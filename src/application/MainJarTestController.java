package application;

import java.net.URL;
import java.util.ResourceBundle;

import buttonOnBus.ButtonOnBus;
import connectButton.ConnectButtonController;
import eventBus.EventBus;
import eventBus.FXEventBus;
import eventBus.events.ConnectionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import textFieldSmart.TextFieldSmart;
import textFieldSmart.validators.Ip4Validator;

public class MainJarTestController implements Initializable {
	public  final EventBus eventBus = new FXEventBus();
	@FXML
	public ConnectButtonController connBtnCtrl01;
	@FXML
	public ConnectButtonController connBtnCtrl02;
	@FXML
	public TextFieldSmart tfs;
	@FXML
	public ButtonOnBus btnOnBus;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("MainController initialize");
		connBtnCtrl01.setConnAction(() -> {
			System.out.println("01Action Connect");
			eventBus.post(new ConnectionEvent(true, "host01"));
		});
		connBtnCtrl01.setDisconnAction(() -> {
			System.out.println("01Action Disconnect");
			eventBus.post(new ConnectionEvent(false, "host01"));
		});
		connBtnCtrl02.setConnAction(() -> {
			System.out.println("02Action Connect");
			eventBus.post(new ConnectionEvent(true, "host02"));
		});
		connBtnCtrl02.setDisconnAction(() -> {
			System.out.println("02Action Disconnect");
			eventBus.post(new ConnectionEvent(false, "host02"));
		});
        connBtnCtrl01.setEventBus(eventBus);
        connBtnCtrl02.setEventBus(eventBus);
        
        connBtnCtrl01.setStatesName("Connect TCAS", "Disconnect TCAS");
        connBtnCtrl02.setStatesName("Connect TCAS", "Disconnect TCAS");
        
        tfs.setValidator(new Ip4Validator());
        tfs.setText("1.2.3.456");
        tfs.setEventBus(eventBus);
        tfs.setConnEventEnabled(true);
        tfs.setConnEventInverted(true);
        
        btnOnBus.setEventBus(eventBus);
        btnOnBus.setConnEventInverted(false);
        btnOnBus.setText("12345");
        btnOnBus.setButtonAction(()->{
        	System.out.println("btnOnBus fired..");
        });
	}

	public void ping() {
		System.out.println("I am the MainController");
	}

}
