package ec.edu.uce.dispmoviles.registrocedula;

/**
 * Aplicación móvil que se encarga de registrar los datos de la cédula de una persona.
 * Integrantes:
 * - Acosta Chasi Cristhian
 * - Jácome Escobar José
 * - Montoya Tite Angel
 * - Morán Buitrón Adaly
 * - Rivas Navarrete Josué
 */

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;

import ec.edu.uce.dispmoviles.trabajo1hemi.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spProvincias, spCantones;
    EditText fechaNaci;
    //Se crea un identificador numérico para el resultado de la busqueda
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    ImageView foto_gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cedula_activity_main);

        fechaNaci = (EditText) findViewById(R.id.fecha_nac);
        fechaNaci.addTextChangedListener(tw);

        foto_gallery = (ImageView) findViewById(R.id.foto_gallery);

        foto_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        spProvincias = (Spinner) findViewById(R.id.sp_provincias2);
        spCantones = (Spinner) findViewById(R.id.sp_cantones);
        loadSpinnerProvincias();

    }


    TextWatcher tw = new TextWatcher() {
        private String current = "";
        private String ddmmyyyy = "ddmmaaaa";
        private Calendar cal = Calendar.getInstance();

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!s.toString().equals(current)) {
                String clean = s.toString().replaceAll("[^\\d.]", "");
                String cleanC = current.replaceAll("[^\\d.]", "");

                int cl = clean.length();
                int sel = cl;
                for (int i = 2; i <= cl && i < 6; i += 2) {
                    sel++;
                }
                //Fix for pressing delete next to a forward slash
                if (clean.equals(cleanC)) sel--;

                if (clean.length() < 8) {
                    clean = clean + ddmmyyyy.substring(clean.length());
                } else {
                    //This part makes sure that when we finish entering numbers
                    //the date is correct, fixing it otherwise
                    int day = Integer.parseInt(clean.substring(0, 2));
                    int mon = Integer.parseInt(clean.substring(2, 4));
                    int year = Integer.parseInt(clean.substring(4, 8));

                    Calendar fecha = new GregorianCalendar();
                    int año = fecha.get(Calendar.YEAR);
                    int mes = fecha.get(Calendar.MONTH);
                    int dia = fecha.get(Calendar.DAY_OF_MONTH);

                    if (mon > 12) {
                        Toast toast1 = Toast.makeText(getApplicationContext(),
                                "Error en el ingreso del mes", Toast.LENGTH_SHORT);
                        toast1.setGravity(Gravity.CENTER, 0, 0);
                        toast1.setDuration(Toast.LENGTH_LONG);
                        toast1.show();
                        fechaNaci.setTextColor(Color.RED);
                    }

                    if (year < 1900 && year > año) {
                        Toast toast1 = Toast.makeText(getApplicationContext(),
                                "Error en el ingreso del año", Toast.LENGTH_SHORT);
                        toast1.setGravity(Gravity.CENTER, 0, 0);
                        toast1.setDuration(Toast.LENGTH_LONG);
                        toast1.show();
                        fechaNaci.setTextColor(Color.RED);
                    }

                    cal.set(Calendar.MONTH, mon - 1);
                    year = (year < 1900) ? 1900 : (year > 2017) ? 2017 : year;
                    cal.set(Calendar.YEAR, year);
                    // ^ first set year for the line below to work correctly
                    //with leap years - otherwise, date e.g. 29/02/2012
                    //would be automatically corrected to 28/02/2012

                    day = (day > cal.getActualMaximum(Calendar.DATE)) ? cal.getActualMaximum(Calendar.DATE) : day;
                    clean = String.format("%02d%02d%02d", day, mon, year);
                }

                clean = String.format("%s/%s/%s", clean.substring(0, 2),
                        clean.substring(2, 4),
                        clean.substring(4, 8));

                sel = sel < 0 ? 0 : sel;
                current = clean;
                fechaNaci.setText(current);
                fechaNaci.setSelection(sel < current.length() ? sel : current.length());
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    private void openGallery() {
        //Lanza una actividad que muestra una lista de objetos a seleccionar para que el usuario elija uno de ellos.
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        //Se inicia la actividad que mostrará un resultado.
        startActivityForResult(gallery, PICK_IMAGE);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            foto_gallery.setImageURI(imageUri);
        }
    }

    private void loadSpinnerProvincias() {

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.array_provincias, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        this.spProvincias.setAdapter(adapter1);

        // This activity implements the AdapterView.OnItemSelectedListener
        this.spProvincias.setOnItemSelectedListener(this);
        this.spCantones.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        switch (parent.getId()) {
            case R.id.sp_provincias2:

                // Recupera el array array_provincias_a_cantones.xml
                TypedArray arrayLocalidades = getResources().obtainTypedArray(
                        R.array.array_provincias_a_cantones);
                CharSequence[] localidades = arrayLocalidades.getTextArray(pos);
                //
                arrayLocalidades.recycle();

                // Create an ArrayAdapter using the string array and a default spinner layout

                ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(
                        this, android.R.layout.simple_spinner_item,
                        android.R.id.text1, localidades);

                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // Apply the adapter to the spinner
                this.spCantones.setAdapter(adapter);

                break;

            case R.id.sp_cantones:

                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
