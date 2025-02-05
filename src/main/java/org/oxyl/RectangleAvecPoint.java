package org.oxyl;

public class RectangleAvecPoint extends AUnCentre {
    private double longueur;
    private double largeur;
    private double angle;

    public RectangleAvecPoint(Point centre, double longueur, double largeur, double angle) {
        super(centre);
        setLongueur(longueur);
        setLargeur(largeur);
        this.angle = angle;
    }

    public RectangleAvecPoint() {
        this(new Point(), 1., 1., 0.);
    }

    public RectangleAvecPoint(RectangleAvecPoint other) {
        this(other.centre, other.longueur, other.largeur, other.angle);
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur >= 0. ? longueur : 0.;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur >= 0. ? largeur : 0.;
    }

    /*public void deplacer(double distanceX, double distanceY) {
        this.centre.deplacer(distanceX, distanceY);
    }*/

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

    public Point getCentre() {
        return centre;
    }
}
