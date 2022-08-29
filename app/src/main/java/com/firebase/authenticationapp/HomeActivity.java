package com.firebase.authenticationapp;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.pdf.PdfDocument;
import android.icu.text.SimpleDateFormat;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;


public class HomeActivity extends AppCompatActivity {

    private static int choice = 0;
    public static int getChoice() {
        return choice;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button download_image = findViewById(R.id.download_image);
        Button camera = findViewById(R.id.camera);
        Button upload = findViewById(R.id.upload);
        Button gallery_image = findViewById(R.id.gallery_image);
        ProgressBar progressBar = findViewById(R.id.progressbar);
        Button exit = findViewById(R.id.exit);

        progressBar.setVisibility(View.INVISIBLE);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice = 1;
                progressBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(HomeActivity.this, ResultActivity.class));
            }
        });
        download_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice = 2;
                progressBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(HomeActivity.this, ResultActivity.class));
            }
        });
        gallery_image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                choice = 3;
                progressBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(HomeActivity.this, ResultActivity.class));
            }
        });
        exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                choice = 0;
                progressBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(HomeActivity.this, ResultActivity.class));
            }
        });
    }

}