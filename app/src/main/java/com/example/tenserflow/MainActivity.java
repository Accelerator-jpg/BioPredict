package com.example.tenserflow;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.pytorch.Module;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Float> x=new ArrayList<>();
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String Path="model_mobile.pt";
        String modelPath = assetFilePath(this, Path);
        ModelUtils modelUtils=new ModelUtils(modelPath);
        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (DataPrepare()) {
                    float[] input = new float[x.size()];
                    for (int i = 0; i < x.size(); i++) {
                        input[i] = x.get(i);
                    }
                    float[] y;
                    y = modelUtils.predict(input);
                    OutputWrite(y);
                }else{
                    String s="请您输入完整数据";
                    Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean DataPrepare(){
        x.clear();
        TextView input1=findViewById(R.id.input1);
        if(input1.getText().toString().trim().length()==0) return false;
        x.add(Float.valueOf(String.valueOf(input1.getText())));
        TextView input2=findViewById(R.id.input2);
        if(input2.getText().toString().trim().length()==0) return false;
        x.add(Float.valueOf(String.valueOf(input2.getText())));
        TextView input3=findViewById(R.id.input3);
        if(input3.getText().toString().trim().length()==0) return false;
        x.add(Float.valueOf(String.valueOf(input3.getText())));
        TextView input4=findViewById(R.id.input4);
        if(input4.getText().toString().trim().length()==0) return false;
        x.add(Float.valueOf(String.valueOf(input4.getText())));
        TextView input5=findViewById(R.id.input5);
        if(input5.getText().toString().trim().length()==0) return false;
        x.add(Float.valueOf(String.valueOf(input5.getText())));
        TextView input6=findViewById(R.id.input6);
        if(input6.getText().toString().trim().length()==0) return false;
        x.add(Float.valueOf(String.valueOf(input6.getText())));
        TextView input7=findViewById(R.id.input7);
        if(input7.getText().toString().trim().length()==0) return false;
        x.add(Float.valueOf(String.valueOf(input7.getText())));
        TextView input8=findViewById(R.id.input8);
        if(input8.getText().toString().trim().length()==0) return false;
        x.add(Float.valueOf(String.valueOf(input8.getText())));
        TextView input9=findViewById(R.id.input9);
        if(input9.getText().toString().trim().length()==0) return false;
        x.add(Float.valueOf(String.valueOf(input9.getText())));
        TextView input10=findViewById(R.id.input10);
        if(input10.getText().toString().trim().length()==0) return false;
        x.add(Float.valueOf(String.valueOf(input10.getText())));
        TextView input11=findViewById(R.id.input11);
        if(input11.getText().toString().trim().length()==0) return false;
        x.add(Float.valueOf(String.valueOf(input11.getText())));
        TextView input12=findViewById(R.id.input12);
        if(input12.getText().toString().trim().length()==0) return false;
        x.add(Float.valueOf(String.valueOf(input12.getText())));
        TextView input13=findViewById(R.id.input13);
        if(input13.getText().toString().trim().length()==0) return false;
        x.add(Float.valueOf(String.valueOf(input13.getText())));
        TextView input14=findViewById(R.id.input14);
        if(input14.getText().toString().trim().length()==0) return false;
        x.add(Float.valueOf(String.valueOf(input14.getText())));
        TextView input15=findViewById(R.id.input15);
        if(input15.getText().toString().trim().length()==0) return false;
        x.add(Float.valueOf(String.valueOf(input15.getText())));
        TextView input16=findViewById(R.id.input16);
        if(input16.getText().toString().trim().length()==0) return false;
        x.add(Float.valueOf(String.valueOf(input16.getText())));
        TextView input17=findViewById(R.id.input17);
        if(input17.getText().toString().trim().length()==0) return false;
        x.add(Float.valueOf(String.valueOf(input17.getText())));
        TextView input18=findViewById(R.id.input18);
        if(input18.getText().toString().trim().length()==0) return false;
        x.add(Float.valueOf(String.valueOf(input18.getText())));
        TextView input19=findViewById(R.id.input19);
        if(input19.getText().toString().trim().length()==0) return false;
        x.add(Float.valueOf(String.valueOf(input19.getText())));
        return true;
    }

    private void OutputWrite(float[] y){
        TextView out1=findViewById(R.id.output1);
        out1.setText(String.valueOf(y[0]));
        TextView out2=findViewById(R.id.output2);
        out2.setText(String.valueOf(y[1]));
        TextView out3=findViewById(R.id.output3);
        out3.setText(String.valueOf(y[2]));
    }

    private String assetFilePath(Context context, String assetName) {
        File file = new File(context.getFilesDir(), assetName);
        try (InputStream is = context.getAssets().open(assetName)) {
            try (OutputStream os = new FileOutputStream(file)) {
                byte[] buffer = new byte[4 * 1024];
                int read;
                while ((read = is.read(buffer)) != -1) {
                    os.write(buffer, 0, read);
                }
                os.flush();
            }
            return file.getAbsolutePath();
        } catch (IOException e) {
            Log.e("pytorchandroid", "Error process asset " + assetName + " to file path");
        }
        return null;
    }
}