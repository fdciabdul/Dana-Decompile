package androidx.paging;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¸\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/flow/FlowKt__CollectKt$collect$3;", "Lkotlinx/coroutines/flow/FlowCollector;", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1 implements FlowCollector<Unit> {
    final /* synthetic */ CoroutineScope BuiltInFictitiousFunctionClassFactory;
    final /* synthetic */ PageFetcherSnapshot KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1", f = "PageFetcherSnapshot.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10, 11, 11, 11, 11, 12, 12, 12, 13, 13, 13, 13, 14, 14, 15, 15, 15}, l = {142, 164, 157, 181, 169, 195, 213, 157, 224, 169, 235, 247, 157, DeepRecoverARiverProxy.TYPE_ENTITY_TEMPLATE, 169, 269}, m = "emit", n = {"this", "this_$iv", "$this$withLock_u24default$iv$iv", "this", "this_$iv", GriverMonitorConstants.KEY_LOAD_TYPE, "this_$iv", "$this$withLock_u24default$iv$iv", "this", "this_$iv", GriverMonitorConstants.KEY_LOAD_TYPE, "$this$withLock_u24default$iv$iv", "this", "this_$iv", GriverMonitorConstants.KEY_LOAD_TYPE, "this_$iv", "$this$withLock_u24default$iv$iv", "this", "this_$iv", GriverMonitorConstants.KEY_LOAD_TYPE, "this", "this_$iv", "this_$iv", "$this$withLock_u24default$iv$iv", "this", "this_$iv", GriverMonitorConstants.KEY_LOAD_TYPE, "this_$iv", "$this$withLock_u24default$iv$iv", "this", "this_$iv", GriverMonitorConstants.KEY_LOAD_TYPE, "$this$withLock_u24default$iv$iv", "this", "this_$iv", GriverMonitorConstants.KEY_LOAD_TYPE, "this_$iv", "$this$withLock_u24default$iv$iv", "this", "this_$iv", GriverMonitorConstants.KEY_LOAD_TYPE, "this", "this_$iv", "this_$iv", "$this$withLock_u24default$iv$iv", "this", GriverMonitorConstants.KEY_LOAD_TYPE, "this_$iv", "$this$withLock_u24default$iv$iv", "this", GriverMonitorConstants.KEY_LOAD_TYPE, "$this$withLock_u24default$iv$iv", "this", GriverMonitorConstants.KEY_LOAD_TYPE, "this_$iv", "$this$withLock_u24default$iv$iv", "this", GriverMonitorConstants.KEY_LOAD_TYPE, "this", "this_$iv", "$this$withLock_u24default$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$0", "L$1", "L$2"})
    /* renamed from: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1(PageFetcherSnapshot pageFetcherSnapshot, CoroutineScope coroutineScope) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = pageFetcherSnapshot;
        this.BuiltInFictitiousFunctionClassFactory = coroutineScope;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0346 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0444 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x04ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x04b4  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x04e5  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0244 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0306  */
    /* JADX WARN: Type inference failed for: r12v0, types: [kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r12v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v102 */
    /* JADX WARN: Type inference failed for: r12v103 */
    /* JADX WARN: Type inference failed for: r12v104 */
    /* JADX WARN: Type inference failed for: r12v105 */
    /* JADX WARN: Type inference failed for: r12v18, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v3, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v45, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v76, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r12v98 */
    /* JADX WARN: Type inference failed for: r12v99 */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(kotlin.Unit r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instructions count: 1318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshot$pageEventFlow$1$4$invokeSuspend$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
