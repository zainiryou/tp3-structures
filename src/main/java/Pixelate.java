public class Pixelate implements Transform {
    private int newPixelSize = 10;

    @Override
    public void applyTo(GrayImage image){
        for(int i=0; i<=image.getWidth() ; i+=newPixelSize) {
            for (int j = 0; j <= image.getHeight() ; j+=newPixelSize) {
                computePixel(image, i, j);
            }
        }
    }

    private void computePixel(GrayImage image, int i, int j) {
        int somme = 0, moyenne, count = 0;
        for(int k = i; k < i+newPixelSize; k++ ) {
            for (int l = j; l < j+newPixelSize; l++) {
                somme += image.getGrayLevel(k, l);
                count++;
            }
        }
        moyenne = somme / count;
        for(int g = i; g < i+newPixelSize; g++ )
            for (int h = j; h < j+newPixelSize; h++)
                image.setGrayLevel(moyenne, g,h);
    }
}
