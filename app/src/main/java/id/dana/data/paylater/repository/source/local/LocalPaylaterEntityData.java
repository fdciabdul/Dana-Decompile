package id.dana.data.paylater.repository.source.local;

import id.dana.data.paylater.repository.PaylaterEntityData;
import id.dana.domain.paylater.model.LoanStatusWhitelist;
import id.dana.domain.paylater.model.LoanWhitelist;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0007J#\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0007J\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0007J\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/data/paylater/repository/source/local/LocalPaylaterEntityData;", "Lid/dana/data/paylater/repository/PaylaterEntityData;", "", "phoneNumber", "Lio/reactivex/Observable;", "", "clearCacheLoanWhitelist", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/domain/paylater/model/LoanWhitelist;", "getPayLaterCacheWhitelistValue", "", "Lid/dana/domain/paylater/model/LoanStatusWhitelist;", "getPayLaterLoanStatus", "", "getPaylaterRotationDelayTime", "resetPayLaterCacheLoanWhitelist", "()Lio/reactivex/Observable;", "loanWhitelist", "savePayLaterCacheWhitelistValue", "(Ljava/lang/String;Lid/dana/domain/paylater/model/LoanWhitelist;)Lio/reactivex/Observable;", "loanStatus", "savePayLaterLoanStatus", "(Ljava/util/List;Ljava/lang/String;)Lio/reactivex/Observable;", "rotationDelayTime", "savePaylaterRotationDelayTime", "(Ljava/lang/String;J)Lio/reactivex/Observable;", "Lid/dana/data/paylater/repository/source/local/PaylaterPreference;", "paylaterPreference", "Lid/dana/data/paylater/repository/source/local/PaylaterPreference;", "<init>", "(Lid/dana/data/paylater/repository/source/local/PaylaterPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalPaylaterEntityData implements PaylaterEntityData {
    private final PaylaterPreference paylaterPreference;

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable getLoanConsultWhitelist(String str, boolean z) {
        return PaylaterEntityData.CC.$default$getLoanConsultWhitelist(this, str, z);
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable getLoanRegisterInfo(String str) {
        return PaylaterEntityData.CC.$default$getLoanRegisterInfo(this, str);
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable getPaylaterCicilMethodConfig() {
        return PaylaterEntityData.CC.$default$getPaylaterCicilMethodConfig(this);
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable getPaylaterHomeInfo(boolean z) {
        return PaylaterEntityData.CC.$default$getPaylaterHomeInfo(this, z);
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable setLoanServicesState(String str, String str2) {
        return PaylaterEntityData.CC.$default$setLoanServicesState(this, str, str2);
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable setOffLoanServicesState(LoanWhitelist loanWhitelist) {
        return PaylaterEntityData.CC.$default$setOffLoanServicesState(this, loanWhitelist);
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final /* synthetic */ Observable setPaylaterChannel(String str) {
        return PaylaterEntityData.CC.$default$setPaylaterChannel(this, str);
    }

    @Inject
    public LocalPaylaterEntityData(PaylaterPreference paylaterPreference) {
        Intrinsics.checkNotNullParameter(paylaterPreference, "");
        this.paylaterPreference = paylaterPreference;
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final Observable<Boolean> savePayLaterCacheWhitelistValue(String phoneNumber, LoanWhitelist loanWhitelist) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(loanWhitelist, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.paylaterPreference.savePayLaterCacheWhitelistValue(phoneNumber, loanWhitelist)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final Observable<LoanWhitelist> getPayLaterCacheWhitelistValue(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<LoanWhitelist> just = Observable.just(this.paylaterPreference.getPayLaterCacheWhitelistValue(phoneNumber));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final Observable<Boolean> resetPayLaterCacheLoanWhitelist() {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.paylaterPreference.clearAll()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final Observable<Boolean> clearCacheLoanWhitelist(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.paylaterPreference.resetPayLaterCacheLoanWhitelist(phoneNumber)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final Observable<Boolean> savePayLaterLoanStatus(List<LoanStatusWhitelist> loanStatus, String phoneNumber) {
        Intrinsics.checkNotNullParameter(loanStatus, "");
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.paylaterPreference.savePayLaterLoanStatus(loanStatus, phoneNumber)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final Observable<List<LoanStatusWhitelist>> getPayLaterLoanStatus(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<List<LoanStatusWhitelist>> just = Observable.just(this.paylaterPreference.getPayLaterLoanStatus(phoneNumber));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final Observable<Boolean> savePaylaterRotationDelayTime(String phoneNumber, long rotationDelayTime) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.paylaterPreference.savePaylaterRotationDelayTime(phoneNumber, rotationDelayTime)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.paylater.repository.PaylaterEntityData
    public final Observable<Long> getPaylaterRotationDelayTime(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Observable<Long> just = Observable.just(Long.valueOf(this.paylaterPreference.getPaylaterRotationDelayTime(phoneNumber)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
