package test.niemingyang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.terry.niemingyangtest20134070211.R;

/**
 * Created by terry on 12/16/15.
 */
public class Query extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.query);

        final EditText isbnEdit = (EditText)findViewById(R.id.editText8);
        Button queryByISBN = (Button)findViewById(R.id.button14);
        Button queryAll = (Button)findViewById(R.id.button15);

        queryByISBN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isbn = isbnEdit.getText().toString().trim();
                Intent intentQ1 = new Intent(Query.this,ShowOne.class);
                intentQ1.putExtra("isbn",isbn);
                startActivity(intentQ1);
            }
        });

        queryAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentQ = new Intent(Query.this,Show.class);
                startActivity(intentQ);
            }
        });
    }
}
