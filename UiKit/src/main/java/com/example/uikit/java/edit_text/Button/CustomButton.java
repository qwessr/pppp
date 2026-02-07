package com.example.uikit.java.edit_text.Button;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.uikit.R;

public class CustomButton extends ConstraintLayout {
    public Button Bth;
    public enum TypeButton{
        PRIMARY,TETRIARY,SECONADRY,OFF,ON
    }
    public CustomButton(@NonNull Context context) {
        super(context);
    }

    public CustomButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(Integer idLayoout){
        if (idLayoout==null||idLayoout==0) return;
        this.removeAllViews();
        LayoutInflater.from(getContext()).inflate(idLayoout,this,true);
        Bth = findViewById(R.id.bth);
    }

    public void init(String value, TypeButton type){
        Bth.setText(value);

        if (type == TypeButton.PRIMARY||type == TypeButton.ON){
            Bth.setBackgroundResource(R.drawable.bth_primary);
            Bth.setTextColor(Color.parseColor("#ffffff"));
        }
        if (type == TypeButton.SECONADRY){
            Bth.setBackgroundResource(R.drawable.bth_secondary);
            Bth.setTextColor(Color.parseColor("#ffffff"));
        }
        if (type == TypeButton.TETRIARY){
            Bth.setBackgroundResource(R.drawable.bth_tetriary);
            Bth.setTextColor(Color.parseColor("#ffffff"));
        }
        if (type == TypeButton.OFF){
            Bth.setBackgroundResource(R.drawable.bth_tetriary);
            Bth.setTextColor(Color.parseColor("#ffffff"));
            this.setEnabled(false);
        }
    }
    public void setEnabled(boolean enabled){
        super.setEnabled(enabled);
        Bth.setEnabled(enabled);
    }
}
