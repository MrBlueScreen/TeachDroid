/**
 * 
 */
package com.keba.teachdroid.util;

import android.content.SharedPreferences;

import com.keba.teachdroid.TeachdroidApplication;

/**
 * @author ltz
 *
 */
public class PreferenceManager {

	private static PreferenceManager	mInstance;
	private SharedPreferences	mPrefs;

	public static PreferenceManager getInstance() {
		if (mInstance == null)
			mInstance = new PreferenceManager();
		return mInstance;
	}

	

	protected PreferenceManager() {
		mPrefs = android.preference.PreferenceManager.getDefaultSharedPreferences(TeachdroidApplication.getAppContext());
	}

	public String getHostname() {

		// then you use
		return mPrefs.getString("hostname_ip", "127.0.0.1");
	}

}
