package id.dana.data.login.source.network.result;

import com.alibaba.fastjson.annotation.JSONField;
import id.dana.domain.login.model.LoginRegisterConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB)\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ2\u0010\f\u001a\u00020\u00002\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\n\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\b"}, d2 = {"Lid/dana/data/login/source/network/result/LoginRegisterConfigResult;", "", "", "component1", "()Ljava/lang/Boolean;", "component2", "Lid/dana/data/login/source/network/result/RetryConfig;", "component3", "()Lid/dana/data/login/source/network/result/RetryConfig;", "ipificationCheckCoverage", "isFeatureChatbotNonLoginEnabled", "retryConfig", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Lid/dana/data/login/source/network/result/RetryConfig;)Lid/dana/data/login/source/network/result/LoginRegisterConfigResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Boolean;", "getIpificationCheckCoverage", "Lid/dana/data/login/source/network/result/RetryConfig;", "getRetryConfig", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Lid/dana/data/login/source/network/result/RetryConfig;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class LoginRegisterConfigResult {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Boolean ipificationCheckCoverage;
    public Boolean isFeatureChatbotNonLoginEnabled;
    public RetryConfig retryConfig;

    public LoginRegisterConfigResult() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ LoginRegisterConfigResult copy$default(LoginRegisterConfigResult loginRegisterConfigResult, Boolean bool, Boolean bool2, RetryConfig retryConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = loginRegisterConfigResult.ipificationCheckCoverage;
        }
        if ((i & 2) != 0) {
            bool2 = loginRegisterConfigResult.isFeatureChatbotNonLoginEnabled;
        }
        if ((i & 4) != 0) {
            retryConfig = loginRegisterConfigResult.retryConfig;
        }
        return loginRegisterConfigResult.copy(bool, bool2, retryConfig);
    }

    /* renamed from: component1  reason: from getter */
    public final Boolean getIpificationCheckCoverage() {
        return this.ipificationCheckCoverage;
    }

    /* renamed from: component2  reason: from getter */
    public final Boolean getIsFeatureChatbotNonLoginEnabled() {
        return this.isFeatureChatbotNonLoginEnabled;
    }

    /* renamed from: component3  reason: from getter */
    public final RetryConfig getRetryConfig() {
        return this.retryConfig;
    }

    public final LoginRegisterConfigResult copy(@JSONField(name = "ipificationCheckCoverage") Boolean ipificationCheckCoverage, @JSONField(name = "isFeatureChatbotNonLoginEnabled") Boolean isFeatureChatbotNonLoginEnabled, @JSONField(name = "retryConfig") RetryConfig retryConfig) {
        Intrinsics.checkNotNullParameter(retryConfig, "");
        return new LoginRegisterConfigResult(ipificationCheckCoverage, isFeatureChatbotNonLoginEnabled, retryConfig);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof LoginRegisterConfigResult) {
            LoginRegisterConfigResult loginRegisterConfigResult = (LoginRegisterConfigResult) other;
            return Intrinsics.areEqual(this.ipificationCheckCoverage, loginRegisterConfigResult.ipificationCheckCoverage) && Intrinsics.areEqual(this.isFeatureChatbotNonLoginEnabled, loginRegisterConfigResult.isFeatureChatbotNonLoginEnabled) && Intrinsics.areEqual(this.retryConfig, loginRegisterConfigResult.retryConfig);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.ipificationCheckCoverage;
        int hashCode = bool == null ? 0 : bool.hashCode();
        Boolean bool2 = this.isFeatureChatbotNonLoginEnabled;
        return (((hashCode * 31) + (bool2 != null ? bool2.hashCode() : 0)) * 31) + this.retryConfig.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LoginRegisterConfigResult(ipificationCheckCoverage=");
        sb.append(this.ipificationCheckCoverage);
        sb.append(", isFeatureChatbotNonLoginEnabled=");
        sb.append(this.isFeatureChatbotNonLoginEnabled);
        sb.append(", retryConfig=");
        sb.append(this.retryConfig);
        sb.append(')');
        return sb.toString();
    }

    public LoginRegisterConfigResult(@JSONField(name = "ipificationCheckCoverage") Boolean bool, @JSONField(name = "isFeatureChatbotNonLoginEnabled") Boolean bool2, @JSONField(name = "retryConfig") RetryConfig retryConfig) {
        Intrinsics.checkNotNullParameter(retryConfig, "");
        this.ipificationCheckCoverage = bool;
        this.isFeatureChatbotNonLoginEnabled = bool2;
        this.retryConfig = retryConfig;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ LoginRegisterConfigResult(java.lang.Boolean r7, java.lang.Boolean r8, id.dana.data.login.source.network.result.RetryConfig r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r6 = this;
            java.lang.Boolean r11 = java.lang.Boolean.FALSE
            r0 = r10 & 1
            if (r0 == 0) goto L7
            r7 = r11
        L7:
            r0 = r10 & 2
            if (r0 == 0) goto Lc
            r8 = r11
        Lc:
            r10 = r10 & 4
            if (r10 == 0) goto L1b
            id.dana.data.login.source.network.result.RetryConfig r9 = new id.dana.data.login.source.network.result.RetryConfig
            r1 = 0
            r2 = 0
            r4 = 3
            r5 = 0
            r0 = r9
            r0.<init>(r1, r2, r4, r5)
        L1b:
            r6.<init>(r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.login.source.network.result.LoginRegisterConfigResult.<init>(java.lang.Boolean, java.lang.Boolean, id.dana.data.login.source.network.result.RetryConfig, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @JvmName(name = "getIpificationCheckCoverage")
    public final Boolean getIpificationCheckCoverage() {
        return this.ipificationCheckCoverage;
    }

    @JvmName(name = "isFeatureChatbotNonLoginEnabled")
    public final Boolean isFeatureChatbotNonLoginEnabled() {
        return this.isFeatureChatbotNonLoginEnabled;
    }

    @JvmName(name = "getRetryConfig")
    public final RetryConfig getRetryConfig() {
        return this.retryConfig;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\u0004\u001a\u00020\u0003*\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/login/source/network/result/LoginRegisterConfigResult$Companion;", "", "Lid/dana/data/login/source/network/result/LoginRegisterConfigResult;", "Lid/dana/domain/login/model/LoginRegisterConfig;", "toLoginRegisterConfig", "(Lid/dana/data/login/source/network/result/LoginRegisterConfigResult;)Lid/dana/domain/login/model/LoginRegisterConfig;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LoginRegisterConfig toLoginRegisterConfig(LoginRegisterConfigResult loginRegisterConfigResult) {
            Intrinsics.checkNotNullParameter(loginRegisterConfigResult, "");
            return new LoginRegisterConfig(loginRegisterConfigResult.getIpificationCheckCoverage(), loginRegisterConfigResult.isFeatureChatbotNonLoginEnabled());
        }
    }
}
