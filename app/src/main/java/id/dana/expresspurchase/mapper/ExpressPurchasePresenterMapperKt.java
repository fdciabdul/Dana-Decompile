package id.dana.expresspurchase.mapper;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import id.dana.R;
import id.dana.core.ui.util.LocaleUtil;
import id.dana.domain.expresspurchase.interaction.model.AddonInfo;
import id.dana.domain.expresspurchase.interaction.model.PaylaterOffer;
import id.dana.domain.expresspurchase.interaction.model.Price;
import id.dana.domain.expresspurchase.interaction.model.VoucherColorCode;
import id.dana.domain.expresspurchase.interaction.model.VoucherExpressInfo;
import id.dana.expresspurchase.model.ExpressPurchaseModel;
import id.dana.expresspurchase.model.PriceModel;
import id.dana.expresspurchase.model.VoucherExpressInfoModel;
import id.dana.extension.lang.StringExtKt;
import id.dana.lib.gcontainer.extension.NumberExtKt;
import id.dana.utils.NumberFormatterUtil;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aC\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000b\u001a9\u0010\r\u001a\u00020\t*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\r\u0010\u000e\u001a\u0019\u0010\n\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\n\u0010\u0010\u001a\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0012*\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/AddonInfo;", "Landroid/content/Context;", "p0", "", "p1", "p2", "p3", "p4", "p5", "Lid/dana/expresspurchase/model/ExpressPurchaseModel;", "getAuthRequestContext", "(Lid/dana/domain/expresspurchase/interaction/model/AddonInfo;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/expresspurchase/model/ExpressPurchaseModel;", "Lid/dana/domain/expresspurchase/interaction/model/PaylaterOffer;", "MyBillsEntityDataFactory", "(Lid/dana/domain/expresspurchase/interaction/model/PaylaterOffer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/expresspurchase/model/ExpressPurchaseModel;", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$OfferContent;", "(Lid/dana/domain/expresspurchase/interaction/model/AddonInfo;Landroid/content/Context;)Lid/dana/expresspurchase/model/ExpressPurchaseModel$OfferContent;", "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content$ResultConfirmation;", "Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/domain/expresspurchase/interaction/model/AddonInfo$Content$ResultConfirmation;)Lid/dana/expresspurchase/model/ExpressPurchaseModel$PaymentResultContent;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExpressPurchasePresenterMapperKt {
    public static final ExpressPurchaseModel getAuthRequestContext(AddonInfo addonInfo, Context context, String str, String str2, String str3, String str4, String str5) {
        PriceModel priceModel;
        PriceModel priceModel2;
        PriceModel priceModel3;
        Intrinsics.checkNotNullParameter(addonInfo, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        String templateType = addonInfo.getTemplateType();
        VoucherExpressInfoModel voucherExpressInfoModel = null;
        VoucherExpressInfoModel.VoucherColorCodeModel voucherColorCodeModel = null;
        switch (templateType.hashCode()) {
            case -1991247790:
                if (templateType.equals("DEALS_TEMPLATE")) {
                    String addonType = addonInfo.getAddonType();
                    String goodsId = addonInfo.getGoodsId();
                    String templateType2 = addonInfo.getTemplateType();
                    String aggregatorGoodsId = addonInfo.getProductInfo().getAggregatorGoodsId();
                    ExpressPurchaseModel.OfferContent authRequestContext = getAuthRequestContext(addonInfo, context);
                    ExpressPurchaseModel.PaymentResultContent BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(addonInfo.getContent().getOnSuccess());
                    ExpressPurchaseModel.PaymentResultContent BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(addonInfo.getContent().getOnPending());
                    ExpressPurchaseModel.PaymentResultContent BuiltInFictitiousFunctionClassFactory3 = BuiltInFictitiousFunctionClassFactory(addonInfo.getContent().getOnFailed());
                    ExpressPurchaseModel.PaymentResultContent BuiltInFictitiousFunctionClassFactory4 = BuiltInFictitiousFunctionClassFactory(addonInfo.getContent().getOnBalanceNotEnough());
                    ExpressPurchaseModel.PreviousPurchasement previousPurchasement = new ExpressPurchaseModel.PreviousPurchasement(str, str2, str3, str4, str5);
                    VoucherExpressInfo voucherInfo = addonInfo.getProductInfo().getVoucherInfo();
                    if (voucherInfo != null) {
                        Intrinsics.checkNotNullParameter(voucherInfo, "");
                        Price displayStrikethroughPrice = voucherInfo.getDisplayStrikethroughPrice();
                        if (displayStrikethroughPrice != null) {
                            Intrinsics.checkNotNullParameter(displayStrikethroughPrice, "");
                            priceModel = new PriceModel(displayStrikethroughPrice.getAmount(), displayStrikethroughPrice.getCurrency());
                        } else {
                            priceModel = null;
                        }
                        Price displayVoucherPrice = voucherInfo.getDisplayVoucherPrice();
                        if (displayVoucherPrice != null) {
                            Intrinsics.checkNotNullParameter(displayVoucherPrice, "");
                            priceModel2 = new PriceModel(displayVoucherPrice.getAmount(), displayVoucherPrice.getCurrency());
                        } else {
                            priceModel2 = null;
                        }
                        Price displayVoucherValue = voucherInfo.getDisplayVoucherValue();
                        if (displayVoucherValue != null) {
                            Intrinsics.checkNotNullParameter(displayVoucherValue, "");
                            priceModel3 = new PriceModel(displayVoucherValue.getAmount(), displayVoucherValue.getCurrency());
                        } else {
                            priceModel3 = null;
                        }
                        String voucherBackGround = voucherInfo.getVoucherBackGround();
                        String voucherIcon = voucherInfo.getVoucherIcon();
                        String voucherName = voucherInfo.getVoucherName();
                        String minTransaction = voucherInfo.getMinTransaction();
                        String validityPeriod = voucherInfo.getValidityPeriod();
                        VoucherColorCode colorCode = voucherInfo.getColorCode();
                        if (colorCode != null) {
                            Intrinsics.checkNotNullParameter(colorCode, "");
                            voucherColorCodeModel = new VoucherExpressInfoModel.VoucherColorCodeModel(colorCode.getFontColorCode(), colorCode.getBackgroundColorCode());
                        }
                        voucherExpressInfoModel = new VoucherExpressInfoModel(priceModel, priceModel2, priceModel3, voucherBackGround, voucherIcon, voucherName, minTransaction, validityPeriod, voucherColorCodeModel);
                    }
                    String goodsTitle = addonInfo.getProductInfo().getGoodsTitle();
                    String MyBillsEntityDataFactory = NumberFormatterUtil.MyBillsEntityDataFactory(LocaleUtil.BuiltInFictitiousFunctionClassFactory(), addonInfo.getProductInfo().getGoodsPrice().getAmount());
                    String currency = addonInfo.getProductInfo().getGoodsPrice().getCurrency();
                    String currencyCode = addonInfo.getProductInfo().getGoodsPrice().getCurrencyCode();
                    String goodsDescription = addonInfo.getProductInfo().getGoodsDescription();
                    String goodsType = addonInfo.getProductInfo().getGoodsType();
                    String aggregatorId = addonInfo.getProductInfo().getAggregatorId();
                    String merchantId = addonInfo.getProductInfo().getMerchantId();
                    String merchantName = addonInfo.getProductInfo().getMerchantName();
                    String providerName = addonInfo.getProductInfo().getProviderName();
                    String providerCategory = addonInfo.getProductInfo().getProviderCategory();
                    String type = addonInfo.getProductInfo().getType();
                    String refId = addonInfo.getProductInfo().getRefId();
                    Map<String, String> extendInfo = addonInfo.getProductInfo().getExtendInfo();
                    boolean isOnlineMerchant = addonInfo.getProductInfo().getIsOnlineMerchant();
                    Double totalDiscountValue = addonInfo.getProductInfo().getTotalDiscountValue();
                    Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
                    return new ExpressPurchaseModel.Deals(addonType, goodsId, templateType2, authRequestContext, goodsTitle, goodsDescription, goodsType, aggregatorId, aggregatorGoodsId, merchantId, merchantName, providerName, providerCategory, MyBillsEntityDataFactory, currencyCode, currency, voucherExpressInfoModel, BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2, BuiltInFictitiousFunctionClassFactory3, BuiltInFictitiousFunctionClassFactory4, previousPurchasement, type, refId, extendInfo, isOnlineMerchant, totalDiscountValue);
                }
                return null;
            case -1732759620:
                if (!templateType.equals("BUNDLED_INSURANCE_TEMPLATE")) {
                    return null;
                }
                break;
            case -1019392421:
                if (templateType.equals("EMAS_QUICKBUY_TEMPLATE")) {
                    return new ExpressPurchaseModel.Gold(addonInfo.getAddonType(), addonInfo.getGoodsId(), addonInfo.getTemplateType(), addonInfo.getProductInfo().getAggregatorGoodsId(), addonInfo.getProductInfo().getValidationTypes(), addonInfo.getProductInfo().getValidationInfo(), null, getAuthRequestContext(addonInfo, context), BuiltInFictitiousFunctionClassFactory(addonInfo.getContent().getOnSuccess()), BuiltInFictitiousFunctionClassFactory(addonInfo.getContent().getOnPending()), BuiltInFictitiousFunctionClassFactory(addonInfo.getContent().getOnFailed()), BuiltInFictitiousFunctionClassFactory(addonInfo.getContent().getOnBalanceNotEnough()), new ExpressPurchaseModel.PreviousPurchasement(str, str2, str3, str4, str5), addonInfo.getExtendInfo(), StringsKt.equals(addonInfo.getProductInfo().getAggregatorName(), "Treasury", true) ? "Treasury" : "Pluang", 64, null);
                }
                return null;
            case 1355934361:
                if (!templateType.equals("STANDALONE_INSURANCE_TEMPLATE")) {
                    return null;
                }
                break;
            default:
                return null;
        }
        return new ExpressPurchaseModel.Insurance(addonInfo.getAddonType(), addonInfo.getGoodsId(), addonInfo.getTemplateType(), addonInfo.getProductInfo().getAggregatorGoodsId(), null, getAuthRequestContext(addonInfo, context), BuiltInFictitiousFunctionClassFactory(addonInfo.getContent().getOnSuccess()), BuiltInFictitiousFunctionClassFactory(addonInfo.getContent().getOnPending()), BuiltInFictitiousFunctionClassFactory(addonInfo.getContent().getOnFailed()), BuiltInFictitiousFunctionClassFactory(addonInfo.getContent().getOnBalanceNotEnough()), new ExpressPurchaseModel.PreviousPurchasement(str, str2, str3, str4, str5), addonInfo.getExtendInfo(), 16, null);
    }

    private static ExpressPurchaseModel.OfferContent getAuthRequestContext(AddonInfo addonInfo, Context context) {
        String str;
        ExpressPurchaseModel.OfferContent.BenefitModel benefitModel;
        Intrinsics.checkNotNullParameter(addonInfo, "");
        Intrinsics.checkNotNullParameter(context, "");
        String imgUrl = addonInfo.getContent().getImgUrl();
        String title = addonInfo.getContent().getTitle();
        String subTitle = addonInfo.getContent().getSubTitle();
        String goodsTitle = addonInfo.getProductInfo().getGoodsTitle();
        String goodsDescription = addonInfo.getProductInfo().getGoodsDescription();
        String MyBillsEntityDataFactory = NumberFormatterUtil.MyBillsEntityDataFactory(LocaleUtil.BuiltInFictitiousFunctionClassFactory(), addonInfo.getProductInfo().getGoodsPrice().getAmount());
        String currency = addonInfo.getProductInfo().getGoodsPrice().getCurrency();
        String currencyCode = addonInfo.getProductInfo().getGoodsPrice().getCurrencyCode();
        String finType = addonInfo.getProductInfo().getFinType();
        String merchantId = addonInfo.getProductInfo().getMerchantId();
        String merchantName = addonInfo.getProductInfo().getMerchantName();
        String providerName = addonInfo.getProductInfo().getProviderName();
        String tncContent = addonInfo.getContent().getTncContent();
        String providerCategory = addonInfo.getProductInfo().getProviderCategory();
        if (addonInfo.getContent().getBenefits().isEmpty()) {
            benefitModel = null;
            str = merchantName;
        } else {
            AddonInfo.Content.Benefit benefit = addonInfo.getContent().getBenefits().get(0);
            Intrinsics.checkNotNullParameter(benefit, "");
            str = merchantName;
            benefitModel = new ExpressPurchaseModel.OfferContent.BenefitModel(benefit.getImgUrl(), benefit.getTitle(), benefit.getDescription());
        }
        String benefitDescription = addonInfo.getContent().getBenefitDescription();
        String string = context.getString(R.string.tnc);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String PlaceComponentResult = StringExtKt.PlaceComponentResult(benefitDescription, string);
        String tncUrl = addonInfo.getContent().getTncUrl();
        String supervision = addonInfo.getContent().getSupervision();
        String string2 = context.getString(R.string.ep_supervised_by);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String PlaceComponentResult2 = StringExtKt.PlaceComponentResult(supervision, string2);
        String purchaseInformation = addonInfo.getContent().getPurchaseInformation();
        String buyButtonLabel = addonInfo.getContent().getBuyButtonLabel();
        String buyButtonRedirectionUrl = addonInfo.getContent().getBuyButtonRedirectionUrl();
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return new ExpressPurchaseModel.OfferContent(imgUrl, title, subTitle, goodsTitle, goodsDescription, MyBillsEntityDataFactory, currency, currencyCode, finType, merchantId, str, providerName, providerCategory, benefitModel, PlaceComponentResult, tncUrl, tncContent, PlaceComponentResult2, purchaseInformation, buyButtonLabel, buyButtonRedirectionUrl);
    }

    private static ExpressPurchaseModel.PaymentResultContent BuiltInFictitiousFunctionClassFactory(AddonInfo.Content.ResultConfirmation resultConfirmation) {
        if (resultConfirmation == null) {
            return null;
        }
        return new ExpressPurchaseModel.PaymentResultContent(resultConfirmation.getImgUrl(), resultConfirmation.getInfoTitle(), resultConfirmation.getInfoLabel(), resultConfirmation.getRedirectUrl(), resultConfirmation.getActionLabel());
    }

    public static final ExpressPurchaseModel MyBillsEntityDataFactory(PaylaterOffer paylaterOffer, String str, String str2, String str3, String str4, String str5) {
        List list;
        Intrinsics.checkNotNullParameter(paylaterOffer, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        ExpressPurchaseModel.PreviousPurchasement previousPurchasement = new ExpressPurchaseModel.PreviousPurchasement(str, str2, str3, str4, str5);
        PaylaterOffer.Partner partner = paylaterOffer.getPartner();
        int safeInt$default = NumberExtKt.toSafeInt$default(partner != null ? Integer.valueOf(partner.getId()) : null, 0, 1, (Object) null);
        PaylaterOffer.Partner partner2 = paylaterOffer.getPartner();
        String redirectedUrl = partner2 != null ? partner2.getRedirectedUrl() : null;
        String str6 = redirectedUrl == null ? "" : redirectedUrl;
        PaylaterOffer.Partner partner3 = paylaterOffer.getPartner();
        String tnc = partner3 != null ? partner3.getTnc() : null;
        String str7 = tnc == null ? "" : tnc;
        String cdpContent = paylaterOffer.getCdpContent();
        if (cdpContent == null) {
            cdpContent = "";
        }
        String str8 = cdpContent;
        if (str8.length() == 0) {
            list = CollectionsKt.emptyList();
        } else {
            Object fromJson = new Gson().fromJson(new Regex("[\n\t]").replace(str8, ""), new TypeToken<List<? extends ExpressPurchaseModel.Paylater.BenefitContent>>() { // from class: id.dana.expresspurchase.mapper.ExpressPurchasePresenterMapperKt$fromJsonArray$type$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(fromJson, "");
            list = (List) fromJson;
        }
        return new ExpressPurchaseModel.Paylater(previousPurchasement, safeInt$default, str6, str7, list);
    }
}
