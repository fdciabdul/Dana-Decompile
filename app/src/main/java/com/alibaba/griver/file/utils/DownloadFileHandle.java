package com.alibaba.griver.file.utils;

import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public class DownloadFileHandle {
    public volatile boolean abort = false;
    public String downloadTaskId;
    public volatile Future<Response> future;
    public float progress;
    public String tempFilePath;
    public long totalBytesExpectedToWrite;
    public long totalBytesWritten;

    void interrupt() {
        this.abort = true;
        if (this.future != null) {
            this.future.cancel(true);
        }
    }
}
