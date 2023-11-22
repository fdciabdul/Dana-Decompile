package id.dana.domain.promodiscovery.model;

import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/domain/promodiscovery/model/DiscoverySectionConfig;", "", "", "itemCount", "I", "getItemCount", "()I", "setItemCount", "(I)V", "", "sortBy", "Ljava/lang/String;", "getSortBy", "()Ljava/lang/String;", "setSortBy", "(Ljava/lang/String;)V", "", MaintenanceBroadcastResult.KEY_VISIBLE, "Z", "getVisible", "()Z", "setVisible", "(Z)V", "<init>", "(IZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DiscoverySectionConfig {
    private int itemCount;
    private String sortBy;
    private boolean visible;

    public DiscoverySectionConfig(int i, boolean z, String str) {
        this.itemCount = i;
        this.visible = z;
        this.sortBy = str;
    }

    @JvmName(name = "getItemCount")
    public final int getItemCount() {
        return this.itemCount;
    }

    @JvmName(name = "setItemCount")
    public final void setItemCount(int i) {
        this.itemCount = i;
    }

    @JvmName(name = "getVisible")
    public final boolean getVisible() {
        return this.visible;
    }

    @JvmName(name = "setVisible")
    public final void setVisible(boolean z) {
        this.visible = z;
    }

    @JvmName(name = "getSortBy")
    public final String getSortBy() {
        return this.sortBy;
    }

    @JvmName(name = "setSortBy")
    public final void setSortBy(String str) {
        this.sortBy = str;
    }
}
