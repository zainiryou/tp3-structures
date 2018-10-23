import javafx.scene.paint.Color;

import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Arnaud Labourel on 02/10/2018.
 */
public class MatrixGrayImage implements GrayImage {

    private final ByteGrayColor[][] pixels;
    private final int width;
    private final int height;

    @Override
    public GrayColor getPixelGrayColor(int x, int y) {
        return this.pixels[x][y];
    }

    @Override
    public void setGrayLevel(int grayLevel, int x, int y) {
        this.pixels[x][y].setGrayLevel(grayLevel);
    }

    @Override
    public int getGrayLevel(int x, int y) {
        return this.pixels[x][y].getGrayLevel();
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return this.pixels[x][y].getColor();
    }

    @Override
    public int getWidth() {
        return this.width;
    }
    @Override
    public int getHeight() {
        return this.height;
    }

    public MatrixGrayImage(int width, int height){
        int i,j;
        this.width= width;
        this.height=height;
        this.pixels=new ByteGrayColor[width+1][height+1];
        for(i=0; i<=width; i++){
            for(j=0; j<=height; j++)
                pixels[i][j] = new ByteGrayColor();
        }
    }


    public static MatrixGrayImage createImageFromPGMFile(String fileName) {
        InputStream file = ClassLoader.getSystemResourceAsStream(fileName);
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        scan.nextLine();
        scan.nextLine();

        int width = scan.nextInt();
        int height = scan.nextInt();

        MatrixGrayImage result = new MatrixGrayImage(width, height);

        scan.nextInt();

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++) {
                result.setGrayLevel(scan.nextInt(), x, y);
            }
        }

        return result;
    }

    public void writeIntoPGMFormat(String fileName){

        try {
            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("P2");
            printWriter.println("# CREATOR: TP3 Version 1.0");
            printWriter.printf("%d %d\n",this.width, this.height);

            printWriter.println(ByteGrayColor.MAXIMUM_GRAY_VALUE);

            for(int y = 0; y < height; y++){
                for(int x = 0; x < width; x++) {
                    printWriter.println(getGrayLevel(x,y));
                }
            }
            printWriter.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public GrayImage clone() {
        GrayImage image2 = this;
        return image2;
    }
}
