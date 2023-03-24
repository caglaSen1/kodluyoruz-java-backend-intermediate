import java.util.Comparator;
import java.util.TreeSet;

public class Book implements Comparable<Book> {
    private String name;
    private  int numOfPage;
    private  String authorName;
    private int publicationYear;

    public Book(String name, int numOfPage, String authorName, int publicationDate) {
        setName(name);
        setNumOfPage(numOfPage);
        setAuthorName(authorName);
        setPublicationYear(publicationDate);
    }

    //getName() -- name of the book which ı added to the TreeSet<book>
    //o.getName() -- name of book which is already added
    //Compare the book I recently added and books which are already added
    @Override
    public int compareTo(Book o) {
        return this.getName().compareTo(o.getName());
    }


    public static void printBooks(TreeSet<Book> books){
        for(Book book : books){
            System.out.println("Name: " + book.getName() +
                    "\nPage: " + book.getNumOfPage() +
                    "\nAuthor: " + book.getAuthorName() +
                    "\nPublication Year: " + book.getPublicationYear());
            System.out.println("*************************************");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfPage() {
        return numOfPage;
    }

    public void setNumOfPage(int numOfPage) {
        this.numOfPage = numOfPage;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

}
