package com.jtwaller.sqlite_demo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jtwaller.sqlite_demo.SQLContract.SQLEntry;

public class CreateActivity extends AppCompatActivity {

    public static final String TAG = "CreateActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        Button b = (Button) findViewById(R.id.createButton);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                EditText titleText = (EditText) findViewById(R.id.titleBox);
                EditText entryText = (EditText) findViewById(R.id.textBox);

                values.put(SQLEntry.COLUMN_NAME_TITLE, titleText.getText().toString());
                values.put(SQLEntry.COLUMN_NAME_ENTRY_TEXT, entryText.getText().toString());

                putData(values);
            }
        });

    }

    private void putData(ContentValues values) {

        SQLiteHelper mSQLHelper = new SQLiteHelper(getApplicationContext());
        SQLiteDatabase db = mSQLHelper.getWritableDatabase();

        long date = System.currentTimeMillis();

        values.put(SQLEntry.COLUMN_NAME_DATE_CREATED, date);
//        values.put(SQLEntry.COLUMN_NAME_ENTRY_ID, SQLEntry._ID);

//        long newRowId;
//        newRowId = db.insert(SQLEntry.TABLE_NAME, null, values);

        db.insert(SQLEntry.TABLE_NAME, null, values);
        Log.d(TAG, "putData");

        Toast.makeText(this, "Entry created.", Toast.LENGTH_SHORT).show();
    }

}
