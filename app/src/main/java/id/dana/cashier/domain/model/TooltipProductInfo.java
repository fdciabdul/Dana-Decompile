package id.dana.cashier.domain.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.domain.nearbyme.model.MoneyView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001Bñ\u0001\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0010\u0012\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0007\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010,\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010.\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\b\u00100\u001a\u0004\u0018\u00010\u0002\u0012\b\u00101\u001a\u0004\u0018\u00010\u0010\u0012\b\u00102\u001a\u0004\u0018\u00010\u0002\u0012\b\u00103\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007\u0012\b\u00105\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0007¢\u0006\u0004\bY\u0010ZJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0018\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0015\u0010\nJ\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0019\u0010\nJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0012J\u0018\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001d\u0010\nJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0012J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0004J\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0004J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004J¤\u0002\u00107\u001a\u00020\u00002\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00072\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u00104\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b7\u00108J\u001a\u0010:\u001a\u00020\u00102\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b:\u0010;J\u0010\u0010=\u001a\u00020<HÖ\u0001¢\u0006\u0004\b=\u0010>J\u0010\u0010?\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b?\u0010\u0004R\u0019\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\"\u0010@\u001a\u0004\bA\u0010\u0004R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010@\u001a\u0004\bB\u0010\u0004R\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010@\u001a\u0004\bC\u0010\u0004R\u001c\u0010%\u001a\u0004\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010D\u001a\u0004\bE\u0010\u0012R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010F\u001a\u0004\bG\u0010\nR\u001c\u0010'\u001a\u0004\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010D\u001a\u0004\bH\u0010\u0012R\u001c\u0010(\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010@\u001a\u0004\bI\u0010\u0004R\u001c\u0010)\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010@\u001a\u0004\bJ\u0010\u0004R\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010@\u001a\u0004\bK\u0010\u0004R\u001c\u0010+\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010@\u001a\u0004\bL\u0010\u0004R\u001c\u0010,\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010@\u001a\u0004\bM\u0010\u0004R\"\u00106\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010F\u001a\u0004\bN\u0010\nR\"\u0010-\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010F\u001a\u0004\bO\u0010\nR\u001c\u0010.\u001a\u0004\u0018\u00010\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010P\u001a\u0004\bQ\u0010\rR\u001c\u0010/\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010@\u001a\u0004\bR\u0010\u0004R\u001c\u00100\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010@\u001a\u0004\bS\u0010\u0004R\u001c\u00101\u001a\u0004\u0018\u00010\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010D\u001a\u0004\bT\u0010\u0012R\u001c\u00102\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010@\u001a\u0004\bU\u0010\u0004R\u001c\u00103\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010@\u001a\u0004\bV\u0010\u0004R\"\u00104\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010F\u001a\u0004\bW\u0010\nR\u001c\u00105\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010@\u001a\u0004\bX\u0010\u0004"}, d2 = {"Lid/dana/cashier/domain/model/TooltipProductInfo;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "", "Lid/dana/cashier/domain/model/InsuranceBenefit;", "component12", "()Ljava/util/List;", "Lid/dana/domain/nearbyme/model/MoneyView;", "component13", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component14", "component15", "", "component16", "()Ljava/lang/Boolean;", "component17", "component18", "component19", "component2", "component20", "Lid/dana/cashier/domain/model/AddonImportantInfo;", "component21", "component3", "component4", "Lid/dana/cashier/domain/model/Benefit;", "component5", "component6", "component7", "component8", "component9", "aggregatorGoodsId", "aggregatorId", "aggregatorLogoUrl", "available", "benefits", "expressGoods", "finType", "goodsDescription", "goodsId", "goodsTitle", "goodsType", "insuranceBenefits", FirebaseAnalytics.Param.PRICE, "providerId", "providerLogoUrl", "stackInsurance", "tier", "tierIdentifier", "tncBrief", "tncUrl", "importantInfos", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)Lid/dana/cashier/domain/model/TooltipProductInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAggregatorGoodsId", "getAggregatorId", "getAggregatorLogoUrl", "Ljava/lang/Boolean;", "getAvailable", "Ljava/util/List;", "getBenefits", "getExpressGoods", "getFinType", "getGoodsDescription", "getGoodsId", "getGoodsTitle", "getGoodsType", "getImportantInfos", "getInsuranceBenefits", "Lid/dana/domain/nearbyme/model/MoneyView;", "getPrice", "getProviderId", "getProviderLogoUrl", "getStackInsurance", "getTier", "getTierIdentifier", "getTncBrief", "getTncUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TooltipProductInfo {
    private final String aggregatorGoodsId;
    private final String aggregatorId;
    private final String aggregatorLogoUrl;
    private final Boolean available;
    private final List<Benefit> benefits;
    private final Boolean expressGoods;
    private final String finType;
    private final String goodsDescription;
    private final String goodsId;
    private final String goodsTitle;
    private final String goodsType;
    private final List<AddonImportantInfo> importantInfos;
    private final List<InsuranceBenefit> insuranceBenefits;
    private final MoneyView price;
    private final String providerId;
    private final String providerLogoUrl;
    private final Boolean stackInsurance;
    private final String tier;
    private final String tierIdentifier;
    private final List<String> tncBrief;
    private final String tncUrl;

    /* renamed from: component1  reason: from getter */
    public final String getAggregatorGoodsId() {
        return this.aggregatorGoodsId;
    }

    /* renamed from: component10  reason: from getter */
    public final String getGoodsTitle() {
        return this.goodsTitle;
    }

    /* renamed from: component11  reason: from getter */
    public final String getGoodsType() {
        return this.goodsType;
    }

    public final List<InsuranceBenefit> component12() {
        return this.insuranceBenefits;
    }

    /* renamed from: component13  reason: from getter */
    public final MoneyView getPrice() {
        return this.price;
    }

    /* renamed from: component14  reason: from getter */
    public final String getProviderId() {
        return this.providerId;
    }

    /* renamed from: component15  reason: from getter */
    public final String getProviderLogoUrl() {
        return this.providerLogoUrl;
    }

    /* renamed from: component16  reason: from getter */
    public final Boolean getStackInsurance() {
        return this.stackInsurance;
    }

    /* renamed from: component17  reason: from getter */
    public final String getTier() {
        return this.tier;
    }

    /* renamed from: component18  reason: from getter */
    public final String getTierIdentifier() {
        return this.tierIdentifier;
    }

    public final List<String> component19() {
        return this.tncBrief;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAggregatorId() {
        return this.aggregatorId;
    }

    /* renamed from: component20  reason: from getter */
    public final String getTncUrl() {
        return this.tncUrl;
    }

    public final List<AddonImportantInfo> component21() {
        return this.importantInfos;
    }

    /* renamed from: component3  reason: from getter */
    public final String getAggregatorLogoUrl() {
        return this.aggregatorLogoUrl;
    }

    /* renamed from: component4  reason: from getter */
    public final Boolean getAvailable() {
        return this.available;
    }

    public final List<Benefit> component5() {
        return this.benefits;
    }

    /* renamed from: component6  reason: from getter */
    public final Boolean getExpressGoods() {
        return this.expressGoods;
    }

    /* renamed from: component7  reason: from getter */
    public final String getFinType() {
        return this.finType;
    }

    /* renamed from: component8  reason: from getter */
    public final String getGoodsDescription() {
        return this.goodsDescription;
    }

    /* renamed from: component9  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    public final TooltipProductInfo copy(String aggregatorGoodsId, String aggregatorId, String aggregatorLogoUrl, Boolean available, List<Benefit> benefits, Boolean expressGoods, String finType, String goodsDescription, String goodsId, String goodsTitle, String goodsType, List<InsuranceBenefit> insuranceBenefits, MoneyView price, String providerId, String providerLogoUrl, Boolean stackInsurance, String tier, String tierIdentifier, List<String> tncBrief, String tncUrl, List<AddonImportantInfo> importantInfos) {
        return new TooltipProductInfo(aggregatorGoodsId, aggregatorId, aggregatorLogoUrl, available, benefits, expressGoods, finType, goodsDescription, goodsId, goodsTitle, goodsType, insuranceBenefits, price, providerId, providerLogoUrl, stackInsurance, tier, tierIdentifier, tncBrief, tncUrl, importantInfos);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof TooltipProductInfo) {
            TooltipProductInfo tooltipProductInfo = (TooltipProductInfo) other;
            return Intrinsics.areEqual(this.aggregatorGoodsId, tooltipProductInfo.aggregatorGoodsId) && Intrinsics.areEqual(this.aggregatorId, tooltipProductInfo.aggregatorId) && Intrinsics.areEqual(this.aggregatorLogoUrl, tooltipProductInfo.aggregatorLogoUrl) && Intrinsics.areEqual(this.available, tooltipProductInfo.available) && Intrinsics.areEqual(this.benefits, tooltipProductInfo.benefits) && Intrinsics.areEqual(this.expressGoods, tooltipProductInfo.expressGoods) && Intrinsics.areEqual(this.finType, tooltipProductInfo.finType) && Intrinsics.areEqual(this.goodsDescription, tooltipProductInfo.goodsDescription) && Intrinsics.areEqual(this.goodsId, tooltipProductInfo.goodsId) && Intrinsics.areEqual(this.goodsTitle, tooltipProductInfo.goodsTitle) && Intrinsics.areEqual(this.goodsType, tooltipProductInfo.goodsType) && Intrinsics.areEqual(this.insuranceBenefits, tooltipProductInfo.insuranceBenefits) && Intrinsics.areEqual(this.price, tooltipProductInfo.price) && Intrinsics.areEqual(this.providerId, tooltipProductInfo.providerId) && Intrinsics.areEqual(this.providerLogoUrl, tooltipProductInfo.providerLogoUrl) && Intrinsics.areEqual(this.stackInsurance, tooltipProductInfo.stackInsurance) && Intrinsics.areEqual(this.tier, tooltipProductInfo.tier) && Intrinsics.areEqual(this.tierIdentifier, tooltipProductInfo.tierIdentifier) && Intrinsics.areEqual(this.tncBrief, tooltipProductInfo.tncBrief) && Intrinsics.areEqual(this.tncUrl, tooltipProductInfo.tncUrl) && Intrinsics.areEqual(this.importantInfos, tooltipProductInfo.importantInfos);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.aggregatorGoodsId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.aggregatorId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.aggregatorLogoUrl;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        Boolean bool = this.available;
        int hashCode4 = bool == null ? 0 : bool.hashCode();
        List<Benefit> list = this.benefits;
        int hashCode5 = list == null ? 0 : list.hashCode();
        Boolean bool2 = this.expressGoods;
        int hashCode6 = bool2 == null ? 0 : bool2.hashCode();
        String str4 = this.finType;
        int hashCode7 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.goodsDescription;
        int hashCode8 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.goodsId;
        int hashCode9 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.goodsTitle;
        int hashCode10 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.goodsType;
        int hashCode11 = str8 == null ? 0 : str8.hashCode();
        List<InsuranceBenefit> list2 = this.insuranceBenefits;
        int hashCode12 = list2 == null ? 0 : list2.hashCode();
        MoneyView moneyView = this.price;
        int hashCode13 = moneyView == null ? 0 : moneyView.hashCode();
        String str9 = this.providerId;
        int hashCode14 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.providerLogoUrl;
        int hashCode15 = str10 == null ? 0 : str10.hashCode();
        Boolean bool3 = this.stackInsurance;
        int hashCode16 = bool3 == null ? 0 : bool3.hashCode();
        String str11 = this.tier;
        int hashCode17 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.tierIdentifier;
        int hashCode18 = str12 == null ? 0 : str12.hashCode();
        List<String> list3 = this.tncBrief;
        int hashCode19 = list3 == null ? 0 : list3.hashCode();
        String str13 = this.tncUrl;
        int hashCode20 = str13 == null ? 0 : str13.hashCode();
        List<AddonImportantInfo> list4 = this.importantInfos;
        return (((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + (list4 != null ? list4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TooltipProductInfo(aggregatorGoodsId=");
        sb.append(this.aggregatorGoodsId);
        sb.append(", aggregatorId=");
        sb.append(this.aggregatorId);
        sb.append(", aggregatorLogoUrl=");
        sb.append(this.aggregatorLogoUrl);
        sb.append(", available=");
        sb.append(this.available);
        sb.append(", benefits=");
        sb.append(this.benefits);
        sb.append(", expressGoods=");
        sb.append(this.expressGoods);
        sb.append(", finType=");
        sb.append(this.finType);
        sb.append(", goodsDescription=");
        sb.append(this.goodsDescription);
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", goodsTitle=");
        sb.append(this.goodsTitle);
        sb.append(", goodsType=");
        sb.append(this.goodsType);
        sb.append(", insuranceBenefits=");
        sb.append(this.insuranceBenefits);
        sb.append(", price=");
        sb.append(this.price);
        sb.append(", providerId=");
        sb.append(this.providerId);
        sb.append(", providerLogoUrl=");
        sb.append(this.providerLogoUrl);
        sb.append(", stackInsurance=");
        sb.append(this.stackInsurance);
        sb.append(", tier=");
        sb.append(this.tier);
        sb.append(", tierIdentifier=");
        sb.append(this.tierIdentifier);
        sb.append(", tncBrief=");
        sb.append(this.tncBrief);
        sb.append(", tncUrl=");
        sb.append(this.tncUrl);
        sb.append(", importantInfos=");
        sb.append(this.importantInfos);
        sb.append(')');
        return sb.toString();
    }

    public TooltipProductInfo(String str, String str2, String str3, Boolean bool, List<Benefit> list, Boolean bool2, String str4, String str5, String str6, String str7, String str8, List<InsuranceBenefit> list2, MoneyView moneyView, String str9, String str10, Boolean bool3, String str11, String str12, List<String> list3, String str13, List<AddonImportantInfo> list4) {
        this.aggregatorGoodsId = str;
        this.aggregatorId = str2;
        this.aggregatorLogoUrl = str3;
        this.available = bool;
        this.benefits = list;
        this.expressGoods = bool2;
        this.finType = str4;
        this.goodsDescription = str5;
        this.goodsId = str6;
        this.goodsTitle = str7;
        this.goodsType = str8;
        this.insuranceBenefits = list2;
        this.price = moneyView;
        this.providerId = str9;
        this.providerLogoUrl = str10;
        this.stackInsurance = bool3;
        this.tier = str11;
        this.tierIdentifier = str12;
        this.tncBrief = list3;
        this.tncUrl = str13;
        this.importantInfos = list4;
    }

    @JvmName(name = "getAggregatorGoodsId")
    public final String getAggregatorGoodsId() {
        return this.aggregatorGoodsId;
    }

    @JvmName(name = "getAggregatorId")
    public final String getAggregatorId() {
        return this.aggregatorId;
    }

    @JvmName(name = "getAggregatorLogoUrl")
    public final String getAggregatorLogoUrl() {
        return this.aggregatorLogoUrl;
    }

    @JvmName(name = "getAvailable")
    public final Boolean getAvailable() {
        return this.available;
    }

    @JvmName(name = "getBenefits")
    public final List<Benefit> getBenefits() {
        return this.benefits;
    }

    @JvmName(name = "getExpressGoods")
    public final Boolean getExpressGoods() {
        return this.expressGoods;
    }

    @JvmName(name = "getFinType")
    public final String getFinType() {
        return this.finType;
    }

    @JvmName(name = "getGoodsDescription")
    public final String getGoodsDescription() {
        return this.goodsDescription;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getGoodsTitle")
    public final String getGoodsTitle() {
        return this.goodsTitle;
    }

    @JvmName(name = "getGoodsType")
    public final String getGoodsType() {
        return this.goodsType;
    }

    @JvmName(name = "getInsuranceBenefits")
    public final List<InsuranceBenefit> getInsuranceBenefits() {
        return this.insuranceBenefits;
    }

    @JvmName(name = "getPrice")
    public final MoneyView getPrice() {
        return this.price;
    }

    @JvmName(name = "getProviderId")
    public final String getProviderId() {
        return this.providerId;
    }

    @JvmName(name = "getProviderLogoUrl")
    public final String getProviderLogoUrl() {
        return this.providerLogoUrl;
    }

    @JvmName(name = "getStackInsurance")
    public final Boolean getStackInsurance() {
        return this.stackInsurance;
    }

    @JvmName(name = "getTier")
    public final String getTier() {
        return this.tier;
    }

    @JvmName(name = "getTierIdentifier")
    public final String getTierIdentifier() {
        return this.tierIdentifier;
    }

    @JvmName(name = "getTncBrief")
    public final List<String> getTncBrief() {
        return this.tncBrief;
    }

    @JvmName(name = "getTncUrl")
    public final String getTncUrl() {
        return this.tncUrl;
    }

    @JvmName(name = "getImportantInfos")
    public final List<AddonImportantInfo> getImportantInfos() {
        return this.importantInfos;
    }
}
