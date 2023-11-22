package id.dana.data.social.repository.source.persistence.dao;

import id.dana.data.social.repository.source.persistence.entity.ActivityItemEntity;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\b\u0010\u0010\u0011ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/social/repository/source/persistence/dao/ActivityDao;", "", "", "clearActivities", "()V", "", "entityId", "deleteActivity", "(Ljava/lang/String;)V", "", "Lid/dana/data/social/repository/source/persistence/entity/ActivityItemEntity;", "getActivities", "()Ljava/util/List;", "activities", "", "", "insertActivities", "(Ljava/util/List;)[Ljava/lang/Long;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface ActivityDao {
    void clearActivities();

    void deleteActivity(String entityId);

    List<ActivityItemEntity> getActivities();

    Long[] insertActivities(List<ActivityItemEntity> activities);
}
