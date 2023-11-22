package id.dana.promodiscovery.adapter;

import android.view.ViewGroup;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.promocenter.model.PromoModel;
import id.dana.promodiscovery.richview.PromoDiscoveryListItemListener;
import id.dana.promodiscovery.viewholder.BankPromoItemViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\bX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/promodiscovery/adapter/BankPromoItemAdapter;", "Lid/dana/promodiscovery/adapter/BaseDiscoveryItemAdapter;", "Lid/dana/promocenter/model/PromoModel;", "Landroid/view/ViewGroup;", "p0", "Lid/dana/base/BaseRecyclerViewHolder;", "MyBillsEntityDataFactory", "(Landroid/view/ViewGroup;)Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "<init>", "(Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BankPromoItemAdapter extends BaseDiscoveryItemAdapter<PromoModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final PromoDiscoveryListItemListener<PromoModel> MyBillsEntityDataFactory;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [id.dana.promodiscovery.model.SectionState, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BankPromoItemAdapter(id.dana.promodiscovery.richview.PromoDiscoveryListItemListener<? super id.dana.promocenter.model.PromoModel> r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            r2.MyBillsEntityDataFactory = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.promodiscovery.adapter.BankPromoItemAdapter.<init>(id.dana.promodiscovery.richview.PromoDiscoveryListItemListener):void");
    }

    @Override // id.dana.promodiscovery.adapter.BaseDiscoveryItemAdapter
    public final BaseRecyclerViewHolder<PromoModel> MyBillsEntityDataFactory(ViewGroup p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return new BankPromoItemViewHolder(p0, this.MyBillsEntityDataFactory);
    }
}
