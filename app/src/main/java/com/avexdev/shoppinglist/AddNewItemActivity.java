package com.avexdev.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AddNewItemActivity extends AppCompatActivity{
    private EditText item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);
        item = findViewById(R.id.addItem);
    }

    public void addNewItem(View view){
        String itemToAdd = item.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("Item", itemToAdd);
        setResult(RESULT_OK, intent);
        Log.d("sendingItem", itemToAdd);
        finish();
    }
}
