package com.zigzag.libraryautomation;

import com.zigzag.libraryautomation.crud.listele.KitapView;
import java.util.ArrayList;
import java.util.List;

/**
 * Bu sınıf :
 * Kütüphaneye kitap ekler.
 * Kütüphaneden kitap siler.
 * Var olan kitapları günceller.
 * Var olan kitapları show eder.
 */
public class KutuphaneManager {

    private static KutuphaneManager instance;
    private List<Kitap> kitaplar;

    public List<Kitap> getKitaplar() {
        return kitaplar;
    }

    //private constructor to avoid client applications to use constructor
    private KutuphaneManager(){
        kitaplar = new ArrayList<>();

        Kitap defaultKitap1 = new Kitap.KitapBuilder("ID123","Sefiller","Victor Hugo")
                .pageSize(333)
                .categoryOfBook("Roman")
                .publishYear(1862)
                .build();

        Kitap defaultKitap2 = new Kitap.KitapBuilder("ID456","Kürk Mantolu Madonna","Sabahattin Ali")
                .pageSize(140)
                .categoryOfBook("Roman")
                .publishYear(1941)
                .build();

        kitaplar.add(defaultKitap1);
        kitaplar.add(defaultKitap2);
    }

    public static KutuphaneManager getInstance(){
        if (instance == null){
            instance = new KutuphaneManager();
        }
        return instance;
    }

    /**
     * Add book
     * @param kitap to be added
     */
    public void insertBook(Kitap kitap){
        kitaplar.add(kitap);
    }

    /**
     * Delete book
     * @param kitap to be deleted
     */
    public void removeBook(Kitap kitap){
        kitaplar.remove(kitap);
    }

    /**
     * @return Kitap adapted as a KitapView
     */
    public List<KitapView> listBooks(){
        if(kitaplar.size() <= 0){
            return null;
        }
        List<KitapView> kitapViewList = new ArrayList<>();
        for (Kitap kitap : this.kitaplar){
            String bookId = kitap.getBookId();
            String bookName = kitap.getBookName();
            String authorName = kitap.getAuthorName();
            Integer publishYear = kitap.getPublishYear();
            Integer pageSize = kitap.getPageSize();
            String categoryOfBook = kitap.getCategoryOfBook();

            KitapView kitapView = new KitapView(bookId, bookName, authorName);
            kitapView.setPublishYear(publishYear);
            kitapView.setPageSize(pageSize);
            kitapView.setCategoryOfBook(categoryOfBook);

            kitapViewList.add(kitapView);
        }
        return kitapViewList;
    }
}
