package id.dana.data.nearbyme.mapper;

import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.data.nearbyme.model.NearbyVoucherInfoEntity;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.nearbyme.model.VoucherInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/nearbyme/model/NearbyVoucherInfoEntity;", "Lid/dana/domain/nearbyme/model/VoucherInfo;", "toVoucherInfo", "(Lid/dana/data/nearbyme/model/NearbyVoucherInfoEntity;)Lid/dana/domain/nearbyme/model/VoucherInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NearbyVoucherInfoMapperKt {
    public static final VoucherInfo toVoucherInfo(NearbyVoucherInfoEntity nearbyVoucherInfoEntity) {
        Intrinsics.checkNotNullParameter(nearbyVoucherInfoEntity, "");
        String voucherName = nearbyVoucherInfoEntity.getVoucherName();
        String voucherIcon = nearbyVoucherInfoEntity.getVoucherIcon();
        String voucherShortDescription = nearbyVoucherInfoEntity.getVoucherShortDescription();
        MoneyView moneyView = new MoneyView(String.valueOf(nearbyVoucherInfoEntity.getVoucherValue().getAmount()), String.valueOf(nearbyVoucherInfoEntity.getVoucherValue().getCurrency()), nearbyVoucherInfoEntity.getVoucherValue().getCurrencyCode());
        MoneyView moneyView2 = new MoneyView(String.valueOf(nearbyVoucherInfoEntity.getVoucherPrice().getAmount()), String.valueOf(nearbyVoucherInfoEntity.getVoucherPrice().getCurrency()), nearbyVoucherInfoEntity.getVoucherPrice().getCurrencyCode());
        MoneyView moneyView3 = MoneyViewEntityMapperKt.toMoneyView(nearbyVoucherInfoEntity.getDisplayVoucherValue());
        MoneyView moneyView4 = MoneyViewEntityMapperKt.toMoneyView(nearbyVoucherInfoEntity.getDisplayVoucherPrice());
        MoneyView moneyView5 = MoneyViewEntityMapperKt.toMoneyView(nearbyVoucherInfoEntity.getDisplayStrikethroughPrice());
        String tnc = nearbyVoucherInfoEntity.getTnc();
        String howTo = nearbyVoucherInfoEntity.getHowTo();
        String discountOffRate = nearbyVoucherInfoEntity.getDiscountOffRate();
        return new VoucherInfo(voucherName, voucherIcon, null, voucherShortDescription, moneyView, moneyView2, moneyView3, moneyView4, moneyView5, tnc, howTo, discountOffRate != null ? discountOffRate : "", 4, null);
    }
}
