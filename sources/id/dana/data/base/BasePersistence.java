package id.dana.data.base;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import dagger.Lazy;

/* loaded from: classes2.dex */
public abstract class BasePersistence {
    static final String DB_NAME = "DB-6CC59C4231550-production";
    private final Lazy<BasePersistenceDao> persistanceDao;
    static final Migration MIGRATION_3_4 = new Migration() { // from class: id.dana.data.base.BasePersistence.1
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `DanaUserContactEntity` (`lastUpdated` INTEGER NOT NULL,`phoneNumber` TEXT,`uid` INTEGER NOT NULL,`userId` TEXT, PRIMARY KEY(uid) )");
            supportSQLiteDatabase.execSQL("ALTER TABLE RecentBankEntity  ADD COLUMN alias TEXT");
        }
    };
    static final Migration MIGRATION_4_5 = new Migration() { // from class: id.dana.data.base.BasePersistence.2
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SplitBillHistoryEntity` (`uid` INTEGER NOT NULL, `lastUpdated` INTEGER NOT NULL,`comment` TEXT,`deepLinkUrl` TEXT,`payers` TEXT, PRIMARY KEY(uid) )");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `RecentPayerSplitBillEntity` (`uid` INTEGER NOT NULL, `userId` TEXT,`userPhoneNumber` TEXT,`userNickname` TEXT,`avatar` TEXT,`lastUpdated` INTEGER NOT NULL,PRIMARY KEY(uid) )");
        }
    };
    static final Migration MIGRATION_5_6 = new Migration() { // from class: id.dana.data.base.BasePersistence.3
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE SplitBillHistoryEntity ADD COLUMN splitBillId TEXT");
            supportSQLiteDatabase.execSQL("ALTER TABLE SplitBillHistoryEntity ADD COLUMN status TEXT");
            supportSQLiteDatabase.execSQL("ALTER TABLE SplitBillHistoryEntity ADD COLUMN createdDate INTEGER DEFAULT 0 NOT NULL");
            supportSQLiteDatabase.execSQL("ALTER TABLE SplitBillHistoryEntity ADD COLUMN totalAmount TEXT");
            supportSQLiteDatabase.execSQL("ALTER TABLE SplitBillHistoryEntity ADD COLUMN payerIndex INTEGER DEFAULT 0 NOT NULL");
            supportSQLiteDatabase.execSQL("ALTER TABLE SplitBillHistoryEntity ADD COLUMN payeeIndex INTEGER DEFAULT 0 NOT NULL");
        }
    };
    static final Migration MIGRATION_6_7 = new Migration() { // from class: id.dana.data.base.BasePersistence.4
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE RecentPayerSplitBillEntity ADD COLUMN shownName TEXT");
            supportSQLiteDatabase.execSQL("ALTER TABLE RecentPayerSplitBillEntity ADD COLUMN shownNumber TEXT");
        }
    };
    static final Migration MIGRATION_7_8 = new Migration() { // from class: id.dana.data.base.BasePersistence.5
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `FollowerItemEntity` (`userId` TEXT NOT NULL, `loginId` TEXT NOT NULL,`nickName` TEXT NOT NULL,`status` TEXT NOT NULL,`gmtCreate` INTEGER NOT NULL, `gmtModified` INTEGER NOT NULL, `avatar` TEXT,PRIMARY KEY(userId) )");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `FollowingItemEntity` (`userId` TEXT NOT NULL, `loginId` TEXT NOT NULL,`nickName` TEXT NOT NULL,`status` TEXT NOT NULL,`gmtCreate` INTEGER NOT NULL, `gmtModified` INTEGER NOT NULL, `avatar` TEXT,PRIMARY KEY(userId) )");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `RecentPoiEntity` (`poiId` TEXT NOT NULL,`radius` INTEGER NOT NULL,`longitude` REAL NOT NULL,`latitude` REAL NOT NULL,`lastPoiNotified` INTEGER,PRIMARY KEY(poiId) )");
        }
    };
    static final Migration MIGRATION_9_10 = new Migration() { // from class: id.dana.data.base.BasePersistence.6
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SecureRecentBankEntity` (`alias` TEXT,`bankLogo` TEXT ,`bankName` TEXT ,`bankNumber` TEXT ,`count` INTEGER NOT NULL,`instId` TEXT ,`instLocalName` TEXT ,`lastUpdated` INTEGER NOT NULL,`payMethod` TEXT ,`payOption` TEXT ,`recipientName` TEXT ,`senderName` TEXT ,`cardIndexNo` TEXT NOT NULL,PRIMARY KEY(cardIndexNo) )");
        }
    };
    static final Migration MIGRATION_10_11 = new Migration() { // from class: id.dana.data.base.BasePersistence.7
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE SecureRecentBankEntity ADD COLUMN prefix TEXT");
        }
    };
    static final Migration MIGRATION_11_12 = new Migration() { // from class: id.dana.data.base.BasePersistence.8
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE SecureRecentBankEntity ADD COLUMN transactionCount INTEGER DEFAULT 0 NOT NULL");
            supportSQLiteDatabase.execSQL("ALTER TABLE RecentContactEntity ADD COLUMN transactionCount INTEGER DEFAULT 0 NOT NULL");
        }
    };
    static final Migration MIGRATION_12_13 = new Migration() { // from class: id.dana.data.base.BasePersistence.9
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE `SecureRecentBankEntity_backup` (`alias` TEXT,`bankLogo` TEXT ,`bankName` TEXT ,`bankNumber` TEXT ,`instId` TEXT ,`instLocalName` TEXT ,`lastUpdated` INTEGER NOT NULL,`payMethod` TEXT ,`payOption` TEXT ,`recipientName` TEXT ,`senderName` TEXT ,`cardIndexNo` TEXT NOT NULL,`prefix` TEXT ,`transactionCount` INTEGER NOT NULL,PRIMARY KEY(cardIndexNo) )");
            supportSQLiteDatabase.execSQL("INSERT INTO `SecureRecentBankEntity_backup` SELECT alias,bankLogo, bankName, bankNumber, instId, instLocalName, lastUpdated, payMethod, payOption, recipientName, senderName, cardIndexNo, prefix, transactionCount  FROM SecureRecentBankEntity ");
            supportSQLiteDatabase.execSQL("DROP TABLE SecureRecentBankEntity ");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SecureRecentBankEntity` (`alias` TEXT,`bankLogo` TEXT ,`bankName` TEXT ,`bankNumber` TEXT ,`instId` TEXT ,`instLocalName` TEXT ,`lastUpdated` INTEGER NOT NULL,`payMethod` TEXT ,`payOption` TEXT ,`recipientName` TEXT ,`senderName` TEXT ,`cardIndexNo` TEXT NOT NULL,`prefix` TEXT ,`transactionCount` INTEGER NOT NULL,PRIMARY KEY(cardIndexNo) )");
            supportSQLiteDatabase.execSQL("INSERT INTO `SecureRecentBankEntity` SELECT alias,bankLogo, bankName, bankNumber, instId, instLocalName, lastUpdated, payMethod, payOption, recipientName, senderName, cardIndexNo, prefix, transactionCount  FROM SecureRecentBankEntity_backup ");
            supportSQLiteDatabase.execSQL("DROP TABLE SecureRecentBankEntity_backup ");
            supportSQLiteDatabase.execSQL("CREATE TABLE `RecentContactEntity_backup` (`uid` INTEGER NOT NULL,`userId` TEXT ,`userPhoneNumber` TEXT ,`userNickName` TEXT ,`avatar` TEXT ,`lastUpdated` INTEGER NOT NULL,`transactionCount` INTEGER NOT NULL,PRIMARY KEY(uid) )");
            supportSQLiteDatabase.execSQL("INSERT INTO `RecentContactEntity_backup` SELECT uid,userId, userPhoneNumber, userNickName, avatar, lastUpdated, transactionCount  FROM RecentContactEntity ");
            supportSQLiteDatabase.execSQL("DROP TABLE RecentContactEntity ");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `RecentContactEntity` (`uid` INTEGER NOT NULL,`userId` TEXT ,`userPhoneNumber` TEXT ,`userNickName` TEXT ,`avatar` TEXT ,`lastUpdated` INTEGER NOT NULL,`transactionCount` INTEGER NOT NULL,PRIMARY KEY(uid) )");
            supportSQLiteDatabase.execSQL("INSERT INTO `RecentContactEntity` SELECT uid,userId, userPhoneNumber, userNickName, avatar, lastUpdated, transactionCount  FROM RecentContactEntity_backup ");
            supportSQLiteDatabase.execSQL("DROP TABLE RecentContactEntity_backup ");
        }
    };
    static final Migration MIGRATION_13_14 = new Migration() { // from class: id.dana.data.base.BasePersistence.10
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE `FollowingItemEntity` ADD COLUMN `username` TEXT NOT NULL DEFAULT ''");
            supportSQLiteDatabase.execSQL("ALTER TABLE `FollowerItemEntity` ADD COLUMN `username` TEXT NOT NULL DEFAULT ''");
        }
    };
    static final Migration MIGRATION_14_15 = new Migration() { // from class: id.dana.data.base.BasePersistence.11
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE `SecureRecentBankEntity` ADD COLUMN `visibleInQuickSend` INTEGER NOT NULL DEFAULT(1)");
            supportSQLiteDatabase.execSQL("ALTER TABLE `RecentContactEntity` ADD COLUMN `visibleInQuickSend` INTEGER NOT NULL DEFAULT(1)");
        }
    };
    static final Migration MIGRATION_15_16 = new Migration() { // from class: id.dana.data.base.BasePersistence.12
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE `SecureRecentBankEntity_backup` (`alias` TEXT,`bankLogo` TEXT ,`bankName` TEXT ,`bankNumber` TEXT ,`instId` TEXT ,`instLocalName` TEXT ,`lastUpdated` INTEGER NOT NULL,`payMethod` TEXT ,`payOption` TEXT ,`recipientName` TEXT ,`senderName` TEXT ,`cardIndexNo` TEXT NOT NULL,`prefix` TEXT ,`transactionCount` INTEGER NOT NULL,`visibleInQuickSend` INTEGER NOT NULL DEFAULT(1),PRIMARY KEY(cardIndexNo) )");
            supportSQLiteDatabase.execSQL("INSERT INTO `SecureRecentBankEntity_backup` SELECT alias,bankLogo, bankName, bankNumber, instId, instLocalName, lastUpdated, payMethod, payOption, recipientName, senderName, cardIndexNo, prefix, transactionCount, visibleInQuickSend  FROM SecureRecentBankEntity ");
            supportSQLiteDatabase.execSQL("DROP TABLE SecureRecentBankEntity ");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SecureRecentBankEntity` (`alias` TEXT,`bankLogo` TEXT ,`bankName` TEXT ,`bankNumber` TEXT ,`instId` TEXT ,`instLocalName` TEXT ,`lastUpdated` INTEGER NOT NULL,`payMethod` TEXT ,`payOption` TEXT ,`recipientName` TEXT ,`senderName` TEXT ,`cardIndexNo` TEXT NOT NULL,`prefix` TEXT ,`transactionCount` INTEGER NOT NULL,`visibleInQuickSend` INTEGER NOT NULL DEFAULT(1),PRIMARY KEY(cardIndexNo) )");
            supportSQLiteDatabase.execSQL("INSERT INTO `SecureRecentBankEntity` SELECT alias,bankLogo, bankName, bankNumber, instId, instLocalName, lastUpdated, payMethod, payOption, recipientName, senderName, cardIndexNo, prefix, transactionCount, visibleInQuickSend  FROM SecureRecentBankEntity_backup ");
            supportSQLiteDatabase.execSQL("DROP TABLE SecureRecentBankEntity_backup ");
            supportSQLiteDatabase.execSQL("CREATE TABLE `RecentContactEntity_backup` (`uid` INTEGER NOT NULL,`userId` TEXT ,`userPhoneNumber` TEXT ,`userNickName` TEXT ,`avatar` TEXT ,`lastUpdated` INTEGER NOT NULL,`transactionCount` INTEGER NOT NULL,`visibleInQuickSend` INTEGER NOT NULL DEFAULT(1),PRIMARY KEY(uid) )");
            supportSQLiteDatabase.execSQL("INSERT INTO `RecentContactEntity_backup` SELECT uid,userId, userPhoneNumber, userNickName, avatar, lastUpdated, transactionCount, visibleInQuickSend  FROM RecentContactEntity ");
            supportSQLiteDatabase.execSQL("DROP TABLE RecentContactEntity ");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `RecentContactEntity` (`uid` INTEGER NOT NULL,`userId` TEXT ,`userPhoneNumber` TEXT ,`userNickName` TEXT ,`avatar` TEXT ,`lastUpdated` INTEGER NOT NULL,`transactionCount` INTEGER NOT NULL,`visibleInQuickSend` INTEGER NOT NULL DEFAULT(1),PRIMARY KEY(uid) )");
            supportSQLiteDatabase.execSQL("INSERT INTO `RecentContactEntity` SELECT uid,userId, userPhoneNumber, userNickName, avatar, lastUpdated, transactionCount, visibleInQuickSend  FROM RecentContactEntity_backup ");
            supportSQLiteDatabase.execSQL("DROP TABLE RecentContactEntity_backup ");
        }
    };
    static final Migration MIGRATION_16_17 = new Migration() { // from class: id.dana.data.base.BasePersistence.13
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE `SecureRecentBankEntity` ADD COLUMN `isFavorite` INTEGER NOT NULL DEFAULT(0)");
            supportSQLiteDatabase.execSQL("ALTER TABLE `RecentContactEntity` ADD COLUMN `isFavorite` INTEGER NOT NULL DEFAULT(0)");
        }
    };
    static final Migration MIGRATION_17_18 = new Migration() { // from class: id.dana.data.base.BasePersistence.14
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE `SecureRecentBankEntity_backup` (`alias` TEXT,`bankLogo` TEXT ,`bankName` TEXT ,`bankNumber` TEXT ,`instId` TEXT ,`instLocalName` TEXT ,`lastUpdated` INTEGER NOT NULL,`payMethod` TEXT ,`payOption` TEXT ,`recipientName` TEXT ,`senderName` TEXT ,`cardIndexNo` TEXT NOT NULL,`prefix` TEXT ,`transactionCount` INTEGER NOT NULL,`visibleInQuickSend` INTEGER NOT NULL DEFAULT(1),`isFavorite` INTEGER NOT NULL DEFAULT(0),PRIMARY KEY(cardIndexNo) )");
            supportSQLiteDatabase.execSQL("INSERT INTO `SecureRecentBankEntity_backup` SELECT alias,bankLogo, bankName, bankNumber, instId, instLocalName, lastUpdated, payMethod, payOption, recipientName, senderName, cardIndexNo, prefix, transactionCount, visibleInQuickSend, isFavorite  FROM SecureRecentBankEntity ");
            supportSQLiteDatabase.execSQL("DROP TABLE SecureRecentBankEntity ");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SecureRecentBankEntity` (`alias` TEXT,`bankLogo` TEXT ,`bankName` TEXT ,`bankNumber` TEXT ,`instId` TEXT ,`instLocalName` TEXT ,`lastUpdated` INTEGER NOT NULL,`payMethod` TEXT ,`payOption` TEXT ,`recipientName` TEXT ,`senderName` TEXT ,`cardIndexNo` TEXT NOT NULL,`prefix` TEXT ,`transactionCount` INTEGER NOT NULL,`visibleInQuickSend` INTEGER NOT NULL DEFAULT(1),`isFavorite` INTEGER NOT NULL DEFAULT(0),PRIMARY KEY(cardIndexNo) )");
            supportSQLiteDatabase.execSQL("INSERT INTO `SecureRecentBankEntity` SELECT alias,bankLogo, bankName, bankNumber, instId, instLocalName, lastUpdated, payMethod, payOption, recipientName, senderName, cardIndexNo, prefix, transactionCount, visibleInQuickSend, isFavorite  FROM SecureRecentBankEntity_backup ");
            supportSQLiteDatabase.execSQL("DROP TABLE SecureRecentBankEntity_backup ");
            supportSQLiteDatabase.execSQL("CREATE TABLE `RecentContactEntity_backup` (`uid` INTEGER NOT NULL,`userId` TEXT ,`userPhoneNumber` TEXT ,`userNickName` TEXT ,`avatar` TEXT ,`lastUpdated` INTEGER NOT NULL,`transactionCount` INTEGER NOT NULL,`visibleInQuickSend` INTEGER NOT NULL DEFAULT(1),`isFavorite` INTEGER NOT NULL DEFAULT(0),PRIMARY KEY(uid) )");
            supportSQLiteDatabase.execSQL("INSERT INTO `RecentContactEntity_backup` SELECT uid,userId, userPhoneNumber, userNickName, avatar, lastUpdated, transactionCount, visibleInQuickSend, isFavorite FROM RecentContactEntity ");
            supportSQLiteDatabase.execSQL("DROP TABLE RecentContactEntity ");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `RecentContactEntity` (`uid` INTEGER NOT NULL,`userId` TEXT ,`userPhoneNumber` TEXT ,`userNickName` TEXT ,`avatar` TEXT ,`lastUpdated` INTEGER NOT NULL,`transactionCount` INTEGER NOT NULL,`visibleInQuickSend` INTEGER NOT NULL DEFAULT(1),`isFavorite` INTEGER NOT NULL DEFAULT(0),PRIMARY KEY(uid) )");
            supportSQLiteDatabase.execSQL("INSERT INTO `RecentContactEntity` SELECT uid,userId, userPhoneNumber, userNickName, avatar, lastUpdated, transactionCount, visibleInQuickSend, isFavorite FROM RecentContactEntity_backup ");
            supportSQLiteDatabase.execSQL("DROP TABLE RecentContactEntity_backup ");
        }
    };
    static final Migration MIGRATION_18_19 = new Migration() { // from class: id.dana.data.base.BasePersistence.15
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE `SecureRecentBankEntity_backup` (`alias` TEXT,`bankLogo` TEXT ,`bankName` TEXT ,`bankNumber` TEXT ,`instId` TEXT ,`instLocalName` TEXT ,`lastUpdated` INTEGER NOT NULL,`payMethod` TEXT ,`payOption` TEXT ,`recipientName` TEXT ,`senderName` TEXT ,`cardIndexNo` TEXT NOT NULL,`prefix` TEXT ,`transactionCount` INTEGER NOT NULL,`isFavorite` INTEGER NOT NULL DEFAULT(0),PRIMARY KEY(cardIndexNo) )");
            supportSQLiteDatabase.execSQL("INSERT INTO `SecureRecentBankEntity_backup` SELECT alias,bankLogo, bankName, bankNumber, instId, instLocalName, lastUpdated, payMethod, payOption, recipientName, senderName, cardIndexNo, prefix, transactionCount, isFavorite  FROM SecureRecentBankEntity ");
            supportSQLiteDatabase.execSQL("DROP TABLE SecureRecentBankEntity ");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SecureRecentBankEntity` (`alias` TEXT,`bankLogo` TEXT ,`bankName` TEXT ,`bankNumber` TEXT ,`instId` TEXT ,`instLocalName` TEXT ,`lastUpdated` INTEGER NOT NULL,`payMethod` TEXT ,`payOption` TEXT ,`recipientName` TEXT ,`senderName` TEXT ,`cardIndexNo` TEXT NOT NULL,`prefix` TEXT ,`transactionCount` INTEGER NOT NULL,`isFavorite` INTEGER NOT NULL DEFAULT(0),PRIMARY KEY(cardIndexNo) )");
            supportSQLiteDatabase.execSQL("INSERT INTO `SecureRecentBankEntity` SELECT alias,bankLogo, bankName, bankNumber, instId, instLocalName, lastUpdated, payMethod, payOption, recipientName, senderName, cardIndexNo, prefix, transactionCount, isFavorite  FROM SecureRecentBankEntity_backup ");
            supportSQLiteDatabase.execSQL("DROP TABLE SecureRecentBankEntity_backup ");
            supportSQLiteDatabase.execSQL("CREATE TABLE `RecentContactEntity_backup` (`uid` INTEGER NOT NULL,`userId` TEXT ,`userPhoneNumber` TEXT ,`userNickName` TEXT ,`avatar` TEXT ,`lastUpdated` INTEGER NOT NULL,`transactionCount` INTEGER NOT NULL,`isFavorite` INTEGER NOT NULL DEFAULT(0),PRIMARY KEY(uid) )");
            supportSQLiteDatabase.execSQL("INSERT INTO `RecentContactEntity_backup` SELECT uid,userId, userPhoneNumber, userNickName, avatar, lastUpdated, transactionCount, isFavorite FROM RecentContactEntity ");
            supportSQLiteDatabase.execSQL("DROP TABLE RecentContactEntity ");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `RecentContactEntity` (`uid` INTEGER NOT NULL,`userId` TEXT ,`userPhoneNumber` TEXT ,`userNickName` TEXT ,`avatar` TEXT ,`lastUpdated` INTEGER NOT NULL,`transactionCount` INTEGER NOT NULL,`isFavorite` INTEGER NOT NULL DEFAULT(0),PRIMARY KEY(uid) )");
            supportSQLiteDatabase.execSQL("INSERT INTO `RecentContactEntity` SELECT uid,userId, userPhoneNumber, userNickName, avatar, lastUpdated, transactionCount, isFavorite FROM RecentContactEntity_backup ");
            supportSQLiteDatabase.execSQL("DROP TABLE RecentContactEntity_backup ");
        }
    };
    static final Migration MIGRATION_19_20 = new Migration() { // from class: id.dana.data.base.BasePersistence.16
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `UserContactEntity` (`uid` INTEGER NOT NULL,`phoneNumber` TEXT NOT NULL,`rawPhoneNumber` TEXT NOT NULL,`name` TEXT,`displayPhoto` TEXT,`updatedAt` INTEGER DEFAULT(NULL),`createdAt` INTEGER DEFAULT(NULL),`isDanaUser` INTEGER DEFAULT(NULL),PRIMARY KEY(uid) )");
        }
    };
    static final Migration MIGRATION_20_21 = new Migration() { // from class: id.dana.data.base.BasePersistence.17
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `UserPaymentAssetsDaoEntity` (`uniqueId` TEXT NOT NULL,`section` TEXT,`amount` TEXT,`currency` TEXT,`limitAmount` TEXT,`limitCurrency` TEXT,`limitCurrencyCode` TEXT,`balanceAmount` TEXT,`balanceCurrency` TEXT,`balanceCurrencyCode` TEXT,`unpaidAmountAmount` TEXT,`unpaidAmountCurrency` TEXT,`unpaidAmountCurrencyCode` TEXT,`overdueTips` TEXT,`overdueStatus` INTEGER,`accountId` TEXT,`gmtCreate` TEXT,`gmtModified` TEXT,`assetBiztype` TEXT,`cardTitle` TEXT,`cardIndexNo` TEXT,`cardNoLength` TEXT,`maskedCardNo` TEXT,`assetType` TEXT,`cardScheme` TEXT,`holderName` TEXT,`instLogoUrl` TEXT,`instId` TEXT,`instOfficialName` TEXT,`instBranchId` TEXT,`instBranchOfficialName` TEXT,`expiryYear` TEXT,`expiryMonth` TEXT,`verified` INTEGER,`bindingId` TEXT,`accountNo` TEXT,`defaultAsset` TEXT,`extInfo` TEXT,`enableStatus` INTEGER,`bankMobileNo` TEXT,`directDebit` INTEGER,`personalDailyLimitAmount` TEXT,`personalDailyLimitCurrency` TEXT,`personalDailyLimitCurrencyCode` TEXT,`userPhoneNo` TEXT,`contactBizType` TEXT,`goodsId` TEXT,`aggregator` TEXT,`userId` TEXT,`accountStatus` TEXT,`availableBalanceAmount` INTEGER DEFAULT(NULL),`availableBalanceCent` INTEGER DEFAULT(NULL),`availableBalanceCentFactor` INTEGER DEFAULT(NULL),`availableBalanceCurrency` TEXT,`availableBalanceCurrencyCode` TEXT,`availableBalanceCurrencyValue` TEXT,`balanceUnitType` TEXT,`balanceUnitUnit` INTEGER,`balanceUnitUnitValue` TEXT,`totalGainLossAmountAmount` INTEGER DEFAULT(NULL),`totalGainLossAmountCent` INTEGER,`totalGainLossAmountCentFactor` INTEGER DEFAULT(NULL),`totalGainLossAmountCurrency` TEXT,`totalGainLossAmountCurrencyCode` TEXT,`totalGainLossAmountCurrencyValue` TEXT,`totalGainLossPercentage` TEXT,`dailyGainLossAmountAmount` INTEGER DEFAULT(NULL),`dailyGainLossAmountCent` INTEGER DEFAULT(NULL),`dailyGainLossAmountCentFactor` INTEGER DEFAULT(NULL),`dailyGainLossAmountCurrency` TEXT,`dailyGainLossAmountCurrencyCode` TEXT,`dailyGainLossAmountCurrencyValue` TEXT,`dailyGainLossPercentage` TEXT,`lastUpdated` INTEGER,`savingId` TEXT,`title` TEXT,`categoryCode` TEXT,`currentAmountAmount` TEXT,`currentAmountCurrency` TEXT,`currentAmountCurrencyCode` TEXT,`targetAmountAmount` TEXT,`targetAmountCurrency` TEXT,`targetAmountCurrencyCode` TEXT,`orderStatus` TEXT,`orderSubStatus` TEXT,`createdTime` INTEGER DEFAULT(NULL),`achievedTime` INTEGER DEFAULT(NULL),`completedTime` INTEGER DEFAULT(NULL),`extendInfo` TEXT,PRIMARY KEY(uniqueId) )");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `UserPocketAssetsDaoEntity` (`pocketId` TEXT NOT NULL,`pocketStatus` TEXT NOT NULL,`iconUrl` TEXT NOT NULL,`backgroundUrl` TEXT NOT NULL,`pocketType` TEXT,`userPocketStatus` TEXT,`activateDate` INTEGER DEFAULT(NULL),`howTo` TEXT,`merchantId` TEXT,`label` TEXT,`subLabel` TEXT,`logoUrl` TEXT,`usable` INTEGER DEFAULT(NULL),`shareable` INTEGER DEFAULT(NULL),`goodsId` TEXT,`tcUrl` TEXT,`expirationDate` INTEGER DEFAULT(NULL),`createdDate` TEXT,`shareableRpcInfoReceiverInfo` TEXT,`shareableRpcInfoReceiverUserId` TEXT,`shareableRpcInfoSharedDate` INTEGER DEFAULT(NULL),`extendInfo` TEXT,PRIMARY KEY(pocketId) )");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `KtpDaoEntity` (`pocketId` TEXT NOT NULL,`pocketStatus` TEXT NOT NULL,`pocketType` TEXT NOT NULL,`backgroundUrl` TEXT NOT NULL,`createdDate` INTEGER DEFAULT(NULL),`iconUrl` TEXT,`logoUrl` TEXT,`extendInfo` TEXT,`cardTitle` TEXT,PRIMARY KEY(pocketId) )");
        }
    };
    static final Migration MIGRATION_21_22 = new Migration() { // from class: id.dana.data.base.BasePersistence.18
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `UserInfoEntity` (`userId` TEXT NOT NULL,`accountStatus` TEXT,`avatarUrl` TEXT,`balance` TEXT,`ktpName` TEXT,`kybInfo` TEXT,`kyc` TEXT,`kycCertified` INTEGER DEFAULT(0),`kycLevel` TEXT,`loginStatus` TEXT,`userStatus` TEXT,`ncc` TEXT,`loginId` TEXT,`nickname` TEXT,`pendingTransaction` TEXT,`shortcode` TEXT,`faceAuthStatus` INTEGER DEFAULT(0),`enrollStatus` INTEGER DEFAULT(0),`faceLoginReady` INTEGER DEFAULT(0),`username` TEXT,`userPan` TEXT,PRIMARY KEY(userId) )");
        }
    };
    static final Migration MIGRATION_22_23 = new Migration() { // from class: id.dana.data.base.BasePersistence.19
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE UserPaymentAssetsDaoEntity ADD COLUMN cardBackground TEXT");
        }
    };
    static final Migration MIGRATION_23_24 = new Migration() { // from class: id.dana.data.base.BasePersistence.20
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `RecentRecipientEntity` (`dataId` TEXT PRIMARY KEY NOT NULL,`alias` TEXT,`id` TEXT,`imageUrl` TEXT,`instLocalName` TEXT,`lastUpdated` INTEGER NOT NULL DEFAULT(0),`lastUpdateTime` INTEGER NOT NULL DEFAULT(0),`name` TEXT,`number` TEXT,`recipientName` TEXT,`senderName` TEXT,`payMethod` TEXT ,`payOption` TEXT ,`cardIndexNo` TEXT,`prefix` TEXT ,`transactionCount` INTEGER NOT NULL DEFAULT(0),`isFavorite` INTEGER NOT NULL DEFAULT(0),`type` INTEGER NOT NULL DEFAULT(0),`participantCount` INTEGER)");
        }
    };
    static final Migration MIGRATION_24_25 = new Migration() { // from class: id.dana.data.base.BasePersistence.21
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE UserPocketAssetsDaoEntity ADD COLUMN primaryCTA TEXT");
        }
    };
    static final Migration MIGRATION_25_26 = new Migration() { // from class: id.dana.data.base.BasePersistence.22
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE UserPocketAssetsDaoEntity ADD COLUMN backgroundColor TEXT");
            supportSQLiteDatabase.execSQL("ALTER TABLE UserPocketAssetsDaoEntity ADD COLUMN fontColor TEXT");
            supportSQLiteDatabase.execSQL("ALTER TABLE UserPocketAssetsDaoEntity ADD COLUMN minimumTransaction TEXT");
            supportSQLiteDatabase.execSQL("ALTER TABLE UserPocketAssetsDaoEntity ADD COLUMN categoryIconUrl TEXT");
        }
    };
    static final Migration MIGRATION_26_27 = new Migration() { // from class: id.dana.data.base.BasePersistence.23
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("ALTER TABLE UserPocketAssetsDaoEntity ADD COLUMN bizInfo TEXT");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ActivityItemEntity` (`entityId` TEXT NOT NULL,`activityId` TEXT NOT NULL,`commentCounts` INTEGER,`content` TEXT,`caption` TEXT,`createdTime` INTEGER,`extendInfo` TEXT,`iconUrl` TEXT,`id` TEXT,`imageUrls` TEXT,`ownActivity` INTEGER,`read` INTEGER,`redirectType` TEXT,`redirectValue` TEXT,`widget` TEXT,`latestComments` TEXT,`ownComments` TEXT,`ownReactions` TEXT,`reactionCounts` TEXT,`groupName` TEXT,`groupId` TEXT,`groupActorCount` INTEGER,`state` TEXT,`isSubmitFeedBanner` INTEGER,PRIMARY KEY(entityId) )");
        }
    };
    static final Migration MIGRATION_27_28 = new Migration() { // from class: id.dana.data.base.BasePersistence.24
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `NewsWidgetActivityDaoEntity` (`activityId` TEXT NOT NULL,`activityContent` TEXT ,`activityTitle` TEXT,`actorAvatar` TEXT,`actorNickname` TEXT,`bizType` TEXT,`clickable` INTEGER NOT NULL DEFAULT(0),`content` TEXT,`createdTime` INTEGER DEFAULT(NULL),`feedType` TEXT,`imageUrl` TEXT,`redirectUrl` TEXT,`targetNickname` TEXT,`verb` TEXT,PRIMARY KEY(activityId) )");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `PromoBannerContentDaoEntity` (`bizType` TEXT ,`contentId` TEXT NOT NULL,`contentName` TEXT,`contentType` TEXT,`contentValue` TEXT,`effectiveDate` TEXT,`envType` TEXT,`expireDate` TEXT,`gmtCreate` TEXT,`gmtModified` TEXT,`language` TEXT,`priority` INTEGER DEFAULT(NULL),`redirectUrl` TEXT,`selectRule` TEXT,`spaceCode` TEXT,`status` TEXT,`tenantId` TEXT,`extendInfo` TEXT,`orderNo` INTEGER NOT NULL DEFAULT(0),PRIMARY KEY(contentId) )");
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `PromoBannerAnnouncementDaoEntity` (`subscriptionId` TEXT NOT NULL,`contentName` TEXT,`contentType` TEXT,`contentValue` TEXT,`redirectUrl` TEXT,`subMerchantId` TEXT,`title` TEXT,`subtitle` TEXT,`goodsName` TEXT,`goodsType` TEXT,`subscriptionDueDate` TEXT,`paymentStatus` TEXT,`totalAmount` TEXT,`iconUrl` TEXT,PRIMARY KEY(subscriptionId) )");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS SecureRecentBankEntity");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS RecentBankEntity");
            supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS RecentContactEntity");
            supportSQLiteDatabase.execSQL("ALTER TABLE UserPaymentAssetsDaoEntity ADD COLUMN cacheTimestamp INTEGER");
            supportSQLiteDatabase.execSQL("ALTER TABLE UserPocketAssetsDaoEntity ADD COLUMN cacheTimestamp INTEGER");
        }
    };
    static final Migration MIGRATION_28_29 = new Migration() { // from class: id.dana.data.base.BasePersistence.25
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `MoreForYouDaoEntity` (`contentId` TEXT NOT NULL,`clientId` TEXT,`scopes` TEXT,`redirectType` TEXT,`icon` TEXT,`title` TEXT,`subtitle` TEXT,`redirectUrl` TEXT,`contentName` TEXT,`contentType` TEXT,`spaceCode` TEXT,`priority` INTEGER,`createdDate` INTEGER,`bizScenario` TEXT,`localIconId` INTEGER,`expireDate` TEXT,`orderNo` INTEGER NOT NULL DEFAULT(0),PRIMARY KEY(contentId) )");
        }
    };
    static final Migration MIGRATION_29_30 = new Migration() { // from class: id.dana.data.base.BasePersistence.26
        @Override // androidx.room.migration.Migration
        public final void MyBillsEntityDataFactory(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SingleBalanceDaoEntity` (`userId` TEXT NOT NULL,`amount` TEXT,`currency` TEXT,`placeholder` INTEGER NOT NULL DEFAULT(0),PRIMARY KEY(userId) )");
        }
    };

    public BasePersistence(Lazy<BasePersistenceDao> lazy) {
        this.persistanceDao = lazy;
    }

    public BasePersistenceDao getDb() {
        return this.persistanceDao.get();
    }
}
