package com.jtwaller.sqlite_demo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.jtwaller.sqlite_demo.SQLContract.SQLEntry;

public class RetrieveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        SQLiteHelper mDdhelper = new SQLiteHelper(this);
        SQLiteDatabase db = mDdhelper.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + SQLEntry.TABLE_NAME, null);
        StringBuilder data = new StringBuilder();

        if (c!=null) {
            int colCount;

            c.moveToFirst();
            while (!c.isAfterLast()) {
                colCount = c.getColumnCount();

                for (int i = 0; i < colCount; i++) {
                    data.append(c.getString(i) + " ");
                }
                data.append(System.lineSeparator());
                c.moveToNext();
            }
        }

        Log.d("RetrieveActivity", data.toString());

        c.close();

        TextView v = (TextView) findViewById(R.id.retrieveTextBox);
        v.setText(data);
    }
}