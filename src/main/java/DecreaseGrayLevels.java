public class DecreaseGrayLevels implements Transform {
    private int nbGrayLevels = 8;
    private int tab[] = new int[nbGrayLevels];

    @Override
    public void applyTo(GrayImage image){
        int i,j,t;

        tab[0] = (256 / nbGrayLevels) - 1;
        for(t=1; t<nbGrayLevels; t++)
            tab[t] = tab[t-1] + (256 / nbGrayLevels);
        for(i=0; i<nbGrayLevels; i++)
            System.out.println(tab[i]);
        t = 0;

        for(i=0; i<=image.getWidth(); i++) {
            for (j = 0; j <= image.getHeight(); j++) {
                if(image.getGrayLevel(i, j) <=tab[t]) {
                    image.setGrayLevel(tab[t], i, j);
                    t=0;
                }
                else
                    t++;
            }
        }
    }
}
