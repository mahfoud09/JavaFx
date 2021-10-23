package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
public class HelloWorldJavaFxSpringBootApplication extends Application {
	public static ConfigurableApplicationContext springContext;
	private FXMLLoader fxmlloader;
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
fxmlloader.setLocation(getClass().getResource("hello-world.fxml"));
		
		Parent root = fxmlloader.load();
		stage.setTitle("Hello World");
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	
		
		
	}
	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(HelloWorldJavaFxSpringBootApplication.class);
		fxmlloader = new FXMLLoader();
		fxmlloader.setControllerFactory(springContext::getBean);
	}
	
	@Override
	public void stop() throws Exception {
		springContext.stop();
		
	}

}
