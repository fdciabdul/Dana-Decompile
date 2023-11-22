package id.dana.promodiscovery.adapter;

import android.view.ViewGroup;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.domain.promodiscovery.model.ProductInfoDiscoveryModel;
import id.dana.promodiscovery.richview.PromoDiscoveryListItemListener;
import id.dana.promodiscovery.viewholder.DanaDealsItemViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/promodiscovery/adapter/DanaDealsItemAdapter;", "Lid/dana/promodiscovery/adapter/BaseDiscoveryItemAdapter;", "Lid/dana/domain/promodiscovery/model/ProductInfoDiscoveryModel;", "Landroid/view/ViewGroup;", "p0", "Lid/dana/base/BaseRecyclerViewHolder;", "MyBillsEntityDataFactory", "(Landroid/view/ViewGroup;)Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DanaDealsItemAdapter extends BaseDiscoveryItemAdapter<ProductInfoDiscoveryModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final PromoDiscoveryListItemListener<ProductInfoDiscoveryModel> BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [id.dana.promodiscovery.model.SectionState, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DanaDealsItemAdapter(id.dana.promodiscovery.richview.PromoDiscoveryListItemListener<? super id.dana.domain.promodiscovery.model.ProductInfoDiscoveryModel> r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            r2.BuiltInFictitiousFunctionClassFactory = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.promodiscovery.adapter.DanaDealsItemAdapter.<init>(id.dana.promodiscovery.richview.PromoDiscoveryListItemListener):void");
    }

    @Override // id.dana.promodiscovery.adapter.BaseDiscoveryItemAdapter
    public final BaseRecyclerViewHolder<ProductInfoDiscoveryModel> MyBillsEntityDataFactory(ViewGroup p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new DanaDealsItemViewHolder(p0, this.BuiltInFictitiousFunctionClassFactory);
    }
}
