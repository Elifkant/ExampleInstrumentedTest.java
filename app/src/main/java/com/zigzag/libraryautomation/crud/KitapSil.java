package com.zigzag.libraryautomation.crud;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.zigzag.libraryautomation.Kitap;
import com.zigzag.libraryautomation.KutuphaneManager;
import com.zigzag.libraryautomation.R;

/**
 * Kitap Silme Aktivitesi
 */
public class KitapSil extends AppCompatActivity implements View.OnClickListener{

    private Button buttondelete;
    private EditText enterid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitap_sil);

        buttondelete=findViewById(R.id.buttondelete);
        enterid=findViewById(R.id.enterid);

        initControl();
    }

    private void initControl(){
        buttondelete = findViewById((R.id.buttondelete));
        buttondelete.setOnClickListener(this);

        enterid = findViewById((R.id.enterid));
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttondelete){
             String value=enterid.getText().toString();
             if(KutuphaneManager.getInstance().getKitaplar().size()==0){
                 Toast.makeText(this, "Kütüphanede silinecek kitap yoktur", Toast.LENGTH_LONG).show();
             }
             else{
                 //for each
                 for (Kitap kitap : KutuphaneManager.getInstance().getKitaplar()){
                     if (kitap.getBookId().equals(value)) {
                         KutuphaneManager.getInstance().removeBook(kitap);
                         Toast.makeText(this, kitap.getBookName()+" silindi.", Toast.LENGTH_SHORT).show();
                         break;
                     }
                 }
             }
        }
    }




}
