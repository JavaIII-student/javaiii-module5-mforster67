package module5;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author Mark Forster
 *
 *         The MainController class.
 * 
 *         The main controller in the MVC pattern.    Displays a list of movies.
 * 
 *         The attributes of the Controller class are...
 *
 * 		   movie		The MovieQueries object containing the list of movies and the count of the movies.
 * 		   tbvMovies	The table view object.
 *         btnAdd		The Add movie button.
 *
 */
public class MainController implements Initializable {
	private MovieQueries movie = new MovieQueries();

	@FXML
	private TableView<Movie> tbvMovies;

	@FXML
	private Button btnAdd;


	/**
	 * Add the columns to the table view, get the list of movies, and
	 * display the list of movies in the data grid. 
	 * 
	 * @param arg0 Argument to the initialize method.
	 * @param arg1 Argument to the initialize method.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		//	Create a new table column for the movie ID...
		TableColumn<Movie, Integer> idColumn = new TableColumn<>("ID");
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

		//	Create a new table column for the movie name...
		TableColumn<Movie, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

		//	Create a new table column for the movie description...
		TableColumn<Movie, String> descColumn = new TableColumn<>("Description");
		descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

		//	Create a new table column for the movie rating...
		TableColumn<Movie, Integer> ratingColumn = new TableColumn<>("Rating");
		ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));

		//	Add the new columns to the table view...
		tbvMovies.getColumns().add(idColumn);
		tbvMovies.getColumns().add(nameColumn);
		tbvMovies.getColumns().add(ratingColumn);
		tbvMovies.getColumns().add(descColumn);

		//	Populate the table view with the movies... 
		tbvMovies.setItems(movie.getMovieList());

		//	Set the on action event for the Add button... 	
		btnAdd.setOnAction(event -> openAddEditMovieDialog());

	}
	
    /**
     * Displays the Add/Edit Movie dialog.
     */
    private void openAddEditMovieDialog() {

    	//	Create a new controller for the Add/Edit Movie dialog...
    	popupController popupController = new popupController(this);

        // Show the new Add/Edit Movie dialog...
    	popupController.showWindow();

    }

    /**
     * Returns the MovieQueries object.
     * 
     *  @return		this.movie		The MovieQueries object.
     */
    public MovieQueries getMovie() {
    	//	Return the MovieQueries object...
    	return this.movie;
    }
    
    
}