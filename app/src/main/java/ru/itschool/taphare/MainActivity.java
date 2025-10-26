package ru.itschool.taphare;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int counter;
    ImageView imgHare;
    TextView textTop, textBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imgHare = findViewById(R.id.imageView);
        textTop = findViewById(R.id.textTop);
        textBottom = findViewById(R.id.textBottom);
    }

    public void tapHare(View view) {
        counter++;
        String end = counter%10>1 && counter%10<5 && counter/10%10!=1 ? " раза" : " раз";
        String text = "Потапали "+counter+end;
        textBottom.setText(text);
    }
}