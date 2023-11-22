package id.dana.data.homeinfo.repository.source.network.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004"}, d2 = {"Lid/dana/data/homeinfo/repository/source/network/result/PaylaterChannelResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "paylaterChannel", "copy", "(Ljava/lang/String;)Lid/dana/data/homeinfo/repository/source/network/result/PaylaterChannelResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getPaylaterChannel", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PaylaterChannelResult extends BaseRpcResult {
    @SerializedName("paylaterChannel")
    private final String paylaterChannel;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PaylaterChannelResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.homeinfo.repository.source.network.result.PaylaterChannelResult.<init>():void");
    }

    public static /* synthetic */ PaylaterChannelResult copy$default(PaylaterChannelResult paylaterChannelResult, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paylaterChannelResult.paylaterChannel;
        }
        return paylaterChannelResult.copy(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPaylaterChannel() {
        return this.paylaterChannel;
    }

    public final PaylaterChannelResult copy(@JSONField(name = "paylaterChannel") String paylaterChannel) {
        return new PaylaterChannelResult(paylaterChannel);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PaylaterChannelResult) && Intrinsics.areEqual(this.paylaterChannel, ((PaylaterChannelResult) other).paylaterChannel);
    }

    public final int hashCode() {
        String str = this.paylaterChannel;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaylaterChannelResult(paylaterChannel=");
        sb.append(this.paylaterChannel);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ PaylaterChannelResult(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    @JvmName(name = "getPaylaterChannel")
    public final String getPaylaterChannel() {
        return this.paylaterChannel;
    }

    public PaylaterChannelResult(@JSONField(name = "paylaterChannel") String str) {
        this.paylaterChannel = str;
    }
}
