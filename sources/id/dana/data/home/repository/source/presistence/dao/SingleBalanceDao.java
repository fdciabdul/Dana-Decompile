package id.dana.data.home.repository.source.presistence.dao;

import id.dana.data.home.repository.source.presistence.entity.SingleBalanceDaoEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0016\n\u0000\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ#\u0010\b\u001a\u00020\u000b2\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\n\"\u00020\u0007H&¢\u0006\u0004\b\b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/home/repository/source/presistence/dao/SingleBalanceDao;", "", "", "PlaceComponentResult", "()V", "", "p0", "Lid/dana/data/home/repository/source/presistence/entity/SingleBalanceDaoEntity;", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Lid/dana/data/home/repository/source/presistence/entity/SingleBalanceDaoEntity;", "", "", "([Lid/dana/data/home/repository/source/presistence/entity/SingleBalanceDaoEntity;)[J"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface SingleBalanceDao {
    SingleBalanceDaoEntity MyBillsEntityDataFactory(String p0);

    long[] MyBillsEntityDataFactory(SingleBalanceDaoEntity... p0);

    void PlaceComponentResult();
}
