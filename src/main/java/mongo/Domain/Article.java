package mongo.Domain;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@Entity("article")
public class Article {

    @Id
    private ObjectId id;
    @Property("price")
    private int stars;
    private String name;
    private Collection<Person> buyers;

    public Article(String name, int stars) {
        this.name = name;
        this.stars = stars;
        buyers = new ArrayList<Person>();
    }
    public Article() {
        this.name = "";
        this.stars = 0;
        buyers = new ArrayList<Person>();
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
    public String getAllBuyers()
    {
        String persons = "";
        Iterator<Person> personIterator = this.buyers.iterator();
        while (personIterator.hasNext())
        {

            persons += personIterator.next().getName()+", ";
        }
        return  persons;
    }

    @Override
    public String toString() {

        return "Article{" +
                "id=" + id +
                ", name=' " + name + '\'' +
                ", stars= " + stars +
                ", buyers= [" + this.getAllBuyers() +" ]"+
                '}';
    }

}
