package id.dana.domain.wallet_v3.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007"}, d2 = {"Lid/dana/domain/wallet_v3/model/SurveyInfoModel;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "hasActiveSurvey", "innerUrl", "copy", "(ZLjava/lang/String;)Lid/dana/domain/wallet_v3/model/SurveyInfoModel;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getHasActiveSurvey", "Ljava/lang/String;", "getInnerUrl", "<init>", "(ZLjava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SurveyInfoModel {
    private final boolean hasActiveSurvey;
    private final String innerUrl;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SurveyInfoModel() {
        /*
            r3 = this;
            r0 = 0
            r1 = 0
            r2 = 3
            r3.<init>(r1, r0, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.wallet_v3.model.SurveyInfoModel.<init>():void");
    }

    public static /* synthetic */ SurveyInfoModel copy$default(SurveyInfoModel surveyInfoModel, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = surveyInfoModel.hasActiveSurvey;
        }
        if ((i & 2) != 0) {
            str = surveyInfoModel.innerUrl;
        }
        return surveyInfoModel.copy(z, str);
    }

    /* renamed from: component1  reason: from getter */
    public final boolean getHasActiveSurvey() {
        return this.hasActiveSurvey;
    }

    /* renamed from: component2  reason: from getter */
    public final String getInnerUrl() {
        return this.innerUrl;
    }

    public final SurveyInfoModel copy(boolean hasActiveSurvey, String innerUrl) {
        Intrinsics.checkNotNullParameter(innerUrl, "");
        return new SurveyInfoModel(hasActiveSurvey, innerUrl);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SurveyInfoModel) {
            SurveyInfoModel surveyInfoModel = (SurveyInfoModel) other;
            return this.hasActiveSurvey == surveyInfoModel.hasActiveSurvey && Intrinsics.areEqual(this.innerUrl, surveyInfoModel.innerUrl);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z = this.hasActiveSurvey;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.innerUrl.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SurveyInfoModel(hasActiveSurvey=");
        sb.append(this.hasActiveSurvey);
        sb.append(", innerUrl=");
        sb.append(this.innerUrl);
        sb.append(')');
        return sb.toString();
    }

    public SurveyInfoModel(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.hasActiveSurvey = z;
        this.innerUrl = str;
    }

    public /* synthetic */ SurveyInfoModel(boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str);
    }

    @JvmName(name = "getHasActiveSurvey")
    public final boolean getHasActiveSurvey() {
        return this.hasActiveSurvey;
    }

    @JvmName(name = "getInnerUrl")
    public final String getInnerUrl() {
        return this.innerUrl;
    }
}
