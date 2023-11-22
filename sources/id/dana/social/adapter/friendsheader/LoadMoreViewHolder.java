package id.dana.social.adapter.friendsheader;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import butterknife.BindView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u000e\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\n¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0012\u0010\b\u001a\u00020\u0007X\u0087\"¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0007¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0011\u0010\u0011\u001a\u00020\u000eX\u0007¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/social/adapter/friendsheader/LoadMoreViewHolder;", "T", "Lid/dana/base/BaseRecyclerViewHolder;", "p0", "", "bindData", "(Ljava/lang/Object;)V", "Landroid/widget/Button;", "btnLoadMore", "Landroid/widget/Button;", "Lkotlin/Function0;", "getAuthRequestContext", "Lkotlin/jvm/functions/Function0;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "MyBillsEntityDataFactory", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LoadMoreViewHolder<T> extends BaseRecyclerViewHolder<T> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final ViewGroup MyBillsEntityDataFactory;
    @BindView(R.id.btn_loadmore)
    public Button btnLoadMore;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Function0<Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void bindData(T p0) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadMoreViewHolder(ViewGroup viewGroup, Function0<Unit> function0) {
        super(viewGroup.getContext(), R.layout.viewholder_loadmore, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.MyBillsEntityDataFactory = viewGroup;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function0;
        Button button = this.btnLoadMore;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.friendsheader.LoadMoreViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoadMoreViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(LoadMoreViewHolder.this);
            }
        });
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(LoadMoreViewHolder loadMoreViewHolder) {
        Intrinsics.checkNotNullParameter(loadMoreViewHolder, "");
        loadMoreViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.invoke();
    }
}
