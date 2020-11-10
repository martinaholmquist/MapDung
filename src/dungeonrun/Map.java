package dungeonrun;

import java.util.*;
///DÖp om till map

public class Map {

    String ANSI_RESET = "\033[0m";
    String ANSI_GREEN = "\033[32;1m";
    String ANSI_RED = "\033[31;1m";
    String ANSI_YELLOW = "\033[33;1m";
    String ANSI_PURPLE = "\033[35;1m";
    String ANSI_BLUE = "\033[34;1m";
    String ANSI_CYAN = "\033[36;1m";
    String ANSI_WHITE = "\033[37;1m";
    Scanner input = new Scanner(System.in);
    int mapChoice;
    int position = 0;
    int[][] mapSmall = new int[4][4];
    int[][] mapMedium = new int[5][5];
    int[][] mapLarge = new int[8][8];
    char choice;

    public void welcomeMessage() {
        System.out.println(ANSI_YELLOW + "  .:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:." + ANSI_RESET);
        System.out.println();
        System.out.println("           _.--\"\"\"\"\"--._");
        System.out.println("           /                \\         WELCOME TO THE MAP ");
        System.out.println("          ;                   ;       ******************");
        System.out.println("          |                   |      (  )");
        System.out.println("          |                   |     ( ) ");
        System.out.println("          ;                   ;   ( )");
        System.out.println("          \\ (`'--,    ,--'`) / ()");
        System.out.println("          \\ \\  _ )  ( _  / /");
        System.out.println("           ) )(')/    \\(')( (");
        System.out.println("          (_ `\"\"` /\\  `\"\"´ _)");
        System.out.println("           \\`\"-, /  \\ ,-\"`/");
        System.out.println("            \\ //  `\"\"` \\ //`");
        System.out.println("             |/\\/\\/\\/\\/\\/|");
        System.out.println("              |\\       //|");
        System.out.println("              ;||/\\/\\/\\||");
        System.out.println("               \\`-`--`-`/");
        System.out.println("                \\      /");
        System.out.println("                 ',__,'");
        System.out.println("                  q__p");
        System.out.println("                  q__p");
        System.out.println("                  q__p");
        System.out.println("                  q__p");
        System.out.println();

        System.out.println("  _^__                                                               __^__");
        System.out.println("( ___ )-------------------------------------------------------------( ___ )");
        System.out.println(" | / |            The adventure will follow a map                    | \\ |");
        System.out.println(" | / |    In each room of the map something may occur,               | \\ |");
        System.out.println(" | / |       either one or more monster will appaer,                 | \\ |");
        System.out.println(" | / |          and/or treasure(s) will be found.                    | \\ |");
        System.out.println(" | / |    This is random, no one knows what will happen.             | \\ |");
        System.out.println(" | / |     When you have won all fights and visited all rooms        | \\ |");
        System.out.println(" | / |  the game is at end. The game also ends if you get defeated   | \\ |");
        System.out.println(" |___|       You will also have the choice to leave the map.         |___|");
        System.out.println("(_____)-------------------------------------------------------------(_____)");
        System.out.println();

    }

    public int selectMap() {
        System.out.println(ANSI_CYAN + "You can choose between the following adventures: " + ANSI_RESET);
        System.out.println(ANSI_CYAN + "1) Map small" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "2) Map medium" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "3) Map large" + ANSI_RESET);
        System.out.println();
        System.out.println("Your choice: ");

        while (true) {

            try {
                mapChoice = input.nextInt();
                if (mapChoice < 1 || mapChoice > 3) {
                    System.out.println("Not correct, please enter a value between 1 - 3");
                    continue;
                }
            } catch (Exception e) {
                input.next();
                System.out.println("Oopsie a daisy! Try again!");
                continue;
            }
            System.out.println();
            return mapChoice;
        }

    }

    public void showMap() {
        if (mapChoice == 1) {
            mapSmall();
        } else if (mapChoice == 2) {
            mapMedium();
        } else if (mapChoice == 3) {
            mapLarge();
        }

    }

