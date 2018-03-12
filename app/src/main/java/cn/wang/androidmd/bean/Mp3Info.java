package cn.wang.androidmd.bean;

/**
 * Created by Wangzg on 2017/2/24.
 */

public class Mp3Info {
    private long id;
    private String title;//歌名
    private String artist;//艺术家
    private String album;//专辑
    private long albumId;//专辑id
    private long duration;//时长
    private long size;//大小
    private String url;//路径

    private String picUri;//网络歌曲的专辑图片地址，本地图片为null
    private String bigPicUri;//网络歌曲的大图片
    private String lrcLink;//网络歌曲的歌词地址

    private int isMusic;//是否为音乐
    private boolean isLoveMusic;//是否为喜欢的歌曲

    public long getId() {
        return id;
    }

    public String getPicUri() {
        return picUri;
    }

    public void setPicUri(String picUri) {
        this.picUri = picUri;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIsMusic() {
        return isMusic;
    }

    public void setIsMusic(int isMusic) {
        this.isMusic = isMusic;
    }

    public String getBigPicUri() {
        return bigPicUri;
    }

    public void setBigPicUri(String bigPicUri) {
        this.bigPicUri = bigPicUri;
    }

    public String getLrcLink() {
        return lrcLink;
    }

    public void setLrcLink(String lrcLink) {
        this.lrcLink = lrcLink;
    }

    public boolean isLoveMusic() {
        return isLoveMusic;
    }

    public void setLoveMusic(boolean loveMusic) {
        isLoveMusic = loveMusic;
    }

    @Override
    public String toString() {
        return "Mp3Info{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", albumId=" + albumId +
                ", duration=" + duration +
                ", size=" + size +
                ", url='" + url + '\'' +
                ", lrcurl='" + lrcLink + '\'' +
                ", isMusic=" + isMusic +
                '}';
    }
}
