package com.google.example.gms.nativeads;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.example.gms.nativeads.nativelist.OttoCurrentRecyclerListData;
import com.google.example.gms.nativeads.nativelist.RecyclerListAdapter;

import static com.google.example.gms.nativeads.nativelist.NativeMainActivity.getDataList;

/**
 * Created by QAIT\amarkhatri on 6/4/17.
 */

public class NativeListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.recycler_list, container, false);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setDataInView();
    }

    private void setDataInView() {
        RecyclerView recyclerView= (RecyclerView) getActivity().findViewById(R.id.recyclerView);
        RecyclerListAdapter recyclerListAdapter = new RecyclerListAdapter(getActivity(), getDataList());
        recyclerView.setAdapter(recyclerListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

        OttoCurrentRecyclerListData ottoCurrentRecyclerListData = new OttoCurrentRecyclerListData(recyclerView, recyclerListAdapter);
        ottoCurrentRecyclerListData.setScrollListener();
    }

}
