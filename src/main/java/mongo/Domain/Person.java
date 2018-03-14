package mongo.Domain;

import mongo.Domain.Adress;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@Entity("person")
public class Person {

    @Id
    private ObjectId id;
    private String name;

    @Embedded
    private Collection<Adress> adresses;

    public Person(String name) {
        this.name = name;
        this.adresses = new ArrayList<Adress>();
    }
    public Person() {
        this.name = "";
        this.adresses = new ArrayList<Adress>();
    }


    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Adress> getAdresses() {
        return adresses;
    }

    public void setAddresses(Collection<Adress> adresses) {
        this.adresses = adresses;
    }

    public void addAddress(Adress adress)
    {
        this.adresses.add(adress);
    }

    public String getAllAddress()
    {
        String addresses = "";
        Iterator<Adress> addressIterator = this.adresses.iterator();
        while (addressIterator.hasNext())
        {

            addresses += "{ "+ addressIterator.next().toString()+" }, ";
        }
        return  addresses;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", addresses = [" + this.getAllAddress() +" ]"+
                '}';
    }
}
