package robot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Robot {

    int size = 0;
    private final List<Program> programList = new ArrayList<>();

    public List<Program> getProgramList() {
        return Collections.unmodifiableList(programList);
    }

    public void loadFromFile(Path path) {
        String line;
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            size = Integer.parseInt(bufferedReader.readLine());
            while ((line = bufferedReader.readLine()) != null) {
                programList.add(new Program(line));
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }
    }

    public void writeToFile(Path path) {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
            for (Program program : programList) {
                bufferedWriter.write(program.egyszerusito().concat(System.lineSeparator()));
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not write file", ioException);
        }
    }

    private Map<Integer, Integer> kisfogyasztasuProgramok() {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < size; i++) {
            int fogyasztas = programList.get(i).getFogyasztas();
            if (fogyasztas <= 100) result.put(i + 1, fogyasztas);
        }
        return result;
    }

    public void printKisfogyasztasuak() {
        Map<Integer, Integer> kisfogyasztasuak = kisfogyasztasuProgramok();
        kisfogyasztasuak.keySet()
                .forEach(k -> System.out.printf("%d %d\n", k, kisfogyasztasuak.get(k)));
    }
}
