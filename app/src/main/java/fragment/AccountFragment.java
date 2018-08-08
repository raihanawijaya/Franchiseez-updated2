package fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.asus.franchiseez.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    int[] icon = {R.mipmap.ic_iklan,R.mipmap.ic_hubungi,R.mipmap.ic_chat2,R.mipmap.ic_notif_akun,R.mipmap.ic_setting};
    String[] text_icon = {"Langganan Iklan","Hubungi Franchiseez","Chat","Notifikasi","Pengaturan Akun"};
    ListView listView;
    listviewAdapter listviewAdapter;
    TextView t;

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_account, container, false);
        listView = (ListView) v.findViewById(R.id.listview_akun);


        listviewAdapter = new listviewAdapter();
        ViewGroup vg = listView;
        int totalHeight = 0;
        for (int i = 0; i < listviewAdapter.getCount(); i++) {
            View listItem = listviewAdapter.getView(i, null, vg);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams par = listView.getLayoutParams();
        par.height = totalHeight + (listView.getDividerHeight() * (listviewAdapter.getCount() - 1));
        listView.setLayoutParams(par);
        listView.requestLayout();
        listView.setAdapter(listviewAdapter);


        return v;
    }

    class listviewAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return icon.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.list_item_akun,null);

            ImageView imageView = (ImageView) convertView.findViewById(R.id.icon_akun);
            TextView textView = (TextView) convertView.findViewById(R.id.text_icon);



            imageView.setImageResource(icon[position]);
            textView.setText(text_icon[position]);
            Typeface mycutom = Typeface.createFromAsset(getActivity().getAssets(),"fonts/Lunchtype22-Light.ttf");
            textView.setTypeface(mycutom);
            return convertView;
        }


    }

}
