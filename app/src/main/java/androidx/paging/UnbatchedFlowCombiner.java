package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003BO\u0012C\u0010\u0005\u001a?\b\u0001\u0012\u000b\u0012\t\u0018\u00018\u0000¢\u0006\u0002\b\u0012\u0012\u000b\u0012\t\u0018\u00018\u0001¢\u0006\u0002\b\u0012\u0012\u000b\u0012\t\u0018\u00010\u0013¢\u0006\u0002\b\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0011ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fRT\u0010\u0016\u001a?\b\u0001\u0012\u000b\u0012\t\u0018\u00018\u0000¢\u0006\u0002\b\u0012\u0012\u000b\u0012\t\u0018\u00018\u0001¢\u0006\u0002\b\u0012\u0012\u000b\u0012\t\u0018\u00010\u0013¢\u0006\u0002\b\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00118\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\b\u0010\u0015R \u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\n0\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u001c\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/UnbatchedFlowCombiner;", "T1", "T2", "", "", "p0", "p1", "", "MyBillsEntityDataFactory", "(ILjava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CompletableDeferred;", "BuiltInFictitiousFunctionClassFactory", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlinx/coroutines/sync/Mutex;", "PlaceComponentResult", "Lkotlinx/coroutines/sync/Mutex;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "Landroidx/paging/CombineSource;", "Lkotlin/coroutines/Continuation;", "Lkotlin/jvm/functions/Function4;", "getAuthRequestContext", "", "[Lkotlinx/coroutines/CompletableDeferred;", "[Ljava/lang/Object;", "<init>", "(Lkotlin/jvm/functions/Function4;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class UnbatchedFlowCombiner<T1, T2> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final CompletableDeferred<Unit> MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final CompletableDeferred<Unit>[] PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Function4<T1, T2, CombineSource, Continuation<? super Unit>, Object> getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Mutex KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Object[] BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Multi-variable type inference failed */
    public UnbatchedFlowCombiner(Function4<? super T1, ? super T2, ? super CombineSource, ? super Continuation<? super Unit>, ? extends Object> function4) {
        Object obj;
        Intrinsics.checkNotNullParameter(function4, "");
        this.getAuthRequestContext = function4;
        this.MyBillsEntityDataFactory = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = MutexKt.Mutex$default(false, 1, null);
        CompletableDeferred<Unit>[] completableDeferredArr = new CompletableDeferred[2];
        for (int i = 0; i < 2; i++) {
            completableDeferredArr[i] = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        }
        this.PlaceComponentResult = completableDeferredArr;
        Object[] objArr = new Object[2];
        for (int i2 = 0; i2 < 2; i2++) {
            obj = FlowExtKt.PlaceComponentResult;
            objArr[i2] = obj;
        }
        this.BuiltInFictitiousFunctionClassFactory = objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b3 A[Catch: all -> 0x011a, TryCatch #1 {all -> 0x011a, blocks: (B:34:0x00ac, B:36:0x00b3, B:44:0x00c6, B:46:0x00ce, B:56:0x00e5, B:60:0x00ef, B:58:0x00ea, B:59:0x00ed, B:52:0x00dd, B:42:0x00c2), top: B:76:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ce A[Catch: all -> 0x011a, TryCatch #1 {all -> 0x011a, blocks: (B:34:0x00ac, B:36:0x00b3, B:44:0x00c6, B:46:0x00ce, B:56:0x00e5, B:60:0x00ef, B:58:0x00ea, B:59:0x00ed, B:52:0x00dd, B:42:0x00c2), top: B:76:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00c5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object MyBillsEntityDataFactory(int r17, java.lang.Object r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.UnbatchedFlowCombiner.MyBillsEntityDataFactory(int, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
