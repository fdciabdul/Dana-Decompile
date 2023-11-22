package androidx.paging;

import androidx.paging.PagedList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0007R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/paging/RecordingCallback;", "Landroidx/paging/PagedList$Callback;", "", "p0", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(II)V", "PlaceComponentResult", "getAuthRequestContext", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class RecordingCallback extends PagedList.Callback {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final List<Integer> BuiltInFictitiousFunctionClassFactory = new ArrayList();

    @Override // androidx.paging.PagedList.Callback
    public final void BuiltInFictitiousFunctionClassFactory(int p0, int p1) {
        this.BuiltInFictitiousFunctionClassFactory.add(0);
        this.BuiltInFictitiousFunctionClassFactory.add(Integer.valueOf(p0));
        this.BuiltInFictitiousFunctionClassFactory.add(Integer.valueOf(p1));
    }

    @Override // androidx.paging.PagedList.Callback
    public final void PlaceComponentResult(int p0, int p1) {
        this.BuiltInFictitiousFunctionClassFactory.add(1);
        this.BuiltInFictitiousFunctionClassFactory.add(Integer.valueOf(p0));
        this.BuiltInFictitiousFunctionClassFactory.add(Integer.valueOf(p1));
    }

    @Override // androidx.paging.PagedList.Callback
    public final void getAuthRequestContext(int p0, int p1) {
        this.BuiltInFictitiousFunctionClassFactory.add(2);
        this.BuiltInFictitiousFunctionClassFactory.add(Integer.valueOf(p0));
        this.BuiltInFictitiousFunctionClassFactory.add(Integer.valueOf(p1));
    }
}
