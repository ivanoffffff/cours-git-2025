package org.oxyl;

public class Triangle {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public Triangle() {
        this(0., 0., 0., 1., 0.5, 0.5);
    }

    public Triangle(Triangle other) {
        this(other.x1, other.y1, other.x2, other.y2, other.x3, other.y3);
    }

    public void deplacer(double distanceX, double distanceY) {
        x1 += distanceX;
        x2 += distanceX;
        x3 += distanceX;
        y1 += distanceY;
        y2 += distanceY;
        y3 += distanceY;
    }

    public void tourner(double thetaDegrees) {
        // 1. Calcul du barycentre
        double barycentreX = (x1 + x2 + x3) / 3.0;
        double barycentreY = (y1 + y2 + y3) / 3.0;

        // 2. Conversion de l'angle en radians
        double thetaRadians = Math.toRadians(thetaDegrees);
        double cosTheta = Math.cos(thetaRadians);
        double sinTheta = Math.sin(thetaRadians);

        // 3. Rotation de chaque point autour du barycentre et mise à jour des coordonnées
        double[] newCoords1 = rotatePoint(x1, y1, barycentreX, barycentreY, cosTheta, sinTheta);
        x1 = newCoords1[0];
        y1 = newCoords1[1];

        double[] newCoords2 = rotatePoint(x2, y2, barycentreX, barycentreY, cosTheta, sinTheta);
        x2 = newCoords2[0];
        y2 = newCoords2[1];

        double[] newCoords3 = rotatePoint(x3, y3, barycentreX, barycentreY, cosTheta, sinTheta);
        x3 = newCoords3[0];
        y3 = newCoords3[1];
    }

    private double[] rotatePoint(double x, double y, double centerX, double centerY, double cosTheta, double sinTheta) {
        // 1. Translation au centre
        double translatedX = x - centerX;
        double translatedY = y - centerY;

        // 2. Rotation
        double rotatedX = translatedX * cosTheta - translatedY * sinTheta;
        double rotatedY = translatedX * sinTheta + translatedY * cosTheta;

        // 3. Retour à la position originale + arrondi
        double finalX = Math.round((rotatedX + centerX) * 100.0) / 100.0;
        double finalY = Math.round((rotatedY + centerY) * 100.0) / 100.0;


        return new double[]{finalX, finalY};
    }

    public boolean isEquilateral() {
        // 1. Calcul des longueurs des côtés
        double side1 = distance(x1, y1, x2, y2);
        double side2 = distance(x2, y2, x3, y3);
        double side3 = distance(x3, y3, x1, y1);

        // 2. Arrondi des longueurs
        double roundedSide1 = Math.round(side1 * 100.0) / 100.0;
        double roundedSide2 = Math.round(side2 * 100.0) / 100.0;
        double roundedSide3 = Math.round(side3 * 100.0) / 100.0;

        // 3. Vérification si les trois longueurs sont égales
        return roundedSide1 == roundedSide2 && roundedSide2 == roundedSide3;
    }

    private double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
