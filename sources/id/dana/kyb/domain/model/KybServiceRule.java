package id.dana.kyb.domain.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ2\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00078\u0007¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\tR\u001a\u0010\n\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00018\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0006"}, d2 = {"Lid/dana/kyb/domain/model/KybServiceRule;", "", "", "component1", "()Ljava/lang/String;", "component2", "()Ljava/lang/Object;", "Lid/dana/kyb/domain/model/KybServiceMessage;", "component3", "()Lid/dana/kyb/domain/model/KybServiceMessage;", "rule", "value", "message", "copy", "(Ljava/lang/String;Ljava/lang/Object;Lid/dana/kyb/domain/model/KybServiceMessage;)Lid/dana/kyb/domain/model/KybServiceRule;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/kyb/domain/model/KybServiceMessage;", "getMessage", "Ljava/lang/String;", "getRule", "Ljava/lang/Object;", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Lid/dana/kyb/domain/model/KybServiceMessage;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybServiceRule {
    private final KybServiceMessage message;
    private final String rule;
    private final Object value;

    public static /* synthetic */ KybServiceRule copy$default(KybServiceRule kybServiceRule, String str, Object obj, KybServiceMessage kybServiceMessage, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = kybServiceRule.rule;
        }
        if ((i & 2) != 0) {
            obj = kybServiceRule.value;
        }
        if ((i & 4) != 0) {
            kybServiceMessage = kybServiceRule.message;
        }
        return kybServiceRule.copy(str, obj, kybServiceMessage);
    }

    /* renamed from: component1  reason: from getter */
    public final String getRule() {
        return this.rule;
    }

    /* renamed from: component2  reason: from getter */
    public final Object getValue() {
        return this.value;
    }

    /* renamed from: component3  reason: from getter */
    public final KybServiceMessage getMessage() {
        return this.message;
    }

    public final KybServiceRule copy(String rule, Object value, KybServiceMessage message) {
        Intrinsics.checkNotNullParameter(rule, "");
        return new KybServiceRule(rule, value, message);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KybServiceRule) {
            KybServiceRule kybServiceRule = (KybServiceRule) other;
            return Intrinsics.areEqual(this.rule, kybServiceRule.rule) && Intrinsics.areEqual(this.value, kybServiceRule.value) && Intrinsics.areEqual(this.message, kybServiceRule.message);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.rule.hashCode();
        Object obj = this.value;
        int hashCode2 = obj == null ? 0 : obj.hashCode();
        KybServiceMessage kybServiceMessage = this.message;
        return (((hashCode * 31) + hashCode2) * 31) + (kybServiceMessage != null ? kybServiceMessage.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybServiceRule(rule=");
        sb.append(this.rule);
        sb.append(", value=");
        sb.append(this.value);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(')');
        return sb.toString();
    }

    public KybServiceRule(String str, Object obj, KybServiceMessage kybServiceMessage) {
        Intrinsics.checkNotNullParameter(str, "");
        this.rule = str;
        this.value = obj;
        this.message = kybServiceMessage;
    }

    public /* synthetic */ KybServiceRule(String str, Object obj, KybServiceMessage kybServiceMessage, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : kybServiceMessage);
    }

    @JvmName(name = "getRule")
    public final String getRule() {
        return this.rule;
    }

    @JvmName(name = "getValue")
    public final Object getValue() {
        return this.value;
    }

    @JvmName(name = "getMessage")
    public final KybServiceMessage getMessage() {
        return this.message;
    }
}
