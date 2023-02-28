package com.mordvinovdsw.library.Database;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Member{
    private SimpleIntegerProperty Id;
    private SimpleStringProperty Name;
    private SimpleStringProperty Phone;
    private SimpleStringProperty Email;
    private SimpleStringProperty RegisterDate;
    private SimpleStringProperty ExpairDate;
    private SimpleStringProperty Status;

        public Member(int id, String name, String phone, String email, String registerDate, String expairDate, String status) {
            this.Id = new SimpleIntegerProperty(id);
            this.Name = new SimpleStringProperty(name);
            this.Phone = new SimpleStringProperty(phone);
            this.Email = new SimpleStringProperty(email);
            this.RegisterDate = new SimpleStringProperty(registerDate);
            this.ExpairDate = new SimpleStringProperty (expairDate);
            this.Status = new SimpleStringProperty (status);
        }


        public int getId() {
        return Id.get();
    }
        public void setId(int id) {this.Id.set(id);}

        public String getName() {return Name.get();}

        public void setName(String name) {this.Name.set(name);}

        public String getPhone() {return Phone.get();}

    public void setPhone(String phone) {
        this.Phone.set(phone);
    }

    public String getEmail() {
        return Email.get();
    }

    public void setEmail(String email) {
        this.Email.set(email);
    }

    public String getRegisterDate() {
        return RegisterDate.get();
    }

    public void setRegisterDate(String registerDate) {
        this.RegisterDate.set(registerDate);
    }

    public String getExpairDate() {
        return ExpairDate.get();
    }

    public void setExpairDate(String expairDate) {
        this.ExpairDate.set(expairDate);
    }

    public String getStatus() {
        return Status.get();
    }

    public void setStatus(String status) {
        this.Status.set(status);
    }


}
