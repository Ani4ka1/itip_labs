import java.util.*;
import java.io.*;

public class WordCounter {
    public static void main(String[] args) throws IOException { //метод может генерировать исключение ввода-вывода,
        File file = new File("textfile.txt");
        Map<String, Integer> wordCounts = new HashMap<String, Integer>(); //используется для хранения слов (в виде строк) и их соответствующего количества вхождений (в виде целых чисел)

        try (BufferedReader br = new BufferedReader(new FileReader(file))) { //для чтения
            String line;
            while ((line = br.readLine()) != null) { //читать пока не закончатся строки
                // Удаление знаков пунктуации и преобразование в нижний регистр, делим слова по пробелам
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) { //не является ли слово пустой строкой
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1); //счетчик
                    }
                }
            }
        }

        // Создание списка из элементов hashmap для сортировки слов по частоте
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCounts.entrySet());
        sortedWords.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Вывод на экран 10 самых частых слов
        for (int i = 0; i < Math.min(10, sortedWords.size()); i++) {
            System.out.println(sortedWords.get(i).getKey() + ": " + sortedWords.get(i).getValue());
        }
    }
}