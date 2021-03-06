import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

public class FileManager {

    public FileManager(String out, File dir) throws IOException {
        if(!dir.exists()) {
            throw new FileNotFoundException("No such directory");
        } else if(!(new File(out).getCanonicalFile().exists())) {
            throw new FileNotFoundException("No such file");
        }
        scanAndWrite(dir, out);

    }


    private static void scanAndWrite(File dir, String output) {

        Logger log = Logger.getLogger(FileManager.class.getName());
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(output,true);
            File directory = dir.getCanonicalFile();
            String[] allFiles = directory.list();

            if (allFiles.length > 0) {
                for (String file : allFiles) {
                    String path = dir + File.separator + file;
                    File currentFile = new File(path).getCanonicalFile();
                    if (currentFile.isDirectory()) {
                        byte[] buffer = (currentFile + "\n").getBytes();
                        fout.write(buffer);
                        scanAndWrite(currentFile.getCanonicalFile(), output);
                    } else if (currentFile.isFile()) {
                        byte[] buffer = (currentFile + "\n").getBytes();
                        fout.write(buffer);
                    }
                }
            } else {
                log.info( dir + " is empty");
            }
        }
        catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        finally {
                try {
                    if (fout != null)
                        fout.close();
                }
                catch (IOException ex){
                    System.out.println(ex.getMessage());
                }
        }
    }


}