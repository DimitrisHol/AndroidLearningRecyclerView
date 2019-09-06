package dimitrishol.com.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private static final String TAG = "NewsAdapter";

    private ArrayList<String> titles = new ArrayList<String>();
    private ArrayList<String> descriptions = new ArrayList<String>();
    private Context context;

    public NewsAdapter(Context context , ArrayList<String> titles, ArrayList<String> descriptions) {
        this.titles = titles;
        this.descriptions = descriptions;
        this.context = context;
    }


    // Responsible for inflating the view, putting the items in the position they should be.
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Create thew view
        // Inflate the view with the target layout (the list item) , parent? idk.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        // Create a class object of ViewHolder, passing the view we just inflated.
        ViewHolder viewHolder = new ViewHolder(view);


        return viewHolder;
    }

    // This is called each time an item wants to be created. If we got 3 items that we want to populate the list, its gonna be 3 times.
    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder viewHolder, int position) {
        Log.d(TAG, "onBindViewHolder: called." + " " + position);

        // The View holder, that has the 2 TextViews, gets the text from the array in the class.
        viewHolder.title.setText(titles.get(position));
        viewHolder.description.setText(descriptions.get(position));

        // This is where you might also create a onClickListener
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView title;
        TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);

        }
    }

}


