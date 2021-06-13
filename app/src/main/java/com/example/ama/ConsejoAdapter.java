package com.example.ama;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ConsejoAdapter extends BaseAdapter {

    //Data
    private ArrayList<Consejos> consejos;
    private FirebaseDatabase db;
    private FirebaseAuth auth;
    private String idUser;
    private String idFavoritos;
    private String consejosFavoritos;
    private String tituloFavoritos;
    private String nombreFavoritos;

    public ConsejoAdapter() {
        consejos = new ArrayList<>();
        db = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
    }

    public void addConsejo(Consejos consejo){
    consejos.add(consejo);
    notifyDataSetChanged();
    }

    public void clear(){
        consejos.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return consejos.size();
    }

    @Override
    public Object getItem(int position) {
        return consejos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //Dotar de UI a un arraylist
    @Override
    public View getView(int pos, View renglon, ViewGroup lista) {
        LayoutInflater inflater = LayoutInflater.from(lista.getContext());
        View renglonView = inflater.inflate(R.layout.row, null);

        Consejos consejo = consejos.get(pos);

        TextView tituloView = renglonView.findViewById(R.id.tituloPerf);
        TextView nombreView = renglonView.findViewById(R.id.nombreView);
        TextView advView = renglonView.findViewById(R.id.advView);
        TextView responderBtn = renglonView.findViewById(R.id.responderBtn);

        tituloView.setText(consejo.getTitulo());
        nombreView.setText("@"+consejo.getNombre());
        advView.setText(consejo.getConsejos());


        DatabaseReference ref = db.getReference().child("consejos");
        ref.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot data) {
                        for (DataSnapshot child : data.getChildren()){
                            Consejos consejo = child.getValue(Consejos.class);
                            nombreFavoritos = consejo.getNombre();
                            consejosFavoritos = consejo.getConsejos();
                            idFavoritos = consejo.getId();
                            tituloFavoritos = consejo.getTitulo();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {

                    }
                }
        );

        responderBtn.setOnClickListener(
                (v) -> {
                    if(auth.getCurrentUser() != null){
                        idUser = auth.getCurrentUser().getUid();
                    }

                    DatabaseReference reference = db.getReference().child("Favoritos").child(idUser).child(idFavoritos);
                    Consejos favoritos = new Consejos(
                            nombreFavoritos,
                            consejosFavoritos,
                            idFavoritos,
                            tituloFavoritos
                    );
                    reference.setValue(favoritos);
                }
        );

        return renglonView;
    }
}
