import javafx.scene.paint.Color;

/**
 * Created by Arnaud Labourel on 02/10/2018.
 */

public class ByteGrayColor implements GrayColor {
    private int grayLevel;
    public static final int MAXIMUM_GRAY_VALUE = 255;
    public static final int MINIMUM_GRAY_VALUE = 0;
    private static final int OPACITY = 1;

    public int getGrayLevel() {
        // TODO : Renvoyer le niveau de gris de l'instance.
        return 0;
    }

    public ByteGrayColor(){
        // TODO : Initialiser l'attribut grayLevel de l'instance avec MINIMUM_GRAY_VALUE.
    }

    public ByteGrayColor(int grayLevel) {
        // TODO : Initialiser l'attribut grayLevel de l'instance.
    }

    @Override
    public Color getColor(){
        return new Color(grayLevel/(double) MAXIMUM_GRAY_VALUE,
                grayLevel/(double) MAXIMUM_GRAY_VALUE,
                grayLevel/(double) MAXIMUM_GRAY_VALUE,
                OPACITY);
    }

    @Override
    public void setGrayLevel(int grayLevel) {
        // TODO : Changer le niveau de gris de la couleur.
    }

    @Override
    public int compareTo(GrayColor o) {
        // TODO : Renvoyer la différence de niveau de gris.
        return 0;
    }

}
