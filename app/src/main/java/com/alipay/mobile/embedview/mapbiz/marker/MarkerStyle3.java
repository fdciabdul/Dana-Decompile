package com.alipay.mobile.embedview.mapbiz.marker;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import com.alipay.mobile.zebra.ZebraLoader;

/* loaded from: classes6.dex */
public class MarkerStyle3 extends MarkerStyle {
    protected String mBgColor;
    protected String mColor;
    protected int mGravity;
    protected String mIcon;
    protected String mText;
    protected float mTextSize;

    @Override // com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle
    boolean measure() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MarkerStyle3(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle
    public MarkerStyle bindData(JSONObject jSONObject) {
        if (getContext() == null) {
            return this;
        }
        this.mIcon = jSONObject.getString("icon");
        this.mText = jSONObject.getString("text");
        this.mColor = jSONObject.containsKey("color") ? jSONObject.getString("color") : "#33B276";
        this.mBgColor = jSONObject.containsKey(RVParams.AROME_BG_COLOR) ? jSONObject.getString(RVParams.AROME_BG_COLOR) : "#FFFFFF";
        String string = jSONObject.getString("gravity");
        if (TextUtils.equals(string, "left")) {
            this.mGravity = 3;
        } else if (TextUtils.equals(string, "right")) {
            this.mGravity = 5;
        } else {
            this.mGravity = 17;
        }
        String string2 = jSONObject.getString("fontType");
        if (TextUtils.equals(string2, "small")) {
            this.mTextSize = 10.0f;
        } else if (TextUtils.equals(string2, "large")) {
            this.mTextSize = 14.0f;
        } else {
            this.mTextSize = 12.0f;
        }
        return this;
    }

    @Override // com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle
    void getBitmapImpl(final MarkerStyle.Callback callback) {
        if (TextUtils.isEmpty(this.mIcon)) {
            callback.call(H5MapUtils.getIconWithString2(getContext(), this.mTextSize, this.mGravity, this.mText, this.mColor, this.mBgColor, null), 0);
            return;
        }
        H5MapContainer h5MapContainer = this.mMapContainerRef.get();
        if (h5MapContainer != null) {
            h5MapContainer.resourceLoader.loadImage(this.mIcon, new ZebraLoader.OnLoadImageCallback() { // from class: com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle3.1
                @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadImageCallback
                public void onComplete(Bitmap bitmap) {
                    if (bitmap != null) {
                        callback.call(H5MapUtils.getIconWithString2(MarkerStyle3.this.getContext(), MarkerStyle3.this.mTextSize, MarkerStyle3.this.mGravity, MarkerStyle3.this.mText, MarkerStyle3.this.mColor, MarkerStyle3.this.mBgColor, bitmap), 0);
                    }
                }
            });
        }
    }
}
