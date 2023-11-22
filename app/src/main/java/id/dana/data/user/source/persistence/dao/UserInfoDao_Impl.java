package id.dana.data.user.source.persistence.dao;

import android.database.Cursor;
import android.view.ViewConfiguration;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.alibaba.fastjson.parser.JSONLexer;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.user.source.persistence.entity.UserInfoEntity;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;
import o.C;

/* loaded from: classes8.dex */
public final class UserInfoDao_Impl extends UserInfoDao {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 1016;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static char MyBillsEntityDataFactory = 30656;
    private static char PlaceComponentResult = 17885;
    private static char getAuthRequestContext = 50718;
    private static int lookAheadTest = 1;
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<UserInfoEntity> __insertionAdapterOfUserInfoEntity;
    private final SharedSQLiteStatement __preparedStmtOfClearUserInfo;

    static /* synthetic */ long access$001(UserInfoDao_Impl userInfoDao_Impl, UserInfoEntity userInfoEntity) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
        lookAheadTest = i % 128;
        char c = i % 2 == 0 ? 'X' : '-';
        long updateUserInfoFull = super.updateUserInfoFull(userInfoEntity);
        if (c != '-') {
            int i2 = 87 / 0;
        }
        return updateUserInfoFull;
    }

    static /* synthetic */ long access$101(UserInfoDao_Impl userInfoDao_Impl, UserInfoEntity userInfoEntity) {
        int i = lookAheadTest + 125;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        char c = i % 2 != 0 ? 'P' : (char) 20;
        long updateUserInfoPan = super.updateUserInfoPan(userInfoEntity);
        if (c != 20) {
            int i2 = 71 / 0;
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
        return updateUserInfoPan;
    }

    static /* synthetic */ long access$201(UserInfoDao_Impl userInfoDao_Impl, UserInfoEntity userInfoEntity) {
        int i = lookAheadTest + 29;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        long updateUserInfoStatusInfo = super.updateUserInfoStatusInfo(userInfoEntity);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 123;
        lookAheadTest = i3 % 128;
        if ((i3 % 2 == 0 ? '2' : (char) 25) != '2') {
            return updateUserInfoStatusInfo;
        }
        Object obj = null;
        obj.hashCode();
        return updateUserInfoStatusInfo;
    }

    static /* synthetic */ long access$301(UserInfoDao_Impl userInfoDao_Impl, UserInfoEntity userInfoEntity) {
        int i = lookAheadTest + 61;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        long updateUserInfoFaceAuth = super.updateUserInfoFaceAuth(userInfoEntity);
        int i3 = lookAheadTest + 29;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 != 0 ? 'c' : '\'') != '\'') {
            int i4 = 17 / 0;
            return updateUserInfoFaceAuth;
        }
        return updateUserInfoFaceAuth;
    }

    public UserInfoDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfUserInfoEntity = new EntityInsertionAdapter<UserInfoEntity>(roomDatabase) { // from class: id.dana.data.user.source.persistence.dao.UserInfoDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `UserInfoEntity` (`userId`,`accountStatus`,`avatarUrl`,`balance`,`ktpName`,`kybInfo`,`kyc`,`kycCertified`,`kycLevel`,`loginStatus`,`userStatus`,`ncc`,`loginId`,`nickname`,`pendingTransaction`,`shortcode`,`faceAuthStatus`,`enrollStatus`,`faceLoginReady`,`username`,`userPan`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, UserInfoEntity userInfoEntity) {
                UserInfoEntity userInfoEntity2 = userInfoEntity;
                if (userInfoEntity2.getUserId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, userInfoEntity2.getUserId());
                }
                if (userInfoEntity2.getAccountStatus() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, userInfoEntity2.getAccountStatus());
                }
                if (userInfoEntity2.getAvatarUrl() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, userInfoEntity2.getAvatarUrl());
                }
                if (userInfoEntity2.getBalance() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, userInfoEntity2.getBalance());
                }
                if (userInfoEntity2.getKtpName() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, userInfoEntity2.getKtpName());
                }
                if (userInfoEntity2.getKybInfo() == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, userInfoEntity2.getKybInfo());
                }
                if (userInfoEntity2.getKyc() == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, userInfoEntity2.getKyc());
                }
                if ((userInfoEntity2.getKycCertified() == null ? null : Integer.valueOf(userInfoEntity2.getKycCertified().booleanValue() ? 1 : 0)) == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindLong(8, r0.intValue());
                }
                if (userInfoEntity2.getKycLevel() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, userInfoEntity2.getKycLevel());
                }
                if (userInfoEntity2.getLoginStatus() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, userInfoEntity2.getLoginStatus());
                }
                if (userInfoEntity2.getUserStatus() == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, userInfoEntity2.getUserStatus());
                }
                if (userInfoEntity2.getNcc() == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, userInfoEntity2.getNcc());
                }
                if (userInfoEntity2.getLoginId() == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, userInfoEntity2.getLoginId());
                }
                if (userInfoEntity2.getNickname() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, userInfoEntity2.getNickname());
                }
                if (userInfoEntity2.getPendingTransaction() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, userInfoEntity2.getPendingTransaction());
                }
                if (userInfoEntity2.getShortcode() == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, userInfoEntity2.getShortcode());
                }
                if ((userInfoEntity2.getFaceAuthStatus() == null ? null : Integer.valueOf(userInfoEntity2.getFaceAuthStatus().booleanValue() ? 1 : 0)) == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindLong(17, r0.intValue());
                }
                if ((userInfoEntity2.getEnrollStatus() == null ? null : Integer.valueOf(userInfoEntity2.getEnrollStatus().booleanValue() ? 1 : 0)) == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindLong(18, r0.intValue());
                }
                if ((userInfoEntity2.getFaceLoginReady() != null ? Integer.valueOf(userInfoEntity2.getFaceLoginReady().booleanValue() ? 1 : 0) : null) == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindLong(19, r1.intValue());
                }
                if (userInfoEntity2.getUsername() == null) {
                    supportSQLiteStatement.bindNull(20);
                } else {
                    supportSQLiteStatement.bindString(20, userInfoEntity2.getUsername());
                }
                if (userInfoEntity2.getUserPan() == null) {
                    supportSQLiteStatement.bindNull(21);
                } else {
                    supportSQLiteStatement.bindString(21, userInfoEntity2.getUserPan());
                }
            }
        };
        this.__preparedStmtOfClearUserInfo = new SharedSQLiteStatement(roomDatabase) { // from class: id.dana.data.user.source.persistence.dao.UserInfoDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM UserInfoEntity";
            }
        };
    }

    @Override // id.dana.data.user.source.persistence.dao.UserInfoDao
    public final long updateUserInfo(UserInfoEntity userInfoEntity) {
        int i = lookAheadTest + 3;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfUserInfoEntity.insertAndReturnId(userInfoEntity);
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 15;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            return insertAndReturnId;
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    @Override // id.dana.data.user.source.persistence.dao.UserInfoDao
    public final long updateUserInfoFull(UserInfoEntity userInfoEntity) {
        long access$001;
        int i = lookAheadTest + 117;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        try {
            if (i % 2 != 0) {
                this.__db.beginTransaction();
                access$001 = access$001(this, userInfoEntity);
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                int i2 = 95 / 0;
            } else {
                this.__db.beginTransaction();
                access$001 = access$001(this, userInfoEntity);
                this.__db.setTransactionSuccessful();
            }
            return access$001;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // id.dana.data.user.source.persistence.dao.UserInfoDao
    public final long updateUserInfoPan(UserInfoEntity userInfoEntity) {
        int i = lookAheadTest + 63;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        this.__db.beginTransaction();
        try {
            long access$101 = access$101(this, userInfoEntity);
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            int i3 = lookAheadTest + 51;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if ((i3 % 2 != 0 ? '8' : 'B') != 'B') {
                Object[] objArr = null;
                int length = objArr.length;
                return access$101;
            }
            return access$101;
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    @Override // id.dana.data.user.source.persistence.dao.UserInfoDao
    public final long updateUserInfoStatusInfo(UserInfoEntity userInfoEntity) {
        long access$201;
        int i = lookAheadTest + 79;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        Object[] objArr = null;
        try {
            try {
                if (i % 2 != 0) {
                    try {
                        this.__db.beginTransaction();
                        access$201 = access$201(this, userInfoEntity);
                        this.__db.setTransactionSuccessful();
                        objArr.hashCode();
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    this.__db.beginTransaction();
                    access$201 = access$201(this, userInfoEntity);
                    this.__db.setTransactionSuccessful();
                }
                int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 45;
                lookAheadTest = i2 % 128;
                if (i2 % 2 == 0) {
                    int length = objArr.length;
                    return access$201;
                }
                return access$201;
            } finally {
                this.__db.endTransaction();
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.data.user.source.persistence.dao.UserInfoDao
    public final long updateUserInfoFaceAuth(UserInfoEntity userInfoEntity) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 19;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            this.__db.beginTransaction();
            try {
                long access$301 = access$301(this, userInfoEntity);
                this.__db.setTransactionSuccessful();
                this.__db.endTransaction();
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
                lookAheadTest = i3 % 128;
                int i4 = i3 % 2;
                return access$301;
            } catch (Throwable th) {
                this.__db.endTransaction();
                throw th;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.data.user.source.persistence.dao.UserInfoDao
    public final void clearUserInfo() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 97;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfClearUserInfo.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            this.__preparedStmtOfClearUserInfo.release(acquire);
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 15;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
        } catch (Throwable th) {
            this.__db.endTransaction();
            this.__preparedStmtOfClearUserInfo.release(acquire);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    @Override // id.dana.data.user.source.persistence.dao.UserInfoDao
    public final List<UserInfoEntity> getUserInfoFull() {
        String str;
        Integer valueOf;
        Boolean valueOf2;
        Boolean valueOf3;
        boolean z;
        Boolean valueOf4;
        Integer valueOf5;
        boolean z2;
        Boolean valueOf6;
        int i = 0;
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT userId, accountStatus, avatarUrl, balance, enrollStatus, faceAuthStatus, faceLoginReady, ktpName, kybInfo, kycCertified, kycLevel, loginId, loginStatus, nickname, pendingTransaction, username FROM UserInfoEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$22 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$22.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$22.moveToNext()) {
                ?? r6 = 0;
                r6 = 0;
                String string = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(i);
                if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(1)) {
                    try {
                        int i2 = lookAheadTest + 55;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                        if (i2 % 2 != 0) {
                            int length = r6.length;
                        }
                        str = null;
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    str = KClassImpl$Data$declaredNonStaticMembers$22.getString(1);
                }
                String string2 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(2) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(2);
                String string3 = !(KClassImpl$Data$declaredNonStaticMembers$22.isNull(3)) ? KClassImpl$Data$declaredNonStaticMembers$22.getString(3) : null;
                if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(4)) {
                    int i3 = lookAheadTest + 1;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                    int i4 = i3 % 2;
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(4));
                }
                if (valueOf == null) {
                    valueOf2 = null;
                } else {
                    valueOf2 = Boolean.valueOf(valueOf.intValue() != 0);
                }
                Integer valueOf7 = (KClassImpl$Data$declaredNonStaticMembers$22.isNull(5) ? Typography.quote : Typography.greater) != '\"' ? Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(5)) : null;
                if (valueOf7 == null) {
                    int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 91;
                    lookAheadTest = i5 % 128;
                    if (i5 % 2 == 0) {
                        r6.hashCode();
                    }
                    valueOf3 = null;
                } else {
                    valueOf3 = Boolean.valueOf(valueOf7.intValue() != 0);
                }
                Integer valueOf8 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(6) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(6));
                if (valueOf8 == null) {
                    int i6 = KClassImpl$Data$declaredNonStaticMembers$2 + 19;
                    lookAheadTest = i6 % 128;
                    int i7 = i6 % 2;
                    valueOf4 = null;
                } else {
                    if (!(valueOf8.intValue() != 0)) {
                        z = false;
                    } else {
                        int i8 = KClassImpl$Data$declaredNonStaticMembers$2 + 17;
                        lookAheadTest = i8 % 128;
                        int i9 = i8 % 2;
                        z = true;
                    }
                    valueOf4 = Boolean.valueOf(z);
                }
                String string4 = !(!KClassImpl$Data$declaredNonStaticMembers$22.isNull(7)) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(7);
                String string5 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(8) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(8);
                if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(9)) {
                    int i10 = lookAheadTest + 87;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i10 % 128;
                    int i11 = i10 % 2;
                    valueOf5 = null;
                } else {
                    valueOf5 = Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(9));
                }
                if (valueOf5 == null) {
                    int i12 = KClassImpl$Data$declaredNonStaticMembers$2 + 1;
                    lookAheadTest = i12 % 128;
                    int i13 = i12 % 2;
                    valueOf6 = null;
                } else {
                    if (valueOf5.intValue() != 0) {
                        int i14 = KClassImpl$Data$declaredNonStaticMembers$2 + 107;
                        lookAheadTest = i14 % 128;
                        int i15 = i14 % 2;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    valueOf6 = Boolean.valueOf(z2);
                }
                String string6 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(10) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(10);
                String string7 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(11) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(11);
                String string8 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(12) ? false : true ? KClassImpl$Data$declaredNonStaticMembers$22.getString(12) : null;
                String string9 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(13) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(13);
                String string10 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(14) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(14);
                if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(15)) {
                    int i16 = KClassImpl$Data$declaredNonStaticMembers$2 + 59;
                    lookAheadTest = i16 % 128;
                    if ((i16 % 2 == 0 ? (char) 17 : '9') == 17) {
                        r6.hashCode();
                    }
                } else {
                    r6 = KClassImpl$Data$declaredNonStaticMembers$22.getString(15);
                }
                arrayList.add(new UserInfoEntity(string, str, string2, string3, string4, string5, null, valueOf6, string6, string8, null, null, string7, string9, string10, null, valueOf3, valueOf2, valueOf4, r6, null));
                i = 0;
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$22.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        if ((!r4.isNull(0)) != true) goto L20;
     */
    @Override // id.dana.data.user.source.persistence.dao.UserInfoDao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<id.dana.data.user.source.persistence.entity.UserInfoEntity> getUserInfoPan() {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.user.source.persistence.dao.UserInfoDao_Impl.getUserInfoPan():java.util.List");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    @Override // id.dana.data.user.source.persistence.dao.UserInfoDao
    public final List<UserInfoEntity> getUserInfoStatusInfo() {
        Integer valueOf;
        boolean z;
        Boolean valueOf2;
        Integer valueOf3;
        Boolean valueOf4;
        Boolean valueOf5;
        Boolean valueOf6;
        String string;
        RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT userId, accountStatus, enrollStatus, faceAuthStatus, faceLoginReady, kycCertified, loginStatus, pendingTransaction, userStatus FROM UserInfoEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$22 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
        try {
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$22.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$22.moveToNext()) {
                ?? r6 = 0;
                r6 = 0;
                String string2 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(0) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(0);
                boolean z2 = true;
                String string3 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(1) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(1);
                if (!(!KClassImpl$Data$declaredNonStaticMembers$22.isNull(2))) {
                    int i = KClassImpl$Data$declaredNonStaticMembers$2 + 17;
                    lookAheadTest = i % 128;
                    if (i % 2 == 0) {
                        int length = r6.length;
                    }
                    valueOf = null;
                } else {
                    valueOf = Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(2));
                }
                if (valueOf == null) {
                    valueOf2 = null;
                } else {
                    if ((valueOf.intValue() != 0 ? '\b' : '3') == '\b') {
                        try {
                            int i2 = lookAheadTest + 77;
                            try {
                                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                                if ((i2 % 2 != 0 ? ')' : 'V') == 'V') {
                                    z = true;
                                    valueOf2 = Boolean.valueOf(z);
                                }
                            } catch (Exception e) {
                                throw e;
                            }
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                    z = false;
                    valueOf2 = Boolean.valueOf(z);
                }
                if (!(!KClassImpl$Data$declaredNonStaticMembers$22.isNull(3))) {
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
                    lookAheadTest = i3 % 128;
                    if (i3 % 2 == 0) {
                        int length2 = r6.length;
                    }
                    valueOf3 = null;
                } else {
                    valueOf3 = Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(3));
                }
                if (valueOf3 == null) {
                    int i4 = lookAheadTest + 19;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i4 % 128;
                    if ((i4 % 2 != 0 ? (char) 6 : '\b') == 6) {
                        int i5 = 7 / 0;
                    }
                    valueOf4 = null;
                } else {
                    valueOf4 = Boolean.valueOf(valueOf3.intValue() != 0);
                }
                Integer valueOf7 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(4) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(4));
                if (valueOf7 == null) {
                    int i6 = lookAheadTest + 99;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i6 % 128;
                    int i7 = i6 % 2;
                    valueOf5 = null;
                } else {
                    valueOf5 = Boolean.valueOf(valueOf7.intValue() != 0);
                }
                Integer valueOf8 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(5) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(5));
                if (!(valueOf8 != null)) {
                    valueOf6 = null;
                } else {
                    if (valueOf8.intValue() == 0) {
                        z2 = false;
                    }
                    valueOf6 = Boolean.valueOf(z2);
                }
                if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(6)) {
                    int i8 = lookAheadTest + 53;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i8 % 128;
                    int i9 = i8 % 2;
                    string = null;
                } else {
                    string = KClassImpl$Data$declaredNonStaticMembers$22.getString(6);
                }
                String string4 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(7) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(7);
                if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(8)) {
                    int i10 = lookAheadTest + 17;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i10 % 128;
                    if (i10 % 2 != 0) {
                        int i11 = 80 / 0;
                    } else {
                        continue;
                    }
                } else {
                    r6 = KClassImpl$Data$declaredNonStaticMembers$22.getString(8);
                }
                arrayList.add(new UserInfoEntity(string2, string3, null, null, null, null, null, valueOf6, null, string, r6, null, null, null, string4, null, valueOf4, valueOf2, valueOf5, null, null));
            }
            return arrayList;
        } finally {
            KClassImpl$Data$declaredNonStaticMembers$22.close();
            authRequestContext.MyBillsEntityDataFactory();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v3 */
    @Override // id.dana.data.user.source.persistence.dao.UserInfoDao
    public final List<UserInfoEntity> getUserInfoFaceAuth() {
        String string;
        Integer valueOf;
        Boolean valueOf2;
        Boolean valueOf3;
        Integer valueOf4;
        Boolean bool;
        Boolean bool2;
        try {
            RoomSQLiteQuery authRequestContext = RoomSQLiteQuery.getAuthRequestContext("SELECT userId, enrollStatus, faceAuthStatus, faceLoginReady, kycCertified, pendingTransaction FROM UserInfoEntity", 0);
            this.__db.assertNotSuspendingTransaction();
            Cursor KClassImpl$Data$declaredNonStaticMembers$22 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext, false);
            try {
                ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$22.getCount());
                int i = lookAheadTest + 19;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                while (KClassImpl$Data$declaredNonStaticMembers$22.moveToNext()) {
                    ?? r8 = 0;
                    r8 = 0;
                    if ((KClassImpl$Data$declaredNonStaticMembers$22.isNull(0) ? (char) 28 : Typography.dollar) != '$') {
                        int i3 = lookAheadTest + 123;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                        if (i3 % 2 != 0) {
                            int i4 = 86 / 0;
                        }
                        string = null;
                    } else {
                        string = KClassImpl$Data$declaredNonStaticMembers$22.getString(0);
                    }
                    boolean z = true;
                    if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(1)) {
                        int i5 = lookAheadTest + 93;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
                        if (i5 % 2 != 0) {
                            int i6 = 17 / 0;
                        }
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(1));
                    }
                    if (valueOf == null) {
                        int i7 = lookAheadTest + 3;
                        KClassImpl$Data$declaredNonStaticMembers$2 = i7 % 128;
                        if ((i7 % 2 != 0 ? (char) 16 : 'S') == 16) {
                            int length = r8.length;
                        }
                        valueOf2 = null;
                    } else {
                        valueOf2 = Boolean.valueOf(valueOf.intValue() != 0);
                    }
                    Integer valueOf5 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(2) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(2));
                    if (valueOf5 == null) {
                        valueOf3 = null;
                    } else {
                        valueOf3 = Boolean.valueOf(valueOf5.intValue() != 0);
                    }
                    if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(3)) {
                        int i8 = KClassImpl$Data$declaredNonStaticMembers$2 + 47;
                        lookAheadTest = i8 % 128;
                        if (i8 % 2 == 0) {
                            int i9 = 42 / 0;
                        }
                        valueOf4 = null;
                    } else {
                        valueOf4 = Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(3));
                    }
                    if (valueOf4 != null) {
                        bool = Boolean.valueOf(valueOf4.intValue() != 0);
                    } else {
                        bool = null;
                    }
                    Integer valueOf6 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(4) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(4));
                    if (valueOf6 != null) {
                        if (valueOf6.intValue() != 0) {
                            int i10 = lookAheadTest + 3;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i10 % 128;
                            int i11 = i10 % 2;
                        } else {
                            z = false;
                        }
                        bool2 = Boolean.valueOf(z);
                    } else {
                        bool2 = null;
                    }
                    if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(5)) {
                        try {
                            int i12 = lookAheadTest + 91;
                            KClassImpl$Data$declaredNonStaticMembers$2 = i12 % 128;
                            if (i12 % 2 != 0) {
                                int length2 = r8.length;
                            } else {
                                continue;
                            }
                        } catch (Exception e) {
                            throw e;
                        }
                    } else {
                        r8 = KClassImpl$Data$declaredNonStaticMembers$22.getString(5);
                    }
                    arrayList.add(new UserInfoEntity(string, null, null, null, null, null, null, bool2, null, null, null, null, null, null, r8, null, valueOf3, valueOf2, bool, null, null));
                }
                return arrayList;
            } finally {
                KClassImpl$Data$declaredNonStaticMembers$22.close();
                authRequestContext.MyBillsEntityDataFactory();
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v67 */
    /* JADX WARN: Type inference failed for: r1v68 */
    /* JADX WARN: Type inference failed for: r1v69 */
    /* JADX WARN: Type inference failed for: r1v74 */
    @Override // id.dana.data.user.source.persistence.dao.UserInfoDao
    public final List<UserInfoEntity> getUserInfoKyc() {
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
        int authRequestContext14;
        String string;
        String string2;
        Boolean bool;
        String string3;
        String string4;
        int i;
        int i2;
        String string5;
        int i3;
        int i4;
        String string6;
        int i5;
        String string7;
        int i6;
        Boolean valueOf;
        int i7;
        int i8;
        int i9;
        boolean z;
        Boolean valueOf2;
        int i10;
        int i11;
        Integer valueOf3;
        int i12;
        char c;
        int i13;
        Boolean bool2;
        boolean z2;
        boolean z3;
        String string8;
        int i14;
        int i15;
        String string9;
        ?? r1;
        RoomSQLiteQuery authRequestContext15 = RoomSQLiteQuery.getAuthRequestContext("SELECT * FROM UserInfoEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor KClassImpl$Data$declaredNonStaticMembers$22 = DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(this.__db, authRequestContext15, false);
        try {
            authRequestContext = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "userId");
            authRequestContext2 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "accountStatus");
            authRequestContext3 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, AccountEntityRepository.UpdateType.AVATAR);
            authRequestContext4 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "balance");
            authRequestContext5 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "ktpName");
            authRequestContext6 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "kybInfo");
            Object[] objArr = new Object[1];
            a(3 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), new char[]{30541, 13493, 53122, 24264}, objArr);
            authRequestContext7 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, ((String) objArr[0]).intern());
            authRequestContext8 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "kycCertified");
            authRequestContext9 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, WalletConstant.KYC_LEVEL);
            authRequestContext10 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "loginStatus");
            authRequestContext11 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "userStatus");
            authRequestContext12 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "ncc");
            authRequestContext13 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, BranchLinkConstant.Params.LOGIN_ID);
            authRequestContext14 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "nickname");
            roomSQLiteQuery = authRequestContext15;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = authRequestContext15;
        }
        try {
            int authRequestContext16 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "pendingTransaction");
            int authRequestContext17 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "shortcode");
            int authRequestContext18 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "faceAuthStatus");
            int authRequestContext19 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "enrollStatus");
            int authRequestContext20 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "faceLoginReady");
            int authRequestContext21 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "username");
            int authRequestContext22 = CursorUtil.getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$22, "userPan");
            int i16 = authRequestContext14;
            ArrayList arrayList = new ArrayList(KClassImpl$Data$declaredNonStaticMembers$22.getCount());
            while (KClassImpl$Data$declaredNonStaticMembers$22.moveToNext()) {
                int i17 = KClassImpl$Data$declaredNonStaticMembers$2 + 85;
                ArrayList arrayList2 = arrayList;
                lookAheadTest = i17 % 128;
                int i18 = i17 % 2;
                String string10 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext);
                String string11 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext2) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext2);
                String string12 = (KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext3) ? 'B' : JSONLexer.EOI) != 26 ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext3);
                String string13 = (KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext4) ? InputCardNumberView.DIVIDER : '*') != '*' ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext4);
                if (!KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext5)) {
                    string = KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext5);
                } else {
                    int i19 = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
                    lookAheadTest = i19 % 128;
                    int i20 = i19 % 2;
                    string = null;
                }
                if (!KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext6)) {
                    string2 = KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext6);
                } else {
                    int i21 = lookAheadTest + 27;
                    KClassImpl$Data$declaredNonStaticMembers$2 = i21 % 128;
                    if (i21 % 2 != 0) {
                        int i22 = 7 / 0;
                    }
                    string2 = null;
                }
                String string14 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext7) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext7);
                Integer valueOf4 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext8) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(authRequestContext8));
                if (valueOf4 != null) {
                    bool = Boolean.valueOf(valueOf4.intValue() != 0);
                } else {
                    int i23 = KClassImpl$Data$declaredNonStaticMembers$2 + 21;
                    lookAheadTest = i23 % 128;
                    if (i23 % 2 == 0) {
                        Object obj = null;
                        obj.hashCode();
                    }
                    bool = null;
                }
                String string15 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext9) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext9);
                String string16 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext10) ? null : KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext10);
                String string17 = (KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext11) ? Typography.greater : (char) 14) != '>' ? KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext11) : null;
                if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext12)) {
                    int i24 = KClassImpl$Data$declaredNonStaticMembers$2 + 45;
                    lookAheadTest = i24 % 128;
                    int i25 = i24 % 2;
                    string3 = null;
                } else {
                    string3 = KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext12);
                }
                if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(authRequestContext13)) {
                    i = i16;
                    string4 = null;
                } else {
                    string4 = KClassImpl$Data$declaredNonStaticMembers$22.getString(authRequestContext13);
                    i = i16;
                }
                if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i)) {
                    int i26 = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
                    i2 = authRequestContext12;
                    lookAheadTest = i26 % 128;
                    if (i26 % 2 == 0) {
                        int i27 = 96 / 0;
                    }
                    i3 = authRequestContext16;
                    string5 = null;
                } else {
                    i2 = authRequestContext12;
                    string5 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i);
                    i3 = authRequestContext16;
                }
                if (!KClassImpl$Data$declaredNonStaticMembers$22.isNull(i3)) {
                    i4 = i;
                    string6 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i3);
                    i5 = authRequestContext17;
                } else {
                    int i28 = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
                    i4 = i;
                    lookAheadTest = i28 % 128;
                    if (i28 % 2 == 0) {
                        ?? r12 = 0;
                        int length = r12.length;
                    }
                    i5 = authRequestContext17;
                    string6 = null;
                }
                if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i5)) {
                    i6 = authRequestContext18;
                    string7 = null;
                } else {
                    string7 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i5);
                    i6 = authRequestContext18;
                }
                Integer valueOf5 = KClassImpl$Data$declaredNonStaticMembers$22.isNull(i6) ? null : Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(i6));
                if (valueOf5 == null) {
                    i7 = i3;
                    i8 = authRequestContext19;
                    valueOf = null;
                } else {
                    valueOf = Boolean.valueOf(valueOf5.intValue() != 0);
                    i7 = i3;
                    i8 = authRequestContext19;
                }
                Integer valueOf6 = !KClassImpl$Data$declaredNonStaticMembers$22.isNull(i8) ? Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(i8)) : null;
                if (valueOf6 == null) {
                    authRequestContext19 = i8;
                    i9 = i5;
                    i10 = authRequestContext20;
                    valueOf2 = null;
                } else {
                    if (valueOf6.intValue() != 0) {
                        authRequestContext19 = i8;
                        int i29 = KClassImpl$Data$declaredNonStaticMembers$2 + 31;
                        i9 = i5;
                        lookAheadTest = i29 % 128;
                        if (i29 % 2 != 0) {
                            z = true;
                            valueOf2 = Boolean.valueOf(z);
                            i10 = authRequestContext20;
                        }
                    } else {
                        authRequestContext19 = i8;
                        i9 = i5;
                    }
                    z = false;
                    valueOf2 = Boolean.valueOf(z);
                    i10 = authRequestContext20;
                }
                if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i10)) {
                    int i30 = KClassImpl$Data$declaredNonStaticMembers$2 + 113;
                    i11 = i6;
                    lookAheadTest = i30 % 128;
                    if (i30 % 2 == 0) {
                        r1 = 0;
                        int length2 = r1.length;
                    } else {
                        r1 = 0;
                    }
                    valueOf3 = r1;
                } else {
                    i11 = i6;
                    valueOf3 = Integer.valueOf(KClassImpl$Data$declaredNonStaticMembers$22.getInt(i10));
                }
                if (valueOf3 == null) {
                    i12 = i10;
                    c = 'Y';
                } else {
                    i12 = i10;
                    c = '(';
                }
                if (c != 'Y') {
                    bool2 = Boolean.valueOf(valueOf3.intValue() != 0);
                    i13 = authRequestContext21;
                } else {
                    i13 = authRequestContext21;
                    bool2 = null;
                }
                if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i13)) {
                    z2 = true;
                    z3 = false;
                } else {
                    z2 = true;
                    z3 = true;
                }
                if (z3 != z2) {
                    i14 = authRequestContext22;
                    string8 = null;
                } else {
                    string8 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i13);
                    i14 = authRequestContext22;
                }
                if (KClassImpl$Data$declaredNonStaticMembers$22.isNull(i14)) {
                    int i31 = KClassImpl$Data$declaredNonStaticMembers$2 + 85;
                    i15 = i13;
                    lookAheadTest = i31 % 128;
                    int i32 = i31 % 2;
                    string9 = null;
                } else {
                    i15 = i13;
                    string9 = KClassImpl$Data$declaredNonStaticMembers$22.getString(i14);
                }
                arrayList2.add(new UserInfoEntity(string10, string11, string12, string13, string, string2, string14, bool, string15, string16, string17, string3, string4, string5, string6, string7, valueOf, valueOf2, bool2, string8, string9));
                authRequestContext22 = i14;
                authRequestContext21 = i15;
                authRequestContext16 = i7;
                authRequestContext17 = i9;
                authRequestContext18 = i11;
                authRequestContext20 = i12;
                arrayList = arrayList2;
                authRequestContext12 = i2;
                i16 = i4;
            }
            ArrayList arrayList3 = arrayList;
            KClassImpl$Data$declaredNonStaticMembers$22.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            KClassImpl$Data$declaredNonStaticMembers$22.close();
            roomSQLiteQuery.MyBillsEntityDataFactory();
            throw th;
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 27;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        List<Class<?>> emptyList = Collections.emptyList();
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 97;
            lookAheadTest = i3 % 128;
            if ((i3 % 2 == 0 ? '#' : (char) 7) != 7) {
                Object obj = null;
                obj.hashCode();
                return emptyList;
            }
            return emptyList;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        while (true) {
            if (c.BuiltInFictitiousFunctionClassFactory >= cArr.length) {
                break;
            }
            int i2 = $11 + 73;
            $10 = i2 % 128;
            int i3 = 58224;
            if (!(i2 % 2 == 0)) {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory >> 0];
            } else {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
            }
            for (int i4 = 0; i4 < 16; i4++) {
                cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i3) ^ ((cArr3[0] << 4) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))));
                cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i3) ^ ((cArr3[1] << 4) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))));
                i3 -= 40503;
            }
            cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
            cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
            c.BuiltInFictitiousFunctionClassFactory += 2;
        }
        String str = new String(cArr2, 0, i);
        int i5 = $10 + 59;
        $11 = i5 % 128;
        if (i5 % 2 != 0) {
            objArr[0] = str;
            return;
        }
        int i6 = 18 / 0;
        objArr[0] = str;
    }
}
