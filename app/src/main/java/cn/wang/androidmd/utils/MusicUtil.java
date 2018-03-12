package cn.wang.androidmd.utils;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileFilter;

import cn.wang.androidmd.bean.Mp3Info;

/**
 * Created by Administrator on 2018/3/12 0012.
 */

public class MusicUtil {
    public static final String ACTION_MEDIA_SCANNER_SCAN_DIR = "android.intent.action.MEDIA_SCANNER_SCAN_DIR";
    public static void scanDirAsync(Context ctx, String dir) {
        Intent scanIntent = new Intent(ACTION_MEDIA_SCANNER_SCAN_DIR);
        scanIntent.setData(Uri.fromFile(new File(dir)));
        ctx.sendBroadcast(scanIntent);
    }
    public static void scanFileAsync(Context ctx, String filePath) {
        Intent scanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        scanIntent.setData(Uri.fromFile(new File(filePath)));
        ctx.sendBroadcast(scanIntent);
    }
    public static Mp3Info scanNewMp3Infos(Context context, Uri uri) {
        Cursor cursor = context.getContentResolver().query(
                uri, null,
                MediaStore.Audio.Media.DURATION + ">=10000",
                null,null);

        Mp3Info mp3Info = new Mp3Info();
        while (cursor.moveToNext()){
            long id = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media._ID));//音乐id
            String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));//音乐标题
            String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));//艺术家
            String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));//专辑
            long albumid = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID));//专辑id
            long duration = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION));//时长
            long size = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.SIZE));//文件大小
            String url = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));//文件路径
            int isMusic = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.IS_MUSIC));//是否为音乐
            //if (isMusic != 0) {
            mp3Info.setId(id);
            mp3Info.setTitle(title);
            mp3Info.setArtist(artist);
            mp3Info.setAlbum(album);
            mp3Info.setAlbumId(albumid);
            mp3Info.setDuration(duration/1000);
            mp3Info.setSize(size);
            mp3Info.setUrl(url);
            mp3Info.setLoveMusic(false);
            System.out.println(mp3Info.toString());
            //}
        }
        cursor.close();
        return mp3Info;
    }

    public static void mediaScan(Context context,File file) {
        file = new File("/mnt/sdcard/Download");
        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.toString().endsWith(".mp3");
            }
        });
        String[] paths = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            paths[i] = files[i].getAbsolutePath();
            System.out.println(paths[i]+"=====");
            //scanFileAsync(context,paths[i]);
        }
        MediaScannerConnection.scanFile(context,
                paths, null,
                new MediaScannerConnection.OnScanCompletedListener() {
                    @Override
                    public void onScanCompleted(String path, Uri uri) {
                        System.out.println(path+"----------");
                        System.out.println(uri.toString());

                    }
                });


    }
}
