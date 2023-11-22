package id.dana.data.referralconfig.repository.source.split;

import id.dana.data.referralconfig.model.ReferralConfigEntity;
import id.dana.data.referralconfig.repository.source.ReferralConfigEntityData;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.constant.ConfigType;
import id.dana.data.toggle.exception.SplitException;
import id.dana.data.toggle.exception.SplitNull;
import id.dana.data.toggle.exception.UnexpectedTreatment;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.lib.toggle.ToggleCallback;
import id.dana.lib.toggle.ToggleManager;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/data/referralconfig/repository/source/split/SplitReferralConfigEntityData;", "Lid/dana/data/referralconfig/repository/source/ReferralConfigEntityData;", "", "key", "Lio/reactivex/Observable;", "Lid/dana/data/referralconfig/model/ReferralConfigEntity;", "getReferralConfig", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitReferralConfigEntityData implements ReferralConfigEntityData {
    private final SplitFacade splitFacade;

    @Inject
    public SplitReferralConfigEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
    }

    @Override // id.dana.data.referralconfig.repository.source.ReferralConfigEntityData
    public final Observable<ReferralConfigEntity> getReferralConfig(final String key) {
        Intrinsics.checkNotNullParameter(key, "");
        Observable flatMap = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().flatMap(new Function() { // from class: id.dana.data.referralconfig.repository.source.split.SplitReferralConfigEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m1788getReferralConfig$lambda0;
                m1788getReferralConfig$lambda0 = SplitReferralConfigEntityData.m1788getReferralConfig$lambda0(key, (BaseTrafficType) obj);
                return m1788getReferralConfig$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getReferralConfig$lambda-0  reason: not valid java name */
    public static final ObservableSource m1788getReferralConfig$lambda0(final String str, final BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        final ReferralConfigEntity referralConfigEntity = new ReferralConfigEntity();
        final boolean z = true;
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: id.dana.data.referralconfig.repository.source.split.SplitReferralConfigEntityData$getReferralConfig$lambda-0$$inlined$getConfigOnceReady$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(final ObservableEmitter<T> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "");
                BaseTrafficType.this.KClassImpl$Data$declaredNonStaticMembers$2(str);
                ToggleManager MyBillsEntityDataFactory = ToggleManager.MyBillsEntityDataFactory();
                String str2 = str;
                String BuiltInFictitiousFunctionClassFactory = BaseTrafficType.this.BuiltInFictitiousFunctionClassFactory();
                Object obj = referralConfigEntity;
                final boolean z2 = z;
                final BaseTrafficType baseTrafficType2 = BaseTrafficType.this;
                final String str3 = str;
                MyBillsEntityDataFactory.getAuthRequestContext(str2, BuiltInFictitiousFunctionClassFactory, ReferralConfigEntity.class, obj, new ToggleCallback<T>() { // from class: id.dana.data.referralconfig.repository.source.split.SplitReferralConfigEntityData$getReferralConfig$lambda-0$$inlined$getConfigOnceReady$1.1
                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onComplete(String treatment, T value) {
                        Unit unit;
                        Intrinsics.checkNotNullParameter(treatment, "");
                        if (value != null) {
                            boolean z3 = z2;
                            BaseTrafficType baseTrafficType3 = baseTrafficType2;
                            String str4 = str3;
                            ObservableEmitter observableEmitter2 = observableEmitter;
                            if (z3 && Intrinsics.areEqual(treatment, "control")) {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(treatment), str4, "Not Received", ConfigType.ASYNC);
                                observableEmitter2.onError(new UnexpectedTreatment(str4));
                            } else {
                                baseTrafficType3.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(treatment), str4, "Received", ConfigType.ASYNC);
                                observableEmitter2.onNext(value);
                                observableEmitter2.onComplete();
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            BaseTrafficType baseTrafficType4 = baseTrafficType2;
                            String str5 = str3;
                            ObservableEmitter observableEmitter3 = observableEmitter;
                            baseTrafficType4.MyBillsEntityDataFactory(BaseTrafficType.getAuthRequestContext(treatment), str5, "Not Received", ConfigType.ASYNC);
                            observableEmitter3.onError(new SplitNull(str5));
                        }
                    }

                    @Override // id.dana.lib.toggle.ToggleCallback
                    public final void onError() {
                        baseTrafficType2.MyBillsEntityDataFactory("", str3, "Not Received", ConfigType.ASYNC);
                        observableEmitter.onError(new SplitException("Error when get toggle config"));
                    }
                }, BaseTrafficType.this.getAuthRequestContext);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "");
        return create;
    }
}
