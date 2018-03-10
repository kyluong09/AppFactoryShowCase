package appfactory.edu.appfactoryshowcase;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by elliottcrifasi on 3/9/18.
 * Profile Holder for Carousel View
 */

public class ProfileHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textView;

    public ProfileHolder(View view) {
        super(view);
        imageView = view.findViewById(R.id.imageView);
        textView = view.findViewById(R.id.textView);

    }
}
