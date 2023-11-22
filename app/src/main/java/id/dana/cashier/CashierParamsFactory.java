package id.dana.cashier;

import id.dana.cashier.domain.interactor.CashierUpdateOrder;
import id.dana.cashier.domain.interactor.CreateCashierOrder;
import id.dana.cashier.domain.interactor.GetCashierCheckoutInfo;
import id.dana.cashier.domain.interactor.GetQueryPromotion;
import id.dana.cashier.domain.model.CashierPayRequest;
import id.dana.cashier.domain.model.CashierUpdateOrderRequest;
import id.dana.cashier.domain.model.CheckoutExternalInfo;
import id.dana.cashier.domain.model.CreateOrderRequest;
import id.dana.cashier.domain.model.MixPayMethod;
import id.dana.cashier.domain.model.QueryPromotionRequest;
import id.dana.cashier.model.CashierCheckoutRequestModel;
import id.dana.cashier.model.CashierMerchantModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierUpdateOrderRequestModel;
import id.dana.cashier.model.QueryPromotionRequestModel;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.lib.gcontainer.util.UserAgentFactory;
import id.dana.utils.TextUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nJ£\u0001\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\n2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\nJ\n\u0010$\u001a\u00020%*\u00020&J\u0012\u0010'\u001a\u00020(*\u00020)2\u0006\u0010\u001d\u001a\u00020\bJ\n\u0010*\u001a\u00020+*\u00020,¨\u0006-"}, d2 = {"Lid/dana/cashier/CashierParamsFactory;", "", "()V", "checkIfMixPayMethodCanBeFilled", "Lid/dana/cashier/domain/model/MixPayMethod;", "mixPaySelectedPayMethod", "Lid/dana/cashier/model/CashierPayMethodModel;", "isMixPayEnable", "", "deviceProviderRequestId", "", "constructCreateOrderParams", "Lid/dana/cashier/domain/interactor/CreateCashierOrder$Params;", "cashierMerchantModel", "Lid/dana/cashier/model/CashierMerchantModel;", "amount", "constructPayRequestParams", "Lid/dana/cashier/domain/interactor/PayCashier$Params;", CashierKeyParams.CASHIER_ORDER_ID, "selectedPayMethod", "selectedVoucher", "Lid/dana/cashier/model/VoucherCashierModel;", "selectedAddonIds", "", "validateData", CashierKeyParams.VERIFICATION_METHOD, "version", CashierKeyParams.INSTALLMENT_PERIOD, "", "isGpsActive", "transType", "paylaterCashierRequestCheckoutModel", "Lid/dana/cashier/model/PaylaterCashierRequestCheckoutModel;", "(Ljava/lang/String;Lid/dana/cashier/model/CashierPayMethodModel;Lid/dana/cashier/model/VoucherCashierModel;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZZLid/dana/cashier/model/CashierPayMethodModel;Ljava/lang/String;Lid/dana/cashier/model/PaylaterCashierRequestCheckoutModel;Ljava/lang/String;)Lid/dana/cashier/domain/interactor/PayCashier$Params;", "generateOneklikDeviceId", "androidId", "constructQueryPromotionRequest", "Lid/dana/cashier/domain/interactor/GetQueryPromotion$Params;", "Lid/dana/cashier/model/QueryPromotionRequestModel;", "constructRequestParams", "Lid/dana/cashier/domain/interactor/GetCashierCheckoutInfo$Params;", "Lid/dana/cashier/model/CashierCheckoutRequestModel;", "constructUpdateOrderRequest", "Lid/dana/cashier/domain/interactor/CashierUpdateOrder$Params;", "Lid/dana/cashier/model/CashierUpdateOrderRequestModel;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierParamsFactory {
    public static final CashierParamsFactory PlaceComponentResult = new CashierParamsFactory();

    private CashierParamsFactory() {
    }

    public static GetCashierCheckoutInfo.Params KClassImpl$Data$declaredNonStaticMembers$2(CashierCheckoutRequestModel cashierCheckoutRequestModel, boolean z) {
        CashierPayRequest cashierPayRequest;
        Intrinsics.checkNotNullParameter(cashierCheckoutRequestModel, "");
        if (cashierCheckoutRequestModel.PlaceComponentResult()) {
            String str = cashierCheckoutRequestModel.MyBillsEntityDataFactory;
            String str2 = cashierCheckoutRequestModel.getErrorConfigVersion;
            Boolean bool = cashierCheckoutRequestModel.initRecordTimeStamp;
            List<String> list = cashierCheckoutRequestModel.GetContactSyncConfig;
            CheckoutExternalInfo checkoutExternalInfo = cashierCheckoutRequestModel.KClassImpl$Data$declaredNonStaticMembers$2;
            Boolean bool2 = cashierCheckoutRequestModel.scheduleImpl;
            String str3 = null;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            String str7 = null;
            Boolean bool3 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            String str16 = null;
            String str17 = null;
            String str18 = null;
            String str19 = null;
            String str20 = null;
            String str21 = null;
            String str22 = "cashierMain";
            cashierPayRequest = new CashierPayRequest(str22, str3, str, checkoutExternalInfo, str4, str5, str6, str7, bool3, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, cashierCheckoutRequestModel.NetworkUserEntityData$$ExternalSyntheticLambda2, cashierCheckoutRequestModel.BuiltInFictitiousFunctionClassFactory, null, null, null, null, null, null, cashierCheckoutRequestModel.PlaceComponentResult, list, null, null, bool, bool2, null, null, str2, null, null, 2122317810, 870, null);
        } else {
            String str23 = Intrinsics.areEqual(cashierCheckoutRequestModel.scheduleImpl, Boolean.TRUE) ? cashierCheckoutRequestModel.MyBillsEntityDataFactory : null;
            String str24 = cashierCheckoutRequestModel.getErrorConfigVersion;
            CheckoutExternalInfo checkoutExternalInfo2 = cashierCheckoutRequestModel.KClassImpl$Data$declaredNonStaticMembers$2;
            List<String> list2 = cashierCheckoutRequestModel.GetContactSyncConfig;
            Boolean bool4 = cashierCheckoutRequestModel.scheduleImpl;
            String str25 = null;
            String str26 = null;
            String str27 = null;
            String str28 = null;
            String str29 = null;
            Boolean bool5 = null;
            String str30 = null;
            String str31 = null;
            String str32 = null;
            String str33 = null;
            String str34 = null;
            String str35 = null;
            String str36 = null;
            String str37 = null;
            String str38 = null;
            String str39 = null;
            String str40 = null;
            String str41 = null;
            String str42 = null;
            String str43 = null;
            String str44 = "cashierMain";
            cashierPayRequest = new CashierPayRequest(str44, str25, str23, checkoutExternalInfo2, str26, str27, str28, str29, bool5, str30, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, str42, str43, cashierCheckoutRequestModel.NetworkUserEntityData$$ExternalSyntheticLambda2, cashierCheckoutRequestModel.BuiltInFictitiousFunctionClassFactory, null, null, null, null, null, null, cashierCheckoutRequestModel.PlaceComponentResult, list2, null, null, null, bool4, null, null, str24, null, null, 2122317810, 878, null);
        }
        return GetCashierCheckoutInfo.Params.INSTANCE.createCashierMainRequest(cashierPayRequest, z);
    }

    private static MixPayMethod getAuthRequestContext(CashierPayMethodModel cashierPayMethodModel, boolean z, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        boolean z2 = cashierPayMethodModel != null && z;
        if (z2 && (cashierPayMethodModel instanceof CashierPayMethodModel.CardPayMethod)) {
            CashierPayMethodModel.CardPayMethod cardPayMethod = (CashierPayMethodModel.CardPayMethod) cashierPayMethodModel;
            CashierPayMethodModel.NewCardData newCardData = cardPayMethod.getAuthRequestContext;
            String str9 = ((newCardData == null || (str2 = newCardData.lookAheadTest) == null) && (str2 = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.getSupportButtonTintMode) == null) ? "" : str2;
            CashierPayMethodModel.NewCardData newCardData2 = cardPayMethod.getAuthRequestContext;
            if (newCardData2 == null || (str3 = newCardData2.MyBillsEntityDataFactory) == null) {
                str3 = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            String str10 = str3;
            CashierPayMethodModel.NewCardData newCardData3 = cardPayMethod.getAuthRequestContext;
            String str11 = newCardData3 != null ? newCardData3.PlaceComponentResult : null;
            String str12 = str11 == null ? "" : str11;
            CashierPayMethodModel.NewCardData newCardData4 = cardPayMethod.getAuthRequestContext;
            String str13 = ((newCardData4 == null || (str4 = newCardData4.scheduleImpl) == null) && (str4 = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.whenAvailable) == null) ? "" : str4;
            CashierPayMethodModel.NewCardData newCardData5 = cardPayMethod.getAuthRequestContext;
            String str14 = ((newCardData5 == null || (str5 = newCardData5.BuiltInFictitiousFunctionClassFactory) == null) && (str5 = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl) == null) ? "" : str5;
            CashierPayMethodModel.NewCardData newCardData6 = cardPayMethod.getAuthRequestContext;
            String str15 = newCardData6 != null ? newCardData6.NetworkUserEntityData$$ExternalSyntheticLambda0 : null;
            if (str15 == null) {
                str15 = "";
            }
            CashierPayMethodModel.NewCardData newCardData7 = cardPayMethod.getAuthRequestContext;
            if (newCardData7 == null || (str6 = newCardData7.getAuthRequestContext) == null) {
                str6 = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8;
            }
            String str16 = str6;
            CashierPayMethodModel.NewCardData newCardData8 = cardPayMethod.getAuthRequestContext;
            if (newCardData8 == null || (str7 = newCardData8.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
                str7 = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.isLayoutRequested;
            }
            String str17 = str7;
            CashierPayMethodModel.NewCardData newCardData9 = cardPayMethod.getAuthRequestContext;
            boolean moveToNextValue = newCardData9 != null ? newCardData9.getMoveToNextValue() : true;
            if (cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext()) {
                Intrinsics.checkNotNullParameter(str, "");
                str8 = TextUtil.getAuthRequestContext(str, UserAgentFactory.getUserAgent(), OneklikAnnotations.ONEKLIK_STATIC_IP);
                Intrinsics.checkNotNullExpressionValue(str8, "");
            } else {
                str8 = cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.GetContactSyncConfig;
            }
            return new MixPayMethod(str9, str13, str10, str12, str15, str16, str17, Boolean.valueOf(moveToNextValue), str14, str8, cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda4, cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.getCallingPid, cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda7, cardPayMethod.KClassImpl$Data$declaredNonStaticMembers$2.VerifyPinStateManager$executeRiskChallenge$2$2);
        } else if (z2 && (cashierPayMethodModel instanceof CashierPayMethodModel.PaylaterCicilPayMethod)) {
            CashierPayMethodModel.PaylaterCicilPayMethod paylaterCicilPayMethod = (CashierPayMethodModel.PaylaterCicilPayMethod) cashierPayMethodModel;
            String str18 = paylaterCicilPayMethod.getErrorConfigVersion.B;
            if (str18 == null) {
                str18 = "";
            }
            String str19 = paylaterCicilPayMethod.getErrorConfigVersion.NetworkUserEntityData$$ExternalSyntheticLambda7;
            if (str19 == null) {
                str19 = "";
            }
            String str20 = paylaterCicilPayMethod.getErrorConfigVersion.PrepareContext;
            return new MixPayMethod(str18, str19, null, null, null, null, null, null, null, str, null, null, null, str20 == null ? "" : str20, null);
        } else {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static id.dana.cashier.domain.interactor.PayCashier.Params MyBillsEntityDataFactory(java.lang.String r55, id.dana.cashier.model.CashierPayMethodModel r56, id.dana.cashier.model.VoucherCashierModel r57, java.util.List<java.lang.String> r58, java.lang.String r59, java.lang.String r60, java.lang.String r61, java.lang.Integer r62, boolean r63, boolean r64, id.dana.cashier.model.CashierPayMethodModel r65, java.lang.String r66, id.dana.cashier.model.PaylaterCashierRequestCheckoutModel r67, java.lang.String r68) {
        /*
            Method dump skipped, instructions count: 1019
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.CashierParamsFactory.MyBillsEntityDataFactory(java.lang.String, id.dana.cashier.model.CashierPayMethodModel, id.dana.cashier.model.VoucherCashierModel, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, boolean, boolean, id.dana.cashier.model.CashierPayMethodModel, java.lang.String, id.dana.cashier.model.PaylaterCashierRequestCheckoutModel, java.lang.String):id.dana.cashier.domain.interactor.PayCashier$Params");
    }

    public static CreateCashierOrder.Params KClassImpl$Data$declaredNonStaticMembers$2(CashierMerchantModel cashierMerchantModel, String str, String str2) {
        Intrinsics.checkNotNullParameter(cashierMerchantModel, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        CreateCashierOrder.Params.Companion companion = CreateCashierOrder.Params.INSTANCE;
        String str3 = cashierMerchantModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
        String str4 = cashierMerchantModel.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (str4 == null) {
            str4 = str2;
        }
        String str5 = cashierMerchantModel.GetContactSyncConfig;
        String str6 = cashierMerchantModel.KClassImpl$Data$declaredNonStaticMembers$2;
        String str7 = cashierMerchantModel.MyBillsEntityDataFactory;
        String str8 = cashierMerchantModel.PlaceComponentResult;
        String str9 = cashierMerchantModel.scheduleImpl;
        boolean prepareContext = cashierMerchantModel.getPrepareContext();
        boolean builtInFictitiousFunctionClassFactory = cashierMerchantModel.getBuiltInFictitiousFunctionClassFactory();
        return companion.forCreateCashierOrder(new CreateOrderRequest(str3, str, str4, str5, null, str6, str7, str8, str9, null, Boolean.valueOf(prepareContext), String.valueOf(builtInFictitiousFunctionClassFactory), cashierMerchantModel.NetworkUserEntityData$$ExternalSyntheticLambda0, cashierMerchantModel.newProxyInstance, 512, null));
    }

    public static GetQueryPromotion.Params getAuthRequestContext(QueryPromotionRequestModel queryPromotionRequestModel) {
        Intrinsics.checkNotNullParameter(queryPromotionRequestModel, "");
        return GetQueryPromotion.Params.INSTANCE.createQueryPromotionRequest(new QueryPromotionRequest(queryPromotionRequestModel.getAuthRequestContext, queryPromotionRequestModel.BuiltInFictitiousFunctionClassFactory, queryPromotionRequestModel.PlaceComponentResult, queryPromotionRequestModel.KClassImpl$Data$declaredNonStaticMembers$2, queryPromotionRequestModel.MyBillsEntityDataFactory, queryPromotionRequestModel.getErrorConfigVersion, queryPromotionRequestModel.NetworkUserEntityData$$ExternalSyntheticLambda0, queryPromotionRequestModel.moveToNextValue));
    }

    public static CashierUpdateOrder.Params PlaceComponentResult(CashierUpdateOrderRequestModel cashierUpdateOrderRequestModel) {
        Intrinsics.checkNotNullParameter(cashierUpdateOrderRequestModel, "");
        return CashierUpdateOrder.Params.INSTANCE.createUpdateOrderRequest(new CashierUpdateOrderRequest(cashierUpdateOrderRequestModel.getAuthRequestContext, cashierUpdateOrderRequestModel.BuiltInFictitiousFunctionClassFactory, cashierUpdateOrderRequestModel.KClassImpl$Data$declaredNonStaticMembers$2));
    }

    public static String PlaceComponentResult(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        String authRequestContext = TextUtil.getAuthRequestContext(str, UserAgentFactory.getUserAgent(), OneklikAnnotations.ONEKLIK_STATIC_IP);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }
}
