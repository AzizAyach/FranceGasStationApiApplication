package com.ayach.francesstation.utility;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.data.geo.Point;

public class Utility {

	public static Date convertStringToDate(String dateInString) throws ParseException {
		return DateUtils.parseDate(dateInString, new String[] { "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss" });
	}

	public static Point getcorrectLocation(String latInString, String lonInString) {
		double latitude = 0d;
		double longitude = 0d;
		if (latInString != null && !latInString.isEmpty()) {
			latitude = Double.valueOf(latInString);
		}
		if (lonInString != null && !lonInString.isEmpty()) {
			longitude = Double.valueOf(lonInString);
		}

		if (Double.compare(latitude, longitude) == 1) {
			return new Point(Double.parseDouble(latCorrectionValue(latInString)),
					Double.parseDouble(longCorrectionValue(lonInString)));
		} else {
			return new Point(Double.parseDouble(longCorrectionValue(lonInString)),
					Double.parseDouble(latCorrectionValue(latInString)));
		}
	}

	public static String latCorrectionValue(String lon) {
		if (lon.length() > 2) {
			if (!lon.contains(".")) {
				lon = lon.substring(0, 2) + "." + lon.substring(2, lon.length());
				return lon;
			} else {
				if (lon.indexOf(".") == 2) {
					return lon;
				} else {
					lon = lon.replace(".", "");
					lon = lon.substring(0, 2) + "." + lon.substring(2, lon.length());
					return lon;
				}
			}
		}

		return lon;
	}

	public static String longCorrectionValue(String lat) {
		if (lat.length() > 2) {
			if (!lat.contains(".")) {
				if (lat.contains("-")) {
					lat = lat.substring(0, 2) + "." + lat.substring(2, lat.length());
					return lat;
				} else {
					lat = lat.substring(0, 1) + "." + lat.substring(1, lat.length());
					return lat;
				}

			} else {
				if (lat.indexOf(".") == 1) {
					return lat;
				} else {
					if (lat.contains("-")) {
						lat = lat.replace(".", "");
						lat = lat.substring(0, 2) + "." + lat.substring(2, lat.length());
						return lat;
					} else {
						lat = lat.replace(".", "");
						lat = lat.substring(0, 1) + "." + lat.substring(1, lat.length());
						return lat;
					}

				}
			}

		}
		return lat;
	}

}
