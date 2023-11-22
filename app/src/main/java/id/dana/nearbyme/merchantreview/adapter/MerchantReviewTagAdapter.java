package id.dana.nearbyme.merchantreview.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.nearbyme.merchantreview.MerchantReviewTagListener;
import id.dana.nearbyme.merchantreview.model.MerchantReviewTagModel;
import id.dana.nearbyme.merchantreview.viewholder.MerchantReviewTagViewHolder;
import java.util.LinkedList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\t"}, d2 = {"Lid/dana/nearbyme/merchantreview/adapter/MerchantReviewTagAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/nearbyme/merchantreview/viewholder/MerchantReviewTagViewHolder;", "Lid/dana/nearbyme/merchantreview/model/MerchantReviewTagModel;", "Lid/dana/nearbyme/merchantreview/MerchantReviewTagListener;", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantreview/MerchantReviewTagListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/LinkedList;", "Lkotlin/Lazy;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/nearbyme/merchantreview/MerchantReviewTagListener;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantReviewTagAdapter extends BaseRecyclerViewAdapter<MerchantReviewTagViewHolder, MerchantReviewTagModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Lazy PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final MerchantReviewTagListener KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new MerchantReviewTagViewHolder((LinkedList) this.PlaceComponentResult.getValue(), viewGroup, new MerchantReviewTagListener() { // from class: id.dana.nearbyme.merchantreview.adapter.MerchantReviewTagAdapter$onCreateViewHolder$1
            @Override // id.dana.nearbyme.merchantreview.MerchantReviewTagListener
            public final void MyBillsEntityDataFactory(int p0) {
                MerchantReviewTagListener merchantReviewTagListener;
                MerchantReviewTagAdapter.getAuthRequestContext(MerchantReviewTagAdapter.this, p0);
                merchantReviewTagListener = MerchantReviewTagAdapter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                merchantReviewTagListener.MyBillsEntityDataFactory(p0);
            }
        });
    }

    public MerchantReviewTagAdapter(MerchantReviewTagListener merchantReviewTagListener) {
        Intrinsics.checkNotNullParameter(merchantReviewTagListener, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = merchantReviewTagListener;
        this.PlaceComponentResult = LazyKt.lazy(new Function0<LinkedList<MerchantReviewTagModel>>() { // from class: id.dana.nearbyme.merchantreview.adapter.MerchantReviewTagAdapter$selectedTags$2
            @Override // kotlin.jvm.functions.Function0
            public final LinkedList<MerchantReviewTagModel> invoke() {
                return new LinkedList<>();
            }
        });
    }

    public static final /* synthetic */ void getAuthRequestContext(MerchantReviewTagAdapter merchantReviewTagAdapter, int i) {
        MerchantReviewTagModel merchantReviewTagModel;
        MerchantReviewTagModel item = merchantReviewTagAdapter.getItem(i);
        if (item != null) {
            if (!item.getMyBillsEntityDataFactory()) {
                if (((LinkedList) merchantReviewTagAdapter.PlaceComponentResult.getValue()).size() == 3 && (merchantReviewTagModel = (MerchantReviewTagModel) ((LinkedList) merchantReviewTagAdapter.PlaceComponentResult.getValue()).pollFirst()) != null) {
                    List<MerchantReviewTagModel> items = merchantReviewTagAdapter.getItems();
                    Intrinsics.checkNotNullExpressionValue(items, "");
                    for (MerchantReviewTagModel merchantReviewTagModel2 : items) {
                        if (Intrinsics.areEqual(merchantReviewTagModel2.PlaceComponentResult, merchantReviewTagModel.PlaceComponentResult)) {
                            merchantReviewTagModel2.MyBillsEntityDataFactory = false;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
                ((LinkedList) merchantReviewTagAdapter.PlaceComponentResult.getValue()).addLast(item);
                item.MyBillsEntityDataFactory = true;
            } else {
                ((LinkedList) merchantReviewTagAdapter.PlaceComponentResult.getValue()).remove(item);
                item.MyBillsEntityDataFactory = false;
            }
            merchantReviewTagAdapter.notifyDataSetChanged();
        }
    }
}
