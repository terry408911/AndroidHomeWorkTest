package test.niemingyang;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.terry.niemingyangtest20134070211.R;

import java.util.List;

/**
 * Created by terry on 12/16/15.
 */
public class BookAdapter extends ArrayAdapter<Book> {
    private int resourceId;

    public BookAdapter (Context context,int textViewResourceId,List<Book> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent){
        Book book = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        TextView isbn = (TextView) view.findViewById(R.id.textViewISBN);
        TextView name = (TextView) view.findViewById(R.id.textViewName);
        TextView author = (TextView) view.findViewById(R.id.textViewAuthor);
        TextView publisher = (TextView) view.findViewById(R.id.textViewPublisher);
        TextView desp = (TextView) view.findViewById(R.id.textViewDesp);
        isbn.setText(book.getIsbn());
        name.setText(book.getName());
        author.setText(book.getAuthor());
        publisher.setText(book.getPublisher());
        desp.setText(book.getDesp());
        return view;

    }
}