    //SKulle behöva en try catch
    public int choiceOfStartPosition() {
        while (true) {
            System.out.println(ANSI_CYAN + "\nPlease choose which corner you would like to start at: " + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "For map small: 1) NorthWest, 4) NorthEast, 13) SouthWest, 16) SoutEast" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "For map medium: 1) NorthWest, 5) NorthEast, 18) SouthWest, 22) SoutEast" + ANSI_RESET);
            System.out.println(ANSI_RED + "For map large: 1) NorthWest, 8) NorthEast, 57) SouthWest, 64) SoutEast" + ANSI_RESET);
            position = input.nextInt();

            if (position == 1) {
                System.out.println("You chose to start in the northwest corner");
                return position;
            } else if ((position == 4) || (position == 5) || (position == 8)) {
                System.out.println("You chose to start in the northeast corner");
                return position;
            } else if ((position == 13) || (position == 17) || (position == 57)) {
                System.out.println("You chose to start in the southwest corner");
                return position;
            } else if ((position == 16) || (position == 22) || (position == 64)) {
                System.out.println("You chose to start in the southeast corner");
                return position;

            } else {
                System.out.println("Wrong input");
            }
        }
    }

    public void choiceOfDirectionMapSmall() {
        int choice;
        System.out.println("-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----");
        System.out.println("From your current position you may choose from the following options");

        if (position == 6) {
            System.out.println("North:1, South:2, East:3 or West:4");
            System.out.println("Make your choice");
            choice = input.nextInt();
            input.nextLine();
            if (choice == 1) {
                position = 2;
            }
            if (choice == 2) {
                position = 10;
            }
            if (choice == 3) {
                position = 7;
            }
            if (choice == 4) {
                position = 5;
            }
        }
        else if (position == 7) {
            System.out.println("North:1, South:2, East:3 or West:4");
            System.out.println("Make your choice");
            choice = input.nextInt();
            input.nextLine();
            if (choice == 1) {
                position = 3;
            }
            if (choice == 2) {
                position = 11;
            }
            if (choice == 3) {
                position = 8;
            }
            if (choice == 4) {
                position = 6;
            }
        }

       else if (position == 10) {
            System.out.println("North:1, South:2, East:3 or West:4");
            System.out.println("Make your choice");
            choice = input.nextInt();
            input.nextLine();
            if (choice == 1) {
                position = 6;
            }
            if (choice == 2) {
                position = 14;
            }
            if (choice == 3) {
                position = 11;
            }
            if (choice == 4) {
                position = 9;
            }
        }
      else if ((position == 11)) {
            System.out.println("North:1, South:2, East:3 or West:4");
            System.out.println("Make your choice");
            choice = input.nextInt();
            input.nextLine();
            if (choice == 1) {
                position = 7;
            }
            if (choice == 2) {
                position = 15;
            }
            if (choice == 3) {
                position = 12;
            }
            if (choice == 4) {
                position = 10;
            }
        }

      else if (position == 2) {
            System.out.println("South:2, East:3 or West:4");
            System.out.println("Make your choice");
            choice = input.nextInt();
            input.nextLine();
            if (choice == 2) {
                position = 6;
            }
            if (choice == 3) {
                position = 3;
            }
            if (choice == 4) {
                position = 1;
            }
        }
      else if (position == 3) {
            System.out.println("South:2, East:3 or West:4");
            System.out.println("Make your choice");
            choice = input.nextInt();
            input.nextLine();
            if (choice == 2) {
                position = 7;
            }
            if (choice == 3) {
                position = 4;
            }
            if (choice == 4) {
                position = 2;
            }
        }

      else if (position == 14) {
            System.out.println("North:1, East:3 or West:4");
            System.out.println("Make your choice");
            choice = input.nextInt();
            input.nextLine();
            if (choice == 1) {
                position = 10;
            }
            if (choice == 3) {
                position = 15;
            }
            if (choice == 4) {
                position = 13;
            }
        }
      else if (position == 15) {
            System.out.println("North:1, East:3 or West:4");
            System.out.println("Make your choice");
            choice = input.nextInt();
            input.nextLine();
            if (choice == 1) {
                position = 11;
            }
            if (choice == 3) {
                position = 16;
            }
            if (choice == 4) {
                position = 14;
            }
        }
       else if (position == 5) {
            System.out.println("North:1, South:2 or East:3");
            System.out.println("Make your choice");
            choice = input.nextInt();
            input.nextLine();
            if (choice == 1) {
                position = 1;
            }
            if (choice == 2) {
                position = 9;
            }
            if (choice == 3) {
                position = 6;
            }
        }
       else if (position == 9) {
            System.out.println("North:1, South:2 or East:3");
            System.out.println("Make your choice");
            choice = input.nextInt();
            input.nextLine();
            if (choice == 1) {
                position = 5;
            }
            if (choice == 2) {
                position = 13;
            }
            if (choice == 3) {
                position = 10;
            }
        }
       else if (position == 8) {
            System.out.println("North:1, South:2 or West:4");
            System.out.println("Make your choice");
            choice = input.nextInt();
            input.nextLine();
            if (choice == 1) {
                position = 4;
            }
            if (choice == 2) {
                position = 12;
            }
            if (choice == 4) {
                position = 7;
            }
        }
       else if (position == 12) {
            System.out.println("North:1, South:2 or West:4");
            System.out.println("Make your choice");
            choice = input.nextInt();
            input.nextLine();
            if (choice == 1) {
                position = 8;
            }
            if (choice == 2) {
                position = 16;
            }
            if (choice == 4) {
                position = 11;
            }
        }

       else if (position == 1) {
            System.out.println("South:2 or East:3");
            System.out.println("Make your choice");
            choice = input.nextInt();
            input.nextLine();
            if (choice == 2) {
                position = 5;
            }
            if (choice == 3) {
                position = 2;
            }
        }
       else if (position == 4) {
            System.out.println("South:2 or West:4");
            System.out.println("Make your choice");
            choice = input.nextInt();
            input.nextLine();
            if (choice == 2) {
                position = 8;
            }
            if (choice == 4) {
                position = 3;
            }
        }
       else if (position == 13) {
            System.out.println("North:1 or East:3");
            System.out.println("Make your choice");
            choice = input.nextInt();
            input.nextLine();
            if (choice == 1) {
                position = 9;
            }
            if (choice == 3) {
                position = 14;
            }
        }
       else if (position == 16) {
            System.out.println("North:1 or West:4");
            System.out.println("Make your choice");
            choice = input.nextInt();
            input.nextLine();
            if (choice == 1) {
                position = 12;
            }
            if (choice == 4) {
                position = 15;
            }
        } 
        //else {
       // }
        visitedRoom();
    }  //KALLAR I SLUTET PÅ VISITEDROOM

