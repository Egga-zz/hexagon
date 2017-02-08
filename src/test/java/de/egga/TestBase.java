package de.egga;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.readAllBytes;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class TestBase {

    @Autowired
    private TestRestTemplate restTemplate;

    protected String get(String url) {
        TestRestTemplate restTemplate = this.restTemplate;
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        return entity.getBody();
    }

    protected String fixture(String fileName) {

        Path path = findFile(fileName);

        try {
            return new String(readAllBytes(path));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected JsonAssertion assertThat(String actual) {
        return new JsonAssertion(actual);
    }


    private Path findFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return Paths.get(classLoader.getResource(fileName + ".json").getPath());
    }

}
