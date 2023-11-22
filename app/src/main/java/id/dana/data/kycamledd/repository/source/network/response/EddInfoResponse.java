package id.dana.data.kycamledd.repository.source.network.response;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b"}, d2 = {"Lid/dana/data/kycamledd/repository/source/network/response/EddInfoResponse;", "", "", "component1", "()Ljava/lang/String;", "", "Lid/dana/data/kycamledd/repository/source/network/response/EddQuestionInfoDTOResponse;", "component2", "()Ljava/util/List;", "amlOrderId", "eddQuestionInfos", "copy", "(Ljava/lang/String;Ljava/util/List;)Lid/dana/data/kycamledd/repository/source/network/response/EddInfoResponse;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAmlOrderId", "Ljava/util/List;", "getEddQuestionInfos", "<init>", "(Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class EddInfoResponse {
    private final String amlOrderId;
    private final List<EddQuestionInfoDTOResponse> eddQuestionInfos;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public EddInfoResponse() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.kycamledd.repository.source.network.response.EddInfoResponse.<init>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EddInfoResponse copy$default(EddInfoResponse eddInfoResponse, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eddInfoResponse.amlOrderId;
        }
        if ((i & 2) != 0) {
            list = eddInfoResponse.eddQuestionInfos;
        }
        return eddInfoResponse.copy(str, list);
    }

    /* renamed from: component1  reason: from getter */
    public final String getAmlOrderId() {
        return this.amlOrderId;
    }

    public final List<EddQuestionInfoDTOResponse> component2() {
        return this.eddQuestionInfos;
    }

    public final EddInfoResponse copy(String amlOrderId, List<EddQuestionInfoDTOResponse> eddQuestionInfos) {
        Intrinsics.checkNotNullParameter(amlOrderId, "");
        Intrinsics.checkNotNullParameter(eddQuestionInfos, "");
        return new EddInfoResponse(amlOrderId, eddQuestionInfos);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof EddInfoResponse) {
            EddInfoResponse eddInfoResponse = (EddInfoResponse) other;
            return Intrinsics.areEqual(this.amlOrderId, eddInfoResponse.amlOrderId) && Intrinsics.areEqual(this.eddQuestionInfos, eddInfoResponse.eddQuestionInfos);
        }
        return false;
    }

    public final int hashCode() {
        return (this.amlOrderId.hashCode() * 31) + this.eddQuestionInfos.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EddInfoResponse(amlOrderId=");
        sb.append(this.amlOrderId);
        sb.append(", eddQuestionInfos=");
        sb.append(this.eddQuestionInfos);
        sb.append(')');
        return sb.toString();
    }

    public EddInfoResponse(String str, List<EddQuestionInfoDTOResponse> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.amlOrderId = str;
        this.eddQuestionInfos = list;
    }

    @JvmName(name = "getAmlOrderId")
    public final String getAmlOrderId() {
        return this.amlOrderId;
    }

    public /* synthetic */ EddInfoResponse(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getEddQuestionInfos")
    public final List<EddQuestionInfoDTOResponse> getEddQuestionInfos() {
        return this.eddQuestionInfos;
    }
}
