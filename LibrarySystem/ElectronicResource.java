
/**
 * A ElectronicResource class created
 * Inheritance method used
 */
public class ElectronicResource extends PrimaryResourse
{
    private boolean canDownload;
  // Constructors
  public ElectronicResource(boolean canDownload, String title, Author author, LibraryMember member) {
    super(title, author, member);
    this.canDownload = canDownload;
  }
  // Getter and setter methods used with no parameter
  public boolean isCanDownload() {
    return canDownload;
  }
  public void setCanDownload(boolean canDownload) {
    this.canDownload = canDownload;
  }
  // Method to print all details of an electronic resource
  public void printDetails() {
    System.out.println("Can Download: " + canDownload + "\n"+
    "Title : " + this.getTitle() +"\n" + "Author : " + this.getAuthor().toString() + "\n" + "LibraryMember : " + this.getLibraryMember().toString());
    // Print other details as needed
  }
  // main method for testing purpose
   public static void main(String[] args) {
    // Create an example electronic resource
        ElectronicResource electronicResource = new ElectronicResource(true,"JavaBook",new Author("John","D'mello","Glasgiow"),new LibraryMember(1));

        // Print details of the electronic resource before any changes
        System.out.println("Electronic Resource Details Before Changes:");
        electronicResource.printDetails();

        // Update electronic resource details
        electronicResource.setCanDownload(false);

        // Print details of the electronic resource after changes
        System.out.println("\nElectronic Resource Details After Changes:");
        electronicResource.printDetails();
  }
}
