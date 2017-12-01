package com.example.lence.testjsoup.view;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.lence.testjsoup.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements MVP {
TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView)findViewById(R.id.text);
        Presenter presenter = new Presenter(this);
        presenter.loadBirds();


        class Async extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... voids) {
                Log.e("html", "start");
                Document doc = null;
                try {
                    doc = Jsoup.connect("http://cbs-uu.ru/wp-json/wp/v2/posts/1511").get();
//            String s = doc.select("image.src");
                    Log.e("html", doc.html());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }
    }

    @Override
    public void getContent(String s) {
        Document doc = Jsoup.parse(s);
        Log.e("html", doc.select("p").first().toString());
        mTextView.setText(doc.select("p").first().text());

    }

    @Override
    public void showError() {

    }
}
