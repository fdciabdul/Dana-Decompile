package com.alibaba.griver.image.photo.meta;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.image.framework.meta.Size;
import com.alibaba.griver.image.framework.utils.Format;
import java.util.Map;

/* loaded from: classes2.dex */
public class PhotoInfo implements Parcelable {
    public static final Parcelable.Creator<PhotoInfo> CREATOR = new Parcelable.Creator<PhotoInfo>() { // from class: com.alibaba.griver.image.photo.meta.PhotoInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoInfo createFromParcel(Parcel parcel) {
            return new PhotoInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoInfo[] newArray(int i) {
            return new PhotoInfo[i];
        }
    };
    public static final int TYPE_PHOTO = 0;
    public static final int TYPE_PHOTO_SUB_TYPE_GIF = 100;
    public static final int TYPE_VIDEO = 1;
    public static final int TYPE_VIDEO_ORIGNAL = 2;
    private int A;
    private boolean B;
    private int C;
    private boolean D;
    private boolean E;
    private int F;

    /* renamed from: a  reason: collision with root package name */
    private int f6612a;
    private int b;
    public Bundle bizExtraParams;
    private double c;
    private double d;
    private long e;
    public Map<String, Object> extraInfo;
    private int f;
    private String g;
    private String h;
    private int i;
    public boolean isGiffSuffix;
    private int j;
    private int k;
    private int l;
    private Drawable m;
    private String n;

    /* renamed from: o  reason: collision with root package name */
    private int f6613o;
    public Size oriPhotoSize;
    private int p;
    private Drawable q;
    private String r;
    private String s;
    public String shadowPathInQ;
    private Drawable t;
    private Drawable u;
    private long v;
    public int videoHeight;
    public int videoWidth;
    public Rect viewBoundsOnScreen;
    private long w;
    private boolean x;
    private boolean y;
    private String z;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getMediaSubType() {
        return this.f6612a;
    }

    public void setMediaSubType(int i) {
        this.f6612a = i;
    }

    public boolean isGif() {
        return this.b == 0 && this.f6612a == 100;
    }

    public double getLatitude() {
        return this.c;
    }

    public void setLatitude(double d) {
        this.c = d;
    }

    public void setMediaType(int i) {
        this.b = i;
    }

    public double getLongitude() {
        return this.d;
    }

    public void setLongitude(double d) {
        this.d = d;
    }

    public int getPhotoGroupIndex() {
        return this.f;
    }

    public int getMediaType() {
        return this.b;
    }

    public boolean isVideo() {
        int i = this.b;
        return i == 1 || i == 2;
    }

    public void setVideoResolution(String str) {
        try {
            String[] split = str.split("x");
            this.videoWidth = Integer.valueOf(split[0]).intValue();
            this.videoHeight = Integer.valueOf(split[1]).intValue();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("解析视频宽高失败：");
            sb.append(e.getMessage());
            GriverLogger.d("videoCompact", sb.toString());
        }
    }

    public void setIsAlbumMedia(boolean z) {
        this.D = z;
    }

    public boolean getIsAlbumMedia() {
        return this.D;
    }

    public void setMediaId(int i) {
        this.F = i;
    }

    public int getMediaId() {
        return this.F;
    }

    public boolean isPicCurrentlyTaked() {
        return this.E;
    }

    public void setIsPicCurrentlyTaked(boolean z) {
        this.E = z;
    }

    public void setVideoPath(String str) {
        this.g = str;
    }

    public String getVideoPath() {
        return this.g;
    }

    public PhotoInfo(String str) {
        this(str, "", "");
    }

    public PhotoInfo(String str, String str2, String str3) {
        this.b = 0;
        this.B = false;
        this.h = str;
        boolean isGifSuffix = isGifSuffix(str);
        this.isGiffSuffix = isGifSuffix;
        if (isGifSuffix) {
            this.f6612a = 100;
        }
        this.r = str2;
        this.s = str3;
        this.v = 0L;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.f6613o = 0;
        this.p = 0;
        this.x = false;
        this.y = false;
        this.A = -1;
    }

    public PhotoInfo(Parcel parcel) {
        this.b = 0;
        this.B = false;
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.n = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readString();
        this.v = parcel.readLong();
        this.w = parcel.readLong();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.f6613o = parcel.readInt();
        this.p = parcel.readInt();
        this.x = parcel.readInt() > 0;
        this.y = parcel.readInt() > 0;
        this.z = parcel.readString();
        this.A = parcel.readInt();
        this.f = parcel.readInt();
        this.b = parcel.readInt();
        this.e = parcel.readLong();
        this.videoWidth = parcel.readInt();
        this.videoHeight = parcel.readInt();
        this.C = parcel.readInt();
        this.E = parcel.readInt() > 0;
        this.c = parcel.readDouble();
        this.d = parcel.readDouble();
        this.isGiffSuffix = parcel.readInt() > 0;
        this.f6612a = parcel.readInt();
        this.F = parcel.readInt();
        this.D = parcel.readInt() > 0;
    }

