package ru.dp.elitesch;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import android.content.Intent;
import android.net.Uri;

import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.UpdateFrom;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        new AppUpdater(this)
                .setUpdateFrom(UpdateFrom.XML)
                .setUpdateXML("https://raw.githubusercontent.com/DPritu/elitesch/master/update-changelog.xml")
                .setTitleOnUpdateAvailable("Доступна новая версия!")
                .setButtonUpdate("Обновить")
                .setButtonDoNotShowAgain(null)
                .setButtonDismiss(null)
                .start();

        ImageView img = findViewById(R.id.DP_logo);

        img.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://pritu.ru"));
                startActivity(intent);
            }
        });
    }
}
