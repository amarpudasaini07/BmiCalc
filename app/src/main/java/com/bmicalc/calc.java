package com.bmicalc;

public class calc {
    public float weight;
    public float height;

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public calc(float weight, float height) {
        this.weight = weight;
        this.height = height;
    }

    public float result(){
        return (this.weight/((this.height/100)*(this.height/100)));
    }
}
