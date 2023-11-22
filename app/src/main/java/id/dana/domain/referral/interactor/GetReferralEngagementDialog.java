package id.dana.domain.referral.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.referral.MyReferralConsultRepository;
import id.dana.domain.referral.ReferralRepository;
import id.dana.domain.referral.model.MyReferralConsultRpcResponse;
import id.dana.domain.referral.model.ReferralEngagementDialog;
import id.dana.domain.referral.model.ReferralEngagementDialogCache;
import id.dana.domain.referral.model.ReferralEngagementDialogConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.NoSuchElementException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00014B!\b\u0007\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b2\u00103J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\n\u001a\u001a\u0012\b\u0012\u0006*\u00020\u00020\u0002*\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\u00050\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0011\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u0004\u0018\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ?\u0010\u001f\u001a\u001a\u0012\b\u0012\u0006*\u00020\u00020\u0002*\f\u0012\b\u0012\u0006*\u00020\u00020\u00020\u00050\u00052\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R(\u0010'\u001a\u00020\u001a8\u0007@\u0007X\u0086\u000e¢\u0006\u0018\n\u0004\b'\u0010(\u0012\u0004\b-\u0010.\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u00100\u001a\u00020/8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b0\u00101"}, d2 = {"Lid/dana/domain/referral/interactor/GetReferralEngagementDialog;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/referral/model/ReferralEngagementDialog;", "Lid/dana/domain/referral/interactor/GetReferralEngagementDialog$Param;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/referral/interactor/GetReferralEngagementDialog$Param;)Lio/reactivex/Observable;", "", "currentUnixEpochTime", "checkDialogAvailability", "(J)Lio/reactivex/Observable;", "", "Lid/dana/domain/referral/model/ReferralEngagementDialogCache;", "dialogCaches", "Lid/dana/domain/referral/model/ReferralEngagementDialogConfig;", "dialogConfig", "checkDialogCaches", "(Ljava/util/List;Lid/dana/domain/referral/model/ReferralEngagementDialogConfig;J)Lid/dana/domain/referral/model/ReferralEngagementDialog;", "getEligibleDialogCache", "(Ljava/util/List;)Lid/dana/domain/referral/model/ReferralEngagementDialogCache;", "popupTimerSeed", "timerDuration", "getRemainTime", "(JJJ)J", "deltaPopupTimer", "", "isTimerPassed", "(JJ)Z", "referralConsultEnabled", "enable", "onCheckReferralAvailability", "(ZZJ)Lio/reactivex/Observable;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "configRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "Lid/dana/domain/referral/MyReferralConsultRepository;", "myReferralConsultRepository", "Lid/dana/domain/referral/MyReferralConsultRepository;", "needTimer", "Z", "getNeedTimer", "()Z", "setNeedTimer", "(Z)V", "getNeedTimer$annotations", "()V", "Lid/dana/domain/referral/ReferralRepository;", "referralRepository", "Lid/dana/domain/referral/ReferralRepository;", "<init>", "(Lid/dana/domain/referral/ReferralRepository;Lid/dana/domain/featureconfig/FeatureConfigRepository;Lid/dana/domain/referral/MyReferralConsultRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetReferralEngagementDialog extends BaseUseCase<ReferralEngagementDialog, Param> {
    private final FeatureConfigRepository configRepository;
    private final MyReferralConsultRepository myReferralConsultRepository;
    private boolean needTimer;
    private final ReferralRepository referralRepository;

    public static /* synthetic */ void getNeedTimer$annotations() {
    }

    private final boolean isTimerPassed(long deltaPopupTimer, long timerDuration) {
        return deltaPopupTimer >= timerDuration;
    }

    @Inject
    public GetReferralEngagementDialog(ReferralRepository referralRepository, FeatureConfigRepository featureConfigRepository, MyReferralConsultRepository myReferralConsultRepository) {
        Intrinsics.checkNotNullParameter(referralRepository, "");
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        Intrinsics.checkNotNullParameter(myReferralConsultRepository, "");
        this.referralRepository = referralRepository;
        this.configRepository = featureConfigRepository;
        this.myReferralConsultRepository = myReferralConsultRepository;
    }

    @JvmName(name = "getNeedTimer")
    public final boolean getNeedTimer() {
        return this.needTimer;
    }

    @JvmName(name = "setNeedTimer")
    public final void setNeedTimer(boolean z) {
        this.needTimer = z;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<ReferralEngagementDialog> buildUseCase(final Param params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable<ReferralEngagementDialog> zip = Observable.zip(this.myReferralConsultRepository.getReferralConsult(), this.configRepository.isShowReferralCode(), new BiFunction() { // from class: id.dana.domain.referral.interactor.GetReferralEngagementDialog$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                ReferralEngagementDialog m2451buildUseCase$lambda0;
                m2451buildUseCase$lambda0 = GetReferralEngagementDialog.m2451buildUseCase$lambda0(GetReferralEngagementDialog.this, params, (MyReferralConsultRpcResponse) obj, (Boolean) obj2);
                return m2451buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zip, "");
        return zip;
    }

    /* renamed from: buildUseCase$lambda-0 */
    public static final ReferralEngagementDialog m2451buildUseCase$lambda0(GetReferralEngagementDialog getReferralEngagementDialog, Param param, MyReferralConsultRpcResponse myReferralConsultRpcResponse, Boolean bool) {
        Intrinsics.checkNotNullParameter(getReferralEngagementDialog, "");
        Intrinsics.checkNotNullParameter(param, "");
        Intrinsics.checkNotNullParameter(myReferralConsultRpcResponse, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return getReferralEngagementDialog.onCheckReferralAvailability(myReferralConsultRpcResponse.isCampaignEnable(), bool.booleanValue(), param.getCurrentUnixEpochTime()).blockingFirst();
    }

    private final Observable<ReferralEngagementDialog> onCheckReferralAvailability(boolean referralConsultEnabled, boolean enable, long currentUnixEpochTime) {
        if (referralConsultEnabled && enable) {
            return checkDialogAvailability(currentUnixEpochTime);
        }
        return Observable.just(new ReferralEngagementDialog(false, null, null, null, null, 0L, null, 127, null));
    }

    private final Observable<ReferralEngagementDialog> checkDialogAvailability(final long currentUnixEpochTime) {
        return this.referralRepository.getReferralEngagementDialogConfig().flatMap(new Function() { // from class: id.dana.domain.referral.interactor.GetReferralEngagementDialog$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2452checkDialogAvailability$lambda2;
                m2452checkDialogAvailability$lambda2 = GetReferralEngagementDialog.m2452checkDialogAvailability$lambda2(GetReferralEngagementDialog.this, currentUnixEpochTime, (ReferralEngagementDialogConfig) obj);
                return m2452checkDialogAvailability$lambda2;
            }
        });
    }

    /* renamed from: checkDialogAvailability$lambda-2 */
    public static final ObservableSource m2452checkDialogAvailability$lambda2(final GetReferralEngagementDialog getReferralEngagementDialog, final long j, final ReferralEngagementDialogConfig referralEngagementDialogConfig) {
        ObservableSource map;
        Intrinsics.checkNotNullParameter(getReferralEngagementDialog, "");
        Intrinsics.checkNotNullParameter(referralEngagementDialogConfig, "");
        if (!referralEngagementDialogConfig.getEnable()) {
            map = Observable.just(new ReferralEngagementDialog(false, null, null, null, null, 0L, null, 127, null));
        } else {
            map = getReferralEngagementDialog.referralRepository.getDialogCaches().map(new Function() { // from class: id.dana.domain.referral.interactor.GetReferralEngagementDialog$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    ReferralEngagementDialog m2453checkDialogAvailability$lambda2$lambda1;
                    m2453checkDialogAvailability$lambda2$lambda1 = GetReferralEngagementDialog.m2453checkDialogAvailability$lambda2$lambda1(GetReferralEngagementDialog.this, referralEngagementDialogConfig, j, (List) obj);
                    return m2453checkDialogAvailability$lambda2$lambda1;
                }
            });
        }
        return map;
    }

    /* renamed from: checkDialogAvailability$lambda-2$lambda-1 */
    public static final ReferralEngagementDialog m2453checkDialogAvailability$lambda2$lambda1(GetReferralEngagementDialog getReferralEngagementDialog, ReferralEngagementDialogConfig referralEngagementDialogConfig, long j, List list) {
        Intrinsics.checkNotNullParameter(getReferralEngagementDialog, "");
        Intrinsics.checkNotNullParameter(referralEngagementDialogConfig, "");
        Intrinsics.checkNotNullParameter(list, "");
        return getReferralEngagementDialog.checkDialogCaches(list, referralEngagementDialogConfig, j);
    }

    private final ReferralEngagementDialog checkDialogCaches(List<ReferralEngagementDialogCache> dialogCaches, ReferralEngagementDialogConfig dialogConfig, long currentUnixEpochTime) {
        ReferralEngagementDialogCache eligibleDialogCache = getEligibleDialogCache(dialogCaches);
        if (eligibleDialogCache == null) {
            return new ReferralEngagementDialog(false, null, null, null, null, 0L, null, 127, null);
        }
        return new ReferralEngagementDialog(true, dialogConfig.getDialogTitleId(), dialogConfig.getDialogTitleEn(), dialogConfig.getDialogDescriptionId(), dialogConfig.getDialogDescriptionEn(), getRemainTime(eligibleDialogCache.getShowPopUpTimerSeed(), dialogConfig.getTimerDuration(), currentUnixEpochTime), eligibleDialogCache.getScenario());
    }

    private final long getRemainTime(long popupTimerSeed, long timerDuration, long currentUnixEpochTime) {
        long j = currentUnixEpochTime - popupTimerSeed;
        boolean isTimerPassed = isTimerPassed(j, timerDuration);
        if (isTimerPassed && !this.needTimer) {
            this.needTimer = true;
            return 0L;
        } else if (isTimerPassed) {
            this.needTimer = false;
            return timerDuration;
        } else {
            return timerDuration - j;
        }
    }

    private final ReferralEngagementDialogCache getEligibleDialogCache(List<ReferralEngagementDialogCache> dialogCaches) {
        try {
            for (Object obj : dialogCaches) {
                if (((ReferralEngagementDialogCache) obj).getShowHomeReferralPopup()) {
                    return (ReferralEngagementDialogCache) obj;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        } catch (Exception unused) {
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0001X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/domain/referral/interactor/GetReferralEngagementDialog$Param;", "", "", "currentUnixEpochTime", "J", "getCurrentUnixEpochTime$domain_productionRelease", "()J", "<init>", "(J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Param {
        private final long currentUnixEpochTime;

        public Param(long j) {
            this.currentUnixEpochTime = j;
        }

        @JvmName(name = "getCurrentUnixEpochTime$domain_productionRelease")
        /* renamed from: getCurrentUnixEpochTime$domain_productionRelease  reason: from getter */
        public final long getCurrentUnixEpochTime() {
            return this.currentUnixEpochTime;
        }
    }
}
