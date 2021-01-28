package com.example.bookstoresimple.model;


import com.orm.SugarRecord;

public class Book extends SugarRecord {
    String title;
    String autor;
    String verlag;
    String isbn;
    String image;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getVerlag() {
        return verlag;
    }

    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public Book(){
    }

    public Book(String title, String autor, String verlag, String isbn, String image){
        this.title = title;
        this.autor = autor;
        this.verlag = verlag;
        this.isbn = isbn;
        this.image = image;
    }



    public String toString() {
        return ("Titel: " + title + "\n" +  "Autor: " + autor + "\n" + "Verlag: " + verlag + "\n" + "ISBN: " + isbn + "\n" );
    }
}

