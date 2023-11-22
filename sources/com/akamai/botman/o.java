package com.akamai.botman;

import android.os.SystemClock;
import kotlin.time.DurationKt;

/* loaded from: classes3.dex */
final class o {
    public static String BuiltInFictitiousFunctionClassFactory() {
        int i;
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i2 = 0;
            int i3 = 1;
            int i4 = 0;
            while (true) {
                if (i3 >= 1000000) {
                    break;
                }
                if (((4508713 % i3) * 11) % i3 == 0) {
                    i2++;
                }
                if (i3 % 100 == 0 && SystemClock.uptimeMillis() - uptimeMillis > 2) {
                    break;
                }
                i4++;
                i3++;
            }
            int i5 = i4 / 100;
            float f = 33.34f;
            long uptimeMillis2 = SystemClock.uptimeMillis();
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 1; i8 < 1000000; i8++) {
                f += i8;
                if ((19.239f * f) / 3.56f < 10000.0f) {
                    i6++;
                }
                if (i8 % 100 == 0 && SystemClock.uptimeMillis() - uptimeMillis2 > 2) {
                    break;
                }
                i7++;
            }
            int i9 = i7 / 100;
            long uptimeMillis3 = SystemClock.uptimeMillis();
            int i10 = 0;
            int i11 = 0;
            for (double d = 1.0d; d < 1000000.0d; d += 1.0d) {
                if (Math.sqrt(d) > 30.0d) {
                    i10++;
                }
                if (((int) d) % 100 == 0 && SystemClock.uptimeMillis() - uptimeMillis3 > 2) {
                    break;
                }
                i11++;
            }
            int i12 = i11 / 100;
            long uptimeMillis4 = SystemClock.uptimeMillis();
            int i13 = 0;
            int i14 = 1;
            int i15 = 0;
            for (i = DurationKt.NANOS_IN_MILLIS; i14 < i; i = DurationKt.NANOS_IN_MILLIS) {
                long j = uptimeMillis4;
                if (Math.acos(i14 / i) + Math.asin(i14 / i) + Math.atan(i14 / DurationKt.NANOS_IN_MILLIS) > 1.5d) {
                    i13++;
                }
                if (i14 % 100 == 0 && SystemClock.uptimeMillis() - j > 2) {
                    break;
                }
                i15++;
                i14++;
                uptimeMillis4 = j;
            }
            int i16 = i15 / 100;
            long uptimeMillis5 = SystemClock.uptimeMillis();
            int i17 = 0;
            for (int i18 = 1; i18 < 1000000 && SystemClock.uptimeMillis() - uptimeMillis5 <= 2; i18++) {
                i17++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(i2);
            sb.append(",");
            sb.append(i5);
            sb.append(",");
            sb.append(i6);
            sb.append(",");
            sb.append(i9);
            sb.append(",");
            sb.append(i10);
            sb.append(",");
            sb.append(i12);
            sb.append(",");
            sb.append(i13);
            sb.append(",");
            sb.append(i16);
            sb.append(",");
            sb.append(i17);
            return sb.toString();
        } catch (Exception e) {
            f.KClassImpl$Data$declaredNonStaticMembers$2(e);
            return "-1,-1,-1,-1,-1,-1,-1,-1,-1";
        }
    }
}
