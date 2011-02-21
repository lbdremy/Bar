package mobi.bar.activity;

import mobi.bar.R;
import mobi.bar.util.Converter;
import mobi.bar.widget.UnitSelector;
import mobi.bar.widget.UnitSelector.Unit;

import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.IntentAction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class SizeActivity extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size);
        
        ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
        /* ACTION BAR */
        /* Home Action*/
        Intent intentHome = new Intent(this, HomeActivity.class);
        IntentAction intentActionHome = new IntentAction(this, intentHome,R.drawable.ic_bar );
	    actionBar.setHomeLogo(intentActionHome);
	     
	    /*Anvil Action*/
	    Intent intentAnvil = new Intent(this, WeightActivity.class);
	    IntentAction intentActionAnvil = new IntentAction(this,intentAnvil,R.drawable.ic_anvil);
	    actionBar.addAction(intentActionAnvil);
	     
	     /*Thermometer Action*/
	    Intent intentThermometer = new Intent(this, TemperatureActivity.class);
	    IntentAction intentActionThermometer= new IntentAction(this,intentThermometer,R.drawable.ic_thermometer);
	    actionBar.addAction(intentActionThermometer);
	     
	     /*Water Action*/
	    Intent intentWater = new Intent(this, VolumeActivity.class);
	    IntentAction intentActionWater = new IntentAction(this,intentWater,R.drawable.ic_water);
	    actionBar.addAction(intentActionWater);
	    
	    /*Resources unit */
	    String[] units = getResources().getStringArray(R.array.size);
	    
	    /*Unit Button 1 */
	    final UnitSelector unitButton1 = (UnitSelector) findViewById(R.id.unitbutton1);
	    unitButton1.setUnitText(units[0]);
	    
	    /*Unit Button 2 */
	    final UnitSelector unitButton2 = (UnitSelector) findViewById(R.id.unitbutton2);
	    unitButton2.setUnitText(units[1]);
	    
	    /*Edit Text */
	    final EditText editText = (EditText) findViewById(R.id.editText);
	    final TextView resultView = (TextView) findViewById(R.id.result);
	    
	    /*Listener Unit Button */
	    unitButton1.setUnit(new Unit() {
			
			@Override
			public void refresh() {
				refreshResult(editText.getText().toString(),unitButton1, unitButton2,resultView);
			}

			@Override
			public int getUnitArray() {
				return R.array.size;
			}
			
		});
	    
	    unitButton2.setUnit(new Unit() {
			
			@Override
			public void refresh() {
				refreshResult(editText.getText().toString(),unitButton1, unitButton2,resultView);
			}

			@Override
			public int getUnitArray() {
				return R.array.size;
			}
		});
	    /*Listener Edit Text */
	    
	    editText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence c, int start, int before, int count) {
				refreshResult(c,unitButton1, unitButton2,resultView);
			}

			@Override
			public void afterTextChanged(Editable s) {}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,int after) {}
		});
    }
	
	public void refreshResult(CharSequence c,UnitSelector unitButton1, UnitSelector unitButton2,TextView resultView){
		if(c.length() > 0){
			double valueBeforeConvertion = Double.valueOf(c.toString()).doubleValue();
			double valueAfterConvertion = Converter.converterSize(unitButton1.getUnitText(), unitButton2.getUnitText(), valueBeforeConvertion);
			resultView.setText("Result: "+String.valueOf(valueAfterConvertion) + " "+ unitButton2.getUnitText(),BufferType.EDITABLE);
		}
    }
	
	
}
