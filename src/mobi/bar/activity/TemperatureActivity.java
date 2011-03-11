package mobi.bar.activity;

import mobi.bar.R;
import mobi.bar.util.Converter;
import mobi.bar.widget.UnitReverse;
import mobi.bar.widget.UnitSelector;
import mobi.bar.widget.UnitReverse.Reverse;
import mobi.bar.widget.UnitSelector.Unit;

import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.IntentAction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class TemperatureActivity extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        
        ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
        /* ACTION BAR */
        /* Home Action*/
        Intent intentHome = new Intent(this, HomeActivity.class);
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
	     
	     /*Water Action*/
	    Intent intentWater = new Intent(this, VolumeActivity.class);
	    IntentAction intentActionWater = new IntentAction(this,intentWater,R.drawable.ic_water);
	    actionBar.addAction(intentActionWater);
	    /*Resources unit */
	    String[] units = getResources().getStringArray(R.array.temperature);
	    
	    /*Unit Button 1 */
	    final UnitSelector unitButton1 = (UnitSelector) findViewById(R.id.unitbutton1);
	    unitButton1.setUnitText(units[0]);
	    
	    /*Unit Button 2 */
	    final UnitSelector unitButton2 = (UnitSelector) findViewById(R.id.unitbutton2);
	    unitButton2.setUnitText(units[1]);
	    
	    /*Edit Text */
	    final EditText editText = (EditText) findViewById(R.id.editText);
	    final TextView resultView = (TextView) findViewById(R.id.result);
	    
	    /*Unit Reverse Button */
	    final UnitReverse unitReverse = (UnitReverse) findViewById(R.id.unitreverse);
	    
	    /*Listener Reverse Button */
	    unitReverse.setReverse(new Reverse(){
	    	@Override
	    	public void performReverse(){
	    		String unitText1 = unitButton1.getUnitText();
	    		String unitText2 = unitButton2.getUnitText();
	    		unitButton1.setUnitText(unitText2);
	    		unitButton2.setUnitText(unitText1);
	    		refreshResult(editText.getText().toString(),unitButton1, unitButton2,resultView);
	    	}
	    });
	    
	    /*Listener Unit Button */
	    unitButton1.setUnit(new Unit() {
			
			@Override
			public void refresh() {
				refreshResult(editText.getText().toString(),unitButton1, unitButton2,resultView);
			}
			
			@Override
			public int getUnitArray() {
				return R.array.temperature;
			}
		});
	    
	    unitButton2.setUnit(new Unit() {
			
			@Override
			public void refresh() {
				refreshResult(editText.getText().toString(),unitButton1, unitButton2,resultView);
			}
			
			@Override
			public int getUnitArray() {
				return R.array.temperature;
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
			double valueAfterConvertion = Converter.converterTemperature(unitButton1.getUnitText(), unitButton2.getUnitText(), valueBeforeConvertion);
			resultView.setText(String.valueOf(valueAfterConvertion) + " "+ unitButton2.getUnitText(),BufferType.EDITABLE);
		}
    }
}
