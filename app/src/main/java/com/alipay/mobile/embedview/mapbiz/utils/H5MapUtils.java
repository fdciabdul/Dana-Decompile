package com.alipay.mobile.embedview.mapbiz.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.alibaba.griver.map.R;
import com.alipay.mobile.apmap.AdapterAMapUtils;
import com.alipay.mobile.apmap.mapcore.AdapterDPoint;
import com.alipay.mobile.apmap.mapcore.AdapterMapProjection;
import com.alipay.mobile.apmap.model.AdapterLatLng;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import com.alipay.mobile.embedview.mapbiz.ui.drawable.CircleImageDrawable;
import com.alipay.mobile.zebra.graphics.ZebraColor;
import com.alipay.mobile.zebra.utils.ZebraUtils;
import com.alipay.mobile.zebra.widget.TextBox;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes2.dex */
public final class H5MapUtils {
    public static int convertRGBAColor(String str) {
        return ZebraColor.parseColor(str);
    }

    public static int convertRGBAColor(String str, int i) {
        return ZebraColor.parseColor(str, i);
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, float f) {
        try {
            Matrix matrix = new Matrix();
            matrix.postRotate(f);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            RVLogger.e(H5MapContainer.TAG, th);
            return bitmap;
        }
    }

    public static Bitmap alphaBitmap(Bitmap bitmap, int i) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawARGB(0, 0, 0, 0);
            Paint paint = new Paint();
            paint.setAlpha(i);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return createBitmap;
        } catch (Throwable th) {
            RVLogger.e(H5MapContainer.TAG, th);
            return bitmap;
        }
    }

    public static Bitmap resizeBitmap(Bitmap bitmap, int i, int i2) {
        if (i > 0 && i2 > 0) {
            try {
                return Bitmap.createScaledBitmap(bitmap, i, i2, true);
            } catch (Throwable th) {
                RVLogger.e(H5MapContainer.TAG, th);
            }
        }
        return bitmap;
    }

    public static Bitmap getIconWithString(Context context, String str, String str2, Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.griver_map_marker);
        }
        return getIconWithString2(context, 12.0f, 17, str, str2, "#FFFFFF", bitmap);
    }

    public static Bitmap getIconWithString2(Context context, float f, int i, String str, String str2, String str3, Bitmap bitmap) {
        return getIconWithString2(context, f, i, str, str2, str3, bitmap, false);
    }

    public static Bitmap getIconWithString2(Context context, float f, int i, String str, String str2, String str3, Bitmap bitmap, boolean z) {
        if (context == null) {
            RVLogger.w(H5MapContainer.TAG, "iconFromView, context == null");
            return null;
        }
        int convertRGBAColor = convertRGBAColor(str2);
        int convertRGBAColor2 = convertRGBAColor(str3);
        View inflate = LayoutInflater.from(context).inflate(R.layout.griver_map_marker_icon_from_view, (ViewGroup) null);
        TextBox textBox = (TextBox) inflate.findViewById(R.id.icon_from_view_str);
        textBox.setEllipsize(null);
        textBox.setMaxLines(2);
        textBox.setTextSize(f);
        textBox.setText(str);
        textBox.setGravity(i);
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
        }
        inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
        ellipsizeEnd(textBox, str, 2);
        return ZebraUtils.draw(inflate);
    }

    public static void ellipsizeEnd(TextView textView, String str, int i) {
        int lineEnd;
        int i2;
        try {
            try {
                if (textView.getLineCount() > i && (lineEnd = textView.getLayout().getLineEnd(i)) >= 0 && lineEnd >= str.length() && lineEnd - 3 >= 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.substring(0, i2));
                    sb.append("...");
                    textView.setText(sb.toString());
                }
            } catch (Exception e) {
                RVLogger.e(H5MapContainer.TAG, e);
            }
        } finally {
            textView.setEllipsize(TextUtils.TruncateAt.END);
        }
    }

    public static boolean isSameJSONObject(JSONObject jSONObject, JSONObject jSONObject2) {
        return (jSONObject == null && jSONObject2 == null) || !(jSONObject == null || jSONObject2 == null || !TextUtils.equals(jSONObject.toJSONString(), jSONObject2.toJSONString()));
    }

    public static float calculateRotate(double d, double d2, double d3, double d4) {
        return (float) ((Math.atan((d4 - d2) / (d3 - d)) / 3.141592653589793d) * 180.0d);
    }

    public static double calculateDistance(List<AdapterLatLng> list) {
        int size;
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (list == null || (size = list.size()) == 0) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        int i = 0;
        while (i < size) {
            AdapterLatLng adapterLatLng = list.get(i);
            if (i == size - 1) {
                break;
            }
            i++;
            d += AdapterAMapUtils.calculateLineDistance(adapterLatLng, list.get(i));
        }
        return d;
    }

    public static AdapterLatLng getPointOnLine(AdapterLatLng adapterLatLng, AdapterLatLng adapterLatLng2, double d) {
        double calculateLineDistance = AdapterAMapUtils.calculateLineDistance(adapterLatLng, adapterLatLng2);
        if (calculateLineDistance <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return adapterLatLng;
        }
        double d2 = d / calculateLineDistance;
        if (adapterLatLng.is2dMapSdk()) {
            return new AdapterLatLng(adapterLatLng, adapterLatLng.getLatitude() + ((adapterLatLng2.getLatitude() - adapterLatLng.getLatitude()) * d2), adapterLatLng.getLongitude() + ((adapterLatLng2.getLongitude() - adapterLatLng.getLongitude()) * d2));
        }
        Point point = new Point();
        AdapterMapProjection.lonLat2Geo(adapterLatLng, adapterLatLng.getLongitude(), adapterLatLng.getLatitude(), point);
        Point point2 = new Point();
        AdapterMapProjection.lonLat2Geo(adapterLatLng2, adapterLatLng2.getLongitude(), adapterLatLng2.getLatitude(), point2);
        Point point3 = new Point();
        double d3 = point2.x - point.x;
        double d4 = point.x;
        Double.isNaN(d3);
        Double.isNaN(d4);
        point3.x = (int) ((d3 * d2) + d4);
        double d5 = point2.y - point.y;
        double d6 = point.y;
        Double.isNaN(d5);
        Double.isNaN(d6);
        point3.y = (int) ((d5 * d2) + d6);
        AdapterDPoint adapterDPoint = new AdapterDPoint();
        AdapterMapProjection.geo2LonLat(adapterLatLng, point3.x, point3.y, adapterDPoint);
        return new AdapterLatLng(adapterLatLng, adapterDPoint.y, adapterDPoint.x);
    }

    public static float getRotate(AdapterLatLng adapterLatLng, AdapterLatLng adapterLatLng2) {
        if (adapterLatLng == null || adapterLatLng2 == null) {
            return 0.0f;
        }
        return (float) ((Math.atan2(adapterLatLng2.getLongitude() - adapterLatLng.getLongitude(), adapterLatLng2.getLatitude() - adapterLatLng.getLatitude()) / 3.141592653589793d) * 180.0d);
    }

    public static boolean equals(Double d, Double d2) {
        return d == d2 || !(d == null || d2 == null || !d.equals(d2));
    }

    public static boolean getBooleanValue(JSONObject jSONObject, String str) {
        return getBooleanValue(jSONObject, str, false);
    }

    public static boolean getBooleanValue(JSONObject jSONObject, String str, boolean z) {
        Object obj;
        if (jSONObject == null || (obj = jSONObject.get(str)) == null) {
            return z;
        }
        try {
            return TypeUtils.castToBoolean(obj).booleanValue();
        } catch (Exception unused) {
            return z;
        }
    }

    public static float getFloatValue(JSONObject jSONObject, String str) {
        return getFloatValue(jSONObject, str, 0.0f);
    }

    public static float getFloatValue(JSONObject jSONObject, String str, float f) {
        Object obj;
        if (jSONObject == null || (obj = jSONObject.get(str)) == null) {
            return f;
        }
        try {
            return TypeUtils.castToFloat(obj).floatValue();
        } catch (Exception unused) {
            return f;
        }
    }

    public static double getDoubleValue(JSONObject jSONObject, String str) {
        return getDoubleValue(jSONObject, str, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public static double getDoubleValue(JSONObject jSONObject, String str, double d) {
        Object obj;
        if (jSONObject == null || (obj = jSONObject.get(str)) == null) {
            return d;
        }
        try {
            return TypeUtils.castToDouble(obj).doubleValue();
        } catch (Exception unused) {
            return d;
        }
    }

    public static int getIntValue(JSONObject jSONObject, String str) {
        return getIntValue(jSONObject, str, 0);
    }

    public static String getStringValue(JSONObject jSONObject, String str, String str2) {
        Object obj;
        if (jSONObject == null || (obj = jSONObject.get(str)) == null) {
            return str2;
        }
        try {
            return TypeUtils.castToString(obj);
        } catch (Exception unused) {
            return str2;
        }
    }

    public static int getIntValue(JSONObject jSONObject, String str, int i) {
        Object obj;
        if (jSONObject == null || (obj = jSONObject.get(str)) == null) {
            return i;
        }
        try {
            return TypeUtils.castToInt(obj).intValue();
        } catch (Exception unused) {
            return i;
        }
    }

    public static Object getObject(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.get(str);
        }
        return null;
    }

    public static Bitmap decodeStream(InputStream inputStream) {
        try {
            return BitmapFactory.decodeStream(inputStream);
        } catch (Throwable th) {
            RVLogger.e(H5MapContainer.TAG, th);
            return null;
        }
    }

    public static View findViewByClassName(View view, String str) {
        if (view == null || str == null) {
            return null;
        }
        if (str.equals(view.getClass().getName())) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                    View findViewByClassName = findViewByClassName(childAt, str);
                    if (findViewByClassName != null) {
                        return findViewByClassName;
                    }
                } else if (str.equals(childAt.getClass().getName())) {
                    return childAt;
                }
            }
            return null;
        }
        return null;
    }

    public static int sizeOf(List<?> list) {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public static <T extends Resettable> void reset(List<T> list) {
        if (list != null) {
            for (T t : list) {
                if (t != null) {
                    t.reset();
                }
            }
        }
    }
}
