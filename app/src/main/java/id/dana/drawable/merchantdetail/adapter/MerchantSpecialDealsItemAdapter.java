package id.dana.drawable.merchantdetail.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.drawable.merchantdetail.itemviewholder.EmptySpaceViewHolder;
import id.dana.drawable.merchantdetail.itemviewholder.MerchantSpecialDealsItemViewHolder;
import id.dana.drawable.merchantdetail.itemviewholder.SeeMoreViewHolder;
import id.dana.nearbyme.merchantdetail.model.MerchantProductInfoModel;
import id.dana.nearbyme.model.NearbySpecialDealsItemWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B0\u0012\u0019\u0010\u0005\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\t¢\u0006\u0002\b\n\u0012\u0004\u0012\u00020\u000b0\b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R)\u0010\u000e\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\t¢\u0006\u0002\b\n\u0012\u0004\u0012\u00020\u000b0\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/nearbyrevamp/merchantdetail/adapter/MerchantSpecialDealsItemAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/model/NearbySpecialDealsItemWrapper;", "", "p0", "getItemViewType", "(I)I", "Lkotlin/Function1;", "Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;", "Lkotlin/ParameterName;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Function0;", "getAuthRequestContext", "Lkotlin/jvm/functions/Function0;", "p1", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantSpecialDealsItemAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<NearbySpecialDealsItemWrapper>, NearbySpecialDealsItemWrapper> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private Function1<? super MerchantProductInfoModel, Unit> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Function0<Unit> BuiltInFictitiousFunctionClassFactory;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[NearbySpecialDealsItemWrapper.Type.values().length];
            iArr[NearbySpecialDealsItemWrapper.Type.EMPTY_SPACE.ordinal()] = 1;
            iArr[NearbySpecialDealsItemWrapper.Type.SEE_MORE.ordinal()] = 2;
            BuiltInFictitiousFunctionClassFactory = iArr;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        EmptySpaceViewHolder emptySpaceViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 0) {
            emptySpaceViewHolder = new EmptySpaceViewHolder(viewGroup);
        } else if (i == 1) {
            emptySpaceViewHolder = new SeeMoreViewHolder(viewGroup, this.BuiltInFictitiousFunctionClassFactory);
        } else {
            emptySpaceViewHolder = new MerchantSpecialDealsItemViewHolder(viewGroup, this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return emptySpaceViewHolder;
    }

    public MerchantSpecialDealsItemAdapter(Function1<? super MerchantProductInfoModel, Unit> function1, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function1;
        this.BuiltInFictitiousFunctionClassFactory = function0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        int i = WhenMappings.BuiltInFictitiousFunctionClassFactory[getItems().get(p0).getAuthRequestContext.ordinal()];
        if (i != 1) {
            return i == 2 ? 1 : 2;
        }
        return 0;
    }
}
