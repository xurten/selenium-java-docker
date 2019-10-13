package com.database;

import com.model.Log;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoRepository implements IRepository<Log> {
    private MongoClient mongoClient;
    private MongoDatabase database;

    @Override
    public void prepareDatabase() {
        mongoClient = new MongoClient("localhost", 27017);
        database = mongoClient.getDatabase("myMongoDb");
    }

    @Override
    public void Add(Log entity) {
        MongoCollection collection = database.getCollection("logs");
        Document document = new Document("id", entity.getId())
                .append("message", entity.getMessage())
                .append("success", entity.getSuccess())
                .append("currentDate", entity.getCurrentDate());
        collection.insertOne(document);
    }

    @Override
    public void Delete(Log entity) {

    }

    @Override
    public void Update(Log entity) {

    }

    @Override
    public Log FindById(int Id) {
        return null;
    }
}
