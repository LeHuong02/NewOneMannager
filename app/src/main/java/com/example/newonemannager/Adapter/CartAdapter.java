package com.example.newonemannager.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newonemannager.Models.Cart;
import com.example.newonemannager.Models.Common;
import com.example.newonemannager.R;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    Context context;


    public CartAdapter(Context context) {
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_giohang, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Cart cart = Common.cartList.get(position);
        Glide.with(context).load(cart.getImage()).into(holder.img);
        holder.tv_name.setText(cart.getName());
        holder.tv_cost.setText(cart.getPrice() + " vnđ");
        holder.tv_quantity.setText(cart.getQuantity() + "");
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Common.cartList.remove(position);
                notifyDataSetChanged();
            }
        });
        holder.btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(holder.tv_quantity.getText().toString());
                quantity++;
                holder.tv_quantity.setText(quantity + "");
                Common.cartList.get(position).setQuantity(quantity);
            }
        });
        holder.btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(holder.tv_quantity.getText().toString());
                if (quantity < 2) {
                    Common.cartList.remove(position);
                    notifyDataSetChanged();
                }else{
                    quantity--;
                    holder.tv_quantity.setText(quantity + "");
                    Common.cartList.get(position).setQuantity(quantity);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return Common.cartList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv_name, tv_quantity, tv_cost;
        Button btnUp, btnDown, btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_hinhanh);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_cost = itemView.findViewById(R.id.tv_price);
            tv_quantity = itemView.findViewById(R.id.tv_quantity);
            btnUp = itemView.findViewById(R.id.btn_cong);
            btnDelete = itemView.findViewById(R.id.btn_delete);
            btnDown = itemView.findViewById(R.id.btn_tru);
        }
    }
}
