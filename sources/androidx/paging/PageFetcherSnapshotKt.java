package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a#\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/paging/GenerationalViewportHint;", "p0", "Landroidx/paging/LoadType;", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/paging/GenerationalViewportHint;Landroidx/paging/GenerationalViewportHint;Landroidx/paging/LoadType;)Z"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class PageFetcherSnapshotKt {
    public static final boolean BuiltInFictitiousFunctionClassFactory(GenerationalViewportHint generationalViewportHint, GenerationalViewportHint generationalViewportHint2, LoadType loadType) {
        Intrinsics.checkNotNullParameter(generationalViewportHint, "");
        Intrinsics.checkNotNullParameter(generationalViewportHint2, "");
        Intrinsics.checkNotNullParameter(loadType, "");
        if (generationalViewportHint.MyBillsEntityDataFactory > generationalViewportHint2.MyBillsEntityDataFactory) {
            return true;
        }
        if (generationalViewportHint.MyBillsEntityDataFactory < generationalViewportHint2.MyBillsEntityDataFactory) {
            return false;
        }
        return HintHandlerKt.KClassImpl$Data$declaredNonStaticMembers$2(generationalViewportHint.getAuthRequestContext, generationalViewportHint2.getAuthRequestContext, loadType);
    }
}
