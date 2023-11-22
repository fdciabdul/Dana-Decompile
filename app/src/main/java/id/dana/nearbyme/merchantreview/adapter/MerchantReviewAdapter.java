package id.dana.nearbyme.merchantreview.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.drawable.search.viewholder.NearbyMerchantLoadingViewHolder;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewViewHolderModel;
import id.dana.nearbyme.merchantreview.viewholder.MerchantReviewSectionTitleViewHolder;
import id.dana.nearbyme.merchantreview.viewholder.MerchantReviewShimmerViewHolder;
import id.dana.nearbyme.merchantreview.viewholder.MerchantReviewSpaceViewHolder;
import id.dana.nearbyme.merchantreview.viewholder.MerchantReviewViewAllViewHolder;
import id.dana.nearbyme.merchantreview.viewholder.UnreviewedMerchantViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B1\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000e\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\rR&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/nearbyme/merchantreview/adapter/MerchantReviewAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewViewHolderModel;", "", "p0", "getItemViewType", "(I)I", "", "MyBillsEntityDataFactory", "()Z", "PlaceComponentResult", "", "(I)V", "Lkotlin/Function2;", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function2;", "Lkotlin/Function0;", "getAuthRequestContext", "Lkotlin/jvm/functions/Function0;", "p1", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantReviewAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<MerchantConsultReviewViewHolderModel>, MerchantConsultReviewViewHolderModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Function2<MerchantConsultReviewModel, Integer, Unit> MyBillsEntityDataFactory;
    private final Function0<Unit> getAuthRequestContext;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MerchantReviewSectionTitleViewHolder merchantReviewSectionTitleViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        switch (i) {
            case 1:
                String string = viewGroup.getContext().getString(R.string.pending_review_section_title);
                Intrinsics.checkNotNullExpressionValue(string, "");
                merchantReviewSectionTitleViewHolder = new MerchantReviewSectionTitleViewHolder(viewGroup, string);
                break;
            case 2:
            case 3:
                merchantReviewSectionTitleViewHolder = new UnreviewedMerchantViewHolder(viewGroup, this.MyBillsEntityDataFactory);
                break;
            case 4:
                merchantReviewSectionTitleViewHolder = new MerchantReviewViewAllViewHolder(viewGroup, this.getAuthRequestContext);
                break;
            case 5:
                merchantReviewSectionTitleViewHolder = new MerchantReviewSpaceViewHolder(viewGroup);
                break;
            case 6:
                merchantReviewSectionTitleViewHolder = new NearbyMerchantLoadingViewHolder(viewGroup);
                break;
            default:
                merchantReviewSectionTitleViewHolder = new MerchantReviewShimmerViewHolder(viewGroup);
                break;
        }
        return merchantReviewSectionTitleViewHolder;
    }

    public /* synthetic */ MerchantReviewAdapter(Function2 function2, AnonymousClass1 anonymousClass1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2, (i & 2) != 0 ? new Function0<Unit>() { // from class: id.dana.nearbyme.merchantreview.adapter.MerchantReviewAdapter.1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : anonymousClass1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MerchantReviewAdapter(Function2<? super MerchantConsultReviewModel, ? super Integer, Unit> function2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function2, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.MyBillsEntityDataFactory = function2;
        this.getAuthRequestContext = function0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        MerchantConsultReviewViewHolderModel item = getItem(p0);
        if (item != null) {
            return item.MyBillsEntityDataFactory;
        }
        return 0;
    }

    public final void PlaceComponentResult(int p0) {
        MerchantConsultReviewViewHolderModel merchantConsultReviewViewHolderModel = (MerchantConsultReviewViewHolderModel) getItems().get(p0);
        MerchantConsultReviewModel merchantConsultReviewModel = merchantConsultReviewViewHolderModel.PlaceComponentResult;
        if (merchantConsultReviewModel != null) {
            merchantConsultReviewModel.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        }
        notifyItemChanged(p0, merchantConsultReviewViewHolderModel);
    }

    public final boolean PlaceComponentResult() {
        List<MerchantConsultReviewViewHolderModel> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        return ((MerchantConsultReviewViewHolderModel) CollectionsKt.last((List) items)).MyBillsEntityDataFactory == 0;
    }

    public final boolean MyBillsEntityDataFactory() {
        List<MerchantConsultReviewViewHolderModel> items = getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        return ((MerchantConsultReviewViewHolderModel) CollectionsKt.last((List) items)).MyBillsEntityDataFactory == 3;
    }
}
