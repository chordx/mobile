package me.tanjay.chordx;


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
    RecyclerView recyclerView;
    String[] myDataset = {"Tanusha", "Jayasinghe"};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_general, container, false);
//        grabData();
        final ArrayList<CategoryModel> category_models = new ArrayList<>();
//        final ArrayList<String> empN = new ArrayList<>();
        CategoryModel cat = new CategoryModel();
        cat.setCategoryId(1);
        cat.setCategoryName("A");
        cat.setCategoryDescription("Beginers Chord");
        cat.setImageURI(Uri.parse("android.resource://"+getContext().getPackageName()+"/drawable/a"));
        category_models.add(cat);

        CategoryModel cat1 = new CategoryModel();
        cat1.setCategoryId(2);
        cat1.setCategoryName("Am");
        cat1.setCategoryDescription("Beginers Chord");
        //cat.setImageURI();
        cat1.setImageURI(Uri.parse("android.resource://"+getContext().getPackageName()+"/drawable/am"));

        category_models.add(cat1);


        CategoryModel cat2 = new CategoryModel();
        cat2.setCategoryId(2);
        cat2.setCategoryName("C");
        cat2.setImageURI(Uri.parse("android.resource://"+getContext().getPackageName()+"/drawable/c"));
        cat2.setCategoryDescription("Beginers Chord");
        //  cat.setImageURI();
        category_models.add(cat2);

        CategoryModel cat3 = new CategoryModel();
        cat3.setCategoryId(3);
        cat3.setCategoryName("D");
        cat3.setImageURI(Uri.parse("android.resource://"+getContext().getPackageName()+"/drawable/d"));
        cat3.setCategoryDescription("hgffghfhfhbjhjhjhjjjbjh");
        //cat.setImageURI();
        category_models.add(cat3);


        CategoryModel cat4 = new CategoryModel();
        cat4.setCategoryId(4);
        cat4.setCategoryName("E");
        cat4.setImageURI(Uri.parse("android.resource://"+getContext().getPackageName()+"/drawable/e"));
        cat4.setCategoryDescription("Beginers Chord");
        //cat.setImageURI();
        category_models.add(cat4);

        CategoryModel cat5 = new CategoryModel();
        cat5.setCategoryId(5);
        cat5.setCategoryName("G");
        cat5.setCategoryDescription("Beginers Chord");
        cat5.setImageURI(Uri.parse("android.resource://"+getContext().getPackageName()+"/drawable/g"));
        //cat.setImageURI();
        category_models.add(cat5);


        recyclerView = (RecyclerView) view.findViewById(R.id.cat_viewe);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CategoryHolder(getContext(), category_models));
        return view;
    }

    private void grabData(){
        final ArrayList<CategoryModel> category_models = new ArrayList<>();
//        final ArrayList<String> empN = new ArrayList<>();


//        CategoryModel cat = new CategoryModel();
//        cat.setCategoryId(1);
//        cat.setCategoryName("A");
//        cat.setCategoryDescription("Beginers Chord");
//        cat.setImageURI(Uri.parse("android.resource://"+getContext().getPackageName()+"/drawable/a"));
//        category_models.add(cat);
//
//        CategoryModel cat1 = new CategoryModel();
//        cat1.setCategoryId(2);
//        cat1.setCategoryName("B");
//        cat1.setCategoryDescription("Beginers Chord");
//        //cat.setImageURI();
//        cat1.setImageURI(Uri.parse("android.resource://"+getContext().getPackageName()+"/drawable/b"));
//
//        category_models.add(cat1);
//
//
//        CategoryModel cat2 = new CategoryModel();
//        cat2.setCategoryId(2);
//        cat2.setCategoryName("C");
//        cat2.setImageURI(Uri.parse("android.resource://"+getContext().getPackageName()+"/drawable/c"));
//        cat2.setCategoryDescription("Beginers Chord");
//      //  cat.setImageURI();
//        category_models.add(cat2);
//
//        CategoryModel cat3 = new CategoryModel();
//        cat3.setCategoryId(3);
//        cat3.setCategoryName("D");
//        cat3.setImageURI(Uri.parse("android.resource://"+getContext().getPackageName()+"/drawable/d"));
//        cat3.setCategoryDescription("hgffghfhfhbjhjhjhjjjbjh");
//        //cat.setImageURI();
//        category_models.add(cat3);
//
//
//        CategoryModel cat4 = new CategoryModel();
//        cat4.setCategoryId(4);
//        cat4.setCategoryName("E");
//        cat4.setImageURI(Uri.parse("android.resource://"+getContext().getPackageName()+"/drawable/e"));
//        cat4.setCategoryDescription("Beginers Chord");
//        //cat.setImageURI();
//        category_models.add(cat4);
//
//        CategoryModel cat5 = new CategoryModel();
//        cat5.setCategoryId(5);
//        cat5.setCategoryName("F");
//        cat5.setCategoryDescription("Beginers Chord");
//        cat5.setImageURI(Uri.parse("android.resource://"+getContext().getPackageName()+"/drawable/g"));
//        //cat.setImageURI();
//        category_models.add(cat5);











//        for (int i = 0; i < 10; i++) {
//            CategoryModel cat = new CategoryModel();
//            cat.setCategoryId(i);
//            cat.setCategoryName("Tanusha" + i++);
//            cat.setCategoryDescription("hgffghfhfhbjhjhjhjjjbjh");
//            cat.setImageURI();
//            category_models.add(cat);
//        }
//        JsonArrayRequest arr = new JsonArrayRequest(MainResource.getInstance().getEMPLOYEEURL(), new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                Log.d(MainResource.TAG_DEBUG, response.toString());
//
//                JSONArray arr = response;
//                for (int i = 0; i < arr.length(); i++) {
//                    try {
//                        JSONObject machine = arr.getJSONObject(i);
//                        Employee_model emp = new Employee_model();
//                        emp.setId(machine.getString("id"));
//                        emp.setName(machine.getString("name"));
//                        emp.setImage(machine.getString("image"));
//                        empN.add(machine.getString("name"));
//                        employee_models.add(emp);
//                        Log.d(MainResource.TAG_DEBUG, employee_models.size() + "Leng");
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }

//                    recyclerView.setAdapter(new CategoryHolder(getContext(), category_models));
//                    Log.d(MainResource.TAG_DEBUG, Arrays.toString(empN.toArray(new String[empN.size()])));
//                    MainResource.getInstance().setEmployees(empN.toArray(new String[empN.size()]));
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
////                new SweetAlertDialog(getActivity(), SweetAlertDialog.ERROR_TYPE)
////                        .setTitleText("Oops...")
////                        .setContentText("No Records were found here")
////                        .show();
////                Log.d(MainResource.TAG_DEBUG, Log.getStackTraceString(error));
//
//            }
//        });
//
//        RequestQueue rq = Volley.newRequestQueue(getContext());
////        main.requestQueue = Volley.newRequestQueue(getContext());
//        rq.add(arr);


    }

}
