package id.dana.nearbyme.merchantdetail.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.nearbyme.merchantdetail.enums.MerchantMenu;
import id.dana.nearbyme.merchantdetail.model.MerchantMenuModel;
import id.dana.nearbyme.merchantdetail.viewholder.MerchantMenuViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u000b\u0010\fR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/nearbyme/merchantdetail/adapter/MerchantMenuAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/nearbyme/merchantdetail/viewholder/MerchantMenuViewHolder;", "Lid/dana/nearbyme/merchantdetail/model/MerchantMenuModel;", "Lkotlin/Function1;", "Lid/dana/nearbyme/merchantdetail/enums/MerchantMenu;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;", "PlaceComponentResult", "p0", "<init>", "(Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantMenuAdapter extends BaseRecyclerViewAdapter<MerchantMenuViewHolder, MerchantMenuModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Function1<MerchantMenu, Unit> PlaceComponentResult;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new MerchantMenuViewHolder(viewGroup, new Function1<Integer, Unit>() { // from class: id.dana.nearbyme.merchantdetail.adapter.MerchantMenuAdapter$onCreateViewHolder$1
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
                Function1 function1;
                MerchantMenuModel item = MerchantMenuAdapter.this.getItem(i2);
                if (item != null) {
                    MerchantMenuAdapter merchantMenuAdapter = MerchantMenuAdapter.this;
                    if (item.getKClassImpl$Data$declaredNonStaticMembers$2()) {
                        function1 = merchantMenuAdapter.PlaceComponentResult;
                        function1.invoke(item.MyBillsEntityDataFactory);
                    }
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MerchantMenuAdapter(Function1<? super MerchantMenu, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.PlaceComponentResult = function1;
    }
}
