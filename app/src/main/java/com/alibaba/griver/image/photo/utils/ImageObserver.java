package com.alibaba.griver.image.photo.utils;

import android.content.Intent;
import android.net.Uri;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.image.framework.api.APImageFormat;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes6.dex */
public class ImageObserver {
    private static ImageObserver d;

    /* renamed from: a  reason: collision with root package name */
    private List<ImageFileObserver> f6618a;
    private HandlerThread b;
    private Handler c;
    private volatile boolean e;

    private ImageObserver() {
        HandlerThread handlerThread = new HandlerThread("BeeImageObserverThread");
        this.b = handlerThread;
        handlerThread.start();
        this.c = new Handler(this.b.getLooper());
    }

    public static ImageObserver getInstance() {
        ImageObserver imageObserver;
        synchronized (ImageObserver.class) {
            if (d == null) {
                d = new ImageObserver();
            }
            imageObserver = d;
        }
        return imageObserver;
    }

    public void active(final List list) {
        if (this.e) {
            return;
        }
        this.e = true;
        a(new Runnable() { // from class: com.alibaba.griver.image.photo.utils.ImageObserver.1
            @Override // java.lang.Runnable
            public void run() {
                ImageObserver.this.a(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List list) {
        StringBuilder sb = new StringBuilder();
        sb.append("doActive### count = ");
        sb.append(list == null ? 0 : list.size());
        GriverLogger.d("ImageObserver", sb.toString());
        this.f6618a = new LinkedList();
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ImageFileObserver imageFileObserver = new ImageFileObserver(String.valueOf(it.next()));
            this.f6618a.add(imageFileObserver);
            imageFileObserver.startWatching();
        }
    }

    public void destroy() {
        a(new Runnable() { // from class: com.alibaba.griver.image.photo.utils.ImageObserver.2
            @Override // java.lang.Runnable
            public void run() {
                if (ImageObserver.this.f6618a == null || ImageObserver.this.f6618a.isEmpty()) {
                    return;
                }
                Iterator it = ImageObserver.this.f6618a.iterator();
                while (it.hasNext()) {
                    ((ImageFileObserver) it.next()).stopWatching();
                }
                ImageObserver.this.f6618a.clear();
            }
        });
    }

    private void a(Runnable runnable) {
        a(runnable, 0);
    }

    private void a(Runnable runnable, int i) {
        Handler handler = this.c;
        if (handler != null) {
            if (i > 0) {
                handler.postDelayed(new SafeRunnable(runnable), i);
            } else {
                handler.post(new SafeRunnable(runnable));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class SafeRunnable implements Runnable {
        Runnable mRunnable;

        public SafeRunnable(Runnable runnable) {
            this.mRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnable = this.mRunnable;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("SafeRunnable exception:");
                sb.append(th.getMessage());
                GriverLogger.d("ImageObserver", sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str) {
        a(new Runnable() { // from class: com.alibaba.griver.image.photo.utils.ImageObserver.3
            @Override // java.lang.Runnable
            public void run() {
                ImageObserver.this.b(str);
            }
        }, 3000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("doScanImage### path = ");
        sb.append(str);
        GriverLogger.d("ImageObserver", sb.toString());
        String substring = str.substring(str.lastIndexOf(".") + 1);
        if (!c(substring)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Ignore invalid file suffix = ");
            sb2.append(substring);
            GriverLogger.d("ImageObserver", sb2.toString());
            return;
        }
        File file = new File(str);
        if (file.exists() && file.isFile() && file.canRead()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Do scan path = ");
            sb3.append(str);
            GriverLogger.d("ImageObserver", sb3.toString());
            GriverEnv.getApplicationContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file)));
            return;
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append("Ignore path = ");
        sb4.append(str);
        GriverLogger.d("ImageObserver", sb4.toString());
    }

    private boolean c(String str) {
        return str.equalsIgnoreCase(APImageFormat.SUFFIX_JPG) || str.equalsIgnoreCase(APImageFormat.SUFFIX_PNG) || str.equalsIgnoreCase("jpeg") || str.equalsIgnoreCase("bmp") || str.equalsIgnoreCase(APImageFormat.SUFFIX_GIF);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class ImageFileObserver extends FileObserver {
        String mDir;

        ImageFileObserver(String str) {
            super(str, 136);
            this.mDir = str;
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            if (128 == i || 8 == i) {
                ImageObserver imageObserver = ImageObserver.this;
                StringBuilder sb = new StringBuilder();
                sb.append(this.mDir);
                sb.append(File.separator);
                sb.append(str);
                imageObserver.a(sb.toString());
            }
        }
    }
}
