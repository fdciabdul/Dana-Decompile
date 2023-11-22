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
import id.dana.data.social.repository.source.persistence.entity.FollowerItemEntity;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes8.dex */
public final class FollowerDao_Impl implements FollowerDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<FollowerItemEntity> __insertionAdapterOfFollowerItemEntity;
    private final SharedSQLiteStatement __preparedStmtOfClearFollower;
    private final SharedSQLiteStatement __preparedStmtOfUpdateModifiedRelation;

    public FollowerDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfFollowerItemEntity = new EntityInsertionAdapter<FollowerItemEntity>(roomDatabase) { // from class: id.dana.data.social.repository.source.persistence.dao.FollowerDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `FollowerItemEntity` (`userId`,`loginId`,`nickName`,`status`,`gmtCreate`,`gmtModified`,`avatar`,`username`) VALUES (?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, FollowerItemEntity followerItemEntity) {
                FollowerItemEntity followerItemEntity2 = followerItemEntity;
                if (followerItemEntity2.getUserId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, followerItemEntity2.getUserId());
                }
                if (followerItemEntity2.getLoginId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, followerItemEntity2.getLoginId());
                }
                if (followerItemEntity2.getNickName() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, followerItemEntity2.getNickName());
                }
                if (followerItemEntity2.getStatus() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, followerItemEntity2.getStatus());
                }
                supportSQLiteStatement.bindLong(5, followerItemEntity2.getGmtCreate());
                supportSQLiteStatement.bindLong(6, followerItemEntity2.getGmtModified());
                if (followerItemEntity2.getAvatar() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, followerItemEntity2.getAvatar());
                }
                if (followerItemEntity2.getUsername() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, followerItemEntity2.getUsername());
                }
            }
        };
        this.__preparedStmtOfUpdateModifiedRelation = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.social.repository.source.persistence.dao.FollowerDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE FollowerItemEntity SET status = ? WHERE userId = ?";
            }
        };
        this.__preparedStmtOfClearFollower = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.social.repository.source.persistence.dao.FollowerDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM FollowerItemEntity";
            }
        };
    }

    @Override // id.dana.data.social.repository.source.persistence.dao.FollowerDao
    public final Long insertFollowerItem(FollowerItemEntity followerItemEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfFollowerItemEntity.insertAndReturnId(followerItemEntity);
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            return Long.valueOf(insertAndReturnId);
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    @Override // id.dana.data.social.repository.source.persistence.dao.FollowerDao
    public final Long[] insertFollowerItemList(List<FollowerItemEntity> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.__insertionAdapterOfFollowerItemEntity.insertAndReturnIdsArrayBox(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // id.dana.data.social.repository.source.persistence.dao.FollowerDao
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

    @Override // id.dana.data.social.repository.source.persistence.dao.FollowerDao
    public final void clearFollower() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfClearFollower.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfClearFollower.release(acquire);
        }
    }

    @Override // id.dana.data.social.repository.source.persistence.dao.FollowerDao
    public final List<FollowerItemEntity> getFollowerItemEntityList() {
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM FollowerItemEntity ORDER BY nickName ASC", 0);
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
                arrayList.add(new FollowerItemEntity(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5), KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6), KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9)));
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    @Override // id.dana.data.social.repository.source.persistence.dao.FollowerDao
    public final Observable<List<FollowerItemEntity>> getSelectedFollower(String str) {
        final RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM FollowerItemEntity WHERE userId = ?", 1);
        if (str == null) {
            authRequestContext.bindNull(1);
        } else {
            authRequestContext.bindString(1, str);
        }
        return RxRoom.BuiltInFictitiousFunctionClassFactory(this.__db, new String[]{"FollowerItemEntity"}, new Callable<List<FollowerItemEntity>>() { // from class: id.dana.data.social.repository.source.persistence.dao.FollowerDao_Impl.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: merged with bridge method [inline-methods] */
            public List<FollowerItemEntity> call() throws Exception {
                Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(FollowerDao_Impl.this.__db, authRequestContext, false);
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
                        arrayList.add(new FollowerItemEntity(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext3), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5), KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6), KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext7), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8), KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9)));
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
