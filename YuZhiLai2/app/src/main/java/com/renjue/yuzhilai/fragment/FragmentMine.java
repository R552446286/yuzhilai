package com.renjue.yuzhilai.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.renjue.yuzhilai.R;

/**
 * @author 任珏
 * @类的用途
 * @date 2017/5/25 19:35
 */
public class FragmentMine extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_mine,null);
        return view;
    }
}
