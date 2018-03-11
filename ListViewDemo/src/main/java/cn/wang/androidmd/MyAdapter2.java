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

public class MyAdapter2 extends BaseAdapter {
    private List<User> users;
    private Context context;

    /**
     * 构造函数
     * @param context：上下文，用来加载布局用
     * @param users：数据
     */
    public MyAdapter2(Context context, List<User> users){
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
        ViewHolder holder = null;
        if(convertView==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.img_icon = (ImageView)convertView.findViewById(R.id.imgtou);
            holder.txt_aName = (TextView)convertView.findViewById(R.id.name);
            holder.txt_aDesc = (TextView)convertView.findViewById(R.id.descript);
            convertView.setTag(holder);//将Holder存储到convertView中
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        User user = users.get(position);
        holder.img_icon.setImageResource(user.getImageId());
        holder.txt_aName.setText(user.getName());
        holder.txt_aDesc.setText(user.getDescript());
        return convertView;
    }
    class ViewHolder{
        ImageView img_icon;
        TextView txt_aName;
        TextView txt_aDesc;
    }
}
