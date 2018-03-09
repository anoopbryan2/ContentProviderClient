package com.ithub.exernalcontentproviderclient;

import android.content.ContentProviderClient;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri yourURI = Uri.parse("content://com.example.MyApplication.StudentsProvider/students");
        ContentProviderClient yourCR = getContentResolver().acquireContentProviderClient(yourURI);
        try{
            Cursor c =yourCR.query(yourURI, null, null, null, "name");
//            int i=yourCR.delete(yourURI, "GRADE" + " = ?", new String[]{String.valueOf(10)});
//            Toast.makeText(this, "id is " + i,
//                    Toast.LENGTH_SHORT).show();
            if(c!=null){
                if (c.moveToFirst()) {
                    do {
                        Toast.makeText(this,
                                //c.getString(c.getColumnIndex(StudentsProvider._ID)) +
                                ", " + c.getString(c.getColumnIndex("name")),
                                Toast.LENGTH_SHORT).show();
                    } while (c.moveToNext());
                }
            }
        }catch(Exception ex){
            Log.e("exception in accesg  " , ex.getMessage().toString());
        }
    }
}
