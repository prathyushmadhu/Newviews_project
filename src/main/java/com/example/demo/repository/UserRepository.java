package com.example.demo.repository;

import com.example.demo.model.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private final Firestore firestore;

    public UserRepository(Firestore firestore) {
        this.firestore = firestore;
    }

    public boolean createUser(User user) {
        ApiFuture<com.google.cloud.firestore.WriteResult> result = firestore.collection("users").document(user.getId()).set(user);
        try {
            com.google.cloud.firestore.WriteResult writeResult = result.get();
            return writeResult != null;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<User> getAllUsers() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> future = firestore.collection("users").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        return documents.stream().map(doc -> doc.toObject(User.class)).collect(Collectors.toList());
    }

    public User getUserById(String id) throws ExecutionException, InterruptedException {
        return firestore.collection("users").document(id).get().get().toObject(User.class);
    }

    public boolean updateUser(User user) {
        ApiFuture<com.google.cloud.firestore.WriteResult> result = firestore.collection("users").document(user.getId()).set(user);
        try {
            com.google.cloud.firestore.WriteResult writeResult = result.get();
            return writeResult != null;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteUser(String id) {
        ApiFuture<com.google.cloud.firestore.WriteResult> result = firestore.collection("users").document(id).delete();
        try {
            com.google.cloud.firestore.WriteResult writeResult = result.get();
            return writeResult != null;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return false;
        }
    }
}
