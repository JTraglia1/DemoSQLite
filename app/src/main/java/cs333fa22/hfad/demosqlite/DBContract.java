package cs333fa22.hfad.demosqlite;

//One nested class for one table
//These inner classes help with working with cursor, ie,
//when cursing over what is returned from DB queries

import android.provider.BaseColumns;

public class DBContract {

    //inner class per table

    class EmployeeEntry implements BaseColumns
    {
        public static final String TABLE_NAME = "employee";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DOB = "dob";
        public static final String COLUMN_DESIGNATION = "designation";
        public static final String COLUMN_ID = _ID;

        public static final String CREATE_EMPLOYEE_TABLE_CMD = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT NOT NULL, " + COLUMN_DOB + " INTEGER NOT NULL, " +
                COLUMN_DESIGNATION + " TEXT NOT NULL)";

        public static final String DROP_EMP_TABLE_CMD = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }


}
