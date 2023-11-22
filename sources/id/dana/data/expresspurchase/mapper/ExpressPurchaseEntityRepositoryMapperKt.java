package id.dana.data.expresspurchase.mapper;

import id.dana.data.expresspurchase.model.ExpressPurchaseConfigResult;
import id.dana.data.expresspurchase.model.ServiceEmasConfigResult;
import id.dana.data.expresspurchase.source.network.pojo.response.GetExpressPurchaseResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.QuickBuyResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.ValidateProductQuickResponse;
import id.dana.data.expresspurchase.source.network.pojo.response.ValidateProductResponse;
import id.dana.domain.expresspurchase.interaction.model.AddonInfo;
import id.dana.domain.expresspurchase.interaction.model.ExpressPurchaseConfig;
import id.dana.domain.expresspurchase.interaction.model.Price;
import id.dana.domain.expresspurchase.interaction.model.QuickBuyGold;
import id.dana.domain.expresspurchase.interaction.model.QuickBuyInsurance;
import id.dana.domain.expresspurchase.interaction.model.ServiceEmasConfig;
import id.dana.domain.expresspurchase.interaction.model.ValidateProduct;
import id.dana.domain.expresspurchase.interaction.model.VoucherColorCode;
import id.dana.domain.expresspurchase.interaction.model.VoucherExpressInfo;
import id.dana.lib.gcontainer.extension.NumberExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0005¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\u000b\u001a\u00020\n*\u00020\t¢\u0006\u0004\b\u000b\u0010\f\u001a\u0011\u0010\u000f\u001a\u00020\u000e*\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0011*\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0011\u0010\u0016\u001a\u00020\u0015*\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0011\u0010\u001a\u001a\u00020\u0019*\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0011\u0010\u001d\u001a\u00020\u001c*\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0011\u0010!\u001a\u00020 *\u00020\u001f¢\u0006\u0004\b!\u0010\"\u001a\u0011\u0010%\u001a\u00020$*\u00020#¢\u0006\u0004\b%\u0010&\u001a\u0011\u0010%\u001a\u00020$*\u00020'¢\u0006\u0004\b%\u0010(\u001a\u0011\u0010+\u001a\u00020**\u00020)¢\u0006\u0004\b+\u0010,\u001a\u0011\u0010/\u001a\u00020.*\u00020-¢\u0006\u0004\b/\u00100\u001a\u0011\u00103\u001a\u000202*\u000201¢\u0006\u0004\b3\u00104"}, d2 = {"Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$Content$ResultConfirmation;", "oldItem", "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content$ResultConfirmation;", "getContentResultConfirmation", "(Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$Content$ResultConfirmation;)Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content$ResultConfirmation;", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse;", "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo;", "toAddonInfo", "(Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse;)Lid/dana/domain/expresspurchase/interaction/model/AddonInfo;", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$Content$Benefit;", "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content$Benefit;", "toBenefit", "(Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$Content$Benefit;)Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content$Benefit;", "Lid/dana/data/expresspurchase/model/ExpressPurchaseConfigResult;", "Lid/dana/domain/expresspurchase/interaction/model/ExpressPurchaseConfig;", "toExpressPurchaseConfig", "(Lid/dana/data/expresspurchase/model/ExpressPurchaseConfigResult;)Lid/dana/domain/expresspurchase/interaction/model/ExpressPurchaseConfig;", "", "toListBenefit", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$PriceEntity;", "Lid/dana/domain/expresspurchase/interaction/model/Price;", "toPrice", "(Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$PriceEntity;)Lid/dana/domain/expresspurchase/interaction/model/Price;", "Lid/dana/data/expresspurchase/source/network/pojo/response/QuickBuyResponse;", "Lid/dana/domain/expresspurchase/interaction/model/QuickBuyGold;", "toQuickBuyGold", "(Lid/dana/data/expresspurchase/source/network/pojo/response/QuickBuyResponse;)Lid/dana/domain/expresspurchase/interaction/model/QuickBuyGold;", "Lid/dana/domain/expresspurchase/interaction/model/QuickBuyInsurance;", "toQuickBuyInsurance", "(Lid/dana/data/expresspurchase/source/network/pojo/response/QuickBuyResponse;)Lid/dana/domain/expresspurchase/interaction/model/QuickBuyInsurance;", "Lid/dana/data/expresspurchase/model/ServiceEmasConfigResult;", "Lid/dana/domain/expresspurchase/interaction/model/ServiceEmasConfig;", "toServiceEmasConfig", "(Lid/dana/data/expresspurchase/model/ServiceEmasConfigResult;)Lid/dana/domain/expresspurchase/interaction/model/ServiceEmasConfig;", "Lid/dana/data/expresspurchase/source/network/pojo/response/ValidateProductQuickResponse;", "Lid/dana/domain/expresspurchase/interaction/model/ValidateProduct;", "toValidateProduct", "(Lid/dana/data/expresspurchase/source/network/pojo/response/ValidateProductQuickResponse;)Lid/dana/domain/expresspurchase/interaction/model/ValidateProduct;", "Lid/dana/data/expresspurchase/source/network/pojo/response/ValidateProductResponse;", "(Lid/dana/data/expresspurchase/source/network/pojo/response/ValidateProductResponse;)Lid/dana/domain/expresspurchase/interaction/model/ValidateProduct;", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$AddonProductInfo$VoucherBundleInfoResponse;", "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$ProductInfo$VoucherBundleInfo;", "toVoucherBundleInfo", "(Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$AddonProductInfo$VoucherBundleInfoResponse;)Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$ProductInfo$VoucherBundleInfo;", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$VoucherColorCodeResponse;", "Lid/dana/domain/expresspurchase/interaction/model/VoucherColorCode;", "toVoucherColorCode", "(Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$VoucherColorCodeResponse;)Lid/dana/domain/expresspurchase/interaction/model/VoucherColorCode;", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$VoucherExpressInfoEntity;", "Lid/dana/domain/expresspurchase/interaction/model/VoucherExpressInfo;", "toVoucherExpressInfo", "(Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse$VoucherExpressInfoEntity;)Lid/dana/domain/expresspurchase/interaction/model/VoucherExpressInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExpressPurchaseEntityRepositoryMapperKt {
    public static final ExpressPurchaseConfig toExpressPurchaseConfig(ExpressPurchaseConfigResult expressPurchaseConfigResult) {
        Intrinsics.checkNotNullParameter(expressPurchaseConfigResult, "");
        return new ExpressPurchaseConfig(NumberExtKt.toSafeInt(expressPurchaseConfigResult.getDismiss(), 0), NumberExtKt.toSafeInt(expressPurchaseConfigResult.getSuccess(), 0));
    }

    public static final ServiceEmasConfig toServiceEmasConfig(ServiceEmasConfigResult serviceEmasConfigResult) {
        Intrinsics.checkNotNullParameter(serviceEmasConfigResult, "");
        return new ServiceEmasConfig(serviceEmasConfigResult.getRedirectUrl(), serviceEmasConfigResult.getClientId(), serviceEmasConfigResult.getScopes());
    }

    public static final Price toPrice(GetExpressPurchaseResponse.PriceEntity priceEntity) {
        Intrinsics.checkNotNullParameter(priceEntity, "");
        return new Price(priceEntity.getAmount(), priceEntity.getCurrency());
    }

    public static final VoucherExpressInfo toVoucherExpressInfo(GetExpressPurchaseResponse.VoucherExpressInfoEntity voucherExpressInfoEntity) {
        Intrinsics.checkNotNullParameter(voucherExpressInfoEntity, "");
        String discountOffRate = voucherExpressInfoEntity.getDiscountOffRate();
        String str = discountOffRate == null ? "" : discountOffRate;
        GetExpressPurchaseResponse.PriceEntity displayStrikethroughPrice = voucherExpressInfoEntity.getDisplayStrikethroughPrice();
        Price price = displayStrikethroughPrice != null ? toPrice(displayStrikethroughPrice) : null;
        GetExpressPurchaseResponse.PriceEntity displayVoucherPrice = voucherExpressInfoEntity.getDisplayVoucherPrice();
        Price price2 = displayVoucherPrice != null ? toPrice(displayVoucherPrice) : null;
        GetExpressPurchaseResponse.PriceEntity displayVoucherValue = voucherExpressInfoEntity.getDisplayVoucherValue();
        Price price3 = displayVoucherValue != null ? toPrice(displayVoucherValue) : null;
        String voucherBackGround = voucherExpressInfoEntity.getVoucherBackGround();
        String voucherIcon = voucherExpressInfoEntity.getVoucherIcon();
        String voucherName = voucherExpressInfoEntity.getVoucherName();
        String minTransaction = voucherExpressInfoEntity.getMinTransaction();
        String validityPeriod = voucherExpressInfoEntity.getValidityPeriod();
        GetExpressPurchaseResponse.VoucherColorCodeResponse colorCode = voucherExpressInfoEntity.getColorCode();
        return new VoucherExpressInfo(str, price, price2, price3, voucherBackGround, voucherIcon, voucherName, minTransaction, validityPeriod, colorCode != null ? toVoucherColorCode(colorCode) : null);
    }

    public static final VoucherColorCode toVoucherColorCode(GetExpressPurchaseResponse.VoucherColorCodeResponse voucherColorCodeResponse) {
        Intrinsics.checkNotNullParameter(voucherColorCodeResponse, "");
        return new VoucherColorCode(voucherColorCodeResponse.getFontColorCode(), voucherColorCodeResponse.getBackgroundColorCode());
    }

    public static final AddonInfo.ProductInfo.VoucherBundleInfo toVoucherBundleInfo(GetExpressPurchaseResponse.AddonProductInfo.VoucherBundleInfoResponse voucherBundleInfoResponse) {
        Intrinsics.checkNotNullParameter(voucherBundleInfoResponse, "");
        return new AddonInfo.ProductInfo.VoucherBundleInfo(voucherBundleInfoResponse.getMultiMerchant());
    }

    public static final AddonInfo toAddonInfo(GetExpressPurchaseResponse getExpressPurchaseResponse) {
        Intrinsics.checkNotNullParameter(getExpressPurchaseResponse, "");
        AddonInfo.Content.ResultConfirmation contentResultConfirmation = getContentResultConfirmation(getExpressPurchaseResponse.getContent().getOnBalanceNotEnough());
        AddonInfo.Content.ResultConfirmation contentResultConfirmation2 = getContentResultConfirmation(getExpressPurchaseResponse.getContent().getOnFailed());
        AddonInfo.Content.ResultConfirmation contentResultConfirmation3 = getContentResultConfirmation(getExpressPurchaseResponse.getContent().getOnPending());
        AddonInfo.Content.ResultConfirmation contentResultConfirmation4 = getContentResultConfirmation(getExpressPurchaseResponse.getContent().getOnSuccess());
        GetExpressPurchaseResponse.Content content = getExpressPurchaseResponse.getContent();
        String imgUrl = content.getImgUrl();
        String str = imgUrl == null ? "" : imgUrl;
        String title = content.getTitle();
        String str2 = title == null ? "" : title;
        String subTitle = content.getSubTitle();
        String str3 = subTitle == null ? "" : subTitle;
        List<AddonInfo.Content.Benefit> listBenefit = toListBenefit(content.getBenefits());
        String supervision = content.getSupervision();
        String str4 = supervision == null ? "" : supervision;
        String benefitDescription = content.getBenefitDescription();
        String str5 = benefitDescription == null ? "" : benefitDescription;
        String tncUrl = content.getTncUrl();
        String str6 = tncUrl == null ? "" : tncUrl;
        String purchaseInformation = content.getPurchaseInformation();
        String str7 = purchaseInformation == null ? "" : purchaseInformation;
        String buyButtonLabel = content.getBuyButtonLabel();
        String str8 = buyButtonLabel == null ? "" : buyButtonLabel;
        String buyButtonRedirectionUrl = content.getBuyButtonRedirectionUrl();
        String str9 = buyButtonRedirectionUrl == null ? "" : buyButtonRedirectionUrl;
        String tncContent = content.getTncContent();
        AddonInfo.Content content2 = new AddonInfo.Content(str, str2, str3, listBenefit, str4, str5, str6, str7, str8, str9, contentResultConfirmation4, contentResultConfirmation3, contentResultConfirmation2, contentResultConfirmation, tncContent == null ? "" : tncContent);
        GetExpressPurchaseResponse.AddonProductInfo.MultiCurrencyMoney goodsPrice = getExpressPurchaseResponse.getProductInfo().getGoodsPrice();
        AddonInfo.ProductInfo.GoodsPrice goodsPrice2 = new AddonInfo.ProductInfo.GoodsPrice(goodsPrice.getAmount(), String.valueOf(goodsPrice.getCent()), String.valueOf(goodsPrice.getCentFactor()), goodsPrice.getCurrency(), goodsPrice.getCurrencyCode(), goodsPrice.getCurrencyValue());
        GetExpressPurchaseResponse.AddonProductInfo productInfo = getExpressPurchaseResponse.getProductInfo();
        String goodsTitle = productInfo.getGoodsTitle();
        String str10 = goodsTitle == null ? "" : goodsTitle;
        String goodsDescription = productInfo.getGoodsDescription();
        String str11 = goodsDescription == null ? "" : goodsDescription;
        String goodsType = productInfo.getGoodsType();
        String str12 = goodsType == null ? "" : goodsType;
        String aggregatorId = productInfo.getAggregatorId();
        String str13 = aggregatorId == null ? "" : aggregatorId;
        String aggregatorGoodsId = productInfo.getAggregatorGoodsId();
        String str14 = aggregatorGoodsId == null ? "" : aggregatorGoodsId;
        String finType = productInfo.getFinType();
        String str15 = finType == null ? "" : finType;
        String merchantId = productInfo.getMerchantId();
        String str16 = merchantId == null ? "" : merchantId;
        String merchantName = productInfo.getMerchantName();
        String str17 = merchantName == null ? "" : merchantName;
        String providerName = productInfo.getProviderName();
        String str18 = providerName == null ? "" : providerName;
        String providerCategory = productInfo.getProviderCategory();
        String str19 = providerCategory == null ? "" : providerCategory;
        List<String> validationTypes = productInfo.getValidationTypes();
        if (validationTypes == null) {
            validationTypes = CollectionsKt.emptyList();
        }
        List<String> list = validationTypes;
        Map<String, Object> validationInfo = productInfo.getValidationInfo();
        if (validationInfo == null) {
            validationInfo = MapsKt.emptyMap();
        }
        Map<String, Object> map = validationInfo;
        String type = productInfo.getType();
        String str20 = type == null ? "" : type;
        String refId = productInfo.getRefId();
        String str21 = refId == null ? "" : refId;
        GetExpressPurchaseResponse.VoucherExpressInfoEntity voucherInfo = productInfo.getVoucherInfo();
        VoucherExpressInfo voucherExpressInfo = voucherInfo != null ? toVoucherExpressInfo(voucherInfo) : null;
        Map<String, String> extendInfo = productInfo.getExtendInfo();
        Boolean isOnlineMerchant = productInfo.getIsOnlineMerchant();
        boolean booleanValue = isOnlineMerchant != null ? isOnlineMerchant.booleanValue() : false;
        GetExpressPurchaseResponse.AddonProductInfo.VoucherBundleInfoResponse voucherBundleInfo = productInfo.getVoucherBundleInfo();
        AddonInfo.ProductInfo.VoucherBundleInfo voucherBundleInfo2 = voucherBundleInfo != null ? toVoucherBundleInfo(voucherBundleInfo) : null;
        String aggregatorName = productInfo.getAggregatorName();
        return new AddonInfo(getExpressPurchaseResponse.getAddonType(), getExpressPurchaseResponse.getGoodsId(), getExpressPurchaseResponse.getProductInfo().getTemplateType(), new AddonInfo.ProductInfo(str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, goodsPrice2, list, map, str20, str21, voucherExpressInfo, extendInfo, booleanValue, voucherBundleInfo2, aggregatorName == null ? "" : aggregatorName, productInfo.getTotalDiscountValue()), content2, null, 32, null);
    }

    public static final QuickBuyInsurance toQuickBuyInsurance(QuickBuyResponse quickBuyResponse) {
        Intrinsics.checkNotNullParameter(quickBuyResponse, "");
        return new QuickBuyInsurance(quickBuyResponse.getBillId(), quickBuyResponse.getAcquirementId(), quickBuyResponse.errorCode);
    }

    public static final QuickBuyGold toQuickBuyGold(QuickBuyResponse quickBuyResponse) {
        Intrinsics.checkNotNullParameter(quickBuyResponse, "");
        return new QuickBuyGold(null, quickBuyResponse.getBillId(), quickBuyResponse.getAcquirementId(), quickBuyResponse.errorCode, 1, null);
    }

    public static final ValidateProduct toValidateProduct(ValidateProductResponse validateProductResponse) {
        Intrinsics.checkNotNullParameter(validateProductResponse, "");
        boolean z = validateProductResponse.success;
        String aggregatorGoodsId = validateProductResponse.getAggregatorGoodsId();
        Map<String, String> map = validateProductResponse.extendInfo;
        Intrinsics.checkNotNullExpressionValue(map, "");
        return new ValidateProduct(z, aggregatorGoodsId, map);
    }

    public static final ValidateProduct toValidateProduct(ValidateProductQuickResponse validateProductQuickResponse) {
        Intrinsics.checkNotNullParameter(validateProductQuickResponse, "");
        return new ValidateProduct(validateProductQuickResponse.success, "", MapsKt.emptyMap());
    }

    private static final AddonInfo.Content.ResultConfirmation getContentResultConfirmation(GetExpressPurchaseResponse.Content.ResultConfirmation resultConfirmation) {
        if (resultConfirmation != null) {
            String imgUrl = resultConfirmation.getImgUrl();
            String infoTitle = resultConfirmation.getInfoTitle();
            String infoLabel = resultConfirmation.getInfoLabel();
            String redirectUrl = resultConfirmation.getRedirectUrl();
            if (redirectUrl == null) {
                redirectUrl = "";
            }
            return new AddonInfo.Content.ResultConfirmation(imgUrl, infoTitle, infoLabel, redirectUrl, resultConfirmation.getActionLabel());
        }
        return null;
    }

    public static final AddonInfo.Content.Benefit toBenefit(GetExpressPurchaseResponse.Content.Benefit benefit) {
        Intrinsics.checkNotNullParameter(benefit, "");
        String imgUrl = benefit.getImgUrl();
        if (imgUrl == null) {
            imgUrl = "";
        }
        String title = benefit.getTitle();
        if (title == null) {
            title = "";
        }
        String description = benefit.getDescription();
        return new AddonInfo.Content.Benefit(imgUrl, title, description != null ? description : "");
    }

    public static final List<AddonInfo.Content.Benefit> toListBenefit(List<GetExpressPurchaseResponse.Content.Benefit> list) {
        if (list != null) {
            List<GetExpressPurchaseResponse.Content.Benefit> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(toBenefit((GetExpressPurchaseResponse.Content.Benefit) it.next()));
            }
            return arrayList;
        }
        return CollectionsKt.emptyList();
    }
}
