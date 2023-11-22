package id.dana.domain.zendesk.model;

import com.alibaba.ariver.kernel.common.log.PageLog;
import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001:\u0002ijBý\u0001\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0010\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\u0006\u0010)\u001a\u00020\u0002\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\u0006\u0010-\u001a\u00020\u0002\u0012\u0006\u0010.\u001a\u00020\u0002\u0012\u0006\u0010/\u001a\u00020\u0002\u0012\u0006\u00100\u001a\u00020\u0002\u0012\u0006\u00101\u001a\u00020\u0002\u0012\u0006\u00102\u001a\u00020\u0002\u0012\u0006\u00103\u001a\u00020\u0002\u0012\u0006\u00104\u001a\u00020\u0002\u0012\u0006\u00105\u001a\u00020\r\u0012\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\u0006\u00107\u001a\u00020\u0002\u0012\u0006\u00108\u001a\u00020\u0002\u0012\u0006\u00109\u001a\u00020\u0002\u0012\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\u0006\u0010;\u001a\u00020\u0002\u0012\u0006\u0010<\u001a\u00020\u0002\u0012\u0006\u0010=\u001a\u00020\u0002\u0012\u0006\u0010>\u001a\u00020\u0002¢\u0006\u0004\bg\u0010hJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0012J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0010HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0012J\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0004J\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0004J\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010HÆ\u0003¢\u0006\u0004\b\"\u0010\u0012J\u0010\u0010#\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u0004J¼\u0002\u0010?\u001a\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\u00022\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010&\u001a\u00020\u00022\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00102\b\b\u0002\u0010(\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u00022\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010,\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u00022\b\b\u0002\u0010.\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\u00022\b\b\u0002\u00100\u001a\u00020\u00022\b\b\u0002\u00101\u001a\u00020\u00022\b\b\u0002\u00102\u001a\u00020\u00022\b\b\u0002\u00103\u001a\u00020\u00022\b\b\u0002\u00104\u001a\u00020\u00022\b\b\u0002\u00105\u001a\u00020\r2\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u00107\u001a\u00020\u00022\b\b\u0002\u00108\u001a\u00020\u00022\b\b\u0002\u00109\u001a\u00020\u00022\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\b\u0002\u0010;\u001a\u00020\u00022\b\b\u0002\u0010<\u001a\u00020\u00022\b\b\u0002\u0010=\u001a\u00020\u00022\b\b\u0002\u0010>\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b?\u0010@J\u001a\u0010C\u001a\u00020B2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bC\u0010DJ\u0010\u0010F\u001a\u00020EHÖ\u0001¢\u0006\u0004\bF\u0010GJ\u0010\u0010H\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bH\u0010\u0004R\u0017\u0010$\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b$\u0010I\u001a\u0004\bJ\u0010\u0004R\u001a\u0010>\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010I\u001a\u0004\bK\u0010\u0004R \u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010L\u001a\u0004\bM\u0010\u0012R\u001a\u0010&\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010I\u001a\u0004\bN\u0010\u0004R \u0010'\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010L\u001a\u0004\bO\u0010\u0012R\u001a\u0010(\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010I\u001a\u0004\bP\u0010\u0004R\u001a\u0010)\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010I\u001a\u0004\bQ\u0010\u0004R\u001a\u0010*\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010I\u001a\u0004\bR\u0010\u0004R \u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010L\u001a\u0004\bS\u0010\u0012R\u001a\u0010,\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010I\u001a\u0004\bT\u0010\u0004R\u001a\u0010-\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010I\u001a\u0004\bU\u0010\u0004R\u001a\u0010.\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b.\u0010I\u001a\u0004\bV\u0010\u0004R\u001a\u0010/\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010I\u001a\u0004\bW\u0010\u0004R\u001a\u00100\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b0\u0010I\u001a\u0004\bX\u0010\u0004R\u001a\u00101\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010I\u001a\u0004\bY\u0010\u0004R\u001a\u00102\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010I\u001a\u0004\bZ\u0010\u0004R\u001a\u00103\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010I\u001a\u0004\b[\u0010\u0004R\u001a\u00104\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010I\u001a\u0004\b\\\u0010\u0004R\u001a\u00105\u001a\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010]\u001a\u0004\b^\u0010\u000fR \u00106\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010L\u001a\u0004\b_\u0010\u0012R\u001a\u00107\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b7\u0010I\u001a\u0004\b`\u0010\u0004R\u001a\u00108\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010I\u001a\u0004\ba\u0010\u0004R\u001a\u00109\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010I\u001a\u0004\bb\u0010\u0004R \u0010:\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0007X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010L\u001a\u0004\bc\u0010\u0012R\u001a\u0010;\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010I\u001a\u0004\bd\u0010\u0004R\u001a\u0010<\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010I\u001a\u0004\be\u0010\u0004R\u001a\u0010=\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010I\u001a\u0004\bf\u0010\u0004"}, d2 = {"Lid/dana/domain/zendesk/model/ZendeskBasicTicketResult;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "Lid/dana/domain/zendesk/model/ZendeskBasicTicketResult$StatisfactionRating;", "component18", "()Lid/dana/domain/zendesk/model/ZendeskBasicTicketResult$StatisfactionRating;", "", "component19", "()Ljava/util/List;", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component3", "Lid/dana/domain/zendesk/model/ZendeskBasicTicketResult$CustomFields;", "component4", "component5", "component6", "component7", "component8", "component9", "assigneeId", "collaboratorIds", "createdAt", "customFields", "description", "dueAt", "externalId", "followerIds", "groupId", "hasIncidents", "id", "organizationId", "priority", "problemId", "rawSubject", "recipient", "requesterId", "satisfactionRating", "sharingAgreementIds", "status", "subject", "submitterId", PageLog.PAGE_LOG_TAGS, "type", "updatedAt", "url", "channel", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/zendesk/model/ZendeskBasicTicketResult$StatisfactionRating;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/zendesk/model/ZendeskBasicTicketResult;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAssigneeId", "getChannel", "Ljava/util/List;", "getCollaboratorIds", "getCreatedAt", "getCustomFields", "getDescription", "getDueAt", "getExternalId", "getFollowerIds", "getGroupId", "getHasIncidents", "getId", "getOrganizationId", "getPriority", "getProblemId", "getRawSubject", "getRecipient", "getRequesterId", "Lid/dana/domain/zendesk/model/ZendeskBasicTicketResult$StatisfactionRating;", "getSatisfactionRating", "getSharingAgreementIds", "getStatus", "getSubject", "getSubmitterId", "getTags", "getType", "getUpdatedAt", "getUrl", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/zendesk/model/ZendeskBasicTicketResult$StatisfactionRating;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "CustomFields", "StatisfactionRating"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ZendeskBasicTicketResult {
    private final String assigneeId;
    private final String channel;
    private final List<String> collaboratorIds;
    private final String createdAt;
    private final List<CustomFields> customFields;
    private final String description;
    private final String dueAt;
    private final String externalId;
    private final List<String> followerIds;
    private final String groupId;
    private final String hasIncidents;
    private final String id;
    private final String organizationId;
    private final String priority;
    private final String problemId;
    private final String rawSubject;
    private final String recipient;
    private final String requesterId;
    private final StatisfactionRating satisfactionRating;
    private final List<String> sharingAgreementIds;
    private final String status;
    private final String subject;
    private final String submitterId;
    private final List<String> tags;
    private final String type;
    private final String updatedAt;
    private final String url;

    /* renamed from: component1  reason: from getter */
    public final String getAssigneeId() {
        return this.assigneeId;
    }

    /* renamed from: component10  reason: from getter */
    public final String getHasIncidents() {
        return this.hasIncidents;
    }

    /* renamed from: component11  reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component12  reason: from getter */
    public final String getOrganizationId() {
        return this.organizationId;
    }

    /* renamed from: component13  reason: from getter */
    public final String getPriority() {
        return this.priority;
    }

    /* renamed from: component14  reason: from getter */
    public final String getProblemId() {
        return this.problemId;
    }

    /* renamed from: component15  reason: from getter */
    public final String getRawSubject() {
        return this.rawSubject;
    }

    /* renamed from: component16  reason: from getter */
    public final String getRecipient() {
        return this.recipient;
    }

    /* renamed from: component17  reason: from getter */
    public final String getRequesterId() {
        return this.requesterId;
    }

    /* renamed from: component18  reason: from getter */
    public final StatisfactionRating getSatisfactionRating() {
        return this.satisfactionRating;
    }

    public final List<String> component19() {
        return this.sharingAgreementIds;
    }

    public final List<String> component2() {
        return this.collaboratorIds;
    }

    /* renamed from: component20  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component21  reason: from getter */
    public final String getSubject() {
        return this.subject;
    }

    /* renamed from: component22  reason: from getter */
    public final String getSubmitterId() {
        return this.submitterId;
    }

    public final List<String> component23() {
        return this.tags;
    }

    /* renamed from: component24  reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component25  reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component26  reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component27  reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final List<CustomFields> component4() {
        return this.customFields;
    }

    /* renamed from: component5  reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component6  reason: from getter */
    public final String getDueAt() {
        return this.dueAt;
    }

    /* renamed from: component7  reason: from getter */
    public final String getExternalId() {
        return this.externalId;
    }

    public final List<String> component8() {
        return this.followerIds;
    }

    /* renamed from: component9  reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    public final ZendeskBasicTicketResult copy(String assigneeId, List<String> collaboratorIds, String createdAt, List<CustomFields> customFields, String description, String dueAt, String externalId, List<String> followerIds, String groupId, String hasIncidents, String id2, String organizationId, String priority, String problemId, String rawSubject, String recipient, String requesterId, StatisfactionRating satisfactionRating, List<String> sharingAgreementIds, String status, String subject, String submitterId, List<String> tags, String type, String updatedAt, String url, String channel) {
        Intrinsics.checkNotNullParameter(assigneeId, "");
        Intrinsics.checkNotNullParameter(collaboratorIds, "");
        Intrinsics.checkNotNullParameter(createdAt, "");
        Intrinsics.checkNotNullParameter(customFields, "");
        Intrinsics.checkNotNullParameter(description, "");
        Intrinsics.checkNotNullParameter(dueAt, "");
        Intrinsics.checkNotNullParameter(externalId, "");
        Intrinsics.checkNotNullParameter(followerIds, "");
        Intrinsics.checkNotNullParameter(groupId, "");
        Intrinsics.checkNotNullParameter(hasIncidents, "");
        Intrinsics.checkNotNullParameter(id2, "");
        Intrinsics.checkNotNullParameter(organizationId, "");
        Intrinsics.checkNotNullParameter(priority, "");
        Intrinsics.checkNotNullParameter(problemId, "");
        Intrinsics.checkNotNullParameter(rawSubject, "");
        Intrinsics.checkNotNullParameter(recipient, "");
        Intrinsics.checkNotNullParameter(requesterId, "");
        Intrinsics.checkNotNullParameter(satisfactionRating, "");
        Intrinsics.checkNotNullParameter(sharingAgreementIds, "");
        Intrinsics.checkNotNullParameter(status, "");
        Intrinsics.checkNotNullParameter(subject, "");
        Intrinsics.checkNotNullParameter(submitterId, "");
        Intrinsics.checkNotNullParameter(tags, "");
        Intrinsics.checkNotNullParameter(type, "");
        Intrinsics.checkNotNullParameter(updatedAt, "");
        Intrinsics.checkNotNullParameter(url, "");
        Intrinsics.checkNotNullParameter(channel, "");
        return new ZendeskBasicTicketResult(assigneeId, collaboratorIds, createdAt, customFields, description, dueAt, externalId, followerIds, groupId, hasIncidents, id2, organizationId, priority, problemId, rawSubject, recipient, requesterId, satisfactionRating, sharingAgreementIds, status, subject, submitterId, tags, type, updatedAt, url, channel);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ZendeskBasicTicketResult) {
            ZendeskBasicTicketResult zendeskBasicTicketResult = (ZendeskBasicTicketResult) other;
            return Intrinsics.areEqual(this.assigneeId, zendeskBasicTicketResult.assigneeId) && Intrinsics.areEqual(this.collaboratorIds, zendeskBasicTicketResult.collaboratorIds) && Intrinsics.areEqual(this.createdAt, zendeskBasicTicketResult.createdAt) && Intrinsics.areEqual(this.customFields, zendeskBasicTicketResult.customFields) && Intrinsics.areEqual(this.description, zendeskBasicTicketResult.description) && Intrinsics.areEqual(this.dueAt, zendeskBasicTicketResult.dueAt) && Intrinsics.areEqual(this.externalId, zendeskBasicTicketResult.externalId) && Intrinsics.areEqual(this.followerIds, zendeskBasicTicketResult.followerIds) && Intrinsics.areEqual(this.groupId, zendeskBasicTicketResult.groupId) && Intrinsics.areEqual(this.hasIncidents, zendeskBasicTicketResult.hasIncidents) && Intrinsics.areEqual(this.id, zendeskBasicTicketResult.id) && Intrinsics.areEqual(this.organizationId, zendeskBasicTicketResult.organizationId) && Intrinsics.areEqual(this.priority, zendeskBasicTicketResult.priority) && Intrinsics.areEqual(this.problemId, zendeskBasicTicketResult.problemId) && Intrinsics.areEqual(this.rawSubject, zendeskBasicTicketResult.rawSubject) && Intrinsics.areEqual(this.recipient, zendeskBasicTicketResult.recipient) && Intrinsics.areEqual(this.requesterId, zendeskBasicTicketResult.requesterId) && Intrinsics.areEqual(this.satisfactionRating, zendeskBasicTicketResult.satisfactionRating) && Intrinsics.areEqual(this.sharingAgreementIds, zendeskBasicTicketResult.sharingAgreementIds) && Intrinsics.areEqual(this.status, zendeskBasicTicketResult.status) && Intrinsics.areEqual(this.subject, zendeskBasicTicketResult.subject) && Intrinsics.areEqual(this.submitterId, zendeskBasicTicketResult.submitterId) && Intrinsics.areEqual(this.tags, zendeskBasicTicketResult.tags) && Intrinsics.areEqual(this.type, zendeskBasicTicketResult.type) && Intrinsics.areEqual(this.updatedAt, zendeskBasicTicketResult.updatedAt) && Intrinsics.areEqual(this.url, zendeskBasicTicketResult.url) && Intrinsics.areEqual(this.channel, zendeskBasicTicketResult.channel);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((this.assigneeId.hashCode() * 31) + this.collaboratorIds.hashCode()) * 31) + this.createdAt.hashCode()) * 31) + this.customFields.hashCode()) * 31) + this.description.hashCode()) * 31) + this.dueAt.hashCode()) * 31) + this.externalId.hashCode()) * 31) + this.followerIds.hashCode()) * 31) + this.groupId.hashCode()) * 31) + this.hasIncidents.hashCode()) * 31) + this.id.hashCode()) * 31) + this.organizationId.hashCode()) * 31) + this.priority.hashCode()) * 31) + this.problemId.hashCode()) * 31) + this.rawSubject.hashCode()) * 31) + this.recipient.hashCode()) * 31) + this.requesterId.hashCode()) * 31) + this.satisfactionRating.hashCode()) * 31) + this.sharingAgreementIds.hashCode()) * 31) + this.status.hashCode()) * 31) + this.subject.hashCode()) * 31) + this.submitterId.hashCode()) * 31) + this.tags.hashCode()) * 31) + this.type.hashCode()) * 31) + this.updatedAt.hashCode()) * 31) + this.url.hashCode()) * 31) + this.channel.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ZendeskBasicTicketResult(assigneeId=");
        sb.append(this.assigneeId);
        sb.append(", collaboratorIds=");
        sb.append(this.collaboratorIds);
        sb.append(", createdAt=");
        sb.append(this.createdAt);
        sb.append(", customFields=");
        sb.append(this.customFields);
        sb.append(", description=");
        sb.append(this.description);
        sb.append(", dueAt=");
        sb.append(this.dueAt);
        sb.append(", externalId=");
        sb.append(this.externalId);
        sb.append(", followerIds=");
        sb.append(this.followerIds);
        sb.append(", groupId=");
        sb.append(this.groupId);
        sb.append(", hasIncidents=");
        sb.append(this.hasIncidents);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(", organizationId=");
        sb.append(this.organizationId);
        sb.append(", priority=");
        sb.append(this.priority);
        sb.append(", problemId=");
        sb.append(this.problemId);
        sb.append(", rawSubject=");
        sb.append(this.rawSubject);
        sb.append(", recipient=");
        sb.append(this.recipient);
        sb.append(", requesterId=");
        sb.append(this.requesterId);
        sb.append(", satisfactionRating=");
        sb.append(this.satisfactionRating);
        sb.append(", sharingAgreementIds=");
        sb.append(this.sharingAgreementIds);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", subject=");
        sb.append(this.subject);
        sb.append(", submitterId=");
        sb.append(this.submitterId);
        sb.append(", tags=");
        sb.append(this.tags);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", updatedAt=");
        sb.append(this.updatedAt);
        sb.append(", url=");
        sb.append(this.url);
        sb.append(", channel=");
        sb.append(this.channel);
        sb.append(')');
        return sb.toString();
    }

    public ZendeskBasicTicketResult(String str, List<String> list, String str2, List<CustomFields> list2, String str3, String str4, String str5, List<String> list3, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, StatisfactionRating statisfactionRating, List<String> list4, String str15, String str16, String str17, List<String> list5, String str18, String str19, String str20, String str21) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(list2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(list3, "");
        Intrinsics.checkNotNullParameter(str6, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(str8, "");
        Intrinsics.checkNotNullParameter(str9, "");
        Intrinsics.checkNotNullParameter(str10, "");
        Intrinsics.checkNotNullParameter(str11, "");
        Intrinsics.checkNotNullParameter(str12, "");
        Intrinsics.checkNotNullParameter(str13, "");
        Intrinsics.checkNotNullParameter(str14, "");
        Intrinsics.checkNotNullParameter(statisfactionRating, "");
        Intrinsics.checkNotNullParameter(list4, "");
        Intrinsics.checkNotNullParameter(str15, "");
        Intrinsics.checkNotNullParameter(str16, "");
        Intrinsics.checkNotNullParameter(str17, "");
        Intrinsics.checkNotNullParameter(list5, "");
        Intrinsics.checkNotNullParameter(str18, "");
        Intrinsics.checkNotNullParameter(str19, "");
        Intrinsics.checkNotNullParameter(str20, "");
        Intrinsics.checkNotNullParameter(str21, "");
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
        this.channel = str21;
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

    @JvmName(name = "getChannel")
    public final String getChannel() {
        return this.channel;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/domain/zendesk/model/ZendeskBasicTicketResult$CustomFields;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "value", "getValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class CustomFields {
        private final String id;
        private final String value;

        public CustomFields(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
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

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006"}, d2 = {"Lid/dana/domain/zendesk/model/ZendeskBasicTicketResult$StatisfactionRating;", "", "", DecodedScanBizInfoKey.COMMENT, "Ljava/lang/String;", "getComment", "()Ljava/lang/String;", "id", "getId", FirebaseAnalytics.Param.SCORE, "getScore", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class StatisfactionRating {
        private final String comment;
        private final String id;
        private final String score;

        public StatisfactionRating(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
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
