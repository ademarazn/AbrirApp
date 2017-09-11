package com.ademar.abrirapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// getPackageManager().getActivityIcon(
		// getPackageManager().getLaunchIntentForPackage(
		// "packageName"));
	}

	public void abrirMaps(View v) {
		Intent maps = getPackageManager().getLaunchIntentForPackage(
				"com.google.android.apps.maps");
		if (maps != null) {
			maps = new Intent(Intent.ACTION_VIEW,
					Uri.parse("geo:0,0?q=Postos+de+gasolina"))
					.setPackage("com.google.android.apps.maps");
			startActivity(maps);
		} else {
			startActivity(new Intent(Intent.ACTION_VIEW,
					Uri.parse("market://details?id="
							+ "com.google.android.apps.maps")));
		}
	}

	public void abrirChrome(View v) {
		Intent chrome = getPackageManager().getLaunchIntentForPackage(
				"com.android.chrome");
		if (chrome != null) {
			startActivity(chrome.setData(Uri.parse("http://www.google.com")));
		} else {
			startActivity(new Intent(Intent.ACTION_VIEW,
					Uri.parse("market://details?id=" + "com.android.chrome")));
		}
	}

	public void abrirCalculadora(View v) {
		Intent calc = getPackageManager().getLaunchIntentForPackage(
				"com.google.android.calculator");
		if (calc != null) {
			startActivity(calc);
		} else {
			// Aplicativo não encontrado
			startActivity(new Intent(Intent.ACTION_VIEW,
					Uri.parse("market://details?id="
							+ "com.google.android.calculator")));
		}
	}

}
