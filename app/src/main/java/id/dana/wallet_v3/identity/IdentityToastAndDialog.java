package id.dana.wallet_v3.identity;

import android.os.Bundle;
import id.dana.base.BaseFragment;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J9\u0010\t\u001a\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\fJ]\u0010\u0015\u001a\u00020\u00072\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rj\u0004\u0018\u0001`\u000f2\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rj\u0004\u0018\u0001`\u00112\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\u0004\u0018\u0001`\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H&¢\u0006\u0004\b\u0017\u0010\fJ\u000f\u0010\u0018\u001a\u00020\u0007H&¢\u0006\u0004\b\u0018\u0010\fJ\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/identity/IdentityToastAndDialog;", "", "", "", "extendInfo", "kycLandingPage", "Lkotlin/Function0;", "", "acceptConsentAction", "checkKYCStatusAndCertType", "(Ljava/util/Map;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "openPinChallenge", "()V", "Lkotlin/Function1;", "Landroid/os/Bundle;", "Lid/dana/riskChallenges/ui/util/strategy/SuccessListener;", "onSuccessListener", "Lid/dana/riskChallenges/ui/util/strategy/ErrorListener;", "onErrorListener", "Lid/dana/riskChallenges/ui/util/strategy/CancelListener;", "onCanceledListener", "setListener", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "showErrorToast", "showErrorVerifyPinPopup", "Lid/dana/base/BaseFragment;", "baseFragment", "showSuccessToast", "(Lid/dana/base/BaseFragment;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface IdentityToastAndDialog {
    void checkKYCStatusAndCertType(Map<String, String> extendInfo, String kycLandingPage, Function0<Unit> acceptConsentAction);

    void openPinChallenge();

    void setListener(Function1<? super Bundle, Unit> onSuccessListener, Function1<? super Bundle, Unit> onErrorListener, Function0<Unit> onCanceledListener);

    void showErrorToast();

    void showErrorVerifyPinPopup();

    void showSuccessToast(BaseFragment baseFragment);
}
