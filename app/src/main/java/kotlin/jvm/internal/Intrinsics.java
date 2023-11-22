package kotlin.jvm.internal;

import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* loaded from: classes.dex */
public class Intrinsics {
    public static final byte[] MyBillsEntityDataFactory = {116, 44, -28, -115, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -4, 13, -35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -34, 37, -9, 6, -10, 7, 4, -4, 13, -51, 39, -13, 16, -2, -39, 17, 10, -10};
    public static final int PlaceComponentResult = 112;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = kotlin.jvm.internal.Intrinsics.MyBillsEntityDataFactory
            int r6 = 69 - r6
            int r7 = 106 - r7
            int r8 = r8 + 12
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L30
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r8) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L30:
            int r8 = r8 + r6
            int r6 = r7 + 1
            int r7 = r8 + 2
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.Intrinsics.a(int, byte, short, java.lang.Object[]):void");
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    private Intrinsics() {
    }

    public static String stringPlus(String str, Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(obj);
        return sb.toString();
    }

    public static void checkNotNull(Object obj) {
        if (obj == null) {
            throwJavaNpe();
        }
    }

    public static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throwJavaNpe(str);
        }
    }

    public static void throwNpe() {
        throw ((KotlinNullPointerException) sanitizeStackTrace(new KotlinNullPointerException()));
    }

    public static void throwNpe(String str) {
        throw ((KotlinNullPointerException) sanitizeStackTrace(new KotlinNullPointerException(str)));
    }

    public static void throwJavaNpe() {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException()));
    }

    public static void throwJavaNpe(String str) {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(str)));
    }

    public static void throwUninitializedProperty(String str) {
        throw ((UninitializedPropertyAccessException) sanitizeStackTrace(new UninitializedPropertyAccessException(str)));
    }

    public static void throwUninitializedPropertyAccessException(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("lateinit property ");
        sb.append(str);
        sb.append(" has not been initialized");
        throwUninitializedProperty(sb.toString());
    }

    public static void throwAssert() {
        throw ((AssertionError) sanitizeStackTrace(new AssertionError()));
    }

    public static void throwAssert(String str) {
        throw ((AssertionError) sanitizeStackTrace(new AssertionError(str)));
    }

    public static void throwIllegalArgument() {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException()));
    }

    public static void throwIllegalArgument(String str) {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException(str)));
    }

    public static void throwIllegalState() {
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException()));
    }

    public static void throwIllegalState(String str) {
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(str)));
    }

    public static void checkExpressionValueIsNotNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" must not be null");
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(sb.toString())));
    }

    public static void checkNotNullExpressionValue(Object obj, String str) {
        if (obj != null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" must not be null");
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(sb.toString())));
    }

    public static void checkReturnedValueIsNotNull(Object obj, String str, String str2) {
        if (obj != null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Method specified as non-null returned null: ");
        sb.append(str);
        sb.append(".");
        sb.append(str2);
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(sb.toString())));
    }

    public static void checkReturnedValueIsNotNull(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(str)));
        }
    }

    public static void checkFieldIsNotNull(Object obj, String str, String str2) {
        if (obj != null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Field specified as non-null is null: ");
        sb.append(str);
        sb.append(".");
        sb.append(str2);
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(sb.toString())));
    }

    public static void checkFieldIsNotNull(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(str)));
        }
    }

    public static void checkParameterIsNotNull(Object obj, String str) {
        if (obj == null) {
            throwParameterIsNullIAE(str);
        }
    }

    public static void checkNotNullParameter(Object obj, String str) {
        if (obj == null) {
            throwParameterIsNullNPE(str);
        }
    }

    private static void throwParameterIsNullIAE(String str) {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException(createParameterIsNullExceptionMessage(str))));
    }

    private static void throwParameterIsNullNPE(String str) {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(createParameterIsNullExceptionMessage(str))));
    }

    private static String createParameterIsNullExceptionMessage(String str) {
        try {
            Object[] objArr = new Object[1];
            a(41, MyBillsEntityDataFactory[21], MyBillsEntityDataFactory[9], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(65, MyBillsEntityDataFactory[8], MyBillsEntityDataFactory[15], objArr2);
            Object invoke = cls.getMethod((String) objArr2[0], null).invoke(null, null);
            try {
                Object[] objArr3 = new Object[1];
                a(41, MyBillsEntityDataFactory[21], MyBillsEntityDataFactory[9], objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                a((byte) (-MyBillsEntityDataFactory[31]), (byte) (MyBillsEntityDataFactory[9] - 1), MyBillsEntityDataFactory[15], objArr4);
                StackTraceElement stackTraceElement = ((StackTraceElement[]) cls2.getMethod((String) objArr4[0], null).invoke(invoke, null))[4];
                try {
                    Object[] objArr5 = new Object[1];
                    a(26, MyBillsEntityDataFactory[21], (byte) (-MyBillsEntityDataFactory[7]), objArr5);
                    Class<?> cls3 = Class.forName((String) objArr5[0]);
                    byte b = MyBillsEntityDataFactory[21];
                    Object[] objArr6 = new Object[1];
                    a(b, (byte) (b + 3), MyBillsEntityDataFactory[21], objArr6);
                    String str2 = (String) cls3.getMethod((String) objArr6[0], null).invoke(stackTraceElement, null);
                    String methodName = stackTraceElement.getMethodName();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Parameter specified as non-null is null: method ");
                    sb.append(str2);
                    sb.append(".");
                    sb.append(methodName);
                    sb.append(", parameter ");
                    sb.append(str);
                    return sb.toString();
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th2;
            }
        } catch (Throwable th3) {
            Throwable cause3 = th3.getCause();
            if (cause3 != null) {
                throw cause3;
            }
            throw th3;
        }
    }

    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean areEqual(Double d, Double d2) {
        return d != null ? !(d2 == null || d.doubleValue() != d2.doubleValue()) : d2 == null;
    }

    public static boolean areEqual(Double d, double d2) {
        return d != null && d.doubleValue() == d2;
    }

    public static boolean areEqual(double d, Double d2) {
        return d2 != null && d == d2.doubleValue();
    }

    public static boolean areEqual(Float f, Float f2) {
        return f != null ? !(f2 == null || f.floatValue() != f2.floatValue()) : f2 == null;
    }

    public static boolean areEqual(Float f, float f2) {
        return f != null && f.floatValue() == f2;
    }

    public static boolean areEqual(float f, Float f2) {
        return f2 != null && f == f2.floatValue();
    }

    public static void throwUndefinedForReified() {
        throwUndefinedForReified("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void throwUndefinedForReified(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void reifiedOperationMarker(int i, String str) {
        throwUndefinedForReified();
    }

    public static void reifiedOperationMarker(int i, String str, String str2) {
        throwUndefinedForReified(str2);
    }

    public static void needClassReification() {
        throwUndefinedForReified();
    }

    public static void needClassReification(String str) {
        throwUndefinedForReified(str);
    }

    public static void checkHasClass(String str) throws ClassNotFoundException {
        String replace = str.replace('/', '.');
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Class ");
            sb.append(replace);
            sb.append(" is not found. Please update the Kotlin runtime to the latest version");
            throw ((ClassNotFoundException) sanitizeStackTrace(new ClassNotFoundException(sb.toString(), e)));
        }
    }

    public static void checkHasClass(String str, String str2) throws ClassNotFoundException {
        String replace = str.replace('/', '.');
        try {
            Class.forName(replace);
        } catch (ClassNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Class ");
            sb.append(replace);
            sb.append(" is not found: this code requires the Kotlin runtime of version at least ");
            sb.append(str2);
            throw ((ClassNotFoundException) sanitizeStackTrace(new ClassNotFoundException(sb.toString(), e)));
        }
    }

    private static <T extends Throwable> T sanitizeStackTrace(T t) {
        return (T) sanitizeStackTrace(t, Intrinsics.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends Throwable> T sanitizeStackTrace(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            StackTraceElement stackTraceElement = stackTrace[i2];
            try {
                Object[] objArr = new Object[1];
                a(26, MyBillsEntityDataFactory[21], (byte) (-MyBillsEntityDataFactory[7]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b = MyBillsEntityDataFactory[21];
                Object[] objArr2 = new Object[1];
                a(b, (byte) (b + 3), MyBillsEntityDataFactory[21], objArr2);
                if (str.equals(cls.getMethod((String) objArr2[0], null).invoke(stackTraceElement, null))) {
                    i = i2;
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    /* loaded from: classes2.dex */
    public static class Kotlin {
        private Kotlin() {
        }
    }
}
