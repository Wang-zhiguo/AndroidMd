package cn.wang.androidmd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取ListView对象，通过调用setAdapter方法为ListView设置Adapter设置适配器
        listView = (ListView)findViewById(R.id.listview);
        //------使用ArrayAdapter
        //useArrayAdapter();

        //------使用SimpleAdapter
        //useSimpleAdapter();

        useBaseAdapter();
    }

    private void useBaseAdapter() {
        String[] names = new String[]{"关羽", "赵云", "张飞"};
        String[] desc = new String[]{"关二爷", "常胜将军~", "哇呀呀呀"};
        int[] imgIds = new int[]{R.mipmap.boy_1, R.mipmap.boy_2, R.mipmap.girl_1};
        List<User> users = new ArrayList<>();
        for (int i = 0; i <names.length ; i++) {
            User user = new User();
            user.setName(names[i]);
            user.setDescript(desc[i]);
            user.setImageId(imgIds[i]);
            users.add(user);
        }
        //动态加载顶部View和底部View
        final LayoutInflater inflater = LayoutInflater.from(this);
        View headView = inflater.inflate(R.layout.view_header, null, false);
        View footView = inflater.inflate(R.layout.view_footer, null, false);
        listView.addHeaderView(headView);
        listView.addFooterView(footView);
        MyAdapter2 myAdapter = new MyAdapter2(this,users);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Position:"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void useSimpleAdapter() {
        String[] names = new String[]{"关羽", "赵云", "张飞"};
        String[] says = new String[]{"关二爷", "常胜将军~", "哇呀呀呀"};
        int[] imgIds = new int[]{R.mipmap.boy_1, R.mipmap.boy_2, R.mipmap.girl_1};

        List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> showitem = new HashMap<String, Object>();
            showitem.put("touxiang", imgIds[i]);
            showitem.put("name", names[i]);
            showitem.put("descript", says[i]);
            listitem.add(showitem);
        }

        //创建一个simpleAdapter
        SimpleAdapter myAdapter = new SimpleAdapter(getApplicationContext(), listitem,
                R.layout.list_item, new String[]{"touxiang", "name", "descript"},
                new int[]{R.id.imgtou, R.id.name, R.id.descript});
        listView.setAdapter(myAdapter);
    }

    private void useArrayAdapter() {
        //要显示的数据
        String[] strs = {"C语言","C++","Java","Android","Python"};
        //创建ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_expandable_list_item_1,strs);
        listView.setAdapter(adapter);
    }
}
