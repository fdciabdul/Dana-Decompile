package id.dana.data.social.repository.source.persistence.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.social.repository.source.persistence.entity.FollowingItemEntity;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes8.dex */
public final class FollowingDao_Impl implements FollowingDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<FollowingItemEntity> __insertionAdapterOfFollowingItemEntity;
    private final SharedSQLiteStatement __preparedStmtOfClearFollowing;
    private final SharedSQLiteStatement __preparedStmtOfUpdateModifiedRelation;

    public FollowingDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfFollowingItemEntity = new EntityInsertionAdapter<FollowingItemEntity>(roomDatabase) { // from class: id.dana.data.social.repository.source.persistence.dao.FollowingDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `FollowingItemEntity` (`userId`,`loginId`,`nickName`,`status`,`gmtCreate`,`gmtModified`,`avatar`,`username`) VALUES (?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, FollowingItemEntity followingItemEntity) {
                FollowingItemEntity followingItemEntity2 = followingItemEntity;
                if (followingItemEntity2.getUserId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, followingItemEntity2.getUserId());
                }
                if (followingItemEntity2.getLoginId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, followingItemEntity2.getLoginId());
                }
                if (followingItemEntity2.getNickName() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, followingItemEntity2.getNickName());
                }
                if (followingItemEntity2.getStatus() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, followingItemEntity2.getStatus());
                }
                supportSQLiteStatement.bindLong(5, followingItemEntity2.getGmtCreate());
                supportSQLiteStatement.bindLong(6, followingItemEntity2.getGmtModified());
                if (followingItemEntity2.getAvatar() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, followingItemEntity2.getAvatar());
                }
                if (followingItemEntity2.getUsername() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, followingItemEntity2.getUsername());
                }
            }
        };
        this.__preparedStmtOfUpdateModifiedRelation = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.social.repository.source.persistence.dao.FollowingDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE FollowingItemEntity SET status = ? WHERE userId = ?";
            }
        };
        this.__preparedStmtOfClearFollowing = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.social.repository.source.persistence.dao.FollowingDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM FollowingItemEntity";
            }
        };
    }

    @Override // id.dana.data.social.repository.source.persistence.dao.FollowingDao
    public final void insertFollowingItem(FollowingItemEntity followingItemEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfFollowingItemEntity.insert((EntityInsertionAdapter<FollowingItemEntity>) followingItemEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // id.dana.data.social.repository.source.persistence.dao.FollowingDao
    public final void insertFollowingItemList(List<FollowingItemEntity> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfFollowingItemEntity.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // id.dana.data.social.repository.source.persistence.dao.FollowingDao
    public final void updateModifiedRelation(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateModifiedRelation.acquire();
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateModifiedRelation.release(acquire);
        }
    }

    @Override // id.dana.data.social.repository.source.persistence.dao.FollowingDao
    public final void clearFollowing() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfClearFollowing.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfClearFollowing.release(acquire);
        }
    }

    @Override // id.dana.data.social.repository.source.persistence.dao.FollowingDao
    public final List<FollowingItemEntity> getFollowingItemEntityList() {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM FollowingItemEntity ORDER BY nickName ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "userId");
            int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BranchLinkConstant.Params.LOGIN_ID);
            int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "nickName");
            int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "status");
            int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "gmtCreate");
            int authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "gmtModified");
            int authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "avatar");
            int authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "username");
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                arrayList.add(new FollowingItemEntity(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5), KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6), KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9)));
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.data.social.repository.source.persistence.dao.FollowingDao
    public final Observable<List<FollowingItemEntity>> getSelectedFollowing(String str) {
        final RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM FollowingItemEntity WHERE userId = ?", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        return RxRoom.BuiltInFictitiousFunctionClassFactory(this.__db, new String[]{"FollowingItemEntity"}, new Callable<List<FollowingItemEntity>>() { // from class: id.dana.data.social.repository.source.persistence.dao.FollowingDao_Impl.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: PlaceComponentResult  reason: merged with bridge method [inline-methods] */
            public List<FollowingItemEntity> call() throws Exception {
                Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(FollowingDao_Impl.this.__db, authRequestContext, false);
                try {
                    int authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "userId");
                    int authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, BranchLinkConstant.Params.LOGIN_ID);
                    int authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "nickName");
                    int authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "status");
                    int authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "gmtCreate");
                    int authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "gmtModified");
                    int authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "avatar");
                    int authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "username");
                    ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
                    while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                        arrayList.add(new FollowingItemEntity(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5), KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6), KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9)));
                    }
                    return arrayList;
                } finally {
                    KClassImpl$Data$declaredNonStaticMembers$2.close();
                }
            }

            protected void finalize() {
                authRequestContext.MyBillsEntityDataFactory();
            }
        });
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
