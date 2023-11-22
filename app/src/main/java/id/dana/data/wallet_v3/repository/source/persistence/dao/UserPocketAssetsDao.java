package id.dana.data.wallet_v3.repository.source.persistence.dao;

import androidx.sqlite.db.SupportSQLiteQuery;
import id.dana.data.wallet_v3.repository.source.persistence.entity.UserPocketAssetsDaoEntity;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ1\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\nH&¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\nH&¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\nH&¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001c\u001a\u00020\u001b2\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u0019\"\u00020\rH&¢\u0006\u0004\b\u001c\u0010\u001dJ9\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\n2\u0006\u0010\u0010\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\nH&¢\u0006\u0004\b\u001e\u0010\u001fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/persistence/dao/UserPocketAssetsDao;", "", "", "clearUserPocketAssets", "()V", "", "pocketId", "", "deleteUserPocketAssets", "(Ljava/lang/String;)I", "", "assetTypes", "statuses", "Lid/dana/data/wallet_v3/repository/source/persistence/entity/UserPocketAssetsDaoEntity;", "getAllUserPocketAssets", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "cardTitle", "getFilteredUserPocketAssets", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;)Ljava/util/List;", "getSavedAssetTypes", "(Ljava/util/List;)Ljava/util/List;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "query", "getUserPocketViaQuery", "(Landroidx/sqlite/db/SupportSQLiteQuery;)Ljava/util/List;", "", "userPocketAssetsDaoEntities", "", "saveUserPocketAssets", "([Lid/dana/data/wallet_v3/repository/source/persistence/entity/UserPocketAssetsDaoEntity;)[J", "searchUserPocketAssets", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Ljava/util/List;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface UserPocketAssetsDao {
    void clearUserPocketAssets();

    int deleteUserPocketAssets(String pocketId);

    List<UserPocketAssetsDaoEntity> getAllUserPocketAssets(List<String> assetTypes, List<String> statuses);

    List<UserPocketAssetsDaoEntity> getFilteredUserPocketAssets(List<String> assetTypes, String cardTitle, List<String> statuses);

    List<String> getSavedAssetTypes(List<String> statuses);

    List<String> getUserPocketViaQuery(SupportSQLiteQuery query);

    long[] saveUserPocketAssets(UserPocketAssetsDaoEntity... userPocketAssetsDaoEntities);

    List<UserPocketAssetsDaoEntity> searchUserPocketAssets(String cardTitle, List<String> assetTypes, List<String> statuses);
}
