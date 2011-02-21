package mobi.bar.util;

import mobi.bar.R;

public class Converter {
	private final static double kilometerInMiles = 0.621371192;
	private final static double kilogramInPounds = 2.20462262;
	private final static double literInGallons = 0.264172052;
	
	public final int UNITS_SIZE = R.array.size;
	public final int UNITS_TEMPERATURE = R.array.temperature;
	public final int UNITS_VOLUME = R.array.volume;
	public final int UNITS_WEIGHT = R.array.weight;
	
	private static double milesToKilometers(double miles){
		return miles / kilometerInMiles;
	}
	
	private static double kilometersToMiles(double kilometers){
		return kilometers * kilometerInMiles;
	}
	
	public static double converterSize(String unit1,String unit2,double value){
		double result = 0.0;
		
		if(unit1.compareTo(unit2) == 0){
			result = value;
		}else if(unit1.compareTo("km") == 0){
			result = kilometersToMiles(value);
		}else if(unit1.compareTo("miles") == 0){
			result = milesToKilometers(value);
		}
		return result;
	}
	
	private static double kilogramsToPounds(double kilograms){
		return kilograms * kilogramInPounds;
	}
	
	private static double poundsToKilograms(double pounds){
		return pounds / kilogramInPounds;
	}
	
	public static double converterWeight(String unit1,String unit2,double value){
		double result = 0.0;
		
		if(unit1.compareTo(unit2) == 0){
			result = value;
		}else if(unit1.compareTo("kg") == 0){
			result = kilogramsToPounds(value);
		}else if(unit1.compareTo("lbs") == 0){
			result = poundsToKilograms(value);
		}
		return result;
	}
	
	private static double litersToGallons(double liters){
		return liters * literInGallons;
	}
	
	private static double gallonsToLiters(double gallons){
		return gallons / literInGallons;
	}
	
	public static double converterVolume(String unit1,String unit2,double value){
		double result = 0.0;
		
		if(unit1.compareTo(unit2) == 0){
			result = value;
		}else if(unit1.compareTo("liter") == 0){
			result = litersToGallons(value);
		}else if(unit1.compareTo("gallon US") == 0){
			result = gallonsToLiters(value);
		}
		return result;
	}
	
	//Degrees Celsius C = (F - 32) / 1.8
	//Degrees Fahrenheit F = C × 1.8 + 32
	// http://wiki.answers.com/Q/What_is_the_relation_between_Celsius_and_Fahrenheit#ixzz1C5lbH8pz
	
	private static double celsiusToFahrenheit(double celsius){
		return celsius * 1.8 + 32;
	}
	
	private static double fahrenheitToCelsius(double fahrenheit){
		return (fahrenheit - 32) / 1.8; 
	}
	
	public static double converterTemperature(String unit1,String unit2,double value){
		double result = 0.0;
		
		if(unit1.compareTo(unit2) == 0){
			result = value;
		}else if(unit1.compareTo("celsius") == 0){
			result = celsiusToFahrenheit(value);
		}else if(unit1.compareTo("fahrenheit") == 0){
			result = fahrenheitToCelsius(value);
		}
		return result;
	}
	
}
