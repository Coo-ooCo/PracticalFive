package com.example.practicalfive;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText etMunicipality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMunicipality = findViewById(R.id.etMunicipality);

        etMunicipality.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_GO || actionId == EditorInfo.IME_ACTION_DONE) {
                String input = etMunicipality.getText().toString();
                String processedName = TextProcessor.processMunicipality(input);

                if (processedName == null) {
                    Toast.makeText(MainActivity.this, "Invalid municipality name. Please try again.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, Municipality.class);
                    intent.putExtra("MUNICIPALITY_NAME", processedName);
                    startActivity(intent);
                    etMunicipality.setText(""); // 清空输入框
                }
                return true;
            }
            return false;
        });
    }
}