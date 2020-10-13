package com.example.reubroretrofitmvp.adapter;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.reubroretrofitmvp.R;
import com.example.reubroretrofitmvp.activity.RecyclerItemClickListener;
import com.example.reubroretrofitmvp.model.Notice;
import com.example.reubroretrofitmvp.model.NoticeList;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {
    Context context;
    private int lastSelectedPosition = -1;


    public List<Notice> dataList;

        public NoticeAdapter(List<Notice> dataList, RecyclerItemClickListener recyclerItemClickListener) {
            this.dataList = dataList;


        }

        @NonNull
        @Override
        public NoticeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.single_view_row, parent, false);
            return new NoticeViewHolder(view);

        }



        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(NoticeViewHolder holder, int position) {
            holder.id.setText(dataList.get(position).getId());
            holder.name.setText(dataList.get(position).getName().getFirstName()+" "+dataList.get(position).getName().getLastName());
            holder.email.setText(dataList.get(position).getEmail());
            holder.gender.setText(dataList.get(position).getGender());
            holder.mobile.setText(dataList.get(position).getContact().getMobile());
            holder.home.setText(dataList.get(position).getContact().getHome());
            holder.office.setText(dataList.get(position).getContact().getOffice());


            Picasso.with(holder.imageView.getContext()).load(dataList.get(position).getName().getImage()).resize(50, 50).into(holder.imageView);

            holder.id.setChecked(lastSelectedPosition == position);


        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }

        public class NoticeViewHolder extends RecyclerView.ViewHolder {
            RadioButton id;
            TextView name, email, gender, mobile, home, office;
            ImageView imageView;
            RecyclerView recyclerView;

            NoticeViewHolder(View itemView) {
                super(itemView);
                id = itemView.findViewById(R.id.id);
                name =  itemView.findViewById(R.id.name);
                email =  itemView.findViewById(R.id.email);
                gender =  itemView.findViewById(R.id.gender);
                mobile =  itemView.findViewById(R.id.mobile);
                home =  itemView.findViewById(R.id.home);
                office =  itemView.findViewById(R.id.office);
                imageView=itemView.findViewById(R.id.imgView);
                recyclerView=itemView.findViewById(R.id.recycler_view_employee_list);



                View.OnClickListener listener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lastSelectedPosition = getAdapterPosition();
                        notifyDataSetChanged();
                       // Toast.makeText(context, "" + list.get(position).getName() + "\n" + list.get(position).getLocation(), Toast.LENGTH_SHORT).show();


                    }
                };
                id.setOnClickListener(listener);
                itemView.setOnClickListener(listener);

            }
        }




    public void removeItem(int position) {
        dataList.remove(position);
        notifyItemRemoved(position);
    }




}