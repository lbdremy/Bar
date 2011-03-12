package mobi.bar.activity;

import java.util.List;

import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.IntentAction;

import mobi.bar.R;
import mobi.bar.adapter.ConversionAdapter;
import mobi.bar.dao.DaoFactory;
import mobi.bar.database.entity.Conversion;
import android.app.Activity;
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
	    Intent intentAnvil = new Intent("mobi.bar.activity.WEIGHT");
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
	    /*List<Conversion> */
	    List<Conversion> conversions = DaoFactory.getConversionDao(this).findAllConversion();
	    /*List View: History of conversions */
	    ListView listHistory = (ListView) findViewById(R.id.list_history);
	    if(!conversions.isEmpty()){
	    listHistory.setAdapter(new ConversionAdapter(this, R.layout.conversion_history, conversions));
	    }
    }
}