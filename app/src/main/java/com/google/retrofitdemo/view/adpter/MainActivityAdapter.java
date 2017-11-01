package com.google.retrofitdemo.view.adpter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.retrofitdemo.MyApplication;
import com.google.retrofitdemo.R;
import com.google.retrofitdemo.net.bean.MovieEntity;
import com.google.retrofitdemo.utils.MLog;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/30.
 */

public class MainActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private MovieEntity movieEntity;

    public void setData(MovieEntity movieEntity){
        this.movieEntity = movieEntity;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MovieHolder viewHolder = new MovieHolder(View.inflate(MyApplication.getContext(), R.layout.item_movie, null));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((MovieHolder)holder).setData(movieEntity.getSubjects().get(position));
    }

    @Override
    public int getItemCount() {
        int count =0;
        if (movieEntity==null){
            count=0;
        }else {
            count=movieEntity.getSubjects().size();
        }
        return count;
    }

    class MovieHolder extends RecyclerView.ViewHolder{

        private final ImageView item_iv_poster;
        private final TextView item_film_name;
        private final TextView item_movie_grade;
        private final TextView item_movie_actor;
        private final TextView item_movie_direct;

        public MovieHolder(View itemView) {
            super(itemView);
            item_iv_poster = itemView.findViewById(R.id.item_iv_poster);
            item_film_name = itemView.findViewById(R.id.item_film_name);
            item_movie_grade = itemView.findViewById(R.id.item_movie_grade);
            item_movie_actor = itemView.findViewById(R.id.item_movie_actor);
            item_movie_direct = itemView.findViewById(R.id.item_movie_direct);
        }

        public void setData(MovieEntity.SubjectsBean data){
                MLog.i("mrgao",data);
//            ArrayList<String> actor = new ArrayList<>();
            StringBuffer stringBuffer = new StringBuffer();
            item_film_name.setText(data.getTitle());
            for (int i = 0; i < data.getCasts().size(); i++) {
//                actor.add(data.getCasts().get(i).getName());
                stringBuffer.append(data.getCasts().get(i).getName()).append("/");
            }
//            String actorSplit = getActorSplit(actor);
            String actor = stringBuffer.deleteCharAt(stringBuffer.length() - 1).toString();
            item_movie_actor.setText(actor);
            item_movie_direct.setText(data.getDirectors().get(0).getName());
            item_movie_grade.setText(data.getRating().getStars());
            Picasso.with(MyApplication.getContext()).load(data.getImages().getLarge()).into(item_iv_poster);
//            item_movie_actor.setText(data.);
        }
    }


    private String getActorSplit(ArrayList<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list==null&&list.size()==0){
            return "";
        }
        for (String actor : list) {
            stringBuffer.append(actor).append("/");
            }
        return stringBuffer.deleteCharAt(stringBuffer.length()-1).toString();
    }
}
