package id.dana.nearbyme.merchantreview.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.drawable.search.viewholder.NearbyMerchantLoadingViewHolder;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewViewModel;
import id.dana.nearbyme.merchantreview.viewholder.MerchantReviewSectionTitleViewHolder;
import id.dana.nearbyme.merchantreview.viewholder.MyReviewEmptyViewHolder;
import id.dana.nearbyme.merchantreview.viewholder.MyReviewViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\fR \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/nearbyme/merchantreview/adapter/MyReviewAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewViewModel;", "", "p0", "getItemViewType", "(I)I", "", "MyBillsEntityDataFactory", "()Z", "PlaceComponentResult", "Z", "Lkotlin/Function1;", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyReviewAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<MerchantReviewViewModel>, MerchantReviewViewModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Function1<MerchantReviewModel, Unit> BuiltInFictitiousFunctionClassFactory;
    public boolean PlaceComponentResult;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        NearbyMerchantLoadingViewHolder nearbyMerchantLoadingViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        switch (i) {
            case 4:
                nearbyMerchantLoadingViewHolder = new NearbyMerchantLoadingViewHolder(viewGroup);
                break;
            case 5:
            case 6:
                nearbyMerchantLoadingViewHolder = new MyReviewViewHolder(viewGroup, this.BuiltInFictitiousFunctionClassFactory);
                break;
            case 7:
                nearbyMerchantLoadingViewHolder = new MyReviewEmptyViewHolder(viewGroup, this.PlaceComponentResult);
                break;
            case 8:
                String string = viewGroup.getContext().getString(R.string.my_review_section_title);
                Intrinsics.checkNotNullExpressionValue(string, "");
                nearbyMerchantLoadingViewHolder = new MerchantReviewSectionTitleViewHolder(viewGroup, string);
                break;
            default:
                nearbyMerchantLoadingViewHolder = new MyReviewViewHolder(viewGroup, this.BuiltInFictitiousFunctionClassFactory);
                break;
        }
        return nearbyMerchantLoadingViewHolder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MyReviewAdapter(Function1<? super MerchantReviewModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.BuiltInFictitiousFunctionClassFactory = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItems().get(p0).MyBillsEntityDataFactory;
    }

    public final boolean MyBillsEntityDataFactory() {
        List<MerchantReviewViewModel> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        return ((MerchantReviewViewModel) CollectionsKt.last((List) items)).MyBillsEntityDataFactory == 6;
    }
}
