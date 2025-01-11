
/**
 * A PrimaryResourse class hold collections of data from
 * subclass Book and ElectronicBook
 */
public class PrimaryResourse
{
    // instance variables - replace the example below with your own
    private String title;
    private Author author;
    private LibraryMember libraryMember;
    /**
     * Constructor for objects of class PrimaryResourse
     * @param with defined string and values
     */
    public PrimaryResourse(String title, Author author, LibraryMember member)
    {
        this.title = title;
        this.author = author;
        this.libraryMember =  member;
    }

    /**
     * Accessor and mutator methods for defined field with return value
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public LibraryMember getLibraryMember() {
        return libraryMember;
    }

    public void setLibraryMember(LibraryMember libraryMember) {
        this.libraryMember = libraryMember;
    }
}
