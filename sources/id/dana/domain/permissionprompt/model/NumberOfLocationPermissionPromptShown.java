package id.dana.domain.permissionprompt.model;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0003\u0010\b\u001a\u00020\u0007\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/domain/permissionprompt/model/NumberOfLocationPermissionPromptShown;", "", "", "lastReminderUIShowed", "J", "getLastReminderUIShowed", "()J", "", "totalReminderUIShowed", "I", "getTotalReminderUIShowed", "()I", "<init>", "(IJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NumberOfLocationPermissionPromptShown {
    public long lastReminderUIShowed;
    public int totalReminderUIShowed;

    public NumberOfLocationPermissionPromptShown() {
        this(0, 0L, 3, null);
    }

    public NumberOfLocationPermissionPromptShown(@JSONField(name = "totalReminderUIShowed") int i, @JSONField(name = "lastReminderUIShowed") long j) {
        this.totalReminderUIShowed = i;
        this.lastReminderUIShowed = j;
    }

    public /* synthetic */ NumberOfLocationPermissionPromptShown(int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0L : j);
    }

    @JvmName(name = "getTotalReminderUIShowed")
    public final int getTotalReminderUIShowed() {
        return this.totalReminderUIShowed;
    }

    @JvmName(name = "getLastReminderUIShowed")
    public final long getLastReminderUIShowed() {
        return this.lastReminderUIShowed;
    }
}
