import java.io.*;

class Book {

    public String title = "";
    public String lastName = "";

    public Book(String title, String lastName) {
        this.title = title;
        this.lastName = lastName;
    }

    void print() {
        System.out.print(this.title + " " + this.lastName + " ");
    }
}