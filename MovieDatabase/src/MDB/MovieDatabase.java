package MDB;

import java.util.*;
import java.io.*;

public class MovieDatabase {
	private ArrayList<Movie> movieList;
	private ArrayList<Actor> actorList;
	
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}
	public ArrayList<Actor> getActorList() {
		return actorList;
	}
	
	public MovieDatabase() {
		this.actorList = new ArrayList<>();
		this.movieList = new ArrayList<>();
	}
	private ArrayList<String> getMovieNames() {
        ArrayList<String> movieNames = new ArrayList<>();
        for (Movie movie: this.movieList) {
            movieNames.add(movie.getName());
        }
        return movieNames;
    }
	
	/**
	 * This method takes in the name of a movie that is not currently 
	 * in the database along with a list of actors for that movie. 
	 * If the movie is already in the database, your code ignores this request 
	 * (this specification is an oversimplification).
	 * If the movie is a new movie, a movie object is created and added to the movieList.
	 * If any of the actors happen to be new, they will be added to the actorList.
	 * @param name
	 * @param actors[]
	 */
	public void addMovie(String name, String actors[]) {
		if (!this.getMovieNames().contains(name)) {
            ArrayList<Movie> movieList = new ArrayList<>();
            Movie newMovie = new Movie(name);
            movieList.add(newMovie);
            for (String actorName: actors) {
                Actor newActor = new Actor(actorName, movieList);
                newMovie.addActor(newActor);
                boolean added = false;
                for (Actor actor: this.actorList) {
                    if (actorName.equals(actor.getName())) {
                        actor.addMovie(newMovie);
                        added = true;
                    }
                }
                if (!added) this.actorList.add(newActor);

            }
            this.movieList.add(newMovie);
        }
	}
	
	/**
	 * Add a rating for this movie. 
	 * Assume that the name argument will definitely 
	 * be a name that is currently in the database.
	 * @param name
	 * @param rating
	 */
	public void addRating(String name,double rating) {
		for (Movie movie: movieList) {
            if (movie.getName().equals(name)) {
                movie.setRating(rating);
            } else {
                continue;
            }
        }
	}
	/**
	 * Overwrite the current rating of a movie with this new rating. 
	 * Again, assume that the name argument will definitely be a name 
	 * that is currently in the database.
	 * @param name
	 * @param newRating
	 */
	public void updateRating(String name, double newRating) {
		this.addRating(name, newRating);
	}
	/**
	 * Returns the name of the actor that has the best average rating for their movies.
	 * In the case of a tie, return any one of the best actors.
	 * @return
	 */
	public String getBestActor() {
		String actorName = "";
        double averageRating = 0.0;

        for (Actor actor: actorList) {
            double totalRating = 0.0;
            for (Movie movie: actor.getMovies()) {
                totalRating += movie.getRating();
            }
            double average = totalRating/actor.getMovies().size();

            if (average > averageRating) {
                averageRating = average;
                actorName = actor.getName();
            }
        }
        return actorName;
	}
	/**
	 * Returns the name of the movie with the highest rating.
	 * In the case of a tie, return any one of the best movies.
	 * @return
	 */
	public String getBestMovie() {
		double bestRating = 0.0;
        String movieName = "";
        for (Movie movie: this.movieList) {
            if (movie.getRating() > bestRating) {
                bestRating = movie.getRating();
                movieName = movie.getName();
            }
        }
        return movieName;
	}
	
	public static void main(String[] args) {
		MovieDatabase movieDB = new MovieDatabase();
		String line;
		//Reading the movies file
		try{
			File fileMovies = new File("movies.txt");
			//System.out.println("Attempting to read from file in: "+ fileMovies.getCanonicalPath()); 
			Scanner sc = new Scanner(fileMovies); 
			  
			while (sc.hasNextLine()) {
				//System.out.println(sc.nextLine());
				line = sc.nextLine();
				//System.out.println(line);
				String[] movie = line.split(",");
				String[] actor = new String[1];
				actor[0] = movie[0];
				//Adding each movie column of each actor row
				for(int i = 1; i < movie.length; i++) {
					movieDB.addMovie(movie[i].trim(), actor);
				}
			}
			sc.close();
		}catch (FileNotFoundException e) {
		      System.out.println("An error occurred. File Not Found");
		      e.printStackTrace();
		    }
		//Reading the ratings file
		try {
			File fileRatings = new File("ratings.txt");
			Scanner sc2 = new Scanner(fileRatings); 
			while (sc2.hasNextLine()) {
				line = sc2.nextLine();
				//System.out.println(line);
				String[] rating = line.split("\t");
				try {
                    double value = Double.parseDouble(rating[1]);
                    movieDB.addRating(rating[0].trim(), value);
                } catch (NumberFormatException e) {
                    continue;
                }
			}
			sc2.close();
		}catch (FileNotFoundException e) {
		      System.out.println("An error occurred. File Not Found");
		      e.printStackTrace();
		    }
		//Best Actor
		System.out.println(movieDB.getBestActor());
		//Best Movie
        System.out.println(movieDB.getBestMovie());
	}

}
