package com.example.themodernbibliothecaandroid.Repository;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActivityRepository {
    public void BindActivities(Context context, ActivityAdapter adapter) {



        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "https://themodernbibliotheca.azurewebsites.net/Admin/Activity.aspx/Json";

        StringRequest getRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    List<Activity> activities = new ArrayList<>();
                    try {
                        JSONArray objects = new JSONObject(response).getJSONArray("d");

                        int count = Math.min(objects.length(), 100);
                        for(int i = 0; i < count; i++){
                            JSONObject current = objects.getJSONObject(i);

                            String tempDate = current.getString("TimeStamp");
                            long time = Long.parseLong(tempDate.replaceFirst("^.*Date\\((\\d+)\\).*$", "$1"));
                            Activity activity = new Activity(
                                    new Date(time),
                                    current.getString("Email"),
                                    current.getString("Description"),
                                    current.getString("UserType"));

                            activities.add(activity);
                        }

                        adapter.setDataChange(activities);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> Toast.makeText(context, "ERROR:" + error.getLocalizedMessage(), Toast.LENGTH_LONG).show()
        ) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json");
                return params;
            }
        };
        queue.add(getRequest);
    }
}
