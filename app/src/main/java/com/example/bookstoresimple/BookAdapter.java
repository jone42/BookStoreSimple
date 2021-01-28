/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.bookstoresimple;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookstoresimple.model.Book;

import java.io.File;
import java.util.ArrayList;

/*
* {@link AndroidFlavorAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
* based on a data source, which is a list of {@link AndroidFlavor} objects.
* */
public class BookAdapter extends ArrayAdapter<Book> {

    private static final String LOG_TAG = BookAdapter.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param books A List of AndroidFlavor objects to display in a list
     */
    public BookAdapter(Activity context, ArrayList<Book> books) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, books);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_book, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Book currentBook = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView listTextTitel = (TextView) listItemView.findViewById(R.id.listTextTitel);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        listTextTitel.setText("Titel: " + currentBook.getTitle());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView listTextAutor = (TextView) listItemView.findViewById(R.id.listTextAutor);
        // Get the version number from the current AndroidFlavor object and
        // set listTextAutor text on the number TextView
        listTextAutor.setText("Autoe: " + currentBook.getAutor());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView listTextVerlag = (TextView) listItemView.findViewById(R.id.listTextVerlag);
        // Get the version number from the current AndroidFlavor object and
        // set listTextAutor text on the number TextView
        listTextVerlag.setText("Verlag: " + currentBook.getVerlag());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView listTextIsbn = (TextView) listItemView.findViewById(R.id.listTextIsbn);
        // Get the version number from the current AndroidFlavor object and
        // set listTextAutor text on the number TextView
        listTextIsbn.setText("ISBN: " + currentBook.getIsbn());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.capturedImage);

        if(currentBook.getImage() != null) {
            File imgFile = new  File(currentBook.getImage());

            if(imgFile.exists()){
                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
                imageView.setImageBitmap(myBitmap);
            }
        }

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
