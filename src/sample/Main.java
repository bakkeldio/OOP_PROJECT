package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;


    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage;

        this.primaryStage.setTitle("JavaFX App");

        initRootLayout();

        showEmployeeOperationsView();
    }

    public void initRootLayout(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            primaryStage.show();

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showEmployeeOperationsView(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/EmployeeOperations.fxml"));
            AnchorPane employeeOperationsView = (AnchorPane) loader.load();
            rootLayout.setCenter(employeeOperationsView);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
