package me.tanjay.chordx;


import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

import me.tanjay.chordx.adapters.CategoryHolder;
import me.tanjay.chordx.models.CategoryModel;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GeneralFragment} factory method to
 * create an instance of this fragment.
 */
public class GeneralFragment extends Fragment {
    View view;
    ArrayList<CategoryModel> m = new ArrayList<>();
    RecyclerView recyclerView;
    String RequestUrl = "http://52.55.145.88:8001/chords";
    String url = "https://s3.ap-south-1.amazonaws.com/chordx-data/";
    String folder = "chords/";
    String[] myDataset = {"Tanusha", "Jayasinghe"};
    CategoryHolder h;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_general, container, false);
//        grabData();

        getData(container.getContext());


        h = new CategoryHolder(getContext(), m);

        recyclerView = (RecyclerView) view.findViewById(R.id.cat_viewe);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    private void getData(Context con) {
        StringRequest req = new StringRequest(RequestUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject objArr = new JSONObject(response);
                    Log.d("TAAAGgg", objArr.getJSONArray("message").toString());
                    JSONArray arr = objArr.getJSONArray("message");
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject obj = arr.getJSONObject(i);
                        CategoryModel model = new CategoryModel();
                        model.setCategoryId(obj.getInt("id"));
                        model.setImageURI(url + folder + obj.getString("chord_img"));
                        model.setCategoryDescription(obj.getString("chord_level"));
                        model.setCategoryName(obj.getString("chord"));
                        m.add(model);
                    }
                    h.notifyDataSetChanged();
                    recyclerView.setAdapter(h);
                } catch (JSONException e) {
//                    e.printStackTrace();
                    Log.d("TAAAGGG", e.getLocalizedMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue q = Volley.newRequestQueue(getContext());
        q.add(req);
    }


    }


