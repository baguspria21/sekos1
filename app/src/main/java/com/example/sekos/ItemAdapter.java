    package com.example.sekos;

    import android.content.Context;
    import android.content.Intent;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ImageView;
    import android.widget.LinearLayout;
    import android.widget.TextView;
    import androidx.annotation.NonNull;
    import androidx.recyclerview.widget.RecyclerView;
    import java.util.ArrayList;
    import java.util.List;

    public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

        private List<Item> itemList;
        private static List<Item> filteredItemList;  // To hold filtered data
        private Context context; // To access context for starting an activity

        public ItemAdapter(Context context, List<Item> itemList) {
            this.context = context; // Correctly assign context
            this.itemList = itemList;
            this.filteredItemList = new ArrayList<>(itemList);  // Initially no filter
        }

        public static class ItemViewHolder extends RecyclerView.ViewHolder {
            TextView textViewItem, textViewItemSubtitle;
            ImageView imageViewItem, iconNext;
            LinearLayout itemLayout;

            public ItemViewHolder(View itemView) {
                super(itemView);
                textViewItem = itemView.findViewById(R.id.textViewItemTitle);
                textViewItemSubtitle = itemView.findViewById(R.id.textViewItemSubtitle);
                imageViewItem = itemView.findViewById(R.id.imageViewItem);
                iconNext = itemView.findViewById(R.id.iconNext);
                itemLayout = itemView.findViewById(R.id.itemLayout); // the root LinearLayout

                // Set the on click listener for the itemLayout to trigger the intent
                itemLayout.setOnClickListener(v -> {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        // Create an Intent to open the ItemDetailActivity
                        Item clickedItem = filteredItemList.get(position);
                        Intent intent = new Intent(itemView.getContext(), ItemDetailActivity.class);
                        intent.putExtra("item_name", clickedItem.getName()); // Pass item name
                        intent.putExtra("item_description", clickedItem.getDescription()); // Pass item name
                        intent.putExtra("item_image", clickedItem.getImageResId()); // Pass item image resource ID
                        itemView.getContext().startActivity(intent);
                    }
                });
            }
        }

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
            Item currentItem = filteredItemList.get(position);
            holder.textViewItem.setText(currentItem.getName());
            holder.imageViewItem.setImageResource(currentItem.getImageResId());
        }

        @Override
        public int getItemCount() {
            return filteredItemList.size();
        }

        // Method to filter data
        public void filter(String query) {
            filteredItemList.clear();  // Clear the list of filtered items
            if (query.isEmpty()) {
                filteredItemList.addAll(itemList);  // If no query, show all items
            } else {
                for (Item item : itemList) {
                    if (item.getName().toLowerCase().contains(query.toLowerCase())) {
                        filteredItemList.add(item);  // Add matching items
                    }
                }
            }
            notifyDataSetChanged();  // Notify the adapter to update the RecyclerView
        }

        // Method to update data
        public void updateData(List<Item> newItems) {
            this.itemList = newItems;
            this.filteredItemList = new ArrayList<>(newItems);
            notifyDataSetChanged();
        }
    }
