package com.example.teladecadastro.helper;

public class DBContract {
    public static final String DB_NAME = "appBank.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "Users";
    public static final String COLUMN_NUM_ACCOUNT = "num_account";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CPF = "cpf";

    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "senha";

    public static final String SQL_CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_NUM_ACCOUNT    +  " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME  +  " TEXT, " +
                    COLUMN_CPF  +  " TEXT, " +
                    COLUMN_EMAIL +  " TEXT," +
                    COLUMN_PASSWORD +  " TEXT) " ;

    public static final String SQL_DELETE_TABLE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

}
