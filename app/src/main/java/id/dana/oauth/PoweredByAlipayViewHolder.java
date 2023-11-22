package id.dana.oauth;

import android.view.ViewGroup;
import android.widget.ImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.oauth.model.ScopeModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/oauth/PoweredByAlipayViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/oauth/model/ScopeModel;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PoweredByAlipayViewHolder extends BaseRecyclerViewHolder<ScopeModel> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(ScopeModel scopeModel) {
        ScopeModel scopeModel2 = scopeModel;
        super.bindData(scopeModel2);
        ImageView imageView = (ImageView) this.itemView.findViewById(R.id.iv_powered_by_alipay);
        SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
        KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = scopeModel2 != null ? scopeModel2.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = imageView;
        new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PoweredByAlipayViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_powered_by_alipay, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
    }
}
