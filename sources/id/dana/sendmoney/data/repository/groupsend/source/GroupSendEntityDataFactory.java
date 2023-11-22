package id.dana.sendmoney.data.repository.groupsend.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.sendmoney.di.scope.GroupSendScope;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@GroupSendScope
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\b"}, d2 = {"Lid/dana/sendmoney/data/repository/groupsend/source/GroupSendEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/sendmoney/data/repository/groupsend/source/GroupSendEntityData;", "", "p0", "PlaceComponentResult", "(Ljava/lang/String;)Lid/dana/sendmoney/data/repository/groupsend/source/GroupSendEntityData;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/data/repository/groupsend/source/GroupSendEntityData;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "p2", "<init>", "(Lid/dana/sendmoney/data/repository/groupsend/source/GroupSendEntityData;Lid/dana/sendmoney/data/repository/groupsend/source/GroupSendEntityData;Lid/dana/sendmoney/data/repository/groupsend/source/GroupSendEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupSendEntityDataFactory extends AbstractEntityDataFactory<GroupSendEntityData> {
    private final GroupSendEntityData KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final GroupSendEntityData PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GroupSendEntityData MyBillsEntityDataFactory;

    @Inject
    public GroupSendEntityDataFactory(GroupSendEntityData groupSendEntityData, GroupSendEntityData groupSendEntityData2, GroupSendEntityData groupSendEntityData3) {
        Intrinsics.checkNotNullParameter(groupSendEntityData, "");
        Intrinsics.checkNotNullParameter(groupSendEntityData2, "");
        Intrinsics.checkNotNullParameter(groupSendEntityData3, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = groupSendEntityData;
        this.PlaceComponentResult = groupSendEntityData2;
        this.MyBillsEntityDataFactory = groupSendEntityData3;
    }

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
    public final GroupSendEntityData createData2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        int hashCode = p0.hashCode();
        if (hashCode != 103145323) {
            if (hashCode != 109648666) {
                if (hashCode == 1843485230 && p0.equals("network")) {
                    return this.MyBillsEntityDataFactory;
                }
            } else if (p0.equals("split")) {
                return this.KClassImpl$Data$declaredNonStaticMembers$2;
            }
        } else if (p0.equals("local")) {
            return this.PlaceComponentResult;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unknown source ");
        sb.append(p0);
        throw new IllegalArgumentException(sb.toString());
    }
}
