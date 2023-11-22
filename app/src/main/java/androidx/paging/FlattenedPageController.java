package androidx.paging;

import kotlin.Metadata;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u00040\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\n\u001a\u00020\t2\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0004H\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019"}, d2 = {"Landroidx/paging/FlattenedPageController;", "", "T", "", "Lkotlin/collections/IndexedValue;", "Landroidx/paging/PageEvent;", "MyBillsEntityDataFactory", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lkotlin/collections/IndexedValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/paging/FlattenedPageEventStorage;", "BuiltInFictitiousFunctionClassFactory", "Landroidx/paging/FlattenedPageEventStorage;", "Lkotlinx/coroutines/sync/Mutex;", "getAuthRequestContext", "Lkotlinx/coroutines/sync/Mutex;", "", "I", "PlaceComponentResult", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class FlattenedPageController<T> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final FlattenedPageEventStorage<T> KClassImpl$Data$declaredNonStaticMembers$2 = new FlattenedPageEventStorage<>();
    private final Mutex getAuthRequestContext = MutexKt.Mutex$default(false, 1, null);

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private int PlaceComponentResult = -1;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0071 A[Catch: all -> 0x0168, TryCatch #0 {all -> 0x0168, blocks: (B:18:0x0058, B:20:0x0071, B:25:0x009b, B:47:0x0160, B:26:0x00b3, B:27:0x00c2, B:28:0x00d7, B:30:0x00dd, B:31:0x00f0, B:33:0x00f4, B:36:0x0113, B:38:0x011f, B:39:0x0127, B:40:0x012e, B:41:0x012f, B:43:0x013b, B:44:0x0143, B:46:0x0147), top: B:54:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f0 A[Catch: all -> 0x0168, TryCatch #0 {all -> 0x0168, blocks: (B:18:0x0058, B:20:0x0071, B:25:0x009b, B:47:0x0160, B:26:0x00b3, B:27:0x00c2, B:28:0x00d7, B:30:0x00dd, B:31:0x00f0, B:33:0x00f4, B:36:0x0113, B:38:0x011f, B:39:0x0127, B:40:0x012e, B:41:0x012f, B:43:0x013b, B:44:0x0143, B:46:0x0147), top: B:54:0x0058 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object KClassImpl$Data$declaredNonStaticMembers$2(kotlin.collections.IndexedValue<? extends androidx.paging.PageEvent<T>> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlattenedPageController.KClassImpl$Data$declaredNonStaticMembers$2(kotlin.collections.IndexedValue, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055 A[Catch: all -> 0x00dc, TryCatch #0 {all -> 0x00dc, blocks: (B:18:0x004f, B:20:0x0055, B:26:0x009c, B:27:0x00b6, B:29:0x00bc, B:31:0x00c2, B:32:0x00c5, B:33:0x00d6, B:21:0x005a, B:23:0x0079, B:24:0x0091), top: B:40:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005a A[Catch: all -> 0x00dc, TryCatch #0 {all -> 0x00dc, blocks: (B:18:0x004f, B:20:0x0055, B:26:0x009c, B:27:0x00b6, B:29:0x00bc, B:31:0x00c2, B:32:0x00c5, B:33:0x00d6, B:21:0x005a, B:23:0x0079, B:24:0x0091), top: B:40:0x004f }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bc A[Catch: all -> 0x00dc, TryCatch #0 {all -> 0x00dc, blocks: (B:18:0x004f, B:20:0x0055, B:26:0x009c, B:27:0x00b6, B:29:0x00bc, B:31:0x00c2, B:32:0x00c5, B:33:0x00d6, B:21:0x005a, B:23:0x0079, B:24:0x0091), top: B:40:0x004f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object MyBillsEntityDataFactory(kotlin.coroutines.Continuation<? super java.util.List<? extends kotlin.collections.IndexedValue<? extends androidx.paging.PageEvent<T>>>> r11) {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.FlattenedPageController.MyBillsEntityDataFactory(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
