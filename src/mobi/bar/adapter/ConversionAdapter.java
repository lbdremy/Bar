package mobi.bar.adapter;

import java.util.List;

import mobi.bar.R;
import mobi.bar.database.entity.Conversion;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ConversionAdapter extends ArrayAdapter<Conversion>{
	
	private int resource;
	
	public ConversionAdapter(Context context, int textViewResourceId,
			List<Conversion> objects) {
		super(context, textViewResourceId, objects);
		resource = textViewResourceId;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if(convertView == null){
			String inflater = Context.LAYOUT_INFLATER_SERVICE;
			LayoutInflater mInflater = (LayoutInflater)getContext().getSystemService(inflater);
			 convertView = mInflater.inflate(resource, null);
		}
		
		Conversion conversion = getItem(position);
		
		ImageView imageHistory = (ImageView) convertView.findViewById(R.id.image_history);
		
		TextView textHistory = (TextView) convertView.findViewById(R.id.text_history);
		
		imageHistory.setImageDrawable(getDrawable(conversion));
		
		textHistory.setText(getMessage(conversion));
		
		return convertView;
	}
	
	private CharSequence getMessage(Conversion conversion) {
		return conversion.getValueBefore() + " " + conversion.getUnitBefore() +" = " + conversion.getValueAfter() + " "+ conversion.getUnitAfter();
	}

	private Drawable getDrawable(Conversion conversion){
		Drawable drawable = null;
		if(conversion.getKindUnit().compareTo("size") == 0){
			drawable = getContext().getResources().getDrawable(R.drawable.ic_ruler);
		}else if(conversion.getKindUnit().compareTo("temperature") == 0){
			drawable = getContext().getResources().getDrawable(R.drawable.ic_thermometer);
		}else if(conversion.getKindUnit().compareTo("volume") == 0){
			drawable = getContext().getResources().getDrawable(R.drawable.ic_water);
		}else if(conversion.getKindUnit().compareTo("weight") == 0){
			drawable = getContext().getResources().getDrawable(R.drawable.ic_anvil);
		}
		return drawable;
		
	}
}
