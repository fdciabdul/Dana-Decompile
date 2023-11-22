package id.dana.cashier.data.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.SimpleSecureKeyPreference;
import java.util.Calendar;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0011\b\u0007\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b0\u00101J\u0013\u0010\u0003\u001a\u0006*\u00020\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0012J\u0013\u0010\u0017\u001a\u0006*\u00020\u00160\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001c\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u000e¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\"\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u001d\u0010%\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b%\u0010&J\u001d\u0010(\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b(\u0010&R\u0014\u0010)\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/"}, d2 = {"Lid/dana/cashier/data/repository/source/local/CashierPreference;", "", "Lid/dana/data/storage/LocalStorageFactory$Builder;", "createBuilder", "()Lid/dana/data/storage/LocalStorageFactory$Builder;", "", "phoneNumber", "getHighlightNewInstId", "(Ljava/lang/String;)Ljava/lang/String;", "mode", "instId", "", "getHighlightTimeShown", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)J", "", "getHighlightVersion", "(Ljava/lang/String;Ljava/lang/String;)I", "getLastTimeSmartPayActivationShow", "(Ljava/lang/String;)J", "getPaylaterCicilRegistrationCacheCooldownCount", "(Ljava/lang/String;)I", "getPaylaterCicilRegistrationCacheCooldownDelay", "Lid/dana/data/storage/PreferenceFacade;", "initCashierPreference", "()Lid/dana/data/storage/PreferenceFacade;", "", "saveHighlightNewInstId", "(Ljava/lang/String;Ljava/lang/String;)Z", "saveHighlightTimeShown", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "version", "saveHighlightVersion", "(Ljava/lang/String;Ljava/lang/String;I)Z", "cacheCooldownCount", "savePaylaterCicilRegistrationCacheCooldownCount", "(ILjava/lang/String;)Z", "cacheCooldownDelayStartTime", "savePaylaterCicilRegistrationCacheCooldownDelay", "(JLjava/lang/String;)Z", "lastTime", "setLastSmartPayActivationShow", "cashierPreferenceGroup", "Ljava/lang/String;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CashierPreference {
    public static final String HIGHLIGHT_NEW = "highlight_new_instid_";
    public static final String HIGHLIGHT_TIME_SHOWN = "highlight_time_shown_";
    public static final String HIGHLIGHT_VERSION = "highlight_version_";
    public static final String LAST_TIME_SMARTPAY_ACTIVATION_SHOW_KEY = "last_time_smartpay_activation_show_";
    public static final String PAYLATER_CICIL_CACHE_COOLDOWN_COUNT_REGISTRATION = "paylater_cicil_cache_cooldown_count_registration_";
    public static final String PAYLATER_CICIL_CACHE_COOLDOWN_REGISTRATION = "paylater_cicil_cache_cooldown_registration_";
    private final String cashierPreferenceGroup;
    private final Context context;
    private final PreferenceFacade preferenceFacade;

    @Inject
    public CashierPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("production");
        this.cashierPreferenceGroup = sb.toString();
        PreferenceFacade initCashierPreference = initCashierPreference();
        Intrinsics.checkNotNullExpressionValue(initCashierPreference, "");
        this.preferenceFacade = new SimpleSecureKeyPreference(initCashierPreference);
    }

    private final LocalStorageFactory.Builder createBuilder() {
        return new LocalStorageFactory.Builder(this.context).setPreferenceGroup(this.cashierPreferenceGroup).setUseDrutherPreference(true);
    }

    private final PreferenceFacade initCashierPreference() {
        return new LocalStorageFactory(createBuilder()).createData("local");
    }

    public final boolean saveHighlightVersion(String phoneNumber, String instId, int version) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(instId, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(HIGHLIGHT_VERSION);
        sb.append(instId);
        sb.append('_');
        sb.append(phoneNumber);
        preferenceFacade.saveData(sb.toString(), Integer.valueOf(version));
        return true;
    }

    public final int getHighlightVersion(String phoneNumber, String instId) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(instId, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(HIGHLIGHT_VERSION);
        sb.append(instId);
        sb.append('_');
        sb.append(phoneNumber);
        Integer integer = preferenceFacade.getInteger(sb.toString());
        Intrinsics.checkNotNullExpressionValue(integer, "");
        return integer.intValue();
    }

    public final boolean saveHighlightNewInstId(String phoneNumber, String instId) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(instId, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(HIGHLIGHT_NEW);
        sb.append(phoneNumber);
        preferenceFacade.saveData(sb.toString(), instId);
        return true;
    }

    public final String getHighlightNewInstId(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(HIGHLIGHT_NEW);
        sb.append(phoneNumber);
        String string = preferenceFacade.getString(sb.toString());
        return string == null ? "" : string;
    }

    public final boolean saveHighlightTimeShown(String mode, String phoneNumber, String instId) {
        Intrinsics.checkNotNullParameter(mode, "");
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(instId, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(mode);
        sb.append("_highlight_time_shown_");
        sb.append(instId);
        sb.append('_');
        sb.append(phoneNumber);
        preferenceFacade.saveData(sb.toString(), Long.valueOf(Calendar.getInstance().getTimeInMillis()));
        return true;
    }

    public final long getHighlightTimeShown(String mode, String phoneNumber, String instId) {
        Intrinsics.checkNotNullParameter(mode, "");
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(instId, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(mode);
        sb.append("_highlight_time_shown_");
        sb.append(instId);
        sb.append('_');
        sb.append(phoneNumber);
        Long l = preferenceFacade.getLong(sb.toString());
        Intrinsics.checkNotNullExpressionValue(l, "");
        return l.longValue();
    }

    public final long getLastTimeSmartPayActivationShow(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append("last_time_smartpay_activation_show__");
        sb.append(phoneNumber);
        Long l = preferenceFacade.getLong(sb.toString());
        Intrinsics.checkNotNullExpressionValue(l, "");
        return l.longValue();
    }

    public final boolean setLastSmartPayActivationShow(long lastTime, String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append("last_time_smartpay_activation_show__");
        sb.append(phoneNumber);
        preferenceFacade.saveData(sb.toString(), Long.valueOf(lastTime));
        return true;
    }

    public final boolean savePaylaterCicilRegistrationCacheCooldownCount(int cacheCooldownCount, String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(PAYLATER_CICIL_CACHE_COOLDOWN_REGISTRATION);
        sb.append(phoneNumber);
        preferenceFacade.saveData(sb.toString(), Integer.valueOf(cacheCooldownCount));
        return true;
    }

    public final int getPaylaterCicilRegistrationCacheCooldownCount(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(PAYLATER_CICIL_CACHE_COOLDOWN_REGISTRATION);
        sb.append(phoneNumber);
        Integer integer = preferenceFacade.getInteger(sb.toString());
        if (integer == null) {
            return 0;
        }
        return integer.intValue();
    }

    public final boolean savePaylaterCicilRegistrationCacheCooldownDelay(long cacheCooldownDelayStartTime, String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(PAYLATER_CICIL_CACHE_COOLDOWN_COUNT_REGISTRATION);
        sb.append(phoneNumber);
        preferenceFacade.saveData(sb.toString(), Long.valueOf(cacheCooldownDelayStartTime));
        return true;
    }

    public final long getPaylaterCicilRegistrationCacheCooldownDelay(String phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        PreferenceFacade preferenceFacade = this.preferenceFacade;
        StringBuilder sb = new StringBuilder();
        sb.append(PAYLATER_CICIL_CACHE_COOLDOWN_COUNT_REGISTRATION);
        sb.append(phoneNumber);
        Long l = preferenceFacade.getLong(sb.toString());
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }
}
