package id.dana.common.decoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.domain.payasset.model.PayMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0017B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/common/decoration/HorizontalItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "p0", "Landroid/view/View;", "p1", "Landroidx/recyclerview/widget/RecyclerView;", "p2", "Landroidx/recyclerview/widget/RecyclerView$State;", "p3", "", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Lid/dana/common/decoration/HorizontalItemDecoration$DecorationMode;", "PlaceComponentResult", "Lid/dana/common/decoration/HorizontalItemDecoration$DecorationMode;", "BuiltInFictitiousFunctionClassFactory", "", "MyBillsEntityDataFactory", "I", "getAuthRequestContext", "<init>", "(ILid/dana/common/decoration/HorizontalItemDecoration$DecorationMode;)V", "DecorationMode"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HorizontalItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final int getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final DecorationMode BuiltInFictitiousFunctionClassFactory;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005"}, d2 = {"Lid/dana/common/decoration/HorizontalItemDecoration$DecorationMode;", "", "<init>", "(Ljava/lang/String;I)V", "HORIZONTAL_ONLY", PayMethod.ALL}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public enum DecorationMode {
        HORIZONTAL_ONLY,
        ALL
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.common.decoration.HorizontalItemDecoration$DecorationMode] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HorizontalItemDecoration() {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            r2 = 3
            r3.<init>(r1, r0, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.common.decoration.HorizontalItemDecoration.<init>():void");
    }

    public /* synthetic */ HorizontalItemDecoration(int i, DecorationMode decorationMode, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? DecorationMode.ALL : decorationMode);
    }

    public HorizontalItemDecoration(int i, DecorationMode decorationMode) {
        Intrinsics.checkNotNullParameter(decorationMode, "");
        this.getAuthRequestContext = i;
        this.BuiltInFictitiousFunctionClassFactory = decorationMode;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect p0, View p1, RecyclerView p2, RecyclerView.State p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        p0.left = this.getAuthRequestContext;
        p0.right = this.getAuthRequestContext;
        if (this.BuiltInFictitiousFunctionClassFactory == DecorationMode.ALL) {
            if (p2.getChildAdapterPosition(p1) == 0) {
                p0.top = this.getAuthRequestContext;
            }
            p0.bottom = this.getAuthRequestContext;
        }
    }
}
