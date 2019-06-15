package com.example.konachanimagepost;

import java.util.concurrent.TimeUnit;

public class ImageSrc {
    protected String id;
    protected String tags;
    protected long create_at;
    protected String author;
    protected String link_source;
    protected String score;
    protected long file_size;
    protected String file_url;
    protected String preview_url;
    protected int width_image;
    protected int height_image;

    public ImageSrc() {
        this.id = "";
        this.tags = "";
        this.create_at = 0;
        this.author = "";
        this.link_source = "";
        this.score = "";
        this.file_size = 0;
        this.file_url = "";
        this.preview_url = "";
        this.width_image = 0;
        this.height_image = 0;
    }

    public ImageSrc(String idpost, String tags, long create_at, String author, String link_source, String score, long file_size, String file_url, String samle_url, int width_image, int height_image) {
        this.id = idpost;
        this.tags = tags;
        this.create_at = create_at;
        this.author = author;
        this.link_source = link_source;
        this.score = score;
        this.file_size = file_size;
        this.file_url = file_url;
        this.preview_url = samle_url;
        this.width_image = width_image;
        this.height_image = height_image;

    }

    public ImageSrc(String id) {
        this.id = id;
        this.tags = "";
        this.create_at = 0;
        this.author = "";
        this.link_source = "";
        this.score = "";
        this.file_size = 0;
        this.file_url = "";
        this.preview_url = "";
        this.width_image = 0;
        this.height_image = 0;
    }

    public ImageSrc(String idpost, long create_at, String tags, String link_source, long file_size, String file_url, String score, String samle_url, int width_image, int height_image) {
        this.id = idpost;
        this.tags = tags;
        this.create_at = create_at;
        this.author = "";
        this.link_source = link_source;
        this.score = score;
        this.file_size = file_size;
        this.file_url = file_url;
        this.preview_url = samle_url;
        this.width_image = width_image;
        this.height_image = height_image;
    }

    public String getIdPost() {
        return id;
    }

    public void setIdPost(String idPost) {
        this.id = idPost;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLink_source() {
        return link_source;
    }

    public void setLink_source(String link_source) {
        this.link_source = link_source;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Long getFile_size() {
        return file_size;
    }

    public void setFile_size(Long file_size) {
        this.file_size = file_size;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getSamle_url() {
        return preview_url;
    }

    public void setSamle_url(String samle_url) {
        this.preview_url = samle_url;
    }

    public int getHeight_image() {
        return height_image;
    }

    public void setHeight_image(int height_image) {
        this.height_image = height_image;
    }

    public int getWidth_image() {
        return width_image;
    }

    public void setWidth_image(int width_image) {
        this.width_image = width_image;
    }

    public String getTimeOfPost(long time) {
        int day = (int) TimeUnit.SECONDS.toDays(time);
        int hour = (int) TimeUnit.SECONDS.toHours(time) - (day * 24);
        int minute = (int) TimeUnit.SECONDS.toMinutes(time) - (hour * 60);
        int secon = (int) time - (minute * 60);
        return "Day: " + day + "Hour: " + hour + "Minute: " + minute + "Second: " + secon;
    }


}
