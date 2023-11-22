package id.dana.data.userconfig.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/data/userconfig/model/KtpPopUpUserConfig;", "Ljava/io/Serializable;", "", "ktpIsSaved", "Z", "getKtpIsSaved", "()Z", "setKtpIsSaved", "(Z)V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KtpPopUpUserConfig implements Serializable {
    private boolean ktpIsSaved;

    public KtpPopUpUserConfig() {
        this(false, 1, null);
    }

    public KtpPopUpUserConfig(boolean z) {
        this.ktpIsSaved = z;
    }

    public /* synthetic */ KtpPopUpUserConfig(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    @JvmName(name = "getKtpIsSaved")
    public final boolean getKtpIsSaved() {
        return this.ktpIsSaved;
    }

    @JvmName(name = "setKtpIsSaved")
    public final void setKtpIsSaved(boolean z) {
        this.ktpIsSaved = z;
    }
}
