import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("Yabancı", 110, "Albert Camus", 1981);
        Book book2 = new Book("Dorian Gray'in Portresi", 258, "Oscar Wilde", 1890 );
        Book book3 = new Book("Dönüşüm", 74, "Franz Kafka", 1915);
        Book book4 = new Book("Yapay Zeka", 175, "Cem Say", 2018);
        Book book5 = new Book("Outliers", 242, "Malcolm Gladwell", 2008);

        //TreeSet booksSortedByName is sorts the books by their names
        TreeSet<Book> booksSortedByName = new TreeSet<>();

        booksSortedByName.add(book1);
        booksSortedByName.add(book2);
        booksSortedByName.add(book3);
        booksSortedByName.add(book4);
        booksSortedByName.add(book5);

        //Print books sorted by name
        System.out.println("\nBooks sorted by name: \n");
        Book.printBooks(booksSortedByName);


        //TreeSet booksSortedByPage is sorts the books by their pages
        TreeSet<Book> booksSortedByPage = new TreeSet<>(new Comparator<Book>() {

            //Compares the added books page numbers
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getNumOfPage() - o2.getNumOfPage();
            }
        });

        booksSortedByPage.add(book1);
        booksSortedByPage.add(book2);
        booksSortedByPage.add(book3);
        booksSortedByPage.add(book4);
        booksSortedByPage.add(book5);

        //Print books sorted by page
        System.out.println("\nBooks sorted by page: \n");
        Book.printBooks(booksSortedByPage);




    }


}