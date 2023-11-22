package com.google.firebase.crashlytics.internal.stacktrace;

import com.google.common.base.Ascii;
import java.lang.reflect.Array;
import java.util.HashMap;

/* loaded from: classes.dex */
public class RemoveRepeatsStrategy implements StackTraceTrimmingStrategy {
    private final int maxRepetitions;
    public static final byte[] PlaceComponentResult = {103, 121, -60, -41, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -34, 37, -9, 6, -10, 7, 4};
    public static final int BuiltInFictitiousFunctionClassFactory = 245;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r8, short r9, int r10, java.lang.Object[] r11) {
        /*
            int r8 = r8 * 2
            int r8 = r8 + 106
            int r10 = r10 * 4
            int r10 = 27 - r10
            int r9 = r9 * 3
            int r9 = 3 - r9
            byte[] r0 = com.google.firebase.crashlytics.internal.stacktrace.RemoveRepeatsStrategy.PlaceComponentResult
            byte[] r1 = new byte[r10]
            r2 = 0
            if (r0 != 0) goto L1a
            r8 = r9
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L37
        L1a:
            r3 = 0
        L1b:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            int r9 = r9 + 1
            if (r4 != r10) goto L2c
            java.lang.String r8 = new java.lang.String
            r8.<init>(r1, r2)
            r11[r2] = r8
            return
        L2c:
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r6
            r7 = r11
            r11 = r10
            r10 = r3
            r3 = r1
            r1 = r0
            r0 = r7
        L37:
            int r9 = r9 + r10
            int r9 = r9 + 2
            r10 = r11
            r11 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.stacktrace.RemoveRepeatsStrategy.a(int, short, int, java.lang.Object[]):void");
    }

    public RemoveRepeatsStrategy() {
        this(1);
    }

    public RemoveRepeatsStrategy(int i) {
        this.maxRepetitions = i;
    }

    @Override // com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy
    public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement[] trimRepeats = trimRepeats(stackTraceElementArr, this.maxRepetitions);
        return trimRepeats.length < stackTraceElementArr.length ? trimRepeats : stackTraceElementArr;
    }

    private static StackTraceElement[] trimRepeats(StackTraceElement[] stackTraceElementArr, int i) {
        int i2;
        HashMap hashMap = new HashMap();
        int length = stackTraceElementArr.length;
        byte b = PlaceComponentResult[16];
        byte b2 = b;
        Object[] objArr = new Object[1];
        a(b, b2, b2, objArr);
        Object[] objArr2 = (Object[]) Array.newInstance(Class.forName((String) objArr[0]), length);
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < stackTraceElementArr.length) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i3];
            Integer num = (Integer) hashMap.get(stackTraceElement);
            if (num == null || !isRepeatingSequence(stackTraceElementArr, num.intValue(), i3)) {
                objArr2[i4] = stackTraceElementArr[i3];
                i4++;
                i2 = i3;
                i5 = 1;
            } else {
                int intValue = i3 - num.intValue();
                if (i5 < i) {
                    System.arraycopy(stackTraceElementArr, i3, objArr2, i4, intValue);
                    i4 += intValue;
                    i5++;
                }
                i2 = (intValue - 1) + i3;
            }
            hashMap.put(stackTraceElement, Integer.valueOf(i3));
            i3 = i2 + 1;
        }
        byte b3 = PlaceComponentResult[16];
        byte b4 = b3;
        Object[] objArr3 = new Object[1];
        a(b3, b4, b4, objArr3);
        StackTraceElement[] stackTraceElementArr2 = (StackTraceElement[]) Array.newInstance(Class.forName((String) objArr3[0]), i4);
        System.arraycopy(objArr2, 0, stackTraceElementArr2, 0, i4);
        return stackTraceElementArr2;
    }

    private static boolean isRepeatingSequence(StackTraceElement[] stackTraceElementArr, int i, int i2) {
        int i3 = i2 - i;
        if (i2 + i3 > stackTraceElementArr.length) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!stackTraceElementArr[i + i4].equals(stackTraceElementArr[i2 + i4])) {
                return false;
            }
        }
        return true;
    }
}
