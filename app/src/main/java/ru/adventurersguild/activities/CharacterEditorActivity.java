package ru.adventurersguild.activities;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Pattern;

import ru.adventurersguild.R;

public class CharacterEditorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_create);
        TextInputEditText name = findViewById(R.id.name_character_editor);
        name.setFilters(nameFilters);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.character_create);
    }

    private static final TextWatcher nameTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private static final InputFilter[] nameFilters = new InputFilter[]{
            new InputFilter.LengthFilter(10),
            new InputFilter() {
                @Override
                public CharSequence filter(CharSequence charSequence, int i, int i1, Spanned spanned, int i2, int i3) {
                    if (charSequence.toString().matches("[\\p{L}-]*"))
                        return null;
                    else return "";
                }
            }
    };

}
