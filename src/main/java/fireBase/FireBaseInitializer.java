package fireBase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;

@Service
public class FireBaseInitializer {
    @PostConstruct
    private void initFireStore() throws IOException {

        InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("jugadores-management-firebase-adminsdk-lyb6c-03e5561e0b.json");

        FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://jugadores-management.firebaseio.com/")
                .build();

        if(FirebaseApp.getApps().isEmpty()){
            FirebaseApp.initializeApp(options);
        }


    }

    public Firestore getFireStore(){
        return FirestoreClient.getFirestore();
    }
}
