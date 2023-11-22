package id.dana.kyb.mapper;

import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import id.dana.domain.promotion.CdpContent;
import id.dana.domain.promotion.Space;
import id.dana.kyb.constant.KybUpgradeTierUrgencyLevel;
import id.dana.kyb.constant.OrderType;
import id.dana.kyb.constant.PaymentRequestStatus;
import id.dana.kyb.domain.model.KybCompressQrConfig;
import id.dana.kyb.domain.model.KybMerchantInfo;
import id.dana.kyb.domain.model.KybService;
import id.dana.kyb.domain.model.KybServiceMessage;
import id.dana.kyb.domain.model.KybServiceRedirectValue;
import id.dana.kyb.domain.model.KybServiceRule;
import id.dana.kyb.domain.model.KybTransactionOrderInfo;
import id.dana.kyb.domain.model.MerchantContractInfo;
import id.dana.kyb.model.BalanceModel;
import id.dana.kyb.model.KybMerchantInfoModel;
import id.dana.kyb.model.KybQrisModel;
import id.dana.kyb.model.KybServiceMessageModel;
import id.dana.kyb.model.KybServiceModel;
import id.dana.kyb.model.KybServiceRedirectValueModel;
import id.dana.kyb.model.KybServiceRuleModel;
import id.dana.kyb.model.MerchantContractInfoModel;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModelKt;
import id.dana.utils.LocaleUtil;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0004\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\r\u001a\u0017\u0010\b\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\nH\u0002¢\u0006\u0004\b\b\u0010\r\u001a\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\r\u001a\u0017\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0004\u0010\r\u001a\u0017\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\r\u001a\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0010\u001a\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006*\u00020\u0011¢\u0006\u0004\b\b\u0010\u0012\u001a%\u0010\b\u001a\u0004\u0018\u00010\u0015*\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u0006\u0010\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0016\u001a\u0013\u0010\f\u001a\u00020\u0017*\u0004\u0018\u00010\u0017¢\u0006\u0004\b\f\u0010\u0018\u001a\u0011\u0010\f\u001a\u00020\u001a*\u00020\u0019¢\u0006\u0004\b\f\u0010\u001b\u001a\u0011\u0010\u0004\u001a\u00020\u001d*\u00020\u001c¢\u0006\u0004\b\u0004\u0010\u001e\u001a\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u001f*\u00020\u001cH\u0002¢\u0006\u0004\b\u000f\u0010 \u001a\u0011\u0010\u0004\u001a\u00020\"*\u00020!¢\u0006\u0004\b\u0004\u0010#\u001a\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\"0\u0013*\b\u0012\u0004\u0012\u00020!0\u0013¢\u0006\u0004\b\b\u0010$\u001a\u0019\u0010\b\u001a\u00020'*\u00020%2\u0006\u0010\u0001\u001a\u00020&¢\u0006\u0004\b\b\u0010("}, d2 = {"Lid/dana/domain/nearbyme/model/MoneyView;", "p0", "p1", "Lid/dana/kyb/model/BalanceModel;", "PlaceComponentResult", "(Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;)Lid/dana/kyb/model/BalanceModel;", "", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;J)Ljava/lang/String;", "Lid/dana/kyb/domain/model/KybTransactionOrderInfo;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/kyb/domain/model/KybTransactionOrderInfo;)Z", "MyBillsEntityDataFactory", "getAuthRequestContext", "(Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/domain/promotion/Space;", "(Lid/dana/domain/promotion/Space;)Ljava/lang/String;", "", "Lid/dana/kyb/domain/model/MerchantContractInfo;", "Lid/dana/kyb/model/MerchantContractInfoModel;", "(Ljava/util/List;Ljava/lang/String;)Lid/dana/kyb/model/MerchantContractInfoModel;", "Lid/dana/kyb/domain/model/KybCompressQrConfig;", "(Lid/dana/kyb/domain/model/KybCompressQrConfig;)Lid/dana/kyb/domain/model/KybCompressQrConfig;", "Lid/dana/kyb/domain/model/KybCompleteInfo;", "Lid/dana/kyb/model/KybCompleteInfoModel;", "(Lid/dana/kyb/domain/model/KybCompleteInfo;)Lid/dana/kyb/model/KybCompleteInfoModel;", "Lid/dana/kyb/domain/model/KybMerchantInfo;", "Lid/dana/kyb/model/KybMerchantInfoModel;", "(Lid/dana/kyb/domain/model/KybMerchantInfo;)Lid/dana/kyb/model/KybMerchantInfoModel;", "Lid/dana/kyb/model/KybQrisModel;", "(Lid/dana/kyb/domain/model/KybMerchantInfo;)Lid/dana/kyb/model/KybQrisModel;", "Lid/dana/kyb/domain/model/KybService;", "Lid/dana/kyb/model/KybServiceModel;", "(Lid/dana/kyb/domain/model/KybService;)Lid/dana/kyb/model/KybServiceModel;", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/kyb/domain/model/TransactionListQueryInfo;", "Landroid/content/Context;", "Lid/dana/kyb/model/TransactionListQueryModel;", "(Lid/dana/kyb/domain/model/TransactionListQueryInfo;Landroid/content/Context;)Lid/dana/kyb/model/TransactionListQueryModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybModelMapperKt {
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final id.dana.kyb.model.KybCompleteInfoModel KClassImpl$Data$declaredNonStaticMembers$2(id.dana.kyb.domain.model.KybCompleteInfo r19) {
        /*
            java.lang.String r0 = ""
            r1 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            id.dana.domain.user.UserInfoResponse r2 = r19.getUserInfoResponse()
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            id.dana.domain.homeinfo.KybResponse r3 = r2.getKybResponse()
            r4 = 0
            if (r3 == 0) goto L1b
            java.lang.String r3 = r3.getOrderStatus()
            r6 = r3
            goto L1c
        L1b:
            r6 = r4
        L1c:
            id.dana.domain.homeinfo.KybResponse r3 = r2.getKybResponse()
            if (r3 == 0) goto L28
            java.lang.String r3 = r3.getKybLevel()
            r7 = r3
            goto L29
        L28:
            r7 = r4
        L29:
            id.dana.domain.homeinfo.KybResponse r3 = r2.getKybResponse()
            if (r3 == 0) goto L35
            java.lang.String r3 = r3.getFailedReason()
            r8 = r3
            goto L36
        L35:
            r8 = r4
        L36:
            boolean r9 = r2.isFaceLoginEnabled()
            boolean r10 = r2.getHasFaceLoginEnrolled()
            id.dana.domain.homeinfo.KycResponse r3 = r2.getKycResponse()
            java.lang.String r3 = r3.getLevel()
            if (r3 == 0) goto L51
            id.dana.domain.homeinfo.KycResponse r3 = r2.getKycResponse()
            java.lang.String r3 = r3.getLevel()
            goto L53
        L51:
            java.lang.String r3 = "KYC0"
        L53:
            r11 = r3
            id.dana.domain.homeinfo.KycResponse r3 = r2.getKycResponse()
            java.lang.String r12 = r3.getOrderStatus()
            boolean r13 = r2.isKycCertified()
            id.dana.kyb.model.UserInfoKybModel r2 = new id.dana.kyb.model.UserInfoKybModel
            r5 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13)
            id.dana.kyb.domain.model.QueryLatestOrder r3 = r19.getQueryLatestOrder()
            if (r3 == 0) goto Lb0
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            id.dana.kyb.domain.model.KybInfo r0 = r3.getKybInfo()
            if (r0 == 0) goto Lb0
            java.lang.String r6 = r0.getResidentialAddress()
            java.lang.String r7 = r0.getUserId()
            java.lang.String r8 = r0.getOperationHours()
            java.lang.String r9 = r0.getBusinessAddress()
            java.lang.String r10 = r0.getProductId()
            java.lang.String r11 = r0.getBusinessName()
            java.lang.String r12 = r0.getOwnerName()
            java.lang.String r13 = r0.getOutletPhotoUrl()
            java.lang.String r14 = r0.getOwnerTaxNumber()
            java.lang.String r15 = r0.getBusinessCity()
            java.lang.String r16 = r0.getBusinessType()
            java.lang.String r17 = r0.getPostalCode()
            java.lang.String r18 = r0.getLogoUrl()
            id.dana.kyb.model.KybInfoModel r0 = new id.dana.kyb.model.KybInfoModel
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            goto Lb1
        Lb0:
            r0 = r4
        Lb1:
            id.dana.kyb.domain.model.KybMerchantInfo r1 = r19.getKybMerchantInfo()
            if (r1 == 0) goto Lbb
            id.dana.kyb.model.KybMerchantInfoModel r4 = PlaceComponentResult(r1)
        Lbb:
            id.dana.kyb.model.KybCompleteInfoModel r1 = new id.dana.kyb.model.KybCompleteInfoModel
            r1.<init>(r2, r0, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.mapper.KybModelMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.kyb.domain.model.KybCompleteInfo):id.dana.kyb.model.KybCompleteInfoModel");
    }

    public static final KybMerchantInfoModel PlaceComponentResult(KybMerchantInfo kybMerchantInfo) {
        Intrinsics.checkNotNullParameter(kybMerchantInfo, "");
        String merchantQrCode = kybMerchantInfo.getMerchantQrCode();
        String merchantName = kybMerchantInfo.getMerchantName();
        String merchantType = kybMerchantInfo.getMerchantType();
        String merchantId = kybMerchantInfo.getMerchantId();
        BalanceModel PlaceComponentResult = PlaceComponentResult(kybMerchantInfo.getBalance(), kybMerchantInfo.getPendingBalance());
        String businessAvatarUrl = kybMerchantInfo.getBusinessAvatarUrl();
        String merchantStatus = kybMerchantInfo.getMerchantStatus();
        String nmid = kybMerchantInfo.getNmid();
        boolean faceAuthActivated = kybMerchantInfo.getFaceAuthActivated();
        boolean faceAuthEligible = kybMerchantInfo.getFaceAuthEligible();
        boolean faceAuthEnrolled = kybMerchantInfo.getFaceAuthEnrolled();
        boolean freezeFundIn = kybMerchantInfo.getFreezeFundIn();
        boolean freezeFundOut = kybMerchantInfo.getFreezeFundOut();
        MerchantContractInfoModel BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(kybMerchantInfo.getSignedContracts(), PaymentRequestStatus.SIGNED);
        if (BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(kybMerchantInfo.getUnsignedContracts(), PaymentRequestStatus.UNSIGNED);
        }
        return new KybMerchantInfoModel(merchantQrCode, merchantName, merchantType, merchantId, PlaceComponentResult, businessAvatarUrl, merchantStatus, nmid, faceAuthActivated, faceAuthEligible, faceAuthEnrolled, freezeFundIn, freezeFundOut, BuiltInFictitiousFunctionClassFactory, MoneyViewModelKt.getAuthRequestContext(kybMerchantInfo.getUsedAmount()), MoneyViewModelKt.getAuthRequestContext(kybMerchantInfo.getLimitAmount()), KClassImpl$Data$declaredNonStaticMembers$2(kybMerchantInfo.getUrgencyLevel()), null, getAuthRequestContext(kybMerchantInfo), AntDetector.SCENE_ID_LOGIN_REGIST, null);
    }

    public static final KybCompressQrConfig KClassImpl$Data$declaredNonStaticMembers$2(KybCompressQrConfig kybCompressQrConfig) {
        return kybCompressQrConfig == null ? KybCompressQrConfig.INSTANCE.getDefault() : kybCompressQrConfig;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x012d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final id.dana.kyb.model.TransactionListQueryModel BuiltInFictitiousFunctionClassFactory(id.dana.kyb.domain.model.TransactionListQueryInfo r14, android.content.Context r15) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.mapper.KybModelMapperKt.BuiltInFictitiousFunctionClassFactory(id.dana.kyb.domain.model.TransactionListQueryInfo, android.content.Context):id.dana.kyb.model.TransactionListQueryModel");
    }

    private static final KybQrisModel getAuthRequestContext(KybMerchantInfo kybMerchantInfo) {
        String merchantQrCode = kybMerchantInfo.getMerchantQrCode();
        if (!(merchantQrCode == null || merchantQrCode.length() == 0)) {
            String nmid = kybMerchantInfo.getNmid();
            if (!(nmid == null || nmid.length() == 0)) {
                String merchantQrCode2 = kybMerchantInfo.getMerchantQrCode();
                Intrinsics.checkNotNull(merchantQrCode2);
                String merchantName = kybMerchantInfo.getMerchantName();
                String nmid2 = kybMerchantInfo.getNmid();
                Intrinsics.checkNotNull(nmid2);
                return new KybQrisModel(merchantQrCode2, merchantName, nmid2);
            }
        }
        return null;
    }

    public static final String BuiltInFictitiousFunctionClassFactory(Space space) {
        Object obj;
        Intrinsics.checkNotNullParameter(space, "");
        List<CdpContent> cdpContents = space.getCdpContents();
        Intrinsics.checkNotNullExpressionValue(cdpContents, "");
        Iterator<T> it = cdpContents.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((CdpContent) obj).getContentName(), "nsscode")) {
                break;
            }
        }
        CdpContent cdpContent = (CdpContent) obj;
        if (cdpContent != null) {
            return cdpContent.getContentValue();
        }
        return null;
    }

    public static final List<KybServiceModel> BuiltInFictitiousFunctionClassFactory(List<KybService> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<KybService> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(PlaceComponentResult((KybService) it.next()));
        }
        return arrayList;
    }

    public static final KybServiceModel PlaceComponentResult(KybService kybService) {
        KybServiceRedirectValueModel kybServiceRedirectValueModel;
        Iterator it;
        KybServiceMessageModel kybServiceMessageModel;
        Intrinsics.checkNotNullParameter(kybService, "");
        String icon = kybService.getIcon();
        String name = kybService.getName();
        String name2 = kybService.getName();
        String replace$default = name2 != null ? StringsKt.replace$default(name2, "\n", " ", false, 4, (Object) null) : null;
        if (replace$default == null) {
            replace$default = "";
        }
        String categoryName = kybService.getCategoryName();
        String redirectType = kybService.getRedirectType();
        KybServiceRedirectValue redirectValue = kybService.getRedirectValue();
        if (redirectValue != null) {
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
            List<KybServiceRule> rules = redirectValue.getRules();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(rules, 10));
            Iterator it2 = rules.iterator();
            while (it2.hasNext()) {
                KybServiceRule kybServiceRule = (KybServiceRule) it2.next();
                String rule = kybServiceRule.getRule();
                Object value = kybServiceRule.getValue();
                KybServiceMessage message = kybServiceRule.getMessage();
                if (message != null) {
                    it = it2;
                    kybServiceMessageModel = new KybServiceMessageModel(message.getTitle(), message.getMessage(), message.getImage());
                } else {
                    it = it2;
                    kybServiceMessageModel = null;
                }
                arrayList.add(new KybServiceRuleModel(rule, value, kybServiceMessageModel));
                it2 = it;
            }
            kybServiceRedirectValueModel = new KybServiceRedirectValueModel(additionalQuery, clientId, scopes, agreed, url, openNewWindow, apiName, minVersion, apiPayload, action, arrayList);
        } else {
            kybServiceRedirectValueModel = null;
        }
        return new KybServiceModel(icon, name, replace$default, categoryName, redirectType, kybServiceRedirectValueModel);
    }

    private static final MerchantContractInfoModel BuiltInFictitiousFunctionClassFactory(List<MerchantContractInfo> list, String str) {
        if (list != null) {
            for (MerchantContractInfo merchantContractInfo : list) {
                if (StringsKt.equals("P2M", merchantContractInfo.getProductName(), true)) {
                    return new MerchantContractInfoModel(str, merchantContractInfo.getProductCode(), merchantContractInfo.getProductName());
                }
            }
            return null;
        }
        return null;
    }

    private static final String KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        return !(Intrinsics.areEqual(str, KybUpgradeTierUrgencyLevel.HIGH) ? true : Intrinsics.areEqual(str, KybUpgradeTierUrgencyLevel.LOW)) ? "NONE" : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x001e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final id.dana.kyb.model.BalanceModel PlaceComponentResult(id.dana.domain.nearbyme.model.MoneyView r6, id.dana.domain.nearbyme.model.MoneyView r7) {
        /*
            r0 = 0
            java.lang.String r2 = ""
            if (r6 == 0) goto L1a
            java.lang.String r3 = r6.getCurrency()
            java.lang.String r6 = r6.getAmount()     // Catch: java.lang.Exception -> L1b
            java.lang.String r6 = id.dana.data.util.NumberUtils.getCleanAll(r6)     // Catch: java.lang.Exception -> L1b
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)     // Catch: java.lang.Exception -> L1b
            long r4 = java.lang.Long.parseLong(r6)     // Catch: java.lang.Exception -> L1b
            goto L1c
        L1a:
            r3 = r2
        L1b:
            r4 = r0
        L1c:
            if (r7 == 0) goto L2d
            java.lang.String r6 = r7.getAmount()     // Catch: java.lang.Exception -> L2d
            java.lang.String r6 = id.dana.data.util.NumberUtils.getCleanAll(r6)     // Catch: java.lang.Exception -> L2d
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)     // Catch: java.lang.Exception -> L2d
            long r0 = java.lang.Long.parseLong(r6)     // Catch: java.lang.Exception -> L2d
        L2d:
            long r6 = r4 + r0
            java.lang.String r6 = BuiltInFictitiousFunctionClassFactory(r3, r6)
            java.lang.String r7 = BuiltInFictitiousFunctionClassFactory(r3, r4)
            java.lang.String r0 = BuiltInFictitiousFunctionClassFactory(r3, r0)
            id.dana.kyb.model.BalanceModel r1 = new id.dana.kyb.model.BalanceModel
            r1.<init>(r6, r0, r7)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.mapper.KybModelMapperKt.PlaceComponentResult(id.dana.domain.nearbyme.model.MoneyView, id.dana.domain.nearbyme.model.MoneyView):id.dana.kyb.model.BalanceModel");
    }

    private static final String BuiltInFictitiousFunctionClassFactory(String str, long j) {
        String format;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        format = NumberFormat.getNumberInstance(LocaleUtil.getAuthRequestContext()).format(j);
        sb.append(format);
        return sb.toString();
    }

    private static final boolean BuiltInFictitiousFunctionClassFactory(KybTransactionOrderInfo kybTransactionOrderInfo) {
        return Intrinsics.areEqual(kybTransactionOrderInfo.getProductCode(), "51051000101000100072") && Intrinsics.areEqual(kybTransactionOrderInfo.getInOut(), "IN");
    }

    private static final boolean getAuthRequestContext(KybTransactionOrderInfo kybTransactionOrderInfo) {
        return Intrinsics.areEqual(kybTransactionOrderInfo.getOrderType(), OrderType.REFUND) || Intrinsics.areEqual(kybTransactionOrderInfo.getOrderType(), OrderType.ADJUSTMENT_REFUND);
    }

    private static final boolean KClassImpl$Data$declaredNonStaticMembers$2(KybTransactionOrderInfo kybTransactionOrderInfo) {
        return Intrinsics.areEqual(kybTransactionOrderInfo.getOrderType(), OrderType.ADJUSTMENT_PAYMENT);
    }

    private static final boolean MyBillsEntityDataFactory(KybTransactionOrderInfo kybTransactionOrderInfo) {
        return Intrinsics.areEqual(kybTransactionOrderInfo.getInOut(), "IN");
    }

    private static final boolean PlaceComponentResult(KybTransactionOrderInfo kybTransactionOrderInfo) {
        return MyBillsEntityDataFactory(kybTransactionOrderInfo) && !kybTransactionOrderInfo.getOffUsMerchant();
    }
}
