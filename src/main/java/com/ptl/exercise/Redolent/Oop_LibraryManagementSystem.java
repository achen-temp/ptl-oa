package com.ptl.exercise.redolent;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Oop_LibraryManagementSystem {

}

interface IBook {
    void setId(int id);

    int getId();

    void setTitle(String title);

    String getTitle();

    void setAuthor(String author);

    String getAuthor();

    void setCategory(String category);

    String getCategory();

    void setPrice(int price);

    int getPrice();
}

interface ILibrarySystem {
    void addBook(IBook book, int quantity);

    void removeBook(IBook book, int quantity);

    int calculateTotal();

    Map<String, Integer> categoryTotalPrice();

    List<BooksInfo> booksInfo();

    List<CategoryAuthorWithCount> categoryAndAuthorWithCount();
}

// Book class implementing IBook
class Book implements IBook {
    private int id;
    private String title;
    private String author;
    private String category;
    private int price;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

class BooksInfo {
    String title;
    int quantity;
    int price;

    BooksInfo(String title, int quantity, int price) {
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }
}

class CategoryAuthorWithCount {
    String category;
    String author;
    int count;

    CategoryAuthorWithCount(String category, String author, int count) {
        this.category = category;
        this.author = author;
        this.count = count;
    }
}

// LibrarySystem class implementing ILibrarySystem
class LibrarySystem implements ILibrarySystem {
    private Map<IBook, Integer> bookMap = new HashMap<>();

    public void addBook(IBook book, int quantity) {
        bookMap.put(book, bookMap.getOrDefault(book, 0) + quantity);
    }

    public void removeBook(IBook book, int quantity) {
        int current = bookMap.getOrDefault(book, 0) - quantity;
        if (current > 0)
            bookMap.put(book, current);
        else
            bookMap.remove(book);
    }

    public int calculateTotal() {
        return bookMap.entrySet().stream()
                .mapToInt(e -> e.getKey().getPrice() * e.getValue())
                .sum();
    }

    public Map<String, Integer> categoryTotalPrice() {
        return bookMap.entrySet().stream()
                .collect(Collectors.groupingBy(
                        e -> e.getKey().getCategory(),
                        Collectors.summingInt(e -> e.getKey().getPrice() * e.getValue())))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new // sorting in price decreasing
                ));
    }

    public List<BooksInfo> booksInfo() {
        return bookMap.entrySet().stream()
                .map(e -> new BooksInfo(e.getKey().getTitle(), e.getValue(), e.getKey().getPrice()))
                .sorted(Comparator.comparing((BooksInfo b) -> b.title)
                        .thenComparingInt(b -> b.quantity))
                .collect(Collectors.toList());
    }

    public List<CategoryAuthorWithCount> categoryAndAuthorWithCount() {
        return bookMap.entrySet().stream()
                .collect(Collectors.groupingBy(
                        e -> e.getKey().getCategory() + "::" + e.getKey().getAuthor(),
                        Collectors.summingInt(Map.Entry::getValue)))
                .entrySet().stream()
                .map(e -> {
                    String[] parts = e.getKey().split("::");
                    return new CategoryAuthorWithCount(parts[0], parts[1], e.getValue());
                })
                .sorted(Comparator.comparing((CategoryAuthorWithCount c) -> c.category)
                        .thenComparing(c -> c.author))
                .collect(Collectors.toList());
    }
}
