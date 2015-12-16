package test.niemingyang;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.terry.niemingyangtest20134070211.R;

/**
 * Created by terry on 11/5/15.
 */
public class Change extends AppCompatActivity {

    private MyDatabase cd;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change);

        final EditText isbnEdit = (EditText) findViewById(R.id.editText4);
        final EditText nameEdit = (EditText) findViewById(R.id.editText5);
        final EditText authorEdit = (EditText) findViewById(R.id.editText6);
        final EditText publisherEdit = (EditText) findViewById(R.id.editText8);
        final EditText despEdit = (EditText) findViewById(R.id.editText9);
        Button change = (Button) findViewById(R.id.button8);
        Button read = (Button) findViewById(R.id.button4);

        cd = new MyDatabase(Change.this,"books.db",null,1);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isbn = isbnEdit.getText().toString().trim();
                String name= nameEdit.getText().toString().trim();
                String author = authorEdit.getText().toString().trim();
                String publisher = publisherEdit.getText().toString().trim();
                String desp = despEdit.getText().toString().trim();

                SQLiteDatabase db = cd.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("isbn",isbn);
                values.put("name",name);
                values.put("author",author);
                values.put("publisher",publisher);
                values.put("desp",desp);

                db.update("books", values, "isbn = ?", new String[]{isbn});
                Toast.makeText(Change.this, "更新成功", Toast.LENGTH_SHORT).show();

            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isbn = isbnEdit.getText().toString().trim();
                SQLiteDatabase db = cd.getWritableDatabase();
                Cursor cursor = db.query("books", null, "isbn="+isbn, null, null, null, null);
                if (cursor.moveToFirst()){
                    do {
                        nameEdit.setText(cursor.getString(cursor.getColumnIndex("name")));
                        authorEdit.setText(cursor.getString(cursor.getColumnIndex("author")));
                        publisherEdit.setText(cursor.getString(cursor.getColumnIndex("publisher")));
                        despEdit.setText(cursor.getString(cursor.getColumnIndex("desp")));
                    }while (cursor.moveToNext());
                }
                cursor.close();
            }
        });

    }
}
