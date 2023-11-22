package id.dana.data.config.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/data/config/model/PopupConfig;", "", "", "homePaymentSettingDialog", "Z", "getHomePaymentSettingDialog", "()Z", "setHomePaymentSettingDialog", "(Z)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PopupConfig {
    public boolean homePaymentSettingDialog;

    public /* synthetic */ PopupConfig() {
    }

    public PopupConfig(boolean z) {
        this.homePaymentSettingDialog = z;
    }

    @JvmName(name = "getHomePaymentSettingDialog")
    public final boolean getHomePaymentSettingDialog() {
        return this.homePaymentSettingDialog;
    }

    @JvmName(name = "setHomePaymentSettingDialog")
    public final void setHomePaymentSettingDialog(boolean z) {
        this.homePaymentSettingDialog = z;
    }
}
