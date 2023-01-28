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
import android.widget.RadioButton;

import com.school.project.m5.drinkorder.DataProdLine;
import com.school.project.m5.drinkorder.MainActivity;
import com.school.project.m5.drinkorder.R;

public class TabAFragment extends Fragment {
    private static final String TAG = "RecyclerViewFragmentMenu";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int DATASET_COUNT = 9;
    protected DataProdLine[] mDataset;
    protected RecyclerView mRecyclerView;
    protected CustomAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected LayoutManagerType mCurrentLayoutManagerType;

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
        View rootView = inflater.inflate(R.layout.fragment_taba, container, false);
        rootView.setTag(TAG);

        // BEGIN_INCLUDE(initializeRecyclerView)
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);

        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(getActivity());

        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }

        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        mLayoutManager = new LinearLayoutManager(getActivity());
        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);

        mAdapter = new CustomAdapter(mDataset);
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // END_INCLUDE(initializeRecyclerView)

        return rootView;
    }
    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */
    private void initDataset() {
        mDataset = new DataProdLine[9];

        mDataset[0] = new DataProdLine("0000", R.drawable.pd_coke, "โค้ก + น้ำเเข็ง", 1, 25.0, 0.0, "");
        mDataset[1] = new DataProdLine("0001", R.drawable.pd_coffee, "กาเเฟเย็นปั่น", 1, 35.0, 0.0, "");
        mDataset[2] = new DataProdLine("0002", R.drawable.pd_coffee2, "กาเเฟเย็น", 1, 30.0, 0.0, "");
        mDataset[3] = new DataProdLine("0003", R.drawable.pd_bluebery, "บลูเบอร์รีปั่น", 1, 35.0, 0.0, "");
        mDataset[4] = new DataProdLine("0004", R.drawable.pd_banana, "กล้วยปั่น", 1, 30.0, 0.0, "");
        mDataset[5] = new DataProdLine("0005", R.drawable.pd_greentea, "ชาเขียวเย็น", 1, 35.0, 0.0, "");
        mDataset[6] = new DataProdLine("0006", R.drawable.pd_lemonjuice, "น้ำมะนาวเย็น", 1, 30.0, 0.0, "");
        mDataset[7] = new DataProdLine("0007", R.drawable.pd_melon, "น้ำเมล่อน", 1, 40.0, 0.0, "");
        mDataset[8] = new DataProdLine("0008", R.drawable.pd_watermelon, "น้ำเเตงโม", 1, 35.0, 0.0, "");

    }
}
