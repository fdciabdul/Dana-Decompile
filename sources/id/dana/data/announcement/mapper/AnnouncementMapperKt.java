package id.dana.data.announcement.mapper;

import id.dana.data.announcement.model.Announcements;
import id.dana.data.announcement.model.RecurringAnnouncementEntity;
import id.dana.data.announcement.repository.source.network.result.AnnouncementResult;
import id.dana.data.pushverify.mapper.PushVerifyChallengeMapperKt;
import id.dana.data.pushverify.source.model.PushVerifyChallengeResult;
import id.dana.domain.announcement.model.AnnouncementsInfo;
import id.dana.domain.announcement.model.RecurringAnnouncement;
import id.dana.domain.pushverify.model.PushVerifyAnnouncement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\t\u001a\u00020\b*\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u0019\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u000b*\u00020\u0000H\u0002¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/data/announcement/repository/source/network/result/AnnouncementResult;", "Lid/dana/domain/announcement/model/AnnouncementsInfo;", "toAnnouncementsInfo", "(Lid/dana/data/announcement/repository/source/network/result/AnnouncementResult;)Lid/dana/domain/announcement/model/AnnouncementsInfo;", "Lid/dana/domain/pushverify/model/PushVerifyAnnouncement;", "toPushVerifyAnnouncement", "(Lid/dana/data/announcement/repository/source/network/result/AnnouncementResult;)Lid/dana/domain/pushverify/model/PushVerifyAnnouncement;", "Lid/dana/data/announcement/model/RecurringAnnouncementEntity;", "Lid/dana/domain/announcement/model/RecurringAnnouncement;", "toRecurringAnnouncement", "(Lid/dana/data/announcement/model/RecurringAnnouncementEntity;)Lid/dana/domain/announcement/model/RecurringAnnouncement;", "", "toRecurringAnnouncements", "(Lid/dana/data/announcement/repository/source/network/result/AnnouncementResult;)Ljava/util/List;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AnnouncementMapperKt {
    public static final AnnouncementsInfo toAnnouncementsInfo(AnnouncementResult announcementResult) {
        Intrinsics.checkNotNullParameter(announcementResult, "");
        return !announcementResult.success ? new AnnouncementsInfo(null, CollectionsKt.emptyList()) : new AnnouncementsInfo(toPushVerifyAnnouncement(announcementResult), toRecurringAnnouncements(announcementResult));
    }

    private static final List<RecurringAnnouncement> toRecurringAnnouncements(AnnouncementResult announcementResult) {
        List<RecurringAnnouncementEntity> recurringAnnouncement;
        Announcements announcements = announcementResult.getAnnouncements();
        if (announcements == null || (recurringAnnouncement = announcements.getRecurringAnnouncement()) == null) {
            return CollectionsKt.emptyList();
        }
        List<RecurringAnnouncementEntity> list = recurringAnnouncement;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(toRecurringAnnouncement((RecurringAnnouncementEntity) it.next()));
        }
        return arrayList;
    }

    private static final PushVerifyAnnouncement toPushVerifyAnnouncement(AnnouncementResult announcementResult) {
        List<PushVerifyChallengeResult> pushVerifyAnnouncement;
        Announcements announcements = announcementResult.getAnnouncements();
        if (announcements == null || (pushVerifyAnnouncement = announcements.getPushVerifyAnnouncement()) == null) {
            return null;
        }
        return PushVerifyChallengeMapperKt.toPushVerifyAnnouncement(pushVerifyAnnouncement);
    }

    private static final RecurringAnnouncement toRecurringAnnouncement(RecurringAnnouncementEntity recurringAnnouncementEntity) {
        return new RecurringAnnouncement(recurringAnnouncementEntity.getSubscriptionId(), recurringAnnouncementEntity.getTitle(), recurringAnnouncementEntity.getSubtitle(), recurringAnnouncementEntity.getWidgetType(), recurringAnnouncementEntity.getExpirationDate(), recurringAnnouncementEntity.getGmtCreate(), recurringAnnouncementEntity.getSubMerchantId(), recurringAnnouncementEntity.getGoodsName(), recurringAnnouncementEntity.getGoodsType(), recurringAnnouncementEntity.getSubscriptionDueDate(), recurringAnnouncementEntity.getPaymentStatus(), recurringAnnouncementEntity.getTotalAmount(), recurringAnnouncementEntity.getExtInfo());
    }
}
