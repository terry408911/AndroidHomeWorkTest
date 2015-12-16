package test.niemingyang;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.terry.niemingyangtest20134070211.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by terry on 11/5/15.
 */
public class Show extends AppCompatActivity {

    private MyDatabase cd = new MyDatabase(this,"books.db",null,1);
    private List<Book> bookList = new ArrayList<Book>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);
        initBook();
        BookAdapter bookAdapter = new BookAdapter(Show.this,R.layout.book_item,bookList);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(bookAdapter);

    }

    private void initBook(){
        SQLiteDatabase db = cd.getWritableDatabase();
        Cursor cursor = db.query("books", null, null, null, null, null, null);
        if (cursor.moveToFirst()){
            do {
                Book book = new Book();
                book.setIsbn(cursor.getString(cursor.getColumnIndex("isbn")));
                book.setName(cursor.getString(cursor.getColumnIndex("name")));
                book.setAuthor(cursor.getString(cursor.getColumnIndex("author")));
                book.setPublisher(cursor.getString(cursor.getColumnIndex("publisher")));
                book.setDesp(cursor.getString(cursor.getColumnIndex("desp")));
                bookList.add(book);
            }while (cursor.moveToNext());
        }
        cursor.close();
    }

}
