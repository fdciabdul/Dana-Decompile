package com.alibaba.griver.core.utils;

import android.text.TextUtils;
import com.iap.ac.android.common.log.ACLog;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class ParameterCheckUtil {
    public static boolean intInvalid(Object obj, boolean z) {
        int i = !z ? 1 : 0;
        if (obj != null) {
            boolean z2 = obj instanceof Integer;
            if (!z2 || ((Integer) obj).intValue() >= i) {
                boolean z3 = obj instanceof BigInteger;
                if (z3) {
                    BigInteger bigInteger = (BigInteger) obj;
                    if (bigInteger.compareTo(BigInteger.valueOf(2147483647L)) >= 0 || bigInteger.compareTo(BigInteger.valueOf(i)) < 0) {
                        return true;
                    }
                }
                boolean z4 = obj instanceof BigDecimal;
                if (z4) {
                    BigDecimal bigDecimal = (BigDecimal) obj;
                    if (bigDecimal.compareTo(BigDecimal.valueOf(2147483647L)) >= 0 || bigDecimal.compareTo(BigDecimal.valueOf(i)) < 0) {
                        return true;
                    }
                }
                boolean z5 = obj instanceof Long;
                if (z5) {
                    Long l = (Long) obj;
                    if (l.compareTo((Long) 2147483647L) >= 0 || l.compareTo(Long.valueOf(i)) < 0) {
                        return true;
                    }
                }
                boolean z6 = obj instanceof Double;
                if (z6) {
                    Double d = (Double) obj;
                    if (d.compareTo(Double.valueOf(2.147483647E9d)) >= 0 || d.compareTo(Double.valueOf(i)) < 0) {
                        return true;
                    }
                }
                return (z2 || z3 || z4 || z5 || z6) ? false : true;
            }
            return true;
        }
        return true;
    }

    public static int convert2IntValue(Object obj) {
        return convert2IntValue(obj, 0);
    }

    public static int convert2IntValue(Object obj, int i) {
        try {
            if (obj instanceof BigDecimal) {
                i = ((BigDecimal) obj).intValue();
            } else {
                i = ((Integer) obj).intValue();
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("convert2IntValue exception:");
            sb.append(e.getMessage());
            ACLog.e("ParameterChecker", sb.toString());
        }
        return i;
    }

    public static boolean stringInvalid(Object obj) {
        return !(obj instanceof String) || TextUtils.isEmpty(((String) obj).trim());
    }

    public static boolean listElementStringInvalid(Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                if (stringInvalid(it.next())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
