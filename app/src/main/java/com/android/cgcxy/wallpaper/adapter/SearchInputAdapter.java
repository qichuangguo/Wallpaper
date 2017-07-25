package com.android.cgcxy.wallpaper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.base.OnClickListener;
import com.android.cgcxy.wallpaper.bean.SearchInoutBean;

/**
 * Created by chuangguo.qi on 2017/7/25.
 */

public class SearchInputAdapter extends RecyclerView.Adapter<SearchInputAdapter.MyViewHold> {

    private SearchInoutBean searchInoutBean;
    private Context mContext;
    private OnClickListener onClickListener;

    public void setData(SearchInoutBean searchInoutBean) {
        this.searchInoutBean = searchInoutBean;
    }

    @Override
    public MyViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.search_input_item, parent, false);
        return new MyViewHold(inflate);
    }

    @Override
    public void onBindViewHolder(MyViewHold holder, final int position) {
        if (searchInoutBean != null) {
            String name = searchInoutBean.getTags().get(position).getName();
            int total = searchInoutBean.getTags().get(position).getTotal();
            holder.textView.setText(name + "(" + total + ")");
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.clickListener(v,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (searchInoutBean != null && searchInoutBean.getTags().size() > 0) {
            return searchInoutBean.getTags().size();
        } else {
            return 0;
        }
    }

    public class MyViewHold extends RecyclerView.ViewHolder {
        private TextView textView;

        public MyViewHold(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);

        }
    }

    public void setOnClickListener(OnClickListener onClickListener){this.onClickListener=onClickListener;}

}
