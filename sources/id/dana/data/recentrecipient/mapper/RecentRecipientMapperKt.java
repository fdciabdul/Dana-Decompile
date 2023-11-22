package id.dana.data.recentrecipient.mapper;

import id.dana.data.recentbank.repository.source.persistance.entity.SecureRecentBankEntity;
import id.dana.data.recentrecipient.source.persistence.entity.RecentRecipientEntity;
import id.dana.domain.recentrecipient.model.RecentRecipient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t*\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\r\u001a\u00020\f*\u00020\u0003¢\u0006\u0004\b\r\u0010\u000e\u001a\u0011\u0010\u000f\u001a\u00020\u0003*\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\t*\b\u0012\u0004\u0012\u00020\f0\t¢\u0006\u0004\b\u0011\u0010\u000b\u001a\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\t*\b\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0004\b\u0012\u0010\u000b"}, d2 = {"", "fixTimeFormat", "(J)J", "Lid/dana/data/recentrecipient/source/persistence/entity/RecentRecipientEntity;", "mapLastUpdated", "(Lid/dana/data/recentrecipient/source/persistence/entity/RecentRecipientEntity;)J", "Lid/dana/data/recentbank/repository/source/persistance/entity/SecureRecentBankEntity;", "toRecentBankRecipientEntity", "(Lid/dana/data/recentrecipient/source/persistence/entity/RecentRecipientEntity;)Lid/dana/data/recentbank/repository/source/persistance/entity/SecureRecentBankEntity;", "", "toRecentBankRecipientList", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/domain/recentrecipient/model/RecentRecipient;", "toRecentRecipient", "(Lid/dana/data/recentrecipient/source/persistence/entity/RecentRecipientEntity;)Lid/dana/domain/recentrecipient/model/RecentRecipient;", "toRecentRecipientEntity", "(Lid/dana/domain/recentrecipient/model/RecentRecipient;)Lid/dana/data/recentrecipient/source/persistence/entity/RecentRecipientEntity;", "toRecentRecipientEntityList", "toRecentRecipientList"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RecentRecipientMapperKt {
    public static final List<SecureRecentBankEntity> toRecentBankRecipientList(List<RecentRecipientEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<RecentRecipientEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toRecentBankRecipientEntity((RecentRecipientEntity) it.next()));
        }
        return arrayList;
    }

    public static final SecureRecentBankEntity toRecentBankRecipientEntity(RecentRecipientEntity recentRecipientEntity) {
        Intrinsics.checkNotNullParameter(recentRecipientEntity, "");
        return new SecureRecentBankEntity(recentRecipientEntity.getRecipientName(), recentRecipientEntity.getInstLocalName(), recentRecipientEntity.getNumber(), recentRecipientEntity.getImageUrl(), recentRecipientEntity.getLastUpdated(), recentRecipientEntity.getAlias(), recentRecipientEntity.getId(), recentRecipientEntity.getInstLocalName(), recentRecipientEntity.getPayMethod(), recentRecipientEntity.getPayOption(), recentRecipientEntity.getSenderName(), recentRecipientEntity.getCardIndexNo(), recentRecipientEntity.getPrefix(), recentRecipientEntity.getTransactionCount(), recentRecipientEntity.getIsFavorite());
    }

    public static final List<RecentRecipient> toRecentRecipientList(List<RecentRecipientEntity> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<RecentRecipientEntity> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toRecentRecipient((RecentRecipientEntity) it.next()));
        }
        return arrayList;
    }

    public static final RecentRecipient toRecentRecipient(RecentRecipientEntity recentRecipientEntity) {
        Intrinsics.checkNotNullParameter(recentRecipientEntity, "");
        RecentRecipient recentRecipient = new RecentRecipient();
        recentRecipient.setId(recentRecipientEntity.getId());
        recentRecipient.setAlias(recentRecipientEntity.getAlias());
        recentRecipient.setCardIndexNo(recentRecipientEntity.getCardIndexNo());
        recentRecipient.setImageUrl(recentRecipientEntity.getImageUrl());
        recentRecipient.setInstLocalName(recentRecipientEntity.getInstLocalName());
        recentRecipient.setLastUpdated(fixTimeFormat(mapLastUpdated(recentRecipientEntity)));
        recentRecipient.setName(recentRecipientEntity.getName());
        recentRecipient.setNumber(recentRecipientEntity.getNumber());
        recentRecipient.setFormattedMaskNumber(recentRecipientEntity.getNumber());
        recentRecipient.setPayMethod(recentRecipientEntity.getPayMethod());
        recentRecipient.setPayOption(recentRecipientEntity.getPayOption());
        recentRecipient.setRecipientName(recentRecipientEntity.getRecipientName());
        recentRecipient.setSenderName(recentRecipientEntity.getSenderName());
        recentRecipient.setPrefix(recentRecipientEntity.getPrefix());
        recentRecipient.setTransactionCount(recentRecipientEntity.getTransactionCount());
        recentRecipient.setType(recentRecipientEntity.getType());
        recentRecipient.setFavorite(recentRecipientEntity.getIsFavorite());
        recentRecipient.setParticipantCount(recentRecipientEntity.getParticipantCount());
        return recentRecipient;
    }

    private static final long mapLastUpdated(RecentRecipientEntity recentRecipientEntity) {
        if (recentRecipientEntity.getLastUpdated() == 0 || recentRecipientEntity.getLastUpdateTime() > recentRecipientEntity.getLastUpdated()) {
            return recentRecipientEntity.getLastUpdateTime();
        }
        return recentRecipientEntity.getLastUpdated();
    }

    private static final long fixTimeFormat(long j) {
        Long valueOf = Long.valueOf(j);
        long longValue = valueOf.longValue();
        boolean z = false;
        if (1 <= longValue && longValue < 10000000000L) {
            z = true;
        }
        if (z) {
            valueOf = null;
        }
        return valueOf != null ? valueOf.longValue() : j * 1000;
    }

    public static final List<RecentRecipientEntity> toRecentRecipientEntityList(List<? extends RecentRecipient> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<? extends RecentRecipient> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toRecentRecipientEntity((RecentRecipient) it.next()));
        }
        return arrayList;
    }

    public static final RecentRecipientEntity toRecentRecipientEntity(RecentRecipient recentRecipient) {
        Intrinsics.checkNotNullParameter(recentRecipient, "");
        return new RecentRecipientEntity(null, recentRecipient.getAlias(), recentRecipient.getId(), recentRecipient.getImageUrl(), recentRecipient.getInstLocalName(), recentRecipient.getLastUpdated(), recentRecipient.getLastUpdated(), recentRecipient.getName(), recentRecipient.getNumber(), recentRecipient.getRecipientName(), recentRecipient.getSenderName(), recentRecipient.getPayMethod(), recentRecipient.getPayOption(), recentRecipient.getCardIndexNo(), recentRecipient.getPrefix(), recentRecipient.getTransactionCount(), recentRecipient.isFavorite(), recentRecipient.getType(), recentRecipient.getParticipantCount(), 1, null);
    }
}
