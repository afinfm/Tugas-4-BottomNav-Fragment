package com.example.tugas4bottomnavfragment.rv;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tugas4bottomnavfragment.R;

public class DetailPahlawan extends AppCompatActivity {
    ImageView ivImage;
    TextView tvDetailNama, tvDetailDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pahlawan);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        ivImage = findViewById(R.id.detailImage);
        tvDetailNama = findViewById(R.id.detailNama);
        tvDetailDetail = findViewById(R.id.detailDetail);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int getImg = bundle.getInt("img_url");
            String getTitle = bundle.getString("title");
            String getDetail = bundle.getString("detail");

            tvDetailNama.setText(getTitle);
            tvDetailDetail.setText(getDetail);
            ivImage.setImageResource(getImg);
        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, com.example.tugas4bottomnavfragment.MainActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
