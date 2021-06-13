package com.example.ama;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FavoritosAdapter extends BaseAdapter {

    //Data
    private ArrayList<Consejos> consejos;
    private FirebaseAuth auth;
    private String idUser;

    public FavoritosAdapter() {
        consejos = new ArrayList<>();
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
        View renglonView = inflater.inflate(R.layout.rowperfil, null);

        Consejos consejo = consejos.get(pos);

        TextView tituloPerf = renglonView.findViewById(R.id.tituloPerf);
        TextView nombrePerf = renglonView.findViewById(R.id.nombrePerf);
        TextView advPerf = renglonView.findViewById(R.id.advPerf);
        Button deleteButton = renglonView.findViewById(R.id.deleteButton);

        tituloPerf.setText(consejo.getTitulo());
        nombrePerf.setText("@"+consejo.getNombre());
        advPerf.setText(consejo.getConsejos());

        deleteButton.setOnClickListener(
                (v) -> {
                    if(auth.getCurrentUser() != null){
                        idUser = auth.getCurrentUser().getUid();
                    }
                    String id = consejo.getId();
                    DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Favoritos").child(idUser).child(id);
                    reference.setValue(null);
                }
        );

        return renglonView;
    }
}
