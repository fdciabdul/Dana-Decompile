package id.dana.cashier.model;

import id.dana.cashier.domain.model.AddonImportantInfo;
import id.dana.cashier.domain.model.Benefit;
import id.dana.cashier.domain.model.InsuranceBenefit;
import id.dana.cashier.domain.model.TooltipProductInfo;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModelKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cashier/domain/model/TooltipProductInfo;", "Lid/dana/cashier/model/TooltipProductInfoModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/domain/model/TooltipProductInfo;)Lid/dana/cashier/model/TooltipProductInfoModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TooltipProductInfoModelKt {
    public static final TooltipProductInfoModel BuiltInFictitiousFunctionClassFactory(TooltipProductInfo tooltipProductInfo) {
        Intrinsics.checkNotNullParameter(tooltipProductInfo, "");
        String aggregatorGoodsId = tooltipProductInfo.getAggregatorGoodsId();
        String aggregatorId = tooltipProductInfo.getAggregatorId();
        String aggregatorLogoUrl = tooltipProductInfo.getAggregatorLogoUrl();
        Boolean available = tooltipProductInfo.getAvailable();
        List<Benefit> benefits = tooltipProductInfo.getBenefits();
        List<BenefitModel> authRequestContext = benefits != null ? BenefitModelKt.getAuthRequestContext(benefits) : null;
        Boolean expressGoods = tooltipProductInfo.getExpressGoods();
        String finType = tooltipProductInfo.getFinType();
        String goodsDescription = tooltipProductInfo.getGoodsDescription();
        String goodsId = tooltipProductInfo.getGoodsId();
        String goodsTitle = tooltipProductInfo.getGoodsTitle();
        String goodsType = tooltipProductInfo.getGoodsType();
        List<InsuranceBenefit> insuranceBenefits = tooltipProductInfo.getInsuranceBenefits();
        List<InsuranceBenefitModel> PlaceComponentResult = insuranceBenefits != null ? InsuranceBenefitModelKt.PlaceComponentResult(insuranceBenefits) : null;
        MoneyView price = tooltipProductInfo.getPrice();
        MoneyViewModel authRequestContext2 = price != null ? MoneyViewModelKt.getAuthRequestContext(price) : null;
        String providerId = tooltipProductInfo.getProviderId();
        String providerLogoUrl = tooltipProductInfo.getProviderLogoUrl();
        Boolean stackInsurance = tooltipProductInfo.getStackInsurance();
        String tier = tooltipProductInfo.getTier();
        String tierIdentifier = tooltipProductInfo.getTierIdentifier();
        List<String> tncBrief = tooltipProductInfo.getTncBrief();
        String tncUrl = tooltipProductInfo.getTncUrl();
        String str = tncUrl != null ? tncUrl : "";
        List<AddonImportantInfo> importantInfos = tooltipProductInfo.getImportantInfos();
        return new TooltipProductInfoModel(aggregatorGoodsId, aggregatorId, aggregatorLogoUrl, available, authRequestContext, expressGoods, finType, goodsDescription, goodsId, goodsTitle, goodsType, PlaceComponentResult, authRequestContext2, providerId, providerLogoUrl, stackInsurance, tier, tierIdentifier, tncBrief, str, importantInfos != null ? AddonImportantInfoModelKt.MyBillsEntityDataFactory(importantInfos) : null);
    }
}
