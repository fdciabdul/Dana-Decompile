package id.dana.data.account.repository.source;

import android.content.Context;
import id.dana.data.account.AccountEntity;
import id.dana.data.account.TransactionEntity;
import id.dana.data.base.UnInitializedSecuredPreferencesException;
import id.dana.data.payasset.source.network.result.QueryPayMethodResult;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.Serializer;
import id.dana.utils.extension.StringExtKt;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class SecuredAccountPreferences {
    public static final String SECURED_ACCOUNT_PREFERENCES = "SecuredAccountPreferencesproduction";
    private final Context context;
    private String keyHash;
    private PreferenceFacade preferenceFacade;
    private final Serializer serializer;

    @Inject
    public SecuredAccountPreferences(Context context, Serializer serializer) {
        this.context = context;
        this.serializer = serializer;
    }

    public void init(String str) {
        String PlaceComponentResult = StringExtKt.PlaceComponentResult(str);
        if (this.preferenceFacade == null || !Objects.equals(PlaceComponentResult, this.keyHash)) {
            this.preferenceFacade = new LocalStorageFactory(new LocalStorageFactory.Builder(this.context).setPreferenceGroup(SECURED_ACCOUNT_PREFERENCES).setSerializerFacade(this.serializer).setPassword(str)).createData("local");
            this.keyHash = PlaceComponentResult;
        }
    }

    public void saveAccount(String str, String str2, String str3, String str4, String str5, String str6) throws UnInitializedSecuredPreferencesException {
        saveAccount(new AccountEntity(str, str2, str3, str4, str5, str6));
    }

    public void saveAccount(AccountEntity accountEntity) throws UnInitializedSecuredPreferencesException {
        initChecking();
        this.preferenceFacade.saveData(Key.ACCOUNT, (String) accountEntity);
        this.preferenceFacade.saveData(Key.USER_ID, accountEntity.getUserId());
    }

    private void initChecking() throws UnInitializedSecuredPreferencesException {
        if (this.preferenceFacade == null) {
            throw new UnInitializedSecuredPreferencesException();
        }
    }

    public boolean hasAccount() throws UnInitializedSecuredPreferencesException {
        return getAccount() != null;
    }

    public AccountEntity getAccount() throws UnInitializedSecuredPreferencesException {
        initChecking();
        return (AccountEntity) this.preferenceFacade.getObject(Key.ACCOUNT, AccountEntity.class);
    }

    public String getPhoneNumber() throws UnInitializedSecuredPreferencesException {
        AccountEntity account = getAccount();
        if (account != null) {
            return account.getPhoneNumber();
        }
        return null;
    }

    public String getUserId() throws UnInitializedSecuredPreferencesException {
        initChecking();
        String string = this.preferenceFacade.getString(Key.USER_ID);
        if (string == null) {
            AccountEntity account = getAccount();
            if (account != null) {
                String userId = account.getUserId();
                this.preferenceFacade.saveData(Key.USER_ID, userId);
                return userId;
            }
            return null;
        }
        return string;
    }

    public String getUUID() throws UnInitializedSecuredPreferencesException {
        AccountEntity account = getAccount();
        if (account != null) {
            return account.getUUID();
        }
        return null;
    }

    public QueryPayMethodResult getPayMethod() throws UnInitializedSecuredPreferencesException {
        initChecking();
        return (QueryPayMethodResult) this.preferenceFacade.getObject("pay_method_response", QueryPayMethodResult.class);
    }

    public void savePayMethodResult(QueryPayMethodResult queryPayMethodResult) throws UnInitializedSecuredPreferencesException {
        initChecking();
        this.preferenceFacade.saveData("pay_method_response", (String) queryPayMethodResult);
    }

    public QueryPayMethodResult getAssetCardResult() throws UnInitializedSecuredPreferencesException {
        initChecking();
        return (QueryPayMethodResult) this.preferenceFacade.getObject("asset_card_response", QueryPayMethodResult.class);
    }

    public void saveAssetCardResult(QueryPayMethodResult queryPayMethodResult) throws UnInitializedSecuredPreferencesException {
        initChecking();
        this.preferenceFacade.saveData("asset_card_response", (String) queryPayMethodResult);
    }

    public void clearAll() throws UnInitializedSecuredPreferencesException {
        initChecking();
        this.preferenceFacade.clearAllData();
    }

    public Boolean isFirstTime() throws UnInitializedSecuredPreferencesException {
        initChecking();
        return Boolean.valueOf(!this.preferenceFacade.getBoolean("finish_first_time").booleanValue());
    }

    public void finishFirstTime() throws UnInitializedSecuredPreferencesException {
        initChecking();
        this.preferenceFacade.saveData("finish_first_time", Boolean.TRUE);
    }

    public void saveLastUpdatePOI(Long l) {
        this.preferenceFacade.saveData("last_updated_poi_time", l);
    }

    public void saveLastUpdatedTimeUserPan(long j) throws UnInitializedSecuredPreferencesException {
        initChecking();
        this.preferenceFacade.saveData("last_updated_time_user_pan", Long.valueOf(j));
    }

    public Long getLastUpdatePOI() {
        return this.preferenceFacade.getLong("last_updated_poi_time");
    }

    public long getLastUpdatedTimeUserPan() throws UnInitializedSecuredPreferencesException {
        initChecking();
        return this.preferenceFacade.getLong("last_updated_time_user_pan").longValue();
    }

    public void saveStatePermissionLocation(boolean z) {
        this.preferenceFacade.saveData("permission_location_state", Boolean.valueOf(z));
    }

    public Boolean getStatePermissionLocation() {
        return this.preferenceFacade.getBoolean("permission_location_state");
    }

    public String getOfflinePublicKey() throws UnInitializedSecuredPreferencesException {
        initChecking();
        return this.preferenceFacade.getString("offline_public_key");
    }

    public void setOfflinePublicKey(String str) throws UnInitializedSecuredPreferencesException {
        initChecking();
        this.preferenceFacade.saveData("offline_public_key", str);
    }

    public String getCardCredentialPublicKey() throws UnInitializedSecuredPreferencesException {
        initChecking();
        String string = this.preferenceFacade.getString("card_credential_public_key");
        return string == null ? "" : string;
    }

    public void setCardCredentialPublicKey(String str) throws UnInitializedSecuredPreferencesException {
        initChecking();
        this.preferenceFacade.saveData("card_credential_public_key", str);
    }

    public void saveLastTransaction(TransactionEntity transactionEntity) throws UnInitializedSecuredPreferencesException {
        initChecking();
        this.preferenceFacade.saveData(Key.LAST_TRANSACTION, (String) transactionEntity);
    }

    public TransactionEntity getLatestTransaction() throws UnInitializedSecuredPreferencesException {
        initChecking();
        return (TransactionEntity) this.preferenceFacade.getObject(Key.LAST_TRANSACTION, TransactionEntity.class);
    }

    public void setClientKey(String str) throws UnInitializedSecuredPreferencesException {
        initChecking();
        this.preferenceFacade.saveData(Key.CLIENT_KEY, str);
    }

    public String getClientKey() throws UnInitializedSecuredPreferencesException {
        initChecking();
        return this.preferenceFacade.getString(Key.CLIENT_KEY);
    }

    /* loaded from: classes8.dex */
    public static class Key {
        public static final String ACCOUNT = "account";
        private static final String ASSET_CARD_RESPONE = "asset_card_response";
        private static final String CARD_CREDENTIAL_PUBLIC_KEY = "card_credential_public_key";
        public static final String CLIENT_KEY = "client_key";
        private static final String FINISH_FIRST_TIME = "finish_first_time";
        public static final String LAST_TRANSACTION = "last_transaction";
        private static final String LAST_UPDATED_POI_TIME = "last_updated_poi_time";
        private static final String LAST_UPDATED_TIME_USER_PAN = "last_updated_time_user_pan";
        private static final String OFFLINE_PUBLIC_KEY = "offline_public_key";
        private static final String PAY_METHOD_RESPONSE = "pay_method_response";
        private static final String PERMISSION_LOCATION_STATE = "permission_location_state";
        private static final String REQUESTMONEY_STATE_TUTORIAL = "requestmoneystatetutorial";
        public static final String USER_ID = "user_id";

        private Key() {
        }
    }
}
