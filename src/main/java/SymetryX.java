public class SymetryX implements Transform {

    @Override
    public void applyTo(GrayImage image){
        int hauteur = image.getHeight();
        int largeur = image.getWidth();
        int temp, count = 2;
        for(int i=0; i<=largeur; i++) {
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
