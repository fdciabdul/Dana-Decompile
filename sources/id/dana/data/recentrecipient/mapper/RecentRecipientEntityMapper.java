package id.dana.data.recentrecipient.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.recentrecipient.source.persistence.entity.RecentRecipientEntity;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00042\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\t\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/data/recentrecipient/mapper/RecentRecipientEntityMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/data/recentrecipient/source/persistence/entity/RecentRecipientEntity;", "Lid/dana/domain/recentrecipient/model/RecentRecipient;", "", "recentRecipientEntities", "apply", "(Ljava/util/List;)Ljava/util/List;", "oldItem", "map", "(Lid/dana/data/recentrecipient/source/persistence/entity/RecentRecipientEntity;)Lid/dana/domain/recentrecipient/model/RecentRecipient;", "", "storedRecentRecipients", "", "toRecentRecipientEntity", "([Lid/dana/data/recentrecipient/source/persistence/entity/RecentRecipientEntity;)Ljava/util/List;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RecentRecipientEntityMapper extends BaseMapper<RecentRecipientEntity, RecentRecipient> {
    @Inject
    public RecentRecipientEntityMapper() {
    }

    public final List<RecentRecipient> apply(List<RecentRecipientEntity> recentRecipientEntities) {
        if (recentRecipientEntities == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = recentRecipientEntities.iterator();
        while (it.hasNext()) {
            RecentRecipient map = map((RecentRecipientEntity) it.next());
            if (map != null) {
                arrayList.add(map);
            }
        }
        return arrayList;
    }

    public final List<RecentRecipientEntity> toRecentRecipientEntity(RecentRecipientEntity[] storedRecentRecipients) {
        Intrinsics.checkNotNullParameter(storedRecentRecipients, "");
        return (List) ArraysKt.filterNotNullTo(storedRecentRecipients, new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public final RecentRecipient map(RecentRecipientEntity oldItem) {
        if (oldItem != null) {
            return RecentRecipientMapperKt.toRecentRecipient(oldItem);
        }
        return null;
    }
}
