package com.example.themodernbibliothecaandroid.Repository;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityRepository {
    public void BindActivities(Context context) {
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://themodernbibliotheca.azurewebsites.net/Admin/Activity.aspx/Json";

        StringRequest getRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        List<Activity> activities = new ArrayList<>();
                        try {
                            JSONArray objects = new JSONObject(response).getJSONArray("d");

                            for(int i = 0; i < objects.length(); i++){
                                JSONObject current = objects.getJSONObject(i);

                                Activity activity = new Activity();
                                activity.accountType = current.getString("UserType");
                                activity.email = current.getString("Email");
                                activity.description = current.getString("Description");
                                String tempDate = current.getString("TimeStamp");
                                long time = Long.parseLong(tempDate.replaceFirst("^.*Date\\((\\d+)\\).*$", "$1"));
                                activity.date = new Date(time);

                                activities.add(activity);

                                Toast.makeText(context, "SUCCESS: " + activity, Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Toast.makeText(context, "ERROR:" + error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json");
                return params;
            }
        };
        queue.add(getRequest);
    }
}
