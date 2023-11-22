package id.dana.domain.expresspurchase.interaction;

import com.iap.ac.android.acs.plugin.utils.Constants;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.domain.authcode.AuthCodeResult;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.expresspurchase.constant.TemplateType;
import id.dana.domain.expresspurchase.interaction.model.GoldValidationInfo;
import id.dana.domain.expresspurchase.interaction.model.QuickBuyGold;
import id.dana.domain.expresspurchase.interaction.model.ServiceEmasConfig;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import id.dana.domain.oauth.repository.OauthRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u0019\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\n\u001a\u001a\u0012\b\u0012\u0006*\u00020\t0\t*\f\u0012\b\u0012\u0006*\u00020\t0\t0\u00050\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/GetQuickBuyGold;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/expresspurchase/interaction/model/QuickBuyGold;", "Lid/dana/domain/expresspurchase/interaction/GetQuickBuyGold$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/expresspurchase/interaction/GetQuickBuyGold$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/expresspurchase/interaction/model/ServiceEmasConfig;", "Lid/dana/domain/authcode/AuthCodeResult;", Constants.JS_API_GET_AUTH_CODE, "(Lid/dana/domain/expresspurchase/interaction/model/ServiceEmasConfig;)Lio/reactivex/Observable;", "", "authCode", "getQuickBuyGold", "(Lid/dana/domain/expresspurchase/interaction/GetQuickBuyGold$Params;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/expresspurchase/interaction/model/GoldValidationInfo;", "validateGoldPrice", "Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;", "expressPurchaseRepository", "Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;", "Lid/dana/domain/oauth/repository/OauthRepository;", "oAuthRepository", "Lid/dana/domain/oauth/repository/OauthRepository;", "<init>", "(Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;Lid/dana/domain/oauth/repository/OauthRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetQuickBuyGold extends BaseUseCase<QuickBuyGold, Params> {
    private final ExpressPurchaseRepository expressPurchaseRepository;
    private final OauthRepository oAuthRepository;

    @Inject
    public GetQuickBuyGold(ExpressPurchaseRepository expressPurchaseRepository, OauthRepository oauthRepository) {
        Intrinsics.checkNotNullParameter(expressPurchaseRepository, "");
        Intrinsics.checkNotNullParameter(oauthRepository, "");
        this.expressPurchaseRepository = expressPurchaseRepository;
        this.oAuthRepository = oauthRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<QuickBuyGold> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable flatMap = validateGoldPrice(params).flatMap(new Function() { // from class: id.dana.domain.expresspurchase.interaction.GetQuickBuyGold$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2316buildUseCase$lambda2;
                m2316buildUseCase$lambda2 = GetQuickBuyGold.m2316buildUseCase$lambda2(GetQuickBuyGold.this, params, (GoldValidationInfo) obj);
                return m2316buildUseCase$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2  reason: not valid java name */
    public static final ObservableSource m2316buildUseCase$lambda2(final GetQuickBuyGold getQuickBuyGold, final Params params, GoldValidationInfo goldValidationInfo) {
        ObservableSource flatMap;
        Intrinsics.checkNotNullParameter(getQuickBuyGold, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(goldValidationInfo, "");
        String errorCode = goldValidationInfo.getErrorCode();
        boolean z = false;
        if (errorCode != null) {
            if (errorCode.length() > 0) {
                z = true;
            }
        }
        if (z) {
            flatMap = Observable.just(new QuickBuyGold(goldValidationInfo, null, null, null, 14, null));
        } else {
            flatMap = getQuickBuyGold.expressPurchaseRepository.getServiceEmasConfig().flatMap(new Function() { // from class: id.dana.domain.expresspurchase.interaction.GetQuickBuyGold$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ObservableSource m2317buildUseCase$lambda2$lambda1;
                    m2317buildUseCase$lambda2$lambda1 = GetQuickBuyGold.m2317buildUseCase$lambda2$lambda1(GetQuickBuyGold.this, params, (ServiceEmasConfig) obj);
                    return m2317buildUseCase$lambda2$lambda1;
                }
            });
        }
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2$lambda-1  reason: not valid java name */
    public static final ObservableSource m2317buildUseCase$lambda2$lambda1(final GetQuickBuyGold getQuickBuyGold, final Params params, ServiceEmasConfig serviceEmasConfig) {
        Intrinsics.checkNotNullParameter(getQuickBuyGold, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(serviceEmasConfig, "");
        return getQuickBuyGold.getAuthCode(serviceEmasConfig).flatMap(new Function() { // from class: id.dana.domain.expresspurchase.interaction.GetQuickBuyGold$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2318buildUseCase$lambda2$lambda1$lambda0;
                m2318buildUseCase$lambda2$lambda1$lambda0 = GetQuickBuyGold.m2318buildUseCase$lambda2$lambda1$lambda0(GetQuickBuyGold.this, params, (AuthCodeResult) obj);
                return m2318buildUseCase$lambda2$lambda1$lambda0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2$lambda-1$lambda-0  reason: not valid java name */
    public static final ObservableSource m2318buildUseCase$lambda2$lambda1$lambda0(GetQuickBuyGold getQuickBuyGold, Params params, AuthCodeResult authCodeResult) {
        Intrinsics.checkNotNullParameter(getQuickBuyGold, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(authCodeResult, "");
        String authCode = authCodeResult.getAuthCode();
        Intrinsics.checkNotNullExpressionValue(authCode, "");
        return getQuickBuyGold.getQuickBuyGold(params, authCode);
    }

    private final Observable<QuickBuyGold> getQuickBuyGold(Params params, String authCode) {
        return this.expressPurchaseRepository.getQuickBuyGold(params.getGoodsId(), params.getAggregatorGoodsId(), params.getExtendInfo(), params.getCashierOrderId(), params.getEpTemplateType(), params.getThirdRefId(), authCode);
    }

    private final Observable<GoldValidationInfo> validateGoldPrice(Params params) {
        return this.expressPurchaseRepository.validateGoldProduct(params.getGoodsId(), params.getValidationTypes(), params.getValidationInfo());
    }

    private final Observable<AuthCodeResult> getAuthCode(ServiceEmasConfig params) {
        return this.oAuthRepository.getAuthCode(params.getRedirectUrl(), params.getClientId(), params.getScopes(), true, "", "", false);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\f\u0012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000f\u0010\bJ~\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0003\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\u0004R\u0017\u0010\u0011\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\b$\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b%\u0010\u0004R&\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b'\u0010\bR\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\"\u001a\u0004\b(\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b)\u0010\u0004R&\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b*\u0010\bR \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010\u000e"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/GetQuickBuyGold$Params;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/util/Map;", "component4", "component5", "component6", "", "component7", "()Ljava/util/List;", "component8", "goodsId", "aggregatorGoodsId", "extendInfo", CashierKeyParams.CASHIER_ORDER_ID, "epTemplateType", "thirdRefId", "validationTypes", "validationInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)Lid/dana/domain/expresspurchase/interaction/GetQuickBuyGold$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAggregatorGoodsId", "getCashierOrderId", "getEpTemplateType", "Ljava/util/Map;", "getExtendInfo", "getGoodsId", "getThirdRefId", "getValidationInfo", "Ljava/util/List;", "getValidationTypes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Params {
        private final String aggregatorGoodsId;
        private final String cashierOrderId;
        private final String epTemplateType;
        private final Map<String, String> extendInfo;
        private final String goodsId;
        private final String thirdRefId;
        private final Map<String, Object> validationInfo;
        private final List<String> validationTypes;

        /* renamed from: component1  reason: from getter */
        public final String getGoodsId() {
            return this.goodsId;
        }

        /* renamed from: component2  reason: from getter */
        public final String getAggregatorGoodsId() {
            return this.aggregatorGoodsId;
        }

        public final Map<String, String> component3() {
            return this.extendInfo;
        }

        /* renamed from: component4  reason: from getter */
        public final String getCashierOrderId() {
            return this.cashierOrderId;
        }

        /* renamed from: component5  reason: from getter */
        public final String getEpTemplateType() {
            return this.epTemplateType;
        }

        /* renamed from: component6  reason: from getter */
        public final String getThirdRefId() {
            return this.thirdRefId;
        }

        public final List<String> component7() {
            return this.validationTypes;
        }

        public final Map<String, Object> component8() {
            return this.validationInfo;
        }

        public final Params copy(String goodsId, String aggregatorGoodsId, Map<String, String> extendInfo, String cashierOrderId, @TemplateType String epTemplateType, String thirdRefId, List<String> validationTypes, Map<String, ? extends Object> validationInfo) {
            Intrinsics.checkNotNullParameter(goodsId, "");
            Intrinsics.checkNotNullParameter(aggregatorGoodsId, "");
            Intrinsics.checkNotNullParameter(extendInfo, "");
            Intrinsics.checkNotNullParameter(cashierOrderId, "");
            Intrinsics.checkNotNullParameter(epTemplateType, "");
            Intrinsics.checkNotNullParameter(thirdRefId, "");
            Intrinsics.checkNotNullParameter(validationTypes, "");
            Intrinsics.checkNotNullParameter(validationInfo, "");
            return new Params(goodsId, aggregatorGoodsId, extendInfo, cashierOrderId, epTemplateType, thirdRefId, validationTypes, validationInfo);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.goodsId, params.goodsId) && Intrinsics.areEqual(this.aggregatorGoodsId, params.aggregatorGoodsId) && Intrinsics.areEqual(this.extendInfo, params.extendInfo) && Intrinsics.areEqual(this.cashierOrderId, params.cashierOrderId) && Intrinsics.areEqual(this.epTemplateType, params.epTemplateType) && Intrinsics.areEqual(this.thirdRefId, params.thirdRefId) && Intrinsics.areEqual(this.validationTypes, params.validationTypes) && Intrinsics.areEqual(this.validationInfo, params.validationInfo);
            }
            return false;
        }

        public final int hashCode() {
            return (((((((((((((this.goodsId.hashCode() * 31) + this.aggregatorGoodsId.hashCode()) * 31) + this.extendInfo.hashCode()) * 31) + this.cashierOrderId.hashCode()) * 31) + this.epTemplateType.hashCode()) * 31) + this.thirdRefId.hashCode()) * 31) + this.validationTypes.hashCode()) * 31) + this.validationInfo.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(goodsId=");
            sb.append(this.goodsId);
            sb.append(", aggregatorGoodsId=");
            sb.append(this.aggregatorGoodsId);
            sb.append(", extendInfo=");
            sb.append(this.extendInfo);
            sb.append(", cashierOrderId=");
            sb.append(this.cashierOrderId);
            sb.append(", epTemplateType=");
            sb.append(this.epTemplateType);
            sb.append(", thirdRefId=");
            sb.append(this.thirdRefId);
            sb.append(", validationTypes=");
            sb.append(this.validationTypes);
            sb.append(", validationInfo=");
            sb.append(this.validationInfo);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2, Map<String, String> map, String str3, @TemplateType String str4, String str5, List<String> list, Map<String, ? extends Object> map2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(map, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(map2, "");
            this.goodsId = str;
            this.aggregatorGoodsId = str2;
            this.extendInfo = map;
            this.cashierOrderId = str3;
            this.epTemplateType = str4;
            this.thirdRefId = str5;
            this.validationTypes = list;
            this.validationInfo = map2;
        }

        @JvmName(name = "getGoodsId")
        public final String getGoodsId() {
            return this.goodsId;
        }

        @JvmName(name = "getAggregatorGoodsId")
        public final String getAggregatorGoodsId() {
            return this.aggregatorGoodsId;
        }

        @JvmName(name = "getExtendInfo")
        public final Map<String, String> getExtendInfo() {
            return this.extendInfo;
        }

        @JvmName(name = "getCashierOrderId")
        public final String getCashierOrderId() {
            return this.cashierOrderId;
        }

        @JvmName(name = "getEpTemplateType")
        public final String getEpTemplateType() {
            return this.epTemplateType;
        }

        @JvmName(name = "getThirdRefId")
        public final String getThirdRefId() {
            return this.thirdRefId;
        }

        @JvmName(name = "getValidationTypes")
        public final List<String> getValidationTypes() {
            return this.validationTypes;
        }

        @JvmName(name = "getValidationInfo")
        public final Map<String, Object> getValidationInfo() {
            return this.validationInfo;
        }
    }
}
