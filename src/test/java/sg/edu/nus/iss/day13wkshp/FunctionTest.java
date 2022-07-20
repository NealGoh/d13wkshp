package sg.edu.nus.iss.day13wkshp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import java.util.logging.Logger;
import java.util.logging.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@SpringBootTest
public class FunctionTest {
    private Logger logger = Logger.getLogger(FunctionTest.class.getName());

    private Path workingDir;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void readContact() throws IOException {
        this.workingDir = Path.of("", "/Users/Zerouf/data");
        Path file = this.workingDir.resolve("f25dd596");
        String content = Files.readString(file);
        assertThat(content, is(notNullValue()));
    }

    @Test
    public void saveContact() throws Exception {

        MultiValueMap<String, String> payload = new LinkedMultiValueMap<String, String>();
        payload.add("name", "Darren");
        payload.add("email", "darren@gmail.com");
        payload.add("phone", "12345678");

        logger.log(Level.INFO, "" + objectMapper.writeValueAsString(payload));

    }
    
}
