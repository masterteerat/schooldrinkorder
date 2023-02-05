package com.school.project.m5.drinkorder.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.school.project.m5.drinkorder.DataProdLine;
import com.school.project.m5.drinkorder.GlobalVar;
import com.school.project.m5.drinkorder.R;

public class TabCFragment extends Fragment {
    private static final String TAG = "RecyclerViewFragmentOrdered";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int DATASET_COUNT = 9;
    protected DataProdLine[] mDataset;
    protected RecyclerView mRecyclerView;
    protected OrderedAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected TabCFragment.LayoutManagerType mCurrentLayoutManagerType;

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        initDataset();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tabc, container, false);
        rootView.setTag(TAG);

        // BEGIN_INCLUDE(initializeRecyclerView)
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(getActivity());

        mCurrentLayoutManagerType = TabCFragment.LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (TabCFragment.LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }

        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        mLayoutManager = new LinearLayoutManager(getActivity());
        mCurrentLayoutManagerType = TabCFragment.LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);

        mAdapter = new OrderedAdapter();
        mRecyclerView.setAdapter(mAdapter);
        GlobalVar.orderedAdapter = mAdapter;

        return rootView;
    }

    private void initDataset() {
        GlobalVar.itemCountOrdered = 0;
        GlobalVar.itemCountOrderedBuf = 0;
        for (int i = 0; i < GlobalVar.ordered.length; i++) {
            GlobalVar.ordered[i].updateDataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "enqueue");
        }

    }
}
