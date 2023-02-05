package com.school.project.m5.drinkorder.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.school.project.m5.drinkorder.DataProdLine;
import com.school.project.m5.drinkorder.GlobalVar;
import com.school.project.m5.drinkorder.MainActivity;
import com.school.project.m5.drinkorder.R;
import com.school.project.m5.drinkorder.Registerscreen;
import com.school.project.m5.drinkorder.splashscreen;

import java.util.Arrays;



/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class OrderedAdapter extends RecyclerView.Adapter<OrderedAdapter.ViewHolder> {
    private static final String TAG = "OrderedAdapter";

    private static DataProdLine[] mDataSet;

    Context mContext;


    public void upDateCartDataChange() {
        this.notifyDataSetChanged();
    }

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtDesc;
        private final TextView txtPrice;
        private final ImageView imgProdPic;
        private final ImageButton imgbtnDel;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });
            txtDesc = (TextView) v.findViewById(R.id.txtDesc);
            txtPrice = (TextView) v.findViewById(R.id.txtPrice);
            imgProdPic = (ImageView) v.findViewById(R.id.imgProd);
            imgbtnDel = (ImageButton) v.findViewById(R.id.btnDelete);
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

        public ImageButton getImgBtnDel() {
            return imgbtnDel;
        }

    }

    // END_INCLUDE(recyclerViewSampleViewHolder)


    public OrderedAdapter() {
        super();
        this.mContext = GlobalVar.mainActivityContext;

    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_item_ordered, viewGroup, false);

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

        viewHolder.getTxtDesc().setText(GlobalVar.ordered[position].description);
        viewHolder.getTxtPrice().setText("จำนวน: " + GlobalVar.ordered[position].quantity.toString() + " ราคา: " + GlobalVar.ordered[position].totalPrice.toString() + " บาท");
        viewHolder.getImgProdPic().setImageResource(GlobalVar.ordered[position].imgResId);

    }




    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return GlobalVar.itemCountOrdered;
    }


}