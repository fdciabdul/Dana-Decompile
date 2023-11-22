package id.dana.domain.permissionprompt.model;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0003\u0010\f\u001a\u00020\u0007\u0012\b\b\u0003\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b"}, d2 = {"Lid/dana/domain/permissionprompt/model/UserLocationPermissionPromptConfig;", "", "", "enable", "Z", "getEnable", "()Z", "", "maxRepeatedInAMonth", "I", "getMaxRepeatedInAMonth", "()I", "repeatedInDays", "getRepeatedInDays", "<init>", "(ZII)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UserLocationPermissionPromptConfig {
    public boolean enable;
    public int maxRepeatedInAMonth;
    public int repeatedInDays;

    public UserLocationPermissionPromptConfig() {
        this(false, 0, 0, 7, null);
    }

    public UserLocationPermissionPromptConfig(@JSONField(name = "enable") boolean z, @JSONField(name = "repeated_in_days") int i, @JSONField(name = "max_repeated_a_month") int i2) {
        this.enable = z;
        this.repeatedInDays = i;
        this.maxRepeatedInAMonth = i2;
    }

    public /* synthetic */ UserLocationPermissionPromptConfig(boolean z, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2);
    }

    @JvmName(name = "getEnable")
    public final boolean getEnable() {
        return this.enable;
    }

    @JvmName(name = "getRepeatedInDays")
    public final int getRepeatedInDays() {
        return this.repeatedInDays;
    }

    @JvmName(name = "getMaxRepeatedInAMonth")
    public final int getMaxRepeatedInAMonth() {
        return this.maxRepeatedInAMonth;
    }
}
