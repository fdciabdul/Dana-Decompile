package com.alipay.mobile.embedview.mapbiz.data;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class TileOverlay implements Serializable {
    @JSONField(serialize = false)
    private String mergeUrl;
    public int tileHeight;
    public int tileWidth;
    public int type;
    public String url;
    public int zIndex;

    public String getMergeUrl() {
        if (this.type == 0) {
            if (TextUtils.isEmpty(this.mergeUrl)) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.url);
                sb.append("/%d/%d-%d-%d.png");
                this.mergeUrl = sb.toString();
            }
            return this.mergeUrl;
        }
        return "";
    }
}
