package mobi.bar.activity;

import java.util.ArrayList;
import java.util.List;

import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.IntentAction;

import mobi.bar.R;
import mobi.bar.adapter.ConversionAdapter;
import mobi.bar.util.ConversionHistory;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class HomeActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
        /* ACTION BAR */
        /* Home Action*/
        Intent intentHome = null;
        IntentAction intentActionHome = new IntentAction(this, intentHome,R.drawable.ic_bar );
	    actionBar.setHomeLogo(intentActionHome);
	    
	    
	    /*Anvil Action*/
	    Intent intentAnvil = new Intent(this, WeightActivity.class);
	    IntentAction intentActionAnvil = new IntentAction(this,intentAnvil,R.drawable.ic_anvil);
	    actionBar.addAction(intentActionAnvil);
	     
	     /*Ruler Action*/
	    Intent intentRuler = new Intent(this, SizeActivity.class);
	    IntentAction intentActionRuler = new IntentAction(this,intentRuler,R.drawable.ic_ruler);
	    actionBar.addAction(intentActionRuler);
	     
	     /*Thermometer Action*/
	    Intent intentThermometer = new Intent(this, TemperatureActivity.class);
	    IntentAction intentActionThermometer= new IntentAction(this,intentThermometer,R.drawable.ic_thermometer);
	    actionBar.addAction(intentActionThermometer);
	     
	     /*Water Action*/
	    Intent intentWater = new Intent(this, VolumeActivity.class);
	    IntentAction intentActionWater = new IntentAction(this,intentWater,R.drawable.ic_water);
	    actionBar.addAction(intentActionWater);
	    /*List<COnversion> */
	    List<ConversionHistory> listConversion = new ArrayList<ConversionHistory>();
	    listConversion.add(new ConversionHistory(getResources().getDrawable(R.drawable.ic_anvil),"12 lbs = 5.44310844 kg"));
	    listConversion.add(new ConversionHistory(getResources().getDrawable(R.drawable.ic_thermometer),"10 °C = 50 °F"));
	    listConversion.add(new ConversionHistory(getResources().getDrawable(R.drawable.ic_water),"10 gallons US = 37.8541178 liters"));
	    /*List View: History of conversions */
	    ListView listHistory = (ListView) findViewById(R.id.list_history);
	    listHistory.setAdapter(new ConversionAdapter(this, R.layout.conversion_history, listConversion));
    }
}