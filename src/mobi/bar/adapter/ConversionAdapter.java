package mobi.bar.adapter;

import java.util.List;

import mobi.bar.R;
import mobi.bar.util.ConversionHistory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ConversionAdapter extends ArrayAdapter<ConversionHistory>{
	
	private int resource;
	
	public ConversionAdapter(Context context, int textViewResourceId,
			List<ConversionHistory> objects) {
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
		
		ConversionHistory conversion = getItem(position);
		
		ImageView imageHistory = (ImageView) convertView.findViewById(R.id.image_history);
		
		TextView textHistory = (TextView) convertView.findViewById(R.id.text_history);
		
		imageHistory.setImageDrawable(conversion.getDrawable());
		
		textHistory.setText(conversion.getMessage());
		
		return convertView;
	}
}
