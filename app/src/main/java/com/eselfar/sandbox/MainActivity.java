package com.eselfar.sandbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * This project has been created to solve this StackOverflow issue:
 * http://stackoverflow.com/q/43786438/1827254
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // JSON String (Should be get from the server)
        String jsonStr = "{" +
                "\"pdfs\": [{" +
                "\"url_pdf\": \"http://url1.com\"" +
                "}," +
                "{" +
                "\"url_pdf\": \"http://url2.com\"" +
                "}]" +
                "}";

        parseJsonAndDisplayData(jsonStr);
    }

    private void parseJsonAndDisplayData(String jsonStr) {

        try {
            // Instantiate a new ArrayList to store the urls
            ArrayList<String> urls = new ArrayList<>();

            JSONObject contacts = new JSONObject(jsonStr);
            JSONArray jsonArray = contacts.getJSONArray("pdfs");
            // looping through All Contacts
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject c = jsonArray.getJSONObject(i);
                String url_pdf = c.getString("url_pdf");

                // add the url to the array of 'url_pdf'
                urls.add(url_pdf);

                // Display each url retrieved (not necessary)
                System.out.println("PDFSSSSSSS" + url_pdf);
            }

            SixFragment fragment = SixFragment.newInstance(urls);
            getSupportFragmentManager().beginTransaction()
                    // Replace the current Fragment. Use the Fragment class name as tag (can
                    // be useful to find the fragment later)
                    .replace(R.id.ah, fragment, fragment.getClass().getSimpleName())
                    .commit();

        } catch (final JSONException e) {
            Log.e(TAG, "Json parsing error: " + e.getMessage());
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(),
                            "Json parsing error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
