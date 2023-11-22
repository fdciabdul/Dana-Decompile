package id.dana.cashier.data.mapper;

import id.dana.cashier.data.repository.source.network.result.AddonImportantInfoResult;
import id.dana.cashier.data.repository.source.network.result.BenefitResult;
import id.dana.cashier.data.repository.source.network.result.CashierAddOnModalTooltipResult;
import id.dana.cashier.data.repository.source.network.result.InsuranceBenefitResult;
import id.dana.cashier.data.repository.source.network.result.TooltipContentResult;
import id.dana.cashier.data.repository.source.network.result.TooltipProductInfoResult;
import id.dana.cashier.domain.model.AddonImportantInfo;
import id.dana.cashier.domain.model.Benefit;
import id.dana.cashier.domain.model.CashierAddOnModalTooltip;
import id.dana.cashier.domain.model.InsuranceBenefit;
import id.dana.cashier.domain.model.TooltipContent;
import id.dana.cashier.domain.model.TooltipProductInfo;
import id.dana.data.base.BaseMapper;
import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.domain.nearbyme.model.MoneyView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b \u0010!J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001a\u00020\b*\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\r\u001a\u00020\f*\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0011\u001a\u00020\u0010*\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0013*\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0013*\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0013*\b\u0012\u0004\u0012\u00020\u000f0\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0015J\u0013\u0010\u001a\u001a\u00020\u0019*\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001e\u001a\u00020\u001d*\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/cashier/data/mapper/CashierAddOnModalTooltipResultMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/cashier/data/repository/source/network/result/CashierAddOnModalTooltipResult;", "Lid/dana/cashier/domain/model/CashierAddOnModalTooltip;", "oldItem", "map", "(Lid/dana/cashier/data/repository/source/network/result/CashierAddOnModalTooltipResult;)Lid/dana/cashier/domain/model/CashierAddOnModalTooltip;", "Lid/dana/cashier/data/repository/source/network/result/AddonImportantInfoResult;", "Lid/dana/cashier/domain/model/AddonImportantInfo;", "toAddonImportantInfo", "(Lid/dana/cashier/data/repository/source/network/result/AddonImportantInfoResult;)Lid/dana/cashier/domain/model/AddonImportantInfo;", "Lid/dana/cashier/data/repository/source/network/result/BenefitResult;", "Lid/dana/cashier/domain/model/Benefit;", "toBenefit", "(Lid/dana/cashier/data/repository/source/network/result/BenefitResult;)Lid/dana/cashier/domain/model/Benefit;", "Lid/dana/cashier/data/repository/source/network/result/InsuranceBenefitResult;", "Lid/dana/cashier/domain/model/InsuranceBenefit;", "toInsuranceBenefit", "(Lid/dana/cashier/data/repository/source/network/result/InsuranceBenefitResult;)Lid/dana/cashier/domain/model/InsuranceBenefit;", "", "toListAddonImportantInfo", "(Ljava/util/List;)Ljava/util/List;", "toListBenefit", "toListInsuranceBenefit", "Lid/dana/cashier/data/repository/source/network/result/TooltipContentResult;", "Lid/dana/cashier/domain/model/TooltipContent;", "toTooltipContent", "(Lid/dana/cashier/data/repository/source/network/result/TooltipContentResult;)Lid/dana/cashier/domain/model/TooltipContent;", "Lid/dana/cashier/data/repository/source/network/result/TooltipProductInfoResult;", "Lid/dana/cashier/domain/model/TooltipProductInfo;", "toTooltipProductInfo", "(Lid/dana/cashier/data/repository/source/network/result/TooltipProductInfoResult;)Lid/dana/cashier/domain/model/TooltipProductInfo;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierAddOnModalTooltipResultMapper extends BaseMapper<CashierAddOnModalTooltipResult, CashierAddOnModalTooltip> {
    @Inject
    public CashierAddOnModalTooltipResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public final CashierAddOnModalTooltip map(CashierAddOnModalTooltipResult oldItem) {
        if (oldItem != null) {
            TooltipContentResult content = oldItem.getContent();
            TooltipContent tooltipContent = content != null ? toTooltipContent(content) : null;
            TooltipProductInfoResult productInfo = oldItem.getProductInfo();
            return new CashierAddOnModalTooltip(tooltipContent, productInfo != null ? toTooltipProductInfo(productInfo) : null);
        }
        return null;
    }

    private final TooltipContent toTooltipContent(TooltipContentResult tooltipContentResult) {
        return new TooltipContent(tooltipContentResult.getClockUrl(), tooltipContentResult.getExpiryTime(), tooltipContentResult.getIconUrl());
    }

    private final TooltipProductInfo toTooltipProductInfo(TooltipProductInfoResult tooltipProductInfoResult) {
        String aggregatorGoodsId = tooltipProductInfoResult.getAggregatorGoodsId();
        String aggregatorId = tooltipProductInfoResult.getAggregatorId();
        String aggregatorLogoUrl = tooltipProductInfoResult.getAggregatorLogoUrl();
        Boolean available = tooltipProductInfoResult.getAvailable();
        List<BenefitResult> benefits = tooltipProductInfoResult.getBenefits();
        List<Benefit> listBenefit = benefits != null ? toListBenefit(benefits) : null;
        Boolean expressGoods = tooltipProductInfoResult.getExpressGoods();
        String finType = tooltipProductInfoResult.getFinType();
        String goodsDescription = tooltipProductInfoResult.getGoodsDescription();
        String goodsId = tooltipProductInfoResult.getGoodsId();
        String goodsTitle = tooltipProductInfoResult.getGoodsTitle();
        String goodsType = tooltipProductInfoResult.getGoodsType();
        List<InsuranceBenefitResult> insuranceBenefits = tooltipProductInfoResult.getInsuranceBenefits();
        List<InsuranceBenefit> listInsuranceBenefit = insuranceBenefits != null ? toListInsuranceBenefit(insuranceBenefits) : null;
        MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(tooltipProductInfoResult.getPrice());
        String providerId = tooltipProductInfoResult.getProviderId();
        String providerLogoUrl = tooltipProductInfoResult.getProviderLogoUrl();
        Boolean stackInsurance = tooltipProductInfoResult.getStackInsurance();
        String tier = tooltipProductInfoResult.getTier();
        String tierIdentifier = tooltipProductInfoResult.getTierIdentifier();
        List<String> tncBrief = tooltipProductInfoResult.getTncBrief();
        String tncUrl = tooltipProductInfoResult.getTncUrl();
        List<AddonImportantInfoResult> importantInfos = tooltipProductInfoResult.getImportantInfos();
        return new TooltipProductInfo(aggregatorGoodsId, aggregatorId, aggregatorLogoUrl, available, listBenefit, expressGoods, finType, goodsDescription, goodsId, goodsTitle, goodsType, listInsuranceBenefit, moneyView, providerId, providerLogoUrl, stackInsurance, tier, tierIdentifier, tncBrief, tncUrl, importantInfos != null ? toListAddonImportantInfo(importantInfos) : null);
    }

    private final List<Benefit> toListBenefit(List<BenefitResult> list) {
        List<BenefitResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toBenefit((BenefitResult) it.next()));
        }
        return arrayList;
    }

    private final Benefit toBenefit(BenefitResult benefitResult) {
        return new Benefit(benefitResult.getIcon(), benefitResult.getTitle(), benefitResult.getSubTitle());
    }

    private final List<InsuranceBenefit> toListInsuranceBenefit(List<InsuranceBenefitResult> list) {
        List<InsuranceBenefitResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toInsuranceBenefit((InsuranceBenefitResult) it.next()));
        }
        return arrayList;
    }

    private final InsuranceBenefit toInsuranceBenefit(InsuranceBenefitResult insuranceBenefitResult) {
        return new InsuranceBenefit(insuranceBenefitResult.getBenefitIcon(), insuranceBenefitResult.getBenefitId(), insuranceBenefitResult.getBenefitSubTitle(), insuranceBenefitResult.getBenefitTitle());
    }

    private final List<AddonImportantInfo> toListAddonImportantInfo(List<AddonImportantInfoResult> list) {
        List<AddonImportantInfoResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toAddonImportantInfo((AddonImportantInfoResult) it.next()));
        }
        return arrayList;
    }

    private final AddonImportantInfo toAddonImportantInfo(AddonImportantInfoResult addonImportantInfoResult) {
        return new AddonImportantInfo(addonImportantInfoResult.getInfoIcon(), addonImportantInfoResult.getInfoValue());
    }
}
