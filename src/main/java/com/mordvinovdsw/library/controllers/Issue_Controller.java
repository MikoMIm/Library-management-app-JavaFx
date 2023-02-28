package com.mordvinovdsw.library.controllers;

import com.mordvinovdsw.library.Database.Book;
import com.mordvinovdsw.library.Database.IssueBook;
import com.mordvinovdsw.library.Database.Member;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.io.IOException;
import com.mordvinovdsw.library.Database.DBConnection;

import com.mordvinovdsw.library.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Issue_Controller implements Initializable {

    @FXML
    private TableView<IssueBook> IssueView;

    @FXML
    private TableColumn<IssueBook, Integer> IDIssueBook;

    @FXML
    private TableColumn<IssueBook, Integer> ID_book;

    @FXML
    private TableColumn<IssueBook, Integer> ID_Member;

    @FXML
    private TableColumn<IssueBook, String> DateE;

    @FXML
    private TableColumn<IssueBook, String> DateR;

    @FXML
    private TableColumn<IssueBook, String> status;

    @FXML
    private TextField idField;
    @FXML
    private ComboBox bookIdCombo;
    @FXML
    private ComboBox memberIdCombo;
    @FXML
    private DatePicker issueDatePicker;
    @FXML
    private DatePicker returnDatePicker;
    @FXML
    private ComboBox statusCombo;


    private ObservableList<IssueBook> issueData = FXCollections.observableArrayList();

    public void initialize(URL url, ResourceBundle resourceBundle) {

        IDIssueBook.setCellValueFactory(new PropertyValueFactory<IssueBook, Integer>("Issue_id"));
        ID_book.setCellValueFactory(new PropertyValueFactory<IssueBook, Integer>("Book_id"));
        ID_Member.setCellValueFactory(new PropertyValueFactory<IssueBook, Integer>("Member_id"));
        DateE.setCellValueFactory(new PropertyValueFactory<IssueBook, String>("Date_Issue"));
        DateR.setCellValueFactory(new PropertyValueFactory<IssueBook, String>("Date_return"));
        status.setCellValueFactory(new PropertyValueFactory<IssueBook, String>("Status"));
        IssueView.setItems(issueData);
        loadData();
    }

    private void loadData() {
        Connection connection = DBConnection.getConnection();
        try {
            String query = "SELECT * FROM Book_Issue";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int Issue_id = result.getInt("Book_Issue_ID");
                int Book_id  = result.getInt("Book_ID");
                int Member_id = result.getInt("Member_ID");
                String Date_Issue = result.getString("Date_Issue");
                String Date_return= result.getString("Date_Return");
                String Status = result.getString("Book_Issue_Status");
                issueData.add(new IssueBook(Issue_id, Book_id, Member_id, Date_Issue, Date_return, Status));
            }
            IssueView.setItems(issueData);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        IssueView.setItems(issueData);
    }

    @FXML
    private void exit() throws IOException {
        Main.changeScene();

    }

}
