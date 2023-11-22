package com.alibaba.griver.image.photo;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.SparseArray;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.image.GriverImageService;
import com.alibaba.griver.image.R;
import com.alibaba.griver.image.framework.api.APImageFormat;
import com.alibaba.griver.image.framework.meta.APImageInfo;
import com.alibaba.griver.image.photo.meta.BucketInfo;
import com.alibaba.griver.image.photo.meta.PhotoItem;
import com.alibaba.griver.image.photo.utils.ImageObserver;
import com.alibaba.griver.image.photo.utils.PhotoUtil;
import com.alipay.mobile.zebra.data.ZebraData;
import com.alipay.multimedia.adjuster.api.APMSandboxProcessor;
import com.huawei.hms.adapter.internal.CommonCode;
import com.j256.ormlite.field.FieldType;
import id.dana.sendmoney.summary.SummaryActivity;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import j$.util.DesugarTimeZone;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public class PhotoResolver {
    public static final String TAG = "PhotoResolver";

    /* renamed from: a  reason: collision with root package name */
    private String f6601a;
    private int b;
    private ContentResolver c;
    private volatile Map<String, List<PhotoItem>> d;
    private volatile List<PhotoItem> e;
    private volatile List<BucketInfo> f;
    private volatile Map<String, BucketInfo> g;
    private boolean h;
    private LinkedHashSet<String> i;
    private BucketUpdateListener j;
    private SimpleDateFormat k;
    private GriverImageService l;
    private volatile Map<String, List<PhotoItem>> m;
    private volatile List<PhotoItem> n;

    /* renamed from: o  reason: collision with root package name */
    private volatile List<BucketInfo> f6602o;
    private boolean q;
    private volatile int r;
    private volatile int s;
    private SparseArray<String> t;
    private Handler p = new Handler(Looper.getMainLooper());
    private Set<String> u = new HashSet();

    /* loaded from: classes6.dex */
    public interface BucketUpdateListener {
        void onScanFinished();

        void onScanStep();
    }

    public PhotoResolver(Context context, BucketUpdateListener bucketUpdateListener) {
        a(context);
        Context applicationContext = context.getApplicationContext();
        this.j = bucketUpdateListener;
        this.c = applicationContext.getContentResolver();
        this.b = 10240;
        this.h = false;
        this.t = new SparseArray<>();
    }

    public void setBucketListener(BucketUpdateListener bucketUpdateListener) {
        this.j = bucketUpdateListener;
    }

    public void setAllBucketName(String str) {
        this.f6601a = str;
    }

    public void setEnableGif(boolean z) {
        this.h = z;
    }

    public void setMinPhotoSize(int i) {
        this.b = i;
    }

    public void setMinPhotoWidth(int i) {
        this.r = i;
    }

    public void setMinPhotoHeight(int i) {
        this.s = i;
    }

    public void setSelectedPhotoPaths(LinkedHashSet<String> linkedHashSet) {
        this.i = linkedHashSet;
    }

    public List<PhotoItem> getBucketList(String str) {
        return this.d.get(str);
    }

    public List<BucketInfo> getBucketList() {
        return this.f;
    }

    public void asyncScanPhotoAndVideo(final boolean z, final boolean z2) {
        c();
        RVLogger.d("PhotoDisplayLink", "Fire async scan job.");
        GriverExecutors.getExecutor(ExecutorType.NORMAL).execute(new Runnable() { // from class: com.alibaba.griver.image.photo.PhotoResolver.1
            @Override // java.lang.Runnable
            public void run() {
                Cursor cursor;
                Cursor a2;
                RVLogger.d("PhotoDisplayLink", "Async scan started.");
                long currentTimeMillis = System.currentTimeMillis();
                if (z) {
                    cursor = PhotoResolver.this.f();
                    if (!TextUtils.equals(GriverConfig.getConfig("disable_photo_thumbnail_scan", "false"), SummaryActivity.CHECKED)) {
                        PhotoResolver.this.b();
                    }
                } else {
                    cursor = null;
                }
                Cursor a3 = z2 ? PhotoResolver.this.a() : null;
                if ((cursor == null || !cursor.moveToLast()) && (cursor == null || !cursor.moveToLast())) {
                    RVLogger.d("PhotoDisplayLink", "asyncScanPhotoAndVideo(), No img!");
                    RVLogger.d("PhotoDisplayLink", "asyncScanPhotoAndVideo(), No img!");
                }
                if (a3 == null || !a3.moveToLast()) {
                    RVLogger.d("VideoDisplayLink", "asyncScanPhotoAndVideo(), No video!");
                }
                int i = 0;
                do {
                    a2 = PhotoResolver.this.a(cursor, a3, true);
                    if (a2 != null) {
                        i++;
                    }
                } while (PhotoResolver.this.a(a2));
                if (cursor != null) {
                    cursor.close();
                }
                if (a3 != null) {
                    a3.close();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Async scan finished, costTime = ");
                sb.append(System.currentTimeMillis() - currentTimeMillis);
                sb.append(",fileCount = ");
                sb.append(i);
                sb.append("imageThumbCount =");
                sb.append(PhotoResolver.this.t.size());
                RVLogger.d("PhotoDisplayLink", sb.toString());
                PhotoResolver.this.j();
                PhotoResolver.this.e();
                ImageObserver.getInstance().active(new ArrayList(PhotoResolver.this.u));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Cursor a() {
        try {
            return this.c.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "bucket_display_name", CommonCode.MapKey.HAS_RESOLUTION, "_data", "_size", "mini_thumb_magic", "duration", "date_modified", "date_added", "datetaken", "latitude", "longitude"}, null, null, d());
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getVideoCursor exception:");
            sb.append(e.getMessage());
            GriverLogger.e(TAG, sb.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
    
        if (r3.moveToFirst() != false) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
    
        r7.t.put(r3.getInt(r3.getColumnIndex("image_id")), r3.getString(r3.getColumnIndex("_data")));
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0034, code lost:
    
        if (r3.moveToNext() != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0036, code lost:
    
        r3.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() {
        /*
            r7 = this;
            java.lang.String r0 = "PhotoResolver"
            java.lang.String r1 = "queryThumbnailInfo:###"
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r0, r1)
            long r1 = java.lang.System.currentTimeMillis()
            android.database.Cursor r3 = r7.g()
            if (r3 == 0) goto L53
            boolean r4 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L3a
            if (r4 == 0) goto L36
        L17:
            java.lang.String r4 = "image_id"
            int r4 = r3.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L3a
            int r4 = r3.getInt(r4)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r5 = "_data"
            int r5 = r3.getColumnIndex(r5)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r5 = r3.getString(r5)     // Catch: java.lang.Throwable -> L3a
            android.util.SparseArray<java.lang.String> r6 = r7.t     // Catch: java.lang.Throwable -> L3a
            r6.put(r4, r5)     // Catch: java.lang.Throwable -> L3a
            boolean r4 = r3.moveToNext()     // Catch: java.lang.Throwable -> L3a
            if (r4 != 0) goto L17
        L36:
            r3.close()     // Catch: java.lang.Throwable -> L3a
            goto L53
        L3a:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Parse thumbnail exception :"
            r4.append(r5)
            java.lang.String r3 = r3.getMessage()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            com.alibaba.ariver.kernel.common.utils.RVLogger.e(r0, r3)
        L53:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Query thumbnail cost time = "
            r3.append(r4)
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r1
            r3.append(r4)
            java.lang.String r1 = r3.toString()
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.photo.PhotoResolver.b():void");
    }

    private void a(Context context) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(context.getString(R.string.griver_image_str_media_time_pattern));
        this.k = simpleDateFormat;
        simpleDateFormat.setTimeZone(DesugarTimeZone.BuiltInFictitiousFunctionClassFactory("GMT"));
    }

    private void c() {
        RVLogger.d("PhotoDisplayLink", "initPhotoBucket");
        this.d = new HashMap();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new HashMap();
        this.m = new HashMap();
        this.n = new ArrayList();
        this.f6602o = new ArrayList();
        this.t = new SparseArray<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Cursor a(Cursor cursor, Cursor cursor2, boolean z) {
        long j;
        if ((cursor2 == null || cursor2.isBeforeFirst() || cursor2.isAfterLast()) && (cursor == null || cursor.isBeforeFirst() || cursor.isAfterLast())) {
            return null;
        }
        long j2 = -1;
        if (cursor2 != null && !cursor2.isBeforeFirst() && !cursor2.isAfterLast()) {
            j = cursor2.getLong(cursor2.getColumnIndex("date_added")) * 1000;
        } else {
            GriverLogger.e("mediaScan", "videoCursor no more data!");
            j = -1;
        }
        if (cursor != null && !cursor.isBeforeFirst() && !cursor.isAfterLast() && cursor != null && !cursor.isBeforeFirst() && !cursor.isAfterLast()) {
            j2 = cursor.getLong(cursor.getColumnIndex("date_added")) * 1000;
        }
        if (j2 < 0 && j < 0 && j2 < 0) {
            RVLogger.d("mediaScan", "both cursor no more data!");
            return null;
        } else if (j >= j2) {
            a(cursor2, z);
            return cursor2;
        } else {
            b(cursor, z);
            return cursor;
        }
    }

    private boolean a(Cursor cursor, boolean z) {
        if (cursor.getLong(cursor.getColumnIndex("_size")) >= this.b) {
            String string = cursor.getString(cursor.getColumnIndex("_data"));
            if (TextUtils.isEmpty(string)) {
                GriverLogger.e(TAG, "Video path is invalid.");
                return false;
            }
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(string);
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                try {
                    mediaMetadataRetriever.release();
                } catch (IOException e) {
                    GriverLogger.e(TAG, "MediaMetadataRetriever release error", e);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(GriverEnv.getApplicationContext().getExternalCacheDir());
                sb.append(File.separator);
                sb.append(SystemClock.currentThreadTimeMillis());
                sb.append(".jpg");
                File file = new File(sb.toString());
                if (file.exists()) {
                    file.delete();
                }
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    frameAtTime.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException unused) {
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(PhotoContext.FILE_SCHEME);
                sb2.append(file.getAbsolutePath());
                String obj = sb2.toString();
                if (file.exists() && file.isFile() && file.canRead()) {
                    int width = frameAtTime.getWidth();
                    int height = frameAtTime.getHeight();
                    if (width <= 0 || height <= 0) {
                        try {
                            Point a2 = a(string, width, height, false);
                            width = a2.x;
                            height = a2.y;
                        } catch (Exception e2) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Update size exception :");
                            sb3.append(e2.getMessage());
                            RVLogger.e(TAG, sb3.toString());
                        }
                    }
                    if (width <= 0 || height <= 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Invalid size : w = ");
                        sb4.append(width);
                        sb4.append("h = ");
                        sb4.append(height);
                        RVLogger.w(TAG, sb4.toString());
                    }
                    if (width < this.r || height < this.s) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Ignore photo when w=");
                        sb5.append(width);
                        sb5.append(",h=");
                        sb5.append(height);
                        RVLogger.d(TAG, sb5.toString());
                        return false;
                    }
                    long j = cursor.getLong(cursor.getColumnIndex("_size"));
                    long j2 = cursor.getLong(cursor.getColumnIndex("date_modified")) * 1000;
                    double d = cursor.getDouble(cursor.getColumnIndex("latitude"));
                    double d2 = cursor.getDouble(cursor.getColumnIndex("longitude"));
                    PhotoItem photoItem = new PhotoItem(obj);
                    a(photoItem, j2);
                    a(photoItem);
                    photoItem.setPhotoSize(j);
                    photoItem.setModifiedTime(j2);
                    photoItem.setPhotoHeight(height);
                    photoItem.setPhotoWidth(width);
                    photoItem.setLatitude(d);
                    photoItem.setLongitude(d2);
                    photoItem.setThumbPath(obj);
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(PhotoContext.FILE_SCHEME);
                    sb6.append(string);
                    photoItem.setVideoPath(sb6.toString());
                    return a(photoItem, cursor.getString(cursor.getColumnIndex("bucket_display_name")), z);
                }
                GriverLogger.e(TAG, "video file error,won`t add!");
                return false;
            } catch (Exception e3) {
                GriverLogger.e(TAG, "Get video thumbnail exception.");
                try {
                    mediaMetadataRetriever.release();
                } catch (IOException unused2) {
                    GriverLogger.e(TAG, "MediaMetadataRetriever release error", e3);
                }
                return false;
            }
        }
        GriverLogger.e(TAG, "video file size too small,won`t add!");
        return false;
    }

    private String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("date_added");
        sb.append(" ASC");
        sb.append(", _id");
        sb.append(" ASC");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.p.post(new Runnable() { // from class: com.alibaba.griver.image.photo.PhotoResolver.2
            @Override // java.lang.Runnable
            public void run() {
                PhotoResolver.this.h();
                if (PhotoResolver.this.j != null) {
                    RVLogger.d("PhotoDisplayLink", "OnScanFinished");
                    PhotoResolver.this.j.onScanFinished();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Cursor cursor) {
        return (cursor == null || !cursor.moveToPrevious() || cursor.isBeforeFirst()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Cursor f() {
        Cursor cursor;
        try {
            cursor = this.c.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, "bucket_display_name", "_data", "_size", "mime_type", ZebraData.ATTR_WIDTH, ZebraData.ATTR_HEIGHT, "orientation", "datetaken", "date_added", "date_modified", "latitude", "longitude"}, null, null, d());
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getImageCursor exception:");
            sb.append(e.getMessage());
            RVLogger.d(TAG, sb.toString());
            cursor = null;
        }
        if (cursor == null || !cursor.isClosed()) {
            return cursor;
        }
        return null;
    }

    private Cursor g() {
        Cursor cursor;
        try {
            cursor = this.c.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, new String[]{"image_id", "_data"}, null, null, null);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("GetThumbnailCursor exception :");
            sb.append(th.getMessage());
            RVLogger.e(TAG, sb.toString());
            cursor = null;
        }
        if (cursor == null || !cursor.isClosed()) {
            return cursor;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f.isEmpty() || this.e.isEmpty()) {
            return;
        }
        if (this.f.get(0).allPhoto) {
            this.f.remove(0);
        }
        BucketInfo bucketInfo = new BucketInfo(this.f6601a, 0, this.e.get(0), true);
        bucketInfo.allPhoto = true;
        this.f.add(0, bucketInfo);
        this.d.put(this.f6601a, this.e);
    }

    private boolean b(Cursor cursor, boolean z) {
        if (cursor.getLong(cursor.getColumnIndex("_size")) < this.b) {
            return false;
        }
        String string = cursor.getString(cursor.getColumnIndex("_data"));
        StringBuilder sb = new StringBuilder();
        sb.append(PhotoContext.FILE_SCHEME);
        sb.append(string);
        String obj = sb.toString();
        if (PhotoUtil.isQCompact()) {
            int i = cursor.getInt(cursor.getColumnIndex(FieldType.FOREIGN_ID_FIELD_SUFFIX));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString());
            sb2.append(File.separator);
            sb2.append(i);
            obj = Uri.parse(sb2.toString()).toString();
        } else {
            try {
                if (!TextUtils.isEmpty(string) && !string.contains(SemanticAttributes.DbSystemValues.CACHE) && string.contains("/")) {
                    this.u.add(string.substring(0, string.lastIndexOf("/")));
                }
            } catch (Exception e) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Parse observer path exception :");
                sb3.append(e.getMessage());
                RVLogger.e(TAG, sb3.toString());
            }
        }
        if (TextUtils.isEmpty(string)) {
            RVLogger.d(TAG, "Photo path is invalid.");
            return false;
        } else if (PhotoUtil.isQVersion() || APMSandboxProcessor.checkFileExist(obj)) {
            boolean equals = TextUtils.equals(cursor.getString(cursor.getColumnIndex("mime_type")), "image/gif");
            if (this.h || !equals) {
                long j = cursor.getLong(cursor.getColumnIndex("_size"));
                long j2 = cursor.getLong(cursor.getColumnIndex("date_modified")) * 1000;
                int i2 = cursor.getInt(cursor.getColumnIndex("orientation"));
                int i3 = cursor.getInt(cursor.getColumnIndex(ZebraData.ATTR_WIDTH));
                int i4 = cursor.getInt(cursor.getColumnIndex(ZebraData.ATTR_HEIGHT));
                if (i3 <= 0 || i4 <= 0) {
                    try {
                        Point a2 = a(string, i3, i4, equals);
                        i3 = a2.x;
                        i4 = a2.y;
                    } catch (Exception e2) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Update size exception :");
                        sb4.append(e2.getMessage());
                        RVLogger.e(TAG, sb4.toString());
                    }
                }
                if (i3 <= 0 || i4 <= 0) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Invalid size : w = ");
                    sb5.append(i3);
                    sb5.append("h = ");
                    sb5.append(i4);
                    RVLogger.w(TAG, sb5.toString());
                }
                if (i3 < this.r || i4 < this.s) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Ignore photo when w=");
                    sb6.append(i3);
                    sb6.append(",h=");
                    sb6.append(i4);
                    RVLogger.d(TAG, sb6.toString());
                    return false;
                }
                double d = cursor.getDouble(cursor.getColumnIndex("latitude"));
                double d2 = cursor.getDouble(cursor.getColumnIndex("longitude"));
                PhotoItem photoItem = new PhotoItem(obj);
                a(photoItem, j2);
                a(photoItem);
                photoItem.setPhotoSize(j);
                photoItem.setModifiedTime(j2);
                photoItem.setPhotoOrientation(i2);
                photoItem.setPhotoHeight(i4);
                photoItem.setPhotoWidth(i3);
                photoItem.setLatitude(d);
                photoItem.setLongitude(d2);
                String string2 = cursor.getString(cursor.getColumnIndex("bucket_display_name"));
                int i5 = cursor.getInt(cursor.getColumnIndex(FieldType.FOREIGN_ID_FIELD_SUFFIX));
                photoItem.setThumbPath(this.t.get(i5));
                photoItem.setMediaId(i5);
                photoItem.setIsAlbumMedia(true);
                if (equals) {
                    photoItem.setMediaSubType(100);
                }
                return a(photoItem, string2, z);
            }
            return false;
        } else {
            return false;
        }
    }

    private Point a(String str, int i, int i2, boolean z) {
        Point point = new Point(i, i2);
        if (this.l == null) {
            this.l = (GriverImageService) RVProxy.get(GriverImageService.class);
        }
        APImageInfo parseImageInfo = this.l.parseImageInfo(str);
        if (parseImageInfo != null) {
            point.x = parseImageInfo.width;
            point.y = parseImageInfo.height;
            StringBuilder sb = new StringBuilder();
            sb.append("Update wh to ");
            sb.append(i);
            sb.append(", ");
            sb.append(i2);
            RVLogger.d(TAG, sb.toString());
        }
        return point;
    }

    private void a(PhotoItem photoItem) {
        LinkedHashSet<String> linkedHashSet = this.i;
        if (linkedHashSet == null || !linkedHashSet.contains(photoItem.getPhotoPath())) {
            return;
        }
        photoItem.setSelected(true);
    }

    private void a(PhotoItem photoItem, long j) {
        try {
            photoItem.modifyTimeDesc = this.k.format(new Date(j));
        } catch (Exception unused) {
        }
    }

    private boolean a(PhotoItem photoItem, String str, boolean z) {
        String photoPath = photoItem.getPhotoPath();
        if (!this.h && photoPath.toLowerCase().endsWith(APImageFormat.SUFFIX_GIF)) {
            RVLogger.d(TAG, "select gif not enabled.");
            return false;
        } else if (photoItem.getPhotoSize() < this.b) {
            StringBuilder sb = new StringBuilder();
            sb.append("ignore small file ");
            sb.append(photoPath);
            RVLogger.d(TAG, sb.toString());
            return false;
        } else {
            BucketInfo bucketInfo = this.g.get(str);
            if (bucketInfo == null) {
                bucketInfo = new BucketInfo(str, 0, photoItem);
                this.g.put(str, bucketInfo);
                this.f6602o.add(z ? this.f6602o.size() : 0, bucketInfo);
            }
            if (!z) {
                bucketInfo.setPhoto(photoItem);
            }
            bucketInfo.increaseCount();
            List<PhotoItem> list = this.m.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.m.put(str, list);
            }
            this.n.add(z ? this.n.size() : 0, photoItem);
            list.add(z ? list.size() : 0, photoItem);
            if (this.q) {
                i();
                return true;
            }
            return true;
        }
    }

    private void i() {
        if ((this.j == null || this.n.size() != 100) && (this.n.size() <= 100 || this.n.size() % 1000 != 0)) {
            return;
        }
        if (TextUtils.equals(GriverConfig.getConfig("disable_bee_dialog_manager", ""), SummaryActivity.CHECKED)) {
            RVLogger.d("PhotoDisplayLink", "Config to disable step update.");
            return;
        }
        j();
        RVLogger.d("PhotoDisplayLink", "Do step update.");
        this.p.post(new Runnable() { // from class: com.alibaba.griver.image.photo.PhotoResolver.3
            @Override // java.lang.Runnable
            public void run() {
                if (PhotoResolver.this.j != null) {
                    PhotoResolver.this.h();
                    PhotoResolver.this.j.onScanStep();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        Map<String, List<PhotoItem>> map = this.m;
        List<PhotoItem> list = this.n;
        List<BucketInfo> list2 = this.f6602o;
        this.m = new HashMap();
        this.n = new ArrayList();
        this.f6602o = new ArrayList();
        this.m.putAll(map);
        this.n.addAll(list);
        this.f6602o.addAll(list2);
        this.d = map;
        this.e = list;
        this.f = list2;
    }

    public void setEnableStepScan(boolean z) {
        this.q = z;
    }
}
