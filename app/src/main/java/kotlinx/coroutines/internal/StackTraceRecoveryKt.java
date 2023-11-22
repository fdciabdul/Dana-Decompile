package kotlinx.coroutines.internal;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.huawei.hms.push.e;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CopyableThrowable;
import kotlinx.coroutines.DebugKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u001a\u0019\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a;\u0010\f\u001a\u00028\u0000\"\b\b\u0000\u0010\u0007*\u00020\u00062\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00002\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\nH\u0002¢\u0006\u0004\b\f\u0010\r\u001a%\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\n2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\u001a3\u0010\u0016\u001a\u00020\u00152\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00132\u0010\u0010\t\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a-\u0010\u0019\u001a\u00028\u0000\"\b\b\u0000\u0010\u0007*\u00020\u00062\u0006\u0010\u0018\u001a\u00028\u00002\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a!\u0010\u001b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0007*\u00020\u00062\u0006\u0010\u0018\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a#\u0010\u001d\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0007*\u00020\u00062\u0006\u0010\u0018\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u001d\u0010\u001c\u001a!\u0010\u001e\u001a\u00028\u0000\"\b\b\u0000\u0010\u0007*\u00020\u00062\u0006\u0010\u0018\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u001e\u0010\u001c\u001a3\u0010 \u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00130\u001f\"\b\b\u0000\u0010\u0007*\u00020\u0006*\u00028\u0000H\u0002¢\u0006\u0004\b \u0010!\u001a#\u0010$\u001a\u00020#*\u00060\u0002j\u0002`\u00032\n\u0010\"\u001a\u00060\u0002j\u0002`\u0003H\u0002¢\u0006\u0004\b$\u0010%\u001a%\u0010(\u001a\u00020'*\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00132\u0006\u0010&\u001a\u00020\u0000H\u0002¢\u0006\u0004\b(\u0010)\u001a\u0017\u0010*\u001a\u00020#*\u00060\u0002j\u0002`\u0003H\u0000¢\u0006\u0004\b*\u0010+\u001a\u001d\u0010,\u001a\u00028\u0000\"\b\b\u0000\u0010\u0007*\u00020\u0006*\u00028\u0000H\u0002¢\u0006\u0004\b,\u0010\u001c\"\u0018\u0010-\u001a\u0006*\u00020\u00000\u00008\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b-\u0010.\"\u0018\u0010/\u001a\u0006*\u00020\u00000\u00008\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b/\u0010.*\f\b\u0000\u00100\"\u00020\u000e2\u00020\u000e*\f\b\u0000\u00101\"\u00020\u00022\u00020\u0002"}, d2 = {"", "message", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "artificialFrame", "(Ljava/lang/String;)Ljava/lang/StackTraceElement;", "", "E", "cause", "result", "Ljava/util/ArrayDeque;", "resultStackTrace", "createFinalException", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "continuation", "createStackTrace", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/util/ArrayDeque;", "", "recoveredStacktrace", "", "mergeRecoveredTraces", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "exception", "recoverFromStackFrame", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "tryCopyAndVerify", "unwrapImpl", "Lkotlin/Pair;", "causeAndStacktrace", "(Ljava/lang/Throwable;)Lkotlin/Pair;", e.PlaceComponentResult, "", "elementWiseEquals", "(Ljava/lang/StackTraceElement;Ljava/lang/StackTraceElement;)Z", "methodName", "", "frameIndex", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "isArtificial", "(Ljava/lang/StackTraceElement;)Z", "sanitizeStackTrace", "baseContinuationImplClassName", "Ljava/lang/String;", "stackTraceRecoveryClassName", "CoroutineStackFrame", "StackTraceElement"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StackTraceRecoveryKt {
    private static final String baseContinuationImplClassName;
    private static final String stackTraceRecoveryClassName;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {TarHeader.LF_DIR, 18, -76, 65, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 34, -37, 9, -6, 10, -7, -4, 4, -13, TarHeader.LF_CHR, -39, 13, -16, 2, 39, -17, -10, 10};
    public static final int getAuthRequestContext = 251;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:23:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = kotlinx.coroutines.internal.StackTraceRecoveryKt.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 + 4
            int r6 = r6 * 15
            int r6 = 27 - r6
            int r8 = r8 * 3
            int r8 = r8 + 103
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r3 = r8
            r4 = 0
            r8 = r7
            r7 = r6
            goto L30
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r7 = r7 + 1
            int r4 = r3 + 1
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r3 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L30:
            int r3 = -r3
            int r6 = r6 + r3
            int r6 = r6 + 2
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.StackTraceRecoveryKt.a(int, int, short, java.lang.Object[]):void");
    }

    public static final /* synthetic */ Throwable access$recoverFromStackFrame(Throwable th, CoroutineStackFrame coroutineStackFrame) {
        return recoverFromStackFrame(th, coroutineStackFrame);
    }

    static {
        Object obj;
        Object obj2;
        try {
            Result.Companion companion = Result.INSTANCE;
            obj = Result.m3179constructorimpl(Class.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl").getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            obj = Result.m3179constructorimpl(ResultKt.createFailure(th));
        }
        baseContinuationImplClassName = (String) (Result.m3182exceptionOrNullimpl(obj) == null ? obj : "kotlin.coroutines.jvm.internal.BaseContinuationImpl");
        try {
            Result.Companion companion3 = Result.INSTANCE;
            obj2 = Result.m3179constructorimpl(Class.forName("kotlinx.coroutines.internal.StackTraceRecoveryKt").getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            obj2 = Result.m3179constructorimpl(ResultKt.createFailure(th2));
        }
        stackTraceRecoveryClassName = (String) (Result.m3182exceptionOrNullimpl(obj2) == null ? obj2 : "kotlinx.coroutines.internal.StackTraceRecoveryKt");
    }

    public static final <E extends Throwable> E recoverStackTrace(E e) {
        Throwable tryCopyAndVerify;
        return (DebugKt.getRECOVER_STACK_TRACES() && (tryCopyAndVerify = tryCopyAndVerify(e)) != null) ? (E) sanitizeStackTrace(tryCopyAndVerify) : e;
    }

    private static final <E extends Throwable> E sanitizeStackTrace(E e) {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        int frameIndex = frameIndex(stackTrace, stackTraceRecoveryClassName);
        int frameIndex2 = frameIndex(stackTrace, baseContinuationImplClassName);
        int i = (length - frameIndex) - (frameIndex2 == -1 ? 0 : length - frameIndex2);
        byte b = KClassImpl$Data$declaredNonStaticMembers$2[16];
        byte b2 = (byte) (b - 1);
        Object[] objArr = new Object[1];
        a(b, b2, (byte) (-b2), objArr);
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) Array.newInstance(Class.forName((String) objArr[0]), i);
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stackTraceElement = artificialFrame("Coroutine boundary");
            } else {
                stackTraceElement = stackTrace[((frameIndex + 1) + i2) - 1];
            }
            stackTraceElementArr[i2] = stackTraceElement;
        }
        e.setStackTrace(stackTraceElementArr);
        return e;
    }

    public static final <E extends Throwable> E recoverFromStackFrame(E e, CoroutineStackFrame coroutineStackFrame) {
        Pair causeAndStacktrace = causeAndStacktrace(e);
        Throwable th = (Throwable) causeAndStacktrace.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) causeAndStacktrace.component2();
        Throwable tryCopyAndVerify = tryCopyAndVerify(th);
        if (tryCopyAndVerify == null) {
            return e;
        }
        ArrayDeque<StackTraceElement> createStackTrace = createStackTrace(coroutineStackFrame);
        if (createStackTrace.isEmpty()) {
            return e;
        }
        if (th != e) {
            mergeRecoveredTraces(stackTraceElementArr, createStackTrace);
        }
        return (E) createFinalException(th, tryCopyAndVerify, createStackTrace);
    }

    private static final <E extends Throwable> E tryCopyAndVerify(E e) {
        E e2 = (E) ExceptionsConstructorKt.tryCopyException(e);
        if (e2 == null) {
            return null;
        }
        if ((e instanceof CopyableThrowable) || Intrinsics.areEqual(e2.getMessage(), e.getMessage())) {
            return e2;
        }
        return null;
    }

    private static final <E extends Throwable> E createFinalException(E e, E e2, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(artificialFrame("Coroutine boundary"));
        StackTraceElement[] stackTrace = e.getStackTrace();
        int frameIndex = frameIndex(stackTrace, baseContinuationImplClassName);
        int i = 0;
        if (frameIndex != -1) {
            int size = arrayDeque.size() + frameIndex;
            byte b = KClassImpl$Data$declaredNonStaticMembers$2[16];
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (-b2), objArr);
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) Array.newInstance(Class.forName((String) objArr[0]), size);
            for (int i2 = 0; i2 < frameIndex; i2++) {
                stackTraceElementArr[i2] = stackTrace[i2];
            }
            Iterator<StackTraceElement> it = arrayDeque.iterator();
            while (it.hasNext()) {
                stackTraceElementArr[i + frameIndex] = it.next();
                i++;
            }
            e2.setStackTrace(stackTraceElementArr);
            return e2;
        }
        byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[16];
        byte b4 = (byte) (b3 - 1);
        Object[] objArr2 = new Object[1];
        a(b3, b4, (byte) (-b4), objArr2);
        Object[] array = arrayDeque.toArray((Object[]) Array.newInstance(Class.forName((String) objArr2[0]), 0));
        if (array != null) {
            e2.setStackTrace((StackTraceElement[]) array);
            return e2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> causeAndStacktrace(E e) {
        boolean z;
        Throwable cause = e.getCause();
        if (cause != null && Intrinsics.areEqual(cause.getClass(), e.getClass())) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if (isArtificial(stackTrace[i])) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                return TuplesKt.to(cause, stackTrace);
            }
            byte b = KClassImpl$Data$declaredNonStaticMembers$2[16];
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (-b2), objArr);
            return TuplesKt.to(e, (Object[]) Array.newInstance(Class.forName((String) objArr[0]), 0));
        }
        byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[16];
        byte b4 = (byte) (b3 - 1);
        Object[] objArr2 = new Object[1];
        a(b3, b4, (byte) (-b4), objArr2);
        return TuplesKt.to(e, (Object[]) Array.newInstance(Class.forName((String) objArr2[0]), 0));
    }

    public static final <E extends Throwable> E unwrapImpl(E e) {
        E e2 = (E) e.getCause();
        if (e2 != null && Intrinsics.areEqual(e2.getClass(), e.getClass())) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            int length = stackTrace.length;
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (isArtificial(stackTrace[i])) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                return e2;
            }
        }
        return e;
    }

    private static final ArrayDeque<StackTraceElement> createStackTrace(CoroutineStackFrame coroutineStackFrame) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            if (!(coroutineStackFrame instanceof CoroutineStackFrame)) {
                coroutineStackFrame = null;
            }
            if (coroutineStackFrame == null || (coroutineStackFrame = coroutineStackFrame.getCallerFrame()) == null) {
                break;
            }
            StackTraceElement stackTraceElement2 = coroutineStackFrame.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
        return arrayDeque;
    }

    public static final StackTraceElement artificialFrame(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("\b\b\b(");
        sb.append(str);
        return new StackTraceElement(sb.toString(), "\b", "\b", -1);
    }

    public static final boolean isArtificial(StackTraceElement stackTraceElement) {
        try {
            byte b = KClassImpl$Data$declaredNonStaticMembers$2[16];
            byte b2 = (byte) (b - 1);
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (-b2), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a((byte) (getAuthRequestContext & 5), KClassImpl$Data$declaredNonStaticMembers$2[18], KClassImpl$Data$declaredNonStaticMembers$2[16], objArr2);
            return StringsKt.startsWith$default((String) cls.getMethod((String) objArr2[0], null).invoke(stackTraceElement, null), "\b\b\b", false, 2, (Object) null);
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    private static final boolean elementWiseEquals(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        if (stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && Intrinsics.areEqual(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && Intrinsics.areEqual(stackTraceElement.getFileName(), stackTraceElement2.getFileName())) {
            try {
                byte b = KClassImpl$Data$declaredNonStaticMembers$2[16];
                byte b2 = (byte) (b - 1);
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (-b2), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a((byte) (getAuthRequestContext & 5), KClassImpl$Data$declaredNonStaticMembers$2[18], KClassImpl$Data$declaredNonStaticMembers$2[16], objArr2);
                Object invoke = cls.getMethod((String) objArr2[0], null).invoke(stackTraceElement, null);
                try {
                    byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[16];
                    byte b4 = (byte) (b3 - 1);
                    Object[] objArr3 = new Object[1];
                    a(b3, b4, (byte) (-b4), objArr3);
                    Class<?> cls2 = Class.forName((String) objArr3[0]);
                    Object[] objArr4 = new Object[1];
                    a((byte) (getAuthRequestContext & 5), KClassImpl$Data$declaredNonStaticMembers$2[18], KClassImpl$Data$declaredNonStaticMembers$2[16], objArr4);
                    return Intrinsics.areEqual(invoke, cls2.getMethod((String) objArr4[0], null).invoke(stackTraceElement2, null));
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
        }
        return false;
    }

    private static final void mergeRecoveredTraces(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (isArtificial(stackTraceElementArr[i])) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (i2 > length2) {
            return;
        }
        while (true) {
            if (elementWiseEquals(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i2) {
                return;
            }
            length2--;
        }
    }

    private static final int frameIndex(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i];
            try {
                byte b = KClassImpl$Data$declaredNonStaticMembers$2[16];
                byte b2 = (byte) (b - 1);
                Object[] objArr = new Object[1];
                a(b, b2, (byte) (-b2), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a((byte) (getAuthRequestContext & 5), KClassImpl$Data$declaredNonStaticMembers$2[18], KClassImpl$Data$declaredNonStaticMembers$2[16], objArr2);
                if (Intrinsics.areEqual(str, cls.getMethod((String) objArr2[0], null).invoke(stackTraceElement, null))) {
                    return i;
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        return -1;
    }
}
