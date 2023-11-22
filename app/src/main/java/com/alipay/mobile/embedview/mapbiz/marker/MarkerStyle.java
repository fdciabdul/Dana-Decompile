package com.alipay.mobile.embedview.mapbiz.marker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.utils.H5MapUtils;
import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public abstract class MarkerStyle {
    protected WeakReference<H5MapContainer> mMapContainerRef;
    protected int mMeasuredWidth = 0;
    protected int mMeasuredHeight = 0;

    /* loaded from: classes6.dex */
    public interface Callback {
        public static final int ERRCODE_MEASURE = -1;
        public static final int ERRCODE_SUCCESS = 0;
        public static final int ERRCODE_SUCCESS_PART = 1;

        boolean call(Bitmap bitmap, int i);
    }

    abstract MarkerStyle bindData(JSONObject jSONObject);

    abstract void getBitmapImpl(Callback callback);

    abstract boolean measure();

    /* JADX INFO: Access modifiers changed from: package-private */
    public MarkerStyle(H5MapContainer h5MapContainer) {
        this.mMapContainerRef = new WeakReference<>(h5MapContainer);
    }

    final Page getH5Page() {
        H5MapContainer h5MapContainer = this.mMapContainerRef.get();
        if (h5MapContainer != null) {
            return h5MapContainer.getH5Page();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Context getContext() {
        H5MapContainer h5MapContainer = this.mMapContainerRef.get();
        if (h5MapContainer != null) {
            return h5MapContainer.getContext();
        }
        return null;
    }

    public final void getBitmap(Callback callback) {
        if (callback == null) {
            return;
        }
        try {
            if (measure()) {
                getBitmapImpl(callback);
            } else {
                callback.call(null, -1);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Matrix getMatrix(Rect rect, Rect rect2) {
        float f;
        float f2;
        Matrix matrix = new Matrix();
        int width = rect.width();
        int height = rect.height();
        int width2 = rect2.width();
        int height2 = rect2.height();
        if ((width < 0 || width2 == width) && (height < 0 || height2 == height)) {
            return matrix;
        }
        float f3 = 0.0f;
        if (width * height2 > width2 * height) {
            f2 = height2 / height;
            f3 = (width2 - (width * f2)) * 0.5f;
            f = 0.0f;
        } else {
            float f4 = width2 / width;
            f = (height2 - (height * f4)) * 0.5f;
            f2 = f4;
        }
        matrix.setScale(f2, f2);
        matrix.postTranslate(Math.round(f3), Math.round(f));
        return matrix;
    }

    public static MarkerStyle fromJSONObject(JSONObject jSONObject, H5MapContainer h5MapContainer) {
        int intValue = H5MapUtils.getIntValue(jSONObject, "type");
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue == 4) {
                        return new MarkerStyle4(h5MapContainer).bindData(jSONObject);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("invalid type for style: ");
                    sb.append(String.valueOf(H5MapUtils.getObject(jSONObject, "type")));
                    RVLogger.w(H5MapContainer.TAG, sb.toString());
                    return null;
                }
                return new MarkerStyle3(h5MapContainer).bindData(jSONObject);
            }
            return new MarkerStyle2(h5MapContainer).bindData(jSONObject);
        }
        return new MarkerStyle1(h5MapContainer).bindData(jSONObject);
    }

    public static MarkerStyle fromLabel(JSONObject jSONObject, H5MapContainer h5MapContainer, Bitmap bitmap) {
        return new MarkerLabel(h5MapContainer, bitmap).bindData(jSONObject);
    }
}
