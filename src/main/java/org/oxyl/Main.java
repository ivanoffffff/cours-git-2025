package org.oxyl;

public class Main {
    public static void main(String [] args){
        System.out.println("It works");

        RectangleAvecPoint rectangle = new RectangleAvecPoint();
        rectangle.deplacer(2,5);
        System.out.println((int)rectangle.getCentre().getX());
        System.out.println( (int) rectangle.getCentre().getY());
    }
}
