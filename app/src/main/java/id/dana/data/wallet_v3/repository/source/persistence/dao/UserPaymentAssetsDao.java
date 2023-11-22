package id.dana.data.wallet_v3.repository.source.persistence.dao;

import androidx.sqlite.db.SupportSQLiteQuery;
import id.dana.data.wallet_v3.repository.source.persistence.entity.UserPaymentAssetsDaoEntity;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\b\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\b\u0010\tJ%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&¢\u0006\u0004\b\f\u0010\rJ/\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001a\u001a\u00020\u00192\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0017\"\u00020\u000bH&¢\u0006\u0004\b\u001a\u0010\u001bJ+\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\u0006\u0010\u000e\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u001c\u0010\u001dø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/persistence/dao/UserPaymentAssetsDao;", "", "", "clearUserPaymentAssets", "()V", "", "", "uniqueId", "deleteUserPaymentAssets", "(Ljava/util/List;)V", "assetType", "Lid/dana/data/wallet_v3/repository/source/persistence/entity/UserPaymentAssetsDaoEntity;", "getAllUserPaymentAssets", "(Ljava/util/List;)Ljava/util/List;", "cardTitle", "getFilteredUserPaymentAssets", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "getSavedAssetTypes", "()Ljava/util/List;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "query", "getUserPaymentViaQuery", "(Landroidx/sqlite/db/SupportSQLiteQuery;)Ljava/util/List;", "", "userPaymentAssetsDaoEntities", "", "saveUserPaymentAssets", "([Lid/dana/data/wallet_v3/repository/source/persistence/entity/UserPaymentAssetsDaoEntity;)[J", "searchUserPaymentAssets", "(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface UserPaymentAssetsDao {
    void clearUserPaymentAssets();

    void deleteUserPaymentAssets(List<String> uniqueId);

    List<UserPaymentAssetsDaoEntity> getAllUserPaymentAssets(List<String> assetType);

    List<UserPaymentAssetsDaoEntity> getFilteredUserPaymentAssets(List<String> assetType, String cardTitle);

    List<String> getSavedAssetTypes();

    List<String> getUserPaymentViaQuery(SupportSQLiteQuery query);

    long[] saveUserPaymentAssets(UserPaymentAssetsDaoEntity... userPaymentAssetsDaoEntities);

    List<UserPaymentAssetsDaoEntity> searchUserPaymentAssets(String cardTitle, List<String> assetType);
}
