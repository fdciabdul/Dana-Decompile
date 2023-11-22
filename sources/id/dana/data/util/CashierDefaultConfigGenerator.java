package id.dana.data.util;

import id.dana.data.cancelsurvey.model.CancellationSurveyConfigModel;
import id.dana.data.config.source.amcs.result.CashierMerchantWhitelistConfigResult;
import id.dana.data.config.source.amcs.result.CashierPaymentAutorouteConfigResult;
import id.dana.domain.featureconfig.model.ExpressPayInfo;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/data/util/CashierDefaultConfigGenerator;", "", "Lid/dana/data/cancelsurvey/model/CancellationSurveyConfigModel;", "createCancellationSurveyConfig", "()Lid/dana/data/cancelsurvey/model/CancellationSurveyConfigModel;", "Lid/dana/data/config/source/amcs/result/CashierMerchantWhitelistConfigResult;", "createCashierMerchantWhitelist", "()Lid/dana/data/config/source/amcs/result/CashierMerchantWhitelistConfigResult;", "Lorg/json/JSONArray;", "createCashierNativeEntryPoints", "()Lorg/json/JSONArray;", "Lid/dana/data/config/source/amcs/result/CashierPaymentAutorouteConfigResult;", "createCashierPaymentAutorouteConfig", "()Lid/dana/data/config/source/amcs/result/CashierPaymentAutorouteConfigResult;", "Lid/dana/domain/featureconfig/model/ExpressPayInfo;", "createExpressPayInfo", "()Lid/dana/domain/featureconfig/model/ExpressPayInfo;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CashierDefaultConfigGenerator {
    public static final CashierDefaultConfigGenerator INSTANCE = new CashierDefaultConfigGenerator();

    private CashierDefaultConfigGenerator() {
    }

    public final CashierMerchantWhitelistConfigResult createCashierMerchantWhitelist() {
        return new CashierMerchantWhitelistConfigResult("", CollectionsKt.listOf("0"));
    }

    public final ExpressPayInfo createExpressPayInfo() {
        ExpressPayInfo expressPayInfo = new ExpressPayInfo();
        expressPayInfo.setEnableInP2P(false);
        expressPayInfo.setEnableInQR(false);
        return expressPayInfo;
    }

    public final CancellationSurveyConfigModel createCancellationSurveyConfig() {
        return new CancellationSurveyConfigModel(false, null, null, 6, null);
    }

    public final JSONArray createCashierNativeEntryPoints() {
        String lowerCase = "innovation".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return new JSONArray(new String[]{lowerCase});
    }

    public final CashierPaymentAutorouteConfigResult createCashierPaymentAutorouteConfig() {
        return new CashierPaymentAutorouteConfigResult(0);
    }
}
