package id.dana.kyb.data.mapper;

import com.alibaba.fastjson.JSONObject;
import id.dana.data.nearbyme.model.MoneyViewEntityMapperKt;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.kyb.data.model.ExtendInfoResult;
import id.dana.kyb.data.model.KybInfoResult;
import id.dana.kyb.data.model.KybServiceMessageResult;
import id.dana.kyb.data.model.KybServiceRedirectValueResult;
import id.dana.kyb.data.model.KybServiceResult;
import id.dana.kyb.data.model.KybServiceRuleResult;
import id.dana.kyb.data.model.KybStartupConfigResult;
import id.dana.kyb.data.model.KybTransactionDTO;
import id.dana.kyb.data.model.KybUrlsConfigResult;
import id.dana.kyb.data.model.KybUrlsConfigWrapperResult;
import id.dana.kyb.data.model.MerchantContractInfoResult;
import id.dana.kyb.data.repository.source.network.result.KybMerchantInfoResult;
import id.dana.kyb.data.repository.source.network.result.KybRequestPaymentResult;
import id.dana.kyb.data.repository.source.network.result.QueryLatestOrderResult;
import id.dana.kyb.data.repository.source.network.result.TransactionListQueryResult;
import id.dana.kyb.domain.model.KybInfo;
import id.dana.kyb.domain.model.KybMerchantInfo;
import id.dana.kyb.domain.model.KybRequestPayment;
import id.dana.kyb.domain.model.KybService;
import id.dana.kyb.domain.model.KybServiceMessage;
import id.dana.kyb.domain.model.KybServiceRedirectValue;
import id.dana.kyb.domain.model.KybServiceRule;
import id.dana.kyb.domain.model.KybStartupConfig;
import id.dana.kyb.domain.model.KybTransactionOrderInfo;
import id.dana.kyb.domain.model.KybUrlsConfig;
import id.dana.kyb.domain.model.MerchantContractInfo;
import id.dana.kyb.domain.model.QueryLatestOrder;
import id.dana.kyb.domain.model.TransactionListQueryInfo;
import id.dana.utils.extension.JSONExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006\u001a\u0011\u0010\u0002\u001a\u00020\b*\u00020\u0007¢\u0006\u0004\b\u0002\u0010\t\u001a\u0011\u0010\f\u001a\u00020\u000b*\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\u0011\u0010\u0010\u001a\u00020\u000f*\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0013\u0010\u0014\u001a\u00020\u0013*\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0011\u0010\u0010\u001a\u00020\u0013*\u00020\u0016¢\u0006\u0004\b\u0010\u0010\u0017\u001a\u001f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0018*\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002¢\u0006\u0004\b\u0014\u0010\u001b\u001a\u0011\u0010\u001e\u001a\u00020\u001d*\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0011\u0010\u0002\u001a\u00020!*\u00020 ¢\u0006\u0004\b\u0002\u0010\""}, d2 = {"", "Lid/dana/kyb/domain/model/KybInfo;", "getAuthRequestContext", "(Ljava/lang/String;)Lid/dana/kyb/domain/model/KybInfo;", "Lid/dana/kyb/data/repository/source/network/result/KybMerchantInfoResult;", "Lid/dana/kyb/domain/model/KybMerchantInfo;", "(Lid/dana/kyb/data/repository/source/network/result/KybMerchantInfoResult;)Lid/dana/kyb/domain/model/KybMerchantInfo;", "Lid/dana/kyb/data/repository/source/network/result/KybRequestPaymentResult;", "Lid/dana/kyb/domain/model/KybRequestPayment;", "(Lid/dana/kyb/data/repository/source/network/result/KybRequestPaymentResult;)Lid/dana/kyb/domain/model/KybRequestPayment;", "Lid/dana/kyb/data/model/KybServiceResult;", "Lid/dana/kyb/domain/model/KybService;", "PlaceComponentResult", "(Lid/dana/kyb/data/model/KybServiceResult;)Lid/dana/kyb/domain/model/KybService;", "Lid/dana/kyb/data/model/KybStartupConfigResult;", "Lid/dana/kyb/domain/model/KybStartupConfig;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/kyb/data/model/KybStartupConfigResult;)Lid/dana/kyb/domain/model/KybStartupConfig;", "Lid/dana/kyb/data/model/KybUrlsConfigResult;", "Lid/dana/kyb/domain/model/KybUrlsConfig;", "MyBillsEntityDataFactory", "(Lid/dana/kyb/data/model/KybUrlsConfigResult;)Lid/dana/kyb/domain/model/KybUrlsConfig;", "Lid/dana/kyb/data/model/KybUrlsConfigWrapperResult;", "(Lid/dana/kyb/data/model/KybUrlsConfigWrapperResult;)Lid/dana/kyb/domain/model/KybUrlsConfig;", "", "Lid/dana/kyb/data/model/MerchantContractInfoResult;", "Lid/dana/kyb/domain/model/MerchantContractInfo;", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/kyb/data/repository/source/network/result/QueryLatestOrderResult;", "Lid/dana/kyb/domain/model/QueryLatestOrder;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/kyb/data/repository/source/network/result/QueryLatestOrderResult;)Lid/dana/kyb/domain/model/QueryLatestOrder;", "Lid/dana/kyb/data/repository/source/network/result/TransactionListQueryResult;", "Lid/dana/kyb/domain/model/TransactionListQueryInfo;", "(Lid/dana/kyb/data/repository/source/network/result/TransactionListQueryResult;)Lid/dana/kyb/domain/model/TransactionListQueryInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybMapperKt {
    public static final KybStartupConfig BuiltInFictitiousFunctionClassFactory(KybStartupConfigResult kybStartupConfigResult) {
        Intrinsics.checkNotNullParameter(kybStartupConfigResult, "");
        Boolean cashOutV2 = kybStartupConfigResult.getCashOutV2();
        return new KybStartupConfig(cashOutV2 != null ? cashOutV2.booleanValue() : false);
    }

    public static final QueryLatestOrder KClassImpl$Data$declaredNonStaticMembers$2(QueryLatestOrderResult queryLatestOrderResult) {
        Intrinsics.checkNotNullParameter(queryLatestOrderResult, "");
        String kybInfo = queryLatestOrderResult.getKybInfo();
        return new QueryLatestOrder(kybInfo != null ? getAuthRequestContext(kybInfo) : null, queryLatestOrderResult.getModifiedDate(), queryLatestOrderResult.getOrderStatus());
    }

    public static final KybMerchantInfo getAuthRequestContext(KybMerchantInfoResult kybMerchantInfoResult) {
        Intrinsics.checkNotNullParameter(kybMerchantInfoResult, "");
        String merchantQrCode = kybMerchantInfoResult.getMerchantQrCode();
        String merchantName = kybMerchantInfoResult.getMerchantName();
        String merchantType = kybMerchantInfoResult.getMerchantType();
        String merchantId = kybMerchantInfoResult.getMerchantId();
        MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(kybMerchantInfoResult.getBalance());
        String businessAvatarUrl = kybMerchantInfoResult.getBusinessAvatarUrl();
        String merchantStatus = kybMerchantInfoResult.getMerchantStatus();
        String nmid = kybMerchantInfoResult.getNmid();
        MoneyView moneyView2 = MoneyViewEntityMapperKt.toMoneyView(kybMerchantInfoResult.getPendingBalance());
        boolean faceAuthActivated = kybMerchantInfoResult.getFaceAuthActivated();
        boolean faceAuthEligible = kybMerchantInfoResult.getFaceAuthEligible();
        boolean faceAuthEnrolled = kybMerchantInfoResult.getFaceAuthEnrolled();
        boolean freezeFundIn = kybMerchantInfoResult.getFreezeFundIn();
        boolean freezeFundOut = kybMerchantInfoResult.getFreezeFundOut();
        List<MerchantContractInfoResult> signedContracts = kybMerchantInfoResult.getSignedContracts();
        List<MerchantContractInfo> MyBillsEntityDataFactory = signedContracts != null ? MyBillsEntityDataFactory(signedContracts) : null;
        List<MerchantContractInfoResult> unSignedContracts = kybMerchantInfoResult.getUnSignedContracts();
        List<MerchantContractInfo> MyBillsEntityDataFactory2 = unSignedContracts != null ? MyBillsEntityDataFactory(unSignedContracts) : null;
        MoneyView moneyView3 = MoneyViewEntityMapperKt.toMoneyView(kybMerchantInfoResult.getUsedAmount());
        MoneyView moneyView4 = MoneyViewEntityMapperKt.toMoneyView(kybMerchantInfoResult.getLimitAmount());
        String urgencyLevel = kybMerchantInfoResult.getUrgencyLevel();
        return new KybMerchantInfo(merchantQrCode, merchantName, merchantType, merchantId, moneyView, businessAvatarUrl, merchantStatus, nmid, moneyView2, faceAuthActivated, faceAuthEligible, faceAuthEnrolled, freezeFundIn, freezeFundOut, MyBillsEntityDataFactory, MyBillsEntityDataFactory2, moneyView3, moneyView4, urgencyLevel == null ? "" : urgencyLevel);
    }

    public static final TransactionListQueryInfo getAuthRequestContext(TransactionListQueryResult transactionListQueryResult) {
        ArrayList emptyList;
        String productCode;
        Intrinsics.checkNotNullParameter(transactionListQueryResult, "");
        Boolean hasMore = transactionListQueryResult.getHasMore();
        boolean booleanValue = hasMore != null ? hasMore.booleanValue() : false;
        List<KybTransactionDTO> transactionListItemDTOs = transactionListQueryResult.getTransactionListItemDTOs();
        if (transactionListItemDTOs == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            Intrinsics.checkNotNullParameter(transactionListItemDTOs, "");
            List<KybTransactionDTO> list = transactionListItemDTOs;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (KybTransactionDTO kybTransactionDTO : list) {
                Intrinsics.checkNotNullParameter(kybTransactionDTO, "");
                boolean offUsMerchant = kybTransactionDTO.getOffUsMerchant();
                String bizOrderId = kybTransactionDTO.getBizOrderId();
                String str = bizOrderId == null ? "" : bizOrderId;
                String bizOrderType = kybTransactionDTO.getBizOrderType();
                String str2 = bizOrderType == null ? "" : bizOrderType;
                String orderTitle = kybTransactionDTO.getOrderTitle();
                String str3 = orderTitle == null ? "" : orderTitle;
                String orderCreatedTime = kybTransactionDTO.getOrderCreatedTime();
                String str4 = orderCreatedTime == null ? "" : orderCreatedTime;
                MoneyView moneyView = MoneyViewEntityMapperKt.toMoneyView(kybTransactionDTO.getPayMoneyAmount());
                String subOrderStatus = kybTransactionDTO.getSubOrderStatus();
                String str5 = subOrderStatus == null ? "" : subOrderStatus;
                String orderStatus = kybTransactionDTO.getOrderStatus();
                String str6 = orderStatus == null ? "" : orderStatus;
                ExtendInfoResult extendInfo = kybTransactionDTO.getExtendInfo();
                String str7 = (extendInfo == null || (productCode = extendInfo.getProductCode()) == null) ? "" : productCode;
                String inOut = kybTransactionDTO.getInOut();
                arrayList.add(new KybTransactionOrderInfo(offUsMerchant, str, str2, str3, str4, moneyView, str5, str6, str7, inOut == null ? "" : inOut));
            }
            emptyList = arrayList;
        }
        return new TransactionListQueryInfo(booleanValue, emptyList, 0, 0, 12, null);
    }

    public static final KybRequestPayment getAuthRequestContext(KybRequestPaymentResult kybRequestPaymentResult) {
        Intrinsics.checkNotNullParameter(kybRequestPaymentResult, "");
        return new KybRequestPayment(kybRequestPaymentResult.getVaEnableStatus(), MoneyViewEntityMapperKt.toMoneyView(kybRequestPaymentResult.getVaMinAmount()));
    }

    public static final KybService PlaceComponentResult(KybServiceResult kybServiceResult) {
        String str;
        KybServiceRedirectValue kybServiceRedirectValue;
        ArrayList emptyList;
        String str2;
        Iterator it;
        String str3;
        KybServiceMessage kybServiceMessage;
        String str4 = "";
        Intrinsics.checkNotNullParameter(kybServiceResult, "");
        Boolean enable = kybServiceResult.getEnable();
        boolean booleanValue = enable != null ? enable.booleanValue() : false;
        String icon = kybServiceResult.getIcon();
        String name = kybServiceResult.getName();
        String redirectType = kybServiceResult.getRedirectType();
        KybServiceRedirectValueResult redirectValue = kybServiceResult.getRedirectValue();
        if (redirectValue != null) {
            Intrinsics.checkNotNullParameter(redirectValue, "");
            List<String> additionalQuery = redirectValue.getAdditionalQuery();
            String clientId = redirectValue.getClientId();
            String scopes = redirectValue.getScopes();
            String agreed = redirectValue.getAgreed();
            String url = redirectValue.getUrl();
            boolean openNewWindow = redirectValue.getOpenNewWindow();
            String apiName = redirectValue.getApiName();
            String minVersion = redirectValue.getMinVersion();
            JSONObject apiPayload = redirectValue.getApiPayload();
            String action = redirectValue.getAction();
            List<KybServiceRuleResult> rules = redirectValue.getRules();
            if (rules != null) {
                List<KybServiceRuleResult> list = rules;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    KybServiceRuleResult kybServiceRuleResult = (KybServiceRuleResult) it2.next();
                    String rule = kybServiceRuleResult.getRule();
                    if (rule == null) {
                        rule = str4;
                    }
                    Object value = kybServiceRuleResult.getValue();
                    KybServiceMessageResult message = kybServiceRuleResult.getMessage();
                    if (message != null) {
                        String title = message.getTitle();
                        str2 = str4;
                        if (title != null) {
                            str4 = title;
                        }
                        String message2 = message.getMessage();
                        it = it2;
                        String str5 = message2 == null ? str2 : message2;
                        String image = message.getImage();
                        str3 = redirectType;
                        if (image == null) {
                            image = str2;
                        }
                        kybServiceMessage = new KybServiceMessage(str4, str5, image);
                    } else {
                        str2 = str4;
                        it = it2;
                        str3 = redirectType;
                        kybServiceMessage = null;
                    }
                    arrayList.add(new KybServiceRule(rule, value, kybServiceMessage));
                    str4 = str2;
                    it2 = it;
                    redirectType = str3;
                }
                str = redirectType;
                emptyList = arrayList;
            } else {
                str = redirectType;
                emptyList = CollectionsKt.emptyList();
            }
            kybServiceRedirectValue = new KybServiceRedirectValue(additionalQuery, clientId, scopes, agreed, url, openNewWindow, apiName, minVersion, apiPayload, action, emptyList);
        } else {
            str = redirectType;
            kybServiceRedirectValue = null;
        }
        return new KybService(booleanValue, icon, name, null, str, kybServiceRedirectValue, 8, null);
    }

    private static final List<MerchantContractInfo> MyBillsEntityDataFactory(List<MerchantContractInfoResult> list) {
        List<MerchantContractInfoResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (MerchantContractInfoResult merchantContractInfoResult : list2) {
            arrayList.add(new MerchantContractInfo(merchantContractInfoResult.getProductCode(), merchantContractInfoResult.getProductName()));
        }
        return arrayList;
    }

    public static final KybUrlsConfig BuiltInFictitiousFunctionClassFactory(KybUrlsConfigWrapperResult kybUrlsConfigWrapperResult) {
        Intrinsics.checkNotNullParameter(kybUrlsConfigWrapperResult, "");
        KybUrlsConfigResult kybUrls = kybUrlsConfigWrapperResult.getKybUrls();
        if (kybUrls == null) {
            kybUrls = new KybUrlsConfigResult(null, null, null, null, null, null, null, null, null, null, 1023, null);
        }
        return MyBillsEntityDataFactory(kybUrls);
    }

    private static final KybUrlsConfig MyBillsEntityDataFactory(KybUrlsConfigResult kybUrlsConfigResult) {
        String kyb = kybUrlsConfigResult.getKyb();
        String kyc = kybUrlsConfigResult.getKyc();
        String transaction = kybUrlsConfigResult.getTransaction();
        String home = kybUrlsConfigResult.getHome();
        String withdraw = kybUrlsConfigResult.getWithdraw();
        String str = withdraw == null ? "" : withdraw;
        String withdrawWithBalance = kybUrlsConfigResult.getWithdrawWithBalance();
        String str2 = withdrawWithBalance == null ? "" : withdrawWithBalance;
        String withdrawWithBank = kybUrlsConfigResult.getWithdrawWithBank();
        String str3 = withdrawWithBank == null ? "" : withdrawWithBank;
        String registration = kybUrlsConfigResult.getRegistration();
        String str4 = registration == null ? "" : registration;
        String registrationReject = kybUrlsConfigResult.getRegistrationReject();
        String str5 = registrationReject == null ? "" : registrationReject;
        String registrationRevoke = kybUrlsConfigResult.getRegistrationRevoke();
        if (registrationRevoke == null) {
            registrationRevoke = "";
        }
        return new KybUrlsConfig(kyb, kyc, transaction, home, str, str3, str2, str4, str5, registrationRevoke);
    }

    private static final KybInfo getAuthRequestContext(String str) {
        Object obj;
        try {
            obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(str, null), (Class<Object>) KybInfoResult.class);
        } catch (Exception unused) {
            obj = null;
        }
        KybInfoResult kybInfoResult = (KybInfoResult) obj;
        if (kybInfoResult != null) {
            return new KybInfo(kybInfoResult.getRESIDENTIAL_ADDRESS(), kybInfoResult.getUSER_ID(), kybInfoResult.getOPERATION_HOURS(), kybInfoResult.getBUSINESS_ADDRESS(), kybInfoResult.getPRODUCTID(), kybInfoResult.getBUSINESS_NAME(), kybInfoResult.getOWNER_NAME(), kybInfoResult.getOUTLET_PHOTO_URL(), kybInfoResult.getOWNER_TAX_NUMBER(), kybInfoResult.getBUSSINESS_CITY(), kybInfoResult.getBUSINESS_TYPE(), kybInfoResult.getPOSTAL_CODE(), kybInfoResult.getLOGO_URL());
        }
        return null;
    }
}
