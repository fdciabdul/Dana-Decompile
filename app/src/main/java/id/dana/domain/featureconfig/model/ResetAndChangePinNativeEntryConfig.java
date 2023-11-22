package id.dana.domain.featureconfig.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0002\u0012\b\b\u0003\u0010\f\u001a\u00020\u0002\u0012\b\b\u0003\u0010\r\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJB\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u000b\u001a\u00020\u00022\b\b\u0003\u0010\f\u001a\u00020\u00022\b\b\u0003\u0010\r\u001a\u00020\u00022\b\b\u0003\u0010\u000e\u001a\u00020\u00022\b\b\u0003\u0010\u000f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0018\u0010\nR\u001a\u0010\u000f\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001a\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001d\u0010\u0004R\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001f\u0010\u0004"}, d2 = {"Lid/dana/domain/featureconfig/model/ResetAndChangePinNativeEntryConfig;", "", "", "component1", "()Z", "component2", "component3", "component4", "", "component5", "()Ljava/lang/String;", "featureChangePin", "featurePinRegularChanges", "featureResetPinPostLogin", "featureResetPinPreLogin", "deeplinkSelfUnfreeze", "copy", "(ZZZZLjava/lang/String;)Lid/dana/domain/featureconfig/model/ResetAndChangePinNativeEntryConfig;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getDeeplinkSelfUnfreeze", "Z", "getFeatureChangePin", "getFeaturePinRegularChanges", "getFeatureResetPinPostLogin", "getFeatureResetPinPreLogin", "<init>", "(ZZZZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ResetAndChangePinNativeEntryConfig {
    @SerializedName("deeplink_self_unfreeze")
    private final String deeplinkSelfUnfreeze;
    @SerializedName("feature_change_pin")
    private final boolean featureChangePin;
    @SerializedName("feature_pin_regular_changes")
    private final boolean featurePinRegularChanges;
    @SerializedName("feature_reset_pin_post_login")
    private final boolean featureResetPinPostLogin;
    @SerializedName("feature_reset_pin_pre_login")
    private final boolean featureResetPinPreLogin;

    public ResetAndChangePinNativeEntryConfig() {
        this(false, false, false, false, null, 31, null);
    }

    public static /* synthetic */ ResetAndChangePinNativeEntryConfig copy$default(ResetAndChangePinNativeEntryConfig resetAndChangePinNativeEntryConfig, boolean z, boolean z2, boolean z3, boolean z4, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = resetAndChangePinNativeEntryConfig.featureChangePin;
        }
        if ((i & 2) != 0) {
            z2 = resetAndChangePinNativeEntryConfig.featurePinRegularChanges;
        }
        boolean z5 = z2;
        if ((i & 4) != 0) {
            z3 = resetAndChangePinNativeEntryConfig.featureResetPinPostLogin;
        }
        boolean z6 = z3;
        if ((i & 8) != 0) {
            z4 = resetAndChangePinNativeEntryConfig.featureResetPinPreLogin;
        }
        boolean z7 = z4;
        if ((i & 16) != 0) {
            str = resetAndChangePinNativeEntryConfig.deeplinkSelfUnfreeze;
        }
        return resetAndChangePinNativeEntryConfig.copy(z, z5, z6, z7, str);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getFeatureChangePin() {
        return this.featureChangePin;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getFeaturePinRegularChanges() {
        return this.featurePinRegularChanges;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getFeatureResetPinPostLogin() {
        return this.featureResetPinPostLogin;
    }

    /* renamed from: component4  reason: from getter */
    public final boolean getFeatureResetPinPreLogin() {
        return this.featureResetPinPreLogin;
    }

    /* renamed from: component5  reason: from getter */
    public final String getDeeplinkSelfUnfreeze() {
        return this.deeplinkSelfUnfreeze;
    }

    public final ResetAndChangePinNativeEntryConfig copy(@JSONField(name = "feature_change_pin") boolean featureChangePin, @JSONField(name = "feature_pin_regular_changes") boolean featurePinRegularChanges, @JSONField(name = "feature_reset_pin_post_login") boolean featureResetPinPostLogin, @JSONField(name = "feature_reset_pin_pre_login") boolean featureResetPinPreLogin, @JSONField(name = "deeplink_self_unfreeze") String deeplinkSelfUnfreeze) {
        Intrinsics.checkNotNullParameter(deeplinkSelfUnfreeze, "");
        return new ResetAndChangePinNativeEntryConfig(featureChangePin, featurePinRegularChanges, featureResetPinPostLogin, featureResetPinPreLogin, deeplinkSelfUnfreeze);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ResetAndChangePinNativeEntryConfig) {
            ResetAndChangePinNativeEntryConfig resetAndChangePinNativeEntryConfig = (ResetAndChangePinNativeEntryConfig) other;
            return this.featureChangePin == resetAndChangePinNativeEntryConfig.featureChangePin && this.featurePinRegularChanges == resetAndChangePinNativeEntryConfig.featurePinRegularChanges && this.featureResetPinPostLogin == resetAndChangePinNativeEntryConfig.featureResetPinPostLogin && this.featureResetPinPreLogin == resetAndChangePinNativeEntryConfig.featureResetPinPreLogin && Intrinsics.areEqual(this.deeplinkSelfUnfreeze, resetAndChangePinNativeEntryConfig.deeplinkSelfUnfreeze);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    public final int hashCode() {
        boolean z = this.featureChangePin;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        ?? r2 = this.featurePinRegularChanges;
        int i = r2;
        if (r2 != 0) {
            i = 1;
        }
        ?? r3 = this.featureResetPinPostLogin;
        int i2 = r3;
        if (r3 != 0) {
            i2 = 1;
        }
        boolean z2 = this.featureResetPinPreLogin;
        return (((((((r0 * 31) + i) * 31) + i2) * 31) + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.deeplinkSelfUnfreeze.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ResetAndChangePinNativeEntryConfig(featureChangePin=");
        sb.append(this.featureChangePin);
        sb.append(", featurePinRegularChanges=");
        sb.append(this.featurePinRegularChanges);
        sb.append(", featureResetPinPostLogin=");
        sb.append(this.featureResetPinPostLogin);
        sb.append(", featureResetPinPreLogin=");
        sb.append(this.featureResetPinPreLogin);
        sb.append(", deeplinkSelfUnfreeze=");
        sb.append(this.deeplinkSelfUnfreeze);
        sb.append(')');
        return sb.toString();
    }

    public ResetAndChangePinNativeEntryConfig(@JSONField(name = "feature_change_pin") boolean z, @JSONField(name = "feature_pin_regular_changes") boolean z2, @JSONField(name = "feature_reset_pin_post_login") boolean z3, @JSONField(name = "feature_reset_pin_pre_login") boolean z4, @JSONField(name = "deeplink_self_unfreeze") String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.featureChangePin = z;
        this.featurePinRegularChanges = z2;
        this.featureResetPinPostLogin = z3;
        this.featureResetPinPreLogin = z4;
        this.deeplinkSelfUnfreeze = str;
    }

    public /* synthetic */ ResetAndChangePinNativeEntryConfig(boolean z, boolean z2, boolean z3, boolean z4, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) == 0 ? z4 : false, (i & 16) != 0 ? "self-unfreeze" : str);
    }

    @JvmName(name = "getFeatureChangePin")
    public final boolean getFeatureChangePin() {
        return this.featureChangePin;
    }

    @JvmName(name = "getFeaturePinRegularChanges")
    public final boolean getFeaturePinRegularChanges() {
        return this.featurePinRegularChanges;
    }

    @JvmName(name = "getFeatureResetPinPostLogin")
    public final boolean getFeatureResetPinPostLogin() {
        return this.featureResetPinPostLogin;
    }

    @JvmName(name = "getFeatureResetPinPreLogin")
    public final boolean getFeatureResetPinPreLogin() {
        return this.featureResetPinPreLogin;
    }

    @JvmName(name = "getDeeplinkSelfUnfreeze")
    public final String getDeeplinkSelfUnfreeze() {
        return this.deeplinkSelfUnfreeze;
    }
}
