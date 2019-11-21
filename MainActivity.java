package com.example.jsoninsert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText edt1,edt2;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        btn=findViewById(R.id.btn);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                final String name2=edt1.getText().toString();
                final String email=edt2.getText().toString();



                StringRequest stringRequest=new StringRequest(Request.Method.POST, "https://prakrutivyas.000webhostapp.com/regserver/myinsertfile.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        Toast.makeText(MainActivity.this, "inserted", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this, "No internet", Toast.LENGTH_SHORT).show();

                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                       HashMap map=new HashMap();
                       map.put("name",name2);
                       map.put("email",email);
                        return map;
                    }
                };


                RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
                queue.add(stringRequest);




            }
        });


    }
}
