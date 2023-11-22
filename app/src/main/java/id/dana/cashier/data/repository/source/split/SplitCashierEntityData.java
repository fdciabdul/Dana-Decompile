package id.dana.cashier.data.repository.source.split;

import android.os.Process;
import android.view.ViewConfiguration;
import id.dana.cashier.data.repository.source.CashierEntityData;
import id.dana.cashier.data.repository.source.network.request.AddAssetCardForUserEntityRequest;
import id.dana.cashier.data.repository.source.network.request.AdditionalPaylaterCashierPayRequest;
import id.dana.cashier.data.repository.source.network.request.CashierAddOnModalTooltipEntityRequest;
import id.dana.cashier.data.repository.source.network.request.CashierAgreementEntityRequest;
import id.dana.cashier.data.repository.source.network.request.CashierPayEntityRequest;
import id.dana.cashier.data.repository.source.network.request.CashierUpdateOrderEntityRequest;
import id.dana.cashier.data.repository.source.network.request.CreateOrderEntityRequest;
import id.dana.cashier.data.repository.source.network.request.FetchBannerEntityRequest;
import id.dana.cashier.data.repository.source.network.request.GetCashierKybProductEntityRequest;
import id.dana.cashier.data.repository.source.network.request.QueryCardPolicyRequest;
import id.dana.cashier.data.repository.source.network.request.QueryInstallmentEntityRequest;
import id.dana.cashier.data.repository.source.network.request.QueryPayOptionRequest;
import id.dana.cashier.data.repository.source.network.request.QueryPromotionEntityRequest;
import id.dana.cashier.data.repository.source.network.request.TopUpConsultEntityRequest;
import id.dana.cashier.data.repository.source.network.request.TopUpSubmitEntityRequest;
import id.dana.cashier.data.repository.source.network.request.TopUpVerifyEntityRequest;
import id.dana.cashier.data.repository.source.network.request.npssurvey.NpsSurveyConsultEntityRequest;
import id.dana.cashier.data.repository.source.network.request.npssurvey.NpsSurveySubmitEntityRequest;
import id.dana.cashier.data.repository.source.network.result.CashierHighlightConfigResult;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.A;
import org.json.JSONArray;

