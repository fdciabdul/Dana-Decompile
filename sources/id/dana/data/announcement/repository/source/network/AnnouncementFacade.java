package id.dana.data.announcement.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.announcement.repository.source.network.request.AnnouncementRequest;
import id.dana.data.announcement.repository.source.network.result.AnnouncementResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/announcement/repository/source/network/AnnouncementFacade;", "", "Lid/dana/data/announcement/repository/source/network/request/AnnouncementRequest;", "announcementRequest", "Lid/dana/data/announcement/repository/source/network/result/AnnouncementResult;", "getAnnouncements", "(Lid/dana/data/announcement/repository/source/network/request/AnnouncementRequest;)Lid/dana/data/announcement/repository/source/network/result/AnnouncementResult;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface AnnouncementFacade {
    @OperationType("alipayplus.mobilewallet.announcement.getAnnouncement")
    @SignCheck
    AnnouncementResult getAnnouncements(AnnouncementRequest announcementRequest);
}
