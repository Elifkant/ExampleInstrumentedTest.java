package com.zigzag.libraryautomation.crud.listele;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.zigzag.libraryautomation.R;
import java.util.List;

public class KitapViewAdapter extends ArrayAdapter<KitapView> {

    public KitapViewAdapter(@NonNull Context context, List<KitapView> arrayList){
        super(context, 0,arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        View currentItemView = convertView;

        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_view, parent, false);
        }
        KitapView currentBookPosition=getItem(position);
        TextView bookName = currentItemView.findViewById(R.id.bookNameList);
        bookName.setText("Book Name : " + currentBookPosition.getBookName());

        TextView authorName = currentItemView.findViewById(R.id.authorNameList);
        authorName.setText("Author Name : " + currentBookPosition.getAuthorName());

        TextView bookId = currentItemView.findViewById(R.id.bookIdList);
        bookId.setText("Book Id : " + currentBookPosition.getBookId());

        TextView categoryOfBook = currentItemView.findViewById(R.id.categoryOfBookList);
        categoryOfBook.setText("Category : " + currentBookPosition.getCategoryOfBook());

        TextView pageSize = currentItemView.findViewById(R.id.pageSizeList);
        pageSize.setText("Page Size : " + currentBookPosition.getPageSize());

        TextView publishYear = currentItemView.findViewById(R.id.publishYearList);
        publishYear.setText("Publish Year : " + currentBookPosition.getPublishYear());

       return currentItemView;
    }
}




