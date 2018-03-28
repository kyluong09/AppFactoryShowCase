package appfactory.edu.appfactoryshowcase.AppPage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import appfactory.edu.appfactoryshowcase.R;

/**
 * Created by elliottcrifasi on 3/9/18.
 */

public class AppAdapter extends RecyclerView.Adapter<AppHolder> {

    private int[] images;
    private String[] text;

    public AppAdapter(int[] images, String[] text) {
        this.images = images;
        this.text = text;
    }

    @Override
    public AppHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_carousel_item, parent, false);
        AppHolder viewHolder = new AppHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(AppHolder holder, int position) {
            holder.imageView.setImageResource(images[position]);
            holder.textView.setText(text[position]);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }
}
