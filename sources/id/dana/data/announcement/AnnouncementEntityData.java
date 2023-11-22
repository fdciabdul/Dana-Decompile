package id.dana.data.announcement;

import id.dana.data.announcement.repository.source.network.result.AnnouncementResult;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J1\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\u0006H&¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\u0006H&¢\u0006\u0004\b\r\u0010\fJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u000e\u001a\u00020\u0002H&¢\u0006\u0004\b\u0012\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/announcement/AnnouncementEntityData;", "", "", "type", "", "extendInfo", "Lio/reactivex/Observable;", "Lid/dana/data/announcement/repository/source/network/result/AnnouncementResult;", "getAnnouncements", "(Ljava/lang/String;Ljava/util/Map;)Lio/reactivex/Observable;", "", "getAnnouncementsIdGNSubscription", "()Lio/reactivex/Observable;", "getTrackedAnnouncementsIdGNSubscription", "id", "", "setAnnouncementIdGNSubscription", "(Ljava/lang/String;)Lio/reactivex/Observable;", "setTrackedAnnouncementIdGNSubscription"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface AnnouncementEntityData {
    Observable<AnnouncementResult> getAnnouncements(String type, Map<String, String> extendInfo);

    Observable<List<String>> getAnnouncementsIdGNSubscription();

    Observable<List<String>> getTrackedAnnouncementsIdGNSubscription();

    Observable<Boolean> setAnnouncementIdGNSubscription(String id2);

    Observable<Boolean> setTrackedAnnouncementIdGNSubscription(String id2);
}
