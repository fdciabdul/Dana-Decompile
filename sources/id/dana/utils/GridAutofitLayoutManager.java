package id.dana.utils;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.extension.view.ViewExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0007J'\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0003\u001a\b\u0018\u00010\u000bR\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0017\u001a\u00020\u0002X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0012"}, d2 = {"Lid/dana/utils/GridAutofitLayoutManager;", "Landroidx/recyclerview/widget/GridLayoutManager;", "", "p0", "p1", "", "PlaceComponentResult", "(II)Z", "MyBillsEntityDataFactory", "()Z", "getAuthRequestContext", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView$State;", "", "onLayoutChildren", "(Landroidx/recyclerview/widget/RecyclerView$Recycler;Landroidx/recyclerview/widget/RecyclerView$State;)V", "NetworkUserEntityData$$ExternalSyntheticLambda0", "I", "scheduleImpl", "Z", "GetContactSyncConfig", "Lkotlin/Lazy;", "BuiltInFictitiousFunctionClassFactory", "initRecordTimeStamp", "KClassImpl$Data$declaredNonStaticMembers$2", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;I)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GridAutofitLayoutManager extends GridLayoutManager {

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private int getAuthRequestContext;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridAutofitLayoutManager(Context context, int i) {
        super(context, 1);
        Intrinsics.checkNotNullParameter(context, "");
        Lazy lazy = LazyKt.lazy(new Function0<Integer>() { // from class: id.dana.utils.GridAutofitLayoutManager$defaultColumnWidth$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ViewExtKt.PlaceComponentResult(48.0f));
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = lazy;
        this.PlaceComponentResult = true;
        if (this.MyBillsEntityDataFactory != i) {
            i = i <= 0 ? ((Number) lazy.getValue()).intValue() : i;
            this.MyBillsEntityDataFactory = i;
            if (i > 0) {
                this.PlaceComponentResult = true;
            }
        }
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.Recycler p0, RecyclerView.State p1) {
        int paddingTop;
        int paddingBottom;
        int width = getWidth();
        int height = getHeight();
        if (PlaceComponentResult(width, height) && getAuthRequestContext(width, height)) {
            if (MyBillsEntityDataFactory()) {
                paddingTop = width - getPaddingRight();
                paddingBottom = getPaddingLeft();
            } else {
                paddingTop = height - getPaddingTop();
                paddingBottom = getPaddingBottom();
            }
            PlaceComponentResult(Math.max(1, (paddingTop - paddingBottom) / this.MyBillsEntityDataFactory));
            this.PlaceComponentResult = false;
        }
        this.getAuthRequestContext = width;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = height;
        super.onLayoutChildren(p0, p1);
    }

    private final boolean MyBillsEntityDataFactory() {
        return getOrientation() == 1;
    }

    private final boolean getAuthRequestContext(int p0, int p1) {
        return (!this.PlaceComponentResult && this.getAuthRequestContext == p0 && this.KClassImpl$Data$declaredNonStaticMembers$2 == p1) ? false : true;
    }

    private final boolean PlaceComponentResult(int p0, int p1) {
        return this.MyBillsEntityDataFactory > 0 && p0 > 0 && p1 > 0;
    }
}
