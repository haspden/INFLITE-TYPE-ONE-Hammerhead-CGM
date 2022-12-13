package cc.inflite.typeone.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import cc.inflite.typeone.R;
import cc.inflite.typeone.data.PreferenceData;
import cc.inflite.typeone.preferences.PreferenceStore;

public class MainActivity extends AppCompatActivity {

    private EditText editTextServerAddress;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextServerAddress = findViewById(R.id.edittext_server_address);
        spinner = findViewById(R.id.spinner_update_frequency);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array_update_frequency, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        PreferenceData preferenceData = PreferenceStore.getPreferences(getApplicationContext());
        editTextServerAddress.setText(preferenceData.getServerAddress());
        spinner.setSelection(adapter.getPosition(String.valueOf(preferenceData.getUpdateFrequency())));
    }

    @Override
    protected void onPause() {
        super.onPause();

        PreferenceStore.savePreferences(getApplicationContext(),
                new PreferenceData(editTextServerAddress.getText().toString(), Integer.parseInt(spinner.getSelectedItem().toString())));
    }
}