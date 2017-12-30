package abdulrahmanjavanrd.com.quakereport_3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String LOG_TAG = MainActivity.class.getName();

    private List<QuakeInfo> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create a fake list of earthquake locations.
        // TODO: fill information form QuakeInfo class
        fillInformation();
        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = findViewById(R.id.list);
        // Create a new {@link ArrayAdapter} of earthquakes
        //TODO : replace this adapter with class adapter .
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        final MyAdapter ada = new MyAdapter(this,QueryUtils.extractEarthQuakes());
        //TODO : set adapter of listView .
        earthquakeListView.setAdapter(ada);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                QuakeInfo currentObj = ada.getItem(position);
                String uri = currentObj.getUri();
                Uri  quakePage = Uri.parse(uri);
                Intent mIntent = new Intent(Intent.ACTION_VIEW,quakePage);
                startActivity(mIntent);
            }
        });
    }

    private void fillInformation(){
        String candyJson = "{\"candies\":[{\"name\":\"Abdulrahman Abdullah \",\"count\":10}]}";
        try {
            JSONObject root = new JSONObject(candyJson);
            JSONArray candiesArray = root.getJSONArray("candies");
            JSONObject firstCandy = candiesArray.getJSONObject(0);
            String candyName = firstCandy.getString("name");
            double candyCount = firstCandy.getDouble("count");
            DateFormat df = new SimpleDateFormat("MM/dd/yyy");
            Date toDay = Calendar.getInstance().getTime();

            // TODO: create List of QuakeInfo
            mList = new ArrayList<>();
//            mList.add(new QuakeInfo(7.2,"Russia",toDay));
//            mList.add(new QuakeInfo(6.1,"New Guinea",toDay));
//            mList.add(new QuakeInfo(6.3,"Morocco",toDay));
//            mList.add(new QuakeInfo(7.1,"Alaska",toDay));
//            mList.add(new QuakeInfo(6.6,"Mexico",toDay));
//            mList.add(new QuakeInfo(6.7,"Japan",toDay));
//            mList.add(new QuakeInfo(6.1,"Bolivia",toDay));
//            mList.add(new QuakeInfo(6.2,"Japan",toDay));
//            mList.add(new QuakeInfo(6.5,"Philippines",toDay));
//            mList.add(new QuakeInfo(6,"Ridge",toDay));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

