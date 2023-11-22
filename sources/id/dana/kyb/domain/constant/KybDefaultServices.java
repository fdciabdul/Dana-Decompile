package id.dana.kyb.domain.constant;

import id.dana.kyb.constant.KybServiceAction;
import id.dana.kyb.constant.KybServiceRedirectType;
import id.dana.kyb.constant.KybServiceRules;
import id.dana.kyb.domain.model.KybService;
import id.dana.kyb.domain.model.KybServiceMessage;
import id.dana.kyb.domain.model.KybServiceRedirectValue;
import id.dana.kyb.domain.model.KybServiceRule;
import id.dana.onboarding.OnboardingParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\n\u0010\t"}, d2 = {"Lid/dana/kyb/domain/constant/KybDefaultServices;", "", "", "p0", "Lid/dana/kyb/domain/model/KybService;", "getAuthRequestContext", "(Ljava/lang/String;)Lid/dana/kyb/domain/model/KybService;", "", "PlaceComponentResult", "()Ljava/util/List;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybDefaultServices {
    public static final KybDefaultServices INSTANCE = new KybDefaultServices();

    private KybDefaultServices() {
    }

    @JvmName(name = "PlaceComponentResult")
    public static List<String> PlaceComponentResult() {
        return CollectionsKt.listOf((Object[]) new String[]{KybServiceCategory.DIGITAL_MONEY, KybServiceCategory.BUSINESS_EDUCATION, KybServiceCategory.MOBILE_RECHARGE, KybServiceCategory.PROMO, KybServiceCategory.GAMES});
    }

    public static KybService getAuthRequestContext(@KybServiceCategory String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        switch (p0.hashCode()) {
            case -1915984177:
                if (p0.equals(KybServiceCategory.QRIS_BUSINESS)) {
                    return new KybService(true, "https://a.m.dana.id/resource/icons/kyb-services/kyb-services-business-qris.png", "QRIS Bisnis", p0, "ACTION", new KybServiceRedirectValue(null, null, null, null, null, false, null, null, null, KybServiceAction.QRIS_BUSINESS, CollectionsKt.emptyList(), 511, null));
                }
                break;
            case -1761499071:
                if (p0.equals(KybServiceCategory.REQUEST_PAYMENT)) {
                    return new KybService(true, "https://a.m.dana.id/resource/icons/kyb-services/kyb-services-req-payment.png", "Minta Pembayaran", p0, "ACTION", new KybServiceRedirectValue(null, null, null, null, null, false, null, null, null, KybServiceAction.REQUEST_PAYMENT, CollectionsKt.emptyList(), 511, null));
                }
                break;
            case -842102242:
                if (p0.equals(KybServiceCategory.BUSINESS_EDUCATION)) {
                    return new KybService(true, "https://a.m.dana.id/resource/imgs/kyb/kyb-dana-bisnis-portal.png", "Edukasi Bisnis", p0, "URL", new KybServiceRedirectValue(null, null, null, null, "https://a.m.dana.id/promo/dananews-landingpage/DANANewsBikinJadiBisaKYB3.html", false, null, null, null, null, CollectionsKt.emptyList(), 1007, null));
                }
                break;
            case 617801836:
                if (p0.equals(KybServiceCategory.GAMES)) {
                    return new KybService(true, "https://m.dana.id/resource/imgs/entrance/games.svg", "Games", p0, "URL", new KybServiceRedirectValue(null, null, null, null, "https://m.dana.id/m/games", false, null, null, null, null, CollectionsKt.emptyList(), 1007, null));
                }
                break;
            case 626622138:
                if (p0.equals(KybServiceCategory.PROMO)) {
                    return new KybService(true, "https://a.m.dana.id/merchant-portal/app/assets/promo.svg", "Promo", p0, KybServiceRedirectType.AUTH, new KybServiceRedirectValue(CollectionsKt.arrayListOf(OnboardingParams.FIRST_TIME_TOP_UP, "requestId=eea20b56b89ed3c6b3676c4074515890"), "2019052801270371642754", "PUBLIC_ID,CASHIER,AGREEMENT_PAY,QUERY_BALANCE,DEFAULT_BASIC_PROFILE,MINI_DANA,MERCHANT_PORTAL", "1", "https://dashboard.dana.id/kyb?entryPage=campaign", false, null, null, null, null, CollectionsKt.arrayListOf(new KybServiceRule(KybServiceRules.TIERS, CollectionsKt.arrayListOf("5", "10"), null), new KybServiceRule(KybServiceRules.MINIMUM_TRANSACTION, 10, new KybServiceMessage("Ups, belum bisa buat promo", "Kamu harus terima minimal 10 transaksi dulu. Yuk tingkatkan penjualan!", "https://m.dana.id/resource/imgs/entrance/games.svg"))), 992, null));
                }
                break;
            case 1363644815:
                if (p0.equals(KybServiceCategory.MOBILE_RECHARGE)) {
                    return new KybService(true, "https://a.m.dana.id/resource/services/icon_mobile_recharge_new.png", "Pulsa", p0, "URL", new KybServiceRedirectValue(null, null, null, null, "https://m.dana.id/i/mobilerecharge/index", false, null, null, null, null, CollectionsKt.emptyList(), 1007, null));
                }
                break;
            case 1433620660:
                if (p0.equals(KybServiceCategory.PRODUCT_CATALOG)) {
                    return new KybService(true, "https://a.m.dana.id/resource/icons/kyb-services/kyb-services-product-catalog.png", "Katalog Produk", p0, "URL", new KybServiceRedirectValue(null, null, null, null, "/i/kyb/linkmanagement", false, null, null, null, null, CollectionsKt.emptyList(), 1007, null));
                }
                break;
            case 1948211844:
                if (p0.equals(KybServiceCategory.DIGITAL_MONEY)) {
                    return new KybService(true, "https://innovation-anteiku-s3.s3-ap-southeast-1.amazonaws.com/prod/images/FILES_1584678246462.png", "Saldo Digital", p0, KybServiceRedirectType.AUTH, new KybServiceRedirectValue(CollectionsKt.arrayListOf("requestId=28318a1b8f3eb6d9d7e17541e8428174"), "2021111707303335725240", "PUBLIC_ID,TRANSFER_MONEY,DEFAULT_BASIC_PROFILE", "1", "https://billers.m.dana.id/SVC-b0546a48?env=prod", false, null, null, null, null, CollectionsKt.emptyList(), 992, null));
                }
                break;
        }
        return new KybService(false, null, null, null, null, null, 62, null);
    }
}
