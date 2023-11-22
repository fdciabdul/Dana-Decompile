package id.dana.domain.kycamledd.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/domain/kycamledd/model/EddSubmitInfo;", "", "", "amlOrderId", "Ljava/lang/String;", "getAmlOrderId", "()Ljava/lang/String;", "", "Lid/dana/domain/kycamledd/model/EddSubmitInfoDTO;", "eddQuestionInfos", "Ljava/util/List;", "getEddQuestionInfos", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EddSubmitInfo {
    private final String amlOrderId;
    private final List<EddSubmitInfoDTO> eddQuestionInfos;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public EddSubmitInfo() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.kycamledd.model.EddSubmitInfo.<init>():void");
    }

    public EddSubmitInfo(String str, List<EddSubmitInfoDTO> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.amlOrderId = str;
        this.eddQuestionInfos = list;
    }

    @JvmName(name = "getAmlOrderId")
    public final String getAmlOrderId() {
        return this.amlOrderId;
    }

    public /* synthetic */ EddSubmitInfo(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getEddQuestionInfos")
    public final List<EddSubmitInfoDTO> getEddQuestionInfos() {
        return this.eddQuestionInfos;
    }
}
