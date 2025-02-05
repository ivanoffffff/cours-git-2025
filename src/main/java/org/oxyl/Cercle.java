package org.oxyl;

public class Cercle {
    private double centreX;
    private double centreY;
    private double rayon;

    public Cercle(double centreX, double centreY, double rayon) {
        this.centreX = centreX;
        this.centreY = centreY;
        setRayon(rayon);
    }

    public Cercle() {
        this(0., 0., 1.);
    }

    public Cercle(Cercle other) {
        this(other.centreX, other.centreY, other.rayon);
    }

    public void setRayon(double rayon) {
        this.rayon = rayon >= 0. ? rayon : 0.;
    }

    public void deplacer(double distanceX, double distanceY) {
        this.centreX += distanceX;
        this.centreY += distanceY;
    }

    public boolean isGrand() {
        return rayon > 100;
    }

    public void redimensionner(double f) {
        setRayon(rayon * f);
    }

    public void tourner(double theta) {
    }
}
