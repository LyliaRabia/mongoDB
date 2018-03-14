package mongo.Main;

import com.mongodb.MongoClient;
import mongo.Domain.Adress;
import mongo.Domain.Article;
import mongo.Domain.Person;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 * Hello world!
 *
 */
public class AppMongo
{
    public static void main( String[] args )
    {
        Morphia morphia = new Morphia();
        MongoClient mongo = new MongoClient();
        morphia.map(Person.class).map(Adress.class);
        morphia.map(Article.class);
        Datastore ds = morphia.createDatastore(mongo, "my_database");

        //Articles
        Article article1 = new Article("kinder", 25);
        Article article2 = new Article("ferero", 30);

        // Personnes
        Person person = new Person("titi");
        Person person1 = new Person("toto");
        Person person2 = new Person("tata");

        //Adresses
        Adress address = new Adress("34 rue guy ropartz","35700","Rennes", "France" );
        Adress address1 = new Adress("20 rue de leon","35000","Rennes", "France" );
        Adress address2 = new Adress("30 kitchen street","65420","kitchen city", "House" );



        person.addAddress(address);
        person.addAddress(address1);
        person.addAddress(address2);


        article1.addPerson(person);
        article1.addPerson(person1);
        article1.addPerson(person2);


        ds.save(article1);
        ds.save(article2);
        ds.save(person);
        ds.save(person1);
        ds.save(person2);

        for (Person e : ds.find(Person.class))
            System.out.println(e.toString());

        for (Article e : ds.find(Article.class))
            System.out.println(e.toString());


    }
}
