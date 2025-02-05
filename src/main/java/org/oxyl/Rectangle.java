package org.oxyl;

public class Rectangle {
    private double centreX;
    private double centreY;
    private double longueur;
    private double largeur;
    private double angle;

    public Rectangle(double centreX, double centreY, double longueur, double largeur, double angle) {
        this.centreX = centreX;
        this.centreY = centreY;
        setLongueur(longueur);
        setLargeur(largeur);
        this.angle = angle;
    }

    public Rectangle() {
        this(0., 0., 1., 1., 0.);
    }

    public Rectangle(Rectangle other) {
        this(other.centreX, other.centreY, other.longueur, other.largeur, other.angle);
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur >= 0. ? longueur : 0.;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur >= 0. ? largeur : 0.;
    }

    public void deplacer(double distanceX, double distanceY) {
        centreX += distanceX;
        centreY += distanceY;
    }

    public boolean isCarre() {
        return longueur == largeur;
    }

    public void redimensionner(double f) {
        setLongueur(longueur * f);
        setLargeur(largeur * f);
    }

    public void tourner(double theta) {
        angle += theta;
    }
}
