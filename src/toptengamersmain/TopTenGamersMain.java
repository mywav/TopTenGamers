/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toptengamersmain;

import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Ryan.Newbold
 */
public class TopTenGamersMain extends Application 
{
    
    @Override
    public void start(Stage stage) throws Exception
    {
        // Reference to a linked list
        LinkedList0 ll = new LinkedList0();
        
        // Shows the current high scores
        TextArea listView = new TextArea();
        listView.setEditable(false);
        
        // Input for user command
        TextField cmdTextField = new TextField();
        cmdTextField.setPrefColumnCount(10);
        
        // Event handler for cmdTextField
        EventHandler<ActionEvent> handler = 
                new CommandHandler(ll, listView) {};
        cmdTextField.setOnAction(handler);
        
        // HBox to contain label and text field for command input.
        HBox hBox1 = new HBox(10);
        Label cmdLabel = new Label("Command: ");
        hBox1.getChildren().addAll(cmdLabel, cmdTextField);
        
        // HBox to contain label with instructions for the user
        HBox hBox2 = new HBox(10);
        Label instructionsLabel = new Label("To add a high score to the list, type the word 'insert' followed "
                + "\nby a space, followed by the name of the person who earned the high score, "
                + "\nfollowed by another space, followed by that person's score. For example, you could type 'insert " 
                + "\nRyan 110' into the command box and then hit enter. Be sure to only use "
                + "\nthe first name of the player or their nickname. The system will only accept "
                + "\none name per player.");
        hBox2.getChildren().addAll(instructionsLabel);
        
        // VBox to contain all the components
        VBox vBox = new VBox(12);
        vBox.setPadding(new Insets(15));
        vBox.getChildren().addAll(hBox1, listView, hBox2);
        
        // Set up the scene and show the stage.
        stage.setScene(new Scene(vBox));
        stage.setTitle("High Scores!");
        stage.show();
    }
        
        
        

    public static void main(String[] args) 
    {
        launch();
    }
}
    
    // Event Handler class for the command text field.       
class CommandHandler implements EventHandler<ActionEvent>
{
    // private fields to hold information passed to the constructor.
    private LinkedList0 ll = new LinkedList0();    
    private TextArea listView;
    
    CommandHandler(LinkedList0 lList, TextArea lView)
    {
        ll = lList;        
        listView = lView;        
    }
    
    @Override
    public void handle(ActionEvent event)
    {
        // Get the command from the command textfield.
        TextField cmdTextField = (TextField)event.getTarget();
        String cmdText =  cmdTextField.getText();
        
        // Use a scanner to read the name of the linked list  
        // method and do a switch on it.
        Scanner sc = new Scanner(cmdText);
        String cmd = sc.next();
        switch(cmd)
        {   
            case "empty":
                String resText = String.valueOf(ll.isEmpty());
                return;
            case "listSize":
               String resText1 = String.valueOf(ll.size());
               return;   
            case "insert":
                ll.insert(sc.next(), sc.nextInt());
                listView.setText(ll.toString());
                return;
        }          
    }    
}
