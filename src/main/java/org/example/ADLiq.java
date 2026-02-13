package org.example;

import liquibase.Liquibase;

import liquibase.database.DatabaseConnection;

import liquibase.exception.LiquibaseException;

import liquibase.resource.ResourceAccessor;

public class ADLiq extends Liquibase {

    public ADLiq(String changeLogFile, ResourceAccessor resourceAccessor, DatabaseConnection conn) throws LiquibaseException {

        super(changeLogFile, resourceAccessor, conn);

    }

}
