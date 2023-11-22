package com.iap.ac.android.region.cdp.component.defaults;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.spi.SPIManager;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.region.cdp.WalletCdpKit;
import com.iap.ac.android.region.cdp.component.AmcsConfigComponent;
import com.iap.ac.android.region.cdp.component.LocalStorageComponent;
import com.iap.ac.android.region.cdp.database.sqlite.SQLiteOpenHelperFactory;
import com.iap.ac.android.region.cdp.database.sqlite.SQLiteOpenHelperManager;
import com.iap.ac.android.region.cdp.database.sqlite.SQLiteTableManager;
import com.iap.ac.android.region.cdp.database.sqlite.SimpleSQLiteOpenHelper;
import com.iap.ac.android.region.cdp.database.sqlite.TransactionHelper;
import com.iap.ac.android.region.cdp.model.CdpBehaviorInfo;
import com.iap.ac.android.region.cdp.model.CdpContentInfo;
import com.iap.ac.android.region.cdp.model.CdpFatigueInfo;
import com.iap.ac.android.region.cdp.model.CdpSpaceInfo;
import com.iap.ac.android.region.cdp.util.CdpUtils;
import com.iap.ac.android.region.cdp.util.SpProvider;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DefaultLocalStorageComponent extends BaseComponent implements LocalStorageComponent {
    public static final String DATABASE_FACTORY_ID = "wallet_cdp_data";
    public static final String DATABASE_NAME = "wallet_cdp_data.db";
    public static final int DATABASE_VERSION = 1;
    public CdpTableManager<CdpBehaviorInfo> mBehaviorInfoTableManager;
    public CdpTableManager<CdpContentInfo> mContentInfoTableManager;
    public CdpTableManager<CdpFatigueInfo> mFatigueInfoTableManager;
    public CdpTableManager<CdpSpaceInfo> mSpaceInfoTableManager;
    public static final String TAG = CdpUtils.logTag("DefaultLocalStorageComponent");
    public static final Object DB_LOCK = new Object();

    /* loaded from: classes3.dex */
    public static class CdpTableManager<T> extends SQLiteTableManager<T, Long> {
        public static final String WHERE_DELIVER_ID_ACTION_PERIOD_USER_ID_LOCALE = "deliverId = ? AND action = ? AND period = ? AND userId = ? AND locale = ?";
        public static final String WHERE_DELIVER_ID_USER_ID_LOCALE = "deliverId = ? AND userId = ? AND locale = ?";
        public static final String WHERE_SPACE_CODE_DELIVER_ID_ACTION_USER_ID_LOCALE = "spaceCode = ? AND deliverId = ? AND action = ? AND userId = ? AND locale = ?";
        public static final String WHERE_SPACE_CODE_DELIVER_ID_USER_ID_LOCALE = "spaceCode = ? AND deliverId = ? AND userId = ? AND locale = ?";
        public static final String WHERE_SPACE_CODE_USER_ID_LOCALE = "spaceCode = ? AND userId = ? AND locale = ?";

        public CdpTableManager(Class<T> cls, Context context) {
            super(cls, context);
        }

        public void deleteBySpaceCodeDeliverIdUserIdLocale(String str, String str2, String str3, String str4) throws SQLException {
            getReadableDatabase().delete(getTableName(), WHERE_SPACE_CODE_DELIVER_ID_USER_ID_LOCALE, new String[]{str, str2, str3, str4});
        }

        public void deleteBySpaceCodeUserIdLocale(String str, String str2, String str3) throws SQLException {
            getReadableDatabase().delete(getTableName(), WHERE_SPACE_CODE_USER_ID_LOCALE, new String[]{str, str2, str3});
        }

        public List<T> getByDeliverIdUserIdLocale(String str, String str2, String str3) throws SQLException {
            return get(WHERE_DELIVER_ID_USER_ID_LOCALE, new String[]{str, str2, str3}, null, null);
        }

        public List<T> getBySpaceCodeDeliverIdActionUserIdLocale(String str, String str2, String str3, String str4, String str5) throws SQLException {
            List<T> list = get(WHERE_SPACE_CODE_DELIVER_ID_ACTION_USER_ID_LOCALE, new String[]{str, str2, str3, str4, str5}, null, null);
            if (list.isEmpty()) {
                return null;
            }
            return list;
        }

        public List<T> getBySpaceCodeUserIdLocale(String str, String str2, String str3) throws SQLException {
            return get(WHERE_SPACE_CODE_USER_ID_LOCALE, new String[]{str, str2, str3}, null, null);
        }

        public T getFirstByDeliverIdActionPeriodUserIdLocale(String str, String str2, String str3, String str4, String str5) throws SQLException {
            List<T> list = get(WHERE_DELIVER_ID_ACTION_PERIOD_USER_ID_LOCALE, new String[]{str, str2, str3, str4, str5}, null, null);
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }

        public T getFirstByDeliverIdUserIdLocale(String str, String str2, String str3) throws SQLException {
            List<T> byDeliverIdUserIdLocale = getByDeliverIdUserIdLocale(str, str2, str3);
            if (byDeliverIdUserIdLocale.isEmpty()) {
                return null;
            }
            return byDeliverIdUserIdLocale.get(0);
        }

        public T getFirstBySpaceCodeUserIdLocale(String str, String str2, String str3) throws SQLException {
            List<T> bySpaceCodeUserIdLocale = getBySpaceCodeUserIdLocale(str, str2, str3);
            if (bySpaceCodeUserIdLocale.isEmpty()) {
                return null;
            }
            return bySpaceCodeUserIdLocale.get(0);
        }
    }

    public DefaultLocalStorageComponent() {
        SQLiteOpenHelperManager.getInstance().putSQLiteOpenHelperFactory(DATABASE_FACTORY_ID, new SQLiteOpenHelperFactory() { // from class: com.iap.ac.android.region.cdp.component.defaults.DefaultLocalStorageComponent.1
            {
                DefaultLocalStorageComponent.this = this;
            }

            @Override // com.iap.ac.android.region.cdp.database.sqlite.SQLiteOpenHelperFactory
            public SQLiteOpenHelper create(String str, Context context) {
                if (DefaultLocalStorageComponent.DATABASE_NAME.equals(str)) {
                    return new SimpleSQLiteOpenHelper(new Class[]{CdpSpaceInfo.class, CdpContentInfo.class, CdpFatigueInfo.class, CdpBehaviorInfo.class}, context, str, 1);
                }
                return null;
            }
        });
        ACLog.d(TAG, "database name is wallet_cdp_data.db, database factory id is wallet_cdp_data");
    }

    private Context getApplicationContextOrThrow() {
        return WalletCdpKit.getInstance().getApplicationContextOrThrow();
    }

    private void initManagers() {
        synchronized (this) {
            if (this.mSpaceInfoTableManager == null || this.mContentInfoTableManager == null || this.mFatigueInfoTableManager == null || this.mBehaviorInfoTableManager == null) {
                this.mSpaceInfoTableManager = new CdpTableManager<>(CdpSpaceInfo.class, getApplicationContextOrThrow());
                this.mContentInfoTableManager = new CdpTableManager<>(CdpContentInfo.class, getApplicationContextOrThrow());
                this.mFatigueInfoTableManager = new CdpTableManager<>(CdpFatigueInfo.class, getApplicationContextOrThrow());
                this.mBehaviorInfoTableManager = new CdpTableManager<>(CdpBehaviorInfo.class, getApplicationContextOrThrow());
                this.mSpaceInfoTableManager.setDatabase(DATABASE_NAME);
                this.mContentInfoTableManager.setDatabase(DATABASE_NAME);
                this.mFatigueInfoTableManager.setDatabase(DATABASE_NAME);
                this.mBehaviorInfoTableManager.setDatabase(DATABASE_NAME);
            }
        }
    }

    @Override // com.iap.ac.android.region.cdp.component.LocalStorageComponent
    public void deleteBehavior(CdpBehaviorInfo cdpBehaviorInfo) throws Exception {
        initManagers();
        synchronized (DB_LOCK) {
            this.mBehaviorInfoTableManager.delete(cdpBehaviorInfo);
        }
    }

    @Override // com.iap.ac.android.region.cdp.component.LocalStorageComponent
    public void deleteSpaceInfo(final String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final String openId = SPIManager.getInstance().getOpenId();
        if (!TextUtils.isEmpty(openId)) {
            final String appLanguage = CdpUtils.getAppLanguage();
            if (!TextUtils.isEmpty(appLanguage)) {
                initManagers();
                synchronized (DB_LOCK) {
                    TransactionHelper.callInTransaction(getApplicationContextOrThrow(), DATABASE_NAME, new Callable<Void>() { // from class: com.iap.ac.android.region.cdp.component.defaults.DefaultLocalStorageComponent.3
                        {
                            DefaultLocalStorageComponent.this = this;
                        }

                        @Override // java.util.concurrent.Callable
                        public Void call() throws Exception {
                            DefaultLocalStorageComponent.this.mSpaceInfoTableManager.deleteBySpaceCodeUserIdLocale(str, openId, appLanguage);
                            DefaultLocalStorageComponent.this.mContentInfoTableManager.deleteBySpaceCodeUserIdLocale(str, openId, appLanguage);
                            DefaultLocalStorageComponent.this.mFatigueInfoTableManager.deleteBySpaceCodeUserIdLocale(str, openId, appLanguage);
                            return null;
                        }
                    });
                }
                ACLog.d(TAG, String.format("deleteSpaceInfo success,spaceCode: %s", str));
                return;
            }
            throw new IllegalArgumentException("locale is empty in getAppLanguage");
        }
        throw new IllegalArgumentException("userId is empty in getOpenId");
    }

    @Override // com.iap.ac.android.region.cdp.component.LocalStorageComponent
    public CdpBehaviorInfo getBehaviorInfo(String str, String str2, String str3, String str4, String str5) throws Exception {
        CdpBehaviorInfo firstByDeliverIdActionPeriodUserIdLocale;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return null;
        }
        initManagers();
        synchronized (DB_LOCK) {
            firstByDeliverIdActionPeriodUserIdLocale = this.mBehaviorInfoTableManager.getFirstByDeliverIdActionPeriodUserIdLocale(str, str2, str3, str4, str5);
        }
        return firstByDeliverIdActionPeriodUserIdLocale;
    }

    @Override // com.iap.ac.android.region.cdp.component.LocalStorageComponent
    public CdpContentInfo getContentInfo(String str, String str2, String str3) throws Exception {
        CdpContentInfo firstByDeliverIdUserIdLocale;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        initManagers();
        synchronized (DB_LOCK) {
            firstByDeliverIdUserIdLocale = this.mContentInfoTableManager.getFirstByDeliverIdUserIdLocale(str, str2, str3);
        }
        return firstByDeliverIdUserIdLocale;
    }

    @Override // com.iap.ac.android.region.cdp.component.LocalStorageComponent
    public List<CdpFatigueInfo> getFatigueInfo(String str, String str2, String str3, String str4, String str5) throws Exception {
        List<CdpFatigueInfo> bySpaceCodeDeliverIdActionUserIdLocale;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        initManagers();
        synchronized (DB_LOCK) {
            bySpaceCodeDeliverIdActionUserIdLocale = this.mFatigueInfoTableManager.getBySpaceCodeDeliverIdActionUserIdLocale(str, str2, str3, str4, str5);
        }
        return bySpaceCodeDeliverIdActionUserIdLocale;
    }

    @Override // com.iap.ac.android.region.cdp.component.LocalStorageComponent
    public CdpSpaceInfo getSpaceInfo(String str, String str2, String str3) throws Exception {
        CdpSpaceInfo firstBySpaceCodeUserIdLocale;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        initManagers();
        synchronized (DB_LOCK) {
            firstBySpaceCodeUserIdLocale = this.mSpaceInfoTableManager.getFirstBySpaceCodeUserIdLocale(str, str2, str3);
            if (firstBySpaceCodeUserIdLocale != null) {
                firstBySpaceCodeUserIdLocale.contentInfos = this.mContentInfoTableManager.getBySpaceCodeUserIdLocale(str, str2, str3);
                List<CdpContentInfo> list = firstBySpaceCodeUserIdLocale.contentInfos;
                if (list != null) {
                    for (CdpContentInfo cdpContentInfo : list) {
                        if (cdpContentInfo != null) {
                            cdpContentInfo.fatigueInfos = this.mFatigueInfoTableManager.getByDeliverIdUserIdLocale(cdpContentInfo.deliverId, str2, str3);
                        }
                    }
                }
            }
        }
        return firstBySpaceCodeUserIdLocale;
    }

    @Override // com.iap.ac.android.region.cdp.component.LocalStorageComponent
    public Map<String, CdpSpaceInfo> getSpaceInfoMap(List<String> list, String str, String str2) throws Exception {
        if (list != null && !list.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (String str3 : list) {
                CdpSpaceInfo spaceInfo = getSpaceInfo(str3, str, str2);
                if (spaceInfo != null) {
                    hashMap.put(str3, spaceInfo);
                }
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }

    @Override // com.iap.ac.android.region.cdp.component.LocalStorageComponent
    public void insertOrReplaceBehaviorInfo(List<CdpBehaviorInfo> list) throws Exception {
        if (CdpUtils.isEmpty(list)) {
            return;
        }
        Iterator<CdpBehaviorInfo> it = list.iterator();
        while (it.hasNext()) {
            insertOrReplaceBehaviorInfo(it.next());
        }
    }

    @Override // com.iap.ac.android.region.cdp.component.LocalStorageComponent
    public void insertOrReplaceSpaceInfo(final CdpSpaceInfo cdpSpaceInfo) throws Exception {
        if (cdpSpaceInfo == null || cdpSpaceInfo.spaceCode == null) {
            return;
        }
        final String openId = SPIManager.getInstance().getOpenId();
        if (!TextUtils.isEmpty(openId)) {
            final String appLanguage = CdpUtils.getAppLanguage();
            if (!TextUtils.isEmpty(appLanguage)) {
                initManagers();
                synchronized (DB_LOCK) {
                    TransactionHelper.callInTransaction(getApplicationContextOrThrow(), DATABASE_NAME, new Callable<Void>() { // from class: com.iap.ac.android.region.cdp.component.defaults.DefaultLocalStorageComponent.2
                        {
                            DefaultLocalStorageComponent.this = this;
                        }

                        @Override // java.util.concurrent.Callable
                        public Void call() throws Exception {
                            CdpSpaceInfo cdpSpaceInfo2 = cdpSpaceInfo;
                            cdpSpaceInfo2.userId = openId;
                            cdpSpaceInfo2.locale = appLanguage;
                            DefaultLocalStorageComponent.this.mSpaceInfoTableManager.insertOrReplace((CdpTableManager) cdpSpaceInfo);
                            List<CdpContentInfo> list = cdpSpaceInfo.contentInfos;
                            if (list != null) {
                                for (CdpContentInfo cdpContentInfo : list) {
                                    if (cdpContentInfo != null) {
                                        cdpContentInfo.userId = openId;
                                        cdpContentInfo.locale = appLanguage;
                                        List<CdpFatigueInfo> list2 = cdpContentInfo.fatigueInfos;
                                        if (list2 != null) {
                                            for (CdpFatigueInfo cdpFatigueInfo : list2) {
                                                if (cdpFatigueInfo != null) {
                                                    cdpFatigueInfo.userId = openId;
                                                    cdpFatigueInfo.locale = appLanguage;
                                                }
                                            }
                                            DefaultLocalStorageComponent.this.mFatigueInfoTableManager.insertOrReplace((Collection) cdpContentInfo.fatigueInfos);
                                        }
                                    }
                                }
                                DefaultLocalStorageComponent.this.mContentInfoTableManager.insertOrReplace((Collection) cdpSpaceInfo.contentInfos);
                                return null;
                            }
                            return null;
                        }
                    });
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Locale is not set in SpaceInfo: ");
            sb.append(cdpSpaceInfo);
            throw new IllegalArgumentException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("UserId is not set in SpaceInfo: ");
        sb2.append(cdpSpaceInfo);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // com.iap.ac.android.region.cdp.component.LocalStorageComponent
    public void deleteBehavior(String str, String str2) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String openId = SPIManager.getInstance().getOpenId();
        if (!TextUtils.isEmpty(openId)) {
            String appLanguage = CdpUtils.getAppLanguage();
            if (!TextUtils.isEmpty(appLanguage)) {
                initManagers();
                synchronized (DB_LOCK) {
                    this.mBehaviorInfoTableManager.deleteBySpaceCodeDeliverIdUserIdLocale(str, str2, openId, appLanguage);
                }
                return;
            }
            throw new IllegalArgumentException("locale is empty in getAppLanguage");
        }
        throw new IllegalArgumentException("userId is empty in getOpenId");
    }

    @Override // com.iap.ac.android.region.cdp.component.LocalStorageComponent
    public void insertOrReplaceBehaviorInfo(CdpBehaviorInfo cdpBehaviorInfo) throws Exception {
        if (cdpBehaviorInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(cdpBehaviorInfo.userId)) {
            if (!TextUtils.isEmpty(cdpBehaviorInfo.locale)) {
                initManagers();
                synchronized (DB_LOCK) {
                    this.mBehaviorInfoTableManager.insertOrReplace((CdpTableManager<CdpBehaviorInfo>) cdpBehaviorInfo);
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Locale is not set in BehaviorInfo: ");
            sb.append(cdpBehaviorInfo);
            throw new IllegalArgumentException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("UserId is not set in BehaviorInfo: ");
        sb2.append(cdpBehaviorInfo);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // com.iap.ac.android.region.cdp.component.LocalStorageComponent
    public List<CdpBehaviorInfo> getBehaviorInfo(String str, String str2, String str3) throws Exception {
        List<CdpBehaviorInfo> bySpaceCodeUserIdLocale;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        initManagers();
        synchronized (DB_LOCK) {
            bySpaceCodeUserIdLocale = this.mBehaviorInfoTableManager.getBySpaceCodeUserIdLocale(str, str2, str3);
        }
        return bySpaceCodeUserIdLocale;
    }

    @Override // com.iap.ac.android.region.cdp.component.LocalStorageComponent
    public void deleteSpaceInfo(Collection<String> collection, boolean z) {
        if (CdpUtils.isEmpty(collection)) {
            return;
        }
        JSONObject forceClearCachedSpaceCodes = ((AmcsConfigComponent) getComponent(AmcsConfigComponent.class)).getForceClearCachedSpaceCodes();
        for (String str : collection) {
            if (z) {
                try {
                    deleteSpaceInfo(str);
                } catch (Exception e) {
                    ACLog.d(TAG, String.format("deleteSpaceInfo failed, spaceCode: %s, error: %s", str, e.getMessage()));
                }
            } else if (forceClearCachedSpaceCodes.has(str)) {
                String optString = forceClearCachedSpaceCodes.optString(str);
                if (TextUtils.isEmpty(optString)) {
                    optString = String.valueOf(System.currentTimeMillis());
                }
                if (!TextUtils.equals(optString, SpProvider.getInstance().getUniqueClearTag(str))) {
                    deleteSpaceInfo(str);
                    SpProvider.getInstance().saveUniqueClearTag(str, optString);
                }
            }
        }
    }

    @Override // com.iap.ac.android.region.cdp.component.LocalStorageComponent
    public void insertOrReplaceSpaceInfo(Collection<CdpSpaceInfo> collection) throws Exception {
        if (collection != null) {
            Iterator<CdpSpaceInfo> it = collection.iterator();
            while (it.hasNext()) {
                insertOrReplaceSpaceInfo(it.next());
            }
        }
    }
}
