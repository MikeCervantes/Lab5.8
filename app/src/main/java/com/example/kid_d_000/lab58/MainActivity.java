package com.example.kid_d_000.lab58;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kid_d_000.lab58.Objetos.FirebaseReferences;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Item> listDatos;
    AdapterDatos adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        listDatos=new ArrayList<>();
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef=database.getReference();
        myRef.child(FirebaseReferences.LLAMADAS_REFERENCE).setValue(null);

        Cursor mCursor = managedQuery(CallLog.Calls.CONTENT_URI, null, null,
                null, null);
        int name = mCursor.getColumnIndex(CallLog.Calls.CACHED_NAME);
        int number = mCursor.getColumnIndex(CallLog.Calls.NUMBER);
        int date = mCursor.getColumnIndex(CallLog.Calls.DATE);
        int duration = mCursor.getColumnIndex(CallLog.Calls.DURATION);
        int type = mCursor.getColumnIndex(CallLog.Calls.TYPE);
        while (mCursor.moveToNext()) {
            String nombre = mCursor.getString(name);
            if(nombre==null){
                nombre="Desconocido";
            }
            String phnumber = mCursor.getString(number);
            String callduration = mCursor.getString(duration);
            String calltype = mCursor.getString(type);
            String calldate = mCursor.getString(date);
            Date d = new Date(Long.valueOf(calldate));
            String callTypeStr = "";
            switch (Integer.parseInt(calltype)) {
                case CallLog.Calls.OUTGOING_TYPE:
                    callTypeStr = "Saliente";
                    break;
                case CallLog.Calls.INCOMING_TYPE:
                    callTypeStr = "Entrante";
                    break;
                case CallLog.Calls.MISSED_TYPE:
                    callTypeStr = "Perdida";
                    break;
            }
            Item item=new Item(nombre,phnumber,callduration+" segundos",callTypeStr,d+"");
            myRef.child(FirebaseReferences.LLAMADAS_REFERENCE).push().setValue(item);
            listDatos.add(item);
        }
        adapter=new AdapterDatos(listDatos);
        recyclerView.setAdapter(adapter);
    }
}
