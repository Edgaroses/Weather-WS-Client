package com.cdyne.ws.WeatherWS;


import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import org.apache.axis.AxisFault;

public class Main {

	public static void main(String[] args) {
		try {
		Weather w = new WeatherLocator();
		WeatherSoap ws = new WeatherSoapStub(new URL(w.getWeatherSoapAddress()),w);
		String zip = "97867";
		WeatherReturn resp = ws.getCityWeatherByZIP(zip);
		System.out.println("Ciudad: "+resp.getCity());
		System.out.println("Temperatura: "+resp.getTemperature());
		} catch (AxisFault e) {
		e.printStackTrace();
		} catch (RemoteException e) {
		e.printStackTrace();
		} catch (MalformedURLException e) {
		e.printStackTrace();
		}
		}
}
