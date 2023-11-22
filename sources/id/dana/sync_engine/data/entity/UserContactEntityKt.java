package id.dana.sync_engine.data.entity;

import id.dana.data.recentcontact.repository.source.persistence.entity.UserContactEntity;
import id.dana.sync_engine.domain.model.UserContact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0006\u001a\u00020\u0000*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/data/recentcontact/repository/source/persistence/entity/UserContactEntity;", "Lid/dana/sync_engine/domain/model/UserContact;", "PlaceComponentResult", "(Lid/dana/data/recentcontact/repository/source/persistence/entity/UserContactEntity;)Lid/dana/sync_engine/domain/model/UserContact;", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sync_engine/domain/model/UserContact;J)Lid/dana/data/recentcontact/repository/source/persistence/entity/UserContactEntity;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UserContactEntityKt {
    public static final UserContact PlaceComponentResult(UserContactEntity userContactEntity) {
        Intrinsics.checkNotNullParameter(userContactEntity, "");
        return new UserContact(userContactEntity.getUid(), userContactEntity.getPhoneNumber(), userContactEntity.getRawPhoneNumber(), userContactEntity.getName(), null, userContactEntity.getUpdatedAt(), userContactEntity.getCreatedAt(), userContactEntity.isDanaUser(), userContactEntity.getDisplayPhoto());
    }

    public static /* synthetic */ UserContactEntity MyBillsEntityDataFactory(UserContact userContact, long j, long j2) {
        Intrinsics.checkNotNullParameter(userContact, "");
        return new UserContactEntity(0L, userContact.NetworkUserEntityData$$ExternalSyntheticLambda0, userContact.lookAheadTest, userContact.scheduleImpl, Long.valueOf(j), Long.valueOf(j2), userContact.BuiltInFictitiousFunctionClassFactory, userContact.getAuthRequestContext);
    }

    public static final UserContactEntity KClassImpl$Data$declaredNonStaticMembers$2(UserContact userContact, long j) {
        Intrinsics.checkNotNullParameter(userContact, "");
        return new UserContactEntity(userContact.KClassImpl$Data$declaredNonStaticMembers$2, userContact.NetworkUserEntityData$$ExternalSyntheticLambda0, userContact.lookAheadTest, userContact.scheduleImpl, Long.valueOf(j), userContact.MyBillsEntityDataFactory, userContact.BuiltInFictitiousFunctionClassFactory, userContact.getAuthRequestContext);
    }
}
