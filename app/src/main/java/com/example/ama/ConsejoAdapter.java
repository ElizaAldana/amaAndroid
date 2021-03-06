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

        TextView tituloView = renglonView.findViewById(R.id.tituloView);
        TextView nombreView = renglonView.findViewById(R.id.nombreView);
        TextView advView = renglonView.findViewById(R.id.advView);
        TextView responderBtn = renglonView.findViewById(R.id.responderBtn);

        tituloView.setText(consejo.getTitulo());
        nombreView.setText("@"+consejo.getNombre());
        advView.setText(consejo.getConsejos());



        responderBtn.setOnClickListener(
                (v) -> {
                    if(auth.getCurrentUser() != null){
                        idUser = auth.getCurrentUser().getUid();
                    }
                    String idConsejos = consejo.getId();

                    DatabaseReference reference = db.getReference().child("Favoritos").child(idUser).child(idConsejos);
                    Consejos favoritos = new Consejos(
                            nombreFavoritos = consejo.getNombre(),
                            consejosFavoritos = consejo.getConsejos(),
                            idConsejos,
                            tituloFavoritos = consejo.getTitulo()
                    );
                    reference.setValue(favoritos);
                }
        );

        return renglonView;
    }
}
