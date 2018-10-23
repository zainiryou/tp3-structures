public class SymetryY implements Transform {

    @Override
    public void applyTo(GrayImage image){
        int hauteur = image.getHeight();
        int largeur = image.getWidth();
        int temp, count = 2;
        for(int j=0; j<=hauteur; j++) {
            for (int i = (largeur/2)-1; i >= 0 ; i--) {
                temp = image.getGrayLevel(i, j);
                image.setGrayLevel(image.getGrayLevel(i+count, j), i, j);
                image.setGrayLevel(temp, i+count, j);
                count+=2;
            }
            count = 2;
        }
    }
}
