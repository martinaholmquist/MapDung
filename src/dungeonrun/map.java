package dungeonrun;

import java.util.*;

public class map {

    Scanner input = new Scanner(System.in);
    int mapChoice;
    boolean isInt = true;
    int direction = 0;
    //direction++;
    int[][] mapSmall = new int[4][4];

    public void welcomeMessage() {
        System.out.println("Hello. Welcom to the map, The  adventure will follow"
                + " a map. In the room of the map something can happen, \n"
                + "either one or more monster will appaer, and/or treasure(s) will be found. "
                + "This is random, no one knows what will happen. When you have\n"
                + "won all fights and visited all rooms the game is at end. The game also ends if you "
                + "get defeated. \n"
                + "You will also have the choice to leave the map.");
    }

    public int showMap() {

        System.out.println("Please select one  below size of adventure.");
        System.out.println("You can choose between 3 different levels of adventure, small, medium or big.");
        System.out.println("Please choose size, small=1, medium=2 and large=3");
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
            return mapChoice;
        }
    }

    public void showMapSize() {  //ta bort
        if (mapChoice == 1) {
            mapChoice = 4;
        } else if (mapChoice == 2) {
            mapChoice = 5;
        } else if (mapChoice == 3) {
            mapChoice = 8;
        }
        System.out.println("This is your choice of mapsize: ");
        for (int rad = 0; rad < mapChoice; rad++) {
            for (int kolumn = 0; kolumn < mapChoice; kolumn++) {
                System.out.print(" x ");
            }
            System.out.println(" ");
        }
    }

    public int choiceOfDirection() {
        while (true) {
            System.out.println("\nPlease choice which corner you'll like to start at. ");
            System.out.println("NorthWest=1, NorthEeast=4, SouthWest=13, SoutEast=16");
            direction = input.nextInt();
            if (direction == 1 || direction == 4 || direction == 13 || direction == 16) {
                return direction;
            } else {
                System.out.println("Wrong input");
            }
        }
    }

    public void mapSmall() {  
        // int[][] mapSmall = new int[4][4];

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

        /*      for (i = 0; i < rows; i++) {
        //bara snygga grejer för utskrift
        System.out.println("------------------");
        //den inre for-loopen kolumnerna
        for (j = 0; j < columns; j++) {
        System.out.print(mapSmall[i][j] + " | ");
        }
        System.out.println("");
        }
        System.out.println("------------------");*/
    }

    public void visitedRoom() {
        for (int k = 0; k < mapSmall.length; k++) {
            for (int l = 0; l < mapSmall.length; l++) {
                if (mapSmall[k][l] == direction) {
                    mapSmall[k][l] = 0;
                    System.out.println("fortsätt spelet " + mapSmall[k][l]); //kolla så det stämmer printout
                }
            }
        }
        
        /*System.out.println("Dags att gå vidare....");
        if (direction == mapSmall[0][0] || direction == mapSmall[0][1] || direction == mapSmall[0][2] || direction == mapSmall[0][3]);
        {
        System.out.println("Då kan du välja h, n");
        }else if //då kan du gå vänster eller neråt
*/
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
    
    }
    
    
    
    public void pictureMap() {
        String one = "* * * * * * ==================================\n * * * * *  ==================================";
        String two = "==============================================";
        for (int i = 1; i <= 4; i++) {
            System.out.println(one);
        }
        System.out.println("* * * * * * ==================================");
        for (int i = 1; i <= 6; i++) {
            System.out.println(two);
        }
    }

    /*public void pictureMap2(){
    System.out.println("       -----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----");
    System.out.println("          . _..::__:  ,-``-```._        |7       ,     _,.__");
    System.out.println("  _.___ _ _<_>`!(._`.`-.    /         _._     `_ ,_/  '  '-._.---.-.__");
    System.out.println(">.{     " " `-==,',._\{  \  / {)      / _ ``>_,-' `                mt-2_");
    System.out.println("  \_.:--.       `._ )`^-. "'       , [_/(                       __,/-");
    System.out.println("'"'     \         "    _L        oD_,--'                )     /. (|");
    System.out.println("        |           ,'          _)_.\\._<> 6              _,' /  '");
    System.out.println("       `.         /           [_/_'` `"(                <'}  )");
    System.out.println("        \\    .-. )           /   `-'"..' `:.#          _)  '");
    System.out.println("   `        \  (  `(           /         `:\  > \  ,-^.  /' '");
    System.out.println("            `._,   ""         |           \`'   \|   ?_)  {\");
    System.out.println("              `=.---.        `._._       ,'     "`  |' ,- '.");
    System.out.println("                |    `-._         |     /          `:`<_|h--._");
    System.out.println("                 (        >        .     | ,          `=.__.`-'\");
    System.out.println("                 `.     /         |     |{|              ,-.,\     .");
    System.out.println("                  |   ,'           \   / `'            ,"     \");
    System.out.println("                  |  /              |_'                |  __  /");
    System.out.println("                 | |                                  '-'  `-'   \.");
    System.out.println("                 |/                                         "    /");
    System.out.println("                 \.                                             '");
    System.out.println("                                                                 ");
    System.out.println("                    ,/            ______._.--._ _..---.---------._");
    System.out.println("   ,-----"-..?----_/ )      __,-'"             "                  (");
    System.out.println("-.._(                  `-----'                                       `-");
    System.out.println("-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----");
    
    }*/
}
