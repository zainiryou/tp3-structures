public class Invert implements Transform {

    @Override
    public void applyTo(GrayImage image){
        for(int i=0; i<=image.getWidth(); i++)
            for (int j = 0; j <= image.getHeight(); j++)
                image.setGrayLevel(image.getPixelGrayColor(i, j).getMaximumGrayLevel() - image.getGrayLevel(i, j), i, j);
    }
}
