package id.dana.data.zendesk.repository.source.network.response;

import com.alibaba.ariver.kernel.common.log.PageLog;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0004\u0016\u0017\u0018\u0019B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004"}, d2 = {"Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse;", "", "Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse$Ticket;", "component1", "()Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse$Ticket;", "ticket", "copy", "(Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse$Ticket;)Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse$Ticket;", "getTicket", "<init>", "(Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse$Ticket;)V", "CustomFields", "StatisfactionRating", TrackerKey.WalletPocketAssetType.TICKET, HttpHeaders.VIA}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CreateZendeskTicketResponse {
    @SerializedName("ticket")
    private final Ticket ticket;

    public static /* synthetic */ CreateZendeskTicketResponse copy$default(CreateZendeskTicketResponse createZendeskTicketResponse, Ticket ticket, int i, Object obj) {
        if ((i & 1) != 0) {
            ticket = createZendeskTicketResponse.ticket;
        }
        return createZendeskTicketResponse.copy(ticket);
    }

    /* renamed from: component1  reason: from getter */
    public final Ticket getTicket() {
        return this.ticket;
    }

    public final CreateZendeskTicketResponse copy(Ticket ticket) {
        Intrinsics.checkNotNullParameter(ticket, "");
        return new CreateZendeskTicketResponse(ticket);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CreateZendeskTicketResponse) && Intrinsics.areEqual(this.ticket, ((CreateZendeskTicketResponse) other).ticket);
    }

    public final int hashCode() {
        return this.ticket.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreateZendeskTicketResponse(ticket=");
        sb.append(this.ticket);
        sb.append(')');
        return sb.toString();
    }

    public CreateZendeskTicketResponse(Ticket ticket) {
        Intrinsics.checkNotNullParameter(ticket, "");
        this.ticket = ticket;
    }

    @JvmName(name = "getTicket")
    public final Ticket getTicket() {
        return this.ticket;
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B³\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007\u0012\b\u00102\u001a\u0004\u0018\u00010\u0002\u0012\b\u00104\u001a\u0004\u0018\u00010\u0002\u0012\b\u00106\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010>\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010A\u001a\u0004\u0018\u00010@¢\u0006\u0004\bE\u0010FR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\t\u001a\u0004\b\u0018\u0010\u000bR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001c\u0010)\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006R\u001c\u0010,\u001a\u0004\u0018\u00010+8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\"\u00100\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010\t\u001a\u0004\b1\u0010\u000bR\u001c\u00102\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\u0006R\u001c\u00104\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010\u0004\u001a\u0004\b5\u0010\u0006R\u001c\u00106\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010\u0004\u001a\u0004\b7\u0010\u0006R\"\u00108\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010\t\u001a\u0004\b9\u0010\u000bR\u001c\u0010:\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010\u0004\u001a\u0004\b;\u0010\u0006R\u001c\u0010<\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010\u0004\u001a\u0004\b=\u0010\u0006R\u001c\u0010>\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006R\u001c\u0010A\u001a\u0004\u0018\u00010@8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D"}, d2 = {"Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse$Ticket;", "", "", "assigneeId", "Ljava/lang/String;", "getAssigneeId", "()Ljava/lang/String;", "", "collaboratorIds", "Ljava/util/List;", "getCollaboratorIds", "()Ljava/util/List;", "createdAt", "getCreatedAt", "Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse$CustomFields;", "customFields", "getCustomFields", "description", "getDescription", "dueAt", "getDueAt", "externalId", "getExternalId", "followerIds", "getFollowerIds", "groupId", "getGroupId", "hasIncidents", "getHasIncidents", "id", "getId", "organizationId", "getOrganizationId", "priority", "getPriority", "problemId", "getProblemId", "rawSubject", "getRawSubject", "recipient", "getRecipient", "requesterId", "getRequesterId", "Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse$StatisfactionRating;", "satisfactionRating", "Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse$StatisfactionRating;", "getSatisfactionRating", "()Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse$StatisfactionRating;", "sharingAgreementIds", "getSharingAgreementIds", "status", "getStatus", "subject", "getSubject", "submitterId", "getSubmitterId", PageLog.PAGE_LOG_TAGS, "getTags", "type", "getType", "updatedAt", "getUpdatedAt", "url", "getUrl", "Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse$Via;", "via", "Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse$Via;", "getVia", "()Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse$Via;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse$StatisfactionRating;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse$Via;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Ticket {
        @SerializedName("assignee_id")
        private final String assigneeId;
        @SerializedName("collaborator_ids")
        private final List<String> collaboratorIds;
        @SerializedName("created_at")
        private final String createdAt;
        @SerializedName("custom_fields")
        private final List<CustomFields> customFields;
        @SerializedName("description")
        private final String description;
        @SerializedName("due_at")
        private final String dueAt;
        @SerializedName("external_id")
        private final String externalId;
        @SerializedName("follower_ids")
        private final List<String> followerIds;
        @SerializedName(FirebaseAnalytics.Param.GROUP_ID)
        private final String groupId;
        @SerializedName("has_incidents")
        private final String hasIncidents;
        @SerializedName("id")
        private final String id;
        @SerializedName("organization_id")
        private final String organizationId;
        @SerializedName("priority")
        private final String priority;
        @SerializedName("problem_id")
        private final String problemId;
        @SerializedName("raw_subject")
        private final String rawSubject;
        @SerializedName("recipient")
        private final String recipient;
        @SerializedName("requester_id")
        private final String requesterId;
        @SerializedName("satisfaction_rating")
        private final StatisfactionRating satisfactionRating;
        @SerializedName("sharing_agreement_ids")
        private final List<String> sharingAgreementIds;
        @SerializedName("status")
        private final String status;
        @SerializedName("subject")
        private final String subject;
        @SerializedName("submitter_id")
        private final String submitterId;
        @SerializedName(PageLog.PAGE_LOG_TAGS)
        private final List<String> tags;
        @SerializedName("type")
        private final String type;
        @SerializedName("updated_at")
        private final String updatedAt;
        @SerializedName("url")
        private final String url;
        @SerializedName("via")
        private final Via via;

        public Ticket(String str, List<String> list, String str2, List<CustomFields> list2, String str3, String str4, String str5, List<String> list3, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, StatisfactionRating statisfactionRating, List<String> list4, String str15, String str16, String str17, List<String> list5, String str18, String str19, String str20, Via via) {
            this.assigneeId = str;
            this.collaboratorIds = list;
            this.createdAt = str2;
            this.customFields = list2;
            this.description = str3;
            this.dueAt = str4;
            this.externalId = str5;
            this.followerIds = list3;
            this.groupId = str6;
            this.hasIncidents = str7;
            this.id = str8;
            this.organizationId = str9;
            this.priority = str10;
            this.problemId = str11;
            this.rawSubject = str12;
            this.recipient = str13;
            this.requesterId = str14;
            this.satisfactionRating = statisfactionRating;
            this.sharingAgreementIds = list4;
            this.status = str15;
            this.subject = str16;
            this.submitterId = str17;
            this.tags = list5;
            this.type = str18;
            this.updatedAt = str19;
            this.url = str20;
            this.via = via;
        }

        @JvmName(name = "getAssigneeId")
        public final String getAssigneeId() {
            return this.assigneeId;
        }

        @JvmName(name = "getCollaboratorIds")
        public final List<String> getCollaboratorIds() {
            return this.collaboratorIds;
        }

        @JvmName(name = "getCreatedAt")
        public final String getCreatedAt() {
            return this.createdAt;
        }

        @JvmName(name = "getCustomFields")
        public final List<CustomFields> getCustomFields() {
            return this.customFields;
        }

        @JvmName(name = "getDescription")
        public final String getDescription() {
            return this.description;
        }

        @JvmName(name = "getDueAt")
        public final String getDueAt() {
            return this.dueAt;
        }

        @JvmName(name = "getExternalId")
        public final String getExternalId() {
            return this.externalId;
        }

        @JvmName(name = "getFollowerIds")
        public final List<String> getFollowerIds() {
            return this.followerIds;
        }

        @JvmName(name = "getGroupId")
        public final String getGroupId() {
            return this.groupId;
        }

        @JvmName(name = "getHasIncidents")
        public final String getHasIncidents() {
            return this.hasIncidents;
        }

        @JvmName(name = "getId")
        public final String getId() {
            return this.id;
        }

        @JvmName(name = "getOrganizationId")
        public final String getOrganizationId() {
            return this.organizationId;
        }

        @JvmName(name = "getPriority")
        public final String getPriority() {
            return this.priority;
        }

        @JvmName(name = "getProblemId")
        public final String getProblemId() {
            return this.problemId;
        }

        @JvmName(name = "getRawSubject")
        public final String getRawSubject() {
            return this.rawSubject;
        }

        @JvmName(name = "getRecipient")
        public final String getRecipient() {
            return this.recipient;
        }

        @JvmName(name = "getRequesterId")
        public final String getRequesterId() {
            return this.requesterId;
        }

        @JvmName(name = "getSatisfactionRating")
        public final StatisfactionRating getSatisfactionRating() {
            return this.satisfactionRating;
        }

        @JvmName(name = "getSharingAgreementIds")
        public final List<String> getSharingAgreementIds() {
            return this.sharingAgreementIds;
        }

        @JvmName(name = "getStatus")
        public final String getStatus() {
            return this.status;
        }

        @JvmName(name = "getSubject")
        public final String getSubject() {
            return this.subject;
        }

        @JvmName(name = "getSubmitterId")
        public final String getSubmitterId() {
            return this.submitterId;
        }

        @JvmName(name = "getTags")
        public final List<String> getTags() {
            return this.tags;
        }

        @JvmName(name = "getType")
        public final String getType() {
            return this.type;
        }

        @JvmName(name = "getUpdatedAt")
        public final String getUpdatedAt() {
            return this.updatedAt;
        }

        @JvmName(name = "getUrl")
        public final String getUrl() {
            return this.url;
        }

        @JvmName(name = "getVia")
        public final Via getVia() {
            return this.via;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse$CustomFields;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "value", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class CustomFields {
        @SerializedName("id")
        private final String id;
        @SerializedName("value")
        private final String value;

        public CustomFields(String str, String str2) {
            this.id = str;
            this.value = str2;
        }

        @JvmName(name = "getId")
        public final String getId() {
            return this.id;
        }

        @JvmName(name = "getValue")
        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse$Via;", "", "", "channel", "Ljava/lang/String;", "getChannel", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Via {
        @SerializedName("channel")
        private final String channel;

        public Via(String str) {
            this.channel = str;
        }

        @JvmName(name = "getChannel")
        public final String getChannel() {
            return this.channel;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse$StatisfactionRating;", "", "", DecodedScanBizInfoKey.COMMENT, "Ljava/lang/String;", "getComment", "()Ljava/lang/String;", "id", "getId", FirebaseAnalytics.Param.SCORE, "getScore", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class StatisfactionRating {
        @SerializedName(DecodedScanBizInfoKey.COMMENT)
        private final String comment;
        @SerializedName("id")
        private final String id;
        @SerializedName(FirebaseAnalytics.Param.SCORE)
        private final String score;

        public StatisfactionRating(String str, String str2, String str3) {
            this.comment = str;
            this.id = str2;
            this.score = str3;
        }

        @JvmName(name = "getComment")
        public final String getComment() {
            return this.comment;
        }

        @JvmName(name = "getId")
        public final String getId() {
            return this.id;
        }

        @JvmName(name = "getScore")
        public final String getScore() {
            return this.score;
        }
    }
}
