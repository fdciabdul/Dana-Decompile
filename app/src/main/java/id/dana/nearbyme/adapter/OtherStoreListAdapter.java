package id.dana.nearbyme.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.nearbyme.adapter.viewholder.LoadingSkeletonViewHolder;
import id.dana.nearbyme.adapter.viewholder.OtherStoreItemViewHolder;
import id.dana.nearbyme.adapter.viewholder.OtherStoreLabelHeaderViewHolder;
import id.dana.nearbyme.adapter.viewholder.SeeMoreButtonViewHolder;
import id.dana.nearbyme.merchantdetail.model.MerchantDetailViewState;
import id.dana.nearbyme.model.MerchantItemWrapper;
import id.dana.nearbyme.model.PromoInfoModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/nearbyme/adapter/OtherStoreListAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/MerchantItemWrapper;", "", "p0", "getItemViewType", "(I)I", "Lid/dana/nearbyme/adapter/OtherStoreListListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/adapter/OtherStoreListListener;", "<init>", "(Lid/dana/nearbyme/adapter/OtherStoreListListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OtherStoreListAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<MerchantItemWrapper>, MerchantItemWrapper> {
    private final OtherStoreListListener BuiltInFictitiousFunctionClassFactory;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        SeeMoreButtonViewHolder seeMoreButtonViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 1) {
            seeMoreButtonViewHolder = new SeeMoreButtonViewHolder(viewGroup, new OtherStoreListAdapter$onCreateViewHolder$1(this.BuiltInFictitiousFunctionClassFactory));
        } else if (i == 2) {
            seeMoreButtonViewHolder = new OtherStoreLabelHeaderViewHolder(viewGroup);
        } else if (i == 3) {
            seeMoreButtonViewHolder = new LoadingSkeletonViewHolder(viewGroup);
        } else {
            seeMoreButtonViewHolder = new OtherStoreItemViewHolder(viewGroup, new Function1<Integer, Unit>() { // from class: id.dana.nearbyme.adapter.OtherStoreListAdapter$onCreateViewHolder$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2) {
                    OtherStoreListListener otherStoreListListener;
                    MerchantItemWrapper item = OtherStoreListAdapter.this.getItem(i2);
                    if (item != null) {
                        otherStoreListListener = OtherStoreListAdapter.this.BuiltInFictitiousFunctionClassFactory;
                        otherStoreListListener.BuiltInFictitiousFunctionClassFactory(item.MyBillsEntityDataFactory);
                    }
                }
            }, new Function1<Integer, Unit>() { // from class: id.dana.nearbyme.adapter.OtherStoreListAdapter$onCreateViewHolder$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i2) {
                    OtherStoreListListener otherStoreListListener;
                    MerchantItemWrapper item = OtherStoreListAdapter.this.getItem(i2);
                    if (item != null) {
                        otherStoreListListener = OtherStoreListAdapter.this.BuiltInFictitiousFunctionClassFactory;
                        List<PromoInfoModel> list = item.MyBillsEntityDataFactory.getCallingPid;
                        Intrinsics.checkNotNullExpressionValue(list, "");
                        otherStoreListListener.BuiltInFictitiousFunctionClassFactory(list);
                    }
                }
            }, new Function1<Integer, Unit>() { // from class: id.dana.nearbyme.adapter.OtherStoreListAdapter$onCreateViewHolder$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r3v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
                public final void invoke(int i2) {
                    OtherStoreListListener otherStoreListListener;
                    MerchantItemWrapper item = OtherStoreListAdapter.this.getItem(i2);
                    if (item != null) {
                        otherStoreListListener = OtherStoreListAdapter.this.BuiltInFictitiousFunctionClassFactory;
                        ?? r3 = 0;
                        otherStoreListListener.KClassImpl$Data$declaredNonStaticMembers$2(new MerchantDetailViewState(item.MyBillsEntityDataFactory, r3, 2, r3));
                    }
                }
            });
        }
        return seeMoreButtonViewHolder;
    }

    public OtherStoreListAdapter(OtherStoreListListener otherStoreListListener) {
        Intrinsics.checkNotNullParameter(otherStoreListListener, "");
        this.BuiltInFictitiousFunctionClassFactory = otherStoreListListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItems().get(p0).BuiltInFictitiousFunctionClassFactory;
    }
}
