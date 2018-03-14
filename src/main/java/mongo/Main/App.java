package mongo.Main;

import com.mongodb.MongoClient;
import mongo.Domain.Adress;
import mongo.Domain.Person;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Morphia morphia = new Morphia();
        MongoClient mongo = new MongoClient();
        morphia.map(Person.class).map(Adress.class);
        Datastore ds = morphia.createDatastore(mongo, "my_database");

        Person p = new Person();
        p.setName("Tintin");

        Adress address = new Adress();
        address.setStreet("123 Some street");
        address.setCity("Some city");
        address.setPostCode("123 456");
        address.setCountry("Some country");
        //set address
        p.addAddress(address);
        // Save the POJO
        ds.save(p);
        for (Person e : ds.find(Person.class))
            System.out.println(e.getName());
    }
}
