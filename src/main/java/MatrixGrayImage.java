import javafx.scene.paint.Color;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Arnaud Labourel on 02/10/2018.
 */
public class MatrixGrayImage implements GrayImage {



    private ByteGrayColor[][] pixels=null;
    private final int width=0;
    private final int height=0;

    @Override
    public GrayColor getPixelGrayColor(int x, int y) {

        // TODO : Changer le code pour retourner la bonne couleur de gris.

        return new ByteGrayColor(ByteGrayColor.MAXIMUM_GRAY_VALUE);
    }

    @Override
    public void setGrayLevel(int graylevel, int x, int y) {

        // TODO : Changer le code pour mettre à jour la couleur.

    }

    @Override
    public int getGraylevel(int x, int y) {

        // TODO : Changer le code pour retourner le bon niveau de gris.

        return ByteGrayColor.MAXIMUM_GRAY_VALUE;
    }

    @Override
    public Color getPixelColor(int x, int y) {

        // TODO : Changer le code pour retourner la bonne couleur.

        return Color.WHITE;
    }

    @Override
    public int getWidth() {
        // TODO : Changer le code pour retourner la bonne largeur.

        return 600;
    }

    @Override
    public int getHeight() {
        // TODO : Changer le code pour retourner la bonne hauteur.

        return 400;
    }

    public MatrixGrayImage(int width, int height){
        /* TODO : Initialiser les attributs de l'instance.
         */
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
                    printWriter.println(getGraylevel(x,y));
                }
            }
            printWriter.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
