package com.example.appxin;

import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn, btn2,them;
    EditText editText;
    TextView dem2, dem1;
    int i1 ,i2,i3;
    SeekBar sk1,sk2,sk3;
    Random rd = new Random();
    ListView lv;
    int iditem = -1;
    ArrayList<ngonngu> arrayNgonngu;
    adapterngonngu adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= findViewById(R.id.button);
        anhxa();

        //Gán Menu vô cái List
        registerForContextMenu(lv);
        //làm tươi lại
//        adapter.notifyDataSetChanged();
        //
        adapter = new adapterngonngu(this, R.layout.layoutngongu, arrayNgonngu);
        lv.setAdapter(adapter);


//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                emailtxt.setText("Dang nhap ne!");
//            }
//        });

        //

        //
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Drawable newdrawable = getResources().getDrawable(R.drawable.home);
        getSupportActionBar().setHomeAsUpIndicator(newdrawable);
        //su kien Back
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    CountDownTimer count = new CountDownTimer(10000,100) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                            i1 = rd.nextInt(10);
                            i2 = rd.nextInt(10);
                            i3 = rd.nextInt(10);

                            if (sk1.getProgress()+i1 >= sk1.getMax())
                            sk1.setProgress(sk1.getMax());
                            else
                            sk1.setProgress(sk1.getProgress() +i1);

                            if (sk2.getProgress()+i2 >= sk2.getMax())
                                sk2.setProgress(sk2.getMax());
                            else
                                sk2.setProgress(sk2.getProgress() +i2);

                            if (sk3.getProgress()+i3 >= sk3.getMax())
                                sk3.setProgress(sk3.getMax());
                            else
                                sk3.setProgress(sk3.getProgress() +i3);

                            if(sk1.getProgress() >= sk1.getMax()){
                                this.cancel();
                                Toast.makeText(MainActivity.this, "May bay Win", Toast.LENGTH_SHORT).show();
                            }
                            if(sk2.getProgress() >= sk2.getMax()){
                                this.cancel();
                                Toast.makeText(MainActivity.this, "Mui ten Win", Toast.LENGTH_SHORT).show();
                            }
                            if(sk3.getProgress() >= sk3.getMax()){
                                this.cancel();
                                Toast.makeText(MainActivity.this, "Ngoi sao Win", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFinish() {

                        }
                    }.start();
                }
            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Choi Lai", Toast.LENGTH_SHORT).show();
                sk1.setProgress(0);
                sk2.setProgress(0);
                sk3.setProgress(0);
            }
        });

    }
    private void anhxa()
    {
            them = findViewById(R.id.them);
//        sua = findViewById(R.id.sua);
//        xoa = findViewById(R.id.xoa);

        btn=findViewById(R.id.button);
        btn2= findViewById(R.id.button2);
        sk1 = findViewById(R.id.seekBar1);
        sk2 = findViewById(R.id.seekBar2);
        sk3 = findViewById(R.id.seekBar3);
        lv =(ListView) findViewById(R.id.listview);
        arrayNgonngu = new ArrayList<>();
        arrayNgonngu.add(new ngonngu("Tieng Viet", "Tieng cua nguoi Dong Lao", R.drawable.vn));
        arrayNgonngu.add(new ngonngu("Tieng Lao", "Tieng cua nguoi Lao", R.drawable.lao));
        arrayNgonngu.add(new ngonngu("Tieng CamPuChia", "Tieng cua nguoi ChamPa cu", R.drawable.cam));
        arrayNgonngu.add(new ngonngu("Tieng Indonesia", "Tieng cua nguoi InDonesia", R.drawable.indo));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_setting:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_help:
                Toast.makeText(this, "Help!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.app_bar_search:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fb:
                Toast.makeText(this, "FaceBook", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.gg:
                Toast.makeText(this, "Google", Toast.LENGTH_SHORT).show();
                break;
            case R.id.yt:
                Toast.makeText(this, "YouTube", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //su kien Back
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
    // Them sửa Xóa Menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.demo_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    //

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        String chon = item.getTitle().toString();
        if (chon.equals("Thêm")){
            Them();
            Toast.makeText(this, "bạn đã chọn Thêm", Toast.LENGTH_SHORT).show();
        }
        if (chon.equals("Xóa")){
            Xoa();
            Toast.makeText(this, "bạn đã chọn Xóa", Toast.LENGTH_SHORT).show();
        }
        if (chon.equals("Sửa")){

            Toast.makeText(this, "bạn đã chọn Sửa", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

    //
    private void  Them(){
        arrayNgonngu.add(new ngonngu("tiếng Tàu","Người Tàu Khựa",R.drawable.china));
        adapter.notifyDataSetChanged();
    }
    private  void Xoa(){
        arrayNgonngu.remove(0);
        adapter.notifyDataSetChanged();

//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
//                iditem = 1;
//                them.setText("i=" +i+" ; l=" +l);
//            }
//        });
    }
}