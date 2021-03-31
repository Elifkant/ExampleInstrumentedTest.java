package com.zigzag.libraryautomation.crud.listele;

public class KitapView {

    private String bookId;
    private String bookName;
    private String authorName;
    private Integer publishYear;
    private Integer pageSize;
    private String categoryOfBook;

    //Constructor
    public KitapView(String bookId, String bookName, String authorName) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
    }

    /**
     * Getters
     */
    public String getBookId() {
        return bookId;
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

    /**
     * Setters
     */
    public void setPublishYear(Integer publishYear) {
        this.publishYear = publishYear;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setCategoryOfBook(String categoryOfBook) {
        this.categoryOfBook = categoryOfBook;
    }
}
