package kotlinx.coroutines;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.common.base.Ascii;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aX\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012)\u0010\b\u001a%\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003¢\u0006\u0002\b\u0007ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"T", "Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "runBlocking", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/BuildersKt")
/* loaded from: classes6.dex */
public final /* synthetic */ class BuildersKt__BuildersKt {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {56, -119, 46, TarHeader.LF_CONTIG, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int getAuthRequestContext = 240;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:23:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 12
            int r7 = r7 + 4
            int r9 = r9 * 7
            int r9 = r9 + 99
            byte[] r0 = kotlinx.coroutines.BuildersKt__BuildersKt.KClassImpl$Data$declaredNonStaticMembers$2
            int r8 = r8 * 3
            int r8 = r8 + 13
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L33
        L1a:
            r3 = 0
        L1b:
            int r4 = r3 + 1
            byte r5 = (byte) r9
            r1[r3] = r5
            if (r4 != r8) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r7]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L33:
            int r8 = -r8
            int r10 = r10 + r8
            int r8 = r10 + 2
            int r7 = r7 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r9
            r9 = r8
            r8 = r6
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.BuildersKt__BuildersKt.a(short, int, int, java.lang.Object[]):void");
    }

    public static /* synthetic */ Object runBlocking$default(CoroutineContext coroutineContext, Function2 function2, int i, Object obj) throws InterruptedException {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return BuildersKt.runBlocking(coroutineContext, function2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0068, code lost:
    
        if (r1 != null) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> T runBlocking(kotlin.coroutines.CoroutineContext r6, kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r7) throws java.lang.InterruptedException {
        /*
            byte[] r0 = kotlinx.coroutines.BuildersKt__BuildersKt.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L88
            r1 = 15
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L88
            int r0 = -r0
            byte r0 = (byte) r0     // Catch: java.lang.Throwable -> L88
            byte r2 = (byte) r0     // Catch: java.lang.Throwable -> L88
            byte r3 = (byte) r2     // Catch: java.lang.Throwable -> L88
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L88
            a(r0, r2, r3, r5)     // Catch: java.lang.Throwable -> L88
            r0 = 0
            r2 = r5[r0]     // Catch: java.lang.Throwable -> L88
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> L88
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L88
            byte[] r3 = kotlinx.coroutines.BuildersKt__BuildersKt.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L88
            r1 = r3[r1]     // Catch: java.lang.Throwable -> L88
            int r1 = r1 + r4
            byte r1 = (byte) r1     // Catch: java.lang.Throwable -> L88
            byte r3 = (byte) r1     // Catch: java.lang.Throwable -> L88
            byte r5 = (byte) r3     // Catch: java.lang.Throwable -> L88
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L88
            a(r1, r3, r5, r4)     // Catch: java.lang.Throwable -> L88
            r0 = r4[r0]     // Catch: java.lang.Throwable -> L88
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L88
            r1 = 0
            java.lang.reflect.Method r0 = r2.getMethod(r0, r1)     // Catch: java.lang.Throwable -> L88
            java.lang.Object r0 = r0.invoke(r1, r1)     // Catch: java.lang.Throwable -> L88
            java.lang.Thread r0 = (java.lang.Thread) r0     // Catch: java.lang.Throwable -> L88
            kotlin.coroutines.ContinuationInterceptor$Key r2 = kotlin.coroutines.ContinuationInterceptor.INSTANCE
            kotlin.coroutines.CoroutineContext$Key r2 = (kotlin.coroutines.CoroutineContext.Key) r2
            kotlin.coroutines.CoroutineContext$Element r2 = r6.get(r2)
            kotlin.coroutines.ContinuationInterceptor r2 = (kotlin.coroutines.ContinuationInterceptor) r2
            if (r2 != 0) goto L57
            kotlinx.coroutines.ThreadLocalEventLoop r1 = kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE
            kotlinx.coroutines.EventLoop r1 = r1.getEventLoop$kotlinx_coroutines_core()
            kotlinx.coroutines.GlobalScope r2 = kotlinx.coroutines.GlobalScope.INSTANCE
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            r3 = r1
            kotlin.coroutines.CoroutineContext r3 = (kotlin.coroutines.CoroutineContext) r3
            kotlin.coroutines.CoroutineContext r6 = r6.plus(r3)
            kotlin.coroutines.CoroutineContext r6 = kotlinx.coroutines.CoroutineContextKt.newCoroutineContext(r2, r6)
            goto L79
        L57:
            boolean r3 = r2 instanceof kotlinx.coroutines.EventLoop
            if (r3 == 0) goto L5e
            kotlinx.coroutines.EventLoop r2 = (kotlinx.coroutines.EventLoop) r2
            goto L5f
        L5e:
            r2 = r1
        L5f:
            if (r2 == 0) goto L6b
            boolean r3 = r2.shouldBeProcessedFromContext()
            if (r3 == 0) goto L68
            r1 = r2
        L68:
            if (r1 == 0) goto L6b
            goto L71
        L6b:
            kotlinx.coroutines.ThreadLocalEventLoop r1 = kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE
            kotlinx.coroutines.EventLoop r1 = r1.currentOrNull$kotlinx_coroutines_core()
        L71:
            kotlinx.coroutines.GlobalScope r2 = kotlinx.coroutines.GlobalScope.INSTANCE
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlin.coroutines.CoroutineContext r6 = kotlinx.coroutines.CoroutineContextKt.newCoroutineContext(r2, r6)
        L79:
            kotlinx.coroutines.BlockingCoroutine r2 = new kotlinx.coroutines.BlockingCoroutine
            r2.<init>(r6, r0, r1)
            kotlinx.coroutines.CoroutineStart r6 = kotlinx.coroutines.CoroutineStart.DEFAULT
            r2.start(r6, r2, r7)
            java.lang.Object r6 = r2.joinBlocking()
            return r6
        L88:
            r6 = move-exception
            java.lang.Throwable r7 = r6.getCause()
            if (r7 == 0) goto L90
            throw r7
        L90:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking(kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function2):java.lang.Object");
    }
}
