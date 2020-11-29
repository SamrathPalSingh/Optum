package com.example.alarm;

        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Toast;


        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.toolbox.StringRequest;
        import com.android.volley.toolbox.Volley;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.util.ArrayList;
        import java.util.List;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;


public class DoctorsList extends AppCompatActivity {

    private static final String URL_DATA = "https://randomuser.me/api/";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_list);

        recyclerView = findViewById(R.id.ourdoes);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        ListItem listItem1 = new ListItem(
                "Amisha Mittal",
                "M.B.B.S, M.D.",
                ""
        );
        listItems.add(listItem1);
        ListItem listItem = new ListItem(
                "Sharvi Sethi",
                "M.B.B.S, M.D.",
                ""
        );
        listItems.add(listItem);
        ListItem listItem2 = new ListItem(
                "Pulkit Gupta",
                "B.Tech",
                ""
        );
        listItems.add(listItem2);
        adapter = new MyAdapter(listItems,getApplicationContext());
        recyclerView.setAdapter(adapter);
        //loadRecyclerViewData();
    }
    private void loadRecyclerViewData(){
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA,
                s -> {
                    progressDialog.dismiss();
                    try {
                        JSONObject jsonObject = new JSONObject(s);
                        JSONArray array = jsonObject.getJSONArray("results");
                        for(int i=0;i<array.length();i++){
                            JSONObject o = array.getJSONObject(i);
                            ListItem item = new ListItem(
                                    o.getString("gender"),
                                    o.getString("email"),
                                    o.getString("phone")
                            );
                            listItems.add(item);
                        }
                        adapter = new MyAdapter(listItems,getApplicationContext());
                        recyclerView.setAdapter(adapter);
                    } catch (JSONException e){
                        e.printStackTrace();
                    }
                },
                error -> {
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);

    }

    public void doctorlist(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://meet.google.com/bcg-dtoe-zxd"));
        startActivity(browserIntent);
    }
}