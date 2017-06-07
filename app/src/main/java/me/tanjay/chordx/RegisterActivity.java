package me.tanjay.chordx;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class RegisterActivity extends AppCompatActivity {
    EditText first, last, email, username, password, phone;
    Button btn;
    String RequestUrl = "http://52.55.145.88:8001/register";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        first = (EditText) findViewById(R.id.first);
        last = (EditText) findViewById(R.id.last);
        email = (EditText) findViewById(R.id.email);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        phone = (EditText) findViewById(R.id.phone);

        btn = (Button) findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest objectRequest = new StringRequest(Request.Method.POST, RequestUrl, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Log.d("daatt", response.toString());
                        try {
                              JSONObject register = new JSONObject(response);
                            if (register.getString("status").equals("1")) {
                                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
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
                        str.put("first", first.getText().toString());
                        str.put("last", last.getText().toString());
                        str.put("email", email.getText().toString());
                        str.put("username", username.getText().toString());
                        str.put("password", password.getText().toString());
                        str.put("phone", phone.getText().toString());
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


                RequestQueue rq = Volley.newRequestQueue(RegisterActivity.this);
                rq.add(objectRequest);



            }
        });
    }
}
