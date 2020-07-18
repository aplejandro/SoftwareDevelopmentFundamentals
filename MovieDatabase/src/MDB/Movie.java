package MDB;
import java.util.*;


public class Movie {
	private String name;
	private ArrayList<Actor> actors;
	private double rating;
	
	public Movie(String name) {
		this.name = name;
		this.actors = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Actor> getActors() {
		return actors;
	}

	public void setActors(ArrayList<Actor> actors) {
		this.actors = actors;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	private ArrayList<String> getActorNames() {
        ArrayList<String> actorNames = new ArrayList<>();
        for (Actor actor: this.actors) {
            actorNames.add(actor.getName());
        }
        return actorNames;
    }
	public void addActor(Actor actor) {
        if (!this.getActorNames().contains(actor.getName())) {
            this.actors.add(actor);
        }
    }
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (Double.compare(movie.rating, rating) != 0) return false;
        return name.equals(movie.name);
    }
	
	

}
