package com.school.project.m5.drinkorder.fragment;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.school.project.m5.drinkorder.DataProdLine;
import com.school.project.m5.drinkorder.R;

import java.util.Arrays;


/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private static DataProdLine[] mDataSet;


    public void upDateDataChange() {
        notifyDataSetChanged();
    }

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtDesc;
        private final TextView txtPrice;
        private final ImageView imgProdPic;
        private final ImageButton imgbtnAdd;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                   /* mDataSet = Arrays.copyOf(mDataSet, mDataSet.length + 1);
                    mDataSet[mDataSet.length - 1] = "add new item";*/
                    upDateDataChange();
                }
            });
            txtDesc = (TextView) v.findViewById(R.id.txtDesc);
            txtPrice = (TextView) v.findViewById(R.id.txtPrice);
            imgProdPic = (ImageView) v.findViewById(R.id.imgProd);
            imgbtnAdd = (ImageButton) v.findViewById(R.id.btnAdd);
        }

        public TextView getTxtDesc() {
            return txtDesc;
        }

        public TextView getTxtPrice() {
            return txtPrice;
        }

        public ImageView getImgProdPic() {
            return imgProdPic;
        }

        public ImageButton getImgBtnAdd() {
            return imgbtnAdd;
        }

    }

    // END_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public CustomAdapter(DataProdLine[] dataSet) {
        mDataSet = dataSet;
    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_item_menu, viewGroup, false);

        return new ViewHolder(v);
    }
    // END_INCLUDE(recyclerViewOnCreateViewHolder)

    // BEGIN_INCLUDE(recyclerViewOnBindViewHolder)
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getTxtDesc().setText(mDataSet[position].description);
        viewHolder.getTxtPrice().setText("ราคา: " + mDataSet[position].price.toString() + " บาท");
        viewHolder.getImgProdPic().setImageResource(mDataSet[position].imgResId);

    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}