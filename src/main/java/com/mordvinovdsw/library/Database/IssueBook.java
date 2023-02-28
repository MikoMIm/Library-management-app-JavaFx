package com.mordvinovdsw.library.Database;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class IssueBook {
    private SimpleIntegerProperty Issue_id;
    private SimpleIntegerProperty Book_id;
    private SimpleIntegerProperty Member_id;
    private SimpleStringProperty Date_Issue;
    private SimpleStringProperty Date_return;
    private SimpleStringProperty Status;

    public IssueBook(int issue_id, int book_id, int member_id, String date_issue, String date_retur, String status) {
        this.Issue_id = new SimpleIntegerProperty(issue_id);
        this.Book_id = new SimpleIntegerProperty(book_id);
        this.Member_id = new SimpleIntegerProperty(member_id);
        this.Date_Issue = new SimpleStringProperty(date_issue);
        this.Date_return= new SimpleStringProperty(date_retur);
        this.Status = new SimpleStringProperty (status);
    }

    public int getIssue_id() {
        return Issue_id.get();
    }

    public SimpleIntegerProperty issue_idProperty() {
        return Issue_id;
    }

    public void setIssue_id(int issue_id) {
        this.Issue_id.set(issue_id);
    }

    public int getBook_id() {
        return Book_id.get();
    }

    public SimpleIntegerProperty book_idProperty() {
        return Book_id;
    }

    public void setBook_id(int book_id) {
        this.Book_id.set(book_id);
    }

    public int getMember_id() {
        return Member_id.get();
    }

    public SimpleIntegerProperty member_idProperty() {
        return Member_id;
    }

    public void setMember_id(int member_id) {
        this.Member_id.set(member_id);
    }

    public String getDate_Issue() {
        return Date_Issue.get();
    }

    public SimpleStringProperty date_IssueProperty() {
        return Date_Issue;
    }

    public void setDate_Issue(String date_Issue) {
        this.Date_Issue.set(date_Issue);
    }

    public String getDate_return() {
        return Date_return.get();
    }

    public SimpleStringProperty date_returnProperty() {
        return Date_return;
    }

    public void setDate_return(String date_return) {
        this.Date_return.set(date_return);
    }

    public String getStatus() {
        return Status.get();
    }

    public SimpleStringProperty statusProperty() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status.set(status);
    }
}



