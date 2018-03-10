package appfactory.edu.appfactoryshowcase;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by elliottcrifasi on 3/9/18.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileHolder> {

    private int[] images = {R.drawable.elliott, R.drawable.max };
    private String[] names = {"Elliott", "Max"};
    @Override
    public ProfileHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_carousel_item, parent, false);
        ProfileHolder viewHolder = new ProfileHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ProfileHolder holder, int position) {
            holder.imageView.setImageResource(images[position]);
            holder.textView.setText(names[position]);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }
}
