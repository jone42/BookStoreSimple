package com.example.bookstoresimple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bookstoresimple.model.Book;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final Button buttomHome = (Button) findViewById(R.id.buttonHome);
        buttomHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonHomeClicked();
            }
        });
        final Button buttomAdd = (Button) findViewById(R.id.buttonAdd);
        buttomAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonAddClicked();
            }
        });
        final Button buttomHList = (Button) findViewById(R.id.buttonList);
        buttomHList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonListClicked();
            }
        });

        Intent intent = getIntent();
        if( intent != null )  {
            // Not in use
        }
        // ListView aus dem Layout holen
        bookListView = (ListView) findViewById(R.id.bookList);

        showBooksInList();
    }


    private void buttonHomeClicked() {
        Intent intent = new Intent(this, MainActivity.class);
        String message = "Come from List!";
        intent.putExtra("message", message);
        startActivity(intent);
    }

    private void buttonAddClicked() {
        Intent intent = new Intent(this, AddActivity.class);
        String message = "Come from List!";
        intent.putExtra("message", message);
        startActivity(intent);
    }

    private void buttonListClicked() {
        Intent intent = new Intent(this, ListActivity.class);
        String message = "Come from List!";
        intent.putExtra("message", message);
        startActivity(intent);
    }

    private ListView bookListView;

    private void showBooksInList () {
        // Daten aus DB holen
        List<Book> books = Book.listAll(Book.class);
        // Neue Instanz von ArrayAdapter, die bookListViewentryList wird
        // übergeben, ein Element ist auswählbar
        BookAdapter bookAdapter = new BookAdapter(this,  (ArrayList)books);

        // Ein Element ist auswählbar
        bookListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        // Den Adapter an die View binden - kein Array / keine Liste
        bookListView.setAdapter(bookAdapter);
    }
}
