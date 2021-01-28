package com.example.bookstoresimple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookstoresimple.model.Book;

import java.io.File;
import java.util.List;

public class AddActivity extends AppCompatActivity {

    private Button buttonSave = null;
    private Button buttonTakePic = null;

    private EditText titelText = null;
    private EditText autorText = null;
    private EditText verlagText = null;
    private TextView isbnText = null;

    private String imageFile = null;

    private static String titel = null;
    private static String autor = null;
    private static String verlag = null;
    private static String isbn = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

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

        buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("doButtonSaveClick");
                doButtonSaveClick();
            }
        });


        buttonTakePic = (Button) findViewById(R.id.picbutton);
        buttonTakePic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("doTakePicClick");
                doTakePicClick();
            }
        });

        // COMMENT 23

        autorText = (EditText)findViewById(R.id.bookTitel);
        titelText = (EditText) findViewById(R.id.bookAutor);
        verlagText = (EditText) findViewById(R.id.bookVerlag);
        isbnText = (EditText) findViewById(R.id.bookIsbn);


        Intent intent = getIntent();
        if( intent != null )  {
            intent.getAction();
            imageFile = ImageHandler.getImageFile();
            Log.d("IMAGE FILE ADD", "HAS INTENT");
           if(imageFile != null) {
               Log.d("IMAGE FILE ADD", imageFile);
               File imgFile = new  File(imageFile);

               if(imgFile.exists()){
                   Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                   ImageView myImage = (ImageView) findViewById(R.id.capturedImage);
                   myImage.setImageBitmap(myBitmap);
               }
           }
        }
    }



    private void doTakePicClick() {
        Intent intent = new Intent(this, CameraActivity.class);
        startActivity(intent);
    }

    private void doButtonSaveClick() {
        Book book = new Book(titelText.getText().toString(),autorText.getText().toString(),
                verlagText.getText().toString(),isbnText.getText().toString(),imageFile);
        book.save();
        List<Book> books = Book.listAll(Book.class);
        System.out.println("COUNT: " + books.size());
        buttonListClicked();
    }


    private void buttonHomeClicked() {
        Intent intent = new Intent(this, MainActivity.class);
        String message = "Come from Add!";
        intent.putExtra("message", message);
        startActivity(intent);
    }

    private void buttonAddClicked() {
        Intent intent = new Intent(this, AddActivity.class);
        String message = "Come from Add!";
        intent.putExtra("message", message);
        startActivity(intent);
    }

    private void buttonListClicked() {
        Intent intent = new Intent(this, ListActivity.class);
        String message = "Come from Add!";
        intent.putExtra("message", message);
        startActivity(intent);
    }
}
