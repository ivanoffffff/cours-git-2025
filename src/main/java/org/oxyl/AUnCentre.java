package org.oxyl;

abstract class AUnCentre {
    protected Point centre;

    public AUnCentre(Point centre) {
        this.centre = centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    public void deplacer(double distanceX, double distanceY) {
        this.centre.deplacer(distanceX, distanceY);
    }

    public boolean isAuCentre() {
        return centre.getX()==0 && centre.getY()==0;
    }
}