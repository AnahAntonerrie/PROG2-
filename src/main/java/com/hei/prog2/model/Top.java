package com.hei.prog2.model;

import java.util.Objects;

public class Top extends Garment {

    private SleeveType sleeveType;

    public Top(String name, Size size, double unitPrice, Material material, SleeveType sleeveType) {
        super(name, size, unitPrice, material);
        this.sleeveType = Objects.requireNonNull(sleeveType, "Sleeve type must not be null");
    }

    public SleeveType getSleeveType() {
        return sleeveType;
    }

    public void setSleeveType(SleeveType sleeveType) {
        this.sleeveType = sleeveType;
    }

    @Override
    public String toString() {
        return super.toString().replaceFirst("]$", ", sleeveType=" + sleeveType + "]");
    }
}
