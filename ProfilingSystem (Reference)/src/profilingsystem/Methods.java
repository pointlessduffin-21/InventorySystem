package profilingsystem;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;

public class Methods {
    
    static Connection conn  = null;
    static PreparedStatement pst = null;
    static ResultSet rs = null;
    static java.sql.Statement stmt = null;
//    static File temp = new File("database.sqlite");
//    static String url = "jdbc:sqlite:" + temp.getAbsolutePath().replace("\\","\\\\");
    static String url = "jdbc:sqlite:C:\\Users\\franc\\Documents\\NetBeansProjects\\ProfilingSystem\\database.sqlite";
    static String error = "";
    
    public static boolean openDB(){
        boolean result = false;
        try{
            Class.forName("org.sqlite.JDBC");
            conn = java.sql.DriverManager.getConnection(url);

            System.out.println("SQLite ession connected.");
            result = true;
        }
        catch(Exception e){
            error = e.getMessage();
            System.out.println("Opening SQLite Error:" + e.getMessage());
        } 
        return result;
    }
    
    public static boolean closeDB(){
        boolean result = false;
        try{
            conn.close();

            System.out.println("SQLite session closed.");
            result = true;
        }
        catch(Exception e){
            error = e.getMessage();
            System.out.println("Closing SQLite Error: " + e.getMessage());
        }
        return result;
    }
    
     public static Connection opensDB(){
        try{
            Class.forName("org.sqlite.JDBC");
            conn = java.sql.DriverManager.getConnection(url);
            System.out.println("OK! SQLite DB session connected.");
            return conn;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        } 
    }

    //Close DB Session Method
    public static Connection closesDB(){
        try{
            conn.close();
            System.out.println("OK! SQLite DB session closed.");
            return conn;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
    
    public static String[][] read(String table, String[] columns){
        String[][] records = null;
        try{
            Methods.stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM " + table);
            int totalRows = rs.getInt(1);

            int totalColumns = columns.length;
            String cols = "";
            for(int i=0;i<totalColumns;i++){
                cols += columns[i];
                if((i+1)!=totalColumns)cols+=", ";
            }
            rs = stmt.executeQuery("SELECT "+ cols +" FROM " + table);
            records = new String[totalRows][totalColumns];
            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<totalColumns;col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                }
                row++;
            }            
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return records;
    }
    
    public static String[][] read(String table, String where){
        String[][] records = null;
        try{
            Methods.stmt = conn.createStatement();

            //Count total rows
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM " + table + " WHERE " + where);
            int totalRows = rs.getInt(1);

            //Count total columns
            rs = stmt.executeQuery("SELECT * FROM " + table + " WHERE " + where);
            ResultSetMetaData rsmd = rs.getMetaData();
            int totalColumns = rsmd.getColumnCount();

            //Initialize 2D Array "records" with totalRows by totalColumns
            records = new String[totalRows][totalColumns];

            //Retrieve the record and store it to 2D Array "records"
            int row=0;
            while(rs.next()){                
                for(int col=0,index=1;col<totalColumns;col++,index++){
                    records[row][col] = rs.getObject(index).toString();
                }
                row++;
            }            
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return records;
    }
    
    public static byte[] read(String table, String column, int id){
        byte[] buffer = null;
        try{
            String query = "SELECT " + column +" FROM " + table + " WHERE StudentID=?"; 
            ResultSet rs = null;
            java.sql.PreparedStatement pstmt = null;            
             
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                buffer = rs.getBytes("IDPic");
            }
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return buffer;
    }
    
    public static boolean create(String table, String values){
        boolean result = false;
        try{
            Methods.stmt = conn.createStatement();
            String query = "INSERT INTO "+ table +" VALUES(" + values + ")";
            stmt.executeUpdate(query);
            
            result = true;
        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }
    
    public static boolean update(String table, byte[] image, String column, int id){
    //byte[] buffer = null;
        boolean result = false;
        try{
            String query = "UPDATE " + table +" SET "+ column +"=? WHERE StudentID=" + id; 
            ResultSet rs = null;
            java.sql.PreparedStatement pstmt = null;            
            
            pstmt = conn.prepareStatement(query);
            pstmt.setBytes(1, image);
            
            pstmt.executeUpdate();
            System.out.println("Image saved to database successfully!");
            result = true;
        }
        catch(Exception e){
            System.out.println("Read Error: " + e.getMessage());
        }
        return result;
    }
    
    public static boolean updatestudent(String table,String values, String id){
        
        boolean result = false;
        try{
            String query = "UPDATE " + table +" SET "+ values +" WHERE StudentID=" + id; 
            ResultSet rs = null;
            java.sql.PreparedStatement pstmt = null;            
            
            pstmt = conn.prepareStatement(query);
            
            pstmt.executeUpdate();
            System.out.println("Data has been updated successfully!");
            result = true;
        }
        catch(Exception e){
            System.out.println("Update Error: " + e.getMessage());
        }
        return result;
    }
    
    public static boolean deletestudent(String table, int id){
        boolean result = false;
        try{
            String queryCheck = "SELECT StudentID from "+ table +" WHERE StudentID = "+id+"";
            PreparedStatement con = conn.prepareStatement(queryCheck);
            ResultSet resultSet = con.executeQuery();
            if(!resultSet.next()){
                System.out.println("Data does not exist in the database!");
            }
            else{
                do{
                    Methods.stmt = conn.createStatement();
                    String query = "DELETE FROM "+ table + " WHERE StudentID=" + id;
                    stmt.executeUpdate(query);
                    result = true;
                    
                }while(resultSet.next());
            }

        }
        catch(Exception e){
            System.out.println("Create Error: " + e.getMessage());
        }
        return result;
    }
}
