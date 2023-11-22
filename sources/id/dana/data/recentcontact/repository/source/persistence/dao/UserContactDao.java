package id.dana.data.recentcontact.repository.source.persistence.dao;

import id.dana.data.here.model.HereUrlConstant;
import id.dana.data.recentcontact.repository.source.persistence.entity.UserContactEntity;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H'¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH'J\u0016\u0010\n\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH'J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H'J7\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0010H'¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0010H'J\b\u0010\u0017\u001a\u00020\tH'J!\u0010\u0018\u001a\u00020\u00102\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H'¢\u0006\u0002\u0010\u0019ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Lid/dana/data/recentcontact/repository/source/persistence/dao/UserContactDao;", "", "addContacts", "", "entities", "", "Lid/dana/data/recentcontact/repository/source/persistence/entity/UserContactEntity;", "([Lid/dana/data/recentcontact/repository/source/persistence/entity/UserContactEntity;)[J", "clearAll", "", "deleteContacts", "uidList", "", "", "getContacts", HereUrlConstant.LIMIT, "", "offset", "getContactsByType", "isDana", "counter", "(IILjava/lang/Integer;I)Ljava/util/List;", "getCountContacts", "resetAll", "updateContacts", "([Lid/dana/data/recentcontact/repository/source/persistence/entity/UserContactEntity;)I", "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface UserContactDao {
    long[] addContacts(UserContactEntity... entities);

    void clearAll();

    void deleteContacts(List<Long> uidList);

    List<UserContactEntity> getContacts(int limit, int offset);

    List<UserContactEntity> getContactsByType(int limit, int offset, Integer isDana, int counter);

    int getCountContacts();

    void resetAll();

    int updateContacts(UserContactEntity... entities);

    /* renamed from: id.dana.data.recentcontact.repository.source.persistence.dao.UserContactDao$-CC  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ List getContactsByType$default(UserContactDao userContactDao, int i, int i2, Integer num, int i3, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 8) != 0) {
                    i3 = 0;
                }
                return userContactDao.getContactsByType(i, i2, num, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContactsByType");
        }
    }
}
