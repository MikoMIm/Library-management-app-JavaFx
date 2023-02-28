package com.mordvinovdsw.library.controllers;

import com.mordvinovdsw.library.Database.Book;
import com.mordvinovdsw.library.Database.Member;

import java.net.URL;
import java.sql.*;
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

public class Member_List_Controller implements Initializable {

    @FXML
    private TableView<Member> memberTable;

    @FXML
    private TableColumn<Member, Integer> idColumn;

    @FXML
    private TableColumn<Member, String> nameColumn;

    @FXML
    private TableColumn<Member, String> phoneColumn;

    @FXML
    private TableColumn<Member, String> emailColumn;

    @FXML
    private TableColumn<Member, String> registerDateColumn;

    @FXML
    private TableColumn<Member, String> expairDateColumn;

    @FXML
    private TableColumn<Member, String> statusColumn;


    @FXML
    private TextField ID_memebrfiled;
    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField emailField;

    @FXML
    private DatePicker registerDateField;

    @FXML
    private DatePicker expairDateField;

    @FXML
    private ComboBox<String> statusField;

    private ObservableList<Member> members = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        statusField.getItems().add("Active");
        statusField.getItems().add("Inactive");



        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        registerDateColumn.setCellValueFactory(new PropertyValueFactory<>("registerDate"));
        expairDateColumn.setCellValueFactory(new PropertyValueFactory<>("expairDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));


        loadData();
    }

    private void loadData() {
        members.clear();

        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Members")){
        while (resultSet.next()) {
                int Id = resultSet.getInt("Member_ID");
                String Name = resultSet.getString("Member_Name");
                String Phone = resultSet.getString("Phone_Number");
                String Email = resultSet.getString("Email_Adress");
                String RegisterDate = resultSet.getString("Register_Date");
                String ExpairDate = resultSet.getString("Date_Expair");
                String Status = resultSet.getString("Member_Status");
                members.add(new Member(Id, Name, Phone, Email, RegisterDate, ExpairDate, Status));
                clearFields();
            }
            memberTable.setItems(members);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        memberTable.setItems(members);
    }

    @FXML
    private void MCK() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        memberTable.setOnMouseClicked(event -> {
            Member selectedMember = memberTable.getSelectionModel().getSelectedItem();
            if (selectedMember != null) {
                ID_memebrfiled.setText(String.valueOf(selectedMember.getId()));
                nameField.setText(selectedMember.getName());
                phoneField.setText(selectedMember.getPhone());
                emailField.setText(selectedMember.getEmail());
                registerDateField.setValue(LocalDate.parse(selectedMember.getRegisterDate(), formatter));
                expairDateField.setValue(LocalDate.parse(selectedMember.getExpairDate(), formatter));
                statusField.setValue(selectedMember.getStatus());
            }
        });
    }

    @FXML
    private void addMember() {
        int y = (int) (Math.random() * 1000000000);
        Member newMember = new Member(
                Integer.parseInt(ID_memebrfiled.getText()),
                nameField.getText(),
                phoneField.getText(),
                emailField.getText(),
                registerDateField.getEditor().getText(),
                expairDateField.getEditor().getText(),
                statusField.getSelectionModel().getSelectedItem().toString()
        );
        Connection connection = DBConnection.getConnection();
        clearFields();
        try {
            String query = "INSERT INTO Members(Member_ID, Member_Name, Phone_Number, Email_Adress, Register_Date, Date_Expair, Member_Status) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, y);
            statement.setString(2, newMember.getName());
            statement.setString(3, newMember.getPhone());
            statement.setString(4, newMember.getEmail());
            statement.setString(5, newMember.getRegisterDate());
            statement.setString(6, newMember.getExpairDate());
            statement.setString(7, newMember.getStatus());
            statement.execute();
            members.add(newMember);
            memberTable.refresh();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private void clearFields() {
        ID_memebrfiled.clear();
        nameField.clear();
        phoneField.clear();
        emailField.clear();
        registerDateField.setValue(null);
        expairDateField.setValue(null);
        statusField.setValue(null);
    }

    @FXML
    private void clearFieldsb() {
        ID_memebrfiled.clear();
        nameField.clear();
        phoneField.clear();
        emailField.clear();
        registerDateField.setValue(null);
        expairDateField.setValue(null);
        statusField.setValue(null);
    }


    @FXML
    private void exit() throws IOException {
        Main.changeScene();

    }

    @FXML
    private void delete() {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM Members WHERE Member_ID = ?")) {

            Member selectedMember = memberTable.getSelectionModel().getSelectedItem();
            statement.setInt(1, selectedMember.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        loadData();
    }

    @FXML
    private void updateData() {
        int MemeberId = Integer.parseInt(ID_memebrfiled.getText());
        String name = nameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String Rdate = registerDateField.getEditor().getText();
        String Dateexpair = expairDateField.getEditor().getText();
        String Status = statusField.getSelectionModel().getSelectedItem().toString();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE Members SET Member_Name = ?, Phone_Number= ?, Email_adress = ?, Register_date = ?, Date_Expair = ?, Member_Status = ? WHERE Member_ID = ?")) {

            statement.setString(1, name);
            statement.setString(2, phone);
            statement.setString(3, email);
            statement.setString(4, Rdate );
            statement.setString(5, Dateexpair);
            statement.setString(6, Status );
            statement.setInt(7, MemeberId);

            int result = statement.executeUpdate();
            if (result == 1) {
                loadData();
                clearFields();
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
