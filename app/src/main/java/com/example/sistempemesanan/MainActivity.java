package com.example.sistempemesanan;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtMenu;
    Button makanan;
    Button minuman;
    TextView txtJumlah;
    public static final String MESSAGE_EXTRA = "MESSAGE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMenu = findViewById(R.id.editTextMenu);
        makanan = findViewById(R.id.btnMkn);
        minuman = findViewById(R.id.btnMin);
        txtJumlah = findViewById(R.id.editTextJml);

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            String replyText = result.getData().getStringExtra(SecondActivity.REPLY_EXTRA);
                            txtJumlah.setText(replyText);
                        }
                    }
                });

        makanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                String pesan = txtMenu.getText().toString();
                intent.putExtra(MESSAGE_EXTRA, pesan);
                intent.putExtra("key", "Makanan");
                launcher.launch(intent);
            }
        });

        minuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(view.getContext(),SecondActivity.class);
                String pesan1 = txtMenu.getText().toString();
                intent1.putExtra(MESSAGE_EXTRA, pesan1);
                intent1.putExtra("key", "Minuman");
                launcher.launch(intent1);
            }
        });
    }
}