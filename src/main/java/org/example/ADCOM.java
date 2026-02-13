package org.example;

import org.h2.jdbc.JdbcConnection;

import java.sql.SQLException;

import java.util.Properties;


public class ADCOM extends JdbcConnection{

    public ADCOM(String url, Properties info, String user, Object password, boolean forbidCreation) throws SQLException {
        super(url, info, user, password, forbidCreation);



    }


}
