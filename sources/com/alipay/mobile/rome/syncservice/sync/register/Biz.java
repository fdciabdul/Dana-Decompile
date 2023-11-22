package com.alipay.mobile.rome.syncservice.sync.register;

import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* loaded from: classes3.dex */
public final class Biz {

    /* renamed from: a  reason: collision with root package name */
    public String f7304a;
    public Integer b;
    public boolean c;
    public boolean d;
    public boolean e;
    public BizDimeEnum f;

    /* loaded from: classes3.dex */
    public enum BizDimeEnum {
        USER,
        DEVICE,
        NULL;

        public static BizDimeEnum getDime(String str) {
            BizDimeEnum bizDimeEnum = DEVICE;
            if (TextUtils.equals(str, bizDimeEnum.toString())) {
                return bizDimeEnum;
            }
            BizDimeEnum bizDimeEnum2 = USER;
            return TextUtils.equals(str, bizDimeEnum2.toString()) ? bizDimeEnum2 : NULL;
        }

        public static BizDimeEnum getDime(int i) {
            if (i == 1) {
                return USER;
            }
            if (i == 2) {
                return DEVICE;
            }
            return NULL;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7304a);
        sb.append(",");
        sb.append(this.b);
        sb.append(",");
        sb.append(this.c);
        sb.append(",");
        sb.append(this.d);
        sb.append(",");
        sb.append(this.e);
        sb.append(",");
        BizDimeEnum bizDimeEnum = this.f;
        sb.append(bizDimeEnum == null ? null : bizDimeEnum.toString());
        return sb.toString();
    }

    public static Biz a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(",");
        if (split == null || split.length < 6) {
            StringBuilder sb = new StringBuilder("parseBiz length error: ");
            sb.append(split);
            com.alipay.mobile.rome.syncsdk.util.c.d("Biz", sb.toString());
            return null;
        }
        Biz biz = new Biz();
        try {
            biz.f7304a = split[0];
            biz.b = Integer.valueOf(Integer.parseInt(split[1]));
            biz.c = Boolean.parseBoolean(split[2]);
            biz.d = Boolean.parseBoolean(split[3]);
            biz.e = Boolean.parseBoolean(split[4]);
            biz.f = BizDimeEnum.getDime(split[5]);
            return biz;
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder("parseBiz info=");
            sb2.append(str);
            sb2.append(", e=");
            sb2.append(e);
            com.alipay.mobile.rome.syncsdk.util.c.a("Biz", sb2.toString());
            String str2 = com.alipay.mobile.rome.syncsdk.a.a.a().f7211a;
            if (TextUtils.isEmpty(str2)) {
                str2 = com.alipay.mobile.rome.syncsdk.a.a.a().e();
            }
            com.alipay.mobile.rome.syncservice.sync.b a2 = com.alipay.mobile.rome.syncservice.sync.b.a();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            sb3.append(e);
            a2.a(sb3.toString(), null, str2, "3019");
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof Biz)) {
            Biz biz = (Biz) obj;
            return com.alipay.mobile.rome.syncservice.d.b.a(this.f7304a, biz.f7304a) && this.d == biz.d && this.c == biz.c && this.e == biz.e;
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.b;
        return (((((((num == null ? 0 : num.intValue()) + 629) * 37) + (this.c ? 1 : 0)) * 37) + (this.d ? 1 : 0)) * 37) + (this.e ? 1 : 0);
    }
}
