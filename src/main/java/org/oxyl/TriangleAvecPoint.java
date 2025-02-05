package org.oxyl;

public class TriangleAvecPoint {
    private Point point1;
    private Point point2;
    private Point point3;

    public TriangleAvecPoint(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public TriangleAvecPoint() {
        this(new Point(0., 0.), new Point(0., 1.), new Point(0.5, 0.5));
    }

    public TriangleAvecPoint(TriangleAvecPoint other) {
        this(other.point1, other.point2, other.point3);
    }

    public void deplacer(double distanceX, double distanceY) {
        this.point1.deplacer(distanceX, distanceY);
        this.point2.deplacer(distanceX, distanceY);
        this.point3.deplacer(distanceX, distanceY);
    }

    public void tourner(double thetaDegrees) {
        // 1. Calcul du barycentre
        double barycentreX = (point1.getX() + point2.getX() + point3.getX()) / 3.0;
        double barycentreY = (point1.getY() + point2.getY() + point3.getY()) / 3.0;

        // 2. Conversion de l'angle en radians
        double thetaRadians = Math.toRadians(thetaDegrees);
        double cosTheta = Math.cos(thetaRadians);
        double sinTheta = Math.sin(thetaRadians);

        // 3. Rotation de chaque point autour du barycentre et mise à jour des coordonnées
        point1.rotate(barycentreX, barycentreY, cosTheta, sinTheta);

        point2.rotate(barycentreX, barycentreY, cosTheta, sinTheta);

        point3.rotate(barycentreX, barycentreY, cosTheta, sinTheta);
    }

    public boolean isEquilateral() {
        // 1. Calcul des longueurs des côtés
        double side1 = point1.calculerDistance(point2);
        double side2 = point2.calculerDistance(point3);
        double side3 = point3.calculerDistance(point1);

        // 2. Arrondi des longueurs
        double roundedSide1 = Math.round(side1 * 100.0) / 100.0;
        double roundedSide2 = Math.round(side2 * 100.0) / 100.0;
        double roundedSide3 = Math.round(side3 * 100.0) / 100.0;

        // 3. Vérification si les trois longueurs sont égales
        return roundedSide1 == roundedSide2 && roundedSide2 == roundedSide3;
    }
}
