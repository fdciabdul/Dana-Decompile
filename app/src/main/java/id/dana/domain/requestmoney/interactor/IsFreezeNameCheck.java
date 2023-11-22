package id.dana.domain.requestmoney.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.requestmoney.RequestMoneyRepository;
import id.dana.domain.requestmoney.model.NameCheckConfig;
import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nJ'\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/domain/requestmoney/interactor/IsFreezeNameCheck;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/requestmoney/model/NameCheckConfig;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/requestmoney/model/NameCheckConfig;)Lio/reactivex/Observable;", "", "getCurrentTimestamp", "()J", "getLastNameCheckTimestamp", "getNameCheckExpiredTime", "nameCheckConfig", "freezeRemainingTime", "freezeExpiredTime", "isShouldReset", "(Lid/dana/domain/requestmoney/model/NameCheckConfig;JJ)Z", "", "resetNameCheckCount", "()V", "", "count", "saveNameCheckCount", "(I)Z", "timestamp", "saveNameCheckExpiredTime", "(J)Z", "Lid/dana/domain/requestmoney/RequestMoneyRepository;", "requestMoneyRepository", "Lid/dana/domain/requestmoney/RequestMoneyRepository;", "<init>", "(Lid/dana/domain/requestmoney/RequestMoneyRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class IsFreezeNameCheck extends BaseUseCase<Boolean, NameCheckConfig> {
    private final RequestMoneyRepository requestMoneyRepository;

    @Inject
    public IsFreezeNameCheck(RequestMoneyRepository requestMoneyRepository) {
        Intrinsics.checkNotNullParameter(requestMoneyRepository, "");
        this.requestMoneyRepository = requestMoneyRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(NameCheckConfig params) {
        Intrinsics.checkNotNullParameter(params, "");
        long nameCheckExpiredTime = getNameCheckExpiredTime();
        long currentTimestamp = nameCheckExpiredTime - getCurrentTimestamp();
        if (isShouldReset(params, currentTimestamp, nameCheckExpiredTime)) {
            resetNameCheckCount();
        }
        Observable<Boolean> just = Observable.just(Boolean.valueOf(currentTimestamp > 0));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    private final boolean isShouldReset(NameCheckConfig nameCheckConfig, long freezeRemainingTime, long freezeExpiredTime) {
        return getCurrentTimestamp() - getLastNameCheckTimestamp() > ((long) nameCheckConfig.getResetTime()) || (freezeRemainingTime <= 0 && freezeExpiredTime != 0);
    }

    private final long getLastNameCheckTimestamp() {
        return this.requestMoneyRepository.getLastNameCheckTimestamp();
    }

    private final long getNameCheckExpiredTime() {
        return this.requestMoneyRepository.getNameCheckExpiredTime();
    }

    private final long getCurrentTimestamp() {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    private final boolean saveNameCheckCount(int count) {
        return this.requestMoneyRepository.setNameCheckCount(count);
    }

    private final boolean saveNameCheckExpiredTime(long timestamp) {
        return this.requestMoneyRepository.setNameCheckExpiredTime(timestamp);
    }

    private final void resetNameCheckCount() {
        saveNameCheckCount(0);
        saveNameCheckExpiredTime(0L);
    }
}
