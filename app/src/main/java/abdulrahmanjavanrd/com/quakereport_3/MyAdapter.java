package abdulrahmanjavanrd.com.quakereport_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by nfs05 on 25/12/2017.
 */

public class MyAdapter extends BaseAdapter {

    Context context ;
    private List<QuakeInfo> mList ;

    public MyAdapter(Context context , List<QuakeInfo> list ){
        this.context = context ;
        this.mList = list ;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public QuakeInfo getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder viewHolder ;
        if (convertView == null ){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,null);
           viewHolder = new ViewHolder();
           viewHolder.txvMagnitude = (TextView) convertView.findViewById(R.id.txv_magnitude);
           viewHolder.txvCity = (TextView) convertView.findViewById(R.id.txv_city);
           viewHolder.txvData = (TextView) convertView.findViewById(R.id.txv_data);
           viewHolder.txvTime = (TextView) convertView.findViewById(R.id.txv_time);
           convertView.setTag(viewHolder);
        }else {
           viewHolder = (ViewHolder) convertView.getTag();
        }
        String magnitudeStr = String.valueOf(getItem(position).getMagnitude());
        viewHolder.txvMagnitude.setText(magnitudeStr);
        viewHolder.txvCity.setText(getItem(position).getQuakeLocation());
        Date date = new Date(getItem(position).getQuakeDate());
        viewHolder.txvData.setText(formatDate(date));
        viewHolder.txvTime.setText(formatTime(date));
        return convertView;
    }

    private String formatDate(Date dateObject){
        DateFormat simple = new SimpleDateFormat("dd/MM/YYYY");
        return simple.format(dateObject);
    }

    private String formatTime(Date dateObject){
        DateFormat simple = new SimpleDateFormat("hh:mm:ss");
        return simple.format(dateObject);
    }
    static class ViewHolder{
       TextView txvMagnitude;
       TextView txvCity ;
       TextView txvData ;
       TextView txvTime ;
    }
}
