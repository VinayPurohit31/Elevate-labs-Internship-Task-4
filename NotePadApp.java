import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class NotePadApp {

    NotePadMethods npms = new NotePadMethods();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        NotePadApp NPA = new NotePadApp();
        System.out.println("Hello! Welcome to NotePad.");
        NPA.menu();
    }

    public void menu() {
        try {
            while (true) {
                System.out.println("\nPlease select an operation:");
                System.out.println("  1 - Create a new note");
                System.out.println("  2 - Write to a note (overwrites content)");
                System.out.println("  3 - Read a note");
                System.out.println("  4 - Update a note (append to it)");
                System.out.println("  5 - Delete content of a note");
                System.out.println("  6 - Delete a note");
                System.out.println("  7 - Exit");
                System.out.print("Enter your choice: ");

                int selectCase = sc.nextInt();
                sc.nextLine(); 
                System.out.println();

                if (selectCase == 7) {
                    System.out.println("You terminated the session.");
                    break;
                }

                switch (selectCase) {
                    case 1 -> npms.createNote(sc);
                    case 2 -> npms.writeNote(sc);
                    case 3 -> npms.readNote(sc);
                    case 4 -> npms.updateNote(sc);
                    case 5 -> npms.deleteNoteContent(sc);
                    case 6 -> npms.deleteNote(sc);
                    default -> System.out.println("Invalid option. Please enter a number between 1 and 7.");
                }
                System.out.println("--------------------------------------------");
            }
        } catch (Exception e) {
            System.out.println();
            System.out.println("You entered an invalid input. Session terminated.");
            System.out.println();
        } finally {
            sc.close();
        }
    }
}

class NotePadMethods {

    public void createNote(Scanner sc) throws IOException {
        System.out.print("Enter the name for the new note: ");
        String name = sc.nextLine();
        File fileObj = new File(name + ".txt");

        if (fileObj.createNewFile()) {
            System.out.println("A new note has been created with the name: " + name + ".txt");
        } else {
            System.out.println("A note with this name already exists. Try a different name.");
        }
    }

    public void writeNote(Scanner sc) throws IOException {
        System.out.print("Enter the name of the note you want to write into: ");
        String name = sc.nextLine();

        System.out.println("Warning: This will overwrite existing content.");
        System.out.print("Are you sure? (yes/no): ");
        String confirm = sc.nextLine();

        if (!confirm.equalsIgnoreCase("yes")) {
            System.out.println("Operation cancelled.");
            return;
        }

        FileWriter fw = new FileWriter(name + ".txt");
        System.out.print("Write the content to be saved in the note: ");
        String data = sc.nextLine();
        fw.write(data);
        fw.close();
        System.out.println("Content written to the note successfully.");
    }

    public void readNote(Scanner sc) throws IOException {
        System.out.print("Enter the name of the note you want to read: ");
        String name = sc.nextLine();

        File file = new File(name + ".txt");
        if (!file.exists()) {
            System.out.println("Note not found. Make sure the note exists.");
            return;
        }

        FileReader fr = new FileReader(file);
        int i;
        System.out.println("Content of " + name + ".txt:");
        while ((i = fr.read()) != -1) {
            System.out.print((char) i);
        }
        fr.close();
        System.out.println(); 
    }

    public void updateNote(Scanner sc) throws IOException {
        System.out.print("Enter the name of the note you want to update: ");
        String name = sc.nextLine();

        File file = new File(name + ".txt");
        if (!file.exists()) {
            System.out.println("Note not found. Make sure the note exists.");
            return;
        }

        FileWriter fw = new FileWriter(name + ".txt", true);
        System.out.print("Enter the content to append to the note: ");
        String data = sc.nextLine();
        fw.write("\n" + data);
        fw.close();
        System.out.println("Note updated successfully.");
    }

    public void deleteNoteContent(Scanner sc) throws IOException {
        System.out.print("Enter the name of the note whose content you want to delete: ");
        String name = sc.nextLine();

        File file = new File(name + ".txt");
        if (!file.exists()) {
            System.out.println("Note not found. Make sure the note exists.");
            return;
        }

        FileWriter fw = new FileWriter(name + ".txt", false);
        fw.write(""); 
        fw.close();
        System.out.println("The content of the note has been deleted successfully.");
    }

    public void deleteNote(Scanner sc) throws IOException {
        System.out.print("Enter the name of the note you want to delete: ");
        String name = sc.nextLine();
        File fileObj = new File(name + ".txt");

        if (!fileObj.exists()) {
            System.out.println("The note does not exist.");
            return;
        }

        if (fileObj.delete()) {
            System.out.println("The note has been deleted successfully.");
        } else {
            System.out.println("Failed to delete the note.");
        }
    }
}
