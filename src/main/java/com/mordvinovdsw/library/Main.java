package com.mordvinovdsw.library;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    static Stage stg;

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1150, 650);
        stage.setResizable(false);
        stage.setTitle("Just Lib System");
        stage.setScene(scene);
        stage.show();

    }

    public static void changeScene() throws IOException {
        {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainMenu.fxml"));
            Scene scene_main = new Scene(fxmlLoader.load(), 901, 708);
            stg.setScene(scene_main);
            stg.show();

        }
    }

    public static void Log_out() throws IOException {
        {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
            Scene scene_start = new Scene(fxmlLoader.load(), 1150, 650);
            stg.setScene(scene_start);
            stg.show();

        }
    }

    public static void BookList() throws IOException {
        {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Book_list.fxml"));
            Scene scene_blist = new Scene(fxmlLoader.load(), 1025, 541);
            stg.setScene(scene_blist);
            stg.show();

        }
    }

    public static void MemberList() throws IOException {
        {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Member_list.fxml"));
            Scene scene_blist = new Scene(fxmlLoader.load(), 1566, 613);
            stg.setScene(scene_blist);
            stg.show();

        }
    }

    public static void IssueList() throws IOException {
        {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Issue_list.fxml"));
            Scene scene_blist = new Scene(fxmlLoader.load(), 1096, 676);
            stg.setScene(scene_blist);
            stg.show();

        }
    }




    public static void main(String[] args) {
        launch();
    }
}
