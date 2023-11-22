package id.dana.data.sendmoney.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017BI\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/data/sendmoney/repository/source/network/request/BizGroupModifyEntityRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "bizType", "Ljava/lang/String;", "getBizType", "()Ljava/lang/String;", "changeType", "getChangeType", "groupId", "getGroupId", "groupLogo", "getGroupLogo", "groupName", "getGroupName", "", "Lid/dana/data/sendmoney/repository/source/network/request/ParticipantModifyEntity;", "participants", "Ljava/util/List;", "getParticipants", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BizGroupModifyEntityRequest extends BaseRpcRequest {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String bizType;
    private final String changeType;
    private final String groupId;
    private final String groupLogo;
    private final String groupName;
    private final List<ParticipantModifyEntity> participants;

    public /* synthetic */ BizGroupModifyEntityRequest(String str, String str2, String str3, String str4, String str5, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : list);
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "getGroupId")
    public final String getGroupId() {
        return this.groupId;
    }

    @JvmName(name = "getChangeType")
    public final String getChangeType() {
        return this.changeType;
    }

    @JvmName(name = "getGroupName")
    public final String getGroupName() {
        return this.groupName;
    }

    @JvmName(name = "getGroupLogo")
    public final String getGroupLogo() {
        return this.groupLogo;
    }

    @JvmName(name = "getParticipants")
    public final List<ParticipantModifyEntity> getParticipants() {
        return this.participants;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/sendmoney/repository/source/network/request/BizGroupModifyEntityRequest$Companion;", "", "", "groupId", "Lid/dana/data/sendmoney/repository/source/network/request/BizGroupModifyEntityRequest;", "createBizGroupModifyRequest", "(Ljava/lang/String;)Lid/dana/data/sendmoney/repository/source/network/request/BizGroupModifyEntityRequest;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BizGroupModifyEntityRequest createBizGroupModifyRequest(String groupId) {
            Intrinsics.checkNotNullParameter(groupId, "");
            return new BizGroupModifyEntityRequest("GROUP_TRANSFER", groupId, "REMOVE_GROUP", null, null, null, 56, null);
        }
    }

    public BizGroupModifyEntityRequest(String str, String str2, String str3, String str4, String str5, List<ParticipantModifyEntity> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.bizType = str;
        this.groupId = str2;
        this.changeType = str3;
        this.groupName = str4;
        this.groupLogo = str5;
        this.participants = list;
    }
}
