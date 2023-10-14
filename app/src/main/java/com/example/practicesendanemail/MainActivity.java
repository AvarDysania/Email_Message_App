package com.example.practicesendanemail;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button send , show;
    EditText to , subject ,message;
    TextView display ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send=findViewById(R.id.button);
        to=findViewById(R.id.editTextText2);
        subject=findViewById(R.id.editTextText3);
        display=findViewById(R.id.editTextText3);
        message=findViewById(R.id.editTextText);
        show=findViewById(R.id.button2);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent perform = new Intent(Intent.ACTION_SEND);
                perform.putExtra(Intent.EXTRA_EMAIL,new String[] {to.toString()});
                perform.putExtra(Intent.EXTRA_SUBJECT,subject.toString());
                perform.putExtra(Intent.EXTRA_TEXT,message.toString());

                perform.setType("message/rfc822");
                startActivity(Intent.createChooser(perform,"mail.shimonjoel003@gmail.com"));
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to_meesage=to.getText().toString();
                String display_message=message.getText().toString();
                String subject_display=subject.getText().toString();

                show.setText(String.format("This Message is Sent to %s which is for:  %s and contains some personal info",to_meesage,subject_display));
            }
        });
    }
}