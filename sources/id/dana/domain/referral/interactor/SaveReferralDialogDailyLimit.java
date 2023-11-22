package id.dana.domain.referral.interactor;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.referral.ReferralEngagementDialogRepository;
import id.dana.domain.referral.model.ReferralDialogLimitCache;
import id.dana.domain.util.DateTimeUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/domain/referral/interactor/SaveReferralDialogDailyLimit;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/referral/interactor/SaveReferralDialogDailyLimit$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/referral/interactor/SaveReferralDialogDailyLimit$Param;)Lio/reactivex/Observable;", "Lid/dana/domain/referral/model/ReferralDialogLimitCache;", "referralDialogLimitCache", "", "currentTime", "onGetDialogDailyLimitCache", "(Lid/dana/domain/referral/model/ReferralDialogLimitCache;J)Lio/reactivex/Observable;", "saveOnFirstTimeOfTheDay", "(J)Lio/reactivex/Observable;", "Lid/dana/domain/referral/ReferralEngagementDialogRepository;", "referralEngagementDialogRepository", "Lid/dana/domain/referral/ReferralEngagementDialogRepository;", "<init>", "(Lid/dana/domain/referral/ReferralEngagementDialogRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SaveReferralDialogDailyLimit extends BaseUseCase<Boolean, Param> {
    private final ReferralEngagementDialogRepository referralEngagementDialogRepository;

    @Inject
    public SaveReferralDialogDailyLimit(ReferralEngagementDialogRepository referralEngagementDialogRepository) {
        Intrinsics.checkNotNullParameter(referralEngagementDialogRepository, "");
        this.referralEngagementDialogRepository = referralEngagementDialogRepository;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÀ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004"}, d2 = {"Lid/dana/domain/referral/interactor/SaveReferralDialogDailyLimit$Param;", "", "", "component1$domain_productionRelease", "()J", "currentTime", "copy", "(J)Lid/dana/domain/referral/interactor/SaveReferralDialogDailyLimit$Param;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "J", "getCurrentTime$domain_productionRelease", "<init>", "(J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Param {
        private final long currentTime;

        public static /* synthetic */ Param copy$default(Param param, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = param.currentTime;
            }
            return param.copy(j);
        }

        /* renamed from: component1$domain_productionRelease  reason: from getter */
        public final long getCurrentTime() {
            return this.currentTime;
        }

        public final Param copy(long currentTime) {
            return new Param(currentTime);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Param) && this.currentTime == ((Param) other).currentTime;
        }

        public final int hashCode() {
            return Cbor$Arg$$ExternalSyntheticBackport0.m(this.currentTime);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(currentTime=");
            sb.append(this.currentTime);
            sb.append(')');
            return sb.toString();
        }

        public Param(long j) {
            this.currentTime = j;
        }

        @JvmName(name = "getCurrentTime$domain_productionRelease")
        public final long getCurrentTime$domain_productionRelease() {
            return this.currentTime;
        }
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(final Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable flatMap = this.referralEngagementDialogRepository.getDialogDailyLimitCache().flatMap(new Function() { // from class: id.dana.domain.referral.interactor.SaveReferralDialogDailyLimit$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2455buildUseCase$lambda0;
                m2455buildUseCase$lambda0 = SaveReferralDialogDailyLimit.m2455buildUseCase$lambda0(SaveReferralDialogDailyLimit.this, params, (ReferralDialogLimitCache) obj);
                return m2455buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final ObservableSource m2455buildUseCase$lambda0(SaveReferralDialogDailyLimit saveReferralDialogDailyLimit, Param param, ReferralDialogLimitCache referralDialogLimitCache) {
        Intrinsics.checkNotNullParameter(saveReferralDialogDailyLimit, "");
        Intrinsics.checkNotNullParameter(param, "");
        Intrinsics.checkNotNullParameter(referralDialogLimitCache, "");
        return saveReferralDialogDailyLimit.onGetDialogDailyLimitCache(referralDialogLimitCache, param.getCurrentTime$domain_productionRelease());
    }

    private final Observable<Boolean> onGetDialogDailyLimitCache(ReferralDialogLimitCache referralDialogLimitCache, long currentTime) {
        long lastTimeShown = referralDialogLimitCache.getLastTimeShown();
        int numberOfDialogShowToday = referralDialogLimitCache.getNumberOfDialogShowToday();
        if (lastTimeShown >= 0 && DateTimeUtils.isSameDay(currentTime, lastTimeShown)) {
            return this.referralEngagementDialogRepository.saveDialogDailyLimit(lastTimeShown, numberOfDialogShowToday + 1);
        }
        return saveOnFirstTimeOfTheDay(currentTime);
    }

    private final Observable<Boolean> saveOnFirstTimeOfTheDay(long currentTime) {
        return ReferralEngagementDialogRepository.CC.saveDialogDailyLimit$default(this.referralEngagementDialogRepository, currentTime, 0, 2, null);
    }
}
