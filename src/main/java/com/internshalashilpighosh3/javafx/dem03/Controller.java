package com.internshalashilpighosh3.javafx.dem03;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Label welcomeLabel ;
    @FXML
    public ChoiceBox<String> choiceBox ;
    @FXML
    public TextField userInputField ;
    @FXML
    public Button convertButton;
    private static final String C_TO_F="Celsius to Fahrenheit";
    private static final String F_TO_C="Fahrenheit to Celsius" ;
    private boolean isC_TO_F=true ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            choiceBox.getItems().add(C_TO_F);
            choiceBox.getItems().add(F_TO_C);
            choiceBox.setValue(C_TO_F);
            choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) ->{
                    if(t1.equalsIgnoreCase(C_TO_F))
                    {
                        isC_TO_F=true;
                    }
                    else
                    {
                        isC_TO_F=false ;
                    }
            });


            convertButton.setOnAction(actionEvent -> {
                convert() ;
            });
    }

    private void convert() {
        String input=userInputField.getText() ;// to get the input from the user
        float enteredTemp=0.0f;
        try
        {
            enteredTemp= Float.valueOf(input) ;
        }
        catch (Exception e)
        {
            warnUser() ;
            return ;
        }

        float newTemp=0.0f ;
        if(isC_TO_F)
        {
                newTemp=(enteredTemp*9/5)+32 ;
        }
        else
        {
                newTemp=(enteredTemp-32)*5/9 ;
        }
        display(newTemp) ;

    }

    private void warnUser() {
        Alert alert=new Alert(Alert.AlertType.ERROR) ;
        alert.setTitle("Error occured");
        alert.setHeaderText("Invalid Temperature Entered");
        alert.setContentText("Please enter a valid temperature");
        alert.show() ;
    }

    private void display(float newTemp) {
        String unit=isC_TO_F?" F":" C" ;
        System.out.println("The new temperature is: "+ newTemp+unit );
        Alert alert=new Alert(Alert.AlertType.INFORMATION) ;
        alert.setTitle("Result");
        alert.setContentText("The new temperature is: "+ newTemp+unit );
        alert.show() ;
    }
}
