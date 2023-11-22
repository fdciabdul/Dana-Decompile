package id.dana.mybills.ui.viewholder;

import androidx.recyclerview.widget.RecyclerView;
import id.dana.mybills.databinding.ItemBillsRecentTransactionV2Binding;
import id.dana.mybills.ui.model.BizProductModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\rB\u0017\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007"}, d2 = {"Lid/dana/mybills/ui/viewholder/QuickBuyBillsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lid/dana/mybills/databinding/ItemBillsRecentTransactionV2Binding;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/mybills/databinding/ItemBillsRecentTransactionV2Binding;", "getAuthRequestContext", "Lid/dana/mybills/ui/viewholder/QuickBuyBillsViewHolder$OnQuickBuyBillsClickCallback;", "Lid/dana/mybills/ui/viewholder/QuickBuyBillsViewHolder$OnQuickBuyBillsClickCallback;", "PlaceComponentResult", "p0", "p1", "<init>", "(Lid/dana/mybills/databinding/ItemBillsRecentTransactionV2Binding;Lid/dana/mybills/ui/viewholder/QuickBuyBillsViewHolder$OnQuickBuyBillsClickCallback;)V", "OnQuickBuyBillsClickCallback"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class QuickBuyBillsViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final ItemBillsRecentTransactionV2Binding getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final OnQuickBuyBillsClickCallback PlaceComponentResult;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/mybills/ui/viewholder/QuickBuyBillsViewHolder$OnQuickBuyBillsClickCallback;", "", "Lid/dana/mybills/ui/model/BizProductModel;", "p0", "", "MyBillsEntityDataFactory", "(Lid/dana/mybills/ui/model/BizProductModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface OnQuickBuyBillsClickCallback {
        void MyBillsEntityDataFactory(BizProductModel p0);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(QuickBuyBillsViewHolder quickBuyBillsViewHolder, BizProductModel bizProductModel) {
        Intrinsics.checkNotNullParameter(quickBuyBillsViewHolder, "");
        quickBuyBillsViewHolder.PlaceComponentResult.MyBillsEntityDataFactory(bizProductModel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickBuyBillsViewHolder(ItemBillsRecentTransactionV2Binding itemBillsRecentTransactionV2Binding, OnQuickBuyBillsClickCallback onQuickBuyBillsClickCallback) {
        super(itemBillsRecentTransactionV2Binding.MyBillsEntityDataFactory);
        Intrinsics.checkNotNullParameter(itemBillsRecentTransactionV2Binding, "");
        Intrinsics.checkNotNullParameter(onQuickBuyBillsClickCallback, "");
        this.getAuthRequestContext = itemBillsRecentTransactionV2Binding;
        this.PlaceComponentResult = onQuickBuyBillsClickCallback;
    }
}
