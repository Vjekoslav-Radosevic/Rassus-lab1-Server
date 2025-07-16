package hr.fer.tel.rassus.server.util;

import hr.fer.tel.rassus.server.model.entity.Sensor;

public class SensorUtils {

	private static final double R = 6371; // Radius of Earth in kilometers

	public static double haversine(Sensor s1, Sensor s2) {
		// Convert latitude and longitude from degrees to radians
		double lon1 = Math.toRadians(s1.getLongitude());
		double lat1 = Math.toRadians(s1.getLatitude());
		double lon2 = Math.toRadians(s2.getLongitude());
		double lat2 = Math.toRadians(s2.getLatitude());

		double dLon = lon2 - lon1;
		double dLat = lat2 - lat1;

		// Haversine formula
		double a = Math.pow(Math.sin(dLat / 2), 2)
			+ Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dLon / 2), 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		// Distance in kilometers
		return R * c;
	}
}
