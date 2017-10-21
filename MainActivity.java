package pdep.cervezas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //definimos variables que vamos a necesitar en distintas partes de la Activity.
    ImageView foto;
    int numTrago;
    TextView texto;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // le dice a android que cargue el layout

        //Maneja la Foto
        ImageView.OnClickListener escuchaFoto = new ImageView.OnClickListener() { // define la respuesta al click
            @Override
            public void onClick(View view) { //ejecuta el metodo tomarBirra al detectar un click
                tomarBirra();
            }
        };

        numTrago = 0; //para seguir la imagen
        foto = (ImageView) findViewById(R.id.foto); //enlaza la variable foto con el elemento del layout
        foto.setImageResource(R.drawable.cerveza0); //setea la imagen en la View
        foto.setOnClickListener(escuchaFoto); //asocia el listener a la View

        //Maneja el Texto
        texto = (TextView) findViewById(R.id.texto); //enlaza la variable texto con el elemento del layout
        input = (EditText) findViewById(R.id.inputText); //enlaza la variable input con el elemento del layout
        TextWatcher escuchaTexto = new TextWatcher() {  //es como un listener pero que detecta el ingreso de texto
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                texto.setText(charSequence); //charSequence es el texto que se ingresó en "input", y lo mostramos en "texto"
            }
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //no hacer nada
            }
            @Override
            public void afterTextChanged(Editable editable) {
                //no hacer nada
            }
        };
        input.addTextChangedListener(escuchaTexto); //le asginamos el listener que definimos a la view "input"

    } // fin onCreate

    protected void tomarBirra(){ //metodo para cambiar la imagen de la cerveza
        switch (numTrago) {
            case 0:
                foto.setImageResource(R.drawable.cerveza1);
                numTrago++;
                break;
            case 1:
                foto.setImageResource(R.drawable.cerveza2);
                numTrago++;
                break;
            case 2:
                foto.setImageResource(R.drawable.cerveza0);
                numTrago = 0;
                break;
        }
    }//fin TomarBirra()
}//fin MainActivity
