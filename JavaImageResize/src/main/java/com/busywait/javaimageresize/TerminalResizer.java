package com.busywait.javaimageresize;

import net.coobird.thumbnailator.Thumbnails;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by IntelliJ IDEA.
 * User: vanja
 * Date: 9/20/11
 * Time: 15:18
 * To change this template use File | Settings | File Templates.
 */
public class TerminalResizer {
    public static void main(String[] args) {
        for (String arg: args) {
            System.out.println("Arg: " + arg);
        }

        String sourcePath = null;
        String destinationFolder = null;
        int greaterDimension = 800;

        try {
            sourcePath = args[0];
            destinationFolder = args[1];
            greaterDimension = Integer.parseInt(args[2]);
        } catch (Exception e) {
            System.err.println("Program requires 3 arguments: source file, destination folder and greater dimension");
            e.printStackTrace();
        }

        File sourceFile = new File(sourcePath);
        new File(destinationFolder).mkdirs();

        try {
            ImageIcon imageIcon = new ImageIcon(sourcePath);
            Image image = imageIcon.getImage();
            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null),
                    image.getHeight(null), BufferedImage.TYPE_INT_ARGB);

            int resizedWidth = 0;
            int resizedHeight = 0;

            if (bufferedImage.getWidth() > bufferedImage.getHeight()) {
                resizedWidth = greaterDimension;
                resizedHeight = bufferedImage.getHeight() * resizedWidth / bufferedImage.getWidth();
            } else {
                resizedHeight = greaterDimension;
                resizedWidth = bufferedImage.getWidth() * resizedHeight / bufferedImage.getHeight();
            }

            Thumbnails.of(bufferedImage).size(resizedWidth, resizedHeight).toFile(destinationFolder + "/" + sourceFile.getName());
        } catch (Exception e)  {
            System.err.println("Unable to resize image: " + sourcePath);
            e.printStackTrace();
        }
    }
}
