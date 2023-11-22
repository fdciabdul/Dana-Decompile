package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: classes3.dex */
public class ImageDownload implements Closeable {
    private static final int MAX_IMAGE_SIZE_BYTES = 1048576;
    private volatile Future<?> future;
    private Task<Bitmap> task;
    private final URL url;

    public static ImageDownload create(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new ImageDownload(new URL(str));
        } catch (MalformedURLException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Not downloading image, bad URL: ");
            sb.append(str);
            InstrumentInjector.log_w(Constants.TAG, sb.toString());
            return null;
        }
    }

    private ImageDownload(URL url) {
        this.url = url;
    }

    public void start(ExecutorService executorService) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.future = executorService.submit(new Runnable() { // from class: com.google.firebase.messaging.ImageDownload$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ImageDownload.this.m180lambda$start$0$comgooglefirebasemessagingImageDownload(taskCompletionSource);
            }
        });
        this.task = taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$start$0$com-google-firebase-messaging-ImageDownload  reason: not valid java name */
    public /* synthetic */ void m180lambda$start$0$comgooglefirebasemessagingImageDownload(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(blockingDownload());
        } catch (Exception e) {
            taskCompletionSource.setException(e);
        }
    }

    public Task<Bitmap> getTask() {
        return (Task) Preconditions.checkNotNull(this.task);
    }

    public Bitmap blockingDownload() throws IOException {
        if (Log.isLoggable(Constants.TAG, 4)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Starting download of: ");
            sb.append(this.url);
            InstrumentInjector.log_i(Constants.TAG, sb.toString());
        }
        byte[] blockingDownloadBytes = blockingDownloadBytes();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(blockingDownloadBytes, 0, blockingDownloadBytes.length);
        if (decodeByteArray == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to decode image: ");
            sb2.append(this.url);
            throw new IOException(sb2.toString());
        }
        if (Log.isLoggable(Constants.TAG, 3)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Successfully downloaded image: ");
            sb3.append(this.url);
            InstrumentInjector.log_d(Constants.TAG, sb3.toString());
        }
        return decodeByteArray;
    }

    private byte[] blockingDownloadBytes() throws IOException {
        URLConnection urlconnection_wrapInstance = InstrumentInjector.urlconnection_wrapInstance(this.url.openConnection());
        if (urlconnection_wrapInstance.getContentLength() > 1048576) {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        InputStream inputStream = urlconnection_wrapInstance.getInputStream();
        try {
            byte[] byteArray = ByteStreams.toByteArray(ByteStreams.limit(inputStream, 1048577L));
            if (inputStream != null) {
                inputStream.close();
            }
            if (Log.isLoggable(Constants.TAG, 2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Downloaded ");
                sb.append(byteArray.length);
                sb.append(" bytes from ");
                sb.append(this.url);
                InstrumentInjector.log_v(Constants.TAG, sb.toString());
            }
            if (byteArray.length <= 1048576) {
                return byteArray;
            }
            throw new IOException("Image exceeds max size of 1048576");
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.future.cancel(true);
    }
}
