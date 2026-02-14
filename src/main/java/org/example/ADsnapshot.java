package org.example;

import liquibase.database.Database;

import liquibase.exception.DatabaseException;

import liquibase.snapshot.InvalidExampleException;

import liquibase.snapshot.JdbcDatabaseSnapshot;

import liquibase.structure.DatabaseObject;


public class ADsnapshot extends JdbcDatabaseSnapshot {

    public ADsnapshot(DatabaseObject[] examples, Database database) throws DatabaseException, InvalidExampleException {
        super(examples, database);

    }
}

