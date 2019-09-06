package dimitrishol.com.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    private ArrayList<String> titles = new ArrayList<String>();
    private ArrayList<String> descriptions = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initiateNews();
        initiateRecyclerView();
        
    }

    private void initiateNews(){



        titles.add("Corgi does cute stuff");
        descriptions.add("Corgi was really cute when it did stuff");

        titles.add("Husky does cute stuff");
        descriptions.add("Husky was really cute when it did stuff");
        titles.add("Husky does cute stuff");
        descriptions.add("Husky was really cute when it did stuff");
        titles.add("Husky does cute stuff");
        descriptions.add("Husky was really cute when it did stuff");
        titles.add("Husky does cute stuff");
        descriptions.add("Husky was really cute when it did stuff");
        titles.add("Husky does cute stuff");
        descriptions.add("Husky was really cute when it did stuff");
        titles.add("Husky does cute stuff");
        descriptions.add("Husky was really cute when it did stuff");
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
    
    
    private void initiateRecyclerView(){




        // Get the refference to the widget.
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewList);

        Log.d(TAG, "RV : Got the reffecnce to RV.");
        // Context, and the 2 arrays. Context is the current activity.
        NewsAdapter adapter = new NewsAdapter(MainActivity.this , titles, descriptions);

        Log.d(TAG, "RV : Created the news Adapter");
        // Finally set the adapter to the RV.
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    
    
    
    
}
