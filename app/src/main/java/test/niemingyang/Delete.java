package test.niemingyang;

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
public class Delete extends AppCompatActivity {
    private MyDatabase cd;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete);

        final EditText isbnFrame = (EditText)findViewById(R.id.editText7);
        Button delete = (Button) findViewById(R.id.button10);
        cd = new MyDatabase(this,"books.db",null,1);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isbn = isbnFrame.getText().toString().trim();
                SQLiteDatabase db = cd.getWritableDatabase();
                db.delete("books","isbn = ?",new String[]{isbn});
                Toast.makeText(Delete.this, "删除成功", Toast.LENGTH_LONG).show();
            }
        });

    }
}
