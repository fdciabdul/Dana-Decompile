package id.dana.nearbyme.merchantdetail.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.nearbyme.merchantdetail.mediaviewer.MediaViewerModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewViewModel;
import id.dana.nearbyme.merchantdetail.viewholder.MerchantLatestReviewViewHolder;
import id.dana.nearbyme.model.ShopModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B#\u0012\u0006\u0010\u0005\u001a\u00020\u0010\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\f¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0012\u0010\n\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0014\u001a\u00020\u0016X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0017"}, d2 = {"Lid/dana/nearbyme/merchantdetail/adapter/MerchantLatestReviewAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewViewModel;", "", "p0", "getItemViewType", "(I)I", "", "", "PlaceComponentResult", "(Z)V", "Lkotlin/Function1;", "Lid/dana/nearbyme/merchantdetail/mediaviewer/MediaViewerModel;", "Lkotlin/jvm/functions/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/nearbyme/model/ShopModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/model/ShopModel;", "getAuthRequestContext", "MyBillsEntityDataFactory", "Z", "", "Ljava/lang/String;", "p1", "<init>", "(Lid/dana/nearbyme/model/ShopModel;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantLatestReviewAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<MerchantReviewViewModel>, MerchantReviewViewModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final ShopModel getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public boolean PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function1<MediaViewerModel, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String MyBillsEntityDataFactory;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new MerchantLatestReviewViewHolder(viewGroup, getItems().size(), this.getAuthRequestContext, this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, this.MyBillsEntityDataFactory);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MerchantLatestReviewAdapter(ShopModel shopModel, Function1<? super MediaViewerModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.getAuthRequestContext = shopModel;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function1;
        this.MyBillsEntityDataFactory = "";
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        MerchantReviewViewModel item = getItem(p0);
        if (item != null) {
            return item.MyBillsEntityDataFactory;
        }
        return 1;
    }

    public final void PlaceComponentResult(boolean p0) {
        List<MerchantReviewViewModel> items = getItems();
        if (items != null) {
            if (p0) {
                items.add(null);
                notifyItemInserted(CollectionsKt.getLastIndex(items));
                return;
            }
            removeItem(CollectionsKt.getLastIndex(items));
        }
    }
}
