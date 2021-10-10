package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Assignment5Controller {
	
	Pizza.Size size;
	boolean vegetarian = false;
	Pizza.Cheese cheese;
	//initialize toppings to none, so that if user doesn't check the boxes it will be None. 
	Pizza.Topping pineapple = Pizza.Topping.None;
	Pizza.Topping greenPepper = Pizza.Topping.None;
	Pizza.Topping ham = Pizza.Topping.None;
	private static ArrayList<LineItem> orders = new ArrayList<>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox chkHam;

    @FXML
    private CheckBox chkPineapple;

    @FXML
    private CheckBox chkPepper;
    
    @FXML
    private CheckBox chkVegitarian;

    @FXML
    private Label lblSize;

    @FXML
    private Label lblCheese;

    @FXML
    private Button btnSmall;

    @FXML
    private Button btnMedium;

    @FXML
    private Button btnLarge;

    @FXML
    private Button btnSingle;

    @FXML
    private Button btnDouble;

    @FXML
    private Button btnTriple;

    @FXML
    private Label lblHam;

    @FXML
    private Label lblPeppers;

    @FXML
    private Label lblPineapple;
    
    @FXML
    private Label lblCost;
    
    @FXML
    private Button btnGetCost;

    @FXML
    private TextField txtText1;

    @FXML
    private Button btnSave;

    @FXML
    private TextArea txtOutput;

    @FXML
    void initialize() {
        assert chkVegitarian != null : "fx:id=\"chkVegitarian\" was not injected: check your FXML file 'Assignemnt5FXML.fxml'.";
        assert chkHam != null : "fx:id=\"chkHam\" was not injected: check your FXML file 'Assignemnt5FXML.fxml'.";
        assert chkPineapple != null : "fx:id=\"chkPineapple\" was not injected: check your FXML file 'Assignemnt5FXML.fxml'.";
        assert chkPepper != null : "fx:id=\"chkPepper\" was not injected: check your FXML file 'Assignemnt5FXML.fxml'.";
        assert lblSize != null : "fx:id=\"lblSize\" was not injected: check your FXML file 'Assignemnt5FXML.fxml'.";
        assert lblCheese != null : "fx:id=\"lblCheese\" was not injected: check your FXML file 'Assignemnt5FXML.fxml'.";
        assert btnSmall != null : "fx:id=\"btnSmall\" was not injected: check your FXML file 'Assignemnt5FXML.fxml'.";
        assert btnMedium != null : "fx:id=\"btnMedium\" was not injected: check your FXML file 'Assignemnt5FXML.fxml'.";
        assert btnLarge != null : "fx:id=\"btnLarge\" was not injected: check your FXML file 'Assignemnt5FXML.fxml'.";
        assert btnSingle != null : "fx:id=\"btnSingle\" was not injected: check your FXML file 'Assignemnt5FXML.fxml'.";
        assert btnDouble != null : "fx:id=\"btnDouble\" was not injected: check your FXML file 'Assignemnt5FXML.fxml'.";
        assert btnTriple != null : "fx:id=\"btnTriple\" was not injected: check your FXML file 'Assignemnt5FXML.fxml'.";
        assert lblHam != null : "fx:id=\"lblHam\" was not injected: check your FXML file 'Assignemnt5FXML.fxml'.";
        assert lblPeppers != null : "fx:id=\"lblPeppers\" was not injected: check your FXML file 'Assignemnt5FXML.fxml'.";
        assert lblPineapple != null : "fx:id=\"lblPineapple\" was not injected: check your FXML file 'Assignemnt5FXML.fxml'.";
        assert lblCost != null : "fx:id=\"lblCost\" was not injected: check your FXML file 'Assignemnt5FXML.fxml'.";
        assert btnGetCost != null : "fx:id=\"btnGetCost\" was not injected: check your FXML file 'Assignemnt5FXML.fxml'.";
        assert txtText1 != null : "fx:id=\"txtText1\" was not injected: check your FXML file 'Assignemnt5FXML.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'Assignemnt5FXML.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Assignemnt5FXML.fxml'.";

        //This lambda function changes the size label to small if the small button is pressed.
        //Then makes the size attribute small.
        btnSmall.setOnAction(event -> 
        	{ 
        		lblSize.setText("Small"); 
        		size = Pizza.Size.Small;
        	});//end lambda function
        
        //This lambda function changes the size label to medium if the medium button is pressed.
        //Then makes the size attribute medium.
        btnMedium.setOnAction(event -> 
        	{ 
        		lblSize.setText("Medium"); 
        		size = Pizza.Size.Medium;
        	});//end lambda function
        
        //This lambda function changes the size label to large if the large button is pressed.
        //Then makes the size attribute Large.
        btnLarge.setOnAction(event -> 
        	{ 
        		lblSize.setText("Large"); 
        		size = Pizza.Size.Large;
        	});//end lambda function
        
        //This lambda function changes the cheese label to Single if the Single button is pressed.
        //Then makes the cheese attribute single.
        btnSingle.setOnAction(event -> 
        	{ 
        		lblCheese.setText("Single"); 
        		cheese = Pizza.Cheese.Single;
        	});//end lambda function
        
        //This lambda function changes the cheese label to double if the double button is pressed.
        //Then makes the cheese attribute double.
        btnDouble.setOnAction(event -> 
        	{ 
        		lblCheese.setText("Double"); 
        		cheese = Pizza.Cheese.Double;
        	});//end lambda function
        
        //This lambda function changes the cheese label to triple if the triple button is pressed.
        //Then makes the cheese attribute triple.
        btnTriple.setOnAction(event -> 
        	{ 
        		lblCheese.setText("Triple"); 
        		cheese = Pizza.Cheese.Triple;
        	});//end lambda function
        
        
        chkHam.setOnAction(event ->
        { 	if (chkHam.isSelected()) {
        		//This is to stop people from picking both Vegetarian and Ham options.
        		if (chkVegitarian.isSelected()) {
        			lblHam.setText("None");
        			ham = Pizza.Topping.None;
        		}//end if statement
        		else {
        			lblHam.setText("Single");
        			ham = Pizza.Topping.Single;
        		}//end else statement
        }//end if(chkHam.isSelected())
        	else {
        		lblHam.setText("None");
        		ham = Pizza.Topping.None;
        	}//end else statement
        });//end lambda function
        
        //This lambda function changes the greenPepper attribute to single if the GreenPepper 
        //box is ticked.
        chkPepper.setOnAction(event ->
        { 	if (chkPepper.isSelected()) {
        		lblPeppers.setText("Single");
        		greenPepper = Pizza.Topping.Single;
        }//end if statement
        	else {
        		lblPeppers.setText("None");
        		greenPepper = Pizza.Topping.None;
        	}//end else statement
        });//end lambda function
        
        //This lambda function changes the Pineapple attribute to single if the Pineapple
        //box is ticked. Also shows up as single in a label below the check boxes.
        chkPineapple.setOnAction(event ->
        { 	if (chkPineapple.isSelected()) {
        		lblPineapple.setText("Single");
        		pineapple = Pizza.Topping.Single;
        }//end if statement
        	else {
        		lblPineapple.setText("None");
        		pineapple = Pizza.Topping.None;
        	}//end else statement
        });//end lambda function
       
        chkVegitarian.setOnAction(event ->
        {
        	if (chkVegitarian.isSelected()) {
        		lblHam.setText("None");
        		vegetarian = true;
        		ham = Pizza.Topping.None;
        	}//end if statement
        	else 
        		vegetarian = false;
        });//end lambda function
        
        //This labmda function gets the cost of the pizza created by the user when the button "Get
        //Cost" is selected.
        btnGetCost.setOnAction(event ->
        {
        	//initialize pizza to null.
        	Pizza pizza = null;
        	//checks if user picked an amount of cheese. Throws an exception if they did not.
        	if (lblCheese.getText().equals("Cheese"))
        		lblCost.setText("Illegal Cheese");
        	//checks if user picked a size. Throws an exception if they did not.
        	else if (lblSize.getText().equals("Size"))
        		lblCost.setText("Illegal Size");
        	else {
        		try {
        			pizza = new Pizza(size, vegetarian, cheese, pineapple, greenPepper, ham);
        		} catch (IllegalPizza ip) {
        			System.out.println(ip.getMessage());
        		}//end catch block
        		double cost = pizza.getCost();
        		//return the cost in a String format.
        		lblCost.setText("$" + String.valueOf(cost));
        	}//end else
        });//end lambda function
        
        //This text box is for user to input the number of pizzas they want. Only integers can be input here.
        //Furthermore, if the user enters a value outside 1 to 100 inclusively, a pop up window
        //comes up reminding them they need to have a number between 1 and 100. 
        //The line item will not show up in the other text box unless this request is met.
        txtText1.textProperty().addListener((observableValue, oldText, newText) ->
        {
        	if (newText != null && !newText.isEmpty()) {
        		try {
        			@SuppressWarnings("unused")
        			int aVal = Integer.parseInt(newText);
        		} catch (NumberFormatException e) {
        			((StringProperty)observableValue).setValue(oldText);
        		}
        	}
        });
        
        //This lambda function is for when the save button is pressed. The button saves the 
        //pizza line item to the screen in the bottom right of the window.
        btnSave.setOnAction(event ->
        {
        	//Just an extra precaution in case the pop up window did not work.
        	if (Integer.parseInt(txtText1.getText()) < 1 || Integer.parseInt(txtText1.getText()) > 100) {
        		Alert info = new Alert (AlertType.CONFIRMATION);
        		info.setTitle("Incorrect Number of pizzas supplied!");
        		info.setHeaderText("The number of pizzas must be within 1 and 100 inclusively");
        		Optional<ButtonType> result = info.showAndWait();
        	}
        	else {
        		//have to initialize and create a new pizza object again.
        		Pizza pizza = null;
        		try {
        			pizza = new Pizza(size, vegetarian, cheese, pineapple, greenPepper, ham);
        		} catch (IllegalPizza ip) {
        			System.out.println(ip.getMessage());
        		}//end catch
        		//get the number of pizzas supplied by the user.
        		int num = Integer.parseInt(txtText1.getText());
        		try {
        			//add the order to the ArrayList<>
        			orders.add(new LineItem(num, pizza));
        		} catch (IllegalPizza ip) {
        			System.out.println(ip.getMessage());
        		}//end catch
        		//initialize the total cost to 0.
        		float totalCost = 0;
        		int line = 1;
        		txtOutput.setText("\nLine\t\tOrder:");
        		//if size is null, then there are no order supplied yet.
        		if (orders.size() == 0)
        			txtOutput.appendText("No items yet!\n");
        		else {
        			orders.sort(null);
        			//go throw each order in teh Array List and print it to the screen on the bottom
        			//left of the window.
        			for (LineItem order : orders) {
        				txtOutput.appendText("\n");
        				totalCost += order.getCost();
        				txtOutput.appendText(line++ + "\t\t" + order);
        			}
        			//Print the total cost of all teh line item orders.
        			txtOutput.appendText("\nTOTAL: \t$" + String.valueOf(totalCost));
        		}//end else statement
        	}//end else statement
        });//end lambda function
    }//end initialize()
}//end Assignement5Controller()
