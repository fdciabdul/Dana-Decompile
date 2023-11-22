package id.dana.drawable.merchantdetail.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.drawable.merchantdetail.sections.LoadingSpecialDealsSectionViewHolder;
import id.dana.drawable.merchantdetail.sections.MerchantSpecialDealsSectionViewHolder;
import id.dana.nearbyme.merchantdetail.model.MerchantProductInfoModel;
import id.dana.nearbyme.model.NearbyDealsSectionModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B)\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000f"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantSpecialDealsSectionAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/NearbyDealsSectionModel;", "", "p0", "getItemViewType", "(I)I", "Lkotlin/Function1;", "Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getAuthRequestContext", "p1", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantSpecialDealsSectionAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<NearbyDealsSectionModel>, NearbyDealsSectionModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Function0<Unit> getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private Function1<? super MerchantProductInfoModel, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[NearbyDealsSectionModel.SectionState.values().length];
            iArr[NearbyDealsSectionModel.SectionState.ACTIVE.ordinal()] = 1;
            iArr[NearbyDealsSectionModel.SectionState.LOADING.ordinal()] = 2;
            getAuthRequestContext = iArr;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LoadingSpecialDealsSectionViewHolder loadingSpecialDealsSectionViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            loadingSpecialDealsSectionViewHolder = new MerchantSpecialDealsSectionViewHolder(viewGroup, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext);
        } else {
            loadingSpecialDealsSectionViewHolder = new LoadingSpecialDealsSectionViewHolder(viewGroup);
        }
        return loadingSpecialDealsSectionViewHolder;
    }

    public MerchantSpecialDealsSectionAdapter(Function1<? super MerchantProductInfoModel, Unit> function1, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function1;
        this.getAuthRequestContext = function0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        int i = WhenMappings.getAuthRequestContext[getItems().get(p0).MyBillsEntityDataFactory.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 1;
            }
            throw new NoWhenBranchMatchedException();
        }
        return 0;
    }
}
