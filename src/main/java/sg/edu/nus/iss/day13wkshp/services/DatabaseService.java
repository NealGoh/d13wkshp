package sg.edu.nus.iss.day13wkshp.services;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.day13wkshp.models.Contact;

@Service
public class DatabaseService {
    
    private File dataDir = new File("some directory");

    //Getter (Always return something)
    public File getDataDir() {
        return dataDir;
    }
    //Setter (Always returns void)
    public void setDataDir(File dataDir) {
        this.dataDir = dataDir;
    }

    public boolean isDataDirValid() {
        return dataDir.exists() && dataDir.isDirectory() && dataDir.canWrite();
    }

    public boolean save(final Contact contact) {
        File f = new File(this.dataDir, contact.getId());
        try {

            return true;
        } catch (IOException ex) {
            System.err.printf("Error: %s", ex.getMessage());
            //ex.printStackTrace();
            return false;
        }

	}

	public Contact read(String fileId) {
        return null;
	}
}