@Singleton
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/cashier/data/repository/source/split/SplitCashierEntityData;", "Lid/dana/cashier/data/repository/source/CashierEntityData;", "Lio/reactivex/Observable;", "Lid/dana/cashier/data/repository/source/network/result/CashierHighlightConfigResult;", "getCashierHighlightConfig", "()Lio/reactivex/Observable;", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SplitCashierEntityData implements CashierEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int MyBillsEntityDataFactory = 269894669;
    private static int PlaceComponentResult;
    private final SplitFacade splitFacade;

    public static /* synthetic */ CashierHighlightConfigResult $r8$lambda$q7MnyMFik0a_5ggTJ3eZYSK9bpw(BaseTrafficType baseTrafficType) {
        int i = PlaceComponentResult + 19;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? 'I' : 'T') != 'T') {
            try {
                CashierHighlightConfigResult m565getCashierHighlightConfig$lambda0 = m565getCashierHighlightConfig$lambda0(baseTrafficType);
                Object obj = null;
                obj.hashCode();
                return m565getCashierHighlightConfig$lambda0;
            } catch (Exception e) {
                throw e;
            }
        }
        return m565getCashierHighlightConfig$lambda0(baseTrafficType);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable addAssetCardForUser(AddAssetCardForUserEntityRequest addAssetCardForUserEntityRequest) {
        int i = PlaceComponentResult + 21;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        char c = i % 2 == 0 ? '@' : 'B';
        Observable $default$addAssetCardForUser = CashierEntityData.CC.$default$addAssetCardForUser(this, addAssetCardForUserEntityRequest);
        if (c != 'B') {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 103;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        return $default$addAssetCardForUser;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable createCashierEKtpAgreement(CashierAgreementEntityRequest cashierAgreementEntityRequest) {
        int i = PlaceComponentResult + 21;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            Observable $default$createCashierEKtpAgreement = CashierEntityData.CC.$default$createCashierEKtpAgreement(this, cashierAgreementEntityRequest);
            int i3 = BuiltInFictitiousFunctionClassFactory + 63;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return $default$createCashierEKtpAgreement;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable doCashierPay(CashierPayEntityRequest cashierPayEntityRequest, AdditionalPaylaterCashierPayRequest additionalPaylaterCashierPayRequest) {
        int i = PlaceComponentResult + 89;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        boolean z = i % 2 == 0;
        Observable $default$doCashierPay = CashierEntityData.CC.$default$doCashierPay(this, cashierPayEntityRequest, additionalPaylaterCashierPayRequest);
        if (z) {
            int i2 = 85 / 0;
        }
        return $default$doCashierPay;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable doCreateOrder(CreateOrderEntityRequest createOrderEntityRequest) {
        int i = BuiltInFictitiousFunctionClassFactory + 81;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 != 0;
        Observable $default$doCreateOrder = CashierEntityData.CC.$default$doCreateOrder(this, createOrderEntityRequest);
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return $default$doCreateOrder;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable fetchBanner(FetchBannerEntityRequest fetchBannerEntityRequest) {
        int i = BuiltInFictitiousFunctionClassFactory + 35;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Observable $default$fetchBanner = CashierEntityData.CC.$default$fetchBanner(this, fetchBannerEntityRequest);
        int i3 = BuiltInFictitiousFunctionClassFactory + 51;
        PlaceComponentResult = i3 % 128;
        int i4 = i3 % 2;
        return $default$fetchBanner;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable fetchNpsSurvey(NpsSurveyConsultEntityRequest npsSurveyConsultEntityRequest) {
        int i = PlaceComponentResult + 57;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? 'T' : (char) 25) != 'T') {
            return CashierEntityData.CC.$default$fetchNpsSurvey(this, npsSurveyConsultEntityRequest);
        }
        try {
            Observable $default$fetchNpsSurvey = CashierEntityData.CC.$default$fetchNpsSurvey(this, npsSurveyConsultEntityRequest);
            Object[] objArr = null;
            int length = objArr.length;
            return $default$fetchNpsSurvey;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getCashierKybProduct(GetCashierKybProductEntityRequest getCashierKybProductEntityRequest) {
        Observable $default$getCashierKybProduct;
        int i = PlaceComponentResult + 69;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? (char) 5 : 'I') != 'I') {
            try {
                $default$getCashierKybProduct = CashierEntityData.CC.$default$getCashierKybProduct(this, getCashierKybProductEntityRequest);
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } else {
            $default$getCashierKybProduct = CashierEntityData.CC.$default$getCashierKybProduct(this, getCashierKybProductEntityRequest);
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 63;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        return $default$getCashierKybProduct;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getCurrencyFromCdn() {
        int i = BuiltInFictitiousFunctionClassFactory + 45;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? '.' : Typography.greater) != '.') {
            return CashierEntityData.CC.$default$getCurrencyFromCdn(this);
        }
        Observable $default$getCurrencyFromCdn = CashierEntityData.CC.$default$getCurrencyFromCdn(this);
        Object[] objArr = null;
        int length = objArr.length;
        return $default$getCurrencyFromCdn;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getHighlightNewInstId(String str) {
        int i = PlaceComponentResult + 57;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            Observable $default$getHighlightNewInstId = CashierEntityData.CC.$default$getHighlightNewInstId(this, str);
            int i3 = BuiltInFictitiousFunctionClassFactory + 53;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return $default$getHighlightNewInstId;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getHighlightTimeShown(String str, String str2, String str3) {
        int i = PlaceComponentResult + 119;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            Observable $default$getHighlightTimeShown = CashierEntityData.CC.$default$getHighlightTimeShown(this, str, str2, str3);
            int i3 = PlaceComponentResult + 95;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return $default$getHighlightTimeShown;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getHighlightVersion(String str, String str2) {
        Observable $default$getHighlightVersion;
        int i = PlaceComponentResult + 83;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? 'Q' : ':') != ':') {
            try {
                $default$getHighlightVersion = CashierEntityData.CC.$default$getHighlightVersion(this, str, str2);
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } else {
            $default$getHighlightVersion = CashierEntityData.CC.$default$getHighlightVersion(this, str, str2);
        }
        int i2 = PlaceComponentResult + 117;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        if ((i2 % 2 == 0 ? (char) 15 : 'c') != 'c') {
            objArr.hashCode();
            return $default$getHighlightVersion;
        }
        return $default$getHighlightVersion;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getLastTimeSmartPayActivationShow(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 73;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Observable $default$getLastTimeSmartPayActivationShow = CashierEntityData.CC.$default$getLastTimeSmartPayActivationShow(this, str);
        int i3 = PlaceComponentResult + 11;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if ((i3 % 2 == 0 ? 'b' : '7') != '7') {
            Object[] objArr = null;
            int length = objArr.length;
            return $default$getLastTimeSmartPayActivationShow;
        }
        return $default$getLastTimeSmartPayActivationShow;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getModalCategory() {
        Observable $default$getModalCategory;
        int i = BuiltInFictitiousFunctionClassFactory + 47;
        PlaceComponentResult = i % 128;
        if (!(i % 2 == 0)) {
            $default$getModalCategory = CashierEntityData.CC.$default$getModalCategory(this);
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            try {
                $default$getModalCategory = CashierEntityData.CC.$default$getModalCategory(this);
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = PlaceComponentResult + 57;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        return $default$getModalCategory;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getModalContent() {
        Observable $default$getModalContent;
        int i = PlaceComponentResult + 11;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (!(i % 2 == 0)) {
            $default$getModalContent = CashierEntityData.CC.$default$getModalContent(this);
        } else {
            $default$getModalContent = CashierEntityData.CC.$default$getModalContent(this);
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 123;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        return $default$getModalContent;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getOneklikRedirectUrl(String str, String str2) {
        int i = BuiltInFictitiousFunctionClassFactory + 55;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? 'J' : 'N') == 'N') {
            try {
                return CashierEntityData.CC.$default$getOneklikRedirectUrl(this, str, str2);
            } catch (Exception e) {
                throw e;
            }
        }
        Observable $default$getOneklikRedirectUrl = CashierEntityData.CC.$default$getOneklikRedirectUrl(this, str, str2);
        Object[] objArr = null;
        int length = objArr.length;
        return $default$getOneklikRedirectUrl;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getPaylaterCicilRegistrationCacheCooldownCount(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 43;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        try {
            Observable $default$getPaylaterCicilRegistrationCacheCooldownCount = CashierEntityData.CC.$default$getPaylaterCicilRegistrationCacheCooldownCount(this, str);
            int i3 = PlaceComponentResult + 97;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if (i3 % 2 == 0) {
                int i4 = 31 / 0;
                return $default$getPaylaterCicilRegistrationCacheCooldownCount;
            }
            return $default$getPaylaterCicilRegistrationCacheCooldownCount;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getPaylaterCicilRegistrationCacheCooldownDelay(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 73;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? '#' : 'K') != 'K') {
            int i2 = 24 / 0;
            return CashierEntityData.CC.$default$getPaylaterCicilRegistrationCacheCooldownDelay(this, str);
        }
        try {
            return CashierEntityData.CC.$default$getPaylaterCicilRegistrationCacheCooldownDelay(this, str);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getQueryCardPolicyByCardNo(QueryCardPolicyRequest queryCardPolicyRequest) {
        int i = PlaceComponentResult + 117;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        Observable $default$getQueryCardPolicyByCardNo = CashierEntityData.CC.$default$getQueryCardPolicyByCardNo(this, queryCardPolicyRequest);
        int i3 = PlaceComponentResult + 103;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
            return $default$getQueryCardPolicyByCardNo;
        }
        return $default$getQueryCardPolicyByCardNo;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getQueryInstallment(QueryInstallmentEntityRequest queryInstallmentEntityRequest) {
        int i = BuiltInFictitiousFunctionClassFactory + 21;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 != 0;
        Observable $default$getQueryInstallment = CashierEntityData.CC.$default$getQueryInstallment(this, queryInstallmentEntityRequest);
        if (z) {
            int i2 = 27 / 0;
        }
        return $default$getQueryInstallment;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getQueryPayOption(QueryPayOptionRequest queryPayOptionRequest) {
        int i = BuiltInFictitiousFunctionClassFactory + 11;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Observable $default$getQueryPayOption = CashierEntityData.CC.$default$getQueryPayOption(this, queryPayOptionRequest);
        try {
            int i3 = BuiltInFictitiousFunctionClassFactory + 123;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return $default$getQueryPayOption;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getQueryPromotion(QueryPromotionEntityRequest queryPromotionEntityRequest) {
        int i = PlaceComponentResult + 69;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            Observable $default$getQueryPromotion = CashierEntityData.CC.$default$getQueryPromotion(this, queryPromotionEntityRequest);
            int i3 = BuiltInFictitiousFunctionClassFactory + 79;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return $default$getQueryPromotion;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getTooltipContent(CashierAddOnModalTooltipEntityRequest cashierAddOnModalTooltipEntityRequest) {
        try {
            int i = PlaceComponentResult + 3;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            Observable $default$getTooltipContent = CashierEntityData.CC.$default$getTooltipContent(this, cashierAddOnModalTooltipEntityRequest);
            try {
                int i3 = PlaceComponentResult + 117;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return $default$getTooltipContent;
                }
                return $default$getTooltipContent;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getTooltipFromCdn(String str) {
        int i = PlaceComponentResult + 33;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            Observable $default$getTooltipFromCdn = CashierEntityData.CC.$default$getTooltipFromCdn(this, str);
            int i3 = PlaceComponentResult + 35;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if (i3 % 2 != 0) {
                return $default$getTooltipFromCdn;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return $default$getTooltipFromCdn;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getTopUpAgent(TopUpConsultEntityRequest topUpConsultEntityRequest) {
        int i = BuiltInFictitiousFunctionClassFactory + 53;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 == 0;
        Observable $default$getTopUpAgent = CashierEntityData.CC.$default$getTopUpAgent(this, topUpConsultEntityRequest);
        if (!z) {
            int i2 = 25 / 0;
        }
        int i3 = BuiltInFictitiousFunctionClassFactory + 17;
        PlaceComponentResult = i3 % 128;
        if ((i3 % 2 != 0 ? 'V' : 'A') != 'V') {
            return $default$getTopUpAgent;
        }
        int i4 = 21 / 0;
        return $default$getTopUpAgent;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable getTopUpConsult(TopUpConsultEntityRequest topUpConsultEntityRequest) {
        int i = PlaceComponentResult + 83;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        char c = i % 2 == 0 ? '\b' : 'H';
        Observable $default$getTopUpConsult = CashierEntityData.CC.$default$getTopUpConsult(this, topUpConsultEntityRequest);
        if (c == '\b') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return $default$getTopUpConsult;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable saveHighlightNewInstId(String str, String str2) {
        int i = BuiltInFictitiousFunctionClassFactory + 79;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 == 0;
        Observable $default$saveHighlightNewInstId = CashierEntityData.CC.$default$saveHighlightNewInstId(this, str, str2);
        if (!z) {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 51;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        return $default$saveHighlightNewInstId;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable saveHighlightTimeShown(String str, String str2, String str3) {
        Observable $default$saveHighlightTimeShown;
        int i = BuiltInFictitiousFunctionClassFactory + 39;
        PlaceComponentResult = i % 128;
        Object[] objArr = null;
        if ((i % 2 != 0 ? '@' : (char) 15) != '@') {
            try {
                $default$saveHighlightTimeShown = CashierEntityData.CC.$default$saveHighlightTimeShown(this, str, str2, str3);
            } catch (Exception e) {
                throw e;
            }
        } else {
            $default$saveHighlightTimeShown = CashierEntityData.CC.$default$saveHighlightTimeShown(this, str, str2, str3);
            int length = objArr.length;
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 73;
        PlaceComponentResult = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return $default$saveHighlightTimeShown;
        }
        objArr.hashCode();
        return $default$saveHighlightTimeShown;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable saveHighlightVersion(String str, String str2, int i) {
        int i2 = BuiltInFictitiousFunctionClassFactory + 109;
        PlaceComponentResult = i2 % 128;
        if (!(i2 % 2 != 0)) {
            return CashierEntityData.CC.$default$saveHighlightVersion(this, str, str2, i);
        }
        try {
            Observable $default$saveHighlightVersion = CashierEntityData.CC.$default$saveHighlightVersion(this, str, str2, i);
            Object obj = null;
            obj.hashCode();
            return $default$saveHighlightVersion;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable savePaylaterCicilRegistrationCacheCooldownCount(int i, String str) {
        int i2 = BuiltInFictitiousFunctionClassFactory + 7;
        PlaceComponentResult = i2 % 128;
        int i3 = i2 % 2;
        Observable $default$savePaylaterCicilRegistrationCacheCooldownCount = CashierEntityData.CC.$default$savePaylaterCicilRegistrationCacheCooldownCount(this, i, str);
        int i4 = BuiltInFictitiousFunctionClassFactory + 121;
        PlaceComponentResult = i4 % 128;
        if ((i4 % 2 != 0 ? '+' : (char) 20) != 20) {
            Object obj = null;
            obj.hashCode();
            return $default$savePaylaterCicilRegistrationCacheCooldownCount;
        }
        return $default$savePaylaterCicilRegistrationCacheCooldownCount;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable savePaylaterCicilRegistrationCacheCooldownDelay(long j, String str) {
        int i = PlaceComponentResult + 111;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        boolean z = i % 2 == 0;
        Observable $default$savePaylaterCicilRegistrationCacheCooldownDelay = CashierEntityData.CC.$default$savePaylaterCicilRegistrationCacheCooldownDelay(this, j, str);
        if (z) {
            Object obj = null;
            obj.hashCode();
        }
        return $default$savePaylaterCicilRegistrationCacheCooldownDelay;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable setLastSmartPayActivationShow(long j, String str) {
        try {
            int i = PlaceComponentResult + 45;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            try {
                Observable $default$setLastSmartPayActivationShow = CashierEntityData.CC.$default$setLastSmartPayActivationShow(this, j, str);
                int i3 = PlaceComponentResult + 87;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
                return $default$setLastSmartPayActivationShow;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable submitNpsSurvey(NpsSurveySubmitEntityRequest npsSurveySubmitEntityRequest) {
        int i = BuiltInFictitiousFunctionClassFactory + 45;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Observable $default$submitNpsSurvey = CashierEntityData.CC.$default$submitNpsSurvey(this, npsSurveySubmitEntityRequest);
        int i3 = PlaceComponentResult + 19;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if ((i3 % 2 == 0 ? 'A' : Typography.quote) != 'A') {
            return $default$submitNpsSurvey;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return $default$submitNpsSurvey;
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable topUpSubmit(TopUpSubmitEntityRequest topUpSubmitEntityRequest) {
        int i = BuiltInFictitiousFunctionClassFactory + 119;
        PlaceComponentResult = i % 128;
        boolean z = i % 2 == 0;
        Observable $default$topUpSubmit = CashierEntityData.CC.$default$topUpSubmit(this, topUpSubmitEntityRequest);
        if (!z) {
            int i2 = 88 / 0;
        }
        try {
            int i3 = BuiltInFictitiousFunctionClassFactory + 21;
            PlaceComponentResult = i3 % 128;
            if (!(i3 % 2 == 0)) {
                Object[] objArr = null;
                int length = objArr.length;
                return $default$topUpSubmit;
            }
            return $default$topUpSubmit;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable topUpVerify(TopUpVerifyEntityRequest topUpVerifyEntityRequest) {
        int i = PlaceComponentResult + 93;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? '\f' : ';') != ';') {
            try {
                Observable $default$topUpVerify = CashierEntityData.CC.$default$topUpVerify(this, topUpVerifyEntityRequest);
                Object[] objArr = null;
                int length = objArr.length;
                return $default$topUpVerify;
            } catch (Exception e) {
                throw e;
            }
        }
        return CashierEntityData.CC.$default$topUpVerify(this, topUpVerifyEntityRequest);
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final /* synthetic */ Observable updateOrder(CashierUpdateOrderEntityRequest cashierUpdateOrderEntityRequest) {
        Observable $default$updateOrder;
        int i = PlaceComponentResult + 21;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 == 0 ? (char) 14 : Typography.less) != 14) {
            $default$updateOrder = CashierEntityData.CC.$default$updateOrder(this, cashierUpdateOrderEntityRequest);
        } else {
            try {
                $default$updateOrder = CashierEntityData.CC.$default$updateOrder(this, cashierUpdateOrderEntityRequest);
                int i2 = 22 / 0;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            int i3 = PlaceComponentResult + 77;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 17 : 'F') != 17) {
                return $default$updateOrder;
            }
            Object obj = null;
            obj.hashCode();
            return $default$updateOrder;
        } catch (Exception e2) {
            throw e2;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:18:0x000d
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @javax.inject.Inject
    public SplitCashierEntityData(id.dana.data.toggle.SplitFacade r2) {
        /*
            r1 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)     // Catch: java.lang.Exception -> Lb
            r1.<init>()     // Catch: java.lang.Exception -> Lb
            r1.splitFacade = r2     // Catch: java.lang.Exception -> Lb
            return
        Lb:
            r2 = move-exception
            throw r2
        Ld:
            r2 = move-exception
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.data.repository.source.split.SplitCashierEntityData.<init>(id.dana.data.toggle.SplitFacade):void");
    }

    @Override // id.dana.cashier.data.repository.source.CashierEntityData
    public final Observable<CashierHighlightConfigResult> getCashierHighlightConfig() {
        Observable map = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.cashier.data.repository.source.split.SplitCashierEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitCashierEntityData.$r8$lambda$q7MnyMFik0a_5ggTJ3eZYSK9bpw((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        try {
            int i = PlaceComponentResult + 93;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            return map;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getCashierHighlightConfig$lambda-0 */
    private static final CashierHighlightConfigResult m565getCashierHighlightConfig$lambda0(BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        Object cashierHighlightConfigResult = new CashierHighlightConfigResult(null, null, null, null, null, null, null, 127, null);
        Object[] objArr = new Object[1];
        a(new char[]{65535, 1, 0, 65527, 65535, 1, 65534, 6, 7, 65531, '\n', 65533, 1, 0, 11, 65529, 65531, 65527, '\f', 0, 65535, 1, 4, 0}, 144 - (Process.myPid() >> 22), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 23, true, 10 - (ViewConfiguration.getEdgeSlop() >> 16), objArr);
        String authRequestContext = baseTrafficType.getAuthRequestContext(((String) objArr[0]).intern(), false);
        if (CashierHighlightConfigResult.class.isAssignableFrom(JSONArray.class)) {
            cashierHighlightConfigResult = (CashierHighlightConfigResult) new JSONArray(authRequestContext != null ? authRequestContext : "");
            int i = BuiltInFictitiousFunctionClassFactory + 7;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
        } else {
            if (!(authRequestContext == null)) {
                int i3 = BuiltInFictitiousFunctionClassFactory + 21;
                PlaceComponentResult = i3 % 128;
                Object obj = null;
                try {
                    if (i3 % 2 != 0) {
                        Object fromJson = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, null), (Class<Object>) CashierHighlightConfigResult.class);
                        int i4 = 68 / 0;
                        obj = fromJson;
                    } else {
                        obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, null), (Class<Object>) CashierHighlightConfigResult.class);
                    }
                } catch (Exception unused) {
                }
                if (!(obj == null)) {
                    cashierHighlightConfigResult = obj;
                }
            }
        }
        return (CashierHighlightConfigResult) cashierHighlightConfigResult;
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        while (true) {
            if (a2.MyBillsEntityDataFactory >= i2) {
                break;
            }
            a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
            cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
            int i4 = a2.MyBillsEntityDataFactory;
            cArr2[i4] = (char) (cArr2[i4] - ((int) (MyBillsEntityDataFactory ^ (-5694784870793460699L))));
            a2.MyBillsEntityDataFactory++;
        }
        if (i3 > 0) {
            try {
                a2.BuiltInFictitiousFunctionClassFactory = i3;
                char[] cArr3 = new char[i2];
                System.arraycopy(cArr2, 0, cArr3, 0, i2);
                System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
            } catch (Exception e) {
                throw e;
            }
        }
        if (z) {
            int i5 = $10 + 95;
            $11 = i5 % 128;
            if (i5 % 2 == 0) {
            }
            char[] cArr4 = new char[i2];
            a2.MyBillsEntityDataFactory = 0;
            while (true) {
                if ((a2.MyBillsEntityDataFactory < i2 ? (char) 31 : 'A') != 31) {
                    break;
                }
                int i6 = $11 + 57;
                try {
                    $10 = i6 % 128;
                    int i7 = i6 % 2;
                    cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                    a2.MyBillsEntityDataFactory++;
                } catch (Exception e2) {
                    throw e2;
                }
            }
            cArr2 = cArr4;
        }
        objArr[0] = new String(cArr2);
    }
}
