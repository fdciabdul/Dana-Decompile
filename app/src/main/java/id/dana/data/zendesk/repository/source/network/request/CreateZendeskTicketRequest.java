package id.dana.data.zendesk.repository.source.network.request;

import com.google.gson.annotations.SerializedName;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004"}, d2 = {"Lid/dana/data/zendesk/repository/source/network/request/CreateZendeskTicketRequest;", "", "Lid/dana/data/zendesk/repository/source/network/request/CreateZendeskTicketRequest$Ticket;", "component1", "()Lid/dana/data/zendesk/repository/source/network/request/CreateZendeskTicketRequest$Ticket;", "ticket", "copy", "(Lid/dana/data/zendesk/repository/source/network/request/CreateZendeskTicketRequest$Ticket;)Lid/dana/data/zendesk/repository/source/network/request/CreateZendeskTicketRequest;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/data/zendesk/repository/source/network/request/CreateZendeskTicketRequest$Ticket;", "getTicket", "<init>", "(Lid/dana/data/zendesk/repository/source/network/request/CreateZendeskTicketRequest$Ticket;)V", "Comment", TrackerKey.WalletPocketAssetType.TICKET}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CreateZendeskTicketRequest {
    @SerializedName("ticket")
    private final Ticket ticket;

    public static /* synthetic */ CreateZendeskTicketRequest copy$default(CreateZendeskTicketRequest createZendeskTicketRequest, Ticket ticket, int i, Object obj) {
        if ((i & 1) != 0) {
            ticket = createZendeskTicketRequest.ticket;
        }
        return createZendeskTicketRequest.copy(ticket);
    }

    /* renamed from: component1  reason: from getter */
    public final Ticket getTicket() {
        return this.ticket;
    }

    public final CreateZendeskTicketRequest copy(Ticket ticket) {
        Intrinsics.checkNotNullParameter(ticket, "");
        return new CreateZendeskTicketRequest(ticket);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CreateZendeskTicketRequest) && Intrinsics.areEqual(this.ticket, ((CreateZendeskTicketRequest) other).ticket);
    }

    public final int hashCode() {
        return this.ticket.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreateZendeskTicketRequest(ticket=");
        sb.append(this.ticket);
        sb.append(')');
        return sb.toString();
    }

    public CreateZendeskTicketRequest(Ticket ticket) {
        Intrinsics.checkNotNullParameter(ticket, "");
        this.ticket = ticket;
    }

    @JvmName(name = "getTicket")
    public final Ticket getTicket() {
        return this.ticket;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b"}, d2 = {"Lid/dana/data/zendesk/repository/source/network/request/CreateZendeskTicketRequest$Ticket;", "", "Lid/dana/data/zendesk/repository/source/network/request/CreateZendeskTicketRequest$Comment;", DecodedScanBizInfoKey.COMMENT, "Lid/dana/data/zendesk/repository/source/network/request/CreateZendeskTicketRequest$Comment;", "getComment", "()Lid/dana/data/zendesk/repository/source/network/request/CreateZendeskTicketRequest$Comment;", "", "priority", "Ljava/lang/String;", "getPriority", "()Ljava/lang/String;", "subject", "getSubject", "<init>", "(Lid/dana/data/zendesk/repository/source/network/request/CreateZendeskTicketRequest$Comment;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Ticket {
        @SerializedName(DecodedScanBizInfoKey.COMMENT)
        private final Comment comment;
        private final String priority;
        private final String subject;

        public Ticket(Comment comment, String str, String str2) {
            Intrinsics.checkNotNullParameter(comment, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.comment = comment;
            this.priority = str;
            this.subject = str2;
        }

        @JvmName(name = "getComment")
        public final Comment getComment() {
            return this.comment;
        }

        @JvmName(name = "getPriority")
        public final String getPriority() {
            return this.priority;
        }

        @JvmName(name = "getSubject")
        public final String getSubject() {
            return this.subject;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/zendesk/repository/source/network/request/CreateZendeskTicketRequest$Comment;", "", "", "body", "Ljava/lang/String;", "getBody", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Comment {
        @SerializedName("body")
        private final String body;

        public Comment(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.body = str;
        }

        @JvmName(name = "getBody")
        public final String getBody() {
            return this.body;
        }
    }
}
