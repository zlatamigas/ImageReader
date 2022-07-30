package com.zlatamigas.imagereader.service;

import com.zlatamigas.imagereader.entity.ImageTableInfo;
import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.ImageParser;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.formats.bmp.BmpImageParser;
import org.apache.commons.imaging.formats.gif.GifImageParser;
import org.apache.commons.imaging.formats.jpeg.JpegImageParser;
import org.apache.commons.imaging.formats.pcx.PcxImageParser;
import org.apache.commons.imaging.formats.png.PngImageParser;
import org.apache.commons.imaging.formats.tiff.TiffImageParser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ImageInfoManager {

    private static final String DELIMITER = "x";

    public ArrayList<ImageTableInfo> getImageInfo(File directory) {

        ArrayList<ImageTableInfo> images = new ArrayList<>();

        if (directory == null || !directory.isDirectory()) {
            return images;
        }

        ImageTableInfo imageTableInfo;
        ImageInfo imageInfo;

        for (File file : directory.listFiles(File::isFile)) {


            imageInfo = getFormatImageInfo(file);
            if (imageInfo == null) {
                continue;
            }

            imageTableInfo = new ImageTableInfo();

            imageTableInfo.setName(file.getName());
            imageTableInfo.setSize(imageInfo.getWidth() + DELIMITER + imageInfo.getHeight());
            imageTableInfo.setPhysicalSize(file.length());

            int depth = imageInfo.getBitsPerPixel();
            if (depth > 0) {
                imageTableInfo.setDepth(Integer.toString(depth));
            }

            int hdpi = imageInfo.getPhysicalWidthDpi();
            int vdpi = imageInfo.getPhysicalHeightDpi();
            if (hdpi + vdpi > 0) {
                imageTableInfo.setExtension(hdpi + DELIMITER + vdpi);
            }
            imageTableInfo.setCompression(imageInfo.getCompressionAlgorithm().name());

            int numberOfImages = imageInfo.getNumberOfImages();
            imageTableInfo.setOptional(Integer.toString(numberOfImages > 0 ? numberOfImages : 1));

            images.add(imageTableInfo);
        }
        return images;
    }


    private ImageInfo getFormatImageInfo(File file) {

        ImageExtensionType type = ImageExtensionType.getExtensionType(file.getName());
        if (type == null) {
            return null;
        }

        ImageParser parser = null;
        switch (type) {
            case JPEG:
            case JPG:
                parser = new JpegImageParser();
                break;
            case PNG:
                parser = new PngImageParser();
                break;
            case GIF:
                parser = new GifImageParser();
                break;
            case BMP:
                parser = new BmpImageParser();
                break;
            case PCX:
                parser = new PcxImageParser();
                break;
            case TIFF:
                parser = new TiffImageParser();
                break;
        }

        try {
            return parser.getImageInfo(file, null);
        } catch (ImageReadException | IOException e) {
            return null;
        }
    }
}