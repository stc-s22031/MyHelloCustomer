package s22031.jp.myhellocustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタン・オブジェクトの用意
        Button btClick = findViewById(R.id.btClick);
        //リスナ・オブジェクトの用意
        HelloListener listener = new HelloListener();
        //ボタンにリスナを設定
        btClick.setOnClickListener(listener);
        //クリアボタンであるButtonオブジェクトを取得
        Button btClearN = findViewById(R.id.btLiveclear);
        Button btClearL = findViewById(R.id.btNameclear);
        //クリアボタンにリスナを設定
        btClearN.setOnClickListener(listener);
        btClearL.setOnClickListener(listener);

    }

    private class HelloListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //名前入力欄であるedittextオブジェクトを取得
            EditText input1 = findViewById(R.id.etLive);
            EditText input2 = findViewById(R.id.etName);


            //タップされた画面部分のidのRを取得
            int id = view.getId();
            //idのR値に応じて処理を分岐


            //表示ボタンの場合
            if(id==R.id.btClick) {
                //入力された名前文字列を取得
                String inputStr1 = input1.getText().toString();
                String inputStr2 = input2.getText().toString();
                //メッセージを表示
                String show = inputStr2 + "にお住いの" + inputStr1 + "さん、こんにちは！";
                Toast.makeText(MainActivity.this, show, Toast.LENGTH_LONG).show();

            }

            //クリアliveボタンの場合
            else if(id==R.id.btLiveclear) {
                //名前入力欄を空文字に設定
                input1.setText("");

            }

            //クリアnameボタンの場合
            else {
                //名前入力欄を空文字に設定
                input2.setText("");

            }


        }
    }
}