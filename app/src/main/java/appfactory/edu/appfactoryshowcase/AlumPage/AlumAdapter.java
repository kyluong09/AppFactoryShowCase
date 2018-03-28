package appfactory.edu.appfactoryshowcase.AlumPage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import appfactory.edu.appfactoryshowcase.R;

/**
 * Created by elliottcrifasi on 3/24/18.
 */

public class AlumAdapter extends RecyclerView.Adapter<AlumHolder> {

    private int[] profile;
    private String[] text;

    public AlumAdapter(int[] profile, String[] text) {
        this.profile = profile;
        this.text = text;
    }
    @Override
    public AlumHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alum_carousel_item, parent, false);
        AlumHolder viewHolder = new AlumHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AlumHolder holder, int position) {
        holder.imageView.setImageResource(profile[position]);
        holder.textView.setText(text[position]);
    }

    @Override
    public int getItemCount() {
        return profile.length;
    }
}
