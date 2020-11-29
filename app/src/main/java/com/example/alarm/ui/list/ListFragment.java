package com.example.alarm.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alarm.ListItem;
import com.example.alarm.MyAdapter;
import com.example.alarm.MyAdapterPatient;
import com.example.alarm.R;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private ListViewModel galleryViewModel;
    private RecyclerView r;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(ListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_list, container, false);

        r = root.findViewById(R.id.ourdoes);
        r.setHasFixedSize(true);
        r.setLayoutManager(new LinearLayoutManager(getContext()));
        listItems = new ArrayList<>();

        ListItem listItem1 = new ListItem(
                "Sarthak Sharma",
                "eccentric.sarthak@gmail.com",
                ""
        );
        listItems.add(listItem1);
        ListItem listItem = new ListItem(
                "Pulkit Gupta",
                "pulkitg64@gmail.com",
                ""
        );
        listItems.add(listItem);
        ListItem listItem2 = new ListItem(
                "Sharvi Sethi",
                "sharvisethi@gmail.com",
                ""
        );
        listItems.add(listItem2);

        adapter = new MyAdapterPatient(listItems,getContext());
        r.setAdapter(adapter);
//        final TextView textView = root.findViewById(R.id.text_gallery);
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}