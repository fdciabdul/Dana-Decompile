package id.dana.social.utils;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0012\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/social/utils/SocialScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "", "BuiltInFictitiousFunctionClassFactory", "()Z", "getAuthRequestContext", "Landroidx/recyclerview/widget/RecyclerView;", "p0", "", "p1", "", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "p2", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "MyBillsEntityDataFactory", "(Z)V", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "PlaceComponentResult", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class SocialScrollListener extends RecyclerView.OnScrollListener {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final RecyclerView KClassImpl$Data$declaredNonStaticMembers$2;

    public void KClassImpl$Data$declaredNonStaticMembers$2() {
    }

    public void MyBillsEntityDataFactory(boolean p0) {
    }

    public abstract boolean getAuthRequestContext();

    public SocialScrollListener(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView p0, int p1, int p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onScrolled(p0, p1, p2);
        MyBillsEntityDataFactory(p2 < 0 && !BuiltInFictitiousFunctionClassFactory());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onScrollStateChanged(p0, p1);
        if (p0.canScrollVertically(130) || !getAuthRequestContext()) {
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2();
    }

    private final boolean BuiltInFictitiousFunctionClassFactory() {
        RecyclerView.LayoutManager layoutManager = this.KClassImpl$Data$declaredNonStaticMembers$2.getLayoutManager();
        if (layoutManager != null) {
            return ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }
}
