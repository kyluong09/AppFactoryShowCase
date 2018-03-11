package appfactory.edu.appfactoryshowcase.AppPage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import appfactory.edu.appfactoryshowcase.R;

/**
 * Created by elliottcrifasi on 3/9/18.
 * Profile Holder for Carousel View
 */

public class AppHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textView;

    public AppHolder(View view) {
        super(view);
        imageView = view.findViewById(R.id.imageView);
        textView = view.findViewById(R.id.textView);

    }
}
