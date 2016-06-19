package com.example.vinh.booklinkers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vinh.Testers.LocalTesters;

public class BooksExchangeDetailActivity extends AppCompatActivity {

//    private static final java.lang.String EXTRA_OWNER_USERNAME = "EXTRA_OWNER_USERNAMEE";
    private Button btnMapDirection;
    private Button btnViewInformation;
    private ListView lvHavingBooks;
    private ListView lvNeedingBooks;

    static final String EXTRA_YOUR_LOCATION = "com.example.vinh.Booklinkers.EXTRA_YOUR_LOCATION";
    static final String EXTRA_OWNER_LOCATION = "com.example.vinh.Booklinkers.EXTRA_OWNER_LOCATION";
    private String getResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_exchange_detail);

        btnMapDirection = (Button)findViewById(R.id.button_map_direction);
        btnViewInformation = (Button)findViewById(R.id.button_view_information);
        lvHavingBooks = (ListView)findViewById(R.id.listview_having_books);
        lvNeedingBooks = (ListView)findViewById(R.id.listview_needing_books);

        btnMapDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        BooksExchangeDetailActivity.this,
                        OwnerDirectionMapsActivity.class);

                intent.putExtra(EXTRA_YOUR_LOCATION, "176/90A, Duong Quang Ham, P5, Go Vap");
                intent.putExtra(EXTRA_OWNER_LOCATION, "dai hoc khoa hoc tu nhien");

                startActivity(intent);
            }
        });

        btnViewInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        BooksExchangeDetailActivity.this,
                        OwnerInformationActivity.class);
                startActivity(intent);
            }
        });

        ArrayAdapter<String> havingBooksAdapter =
                new ArrayAdapter<String>(this, R.layout.list_book_item, LocalTesters.havingBooksRecently);

        lvHavingBooks.setAdapter(havingBooksAdapter);

        lvHavingBooks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(BooksExchangeDetailActivity.this, BookInformationActivity.class);
                startActivity(intent);
            }
        });
    }
}
