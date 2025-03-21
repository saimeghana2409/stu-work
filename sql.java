package com.example.myapplication;
import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class sql {
    Connection con;
    @SuppressLint("NewApi")
    public Connection conclass() {
        String ip="172.1.2.0", port="1433", db="assistant", user="sai", pass="12345";
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection=null;
        String ConnectionURL=null;
        try{
             Class.forName("net.sourceforge.jtds.jdbc.Driver");
             ConnectionURL= "jdbc:jtds:sqlserver://"+ ip + ":"+ port+";"+ "databasename="+ db+";user="+user+";password="+pass+";";
             connection= DriverManager.getConnection(ConnectionURL);
        }
        catch(Exception ex){
            Log.e("Error", ex.getMessage());

        }
        return connection;
    }

}
