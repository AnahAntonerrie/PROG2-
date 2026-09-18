package com.hei.prog2.model;

import java.util.Objects;

public abstract class Garment {

    private String name;
    private Size size;
    private double unitPrice;
    private Material material;

    protected Garment(String name, Size size, double unitPrice, Material material) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Garment name must not be empty");
        }
        if (unitPrice < 0) {
            throw new IllegalArgumentException("Unit price must not be negative");
        }
        this.name = name;
        this.size = Objects.requireNonNull(size, "Size must not be null");
        this.unitPrice = unitPrice;
        this.material = Objects.requireNonNull(material, "Material must not be null");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return String.format("%s [name=%s, size=%s, unitPrice=%.2f, material=%s]",
                getClass().getSimpleName(), name, size, unitPrice, material);
    }
}
