package com.alibaba.griver.device.jsapi.screen;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.SparseLongArray;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.griver.base.common.logger.GriverLogger;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
public class ScreenShotObserver {
    static final SparseLongArray LAST_OP_TIME_MAP;
    static final String[] PROJECTION;
    static final boolean SCOPED_STORAGE;

    /* renamed from: a  reason: collision with root package name */
    private static final String f6516a = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
    private H5ScreenShotListener c;
    private Context d;
    private final CopyOnWriteArrayList<H5ScreenShotListener> b = new CopyOnWriteArrayList<>();
    private final ContentObserver e = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.alibaba.griver.device.jsapi.screen.ScreenShotObserver.1

        /* renamed from: a  reason: collision with root package name */
        private volatile String f6517a = null;

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append("old onChange ");
            sb.append(z);
            GriverLogger.d("H5ScreenShotObserver", sb.toString());
            try {
                super.onChange(z);
                onChange(z, null);
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(th);
                GriverLogger.e("H5ScreenShotObserver", sb2.toString());
            }
        }

        Cursor query(Uri uri) {
            if (uri == null) {
                return ScreenShotObserver.this.d.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, ScreenShotObserver.PROJECTION, null, null, "date_added DESC");
            }
            if (uri.toString().contains(ScreenShotObserver.f6516a)) {
                return ScreenShotObserver.this.d.getContentResolver().query(uri, ScreenShotObserver.PROJECTION, null, null, "date_added DESC");
            }
            return null;
        }

        boolean valid(String str) {
            return !TextUtils.isEmpty(str) && str.toLowerCase().contains("screenshot");
        }

        @Override // android.database.ContentObserver
        public void onChange(final boolean z, final Uri uri) {
            ExecutorUtils.execute(ExecutorType.URGENT_DISPLAY, new Runnable() { // from class: com.alibaba.griver.device.jsapi.screen.ScreenShotObserver.1.1
                @Override // java.lang.Runnable
                public void run() {
                    GriverLogger.w("H5ScreenShotObserver", "childThread:onChange");
                    a(z, uri);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z, Uri uri) {
            Cursor query;
            boolean valid;
            if (ScreenShotObserver.this.d == null) {
                GriverLogger.w("H5ScreenShotObserver", "new onChange mContext == null");
                return;
            }
            Cursor cursor = null;
            String str = null;
            try {
                query = query(uri);
            } catch (Throwable th) {
                th = th;
            }
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("new onChange ");
                sb.append(z);
                sb.append(", uri ");
                sb.append(uri);
                GriverLogger.d("H5ScreenShotObserver", sb.toString());
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                } else if (!query.moveToFirst()) {
                    if (query != null) {
                        query.close();
                    }
                } else {
                    if (Math.abs((System.currentTimeMillis() / 1000) - query.getLong(query.getColumnIndex("date_added"))) > 10) {
                        if (query != null) {
                            query.close();
                            return;
                        }
                        return;
                    }
                    if (ScreenShotObserver.SCOPED_STORAGE) {
                        String string = query.getString(query.getColumnIndex("bucket_display_name"));
                        str = query.getString(query.getColumnIndex("_display_name"));
                        if (!valid(string) && !valid(str)) {
                            valid = false;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("bucketName = ");
                            sb2.append(string);
                            sb2.append(", display name = ");
                            sb2.append(str);
                            GriverLogger.d("H5ScreenShotObserver", sb2.toString());
                        }
                        valid = true;
                        StringBuilder sb22 = new StringBuilder();
                        sb22.append("bucketName = ");
                        sb22.append(string);
                        sb22.append(", display name = ");
                        sb22.append(str);
                        GriverLogger.d("H5ScreenShotObserver", sb22.toString());
                    } else {
                        String string2 = query.getString(query.getColumnIndex("_data"));
                        valid = valid(string2);
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("data = ");
                        sb3.append(string2);
                        GriverLogger.d("H5ScreenShotObserver", sb3.toString());
                    }
                    if (valid) {
                        if (ScreenShotObserver.SCOPED_STORAGE) {
                            if (ScreenShotObserver.isFastOp(this, 800L)) {
                                GriverLogger.d("H5ScreenShotObserver", "forbid fast send event in android Q");
                                if (query != null) {
                                    query.close();
                                    return;
                                }
                                return;
                            } else if (this.f6517a != null && this.f6517a.equals(str)) {
                                GriverLogger.d("H5ScreenShotObserver", "forbid fast send the same path picture");
                                if (query != null) {
                                    query.close();
                                    return;
                                }
                                return;
                            }
                        }
                        this.f6517a = str;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("onScreenShot, listeners: ");
                        sb4.append(ScreenShotObserver.this.b.size());
                        GriverLogger.d("H5ScreenShotObserver", sb4.toString());
                        ScreenShotObserver.this.a();
                    }
                    if (query != null) {
                        query.close();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = query;
                try {
                    GriverLogger.e("H5ScreenShotObserver", "", th);
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface H5ScreenShotListener {
        void onScreenShot();
    }

    static {
        boolean z = Build.VERSION.SDK_INT >= 29 || (Build.VERSION.SDK_INT == 28 && Build.VERSION.PREVIEW_SDK_INT > 0);
        SCOPED_STORAGE = z;
        PROJECTION = z ? new String[]{"bucket_display_name", "_display_name", "date_added"} : new String[]{"_data", "date_added"};
        LAST_OP_TIME_MAP = new SparseLongArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.device.jsapi.screen.ScreenShotObserver.2
            @Override // java.lang.Runnable
            public void run() {
                if (ScreenShotObserver.this.c != null) {
                    ScreenShotObserver.this.c.onScreenShot();
                }
                if (ScreenShotObserver.this.b.size() > 0) {
                    Iterator it = ScreenShotObserver.this.b.iterator();
                    while (it.hasNext()) {
                        ((H5ScreenShotListener) it.next()).onScreenShot();
                    }
                }
            }
        });
    }

    public ScreenShotObserver(Context context) {
        this.d = context;
        if (context != null) {
            GriverLogger.d("H5ScreenShotObserver", "registerContentObserver");
            b();
        }
    }

    private void b() {
        ExecutorUtils.runNotOnMain(ExecutorType.URGENT_DISPLAY, new Runnable() { // from class: com.alibaba.griver.device.jsapi.screen.ScreenShotObserver.3
            @Override // java.lang.Runnable
            public void run() {
                GriverLogger.d("H5ScreenShotObserver", "registerContentObserver in child thread");
                ScreenShotObserver.this.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Context context = this.d;
        if (context == null) {
            GriverLogger.w("H5ScreenShotObserver", "registerContentObserverInternal(): mContext is null, cannot register");
        } else if (context.getContentResolver() == null) {
            GriverLogger.w("H5ScreenShotObserver", "registerContentObserverInternal(): mContext.getContentResolver() is null, cannot register");
        } else {
            try {
                this.d.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, SCOPED_STORAGE, this.e);
            } catch (Exception e) {
                GriverLogger.e("H5ScreenShotObserver", "registerContentObserverInternal(): exception", e);
            }
        }
    }

    public void setCommonListener(H5ScreenShotListener h5ScreenShotListener) {
        this.c = h5ScreenShotListener;
    }

    public void registerListener(H5ScreenShotListener h5ScreenShotListener) {
        this.b.add(h5ScreenShotListener);
    }

    public void release() {
        this.b.clear();
        if (this.d != null) {
            GriverLogger.d("H5ScreenShotObserver", "unregisterContentObserver");
            this.d.getContentResolver().unregisterContentObserver(this.e);
        }
        this.d = null;
    }

    public static boolean isFastOp(Object obj, long j) {
        int hashCode = obj != null ? obj.hashCode() : (int) (Math.random() * 2.147483647E9d);
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 18 && currentTimeMillis - LAST_OP_TIME_MAP.get(hashCode) < j) {
            z = true;
        }
        if (!z && Build.VERSION.SDK_INT >= 18) {
            LAST_OP_TIME_MAP.put(hashCode, currentTimeMillis);
        }
        return z;
    }
}
