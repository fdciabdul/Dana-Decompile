package id.dana.domain.zendesk.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/domain/zendesk/model/ZendeskBasicTicket;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "priority", "subject", "body", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/zendesk/model/ZendeskBasicTicket;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBody", "getPriority", "getSubject", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ZendeskBasicTicket {
    private final String body;
    private final String priority;
    private final String subject;

    public static /* synthetic */ ZendeskBasicTicket copy$default(ZendeskBasicTicket zendeskBasicTicket, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = zendeskBasicTicket.priority;
        }
        if ((i & 2) != 0) {
            str2 = zendeskBasicTicket.subject;
        }
        if ((i & 4) != 0) {
            str3 = zendeskBasicTicket.body;
        }
        return zendeskBasicTicket.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPriority() {
        return this.priority;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component3  reason: from getter */
    public final String getBody() {
        return this.body;
    }

    public final ZendeskBasicTicket copy(String priority, String subject, String body) {
        Intrinsics.checkNotNullParameter(priority, "");
        Intrinsics.checkNotNullParameter(subject, "");
        Intrinsics.checkNotNullParameter(body, "");
        return new ZendeskBasicTicket(priority, subject, body);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ZendeskBasicTicket) {
            ZendeskBasicTicket zendeskBasicTicket = (ZendeskBasicTicket) other;
            return Intrinsics.areEqual(this.priority, zendeskBasicTicket.priority) && Intrinsics.areEqual(this.subject, zendeskBasicTicket.subject) && Intrinsics.areEqual(this.body, zendeskBasicTicket.body);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.priority.hashCode() * 31) + this.subject.hashCode()) * 31) + this.body.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ZendeskBasicTicket(priority=");
        sb.append(this.priority);
        sb.append(", subject=");
        sb.append(this.subject);
        sb.append(", body=");
        sb.append(this.body);
        sb.append(')');
        return sb.toString();
    }

    public ZendeskBasicTicket(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.priority = str;
        this.subject = str2;
        this.body = str3;
    }

    @JvmName(name = "getPriority")
    public final String getPriority() {
        return this.priority;
    }

    @JvmName(name = "getSubject")
    public final String getSubject() {
        return this.subject;
    }

    @JvmName(name = "getBody")
    public final String getBody() {
        return this.body;
    }
}
