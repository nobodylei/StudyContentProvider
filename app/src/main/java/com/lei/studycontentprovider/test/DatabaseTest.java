package com.lei.studycontentprovider.test;

import android.test.AndroidTestCase;

import com.lei.studycontentprovider.MySQLiteOpenHelper;

/**
 * Created by yanle on 2018/3/2.
 */

public class DatabaseTest extends AndroidTestCase{
    public void createDatabase() {
        MySQLiteOpenHelper open = new MySQLiteOpenHelper(getContext());
        open.getReadableDatabase();
    }
}
