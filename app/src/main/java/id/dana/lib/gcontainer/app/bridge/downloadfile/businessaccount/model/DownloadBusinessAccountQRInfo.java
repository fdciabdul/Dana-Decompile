package id.dana.lib.gcontainer.app.bridge.downloadfile.businessaccount.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/downloadfile/businessaccount/model/DownloadBusinessAccountQRInfo;", "", "", "businessName", "Ljava/lang/String;", "getBusinessName", "()Ljava/lang/String;", "setBusinessName", "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class DownloadBusinessAccountQRInfo {
    private String businessName;
    private String url;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DownloadBusinessAccountQRInfo() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.lib.gcontainer.app.bridge.downloadfile.businessaccount.model.DownloadBusinessAccountQRInfo.<init>():void");
    }

    public DownloadBusinessAccountQRInfo(String str, String str2) {
        this.url = str;
        this.businessName = str2;
    }

    public /* synthetic */ DownloadBusinessAccountQRInfo(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    @JvmName(name = "getUrl")
    public final String getUrl() {
        return this.url;
    }

    @JvmName(name = "setUrl")
    public final void setUrl(String str) {
        this.url = str;
    }

    @JvmName(name = "getBusinessName")
    public final String getBusinessName() {
        return this.businessName;
    }

    @JvmName(name = "setBusinessName")
    public final void setBusinessName(String str) {
        this.businessName = str;
    }
}
