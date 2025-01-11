
/**
 * A class Author that present with all details
 */
public class Author
{
    private String firstName;
    private String surname;
    private String address;

    // Constructors with all defined parameters
    public Author(String firstName, String surname, String address) {
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
    }

    // Getter and setter methods for all field
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Method to print all details of an author
    public void printDetails() {
        System.out.println("Author: " + firstName + " " + surname);
        System.out.println("Address: " + address);
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create an example author
        Author author = new Author("John", "Doe", "123 Main St, City");

        // Test the functionality
        author.printDetails();

        // Update author details
        author.setAddress("456 Oak St, Town");

        // Print updated details
        author.printDetails();
    }
}

