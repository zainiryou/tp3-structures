public class Outline implements Transform {
    private int threshold;

    public Outline(int threshold){
        this.threshold = threshold;
    }

    @Override
    public void applyTo(GrayImage image){
        for(int i=0; i<image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                if(Math.abs((image.getGrayLevel(i+1, j)) - (image.getGrayLevel(i, j))) > threshold || Math.abs((image.getGrayLevel(i, j+1)) - (image.getGrayLevel(i, j))) > threshold)
                    image.setGrayLevel(0, i, j);
                else
                    image.setGrayLevel(255, i, j);
            }
        }
    }
}
