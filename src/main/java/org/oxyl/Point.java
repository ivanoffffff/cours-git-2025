package org.oxyl;

import java.util.Objects;

public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0., 0.);
    }

    public Point(Point other) {
        this(other.x, other.y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point point)) return false;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public double calculerDistance(Point other) {
        return Math.sqrt(Math.pow(other.x - x, 2) + Math.pow(other.y - y, 2));
    }

    public void deplacer(double distanceX, double distanceY) {
        x += distanceX;
        y += distanceY;
    }

    public void rotate(double centerX, double centerY, double cosTheta, double sinTheta) {
        // 1. Translation au centre
        double translatedX = x - centerX;
        double translatedY = y - centerY;

        // 2. Rotation
        double rotatedX = translatedX * cosTheta - translatedY * sinTheta;
        double rotatedY = translatedX * sinTheta + translatedY * cosTheta;

        // 3. Retour à la position originale + arrondi
        x = Math.round((rotatedX + centerX) * 100.0) / 100.0;
        y = Math.round((rotatedY + centerY) * 100.0) / 100.0;
    }
}
