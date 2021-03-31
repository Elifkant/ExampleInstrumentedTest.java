package com.zigzag.libraryautomation.crud;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.zigzag.libraryautomation.Kitap;
import com.zigzag.libraryautomation.KutuphaneManager;
import com.zigzag.libraryautomation.R;

public class KitapEkle extends AppCompatActivity implements View.OnClickListener {

    private Button addButton;
    private EditText bookName;
    private EditText bookId;
    private EditText categoryOfBook;
    private EditText publishYear;
    private EditText pageSize;
    private EditText authorName;

    String bookNameStr;
    String bookIdStr;
    String authorNameStr;
    String categoryOfBookStr;
    String publishYearStr;
    String pageSizeStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitap_ekle);

        bookName = findViewById(R.id.bookName);

        bookId=findViewById(R.id.bookId);
        authorName=findViewById(R.id.authorName);
        categoryOfBook=findViewById(R.id.categoryOfBook);
        publishYear=findViewById(R.id.publishYear);
        pageSize=findViewById(R.id.pageSize);

        initControl(); // butona burda basılıyor.
    }

    @Override
    public void onClick(View v) {

        bookNameStr = bookName.getText().toString();
        bookIdStr = bookId.getText().toString();
        authorNameStr = authorName.getText().toString();
        categoryOfBookStr = categoryOfBook.getText().toString();
        pageSizeStr = pageSize.getText().toString();
        publishYearStr = publishYear.getText().toString();

        if (v.getId() == R.id.addButton) {

            if(bookNameStr.equals("") || bookIdStr.equals("") || authorNameStr.equals("")){
                Toast.makeText(this,"Mandatory items are null",Toast.LENGTH_SHORT).show();
            }
            else {
                try {
                    Kitap kitap = new Kitap.KitapBuilder(bookIdStr,bookNameStr,authorNameStr)
                            .pageSize(!pageSizeStr.equals("") ? Integer.parseInt(pageSizeStr) : null)
                            .categoryOfBook(categoryOfBookStr)
                            .publishYear(!publishYearStr.equals("") ? Integer.parseInt(publishYearStr) : null)
                            .build();
                    KutuphaneManager.getInstance().insertBook(kitap);

                    Toast.makeText(this,bookNameStr+" added",Toast.LENGTH_SHORT).show();
                    Log.e("Hata","Hata Yok");
                }
                catch (Exception e){
                    System.out.println("Error " + e.getMessage());
                    Log.e("Hata","Hata var");
                }
            }
        }
    }

    private void initControl(){
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(this);
    }
}
