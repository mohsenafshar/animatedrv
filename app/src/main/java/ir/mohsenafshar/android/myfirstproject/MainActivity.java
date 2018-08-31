package ir.mohsenafshar.android.myfirstproject;

import android.animation.LayoutTransition;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private View stubView;
    private List<String> strings = new ArrayList<>();
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        stubView = findViewById(R.id.stub);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                stubView.setVisibility(View.VISIBLE);
            }
        }, 2000);

        for (int i = 0; i < 3; i++) {
            strings.add("item : " + i);
        }

        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(strings);
        recyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

        /*Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

        LinearLayout l = findViewById(R.id.lay);
        l.getLayoutTransition().setDuration(1000);

//        recyclerView.getLayoutTransition().setDuration(1000);

    }

    public void addItem(View view) throws InterruptedException {
        /*strings.add("AAA AAA AAA" + strings.size());
        myAdapter.notifyItemInserted(strings.size() - 2);*/
        /*strings.addAll(strings);
        myAdapter.notifyDataSetChanged();*/
        List<String> list = Arrays.asList("ABCD", "EFGH", "WRTY", "ZXCV");
        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                strings.add("AAA AAA AAA" + strings.size());
                myAdapter.notifyItemInserted(strings.size() - 2);
            }
        }, 1000);*/
        adder("mohsen");

    }

    private void adder(String tx) {
        final List<String> list = Arrays.asList("ABCD", "EFGH", "WRTY", "ZXCV");


        strings.add(tx);
        myAdapter.notifyItemInserted(strings.size() - 1);
    }

    private void adder(final int i) {
        final List<String> list = Arrays.asList("ABCD", "EFGH", "WRTY", "ZXCV");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (i >= list.size() ) return;
                strings.add(list.get(i));
                myAdapter.notifyItemInserted(strings.size() - 1);
                adder(i + 1);
            }
        }, 1000);
    }
}