    public void mapSmall() {

        mapSmall[0][0] = 1;
        mapSmall[0][1] = 2;
        mapSmall[0][2] = 3;
        mapSmall[0][3] = 4;

        mapSmall[1][0] = 5;
        mapSmall[1][1] = 6;
        mapSmall[1][2] = 7;
        mapSmall[1][3] = 8;

        mapSmall[2][0] = 9;
        mapSmall[2][1] = 10;
        mapSmall[2][2] = 11;
        mapSmall[2][3] = 12;

        mapSmall[3][0] = 13;
        mapSmall[3][1] = 14;
        mapSmall[3][2] = 15;
        mapSmall[3][3] = 16;

        int rows = 4;
        int columns = 4;
        int i, j;

        for (i = 0; i < rows; i++) {
            System.out.println("------------------");
            for (j = 0; j < columns; j++) {
                System.out.print(mapSmall[i][j] + " | ");
            }
            System.out.println("");
        }
        System.out.println("------------------");
    }

    public void mapMedium() {

        mapMedium[0][0] = 1;
        mapMedium[0][1] = 2;
        mapMedium[0][2] = 3;
        mapMedium[0][3] = 4;
        mapMedium[0][4] = 5;

        mapMedium[1][0] = 6;
        mapMedium[1][1] = 7;
        mapMedium[1][2] = 8;
        mapMedium[1][3] = 9;
        mapMedium[1][4] = 10;

        mapMedium[2][0] = 11;
        mapMedium[2][1] = 12;
        mapMedium[2][2] = 13;
        mapMedium[2][3] = 14;
        mapMedium[2][4] = 15;

        mapMedium[3][0] = 13;
        mapMedium[3][1] = 14;
        mapMedium[3][2] = 15;
        mapMedium[3][3] = 16;
        mapMedium[3][4] = 17;

        mapMedium[4][0] = 18;
        mapMedium[4][1] = 19;
        mapMedium[4][2] = 20;
        mapMedium[4][3] = 21;
        mapMedium[4][4] = 22;

        int rows = 5;
        int columns = 5;
        int k, l;

        for (k = 0; k < rows; k++) {
            //bara snygga grejer för utskrift
            System.out.println("------------------------");
            //den inre for-loopen kolumnerna
            for (l = 0; l < columns; l++) {
                System.out.print(mapMedium[k][l] + " | ");
            }
            System.out.println("");
        }
        System.out.println("------------------------");
    }

