package id.dana.sendmoney.data.api.groupsend.submit.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J@\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001c\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/data/api/groupsend/submit/model/MilestoneEntity;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/lang/Integer;", "component3", "component4", "timeScale", "timeConstraint", "bizScenario", "templateId", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lid/dana/sendmoney/data/api/groupsend/submit/model/MilestoneEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizScenario", "getTemplateId", "Ljava/lang/Integer;", "getTimeConstraint", "getTimeScale", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MilestoneEntity {
    private final String bizScenario;
    private final String templateId;
    private final Integer timeConstraint;
    private final String timeScale;

    public static /* synthetic */ MilestoneEntity copy$default(MilestoneEntity milestoneEntity, String str, Integer num, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = milestoneEntity.timeScale;
        }
        if ((i & 2) != 0) {
            num = milestoneEntity.timeConstraint;
        }
        if ((i & 4) != 0) {
            str2 = milestoneEntity.bizScenario;
        }
        if ((i & 8) != 0) {
            str3 = milestoneEntity.templateId;
        }
        return milestoneEntity.copy(str, num, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTimeScale() {
        return this.timeScale;
    }

    /* renamed from: component2  reason: from getter */
    public final Integer getTimeConstraint() {
        return this.timeConstraint;
    }

    /* renamed from: component3  reason: from getter */
    public final String getBizScenario() {
        return this.bizScenario;
    }

    /* renamed from: component4  reason: from getter */
    public final String getTemplateId() {
        return this.templateId;
    }

    public final MilestoneEntity copy(String timeScale, Integer timeConstraint, String bizScenario, String templateId) {
        return new MilestoneEntity(timeScale, timeConstraint, bizScenario, templateId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MilestoneEntity) {
            MilestoneEntity milestoneEntity = (MilestoneEntity) other;
            return Intrinsics.areEqual(this.timeScale, milestoneEntity.timeScale) && Intrinsics.areEqual(this.timeConstraint, milestoneEntity.timeConstraint) && Intrinsics.areEqual(this.bizScenario, milestoneEntity.bizScenario) && Intrinsics.areEqual(this.templateId, milestoneEntity.templateId);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.timeScale;
        int hashCode = str == null ? 0 : str.hashCode();
        Integer num = this.timeConstraint;
        int hashCode2 = num == null ? 0 : num.hashCode();
        String str2 = this.bizScenario;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.templateId;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MilestoneEntity(timeScale=");
        sb.append(this.timeScale);
        sb.append(", timeConstraint=");
        sb.append(this.timeConstraint);
        sb.append(", bizScenario=");
        sb.append(this.bizScenario);
        sb.append(", templateId=");
        sb.append(this.templateId);
        sb.append(')');
        return sb.toString();
    }

    public MilestoneEntity(String str, Integer num, String str2, String str3) {
        this.timeScale = str;
        this.timeConstraint = num;
        this.bizScenario = str2;
        this.templateId = str3;
    }

    @JvmName(name = "getTimeScale")
    public final String getTimeScale() {
        return this.timeScale;
    }

    @JvmName(name = "getTimeConstraint")
    public final Integer getTimeConstraint() {
        return this.timeConstraint;
    }

    @JvmName(name = "getBizScenario")
    public final String getBizScenario() {
        return this.bizScenario;
    }

    @JvmName(name = "getTemplateId")
    public final String getTemplateId() {
        return this.templateId;
    }
}
