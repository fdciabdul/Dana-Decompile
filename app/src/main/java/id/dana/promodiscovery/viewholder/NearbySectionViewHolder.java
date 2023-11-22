package id.dana.promodiscovery.viewholder;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import id.dana.R;
import id.dana.animation.RoundedCornersTransformation;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequest;
import id.dana.extension.view.ViewExtKt;
import id.dana.promodiscovery.model.DiscoverySectionModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u001d\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0004\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0011\u0010\n\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/promodiscovery/viewholder/NearbySectionViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promodiscovery/model/DiscoverySectionModel;", "", "Lkotlin/Function0;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function0;", "Landroid/view/ViewGroup;", "getAuthRequestContext", "Landroid/view/ViewGroup;", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Lkotlin/jvm/functions/Function0;Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NearbySectionViewHolder extends BaseRecyclerViewHolder<DiscoverySectionModel<Unit>> {
    private final Function0<Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final ViewGroup MyBillsEntityDataFactory;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(DiscoverySectionModel<Unit> discoverySectionModel) {
        super.bindData(discoverySectionModel);
        ((DanaButtonPrimaryView) this.itemView.findViewById(R.id.btn_explore)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.promodiscovery.viewholder.NearbySectionViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NearbySectionViewHolder.MyBillsEntityDataFactory(NearbySectionViewHolder.this);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbySectionViewHolder(Function0<Unit> function0, ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.nearby_section_layout, viewGroup);
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function0;
        this.MyBillsEntityDataFactory = viewGroup;
        GlideRequest<Drawable> PlaceComponentResult = GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(Integer.valueOf((int) R.drawable.ic_nearby_illustration));
        ViewExtKt.PlaceComponentResult(8.0f);
        GlideRequest<Drawable> PlaceComponentResult2 = PlaceComponentResult.PlaceComponentResult(new CenterCrop(), new RoundedCornersTransformation(ViewExtKt.PlaceComponentResult(8.0f), 0));
        View view = this.itemView;
        PlaceComponentResult2.MyBillsEntityDataFactory((ImageView) (view != null ? (AppCompatImageView) view.findViewById(R.id.res_0x7f0a0ba5_windowinsetscompat_builderimpl30) : null));
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(NearbySectionViewHolder nearbySectionViewHolder) {
        Intrinsics.checkNotNullParameter(nearbySectionViewHolder, "");
        nearbySectionViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.invoke();
    }
}
