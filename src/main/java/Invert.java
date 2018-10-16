public class Invert implements Transform {

    @Override
    public void applyTo(GrayImage image){
        int i,j;
        for(i=0; i<=image.getWidth(); i++)
            for (j = 0; j <= image.getHeight(); j++)
                image.setGrayLevel(image.getPixelGrayColor(i, j).getMaximumGrayLevel() - image.getGrayLevel(i, j), i, j);
    }
}
