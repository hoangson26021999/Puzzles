package org.example;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GetSetPixels {
    public static void main(String args[]) throws IOException {

        System.out.println("---Start---");
        BufferedImage imgEncoded = null;
        File fileEncode = null;

        BufferedImage imgKey = null;
        File fileKey = null;

        // read image
        try {
            fileEncode = new File("src/main/resources/image/something.png");
            imgEncoded = ImageIO.read(fileEncode);

            fileKey = new File("src/main/resources/image/key.png");
            imgKey = ImageIO.read(fileKey);
        } catch (IOException e) {
            System.out.println(e);
        }

//        System.out.println(imgKey.getWidth());
//        System.out.println(imgKey.getHeight());
//
//        for (int i = 0; i < imgKey.getHeight(); i++) {
//            for (int j = 0; j < imgKey.getWidth(); j++) {
//                int red = imgEncoded.getRGB(j,i) == -16777216 ? 0 : imgEncoded.getRGB(j,i);
//                System.out.print(red);
//            }
//            System.out.println("");
//        }

        int red = 0;
        int black = -16777216;
        int blue = -14484804;
        int yealow = -3584;
        for (int i = 0; i < imgEncoded.getHeight(); i++) {
            for (int j = 0; j < imgEncoded.getWidth(); j++) {

                if (imgKey.getRGB(j, i) != yealow) {
                    if (imgEncoded.getRGB(j, i) != blue) {
                        imgEncoded.setRGB(j, i, blue);
                    } else {
                        imgEncoded.setRGB(j, i, black);
                    }
                }
            }
        }

        File planImg = null;

        // write image
        try {
            planImg = new File("src/main/resources/image/test.png");
            ImageIO.write(imgEncoded, "jpg", planImg);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

