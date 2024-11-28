package com.example.sekos;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private KosAdapter kosAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize RecyclerView
        recyclerView = view.findViewById(R.id.recyclerViewKos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Set the adapter to RecyclerView (assuming you have a KosAdapter and data ready)
        kosAdapter = new KosAdapter(getContext(), getKosData()); // Assuming getKosData() fetches data
        recyclerView.setAdapter(kosAdapter);

        return view;
    }

    // Method to get sample data (this could come from an API or database)
    private List<Kos> getKosData() {
        List<Kos> kosList = new ArrayList<>();
        kosList.add(new Kos("Kos A", "Jalan Merdeka No. 1", "1,500,000", R.drawable.kos2));
        kosList.add(new Kos("Kos B", "Jalan Raya No. 2", "1,200,000", R.drawable.kos3));
        kosList.add(new Kos("Kos C", "Jalan Sudirman No. 3", "1,800,000", R.drawable.kos4));
        return kosList;
    }
}
