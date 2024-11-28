package com.example.sekos;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        // Get the passed data from the Intent
        String itemName = getIntent().getStringExtra("item_name");
        String description = getIntent().getStringExtra("item_description");
        int itemImageResId = getIntent().getIntExtra("item_image", -1);

        // Find views in the layout
        TextView itemTitle = findViewById(R.id.itemName);
        TextView itemDescription = findViewById(R.id.itemdescription); // Fixed ID
        ImageView itemImage = findViewById(R.id.itemImage);

        // Set the values on the views
        itemTitle.setText(itemName);
        itemDescription.setText(description); // Set the description
        itemImage.setImageResource(itemImageResId);
    }
}