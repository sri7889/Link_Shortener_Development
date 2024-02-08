import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkShortener linkShortener = new LinkShortener();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Shorten URL");
            System.out.println("2. Expand URL");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the long URL: ");
                    String longURL = scanner.nextLine();
                    String shortURL = linkShortener.shortenURL(longURL);
                    System.out.println("Shortened URL: " + shortURL);
                    break;
                case 2:
                    System.out.print("Enter the short URL: ");
                    String inputShortURL = scanner.nextLine();
                    String expandedURL = linkShortener.expandURL(inputShortURL);
                    System.out.println("Expanded URL: " + expandedURL);
                    break;
                case 3:
                    System.out.println("Exiting the Link Shortener. Goodbye!\n------------------");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}
