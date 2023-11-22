package id.dana.domain.expresspurchase.interaction;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import com.alibaba.griver.video.H5Constants;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.expresspurchase.interaction.GetPaylaterOfferExpressPurchase;
import id.dana.domain.expresspurchase.interaction.model.ExpressPurchasePaylaterConfig;
import id.dana.domain.expresspurchase.interaction.model.ExpressPurchaseType;
import id.dana.domain.expresspurchase.interaction.model.LatestExpressPurchaseAction;
import id.dana.domain.expresspurchase.interaction.model.PaylaterOffer;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import id.dana.domain.expresspurchase.util.ExpressPurchaseExtKt;
import id.dana.domain.paylater.PaylaterAction;
import id.dana.domain.paylater.model.PaylaterAgreementConfig;
import id.dana.domain.paylater.model.PaylaterHomeInfo;
import id.dana.domain.useragreement.UserConsentRepository;
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

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001&B\u0019\b\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b$\u0010%J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ1\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\n2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\rJ1\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0013\u0010\u0017J\u0019\u0010\u0018\u001a\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\u0005H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J7\u0010\u001a\u001a\u001a\u0012\b\u0012\u0006*\u00020\u00020\u0002*\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\u00050\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/GetPaylaterOfferExpressPurchase;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/expresspurchase/interaction/model/PaylaterOffer;", "Lid/dana/domain/expresspurchase/interaction/GetPaylaterOfferExpressPurchase$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/expresspurchase/interaction/GetPaylaterOfferExpressPurchase$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/expresspurchase/interaction/model/ExpressPurchasePaylaterConfig;", "config", "Lkotlin/Function1;", "Lid/dana/domain/paylater/model/PaylaterHomeInfo;", "checkIsAbleToGetPaylaterOffer", "(Lid/dana/domain/expresspurchase/interaction/model/ExpressPurchasePaylaterConfig;)Lkotlin/jvm/functions/Function1;", "", "checkPaylaterOffer", "(Lid/dana/domain/expresspurchase/interaction/model/ExpressPurchasePaylaterConfig;Lid/dana/domain/expresspurchase/interaction/GetPaylaterOfferExpressPurchase$Params;)Lkotlin/jvm/functions/Function1;", "checkPaylaterOfferCooldown", "(Lid/dana/domain/expresspurchase/interaction/GetPaylaterOfferExpressPurchase$Params;)Lkotlin/jvm/functions/Function1;", "composePaylaterOffer", "expressPurchasePaylaterConfig", "paylaterOffer", "Lid/dana/domain/paylater/model/PaylaterAgreementConfig;", "(Lid/dana/domain/expresspurchase/interaction/model/ExpressPurchasePaylaterConfig;Lid/dana/domain/expresspurchase/interaction/model/PaylaterOffer;)Lkotlin/jvm/functions/Function1;", "noOffer", "()Lio/reactivex/Observable;", "onCheckPaylaterCoolDown", "(Lid/dana/domain/expresspurchase/interaction/GetPaylaterOfferExpressPurchase$Params;Lid/dana/domain/expresspurchase/interaction/model/ExpressPurchasePaylaterConfig;)Lio/reactivex/Observable;", "onCheckPaylaterOffer", "(Lid/dana/domain/expresspurchase/interaction/model/ExpressPurchasePaylaterConfig;Lid/dana/domain/expresspurchase/interaction/GetPaylaterOfferExpressPurchase$Params;)Lio/reactivex/Observable;", "Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;", "expressPurchaseRepository", "Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;", "Lid/dana/domain/useragreement/UserConsentRepository;", "userConsentRepository", "Lid/dana/domain/useragreement/UserConsentRepository;", "<init>", "(Lid/dana/domain/expresspurchase/repository/ExpressPurchaseRepository;Lid/dana/domain/useragreement/UserConsentRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetPaylaterOfferExpressPurchase extends BaseUseCase<PaylaterOffer, Params> {
    private final ExpressPurchaseRepository expressPurchaseRepository;
    private final UserConsentRepository userConsentRepository;

    @Inject
    public GetPaylaterOfferExpressPurchase(ExpressPurchaseRepository expressPurchaseRepository, UserConsentRepository userConsentRepository) {
        Intrinsics.checkNotNullParameter(expressPurchaseRepository, "");
        Intrinsics.checkNotNullParameter(userConsentRepository, "");
        this.expressPurchaseRepository = expressPurchaseRepository;
        this.userConsentRepository = userConsentRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<PaylaterOffer> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<ExpressPurchasePaylaterConfig> expressPurchasePaylaterConfig = this.expressPurchaseRepository.getExpressPurchasePaylaterConfig();
        final Function1<ExpressPurchasePaylaterConfig, Observable<PaylaterOffer>> checkPaylaterOfferCooldown = checkPaylaterOfferCooldown(params);
        Observable flatMap = expressPurchasePaylaterConfig.flatMap(new Function() { // from class: id.dana.domain.expresspurchase.interaction.GetPaylaterOfferExpressPurchase$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2307buildUseCase$lambda0;
                m2307buildUseCase$lambda0 = GetPaylaterOfferExpressPurchase.m2307buildUseCase$lambda0(Function1.this, (ExpressPurchasePaylaterConfig) obj);
                return m2307buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final ObservableSource m2307buildUseCase$lambda0(Function1 function1, ExpressPurchasePaylaterConfig expressPurchasePaylaterConfig) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (ObservableSource) function1.invoke(expressPurchasePaylaterConfig);
    }

    private final Function1<ExpressPurchasePaylaterConfig, Observable<PaylaterOffer>> checkPaylaterOfferCooldown(final Params params) {
        return new Function1<ExpressPurchasePaylaterConfig, Observable<PaylaterOffer>>() { // from class: id.dana.domain.expresspurchase.interaction.GetPaylaterOfferExpressPurchase$checkPaylaterOfferCooldown$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<PaylaterOffer> invoke(ExpressPurchasePaylaterConfig expressPurchasePaylaterConfig) {
                Observable<PaylaterOffer> onCheckPaylaterCoolDown;
                Observable<PaylaterOffer> noOffer;
                Intrinsics.checkNotNullParameter(expressPurchasePaylaterConfig, "");
                if (expressPurchasePaylaterConfig.getDismiss() == 0) {
                    noOffer = GetPaylaterOfferExpressPurchase.this.noOffer();
                    return noOffer;
                }
                onCheckPaylaterCoolDown = GetPaylaterOfferExpressPurchase.this.onCheckPaylaterCoolDown(params, expressPurchasePaylaterConfig);
                Intrinsics.checkNotNullExpressionValue(onCheckPaylaterCoolDown, "");
                return onCheckPaylaterCoolDown;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<PaylaterOffer> onCheckPaylaterCoolDown(final Params params, final ExpressPurchasePaylaterConfig config) {
        Observable<R> map = this.expressPurchaseRepository.getLastExpressPurchaseAction(params.getAddonId(), ExpressPurchaseType.PAYLATER.name()).map(new Function() { // from class: id.dana.domain.expresspurchase.interaction.GetPaylaterOfferExpressPurchase$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m2308onCheckPaylaterCoolDown$lambda1;
                m2308onCheckPaylaterCoolDown$lambda1 = GetPaylaterOfferExpressPurchase.m2308onCheckPaylaterCoolDown$lambda1(GetPaylaterOfferExpressPurchase.Params.this, config, (LatestExpressPurchaseAction) obj);
                return m2308onCheckPaylaterCoolDown$lambda1;
            }
        });
        final Function1<Boolean, Observable<PaylaterOffer>> checkPaylaterOffer = checkPaylaterOffer(config, params);
        return map.flatMap(new Function() { // from class: id.dana.domain.expresspurchase.interaction.GetPaylaterOfferExpressPurchase$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2309onCheckPaylaterCoolDown$lambda2;
                m2309onCheckPaylaterCoolDown$lambda2 = GetPaylaterOfferExpressPurchase.m2309onCheckPaylaterCoolDown$lambda2(Function1.this, (Boolean) obj);
                return m2309onCheckPaylaterCoolDown$lambda2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCheckPaylaterCoolDown$lambda-1  reason: not valid java name */
    public static final Boolean m2308onCheckPaylaterCoolDown$lambda1(Params params, ExpressPurchasePaylaterConfig expressPurchasePaylaterConfig, LatestExpressPurchaseAction latestExpressPurchaseAction) {
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(expressPurchasePaylaterConfig, "");
        Intrinsics.checkNotNullParameter(latestExpressPurchaseAction, "");
        return Boolean.valueOf(latestExpressPurchaseAction.getDismissTimestamp() < 0 ? true : ExpressPurchaseExtKt.isMoreThanDaysThreshold(params.getCurrentTime(), latestExpressPurchaseAction.getDismissTimestamp(), expressPurchasePaylaterConfig.getDismiss()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCheckPaylaterCoolDown$lambda-2  reason: not valid java name */
    public static final ObservableSource m2309onCheckPaylaterCoolDown$lambda2(Function1 function1, Boolean bool) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (ObservableSource) function1.invoke(bool);
    }

    private final Function1<Boolean, Observable<PaylaterOffer>> checkPaylaterOffer(final ExpressPurchasePaylaterConfig config, final Params params) {
        return new Function1<Boolean, Observable<PaylaterOffer>>() { // from class: id.dana.domain.expresspurchase.interaction.GetPaylaterOfferExpressPurchase$checkPaylaterOffer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Observable<PaylaterOffer> invoke(Boolean bool) {
                return invoke(bool.booleanValue());
            }

            public final Observable<PaylaterOffer> invoke(boolean z) {
                Observable<PaylaterOffer> noOffer;
                Observable<PaylaterOffer> onCheckPaylaterOffer;
                if (z) {
                    onCheckPaylaterOffer = GetPaylaterOfferExpressPurchase.this.onCheckPaylaterOffer(config, params);
                    return onCheckPaylaterOffer;
                }
                noOffer = GetPaylaterOfferExpressPurchase.this.noOffer();
                return noOffer;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<PaylaterOffer> onCheckPaylaterOffer(ExpressPurchasePaylaterConfig config, Params params) {
        Observable<PaylaterHomeInfo> paylaterHomeInfo = this.expressPurchaseRepository.getPaylaterHomeInfo(params.getSkipBillInfo());
        final Function1<PaylaterHomeInfo, Observable<PaylaterOffer>> checkIsAbleToGetPaylaterOffer = checkIsAbleToGetPaylaterOffer(config);
        Observable<R> flatMap = paylaterHomeInfo.flatMap(new Function() { // from class: id.dana.domain.expresspurchase.interaction.GetPaylaterOfferExpressPurchase$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2310onCheckPaylaterOffer$lambda3;
                m2310onCheckPaylaterOffer$lambda3 = GetPaylaterOfferExpressPurchase.m2310onCheckPaylaterOffer$lambda3(Function1.this, (PaylaterHomeInfo) obj);
                return m2310onCheckPaylaterOffer$lambda3;
            }
        });
        final Function1<PaylaterOffer, Observable<PaylaterOffer>> composePaylaterOffer = composePaylaterOffer(config);
        Observable<PaylaterOffer> flatMap2 = flatMap.flatMap(new Function() { // from class: id.dana.domain.expresspurchase.interaction.GetPaylaterOfferExpressPurchase$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2311onCheckPaylaterOffer$lambda4;
                m2311onCheckPaylaterOffer$lambda4 = GetPaylaterOfferExpressPurchase.m2311onCheckPaylaterOffer$lambda4(Function1.this, (PaylaterOffer) obj);
                return m2311onCheckPaylaterOffer$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap2, "");
        return flatMap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCheckPaylaterOffer$lambda-3  reason: not valid java name */
    public static final ObservableSource m2310onCheckPaylaterOffer$lambda3(Function1 function1, PaylaterHomeInfo paylaterHomeInfo) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (ObservableSource) function1.invoke(paylaterHomeInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCheckPaylaterOffer$lambda-4  reason: not valid java name */
    public static final ObservableSource m2311onCheckPaylaterOffer$lambda4(Function1 function1, PaylaterOffer paylaterOffer) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (ObservableSource) function1.invoke(paylaterOffer);
    }

    private final Function1<PaylaterHomeInfo, Observable<PaylaterOffer>> checkIsAbleToGetPaylaterOffer(final ExpressPurchasePaylaterConfig config) {
        return new Function1<PaylaterHomeInfo, Observable<PaylaterOffer>>() { // from class: id.dana.domain.expresspurchase.interaction.GetPaylaterOfferExpressPurchase$checkIsAbleToGetPaylaterOffer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<PaylaterOffer> invoke(PaylaterHomeInfo paylaterHomeInfo) {
                Observable<PaylaterOffer> noOffer;
                Intrinsics.checkNotNullParameter(paylaterHomeInfo, "");
                if (!Intrinsics.areEqual(paylaterHomeInfo.getAction().name(), PaylaterAction.ACTION_CREDIT_REGISTER.name()) && !Intrinsics.areEqual(paylaterHomeInfo.getAction().name(), PaylaterAction.ACTION_CREDIT_REREGISTER.name())) {
                    noOffer = this.noOffer();
                    return noOffer;
                }
                Observable<PaylaterOffer> just = Observable.just(new PaylaterOffer(true, new PaylaterOffer.Partner(paylaterHomeInfo.getPartnerId(), ExpressPurchasePaylaterConfig.this.getRedirectedUrl(), ""), null, 4, null));
                Intrinsics.checkNotNullExpressionValue(just, "");
                return just;
            }
        };
    }

    private final Function1<PaylaterOffer, Observable<PaylaterOffer>> composePaylaterOffer(ExpressPurchasePaylaterConfig config) {
        return new GetPaylaterOfferExpressPurchase$composePaylaterOffer$1(this, config);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function1<PaylaterAgreementConfig, Observable<PaylaterOffer>> composePaylaterOffer(ExpressPurchasePaylaterConfig expressPurchasePaylaterConfig, PaylaterOffer paylaterOffer) {
        return new GetPaylaterOfferExpressPurchase$composePaylaterOffer$2(this, expressPurchasePaylaterConfig, paylaterOffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<PaylaterOffer> noOffer() {
        Observable<PaylaterOffer> just = Observable.just(new PaylaterOffer(false, null, null, 7, null));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/GetPaylaterOfferExpressPurchase$Params;", "", "", "addonId", "Ljava/lang/String;", "getAddonId", "()Ljava/lang/String;", "", "currentTime", "J", H5Constants.ACTION_GET_CURRENT_TIME, "()J", "", "skipBillInfo", "Z", "getSkipBillInfo", "()Z", "<init>", "(Ljava/lang/String;JZ)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String addonId;
        private final long currentTime;
        private final boolean skipBillInfo;

        @JvmStatic
        public static final Params create(String str) {
            return INSTANCE.create(str);
        }

        private Params(String str, long j, boolean z) {
            this.addonId = str;
            this.currentTime = j;
            this.skipBillInfo = z;
        }

        @JvmName(name = "getAddonId")
        public final String getAddonId() {
            return this.addonId;
        }

        /* synthetic */ Params(String str, long j, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? System.currentTimeMillis() : j, (i & 4) != 0 ? true : z);
        }

        @JvmName(name = H5Constants.ACTION_GET_CURRENT_TIME)
        public final long getCurrentTime() {
            return this.currentTime;
        }

        @JvmName(name = "getSkipBillInfo")
        public final boolean getSkipBillInfo() {
            return this.skipBillInfo;
        }

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/GetPaylaterOfferExpressPurchase$Params$Companion;", "", "", "addonId", "Lid/dana/domain/expresspurchase/interaction/GetPaylaterOfferExpressPurchase$Params;", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "(Ljava/lang/String;)Lid/dana/domain/expresspurchase/interaction/GetPaylaterOfferExpressPurchase$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Params create(String addonId) {
                Intrinsics.checkNotNullParameter(addonId, "");
                return new Params(addonId, 0L, false, 6, null);
            }
        }
    }
}
