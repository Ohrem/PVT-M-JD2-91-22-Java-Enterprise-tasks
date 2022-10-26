package ohremchuk.hometask.task9.util;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class ResourceReader {

    public static void main(String[] args) throws Exception {
        ResourceReader.readTextResource();
    }

    public static void readTextResource() throws Exception {
        Path path = Path.of("D:\\java\\apache-tomcat-9.0.65\\webapps\\pure\\WEB-INF\\classes\\file.txt");
        Pattern separator = Pattern.compile("\\t");
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            Stream<String> words = lines.flatMap(separator::splitAsStream);
            words.forEach(System.out::println);
        }
    }
}

