package mobi.bar.util;


public class Converter {
	
	private Converter(){};
	public static double converterSize(String unit1,String unit2,double value){
		double result = 0.0;
		
		if(unit1.compareTo(unit2) == 0){
			result = value;
		}else if(unit1.compareTo("km") == 0 && unit2.compareTo("miles") == 0){
			result = ConverterMath.kilometersToMiles(value);
		}else if(unit1.compareTo("miles") == 0 && unit2.compareTo("km") == 0){
			result = ConverterMath.milesToKilometers(value);
		}else if(unit1.compareTo("km") == 0 && unit2.compareTo("cm") == 0){
			result = ConverterMath.kilometersToCm(value);
		}else if(unit1.compareTo("cm") == 0 && unit2.compareTo("km") == 0){
			result = ConverterMath.CmToKilometers(value);
		}else if(unit1.compareTo("km") == 0 && unit2.compareTo("mm") == 0){
			result = ConverterMath.kilometersToMm(value);
		}else if(unit1.compareTo("mm") == 0 && unit2.compareTo("km") == 0){
			result = ConverterMath.mmToKilometers(value);
		}else if(unit1.compareTo("km") == 0 && (unit2.compareTo("inch") == 0 ||unit2.compareTo("pouce") == 0 )){
			result = ConverterMath.kilometerToInch(value);
		}else if((unit1.compareTo("inch") == 0 || unit1.compareTo("pouce") == 0) && unit2.compareTo("km") == 0){
			result = ConverterMath.inchToKilometer(value);
		}else if(unit1.compareTo("miles") == 0 && unit2.compareTo("cm") == 0){
			result = ConverterMath.milesToCm(value);
		}else if(unit1.compareTo("cm") == 0 && unit2.compareTo("miles") == 0){
			result = ConverterMath.cmToMiles(value);
		}else if(unit1.compareTo("mm") == 0 && unit2.compareTo("miles") == 0){
			result = ConverterMath.mmToMiles(value);
		}else if(unit1.compareTo("miles") == 0 && unit2.compareTo("mm") == 0){
			result = ConverterMath.milesToMm(value);
		}else if(unit1.compareTo("miles") == 0 && (unit2.compareTo("inch") == 0 || unit2.compareTo("pouce") == 0 )){
			result = ConverterMath.milesToInch(value);
		}else if((unit1.compareTo("inch") == 0 || unit1.compareTo("pouce") == 0)  && unit2.compareTo("miles") == 0){
			result = ConverterMath.inchToMiles(value);
		}else if(unit1.compareTo("cm") == 0 && unit2.compareTo("mm") == 0){
			result = ConverterMath.cmToMm(value);
		}else if(unit1.compareTo("mm") == 0 && unit2.compareTo("cm") == 0){
			result = ConverterMath.mmToCm(value);
		}else if(unit1.compareTo("cm") == 0 && (unit2.compareTo("inch") == 0 ||unit2.compareTo("pouce") == 0 )){
			result = ConverterMath.cmToInch(value);
		}else if((unit1.compareTo("inch") == 0 || unit1.compareTo("pouce") == 0)  && unit2.compareTo("cm") == 0){
			result = ConverterMath.inchToCm(value);
		}else if(unit1.compareTo("mm") == 0 && (unit2.compareTo("inch") == 0 ||unit2.compareTo("pouce") == 0 )){
			result = ConverterMath.mmToInch(value);
		}else if((unit1.compareTo("inch") == 0 || unit1.compareTo("pouce") == 0)  && unit2.compareTo("mm") == 0){
			result = ConverterMath.inchToMm(value);
		}
		return transformResult(result);
	}
	
	
	
	public static double converterWeight(String unit1,String unit2,double value){
		double result = 0.0;
		
		if(unit1.compareTo(unit2) == 0){
			result = value;
		}else if(unit1.compareTo("kg") == 0 && unit2.compareTo("lbs") == 0){
			result = ConverterMath.kilogramsToPounds(value);
		}else if(unit1.compareTo("lbs") == 0 && unit2.compareTo("kg") == 0){
			result = ConverterMath.poundsToKilograms(value);
		}else if(unit1.compareTo("kg") == 0 && unit2.compareTo("ounce") == 0){
			result = ConverterMath.kilogramsToOunces(value);
		}else if(unit1.compareTo("ounce") == 0 && unit2.compareTo("kg") == 0){
			result = ConverterMath.ouncesToKilograms(value);
		}else if(unit1.compareTo("lbs") == 0 && unit2.compareTo("ounce") == 0){
			result = ConverterMath.poundsToOunces(value);
		}else if(unit1.compareTo("ounce") == 0 && unit2.compareTo("lbs") == 0){
			result = ConverterMath.ouncesToPounds(value);
		}
		return transformResult(result);
	}
	
	
	
	public static double converterVolume(String unit1,String unit2,double value){
		double result = 0.0;
		
		if(unit1.compareTo(unit2) == 0){
			result = value;
		}else if((unit1.compareTo("liter") == 0 || unit1.compareTo("litre") == 0) && unit2.compareTo("US gallons") == 0){
			result = ConverterMath.litersToGallons(value);
		}else if(unit1.compareTo("US gallons") == 0 && (unit2.compareTo("liter") == 0 || unit2.compareTo("litre") == 0)){
			result = ConverterMath.gallonsToLiters(value);
		}else if((unit1.compareTo("liter") == 0 || unit1.compareTo("litre") == 0) && unit2.compareTo("US cups") == 0){
			result = ConverterMath.litersToCups(value);
		}else if(unit1.compareTo("US cups") == 0 && (unit2.compareTo("liter") == 0 || unit2.compareTo("litre") == 0)){
			result = ConverterMath.cupsToLiters(value);
		}else if(unit1.compareTo("US cups") == 0 && unit2.compareTo("US gallons") == 0){
			result = ConverterMath.cupsToGallons(value);
		}else if(unit1.compareTo("US gallons") == 0 && unit2.compareTo("US cups") == 0 ){
			result = ConverterMath.gallonsToCups(value);
		}
		return transformResult(result);
	}
	
	
	
	public static double converterTemperature(String unit1,String unit2,double value){
		double result = 0.0;
		
		if(unit1.compareTo(unit2) == 0){
			result = value;
		}else if(unit1.compareTo("celsius") == 0 && unit2.compareTo("fahrenheit") == 0){
			result = ConverterMath.celsiusToFahrenheit(value);
		}else if(unit1.compareTo("fahrenheit") == 0 && unit2.compareTo("celsius") == 0){
			result = ConverterMath.fahrenheitToCelsius(value);
		}else if(unit1.compareTo("celsius") == 0 && unit2.compareTo("kelvin") == 0){
			result = ConverterMath.celsiusToKelvin(value);
		}else if(unit1.compareTo("kelvin") == 0 && unit2.compareTo("celsius") == 0){
			result = ConverterMath.kelvinToCelsius(value);
		}else if(unit1.compareTo("kelvin") == 0 && unit2.compareTo("fahrenheit") == 0){
			result = ConverterMath.kelvinToFahrenheit(value);
		}else if(unit1.compareTo("fahrenheit") == 0 && unit2.compareTo("kelvin") == 0){
			result = ConverterMath.fahrenheitToKelvin(value);
		}
		return transformResult(result);
	}
	
	private static double transformResult(double result){
		if(result < 1.00 && result > -1.00){
			return result;
		}
		return Math.round(result * 100.0 ) / 100.0; 
	}
}
