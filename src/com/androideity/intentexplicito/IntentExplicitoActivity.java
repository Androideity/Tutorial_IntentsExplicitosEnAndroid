package com.androideity.intentexplicito;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class IntentExplicitoActivity extends Activity {
	
	private static final int REQUEST_CODE = 10;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);        
    }
    
    public void onClick(View view) {
		Intent i = new Intent(this, ActivitySecundaria.class);
		i.putExtra("valor1", "Primer valor para la actividad dos.");
		i.putExtra("valor2", "Segundo valor para la actividad dos.");
		// Mandamos un código de solicitud para identificar la 
		// respuesta con este mismo valor
		startActivityForResult(i, REQUEST_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
			if (data.hasExtra("returnKey1")) {
				Toast.makeText(this, data.getExtras().getString("returnKey1"),
						Toast.LENGTH_SHORT).show();
			}
		}
	}
}