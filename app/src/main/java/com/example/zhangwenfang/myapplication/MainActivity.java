package com.example.zhangwenfang.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;


public class MainActivity extends AppCompatActivity {
    private Button button;
    //被观察者
//    Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
//        @Override
//        public void subscribe(ObservableEmitter<String> e) throws Exception {
//            e.onNext("我是来发射数据的");
//        }
//    });


//    Observable<String> observable =Observable.just("Hello");


    Observable<Integer> obser=Observable.just("hello").map(new Function<String, Integer>() {
        @Override
        public Integer apply(String s) throws Exception {

            return s.length();
        }
    });
    Observable<Long> observable = Observable.interval(2, TimeUnit.SECONDS);

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "点击了返回箭头", Toast.LENGTH_LONG).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Observable.just("hello").subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) throws Exception {
//                        button.setText(s);
//                    }
//                });
               obser.subscribe(new Consumer<Integer>() {
                   @Override
                   public void accept(Integer integer) throws Exception {
                       Log.e("------",integer+"");
                       button.setText(integer+"");
                   }
               });
            }
        });


    }

    //观察者
    Observer<String> observer = new Observer<String>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(String s) {
            button.setText(s);

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
                Toast.makeText(getApplicationContext(), "action_search", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "action_settings", Toast.LENGTH_LONG).show();

                break;
            case R.id.action_share:
                Toast.makeText(getApplicationContext(), "action_share", Toast.LENGTH_LONG).show();

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
