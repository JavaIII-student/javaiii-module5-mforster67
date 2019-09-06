package module5;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * @author Mark Forster
 *
 *         The popupController class.
 *         
 *         The controller for the Add/Edit Movie dialog in the MVC pattern.
 * 
 *         The attributes of the popupController class are...
 * 
 * 		   popupStage		The JavaFX stage for the Add/Edit Movie dialog.
 * 		   mainController	The main movie listing windows controller.
 *         btnOK			The OK button which saves the movie and closes the dialog.
 *         btnClear			The Clear button which discards any changes and closes the dialog.
 *         txtId			The text field which holds the automatically generated movie ID.
 *         txtName			The text field which holds the name of the movie.
 *         txtDescription	The text field which holds the movie description.
 *         txtRating		The text field which holds the movie rating.
 *
 */
public class popupController implements Initializable {
	
	// Holds this controller's Stage
    private Stage popupStage;
    
    // The main movie listing windows controller...
    private MainController mainController;
    
    @FXML
    private Button btnOK;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtRating;

    @FXML
    private TextArea txtDescription;

    /**
     * The constructor for the class.
     * 
     * @param	mainController		The controller for the main window (i.e. the list of movies). 
     */
    popupController(MainController mainController) {
		
		Parent root1;
		this.mainController = mainController;

		// Create the Add/Edit Movie dialog...
		try {

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddEditMovie.fxml"));
			fxmlLoader.setController(this);
			root1 = (Parent) fxmlLoader.load();
			
			popupStage = new Stage();
			Scene scene = new Scene(root1); // attach scene graph to scene
			popupStage.setTitle("Add/Edit Movie"); // displayed in window's title bar
			popupStage.setScene(scene); // attach scene to stage

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * Show the Add/Edit Movie dialog.
     */
    public void showWindow() {
    	// Display the Add/Edit Movie dialog...
    	popupStage.showAndWait();
    }
    
    
	/**
	 *	Set the ID field to non-editable.
	 * 
	 * @param	arg0	Argument to the initialize method.
	 * @param	arg1	Argument to the initialize method.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 	Make the ID field non-editable...
		txtId.setDisable(true);
	}


	/**
	 *	Save the movie details and close the Add/Edit Movie dialog.
	 * 
	 *	@param	event	The button pressed event.
	 */
	@FXML
	private void okButtonPressed(ActionEvent event) {
		
		// Calculate the next ID number and display it ...
		int newId = mainController.getMovie().getListLength() + 1;
		txtId.setText(Integer.toString(newId));

		//	Convert the rating field contents to an integer...
		int newRating = Integer.parseInt(txtRating.getText());

		//	Add the movie to the list and database...
		mainController.getMovie().addMovie(newId, txtName.getText(), txtDescription.getText(), newRating);
		
		//	Close the Add/Edit Movie dialog...
		popupStage.close();
	}

	/**
	 *	Close the Add/Edit Movie dialog.
	 * 
	 *	@param	event	The button pressed event.
     */	
	@FXML
	private void cancelButtonPressed(ActionEvent event) {
		
		//	Close the Add/Edit Movie dialog...
		popupStage.close();
	}

}