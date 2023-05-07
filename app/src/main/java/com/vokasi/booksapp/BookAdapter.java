package com.vokasi.booksapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private Context context;
    private ArrayList<BookData> values;
    private LayoutInflater inflater;
    private RequestOptions requestOptions;

    public BookAdapter(Context context, ArrayList<BookData> values){
        this.context = context;
        this.values = values;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BookData data = values.get(position);
        holder.titleText.setText(data.bookTitle);
        holder.authorText.setText(data.bookAuthor);

        // Memuat gambar ke dalam ImageView menggunakan Glide
        Glide.with(context)
                .load(data.bookImageUrl)
                .into(holder.bookImage);
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleText;
        TextView authorText;
        ImageView bookImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.text1);
            authorText = itemView.findViewById(R.id.text2);
            bookImage = itemView.findViewById(R.id.book_image);
        }
    }
}
