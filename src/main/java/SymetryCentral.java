public class SymetryCentral implements Transform {

    @Override
    public void applyTo(GrayImage image){
        int hauteur = image.getHeight();
        int largeur = image.getWidth();
        int count = 2;
        symetryx(image, hauteur, largeur, count);
        symetryy(image, hauteur, largeur, count);

    }

    public void symetryy(GrayImage image, int hauteur, int largeur, int count) {
        int temp;
        for(int j = 0; j<=hauteur; j++) {
            for (int i = (largeur/2)-1; i >= 0 ; i--) {
                temp = image.getGrayLevel(i, j);
                image.setGrayLevel(image.getGrayLevel(i+count, j), i, j);
                image.setGrayLevel(temp, i+count, j);
                count+=2;
            }
            count = 2;
        }
    }

    public void symetryx(GrayImage image, int hauteur, int largeur, int count) {
        int temp;
        for(int i = 0; i<=largeur; i++) {
            for (int j = (hauteur/2)-1; j >= 0 ; j--) {
                temp = image.getGrayLevel(i, j);
                image.setGrayLevel(image.getGrayLevel(i, j+count), i, j);
                image.setGrayLevel(temp, i, j+count);
                count+=2;
            }
            count = 2;
        }
    }
}
