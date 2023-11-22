package androidx.paging;

import androidx.paging.ViewportHint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a%\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/paging/ViewportHint;", "p0", "Landroidx/paging/LoadType;", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/paging/ViewportHint;Landroidx/paging/ViewportHint;Landroidx/paging/LoadType;)Z"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class HintHandlerKt {
    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(ViewportHint viewportHint, ViewportHint viewportHint2, LoadType loadType) {
        Intrinsics.checkNotNullParameter(viewportHint, "");
        Intrinsics.checkNotNullParameter(loadType, "");
        return viewportHint2 == null || ((viewportHint2 instanceof ViewportHint.Initial) && (viewportHint instanceof ViewportHint.Access)) || !(((viewportHint instanceof ViewportHint.Initial) && (viewportHint2 instanceof ViewportHint.Access)) || (viewportHint.MyBillsEntityDataFactory == viewportHint2.MyBillsEntityDataFactory && viewportHint.BuiltInFictitiousFunctionClassFactory == viewportHint2.BuiltInFictitiousFunctionClassFactory && viewportHint2.getAuthRequestContext(loadType) <= viewportHint.getAuthRequestContext(loadType)));
    }
}
