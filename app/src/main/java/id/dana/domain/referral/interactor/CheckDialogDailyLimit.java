package id.dana.domain.referral.interactor;

import id.dana.data.here.model.HereUrlConstant;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.referral.ReferralEngagementDialogRepository;
import id.dana.domain.referral.ReferralRepository;
import id.dana.domain.referral.model.ReferralDialogLimitCache;
import id.dana.domain.referral.model.ReferralEngagementDialogConfig;
import id.dana.domain.util.DateTimeUtils;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0019\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/domain/referral/interactor/CheckDialogDailyLimit;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/referral/interactor/CheckDialogDailyLimit$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/referral/interactor/CheckDialogDailyLimit$Params;)Lio/reactivex/Observable;", "", "currentEpochTime", "", HereUrlConstant.LIMIT, "Lid/dana/domain/referral/model/ReferralDialogLimitCache;", "dailyLimitCache", "isDialogExceedLimit", "(JILid/dana/domain/referral/model/ReferralDialogLimitCache;)Z", "Lid/dana/domain/referral/ReferralEngagementDialogRepository;", "referralEngagementDialogRepository", "Lid/dana/domain/referral/ReferralEngagementDialogRepository;", "Lid/dana/domain/referral/ReferralRepository;", "referralRepository", "Lid/dana/domain/referral/ReferralRepository;", "<init>", "(Lid/dana/domain/referral/ReferralEngagementDialogRepository;Lid/dana/domain/referral/ReferralRepository;)V", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CheckDialogDailyLimit extends BaseUseCase<Boolean, Params> {
    private final ReferralEngagementDialogRepository referralEngagementDialogRepository;
    private final ReferralRepository referralRepository;

    @Inject
    public CheckDialogDailyLimit(ReferralEngagementDialogRepository referralEngagementDialogRepository, ReferralRepository referralRepository) {
        Intrinsics.checkNotNullParameter(referralEngagementDialogRepository, "");
        Intrinsics.checkNotNullParameter(referralRepository, "");
        this.referralEngagementDialogRepository = referralEngagementDialogRepository;
        this.referralRepository = referralRepository;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/referral/interactor/CheckDialogDailyLimit$Params;", "", "", "currentEpochTime", "J", "getCurrentEpochTime$domain_productionRelease", "()J", "<init>", "(J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {
        private final long currentEpochTime;

        public Params(long j) {
            this.currentEpochTime = j;
        }

        @JvmName(name = "getCurrentEpochTime$domain_productionRelease")
        /* renamed from: getCurrentEpochTime$domain_productionRelease  reason: from getter */
        public final long getCurrentEpochTime() {
            return this.currentEpochTime;
        }
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<Boolean> zip = Observable.zip(this.referralRepository.getReferralEngagementDialogConfig(), this.referralEngagementDialogRepository.getDialogDailyLimitCache(), new BiFunction() { // from class: id.dana.domain.referral.interactor.CheckDialogDailyLimit$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Boolean m2450buildUseCase$lambda0;
                m2450buildUseCase$lambda0 = CheckDialogDailyLimit.m2450buildUseCase$lambda0(CheckDialogDailyLimit.this, params, (ReferralEngagementDialogConfig) obj, (ReferralDialogLimitCache) obj2);
                return m2450buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final Boolean m2450buildUseCase$lambda0(CheckDialogDailyLimit checkDialogDailyLimit, Params params, ReferralEngagementDialogConfig referralEngagementDialogConfig, ReferralDialogLimitCache referralDialogLimitCache) {
        Intrinsics.checkNotNullParameter(checkDialogDailyLimit, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(referralEngagementDialogConfig, "");
        Intrinsics.checkNotNullParameter(referralDialogLimitCache, "");
        return Boolean.valueOf(referralEngagementDialogConfig.getEnable() && !checkDialogDailyLimit.isDialogExceedLimit(params.getCurrentEpochTime(), referralEngagementDialogConfig.getDailyLimit(), referralDialogLimitCache));
    }

    private final boolean isDialogExceedLimit(long currentEpochTime, int limit, ReferralDialogLimitCache dailyLimitCache) {
        return DateTimeUtils.isSameDay(currentEpochTime, dailyLimitCache.getLastTimeShown()) && dailyLimitCache.getNumberOfDialogShowToday() >= limit;
    }
}