    public void mapLarge() {

        mapLarge[0][0] = 1;
        mapLarge[0][1] = 2;
        mapLarge[0][2] = 3;
        mapLarge[0][3] = 4;
        mapLarge[0][4] = 5;
        mapLarge[0][5] = 6;
        mapLarge[0][6] = 7;
        mapLarge[0][7] = 8;

        mapLarge[1][0] = 9;
        mapLarge[1][1] = 10;
        mapLarge[1][2] = 11;
        mapLarge[1][3] = 12;
        mapLarge[1][4] = 13;
        mapLarge[1][5] = 14;
        mapLarge[1][6] = 15;
        mapLarge[1][7] = 16;

        mapLarge[2][0] = 17;
        mapLarge[2][1] = 18;
        mapLarge[2][2] = 19;
        mapLarge[2][3] = 20;
        mapLarge[2][4] = 21;
        mapLarge[2][5] = 22;
        mapLarge[2][6] = 23;
        mapLarge[2][7] = 24;

        mapLarge[3][0] = 25;
        mapLarge[3][1] = 26;
        mapLarge[3][2] = 27;
        mapLarge[3][3] = 28;
        mapLarge[3][4] = 29;
        mapLarge[3][5] = 30;
        mapLarge[3][6] = 31;
        mapLarge[3][7] = 32;

        mapLarge[4][0] = 33;
        mapLarge[4][1] = 34;
        mapLarge[4][2] = 35;
        mapLarge[4][3] = 36;
        mapLarge[4][4] = 37;
        mapLarge[4][5] = 38;
        mapLarge[4][6] = 39;
        mapLarge[4][7] = 40;

        mapLarge[5][0] = 41;
        mapLarge[5][1] = 42;
        mapLarge[5][2] = 43;
        mapLarge[5][3] = 44;
        mapLarge[5][4] = 45;
        mapLarge[5][5] = 46;
        mapLarge[5][6] = 47;
        mapLarge[5][7] = 48;

        mapLarge[6][0] = 49;
        mapLarge[6][1] = 50;
        mapLarge[6][2] = 51;
        mapLarge[6][3] = 52;
        mapLarge[6][4] = 53;
        mapLarge[6][5] = 54;
        mapLarge[6][6] = 55;
        mapLarge[6][7] = 56;

        mapLarge[7][0] = 57;
        mapLarge[7][1] = 58;
        mapLarge[7][2] = 59;
        mapLarge[7][3] = 60;
        mapLarge[7][4] = 61;
        mapLarge[7][5] = 62;
        mapLarge[7][6] = 63;
        mapLarge[7][7] = 64;

        int rows = 8;
        int columns = 8;
        int y, x;

        for (y = 0; y < rows; y++) {
            //bara snygga grejer för utskrift
            System.out.println("---------------------------------------");
            //den inre for-loopen kolumnerna
            for (x = 0; x < columns; x++) {
                System.out.print(mapLarge[y][x] + " | ");
            }
            System.out.println("");
        }
        System.out.println("---------------------------------------");
    }

