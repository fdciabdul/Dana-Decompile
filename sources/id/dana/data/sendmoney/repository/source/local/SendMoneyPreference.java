package id.dana.data.sendmoney.repository.source.local;

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

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 '2\u00020\u0001:\u0001'B\u0011\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b%\u0010&J\u0013\u0010\u0003\u001a\u0006*\u00020\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\u0013\u0010\f\u001a\u0006*\u00020\u00050\u0005H\u0002¢\u0006\u0004\b\f\u0010\u0007J\r\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u0007J\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\nJ\u0015\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0014J\r\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\nJ\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b#\u0010$"}, d2 = {"Lid/dana/data/sendmoney/repository/source/local/SendMoneyPreference;", "", "Lid/dana/data/account/AccountEntity;", "getAccount", "()Lid/dana/data/account/AccountEntity;", "", "getExternalOnboardingPrefKey", "()Ljava/lang/String;", "", "getIsNeedToShowSmartFrictionSuspiciousAccount", "()Z", "getIsUserCertifiedGlobalSend", "getPhoneNumber", "getStateSendMoneyShareFeed", "", "initSaPreference", "()V", "isNeedToShowExternalOnboardingDialog", "isShow", "saveIsNeedToShowExternalOnboardingDialog", "(Z)Z", "saveIsNeedToShowSmartFrictionSuspiciousAccount", "saveIsUserCertifiedGlobalSend", "state", "saveStateSendMoneyShareFeed", "(Ljava/lang/String;)Z", "SEND_MONEY_PREFERENCE", "Ljava/lang/String;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "Lid/dana/data/account/repository/source/SecuredAccountPreferences;", "saPreferencesFacade", "Lid/dana/data/account/repository/source/SecuredAccountPreferences;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SendMoneyPreference {
    private static final String FIRST_STATE_SEND_MONEY_SHARE_FEED = "firstTime";
    private static final String IS_USER_CERTIFIED_GLOBAL_SEND = "is_user_certified_global_send";
    private static final String SEND_MONEY_EXTERNAL_ONBOARDING = "send_money_external_onboarding_";
    public static final String SEND_MONEY_SHARE_FEED = "send_money_share_feed";
    private static final String SMART_FRICTION_SUSPICIOUS_ACCOUNT = "smart_friction_suspicious_account";
    private String SEND_MONEY_PREFERENCE;
    private final Context context;
    private final PreferenceFacade preferenceFacade;
    private SecuredAccountPreferences saPreferencesFacade;

    @Inject
    public SendMoneyPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("production");
        this.SEND_MONEY_PREFERENCE = sb.toString();
        initSaPreference();
        PreferenceFacade createData2 = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(this.SEND_MONEY_PREFERENCE).setUseDrutherPreference(true)).createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        this.preferenceFacade = new SimpleSecureKeyPreference(createData2);
    }

    private final void initSaPreference() {
        SecuredAccountPreferences securedAccountPreferences = new SecuredAccountPreferences(this.context, null);
        this.saPreferencesFacade = securedAccountPreferences;
        securedAccountPreferences.init(CommonUtil.MyBillsEntityDataFactory(new SecurityGuardFacade(this.context), ""));
    }

    public final boolean saveIsNeedToShowExternalOnboardingDialog(boolean isShow) {
        this.preferenceFacade.saveData(getExternalOnboardingPrefKey(), Boolean.valueOf(!isShow));
        return true;
    }

    public final boolean isNeedToShowExternalOnboardingDialog() {
        return !this.preferenceFacade.getBoolean(getExternalOnboardingPrefKey()).booleanValue();
    }

    public final boolean saveStateSendMoneyShareFeed(String state) {
        Intrinsics.checkNotNullParameter(state, "");
        this.preferenceFacade.saveData(SEND_MONEY_SHARE_FEED, state);
        return true;
    }

    public final String getStateSendMoneyShareFeed() {
        String string = this.preferenceFacade.getString(SEND_MONEY_SHARE_FEED);
        return string == null ? "firstTime" : string;
    }

    public final boolean saveIsNeedToShowSmartFrictionSuspiciousAccount(boolean isShow) {
        this.preferenceFacade.saveData(SMART_FRICTION_SUSPICIOUS_ACCOUNT, Boolean.valueOf(isShow));
        return true;
    }

    public final boolean getIsNeedToShowSmartFrictionSuspiciousAccount() {
        Boolean bool = this.preferenceFacade.getBoolean(SMART_FRICTION_SUSPICIOUS_ACCOUNT);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }

    public final boolean saveIsUserCertifiedGlobalSend() {
        this.preferenceFacade.saveData(IS_USER_CERTIFIED_GLOBAL_SEND, Boolean.TRUE);
        return true;
    }

    public final boolean getIsUserCertifiedGlobalSend() {
        Boolean bool = this.preferenceFacade.getBoolean(IS_USER_CERTIFIED_GLOBAL_SEND, false);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
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

    private final String getExternalOnboardingPrefKey() {
        StringBuilder sb = new StringBuilder();
        sb.append(SEND_MONEY_EXTERNAL_ONBOARDING);
        sb.append(getPhoneNumber());
        return sb.toString();
    }
}
