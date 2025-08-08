package app.fx;

import java.io.FileInputStream;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}
	
	int credits = 100;
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		//layout
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.TOP_CENTER);
		gridPane.setHgap(30);
		gridPane.setVgap(30);
		
		HBox hBox = new HBox();
		
		HBox hBox1 = new HBox();
		
		Image imgBanana = new Image(new FileInputStream("src/assets/banana.jpg"));
		Image imgCherries = new Image(new FileInputStream("src/assets/cheries.jpg"));
		Image imgSeven = new Image(new FileInputStream("src/assets/7.jpg"));
		
		Image imgGray = new Image(new FileInputStream("src/assets/gray.jpeg"));
		
		ImageView imgHeader = new ImageView(new Image(new FileInputStream("src/assets/cbgLogo.jpg")));
		imgHeader.setFitHeight(250);
		imgHeader.setFitWidth(450);
		
		ImageView imgBtn = new ImageView(new Image(new FileInputStream("src/assets/sltbtn.jpg")));
		imgBtn.setFitHeight(100);
		imgBtn.setFitWidth(100);
		
		ImageView img1 = new ImageView(imgGray);
		ImageView img2 = new ImageView(imgGray);
		ImageView img3 = new ImageView(imgGray);
		
		ImageView[] images = {
				img1, img2, img3
		};
		for (ImageView img:images) {
			img.setFitHeight(150);
			img.setFitWidth(150);
		}
		
		Button btnPlay = new Button("Pull",imgBtn);
		btnPlay.setFont(Font.font("Arial",FontWeight.BOLD,20));
		btnPlay.setTextFill(Color.WHITE);
		
		//int credits = 100;
		Label creditLbl = new Label("Credits :\n"+ credits+"€");
		
		
		creditLbl.setFont(Font.font("Arial",FontWeight.BOLD,20));
		
		gridPane.add(btnPlay, 2, 2);
		btnPlay.setMaxHeight(100);
		btnPlay.setMinWidth(100);
		
		gridPane.add(hBox, 1, 1);
		hBox.getChildren().add(imgHeader);
		
		gridPane.add(creditLbl, 2, 1);
		
		gridPane.add(hBox1, 1, 2);
		
		hBox1.getChildren().addAll(img1, img2, img3);
		hBox1.setSpacing(20);
		
		//gridPane.setColumnSpan
		
		btnPlay.setOnAction(event ->{
			if (credits <= 5) {
				btnPlay.setDisable(true);
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Game Over!");
				alert.setHeaderText(null);
				alert.setContentText("You Lose!, Game is Over!\n Start new game?");
				//alert.showAndWait();
				
				alert.showAndWait().filter(ButtonType.OK::equals).ifPresent(b -> {
					credits = 100;
					btnPlay.setDisable(false);
					creditLbl.setText("Credits :\n"+ credits+"€");
		        });
				
			}
			credits = credits - 5;
			creditLbl.setText("Credits :\n"+ credits+"€");
			
			Random rand = new Random();
			int iOne =rand.nextInt(3) + 1;
			int iTwo =rand.nextInt(3) + 1;
			int iThree =rand.nextInt(3) + 1;
			
			if(iOne == 1) {
				img1.setImage(imgBanana);
			}
			if(iOne == 2) {
				img1.setImage(imgSeven);	
						}
			if(iOne == 3) {
				img1.setImage(imgCherries);
			}
			
			if(iTwo == 1) {
				img2.setImage(imgBanana);
			}
			if(iTwo == 2) {
				img2.setImage(imgSeven);	
						}
			if(iTwo == 3) {
				img2.setImage(imgCherries);
			}
			
			if(iThree == 1) {
				img3.setImage(imgBanana);
			}
			if(iThree == 2) {
				img3.setImage(imgSeven);	
						}
			if(iThree == 3) {
				img3.setImage(imgCherries);
			}
			
			//Check Win.
			if(iOne == iTwo && iOne == iThree) {
				if (iOne == 1) {
					credits = credits + 10;
				}
				if (iOne == 2) {
					credits = credits + 20;
				}
				if (iOne == 3) {
					credits = credits + 50;
				}
				creditLbl.setText("Credits :\n"+ credits+"€");
			}
			
		});
		
		
		Scene scene = new Scene(gridPane, 750, 500);
		stage.setScene(scene);
		
		stage.getIcons().add(new Image(new FileInputStream("src/assets/logo.png")));
		stage.setResizable(false);
		
		stage.setTitle("Slot Game!");
		stage.show();
	}

}
