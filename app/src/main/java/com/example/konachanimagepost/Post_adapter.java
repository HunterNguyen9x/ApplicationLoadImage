package com.example.konachanimagepost;

import android.content.Context;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Post_adapter extends ArrayAdapter<ImageSrc> {

    public final String TAG = this.getClass().getName();
    private Context context;
    private int resource;
    private List<ImageSrc> arrList;

    public Post_adapter(Context context, int resource, List<ImageSrc> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.arrList = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
            viewHolder.idPost = convertView.findViewById(R.id.idPost);
            viewHolder.ivPost = convertView.findViewById(R.id.ivPost);
            viewHolder.tvAuthor = convertView.findViewById(R.id.tvAuthor);
            viewHolder.tvCreateTime = convertView.findViewById(R.id.tvCreateTime);
            viewHolder.tvFileSize = convertView.findViewById(R.id.tvFileSize);
            viewHolder.tvWidth = convertView.findViewById(R.id.tvWidth);
            viewHolder.tvHeight = convertView.findViewById(R.id.tvHeight);
            viewHolder.tvScore = convertView.findViewById(R.id.tvScore);
            viewHolder.tvTags = convertView.findViewById(R.id.tvTags);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ImageSrc image = arrList.get(position);
        viewHolder.idPost.setText(image.getIdPost());
        viewHolder.tvAuthor.setText(image.getAuthor());
        try {
            Picasso.get().load(image.getSamle_url().replace("\\", "")).into(viewHolder.ivPost);
        } catch (Exception e) {
            Log.d(TAG, "getView: " + e.getMessage());
        }

        viewHolder.tvCreateTime.setText(image.getCreate_at() + "");
        viewHolder.tvFileSize.setText(image.getFile_size() + "");
        viewHolder.tvWidth.setText(image.getWidth_image() + "");
        viewHolder.tvHeight.setText(image.getHeight_image() + "");
        viewHolder.tvScore.setText(image.getScore());
        viewHolder.tvTags.setText(image.getTags());


        return convertView;
    }

    public class ViewHolder {
        TextView idPost;
        ImageView ivPost;
        TextView tvAuthor;
        TextView tvCreateTime;
        TextView tvFileSize;
        TextView tvWidth;
        TextView tvHeight;
        TextView tvScore;
        TextView tvTags;
    }
}
