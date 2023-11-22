package id.dana.domain.referral.interactor;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.referral.ReferralRepository;
import id.dana.domain.referral.model.ReferralEngagementDialogCache;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/domain/referral/interactor/SaveReferralEngagementDialogCache;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/domain/referral/interactor/SaveReferralEngagementDialogCache$Param;", "param", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/referral/interactor/SaveReferralEngagementDialogCache$Param;)Lio/reactivex/Observable;", "", "Lid/dana/domain/referral/model/ReferralEngagementDialogCache;", "dialogCaches", "", "replaceSameScenarioCache", "(Ljava/util/List;Lid/dana/domain/referral/interactor/SaveReferralEngagementDialogCache$Param;)V", "Lid/dana/domain/referral/ReferralRepository;", "referralRepository", "Lid/dana/domain/referral/ReferralRepository;", "<init>", "(Lid/dana/domain/referral/ReferralRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaveReferralEngagementDialogCache extends BaseUseCase<Boolean, Param> {
    private final ReferralRepository referralRepository;

    @Inject
    public SaveReferralEngagementDialogCache(ReferralRepository referralRepository) {
        Intrinsics.checkNotNullParameter(referralRepository, "");
        this.referralRepository = referralRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<Boolean> buildUseCase(final Param param) {
        Intrinsics.checkNotNullParameter(param, "");
        Observable flatMap = this.referralRepository.getDialogCaches().flatMap(new Function() { // from class: id.dana.domain.referral.interactor.SaveReferralEngagementDialogCache$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2456buildUseCase$lambda0;
                m2456buildUseCase$lambda0 = SaveReferralEngagementDialogCache.m2456buildUseCase$lambda0(SaveReferralEngagementDialogCache.this, param, (List) obj);
                return m2456buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final ObservableSource m2456buildUseCase$lambda0(SaveReferralEngagementDialogCache saveReferralEngagementDialogCache, Param param, List list) {
        Intrinsics.checkNotNullParameter(saveReferralEngagementDialogCache, "");
        Intrinsics.checkNotNullParameter(param, "");
        Intrinsics.checkNotNullParameter(list, "");
        saveReferralEngagementDialogCache.replaceSameScenarioCache(list, param);
        return saveReferralEngagementDialogCache.referralRepository.saveDialogCache(list);
    }

    private final void replaceSameScenarioCache(List<ReferralEngagementDialogCache> dialogCaches, Param param) {
        boolean z = false;
        for (int i = 0; !z && i <= CollectionsKt.getLastIndex(dialogCaches); i++) {
            if (Intrinsics.areEqual(param.getScenario(), dialogCaches.get(i).getScenario())) {
                dialogCaches.remove(i);
                z = true;
            }
        }
        dialogCaches.add(new ReferralEngagementDialogCache(param.getScenario(), param.getShowDialog(), param.getCurrentUnixEpochTime()));
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0017\u0010\r\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0018\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007"}, d2 = {"Lid/dana/domain/referral/interactor/SaveReferralEngagementDialogCache$Param;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "", "component3", "()J", "scenario", "showDialog", "currentUnixEpochTime", "copy", "(Ljava/lang/String;ZJ)Lid/dana/domain/referral/interactor/SaveReferralEngagementDialogCache$Param;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "J", "getCurrentUnixEpochTime", "Ljava/lang/String;", "getScenario", "Z", "getShowDialog", "<init>", "(Ljava/lang/String;ZJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Param {
        private final long currentUnixEpochTime;
        private final String scenario;
        private final boolean showDialog;

        public static /* synthetic */ Param copy$default(Param param, String str, boolean z, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = param.scenario;
            }
            if ((i & 2) != 0) {
                z = param.showDialog;
            }
            if ((i & 4) != 0) {
                j = param.currentUnixEpochTime;
            }
            return param.copy(str, z, j);
        }

        /* renamed from: component1  reason: from getter */
        public final String getScenario() {
            return this.scenario;
        }

        /* renamed from: component2  reason: from getter */
        public final boolean getShowDialog() {
            return this.showDialog;
        }

        /* renamed from: component3  reason: from getter */
        public final long getCurrentUnixEpochTime() {
            return this.currentUnixEpochTime;
        }

        public final Param copy(String scenario, boolean showDialog, long currentUnixEpochTime) {
            Intrinsics.checkNotNullParameter(scenario, "");
            return new Param(scenario, showDialog, currentUnixEpochTime);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Param) {
                Param param = (Param) other;
                return Intrinsics.areEqual(this.scenario, param.scenario) && this.showDialog == param.showDialog && this.currentUnixEpochTime == param.currentUnixEpochTime;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.scenario.hashCode();
            boolean z = this.showDialog;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return (((hashCode * 31) + i) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.currentUnixEpochTime);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(scenario=");
            sb.append(this.scenario);
            sb.append(", showDialog=");
            sb.append(this.showDialog);
            sb.append(", currentUnixEpochTime=");
            sb.append(this.currentUnixEpochTime);
            sb.append(')');
            return sb.toString();
        }

        public Param(String str, boolean z, long j) {
            Intrinsics.checkNotNullParameter(str, "");
            this.scenario = str;
            this.showDialog = z;
            this.currentUnixEpochTime = j;
        }

        @JvmName(name = "getCurrentUnixEpochTime")
        public final long getCurrentUnixEpochTime() {
            return this.currentUnixEpochTime;
        }

        @JvmName(name = "getScenario")
        public final String getScenario() {
            return this.scenario;
        }

        @JvmName(name = "getShowDialog")
        public final boolean getShowDialog() {
            return this.showDialog;
        }
    }
}
