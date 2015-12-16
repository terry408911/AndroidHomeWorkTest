package test.niemingyang;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.terry.niemingyangtest20134070211.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by terry on 12/16/15.
 */
public class ShowOne extends Activity {

    Intent intent;
    private MyDatabase cd = new MyDatabase(this,"books.db",null,1);
    private List<Book> bookList = new ArrayList<Book>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);

        intent = getIntent();
        initBook();
        BookAdapter bookAdapter = new BookAdapter(ShowOne.this,R.layout.book_item,bookList);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(bookAdapter);
    }

    private void initBook(){
        SQLiteDatabase db = cd.getWritableDatabase();
        Cursor cursor = db.query("books", null, "isbn="+intent.getStringExtra("isbn"), null, null, null, null);
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
