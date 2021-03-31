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

public class KitapGuncelle extends AppCompatActivity implements View.OnClickListener {

    private EditText bookIdSearch;
    private EditText bookIdUpdate;
    private EditText bookNameUpdate;
    private EditText authorNameUpdate;
    private EditText categoryOfBookUpdate;
    private EditText publishYearUpdate;
    private EditText pageSizeUpdate;

    private Button fetchBook;
    private Button updateButton;

    private Kitap kitapToBeUpdated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitap_guncelle);

        bookIdSearch = findViewById(R.id.bookIdSearch);
        bookIdUpdate = findViewById(R.id.bookIdUpdate);
        bookNameUpdate = findViewById(R.id.bookNameUpdate);
        authorNameUpdate = findViewById(R.id.authorNameUpdate);
        categoryOfBookUpdate = findViewById(R.id.categoryOfBookUpdate);
        publishYearUpdate = findViewById(R.id.publishYearUpdate);
        pageSizeUpdate = findViewById(R.id.pageSizeUpdate);

        fetchBook = findViewById(R.id.fetchBook);
        updateButton = findViewById(R.id.updateButton);

        fetchBook.setOnClickListener(this);
        updateButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fetchBook:
                kitapToBeUpdated = fetchBook();
                break;
            case R.id.updateButton:
                updateBook();
                break;
            default:
                break;
        }
    }

    private Kitap fetchBook() {
        String id = bookIdSearch.getText().toString();

        for (Kitap kitap : KutuphaneManager.getInstance().getKitaplar()) {
            if (kitap.getBookId().equals(id)) {

                bookIdUpdate.setText(kitap.getBookId());
                bookNameUpdate.setText(kitap.getBookName());
                authorNameUpdate.setText(kitap.getAuthorName());
                categoryOfBookUpdate.setText(kitap.getCategoryOfBook());
                publishYearUpdate.setText(kitap.getPublishYear()+"");
                pageSizeUpdate.setText(kitap.getPageSize()+"");

                return kitap;
            }
        }
        Toast.makeText(this, "Book couldn't find!", Toast.LENGTH_SHORT).show();
        return null;
    }

    private void updateBook(){
        if (this.kitapToBeUpdated == null){
            Toast.makeText(this,"First, fetch the book!", Toast.LENGTH_SHORT).show();
        } else {
            kitapToBeUpdated.setBookId(bookIdUpdate.getText().toString());
            kitapToBeUpdated.setBookName(bookNameUpdate.getText().toString());
            kitapToBeUpdated.setAuthorName(authorNameUpdate.getText().toString());
            kitapToBeUpdated.setCategoryOfBook(categoryOfBookUpdate.getText().toString());
            kitapToBeUpdated.setPublishYear(Integer.parseInt(String.valueOf(publishYearUpdate.getText())));
            kitapToBeUpdated.setPageSize(Integer.parseInt(String.valueOf(pageSizeUpdate.getText())));

            Toast.makeText(this,"Book updated!", Toast.LENGTH_SHORT).show();
        }
    }
}




