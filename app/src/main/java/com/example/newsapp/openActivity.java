package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.service.quicksettings.Tile;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class openActivity extends AppCompatActivity {

    String title,discription,content,imageUrl,Url;
    private TextView Title,Disc,cont;
    private ImageView image1;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);

        title=getIntent().getStringExtra("title");
        discription=getIntent().getStringExtra("discription");
        content=getIntent().getStringExtra("content");
        imageUrl=getIntent().getStringExtra("image");
        Url=getIntent().getStringExtra("url");

        Title=findViewById(R.id.title1);
        button=findViewById(R.id.button);
        Disc=findViewById(R.id.disc1);
        image1=findViewById(R.id.image1);
        cont=findViewById(R.id.content1);

        Title.setText(title);
        Disc.setText(discription);
        cont.setText(content);
        Picasso.get().load(imageUrl).into(image1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(Url));
                startActivity(intent);
            }
        });

    }
}