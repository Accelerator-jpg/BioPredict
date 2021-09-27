package com.example.tenserflow;

import android.graphics.drawable.shapes.Shape;

import org.pytorch.IValue;
import org.pytorch.Module;
import org.pytorch.Tensor;

public class ModelUtils {

    Module model;
    private float[] x;
    private float[] y;

    public ModelUtils(String modelPath){
        model=Module.load(modelPath);
    }

    public float[] predict(float[] x){
        Tensor x_tensor=Tensor.fromBlob(x,new long[]{1,19});
        IValue inputs= IValue.from(x_tensor);
        Tensor y_tensor=model.forward(inputs).toTensor();
        float[] outputs=y_tensor.getDataAsFloatArray();
        return outputs;
    }

    public float[] getX() {
        return x;
    }

    public void setX(float[] x) {
        this.x = x;
    }

    public float[] getY() {
        return y;
    }

    public void setY(float[] y) {
        this.y = y;
    }
}