    public void visitedRoom() {  //KALLAR PÅ SMALL, MEDIUM EL LARGE och går vidare till choice of direction
        if (mapChoice == 1) {
            visitedRoomSmall();
            choiceOfDirectionMapSmall();
        } else if (mapChoice == 2) {
            visitedRoomMedium();
        } else if (mapChoice == 3) {
            visitedRoomLarge();
        }
    } //KALLAR PÅ SMALL, MEDIUM EL LARGE och går vidare till choice of direction

    public void visitedRoomSmall() { //KALLAR PÅ RANDOM (MONSTER, SKATTER OCH EXIT)
       //allRoomsDone();
         randomMonster();
        randomTreasure();
       // randomExit();
        for (int k = 0; k < mapSmall.length; k++) {
            for (int l = 0; l < mapSmall.length; l++) {

                if (mapSmall[k][l] == position) {
                    mapSmall[k][l] = 0;
                    //    System.out.println("fortsätt spelet " + mapSmall[k][l]); //kolla så det stämmer printout
                }
            }
        }

        int rows = 4;
        int columns = 4;
        int i, j;

        for (i = 0; i < rows; i++) {
            //bara snygga grejer för utskrift
            System.out.println("------------------");
            //den inre for-loopen kolumnerna
            for (j = 0; j < columns; j++) {
                System.out.print(mapSmall[i][j] + " | ");
            }
            System.out.println("");
        }
        System.out.println("------------------");

    }//KALLAR PÅ RANDOM (MONSTER, SKATTER OCH EXIT)

    public void visitedRoomMedium() {
        for (int k = 0; k < mapMedium.length; k++) {
            for (int l = 0; l < mapMedium.length; l++) {

                if (mapMedium[k][l] == position) {
                    mapMedium[k][l] = 0;
                }
            }
            randomMonster();
            randomTreasure();
        }

        int rows = 5;
        int columns = 5;
        int i, j;

        for (i = 0; i < rows; i++) {
            //bara snygga grejer för utskrift
            System.out.println("------------------");
            //den inre for-loopen kolumnerna
            for (j = 0; j < columns; j++) {
                System.out.print(mapMedium[i][j] + " | ");
            }
            System.out.println("");
        }
        System.out.println("------------------");
    } //KALLAR PÅ RANDOM (MONSTER, SKATTER OCH EXIT)

    public void visitedRoomLarge() {
        for (int k = 0; k < mapLarge.length; k++) {
            for (int l = 0; l < mapLarge.length; l++) {

                if (mapLarge[k][l] == position) {
                    mapLarge[k][l] = 0;
                }
            }
            randomMonster();
            randomTreasure();
        }

        int rows = 8;
        int columns = 8;
        int i, j;

        for (i = 0; i < rows; i++) {
            //bara snygga grejer för utskrift
            System.out.println("------------------");
            //den inre for-loopen kolumnerna
            for (j = 0; j < columns; j++) {
                System.out.print(mapLarge[i][j] + " | ");
            }
            System.out.println("");
        }
        System.out.println("------------------");
    } //KALLAR PÅ RANDOM (MONSTER, SKATTER OCH EXIT)

