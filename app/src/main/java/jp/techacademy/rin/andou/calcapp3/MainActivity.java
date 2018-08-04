package jp.techacademy.rin.andou.calcapp3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタン
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        //ボタン2
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
        //ボタン3
        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);
        //ボタン4
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        //メンバ変数
        EditText edittext;
        EditText edittext2;

        //エディットテキスト
        edittext = (EditText) findViewById(R.id.edittext);
        //エディットテキスト2
        edittext2 = (EditText) findViewById(R.id.edittext2);
        //文字からの変換
        String edit1 = edittext.getText().toString();
        String edit2 = edittext2.getText().toString();

        if (edit1 == "" ||  edit2 == ""){
            Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return;
        }

        double num1 = Double.parseDouble(edit1);
        double num2 = Double.parseDouble(edit2);

        //持って行く。
        Intent intent = new Intent(this, Main2Activity.class);

        if (v.getId() == R.id.button) {
            intent.putExtra("VALUE1", num1 + num2);
            startActivity(intent);
        } else if (v.getId() == R.id.button2) {
            intent.putExtra("VALUE1", num1 - num2);
            startActivity(intent);
        } else if (v.getId() == R.id.button3) {
            intent.putExtra("VALUE1", num1 * num2);
            startActivity(intent);
        } else if (v.getId() == R.id.button4) {
            intent.putExtra("VALUE1", num1 / num2);
            startActivity(intent);
        }


        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
    }
}
