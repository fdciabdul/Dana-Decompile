package id.dana.domain.expresspurchase.interaction.model;

import id.dana.domain.expresspurchase.interaction.SaveLastActionToPreference;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/ExpressPurchasePaylaterConfig;", "", "", "cdpSpaceCode", "Ljava/lang/String;", "getCdpSpaceCode", "()Ljava/lang/String;", "", SaveLastActionToPreference.DISMISS_EP, "I", "getDismiss", "()I", "redirectedUrl", "getRedirectedUrl", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ExpressPurchasePaylaterConfig {
    private final String cdpSpaceCode;
    private final int dismiss;
    private final String redirectedUrl;

    public ExpressPurchasePaylaterConfig(int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.dismiss = i;
        this.redirectedUrl = str;
        this.cdpSpaceCode = str2;
    }

    @JvmName(name = "getDismiss")
    public final int getDismiss() {
        return this.dismiss;
    }

    @JvmName(name = "getRedirectedUrl")
    public final String getRedirectedUrl() {
        return this.redirectedUrl;
    }

    @JvmName(name = "getCdpSpaceCode")
    public final String getCdpSpaceCode() {
        return this.cdpSpaceCode;
    }
}
