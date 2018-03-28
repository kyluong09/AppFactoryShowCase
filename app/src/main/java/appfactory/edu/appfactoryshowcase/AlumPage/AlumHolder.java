package appfactory.edu.appfactoryshowcase.AlumPage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import appfactory.edu.appfactoryshowcase.R;

/**
 * Created by elliottcrifasi on 3/24/18.
 */

public class AlumHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textView;

    public AlumHolder(View view) {
        super(view);
        imageView = view.findViewById(R.id.alum_imageView);
        textView = view.findViewById(R.id.alum_textView);

    }
}
