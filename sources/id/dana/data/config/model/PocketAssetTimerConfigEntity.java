package id.dana.data.config.model;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0003\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005"}, d2 = {"Lid/dana/data/config/model/PocketAssetTimerConfigEntity;", "", "", "isOn", "Z", "()Z", "<init>", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PocketAssetTimerConfigEntity {
    private final boolean isOn;

    public PocketAssetTimerConfigEntity() {
        this(false, 1, null);
    }

    public PocketAssetTimerConfigEntity(@JSONField(name = "is_on") boolean z) {
        this.isOn = z;
    }

    public /* synthetic */ PocketAssetTimerConfigEntity(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }

    @JvmName(name = "isOn")
    /* renamed from: isOn  reason: from getter */
    public final boolean getIsOn() {
        return this.isOn;
    }
}
