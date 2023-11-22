package id.dana.domain.login.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0006"}, d2 = {"Lid/dana/domain/login/model/LoginRegisterConfig;", "", "", "ipificationCheckCoverage", "Ljava/lang/Boolean;", "getIpificationCheckCoverage", "()Ljava/lang/Boolean;", "isFeatureChatbotNonLoginEnabled", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LoginRegisterConfig {
    @SerializedName("ipificationCheckCoverage")
    private final Boolean ipificationCheckCoverage;
    @SerializedName("isFeatureChatbotNonLoginEnabled")
    private final Boolean isFeatureChatbotNonLoginEnabled;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LoginRegisterConfig() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.login.model.LoginRegisterConfig.<init>():void");
    }

    public LoginRegisterConfig(Boolean bool, Boolean bool2) {
        this.ipificationCheckCoverage = bool;
        this.isFeatureChatbotNonLoginEnabled = bool2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ LoginRegisterConfig(java.lang.Boolean r2, java.lang.Boolean r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r1 = this;
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r0 = r4 & 1
            if (r0 == 0) goto L7
            r2 = r5
        L7:
            r4 = r4 & 2
            if (r4 == 0) goto Lc
            r3 = r5
        Lc:
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.login.model.LoginRegisterConfig.<init>(java.lang.Boolean, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getIpificationCheckCoverage")
    public final Boolean getIpificationCheckCoverage() {
        return this.ipificationCheckCoverage;
    }

    @JvmName(name = "isFeatureChatbotNonLoginEnabled")
    /* renamed from: isFeatureChatbotNonLoginEnabled  reason: from getter */
    public final Boolean getIsFeatureChatbotNonLoginEnabled() {
        return this.isFeatureChatbotNonLoginEnabled;
    }
}