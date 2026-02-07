package com.example.uikit.java.edit_text;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.uikit.R;

public class CustomEditText extends ConstraintLayout {
    public EditText editText;
    public TextView textView, errorTextView;
    public boolean onError = false;

    public CustomEditText(@NonNull Context context) {
        super(context);
        init(null);
    }

    public CustomEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(null);
    }
    public CustomEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(null);
    }

    public void init(Integer idLayout){
        if(idLayout== null) return;

        LayoutInflater.from(getContext()).inflate(idLayout,this,true);
        editText = findViewById(R.id.et_edit_text);
        textView = findViewById(R.id.tvTextView);
        errorTextView = findViewById(R.id.tvTextView);

        if (editText!=null){
            editText.setOnFocusChangeListener(FocusListener);
        }
    }

    public void init(String title, String hint, String text){
        if (title.isEmpty()){
            textView.setVisibility(View.GONE);
        }else {
            textView.setText(title);
            textView.setVisibility(VISIBLE);
        }

        editText.setText(text);
        editText.setHint(hint);
    }
    public OnFocusChangeListener FocusListener = (v,hasFocus)->setState();

    public void OnError(boolean state,String errorText){
        if(errorTextView!=null){
            errorTextView.setText(errorText);
        }
        onError = state;
        setState();
    }
    private void setState() {
        if (onError){
            editText.setBackgroundResource(R.drawable.et_state_error);
            if (errorTextView !=null){
                errorTextView.setVisibility(VISIBLE);
            }
        }else {
            if (errorTextView!=null){
                errorTextView.setVisibility(INVISIBLE);
            }
            editText.setBackgroundResource(R.drawable.et_selector);
        }
    }
}
