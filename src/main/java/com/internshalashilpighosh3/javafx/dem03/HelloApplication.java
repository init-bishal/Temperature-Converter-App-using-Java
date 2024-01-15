package com.internshalashilpighosh3.javafx.dem03;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        VBox rootNode=loader.load() ;
        MenuBar menuBar=creatMenu() ;
        rootNode.getChildren().add(0,menuBar) ;
        Scene scene = new Scene(rootNode);
        stage.setTitle("Temperature Converter Tool");
        stage.setScene(scene);
        stage.show();
    }
    private MenuBar creatMenu()
    {
        //File Menu
        Menu fileMenu=new Menu("File") ;
        MenuItem newMenuItem=new MenuItem("New") ;
        SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem() ;

        newMenuItem.setOnAction(event->{
            System.out.println("New Menu Item clicked");
            // More code....
        });
        // event handling

        MenuItem quitMenuItem=new MenuItem("Quit") ;
        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);
        //Help Menu
        quitMenuItem.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });
        Menu helpMenu=new Menu("Help") ;
        MenuItem aboutApp=new MenuItem("About") ;
        helpMenu.getItems().addAll(aboutApp);
        aboutApp.setOnAction(actionEvent -> aboutApp());
        MenuBar menuBar=new MenuBar() ;
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar ;

    }
    private void aboutApp()
    {
        Alert alertDialog=new Alert(Alert.AlertType.WARNING) ;
        alertDialog.setTitle("My First Desktop App");
        alertDialog.setHeaderText("Learning JavaFX");
        alertDialog.setContentText("I am just a beginnger but soon I will pro in it");

        ButtonType yesBtn=new ButtonType("Yes") ;
        ButtonType noBtn=new ButtonType("No");
        alertDialog.getButtonTypes().setAll(yesBtn,noBtn);

        Optional<ButtonType> clickedBtn=alertDialog.showAndWait() ;
        if( clickedBtn.isPresent() && clickedBtn.get()==yesBtn)
        {
            System.out.println("Yes Button Clicked!!!");
        }
        else
        {
            System.out.println("No Button Clicked");
        }

    }



    public static void main(String[] args) {
        launch();
    }
}