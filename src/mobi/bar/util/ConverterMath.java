package mobi.bar.util;

public class ConverterMath {
	
	private ConverterMath(){};
	/*Distance */
	private final static double kilometerInMiles = 0.621371192;
	private final static double kilometerInCm = 100000;
	private final static double kilometerInMm = 1000000;
	private final static double kilometerInInch = 39370.0787;
	
	public static double milesToKilometers(double miles){
		return miles / kilometerInMiles;
	}
	
	public static double kilometersToMiles(double kilometers){
		return kilometers * kilometerInMiles;
	}
	
	public static double kilometersToCm(double kilometers){
		return kilometers * kilometerInCm;
	}
	
	public static double CmToKilometers(double cm){
		return cm / kilometerInCm;
	}
	
	public static double kilometersToMm(double kilometers){
		return kilometers * kilometerInMm;
	}
	
	public static double mmToKilometers(double mm){
		return mm / kilometerInMm;
	}
	
	public static double kilometerToInch(double kilometers){
		return kilometers * kilometerInInch;
	}
	
	public static double inchToKilometer(double inch){
		return inch / kilometerInInch;
	}
	
	public static double milesToCm(double miles){
		return miles * kilometerInCm / kilometerInMiles;
	}
	
	public static double cmToMiles(double cm){
		return cm * kilometerInMiles / kilometerInCm;
	}
	
	public static double mmToMiles(double mm){
		return mm * kilometerInMiles / kilometerInMm;
	}
	
	public static double milesToMm(double miles){
		return miles * kilometerInMm / kilometerInMiles;
	}
	
	public static double milesToInch(double miles){
		return miles * kilometerInInch / kilometerInMiles;
	}
	
	public static double inchToMiles(double inch){
		return inch * kilometerInMiles / kilometerInInch;
	}
	
	public static double cmToMm(double cm){
		return cm * 10;
	}
	
	public static double mmToCm(double mm){
		return mm / 10;
	}
	
	public static double cmToInch(double cm){
		return cm * kilometerInInch / kilometerInCm;
	}
	
	public static double inchToCm(double inch){
		return inch * kilometerInCm / kilometerInInch;
	}
	
	public static double mmToInch(double mm){
		return mm * kilometerInInch / kilometerInMm;
	}
	
	public static double inchToMm(double inch){
		return inch * kilometerInMm / kilometerInInch;
	}
	
	/*Weight */
	private final static double kilogramInPounds = 2.20462262;
	private final static double kilogramInOunces = 35.2739619;
	
	public static double kilogramsToPounds(double kilograms){
		return kilograms * kilogramInPounds;
	}
	
	public static double poundsToKilograms(double pounds){
		return pounds / kilogramInPounds;
	}
	
	public static double kilogramsToOunces(double kilograms){
		return kilograms * kilogramInOunces;
	}
	
	public static double ouncesToKilograms(double ounces ){
		return ounces / kilogramInOunces;
	}
	
	public static double poundsToOunces(double pounds){
		return pounds *  kilogramInOunces / kilogramInPounds ;
	}
	
	public static double ouncesToPounds(double ounces){
		return ounces * kilogramInPounds / kilogramInOunces;
	}
	
	/*Volume */
	private final static double literInGallons = 0.264172052;
	private final static double literInCups = 4.22675284;
	
	public static double litersToGallons(double liters){
		return liters * literInGallons;
	}
	
	public static double gallonsToLiters(double gallons){
		return gallons / literInGallons;
	}
	
	public static double litersToCups(double liters){
		return liters * literInCups;
	}
	
	public static double cupsToLiters(double cups){
		return cups / literInCups;
	}
	
	public static double cupsToGallons(double cups){
		return cups * literInGallons / literInCups;
	}
	
	public static double gallonsToCups(double gallons){
		return gallons * literInCups / literInGallons;
	}
	
	//Degrees Celsius C = (F - 32) / 1.8
	//Degrees Fahrenheit F = C × 1.8 + 32
	// http://wiki.answers.com/Q/What_is_the_relation_between_Celsius_and_Fahrenheit#ixzz1C5lbH8pz
	private final static double celsiusInKelvin = 273.15;
	
	public static double celsiusToFahrenheit(double celsius){
		return celsius * 1.8 + 32;
	}
	
	public static double fahrenheitToCelsius(double fahrenheit){
		return (fahrenheit - 32) / 1.8; 
	}
	
	public static double celsiusToKelvin(double celsius){
		return celsius + celsiusInKelvin;
	}
	
	public static double kelvinToCelsius(double kelvin){
		return kelvin - celsiusInKelvin;
	}
	
	public static double fahrenheitToKelvin(double fahrenheit){
		return fahrenheitToCelsius(fahrenheit) + celsiusInKelvin;
	}
	
	public static double kelvinToFahrenheit(double kelvin){
		return celsiusToFahrenheit(kelvinToCelsius(kelvin));
	}
}
