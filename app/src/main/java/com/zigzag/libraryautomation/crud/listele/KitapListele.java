package com.zigzag.libraryautomation.crud.listele;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.zigzag.libraryautomation.KutuphaneManager;
import com.zigzag.libraryautomation.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Kitap Listeleme Aktivitesi
 *
 * Adapter Pattern ile kitaplar listelenir.
 */
public class KitapListele extends AppCompatActivity {
    TextView textView;
    ListView listView;
    List<KitapView> arrayOfBooks;
    KitapViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitap_listele);
        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.editText);

        arrayOfBooks = new ArrayList<>();
        adapter = new KitapViewAdapter(this,arrayOfBooks);

        listView.setAdapter(adapter);
        if (KutuphaneManager.getInstance().listBooks() != null){
            adapter.addAll(KutuphaneManager.getInstance().listBooks());
            listView.setAdapter(adapter);
        }else {
            textView.setVisibility(1);
        }
    }
}





















/*ArrayList<KitapView> kitapList=new ArrayList<>();


@Override
    protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    String kitapAdi="Kitap Adi:";
    String yazarAdi="Yazar Adi:";

    try {
        kitapList.add(new KitapView("sefiller","Victor hugo"));
        KitapViewAdapter kitapArrayAdapter=new KitapViewAdapter(this,  kitapList);
        ListView listView=findViewById(R.id.books_list);
        listView.setAdapter(kitapArrayAdapter);

    } catch (Exception e) {
        e.printStackTrace();
    }


}*/



