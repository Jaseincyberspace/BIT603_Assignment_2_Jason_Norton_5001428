package com.example.bit603_assignment2_jasonnorton_5001428;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

// Custom ViewHolder gives access to the views
public class InventoryAdapter extends RecyclerView.Adapter<InventoryAdapter.ViewHolder> {

    // Get access to views on each row:
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView_itemName;
        public TextView textView_itemQuantity;
        public ImageButton button_quantityAdd;
        public ImageButton button_quantitySubtract;

    // This constructor looks up the subviews and stores them in the itemView view to create a row that is accessed by the ViewHolder instance.
    public ViewHolder(View itemView) {
        super(itemView);
        textView_itemName = (TextView) itemView.findViewById(R.id.textView_itemName);
        textView_itemQuantity = (TextView) itemView.findViewById(R.id.textView_itemQuantity);
    }// end ViewHolder constructor
    }// end ViewHolder class

    // Storing the data in a member variable to be displayed in the recyclerview rows:
    private List<Inventory> mInventoryItems;
    public InventoryAdapter(List<Inventory> inventoryItems) {
        mInventoryItems = inventoryItems;
    }

    // Inflating the custom layout from recycler_view_inventory_row.xml
    @Override
    public InventoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View inventoryView = inflater.inflate(R.layout.inventory_item_row, parent, false);

        // Returns a new instance of the ViewHolder:
        ViewHolder viewHolder = new ViewHolder(inventoryView);
        return viewHolder;
    } // End onCreateViewHolder method

    // Populate data into each subview on the row
    @Override
    public void onBindViewHolder(InventoryAdapter.ViewHolder viewHolder, int position) {
        Inventory inventory = mInventoryItems.get(position);

        // Get row subviews from viewHolder:
        TextView textView_itemName = viewHolder.textView_itemName;
        final TextView textView_itemQuantity = viewHolder.textView_itemQuantity;
        final ImageButton button_quantityAdd = viewHolder.button_quantityAdd;
        final ImageButton button_quantitySubtract = viewHolder.button_quantitySubtract;

        // Set values and behaviours for row subviews:
        textView_itemName.setText(inventory.getItemName());
        textView_itemQuantity.setText(Integer.toString(inventory.getQuantity()));
    } // End onBindViewHolder method

    @Override
    public int getItemCount() {
        return mInventoryItems.size();
    }
}// End InventoryAdapter
