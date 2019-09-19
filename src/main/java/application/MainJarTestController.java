package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

import buttonOnEvent.ButtonOnEvent;
import buttonOnEvent.ToggleButtonOnEvent;
import connectButton.ConnectButtonController;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import textFieldSmart.TextFieldSmart;
import textFieldSmart.validators.Ip4Validator;

public class MainJarTestController implements Initializable {

	public  final Preferences localPrefs = Preferences.userRoot().node("MainJarTestController.class");
	public  BooleanProperty connEvent = new SimpleBooleanProperty(false);
	
	@FXML
	public ConnectButtonController connBtnCtrl01;
	@FXML
	public ConnectButtonController connBtnCtrl02;
	@FXML
	public TextFieldSmart tfs;
	@FXML
	public ButtonOnEvent btnOnEvent;
	@FXML
	public ToggleButtonOnEvent tglbtnOnEvent;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("MainController initialize");
		
		// ----------ConnectButtons-------------
		connBtnCtrl01.setConnAction(() -> {
			System.out.println("01Action Connect");
			connEvent.setValue(true);
		});
		connBtnCtrl01.setDisconnAction(() -> {
			System.out.println("01Action Disconnect");
			connEvent.setValue(false);
		});
		connBtnCtrl02.setConnAction(() -> {
			System.out.println("02Action Connect");
			connEvent.setValue(true);
		});
		connBtnCtrl02.setDisconnAction(() -> {
			System.out.println("02Action Disconnect");
			connEvent.setValue(false);
		});
        
        connBtnCtrl01.setStatesName("Connect TCAS", "Disconnect TCAS");
        connBtnCtrl01.setConnEventInverted(false);
        connBtnCtrl01.setConnEvent(connEvent);
        
        connBtnCtrl02.setStatesName("Connect TCAS", "Disconnect TCAS");
        connBtnCtrl02.setConnEventInverted(false);
        connBtnCtrl02.setConnEvent(connEvent);
        
        // ----------TextFieldSmart-------------
        tfs.setValidator(new Ip4Validator());
        tfs.setPreference("1.2.3.4", localPrefs);
        tfs.setConnEventInverted(true);
        tfs.setConnEvent(connEvent);
        tfs.setOnValidChange(str -> System.out.println(str));
        
        //----------ButtonOnEvent-------------------------------
        btnOnEvent.setConnEventInverted(false);
        btnOnEvent.setText("ButtonOnEvent");
        btnOnEvent.setConnEvent(connEvent);
        btnOnEvent.setButtonAction(()->{
        	System.out.println("btnOnEvent fired..");
        });
        
        //----------ToggleButtonOnEvent-------------------------------
        //ToggleButtonOnEvent tglbtnOnEvent = new ToggleButtonOnEvent();
        tglbtnOnEvent.setButtonPressAction(()->{
        	System.out.println("ToggleButtonOnEvent is pressed");
        });
        tglbtnOnEvent.setButtonReleaseAction(()->{
        	System.out.println("ToggleButtonOnEvent is released");
        });
        tglbtnOnEvent.setText("ToggleButtonOnEvent");
        tglbtnOnEvent.setConnEventInverted(false);
        tglbtnOnEvent.setConnEvent(connEvent);
	}

	public void ping() {
		System.out.println("I am the MainController");
	}


	
}