    public void randomMonster() {

        Random random = new Random();
        if (Math.random() * 100 < 20) {     //jättespindel 20, 
            System.out.println("-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----");
            System.out.println("Watch out, theres a Giantspider ahead!");
            giantspider();//hittepåmetoder för test-körning
            hittePaFight();//hittepåmetoder för test-körning
        }
        if (Math.random() * 100 < 15) {  //skelett 15  
            System.out.println("-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----");
            System.out.println("Watch out, theres a Skeleton ahead!");
            skeleton();//hittepåmetoder för test-körning
            hittePaFight();//hittepåmetoder för test-körning
        }
        if (Math.random() * 100 < 10) {   //orc 10
            System.out.println("-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----");
            System.out.println("Watch out, theres an Orc ahead!");
            orc();//hittepåmetoder för test-körning
            hittePaFight();//hittepåmetoder för test-körning
        }
        if (Math.random() * 100 < 5) {     //troll 5
            System.out.println("-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----");
            System.out.println("Watch out, theres an Troll ahead!");
            troll();//hittepåmetoder för test-körning
            hittePaFight();//hittepåmetoder för test-körning
        }

    }  //obs plocka bort för testkörning

    public void hittePaFight() {
        Scanner input = new Scanner(System.in);
        System.out.println("Skriv ett valfritt heltal för att slåss");
        int nummer = input.nextInt();
        if (nummer % 2 == 0) {
            System.out.println("Vilken tur! Numret du valt är ett jämt nummer så du vinner");
        } else {
            System.out.println("Vilken tur! Numret du valt är ett ojämt nummer, så du vinner");
        }
    }   //hittepåmetoder för test-körning

    public void giantspider() {
        System.out.println("Come on, lets fight!!");
    }  //hittepåmetoder för test-körning

    public void skeleton() {
        System.out.println("Come on, lets fight!!");
    }  //hittepåmetoder för test-körning

    public void orc() {
        System.out.println("Come on, lets fight!!");
    }   //hittepåmetoder för test-körning

    public void troll() {
        System.out.println("Come on, lets fight!!");
    }   //hittepåmetoder för test-körning

    public void randomTreasure() {  //lägg in i fightdelen, om vinna så plocka ev.skatt

        Random random = new Random();
        if (Math.random() * 100 < 40) {     //lösa slanatar 40, 
            System.out.println("-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----");
            System.out.println("Congrats! You won a coin!");
        }
        if (Math.random() * 100 < 20) {  //pengapung 20   
            System.out.println("-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----");
            System.out.println("Congrats! You won a purse with coins in it!");
        }
        if (Math.random() * 100 < 15) {   //gold jewelry 15
            System.out.println("-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----");
            System.out.println("Congrats! You won gold jewelry!");
        }
        if (Math.random() * 100 < 10) {     //ädelsten 10
            System.out.println("-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----");
            System.out.println("Congrats! You won a precious stone");
        }
        if (Math.random() * 100 < 5) {     //skattkista 5
            System.out.println("-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----");
            System.out.println("Congrats! You won a small treasure chest");
        }
    }

    public void randomExit() {  //

        Random random = new Random();
        if (Math.random() * 100 < 20) {     //hur stor % chans? 20?  
            System.out.println("This is an exitroom, would you like to stay (S) or leave (L), S/L?");
            choice = input.next().charAt(0);
            if (choice == 'L' || choice == 'l') {
                System.out.println("Lägg in exitmetod. Hej då!!");
            } else {
                System.out.println("Lägg in choiceOfDirection-METOD!!");
            }

            /* if (choice == 'y' || choice == 'Y') {
        System.out.println("Lägg in exitmetod. Hej då!!");
        }
        if (mapChoice == 1) {
        choiceOfDirectionMapSmall();
        } else if (mapChoice == 2) {
        //choiceOfDirectionMapMedium();
        } else if (mapChoice == 3) {
        //choiceOfDirectionMapLarge();
        }*/
        }
    }
    
    public void allRoomsDone() {
        System.out.println("***************Nu ska jag kolla om alla rum är 0:ade");
        for (int k = 0; k < mapSmall.length; k++) {
            for (int l = 0; l < mapSmall.length; l++) {

                if (mapSmall[k][l] > 0) {
                    System.out.println("============Nä de e inte o;ade");                  
                }
                else{
                    System.out.println("*************Alla rum är nollade");
                }
            }
        }    
                    
                
    }   

}
