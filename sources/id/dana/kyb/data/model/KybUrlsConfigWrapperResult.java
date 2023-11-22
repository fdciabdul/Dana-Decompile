package id.dana.kyb.data.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004"}, d2 = {"Lid/dana/kyb/data/model/KybUrlsConfigWrapperResult;", "", "Lid/dana/kyb/data/model/KybUrlsConfigResult;", "component1", "()Lid/dana/kyb/data/model/KybUrlsConfigResult;", "kybUrls", "copy", "(Lid/dana/kyb/data/model/KybUrlsConfigResult;)Lid/dana/kyb/data/model/KybUrlsConfigWrapperResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/kyb/data/model/KybUrlsConfigResult;", "getKybUrls", "<init>", "(Lid/dana/kyb/data/model/KybUrlsConfigResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybUrlsConfigWrapperResult {
    @SerializedName("kyb_urls")
    private final KybUrlsConfigResult kybUrls;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.kyb.data.model.KybUrlsConfigResult, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public KybUrlsConfigWrapperResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.data.model.KybUrlsConfigWrapperResult.<init>():void");
    }

    public static /* synthetic */ KybUrlsConfigWrapperResult copy$default(KybUrlsConfigWrapperResult kybUrlsConfigWrapperResult, KybUrlsConfigResult kybUrlsConfigResult, int i, Object obj) {
        if ((i & 1) != 0) {
            kybUrlsConfigResult = kybUrlsConfigWrapperResult.kybUrls;
        }
        return kybUrlsConfigWrapperResult.copy(kybUrlsConfigResult);
    }

    /* renamed from: component1  reason: from getter */
    public final KybUrlsConfigResult getKybUrls() {
        return this.kybUrls;
    }

    public final KybUrlsConfigWrapperResult copy(KybUrlsConfigResult kybUrls) {
        return new KybUrlsConfigWrapperResult(kybUrls);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof KybUrlsConfigWrapperResult) && Intrinsics.areEqual(this.kybUrls, ((KybUrlsConfigWrapperResult) other).kybUrls);
    }

    public final int hashCode() {
        KybUrlsConfigResult kybUrlsConfigResult = this.kybUrls;
        if (kybUrlsConfigResult == null) {
            return 0;
        }
        return kybUrlsConfigResult.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybUrlsConfigWrapperResult(kybUrls=");
        sb.append(this.kybUrls);
        sb.append(')');
        return sb.toString();
    }

    public KybUrlsConfigWrapperResult(KybUrlsConfigResult kybUrlsConfigResult) {
        this.kybUrls = kybUrlsConfigResult;
    }

    public /* synthetic */ KybUrlsConfigWrapperResult(KybUrlsConfigResult kybUrlsConfigResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new KybUrlsConfigResult(null, null, null, null, null, null, null, null, null, null, 1023, null) : kybUrlsConfigResult);
    }

    @JvmName(name = "getKybUrls")
    public final KybUrlsConfigResult getKybUrls() {
        return this.kybUrls;
    }
}
