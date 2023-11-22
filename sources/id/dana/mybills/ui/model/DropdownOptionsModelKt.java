package id.dana.mybills.ui.model;

import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.mybills.domain.model.ProductGoodsInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/domain/model/ProductGoodsInfo;", "Lid/dana/mybills/ui/model/DropdownOptionsModel;", "toDropdownOptionsModel", "(Lid/dana/mybills/domain/model/ProductGoodsInfo;)Lid/dana/mybills/ui/model/DropdownOptionsModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class DropdownOptionsModelKt {
    public static final DropdownOptionsModel toDropdownOptionsModel(ProductGoodsInfo productGoodsInfo) {
        MoneyViewModel moneyViewModel;
        Intrinsics.checkNotNullParameter(productGoodsInfo, "");
        String goodsTitle = productGoodsInfo.getGoodsTitle();
        String goodsId = productGoodsInfo.getGoodsId();
        MoneyView denom = productGoodsInfo.getDenom();
        String displayAmount = (denom == null || (moneyViewModel = BillPaymentStatusModelKt.toMoneyViewModel(denom)) == null) ? null : moneyViewModel.getDisplayAmount();
        MoneyView price = productGoodsInfo.getPrice();
        return new DropdownOptionsModel(goodsTitle, displayAmount, goodsId, price != null ? BillPaymentStatusModelKt.toMoneyViewModel(price) : null, null, 16, null);
    }
}
