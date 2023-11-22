package kotlinx.coroutines;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.common.base.Ascii;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\"\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "", "exception", "", "handleCoroutineExceptionImpl", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handlers", "Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CoroutineExceptionHandlerImplKt {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {Ascii.ETB, -59, 18, 83, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int BuiltInFictitiousFunctionClassFactory = 255;
    private static final List<CoroutineExceptionHandler> handlers = SequencesKt.toList(SequencesKt.asSequence(ServiceLoader.load(CoroutineExceptionHandler.class, CoroutineExceptionHandler.class.getClassLoader()).iterator()));

    /* JADX WARN: Removed duplicated region for block: B:20:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002e -> B:23:0x0039). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r8, short r9, short r10, java.lang.Object[] r11) {
        /*
            int r8 = r8 * 12
            int r8 = r8 + 4
            byte[] r0 = kotlinx.coroutines.CoroutineExceptionHandlerImplKt.KClassImpl$Data$declaredNonStaticMembers$2
            int r10 = r10 * 7
            int r10 = r10 + 99
            int r9 = r9 * 3
            int r9 = r9 + 13
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r11
            r11 = r9
            r9 = r8
            goto L39
        L1a:
            r3 = 0
            r6 = r9
            r9 = r8
            r8 = r10
            r10 = r6
        L1f:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r10) goto L2e
            java.lang.String r8 = new java.lang.String
            r8.<init>(r1, r2)
            r11[r2] = r8
            return
        L2e:
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
        L39:
            int r10 = -r10
            int r8 = r8 + 1
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
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.CoroutineExceptionHandlerImplKt.a(int, short, short, java.lang.Object[]):void");
    }

    public static final void handleCoroutineExceptionImpl(CoroutineContext coroutineContext, Throwable th) {
        Iterator<CoroutineExceptionHandler> it = handlers.iterator();
        while (it.hasNext()) {
            try {
                it.next().handleException(coroutineContext, th);
            } catch (Throwable th2) {
                try {
                    byte b = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                    byte b2 = b;
                    Object[] objArr = new Object[1];
                    a(b, b2, b2, objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
                    byte b4 = b3;
                    Object[] objArr2 = new Object[1];
                    a(b3, b4, b4, objArr2);
                    Thread thread = (Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null);
                    thread.getUncaughtExceptionHandler().uncaughtException(thread, CoroutineExceptionHandlerKt.handlerException(th, th2));
                } catch (Throwable th3) {
                    Throwable cause = th3.getCause();
                    if (cause == null) {
                        throw th3;
                    }
                    throw cause;
                }
            }
        }
        try {
            byte b5 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
            byte b6 = b5;
            Object[] objArr3 = new Object[1];
            a(b5, b6, b6, objArr3);
            Class<?> cls2 = Class.forName((String) objArr3[0]);
            byte b7 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
            byte b8 = b7;
            Object[] objArr4 = new Object[1];
            a(b7, b8, b8, objArr4);
            Thread thread2 = (Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null);
            try {
                Result.Companion companion = Result.INSTANCE;
                kotlin.ExceptionsKt.addSuppressed(th, new DiagnosticCoroutineContextException(coroutineContext));
                Result.m3179constructorimpl(Unit.INSTANCE);
            } catch (Throwable th4) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m3179constructorimpl(ResultKt.createFailure(th4));
            }
            thread2.getUncaughtExceptionHandler().uncaughtException(thread2, th);
        } catch (Throwable th5) {
            Throwable cause2 = th5.getCause();
            if (cause2 == null) {
                throw th5;
            }
            throw cause2;
        }
    }
}
