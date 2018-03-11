package cn.wang.androidmd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/2/5 0005.
 */

public class MyAdapter extends BaseAdapter {
    private List<User> users;
    private Context context;

    /**
     * 构造函数
     * @param context：上下文，用来加载布局用
     * @param users：数据
     */
    public MyAdapter(Context context,List<User> users){
        this.context = context;
        this.users = users;
    }
    @Override
    public int getCount() {//决定显示数据的数量
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    //最重要的：决定每个Item的View（即如何显示）
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item,null);
        ImageView imageView = (ImageView)view.findViewById(R.id.imgtou);
        TextView tvName = (TextView)view.findViewById(R.id.name);
        TextView tvDesc = (TextView)view.findViewById(R.id.descript);
        User user = users.get(position);
        imageView.setImageResource(user.getImageId());
        tvName.setText(user.getName());
        tvDesc.setText(user.getDescript());
        return view;
    }
}
