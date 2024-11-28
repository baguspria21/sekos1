package com.example.sekos;

import android.content.res.TypedArray;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    private ItemAdapter adapter;
    private List<Item> items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        // Initialize RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Get data from strings.xml
        String[] itemsArray = getResources().getStringArray(R.array.list_items);
        String[] itemsPrice = getResources().getStringArray(R.array.price_list);

        // Get image resources from arrays.xml
        TypedArray images = getResources().obtainTypedArray(R.array.image_items);

        items = new ArrayList<>();

        // Populate the list with data and images
        for (int i = 0; i < itemsArray.length; i++) {
            items.add(new Item(itemsArray[i], images.getResourceId(i, -1), itemsPrice[i]));  // Tambahkan price
        }

        // Set up the adapter
        adapter = new ItemAdapter(getContext(), items);
        recyclerView.setAdapter(adapter);

        // Initialize SearchView and link it with the adapter
        SearchView searchView = view.findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Handle query submission if needed (you can perform actions here)
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter the items as the query changes
                adapter.filter(newText);  // Call filter method in adapter
                return false;  // Return false to allow other actions
            }
        });

        return view;
    }
}
