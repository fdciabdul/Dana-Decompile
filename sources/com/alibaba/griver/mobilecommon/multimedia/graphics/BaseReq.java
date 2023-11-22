package com.alibaba.griver.mobilecommon.multimedia.graphics;

import android.content.Context;
import android.os.Bundle;
import com.alibaba.griver.mobilecommon.multimedia.api.data.BaseInfo;
import com.alibaba.griver.mobilecommon.multimedia.graphics.data.BaseOptions;
import com.alibaba.griver.mobilecommon.multimedia.graphics.data.CutScaleType;
import com.alibaba.griver.mobilecommon.multimedia.graphics.data.Size;
import com.alibaba.griver.mobilecommon.multimedia.graphics.load.Base64Optimization;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class BaseReq extends BaseInfo {
    public static final String KEY_FILE_KEY = "filekey";
    public static final String KEY_NETCHECK = "netcheck";
    public static final String KEY_REFID = "refid";
    public static final String KEY_SSID = "ssid";
    public static final int MAX_SUPER_SIZE = 16000;
    public static final int PRIORITY_HIGH = 10;
    public static final int PRIORITY_LOW = 1;
    public static final int PRIORITY_MID = 5;
    public static final int QUALITY_DJ_DEFUALT = 80;
    public static final int QUALITY_DJ_MIN = 40;
    public static final int QUALITY_NONE = -1;
    public String aliasPath;
    public Base64Optimization base64Optimization;
    public BaseOptions baseOptions;
    public Bundle bundle;
    public CutScaleType cutScaleType;
    public boolean detectedGif;
    public String fileKey;
    public Integer height;
    private WeakReference<Context> mContext;
    public Float scale;
    public CutScaleType secondaryCutScaleType;
    public Size srcSize;
    public boolean usingSourceType;
    public Integer width;
    private Integer quality = -1;
    private boolean bProgressive = false;
    public boolean shareGifMemCache = true;
    public boolean enableSaliency = false;

    public void setQuality(int i) {
        this.quality = Integer.valueOf(checkQuality(i));
    }

    public int getQuality() {
        return this.quality.intValue();
    }

    @Override // com.alibaba.griver.mobilecommon.multimedia.api.data.BaseInfo
    public void setPriority(int i) {
        super.setPriority(i);
    }

    @Override // com.alibaba.griver.mobilecommon.multimedia.api.data.BaseInfo
    public int getPriority() {
        return super.getPriority();
    }

    public void setProgressive(boolean z) {
        this.bProgressive = z;
    }

    public boolean isProgressive() {
        return this.bProgressive;
    }

    public void setContext(Context context) {
        if (context != null) {
            this.mContext = new WeakReference<>(context);
        }
    }

    public Context getContext() {
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private int checkQuality(int i) {
        if (i <= 0) {
            return -1;
        }
        if (i >= 80) {
            return 80;
        }
        if (i <= 0 || i >= 40) {
            return (i / 10) * 10;
        }
        return 40;
    }

    public static boolean isSuperSize(Integer num) {
        return (num == null || num.intValue() <= 16000 || num.intValue() == Integer.MAX_VALUE) ? false : true;
    }

    public void setEnableSaliency(boolean z) {
        this.enableSaliency = z;
    }

    @Override // com.alibaba.griver.mobilecommon.multimedia.api.data.BaseInfo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseReq{width=");
        sb.append(this.width);
        sb.append(", height=");
        sb.append(this.height);
        sb.append(", quality=");
        sb.append(this.quality);
        sb.append(", bProgressive=");
        sb.append(this.bProgressive);
        sb.append(", scale=");
        sb.append(this.scale);
        sb.append(", srcSize=");
        sb.append(this.srcSize);
        sb.append(", businessId='");
        sb.append(this.businessId);
        sb.append(", cutScaleType=");
        sb.append(this.cutScaleType);
        sb.append(", aliasPath=");
        sb.append(this.aliasPath);
        sb.append(", usingSourceType=");
        sb.append(this.usingSourceType);
        sb.append(", context=");
        sb.append(getContext());
        sb.append(", secondaryCutScaleType=");
        sb.append(this.secondaryCutScaleType);
        sb.append(", detectedGif=");
        sb.append(this.detectedGif);
        sb.append(", shareGifMemCache=");
        sb.append(this.shareGifMemCache);
        sb.append(", enableSaliency=");
        sb.append(this.enableSaliency);
        sb.append(", baseInfo=");
        sb.append(super.toString());
        sb.append(", fileKey=");
        sb.append(this.fileKey);
        sb.append(", bundle=");
        sb.append(this.bundle);
        sb.append('}');
        return sb.toString();
    }
}
