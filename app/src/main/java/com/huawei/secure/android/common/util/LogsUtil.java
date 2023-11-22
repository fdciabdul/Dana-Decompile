package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.regex.Pattern;

/* loaded from: classes8.dex */
public class LogsUtil {
    private static final Pattern PlaceComponentResult = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    /* loaded from: classes8.dex */
    static class a extends Throwable {
        private static final long d = 7129050843360571879L;

        /* renamed from: a  reason: collision with root package name */
        private String f7524a;
        private Throwable b;
        private Throwable c;

        public a(Throwable th) {
            this.c = th;
        }

        public void a(Throwable th) {
            this.b = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            Throwable th = this.b;
            if (th == this) {
                return null;
            }
            return th;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.f7524a;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable th = this.c;
            if (th == null) {
                return "";
            }
            String name = th.getClass().getName();
            if (this.f7524a != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(name);
                sb.append(": ");
                String obj = sb.toString();
                if (this.f7524a.startsWith(obj)) {
                    return this.f7524a;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj);
                sb2.append(this.f7524a);
                return sb2.toString();
            }
            return name;
        }

        public void a(String str) {
            this.f7524a = str;
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            return;
        }
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (!TextUtils.isEmpty(str3)) {
                int length = str3.length();
                int i = 1;
                if (1 == length) {
                    str3 = "*";
                } else {
                    StringBuilder sb2 = new StringBuilder(length);
                    for (int i2 = 0; i2 < length; i2++) {
                        char charAt = str3.charAt(i2);
                        if (PlaceComponentResult.matcher(String.valueOf(charAt)).matches()) {
                            if (i % 2 == 0) {
                                charAt = '*';
                            }
                            i++;
                        }
                        sb2.append(charAt);
                    }
                    str3 = sb2.toString();
                }
            }
            sb.append(str3);
        }
        InstrumentInjector.log_e(str, sb.toString());
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        InstrumentInjector.log_i(str, sb.toString());
    }

    public static void MyBillsEntityDataFactory(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        InstrumentInjector.log_e(str, sb.toString());
    }
}
