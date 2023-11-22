package id.dana.data.recentrecipient.mapper;

import id.dana.data.recentrecipient.source.persistence.entity.RecentRecipientEntity;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/data/recentrecipient/mapper/RecentRecipientEntityArrayMapper;", "", "Lid/dana/domain/recentrecipient/model/RecentRecipient;", "recentRecipient", "Lid/dana/data/recentrecipient/source/persistence/entity/RecentRecipientEntity;", "toRecentRecipientEntity", "(Lid/dana/domain/recentrecipient/model/RecentRecipient;)Lid/dana/data/recentrecipient/source/persistence/entity/RecentRecipientEntity;", "", "recentRecipients", "", "toRecentRecipientEntityArray", "(Ljava/util/List;)[Lid/dana/data/recentrecipient/source/persistence/entity/RecentRecipientEntity;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class RecentRecipientEntityArrayMapper {
    public static final RecentRecipientEntityArrayMapper INSTANCE = new RecentRecipientEntityArrayMapper();

    private RecentRecipientEntityArrayMapper() {
    }

    public final RecentRecipientEntity[] toRecentRecipientEntityArray(List<? extends RecentRecipient> recentRecipients) {
        Intrinsics.checkNotNullParameter(recentRecipients, "");
        int size = recentRecipients.size();
        RecentRecipientEntity[] recentRecipientEntityArr = new RecentRecipientEntity[size];
        if ((!recentRecipients.isEmpty()) != false) {
            for (int i = 0; i < size; i++) {
                recentRecipientEntityArr[i] = toRecentRecipientEntity(recentRecipients.get(i));
            }
            return (RecentRecipientEntity[]) ArraysKt.requireNoNulls(recentRecipientEntityArr);
        }
        return new RecentRecipientEntity[0];
    }

    private final RecentRecipientEntity toRecentRecipientEntity(RecentRecipient recentRecipient) {
        String str = null;
        RecentRecipientEntity recentRecipientEntity = new RecentRecipientEntity(null, null, null, null, null, 0L, 0L, null, null, null, null, null, str, str, null, 0, false, 0, null, 524287, null);
        recentRecipientEntity.setId(recentRecipient.getId());
        recentRecipientEntity.setAlias(recentRecipient.getAlias());
        recentRecipientEntity.setCardIndexNo(recentRecipient.getCardIndexNo());
        recentRecipientEntity.setImageUrl(recentRecipient.getImageUrl());
        recentRecipientEntity.setInstLocalName(recentRecipient.getInstLocalName());
        recentRecipientEntity.setLastUpdated(recentRecipient.getLastUpdated());
        recentRecipientEntity.setName(recentRecipient.getName());
        recentRecipientEntity.setNumber(recentRecipient.getNumber());
        recentRecipientEntity.setPayMethod(recentRecipient.getPayMethod());
        recentRecipientEntity.setPayOption(recentRecipient.getPayOption());
        recentRecipientEntity.setRecipientName(recentRecipient.getRecipientName());
        recentRecipientEntity.setSenderName(recentRecipient.getSenderName());
        recentRecipientEntity.setType(recentRecipient.getType());
        recentRecipientEntity.setPrefix(recentRecipient.getPrefix());
        recentRecipientEntity.setTransactionCount(recentRecipient.getTransactionCount());
        return recentRecipientEntity;
    }
}
