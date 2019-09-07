package dimitrishol.com.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private static final String TAG = "NewsAdapter";

    private ArrayList<String> imageUrls = new ArrayList<String>();
    private ArrayList<String> titles = new ArrayList<String>();
    private ArrayList<String> descriptions = new ArrayList<String>();
    private ArrayList<String> dates = new ArrayList<String>();
    private ArrayList<String> sources = new ArrayList<String>();
    private ArrayList<String> urls= new ArrayList<String>();

    // This might be not actually useful ?
    private Context context;

    public NewsAdapter(Context contextArrayList , ArrayList<String> imageUrls, ArrayList<String> titles, ArrayList<String> descriptions, ArrayList<String> dates, ArrayList<String> sources, ArrayList<String> urls) {

        this.imageUrls = imageUrls;
        this.titles = titles;
        this.descriptions = descriptions;
        this.dates = dates;
        this.sources = sources;
        this.urls = urls;

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

        Picasso.get().load(imageUrls.get(position)).into(viewHolder.image);

        viewHolder.title.setText(titles.get(position));
        viewHolder.description.setText(descriptions.get(position));
        viewHolder.author.setText(sources.get(position));
        viewHolder.date.setText(dates.get(position));

        // This is where you might also create a onClickListener
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        ImageView image;
        TextView title;
        TextView description;
        TextView author;
        TextView date;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.articleImage);
            title = itemView.findViewById(R.id.articleTitle);
            description = itemView.findViewById(R.id.articleDesc);
            author = itemView.findViewById(R.id.articleAuthor);
            date = itemView.findViewById(R.id.articleDate);



        }
    }

}


