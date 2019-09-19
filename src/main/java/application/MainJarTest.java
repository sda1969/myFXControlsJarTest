package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainJarTest extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
            //---- для отладки того же компонента но уже из внешнего jar
			FXMLLoader mainJarTestLoader = new FXMLLoader();
			mainJarTestLoader.setLocation(getClass().getResource("/application/MainJarTest.fxml"));
			Parent root = mainJarTestLoader.load();
			MainJarTestController mainCtrl = mainJarTestLoader.getController();
			mainCtrl.ping();
            //--------------------------------------------------------
            
            primaryStage.setTitle("My Controls Jar Test");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();	
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}