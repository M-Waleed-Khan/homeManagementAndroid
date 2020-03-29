package com.example.homemanagement;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddItem extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {


    EditText editTextItemName,editTextBrand;
    Button buttonAddItem;
    String text;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_item);

        editTextItemName = (EditText)findViewById(R.id.et_item_name);
        editTextBrand = (EditText)findViewById(R.id.et_brand);

        buttonAddItem = (Button)findViewById(R.id.btn_add_item);
        buttonAddItem.setOnClickListener(this);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinnerArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);




    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    //This is the part where data is transafeered from Your Android phone to Sheet by using HTTP Rest API calls

    private void   addItemToSheet() {
        switch (text) {
            case "BabySitter":
                final ProgressDialog loading = ProgressDialog.show(this, "Adding Item", "Please wait");
                final String name = editTextItemName.getText().toString().trim();
                final String brand = editTextBrand.getText().toString().trim();


                StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycby6GPJ2ItFSMsEhSTsiInyjCgfUtAwQQp_MzQsJrMKKlofmVzhx/exec",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                loading.dismiss();
                                Toast.makeText(AddItem.this, response, Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> parmas = new HashMap<>();

                        //here we pass params
                        parmas.put("action", "addItem");
                        parmas.put("name", name);
                        parmas.put("number",brand);

                        return parmas;
                    }
                };

                int socketTimeOut = 50000;// u can change this .. here it is 50 seconds

                RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                stringRequest.setRetryPolicy(retryPolicy);

                RequestQueue queue = Volley.newRequestQueue(this);

                queue.add(stringRequest);


                break;
            case "Electrician":
                final ProgressDialog loadingE = ProgressDialog.show(this, "Adding Item", "Please wait");
                final String nameE = editTextItemName.getText().toString().trim();
                final String brandE = editTextBrand.getText().toString().trim();


                StringRequest stringRequestE = new StringRequest(Request.Method.POST, "\n" + "https://script.google.com/macros/s/AKfycbzvLLBPhregMudldVvk3YFYqPTXF4Fmr95EKJpPY0zTbtQe870P/exec",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                loadingE.dismiss();
                                Toast.makeText(AddItem.this, response, Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> parmas = new HashMap<>();

                        //here we pass params
                        parmas.put("action", "addItem");
                        parmas.put("name", nameE);
                        parmas.put("number", brandE);

                        return parmas;
                    }
                };

                int socketTimeOutE = 50000;// u can change this .. here it is 50 seconds

                RetryPolicy retryPolicyE = new DefaultRetryPolicy(socketTimeOutE, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                stringRequestE.setRetryPolicy(retryPolicyE);

                RequestQueue queueE = Volley.newRequestQueue(this);

                queueE.add(stringRequestE);



                break;
            case "Plumber":
                final ProgressDialog loadingP = ProgressDialog.show(this, "Adding Item", "Please wait");
                final String nameP = editTextItemName.getText().toString().trim();
                final String brandP = editTextBrand.getText().toString().trim();


                StringRequest stringRequestP = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbwVReiP2GMGBLDSxddIU-dZKwM-7idbN_mFiAaKle_rMulM6089/exec",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                loadingP.dismiss();
                                Toast.makeText(AddItem.this, response, Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> parmas = new HashMap<>();

                        //here we pass params
                        parmas.put("action", "addItem");
                        parmas.put("name", nameP);
                        parmas.put("number", brandP);

                        return parmas;
                    }
                };

                int socketTimeOutP = 50000;// u can change this .. here it is 50 seconds

                RetryPolicy retryPolicyP = new DefaultRetryPolicy(socketTimeOutP, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                stringRequestP.setRetryPolicy(retryPolicyP);

                RequestQueue queueP = Volley.newRequestQueue(this);

                queueP.add(stringRequestP);
                break;
            case "Mechanic":
                final ProgressDialog loadingM = ProgressDialog.show(this, "Adding Item", "Please wait");
                final String nameM = editTextItemName.getText().toString().trim();
                final String brandM = editTextBrand.getText().toString().trim();


                StringRequest stringRequestM = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbxaGqfN0vpYFiBkkkul68ZJr6x9wi9URZk-66CCqgv655klyBF9/exec",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                loadingM.dismiss();
                                Toast.makeText(AddItem.this, response, Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> parmas = new HashMap<>();

                        //here we pass params
                        parmas.put("action", "addItem");
                        parmas.put("name", nameM);
                        parmas.put("number", brandM);

                        return parmas;
                    }
                };

                int socketTimeOutM = 50000;// u can change this .. here it is 50 seconds

                RetryPolicy retryPolicyM = new DefaultRetryPolicy(socketTimeOutM, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                stringRequestM.setRetryPolicy(retryPolicyM);

                RequestQueue queueM = Volley.newRequestQueue(this);

                queueM.add(stringRequestM);
                break;
            case "Gardner":
                final ProgressDialog loadingG = ProgressDialog.show(this, "Adding Item", "Please wait");
                final String nameG = editTextItemName.getText().toString().trim();
                final String brandG = editTextBrand.getText().toString().trim();


                StringRequest stringRequestG = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbx8G9gCpkiU8P0pFq6dhvKxsNuAymUmZVjaihkBzghNCwAmfVc/exec",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                loadingG.dismiss();
                                Toast.makeText(AddItem.this, response, Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> parmas = new HashMap<>();

                        //here we pass params
                        parmas.put("action", "addItem");
                        parmas.put("name", nameG);
                        parmas.put("number", brandG);

                        return parmas;
                    }
                };

                int socketTimeOutG = 50000;// u can change this .. here it is 50 seconds

                RetryPolicy retryPolicyG = new DefaultRetryPolicy(socketTimeOutG, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                stringRequestG.setRetryPolicy(retryPolicyG);

                RequestQueue queueG = Volley.newRequestQueue(this);

                queueG.add(stringRequestG);
                break;
            case "Grocery":
                final ProgressDialog loadingGr = ProgressDialog.show(this, "Adding Item", "Please wait");
                final String nameGr = editTextItemName.getText().toString().trim();
                final String brandGr = editTextBrand.getText().toString().trim();


                StringRequest stringRequestGr = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbwrB0IU4RK1nghwiEo4X1L3DFobNw99a_YwcqQRsqG9G3qJtlBM/exec",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                loadingGr.dismiss();
                                Toast.makeText(AddItem.this, response, Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> parmas = new HashMap<>();

                        //here we pass params
                        parmas.put("action", "addItem");
                        parmas.put("name", nameGr);
                        parmas.put("number", brandGr);

                        return parmas;
                    }
                };

                int socketTimeOutGr = 50000;// u can change this .. here it is 50 seconds

                RetryPolicy retryPolicyGr = new DefaultRetryPolicy(socketTimeOutGr, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                stringRequestGr.setRetryPolicy(retryPolicyGr);

                RequestQueue queueGr = Volley.newRequestQueue(this);

                queueGr.add(stringRequestGr);
                break;
            default:
                Toast.makeText(this, "Invalid Selection", Toast.LENGTH_SHORT).show();
                break;

        }
    }




    @Override
    public void onClick(View v) {

        if(v==buttonAddItem){
            addItemToSheet();

            //Define what to do when button is clicked
        }
    }


}

