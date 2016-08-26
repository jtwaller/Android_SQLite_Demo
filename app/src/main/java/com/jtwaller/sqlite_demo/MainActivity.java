package com.jtwaller.sqlite_demo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button create = (Button) findViewById(R.id.createActivityButton);
        Button retrieve = (Button) findViewById(R.id.retrieveActivityButton);
        Button drop = (Button) findViewById(R.id.dropTablesButton);


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateActivity.class));
            }
        });

        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RetrieveActivity.class));
            }
        });

        drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteHelper mSQLHelper = new SQLiteHelper(MainActivity.this);
                SQLiteDatabase db = mSQLHelper.getWritableDatabase();

                db.execSQL("DROP TABLE IF EXISTS " + SQLContract.SQLEntry.TABLE_NAME);
                Log.d(TAG, "Drop onClick: " + db.toString() + " " + SQLContract.SQLEntry.TABLE_NAME);
                mSQLHelper.onCreate(db);
            }
        });
    }
}
