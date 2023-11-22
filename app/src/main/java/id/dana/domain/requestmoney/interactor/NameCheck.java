package id.dana.domain.requestmoney.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.requestmoney.RequestMoneyRepository;
import id.dana.domain.requestmoney.exception.NameCheckFreezeException;
import id.dana.domain.requestmoney.model.NameCheckConfig;
import id.dana.domain.sendmoney.model.NameCheckParam;
import id.dana.domain.sendmoney.model.WithdrawNameCheck;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0001B\u0019\b\u0007\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b-\u0010.J)\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\fJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0014\u0010\fJ\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001b\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\nH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u0011H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\nH\u0002¢\u0006\u0004\b&\u0010\"R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,"}, d2 = {"Lid/dana/domain/requestmoney/interactor/NameCheck;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/sendmoney/model/WithdrawNameCheck;", "Lkotlin/Pair;", "Lid/dana/domain/requestmoney/model/NameCheckConfig;", "Lid/dana/domain/sendmoney/model/NameCheckParam;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lkotlin/Pair;)Lio/reactivex/Observable;", "", "getCurrentTimestamp", "()J", "nameCheckConfig", "getExpiredTimestamp", "(Lid/dana/domain/requestmoney/model/NameCheckConfig;)J", "getLastNameCheckTimestamp", "", "getNameCheckCount", "()I", "getNameCheckExpiredTime", "currentNameCheckCount", "", "isNameCheckCountExceedLimit", "(ILid/dana/domain/requestmoney/model/NameCheckConfig;)Z", "freezeRemainingTime", "freezeExpiredTime", "isShouldReset", "(Lid/dana/domain/requestmoney/model/NameCheckConfig;JJ)Z", "", "resetNameCheckCount", "()V", "timestamp", "saveLastNameCheckTimestamp", "(J)Z", "count", "saveNameCheckCount", "(I)Z", "saveNameCheckExpiredTime", "Lid/dana/domain/requestmoney/RequestMoneyRepository;", "requestMoneyRepository", "Lid/dana/domain/requestmoney/RequestMoneyRepository;", "Lid/dana/domain/sendmoney/repository/SendMoneyRepository;", "sendMoneyRepository", "Lid/dana/domain/sendmoney/repository/SendMoneyRepository;", "<init>", "(Lid/dana/domain/requestmoney/RequestMoneyRepository;Lid/dana/domain/sendmoney/repository/SendMoneyRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NameCheck extends BaseUseCase<WithdrawNameCheck, Pair<? extends NameCheckConfig, ? extends NameCheckParam>> {
    private final RequestMoneyRepository requestMoneyRepository;
    private final SendMoneyRepository sendMoneyRepository;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* bridge */ /* synthetic */ Observable<WithdrawNameCheck> buildUseCase(Pair<? extends NameCheckConfig, ? extends NameCheckParam> pair) {
        return buildUseCase2((Pair<NameCheckConfig, ? extends NameCheckParam>) pair);
    }

    @Inject
    public NameCheck(RequestMoneyRepository requestMoneyRepository, SendMoneyRepository sendMoneyRepository) {
        Intrinsics.checkNotNullParameter(requestMoneyRepository, "");
        Intrinsics.checkNotNullParameter(sendMoneyRepository, "");
        this.requestMoneyRepository = requestMoneyRepository;
        this.sendMoneyRepository = sendMoneyRepository;
    }

    /* renamed from: buildUseCase  reason: avoid collision after fix types in other method */
    public final Observable<WithdrawNameCheck> buildUseCase2(Pair<NameCheckConfig, ? extends NameCheckParam> params) {
        Intrinsics.checkNotNullParameter(params, "");
        NameCheckConfig first = params.getFirst();
        NameCheckParam second = params.getSecond();
        long nameCheckExpiredTime = getNameCheckExpiredTime();
        long currentTimestamp = nameCheckExpiredTime - getCurrentTimestamp();
        if (isShouldReset(first, currentTimestamp, nameCheckExpiredTime)) {
            resetNameCheckCount();
        }
        if (currentTimestamp > 0) {
            Observable<WithdrawNameCheck> error = Observable.error(new NameCheckFreezeException());
            Intrinsics.checkNotNullExpressionValue(error, "");
            return error;
        }
        int nameCheckCount = getNameCheckCount();
        if (isNameCheckCountExceedLimit(nameCheckCount, first)) {
            saveNameCheckExpiredTime(getExpiredTimestamp(first));
            Observable<WithdrawNameCheck> error2 = Observable.error(new NameCheckFreezeException());
            Intrinsics.checkNotNullExpressionValue(error2, "");
            return error2;
        }
        saveNameCheckCount(nameCheckCount + 1);
        saveLastNameCheckTimestamp(getCurrentTimestamp());
        Observable<WithdrawNameCheck> nameCheck = this.sendMoneyRepository.nameCheck(second);
        Intrinsics.checkNotNullExpressionValue(nameCheck, "");
        return nameCheck;
    }

    private final boolean isShouldReset(NameCheckConfig nameCheckConfig, long freezeRemainingTime, long freezeExpiredTime) {
        return getCurrentTimestamp() - getLastNameCheckTimestamp() > ((long) nameCheckConfig.getResetTime()) || (freezeRemainingTime <= 0 && freezeExpiredTime != 0);
    }

    private final boolean saveLastNameCheckTimestamp(long timestamp) {
        return this.requestMoneyRepository.setLastNameCheckTimestamp(timestamp);
    }

    private final boolean saveNameCheckCount(int count) {
        return this.requestMoneyRepository.setNameCheckCount(count);
    }

    private final boolean saveNameCheckExpiredTime(long timestamp) {
        return this.requestMoneyRepository.setNameCheckExpiredTime(timestamp);
    }

    private final long getLastNameCheckTimestamp() {
        return this.requestMoneyRepository.getLastNameCheckTimestamp();
    }

    private final int getNameCheckCount() {
        return this.requestMoneyRepository.getNameCheckCount();
    }

    private final long getNameCheckExpiredTime() {
        return this.requestMoneyRepository.getNameCheckExpiredTime();
    }

    private final boolean isNameCheckCountExceedLimit(int currentNameCheckCount, NameCheckConfig nameCheckConfig) {
        return currentNameCheckCount >= nameCheckConfig.getRetryLimit();
    }

    private final long getCurrentTimestamp() {
        return TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    private final long getExpiredTimestamp(NameCheckConfig nameCheckConfig) {
        return getCurrentTimestamp() + nameCheckConfig.getFreezeTime();
    }

    private final void resetNameCheckCount() {
        saveNameCheckCount(0);
        saveNameCheckExpiredTime(0L);
    }
}
