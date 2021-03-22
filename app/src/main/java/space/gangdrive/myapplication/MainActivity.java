package space.gangdrive.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long backPressedTime;
    private  Toast backToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Button buttonKillometrageEngine = (Button) findViewById(R.id.kilometrage_engine);
        buttonKillometrageEngine.setOnClickListener(new View.OnClickListener(){


        public void onClick (View v){
        //Начало конструкции
        Intent intent = new Intent(MainActivity.this, KillometrageEngineActivity.class);
        startActivity(intent);
    }
    });
    }
    @Override
    public void onBackPressed() {

        if (backPressedTime+2000>System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else{
            backToast = Toast.makeText(getBaseContext(),"Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();

    }
}