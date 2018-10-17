public class DecreaseGrayLevels implements Transform {
    private int nbGrayLevels = 8;
    private int tab[] = new int[nbGrayLevels];

    @Override
    public void applyTo(GrayImage image){
        int k,t;

        tab[0] = 0;
        tab[1] = (256 / nbGrayLevels) - 1;
        for(k=2; k<nbGrayLevels; k++)
            tab[k] = tab[k-1] + (256 / nbGrayLevels);

        for(int i=0; i<=image.getWidth(); i++) {
            for (int j = 0; j <= image.getHeight(); j++) {
                t = image.getGrayLevel(i, j) / 32;
                image.setGrayLevel(tab[t], i, j);
            }
        }
    }
}
