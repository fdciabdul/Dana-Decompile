package id.dana.data.home.repository.source.presistence.dao;

import id.dana.data.home.repository.source.presistence.entity.PromoBannerAnnouncementDaoEntity;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0016\n\u0000\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u0003\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0003\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H&¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0003\u001a\u00020\r2\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\f\"\u00020\tH&¢\u0006\u0004\b\u0003\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/home/repository/source/presistence/dao/PromoBannerAnnouncementDao;", "", "", "getAuthRequestContext", "()V", "", "", "p0", "(Ljava/util/List;)V", "Lid/dana/data/home/repository/source/presistence/entity/PromoBannerAnnouncementDaoEntity;", "PlaceComponentResult", "()Ljava/util/List;", "", "", "([Lid/dana/data/home/repository/source/presistence/entity/PromoBannerAnnouncementDaoEntity;)[J"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface PromoBannerAnnouncementDao {
    List<PromoBannerAnnouncementDaoEntity> PlaceComponentResult();

    void getAuthRequestContext();

    void getAuthRequestContext(List<String> p0);

    long[] getAuthRequestContext(PromoBannerAnnouncementDaoEntity... p0);
}
