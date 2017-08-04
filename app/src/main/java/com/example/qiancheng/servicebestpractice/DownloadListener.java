package com.example.qiancheng.servicebestpractice;

/**
 * Created by qiancheng on 2017/8/4.
 */

public interface DownloadListener {

    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onCanecled();

    void onPaused();

}
