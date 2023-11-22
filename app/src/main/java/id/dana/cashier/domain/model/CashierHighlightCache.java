package id.dana.cashier.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\t\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/cashier/domain/model/CashierHighlightCache;", "", "", "isVersionUpdated", "Z", "()Z", "needToShowHighlight", "getNeedToShowHighlight", "", "version", "I", "getVersion", "()I", "<init>", "(IZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierHighlightCache {
    private final boolean isVersionUpdated;
    private final boolean needToShowHighlight;
    private final int version;

    public CashierHighlightCache(int i, boolean z, boolean z2) {
        this.version = i;
        this.needToShowHighlight = z;
        this.isVersionUpdated = z2;
    }

    @JvmName(name = "getVersion")
    public final int getVersion() {
        return this.version;
    }

    @JvmName(name = "getNeedToShowHighlight")
    public final boolean getNeedToShowHighlight() {
        return this.needToShowHighlight;
    }

    @JvmName(name = "isVersionUpdated")
    /* renamed from: isVersionUpdated  reason: from getter */
    public final boolean getIsVersionUpdated() {
        return this.isVersionUpdated;
    }
}
