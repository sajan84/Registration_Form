package com.example.rform;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.regex.Pattern;
//Registration Form:
public class Rform extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        GridPane pane=new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(7);
        pane.setVgap(7);
        //label for first name
        Label fname=new Label("First name");
        TextField fnameText=new TextField();
        fnameText.setPromptText("Enter Your First name");
         pane.add(fname,1,0);
         pane.add(fnameText,2,0);

         //label for Middle name
        Label mname=new Label("Middle name");
        TextField mnameText=new TextField();
        mnameText.setPromptText("Enter Your Middle name");
        pane.add(mname,1,1);
        pane.add(mnameText,2,1);

        //label for last name
        Label lname=new Label("Last name");
        TextField lnameText=new TextField();
        lnameText.setPromptText("Enter Your Last name");
        pane.add(lname,1,2);
        pane.add(lnameText,2,2);//Colum row

        //label for email
        Label email=new Label("Email");
        TextField emailText=new TextField();
        emailText.setPromptText("Enter Your Email");
        pane.add(email,1,3);
        pane.add(emailText,2,3);

        //label for mobile no
        Label mon=new Label("Mobile No");
        TextField monText=new TextField();
        monText.setPromptText("Enter Your Mobile No");
        pane.add(mon,1,4);
        pane.add(monText,2,4);

        //label for Date of Birth
        Label Dob=new Label("Date Of Birth");
        Label Day=new Label("Day");
        Label Month=new Label("Month");
        Label Year=new Label("Year");

        //Create String to put into ComboBox
        String [] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String [] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        String [] years = {"1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005"};

        //put Collection of String array into the ComboBox
        ComboBox cbDay=new ComboBox(FXCollections.observableArrayList(days));
        ComboBox cbMonth=new ComboBox(FXCollections.observableArrayList(months));
        ComboBox cbYears=new ComboBox(FXCollections.observableArrayList(years));
        //set Alignment for ColumnNO and Row no
        pane.add(Dob,1,5);
        pane.add(Day,1,6);
        pane.add(cbDay,2,6);
        pane.add(Month,1,7);
        pane.add(cbMonth,2,7);
        pane.add(Year,1,8);
        pane.add(cbYears,2,8);

        //label for Gender
        Label gender=new Label("Gender");
        RadioButton rbMale=new RadioButton("Male");
        RadioButton rbFemale=new RadioButton("Female");
        //To set Toggling feature in Radio Button We can use ToggleGroup Class
        ToggleGroup toggleGroup=new ToggleGroup();
        rbMale.setToggleGroup(toggleGroup);
        rbFemale.setToggleGroup(toggleGroup);
        pane.add(gender,1,9);
        pane.add(rbMale,2,9);
        pane.add(rbFemale,2,10);

        //Label for Language
        Label language=new Label("Language");
        //CheckBox for Language
        CheckBox English=new CheckBox("English");
        CheckBox Hindi=new CheckBox("Hindi");
        CheckBox Gujarati=new CheckBox("Gujarati");
        pane.add(language,1,11);
        pane.add(English,2,11);
        pane.add(Hindi,2,12);
        pane.add(Gujarati,2,13);

        //Create a Button
        Button Cancel=new Button("Cancel");
        Button Submit=new Button("Submit");
        pane.add(Cancel,1,16);
        pane.add(Submit,2,16);

//       Second Scene for new window after To new Page
        GridPane pane2=new GridPane();
        Scene sc1=new Scene(pane2,500,500);
        Label WelcomePage=new Label();
        WelcomePage.setAlignment(Pos.CENTER);

    //submit validation
        Submit.setOnAction(e->{
            //name validation
            String fml="[A-Za-z\\s]+";
            Pattern p=Pattern.compile(fml);
            //validation For First name
            Boolean a=p.matcher(fnameText.getText()).matches();
            if (!a){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Name Warning");
                alert.setHeaderText(null);
                alert.setContentText("Fisrt name must be Charcter and not be null");
                alert.showAndWait();

            }
            //validation for Middle name
            Boolean b=p.matcher(mname.getText()).matches();
             b=p.matcher(mnameText.getText()).matches();
            if (!b){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Name Warning");
                alert.setHeaderText(null);
                alert.setContentText("Middle name must be Charcter and not be null");
                alert.showAndWait();
            }
            //validation for last name
            Boolean c=p.matcher(lname.getText()).matches();
            if (!c){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Name Warning");
                alert.setHeaderText(null);
                alert.setContentText("Last name must be Charcter and not be null");
                alert.showAndWait();
            }

            //Email validation
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            p=Pattern.compile(emailRegex);
            Boolean eChecker=p.matcher(emailText.getText()).matches();
            if (!eChecker){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Email Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please Enter Valid Email Address");
                alert.showAndWait();
            }

            //Mobile validation
            String numberRegex = "[6-9][0-9]{9}";
            p=Pattern.compile(numberRegex);
            Boolean numChecker=p.matcher(monText.getText()).matches();
            if (!numChecker){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Mobile Warning");
                alert.setHeaderText(null);
                alert.setContentText("Mobile number must be in 10 digit");
                alert.showAndWait();
            }

            //Combobox validation
            //ComboBox validation for Days
            Boolean d=cbDay.getSelectionModel().isEmpty();
            if (d){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Day Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please select Day");
                alert.showAndWait();
            }
            //ComboBox validation for Month
            Boolean m=cbMonth.getSelectionModel().isEmpty();
            if (m){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Month Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please select Month");
                alert.showAndWait();
            }
            //ComboBox validation for year
            Boolean y=cbYears.getSelectionModel().isEmpty();
            if (y){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Year Warning");
                alert.setHeaderText(null);
                alert.setContentText("Please select Year");
                alert.showAndWait();
            }
            //Radio button validation
            Boolean mf=((rbMale.isSelected())|| (rbFemale.isSelected()));
            if (!mf){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Validate Field");
                alert.setHeaderText(null);
                alert.setContentText("Please Select Gender");
                alert.showAndWait();
            }
            //Checkbox validation
            Boolean Ehg=((English.isSelected())|| (Hindi.isSelected()) || (Gujarati.isSelected())) ;
            if (!Ehg){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle(" Validate Field");
                alert.setHeaderText(null);
                alert.setContentText("Please Select Language");
                alert.showAndWait();
            }
            //WelComePage  Shower
            if (a && b && c && eChecker && numChecker && !d && !m && !y && mf && Ehg ) {
                stage.setScene(sc1);
                String name=fnameText.getText()+" "+lnameText.getText();
                WelcomePage.setText("Welcome "+ name);
                pane2.setAlignment(Pos.CENTER);
                pane2.setStyle("-fx-font:40px CENTER");
                pane2.add(WelcomePage,1,1);
            }
        });
        //Event handling on Cancel Button
        //Clear the Form
        Cancel.setOnAction(e->{
            fnameText.clear();
            mnameText.clear();
            lnameText.clear();
            emailText.clear();
            monText.clear();
            cbDay.getSelectionModel().clearSelection();
            cbMonth.getSelectionModel().clearSelection();
            cbYears.getSelectionModel().clearSelection();
            rbMale.setSelected(false);
            rbFemale.setSelected(false);
            English.setSelected(false);
            Hindi.setSelected(false);
            Gujarati.setSelected(false);
        });

        Scene sc=new Scene(pane,1000,1000);
        stage.setTitle("Registartion Form");
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
