package com.example.cesarcipher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cesarcipher.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Button button = findViewById(R.id.submitButton);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);

            EditText messageTextBox = binding.messageText;
            String messageText = messageTextBox.getText().toString();

            EditText cypherTextBox = binding.cypherValue;
            int cypherValue = Integer.parseInt(cypherTextBox.getText().toString());

            Bundle bundle = new Bundle();

            bundle.putString("messageText", messageText);
            bundle.putInt("cypherValue", cypherValue);

            intent.putExtras(bundle);

            startActivity(intent);
        });
    }
}