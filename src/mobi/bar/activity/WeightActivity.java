package mobi.bar.activity;

import mobi.bar.R;
import mobi.bar.dao.DaoFactory;
import mobi.bar.database.entity.Conversion;
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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class WeightActivity extends Activity {
	
	private double valueBeforeConvertion;
	private String unitBefore;
	private double valueAfterConvertion;
	private String unitAfter;
	
	private String lastModification;
	private static boolean alreadyVisit = false;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);
        ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
        /* ACTION BAR */
        /* Home Action*/
        Intent intentHome = new Intent(this, HomeActivity.class);;
        IntentAction intentActionHome = new IntentAction(this, intentHome,R.drawable.ic_bar );
	    actionBar.setHomeLogo(intentActionHome);
	     
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
	    
	    /*Resources unit */
	    String[] units = getResources().getStringArray(R.array.weight);
	    
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
				return R.array.weight;
			}
		});
	    
	    unitButton2.setUnit(new Unit() {
			
			@Override
			public void refresh() {
				refreshResult(editText.getText().toString(),unitButton1, unitButton2,resultView);
			}
			
			@Override
			public int getUnitArray() {
				return R.array.weight;
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
	    /*Restore activity state */
	    if(alreadyVisit){
	    	restoreActivityState(editText,unitButton1, unitButton2);
	    }
    }
	
	private void restoreActivityState(EditText editText,UnitSelector unitButton1,UnitSelector unitButton2) {
		Conversion conversion = DaoFactory.getConversionDao(this).findLastEntry(Conversion.KIND_UNIT_WEIGHT);
		if(conversion != null){
			unitButton1.setUnitText(conversion.getUnitBefore());
			unitButton2.setUnitText(conversion.getUnitAfter());
			editText.setText(String.valueOf(conversion.getValueBefore()));
		}
	}

	public void refreshResult(CharSequence c,UnitSelector unitButton1, UnitSelector unitButton2,TextView resultView){
		/*Value set since start up */
        alreadyVisit = true;
        
		lastModification = c.toString();
		if(lastModification.length() > 0){
			valueBeforeConvertion = Double.valueOf(c.toString()).doubleValue();
			valueAfterConvertion = Converter.converterWeight(unitButton1.getUnitText(), unitButton2.getUnitText(), valueBeforeConvertion);
			
			unitBefore = unitButton1.getUnitText();
			unitAfter =  unitButton2.getUnitText();
			
			resultView.setText(String.valueOf(valueAfterConvertion) + " "+ unitButton2.getUnitText(),BufferType.EDITABLE);
			
		}else{
			resultView.setText("");
		}
	}

	@Override
	protected void onPause() {
		if(lastModification !=  null && lastModification.length() > 0) {
			Conversion conversion = new Conversion();
			conversion.setUnitBefore(unitBefore);
			conversion.setUnitAfter(unitAfter);
			conversion.setValueAfter(valueAfterConvertion);
			conversion.setValueBefore(valueBeforeConvertion);
			conversion.setKindUnit(Conversion.KIND_UNIT_WEIGHT);
			if(!DaoFactory.getConversionDao(this).isAlreadyExits(conversion)){
				DaoFactory.getConversionDao(this).addConversion(conversion);
			}
		}
		super.onPause();
			finish();
	}
	
	
	
}
