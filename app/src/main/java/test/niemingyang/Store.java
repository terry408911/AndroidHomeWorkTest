package test.niemingyang;

import android.content.ContentValues;
import android.content.Intent;
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
public class Store extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store);
        
        final EditText isbnEdit = (EditText)findViewById(R.id.editText);
        final EditText nameEdit = (EditText)findViewById(R.id.editText2);
        final EditText authorEdit = (EditText)findViewById(R.id.editText3);
        final EditText publisherEdit = (EditText)findViewById(R.id.editText4);
        final EditText despEdit = (EditText)findViewById(R.id.editText5);

        Button store = (Button)findViewById(R.id.button3);
        Button restore = (Button) findViewById(R.id.button9);
        final MyDatabase cd = new MyDatabase(this,"books.db",null,1);

        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isbn = isbnEdit.getText().toString().trim();
                String name = nameEdit.getText().toString().trim();
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
                db.insert("books", null, values);
                Toast.makeText(Store.this, "添加成功", Toast.LENGTH_SHORT).show();
            }
        });

        restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isbnEdit.setText("");
                nameEdit.setText("");
                authorEdit.setText("");
                publisherEdit.setText("");
                despEdit.setText("");
            }
        });
    }
}
