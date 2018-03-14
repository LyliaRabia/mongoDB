package mongo;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Collection;

public class Article {


    private ObjectId id;
    private int stars;
    private String name;
    private Collection<Person> buyrers;

    public Article(String name, int stars) {
        this.name = name;
        this.stars = stars;
        buyrers = new ArrayList<Person>();
    }
    public Article() {
        this.name = "";
        this.stars = 0;
        buyrers = new ArrayList<Person>();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
