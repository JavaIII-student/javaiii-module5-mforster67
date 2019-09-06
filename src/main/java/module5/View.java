package module5;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Mark Forster
 *
 *         The View class.
 * 
 *         Displays a list of movies from a database of movies.
 *         Also allows the user to add one or more movies to the 
 *         database.
 * 
 *         The attributes of the View class are...
 * 
 *         LOGGER 		The logger object. 
 *         logFileName	The name of the log file.
 *
 */
public class View extends Application {

	static final Logger LOGGER = Logger.getLogger(View.class.getName());
	static String logFileName = "logfile.txt";

	/**
	 * Display the main list of movies dialog.
	 * 
	 * @param stage The JavaFX stage object.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		Parent root;
		FileHandler fh;
		try {
			//
			// Setup the logging mechanism...
			//
			fh = new FileHandler(logFileName);
			LOGGER.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			LOGGER.info("Starting the Movie Database application.");

			// Show the applications main dialog...
			root = FXMLLoader.load(getClass().getResource("ListMovies.fxml"));

			Scene scene = new Scene(root); // attach scene graph to scene
			stage.setTitle("Movie Database 1.0"); // displayed in window's title bar
			stage.setScene(scene); // attach scene to stage
			stage.show(); // display the stage

			/// Write the final logging message...
			LOGGER.info("Closing the Movie Database application.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 * 
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
