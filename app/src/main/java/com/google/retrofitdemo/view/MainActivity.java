package com.google.retrofitdemo.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.retrofitdemo.R;
import com.google.retrofitdemo.net.bean.MovieEntity;
import com.google.retrofitdemo.presenter.activity.MovieService;
import com.google.retrofitdemo.view.adpter.MainActivityAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IView {

    @Bind(R.id.click_me_BN)
    Button clickMeBN;
    @Bind(R.id.editText)
    EditText editText;
    @Bind(R.id.editText2)
    EditText editText2;
    @Bind(R.id.movie_tv)
    TextView movieTv;
    @Bind(R.id.movie_recyclerview)
    RecyclerView movieRecyclerView;
    private MovieService movieService;
    private int count;
    private ArrayList<String> mList = new ArrayList<>();
    private MainActivityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //因为没有使用Dagger，所以暂时还是new对象
        adapter = new MainActivityAdapter();
        movieService = new MovieService(this,adapter);

        movieRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        if (adapter!=null){
            movieRecyclerView.setAdapter(adapter);
        }else{
            adapter = new MainActivityAdapter();
            movieRecyclerView.setAdapter(adapter);
        }
    }


    @OnClick(R.id.click_me_BN)
    public void onClick() {
        getMovie();
    }

    public void getMovie() {
        String et = editText.getText().toString();
        String et2 = editText2.getText().toString();
        if (et==null&&et2==null){
            Toast.makeText(this,"输入不能为空",Toast.LENGTH_LONG).show();
        }
        int start = Integer.parseInt(et);
        count = Integer.parseInt(et2);
        movieService.getData(start, count);
    }

    @Override
    public void success(Object o) {
        MovieEntity movieEntity = (MovieEntity) o;
//        for (int i = 0; i < count-1; i++) {
//            mList.add(String.valueOf(movieEntity.getSubjects().get(i).getTitle()));
//        }
        movieTv.setText(movieEntity.getTitle());
    }

    @Override
    public void failed(String msg) {
        Toast.makeText(this,""+msg,Toast.LENGTH_SHORT).show();
    }
}
