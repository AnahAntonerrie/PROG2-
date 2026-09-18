package com.hei.prog2.model;
public class Bottom extends Garment {

    private int waistSize;

    public Bottom(String name, Size size, double unitPrice, Material material, int waistSize) {
        super(name, size, unitPrice, material);
        if (waistSize <= 0) {
            throw new IllegalArgumentException("Waist size must be a positive integer");
        }
        this.waistSize = waistSize;
    }

    public int getWaistSize() {
        return waistSize;
    }

    public void setWaistSize(int waistSize) {
        this.waistSize = waistSize;
    }

    @Override
    public String toString() {
        return super.toString().replaceFirst("]$", ", waistSize=" + waistSize + "]");
    }
}
