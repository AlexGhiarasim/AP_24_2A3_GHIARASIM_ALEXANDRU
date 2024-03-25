import java.io.File;

class DocumentRepositoryException extends Exception {
    public DocumentRepositoryException(String message) {
        super(message);
    }
}
class DocumentRepository {
    private final File masterDirectory;

    public DocumentRepository(String masterDirectoryPath) throws DocumentRepositoryException {
        this.masterDirectory = new File(masterDirectoryPath);
        if (!this.masterDirectory.exists() || !this.masterDirectory.isDirectory()) {
            throw new DocumentRepositoryException("Master_directory nu exista sau nu este un director specific");
        }
    }

    public void printRepositoryContent() throws DocumentRepositoryException {
        File[] personDirectories = masterDirectory.listFiles(File::isDirectory);
        if (personDirectories == null) {
            throw new DocumentRepositoryException("Eroare la accesarea continutului");
        }
        for (File personDirectory : personDirectories) {
            System.out.println("\n"+personDirectory.getName());
            File[] contents = personDirectory.listFiles();
            if (contents != null) {
                for (File content : contents) {
                    if (content.isDirectory()) {
                        System.out.println("  |-> " + content.getName());
                        File[] subContents = content.listFiles();
                        if (subContents != null) {
                            for (File subContent : subContents) {
                                System.out.println("      |->" + subContent.getName());
                            }
                        }
                    }
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            DocumentRepository repository = new DocumentRepository("C:\\Users\\ghiar\\Desktop\\Lab05\\Compulsory\\src");
            repository.printRepositoryContent();
        } catch (DocumentRepositoryException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}