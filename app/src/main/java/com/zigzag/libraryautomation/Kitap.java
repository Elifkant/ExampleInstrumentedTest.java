package com.zigzag.libraryautomation;

/**
 * Use Builder Design Pattern
 *
 * Kullanıcı publishYear, pageSize, categoryOfBook girmek zorunda değildir.
 * Ama bookName, authorName ve bookId girmek zorundadır.
 */
public class Kitap {

    private String bookId; //mandatory
    private String bookName; //mandatory
    private String authorName; //mandatory
    private Integer publishYear;//optional
    private Integer pageSize;//optional
    private String categoryOfBook;//optional

    public Kitap(KitapBuilder kitapBuilder){
        this.bookId = kitapBuilder.bookId;
        this.bookName = kitapBuilder.bookName;
        this.authorName = kitapBuilder.authorName;
        this.publishYear = kitapBuilder.publishYear;
        this.pageSize = kitapBuilder.pageSize;
        this.categoryOfBook = kitapBuilder.categoryOfBook;
    }

    /**
     * Setters
     */
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setCategoryOfBook(String categoryOfBook) {
        this.categoryOfBook = categoryOfBook;
    }

    /**
     * Getters
     */
    public String getBookId(){
        return this.bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public String getCategoryOfBook() {
        return categoryOfBook;
    }

    public static class KitapBuilder{

        private String bookId; //mandatory
        private String bookName; //mandatory
        private String authorName; //mandatory
        private Integer publishYear = null;//optional
        private Integer pageSize = null;//optional
        private String categoryOfBook = null;//optional

        /**
         * Mandatory parts are passed over constructure
         */
        public KitapBuilder(String bookId, String bookName, String authorName){
            this.bookId = bookId;
            this.bookName = bookName;
            this.authorName = authorName;
        }

        public KitapBuilder publishYear(Integer publishYear){
            this.publishYear = publishYear;
            return this;
        }

        public KitapBuilder pageSize(Integer pageSize){
            this.pageSize = pageSize;
            return this;
        }

        public KitapBuilder categoryOfBook(String categoryOfBook){
            this.categoryOfBook = categoryOfBook;
            return this;
        }

        public Kitap build(){
            Kitap kitap = new Kitap(this);
            return kitap;
        }
    }
}

