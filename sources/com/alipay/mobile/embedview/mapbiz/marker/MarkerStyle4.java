package com.alipay.mobile.embedview.mapbiz.marker;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.utils.DensityUtil;
import com.alibaba.griver.map.R;
import com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.ui.drawable.CircleImageDrawable;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import com.alipay.mobile.zebra.ZebraLoader;
import com.alipay.mobile.zebra.utils.ZebraUtils;
import com.alipay.mobile.zebra.widget.TextBox;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public class MarkerStyle4 extends MarkerStyle3 {
    protected static final LruCache<String, Object> sIconSuccessCache = new LruCache<>(99);
    protected String mAnimationImage;
    protected double mAnimationImageHeight;
    protected double mAnimationImageWidth;
    protected double mAnimationImageY;
    protected String mDefaultIcon;
    protected double mIconHeight;
    protected double mIconWidth;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MarkerStyle4(H5MapContainer h5MapContainer) {
        super(h5MapContainer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle3, com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle
    public MarkerStyle bindData(JSONObject jSONObject) {
        if (getContext() == null) {
            return this;
        }
        super.bindData(jSONObject);
        this.mDefaultIcon = jSONObject.getString("defaultIcon");
        this.mIconWidth = H5MapUtils.getDoubleValue(jSONObject, "iconWidth");
        this.mIconHeight = H5MapUtils.getDoubleValue(jSONObject, "iconHeight");
        this.mAnimationImageY = H5MapUtils.getDoubleValue(jSONObject, "animationImageY");
        this.mAnimationImageWidth = H5MapUtils.getDoubleValue(jSONObject, "animationImageWidth");
        this.mAnimationImageHeight = H5MapUtils.getDoubleValue(jSONObject, "animationImageHeight");
        JSONArray jSONArray = jSONObject.getJSONArray("animationImages");
        if (jSONArray != null && jSONArray.size() > 0) {
            this.mAnimationImage = jSONArray.getString(0);
        }
        return this;
    }

    @Override // com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle3, com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle
    void getBitmapImpl(final MarkerStyle.Callback callback) {
        if (TextUtils.isEmpty(this.mAnimationImage)) {
            getBitmapImpl(callback, null);
            return;
        }
        H5MapContainer h5MapContainer = this.mMapContainerRef.get();
        if (h5MapContainer != null) {
            h5MapContainer.resourceLoader.loadImage(this.mAnimationImage, new ZebraLoader.OnLoadImageCallback() { // from class: com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle4.1
                @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadImageCallback
                public void onComplete(Bitmap bitmap) {
                    MarkerStyle4.this.getBitmapImpl(callback, bitmap);
                }
            });
        }
    }

    void getBitmapImpl(final MarkerStyle.Callback callback, final Bitmap bitmap) {
        if (TextUtils.isEmpty(this.mIcon) && TextUtils.isEmpty(this.mDefaultIcon)) {
            callback.call(getIconWithString2(getContext(), null, true, bitmap), 0);
            return;
        }
        final H5MapContainer h5MapContainer = this.mMapContainerRef.get();
        if (TextUtils.isEmpty(this.mDefaultIcon) && h5MapContainer != null) {
            h5MapContainer.resourceLoader.loadImage(this.mIcon, new ZebraLoader.OnLoadImageCallback() { // from class: com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle4.2
                @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadImageCallback
                public void onComplete(Bitmap bitmap2) {
                    if (bitmap2 != null) {
                        MarkerStyle4 markerStyle4 = MarkerStyle4.this;
                        callback.call(markerStyle4.getIconWithString2(markerStyle4.getContext(), bitmap2, true, bitmap), 0);
                        if (TextUtils.isEmpty(MarkerStyle4.this.mIcon)) {
                            return;
                        }
                        MarkerStyle4.sIconSuccessCache.put(MarkerStyle4.this.mIcon, new Object());
                    }
                }
            });
        } else if (h5MapContainer != null) {
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            h5MapContainer.resourceLoader.loadImage(this.mDefaultIcon, new ZebraLoader.OnLoadImageCallback() { // from class: com.alipay.mobile.embedview.mapbiz.marker.MarkerStyle4.3
                @Override // com.alipay.mobile.zebra.ZebraLoader.OnLoadImageCallback
                public void onComplete(Bitmap bitmap2) {
                    if (bitmap2 != null || !atomicBoolean.get()) {
                        MarkerStyle4 markerStyle4 = MarkerStyle4.this;
                        Bitmap iconWithString2 = markerStyle4.getIconWithString2(markerStyle4.getContext(), bitmap2, true, bitmap);
                        if (atomicBoolean.get()) {
                            callback.call(iconWithString2, 0);
                            if (!TextUtils.isEmpty(MarkerStyle4.this.mIcon)) {
                                MarkerStyle4.sIconSuccessCache.put(MarkerStyle4.this.mIcon, new Object());
                            }
                        } else if (!TextUtils.isEmpty(MarkerStyle4.this.mIcon) && MarkerStyle4.sIconSuccessCache.get(MarkerStyle4.this.mIcon) == null) {
                            callback.call(iconWithString2, 0);
                        } else if (callback.call(iconWithString2, 1)) {
                            return;
                        }
                    }
                    if (atomicBoolean.get()) {
                        return;
                    }
                    atomicBoolean.set(true);
                    if (TextUtils.isEmpty(MarkerStyle4.this.mIcon)) {
                        return;
                    }
                    h5MapContainer.resourceLoader.loadImage(MarkerStyle4.this.mIcon, this);
                }
            });
        }
    }

    protected Bitmap getIconWithString2(Context context, Bitmap bitmap, boolean z, Bitmap bitmap2) {
        ViewGroup.LayoutParams layoutParams;
        if (context == null) {
            RVLogger.w(H5MapContainer.TAG, "iconFromView, context == null");
            return null;
        }
        int convertRGBAColor = H5MapUtils.convertRGBAColor(this.mColor);
        int convertRGBAColor2 = H5MapUtils.convertRGBAColor(this.mBgColor);
        View inflate = LayoutInflater.from(context).inflate(R.layout.griver_map_marker_icon_from_view_style_4, (ViewGroup) null);
        TextBox textBox = (TextBox) inflate.findViewById(R.id.icon_from_view_str);
        textBox.setEllipsize(null);
        textBox.setMaxLines(2);
        textBox.setTextSize(this.mTextSize);
        textBox.setText(this.mText);
        textBox.setGravity(this.mGravity);
        textBox.setTextColor(convertRGBAColor);
        textBox.setStrokeWidth(8);
        textBox.setStrokeColor(convertRGBAColor2);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.icon_from_view_icon);
        if (bitmap == null || bitmap.isRecycled()) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            if (z) {
                imageView.setImageDrawable(new CircleImageDrawable(bitmap).setStrokeWidth(6).setStrokeColor(convertRGBAColor2));
            } else {
                imageView.setImageBitmap(bitmap);
            }
            if (this.mIconWidth != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && this.mIconHeight != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && (layoutParams = imageView.getLayoutParams()) != null) {
                layoutParams.width = DensityUtil.dip2px(context, (float) this.mIconWidth);
                layoutParams.height = DensityUtil.dip2px(context, (float) this.mIconHeight);
                imageView.setLayoutParams(layoutParams);
            }
        }
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.icon_from_view_animation);
        if (bitmap2 == null || bitmap2.isRecycled() || bitmap == null || bitmap.isRecycled()) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(0);
            imageView2.setImageBitmap(bitmap2);
            if (this.mAnimationImageWidth != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && this.mAnimationImageHeight != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
                    layoutParams3.width = DensityUtil.dip2px(context, (float) this.mAnimationImageWidth);
                    layoutParams3.height = DensityUtil.dip2px(context, (float) this.mAnimationImageHeight);
                    double d = this.mAnimationImageY;
                    if (d != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        layoutParams3.topMargin = DensityUtil.dip2px(context, (float) d);
                    }
                    imageView2.setLayoutParams(layoutParams3);
                }
            }
        }
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
        H5MapUtils.ellipsizeEnd(textBox, this.mText, 2);
        return ZebraUtils.draw(inflate);
    }
}
