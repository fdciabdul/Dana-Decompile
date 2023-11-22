package id.dana.domain.permissionprompt.interactor;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.permissionprompt.PermissionPromptRepository;
import id.dana.domain.permissionprompt.model.NumberOfLocationPermissionPromptShown;
import id.dana.domain.permissionprompt.model.UserLocationPermissionPromptConfig;
import id.dana.domain.util.DateTimeUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002'(B\u0011\b\u0007\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b%\u0010&J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J9\u0010\u000e\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0012\u000e\u0012\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\u00050\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJI\u0010\u0010\u001a<\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0012&\u0012$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\u000b0\u00050\nH\u0002¢\u0006\u0004\b\u0010\u0010\u0011JQ\u0010\u0013\u001a<\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0012&\u0012$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\u000b0\u00050\n2\u0006\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0013\u0010\u000fJA\u0010\u0014\u001a,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\u00050\n2\u0006\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\u0005H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ)\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\u00052\u0006\u0010\u001f\u001a\u00020\rH\u0002¢\u0006\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$"}, d2 = {"Lid/dana/domain/permissionprompt/interactor/CheckLocationPermissionPromptFeature;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/permissionprompt/interactor/CheckLocationPermissionPromptFeature$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/permissionprompt/interactor/CheckLocationPermissionPromptFeature$Params;)Lio/reactivex/Observable;", "", "currentTime", "Lkotlin/Function1;", "Lkotlin/Pair;", "Lid/dana/domain/permissionprompt/model/UserLocationPermissionPromptConfig;", "Lid/dana/domain/permissionprompt/model/NumberOfLocationPermissionPromptShown;", "checkIfLessThanMaximum", "(J)Lkotlin/jvm/functions/Function1;", "checkIsFeatureEnabled", "()Lkotlin/jvm/functions/Function1;", "currentTimestamp", "checkIsLastShowedUIInTheSameMonth", "checkShouldUpdateConfigFromSplit", "lastShown", "", GriverMonitorConstants.KEY_THRESHOLD, "checkWithThreshold", "(JJI)Z", "getLocationPermissionPromptData", "()Lio/reactivex/Observable;", "time", "getMonth", "(J)I", "lastShowedUI", "updateConfigFromSplit", "(Lid/dana/domain/permissionprompt/model/NumberOfLocationPermissionPromptShown;)Lio/reactivex/Observable;", "Lid/dana/domain/permissionprompt/PermissionPromptRepository;", "permissionPromptRepository", "Lid/dana/domain/permissionprompt/PermissionPromptRepository;", "<init>", "(Lid/dana/domain/permissionprompt/PermissionPromptRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CheckLocationPermissionPromptFeature extends BaseUseCase<Boolean, Params> {
    private static final long EPOCH_TO_MILLISECOND_EPOCH = 1000;
    private static final long SECONDS_PER_DAY = 86400;
    private final PermissionPromptRepository permissionPromptRepository;

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkWithThreshold(long currentTime, long lastShown, int threshold) {
        return currentTime - lastShown > ((long) threshold) * 86400;
    }

    @Inject
    public CheckLocationPermissionPromptFeature(PermissionPromptRepository permissionPromptRepository) {
        Intrinsics.checkNotNullParameter(permissionPromptRepository, "");
        this.permissionPromptRepository = permissionPromptRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>> locationPermissionPromptData = getLocationPermissionPromptData();
        final Function1<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>, Observable<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>>> checkShouldUpdateConfigFromSplit = checkShouldUpdateConfigFromSplit(params.getCurrentTimestamp());
        Observable<R> flatMap = locationPermissionPromptData.flatMap(new Function() { // from class: id.dana.domain.permissionprompt.interactor.CheckLocationPermissionPromptFeature$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2403buildUseCase$lambda0;
                m2403buildUseCase$lambda0 = CheckLocationPermissionPromptFeature.m2403buildUseCase$lambda0(Function1.this, (Pair) obj);
                return m2403buildUseCase$lambda0;
            }
        });
        final Function1<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>, Observable<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>>> checkIsFeatureEnabled = checkIsFeatureEnabled();
        Observable flatMap2 = flatMap.flatMap(new Function() { // from class: id.dana.domain.permissionprompt.interactor.CheckLocationPermissionPromptFeature$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2404buildUseCase$lambda1;
                m2404buildUseCase$lambda1 = CheckLocationPermissionPromptFeature.m2404buildUseCase$lambda1(Function1.this, (Pair) obj);
                return m2404buildUseCase$lambda1;
            }
        });
        final Function1<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>, Observable<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>>> checkIsLastShowedUIInTheSameMonth = checkIsLastShowedUIInTheSameMonth(params.getCurrentTimestamp());
        Observable flatMap3 = flatMap2.flatMap(new Function() { // from class: id.dana.domain.permissionprompt.interactor.CheckLocationPermissionPromptFeature$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2405buildUseCase$lambda2;
                m2405buildUseCase$lambda2 = CheckLocationPermissionPromptFeature.m2405buildUseCase$lambda2(Function1.this, (Pair) obj);
                return m2405buildUseCase$lambda2;
            }
        });
        final Function1<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>, Observable<Boolean>> checkIfLessThanMaximum = checkIfLessThanMaximum(params.getCurrentTimestamp());
        Observable<Boolean> flatMap4 = flatMap3.flatMap(new Function() { // from class: id.dana.domain.permissionprompt.interactor.CheckLocationPermissionPromptFeature$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2406buildUseCase$lambda3;
                m2406buildUseCase$lambda3 = CheckLocationPermissionPromptFeature.m2406buildUseCase$lambda3(Function1.this, (Pair) obj);
                return m2406buildUseCase$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap4, "");
        return flatMap4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final ObservableSource m2403buildUseCase$lambda0(Function1 function1, Pair pair) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (ObservableSource) function1.invoke(pair);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-1  reason: not valid java name */
    public static final ObservableSource m2404buildUseCase$lambda1(Function1 function1, Pair pair) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (ObservableSource) function1.invoke(pair);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-2  reason: not valid java name */
    public static final ObservableSource m2405buildUseCase$lambda2(Function1 function1, Pair pair) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (ObservableSource) function1.invoke(pair);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-3  reason: not valid java name */
    public static final ObservableSource m2406buildUseCase$lambda3(Function1 function1, Pair pair) {
        Intrinsics.checkNotNullParameter(function1, "");
        return (ObservableSource) function1.invoke(pair);
    }

    private final Observable<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>> getLocationPermissionPromptData() {
        Observable<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>> zip = Observable.zip(this.permissionPromptRepository.getLocationPermissionPromptConfig(false), this.permissionPromptRepository.getNumberOfLocationPermissionPromptShown(), new BiFunction() { // from class: id.dana.domain.permissionprompt.interactor.CheckLocationPermissionPromptFeature$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Pair m2407getLocationPermissionPromptData$lambda4;
                m2407getLocationPermissionPromptData$lambda4 = CheckLocationPermissionPromptFeature.m2407getLocationPermissionPromptData$lambda4((UserLocationPermissionPromptConfig) obj, (NumberOfLocationPermissionPromptShown) obj2);
                return m2407getLocationPermissionPromptData$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getLocationPermissionPromptData$lambda-4  reason: not valid java name */
    public static final Pair m2407getLocationPermissionPromptData$lambda4(UserLocationPermissionPromptConfig userLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown numberOfLocationPermissionPromptShown) {
        Intrinsics.checkNotNullParameter(userLocationPermissionPromptConfig, "");
        Intrinsics.checkNotNullParameter(numberOfLocationPermissionPromptShown, "");
        return new Pair(userLocationPermissionPromptConfig, numberOfLocationPermissionPromptShown);
    }

    private final Function1<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>, Observable<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>>> checkShouldUpdateConfigFromSplit(final long currentTimestamp) {
        return (Function1) new Function1<Pair<? extends UserLocationPermissionPromptConfig, ? extends NumberOfLocationPermissionPromptShown>, Observable<Pair<? extends UserLocationPermissionPromptConfig, ? extends NumberOfLocationPermissionPromptShown>>>() { // from class: id.dana.domain.permissionprompt.interactor.CheckLocationPermissionPromptFeature$checkShouldUpdateConfigFromSplit$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Observable<Pair<? extends UserLocationPermissionPromptConfig, ? extends NumberOfLocationPermissionPromptShown>> invoke(Pair<? extends UserLocationPermissionPromptConfig, ? extends NumberOfLocationPermissionPromptShown> pair) {
                return invoke2((Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>) pair);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Observable<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>> invoke2(Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown> pair) {
                boolean checkWithThreshold;
                Observable<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>> updateConfigFromSplit;
                Intrinsics.checkNotNullParameter(pair, "");
                checkWithThreshold = CheckLocationPermissionPromptFeature.this.checkWithThreshold(currentTimestamp, pair.getSecond().getLastReminderUIShowed(), pair.getFirst().getRepeatedInDays());
                if (checkWithThreshold) {
                    updateConfigFromSplit = CheckLocationPermissionPromptFeature.this.updateConfigFromSplit(pair.getSecond());
                    return updateConfigFromSplit;
                }
                Observable<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>> just = Observable.just(new Pair(pair.getFirst(), pair.getSecond()));
                Intrinsics.checkNotNullExpressionValue(just, "");
                return just;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Observable<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>> updateConfigFromSplit(final NumberOfLocationPermissionPromptShown lastShowedUI) {
        Observable flatMap = this.permissionPromptRepository.getLocationPermissionPromptConfig(true).flatMap(new Function() { // from class: id.dana.domain.permissionprompt.interactor.CheckLocationPermissionPromptFeature$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2408updateConfigFromSplit$lambda5;
                m2408updateConfigFromSplit$lambda5 = CheckLocationPermissionPromptFeature.m2408updateConfigFromSplit$lambda5(NumberOfLocationPermissionPromptShown.this, (UserLocationPermissionPromptConfig) obj);
                return m2408updateConfigFromSplit$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateConfigFromSplit$lambda-5  reason: not valid java name */
    public static final ObservableSource m2408updateConfigFromSplit$lambda5(NumberOfLocationPermissionPromptShown numberOfLocationPermissionPromptShown, UserLocationPermissionPromptConfig userLocationPermissionPromptConfig) {
        Intrinsics.checkNotNullParameter(numberOfLocationPermissionPromptShown, "");
        Intrinsics.checkNotNullParameter(userLocationPermissionPromptConfig, "");
        return Observable.just(new Pair(userLocationPermissionPromptConfig, numberOfLocationPermissionPromptShown));
    }

    private final Function1<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>, Observable<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>>> checkIsFeatureEnabled() {
        return new Function1<Pair<? extends UserLocationPermissionPromptConfig, ? extends NumberOfLocationPermissionPromptShown>, Observable<Pair<? extends UserLocationPermissionPromptConfig, ? extends NumberOfLocationPermissionPromptShown>>>() { // from class: id.dana.domain.permissionprompt.interactor.CheckLocationPermissionPromptFeature$checkIsFeatureEnabled$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Observable<Pair<? extends UserLocationPermissionPromptConfig, ? extends NumberOfLocationPermissionPromptShown>> invoke(Pair<? extends UserLocationPermissionPromptConfig, ? extends NumberOfLocationPermissionPromptShown> pair) {
                return invoke2((Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>) pair);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Observable<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>> invoke2(Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown> pair) {
                Intrinsics.checkNotNullParameter(pair, "");
                if (!pair.getFirst().getEnable()) {
                    Observable<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>> error = Observable.error(new IllegalStateException());
                    Intrinsics.checkNotNullExpressionValue(error, "");
                    return error;
                }
                Observable<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>> just = Observable.just(new Pair(pair.getFirst(), pair.getSecond()));
                Intrinsics.checkNotNullExpressionValue(just, "");
                return just;
            }
        };
    }

    private final Function1<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>, Observable<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>>> checkIsLastShowedUIInTheSameMonth(final long currentTimestamp) {
        return (Function1) new Function1<Pair<? extends UserLocationPermissionPromptConfig, ? extends NumberOfLocationPermissionPromptShown>, Observable<Pair<? extends UserLocationPermissionPromptConfig, ? extends NumberOfLocationPermissionPromptShown>>>() { // from class: id.dana.domain.permissionprompt.interactor.CheckLocationPermissionPromptFeature$checkIsLastShowedUIInTheSameMonth$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Observable<Pair<? extends UserLocationPermissionPromptConfig, ? extends NumberOfLocationPermissionPromptShown>> invoke(Pair<? extends UserLocationPermissionPromptConfig, ? extends NumberOfLocationPermissionPromptShown> pair) {
                return invoke2((Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>) pair);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Observable<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>> invoke2(Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown> pair) {
                int month;
                int month2;
                PermissionPromptRepository permissionPromptRepository;
                Intrinsics.checkNotNullParameter(pair, "");
                if (pair.getSecond().getLastReminderUIShowed() > 0) {
                    month = CheckLocationPermissionPromptFeature.this.getMonth(currentTimestamp);
                    month2 = CheckLocationPermissionPromptFeature.this.getMonth(pair.getSecond().getLastReminderUIShowed());
                    if (month != month2) {
                        NumberOfLocationPermissionPromptShown numberOfLocationPermissionPromptShown = new NumberOfLocationPermissionPromptShown(0, 0L, 3, null);
                        permissionPromptRepository = CheckLocationPermissionPromptFeature.this.permissionPromptRepository;
                        permissionPromptRepository.saveNumberOfLocationPermissionPromptShown(numberOfLocationPermissionPromptShown);
                        return Observable.just(new Pair(pair.getFirst(), numberOfLocationPermissionPromptShown));
                    }
                }
                return Observable.just(new Pair(pair.getFirst(), pair.getSecond()));
            }
        };
    }

    private final Function1<Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>, Observable<Boolean>> checkIfLessThanMaximum(final long currentTime) {
        return (Function1) new Function1<Pair<? extends UserLocationPermissionPromptConfig, ? extends NumberOfLocationPermissionPromptShown>, Observable<Boolean>>() { // from class: id.dana.domain.permissionprompt.interactor.CheckLocationPermissionPromptFeature$checkIfLessThanMaximum$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Observable<Boolean> invoke(Pair<? extends UserLocationPermissionPromptConfig, ? extends NumberOfLocationPermissionPromptShown> pair) {
                return invoke2((Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown>) pair);
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Observable<Boolean> invoke2(Pair<UserLocationPermissionPromptConfig, NumberOfLocationPermissionPromptShown> pair) {
                boolean checkWithThreshold;
                Intrinsics.checkNotNullParameter(pair, "");
                checkWithThreshold = CheckLocationPermissionPromptFeature.this.checkWithThreshold(currentTime, pair.getSecond().getLastReminderUIShowed(), pair.getFirst().getRepeatedInDays());
                boolean z = false;
                boolean z2 = pair.getSecond().getTotalReminderUIShowed() < pair.getFirst().getMaxRepeatedInAMonth();
                if (checkWithThreshold && z2) {
                    z = true;
                }
                return Observable.just(Boolean.valueOf(z));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getMonth(long time) {
        DateTimeUtils dateTimeUtils = DateTimeUtils.INSTANCE;
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "");
        return dateTimeUtils.getMonthFromTimeMillis(time * 1000, locale);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/permissionprompt/interactor/CheckLocationPermissionPromptFeature$Params;", "", "", "currentTimestamp", "J", "getCurrentTimestamp", "()J", "<init>", "(J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final long currentTimestamp;

        public Params(long j) {
            this.currentTimestamp = j;
        }

        @JvmName(name = "getCurrentTimestamp")
        public final long getCurrentTimestamp() {
            return this.currentTimestamp;
        }
    }
}
