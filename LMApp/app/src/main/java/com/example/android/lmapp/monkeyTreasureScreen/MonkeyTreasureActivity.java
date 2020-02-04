package com.example.android.lmapp.monkeyTreasureScreen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.android.lmapp.R;

public class MonkeyTreasureActivity extends AppCompatActivity implements GameFieldAdapter.ViewHolder.clickListener {
    RecyclerView gameField;
    GameFieldAdapter adapter = new GameFieldAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monkey_treasure);
        gameField = findViewById(R.id.gameField);
        gameField.setLayoutManager(new GridLayoutManager(this,9));
        generateTiles(adapter);
        gameField.setAdapter(adapter);
    }
    void generateTiles(GameFieldAdapter adapter){
        MonkeyTreasureTile [] tiles = new MonkeyTreasureTile []{
                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,true, false),
                new MonkeyTreasureTile(false,false,false,true, false),
                new MonkeyTreasureTile(false,false,true,false, false),
                new MonkeyTreasureTile(false,false,false,false, true),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,true,false, false),
                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,true, false),

                new MonkeyTreasureTile(false,false,false,true, false),
                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,true, false),
                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,true, false),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,true, false),
                new MonkeyTreasureTile(false,false,false,true, false),

                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,false,true, false),
                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,true, false),

                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,true, false),
                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,true, false),
                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,true, false),
                new MonkeyTreasureTile(false,false,false,true, false),

                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,false,true, false),
                new MonkeyTreasureTile(false,false,false,true, false),
                new MonkeyTreasureTile(false,true,false,false,false),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,true,false,false),

                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,true, false),
                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,true, false),
                new MonkeyTreasureTile(false,false,false,true,false),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,true,false,false),

                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,false,false, false),
                new MonkeyTreasureTile(false,false,true,false,false),

                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,true, false),
                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,true, false),
                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,true, false),
                new MonkeyTreasureTile(false,false,true,false,false),

                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,true, false),
                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,true, false),
                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,true,false,false),
                new MonkeyTreasureTile(false,false,false,true, false),
                new MonkeyTreasureTile(false,false,true,false,false)
        };
        adapter.setData(tiles);
    }

    @Override
    public void makeMessage(boolean condition) {
        String message = condition ? "Ты помог мартышке найти золото! Сыграем еще раз?" : "Ты проиграл! Сыграем еще раз?";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Игра завершена")
                .setMessage(message)
                .setCancelable(false)
                .setNegativeButton("Заново", (dialog, which) -> {
                    generateTiles(adapter);
                    adapter.resetPositionts(40);
                    dialog.cancel();
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
