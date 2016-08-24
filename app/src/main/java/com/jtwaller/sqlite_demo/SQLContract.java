package com.jtwaller.sqlite_demo;

import android.provider.BaseColumns;

public class SQLContract {
    public SQLContract() {
        // empty to prevent rogue instantiating
    }

    public static abstract class SQLEntry implements BaseColumns {
        public static final String TABLE_NAME = "SQLTable";
        public static final String COLUMN_NAME_DATE_CREATED = "date";
//        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_ENTRY_TEXT = "text";
    }
}
