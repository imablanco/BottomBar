package com.example.bottombar.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

/**
 * Created by Álvaro Blanco Cabrero on 24/06/2017.
 * BottomBar.
 */
public class ProgrammaticallyTabsActivity extends AppCompatActivity {

    private TextView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmatically_tabs);

        messageView = (TextView) findViewById(R.id.messageView);

        final BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);

        bottomBar.setBackgroundColorWhenSelected(Color.RED);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                messageView.setText(ProgrammaticallyTabMessage.get(tabId, false));
            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                Toast.makeText(getApplicationContext(),
                        ProgrammaticallyTabMessage.get(tabId, true), Toast.LENGTH_LONG).show();
            }
        });

        bottomBar.addItem(ProgrammaticallyTabMessage.FAVORITES, "Favorites", R.drawable.ic_favorites);
        bottomBar.addItem(ProgrammaticallyTabMessage.NEARBY, "Nearby", ContextCompat.getDrawable(this, R.drawable.ic_nearby));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                bottomBar.addItem(ProgrammaticallyTabMessage.FRIENDS, "Friends", R.drawable.ic_friends);
            }
        }, 1500);
    }
}
