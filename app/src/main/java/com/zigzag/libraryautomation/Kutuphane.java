package com.zigzag.libraryautomation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.zigzag.libraryautomation.crud.KitapEkle;
import com.zigzag.libraryautomation.crud.KitapGuncelle;
import com.zigzag.libraryautomation.crud.KitapSil;
import com.zigzag.libraryautomation.crud.listele.KitapListele;

public class Kutuphane extends AppCompatActivity implements View.OnClickListener {

    private Button kitapEkleButton;
    private Button kitapListeleButton;
    private Button kitapSilButton;
    private Button kitapGuncelleButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kutuphane);

        kitapEkleButton = findViewById((R.id.kitapEkleButton));
        kitapEkleButton.setOnClickListener(this);


        kitapSilButton = findViewById((R.id.kitapSilButton));
        kitapSilButton.setOnClickListener(this);

        kitapListeleButton = findViewById((R.id.kitapListeleButton));
        kitapListeleButton.setOnClickListener(this);

        kitapGuncelleButton = findViewById((R.id.kitapGuncelleButton));
        kitapGuncelleButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.kitapEkleButton:
                 intent = new Intent(this, KitapEkle.class);
                this.startActivity(intent);
                break;
            case R.id.kitapListeleButton:
                 intent = new Intent(this, KitapListele.class);
                this.startActivity(intent);
                break;
            case R.id.kitapSilButton:
                intent = new Intent(this, KitapSil.class);
                this.startActivity(intent);
                break;
            case R.id.kitapGuncelleButton:
                intent = new Intent(this, KitapGuncelle.class);
                this.startActivity(intent);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}