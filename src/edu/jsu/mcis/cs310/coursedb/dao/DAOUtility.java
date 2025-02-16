package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
    
    public static final int TERMID_FA24 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {

                ResultSetMetaData rsmd = rs.getMetaData();
                while (rs.next()) {
                    JsonObject record = new JsonObject();
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        String columnName = rsmd.getColumnName(i);
                        String columnValue = rs.getString(i);
                        record.put(columnName, columnValue);
                    }
                    records.add(record);

                }
            }  
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}
