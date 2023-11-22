package id.dana.richview.servicescard.decorator;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\r\u0012\u0006\u0010\u0005\u001a\u00020\r\u0012\u0006\u0010\u0007\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\r¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000f"}, d2 = {"Lid/dana/richview/servicescard/decorator/ServiceItemDecorator;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "p0", "Landroid/view/View;", "p1", "Landroidx/recyclerview/widget/RecyclerView;", "p2", "Landroidx/recyclerview/widget/RecyclerView$State;", "p3", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "MyBillsEntityDataFactory", "getAuthRequestContext", "<init>", "(IIII)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServiceItemDecorator extends RecyclerView.ItemDecoration {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final int PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final int getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final int KClassImpl$Data$declaredNonStaticMembers$2;

    public ServiceItemDecorator(int i, int i2, int i3, int i4) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
        this.getAuthRequestContext = i2;
        this.PlaceComponentResult = i3;
        this.BuiltInFictitiousFunctionClassFactory = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect p0, View p1, RecyclerView p2, RecyclerView.State p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        super.getItemOffsets(p0, p1, p2, p3);
        p0.top = this.getAuthRequestContext;
        p0.bottom = this.BuiltInFictitiousFunctionClassFactory;
        p0.left = this.KClassImpl$Data$declaredNonStaticMembers$2;
        p0.right = this.PlaceComponentResult;
    }
}
