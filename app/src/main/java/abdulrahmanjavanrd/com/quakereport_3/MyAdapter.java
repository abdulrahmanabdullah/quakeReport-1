package abdulrahmanjavanrd.com.quakereport_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import android.graphics.drawable.GradientDrawable;
/**
 * Created by nfs05 on 25/12/2017.
 */

public class MyAdapter extends BaseAdapter {

    Context context ;
    private List<QuakeInfo> mList ;
    private String subLocation ;
    private String primaryLocation;

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
       QuakeInfo currentObject = getItem(position);
       // declare location and primary address .
        String originalLocation = currentObject.getQuakeLocation();
//        if (originalLocation.contains("of")){
//            String[] parts = originalLocation.split("of");
//            subLocation = parts[0];
//            primaryLocation = parts[1];
//        }else {
//            subLocation = context.getResources().getString(R.string.near_the);
//            primaryLocation = originalLocation ;
//        }
        extractAddress(originalLocation);
        if (convertView == null ){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item,null);
           viewHolder = new ViewHolder();
           viewHolder.txvMagnitude =  convertView.findViewById(R.id.txv_magnitude);
           viewHolder.txvLocation = convertView.findViewById(R.id.txv_location);
           viewHolder.txvCity =  convertView.findViewById(R.id.txv_city);
           viewHolder.txvData = convertView.findViewById(R.id.txv_data);
           viewHolder.txvTime = convertView.findViewById(R.id.txv_time);
           convertView.setTag(viewHolder);
        }else {
           viewHolder = (ViewHolder) convertView.getTag();
        }
        GradientDrawable grad = (GradientDrawable) viewHolder.txvMagnitude.getBackground();
        //TODO: create new method to compare the magnitude .
        int gr = getMagnitudeColor(currentObject.getMagnitude()) ;
        grad.setColor(gr);
        viewHolder.txvMagnitude.setText(mangnitudeFormatter(currentObject.getMagnitude()));
        viewHolder.txvLocation.setText(subLocation);
        viewHolder.txvCity.setText(primaryLocation);
        /** Create Date, Then convert Date by call {@link #formatTime(Date)}*/
        Date date = new Date(currentObject.getQuakeDate());
        viewHolder.txvData.setText(formatDate(date));
        viewHolder.txvTime.setText(formatTime(date));
        return convertView;
    }


    private int getMagnitudeColor(double d){
        int result;
        // to compare the parameter
        int getColorPosition = (int)Math.floor(d);
        switch (getColorPosition){
            case 0:
            case 1:
                result = context.getResources().getColor(R.color.magnitude1);
                break;
            case 2:
               result = context.getResources().getColor(R.color.magnitude2);
               break;
            case 3:
                result = context.getResources().getColor(R.color.magnitude3);
                break;
            case 4:
                result = context.getResources().getColor(R.color.magnitude4);
                break;
            case 5:
                result = context.getResources().getColor(R.color.magnitude5);
                break;
            case 6:
                result = context.getResources().getColor(R.color.magnitude6);
                break;
            case 7:
                result = context.getResources().getColor(R.color.magnitude7);
                break;
            case 8:
                result = context.getResources().getColor(R.color.magnitude8);
                break;
            case 9:
                result = context.getResources().getColor(R.color.magnitude9);
                break;
            case 10:
                result = context.getResources().getColor(R.color.magnitude10plus);
                break;
            default:
                result = context.getResources().getColor(R.color.magnitude1);
        }
        return result;
    }
    private String formatDate(Date dateObject){
        DateFormat simple = new SimpleDateFormat("dd/MM/YYYY");
        return simple.format(dateObject);
    }
    private String formatTime(Date dateObject){
        DateFormat simple = new SimpleDateFormat("hh:mm:ss");
        return simple.format(dateObject);
    }
    /**
     * @param str original Address
     * @return separator original Address to two parts, with compare with 'of'
     */
    private String extractAddress(String str){
        String separator = "of";
       if (str.contains(separator)){
          String[] parts = str.split(separator);
          subLocation = parts[0];
          primaryLocation = parts[1];
       }else{
           subLocation = context.getResources().getString(R.string.near_the);
           primaryLocation = str ;
       }
        return str ;
    }
    /**
     * @param d quake value in {@link QuakeInfo}= double
     * @return string after formatted .
     */
    private String mangnitudeFormatter(Double d){
        DecimalFormat df = new DecimalFormat("0.0");
        return df.format(d);
    }
    static class ViewHolder{
       TextView txvMagnitude;
       TextView txvLocation;
       TextView txvCity ;
       TextView txvData ;
       TextView txvTime ;
    }
}
