package mobi.bar.util;

import android.graphics.drawable.Drawable;

public class ConversionHistory {
	private Drawable drawable;
	private String message;
	
	public ConversionHistory(Drawable drawable,String message){
		this.drawable = drawable;
		this.message = message;
	}
	
	public void setDrawable(Drawable drawable) {
		this.drawable = drawable;
	}
	public Drawable getDrawable() {
		return drawable;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
}
