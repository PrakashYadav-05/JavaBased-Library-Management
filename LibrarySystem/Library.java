import java.util.ArrayList;
import java.util.List;
/**
 * Created Library class
 */
public class Library
{
    private List<PrimaryResourse> catalogue; // Assuming a common type for Book, ElectronicResource, etc.
    // Construct an empty library.
    public Library() {
        this.catalogue = new ArrayList<>();
    }
    // Getter and setter methods
    public List<PrimaryResourse> getCatalogue() {
        return catalogue;
    }
    // Method to print all details of the library
    public void printDetails() {
        System.out.println("Library Catalogue Details:");
        for (PrimaryResourse resource : catalogue) {
            if (resource instanceof Book) {
                ((Book) resource).printDetails();
            } else if (resource instanceof ElectronicResource) {
                ((ElectronicResource) resource).printDetails();
            }
        }
        System.out.println("Total Number of Resources: " + catalogue.size());
    }
    // Method to check if the catalogue contains a resource object
    public boolean containsResource(PrimaryResourse resource) {
        return catalogue.contains(resource);
    }
    // Method to simulate editing the author's first name for a resource
    public void editAuthorFirstName(PrimaryResourse resource, String newFirstName) {
        if (catalogue.contains(resource)) {
            if (resource instanceof Book) {
                Author author = ((Book) resource).getAuthor();
                if (author != null) {
                    author.setFirstName(newFirstName);
                    System.out.println("Author's first name updated successfully.");
                } else {
                    System.out.println("Author data field for the resource is null.");
                }
            } else if (resource instanceof ElectronicResource) {
                System.out.println("Editing author details not applicable for electronic resources.");
            }
        } else {
            System.out.println("Resource is not in the catalogue.");
        }
    }
    // Method to search the catalogue by resource title
    public void searchByTitle(String title) {
        int count = 0;
        System.out.println("Search Results for Title '" + title + "':");
        for (Object resource : catalogue) {
            if (resource instanceof Book && ((Book) resource).getTitle().equalsIgnoreCase(title)) {
                ((Book) resource).printDetails();
                count++;
            }
        }
        System.out.println("Total Number of Resources Found: " + count);
    }
    // Method to search the catalogue by author surname
    public void searchByAuthorSurname(String authorSurname) {
        int count = 0;
        System.out.println("Search Results for Author Surname '" + authorSurname + "':");
        for (PrimaryResourse resource : catalogue) {
            if (resource instanceof Book) {
                Author author = ((Book) resource).getAuthor();
                if (author != null && author.getSurname().equalsIgnoreCase(authorSurname)) {
                    ((Book) resource).printDetails();
                    count++;
                }
            }
        }
        System.out.println("Total Number of Resources Found: " + count);
    }
    // Method to remove a resource object from the library catalogue
    public void removeResource(PrimaryResourse resource) {
        if (catalogue.contains(resource)) {
            if (resource instanceof Book) {
                Book book = (Book) resource;
                if (book.getLibraryMember() == null) {
                    catalogue.remove(resource);
                    System.out.println("Resource removed successfully.");
                } else {
                    System.out.println("Cannot remove a book currently on loan.");
                }
            } else if (resource instanceof ElectronicResource) {
                catalogue.remove(resource);
                System.out.println("Resource removed successfully.");
            }
        } else {
            System.out.println("Resource is not in the catalogue.");
        }
    }
    // Method to remove a resource object at a specific position in the library catalogue
    public void removeResourceAtPosition(int position) {
        if (position >= 0 && position < catalogue.size()) {
            PrimaryResourse resource = catalogue.get(position);
            removeResource(resource);
        } else {
            System.out.println("Specified position does not exist in the catalogue.");
        }
    }
    // Method to print details of all available books
    public void printAvailableBooks() {
        System.out.println("Available Books:");
        for (Object resource : catalogue) {
            if (resource instanceof Book) {
                if (((Book) resource).isAvailable()) {
                    ((Book) resource).printDetails();
                }
            }
        }
    }
    // Method to get the number of resource objects in the library catalogue
    public int getNumberOfResources() {
        return catalogue.size();
    }
    // Method to add a resource object to the catalogue
    public void addResource(PrimaryResourse resource) {
        if (!catalogue.contains(resource)) {
            catalogue.add(resource);
            System.out.println("Resource added to the catalogue.");
        } else {
            System.out.println("Resource already exists in the catalogue.");
        }
    }
    // Method to simulate the process of lending a book
    public void lendBook(Book book, LibraryMember libraryMember) {
        if (catalogue.contains(book)) {
            if (book.isAvailable()) {
                book.setLibraryMember(libraryMember);
                libraryMember.borrowBook(book);
                System.out.println("Book lent successfully.");
            } else {
                System.out.println("Book is currently borrowed by another library member.");
            }
        } else {
            System.out.println("Book is not in the catalogue.");
        }
    }
    // Method to simulate the process of accepting a physical book return
    public void acceptBookReturn(Book book, boolean recordDamage, String damageDescription) {
        if (catalogue.contains(book)) {
            book.setLibraryMember(null);
            if (recordDamage) {
                book.addDamage(damageDescription);
                System.out.println("Damage recorded successfully.");
            }
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book is not in the catalogue.");
        }
    }

    // Method to print details of all physical book objects in the catalogue
    public void printPhysicalBooksDetails() {
        System.out.println("Physical Books Details:");
        for (PrimaryResourse resource : catalogue) {
            if (resource instanceof Book) {
                ((Book) resource).printDetails();
            }
        }
    }
    // Method to print details of all electronic resource objects in the catalogue
    public void printElectronicResourcesDetails() {
        System.out.println("Electronic Resources Details:");
        for (PrimaryResourse resource : catalogue) {
            if (resource instanceof ElectronicResource) {
                ((ElectronicResource) resource).printDetails();
            }
        }
    }
    // Main Method for Testing
    public static void main(String[] args) {
        // Create an example library
        Library library = new Library();

        // Create example authors
        Author author1 = new Author("Adam", "Doe", "123 Main St, City");
        Author author2 = new Author("Eric", "Smith", "456 Oak St, Town");

        // Create example books
        Book book1 = new Book("123456789", "Book 1", author1, null);
        Book book2 = new Book("987654321", "Book 2", author2, null);

        // Create example electronic resources
        ElectronicResource electronicResource1 = new ElectronicResource(true,"123456789",new Author("Adam","Doe","123 Main St, City"),new LibraryMember(0));
        ElectronicResource electronicResource2 = new ElectronicResource(false,"987654321",new Author("Eric","Smith","456 Oak St, Town"),new LibraryMember(1));

        // Add resources to the library catalogue
        library.addResource(book1);
        library.addResource(book2);
        library.addResource(electronicResource1);
        library.addResource(electronicResource2);

        // Print details of the library before any changes
        System.out.println("Library Details Before Changes:");
        library.printDetails();

        // Simulate lending a book
        LibraryMember member = new LibraryMember(1);
        library.lendBook(book1, member);

        // Simulate accepting a book return with damage
        library.acceptBookReturn(book1, true, "Torn cover");

        // Print details of the library after changes
        System.out.println("\nLibrary Details After Changes:");
        library.printDetails();
    }
}
