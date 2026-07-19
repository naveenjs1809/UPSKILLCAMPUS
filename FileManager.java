import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileManager {

    // Creates a folder if it does not exist
    public File createFolder(String parentPath, String folderName) {

        File folder = new File(parentPath, folderName);

        if (!folder.exists()) {
            if (folder.mkdir()) {
                System.out.println("Folder created: " + folderName);
            } else {
                System.out.println("Failed to create folder: " + folderName);
            }
        }

        return folder;
    }

    // Moves a file to the destination folder
    public void moveFile(File sourceFile, File destinationFolder) {

        try {
            File destinationFile = new File(destinationFolder, sourceFile.getName());

            Files.move(sourceFile.toPath(),
                    destinationFile.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Moved: " + sourceFile.getName()
                    + " → " + destinationFolder.getName());

        } catch (IOException e) {
            System.out.println("Error moving file: " + sourceFile.getName());
            e.printStackTrace();
        }
    }

    // Checks whether a file exists
    public boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    // Displays all files in a directory
    public void listFiles(String directoryPath) {

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory.");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("No files found.");
            return;
        }

        System.out.println("\nFiles in Directory:");

        for (File file : files) {
            System.out.println("- " + file.getName());
        }
    }
}
