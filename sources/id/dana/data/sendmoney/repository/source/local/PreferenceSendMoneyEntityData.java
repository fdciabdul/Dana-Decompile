package id.dana.data.sendmoney.repository.source.local;

import id.dana.data.sendmoney.repository.SendMoneyPreferenceEntityData;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0005J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0005J\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/data/sendmoney/repository/source/local/PreferenceSendMoneyEntityData;", "Lid/dana/data/sendmoney/repository/SendMoneyPreferenceEntityData;", "Lio/reactivex/Observable;", "", "getIsNeedToShowSuspiciousAccountSmartFriction", "()Lio/reactivex/Observable;", "getIsUserCertifiedGlobalSend", "", "getStateSendMoneyShareFeed", "isNeedToShowExternalOnboardingDialog", "isShow", "saveIsNeedToShowExternalOnboardingDialog", "(Z)Lio/reactivex/Observable;", "saveIsNeedToShowSuspiciousAccountSmartFriction", "saveIsUserCertifiedGlobalSend", "state", "saveStateSendMoneyShareFeed", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/sendmoney/repository/source/local/SendMoneyPreference;", "sendMoneyPreference", "Lid/dana/data/sendmoney/repository/source/local/SendMoneyPreference;", "<init>", "(Lid/dana/data/sendmoney/repository/source/local/SendMoneyPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PreferenceSendMoneyEntityData implements SendMoneyPreferenceEntityData {
    private final SendMoneyPreference sendMoneyPreference;

    @Inject
    public PreferenceSendMoneyEntityData(SendMoneyPreference sendMoneyPreference) {
        Intrinsics.checkNotNullParameter(sendMoneyPreference, "");
        this.sendMoneyPreference = sendMoneyPreference;
    }

    @Override // id.dana.data.sendmoney.repository.SendMoneyPreferenceEntityData
    public final Observable<Boolean> saveIsNeedToShowExternalOnboardingDialog(boolean isShow) {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.sendMoneyPreference.saveIsNeedToShowExternalOnboardingDialog(isShow)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.sendmoney.repository.SendMoneyPreferenceEntityData
    public final Observable<Boolean> isNeedToShowExternalOnboardingDialog() {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.sendMoneyPreference.isNeedToShowExternalOnboardingDialog()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.sendmoney.repository.SendMoneyPreferenceEntityData
    public final Observable<Boolean> saveStateSendMoneyShareFeed(String state) {
        Intrinsics.checkNotNullParameter(state, "");
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.sendMoneyPreference.saveStateSendMoneyShareFeed(state)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.sendmoney.repository.SendMoneyPreferenceEntityData
    public final Observable<String> getStateSendMoneyShareFeed() {
        Observable<String> just = Observable.just(this.sendMoneyPreference.getStateSendMoneyShareFeed());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.sendmoney.repository.SendMoneyPreferenceEntityData
    public final Observable<Boolean> saveIsNeedToShowSuspiciousAccountSmartFriction(boolean isShow) {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.sendMoneyPreference.saveIsNeedToShowSmartFrictionSuspiciousAccount(isShow)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.sendmoney.repository.SendMoneyPreferenceEntityData
    public final Observable<Boolean> getIsNeedToShowSuspiciousAccountSmartFriction() {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.sendMoneyPreference.getIsNeedToShowSmartFrictionSuspiciousAccount()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.sendmoney.repository.SendMoneyPreferenceEntityData
    public final Observable<Boolean> saveIsUserCertifiedGlobalSend() {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.sendMoneyPreference.saveIsUserCertifiedGlobalSend()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.sendmoney.repository.SendMoneyPreferenceEntityData
    public final Observable<Boolean> getIsUserCertifiedGlobalSend() {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.sendMoneyPreference.getIsUserCertifiedGlobalSend()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
