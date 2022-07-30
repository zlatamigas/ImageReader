package com.zlatamigas.imagereader.entity;

import java.util.Objects;

public class ImageTableInfo {

    private String name;
    private String size;
    private String extension;
    private String depth;
    private String compression;
    private String optional;

    private long physicalSize;

    public ImageTableInfo() {
        this.name = "";
        this.size = "";
        this.extension = "UNKNOWN";
        this.depth = "";
        this.compression = "Cannot get compression";
        this.optional = "";
        this.physicalSize = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getCompression() {
        return compression;
    }

    public void setCompression(String compression) {
        this.compression = compression;
    }

    public String getOptional() {
        return optional;
    }

    public void setOptional(String optional) {
        this.optional = optional;
    }

    public long getPhysicalSize() {
        return physicalSize;
    }

    public void setPhysicalSize(long physicalSize) {
        this.physicalSize = physicalSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageTableInfo imageInfo = (ImageTableInfo) o;
        return name.equals(imageInfo.name)
                && size.equals(imageInfo.size)
                && extension.equals(imageInfo.extension)
                && depth.equals(imageInfo.depth)
                && compression.equals(imageInfo.compression)
                && optional.equals(imageInfo.optional)
                && physicalSize == imageInfo.physicalSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, extension, depth, compression, optional, physicalSize);
    }
}
