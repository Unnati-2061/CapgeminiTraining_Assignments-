package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class WordCounter {

    @Autowired
    private FIleListProvider fileListProvider;

    public Map<String, Integer> wordCount() {
        Map<String, Integer> map = new HashMap<>();
        List<File> files = fileListProvider.getFileJava();
        for (File file : files) {
            int count = 0;
            try {
                BufferedReader br =
                        new BufferedReader(
                                new InputStreamReader(
                                        new FileInputStream(file)));
                String line;
                while ((line = br.readLine()) != null) {
                    String[] words = line.split("[\\s.;()]+");
                    for (String word : words) {
                        if (word.equals("System")) {
                            count++;
                        }
                    }
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (count != 0) {
                map.put(file.getName(), count);
            }
        }

        return map;
    }
}

// System System System
// System System System
// System System System