package com.example.demo.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {


    @PostConstruct
    public void init() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("src/main/resources/newviews-3dead-firebase-adminsdk-ex56e-6391ffc262.json");

        FirebaseOptions options = FirebaseOptions.builder() 
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://newviews-3dead.rtdb.asia-southeast1.firebasedatabase.app/") 
            .build();

        FirebaseApp.initializeApp(options);
    }

    @Bean
    public Firestore firestore() throws IOException {
        return FirestoreClient.getFirestore();
    }
}






































// package com.example.demo.config;

// import com.google.auth.oauth2.GoogleCredentials;
// import com.google.firebase.FirebaseApp;
// import com.google.firebase.FirebaseOptions;
// import org.springframework.context.annotation.Configuration;
// import com.google.firebase.database.FirebaseDatabase;
// import org.springframework.context.annotation.Bean;
// import javax.annotation.PostConstruct;
// import java.io.FileInputStream;
// import java.io.IOException;

// @Configuration
// public class FirebaseConfig {

//   @PostConstruct
//   public void init() throws IOException {
//     FileInputStream serviceAccount = new FileInputStream("src/main/resources/newviews-3dead-firebase-adminsdk-ex56e-6391ffc262.json");
//     FirebaseOptions options = FirebaseOptions.builder() 
//       .setCredentials(GoogleCredentials.fromStream(serviceAccount))
//       .setDatabaseUrl("https://newviews-3dead.rtdb.asia-southeast1.firebasedatabase.app/") 
//       .build();
//     FirebaseApp.initializeApp(options);
//   }

//   @Bean
//   public FirebaseDatabase firebaseDatabase() {
//       return FirebaseDatabase.getInstance();
//   }  
// }


// https://newviews-3dead.rtdb.asia-southeast1.firebasedatabase.app/
// https://newviews-3dead-default-rtdb.asia-southeast1.firebasedatabase.app/