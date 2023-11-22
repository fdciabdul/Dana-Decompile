package id.dana.data.requestmoney.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.account.AccountEntity;
import id.dana.data.account.repository.source.SecuredAccountPreferences;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.foundation.utils.CommonUtil;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.SimpleSecureKeyPreference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 *2\u00020\u0001:\u0001*B\u0011\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b(\u0010)J\u0013\u0010\u0003\u001a\u0006*\u00020\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0006*\u00020\u00050\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0006*\u00020\u000b0\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\nJ\u0011\u0010\u000f\u001a\u0006*\u00020\u00050\u0005¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\nJ\u0013\u0010\u0011\u001a\u0006*\u00020\b0\bH\u0002¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010'"}, d2 = {"Lid/dana/data/requestmoney/repository/source/local/RequestMoneyPreference;", "", "Lid/dana/data/account/AccountEntity;", "getAccount", "()Lid/dana/data/account/AccountEntity;", "", "getLastNameCheckTimestamp", "()Ljava/lang/Long;", "", "getLastNameCheckTimestampPrefKey", "()Ljava/lang/String;", "", "getNameCheckCount", "()Ljava/lang/Integer;", "getNameCheckExpiredPrefKey", "getNameCheckExpiredTime", "getNameCheckPrefKey", "getPhoneNumber", "", "initSaPreference", "()V", "timestamp", "", "setLastNameCheckTimestamp", "(J)Z", "count", "setNameCheckCount", "(I)Z", "setNameCheckExpiredTime", "REQUEST_MONEY_PREFERENCE", "Ljava/lang/String;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/account/repository/source/SecuredAccountPreferences;", "saPreferencesFacade", "Lid/dana/data/account/repository/source/SecuredAccountPreferences;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RequestMoneyPreference {
    private static final String REQUEST_MONEY_LAST_NAME_CHECK_TIME_STAMP = "request_money_last_name_check_time_stamp_";
    private static final String REQUEST_MONEY_NAME_CHECK_COUNT = "request_money_name_check_count_";
    private static final String REQUEST_MONEY_NAME_CHECK_EXPIRED_TIME = "request_money_name_check_count_expired_time_";
    private String REQUEST_MONEY_PREFERENCE;
    private final Context context;
    private final PreferenceFacade preferenceFacade;
    private SecuredAccountPreferences saPreferencesFacade;

    @Inject
    public RequestMoneyPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("production");
        this.REQUEST_MONEY_PREFERENCE = sb.toString();
        initSaPreference();
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(this.REQUEST_MONEY_PREFERENCE).setUseDrutherPreference(true)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.preferenceFacade = new SimpleSecureKeyPreference(createData2);
    }

    private final void initSaPreference() {
        SecuredAccountPreferences securedAccountPreferences = new SecuredAccountPreferences(this.context, null);
        this.saPreferencesFacade = securedAccountPreferences;
        securedAccountPreferences.init(CommonUtil.MyBillsEntityDataFactory(new SecurityGuardFacade(this.context), ""));
    }

    public final boolean setNameCheckCount(int count) {
        this.preferenceFacade.saveData(getNameCheckPrefKey(), Integer.valueOf(count));
        return true;
    }

    public final Integer getNameCheckCount() {
        return this.preferenceFacade.getInteger(getNameCheckPrefKey());
    }

    public final boolean setNameCheckExpiredTime(long timestamp) {
        this.preferenceFacade.saveData(getNameCheckExpiredPrefKey(), Long.valueOf(timestamp));
        return true;
    }

    public final Long getNameCheckExpiredTime() {
        return this.preferenceFacade.getLong(getNameCheckExpiredPrefKey());
    }

    public final boolean setLastNameCheckTimestamp(long timestamp) {
        this.preferenceFacade.saveData(getLastNameCheckTimestampPrefKey(), Long.valueOf(timestamp));
        return true;
    }

    public final Long getLastNameCheckTimestamp() {
        return this.preferenceFacade.getLong(getLastNameCheckTimestampPrefKey());
    }

    private final AccountEntity getAccount() {
        SecuredAccountPreferences securedAccountPreferences = this.saPreferencesFacade;
        if (securedAccountPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            securedAccountPreferences = null;
        }
        return securedAccountPreferences.getAccount();
    }

    private final String getPhoneNumber() {
        if (getAccount() != null) {
            return getAccount().getPhoneNumber();
        }
        initSaPreference();
        return getAccount().getPhoneNumber();
    }

    private final String getNameCheckPrefKey() {
        StringBuilder sb = new StringBuilder();
        sb.append(REQUEST_MONEY_NAME_CHECK_COUNT);
        sb.append(getPhoneNumber());
        return sb.toString();
    }

    private final String getNameCheckExpiredPrefKey() {
        StringBuilder sb = new StringBuilder();
        sb.append(REQUEST_MONEY_NAME_CHECK_EXPIRED_TIME);
        sb.append(getPhoneNumber());
        return sb.toString();
    }

    private final String getLastNameCheckTimestampPrefKey() {
        StringBuilder sb = new StringBuilder();
        sb.append(REQUEST_MONEY_LAST_NAME_CHECK_TIME_STAMP);
        sb.append(getPhoneNumber());
        return sb.toString();
    }
}
