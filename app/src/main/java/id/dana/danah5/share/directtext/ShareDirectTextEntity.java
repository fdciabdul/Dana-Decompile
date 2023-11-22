package id.dana.danah5.share.directtext;

import com.alibaba.fastjson.annotation.JSONCreator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B!\b\u0007\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004\"\u0004\b\u0014\u0010\u0015R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\u0004\"\u0004\b\u0017\u0010\u0015"}, d2 = {"Lid/dana/danah5/share/directtext/ShareDirectTextEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "message", "externalApp", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/danah5/share/directtext/ShareDirectTextEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getExternalApp", "setExternalApp", "(Ljava/lang/String;)V", "getMessage", "setMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ShareDirectTextEntity {
    private String externalApp;
    private String message;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @com.alibaba.fastjson.annotation.JSONCreator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ShareDirectTextEntity() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.share.directtext.ShareDirectTextEntity.<init>():void");
    }

    public static /* synthetic */ ShareDirectTextEntity copy$default(ShareDirectTextEntity shareDirectTextEntity, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = shareDirectTextEntity.message;
        }
        if ((i & 2) != 0) {
            str2 = shareDirectTextEntity.externalApp;
        }
        return shareDirectTextEntity.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component2  reason: from getter */
    public final String getExternalApp() {
        return this.externalApp;
    }

    public final ShareDirectTextEntity copy(String message, String externalApp) {
        return new ShareDirectTextEntity(message, externalApp);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ShareDirectTextEntity) {
            ShareDirectTextEntity shareDirectTextEntity = (ShareDirectTextEntity) other;
            return Intrinsics.areEqual(this.message, shareDirectTextEntity.message) && Intrinsics.areEqual(this.externalApp, shareDirectTextEntity.externalApp);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.message;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.externalApp;
        return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ShareDirectTextEntity(message=");
        sb.append(this.message);
        sb.append(", externalApp=");
        sb.append(this.externalApp);
        sb.append(')');
        return sb.toString();
    }

    @JSONCreator
    public ShareDirectTextEntity(String str, String str2) {
        this.message = str;
        this.externalApp = str2;
    }

    public /* synthetic */ ShareDirectTextEntity(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    @JvmName(name = "getMessage")
    public final String getMessage() {
        return this.message;
    }

    @JvmName(name = "setMessage")
    public final void setMessage(String str) {
        this.message = str;
    }

    @JvmName(name = "getExternalApp")
    public final String getExternalApp() {
        return this.externalApp;
    }

    @JvmName(name = "setExternalApp")
    public final void setExternalApp(String str) {
        this.externalApp = str;
    }
}
