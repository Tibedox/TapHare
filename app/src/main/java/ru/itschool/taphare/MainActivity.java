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
    TextView textCoins;

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
        imgHare = findViewById(R.id.imageHare);
        textTop = findViewById(R.id.textTop);
        textBottom = findViewById(R.id.textBottom);
        textCoins = findViewById(R.id.textCoin);
    }

    public void tapHare(View view) {
        counter++;
        String end = counter%10>1 && counter%10<5 && counter/10%10!=1 ? " раза" : " раз";
        String text = "Потапали "+counter+end;
        textBottom.setText(text);

        int coins = counter/10;
        if(coins%10==1 && coins/10%10!=1) end = " рубль";
        else if (coins%10>1 && coins%10<5 && coins/10%10!=1) end = " рубля";
        else end = " рублей";
        text = "Натапали "+coins+end;
        textCoins.setText(text);

        if(counter>30) imgHare.setImageResource(R.drawable.hare2);
        if(counter>60) imgHare.setImageResource(R.drawable.hare3);
        if(counter>90) imgHare.setImageResource(R.drawable.hare4);
    }
}
