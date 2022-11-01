package com.example.cesarcipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cesarcipher.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {
    private ActivityResultBinding binding;

    String cypher(String messageText, int cypherValue) {

        if (cypherValue < 0 || cypherValue > 25) return "Cipher value invalid\n(needs to be between 0 and 25)";

        char[] cypher = messageText.toLowerCase().toCharArray();

        for(int i = 0; i < cypher.length; i++) {
            if (cypher[i] == ' ') continue;
            int newPos = (char) ((cypher[i] - 'a') + cypherValue) % 26;
            cypher[i] = (char) ('a' + newPos);
        }

        return String.valueOf(cypher);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Bundle bundle = getIntent().getExtras();


        if (bundle != null) {
            String messageText = bundle.getString("messageText");
            int cypherValue = bundle.getInt("cypherValue");

            String translated = cypher(messageText, cypherValue);

            TextView message = binding.cypherMessage;
            message.setText(translated);
        }
    }
}