    public PhotoInfo(PhotoInfo photoInfo) {
        this.b = 0;
        this.B = false;
        this.g = photoInfo.g;
        this.h = photoInfo.h;
        this.m = photoInfo.m;
        this.r = photoInfo.r;
        this.s = photoInfo.s;
        this.t = photoInfo.t;
        this.q = photoInfo.q;
        this.n = photoInfo.n;
        this.v = photoInfo.v;
        this.w = photoInfo.w;
        this.u = photoInfo.u;
        this.i = photoInfo.i;
        this.j = photoInfo.j;
        this.k = photoInfo.k;
        this.l = photoInfo.l;
        this.f6613o = photoInfo.f6613o;
        this.p = photoInfo.p;
        this.x = photoInfo.x;
        this.y = photoInfo.y;
        this.z = photoInfo.z;
        this.A = photoInfo.A;
        this.f = photoInfo.f;
        this.b = photoInfo.b;
        this.e = photoInfo.e;
        this.videoHeight = photoInfo.videoHeight;
        this.videoWidth = photoInfo.videoWidth;
        this.C = photoInfo.C;
        this.E = photoInfo.E;
        this.c = photoInfo.c;
        this.d = photoInfo.d;
        this.isGiffSuffix = photoInfo.isGiffSuffix;
        this.B = photoInfo.B;
        this.extraInfo = photoInfo.extraInfo;
        this.bizExtraParams = photoInfo.bizExtraParams;
        this.f6612a = photoInfo.f6612a;
        this.F = photoInfo.F;
        this.D = photoInfo.D;
    }

    public void setPhotoOrientation(int i) {
        this.C = i;
    }

    public int getPhotoOrientation() {
        return this.C;
    }

    public String getThumbPath() {
        return this.n;
    }

    public PhotoInfo setThumbPath(String str) {
        this.n = str;
        return this;
    }

    public String getPhotoPath() {
        return this.h;
    }

    public PhotoInfo setPhotoPath(String str) {
        this.h = str;
        boolean isGifSuffix = isGifSuffix(str);
        this.isGiffSuffix = isGifSuffix;
        if (isGifSuffix) {
            this.f6612a = 100;
        }
        return this;
    }

    public String getLeftText() {
        return this.r;
    }

    public PhotoInfo setLeftText(String str) {
        this.r = str;
        return this;
    }

    public String getRightText() {
        return this.s;
    }

    public PhotoInfo setRightText(String str) {
        this.s = str;
        return this;
    }

    public long getPhotoSize() {
        return this.v;
    }

    public PhotoInfo setPhotoSize(long j) {
        this.v = j;
        return this;
    }

    public long getModifiedTime() {
        return this.w;
    }

    public PhotoInfo setModifiedTime(long j) {
        this.w = j;
        return this;
    }

    public Drawable getPhoto() {
        return this.m;
    }

    public PhotoInfo setPhoto(Drawable drawable) {
        this.m = drawable;
        return this;
    }

    public Drawable getThumb() {
        return this.q;
    }

    public PhotoInfo setThumb(Drawable drawable) {
        this.q = drawable;
        return this;
    }

    public Drawable getFail() {
        return this.t;
    }

    public PhotoInfo setFail(Drawable drawable) {
        this.t = drawable;
        return this;
    }

    public Drawable getLoading() {
        return this.u;
    }

    public PhotoInfo setLoading(Drawable drawable) {
        this.u = drawable;
        return this;
    }

    public int getPhotoWidth() {
        return this.i;
    }

    public PhotoInfo setPhotoWidth(int i) {
        this.i = i;
        return this;
    }

    public int getPhotoHeight() {
        return this.j;
    }

    public PhotoInfo setPhotoHeight(int i) {
        this.j = i;
        return this;
    }

    public boolean getLoadOrigin() {
        return this.x;
    }

    public PhotoInfo setLoadOrigin(boolean z) {
        this.x = z;
        return this;
    }

    public int getPhotoIndex() {
        return this.A;
    }

    public PhotoInfo setPhotoIndex(int i) {
        this.A = i;
        return this;
    }

    public int getLargePhotoWidth() {
        return this.k;
    }

    public void setLargePhotoWidth(int i) {
        this.k = i;
    }

    public int getLargePhotoHeight() {
        return this.l;
    }

    public void setLargePhotoHeight(int i) {
        this.l = i;
    }

    public void setInEdited(boolean z) {
        this.B = z;
    }

    public boolean getInEdited() {
        return this.B;
    }

    public boolean getSelected() {
        return this.y;
    }

    public PhotoInfo setSelected(boolean z) {
        this.y = z;
        return this;
    }

    public long getVideoDuration() {
        return this.e;
    }

    public void setVideoDuration(long j) {
        this.e = j;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public void setVideoWidth(int i) {
        this.videoWidth = i;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public void setVideoHeight(int i) {
        this.videoHeight = i;
    }

    public String getTag() {
        return this.z;
    }

    public PhotoInfo setTag(String str) {
        this.z = str;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.n);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeLong(this.v);
        parcel.writeLong(this.w);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.f6613o);
        parcel.writeInt(this.p);
        parcel.writeInt(this.x ? 1 : 0);
        parcel.writeInt(this.y ? 1 : 0);
        parcel.writeString(this.z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.f);
        parcel.writeInt(this.b);
        parcel.writeLong(this.e);
        parcel.writeInt(this.videoWidth);
        parcel.writeInt(this.videoHeight);
        parcel.writeInt(this.C);
        parcel.writeInt(this.E ? 1 : 0);
        parcel.writeDouble(this.c);
        parcel.writeDouble(this.d);
        parcel.writeInt(this.isGiffSuffix ? 1 : 0);
        parcel.writeInt(this.f6612a);
        parcel.writeInt(this.F);
        parcel.writeInt(this.D ? 1 : 0);
    }

    public boolean isGifSuffix(String str) {
        if (str == null || str.length() <= 4) {
            return false;
        }
        int length = str.length();
        return str.substring(length - 4, length).equalsIgnoreCase(Format.SUFFIX_GIF);
    }
}
