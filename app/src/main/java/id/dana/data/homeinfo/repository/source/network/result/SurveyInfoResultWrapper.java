package id.dana.data.homeinfo.repository.source.network.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/data/homeinfo/repository/source/network/result/SurveyInfoResultWrapper;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "Lid/dana/data/homeinfo/repository/source/network/result/SurveyInfoResult;", "component1", "()Lid/dana/data/homeinfo/repository/source/network/result/SurveyInfoResult;", "surveyInfo", "copy", "(Lid/dana/data/homeinfo/repository/source/network/result/SurveyInfoResult;)Lid/dana/data/homeinfo/repository/source/network/result/SurveyInfoResultWrapper;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/data/homeinfo/repository/source/network/result/SurveyInfoResult;", "getSurveyInfo", "<init>", "(Lid/dana/data/homeinfo/repository/source/network/result/SurveyInfoResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SurveyInfoResultWrapper extends BaseRpcResult {
    @SerializedName("surveyInfo")
    private final SurveyInfoResult surveyInfo;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, id.dana.data.homeinfo.repository.source.network.result.SurveyInfoResult] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SurveyInfoResultWrapper() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.homeinfo.repository.source.network.result.SurveyInfoResultWrapper.<init>():void");
    }

    public static /* synthetic */ SurveyInfoResultWrapper copy$default(SurveyInfoResultWrapper surveyInfoResultWrapper, SurveyInfoResult surveyInfoResult, int i, Object obj) {
        if ((i & 1) != 0) {
            surveyInfoResult = surveyInfoResultWrapper.surveyInfo;
        }
        return surveyInfoResultWrapper.copy(surveyInfoResult);
    }

    /* renamed from: component1  reason: from getter */
    public final SurveyInfoResult getSurveyInfo() {
        return this.surveyInfo;
    }

    public final SurveyInfoResultWrapper copy(@JSONField(name = "surveyInfo") SurveyInfoResult surveyInfo) {
        return new SurveyInfoResultWrapper(surveyInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SurveyInfoResultWrapper) && Intrinsics.areEqual(this.surveyInfo, ((SurveyInfoResultWrapper) other).surveyInfo);
    }

    public final int hashCode() {
        SurveyInfoResult surveyInfoResult = this.surveyInfo;
        if (surveyInfoResult == null) {
            return 0;
        }
        return surveyInfoResult.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SurveyInfoResultWrapper(surveyInfo=");
        sb.append(this.surveyInfo);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ SurveyInfoResultWrapper(SurveyInfoResult surveyInfoResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : surveyInfoResult);
    }

    @JvmName(name = "getSurveyInfo")
    public final SurveyInfoResult getSurveyInfo() {
        return this.surveyInfo;
    }

    public SurveyInfoResultWrapper(@JSONField(name = "surveyInfo") SurveyInfoResult surveyInfoResult) {
        this.surveyInfo = surveyInfoResult;
    }
}
