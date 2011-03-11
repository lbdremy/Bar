package mobi.bar.widget;

import mobi.bar.R;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.view.View;
import android.view.View.OnClickListener;

public class UnitReverse extends RelativeLayout implements OnClickListener{
	
	private LayoutInflater mInflater;
    private RelativeLayout mUnitReverseButton;
    private Reverse reverse;

	public void setReverse(Reverse reverse) {
		this.reverse = reverse;
	}

	public UnitReverse(Context context, AttributeSet attrs) {
		super(context, attrs);

        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mUnitReverseButton = (RelativeLayout) mInflater.inflate(R.layout.unitreverse, null);
        addView(mUnitReverseButton);
        mUnitReverseButton.setOnClickListener(this);
       
	}

	@Override
	public void onClick(View v) {
		Log.d("DEBUG", "perform Reverse");
		reverse.performReverse();
	}
	
	public interface Reverse{
		public void performReverse();
	}
}
