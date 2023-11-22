package id.dana.data.resetpin;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.account.AccountEntity;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.login.source.network.model.LoginIdType;
import id.dana.data.registration.RegistrationProcessManager;
import id.dana.data.resetpin.model.ConfigCountPinChange;
import id.dana.data.resetpin.model.ConsultForceDanaVizEnrollResult;
import id.dana.data.resetpin.model.CountPinChangeResult;
import id.dana.data.resetpin.source.local.ResetPinPreference;
import id.dana.data.resetpin.source.network.NetworkResetPinEntityData;
import id.dana.domain.resetpin.ResetPinRepository;
import id.dana.domain.resetpin.model.ConsultDanaVizModel;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\f\u001a\u00020%\u0012\u0006\u0010\u0016\u001a\u00020\u001f\u0012\u0006\u0010+\u001a\u00020\u001c\u0012\u0006\u0010,\u001a\u00020\u0019\u0012\u0006\u0010-\u001a\u00020#¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0016¢\u0006\u0004\b\n\u0010\bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\bJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\bJ\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\bJ\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\u000eJ%\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\t0\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0010\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010 \u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010$R\u0014\u0010\u001d\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010&R\u0013\u0010*\u001a\u00020'X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b(\u0010)"}, d2 = {"Lid/dana/data/resetpin/ResetPinRepositoryImpl;", "Lid/dana/domain/resetpin/ResetPinRepository;", "", "clearDanaVizPromptCache", "()V", "Lio/reactivex/Observable;", "Lid/dana/domain/resetpin/model/ConsultDanaVizModel;", "consultForceDanaVizEnroll", "()Lio/reactivex/Observable;", "", "finishForceDanaVizEnroll", "", "p0", "getDanaVizPromptAfterResetPin", "(Ljava/lang/String;)Lio/reactivex/Observable;", "getForceDanaVizPrompt", "KClassImpl$Data$declaredNonStaticMembers$2", "getTempRegistrationPhoneNumber", "isDanaVizEnrollmentSkippable", "saveForceDanaVizPrompt", "(Z)Lio/reactivex/Observable;", "selfUnfreeze", "p1", "setDanaVizPromptAfterResetPin", "(Ljava/lang/String;Z)Lio/reactivex/Observable;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "getAuthRequestContext", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "MyBillsEntityDataFactory", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "Lid/dana/data/resetpin/source/network/NetworkResetPinEntityData;", "PlaceComponentResult", "Lid/dana/data/resetpin/source/network/NetworkResetPinEntityData;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/registration/RegistrationProcessManager;", "Lid/dana/data/registration/RegistrationProcessManager;", "Lid/dana/data/resetpin/source/local/ResetPinPreference;", "Lid/dana/data/resetpin/source/local/ResetPinPreference;", "Lid/dana/data/config/source/ConfigEntityData;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/Lazy;", "moveToNextValue", "p2", "p3", "p4", "<init>", "(Lid/dana/data/resetpin/source/local/ResetPinPreference;Lid/dana/data/resetpin/source/network/NetworkResetPinEntityData;Lid/dana/data/config/source/ConfigEntityDataFactory;Lid/dana/data/account/repository/source/AccountEntityDataFactory;Lid/dana/data/registration/RegistrationProcessManager;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ResetPinRepositoryImpl implements ResetPinRepository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final ResetPinPreference MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final RegistrationProcessManager PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final ConfigEntityDataFactory KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy moveToNextValue;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final NetworkResetPinEntityData BuiltInFictitiousFunctionClassFactory;
    private final AccountEntityDataFactory getAuthRequestContext;

    @Inject
    public ResetPinRepositoryImpl(ResetPinPreference resetPinPreference, NetworkResetPinEntityData networkResetPinEntityData, ConfigEntityDataFactory configEntityDataFactory, AccountEntityDataFactory accountEntityDataFactory, RegistrationProcessManager registrationProcessManager) {
        Intrinsics.checkNotNullParameter(resetPinPreference, "");
        Intrinsics.checkNotNullParameter(networkResetPinEntityData, "");
        Intrinsics.checkNotNullParameter(configEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(registrationProcessManager, "");
        this.MyBillsEntityDataFactory = resetPinPreference;
        this.BuiltInFictitiousFunctionClassFactory = networkResetPinEntityData;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = configEntityDataFactory;
        this.getAuthRequestContext = accountEntityDataFactory;
        this.PlaceComponentResult = registrationProcessManager;
        this.moveToNextValue = LazyKt.lazy(new Function0<ConfigEntityData>() { // from class: id.dana.data.resetpin.ResetPinRepositoryImpl$splitConfigEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConfigEntityData invoke() {
                ConfigEntityDataFactory configEntityDataFactory2;
                configEntityDataFactory2 = ResetPinRepositoryImpl.this.KClassImpl$Data$declaredNonStaticMembers$2;
                return configEntityDataFactory2.createData2("split");
            }
        });
    }

    @Override // id.dana.domain.resetpin.ResetPinRepository
    public final Observable<Boolean> getDanaVizPromptAfterResetPin(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<Boolean> doOnComplete = Observable.just(Boolean.valueOf(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0))).doOnComplete(new Action() { // from class: id.dana.data.resetpin.ResetPinRepositoryImpl$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Action
            public final void run() {
                ResetPinRepositoryImpl.getAuthRequestContext(ResetPinRepositoryImpl.this);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnComplete, "");
        return doOnComplete;
    }

    @Override // id.dana.domain.resetpin.ResetPinRepository
    public final Observable<Boolean> setDanaVizPromptAfterResetPin(String p0, boolean p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
        Observable<Boolean> just = Observable.just(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.resetpin.ResetPinRepository
    public final Observable<Boolean> getForceDanaVizPrompt() {
        Observable map = KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.resetpin.ResetPinRepositoryImpl$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ResetPinRepositoryImpl.getAuthRequestContext(ResetPinRepositoryImpl.this, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.resetpin.ResetPinRepository
    public final Observable<Unit> saveForceDanaVizPrompt(final boolean p0) {
        Observable map = KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.resetpin.ResetPinRepositoryImpl$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ResetPinRepositoryImpl.KClassImpl$Data$declaredNonStaticMembers$2(ResetPinRepositoryImpl.this, p0, (String) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.resetpin.ResetPinRepository
    public final Observable<ConsultDanaVizModel> consultForceDanaVizEnroll() {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Observable map = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult().map(new Function() { // from class: id.dana.data.resetpin.ResetPinRepositoryImpl$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ResetPinRepositoryImpl.getAuthRequestContext(Ref.BooleanRef.this, (ConsultForceDanaVizEnrollResult) obj);
            }
        });
        saveForceDanaVizPrompt(booleanRef.element);
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.resetpin.ResetPinRepository
    public final void clearDanaVizPromptCache() {
        this.MyBillsEntityDataFactory.PlaceComponentResult.clearAllData();
    }

    @Override // id.dana.domain.resetpin.ResetPinRepository
    public final Observable<Boolean> finishForceDanaVizEnroll() {
        Observable flatMap = getForceDanaVizPrompt().flatMap(new Function() { // from class: id.dana.data.resetpin.ResetPinRepositoryImpl$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ResetPinRepositoryImpl.MyBillsEntityDataFactory(ResetPinRepositoryImpl.this, (Boolean) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    @Override // id.dana.domain.resetpin.ResetPinRepository
    public final Observable<Boolean> selfUnfreeze(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        NetworkResetPinEntityData networkResetPinEntityData = this.BuiltInFictitiousFunctionClassFactory;
        String phoneNumber = this.PlaceComponentResult.getPhoneNumber();
        Intrinsics.checkNotNullExpressionValue(phoneNumber, "");
        Observable map = networkResetPinEntityData.getAuthRequestContext(p0, phoneNumber, LoginIdType.MOBILE_NO).map(new Function() { // from class: id.dana.data.resetpin.ResetPinRepositoryImpl$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ResetPinRepositoryImpl.PlaceComponentResult((BaseRpcResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.resetpin.ResetPinRepository
    public final Observable<String> getTempRegistrationPhoneNumber() {
        Observable<String> just = Observable.just(this.PlaceComponentResult.getPhoneNumber());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(ResetPinRepositoryImpl resetPinRepositoryImpl, Boolean bool) {
        Observable just;
        Intrinsics.checkNotNullParameter(resetPinRepositoryImpl, "");
        Intrinsics.checkNotNullParameter(bool, "");
        if (bool.booleanValue()) {
            just = resetPinRepositoryImpl.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.resetpin.ResetPinRepositoryImpl$$ExternalSyntheticLambda4
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return ResetPinRepositoryImpl.BuiltInFictitiousFunctionClassFactory((BaseRpcResult) obj);
                }
            });
            resetPinRepositoryImpl.saveForceDanaVizPrompt(false);
        } else {
            just = Observable.just(Boolean.TRUE);
        }
        return just;
    }

    public static /* synthetic */ ConsultDanaVizModel getAuthRequestContext(Ref.BooleanRef booleanRef, ConsultForceDanaVizEnrollResult consultForceDanaVizEnrollResult) {
        Intrinsics.checkNotNullParameter(booleanRef, "");
        Intrinsics.checkNotNullParameter(consultForceDanaVizEnrollResult, "");
        booleanRef.element = consultForceDanaVizEnrollResult.isForced();
        return new ConsultDanaVizModel(false, booleanRef.element, 1, null);
    }

    public static /* synthetic */ Boolean getAuthRequestContext(ResetPinRepositoryImpl resetPinRepositoryImpl, String str) {
        Intrinsics.checkNotNullParameter(resetPinRepositoryImpl, "");
        Intrinsics.checkNotNullParameter(str, "");
        return Boolean.valueOf(resetPinRepositoryImpl.MyBillsEntityDataFactory.PlaceComponentResult(str));
    }

    public static /* synthetic */ Boolean MyBillsEntityDataFactory(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return Boolean.TRUE;
    }

    public static /* synthetic */ String MyBillsEntityDataFactory(AccountEntity accountEntity) {
        Intrinsics.checkNotNullParameter(accountEntity, "");
        String phoneNumber = accountEntity.getPhoneNumber();
        return phoneNumber == null ? "" : phoneNumber;
    }

    public static /* synthetic */ Boolean PlaceComponentResult(BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        return Boolean.valueOf(baseRpcResult.success);
    }

    public static /* synthetic */ Boolean PlaceComponentResult(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return Boolean.TRUE;
    }

    public static /* synthetic */ Boolean BuiltInFictitiousFunctionClassFactory(BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        return Boolean.valueOf(baseRpcResult.success);
    }

    public static /* synthetic */ void getAuthRequestContext(ResetPinRepositoryImpl resetPinRepositoryImpl) {
        Intrinsics.checkNotNullParameter(resetPinRepositoryImpl, "");
        resetPinRepositoryImpl.MyBillsEntityDataFactory.PlaceComponentResult.clearData("dana_viz_prompt_after_reset_pin");
    }

    public static /* synthetic */ ObservableSource PlaceComponentResult(ResetPinRepositoryImpl resetPinRepositoryImpl, final ConfigCountPinChange configCountPinChange) {
        Observable just;
        Intrinsics.checkNotNullParameter(resetPinRepositoryImpl, "");
        Intrinsics.checkNotNullParameter(configCountPinChange, "");
        if (configCountPinChange.getPlaceComponentResult()) {
            Intrinsics.checkNotNullParameter(configCountPinChange, "");
            just = resetPinRepositoryImpl.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory().flatMap(new Function() { // from class: id.dana.data.resetpin.ResetPinRepositoryImpl$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return ResetPinRepositoryImpl.KClassImpl$Data$declaredNonStaticMembers$2(ConfigCountPinChange.this, (CountPinChangeResult) obj);
                }
            }).onErrorReturn(new Function() { // from class: id.dana.data.resetpin.ResetPinRepositoryImpl$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return ResetPinRepositoryImpl.MyBillsEntityDataFactory((Throwable) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(just, "");
        } else {
            just = Observable.just(Boolean.TRUE);
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        return just;
    }

    public static /* synthetic */ Unit KClassImpl$Data$declaredNonStaticMembers$2(ResetPinRepositoryImpl resetPinRepositoryImpl, boolean z, String str) {
        Intrinsics.checkNotNullParameter(resetPinRepositoryImpl, "");
        Intrinsics.checkNotNullParameter(str, "");
        resetPinRepositoryImpl.MyBillsEntityDataFactory.PlaceComponentResult(str, z);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ ObservableSource KClassImpl$Data$declaredNonStaticMembers$2(ConfigCountPinChange configCountPinChange, CountPinChangeResult countPinChangeResult) {
        Observable just;
        Intrinsics.checkNotNullParameter(configCountPinChange, "");
        Intrinsics.checkNotNullParameter(countPinChangeResult, "");
        if (countPinChangeResult.getTotal() > configCountPinChange.getAuthRequestContext) {
            just = Observable.just(Boolean.FALSE);
        } else {
            just = Observable.just(Boolean.TRUE);
        }
        return just;
    }

    private final Observable<String> KClassImpl$Data$declaredNonStaticMembers$2() {
        Observable map = this.getAuthRequestContext.createData2("local").getAccount().map(new Function() { // from class: id.dana.data.resetpin.ResetPinRepositoryImpl$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ResetPinRepositoryImpl.MyBillsEntityDataFactory((AccountEntity) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.resetpin.ResetPinRepository
    public final Observable<Boolean> isDanaVizEnrollmentSkippable() {
        Object value = this.moveToNextValue.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "");
        Observable<Boolean> onErrorReturn = ((ConfigEntityData) value).getCountPinChange().flatMap(new Function() { // from class: id.dana.data.resetpin.ResetPinRepositoryImpl$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ResetPinRepositoryImpl.PlaceComponentResult(ResetPinRepositoryImpl.this, (ConfigCountPinChange) obj);
            }
        }).onErrorReturn(new Function() { // from class: id.dana.data.resetpin.ResetPinRepositoryImpl$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ResetPinRepositoryImpl.PlaceComponentResult((Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "");
        return onErrorReturn;
    }
}
