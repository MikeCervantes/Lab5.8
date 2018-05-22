package com.example.kid_d_000.lab58;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {
    ArrayList<Item> listDatos;

    public AdapterDatos(ArrayList<Item> listDatos) {
        this.listDatos = listDatos;
    }

    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        holder.nombre.setText(listDatos.get(position).getNombre());
        holder.telefono.setText(listDatos.get(position).getTelefono());
        holder.duracion.setText(listDatos.get(position).getDuracion());
        holder.tipo.setText(listDatos.get(position).getTipo());
        holder.fecha.setText(listDatos.get(position).getFecha());
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView nombre,telefono,duracion,tipo,fecha;

        public ViewHolderDatos(View itemView) {
            super(itemView);

            nombre=itemView.findViewById(R.id.nombre);
            telefono=itemView.findViewById(R.id.telefono);
            duracion=itemView.findViewById(R.id.duracion);
            tipo=itemView.findViewById(R.id.tipo);
            fecha=itemView.findViewById(R.id.fecha);
        }
    }
}
