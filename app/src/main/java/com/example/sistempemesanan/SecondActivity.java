package com.example.sistempemesanan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView cetak;
    TextView inputan;
    EditText txtJumlah;
    Button btnOk;

    public static final String REPLY_EXTRA = "REPLY_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        cetak = findViewById(R.id.txtView1);
        inputan = findViewById(R.id.txtView2);
        txtJumlah = findViewById(R.id.editTextJml);
        btnOk = findViewById(R.id.btnOk);

        Intent intent = getIntent();
        String pesan = intent.getStringExtra(MainActivity.MESSAGE_EXTRA);
        inputan.setText(pesan);

        String pesan1 = intent.getStringExtra("key");
        cetak.setText(pesan1);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String replyPesan = txtJumlah.getText().toString();
                intent.putExtra(REPLY_EXTRA, replyPesan);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}