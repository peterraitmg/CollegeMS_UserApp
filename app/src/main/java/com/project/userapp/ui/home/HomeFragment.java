package com.project.userapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.project.userapp.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;

public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;
    private ImageView map;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.FADETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(5);

        setSliderViews();

        map=view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openmap();
            }
        });
        return view;
    }

    private void openmap() {
        Uri uri =Uri.parse("geo:0, 0?q=Jawalakhel chowk");
        Intent intent =new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderViews() {
        for(int i=0;i<5;i++){
            DefaultSliderView sliderView = new DefaultSliderView(getContext());

            switch(i){
                case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-85291.appspot.com/o/Gallery%2F%5BB%40503bb39jpg?alt=media&token=3d39460d-6b80-4e0e-8108-4734625fda19");
                    break;
                case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-85291.appspot.com/o/Gallery%2F%5BB%4096dda08jpg?alt=media&token=7812633d-321d-4331-89e2-d93e7060d29d");
                    break;
                case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-85291.appspot.com/o/Gallery%2F%5BB%40315ac1ajpg?alt=media&token=9f2ffbd6-0b4f-41c7-9edb-c37f8c3f5591");
                    break;
                case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-85291.appspot.com/o/Gallery%2F%5BB%40e9fca8cjpg?alt=media&token=3cef89d5-d3d2-4bab-884a-b00aa5cb25db");
                    break;
                case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-85291.appspot.com/o/Gallery%2F%5BB%401cb415fjpg?alt=media&token=91c302e7-0b11-4e8c-b45d-67b7a9757386");
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.FIT_XY);
            sliderLayout.addSliderView(sliderView);
        }
    }
}