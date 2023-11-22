package id.dana.data.homeinfo.repository.source.network.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007"}, d2 = {"Lid/dana/data/homeinfo/repository/source/network/result/SurveyInfoResult;", "", "", "component1", "()Ljava/lang/Boolean;", "", "component2", "()Ljava/lang/String;", "hasActiveSurvey", "innerUrl", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lid/dana/data/homeinfo/repository/source/network/result/SurveyInfoResult;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/Boolean;", "getHasActiveSurvey", "Ljava/lang/String;", "getInnerUrl", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SurveyInfoResult {
    @SerializedName("hasActiveSurvey")
    private final Boolean hasActiveSurvey;
    @SerializedName("innerUrl")
    private final String innerUrl;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.Boolean, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SurveyInfoResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.homeinfo.repository.source.network.result.SurveyInfoResult.<init>():void");
    }

    public static /* synthetic */ SurveyInfoResult copy$default(SurveyInfoResult surveyInfoResult, Boolean bool, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = surveyInfoResult.hasActiveSurvey;
        }
        if ((i & 2) != 0) {
            str = surveyInfoResult.innerUrl;
        }
        return surveyInfoResult.copy(bool, str);
    }

    /* renamed from: component1  reason: from getter */
    public final Boolean getHasActiveSurvey() {
        return this.hasActiveSurvey;
    }

    /* renamed from: component2  reason: from getter */
    public final String getInnerUrl() {
        return this.innerUrl;
    }

    public final SurveyInfoResult copy(@JSONField(name = "hasActiveSurvey") Boolean hasActiveSurvey, @JSONField(name = "innerUrl") String innerUrl) {
        return new SurveyInfoResult(hasActiveSurvey, innerUrl);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SurveyInfoResult) {
            SurveyInfoResult surveyInfoResult = (SurveyInfoResult) other;
            return Intrinsics.areEqual(this.hasActiveSurvey, surveyInfoResult.hasActiveSurvey) && Intrinsics.areEqual(this.innerUrl, surveyInfoResult.innerUrl);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.hasActiveSurvey;
        int hashCode = bool == null ? 0 : bool.hashCode();
        String str = this.innerUrl;
        return (hashCode * 31) + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SurveyInfoResult(hasActiveSurvey=");
        sb.append(this.hasActiveSurvey);
        sb.append(", innerUrl=");
        sb.append(this.innerUrl);
        sb.append(')');
        return sb.toString();
    }

    public SurveyInfoResult(@JSONField(name = "hasActiveSurvey") Boolean bool, @JSONField(name = "innerUrl") String str) {
        this.hasActiveSurvey = bool;
        this.innerUrl = str;
    }

    public /* synthetic */ SurveyInfoResult(Boolean bool, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : str);
    }

    @JvmName(name = "getHasActiveSurvey")
    public final Boolean getHasActiveSurvey() {
        return this.hasActiveSurvey;
    }

    @JvmName(name = "getInnerUrl")
    public final String getInnerUrl() {
        return this.innerUrl;
    }
}
