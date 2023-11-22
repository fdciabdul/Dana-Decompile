package id.dana.kyb.data.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ4\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00078\u0007¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00018\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u0006"}, d2 = {"Lid/dana/kyb/data/model/KybServiceRuleResult;", "", "", "component1", "()Ljava/lang/String;", "component2", "()Ljava/lang/Object;", "Lid/dana/kyb/data/model/KybServiceMessageResult;", "component3", "()Lid/dana/kyb/data/model/KybServiceMessageResult;", "rule", "value", "message", "copy", "(Ljava/lang/String;Ljava/lang/Object;Lid/dana/kyb/data/model/KybServiceMessageResult;)Lid/dana/kyb/data/model/KybServiceRuleResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Lid/dana/kyb/data/model/KybServiceMessageResult;", "getMessage", "Ljava/lang/String;", "getRule", "Ljava/lang/Object;", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Lid/dana/kyb/data/model/KybServiceMessageResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybServiceRuleResult {
    private final KybServiceMessageResult message;
    private final String rule;
    private final Object value;

    public KybServiceRuleResult() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ KybServiceRuleResult copy$default(KybServiceRuleResult kybServiceRuleResult, String str, Object obj, KybServiceMessageResult kybServiceMessageResult, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = kybServiceRuleResult.rule;
        }
        if ((i & 2) != 0) {
            obj = kybServiceRuleResult.value;
        }
        if ((i & 4) != 0) {
            kybServiceMessageResult = kybServiceRuleResult.message;
        }
        return kybServiceRuleResult.copy(str, obj, kybServiceMessageResult);
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
    public final KybServiceMessageResult getMessage() {
        return this.message;
    }

    public final KybServiceRuleResult copy(String rule, Object value, KybServiceMessageResult message) {
        return new KybServiceRuleResult(rule, value, message);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KybServiceRuleResult) {
            KybServiceRuleResult kybServiceRuleResult = (KybServiceRuleResult) other;
            return Intrinsics.areEqual(this.rule, kybServiceRuleResult.rule) && Intrinsics.areEqual(this.value, kybServiceRuleResult.value) && Intrinsics.areEqual(this.message, kybServiceRuleResult.message);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.rule;
        int hashCode = str == null ? 0 : str.hashCode();
        Object obj = this.value;
        int hashCode2 = obj == null ? 0 : obj.hashCode();
        KybServiceMessageResult kybServiceMessageResult = this.message;
        return (((hashCode * 31) + hashCode2) * 31) + (kybServiceMessageResult != null ? kybServiceMessageResult.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybServiceRuleResult(rule=");
        sb.append(this.rule);
        sb.append(", value=");
        sb.append(this.value);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(')');
        return sb.toString();
    }

    public KybServiceRuleResult(String str, Object obj, KybServiceMessageResult kybServiceMessageResult) {
        this.rule = str;
        this.value = obj;
        this.message = kybServiceMessageResult;
    }

    public /* synthetic */ KybServiceRuleResult(String str, Object obj, KybServiceMessageResult kybServiceMessageResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : kybServiceMessageResult);
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
    public final KybServiceMessageResult getMessage() {
        return this.message;
    }
}
