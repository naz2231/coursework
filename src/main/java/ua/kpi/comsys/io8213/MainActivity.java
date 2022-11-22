package ua.kpi.comsys.io8213;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button graphsButton, booksButton, galleryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        graphsButton = findViewById(R.id.graphButton);
        graphsButton.setOnClickListener(this);

        booksButton = findViewById(R.id.booksButton);
        booksButton.setOnClickListener(this);

        galleryButton = findViewById(R.id.galleryButton);
        galleryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.graphButton:
                startActivity(new Intent(this, GraphsActivity.class));
                break;
            case R.id.booksButton:
                startActivity(new Intent(this, BooksActivity.class));
                break;
            case R.id.galleryButton:
                startActivity(new Intent(this, GalleryActivity.class));
                break;
            default:
                break;
        }

    }
}