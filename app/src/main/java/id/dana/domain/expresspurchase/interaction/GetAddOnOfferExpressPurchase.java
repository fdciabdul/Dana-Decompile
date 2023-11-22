package id.dana.domain.expresspurchase.interaction;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import com.alibaba.griver.video.H5Constants;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.expresspurchase.interaction.model.AddonInfo;
import id.dana.domain.expresspurchase.interaction.model.AddonOffer;
import id.dana.domain.expresspurchase.interaction.model.ExpressPurchaseConfig;
import id.dana.domain.expresspurchase.interaction.model.LatestExpressPurchaseAction;
import id.dana.domain.expresspurchase.interaction.model.ValidateProduct;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import id.dana.domain.expresspurchase.util.ExpressPurchaseExtKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002()B\u0011\b\u0007\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b&\u0010'J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0007J'\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00102\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0013\u001a\u001a\u0012\b\u0012\u0006*\u00020\u00020\u0002*\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\u00050\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0007J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u0015J)\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00102\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001a\u0010\u0012J%\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00052\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/GetAddOnOfferExpressPurchase;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/expresspurchase/interaction/model/AddonOffer;", "Lid/dana/domain/expresspurchase/interaction/GetAddOnOfferExpressPurchase$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/expresspurchase/interaction/GetAddOnOfferExpressPurchase$Params;)Lio/reactivex/Observable;", "checkAddOnOffer", "Lid/dana/domain/expresspurchase/interaction/model/LatestExpressPurchaseAction;", "lastAction", "Lid/dana/domain/expresspurchase/interaction/model/ExpressPurchaseConfig;", "config", "", "checkCoolDownEP", "(Lid/dana/domain/expresspurchase/interaction/GetAddOnOfferExpressPurchase$Params;Lid/dana/domain/expresspurchase/interaction/model/LatestExpressPurchaseAction;Lid/dana/domain/expresspurchase/interaction/model/ExpressPurchaseConfig;)Z", "Lkotlin/Function1;", "checkOfferEP", "(Lid/dana/domain/expresspurchase/interaction/GetAddOnOfferExpressPurchase$Params;)Lkotlin/jvm/functions/Function1;", "getCashierAddOn", "getConfigExpressPurchase", "()Lio/reactivex/Observable;", "canProceedEP", "isEPCanProceed", "(Lid/dana/domain/expresspurchase/interaction/GetAddOnOfferExpressPurchase$Params;Z)Lio/reactivex/Observable;", "noOffer", "validateOffer", "addonOffer", "validateProductInsurance", "(Lid/dana/domain/expresspurchase/interaction/GetAddOnOfferExpressPurchase$Params;Lid/dana/domain/expresspurchase/interaction/model/AddonOffer;)Lio/reactivex/Observable;", "Lid/dana/domain/expresspurchase/interaction/model/AddonInfo;", "addonInfo", "Lid/dana/domain/expresspurchase/interaction/model/ValidateProduct;", "validateProductIsAvailable", "(Lid/dana/domain/expresspurchase/interaction/model/AddonInfo;Lid/dana/domain/expresspurchase/interaction/GetAddOnOfferExpressPurchase$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;", "expressPurchaseRepository", "Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;", "<init>", "(Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetAddOnOfferExpressPurchase extends BaseUseCase<AddonOffer, Params> {
    public static final long MILIS_IN_A_DAY = 86400000;
    private final ExpressPurchaseRepository expressPurchaseRepository;

    @Inject
    public GetAddOnOfferExpressPurchase(ExpressPurchaseRepository expressPurchaseRepository) {
        Intrinsics.checkNotNullParameter(expressPurchaseRepository, "");
        this.expressPurchaseRepository = expressPurchaseRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<AddonOffer> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return checkAddOnOffer(params);
    }

    private final Observable<AddonOffer> checkAddOnOffer(Params params) {
        Observable<ExpressPurchaseConfig> configExpressPurchase = getConfigExpressPurchase();
        final Function1<ExpressPurchaseConfig, Observable<AddonOffer>> checkOfferEP = checkOfferEP(params);
        Observable flatMap = configExpressPurchase.flatMap(new Function() { // from class: id.dana.domain.expresspurchase.interaction.GetAddOnOfferExpressPurchase$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2298checkAddOnOffer$lambda0;
                m2298checkAddOnOffer$lambda0 = GetAddOnOfferExpressPurchase.m2298checkAddOnOffer$lambda0(Function1.this, (ExpressPurchaseConfig) obj);
                return m2298checkAddOnOffer$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkAddOnOffer$lambda-0  reason: not valid java name */
    public static final ObservableSource m2298checkAddOnOffer$lambda0(Function1 function1, ExpressPurchaseConfig expressPurchaseConfig) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (ObservableSource) function1.invoke(expressPurchaseConfig);
    }

    private final Observable<ExpressPurchaseConfig> getConfigExpressPurchase() {
        return this.expressPurchaseRepository.getExpressPurchaseConfig();
    }

    private final Function1<ExpressPurchaseConfig, Observable<AddonOffer>> checkOfferEP(Params params) {
        return new GetAddOnOfferExpressPurchase$checkOfferEP$1(this, params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkCoolDownEP(Params params, LatestExpressPurchaseAction lastAction, ExpressPurchaseConfig config) {
        boolean z = lastAction.getSuccessTimestamp() == 0 && lastAction.getDismissTimestamp() == 0;
        boolean z2 = lastAction.getSuccessTimestamp() == -1 && lastAction.getDismissTimestamp() == -1;
        boolean z3 = lastAction.getSuccessTimestamp() > 0 && lastAction.getSuccessTimestamp() > lastAction.getDismissTimestamp() && ExpressPurchaseExtKt.isMoreThanDaysThreshold(params.getCurrentTime(), lastAction.getSuccessTimestamp(), config.getSuccessDelay());
        boolean z4 = lastAction.getDismissTimestamp() > 0 && lastAction.getSuccessTimestamp() < lastAction.getDismissTimestamp() && ExpressPurchaseExtKt.isMoreThanDaysThreshold(params.getCurrentTime(), lastAction.getDismissTimestamp(), config.getDismissDelay());
        if (z) {
            return false;
        }
        if (z2) {
            return true;
        }
        if (z3) {
            this.expressPurchaseRepository.saveLastOfferSucceedTransaction(params.getAddonId());
            return true;
        }
        return z4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<AddonOffer> isEPCanProceed(Params params, boolean canProceedEP) {
        if (!canProceedEP) {
            return noOffer();
        }
        Observable<AddonOffer> cashierAddOn = getCashierAddOn(params);
        final Function1<AddonOffer, Observable<AddonOffer>> validateOffer = validateOffer(params);
        Observable flatMap = cashierAddOn.flatMap(new Function() { // from class: id.dana.domain.expresspurchase.interaction.GetAddOnOfferExpressPurchase$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2300isEPCanProceed$lambda1;
                m2300isEPCanProceed$lambda1 = GetAddOnOfferExpressPurchase.m2300isEPCanProceed$lambda1(Function1.this, (AddonOffer) obj);
                return m2300isEPCanProceed$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isEPCanProceed$lambda-1  reason: not valid java name */
    public static final ObservableSource m2300isEPCanProceed$lambda1(Function1 function1, AddonOffer addonOffer) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (ObservableSource) function1.invoke(addonOffer);
    }

    private final Observable<AddonOffer> getCashierAddOn(Params params) {
        return this.expressPurchaseRepository.getCashierAddonInfo(params.getAddonId(), params.getCashierOrderId()).map(new Function() { // from class: id.dana.domain.expresspurchase.interaction.GetAddOnOfferExpressPurchase$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AddonOffer m2299getCashierAddOn$lambda2;
                m2299getCashierAddOn$lambda2 = GetAddOnOfferExpressPurchase.m2299getCashierAddOn$lambda2((AddonInfo) obj);
                return m2299getCashierAddOn$lambda2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCashierAddOn$lambda-2  reason: not valid java name */
    public static final AddonOffer m2299getCashierAddOn$lambda2(AddonInfo addonInfo) {
        Intrinsics.checkNotNullParameter(addonInfo, "");
        return new AddonOffer(addonInfo, false, 2, null);
    }

    private final Function1<AddonOffer, Observable<AddonOffer>> validateOffer(final Params params) {
        return new Function1<AddonOffer, Observable<AddonOffer>>() { // from class: id.dana.domain.expresspurchase.interaction.GetAddOnOfferExpressPurchase$validateOffer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
            
                r7 = r2.validateProductInsurance(r3, r7);
             */
            /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
            
                return r7;
             */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final io.reactivex.Observable<id.dana.domain.expresspurchase.interaction.model.AddonOffer> invoke(id.dana.domain.expresspurchase.interaction.model.AddonOffer r7) {
                /*
                    r6 = this;
                    java.lang.String r0 = ""
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                    boolean r1 = r7.getHasOffer()
                    if (r1 == 0) goto L71
                    id.dana.domain.expresspurchase.interaction.model.AddonInfo r1 = r7.getAddonInfo()
                    if (r1 == 0) goto L71
                    id.dana.domain.expresspurchase.interaction.model.AddonInfo r1 = r7.getAddonInfo()
                    id.dana.domain.expresspurchase.interaction.GetAddOnOfferExpressPurchase r2 = id.dana.domain.expresspurchase.interaction.GetAddOnOfferExpressPurchase.this
                    id.dana.domain.expresspurchase.interaction.GetAddOnOfferExpressPurchase$Params r3 = r2
                    java.lang.String r1 = r1.getTemplateType()
                    int r4 = r1.hashCode()
                    r5 = -1991247790(0xffffffff894ff852, float:-2.5033478E-33)
                    if (r4 == r5) goto L46
                    r5 = -1732759620(0xffffffff98b82fbc, float:-4.7611085E-24)
                    if (r4 == r5) goto L39
                    r5 = 1355934361(0x50d1ea99, float:2.81745019E10)
                    if (r4 != r5) goto L4e
                    java.lang.String r4 = "STANDALONE_INSURANCE_TEMPLATE"
                    boolean r1 = r1.equals(r4)
                    if (r1 != 0) goto L41
                    goto L4e
                L39:
                    java.lang.String r4 = "BUNDLED_INSURANCE_TEMPLATE"
                    boolean r1 = r1.equals(r4)
                    if (r1 == 0) goto L4e
                L41:
                    io.reactivex.Observable r7 = id.dana.domain.expresspurchase.interaction.GetAddOnOfferExpressPurchase.access$validateProductInsurance(r2, r3, r7)
                    goto L78
                L46:
                    java.lang.String r3 = "DEALS_TEMPLATE"
                    boolean r1 = r1.equals(r3)
                    if (r1 != 0) goto L56
                L4e:
                    io.reactivex.Observable r7 = io.reactivex.Observable.just(r7)
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
                    goto L78
                L56:
                    id.dana.domain.expresspurchase.interaction.model.AddonInfo r1 = r7.getAddonInfo()
                    id.dana.domain.expresspurchase.interaction.model.AddonInfo$ProductInfo r1 = r1.getProductInfo()
                    boolean r1 = r1.isVoucherBundle()
                    if (r1 == 0) goto L69
                    io.reactivex.Observable r7 = id.dana.domain.expresspurchase.interaction.GetAddOnOfferExpressPurchase.access$noOffer(r2)
                    goto L78
                L69:
                    io.reactivex.Observable r7 = io.reactivex.Observable.just(r7)
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
                    goto L78
                L71:
                    io.reactivex.Observable r7 = io.reactivex.Observable.just(r7)
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
                L78:
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.expresspurchase.interaction.GetAddOnOfferExpressPurchase$validateOffer$1.invoke(id.dana.domain.expresspurchase.interaction.model.AddonOffer):io.reactivex.Observable");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<AddonOffer> validateProductInsurance(Params params, final AddonOffer addonOffer) {
        AddonInfo addonInfo = addonOffer.getAddonInfo();
        Intrinsics.checkNotNull(addonInfo);
        Observable flatMap = validateProductIsAvailable(addonInfo, params).flatMap(new Function() { // from class: id.dana.domain.expresspurchase.interaction.GetAddOnOfferExpressPurchase$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2301validateProductInsurance$lambda3;
                m2301validateProductInsurance$lambda3 = GetAddOnOfferExpressPurchase.m2301validateProductInsurance$lambda3(AddonOffer.this, this, (ValidateProduct) obj);
                return m2301validateProductInsurance$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: validateProductInsurance$lambda-3  reason: not valid java name */
    public static final ObservableSource m2301validateProductInsurance$lambda3(AddonOffer addonOffer, GetAddOnOfferExpressPurchase getAddOnOfferExpressPurchase, ValidateProduct validateProduct) {
        Observable<AddonOffer> noOffer;
        Intrinsics.checkNotNullParameter(addonOffer, "");
        Intrinsics.checkNotNullParameter(getAddOnOfferExpressPurchase, "");
        Intrinsics.checkNotNullParameter(validateProduct, "");
        if (validateProduct.getSuccess()) {
            if (validateProduct.getAggregatorGoodsId().length() > 0) {
                addonOffer.getAddonInfo().getProductInfo().setAggregatorGoodsId(validateProduct.getAggregatorGoodsId());
                addonOffer.getAddonInfo().setExtendInfo(validateProduct.getExtendInfo());
            }
            noOffer = Observable.just(addonOffer);
            Intrinsics.checkNotNullExpressionValue(noOffer, "");
        } else {
            noOffer = getAddOnOfferExpressPurchase.noOffer();
        }
        return noOffer;
    }

    private final Observable<ValidateProduct> validateProductIsAvailable(AddonInfo addonInfo, Params params) {
        if (Intrinsics.areEqual(addonInfo.getTemplateType(), "BUNDLED_INSURANCE_TEMPLATE")) {
            return this.expressPurchaseRepository.validateBundleProduct(addonInfo.getGoodsId(), addonInfo.getProductInfo().getAggregatorId(), addonInfo.getProductInfo().getAggregatorGoodsId(), addonInfo.getProductInfo().getFinType(), params.getBizOrderId(), params.getMerchantTransId());
        }
        return this.expressPurchaseRepository.validateStandaloneProduct(addonInfo.getGoodsId(), addonInfo.getProductInfo().getAggregatorGoodsId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<AddonOffer> noOffer() {
        Observable<AddonOffer> just = Observable.just(new AddonOffer());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B3\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/GetAddOnOfferExpressPurchase$Params;", "", "", "addonId", "Ljava/lang/String;", "getAddonId", "()Ljava/lang/String;", "bizOrderId", "getBizOrderId", CashierKeyParams.CASHIER_ORDER_ID, "getCashierOrderId", "", "currentTime", "J", H5Constants.ACTION_GET_CURRENT_TIME, "()J", "merchantTransId", "getMerchantTransId", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String addonId;
        private final String bizOrderId;
        private final String cashierOrderId;
        private final long currentTime;
        private final String merchantTransId;

        @JvmStatic
        public static final Params create(String str, String str2, String str3, String str4) {
            return INSTANCE.create(str, str2, str3, str4);
        }

        private Params(String str, String str2, long j, String str3, String str4) {
            this.addonId = str;
            this.cashierOrderId = str2;
            this.currentTime = j;
            this.bizOrderId = str3;
            this.merchantTransId = str4;
        }

        @JvmName(name = "getAddonId")
        public final String getAddonId() {
            return this.addonId;
        }

        @JvmName(name = "getCashierOrderId")
        public final String getCashierOrderId() {
            return this.cashierOrderId;
        }

        /* synthetic */ Params(String str, String str2, long j, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? System.currentTimeMillis() : j, str3, str4);
        }

        @JvmName(name = H5Constants.ACTION_GET_CURRENT_TIME)
        public final long getCurrentTime() {
            return this.currentTime;
        }

        @JvmName(name = "getBizOrderId")
        public final String getBizOrderId() {
            return this.bizOrderId;
        }

        @JvmName(name = "getMerchantTransId")
        public final String getMerchantTransId() {
            return this.merchantTransId;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/GetAddOnOfferExpressPurchase$Params$Companion;", "", "", "addonId", CashierKeyParams.CASHIER_ORDER_ID, "bizOrderId", "merchantTransId", "Lid/dana/domain/expresspurchase/interaction/GetAddOnOfferExpressPurchase$Params;", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/expresspurchase/interaction/GetAddOnOfferExpressPurchase$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params create(String addonId, String cashierOrderId, String bizOrderId, String merchantTransId) {
                Intrinsics.checkNotNullParameter(addonId, "");
                Intrinsics.checkNotNullParameter(cashierOrderId, "");
                Intrinsics.checkNotNullParameter(bizOrderId, "");
                Intrinsics.checkNotNullParameter(merchantTransId, "");
                return new Params(addonId, cashierOrderId, 0L, bizOrderId, merchantTransId, 4, null);
            }
        }
    }
}
