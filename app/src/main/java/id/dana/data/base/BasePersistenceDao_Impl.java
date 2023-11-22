package id.dana.data.base;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.alibaba.griver.core.GriverParams;
import com.alipay.imobile.network.quake.transport.http.constant.HeaderConstant;
import com.alipay.mobile.zebra.data.ZebraData;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.danah5.constant.BaseKey;
import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.geofence.repository.source.persistence.dao.GeofenceDao;
import id.dana.data.geofence.repository.source.persistence.dao.GeofenceDao_Impl;
import id.dana.data.home.repository.source.presistence.dao.MoreForYouDao;
import id.dana.data.home.repository.source.presistence.dao.MoreForYouDao_Impl;
import id.dana.data.home.repository.source.presistence.dao.NewsWidgetActivityDao;
import id.dana.data.home.repository.source.presistence.dao.NewsWidgetActivityDao_Impl;
import id.dana.data.home.repository.source.presistence.dao.PromoBannerAnnouncementDao;
import id.dana.data.home.repository.source.presistence.dao.PromoBannerAnnouncementDao_Impl;
import id.dana.data.home.repository.source.presistence.dao.PromoBannerContentDao;
import id.dana.data.home.repository.source.presistence.dao.PromoBannerContentDao_Impl;
import id.dana.data.home.repository.source.presistence.dao.SingleBalanceDao;
import id.dana.data.home.repository.source.presistence.dao.SingleBalanceDao_Impl;
import id.dana.data.loyalty.repository.source.local.dao.LoyaltyReceiptDao;
import id.dana.data.loyalty.repository.source.local.dao.LoyaltyReceiptDao_Impl;
import id.dana.data.recentcontact.repository.source.persistence.dao.DanaUserContactDao;
import id.dana.data.recentcontact.repository.source.persistence.dao.DanaUserContactDao_Impl;
import id.dana.data.recentcontact.repository.source.persistence.dao.UserContactDao;
import id.dana.data.recentcontact.repository.source.persistence.dao.UserContactDao_Impl;
import id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao;
import id.dana.data.recentrecipient.source.persistence.dao.RecentRecipientDao_Impl;
import id.dana.data.social.repository.source.persistence.dao.ActivityDao;
import id.dana.data.social.repository.source.persistence.dao.ActivityDao_Impl;
import id.dana.data.social.repository.source.persistence.dao.FollowerDao;
import id.dana.data.social.repository.source.persistence.dao.FollowerDao_Impl;
import id.dana.data.social.repository.source.persistence.dao.FollowingDao;
import id.dana.data.social.repository.source.persistence.dao.FollowingDao_Impl;
import id.dana.data.splitbill.repository.source.persistence.dao.RecentPayerSplitBillDao;
import id.dana.data.splitbill.repository.source.persistence.dao.RecentPayerSplitBillDao_Impl;
import id.dana.data.splitbill.repository.source.persistence.dao.SplitBillHistoryDao;
import id.dana.data.splitbill.repository.source.persistence.dao.SplitBillHistoryDao_Impl;
import id.dana.data.user.source.persistence.dao.UserInfoDao;
import id.dana.data.user.source.persistence.dao.UserInfoDao_Impl;
import id.dana.data.wallet_v3.repository.source.persistence.dao.UserIdentityAssetsDao;
import id.dana.data.wallet_v3.repository.source.persistence.dao.UserIdentityAssetsDao_Impl;
import id.dana.data.wallet_v3.repository.source.persistence.dao.UserPaymentAssetsDao;
import id.dana.data.wallet_v3.repository.source.persistence.dao.UserPaymentAssetsDao_Impl;
import id.dana.data.wallet_v3.repository.source.persistence.dao.UserPocketAssetsDao;
import id.dana.data.wallet_v3.repository.source.persistence.dao.UserPocketAssetsDao_Impl;
import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.domain.wallet_v3.constant.WalletRecommendationConstant;
import id.dana.lib.gcontainer.app.bridge.constant.BridgeKey;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

/* loaded from: classes8.dex */
public final class BasePersistenceDao_Impl extends BasePersistenceDao {
    private volatile ActivityDao _activityDao;
    private volatile DanaUserContactDao _danaUserContactDao;
    private volatile FollowerDao _followerDao;
    private volatile FollowingDao _followingDao;
    private volatile GeofenceDao _geofenceDao;
    private volatile LoyaltyReceiptDao _loyaltyReceiptDao;
    private volatile MoreForYouDao _moreForYouDao;
    private volatile NewsWidgetActivityDao _newsWidgetActivityDao;
    private volatile PromoBannerAnnouncementDao _promoBannerAnnouncementDao;
    private volatile PromoBannerContentDao _promoBannerContentDao;
    private volatile RecentPayerSplitBillDao _recentPayerSplitBillDao;
    private volatile RecentRecipientDao _recentRecipientDao;
    private volatile SingleBalanceDao _singleBalanceDao;
    private volatile SplitBillHistoryDao _splitBillHistoryDao;
    private volatile UserContactDao _userContactDao;
    private volatile UserIdentityAssetsDao _userIdentityAssetsDao;
    private volatile UserInfoDao _userInfoDao;
    private volatile UserPaymentAssetsDao _userPaymentAssetsDao;
    private volatile UserPocketAssetsDao _userPocketAssetsDao;

    @Override // androidx.room.RoomDatabase
    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(this) { // from class: id.dana.data.base.BasePersistenceDao_Impl.1
            private static int $10 = 0;
            private static int $11 = 1;
            private static int BuiltInFictitiousFunctionClassFactory = 1;
            private static int PlaceComponentResult;
            private static char[] getAuthRequestContext = {35503, 35568, 35564};
            final /* synthetic */ BasePersistenceDao_Impl KClassImpl$Data$declaredNonStaticMembers$2;

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                int i = PlaceComponentResult + 105;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                if ((i % 2 == 0 ? 'M' : (char) 30) != 'M') {
                    return;
                }
                Object[] objArr = null;
                int length = objArr.length;
            }

