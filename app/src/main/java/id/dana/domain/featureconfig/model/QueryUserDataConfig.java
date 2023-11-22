package id.dana.domain.featureconfig.model;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B?\u0012\b\b\u0003\u0010\u0011\u001a\u00020\b\u0012\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0003\u0010\u000f\u001a\u00020\b\u0012\b\b\u0003\u0010\r\u001a\u00020\b\u0012\b\b\u0003\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001a\u0010\u000f\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\f"}, d2 = {"Lid/dana/domain/featureconfig/model/QueryUserDataConfig;", "", "", "", "queryType", "Ljava/util/List;", "getQueryType", "()Ljava/util/List;", "", "seperatePaylaterChannel", "Z", "getSeperatePaylaterChannel", "()Z", "seperateProcessTrans", "getSeperateProcessTrans", "seperateSurveyInfo", "getSeperateSurveyInfo", "seperateUserInfo", "getSeperateUserInfo", "<init>", "(ZLjava/util/List;ZZZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class QueryUserDataConfig {
    public List<String> queryType;
    public boolean seperatePaylaterChannel;
    public boolean seperateProcessTrans;
    public boolean seperateSurveyInfo;
    public boolean seperateUserInfo;

    public QueryUserDataConfig() {
        this(false, null, false, false, false, 31, null);
    }

    public QueryUserDataConfig(@JSONField(name = "seperateUserInfo") boolean z, @JSONField(name = "queryType") List<String> list, @JSONField(name = "seperateSurveyInfo") boolean z2, @JSONField(name = "seperateProcessTrans") boolean z3, @JSONField(name = "seperatePaylaterChannel") boolean z4) {
        Intrinsics.checkNotNullParameter(list, "");
        this.seperateUserInfo = z;
        this.queryType = list;
        this.seperateSurveyInfo = z2;
        this.seperateProcessTrans = z3;
        this.seperatePaylaterChannel = z4;
    }

    @JvmName(name = "getSeperateUserInfo")
    public final boolean getSeperateUserInfo() {
        return this.seperateUserInfo;
    }

    public /* synthetic */ QueryUserDataConfig(boolean z, List list, boolean z2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4);
    }

    @JvmName(name = "getQueryType")
    public final List<String> getQueryType() {
        return this.queryType;
    }

    @JvmName(name = "getSeperateSurveyInfo")
    public final boolean getSeperateSurveyInfo() {
        return this.seperateSurveyInfo;
    }

    @JvmName(name = "getSeperateProcessTrans")
    public final boolean getSeperateProcessTrans() {
        return this.seperateProcessTrans;
    }

    @JvmName(name = "getSeperatePaylaterChannel")
    public final boolean getSeperatePaylaterChannel() {
        return this.seperatePaylaterChannel;
    }
}
