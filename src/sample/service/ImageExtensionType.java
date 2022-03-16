package sample.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ImageExtensionType {
    JPG(".jpg"),
    JPEG(".jpeg"),
    PNG(".png"),
    GIF(".gif"),
    BMP(".bmp"),
    PCX(".pcx"),
    TIFF(".tiff");

    private String extension;

    ImageExtensionType(String extension) {
        this.extension = extension;
    }

    public static List<String> getFormatExtensions() {
        return Arrays.stream(ImageExtensionType.values())
                .map(s -> s.extension).collect(Collectors.toList());
    }

    public static ImageExtensionType getExtensionType(String filename) {

        return Arrays.stream(ImageExtensionType.values())
                .filter(t -> filename.endsWith(t.extension))
                .findFirst().orElse(null);
    }
}
