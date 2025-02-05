package org.oxyl;

public interface Figure {

    public default void setCentre(Point centre) {
        this.centre = centre;
    }

    public default void deplacer(double distanceX, double distanceY) {
        this.centre.deplacer(distanceX, distanceY);
    }

    public default boolean isAuCentre() {
        return centre.getX()==0 && centre.getY()==0;
    }
}
