package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class DocumentRepository {
    private final String masterDirectory;
    private final Map<Person, List<Document>> documents;

    public DocumentRepository(String masterDirectory) {
        this.masterDirectory = masterDirectory;
        this.documents = new HashMap<>();
    }

    public void addDocument(Document document) {
        this.documents.computeIfAbsent(document.owner(), k -> new ArrayList<>()).add(document);
    }

    public void displayDocuments() {
        this.documents.forEach((person, docs) -> {
            System.out.println("Person: " + person.name() + ", ID: " + person.id());
            docs.forEach(doc -> System.out.println("Document: " + doc.title()));
        });
    }
}