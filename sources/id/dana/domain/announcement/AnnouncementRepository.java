package id.dana.domain.announcement;

import id.dana.domain.announcement.model.AnnouncementsInfo;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\r\u0010\u0006J\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00022\u0006\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00022\u0006\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/announcement/AnnouncementRepository;", "", "Lio/reactivex/Observable;", "", "", "getAnnouncementGnIds", "()Lio/reactivex/Observable;", "type", "", "extendInfo", "Lid/dana/domain/announcement/model/AnnouncementsInfo;", "getAnnouncements", "(Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "getTrackedAnnouncementsGnId", "id", "", "saveAnnouncementGnId", "(Ljava/lang/String;)Lio/reactivex/Observable;", "saveTrackedAnnouncementGnId"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AnnouncementRepository {
    Observable<List<String>> getAnnouncementGnIds();

    Observable<AnnouncementsInfo> getAnnouncements(String type, Map<String, String> extendInfo);

    Observable<List<String>> getTrackedAnnouncementsGnId();

    Observable<Boolean> saveAnnouncementGnId(String id2);

    Observable<Boolean> saveTrackedAnnouncementGnId(String id2);
}
