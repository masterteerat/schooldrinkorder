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
public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private static final String TAG = "CartAdapter";

    private static DataProdLine[] mDataSet;

    Context mContext;

    public void upDateCartDataChange() {
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
                    upDateCartDataChange();
                }
            });
            txtDesc = (TextView) v.findViewById(R.id.txtDesc);
            txtPrice = (TextView) v.findViewById(R.id.txtPrice);
            imgProdPic = (ImageView) v.findViewById(R.id.imgProd);
            imgbtnAdd = (ImageButton) v.findViewById(R.id.btnDelete);
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
    public CartAdapter(DataProdLine[] dataSet) {
        super();
        this.mContext = GlobalVar.mainActivityContext;
        mDataSet = dataSet;
    }

    // BEGIN_INCLUDE(recyclerViewOnCreateViewHolder)
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_item_cart, viewGroup, false);

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
        viewHolder.getImgBtnAdd().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(mDataSet[position].description, position);
            }
        });
    }
    // END_INCLUDE(recyclerViewOnBindViewHolder)
    public void showDialog(final String inpTxt, Integer position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

        builder.setMessage( inpTxt + ": เพิ่มสินค้าในตระกร้า?");

        builder.setPositiveButton("ยืนยัน", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){

                addToCart(mDataSet[position]);

                dialog.dismiss();
            }
        });

        builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                dialog.dismiss();
            }
        });
        builder.show();
    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    public void addToCart(DataProdLine dataprodline) {

        for (int i = 0; i < 10; i++){

            if (GlobalVar.cart[i].prodId.equals("0")) {
                GlobalVar.cart[i].prodId = dataprodline.prodId;
                GlobalVar.cart[i].status = dataprodline.status;
                GlobalVar.cart[i].totalPrice = dataprodline.price;
                GlobalVar.cart[i].quantity = dataprodline.quantity;
                GlobalVar.cart[i].price = dataprodline.price;
                GlobalVar.cart[i].description = dataprodline.description;
                GlobalVar.cart[i].imgResId = dataprodline.imgResId;
                GlobalVar.itemCountCart = i + 1;
                break;
            }else{
                if (GlobalVar.cart[i].prodId.equals(dataprodline.prodId)) {
                    GlobalVar.cart[i].quantity = GlobalVar.cart[i].quantity + 1;
                    GlobalVar.cart[i].totalPrice = GlobalVar.cart[i].quantity * dataprodline.price;
                    GlobalVar.itemCountCart = i + 1;
                    break;
                }

            }

        }
    }



}