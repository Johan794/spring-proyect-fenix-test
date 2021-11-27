package service.implement;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.database.Query;
import fireBase.FireBaseInitializer;
import model.Jugador;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import service.PostManagementService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
@ComponentScan("fireBase")
public class PostManagementServiceImplement implements PostManagementService {

    @Autowired
    private FireBaseInitializer fireBaseInitializer;

    @Override
    public List<Jugador> list() {
        List<Jugador> responde = new ArrayList<>();
        Jugador post;

        ApiFuture<QuerySnapshot> querySnapshotApiFuture = getCollection().get();

        try {
            for (DocumentSnapshot doc:querySnapshotApiFuture.get().getDocuments()) {
                post = doc.toObject(Jugador.class);
                post.setId(doc.getId());
                responde.add(post);
            }

            return responde;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }



    }

    @Override
    public boolean add(Jugador jugador) {
        Map<String,Object> dataDocument = new HashMap<>();
        dataDocument.put("name",jugador.getName());
        dataDocument.put("playNumber",jugador.getPlayNumber());

        CollectionReference post = getCollection();
        ApiFuture<WriteResult> writeResultApiFuture = post.document().create(dataDocument);
        try {
            if (null!=writeResultApiFuture.get()){
                return true;
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(String name, Jugador jugador) {
        return false;
    }

    @Override
    public boolean delete(String name) {
        return false;
    }

    private CollectionReference getCollection() {
        return fireBaseInitializer.getFireStore().collection("post");
    }
}
