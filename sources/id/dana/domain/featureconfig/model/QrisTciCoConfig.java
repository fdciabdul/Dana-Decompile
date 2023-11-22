package id.dana.domain.featureconfig.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0004\u001a\u0004\b\u0006\u0010\u0005"}, d2 = {"Lid/dana/domain/featureconfig/model/QrisTciCoConfig;", "", "", "isProfileEnabled", "Z", "()Z", "isRequestMoneyEnabled", "<init>", "(ZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QrisTciCoConfig {
    private final boolean isProfileEnabled;
    private final boolean isRequestMoneyEnabled;

    public QrisTciCoConfig(boolean z, boolean z2) {
        this.isRequestMoneyEnabled = z;
        this.isProfileEnabled = z2;
    }

    @JvmName(name = "isRequestMoneyEnabled")
    /* renamed from: isRequestMoneyEnabled  reason: from getter */
    public final boolean getIsRequestMoneyEnabled() {
        return this.isRequestMoneyEnabled;
    }

    @JvmName(name = "isProfileEnabled")
    /* renamed from: isProfileEnabled  reason: from getter */
    public final boolean getIsProfileEnabled() {
        return this.isProfileEnabled;
    }
}
