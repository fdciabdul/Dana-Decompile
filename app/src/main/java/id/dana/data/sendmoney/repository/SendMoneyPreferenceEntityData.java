package id.dana.data.sendmoney.repository;

import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H&¢\u0006\u0004\b\b\u0010\u0005J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\t\u0010\u0005J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\u0003H&¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\u0003H&¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u000e\u0010\u0005J\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/sendmoney/repository/SendMoneyPreferenceEntityData;", "", "Lio/reactivex/Observable;", "", "getIsNeedToShowSuspiciousAccountSmartFriction", "()Lio/reactivex/Observable;", "getIsUserCertifiedGlobalSend", "", "getStateSendMoneyShareFeed", "isNeedToShowExternalOnboardingDialog", "isShow", "saveIsNeedToShowExternalOnboardingDialog", "(Z)Lio/reactivex/Observable;", "saveIsNeedToShowSuspiciousAccountSmartFriction", "saveIsUserCertifiedGlobalSend", "state", "saveStateSendMoneyShareFeed", "(Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface SendMoneyPreferenceEntityData {
    Observable<Boolean> getIsNeedToShowSuspiciousAccountSmartFriction();

    Observable<Boolean> getIsUserCertifiedGlobalSend();

    Observable<String> getStateSendMoneyShareFeed();

    Observable<Boolean> isNeedToShowExternalOnboardingDialog();

    Observable<Boolean> saveIsNeedToShowExternalOnboardingDialog(boolean isShow);

    Observable<Boolean> saveIsNeedToShowSuspiciousAccountSmartFriction(boolean isShow);

    Observable<Boolean> saveIsUserCertifiedGlobalSend();

    Observable<Boolean> saveStateSendMoneyShareFeed(String state);
}
