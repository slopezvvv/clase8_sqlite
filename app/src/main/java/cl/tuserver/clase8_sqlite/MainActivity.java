package cl.tuserver.clase8_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnRegistrar;
    private EditText eRut, eNombre, eEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(v -> {
            //Toast.makeText().show();
        });
        eRut = findViewById(R.id.eRut);
        eNombre = findViewById(R.id.eNombre);
        eEmail = findViewById(R.id.eEmail);
    }
}
