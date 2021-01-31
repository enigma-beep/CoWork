package com.abhigyan.cowork.Welcome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.abhigyan.cowork.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    public SliderAdapter(Context context){
        this.context=context;
    }

    public int[] slide_image={
            R.drawable.computer,
            R.drawable.space,
            R.drawable.chat

    };
    public String[] slide_heading={
            "Manage Your CoWorking Space","Book Seats, Cabins and Rooms","Have discussions with your Co-Workers"
    };
    public String[] slide_desc={
            "Choose your preferred workspace",
            "Book your preferred seats, cabin and rooms ",
            "Use the discussion page to manage your workplace even better"
    };
    @Override
    public int getCount() {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object ;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view= layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView slideImageView=view.findViewById(R.id.imageView);
        TextView slideTextView=view.findViewById(R.id.textView);
        TextView slideTextView2=view.findViewById(R.id.textView2);

        slideImageView.setImageResource(slide_image[position]);
        slideTextView.setText(slide_heading[position]);
        slideTextView2.setText(slide_desc[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
