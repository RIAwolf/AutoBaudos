package com.company;

import lt.duombaze.MyDBModel;
import lt.failai.FailoImportavimas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        MyDBModel duomenys = new MyDBModel();

        Scanner skaneris = new Scanner(System.in);
        FailoImportavimas importavimas = new FailoImportavimas();
        while (true) {
            System.out.println("Ka norite atlikti?");
            System.out.println("0- baigti darba");
            System.out.println("1- Prideti automobili");
            System.out.println("2- Pasalinti automobili");
            System.out.println("3- Parodyti automobilius");
            System.out.println("4- Prideti bauda");
            System.out.println("5- Pasalinti bauda");
            System.out.println("6- Parodyti baudas");
            System.out.println("7- Parodyti visas masinas su bauda");
            System.out.println("8- Parodyti masinas kurios negalejo pasiekti baudos greicio");
            System.out.println("9- Importuoti automobilius");
            System.out.println("10- Importuoti baudas");
            int veikmas = skaneris.nextInt();
            skaneris.nextLine();
            switch (veikmas) {
                case 0:
                    return;
                case 1:
                    System.out.println("Iveskite automobilio modeli");
                    String modelis = skaneris.nextLine();
                    System.out.println("Iveskite automobilio marke");
                    String marke = skaneris.nextLine();
                    System.out.println("Iveskite automobilio aprasyma");
                    String aprasymas = skaneris.nextLine();
                    System.out.println("Iveskite automobilio maksimalu greiti");
                    int maxGreitis = skaneris.nextInt();

                    duomenys.simpleExecute("INSERT INTO `Automobiliai` " +
                            "(`modelis`, `marke`, `aprasymas`, `max_greitis`) " +
                            "values " +
                            "('" + modelis + "','" + marke + "','" + aprasymas + "','" + maxGreitis + "')");
                    break;
                case 2:
                    System.out.println("Iveskite trinamo automobilio ID");
                    int ID = skaneris.nextInt();
                    duomenys.simpleExecute("DELETE FROM `Automobiliai` WHERE id = "+ID+"");
                    break;
                case 3:
                    duomenys.simplePrint("SELECT * FROM `Automobiliai`;");
                    break;
                case 4:
                    System.out.println("Iveskite automobilio ID");
                    String autoID = skaneris.nextLine();
                    System.out.println("Iveskite baudos aprasyma");
                    String baudosAprasymas = skaneris.nextLine();
                    System.out.println("Iveskite baudos dydi");
                    int baudosDydis = skaneris.nextInt();
                    System.out.println("Iveskite greiti kuriuo vaziavo");
                    int baudosGreitis = skaneris.nextInt();

                    duomenys.simpleExecute("INSERT INTO `nusizengimas` " +
                            "(`auto_id`, `aprasymas`, `bauda`, `greitis`) " +
                            "values " +
                            "('" + autoID + "','" + baudosAprasymas + "'," + baudosDydis + ", " + baudosGreitis + ")");
                    break;
                case 5:
                    System.out.println("Iveskite trinamos baudos ID");
                    int baudosID = skaneris.nextInt();
                    duomenys.simpleExecute("DELETE FROM `nusizengimas` WHERE id = "+baudosID+"");
                    break;
                case 6:
                    duomenys.simplePrint("SELECT * FROM `nusizengimas`;");
                    break;
                case 7:
                    duomenys.simplePrint("SELECT * FROM `automobiliai` " +
                            "INNER JOIN `nusizengimas` " +
                            "ON `automobiliai`.`id` = `nusizengimas`.`auto_id`");
                    break;
                case 8:
                    duomenys.simplePrint("SELECT * FROM `automobiliai` " +
                            "INNER JOIN `nusizengimas` " +
                            "ON `automobiliai`.`id` = `nusizengimas`.`auto_id` " +
                            "WHERE `nusizengimas`.`greitis`>`automobiliai`.`max_greitis`");
                    break;
                case 9:
                    importavimas.importuotiAutomobilius(duomenys);
                    break;
                case 10:
                    importavimas.importuotiBaudas(duomenys);
                    break;
            }

        }
    }
}
