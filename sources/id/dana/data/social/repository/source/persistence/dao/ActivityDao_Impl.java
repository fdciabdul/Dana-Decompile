package id.dana.data.social.repository.source.persistence.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.data.base.MapConverter;
import id.dana.data.base.StringConverter;
import id.dana.data.social.repository.source.persistence.entity.ActivityItemEntity;
import id.dana.domain.social.ExtendInfoUtilKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public final class ActivityDao_Impl implements ActivityDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ActivityItemEntity> __insertionAdapterOfActivityItemEntity;
    private final SharedSQLiteStatement __preparedStmtOfClearActivities;
    private final SharedSQLiteStatement __preparedStmtOfDeleteActivity;
    private final MapConverter __mapConverter = new MapConverter();
    private final StringConverter __stringConverter = new StringConverter();

    public ActivityDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfActivityItemEntity = new EntityInsertionAdapter<ActivityItemEntity>(roomDatabase) { // from class: id.dana.data.social.repository.source.persistence.dao.ActivityDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `ActivityItemEntity` (`entityId`,`activityId`,`commentCounts`,`content`,`caption`,`createdTime`,`extendInfo`,`iconUrl`,`id`,`imageUrls`,`ownActivity`,`read`,`redirectType`,`redirectValue`,`widget`,`latestComments`,`ownComments`,`ownReactions`,`reactionCounts`,`groupName`,`groupId`,`groupActorCount`,`state`,`isSubmitFeedBanner`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, ActivityItemEntity activityItemEntity) {
                ActivityItemEntity activityItemEntity2 = activityItemEntity;
                if (activityItemEntity2.getEntityId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, activityItemEntity2.getEntityId());
                }
                if (activityItemEntity2.getActivityId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, activityItemEntity2.getActivityId());
                }
                if (activityItemEntity2.getCommentCounts() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindLong(3, activityItemEntity2.getCommentCounts().intValue());
                }
                if (activityItemEntity2.getContent() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, activityItemEntity2.getContent());
                }
                if (activityItemEntity2.getCaption() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, activityItemEntity2.getCaption());
                }
                if (activityItemEntity2.getCreatedTime() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindLong(6, activityItemEntity2.getCreatedTime().longValue());
                }
                String fromStringMap = ActivityDao_Impl.this.__mapConverter.fromStringMap(activityItemEntity2.getExtendInfo());
                if (fromStringMap == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, fromStringMap);
                }
                if (activityItemEntity2.getIconUrl() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, activityItemEntity2.getIconUrl());
                }
                if (activityItemEntity2.getId() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, activityItemEntity2.getId());
                }
                String fromList = ActivityDao_Impl.this.__stringConverter.fromList(activityItemEntity2.getImageUrls());
                if (fromList == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, fromList);
                }
                if ((activityItemEntity2.getOwnActivity() == null ? null : Integer.valueOf(activityItemEntity2.getOwnActivity().booleanValue() ? 1 : 0)) == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindLong(11, r0.intValue());
                }
                if ((activityItemEntity2.getRead() == null ? null : Integer.valueOf(activityItemEntity2.getRead().booleanValue() ? 1 : 0)) == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindLong(12, r0.intValue());
                }
                if (activityItemEntity2.getRedirectType() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, activityItemEntity2.getRedirectType());
                }
                if (activityItemEntity2.getRedirectValue() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, activityItemEntity2.getRedirectValue());
                }
                if (activityItemEntity2.getWidget() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, activityItemEntity2.getWidget());
                }
                if (activityItemEntity2.getLatestComments() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, activityItemEntity2.getLatestComments());
                }
                if (activityItemEntity2.getOwnComments() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, activityItemEntity2.getOwnComments());
                }
                if (activityItemEntity2.getOwnReactions() == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindString(18, activityItemEntity2.getOwnReactions());
                }
                if (activityItemEntity2.getReactionCounts() == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindString(19, activityItemEntity2.getReactionCounts());
                }
                if (activityItemEntity2.getGroupName() == null) {
                    supportSQLiteStatement.bindNull(20);
                } else {
                    supportSQLiteStatement.bindString(20, activityItemEntity2.getGroupName());
                }
                if (activityItemEntity2.getGroupId() == null) {
                    supportSQLiteStatement.bindNull(21);
                } else {
                    supportSQLiteStatement.bindString(21, activityItemEntity2.getGroupId());
                }
                if (activityItemEntity2.getGroupActorCount() == null) {
                    supportSQLiteStatement.bindNull(22);
                } else {
                    supportSQLiteStatement.bindLong(22, activityItemEntity2.getGroupActorCount().intValue());
                }
                if (activityItemEntity2.getState() == null) {
                    supportSQLiteStatement.bindNull(23);
                } else {
                    supportSQLiteStatement.bindString(23, activityItemEntity2.getState());
                }
                if ((activityItemEntity2.isSubmitFeedBanner() != null ? Integer.valueOf(activityItemEntity2.isSubmitFeedBanner().booleanValue() ? 1 : 0) : null) == null) {
                    supportSQLiteStatement.bindNull(24);
                } else {
                    supportSQLiteStatement.bindLong(24, r1.intValue());
                }
            }
        };
        this.__preparedStmtOfClearActivities = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.social.repository.source.persistence.dao.ActivityDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM ActivityItemEntity";
            }
        };
        this.__preparedStmtOfDeleteActivity = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.social.repository.source.persistence.dao.ActivityDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM ActivityItemEntity WHERE entityId = ?";
            }
        };
    }

    @Override // id.dana.data.social.repository.source.persistence.dao.ActivityDao
    public final Long[] insertActivities(List<ActivityItemEntity> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            Long[] insertAndReturnIdsArrayBox = this.__insertionAdapterOfActivityItemEntity.insertAndReturnIdsArrayBox(list);
            this.__db.setTransactionSuccessful();
            return insertAndReturnIdsArrayBox;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // id.dana.data.social.repository.source.persistence.dao.ActivityDao
    public final void clearActivities() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfClearActivities.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfClearActivities.release(acquire);
        }
    }

    @Override // id.dana.data.social.repository.source.persistence.dao.ActivityDao
    public final void deleteActivity(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteActivity.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteActivity.release(acquire);
        }
    }

    @Override // id.dana.data.social.repository.source.persistence.dao.ActivityDao
    public final List<ActivityItemEntity> getActivities() {
        RoomSQLiteQuery roomSQLiteQuery;
        int authRequestContext;
        int authRequestContext2;
        int authRequestContext3;
        int authRequestContext4;
        int authRequestContext5;
        int authRequestContext6;
        int authRequestContext7;
        int authRequestContext8;
        int authRequestContext9;
        int authRequestContext10;
        int authRequestContext11;
        int authRequestContext12;
        int authRequestContext13;
        String string;
        int i;
        Boolean valueOf;
        Boolean valueOf2;
        int i2;
        int i3;
        String string2;
        String string3;
        int i4;
        String string4;
        int i5;
        String string5;
        int i6;
        String string6;
        int i7;
        String string7;
        int i8;
        String string8;
        int i9;
        String string9;
        int i10;
        String string10;
        int i11;
        Integer valueOf3;
        int i12;
        String string11;
        int i13;
        RoomSQLiteQuery authRequestContext14 = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM ActivityItemEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$2 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext14, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "entityId");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID);
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "commentCounts");
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "content");
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "caption");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "createdTime");
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "extendInfo");
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "iconUrl");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "id");
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "imageUrls");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "ownActivity");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "read");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "redirectType");
            roomSQLiteQuery = authRequestContext14;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext14;
        }
        try {
            int authRequestContext15 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, ShareToFeedBridge.REDIRECT_VALUE);
            int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, ShareToFeedBridge.WIDGET);
            int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "latestComments");
            int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "ownComments");
            int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "ownReactions");
            int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "reactionCounts");
            int authRequestContext21 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "groupName");
            int authRequestContext22 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "groupId");
            int authRequestContext23 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "groupActorCount");
            int authRequestContext24 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "state");
            int authRequestContext25 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2, "isSubmitFeedBanner");
            int i14 = authRequestContext13;
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$2.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$2.moveToNext()) {
                Boolean bool = null;
                String string12 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext);
                String string13 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext2);
                Integer valueOf4 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext3) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext3));
                String string14 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext4) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext4);
                String string15 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext5) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext5);
                Long valueOf5 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext6) ? null : Long.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getLong(authRequestContext6));
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext7)) {
                    i = authRequestContext;
                    string = null;
                } else {
                    string = KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext7);
                    i = authRequestContext;
                }
                Map<String, String> fromString = this.__mapConverter.fromString(string);
                String string16 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext8) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext8);
                String string17 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext9);
                List<String> fromString2 = this.__stringConverter.fromString(KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$2.getString(authRequestContext10));
                Integer valueOf6 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext11) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext11));
                if (valueOf6 == null) {
                    valueOf = null;
                } else {
                    valueOf = Boolean.valueOf(valueOf6.intValue() != 0);
                }
                Integer valueOf7 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(authRequestContext12) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(authRequestContext12));
                if (valueOf7 == null) {
                    i2 = i14;
                    valueOf2 = null;
                } else {
                    valueOf2 = Boolean.valueOf(valueOf7.intValue() != 0);
                    i2 = i14;
                }
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i2)) {
                    i3 = authRequestContext15;
                    string2 = null;
                } else {
                    i3 = authRequestContext15;
                    string2 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i2);
                }
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i3)) {
                    i14 = i2;
                    i4 = authRequestContext16;
                    string3 = null;
                } else {
                    string3 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i3);
                    i14 = i2;
                    i4 = authRequestContext16;
                }
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i4)) {
                    authRequestContext16 = i4;
                    i5 = authRequestContext17;
                    string4 = null;
                } else {
                    string4 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i4);
                    authRequestContext16 = i4;
                    i5 = authRequestContext17;
                }
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i5)) {
                    authRequestContext17 = i5;
                    i6 = authRequestContext18;
                    string5 = null;
                } else {
                    string5 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i5);
                    authRequestContext17 = i5;
                    i6 = authRequestContext18;
                }
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i6)) {
                    authRequestContext18 = i6;
                    i7 = authRequestContext19;
                    string6 = null;
                } else {
                    string6 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i6);
                    authRequestContext18 = i6;
                    i7 = authRequestContext19;
                }
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i7)) {
                    authRequestContext19 = i7;
                    i8 = authRequestContext20;
                    string7 = null;
                } else {
                    string7 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i7);
                    authRequestContext19 = i7;
                    i8 = authRequestContext20;
                }
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i8)) {
                    authRequestContext20 = i8;
                    i9 = authRequestContext21;
                    string8 = null;
                } else {
                    string8 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i8);
                    authRequestContext20 = i8;
                    i9 = authRequestContext21;
                }
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i9)) {
                    authRequestContext21 = i9;
                    i10 = authRequestContext22;
                    string9 = null;
                } else {
                    string9 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i9);
                    authRequestContext21 = i9;
                    i10 = authRequestContext22;
                }
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i10)) {
                    authRequestContext22 = i10;
                    i11 = authRequestContext23;
                    string10 = null;
                } else {
                    string10 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i10);
                    authRequestContext22 = i10;
                    i11 = authRequestContext23;
                }
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i11)) {
                    authRequestContext23 = i11;
                    i12 = authRequestContext24;
                    valueOf3 = null;
                } else {
                    valueOf3 = Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i11));
                    authRequestContext23 = i11;
                    i12 = authRequestContext24;
                }
                if (KClassImpl$Data$declaredNonStaticMembers$2.isNull(i12)) {
                    authRequestContext24 = i12;
                    i13 = authRequestContext25;
                    string11 = null;
                } else {
                    string11 = KClassImpl$Data$declaredNonStaticMembers$2.getString(i12);
                    authRequestContext24 = i12;
                    i13 = authRequestContext25;
                }
                Integer valueOf8 = KClassImpl$Data$declaredNonStaticMembers$2.isNull(i13) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$2.getInt(i13));
                if (valueOf8 != null) {
                    bool = Boolean.valueOf(valueOf8.intValue() != 0);
                }
                authRequestContext25 = i13;
                arrayList.add(new ActivityItemEntity(string12, string13, valueOf4, string14, string15, valueOf5, fromString, string16, string17, fromString2, valueOf, valueOf2, string2, string3, string4, string5, string6, string7, string8, string9, string10, valueOf3, string11, bool));
                authRequestContext15 = i3;
                authRequestContext = i;
            }
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            KClassImpl$Data$declaredNonStaticMembers$2.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            throw th;
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
