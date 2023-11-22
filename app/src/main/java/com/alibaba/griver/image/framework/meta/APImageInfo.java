package com.alibaba.griver.image.framework.meta;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.image.framework.utils.Exif;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class APImageInfo {
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ROTATION_0 = 0;
    public static final int ROTATION_180 = 180;
    public static final int ROTATION_270 = 270;
    public static final int ROTATION_90 = 90;
    private APImageInfo b;
    public int correctHeight;
    public int correctWidth;
    public byte[] data;
    public Integer format;
    public int height;
    public int orientation;
    public String path;
    public int rotation;
    public int version;
    public int width;
    public static final Pattern sExcludePathPattern = Pattern.compile("(multimedia/[0-9a-z]{32})|(tencent)", 2);
    public static boolean sDecodeUnknownImageInfo = true;
    public static boolean sParseExifWhileDecodeError = false;

    /* renamed from: a  reason: collision with root package name */
    private static Set<String> f6579a = Collections.synchronizedSet(new HashSet());

    public static int getImageRotation(int i) {
        if (i != 1) {
            if (i != 3) {
                if (i != 6) {
                    return i != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        }
        return 0;
    }

    public APImageInfo(int i, int i2, int i3) {
        this.version = -1;
        this.format = null;
        this.width = i;
        this.height = i2;
        this.orientation = i3;
        this.rotation = getImageRotation(i3);
        a();
    }

    public APImageInfo() {
        this.orientation = 1;
        this.version = -1;
        this.format = null;
    }

    public static APImageInfo getImageInfo(Bitmap bitmap, int i) {
        APImageInfo aPImageInfo = new APImageInfo();
        if (bitmap != null) {
            aPImageInfo.width = bitmap.getWidth();
            aPImageInfo.height = bitmap.getHeight();
        }
        aPImageInfo.rotation = i;
        aPImageInfo.a();
        return aPImageInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
    
        if (com.alibaba.griver.image.framework.meta.APImageInfo.sParseExifWhileDecodeError != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        if (com.alibaba.griver.image.framework.meta.APImageInfo.sParseExifWhileDecodeError != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.alibaba.griver.image.framework.meta.APImageInfo getImageInfo(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.framework.meta.APImageInfo.getImageInfo(java.lang.String):com.alibaba.griver.image.framework.meta.APImageInfo");
    }

    private void a() {
        int i = this.orientation;
        if (i == 6 || i == 8) {
            this.correctWidth = this.height;
            this.correctHeight = this.width;
            return;
        }
        this.correctWidth = this.width;
        this.correctHeight = this.height;
    }

    public static APImageInfo getImageInfo(byte[] bArr) {
        long currentTimeMillis = System.currentTimeMillis();
        int orientation = Exif.getOrientation(bArr);
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (bArr != null) {
            try {
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("getImageInfo image: ");
                sb.append(bArr);
                sb.append(", error: ");
                sb.append(th);
                RVLogger.w("ImageInfo", sb.toString());
            }
        }
        APImageInfo aPImageInfo = new APImageInfo();
        aPImageInfo.width = options.outWidth;
        aPImageInfo.height = options.outHeight;
        aPImageInfo.rotation = getImageRotation(orientation);
        aPImageInfo.orientation = orientation;
        aPImageInfo.a();
        aPImageInfo.data = bArr;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getImageInfo from byte[], cost: ");
        sb2.append(System.currentTimeMillis() - currentTimeMillis);
        sb2.append(", info: ");
        sb2.append(aPImageInfo);
        RVLogger.d("ImageInfo", sb2.toString());
        return aPImageInfo;
    }

    public APImageInfo getThumbnailInfo() {
        if (this.b == null && !TextUtils.isEmpty(this.path) && !f6579a.contains(this.path) && !sExcludePathPattern.matcher(this.path).find() && matchFormat(0)) {
            try {
                byte[] thumbnail = new ExifInterface(this.path).getThumbnail();
                if (thumbnail != null) {
                    this.b = getImageInfo(thumbnail);
                }
            } catch (Exception unused) {
                f6579a.add(this.path);
            }
        }
        return this.b;
    }

    public int getFormat() {
        if (this.format == null) {
            byte[] bArr = this.data;
            this.format = Integer.valueOf(bArr == null ? ImageFileType.detectImageFileType(this.path) : ImageFileType.detectImageDataType(bArr));
        }
        return this.format.intValue();
    }

    public boolean matchFormat(int i) {
        return i == getFormat();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImageInfo{path='");
        sb.append(this.path);
        sb.append('\'');
        sb.append(", width=");
        sb.append(this.width);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", rotation=");
        sb.append(this.rotation);
        sb.append(", orientation=");
        sb.append(this.orientation);
        sb.append(", correctWidth=");
        sb.append(this.correctWidth);
        sb.append(", correctHeight=");
        sb.append(this.correctHeight);
        sb.append(", data=");
        sb.append(this.data);
        sb.append(", mThumbnailInfo=");
        sb.append(this.b);
        sb.append(", format=");
        sb.append(this.format);
        sb.append(", version=");
        sb.append(this.version);
        sb.append('}');
        return sb.toString();
    }
}
