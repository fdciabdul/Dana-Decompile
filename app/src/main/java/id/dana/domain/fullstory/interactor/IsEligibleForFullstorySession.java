package id.dana.domain.fullstory.interactor;

import android.text.format.DateUtils;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.fullstory.FullstoryRepository;
import id.dana.domain.fullstory.model.FullstoryConfig;
import id.dana.domain.fullstory.model.FullstoryPreferenceConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/domain/fullstory/interactor/IsEligibleForFullstorySession;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/core/usecase/NoParams;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/core/usecase/NoParams;)Lio/reactivex/Observable;", "", "maxSessPerDay", "sessionCount", "compareSessionCountWithMaxSessionAllowed", "(II)Lio/reactivex/Observable;", "Lid/dana/domain/fullstory/model/FullstoryConfig;", "fullstoryConfig", "handleFullstoryConfigSessionCount", "(Lid/dana/domain/fullstory/model/FullstoryConfig;)Lio/reactivex/Observable;", "Lid/dana/domain/fullstory/model/FullstoryPreferenceConfig;", "manageSessionPreference", "()Lid/dana/domain/fullstory/model/FullstoryPreferenceConfig;", "Lid/dana/domain/fullstory/FullstoryRepository;", "fullstoryRepository", "Lid/dana/domain/fullstory/FullstoryRepository;", "<init>", "(Lid/dana/domain/fullstory/FullstoryRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IsEligibleForFullstorySession extends BaseUseCase<Boolean, NoParams> {
    private final FullstoryRepository fullstoryRepository;

    @Inject
    public IsEligibleForFullstorySession(FullstoryRepository fullstoryRepository) {
        Intrinsics.checkNotNullParameter(fullstoryRepository, "");
        this.fullstoryRepository = fullstoryRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(NoParams params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable switchMap = this.fullstoryRepository.getFullstoryConfig().switchMap(new Function() { // from class: id.dana.domain.fullstory.interactor.IsEligibleForFullstorySession$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2336buildUseCase$lambda0;
                m2336buildUseCase$lambda0 = IsEligibleForFullstorySession.m2336buildUseCase$lambda0(IsEligibleForFullstorySession.this, (FullstoryConfig) obj);
                return m2336buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(switchMap, "");
        return switchMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final ObservableSource m2336buildUseCase$lambda0(IsEligibleForFullstorySession isEligibleForFullstorySession, FullstoryConfig fullstoryConfig) {
        Observable<Boolean> just;
        Intrinsics.checkNotNullParameter(isEligibleForFullstorySession, "");
        Intrinsics.checkNotNullParameter(fullstoryConfig, "");
        if (fullstoryConfig.getEnable()) {
            if (fullstoryConfig.getMaxSessionPerDay() < 0) {
                just = Observable.just(Boolean.TRUE);
                Intrinsics.checkNotNullExpressionValue(just, "");
            } else {
                just = isEligibleForFullstorySession.handleFullstoryConfigSessionCount(fullstoryConfig);
            }
        } else {
            just = Observable.just(Boolean.FALSE);
            Intrinsics.checkNotNullExpressionValue(just, "");
        }
        return just;
    }

    private final Observable<Boolean> handleFullstoryConfigSessionCount(FullstoryConfig fullstoryConfig) {
        return compareSessionCountWithMaxSessionAllowed(fullstoryConfig.getMaxSessionPerDay(), manageSessionPreference().getSessionCount());
    }

    private final FullstoryPreferenceConfig manageSessionPreference() {
        FullstoryPreferenceConfig sessionCounterFromPreference = this.fullstoryRepository.getSessionCounterFromPreference();
        if (sessionCounterFromPreference != null) {
            if (DateUtils.isToday(sessionCounterFromPreference.getLastSessionTime())) {
                sessionCounterFromPreference.setSessionCount(sessionCounterFromPreference.getSessionCount() + 1);
            } else {
                sessionCounterFromPreference.setSessionCount(1);
            }
            sessionCounterFromPreference.setLastSessionTime(System.currentTimeMillis());
        } else {
            sessionCounterFromPreference = new FullstoryPreferenceConfig(System.currentTimeMillis(), 1);
        }
        this.fullstoryRepository.setSessionCounterToPreference(sessionCounterFromPreference);
        return sessionCounterFromPreference;
    }

    private final Observable<Boolean> compareSessionCountWithMaxSessionAllowed(int maxSessPerDay, int sessionCount) {
        if (sessionCount > maxSessPerDay) {
            Observable<Boolean> just = Observable.just(Boolean.FALSE);
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }
        Observable<Boolean> just2 = Observable.just(Boolean.TRUE);
        Intrinsics.checkNotNullExpressionValue(just2, "");
        return just2;
    }
}
