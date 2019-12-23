package com.refinaria.advancedandroidcourse.trending;

import androidx.recyclerview.widget.DiffUtil;

import com.refinaria.advancedandroidcourse.models.Repo;

import java.util.List;

public class RepoDiffCallback extends DiffUtil.Callback {

    private final List<Repo> oldList;
    private final List<Repo> newList;

    public RepoDiffCallback(List<Repo> oldList, List<Repo> newList) {
        this.newList = newList;
        this.oldList = oldList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).id() == newList.get(newItemPosition).id();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition));
    }
}
