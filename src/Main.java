import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Warrior you = new Warrior("You");
    private static Warrior enemy = new Warrior("Enemy");

    public static void main(String[] args) {

        System.out.println("Bine ati venit intr-o lume demult apusa, unde regatele infloritoare, vitejia si magia inca nu au disparut!" +
                "\nPentru a putea descoperi acest taram, mai intai va trebui sa-ti configurezi personajul tau.");
        System.out.println("\nApasa tasta Enter pentru a continua");
        scanner.nextLine();
        System.out.println("Cum te numesti?");
        String name = scanner.nextLine();
        you.setName(name);
        System.out.println();
        System.out.println(you.getName() + ", ce clasa de luptator doresti sa fii?\n\nApasa:" +
                "\n1 - pentru a deveni un CAVALER puternic" +
                "\n\t-> Cavalerul este foarte eficient cand lupta cu sabia, este descurcaret si in folosirea magiei, insa este mai putin eficient cand foloseste arcul." +
                "\n\t-> Cavalerul poate fi rezistent la atacul cu sabia, insa viata este moderat afectata de magie si puternic afectata de ploaia de sageti." +
                "\n2 - pentru a deveni un HAIDUC curajos" +
                "\n\t-> Haiducul este foarte eficient cand lanseaza o ploaie de sageti, insa nu se descurca foarte bine cand lupta cu sabia si este un novice al magiei." +
                "\n\t-> Sagetile nu-l afecteaza foarte mult pe haiduc. Reuseste sa faca fata binisor si atacurilor cu sabia. Slabiciunea sa cea mare este magia." +
                "\n3 - pentru a deveni un VRAJITOR iscusit" +
                "\n\t-> Vrajitorul este un maestru al manipularii magiei. Foloseste binisor si arcul, insa sabia nu este punctul sau forte." +
                "\n\t-> Cu toate ca rezistacu indarjire atacurilor vrajitoresti, vrajitorul este afectat de sagetile trase cu arcul, iar sabia ii provoaca cele mai grave leziuni." +
                "\n\n Nota: Fiecare atac are anumite marje de succes in functie de tipul atacului, de clasa caracterului tau si de clasa adversarului." +
                "\n      Apasa tasta 0 pentru a vedea gradul de eficienta a fiecarui atac in functie de clasa personajului tau, de cea a adversarului, si de tipul atacului folosit.");
//        int option = scanner.nextInt();
//        scanner.nextLine();
        boolean menu = false;
        while(!menu) {
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    printDetails();
                    System.out.println("\n Prin urmare, apasa:" +
                            "\n1 - ca sa devii CAVALER;" +
                            "\n2 - ca sa devii HAIDUC;" +
                            "\n3 - ca sa devii VRAJITOR.");

                    break;
                case 1:
                    System.out.println("Ai ales sa fii cavaler");
                    you.setKnight(true);
                    menu = true;
                    break;
                case 2:
                    System.out.println("Ai ales sa fii haiduc!");
                    you.setThief(true);
                    menu = true;
                    break;
                case 3:
                    System.out.println("Ai ales sa fii vrajitor!");
                    you.setMage(true);
                    menu = true;
                    break;
                default:
                    break;
            }
        }

        System.out.println("Apasa tasta Enter pentru a continua.");
        scanner.nextLine();


        int random = (int) (Math.random() * 3);
        switch (random) {
            case 0:
                enemy.setName("Ion Voda din Carpati");
                enemy.setKnight(true);
                break;
            case 1:
                enemy.setName("Vasile Dobrogeanu'");
                enemy.setThief(true);
                break;
            case 2:
                enemy.setName("Constantin Cartoforul");
                enemy.setMage(true);
                break;
        }

        System.out.println(you.getName() + ", " + you.returnRace() + " neinfricat, incepe aventura ta pe aceste taramuri." +
                "\nBogatia si grandoarea acestui nou tinut sunt umbrite de tristetea rapirii Printesei Bubulina de catre " + enemy.getName() + ", un " + enemy.returnRace() + " vestit prin aceste meleaguri." +
                "\nViteaz si darnic din fire, la auzirea acestei vesti ai decis sa pleci in cautarea Printesei.");

        System.out.println("\nApasa tasta Enter pentru a-ti continua aventura.");
        scanner.nextLine();

        System.out.println("Dupa o calatorie lunga ai ajuns la Turnul de piatra al Chindiei, in varful caruia Printesa Bubulina este tinuta prizoniera de " + enemy.getName() + "." +
                "\nDin fericire inamicul inca nu te-a zarit, asa ca poti face prima miscare. Ce alegi sa faci?");
        printOptions();

        boolean quit = false;
        while ((!quit)/*||(you.getLife()<=0)||(enemy.getLife()<=0)*/) {
            int choose = scanner.nextInt();
            switch (choose) {
                case 0:
                    System.out.println("Ai fugit din fata provocarii cu onoarea patata.\nLa auzul vestii, Imparatul te-a alungat din imparatia sa. " +
                            "Vei fi nevoit sa traiesti tot restul vietii cu aceasta rusine.\nGAME OVER");
                    quit = true;
                    break;
                case 1:
                    int initialDamage = you.swordAttack();
                    if (enemy.isKnight()) {
                        int efficiency = (int) (Math.random() * 40) + 1; //generarea unui nr intreg intre 1 si 40;
                        double percentage = ((double) efficiency) / 100d;
                        double totalDamage = initialDamage - percentage * initialDamage;
//                        System.out.println(totalDamage);
//                        System.out.println((int)totalDamage);
                        enemy.setLife((int) totalDamage);
                        System.out.println("Vitejia ta s-a vazut in manuirea sabiei. Viata lui " + enemy.getName() + " a scazut cu " + (int) totalDamage + " de puncte.");
                        if (enemy.getLife() > 0) {
                            enemyAttack();
                        }
                        printStats();
                    }
                    if (enemy.isThief()) {
                        int efficiency = (int) (Math.random() * 25) + 1;
                        double percentage = ((double) efficiency) / 100d;
                        double totalDamage = initialDamage - percentage * initialDamage;
                        enemy.setLife((int) totalDamage);
                        System.out.println("Vitejia ta s-a vazut in manuirea sabiei. Viata lui " + enemy.getName() + " a scazut cu " + (int) totalDamage + " de puncte.");
                        if (enemy.getLife() > 0) {
                            enemyAttack();
                        }
                        printStats();
                    }
                    if (enemy.isMage()) {
                        int efficiency = (int) (Math.random() * 10) + 1;
                        double percentage = ((double) efficiency) / 100d;
                        double totalDamage = initialDamage - percentage * initialDamage;
                        enemy.setLife((int) totalDamage);
                        System.out.println("Vitejia ta s-a vazut in manuirea sabiei. Viata lui " + enemy.getName() + " a scazut cu " + (int) totalDamage + " de puncte.");
                        if (enemy.getLife() > 0) {
                            enemyAttack();
                        }
                        printStats();
                    }
                    break;
                case 2:
                    int initialStealthDamage = you.stealthAttack();
                    if (enemy.isKnight()) {
                        int efficiency = (int) (Math.random() * 10) + 1;
                        double percentage = ((double) efficiency) / 100d;
                        double totalDamage = initialStealthDamage - percentage * initialStealthDamage;
                        enemy.setLife((int) totalDamage);
                        System.out.println("Sagetile propulsate cu toata forta ta i-au furat lui " + enemy.getName() + "" + (int) totalDamage + " de puncte din viata.");
                        if (enemy.getLife() > 0) {
                            enemyAttack();
                        }
                        printStats();
                    }
                    if (enemy.isThief()) {
                        int efficiency = (int) (Math.random() * 40) + 1;
                        double percentage = ((double) efficiency) / 100d;
                        double totalDamage = initialStealthDamage - percentage * initialStealthDamage;
                        enemy.setLife((int) totalDamage);
                        System.out.println("Sagetile propulsate cu toata forta ta i-au furat lui " + enemy.getName() + " " + (int) totalDamage + " de puncte din viata.");
                        if (enemy.getLife() > 0) {
                            enemyAttack();
                        }
                        printStats();
                    }
                    if (enemy.isMage()) {
                        int efficiency = (int) (Math.random() * 25) + 1;
                        double percentage = ((double) efficiency) / 100d;
                        double totalDamage = initialStealthDamage - percentage * initialStealthDamage;
                        enemy.setLife((int) totalDamage);
                        System.out.println("Sagetile propulsate cu toata forta ta i-au furat lui " + enemy.getName() + " " + (int) totalDamage + " de puncte din viata.");
                        if (enemy.getLife() > 0) {
                            enemyAttack();
                        }
                        printStats();
                    }
                    break;
                case 3:
                    int initialSpellDamage = you.spellAttack();
                    if (enemy.isKnight()) {
                        int efficiency = (int) (Math.random() * 25) + 1;
                        double percentage = ((double) efficiency) / 100d;
                        double totalDamage = initialSpellDamage - percentage * initialSpellDamage;
                        enemy.setLife((int) totalDamage);
                        System.out.println("Magia ta s-a napustit asupra lui " + enemy.getName() + " sub forma unei tornade inflacarate care i-a scazut viata cu " + (int) totalDamage + " de puncte.");
                        if (enemy.getLife() > 0) {
                            enemyAttack();
                        }
                        printStats();
                    }
                    if (enemy.isThief()) {
                        int efficiency = (int) (Math.random() * 10) + 1;
                        double percentage = ((double) efficiency) / 100d;
                        double totalDamage = initialSpellDamage - percentage * initialSpellDamage;
                        enemy.setLife((int) totalDamage);
                        System.out.println("Magia ta s-a napustit asupra lui " + enemy.getName() + " sub forma unei tornade inflacarate care i-a scazut viata cu " + (int) totalDamage + " de puncte.");
                        if (enemy.getLife() > 0) {
                            enemyAttack();
                        }
                        printStats();
                    }
                    if (enemy.isMage()) {
                        int efficiency = (int) (Math.random() * 40) + 1;
                        double percentage = ((double) efficiency) / 100d;
                        double totalDamage = initialSpellDamage - percentage * initialSpellDamage;
                        enemy.setLife((int) totalDamage);
                        System.out.println("Magia ta s-a napustit asupra lui " + enemy.getName() + " sub forma unei tornade inflacarate care i-a scazut viata cu " + (int) totalDamage + " de puncte.");
                        if (enemy.getLife() > 0) {
                            enemyAttack();
                        }
                        printStats();
                    }
                    break;
                case 4:
                    int firstLife = you.getLife();
                    if (you.drinkPotion()) {
                        int secondLife = you.getLife();
                        System.out.println("Ai sorbit din licoarea de insanatosire si viata ti-a crescut cu " + (secondLife - firstLife) + " puncte.");
                        enemyAttack();
                        printStats();
                    } else {
                        System.out.println("Ai ramas fara licori.");
                    }
                    break;
                case 5:
                    printOptions();
                    break;
                case 6:
                    printDetails();
                    break;


            }

            if (enemy.getLife() <= 0) {
                System.out.println("Felicitari! Ai reusit sa-l invingi pe " + enemy.getName() + " si sa o salvezi pe printesa." +
                        "\nDrept recompensa, Imparatul ti-a dat mana Printesei si o avere insemnata. Iti vei trai viata cu demnitate si onoare!" +
                        "\nGAME OVER");
                quit = true;

            }
            if (you.getLife() <= 0) {
                System.out.println("Din pacate nu ai fost suficient de abil pentru a-l invinge pe " + enemy.getName() + " si pentru a o salva pe Printesa." +
                        "\nVei fi dat uitarii.\nGAME OVER");
                quit = true;
            }
        }

        scanner.nextLine();
        System.out.println("\nApasa orice tasta pentru a iesi din joc.");
        scanner.nextLine();
    }

    public static void printOptions() {
        System.out.println("\nIn lupta cu " + enemy.getName() + " poti apasa tasta:" +
                "\n0 - pentru a fugi de confruntarea cu oponentul;" +
                "\n1 - pentru a lansa un atac cu sabia;" +
                "\n2 - pentru a arunca o ploaie de sageti asupra adversarului;" +
                "\n3 - pentru a folosi atacul magic;" +
                "\n4 - pentru a sorbi din licoarea magica de insanatosire (viata iti va creste cu 50 pct, insa ai doar trei licori);" +
                "\n5 - pentru a afisa aceasta lista de optiuni in caz de nevoie;" +
                "\n6 - pentru a afisa tabelul detaliat privind eficienta fiecarui atac.");
    }


    public static void printDetails() {
        System.out.println("    ~ EFICIENTA ATACURILOR ~\n" +
                "\nPe prima linie se afla personajul care lanseaza atacul, iar in prima coloana se regaseste personajul care incaseaza atacul. " +
                "\n" +
                "\n_____________________________________________________________________________________" +
                "\n|        ||        CAVALER        ||         HAIDUC        ||        VRAJITOR       | " +
                "\n-------------------------------------------------------------------------------------" +
                "\n|        || Sabie |  Arc  | Magie || Sabie |  Arc  | Magie || Sabie |  Arc  | Magie |" +
                "\n-------------------------------------------------------------------------------------" +
                "\n|CAVALER || 29-18 | 17-16 | 23-18 || 23-14 | 29-27 | 17-13 || 17-10 | 23-21 | 29-22 |" +
                "\n-------------------------------------------------------------------------------------" +
                "\n|HAIDUC  || 29-22 | 17-11 | 23-21 || 23-18 | 29-18 | 17-16 || 17-13 | 23-14 | 29-27 |" +
                "\n-------------------------------------------------------------------------------------" +
                "\n|VRAJITOR|| 29-27 | 17-13 | 23-16 || 23-21 | 29-22 | 17-10 || 17-16 | 23-18 | 29-18 |" +
                "\n-------------------------------------------------------------------------------------");
    }


    public static void printStats() {
        if ((you.getLife() > 0) && (enemy.getLife() > 0)) {
            System.out.println();
            System.out.println(you.getName() + ", mai ai " + you.getLife() + " puncte de viata.");
            System.out.println(enemy.getName() + " mai are " + enemy.getLife() + " puncte de viata.");
        }
    }


    public static void enemyAttack() {
        int randomOption = (int) (Math.random() * 4) + 1;

        switch (randomOption) {
            case 1:
                if ((enemy.getLife() <= 40) && (enemy.drinkPotion())) {
                    System.out.println(enemy.getName() + " a sorbit din licoarea de insanatosire, iar viata i-a crescut cu 50 de puncte.");
                    break;
                }

                int initialSwordDamage = enemy.swordAttack();
                if (you.isKnight()) {
                    int efficiency = (int) (Math.random() * 10) + 1;
                    double percentage = ((double) efficiency) / 100d;
                    double totalDamage = initialSwordDamage - percentage * initialSwordDamage;
                    you.setLife((int) totalDamage);
                    System.out.println(enemy.getName() + " a ripostat cu o lovitura de sabie care ti-a scazut viata cu " + (int) totalDamage + " de puncte.");

                }
                if (you.isThief()) {
                    int efficiency = (int) (Math.random() * 40) + 1;
                    double percentage = ((double) efficiency) / 100d;
                    double totalDamage = initialSwordDamage - percentage * initialSwordDamage;
                    you.setLife((int) totalDamage);
                    System.out.println(enemy.getName() + " a ripostat cu o lovitura de sabie care ti-a scazut viata cu " + (int) totalDamage + " de puncte.");

                }
                if (you.isMage()) {
                    int efficiency = (int) (Math.random() * 25) + 1;
                    double percentage = ((double) efficiency) / 100d;
                    double totalDamage = initialSwordDamage - percentage * initialSwordDamage;
                    you.setLife((int) totalDamage);
                    System.out.println(enemy.getName() + " a ripostat cu o lovitura de sabie care ti-a scazut viata cu " + (int) totalDamage + " de puncte.");
                }

                break;
            case 2:
                if ((enemy.getLife() <= 40) && (enemy.drinkPotion())) {
                    System.out.println(enemy.getName() + " a sorbit din licoarea de insanatosire, iar viata i-a crescut cu 50 de puncte.");
                    break;
                }

                int initialStealthDamage = enemy.stealthAttack();
                if (you.isKnight()) {
                    int efficiency = (int) (Math.random() * 10) + 1;
                    double percentage = ((double) efficiency) / 100d;
                    double totalDamage = initialStealthDamage - percentage * initialStealthDamage;
                    you.setLife((int) totalDamage);
                    System.out.println(enemy.getName() + " a trimis o ploaie de sageti care ti-a scazut viata cu " + (int) totalDamage + " de puncte.");
                }
                if (you.isThief()) {
                    int efficiency = (int) (Math.random() * 40) + 1;
                    double percentage = ((double) efficiency) / 100d;
                    double totalDamage = initialStealthDamage - percentage * initialStealthDamage;
                    you.setLife((int) totalDamage);
                    System.out.println(enemy.getName() + " a trimis o ploaie de sageti care ti-a scazut viata cu " + (int) totalDamage + " de puncte.");

                }
                if (you.isMage()) {
                    int efficiency = (int) (Math.random() * 25) + 1;
                    double percentage = ((double) efficiency) / 100d;
                    double totalDamage = initialStealthDamage - percentage * initialStealthDamage;
                    you.setLife((int) totalDamage);
                    System.out.println(enemy.getName() + " a trimis o ploaie de sageti care ti-a scazut viata cu " + (int) totalDamage + " de puncte.");

                }
                break;
            case 3:
                if ((enemy.getLife() <= 40) && (enemy.drinkPotion())) {
                    System.out.println(enemy.getName() + " a sorbit din licoarea de insanatosire, iar viata i-a crescut cu 50 de puncte.");
                    break;
                }

                int initialSpellDamage = enemy.spellAttack();
                if (you.isKnight()) {
                    int efficiency = (int) (Math.random() * 25) + 1;
                    double percentage = ((double) efficiency) / 100d;
                    double totalDamage = initialSpellDamage - percentage * initialSpellDamage;
                    you.setLife((int) totalDamage);
                    System.out.println("Din mainile goale ale lui " + enemy.getName() + " a aparut o explozie de lumini. In urma acestui atac, viata ti-a scazut cu " + (int) totalDamage + " de puncte");

                }
                if (you.isThief()) {
                    int efficiency = (int) (Math.random() * 10) + 1;
                    double percentage = ((double) efficiency) / 100d;
                    double totalDamage = initialSpellDamage - percentage * initialSpellDamage;
                    you.setLife((int) totalDamage);
                    System.out.println("Din mainile goale ale lui " + enemy.getName() + " a aparut o explozie de lumini. In urma acestui atac, viata ti-a scazut cu " + (int) totalDamage + " de puncte");

                }
                if (you.isMage()) {
                    int efficiency = (int) (Math.random() * 40) + 1;
                    double percentage = ((double) efficiency) / 100d;
                    double totalDamage = initialSpellDamage - percentage * initialSpellDamage;
                    you.setLife((int) totalDamage);
                    System.out.println("Din mainile goale ale lui " + enemy.getName() + " a aparut o explozie de lumini. In urma acestui atac, viata ti-a scazut cu " + (int) totalDamage + " de puncte");

                }
                break;

            case 4:
                if (enemy.drinkPotion()) {
                    System.out.println(enemy.getName() + " a sorbit din licoarea de insanatosire, iar viata i-a crescut cu 50 de puncte.");
                } else {
                    System.out.println(enemy.getName() + " a ramas fara licori de insanatosire. Nu a fost atent la atacul tau si nu a putut riposta.");
                }
                break;
        }
    }
}
