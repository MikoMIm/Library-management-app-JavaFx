package com.mordvinovdsw.library.Database;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Book {
    private SimpleIntegerProperty bookID;
    private SimpleStringProperty bookTitle;
    private SimpleDoubleProperty price;
    private SimpleIntegerProperty bookNumber;

    public Book(int bookID, String bookTitle, double price, int bookNumber) {
        this.bookID = new SimpleIntegerProperty(bookID);
        this.bookTitle = new SimpleStringProperty(bookTitle);
        this.price = new SimpleDoubleProperty(price);
        this.bookNumber = new SimpleIntegerProperty(bookNumber);
    }

    public int getBookID() {
        return bookID.get();
    }

    public void setBookID(int bookID) {
        this.bookID.set(bookID);
    }

    public String getBookTitle() {
        return bookTitle.get();
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle.set(bookTitle);
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public int getBookNumber() {
        return bookNumber.get();
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber.set(bookNumber);
    }
}