            {
                try {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
                } catch (Exception e) {
                    throw e;
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                try {
                    int i = BuiltInFictitiousFunctionClassFactory + 33;
                    PlaceComponentResult = i % 128;
                    int i2 = i % 2;
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `DanaUserContactEntity` (`lastUpdated` INTEGER NOT NULL, `phoneNumber` TEXT, `uid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` TEXT)");
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SplitBillHistoryEntity` (`uid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `comment` TEXT, `deepLinkUrl` TEXT, `payers` TEXT, `lastUpdated` INTEGER NOT NULL, `splitBillId` TEXT, `createdDate` INTEGER NOT NULL, `status` TEXT, `totalAmount` TEXT, `payeeIndex` INTEGER NOT NULL, `payerIndex` INTEGER NOT NULL)");
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `RecentPayerSplitBillEntity` (`uid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userId` TEXT, `userPhoneNumber` TEXT, `userNickname` TEXT, `avatar` TEXT, `lastUpdated` INTEGER NOT NULL, `shownName` TEXT, `shownNumber` TEXT)");
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `FollowerItemEntity` (`userId` TEXT NOT NULL, `loginId` TEXT NOT NULL, `nickName` TEXT NOT NULL, `status` TEXT NOT NULL, `gmtCreate` INTEGER NOT NULL, `gmtModified` INTEGER NOT NULL, `avatar` TEXT, `username` TEXT NOT NULL, PRIMARY KEY(`userId`))");
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `FollowingItemEntity` (`userId` TEXT NOT NULL, `loginId` TEXT NOT NULL, `nickName` TEXT NOT NULL, `status` TEXT NOT NULL, `gmtCreate` INTEGER NOT NULL, `gmtModified` INTEGER NOT NULL, `avatar` TEXT, `username` TEXT NOT NULL, PRIMARY KEY(`userId`))");
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `RecentPoiEntity` (`poiId` TEXT NOT NULL, `radius` INTEGER NOT NULL, `longitude` REAL NOT NULL, `latitude` REAL NOT NULL, `lastPoiNotified` INTEGER, PRIMARY KEY(`poiId`))");
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `LoyaltyReceiptEntity` (`userLoyaltyId` TEXT NOT NULL, `merchantId` TEXT NOT NULL, `orderId` TEXT NOT NULL, `merchantName` TEXT NOT NULL, `orderAmount` TEXT NOT NULL, `timestamp` TEXT NOT NULL, `filePath` TEXT NOT NULL, `rawText` TEXT NOT NULL, PRIMARY KEY(`userLoyaltyId`))");
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `UserContactEntity` (`uid` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `phoneNumber` TEXT NOT NULL, `rawPhoneNumber` TEXT NOT NULL, `name` TEXT, `updatedAt` INTEGER, `createdAt` INTEGER, `isDanaUser` INTEGER, `displayPhoto` TEXT)");
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `UserPaymentAssetsDaoEntity` (`uniqueId` TEXT NOT NULL, `section` TEXT, `amount` TEXT, `currency` TEXT, `limitAmount` TEXT, `limitCurrency` TEXT, `limitCurrencyCode` TEXT, `balanceAmount` TEXT, `balanceCurrency` TEXT, `balanceCurrencyCode` TEXT, `unpaidAmountAmount` TEXT, `unpaidAmountCurrency` TEXT, `unpaidAmountCurrencyCode` TEXT, `overdueTips` TEXT, `overdueStatus` INTEGER, `accountId` TEXT, `gmtCreate` TEXT, `gmtModified` TEXT, `assetBiztype` TEXT, `cardTitle` TEXT, `cardIndexNo` TEXT, `cardNoLength` TEXT, `maskedCardNo` TEXT, `assetType` TEXT, `cardScheme` TEXT, `holderName` TEXT, `instLogoUrl` TEXT, `instId` TEXT, `instOfficialName` TEXT, `instBranchId` TEXT, `instBranchOfficialName` TEXT, `expiryYear` TEXT, `expiryMonth` TEXT, `verified` INTEGER, `bindingId` TEXT, `accountNo` TEXT, `defaultAsset` TEXT, `extInfo` TEXT, `enableStatus` INTEGER, `bankMobileNo` TEXT, `directDebit` INTEGER, `personalDailyLimitAmount` TEXT, `personalDailyLimitCurrency` TEXT, `personalDailyLimitCurrencyCode` TEXT, `userPhoneNo` TEXT, `contactBizType` TEXT, `goodsId` TEXT, `aggregator` TEXT, `userId` TEXT, `accountStatus` TEXT, `availableBalanceAmount` INTEGER, `availableBalanceCent` INTEGER, `availableBalanceCentFactor` INTEGER, `availableBalanceCurrency` TEXT, `availableBalanceCurrencyCode` TEXT, `availableBalanceCurrencyValue` TEXT, `balanceUnitType` TEXT, `balanceUnitUnit` INTEGER, `balanceUnitUnitValue` TEXT, `totalGainLossAmountAmount` INTEGER, `totalGainLossAmountCent` INTEGER, `totalGainLossAmountCentFactor` INTEGER, `totalGainLossAmountCurrency` TEXT, `totalGainLossAmountCurrencyCode` TEXT, `totalGainLossAmountCurrencyValue` TEXT, `totalGainLossPercentage` TEXT, `dailyGainLossAmountAmount` INTEGER, `dailyGainLossAmountCent` INTEGER, `dailyGainLossAmountCentFactor` INTEGER, `dailyGainLossAmountCurrency` TEXT, `dailyGainLossAmountCurrencyCode` TEXT, `dailyGainLossAmountCurrencyValue` TEXT, `dailyGainLossPercentage` TEXT, `lastUpdated` INTEGER, `savingId` TEXT, `title` TEXT, `categoryCode` TEXT, `currentAmountAmount` TEXT, `currentAmountCurrency` TEXT, `currentAmountCurrencyCode` TEXT, `targetAmountAmount` TEXT, `targetAmountCurrency` TEXT, `targetAmountCurrencyCode` TEXT, `orderStatus` TEXT, `orderSubStatus` TEXT, `createdTime` INTEGER, `achievedTime` INTEGER, `completedTime` INTEGER, `extendInfo` TEXT, `cardBackground` TEXT, `cacheTimestamp` INTEGER, PRIMARY KEY(`uniqueId`))");
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `UserPocketAssetsDaoEntity` (`pocketId` TEXT NOT NULL, `pocketStatus` TEXT NOT NULL, `iconUrl` TEXT NOT NULL, `backgroundUrl` TEXT NOT NULL, `pocketType` TEXT, `userPocketStatus` TEXT, `activateDate` INTEGER, `howTo` TEXT, `merchantId` TEXT, `label` TEXT, `subLabel` TEXT, `logoUrl` TEXT, `usable` INTEGER, `shareable` INTEGER, `goodsId` TEXT, `tcUrl` TEXT, `expirationDate` INTEGER, `createdDate` TEXT, `shareableRpcInfoReceiverInfo` TEXT, `shareableRpcInfoReceiverUserId` TEXT, `shareableRpcInfoSharedDate` INTEGER, `extendInfo` TEXT, `primaryCTA` TEXT, `backgroundColor` TEXT, `fontColor` TEXT, `minimumTransaction` TEXT, `categoryIconUrl` TEXT, `bizInfo` TEXT, `cacheTimestamp` INTEGER, PRIMARY KEY(`pocketId`))");
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `KtpDaoEntity` (`pocketId` TEXT NOT NULL, `pocketStatus` TEXT NOT NULL, `pocketType` TEXT NOT NULL, `backgroundUrl` TEXT NOT NULL, `createdDate` INTEGER, `iconUrl` TEXT, `logoUrl` TEXT, `extendInfo` TEXT, `cardTitle` TEXT, PRIMARY KEY(`pocketId`))");
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `UserInfoEntity` (`userId` TEXT NOT NULL, `accountStatus` TEXT, `avatarUrl` TEXT, `balance` TEXT, `ktpName` TEXT, `kybInfo` TEXT, `kyc` TEXT, `kycCertified` INTEGER, `kycLevel` TEXT, `loginStatus` TEXT, `userStatus` TEXT, `ncc` TEXT, `loginId` TEXT, `nickname` TEXT, `pendingTransaction` TEXT, `shortcode` TEXT, `faceAuthStatus` INTEGER, `enrollStatus` INTEGER, `faceLoginReady` INTEGER, `username` TEXT, `userPan` TEXT, PRIMARY KEY(`userId`))");
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `RecentRecipientEntity` (`dataId` TEXT NOT NULL, `alias` TEXT, `id` TEXT, `imageUrl` TEXT, `instLocalName` TEXT, `lastUpdated` INTEGER NOT NULL DEFAULT 0, `lastUpdateTime` INTEGER NOT NULL DEFAULT 0, `name` TEXT, `number` TEXT, `recipientName` TEXT, `senderName` TEXT, `payMethod` TEXT, `payOption` TEXT, `cardIndexNo` TEXT, `prefix` TEXT, `transactionCount` INTEGER NOT NULL DEFAULT 0, `isFavorite` INTEGER NOT NULL DEFAULT 0, `type` INTEGER NOT NULL DEFAULT 0, `participantCount` INTEGER, PRIMARY KEY(`dataId`))");
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ActivityItemEntity` (`entityId` TEXT NOT NULL, `activityId` TEXT NOT NULL, `commentCounts` INTEGER, `content` TEXT, `caption` TEXT, `createdTime` INTEGER, `extendInfo` TEXT, `iconUrl` TEXT, `id` TEXT, `imageUrls` TEXT, `ownActivity` INTEGER, `read` INTEGER, `redirectType` TEXT, `redirectValue` TEXT, `widget` TEXT, `latestComments` TEXT, `ownComments` TEXT, `ownReactions` TEXT, `reactionCounts` TEXT, `groupName` TEXT, `groupId` TEXT, `groupActorCount` INTEGER, `state` TEXT, `isSubmitFeedBanner` INTEGER, PRIMARY KEY(`entityId`))");
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `NewsWidgetActivityDaoEntity` (`activityId` TEXT NOT NULL, `activityContent` TEXT, `activityTitle` TEXT, `actorAvatar` TEXT, `actorNickname` TEXT, `bizType` TEXT, `clickable` INTEGER NOT NULL, `content` TEXT, `createdTime` INTEGER, `feedType` TEXT, `imageUrl` TEXT, `redirectUrl` TEXT, `targetNickname` TEXT, `verb` TEXT, PRIMARY KEY(`activityId`))");
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `PromoBannerContentDaoEntity` (`bizType` TEXT, `contentId` TEXT NOT NULL, `contentName` TEXT, `contentType` TEXT, `contentValue` TEXT, `effectiveDate` TEXT, `envType` TEXT, `expireDate` TEXT, `gmtCreate` TEXT, `gmtModified` TEXT, `language` TEXT, `priority` INTEGER, `redirectUrl` TEXT, `selectRule` TEXT, `spaceCode` TEXT, `status` TEXT, `tenantId` TEXT, `extendInfo` TEXT, `orderNo` INTEGER NOT NULL, PRIMARY KEY(`contentId`))");
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `PromoBannerAnnouncementDaoEntity` (`subscriptionId` TEXT NOT NULL, `contentName` TEXT, `contentType` TEXT, `contentValue` TEXT, `redirectUrl` TEXT, `subMerchantId` TEXT, `title` TEXT, `subtitle` TEXT, `goodsName` TEXT, `goodsType` TEXT, `subscriptionDueDate` TEXT, `paymentStatus` TEXT, `totalAmount` TEXT, `iconUrl` TEXT, PRIMARY KEY(`subscriptionId`))");
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SingleBalanceDaoEntity` (`userId` TEXT NOT NULL, `amount` TEXT, `currency` TEXT, `placeholder` INTEGER NOT NULL, PRIMARY KEY(`userId`))");
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `MoreForYouDaoEntity` (`contentId` TEXT NOT NULL, `clientId` TEXT, `scopes` TEXT, `redirectType` TEXT, `icon` TEXT, `title` TEXT, `subtitle` TEXT, `redirectUrl` TEXT, `contentName` TEXT, `contentType` TEXT, `spaceCode` TEXT, `priority` INTEGER, `createdDate` INTEGER, `bizScenario` TEXT, `localIconId` INTEGER, `expireDate` TEXT, `orderNo` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`contentId`))");
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                    supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '088f3559112d15abeae846ebac9a66a9')");
                    int i3 = BuiltInFictitiousFunctionClassFactory + 57;
                    PlaceComponentResult = i3 % 128;
                    if ((i3 % 2 != 0 ? '_' : 'E') != 'E') {
                        Object obj = null;
                        obj.hashCode();
                    }
                } catch (Exception e) {
                    throw e;
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `DanaUserContactEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SplitBillHistoryEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `RecentPayerSplitBillEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `FollowerItemEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `FollowingItemEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `RecentPoiEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `LoyaltyReceiptEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `UserContactEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `UserPaymentAssetsDaoEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `UserPocketAssetsDaoEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `KtpDaoEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `UserInfoEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `RecentRecipientEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `ActivityItemEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `NewsWidgetActivityDaoEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `PromoBannerContentDaoEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `PromoBannerAnnouncementDaoEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SingleBalanceDaoEntity`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `MoreForYouDaoEntity`");
                if (!(this.KClassImpl$Data$declaredNonStaticMembers$2.mCallbacks != null)) {
                    return;
                }
                int i = PlaceComponentResult + 9;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                int size = this.KClassImpl$Data$declaredNonStaticMembers$2.mCallbacks.size();
                int i3 = 0;
                while (true) {
                    if (!(i3 < size)) {
                        return;
                    }
                    int i4 = PlaceComponentResult + 69;
                    BuiltInFictitiousFunctionClassFactory = i4 % 128;
                    if (i4 % 2 == 0) {
                        RoomDatabase.Callback callback = (RoomDatabase.Callback) this.KClassImpl$Data$declaredNonStaticMembers$2.mCallbacks.get(i3);
                        i3 += 121;
                    } else {
                        try {
                            try {
                                RoomDatabase.Callback callback2 = (RoomDatabase.Callback) this.KClassImpl$Data$declaredNonStaticMembers$2.mCallbacks.get(i3);
                                i3++;
                            } catch (Exception e) {
                                throw e;
                            }
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                int size;
                int i;
                if (this.KClassImpl$Data$declaredNonStaticMembers$2.mCallbacks == null) {
                    return;
                }
                int i2 = PlaceComponentResult + 97;
                BuiltInFictitiousFunctionClassFactory = i2 % 128;
                if ((i2 % 2 == 0 ? '\t' : Typography.quote) != '\t') {
                    size = this.KClassImpl$Data$declaredNonStaticMembers$2.mCallbacks.size();
                    i = 0;
                } else {
                    try {
                        size = this.KClassImpl$Data$declaredNonStaticMembers$2.mCallbacks.size();
                        i = 1;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                while (true) {
                    if (!(i < size)) {
                        return;
                    }
                    RoomDatabase.Callback callback = (RoomDatabase.Callback) this.KClassImpl$Data$declaredNonStaticMembers$2.mCallbacks.get(i);
                    i++;
                    int i3 = BuiltInFictitiousFunctionClassFactory + 107;
                    PlaceComponentResult = i3 % 128;
                    int i4 = i3 % 2;
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                int i = PlaceComponentResult + 51;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                try {
                    this.KClassImpl$Data$declaredNonStaticMembers$2.mDatabase = supportSQLiteDatabase;
                    this.KClassImpl$Data$declaredNonStaticMembers$2.internalInitInvalidationTracker(supportSQLiteDatabase);
                    if (!(this.KClassImpl$Data$declaredNonStaticMembers$2.mCallbacks == null)) {
                        int size = this.KClassImpl$Data$declaredNonStaticMembers$2.mCallbacks.size();
                        int i3 = 0;
                        while (true) {
                            if ((i3 < size ? '^' : 'D') != '^') {
                                break;
                            }
                            int i4 = BuiltInFictitiousFunctionClassFactory + 27;
                            PlaceComponentResult = i4 % 128;
                            if ((i4 % 2 != 0 ? (char) 1 : ';') != 1) {
                                ((RoomDatabase.Callback) this.KClassImpl$Data$declaredNonStaticMembers$2.mCallbacks.get(i3)).KClassImpl$Data$declaredNonStaticMembers$2(supportSQLiteDatabase);
                                i3++;
                            } else {
                                ((RoomDatabase.Callback) this.KClassImpl$Data$declaredNonStaticMembers$2.mCallbacks.get(i3)).KClassImpl$Data$declaredNonStaticMembers$2(supportSQLiteDatabase);
                                i3 += 115;
                            }
                        }
                    }
                    int i5 = BuiltInFictitiousFunctionClassFactory + 51;
                    PlaceComponentResult = i5 % 128;
                    if ((i5 % 2 != 0 ? 'Q' : '\\') != '\\') {
                        int i6 = 8 / 0;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                int i = BuiltInFictitiousFunctionClassFactory + 101;
                PlaceComponentResult = i % 128;
                char c = i % 2 != 0 ? '6' : 'H';
                DBUtil.KClassImpl$Data$declaredNonStaticMembers$2(supportSQLiteDatabase);
                if (c == '6') {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                int i2 = PlaceComponentResult + 5;
                BuiltInFictitiousFunctionClassFactory = i2 % 128;
                int i3 = i2 % 2;
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                boolean z;
                boolean z2;
                HashMap hashMap = new HashMap(4);
                hashMap.put(BaseKey.LAST_UPDATED, new TableInfo.Column(BaseKey.LAST_UPDATED, "INTEGER", true, 0, null, 1));
                hashMap.put("phoneNumber", new TableInfo.Column("phoneNumber", "TEXT", false, 0, null, 1));
                hashMap.put("uid", new TableInfo.Column("uid", "INTEGER", true, 1, null, 1));
                hashMap.put("userId", new TableInfo.Column("userId", "TEXT", false, 0, null, 1));
                TableInfo tableInfo = new TableInfo("DanaUserContactEntity", hashMap, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory2 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "DanaUserContactEntity");
                if (!tableInfo.equals(BuiltInFictitiousFunctionClassFactory2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("DanaUserContactEntity(id.dana.data.recentcontact.repository.source.persistence.entity.DanaUserContactEntity).\n Expected:\n");
                    sb.append(tableInfo);
                    sb.append("\n Found:\n");
                    sb.append(BuiltInFictitiousFunctionClassFactory2);
                    RoomOpenHelper.ValidationResult validationResult = new RoomOpenHelper.ValidationResult(false, sb.toString());
                    int i = BuiltInFictitiousFunctionClassFactory + 89;
                    PlaceComponentResult = i % 128;
                    int i2 = i % 2;
                    return validationResult;
                }
                HashMap hashMap2 = new HashMap(11);
                hashMap2.put("uid", new TableInfo.Column("uid", "INTEGER", true, 1, null, 1));
                hashMap2.put(DecodedScanBizInfoKey.COMMENT, new TableInfo.Column(DecodedScanBizInfoKey.COMMENT, "TEXT", false, 0, null, 1));
                hashMap2.put("deepLinkUrl", new TableInfo.Column("deepLinkUrl", "TEXT", false, 0, null, 1));
                hashMap2.put("payers", new TableInfo.Column("payers", "TEXT", false, 0, null, 1));
                hashMap2.put(BaseKey.LAST_UPDATED, new TableInfo.Column(BaseKey.LAST_UPDATED, "INTEGER", true, 0, null, 1));
                hashMap2.put(DecodedScanBizInfoKey.SPLIT_BILL_ID, new TableInfo.Column(DecodedScanBizInfoKey.SPLIT_BILL_ID, "TEXT", false, 0, null, 1));
                hashMap2.put("createdDate", new TableInfo.Column("createdDate", "INTEGER", true, 0, null, 1));
                hashMap2.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, 1));
                hashMap2.put("totalAmount", new TableInfo.Column("totalAmount", "TEXT", false, 0, null, 1));
                hashMap2.put(DecodedScanBizInfoKey.PAYEE_INDEX, new TableInfo.Column(DecodedScanBizInfoKey.PAYEE_INDEX, "INTEGER", true, 0, null, 1));
                hashMap2.put(DecodedScanBizInfoKey.PAYER_INDEX, new TableInfo.Column(DecodedScanBizInfoKey.PAYER_INDEX, "INTEGER", true, 0, null, 1));
                TableInfo tableInfo2 = new TableInfo("SplitBillHistoryEntity", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory3 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "SplitBillHistoryEntity");
                Object[] objArr = null;
                if (!tableInfo2.equals(BuiltInFictitiousFunctionClassFactory3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SplitBillHistoryEntity(id.dana.data.splitbill.repository.source.persistence.entity.SplitBillHistoryEntity).\n Expected:\n");
                    sb2.append(tableInfo2);
                    sb2.append("\n Found:\n");
                    sb2.append(BuiltInFictitiousFunctionClassFactory3);
                    RoomOpenHelper.ValidationResult validationResult2 = new RoomOpenHelper.ValidationResult(false, sb2.toString());
                    int i3 = BuiltInFictitiousFunctionClassFactory + 53;
                    PlaceComponentResult = i3 % 128;
                    if (!(i3 % 2 == 0)) {
                        int length = objArr.length;
                        return validationResult2;
                    }
                    return validationResult2;
                }
                HashMap hashMap3 = new HashMap(8);
                hashMap3.put("uid", new TableInfo.Column("uid", "INTEGER", true, 1, null, 1));
                hashMap3.put("userId", new TableInfo.Column("userId", "TEXT", false, 0, null, 1));
                hashMap3.put("userPhoneNumber", new TableInfo.Column("userPhoneNumber", "TEXT", false, 0, null, 1));
                hashMap3.put("userNickname", new TableInfo.Column("userNickname", "TEXT", false, 0, null, 1));
                hashMap3.put("avatar", new TableInfo.Column("avatar", "TEXT", false, 0, null, 1));
                hashMap3.put(BaseKey.LAST_UPDATED, new TableInfo.Column(BaseKey.LAST_UPDATED, "INTEGER", true, 0, null, 1));
                hashMap3.put("shownName", new TableInfo.Column("shownName", "TEXT", false, 0, null, 1));
                hashMap3.put("shownNumber", new TableInfo.Column("shownNumber", "TEXT", false, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("RecentPayerSplitBillEntity", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory4 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "RecentPayerSplitBillEntity");
                if (!tableInfo3.equals(BuiltInFictitiousFunctionClassFactory4)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("RecentPayerSplitBillEntity(id.dana.data.splitbill.repository.source.persistence.entity.RecentPayerSplitBillEntity).\n Expected:\n");
                    sb3.append(tableInfo3);
                    sb3.append("\n Found:\n");
                    sb3.append(BuiltInFictitiousFunctionClassFactory4);
                    return new RoomOpenHelper.ValidationResult(false, sb3.toString());
                }
                HashMap hashMap4 = new HashMap(8);
                hashMap4.put("userId", new TableInfo.Column("userId", "TEXT", true, 1, null, 1));
                hashMap4.put(BranchLinkConstant.Params.LOGIN_ID, new TableInfo.Column(BranchLinkConstant.Params.LOGIN_ID, "TEXT", true, 0, null, 1));
                hashMap4.put("nickName", new TableInfo.Column("nickName", "TEXT", true, 0, null, 1));
                hashMap4.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, 1));
                hashMap4.put("gmtCreate", new TableInfo.Column("gmtCreate", "INTEGER", true, 0, null, 1));
                hashMap4.put("gmtModified", new TableInfo.Column("gmtModified", "INTEGER", true, 0, null, 1));
                hashMap4.put("avatar", new TableInfo.Column("avatar", "TEXT", false, 0, null, 1));
                hashMap4.put("username", new TableInfo.Column("username", "TEXT", true, 0, null, 1));
                TableInfo tableInfo4 = new TableInfo("FollowerItemEntity", hashMap4, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory5 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "FollowerItemEntity");
                if (!tableInfo4.equals(BuiltInFictitiousFunctionClassFactory5)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("FollowerItemEntity(id.dana.data.social.repository.source.persistence.entity.FollowerItemEntity).\n Expected:\n");
                    sb4.append(tableInfo4);
                    sb4.append("\n Found:\n");
                    sb4.append(BuiltInFictitiousFunctionClassFactory5);
                    return new RoomOpenHelper.ValidationResult(false, sb4.toString());
                }
                HashMap hashMap5 = new HashMap(8);
                hashMap5.put("userId", new TableInfo.Column("userId", "TEXT", true, 1, null, 1));
                hashMap5.put(BranchLinkConstant.Params.LOGIN_ID, new TableInfo.Column(BranchLinkConstant.Params.LOGIN_ID, "TEXT", true, 0, null, 1));
                hashMap5.put("nickName", new TableInfo.Column("nickName", "TEXT", true, 0, null, 1));
                hashMap5.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, 1));
                hashMap5.put("gmtCreate", new TableInfo.Column("gmtCreate", "INTEGER", true, 0, null, 1));
                hashMap5.put("gmtModified", new TableInfo.Column("gmtModified", "INTEGER", true, 0, null, 1));
                hashMap5.put("avatar", new TableInfo.Column("avatar", "TEXT", false, 0, null, 1));
                hashMap5.put("username", new TableInfo.Column("username", "TEXT", true, 0, null, 1));
                TableInfo tableInfo5 = new TableInfo("FollowingItemEntity", hashMap5, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory6 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "FollowingItemEntity");
                if (!tableInfo5.equals(BuiltInFictitiousFunctionClassFactory6)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("FollowingItemEntity(id.dana.data.social.repository.source.persistence.entity.FollowingItemEntity).\n Expected:\n");
                    sb5.append(tableInfo5);
                    sb5.append("\n Found:\n");
                    sb5.append(BuiltInFictitiousFunctionClassFactory6);
                    return new RoomOpenHelper.ValidationResult(false, sb5.toString());
                }
                HashMap hashMap6 = new HashMap(5);
                hashMap6.put("poiId", new TableInfo.Column("poiId", "TEXT", true, 1, null, 1));
                hashMap6.put("radius", new TableInfo.Column("radius", "INTEGER", true, 0, null, 1));
                hashMap6.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, null, 1));
                hashMap6.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, null, 1));
                hashMap6.put("lastPoiNotified", new TableInfo.Column("lastPoiNotified", "INTEGER", false, 0, null, 1));
                TableInfo tableInfo6 = new TableInfo("RecentPoiEntity", hashMap6, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory7 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "RecentPoiEntity");
                if (!tableInfo6.equals(BuiltInFictitiousFunctionClassFactory7)) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("RecentPoiEntity(id.dana.data.geofence.repository.source.persistence.entity.RecentPoiEntity).\n Expected:\n");
                    sb6.append(tableInfo6);
                    sb6.append("\n Found:\n");
                    sb6.append(BuiltInFictitiousFunctionClassFactory7);
                    return new RoomOpenHelper.ValidationResult(false, sb6.toString());
                }
                HashMap hashMap7 = new HashMap(8);
                hashMap7.put("userLoyaltyId", new TableInfo.Column("userLoyaltyId", "TEXT", true, 1, null, 1));
                hashMap7.put("merchantId", new TableInfo.Column("merchantId", "TEXT", true, 0, null, 1));
                hashMap7.put("orderId", new TableInfo.Column("orderId", "TEXT", true, 0, null, 1));
                hashMap7.put("merchantName", new TableInfo.Column("merchantName", "TEXT", true, 0, null, 1));
                hashMap7.put(CashierKeyParams.TOTAL_AMOUNT, new TableInfo.Column(CashierKeyParams.TOTAL_AMOUNT, "TEXT", true, 0, null, 1));
                hashMap7.put("timestamp", new TableInfo.Column("timestamp", "TEXT", true, 0, null, 1));
                hashMap7.put(BridgeKey.FILE_PATH, new TableInfo.Column(BridgeKey.FILE_PATH, "TEXT", true, 0, null, 1));
                hashMap7.put("rawText", new TableInfo.Column("rawText", "TEXT", true, 0, null, 1));
                TableInfo tableInfo7 = new TableInfo("LoyaltyReceiptEntity", hashMap7, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory8 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "LoyaltyReceiptEntity");
                if (!tableInfo7.equals(BuiltInFictitiousFunctionClassFactory8)) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("LoyaltyReceiptEntity(id.dana.data.loyalty.repository.source.local.entity.LoyaltyReceiptEntity).\n Expected:\n");
                    sb7.append(tableInfo7);
                    sb7.append("\n Found:\n");
                    sb7.append(BuiltInFictitiousFunctionClassFactory8);
                    return new RoomOpenHelper.ValidationResult(false, sb7.toString());
                }
                HashMap hashMap8 = new HashMap(8);
                hashMap8.put("uid", new TableInfo.Column("uid", "INTEGER", true, 1, null, 1));
                hashMap8.put("phoneNumber", new TableInfo.Column("phoneNumber", "TEXT", true, 0, null, 1));
                hashMap8.put("rawPhoneNumber", new TableInfo.Column("rawPhoneNumber", "TEXT", true, 0, null, 1));
                hashMap8.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, 1));
                hashMap8.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", false, 0, null, 1));
                hashMap8.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", false, 0, null, 1));
                hashMap8.put("isDanaUser", new TableInfo.Column("isDanaUser", "INTEGER", false, 0, null, 1));
                hashMap8.put("displayPhoto", new TableInfo.Column("displayPhoto", "TEXT", false, 0, null, 1));
                TableInfo tableInfo8 = new TableInfo("UserContactEntity", hashMap8, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory9 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "UserContactEntity");
                if (!tableInfo8.equals(BuiltInFictitiousFunctionClassFactory9)) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append("UserContactEntity(id.dana.data.recentcontact.repository.source.persistence.entity.UserContactEntity).\n Expected:\n");
                    sb8.append(tableInfo8);
                    sb8.append("\n Found:\n");
                    sb8.append(BuiltInFictitiousFunctionClassFactory9);
                    return new RoomOpenHelper.ValidationResult(false, sb8.toString());
                }
                HashMap hashMap9 = new HashMap(91);
                hashMap9.put("uniqueId", new TableInfo.Column("uniqueId", "TEXT", true, 1, null, 1));
                hashMap9.put(HomeTabActivity.WALLET_SECTION, new TableInfo.Column(HomeTabActivity.WALLET_SECTION, "TEXT", false, 0, null, 1));
                hashMap9.put("amount", new TableInfo.Column("amount", "TEXT", false, 0, null, 1));
                hashMap9.put(FirebaseAnalytics.Param.CURRENCY, new TableInfo.Column(FirebaseAnalytics.Param.CURRENCY, "TEXT", false, 0, null, 1));
                hashMap9.put("limitAmount", new TableInfo.Column("limitAmount", "TEXT", false, 0, null, 1));
                hashMap9.put("limitCurrency", new TableInfo.Column("limitCurrency", "TEXT", false, 0, null, 1));
                hashMap9.put("limitCurrencyCode", new TableInfo.Column("limitCurrencyCode", "TEXT", false, 0, null, 1));
                hashMap9.put("balanceAmount", new TableInfo.Column("balanceAmount", "TEXT", false, 0, null, 1));
                hashMap9.put("balanceCurrency", new TableInfo.Column("balanceCurrency", "TEXT", false, 0, null, 1));
                hashMap9.put("balanceCurrencyCode", new TableInfo.Column("balanceCurrencyCode", "TEXT", false, 0, null, 1));
                hashMap9.put("unpaidAmountAmount", new TableInfo.Column("unpaidAmountAmount", "TEXT", false, 0, null, 1));
                hashMap9.put("unpaidAmountCurrency", new TableInfo.Column("unpaidAmountCurrency", "TEXT", false, 0, null, 1));
                hashMap9.put("unpaidAmountCurrencyCode", new TableInfo.Column("unpaidAmountCurrencyCode", "TEXT", false, 0, null, 1));
                hashMap9.put("overdueTips", new TableInfo.Column("overdueTips", "TEXT", false, 0, null, 1));
                hashMap9.put("overdueStatus", new TableInfo.Column("overdueStatus", "INTEGER", false, 0, null, 1));
                hashMap9.put("accountId", new TableInfo.Column("accountId", "TEXT", false, 0, null, 1));
                hashMap9.put("gmtCreate", new TableInfo.Column("gmtCreate", "TEXT", false, 0, null, 1));
                hashMap9.put("gmtModified", new TableInfo.Column("gmtModified", "TEXT", false, 0, null, 1));
                hashMap9.put("assetBiztype", new TableInfo.Column("assetBiztype", "TEXT", false, 0, null, 1));
                hashMap9.put("cardTitle", new TableInfo.Column("cardTitle", "TEXT", false, 0, null, 1));
                hashMap9.put(WalletConstant.CARD_INDEX_NO, new TableInfo.Column(WalletConstant.CARD_INDEX_NO, "TEXT", false, 0, null, 1));
                hashMap9.put("cardNoLength", new TableInfo.Column("cardNoLength", "TEXT", false, 0, null, 1));
                hashMap9.put("maskedCardNo", new TableInfo.Column("maskedCardNo", "TEXT", false, 0, null, 1));
                hashMap9.put("assetType", new TableInfo.Column("assetType", "TEXT", false, 0, null, 1));
                hashMap9.put("cardScheme", new TableInfo.Column("cardScheme", "TEXT", false, 0, null, 1));
                hashMap9.put("holderName", new TableInfo.Column("holderName", "TEXT", false, 0, null, 1));
                hashMap9.put("instLogoUrl", new TableInfo.Column("instLogoUrl", "TEXT", false, 0, null, 1));
                hashMap9.put("instId", new TableInfo.Column("instId", "TEXT", false, 0, null, 1));
                hashMap9.put("instOfficialName", new TableInfo.Column("instOfficialName", "TEXT", false, 0, null, 1));
                hashMap9.put("instBranchId", new TableInfo.Column("instBranchId", "TEXT", false, 0, null, 1));
                hashMap9.put("instBranchOfficialName", new TableInfo.Column("instBranchOfficialName", "TEXT", false, 0, null, 1));
                hashMap9.put("expiryYear", new TableInfo.Column("expiryYear", "TEXT", false, 0, null, 1));
                hashMap9.put("expiryMonth", new TableInfo.Column("expiryMonth", "TEXT", false, 0, null, 1));
                hashMap9.put("verified", new TableInfo.Column("verified", "INTEGER", false, 0, null, 1));
                hashMap9.put("bindingId", new TableInfo.Column("bindingId", "TEXT", false, 0, null, 1));
                hashMap9.put("accountNo", new TableInfo.Column("accountNo", "TEXT", false, 0, null, 1));
                hashMap9.put("defaultAsset", new TableInfo.Column("defaultAsset", "TEXT", false, 0, null, 1));
                hashMap9.put("extInfo", new TableInfo.Column("extInfo", "TEXT", false, 0, null, 1));
                hashMap9.put("enableStatus", new TableInfo.Column("enableStatus", "INTEGER", false, 0, null, 1));
                hashMap9.put("bankMobileNo", new TableInfo.Column("bankMobileNo", "TEXT", false, 0, null, 1));
                hashMap9.put("directDebit", new TableInfo.Column("directDebit", "INTEGER", false, 0, null, 1));
                hashMap9.put("personalDailyLimitAmount", new TableInfo.Column("personalDailyLimitAmount", "TEXT", false, 0, null, 1));
                hashMap9.put("personalDailyLimitCurrency", new TableInfo.Column("personalDailyLimitCurrency", "TEXT", false, 0, null, 1));
                hashMap9.put("personalDailyLimitCurrencyCode", new TableInfo.Column("personalDailyLimitCurrencyCode", "TEXT", false, 0, null, 1));
                hashMap9.put("userPhoneNo", new TableInfo.Column("userPhoneNo", "TEXT", false, 0, null, 1));
                hashMap9.put("contactBizType", new TableInfo.Column("contactBizType", "TEXT", false, 0, null, 1));
                hashMap9.put("goodsId", new TableInfo.Column("goodsId", "TEXT", false, 0, null, 1));
                hashMap9.put("aggregator", new TableInfo.Column("aggregator", "TEXT", false, 0, null, 1));
                hashMap9.put("userId", new TableInfo.Column("userId", "TEXT", false, 0, null, 1));
                hashMap9.put("accountStatus", new TableInfo.Column("accountStatus", "TEXT", false, 0, null, 1));
                hashMap9.put("availableBalanceAmount", new TableInfo.Column("availableBalanceAmount", "INTEGER", false, 0, null, 1));
                hashMap9.put("availableBalanceCent", new TableInfo.Column("availableBalanceCent", "INTEGER", false, 0, null, 1));
                hashMap9.put("availableBalanceCentFactor", new TableInfo.Column("availableBalanceCentFactor", "INTEGER", false, 0, null, 1));
                hashMap9.put("availableBalanceCurrency", new TableInfo.Column("availableBalanceCurrency", "TEXT", false, 0, null, 1));
                hashMap9.put("availableBalanceCurrencyCode", new TableInfo.Column("availableBalanceCurrencyCode", "TEXT", false, 0, null, 1));
                hashMap9.put("availableBalanceCurrencyValue", new TableInfo.Column("availableBalanceCurrencyValue", "TEXT", false, 0, null, 1));
                hashMap9.put("balanceUnitType", new TableInfo.Column("balanceUnitType", "TEXT", false, 0, null, 1));
                hashMap9.put("balanceUnitUnit", new TableInfo.Column("balanceUnitUnit", "INTEGER", false, 0, null, 1));
                hashMap9.put("balanceUnitUnitValue", new TableInfo.Column("balanceUnitUnitValue", "TEXT", false, 0, null, 1));
                hashMap9.put("totalGainLossAmountAmount", new TableInfo.Column("totalGainLossAmountAmount", "INTEGER", false, 0, null, 1));
                hashMap9.put("totalGainLossAmountCent", new TableInfo.Column("totalGainLossAmountCent", "INTEGER", false, 0, null, 1));
                hashMap9.put("totalGainLossAmountCentFactor", new TableInfo.Column("totalGainLossAmountCentFactor", "INTEGER", false, 0, null, 1));
                hashMap9.put("totalGainLossAmountCurrency", new TableInfo.Column("totalGainLossAmountCurrency", "TEXT", false, 0, null, 1));
                hashMap9.put("totalGainLossAmountCurrencyCode", new TableInfo.Column("totalGainLossAmountCurrencyCode", "TEXT", false, 0, null, 1));
                hashMap9.put("totalGainLossAmountCurrencyValue", new TableInfo.Column("totalGainLossAmountCurrencyValue", "TEXT", false, 0, null, 1));
                hashMap9.put("totalGainLossPercentage", new TableInfo.Column("totalGainLossPercentage", "TEXT", false, 0, null, 1));
                hashMap9.put("dailyGainLossAmountAmount", new TableInfo.Column("dailyGainLossAmountAmount", "INTEGER", false, 0, null, 1));
                hashMap9.put("dailyGainLossAmountCent", new TableInfo.Column("dailyGainLossAmountCent", "INTEGER", false, 0, null, 1));
                hashMap9.put("dailyGainLossAmountCentFactor", new TableInfo.Column("dailyGainLossAmountCentFactor", "INTEGER", false, 0, null, 1));
                hashMap9.put("dailyGainLossAmountCurrency", new TableInfo.Column("dailyGainLossAmountCurrency", "TEXT", false, 0, null, 1));
                hashMap9.put("dailyGainLossAmountCurrencyCode", new TableInfo.Column("dailyGainLossAmountCurrencyCode", "TEXT", false, 0, null, 1));
                hashMap9.put("dailyGainLossAmountCurrencyValue", new TableInfo.Column("dailyGainLossAmountCurrencyValue", "TEXT", false, 0, null, 1));
                hashMap9.put("dailyGainLossPercentage", new TableInfo.Column("dailyGainLossPercentage", "TEXT", false, 0, null, 1));
                hashMap9.put(BaseKey.LAST_UPDATED, new TableInfo.Column(BaseKey.LAST_UPDATED, "INTEGER", false, 0, null, 1));
                hashMap9.put("savingId", new TableInfo.Column("savingId", "TEXT", false, 0, null, 1));
                hashMap9.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, 1));
                hashMap9.put("categoryCode", new TableInfo.Column("categoryCode", "TEXT", false, 0, null, 1));
                hashMap9.put("currentAmountAmount", new TableInfo.Column("currentAmountAmount", "TEXT", false, 0, null, 1));
                hashMap9.put("currentAmountCurrency", new TableInfo.Column("currentAmountCurrency", "TEXT", false, 0, null, 1));
                hashMap9.put("currentAmountCurrencyCode", new TableInfo.Column("currentAmountCurrencyCode", "TEXT", false, 0, null, 1));
                hashMap9.put("targetAmountAmount", new TableInfo.Column("targetAmountAmount", "TEXT", false, 0, null, 1));
                hashMap9.put("targetAmountCurrency", new TableInfo.Column("targetAmountCurrency", "TEXT", false, 0, null, 1));
                hashMap9.put("targetAmountCurrencyCode", new TableInfo.Column("targetAmountCurrencyCode", "TEXT", false, 0, null, 1));
                hashMap9.put("orderStatus", new TableInfo.Column("orderStatus", "TEXT", false, 0, null, 1));
                hashMap9.put("orderSubStatus", new TableInfo.Column("orderSubStatus", "TEXT", false, 0, null, 1));
                hashMap9.put("createdTime", new TableInfo.Column("createdTime", "INTEGER", false, 0, null, 1));
                hashMap9.put("achievedTime", new TableInfo.Column("achievedTime", "INTEGER", false, 0, null, 1));
                hashMap9.put("completedTime", new TableInfo.Column("completedTime", "INTEGER", false, 0, null, 1));
                hashMap9.put("extendInfo", new TableInfo.Column("extendInfo", "TEXT", false, 0, null, 1));
                hashMap9.put("cardBackground", new TableInfo.Column("cardBackground", "TEXT", false, 0, null, 1));
                hashMap9.put("cacheTimestamp", new TableInfo.Column("cacheTimestamp", "INTEGER", false, 0, null, 1));
                TableInfo tableInfo9 = new TableInfo(WalletRecommendationConstant.USER_PAYMENT_ASSET_DAO, hashMap9, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory10 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, WalletRecommendationConstant.USER_PAYMENT_ASSET_DAO);
                if (!tableInfo9.equals(BuiltInFictitiousFunctionClassFactory10)) {
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append("UserPaymentAssetsDaoEntity(id.dana.data.wallet_v3.repository.source.persistence.entity.UserPaymentAssetsDaoEntity).\n Expected:\n");
                    sb9.append(tableInfo9);
                    sb9.append("\n Found:\n");
                    sb9.append(BuiltInFictitiousFunctionClassFactory10);
                    return new RoomOpenHelper.ValidationResult(false, sb9.toString());
                }
                HashMap hashMap10 = new HashMap(29);
                hashMap10.put("pocketId", new TableInfo.Column("pocketId", "TEXT", true, 1, null, 1));
                hashMap10.put("pocketStatus", new TableInfo.Column("pocketStatus", "TEXT", true, 0, null, 1));
                hashMap10.put("iconUrl", new TableInfo.Column("iconUrl", "TEXT", true, 0, null, 1));
                hashMap10.put("backgroundUrl", new TableInfo.Column("backgroundUrl", "TEXT", true, 0, null, 1));
                hashMap10.put("pocketType", new TableInfo.Column("pocketType", "TEXT", false, 0, null, 1));
                hashMap10.put("userPocketStatus", new TableInfo.Column("userPocketStatus", "TEXT", false, 0, null, 1));
                hashMap10.put("activateDate", new TableInfo.Column("activateDate", "INTEGER", false, 0, null, 1));
                hashMap10.put("howTo", new TableInfo.Column("howTo", "TEXT", false, 0, null, 1));
                hashMap10.put("merchantId", new TableInfo.Column("merchantId", "TEXT", false, 0, null, 1));
                hashMap10.put(Constants.ScionAnalytics.PARAM_LABEL, new TableInfo.Column(Constants.ScionAnalytics.PARAM_LABEL, "TEXT", false, 0, null, 1));
                hashMap10.put("subLabel", new TableInfo.Column("subLabel", "TEXT", false, 0, null, 1));
                hashMap10.put(DecodedScanBizInfoKey.LOGO_URL, new TableInfo.Column(DecodedScanBizInfoKey.LOGO_URL, "TEXT", false, 0, null, 1));
                hashMap10.put("usable", new TableInfo.Column("usable", "INTEGER", false, 0, null, 1));
                hashMap10.put("shareable", new TableInfo.Column("shareable", "INTEGER", false, 0, null, 1));
                hashMap10.put("goodsId", new TableInfo.Column("goodsId", "TEXT", false, 0, null, 1));
                hashMap10.put("tcUrl", new TableInfo.Column("tcUrl", "TEXT", false, 0, null, 1));
                hashMap10.put("expirationDate", new TableInfo.Column("expirationDate", "INTEGER", false, 0, null, 1));
                hashMap10.put("createdDate", new TableInfo.Column("createdDate", "TEXT", false, 0, null, 1));
                hashMap10.put("shareableRpcInfoReceiverInfo", new TableInfo.Column("shareableRpcInfoReceiverInfo", "TEXT", false, 0, null, 1));
                hashMap10.put("shareableRpcInfoReceiverUserId", new TableInfo.Column("shareableRpcInfoReceiverUserId", "TEXT", false, 0, null, 1));
                hashMap10.put("shareableRpcInfoSharedDate", new TableInfo.Column("shareableRpcInfoSharedDate", "INTEGER", false, 0, null, 1));
                hashMap10.put("extendInfo", new TableInfo.Column("extendInfo", "TEXT", false, 0, null, 1));
                hashMap10.put("primaryCTA", new TableInfo.Column("primaryCTA", "TEXT", false, 0, null, 1));
                hashMap10.put("backgroundColor", new TableInfo.Column("backgroundColor", "TEXT", false, 0, null, 1));
                hashMap10.put("fontColor", new TableInfo.Column("fontColor", "TEXT", false, 0, null, 1));
                hashMap10.put("minimumTransaction", new TableInfo.Column("minimumTransaction", "TEXT", false, 0, null, 1));
                hashMap10.put("categoryIconUrl", new TableInfo.Column("categoryIconUrl", "TEXT", false, 0, null, 1));
                hashMap10.put("bizInfo", new TableInfo.Column("bizInfo", "TEXT", false, 0, null, 1));
                hashMap10.put("cacheTimestamp", new TableInfo.Column("cacheTimestamp", "INTEGER", false, 0, null, 1));
                TableInfo tableInfo10 = new TableInfo(WalletRecommendationConstant.USER_POCKET_ASSET_DAO, hashMap10, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory11 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, WalletRecommendationConstant.USER_POCKET_ASSET_DAO);
                if (!tableInfo10.equals(BuiltInFictitiousFunctionClassFactory11)) {
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append("UserPocketAssetsDaoEntity(id.dana.data.wallet_v3.repository.source.persistence.entity.UserPocketAssetsDaoEntity).\n Expected:\n");
                    sb10.append(tableInfo10);
                    sb10.append("\n Found:\n");
                    sb10.append(BuiltInFictitiousFunctionClassFactory11);
                    return new RoomOpenHelper.ValidationResult(false, sb10.toString());
                }
                HashMap hashMap11 = new HashMap(9);
                hashMap11.put("pocketId", new TableInfo.Column("pocketId", "TEXT", true, 1, null, 1));
                hashMap11.put("pocketStatus", new TableInfo.Column("pocketStatus", "TEXT", true, 0, null, 1));
                hashMap11.put("pocketType", new TableInfo.Column("pocketType", "TEXT", true, 0, null, 1));
                hashMap11.put("backgroundUrl", new TableInfo.Column("backgroundUrl", "TEXT", true, 0, null, 1));
                hashMap11.put("createdDate", new TableInfo.Column("createdDate", "INTEGER", false, 0, null, 1));
                hashMap11.put("iconUrl", new TableInfo.Column("iconUrl", "TEXT", false, 0, null, 1));
                hashMap11.put(DecodedScanBizInfoKey.LOGO_URL, new TableInfo.Column(DecodedScanBizInfoKey.LOGO_URL, "TEXT", false, 0, null, 1));
                hashMap11.put("extendInfo", new TableInfo.Column("extendInfo", "TEXT", false, 0, null, 1));
                hashMap11.put("cardTitle", new TableInfo.Column("cardTitle", "TEXT", false, 0, null, 1));
                TableInfo tableInfo11 = new TableInfo(WalletRecommendationConstant.KTP_DAO, hashMap11, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory12 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, WalletRecommendationConstant.KTP_DAO);
                if (!tableInfo11.equals(BuiltInFictitiousFunctionClassFactory12)) {
                    StringBuilder sb11 = new StringBuilder();
                    sb11.append("KtpDaoEntity(id.dana.data.wallet_v3.repository.source.persistence.entity.KtpDaoEntity).\n Expected:\n");
                    sb11.append(tableInfo11);
                    sb11.append("\n Found:\n");
                    sb11.append(BuiltInFictitiousFunctionClassFactory12);
                    return new RoomOpenHelper.ValidationResult(false, sb11.toString());
                }
                HashMap hashMap12 = new HashMap(21);
                hashMap12.put("userId", new TableInfo.Column("userId", "TEXT", true, 1, null, 1));
                hashMap12.put("accountStatus", new TableInfo.Column("accountStatus", "TEXT", false, 0, null, 1));
                hashMap12.put(AccountEntityRepository.UpdateType.AVATAR, new TableInfo.Column(AccountEntityRepository.UpdateType.AVATAR, "TEXT", false, 0, null, 1));
                hashMap12.put("balance", new TableInfo.Column("balance", "TEXT", false, 0, null, 1));
                hashMap12.put("ktpName", new TableInfo.Column("ktpName", "TEXT", false, 0, null, 1));
                hashMap12.put("kybInfo", new TableInfo.Column("kybInfo", "TEXT", false, 0, null, 1));
                Object[] objArr2 = new Object[1];
                a(new int[]{0, 3, 0, 3}, true, new byte[]{1, 0, 0}, objArr2);
                String intern = ((String) objArr2[0]).intern();
                Object[] objArr3 = new Object[1];
                a(new int[]{0, 3, 0, 3}, true, new byte[]{1, 0, 0}, objArr3);
                hashMap12.put(intern, new TableInfo.Column(((String) objArr3[0]).intern(), "TEXT", false, 0, null, 1));
                hashMap12.put("kycCertified", new TableInfo.Column("kycCertified", "INTEGER", false, 0, null, 1));
                hashMap12.put(WalletConstant.KYC_LEVEL, new TableInfo.Column(WalletConstant.KYC_LEVEL, "TEXT", false, 0, null, 1));
                hashMap12.put("loginStatus", new TableInfo.Column("loginStatus", "TEXT", false, 0, null, 1));
                hashMap12.put("userStatus", new TableInfo.Column("userStatus", "TEXT", false, 0, null, 1));
                hashMap12.put("ncc", new TableInfo.Column("ncc", "TEXT", false, 0, null, 1));
                hashMap12.put(BranchLinkConstant.Params.LOGIN_ID, new TableInfo.Column(BranchLinkConstant.Params.LOGIN_ID, "TEXT", false, 0, null, 1));
                hashMap12.put("nickname", new TableInfo.Column("nickname", "TEXT", false, 0, null, 1));
                hashMap12.put("pendingTransaction", new TableInfo.Column("pendingTransaction", "TEXT", false, 0, null, 1));
                hashMap12.put("shortcode", new TableInfo.Column("shortcode", "TEXT", false, 0, null, 1));
                hashMap12.put("faceAuthStatus", new TableInfo.Column("faceAuthStatus", "INTEGER", false, 0, null, 1));
                hashMap12.put("enrollStatus", new TableInfo.Column("enrollStatus", "INTEGER", false, 0, null, 1));
                hashMap12.put("faceLoginReady", new TableInfo.Column("faceLoginReady", "INTEGER", false, 0, null, 1));
                hashMap12.put("username", new TableInfo.Column("username", "TEXT", false, 0, null, 1));
                hashMap12.put("userPan", new TableInfo.Column("userPan", "TEXT", false, 0, null, 1));
                TableInfo tableInfo12 = new TableInfo("UserInfoEntity", hashMap12, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory13 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "UserInfoEntity");
                if (!tableInfo12.equals(BuiltInFictitiousFunctionClassFactory13)) {
                    StringBuilder sb12 = new StringBuilder();
                    sb12.append("UserInfoEntity(id.dana.data.user.source.persistence.entity.UserInfoEntity).\n Expected:\n");
                    sb12.append(tableInfo12);
                    sb12.append("\n Found:\n");
                    sb12.append(BuiltInFictitiousFunctionClassFactory13);
                    return new RoomOpenHelper.ValidationResult(false, sb12.toString());
                }
                HashMap hashMap13 = new HashMap(19);
                hashMap13.put("dataId", new TableInfo.Column("dataId", "TEXT", true, 1, null, 1));
                hashMap13.put("alias", new TableInfo.Column("alias", "TEXT", false, 0, null, 1));
                hashMap13.put("id", new TableInfo.Column("id", "TEXT", false, 0, null, 1));
                hashMap13.put(GriverParams.ShareParams.IMAGE_URL, new TableInfo.Column(GriverParams.ShareParams.IMAGE_URL, "TEXT", false, 0, null, 1));
                hashMap13.put("instLocalName", new TableInfo.Column("instLocalName", "TEXT", false, 0, null, 1));
                hashMap13.put(BaseKey.LAST_UPDATED, new TableInfo.Column(BaseKey.LAST_UPDATED, "INTEGER", true, 0, "0", 1));
                hashMap13.put("lastUpdateTime", new TableInfo.Column("lastUpdateTime", "INTEGER", true, 0, "0", 1));
                hashMap13.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, 1));
                hashMap13.put("number", new TableInfo.Column("number", "TEXT", false, 0, null, 1));
                hashMap13.put("recipientName", new TableInfo.Column("recipientName", "TEXT", false, 0, null, 1));
                hashMap13.put("senderName", new TableInfo.Column("senderName", "TEXT", false, 0, null, 1));
                hashMap13.put("payMethod", new TableInfo.Column("payMethod", "TEXT", false, 0, null, 1));
                hashMap13.put("payOption", new TableInfo.Column("payOption", "TEXT", false, 0, null, 1));
                hashMap13.put(WalletConstant.CARD_INDEX_NO, new TableInfo.Column(WalletConstant.CARD_INDEX_NO, "TEXT", false, 0, null, 1));
                hashMap13.put("prefix", new TableInfo.Column("prefix", "TEXT", false, 0, null, 1));
                hashMap13.put("transactionCount", new TableInfo.Column("transactionCount", "INTEGER", true, 0, "0", 1));
                hashMap13.put(TrackerKey.SendMoneyProperties.IS_FAVORITE, new TableInfo.Column(TrackerKey.SendMoneyProperties.IS_FAVORITE, "INTEGER", true, 0, "0", 1));
                hashMap13.put("type", new TableInfo.Column("type", "INTEGER", true, 0, "0", 1));
                hashMap13.put("participantCount", new TableInfo.Column("participantCount", "INTEGER", false, 0, null, 1));
                TableInfo tableInfo13 = new TableInfo("RecentRecipientEntity", hashMap13, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory14 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "RecentRecipientEntity");
                if (!tableInfo13.equals(BuiltInFictitiousFunctionClassFactory14)) {
                    StringBuilder sb13 = new StringBuilder();
                    sb13.append("RecentRecipientEntity(id.dana.data.recentrecipient.source.persistence.entity.RecentRecipientEntity).\n Expected:\n");
                    sb13.append(tableInfo13);
                    sb13.append("\n Found:\n");
                    sb13.append(BuiltInFictitiousFunctionClassFactory14);
                    return new RoomOpenHelper.ValidationResult(false, sb13.toString());
                }
                HashMap hashMap14 = new HashMap(24);
                hashMap14.put("entityId", new TableInfo.Column("entityId", "TEXT", true, 1, null, 1));
                hashMap14.put(ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, new TableInfo.Column(ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, "TEXT", true, 0, null, 1));
                hashMap14.put("commentCounts", new TableInfo.Column("commentCounts", "INTEGER", false, 0, null, 1));
                hashMap14.put("content", new TableInfo.Column("content", "TEXT", false, 0, null, 1));
                hashMap14.put("caption", new TableInfo.Column("caption", "TEXT", false, 0, null, 1));
                hashMap14.put("createdTime", new TableInfo.Column("createdTime", "INTEGER", false, 0, null, 1));
                hashMap14.put("extendInfo", new TableInfo.Column("extendInfo", "TEXT", false, 0, null, 1));
                hashMap14.put("iconUrl", new TableInfo.Column("iconUrl", "TEXT", false, 0, null, 1));
                hashMap14.put("id", new TableInfo.Column("id", "TEXT", false, 0, null, 1));
                hashMap14.put("imageUrls", new TableInfo.Column("imageUrls", "TEXT", false, 0, null, 1));
                hashMap14.put("ownActivity", new TableInfo.Column("ownActivity", "INTEGER", false, 0, null, 1));
                hashMap14.put("read", new TableInfo.Column("read", "INTEGER", false, 0, null, 1));
                hashMap14.put("redirectType", new TableInfo.Column("redirectType", "TEXT", false, 0, null, 1));
                hashMap14.put(ShareToFeedBridge.REDIRECT_VALUE, new TableInfo.Column(ShareToFeedBridge.REDIRECT_VALUE, "TEXT", false, 0, null, 1));
                hashMap14.put(ShareToFeedBridge.WIDGET, new TableInfo.Column(ShareToFeedBridge.WIDGET, "TEXT", false, 0, null, 1));
                hashMap14.put("latestComments", new TableInfo.Column("latestComments", "TEXT", false, 0, null, 1));
                hashMap14.put("ownComments", new TableInfo.Column("ownComments", "TEXT", false, 0, null, 1));
                hashMap14.put("ownReactions", new TableInfo.Column("ownReactions", "TEXT", false, 0, null, 1));
                hashMap14.put("reactionCounts", new TableInfo.Column("reactionCounts", "TEXT", false, 0, null, 1));
                hashMap14.put("groupName", new TableInfo.Column("groupName", "TEXT", false, 0, null, 1));
                hashMap14.put("groupId", new TableInfo.Column("groupId", "TEXT", false, 0, null, 1));
                hashMap14.put("groupActorCount", new TableInfo.Column("groupActorCount", "INTEGER", false, 0, null, 1));
                hashMap14.put("state", new TableInfo.Column("state", "TEXT", false, 0, null, 1));
                hashMap14.put("isSubmitFeedBanner", new TableInfo.Column("isSubmitFeedBanner", "INTEGER", false, 0, null, 1));
                TableInfo tableInfo14 = new TableInfo("ActivityItemEntity", hashMap14, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory15 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "ActivityItemEntity");
                if (!tableInfo14.equals(BuiltInFictitiousFunctionClassFactory15)) {
                    StringBuilder sb14 = new StringBuilder();
                    sb14.append("ActivityItemEntity(id.dana.data.social.repository.source.persistence.entity.ActivityItemEntity).\n Expected:\n");
                    sb14.append(tableInfo14);
                    sb14.append("\n Found:\n");
                    sb14.append(BuiltInFictitiousFunctionClassFactory15);
                    return new RoomOpenHelper.ValidationResult(false, sb14.toString());
                }
                HashMap hashMap15 = new HashMap(14);
                hashMap15.put(ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, new TableInfo.Column(ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, "TEXT", true, 1, null, 1));
                hashMap15.put("activityContent", new TableInfo.Column("activityContent", "TEXT", false, 0, null, 1));
                hashMap15.put("activityTitle", new TableInfo.Column("activityTitle", "TEXT", false, 0, null, 1));
                hashMap15.put("actorAvatar", new TableInfo.Column("actorAvatar", "TEXT", false, 0, null, 1));
                hashMap15.put("actorNickname", new TableInfo.Column("actorNickname", "TEXT", false, 0, null, 1));
                hashMap15.put("bizType", new TableInfo.Column("bizType", "TEXT", false, 0, null, 1));
                hashMap15.put(ZebraData.ATTR_CLICKABLE, new TableInfo.Column(ZebraData.ATTR_CLICKABLE, "INTEGER", true, 0, null, 1));
                hashMap15.put("content", new TableInfo.Column("content", "TEXT", false, 0, null, 1));
                hashMap15.put("createdTime", new TableInfo.Column("createdTime", "INTEGER", false, 0, null, 1));
                hashMap15.put("feedType", new TableInfo.Column("feedType", "TEXT", false, 0, null, 1));
                hashMap15.put(GriverParams.ShareParams.IMAGE_URL, new TableInfo.Column(GriverParams.ShareParams.IMAGE_URL, "TEXT", false, 0, null, 1));
                hashMap15.put("redirectUrl", new TableInfo.Column("redirectUrl", "TEXT", false, 0, null, 1));
                hashMap15.put("targetNickname", new TableInfo.Column("targetNickname", "TEXT", false, 0, null, 1));
                hashMap15.put("verb", new TableInfo.Column("verb", "TEXT", false, 0, null, 1));
                TableInfo tableInfo15 = new TableInfo("NewsWidgetActivityDaoEntity", hashMap15, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory16 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "NewsWidgetActivityDaoEntity");
                if (!tableInfo15.equals(BuiltInFictitiousFunctionClassFactory16)) {
                    StringBuilder sb15 = new StringBuilder();
                    sb15.append("NewsWidgetActivityDaoEntity(id.dana.data.home.repository.source.presistence.entity.NewsWidgetActivityDaoEntity).\n Expected:\n");
                    sb15.append(tableInfo15);
                    sb15.append("\n Found:\n");
                    sb15.append(BuiltInFictitiousFunctionClassFactory16);
                    RoomOpenHelper.ValidationResult validationResult3 = new RoomOpenHelper.ValidationResult(false, sb15.toString());
                    int i4 = PlaceComponentResult + 91;
                    BuiltInFictitiousFunctionClassFactory = i4 % 128;
                    if (i4 % 2 == 0) {
                        z = true;
                        z2 = true;
                    } else {
                        z = true;
                        z2 = false;
                    }
                    if (z2 != z) {
                        return validationResult3;
                    }
                    Object obj = null;
                    obj.hashCode();
                    return validationResult3;
                }
                HashMap hashMap16 = new HashMap(19);
                hashMap16.put("bizType", new TableInfo.Column("bizType", "TEXT", false, 0, null, 1));
                hashMap16.put("contentId", new TableInfo.Column("contentId", "TEXT", true, 1, null, 1));
                hashMap16.put("contentName", new TableInfo.Column("contentName", "TEXT", false, 0, null, 1));
                hashMap16.put("contentType", new TableInfo.Column("contentType", "TEXT", false, 0, null, 1));
                hashMap16.put("contentValue", new TableInfo.Column("contentValue", "TEXT", false, 0, null, 1));
                hashMap16.put("effectiveDate", new TableInfo.Column("effectiveDate", "TEXT", false, 0, null, 1));
                hashMap16.put("envType", new TableInfo.Column("envType", "TEXT", false, 0, null, 1));
                hashMap16.put("expireDate", new TableInfo.Column("expireDate", "TEXT", false, 0, null, 1));
                hashMap16.put("gmtCreate", new TableInfo.Column("gmtCreate", "TEXT", false, 0, null, 1));
                hashMap16.put("gmtModified", new TableInfo.Column("gmtModified", "TEXT", false, 0, null, 1));
                hashMap16.put("language", new TableInfo.Column("language", "TEXT", false, 0, null, 1));
                hashMap16.put("priority", new TableInfo.Column("priority", "INTEGER", false, 0, null, 1));
                hashMap16.put("redirectUrl", new TableInfo.Column("redirectUrl", "TEXT", false, 0, null, 1));
                hashMap16.put("selectRule", new TableInfo.Column("selectRule", "TEXT", false, 0, null, 1));
                hashMap16.put("spaceCode", new TableInfo.Column("spaceCode", "TEXT", false, 0, null, 1));
                hashMap16.put("status", new TableInfo.Column("status", "TEXT", false, 0, null, 1));
                hashMap16.put(HeaderConstant.HEADER_KEY_TENANT_ID, new TableInfo.Column(HeaderConstant.HEADER_KEY_TENANT_ID, "TEXT", false, 0, null, 1));
                hashMap16.put("extendInfo", new TableInfo.Column("extendInfo", "TEXT", false, 0, null, 1));
                hashMap16.put("orderNo", new TableInfo.Column("orderNo", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo16 = new TableInfo("PromoBannerContentDaoEntity", hashMap16, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory17 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "PromoBannerContentDaoEntity");
                if (!tableInfo16.equals(BuiltInFictitiousFunctionClassFactory17)) {
                    StringBuilder sb16 = new StringBuilder();
                    sb16.append("PromoBannerContentDaoEntity(id.dana.data.home.repository.source.presistence.entity.PromoBannerContentDaoEntity).\n Expected:\n");
                    sb16.append(tableInfo16);
                    sb16.append("\n Found:\n");
                    sb16.append(BuiltInFictitiousFunctionClassFactory17);
                    return new RoomOpenHelper.ValidationResult(false, sb16.toString());
                }
                HashMap hashMap17 = new HashMap(14);
                hashMap17.put("subscriptionId", new TableInfo.Column("subscriptionId", "TEXT", true, 1, null, 1));
                hashMap17.put("contentName", new TableInfo.Column("contentName", "TEXT", false, 0, null, 1));
                hashMap17.put("contentType", new TableInfo.Column("contentType", "TEXT", false, 0, null, 1));
                hashMap17.put("contentValue", new TableInfo.Column("contentValue", "TEXT", false, 0, null, 1));
                hashMap17.put("redirectUrl", new TableInfo.Column("redirectUrl", "TEXT", false, 0, null, 1));
                hashMap17.put("subMerchantId", new TableInfo.Column("subMerchantId", "TEXT", false, 0, null, 1));
                hashMap17.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, 1));
                hashMap17.put("subtitle", new TableInfo.Column("subtitle", "TEXT", false, 0, null, 1));
                hashMap17.put("goodsName", new TableInfo.Column("goodsName", "TEXT", false, 0, null, 1));
                hashMap17.put("goodsType", new TableInfo.Column("goodsType", "TEXT", false, 0, null, 1));
                hashMap17.put("subscriptionDueDate", new TableInfo.Column("subscriptionDueDate", "TEXT", false, 0, null, 1));
                hashMap17.put("paymentStatus", new TableInfo.Column("paymentStatus", "TEXT", false, 0, null, 1));
                hashMap17.put("totalAmount", new TableInfo.Column("totalAmount", "TEXT", false, 0, null, 1));
                hashMap17.put("iconUrl", new TableInfo.Column("iconUrl", "TEXT", false, 0, null, 1));
                TableInfo tableInfo17 = new TableInfo("PromoBannerAnnouncementDaoEntity", hashMap17, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory18 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "PromoBannerAnnouncementDaoEntity");
                if (!tableInfo17.equals(BuiltInFictitiousFunctionClassFactory18)) {
                    StringBuilder sb17 = new StringBuilder();
                    sb17.append("PromoBannerAnnouncementDaoEntity(id.dana.data.home.repository.source.presistence.entity.PromoBannerAnnouncementDaoEntity).\n Expected:\n");
                    sb17.append(tableInfo17);
                    sb17.append("\n Found:\n");
                    sb17.append(BuiltInFictitiousFunctionClassFactory18);
                    return new RoomOpenHelper.ValidationResult(false, sb17.toString());
                }
                HashMap hashMap18 = new HashMap(4);
                hashMap18.put("userId", new TableInfo.Column("userId", "TEXT", true, 1, null, 1));
                hashMap18.put("amount", new TableInfo.Column("amount", "TEXT", false, 0, null, 1));
                hashMap18.put(FirebaseAnalytics.Param.CURRENCY, new TableInfo.Column(FirebaseAnalytics.Param.CURRENCY, "TEXT", false, 0, null, 1));
                hashMap18.put("placeholder", new TableInfo.Column("placeholder", "INTEGER", true, 0, null, 1));
                TableInfo tableInfo18 = new TableInfo("SingleBalanceDaoEntity", hashMap18, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory19 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "SingleBalanceDaoEntity");
                if (!tableInfo18.equals(BuiltInFictitiousFunctionClassFactory19)) {
                    StringBuilder sb18 = new StringBuilder();
                    sb18.append("SingleBalanceDaoEntity(id.dana.data.home.repository.source.presistence.entity.SingleBalanceDaoEntity).\n Expected:\n");
                    sb18.append(tableInfo18);
                    sb18.append("\n Found:\n");
                    sb18.append(BuiltInFictitiousFunctionClassFactory19);
                    return new RoomOpenHelper.ValidationResult(false, sb18.toString());
                }
                HashMap hashMap19 = new HashMap(17);
                hashMap19.put("contentId", new TableInfo.Column("contentId", "TEXT", true, 1, null, 1));
                hashMap19.put("clientId", new TableInfo.Column("clientId", "TEXT", false, 0, null, 1));
                hashMap19.put("scopes", new TableInfo.Column("scopes", "TEXT", false, 0, null, 1));
                hashMap19.put("redirectType", new TableInfo.Column("redirectType", "TEXT", false, 0, null, 1));
                hashMap19.put("icon", new TableInfo.Column("icon", "TEXT", false, 0, null, 1));
                hashMap19.put("title", new TableInfo.Column("title", "TEXT", false, 0, null, 1));
                hashMap19.put("subtitle", new TableInfo.Column("subtitle", "TEXT", false, 0, null, 1));
                hashMap19.put("redirectUrl", new TableInfo.Column("redirectUrl", "TEXT", false, 0, null, 1));
                hashMap19.put("contentName", new TableInfo.Column("contentName", "TEXT", false, 0, null, 1));
                hashMap19.put("contentType", new TableInfo.Column("contentType", "TEXT", false, 0, null, 1));
                hashMap19.put("spaceCode", new TableInfo.Column("spaceCode", "TEXT", false, 0, null, 1));
                hashMap19.put("priority", new TableInfo.Column("priority", "INTEGER", false, 0, null, 1));
                hashMap19.put("createdDate", new TableInfo.Column("createdDate", "INTEGER", false, 0, null, 1));
                hashMap19.put("bizScenario", new TableInfo.Column("bizScenario", "TEXT", false, 0, null, 1));
                hashMap19.put("localIconId", new TableInfo.Column("localIconId", "INTEGER", false, 0, null, 1));
                hashMap19.put("expireDate", new TableInfo.Column("expireDate", "TEXT", false, 0, null, 1));
                hashMap19.put("orderNo", new TableInfo.Column("orderNo", "INTEGER", true, 0, "0", 1));
                TableInfo tableInfo19 = new TableInfo("MoreForYouDaoEntity", hashMap19, new HashSet(0), new HashSet(0));
                TableInfo BuiltInFictitiousFunctionClassFactory20 = TableInfo.BuiltInFictitiousFunctionClassFactory(supportSQLiteDatabase, "MoreForYouDaoEntity");
                if (!tableInfo19.equals(BuiltInFictitiousFunctionClassFactory20)) {
                    StringBuilder sb19 = new StringBuilder();
                    sb19.append("MoreForYouDaoEntity(id.dana.data.home.repository.source.presistence.entity.MoreForYouDaoEntity).\n Expected:\n");
                    sb19.append(tableInfo19);
                    sb19.append("\n Found:\n");
                    sb19.append(BuiltInFictitiousFunctionClassFactory20);
                    return new RoomOpenHelper.ValidationResult(false, sb19.toString());
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }

            private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
                int i;
                char[] cArr;
                char c;
                int i2;
                VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
                int i3 = iArr[0];
                int i4 = iArr[1];
                int i5 = 2;
                int i6 = iArr[2];
                int i7 = iArr[3];
                char[] cArr2 = getAuthRequestContext;
                if (cArr2 != null) {
                    int length = cArr2.length;
                    char[] cArr3 = new char[length];
                    int i8 = 0;
                    while (i8 < length) {
                        int i9 = $10 + 67;
                        $11 = i9 % 128;
                        if (i9 % i5 == 0) {
                            i2 = i6;
                            try {
                                cArr3[i8] = (char) (cArr2[i8] % 5097613533456403102L);
                                i8 *= 0;
                            } catch (Exception e) {
                                throw e;
                            }
                        } else {
                            i2 = i6;
                            cArr3[i8] = (char) (cArr2[i8] ^ 5097613533456403102L);
                            i8++;
                        }
                        i6 = i2;
                        i5 = 2;
                    }
                    i = i6;
                    cArr2 = cArr3;
                } else {
                    i = i6;
                }
                char[] cArr4 = new char[i4];
                System.arraycopy(cArr2, i3, cArr4, 0, i4);
                if ((bArr != null ? InputCardNumberView.DIVIDER : '9') != '9') {
                    int i10 = $10 + 19;
                    $11 = i10 % 128;
                    if (i10 % 2 == 0) {
                        cArr = new char[i4];
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                        c = 1;
                    } else {
                        cArr = new char[i4];
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                        c = 0;
                    }
                    while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i4) {
                        if ((bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1 ? (char) 21 : ',') != ',') {
                            int i11 = $11 + 83;
                            $10 = i11 % 128;
                            if ((i11 % 2 != 0 ? '.' : '@') != '.') {
                                cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                            } else {
                                cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] + 2) * 0) >>> c);
                            }
                        } else {
                            cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                        }
                        c = cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                    }
                    int i12 = $10 + 45;
                    $11 = i12 % 128;
                    int i13 = i12 % 2;
                    cArr4 = cArr;
                }
                if (i7 > 0) {
                    char[] cArr5 = new char[i4];
                    try {
                        System.arraycopy(cArr4, 0, cArr5, 0, i4);
                        int i14 = i4 - i7;
                        System.arraycopy(cArr5, 0, cArr4, i14, i7);
                        System.arraycopy(cArr5, i7, cArr4, 0, i14);
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
                if (z) {
                    int i15 = $10 + 73;
                    $11 = i15 % 128;
                    int i16 = i15 % 2;
                    char[] cArr6 = new char[i4];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                    while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i4) {
                        cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr4[(i4 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                    }
                    cArr4 = cArr6;
                }
                if (i > 0) {
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                    while (true) {
                        if (!(verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i4)) {
                            break;
                        }
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                    }
                }
                String str = new String(cArr4);
                int i17 = $10 + 99;
                $11 = i17 % 128;
                int i18 = i17 % 2;
                objArr[0] = str;
            }
        }, "088f3559112d15abeae846ebac9a66a9", "1172920cdfa42a11a56109e4d09dbf5d");
        SupportSQLiteOpenHelper.Configuration.Builder BuiltInFictitiousFunctionClassFactory = SupportSQLiteOpenHelper.Configuration.BuiltInFictitiousFunctionClassFactory(databaseConfiguration.BuiltInFictitiousFunctionClassFactory);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = databaseConfiguration.NetworkUserEntityData$$ExternalSyntheticLambda2;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = roomOpenHelper;
        return databaseConfiguration.PrepareContext.create(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory());
    }

    @Override // androidx.room.RoomDatabase
    public final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "DanaUserContactEntity", "SplitBillHistoryEntity", "RecentPayerSplitBillEntity", "FollowerItemEntity", "FollowingItemEntity", "RecentPoiEntity", "LoyaltyReceiptEntity", "UserContactEntity", WalletRecommendationConstant.USER_PAYMENT_ASSET_DAO, WalletRecommendationConstant.USER_POCKET_ASSET_DAO, WalletRecommendationConstant.KTP_DAO, "UserInfoEntity", "RecentRecipientEntity", "ActivityItemEntity", "NewsWidgetActivityDaoEntity", "PromoBannerContentDaoEntity", "PromoBannerAnnouncementDaoEntity", "SingleBalanceDaoEntity", "MoreForYouDaoEntity");
    }

    @Override // androidx.room.RoomDatabase
    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `DanaUserContactEntity`");
            writableDatabase.execSQL("DELETE FROM `SplitBillHistoryEntity`");
            writableDatabase.execSQL("DELETE FROM `RecentPayerSplitBillEntity`");
            writableDatabase.execSQL("DELETE FROM `FollowerItemEntity`");
            writableDatabase.execSQL("DELETE FROM `FollowingItemEntity`");
            writableDatabase.execSQL("DELETE FROM `RecentPoiEntity`");
            writableDatabase.execSQL("DELETE FROM `LoyaltyReceiptEntity`");
            writableDatabase.execSQL("DELETE FROM `UserContactEntity`");
            writableDatabase.execSQL("DELETE FROM `UserPaymentAssetsDaoEntity`");
            writableDatabase.execSQL("DELETE FROM `UserPocketAssetsDaoEntity`");
            writableDatabase.execSQL("DELETE FROM `KtpDaoEntity`");
            writableDatabase.execSQL("DELETE FROM `UserInfoEntity`");
            writableDatabase.execSQL("DELETE FROM `RecentRecipientEntity`");
            writableDatabase.execSQL("DELETE FROM `ActivityItemEntity`");
            writableDatabase.execSQL("DELETE FROM `NewsWidgetActivityDaoEntity`");
            writableDatabase.execSQL("DELETE FROM `PromoBannerContentDaoEntity`");
            writableDatabase.execSQL("DELETE FROM `PromoBannerAnnouncementDaoEntity`");
            writableDatabase.execSQL("DELETE FROM `SingleBalanceDaoEntity`");
            writableDatabase.execSQL("DELETE FROM `MoreForYouDaoEntity`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    public final Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(DanaUserContactDao.class, DanaUserContactDao_Impl.getRequiredConverters());
        hashMap.put(SplitBillHistoryDao.class, SplitBillHistoryDao_Impl.getRequiredConverters());
        hashMap.put(RecentPayerSplitBillDao.class, RecentPayerSplitBillDao_Impl.getRequiredConverters());
        hashMap.put(FollowerDao.class, FollowerDao_Impl.getRequiredConverters());
        hashMap.put(FollowingDao.class, FollowingDao_Impl.getRequiredConverters());
        hashMap.put(GeofenceDao.class, GeofenceDao_Impl.getRequiredConverters());
        hashMap.put(LoyaltyReceiptDao.class, LoyaltyReceiptDao_Impl.getRequiredConverters());
        hashMap.put(UserContactDao.class, UserContactDao_Impl.getRequiredConverters());
        hashMap.put(UserPaymentAssetsDao.class, UserPaymentAssetsDao_Impl.getRequiredConverters());
        hashMap.put(UserPocketAssetsDao.class, UserPocketAssetsDao_Impl.getRequiredConverters());
        hashMap.put(UserIdentityAssetsDao.class, UserIdentityAssetsDao_Impl.getRequiredConverters());
        hashMap.put(NewsWidgetActivityDao.class, NewsWidgetActivityDao_Impl.getAuthRequestContext());
        hashMap.put(UserInfoDao.class, UserInfoDao_Impl.getRequiredConverters());
        hashMap.put(RecentRecipientDao.class, RecentRecipientDao_Impl.getRequiredConverters());
        hashMap.put(ActivityDao.class, ActivityDao_Impl.getRequiredConverters());
        hashMap.put(PromoBannerContentDao.class, PromoBannerContentDao_Impl.getAuthRequestContext());
        hashMap.put(PromoBannerAnnouncementDao.class, PromoBannerAnnouncementDao_Impl.BuiltInFictitiousFunctionClassFactory());
        hashMap.put(SingleBalanceDao.class, SingleBalanceDao_Impl.getAuthRequestContext());
        hashMap.put(MoreForYouDao.class, MoreForYouDao_Impl.BuiltInFictitiousFunctionClassFactory());
        return hashMap;
    }

    @Override // androidx.room.RoomDatabase
    public final Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public final List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // id.dana.data.base.BasePersistenceDao
    public final DanaUserContactDao danaUserContactDao() {
        DanaUserContactDao danaUserContactDao;
        if (this._danaUserContactDao != null) {
            return this._danaUserContactDao;
        }
        synchronized (this) {
            if (this._danaUserContactDao == null) {
                this._danaUserContactDao = new DanaUserContactDao_Impl(this);
            }
            danaUserContactDao = this._danaUserContactDao;
        }
        return danaUserContactDao;
    }

    @Override // id.dana.data.base.BasePersistenceDao
    public final SplitBillHistoryDao splitBillHistoryDao() {
        SplitBillHistoryDao splitBillHistoryDao;
        if (this._splitBillHistoryDao != null) {
            return this._splitBillHistoryDao;
        }
        synchronized (this) {
            if (this._splitBillHistoryDao == null) {
                this._splitBillHistoryDao = new SplitBillHistoryDao_Impl(this);
            }
            splitBillHistoryDao = this._splitBillHistoryDao;
        }
        return splitBillHistoryDao;
    }

    @Override // id.dana.data.base.BasePersistenceDao
    public final RecentPayerSplitBillDao recentPayerSplitBillDao() {
        RecentPayerSplitBillDao recentPayerSplitBillDao;
        if (this._recentPayerSplitBillDao != null) {
            return this._recentPayerSplitBillDao;
        }
        synchronized (this) {
            if (this._recentPayerSplitBillDao == null) {
                this._recentPayerSplitBillDao = new RecentPayerSplitBillDao_Impl(this);
            }
            recentPayerSplitBillDao = this._recentPayerSplitBillDao;
        }
        return recentPayerSplitBillDao;
    }

    @Override // id.dana.data.base.BasePersistenceDao
    public final FollowerDao followerDao() {
        FollowerDao followerDao;
        if (this._followerDao != null) {
            return this._followerDao;
        }
        synchronized (this) {
            if (this._followerDao == null) {
                this._followerDao = new FollowerDao_Impl(this);
            }
            followerDao = this._followerDao;
        }
        return followerDao;
    }

    @Override // id.dana.data.base.BasePersistenceDao
    public final FollowingDao followingDao() {
        FollowingDao followingDao;
        if (this._followingDao != null) {
            return this._followingDao;
        }
        synchronized (this) {
            if (this._followingDao == null) {
                this._followingDao = new FollowingDao_Impl(this);
            }
            followingDao = this._followingDao;
        }
        return followingDao;
    }

    @Override // id.dana.data.base.BasePersistenceDao
    public final GeofenceDao geofenceDao() {
        GeofenceDao geofenceDao;
        if (this._geofenceDao != null) {
            return this._geofenceDao;
        }
        synchronized (this) {
            if (this._geofenceDao == null) {
                this._geofenceDao = new GeofenceDao_Impl(this);
            }
            geofenceDao = this._geofenceDao;
        }
        return geofenceDao;
    }

    @Override // id.dana.data.base.BasePersistenceDao
    public final LoyaltyReceiptDao loyaltyReceiptDao() {
        LoyaltyReceiptDao loyaltyReceiptDao;
        if (this._loyaltyReceiptDao != null) {
            return this._loyaltyReceiptDao;
        }
        synchronized (this) {
            if (this._loyaltyReceiptDao == null) {
                this._loyaltyReceiptDao = new LoyaltyReceiptDao_Impl(this);
            }
            loyaltyReceiptDao = this._loyaltyReceiptDao;
        }
        return loyaltyReceiptDao;
    }

    @Override // id.dana.data.base.BasePersistenceDao
    public final UserContactDao userContactDao() {
        UserContactDao userContactDao;
        if (this._userContactDao != null) {
            return this._userContactDao;
        }
        synchronized (this) {
            if (this._userContactDao == null) {
                this._userContactDao = new UserContactDao_Impl(this);
            }
            userContactDao = this._userContactDao;
        }
        return userContactDao;
    }

    @Override // id.dana.data.base.BasePersistenceDao
    public final UserPaymentAssetsDao userPaymentAssetsDao() {
        UserPaymentAssetsDao userPaymentAssetsDao;
        if (this._userPaymentAssetsDao != null) {
            return this._userPaymentAssetsDao;
        }
        synchronized (this) {
            if (this._userPaymentAssetsDao == null) {
                this._userPaymentAssetsDao = new UserPaymentAssetsDao_Impl(this);
            }
            userPaymentAssetsDao = this._userPaymentAssetsDao;
        }
        return userPaymentAssetsDao;
    }

    @Override // id.dana.data.base.BasePersistenceDao
    public final UserPocketAssetsDao userPocketAssetsDao() {
        UserPocketAssetsDao userPocketAssetsDao;
        if (this._userPocketAssetsDao != null) {
            return this._userPocketAssetsDao;
        }
        synchronized (this) {
            if (this._userPocketAssetsDao == null) {
                this._userPocketAssetsDao = new UserPocketAssetsDao_Impl(this);
            }
            userPocketAssetsDao = this._userPocketAssetsDao;
        }
        return userPocketAssetsDao;
    }

    @Override // id.dana.data.base.BasePersistenceDao
    public final UserIdentityAssetsDao userIdentityAssetsDao() {
        UserIdentityAssetsDao userIdentityAssetsDao;
        if (this._userIdentityAssetsDao != null) {
            return this._userIdentityAssetsDao;
        }
        synchronized (this) {
            if (this._userIdentityAssetsDao == null) {
                this._userIdentityAssetsDao = new UserIdentityAssetsDao_Impl(this);
            }
            userIdentityAssetsDao = this._userIdentityAssetsDao;
        }
        return userIdentityAssetsDao;
    }

    @Override // id.dana.data.base.BasePersistenceDao
    public final NewsWidgetActivityDao newsWidgetActivityDao() {
        NewsWidgetActivityDao newsWidgetActivityDao;
        if (this._newsWidgetActivityDao != null) {
            return this._newsWidgetActivityDao;
        }
        synchronized (this) {
            if (this._newsWidgetActivityDao == null) {
                this._newsWidgetActivityDao = new NewsWidgetActivityDao_Impl(this);
            }
            newsWidgetActivityDao = this._newsWidgetActivityDao;
        }
        return newsWidgetActivityDao;
    }

    @Override // id.dana.data.base.BasePersistenceDao
    public final UserInfoDao userInfoDao() {
        UserInfoDao userInfoDao;
        if (this._userInfoDao != null) {
            return this._userInfoDao;
        }
        synchronized (this) {
            if (this._userInfoDao == null) {
                this._userInfoDao = new UserInfoDao_Impl(this);
            }
            userInfoDao = this._userInfoDao;
        }
        return userInfoDao;
    }

    @Override // id.dana.data.base.BasePersistenceDao
    public final RecentRecipientDao recentRecipientDao() {
        RecentRecipientDao recentRecipientDao;
        if (this._recentRecipientDao != null) {
            return this._recentRecipientDao;
        }
        synchronized (this) {
            if (this._recentRecipientDao == null) {
                this._recentRecipientDao = new RecentRecipientDao_Impl(this);
            }
            recentRecipientDao = this._recentRecipientDao;
        }
        return recentRecipientDao;
    }

    @Override // id.dana.data.base.BasePersistenceDao
    public final ActivityDao activityDao() {
        ActivityDao activityDao;
        if (this._activityDao != null) {
            return this._activityDao;
        }
        synchronized (this) {
            if (this._activityDao == null) {
                this._activityDao = new ActivityDao_Impl(this);
            }
            activityDao = this._activityDao;
        }
        return activityDao;
    }

    @Override // id.dana.data.base.BasePersistenceDao
    public final PromoBannerContentDao promoBannerContentDao() {
        PromoBannerContentDao promoBannerContentDao;
        if (this._promoBannerContentDao != null) {
            return this._promoBannerContentDao;
        }
        synchronized (this) {
            if (this._promoBannerContentDao == null) {
                this._promoBannerContentDao = new PromoBannerContentDao_Impl(this);
            }
            promoBannerContentDao = this._promoBannerContentDao;
        }
        return promoBannerContentDao;
    }

    @Override // id.dana.data.base.BasePersistenceDao
    public final PromoBannerAnnouncementDao promoBannerAnnouncementDao() {
        PromoBannerAnnouncementDao promoBannerAnnouncementDao;
        if (this._promoBannerAnnouncementDao != null) {
            return this._promoBannerAnnouncementDao;
        }
        synchronized (this) {
            if (this._promoBannerAnnouncementDao == null) {
                this._promoBannerAnnouncementDao = new PromoBannerAnnouncementDao_Impl(this);
            }
            promoBannerAnnouncementDao = this._promoBannerAnnouncementDao;
        }
        return promoBannerAnnouncementDao;
    }

    @Override // id.dana.data.base.BasePersistenceDao
    public final SingleBalanceDao singleBalanceDao() {
        SingleBalanceDao singleBalanceDao;
        if (this._singleBalanceDao != null) {
            return this._singleBalanceDao;
        }
        synchronized (this) {
            if (this._singleBalanceDao == null) {
                this._singleBalanceDao = new SingleBalanceDao_Impl(this);
            }
            singleBalanceDao = this._singleBalanceDao;
        }
        return singleBalanceDao;
    }

    @Override // id.dana.data.base.BasePersistenceDao
    public final MoreForYouDao moreForYouDao() {
        MoreForYouDao moreForYouDao;
        if (this._moreForYouDao != null) {
            return this._moreForYouDao;
        }
        synchronized (this) {
            if (this._moreForYouDao == null) {
                this._moreForYouDao = new MoreForYouDao_Impl(this);
            }
            moreForYouDao = this._moreForYouDao;
        }
        return moreForYouDao;
    }
}
