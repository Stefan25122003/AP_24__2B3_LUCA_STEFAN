package org.example;

public class Main {
    public static void main(String[] args) {
        DocumentRepository repository = new DocumentRepository("\"C:\\Users\\Crist\\IdeaProjects\\lab5\\master\"");

        Person person1 = new Person(1, "Name1");
        Person person2 = new Person(2, "Name2");

        Document document1 = new Document("Title1", "Content1", person1);
        Document document2 = new Document("Title2", "Content2", person2);

        repository.addDocument(document1);
        repository.addDocument(document2);

        repository.displayDocuments();
    }
}