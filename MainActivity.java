package pdep.cervezas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView foto;
    int numTrago;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        foto = (ImageView) findViewById(R.id.foto);
        numTrago = 0;
        foto.setImageResource(R.drawable.cerveza1);
        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
            }
        });
    }
}

