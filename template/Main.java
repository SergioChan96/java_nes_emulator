package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
         */
        Cartrige cartrige = new Cartrige("\\Users\\admin\\Downloads\\no$gmb\\SLOT\\Tetris.gb");
        Memory memory = new Memory(cartrige);
        CPU cpu = new CPU(memory);
        while(true){
            cpu.cycle();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
