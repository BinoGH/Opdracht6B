package Prog;

import java.time.LocalDate;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    public Game(String nm, int rJ, double nwpr) {
        this.naam = nm;
        this.releaseJaar = rJ;
        this.nieuwprijs = nwpr;
    }

    public String getNaam() {
        return this.naam;
    }

    public double huidigeWaarde() {
        double prijs = nieuwprijs;
        int jaarNu = LocalDate.now().getYear();
        int aantalVerlagingen = jaarNu - releaseJaar;
        for (int i = 0; i<aantalVerlagingen; i++)
            prijs *= 0.7;

        return prijs;
    }

    public boolean equals(Object andereObject) {
        boolean objectBestaat = false;
        if (andereObject instanceof Game) {
            Game andereGame = (Game) andereObject;

            if (this.naam.equals(andereGame.naam) &&
                    this.releaseJaar == andereGame.releaseJaar) {
                objectBestaat = true;
            }
        }

        return objectBestaat;
    }

    public String toString() {
        return this.naam + ", uitgegeven in " + this.releaseJaar + String.format("; nieuwprijs: €%.2f",this.nieuwprijs)+
                String.format(" nu voor: €%.2f",this.huidigeWaarde());
    }
}