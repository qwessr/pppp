package com.example.uikit.java.edit_text;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.uikit.R;

public class EtDefualt extends ConstraintLayout {
    public TextView textView;
    public EditText editText;
    private  boolean onError = false;

    public EtDefualt(@NonNull Context context) {
        super(context);
    }

    public EtDefualt(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public EtDefualt(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init()
    {
        LayoutInflater.from(getContext()).inflate(R.layout.et_defualt,this,true);
        editText = findViewById(R.id.et_edit_text);
        textView = findViewById(R.id.tvTextView);

        if (editText!=null)
        {
            editText.setOnFocusChangeListener(FocusListener);
        }
    }
    public void init(String title, String hint, String text)
    {
        if (editText !=null) {


            if (title == null || title.isEmpty()) {
                textView.setVisibility(View.GONE);
            } else {
                textView.setText(title);
                textView.setVisibility(View.VISIBLE);
            }
        }

        if (editText != null)
        {
            editText.setHint(hint);
            editText.setText(text);
        }
    }

    public void init (String title, String hint){init(title, hint,"");}

    public OnFocusChangeListener FocusListener = (v,hasFocus)->setState();

    protected void setState() {
        if (editText == null) return;

        if (onError)
        {
            editText.setBackgroundResource(R.drawable.et_state_error);
        }
        else {
            if (String.valueOf(editText.getText()).isEmpty())
            {
                editText.setBackgroundResource(R.drawable.et_stste_defualt);
            }
            else {
                editText.setBackgroundResource(R.drawable.et_state_filled);
            }
        }
    }

}
