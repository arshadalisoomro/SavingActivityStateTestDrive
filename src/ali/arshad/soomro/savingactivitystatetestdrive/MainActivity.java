package ali.arshad.soomro.savingactivitystatetestdrive;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText editText = null;
	private String VALUE_STRING = "My String";
	private String VALUE_INT = "My int";
	private String VALUE_BOOLEAN = "My boolean";
	private SharedPreferences preferences = null;
	private SharedPreferences.Editor editor = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText = (EditText) findViewById(R.id.editText1);
		preferences = PreferenceManager.getDefaultSharedPreferences(this);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		// Store values between instances here
		  editor = preferences.edit();  // Put the values from the UI
		  String strName = editText.getText().toString();

		  editor.putString(VALUE_STRING, strName); // value to store
		  editor.putInt(VALUE_INT, 100); // value to store
		  editor.putBoolean(VALUE_BOOLEAN, true); // value to store    
		  // Commit to storage
		  editor.commit();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		editText.setText(preferences.getString(VALUE_STRING, "Not found"));
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
