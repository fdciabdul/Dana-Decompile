package id.dana.nearbyme.merchantdetail.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.nearbyme.merchantdetail.model.MerchantProductInfoModel;
import id.dana.nearbyme.merchantdetail.viewholder.MerchantDanaDealsShimmerViewHolder;
import id.dana.nearbyme.merchantdetail.viewholder.MerchantDanaDealsViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001e\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/nearbyme/merchantdetail/adapter/MerchantDanaDealsAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;", "", "p0", "getItemViewType", "(I)I", "Landroid/content/Context;", "PlaceComponentResult", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Lkotlin/Function1;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/jvm/functions/Function1;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Landroid/content/Context;)V", "MerchantDanaDealType"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantDanaDealsAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<MerchantProductInfoModel>, MerchantProductInfoModel> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public Function1<? super MerchantProductInfoModel, Unit> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private Context MyBillsEntityDataFactory;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MerchantDanaDealsViewHolder merchantDanaDealsViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == MerchantDanaDealType.SHIMMER.getValue()) {
            merchantDanaDealsViewHolder = new MerchantDanaDealsShimmerViewHolder(viewGroup);
        } else if (i == MerchantDanaDealType.NON_SHIMMER.getValue()) {
            merchantDanaDealsViewHolder = new MerchantDanaDealsViewHolder(viewGroup, this.BuiltInFictitiousFunctionClassFactory);
        } else {
            merchantDanaDealsViewHolder = new MerchantDanaDealsViewHolder(viewGroup, this.BuiltInFictitiousFunctionClassFactory);
        }
        return merchantDanaDealsViewHolder;
    }

    public MerchantDanaDealsAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.MyBillsEntityDataFactory = context;
        this.BuiltInFictitiousFunctionClassFactory = new Function1<MerchantProductInfoModel, Unit>() { // from class: id.dana.nearbyme.merchantdetail.adapter.MerchantDanaDealsAdapter$onBuyButtonClickListener$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MerchantProductInfoModel merchantProductInfoModel) {
                Intrinsics.checkNotNullParameter(merchantProductInfoModel, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MerchantProductInfoModel merchantProductInfoModel) {
                invoke2(merchantProductInfoModel);
                return Unit.INSTANCE;
            }
        };
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        if (getItems().get(p0).NetworkUserEntityData$$ExternalSyntheticLambda1.getScheduleImpl()) {
            return MerchantDanaDealType.SHIMMER.getValue();
        }
        return MerchantDanaDealType.NON_SHIMMER.getValue();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n"}, d2 = {"Lid/dana/nearbyme/merchantdetail/adapter/MerchantDanaDealsAdapter$MerchantDanaDealType;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "SHIMMER", "NON_SHIMMER"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    enum MerchantDanaDealType {
        SHIMMER(0),
        NON_SHIMMER(1);

        private final int value;

        MerchantDanaDealType(int i) {
            this.value = i;
        }

        @JvmName(name = "getValue")
        public final int getValue() {
            return this.value;
        }
    }
}
