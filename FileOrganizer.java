import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileOrganizer {

    public void organizeFiles(String directoryPath) {

        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory!");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("No files found.");
            return;
        }

        for (File file : files) {

            if (file.isFile()) {

                String folderName = getFolderName(file.getName());

                File destinationFolder = new File(directory, folderName);

                if (!destinationFolder.exists()) {
                    destinationFolder.mkdir();
                }

                File destinationFile = new File(destinationFolder, file.getName());

                try {
                    Files.move(file.toPath(),
                            destinationFile.toPath(),
                            StandardCopyOption.REPLACE_EXISTING);

                    System.out.println("Moved: " + file.getName()
                            + " → " + folderName);

                } catch (IOException e) {
                    System.out.println("Error moving file: " + file.getName());
                }
            }
        }

        System.out.println("\nFile organization completed successfully.");
    }

    private String getFolderName(String fileName) {

        String extension = "";

        int index = fileName.lastIndexOf(".");

        if (index > 0) {
            extension = fileName.substring(index + 1).toLowerCase();
        }

        switch (extension) {

            case "jpg":
            case "jpeg":
            case "png":
            case "gif":
            case "bmp":
                return "Images";

            case "pdf":
            case "doc":
            case "docx":
            case "txt":
            case "ppt":
            case "pptx":
            case "xls":
            case "xlsx":
                return "Documents";

            case "mp4":
            case "mkv":
            case "avi":
            case "mov":
                return "Videos";

            case "mp3":
            case "wav":
            case "aac":
                return "Music";

            case "zip":
            case "rar":
            case "7z":
                return "Archives";

            case "java":
            case "cpp":
            case "c":
            case "py":
            case "html":
            case "css":
            case "js":
                return "Source Code";

            default:
                return "Others";
        }
    }
}
