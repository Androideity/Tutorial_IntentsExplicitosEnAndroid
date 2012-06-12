package com.androideity.intentexplicito;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ActivitySecundaria extends Activity {	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.second);
		Bundle extras = getIntent().getExtras();
		if (extras == null) {
			return;
		}
		String valor1 = extras.getString("valor1");
		String valor2 = extras.getString("valor2");
		if (valor1 != null && valor2 != null) {
			EditText text1 = (EditText) findViewById(R.id.txt_first);
			EditText text2 = (EditText) findViewById(R.id.txt_second);
			text1.setText(valor1);
			text2.setText(valor2);
		}
	}

	public void onClick(View view) {
		finish();
	}

	@Override
	public void finish() {
		Intent data = new Intent();
		data.putExtra("returnKey1", "¡Lo hemos logrado!");
		data.putExtra("returnKey2", "Este es otro valor de retorno.");
		setResult(RESULT_OK, data);
		super.finish();
	}

}
