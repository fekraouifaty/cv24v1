package fr.univrouen.cv24v1.util;

import org.springframework.core.io.Resource;
import org.springframework.core.io.DefaultResourceLoader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
public class Fichier {
	public static String loadFileXML() {
        Resource resource = new DefaultResourceLoader().getResource("classpath:xml/smallCV.xml");
        StringBuilder contentBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
            return contentBuilder.toString();
        } catch (Exception e) {
            return "Erreur lors du chargement du fichier : " + e.getMessage();
        }
    }
}
