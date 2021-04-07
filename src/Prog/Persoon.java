package Prog;

import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames = new ArrayList<Game>();

    public Persoon(String nm, double bud) {
        this.naam = nm;
        this.budget = bud;
    }

    public double getBudget() {
        return this.budget;
    }

    public boolean koop(Game g) {
        boolean kanKopen = false;

        if ((g.huidigeWaarde() < this.budget) && !(this.mijnGames.contains(g))) {
            kanKopen = true;
            this.budget -= g.huidigeWaarde();
            this.mijnGames.add(g);
        }

        return kanKopen;
    }

    public boolean verkoop(Game g, Persoon koper) {
        boolean verkoopGelukt = false;
        if (this.mijnGames.contains(g) && (koper.getBudget() > g.huidigeWaarde()) && !(koper.mijnGames.contains(g))) {
            koper.koop(g);
            this.mijnGames.remove(g);
            this.budget += g.huidigeWaarde();
            verkoopGelukt = true;
        }

        return verkoopGelukt;
    }

    public Game zoekGameOpNaam(String game){
        for (Game gameInArray : mijnGames){
            if (gameInArray.getNaam().equals(game)){
                return gameInArray;
            }
        }
        return null;
    }

    public ArrayList<Game> bepaalGamesNietInBezit(ArrayList<Game> gameLijst) {
        ArrayList<Game> gamesNietInBezit = new ArrayList<Game>();
        for (Game g : gameLijst) {
            if (!mijnGames.contains(g)) {
                gamesNietInBezit.add(g);
            }
        }
        return gamesNietInBezit;
    }

    public String toString() {
        String budgetStr = String.format(" heeft een budget van €%.2f", this.budget);
        String str = this.naam + budgetStr + " en bezit de volgende games:";
        for (Game game : this.mijnGames) {
            str += "\n" + game;
        }
        return str;
    }
}