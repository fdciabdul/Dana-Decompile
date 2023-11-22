package id.dana.myprofile.mepagerevamp.securitysettings;

import android.os.Bundle;
import id.dana.myprofile.ProfileUserServiceType;
import id.dana.utils.danah5.DanaH5Listener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¸\u0006\b"}, d2 = {"Lid/dana/base/callback/DanaH5CallbackKt$withDanaH5Callback$1;", "Lid/dana/utils/danah5/DanaH5Listener;", "Landroid/os/Bundle;", "p0", "", "onContainerCreated", "(Landroid/os/Bundle;)V", "onContainerDestroyed", "id/dana/base/callback/DanaH5CallbackKt$withDanaH5Callback$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SecuritySettingsActivity$openH5Container$$inlined$withDanaH5Callback$1 implements DanaH5Listener {
    final /* synthetic */ SecuritySettingsActivity MyBillsEntityDataFactory;

    @Override // id.dana.utils.danah5.DanaH5Listener
    public final void onContainerCreated(Bundle p0) {
    }

    public SecuritySettingsActivity$openH5Container$$inlined$withDanaH5Callback$1(SecuritySettingsActivity securitySettingsActivity) {
        this.MyBillsEntityDataFactory = securitySettingsActivity;
    }

    @Override // id.dana.utils.danah5.DanaH5Listener
    public final void onContainerDestroyed(Bundle p0) {
        String str;
        this.MyBillsEntityDataFactory.getSecuritySettingsPresenter().PlaceComponentResult();
        str = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        if (Intrinsics.areEqual(str, ProfileUserServiceType.CHANGE_PIN)) {
            this.MyBillsEntityDataFactory.getSecuritySettingsPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }
}
