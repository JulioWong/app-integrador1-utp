package Data;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

public final class Database {
    private final MongoClientURI uri;
    private final String user;
    private final String password;
    private final String database;
    private final MongoClient mongoClient;
    private final MongoDatabase mongoDatabase;

    public Database() {
        this.database = "integrador1";
        this.user = "jwong";
        this.password = "integrador1";
        this.uri = new MongoClientURI(
            "mongodb://" + this.user + ":" + this.password + "@" +
            "cluster0-shard-00-00.aptoz.mongodb.net:27017," +
            "cluster0-shard-00-01.aptoz.mongodb.net:27017," +
            "cluster0-shard-00-02.aptoz.mongodb.net:27017/" + this.database +
            "?ssl=true&replicaSet=atlas-xyxo8p-shard-0&" +
            "authSource=admin&retryWrites=true&w=majority"
        );
        this.mongoClient = new MongoClient(this.uri);
        this.mongoDatabase = mongoClient.getDatabase(this.database);
    }
    
    public MongoCollection<Document> getMongoCollection(String table) {
        return this.mongoDatabase.getCollection(table);
    }
    public boolean insertMongoDocument(Document doc, String Collection){
        try{
            MongoCollection<Document> collection = this.mongoDatabase.getCollection(Collection);
            collection.insertOne(doc);    
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    public boolean updateMongoDocument(Document query, Bson updateObject,String Collection){
        try{
            MongoCollection<Document> collection = this.mongoDatabase.getCollection(Collection);
            collection.updateOne(query,updateObject);    
            return true;
        }catch(Exception ex){
            return false;
        }
    }
}