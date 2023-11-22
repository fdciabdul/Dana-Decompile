package id.dana.data.wallet_v3.repository.source.persistence.dao;

import androidx.sqlite.db.SupportSQLiteQuery;
import id.dana.data.wallet_v3.repository.source.persistence.entity.KtpDaoEntity;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0005H&¢\u0006\u0004\b\u000e\u0010\bJ#\u0010\u0012\u001a\u00020\u00112\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u000f\"\u00020\rH&¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u0010\u0014\u001a\u00020\u0006H&¢\u0006\u0004\b\u0015\u0010\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/wallet_v3/repository/source/persistence/dao/UserIdentityAssetsDao;", "", "", "clearUserIdentityAssets", "()V", "", "", "getSavedAssetTypes", "()Ljava/util/List;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "query", "getUserIdentityViaQuery", "(Landroidx/sqlite/db/SupportSQLiteQuery;)Ljava/util/List;", "Lid/dana/data/wallet_v3/repository/source/persistence/entity/KtpDaoEntity;", "getUserKtpAssets", "", "ktpDaoEntity", "", "saveUserKtpAssets", "([Lid/dana/data/wallet_v3/repository/source/persistence/entity/KtpDaoEntity;)[J", "cardTitle", "searchUserIdentityAssets", "(Ljava/lang/String;)Ljava/util/List;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface UserIdentityAssetsDao {
    void clearUserIdentityAssets();

    List<String> getSavedAssetTypes();

    List<String> getUserIdentityViaQuery(SupportSQLiteQuery query);

    List<KtpDaoEntity> getUserKtpAssets();

    long[] saveUserKtpAssets(KtpDaoEntity... ktpDaoEntity);

    List<KtpDaoEntity> searchUserIdentityAssets(String cardTitle);
}
