package id.dana.nearbyme.merchantdetail.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.nearbyme.model.MerchantProductInfo;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.nearbyme.model.VoucherInfo;
import id.dana.nearbyme.merchantdetail.model.MerchantProductInfoModel;
import id.dana.nearbyme.merchantdetail.model.MerchantVoucherInfoModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/nearbyme/merchantdetail/mapper/MerchantDanaDealsMapper;", "Lid/dana/data/base/BaseMapper;", "", "Lid/dana/domain/nearbyme/model/MerchantProductInfo;", "Lid/dana/nearbyme/merchantdetail/model/MerchantProductInfoModel;", "Lid/dana/domain/nearbyme/model/MoneyView;", "p0", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/domain/nearbyme/model/MoneyView;)Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantDanaDealsMapper extends BaseMapper<List<? extends MerchantProductInfo>, List<? extends MerchantProductInfoModel>> {
    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ List<? extends MerchantProductInfoModel> map(List<? extends MerchantProductInfo> list) {
        List<? extends MerchantProductInfo> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "");
        ArrayList arrayList = new ArrayList();
        for (MerchantProductInfo merchantProductInfo : list2) {
            String goodsId = merchantProductInfo.getGoodsId();
            String provider = merchantProductInfo.getProvider();
            String type = merchantProductInfo.getType();
            String description = merchantProductInfo.getDescription();
            String goodsTitle = merchantProductInfo.getGoodsTitle();
            MoneyViewModel KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(merchantProductInfo.getPrice());
            MoneyViewModel KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(merchantProductInfo.getDenom());
            boolean available = merchantProductInfo.getAvailable();
            String productCode = merchantProductInfo.getProductCode();
            Map<String, String> extendInfo = merchantProductInfo.getExtendInfo();
            VoucherInfo voucherInfo = merchantProductInfo.getVoucherInfo();
            String voucherName = voucherInfo.getVoucherName();
            String voucherIcon = voucherInfo.getVoucherIcon();
            String voucherBackground = voucherInfo.getVoucherBackground();
            String voucherShortDescription = voucherInfo.getVoucherShortDescription();
            MoneyViewModel.Companion companion = MoneyViewModel.INSTANCE;
            MoneyViewModel PlaceComponentResult = MoneyViewModel.Companion.PlaceComponentResult(voucherInfo.getVoucherValue());
            MoneyViewModel.Companion companion2 = MoneyViewModel.INSTANCE;
            MoneyViewModel PlaceComponentResult2 = MoneyViewModel.Companion.PlaceComponentResult(voucherInfo.getVoucherPrice());
            MoneyViewModel.Companion companion3 = MoneyViewModel.INSTANCE;
            MoneyViewModel PlaceComponentResult3 = MoneyViewModel.Companion.PlaceComponentResult(voucherInfo.getDisplayVoucherValue());
            MoneyViewModel.Companion companion4 = MoneyViewModel.INSTANCE;
            MoneyViewModel PlaceComponentResult4 = MoneyViewModel.Companion.PlaceComponentResult(voucherInfo.getDisplayVoucherPrice());
            MoneyViewModel.Companion companion5 = MoneyViewModel.INSTANCE;
            arrayList.add(new MerchantProductInfoModel(goodsId, provider, type, description, goodsTitle, KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$22, available, productCode, extendInfo, new MerchantVoucherInfoModel(voucherName, voucherIcon, voucherBackground, voucherShortDescription, PlaceComponentResult, PlaceComponentResult2, PlaceComponentResult3, PlaceComponentResult4, MoneyViewModel.Companion.PlaceComponentResult(voucherInfo.getDisplayStrikethroughPrice()), voucherInfo.getTnc(), voucherInfo.getHowTo(), voucherInfo.getDiscountOffRate(), false), merchantProductInfo.getSavingRate()));
        }
        return arrayList;
    }

    @Inject
    public MerchantDanaDealsMapper() {
    }

    private static MoneyViewModel KClassImpl$Data$declaredNonStaticMembers$2(MoneyView p0) {
        String amount = p0.getAmount();
        String currency = p0.getCurrency();
        String currencyCode = p0.getCurrencyCode();
        if (currencyCode == null) {
            currencyCode = "";
        }
        return new MoneyViewModel(amount, currency, currencyCode);
    }
}
