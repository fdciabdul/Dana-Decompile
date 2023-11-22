package com.alipay.mobile.embedview.mapbiz.utils;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alipay.mobile.embedview.mapbiz.ui.H5MapContainer;
import id.dana.cashier.view.InputCardNumberView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class WKT {

    /* renamed from: a  reason: collision with root package name */
    private static final int f7191a = 10;

    /* loaded from: classes2.dex */
    public interface WKTPoint {

        /* loaded from: classes6.dex */
        public interface Builder {
            WKTPoint build(double d, double d2);
        }

        double latitude();

        double longitude();
    }

    public static <T extends WKTPoint> List<T> fromLineString(String str, WKTPoint.Builder builder) {
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            return arrayList;
        }
        int length = str.length();
        int i = f7191a;
        if (length < i + 2) {
            return arrayList;
        }
        int i2 = i;
        for (int i3 = i + 1; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == ' ') {
                i2 = i3;
            } else if (charAt == ',' || i3 == length - 1) {
                try {
                    arrayList.add(builder.build(Double.parseDouble(str.substring(i2, i3)), Double.parseDouble(str.substring(i + 1, i2))));
                } catch (Exception e) {
                    RVLogger.e(H5MapContainer.TAG, e);
                }
                i = i3;
            }
        }
        return arrayList;
    }

    public static <T extends WKTPoint> String toLineString(List<T> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("LINESTRING");
        sb.append('(');
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i != 0) {
                    sb.append(',');
                }
                T t = list.get(i);
                sb.append(t.longitude());
                sb.append(InputCardNumberView.DIVIDER);
                sb.append(t.latitude());
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
