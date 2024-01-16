package com.helloworld.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.helloworld.R;

public class ThirdFragment extends Fragment {

    private ImageView bokunohero;
    private ImageView classroom;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third, container, false);

        bokunohero = view.findViewById(R.id.bokunohero);
        classroom = view.findViewById(R.id.classroom);

        bokunohero.setOnClickListener(v -> playVideo("pvbokunohero"));

        classroom.setOnClickListener(v -> playVideo("pvclassroom"));

        return view;
    }

    private void playVideo(String videoFileName) {
        String videoPath = "android.resource://" + requireActivity().getPackageName() + "/raw/" + videoFileName;
        Uri videoUri = Uri.parse(videoPath);

        Intent intent = new Intent(requireContext(), VideoActivity.class);
        intent.putExtra("VIDEO_URI", videoUri.toString());
        startActivity(intent);
    }

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ThirdFragment() {
        // Konstruktor publik kosong yang diperlukan
    }

    public static ThirdFragment newInstance(String param1, String param2) {
        ThirdFragment fragment = new ThirdFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
}
