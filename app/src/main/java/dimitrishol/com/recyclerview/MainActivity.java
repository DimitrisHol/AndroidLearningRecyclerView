package dimitrishol.com.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    private ArrayList<String> imageUrls = new ArrayList<String>();
    private ArrayList<String> titles = new ArrayList<String>();
    private ArrayList<String> descriptions = new ArrayList<String>();
    private ArrayList<String> dates = new ArrayList<String>();
    private ArrayList<String> sources = new ArrayList<String>();
    private ArrayList<String> urls= new ArrayList<String>();

    private RequestQueue mQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        initiateNews();
//        initiateRecyclerView();


        // Get refference to the button
        Button fetchButton = findViewById(R.id.fetch_data_button);

        // Create Volley Queue


        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d(TAG, "onClick: Pressed the Parse Button");
                jsonParse();

            }
        });



    }

    private void initiateNews() {


        titles.add("Corgi does cute stuff");
        descriptions.add("Corgi was really cute when it did stuff");
        titles.add("Husky does cute stuff");
        descriptions.add("Husky was really cute when it did stuff");
        titles.add("Husky does cute stuff");
        descriptions.add("Husky was really cute when it did stuff");
        titles.add("Golder Retriever does cute stuff");
        descriptions.add("Golden Retriever was really cute when it did stuff");
        titles.add("Dog does cute stuff");
        descriptions.add("Dog was really cute when it did stuff");

        Log.d(TAG, "RV : Got the news");
    }


    private void jsonParse() {


        // Initiate the Request Queue
        String url = "https://newsapi.org/v2/everything?q=bitcoin&from=2019-08-07&sortBy=publishedAt&apiKey=1b2ce28eaee94688ba98a1854d139e1c";
        mQueue = Volley.newRequestQueue(this);


        // Request a string rensponse from the URL
        JsonRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

//                        Log.d(TAG, "onResponse: " + response);

                        try {

                            JSONArray articles = response.getJSONArray("articles");

                            for (int i = 0; i < 10; i++) {

                                JSONObject article = articles.getJSONObject(i);

                                JSONObject source = article.getJSONObject("source");
                                sources.add(source.getString("name"));

                                imageUrls.add(article.getString("urlToImage"));
                                titles.add(article.getString("title"));
                                descriptions.add(article.getString("description"));
                                dates.add(article.getString("publishedAt"));

                                urls.add(article.getString("url"));


                            }


                            initiateRecyclerView();

                        } catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        error.printStackTrace();
                    }
                });


        mQueue.add(jsonRequest);
    }


    private void initiateRecyclerView() {


        // Get the refference to the widget.
        RecyclerView recyclerView = findViewById(R.id.recyclerViewList);

        Log.d(TAG, "RV : Got the reffecnce to RV.");
        // Context, and the 2 arrays. Context is the current activity.
        NewsAdapter adapter = new NewsAdapter(MainActivity.this , imageUrls , titles, descriptions, dates, sources , urls);


        Log.d(TAG, "RV : Created the news Adapter");
        // Finally set the adapter to the RV.
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


}
