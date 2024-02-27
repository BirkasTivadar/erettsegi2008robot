package robot;

import org.apache.commons.lang3.ArrayUtils;

import java.util.List;
import java.util.stream.IntStream;

public class Program {

    private String directories;

    private int x = 0;

    private int y = 0;

    private int lepes = 0;

    private int maxLepes = 0;
    private double maxTavolsag = 0;

    private int fogyasztas = 3;

    public Program(String directories) {
        this.directories = directories;
        setArguments();
    }

    public int getFogyasztas() {
        return fogyasztas;
    }

    public String printEgyszerusitheto() {
        boolean egyszerusitheto = egyszerusitheto();
        return String.format("A program %s", egyszerusitheto ? "egyszerűsíthető." : "nem egyszerűsíthető.");
    }


    public String printVisszajuttatas() {
        return String.format("%d lépést kell tenni az ED, %d lépést a KN tengely mentén.", Math.abs(y), Math.abs(x));
    }

    public String legmesszebb() {
        return String.format("A robot a %d lépésnél volt a legmesszebb, a távolság %.3f volt", maxLepes, maxTavolsag);
    }

    public String visszaTranszformalo(String egyszerusitett) {
        StringBuilder result = new StringBuilder();
        int size = egyszerusitett.length();
        IntStream.range(0, size)
                .forEach(i -> {
                    if (Character.isDigit(egyszerusitett.charAt(i))) {
                        result.append(String.valueOf(egyszerusitett.charAt(i + 1)).repeat(egyszerusitett.charAt(i) - 49));
                    } else {
                        result.append(egyszerusitett.charAt(i));
                    }
                });
        return result.toString();
    }

    public String egyszerusito() {
        String munkapeldany = directories + "Q";
        StringBuilder result = new StringBuilder();
        char[] dir = munkapeldany.toCharArray();
        int size = munkapeldany.length();
        Character tobb = null;
        int counter = 1;

        for (int i = 1; i < size; i++) {
            if (dir[i] != dir[i - 1]) {
                if (counter != 1) {
                    result.append(counter).append(tobb);
                    counter = 1;
                } else {
                    result.append(dir[i - 1]);
                }
            } else {
                tobb = dir[i];
                counter++;
            }
        }
        return result.toString();
    }

    private void setArguments() {
        List.of(ArrayUtils.toObject(directories.toCharArray()))
                .forEach(c ->
                {
                    setXY(c);
                    double tavolsag = Math.sqrt(x * x + y * y);
                    if (maxTavolsag < tavolsag) {
                        maxTavolsag = tavolsag;
                        maxLepes = lepes;
                    }
                });
        fogyasztas();
    }


    private void setXY(Character c) {
        if (c == 'E') y++;
        if (c == 'D') y--;
        if (c == 'K') x++;
        if (c == 'N') x--;
        lepes++;
    }

    private void fogyasztas() {
        int size = directories.length();
        IntStream.range(1, size)
                .forEach(i -> {
                    fogyasztas++;
                    if (directories.charAt(i) == directories.charAt(i - 1)) fogyasztas += 2;

                });
    }

    private boolean egyszerusitheto() {
        return directories.contains("DE")
                || directories.contains("ED")
                || directories.contains("KN")
                || directories.contains("NK");
    }


}
