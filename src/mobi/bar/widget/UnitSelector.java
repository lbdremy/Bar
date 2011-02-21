package mobi.bar.widget;

import mobi.bar.R;
import mobi.bar.util.Converter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TextView.BufferType;

public class UnitSelector extends RelativeLayout implements OnClickListener{
	
	private LayoutInflater mInflater;
    private RelativeLayout mUnitButton;
    private ImageView mArrow;
    private TextView mUnitText;
    private Unit unit;
	
	public UnitSelector(Context context, AttributeSet attrs) {
		super(context, attrs);

        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mUnitButton = (RelativeLayout) mInflater.inflate(R.layout.unitselector, null);
        addView(mUnitButton);

        mArrow = (ImageView) mUnitButton.findViewById(R.id.arrow);
        mUnitText = (TextView) mUnitButton.findViewById(R.id.unit_text);
        
        mUnitButton.setOnClickListener(this);
        
        mArrow.setPadding(mUnitText.getWidth()+5, mArrow.getPaddingTop(), mArrow.getPaddingRight(), mArrow.getPaddingBottom());
        
	}

	@Override
	public void onClick(View view) {
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
		builder.setTitle(R.string.select_unit);
		builder.setItems(unit.getUnitArray(), new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int idItem) {
		        setUnitText(getResources().getStringArray(unit.getUnitArray())[idItem]);
		        unit.refresh();
		    }
		});
		AlertDialog alert = builder.create();
		alert.show();
		
		
		
		
	}
	
	public void setUnitText(String unitText){
		mUnitText.setText(unitText.toCharArray(),0,unitText.length());
	}
	
	public void setUnitText(CharSequence unitText){
		mUnitText.setText(unitText);
	}
	
	public void setUnitText(int resid){
		mUnitText.setText(resid);
	}
	
	public String getUnitText(){
		return mUnitText.getText().toString();
	}
	
	public void setUnit(Unit unit){
		this.unit = unit;
	}
	
	public interface Unit{
		public void refresh();
		public int getUnitArray();
	}
	
	

}
