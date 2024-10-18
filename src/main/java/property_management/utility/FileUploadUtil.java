package property_management.utility;



import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUploadUtil {

    // Directory where files will be saved
    private static final String UPLOAD_DIR = "uploads/";

    public static String saveFile(MultipartFile file) throws IOException {
        if (file != null && !file.isEmpty()) {
            // Create the upload directory if it doesn't exist
            Files.createDirectories(Paths.get(UPLOAD_DIR));

            // Generate a unique file name using the current timestamp
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

            // Create a File object representing the destination file
            File destinationFile = new File(UPLOAD_DIR + fileName);

            // Transfer the file content to the destination file
            file.transferTo(destinationFile);

            // Return the absolute path of the uploaded file
            return destinationFile.getAbsolutePath();
        }
        return null; // Return null if no file was uploaded
    }
}

