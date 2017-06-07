package me.tanjay.chordx;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    EditText username, password;
    Button submit;
    String RequestUrl = "http://52.55.145.88:8001/login";
    FloatingActionButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn = (FloatingActionButton) findViewById(R.id.fab);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        submit = (Button) findViewById(R.id.submit);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String user = username.getText().toString();
                final String pass = password.getText().toString();

                StringRequest objectRequest = new StringRequest(Request.Method.POST, RequestUrl, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Log.d("daatt", response.toString());
                        try {
                            JSONObject register = new JSONObject(response);
                            if (register.getString("status").equals("1")) {
                                username.getText().clear();
                                password.getText().clear();
                                SharedPreferences.Editor sharedPreferences = getSharedPreferences("API_KEY", MODE_PRIVATE).edit();
                                sharedPreferences.putString("KEY", register.getJSONArray("message").getJSONObject(0).getString("api_key"));
                                sharedPreferences.commit();
                                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                finish();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.getStackTraceString(error);

                    }
                })


                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> str = new HashMap<>();
                        str.put("username", user);
                        str.put("password", pass);
                        return str;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        Log.d("Data", "Auth");
                        params.put("Content-Type", "application/x-www-form-urlencoded");
                        return params;
                    }
                };


                RequestQueue rq = Volley.newRequestQueue(LoginActivity.this);
                rq.add(objectRequest);


            }
        });


    }

}
