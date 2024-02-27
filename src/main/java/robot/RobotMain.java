package robot;

import java.nio.file.Path;
import java.util.Scanner;

public class RobotMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Robot robot = new Robot();

//        1. Olvassa be a program.txt állományban talált adatokat, s azok felhasználásával oldja
//        meg a következő feladatokat! Ha az állományt nem tudja beolvasni, az állomány első 10
//        sorának adatait jegyezze be a programba és dolgozzon azzal!

        System.out.println("1. feladat".concat(System.lineSeparator()));

        robot.loadFromFile(Path.of("src", "main", "resources", "program.txt"));

//        2. Kérje be egy utasítássor számát, majd írja a képernyőre, hogy:

        System.out.println("2. feladat:\n" +
                "Kérem az utasítássor sorszámát!");
        int sorszam = scanner.nextInt();
        scanner.nextLine();

        Program program = robot.getProgramList().get(sorszam - 1);

//        a. Egyszerűsíthető-e az utasítássorozat! Az egyszerűsíthető, illetve nem egyszerűsíthető választ írja a képernyőre! (Egy utasítássort egyszerűsíthetőnek nevezünk, ha
//        van benne két szomszédos, ellentétes irányt kifejező utasításpár, hiszen ezek a párok
//        elhagyhatók. Ilyen ellentétes utasításpár az ED, DE, KN, NK.)

        System.out.println("2/a. Egyszerűsíthető-e az utasítássorozat!");
        System.out.println(program.printEgyszerusitheto().concat(System.lineSeparator()));

//        b. Az utasítássor végrehajtását követően legkevesebb mennyi E vagy D és K vagy N utasítással lehetne a robotot a kiindulási pontba visszajuttatni! A választ a következő
//        formában jelenítse meg: 3 lépést kell tenni az ED, 4 lépést a KN tengely
//        mentén.

        System.out.println("2/b. Hány utasítással lehet visszajuttatni a kiindulási pontba?");
        System.out.println(program.printVisszajuttatas().concat(System.lineSeparator()));


//        c. Annak végrehajtása során hányadik lépést követően került (légvonalban) legtávolabb a
//        robot a kiindulási ponttól és mekkora volt ez a távolság! A távolságot a lépés sorszámát követően 3 tizedes pontossággal írja a képernyőre!

        System.out.println("2/c. Hányadik lépésnél került legmesszebbre a robot, és milyen messze volt akkor.");
        System.out.println(program.legmesszebb().concat(System.lineSeparator()));


//        3. A robot a mozgáshoz szükséges energiát egy beépített akkuból nyeri. A robot
//        1 centiméternyi távolság megtételéhez 1 egység, az irányváltásokhoz és az induláshoz
//        2 egység energiát használ. Ennek alapján az EKK utasítássor végrehajtásához 7 egység
//        energia szükséges. A szakkörön használt teljesen feltöltött kis kapacitású akkuból 100, a
//        nagykapacitásúból 1000 egységnyi energia nyerhető ki. Adja meg azon utasítássorokat,
//        amelyek végrehajtásához a teljesen feltöltött kis kapacitású akku is elegendő! Írja a képernyőre egymástól szóközzel elválasztva az utasítássor sorszámát és a szükséges energia
//        mennyiségét! Minden érintett utasítássor külön sorba kerüljön!

        System.out.println("3. feladat Kisfogyasztású programok:".concat(System.lineSeparator()));
        robot.printKisfogyasztasuak();

//        4. Gáborék továbbfejlesztették az utasításokat értelmező programot. Az új, jelenleg még
//        tesztelés alatt álló változatban a több, változatlan irányban tett elmozdulást helyettesítjük
//        az adott irányban tett elmozdulások számával és az irány betűjével. Tehát például a
//        DDDKDD utasítássor leírható rövidített 3DK2D formában is. Az önállóan álló utasításnál
//        az 1-es számot nem szabad kiírni! Hozza létre az ujprog.txt állományt, amely a
//        program.txt állományban foglalt utasítássorozatokat az új formára alakítja úgy, hogy
//        az egymást követő azonos utasításokat minden esetben a rövidített alakra cseréli! Az
//        ujprog.txt állományba soronként egy utasítássor kerüljön, a sorok ne tartalmazzanak
//        szóközt!

        System.out.println("4. feladat Utasítássor egyszerűsítése, fájlba írása".concat(System.lineSeparator()));
        robot.writeToFile(Path.of("src", "main", "resources", "ujprog.txt"));


//        5. Sajnos a tesztek rámutattak arra, hogy a program új verziója még nem tökéletes, ezért vissza kell térni az utasítássorok leírásának régebbi változatához.
//        Mivel a szakkörösök nagyon bíztak az új változatban, ezért néhány utasítássort már csak ennek megfelelően készítettek el.
//        Segítsen ezeket visszaírni az eredeti formára! Az ismétlődések száma legfeljebb 200 lehet!
//        Kérjen be egy új formátumú utasítássort, majd írja a képernyőre régi formában!

        System.out.println("5. feladat Egyszerűsített utasítássor visszatranszformálása eredetibe");

        System.out.println("Kérek egy egyszerűsített formátumú utasítássort:");

        String utasitasSor = scanner.nextLine();
        System.out.println(program.visszaTranszformalo(utasitasSor));
    }
}