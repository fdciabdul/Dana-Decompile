package id.dana.explore.domain.userpersonalization.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0006"}, d2 = {"Lid/dana/explore/domain/userpersonalization/model/ShouldOpenUserPersonalizationModelWrapper;", "", "", "hasFillForm", "Z", "getHasFillForm", "()Z", "isFirstTime", "<init>", "(ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShouldOpenUserPersonalizationModelWrapper {
    private final boolean hasFillForm;
    private final boolean isFirstTime;

    public ShouldOpenUserPersonalizationModelWrapper(boolean z, boolean z2) {
        this.isFirstTime = z;
        this.hasFillForm = z2;
    }

    @JvmName(name = "isFirstTime")
    /* renamed from: isFirstTime  reason: from getter */
    public final boolean getIsFirstTime() {
        return this.isFirstTime;
    }

    @JvmName(name = "getHasFillForm")
    public final boolean getHasFillForm() {
        return this.hasFillForm;
    }
}
