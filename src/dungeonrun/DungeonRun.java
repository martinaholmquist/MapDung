package dungeonrun;

import java.util.*;

public class DungeonRun {

    public static void main(String[] args) {
        Map w = new Map();  //skapar objekt av klassen map

        w.welcomeMessage();
        w.exitFromMap();
        w.selectMap();
        w.showMap();
        w.choiceOfStartPosition();
        w.visitedRoom();

    }
}
