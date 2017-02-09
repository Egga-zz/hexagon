package de.egga;

import com.google.common.collect.ImmutableMap;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static java.nio.file.Files.readAllBytes;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@Ignore
public class TestBase {

    @Autowired
    private TestRestTemplate restTemplate;

    protected String get(String url, String id) {
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class, id);
        return entity.getBody();
    }

    protected String get(String url) {
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        return entity.getBody();
    }

    protected void put(String requestBody, String url, String key1, String value1, String key2, String value2) {
        put(requestBody, url, ImmutableMap.of(key1, value1, key2, value2));

    }
    protected void put(String requestBody, String url, String key, String value) {
        put(requestBody, url, ImmutableMap.of(key, value));
    }

    protected void delete(String url) {
        restTemplate.delete(url);
    }

    protected String fixture(String fileName) {

        Path path = findFile(fileName);

        try {
            return new String(readAllBytes(path));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void put(String requestBody, String url, Map<String, String> params) {
        restTemplate.put(
            url,
            createHttpEntity(requestBody),
            params
        );
    }

    private Path findFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return Paths.get(classLoader.getResource(fileName + ".json").getPath());
    }

    private HttpEntity<String> createHttpEntity(String requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(APPLICATION_JSON);

        return new HttpEntity<>(requestBody, headers);
    }

}
