package com.example.chapter3.homework;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;

public class PlaceholderFragment extends Fragment {

   private ListView listView;
   private LottieAnimationView animationView;

    private String[] data = {"Item1","Item2","Item3","Item4","Item5","Item6","Item7","Item8","Item9"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件

        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        listView = view.findViewById(R.id.list_view);
        animationView = view.findViewById(R.id.animation_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {

                ObjectAnimator animator1=ObjectAnimator.ofFloat(animationView,"alpha",1f,0f);
                animator1.setDuration(500);
                animator1.start();
                listView.setVisibility(View.VISIBLE);
                ObjectAnimator animator2=ObjectAnimator.ofFloat(listView,"alpha",0f,1f);
                animator2.setDuration(1000);
                animator2.start();
            }
        }, 5000);
    }
}
