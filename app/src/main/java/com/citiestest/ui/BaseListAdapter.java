package com.citiestest.ui;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;


public abstract class BaseListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {

    public interface OnItemClickListener {

        void onItemClick(int position);
    }

    public interface OnItemLongClickListener {

        void onItemLongClick(int position);
    }

    protected List<T> items;

    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;


    public BaseListAdapter(List<T> items) {
        this.items = items;
    }

    public BaseListAdapter(List<T> items, OnItemClickListener onItemClickListener) {
        this.items = items;
        this.onItemClickListener = onItemClickListener;
    }

    public BaseListAdapter(List<T> items, OnItemLongClickListener onItemLongClickListener) {
        this.items = items;
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public BaseListAdapter(List<T> items, OnItemClickListener onItemClickListener,
                           OnItemLongClickListener onItemLongClickListener) {
        this.items = items;
        this.onItemClickListener = onItemClickListener;
        this.onItemLongClickListener = onItemLongClickListener;
    }

    @Override
    public void onBindViewHolder(@NotNull final VH holder, int position) {
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener(view -> {
                onItemClickListener.onItemClick(holder.getAdapterPosition());
            });
        }

        if (onItemLongClickListener != null) {
            holder.itemView.setOnLongClickListener(view -> {
                onItemLongClickListener.onItemLongClick(holder.getAdapterPosition());
                return false;
            });
        }
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }


    public T getItem(int position) {
        return this.items.get(position);
    }

    public List<T> getItems() {
        return this.items;
    }

    public void setItems(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void addItem(T item, int position) {
        this.items.add(position, item);
        notifyDataSetChanged();
    }

    public void deleteItem(int position) {
        items.remove(position);
        notifyDataSetChanged();
    }

    public void updateItem(T item, int position) {
        this.items.set(position, item);
        notifyDataSetChanged();
    }

    public void updateItems(List<T> items) {
        if (this.items != null) {
            this.items.clear();
            this.items.addAll(items);
            notifyDataSetChanged();
        } else {
            setItems(items);
        }
    }

    public void clearItems() {
        this.items.clear();
        notifyDataSetChanged();
    }
}

