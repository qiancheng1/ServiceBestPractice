package com.example.qiancheng.servicebestpractice;

import android.os.AsyncTask;
import android.os.Environment;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by qiancheng on 2017/8/4.
 */

public class Downloadtask extends AsyncTask {
    public static final int TYPE_SUCCESS = 0;
    public static final int TYPE_FAILED = 1;
    public static final int TYPE_PAUSED = 2;
    public static final int TYPE_CANCELED = 3;

    DownloadListener listener;

    Boolean isCanceled = false;
    Boolean isPaused = false;
    int lastProgress;

    public Downloadtask(DownloadListener listener) {
        this.listener = listener;
    }
    @Override
    protected Object doInBackground(String... params) {
        InputStream is = null;
        RandomAccessFile mRandomAccessFile = null;
        File file = null;
        try {
            long downloadedLength = 0;
            String downloadUrl = params[0];
            String fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
            String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            file = new File(directory + fileName);
            if (file.exists()) {
                downloadedLength = file.length();
            }
            long contentLength = getContentLength(downloadUrl);
            if (contentLength == 0) {
                return TYPE_FAILED;
            } else if (downloadedLength == contentLength) {
                return TYPE_SUCCESS;
            }

            OkHttpClient okHttpCleant = new OkHttpClient();
            Request request = new Request.Builder()
                    .addHeader("RANGE" +)
                    .url(downloadUrl)
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private long getContentLength(String downloadUrl) {
    }
}
