package id.dana.data.config.source.sharedpreference;

import com.google.gson.Gson;
import id.dana.data.storage.PreferenceFacade;
import id.dana.domain.featureconfig.ScannerConfigEntityData;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 &2\u00020\u0001:\u0001&B\u001b\b\u0007\u0012\b\b\u0001\u0010\"\u001a\u00020!\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u000bJ\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ\u001f\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u001d\u0010\u001c\u001a\u00020\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#"}, d2 = {"Lid/dana/data/config/source/sharedpreference/SharedPrefScannerConfig;", "Lid/dana/domain/featureconfig/ScannerConfigEntityData;", "", "key", "", "checkTimeisExpired", "(Ljava/lang/String;)Z", "", "clearAll", "()V", "getFeatureCashierDeeplinkKybEnable", "()Z", "getFeatureNativeDecodeEnable", "getFeaturePaymentKeyboardEnable", "", "getQrisCpmPrefixs", "()Ljava/util/List;", "isFeatureCashierDeeplinkKybTimeExpired", "isFeatureNativeDecodeTimeExpired", "isFeaturePaymentKeyboardTimeExpired", "enable", "", "createdTime", "setFeatureCashierDeeplinkKybEnable", "(ZJ)V", "setFeatureNativeDecodeEnable", "setFeaturePaymentKeyboardEnable", "prefixes", "setQrisCpmPrefixs", "(Ljava/util/List;)V", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "<init>", "(Lid/dana/data/storage/PreferenceFacade;Lcom/google/gson/Gson;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SharedPrefScannerConfig implements ScannerConfigEntityData {
    public static final String FEATURE_CASHIER_DEEPLINK_KYB = "featurecashierdeeplinkkyb";
    public static final String FEATURE_CASHIER_DEEPLINK_TIME_SAVED_KEY = "featurecashierdeeplinktimesavedkey";
    public static final String FEATURE_NATIVE_DECODE = "featurenativedecode";
    public static final String FEATURE_NATIVE_DECODE_TIME_SAVED_KEY = "featurenativedecodetimesavedkey";
    public static final String FEATURE_PAYMENT_KEYBOARD = "featurepaymentkeyboard";
    public static final String FEATURE_PAYMENT_KEYBOARD_TIME_SAVED_KEY = "featurepaymentkeyboardtimesavedkey";
    public static final String QRIS_CPM_PREFIX_KEY = "qriscpmprefixkey";
    public static final String SCANNER_PREFERENCE_KEY = "scannerpreferencekey";
    private final Gson gson;
    private final PreferenceFacade preferenceFacade;

    @Inject
    public SharedPrefScannerConfig(@Named("scannerpref") PreferenceFacade preferenceFacade, Gson gson) {
        Intrinsics.checkNotNullParameter(preferenceFacade, "");
        Intrinsics.checkNotNullParameter(gson, "");
        this.preferenceFacade = preferenceFacade;
        this.gson = gson;
    }

    @Override // id.dana.domain.featureconfig.ScannerConfigEntityData
    public final void setFeatureCashierDeeplinkKybEnable(boolean enable, long createdTime) {
        this.preferenceFacade.saveData(FEATURE_CASHIER_DEEPLINK_TIME_SAVED_KEY, Long.valueOf(createdTime));
        this.preferenceFacade.saveData(FEATURE_CASHIER_DEEPLINK_KYB, Boolean.valueOf(enable));
    }

    @Override // id.dana.domain.featureconfig.ScannerConfigEntityData
    public final void setFeaturePaymentKeyboardEnable(boolean enable, long createdTime) {
        this.preferenceFacade.saveData(FEATURE_PAYMENT_KEYBOARD_TIME_SAVED_KEY, Long.valueOf(createdTime));
        this.preferenceFacade.saveData(FEATURE_PAYMENT_KEYBOARD, Boolean.valueOf(enable));
    }

    @Override // id.dana.domain.featureconfig.ScannerConfigEntityData
    public final void setFeatureNativeDecodeEnable(boolean enable, long createdTime) {
        this.preferenceFacade.saveData(FEATURE_NATIVE_DECODE_TIME_SAVED_KEY, Long.valueOf(createdTime));
        this.preferenceFacade.saveData(FEATURE_NATIVE_DECODE, Boolean.valueOf(enable));
    }

    @Override // id.dana.domain.featureconfig.ScannerConfigEntityData
    public final boolean getFeatureCashierDeeplinkKybEnable() {
        Boolean bool = this.preferenceFacade.getBoolean(FEATURE_CASHIER_DEEPLINK_KYB, true);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }

    @Override // id.dana.domain.featureconfig.ScannerConfigEntityData
    public final boolean getFeaturePaymentKeyboardEnable() {
        Boolean bool = this.preferenceFacade.getBoolean(FEATURE_PAYMENT_KEYBOARD, false);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }

    @Override // id.dana.domain.featureconfig.ScannerConfigEntityData
    public final boolean getFeatureNativeDecodeEnable() {
        Boolean bool = this.preferenceFacade.getBoolean(FEATURE_NATIVE_DECODE, true);
        Intrinsics.checkNotNullExpressionValue(bool, "");
        return bool.booleanValue();
    }

    private final boolean checkTimeisExpired(String key) {
        Long l;
        try {
            l = this.preferenceFacade.getLong(key);
            Intrinsics.checkNotNullExpressionValue(l, "");
        } catch (Exception unused) {
        }
        return Calendar.getInstance().getTimeInMillis() - l.longValue() > TimeUnit.MINUTES.toMillis(30L);
    }

    @Override // id.dana.domain.featureconfig.ScannerConfigEntityData
    public final boolean isFeatureCashierDeeplinkKybTimeExpired() {
        return checkTimeisExpired(FEATURE_CASHIER_DEEPLINK_TIME_SAVED_KEY);
    }

    @Override // id.dana.domain.featureconfig.ScannerConfigEntityData
    public final boolean isFeaturePaymentKeyboardTimeExpired() {
        return checkTimeisExpired(FEATURE_PAYMENT_KEYBOARD_TIME_SAVED_KEY);
    }

    @Override // id.dana.domain.featureconfig.ScannerConfigEntityData
    public final boolean isFeatureNativeDecodeTimeExpired() {
        return checkTimeisExpired(FEATURE_NATIVE_DECODE_TIME_SAVED_KEY);
    }

    @Override // id.dana.domain.featureconfig.ScannerConfigEntityData
    public final void clearAll() {
        this.preferenceFacade.clearAllData();
    }

    @Override // id.dana.domain.featureconfig.ScannerConfigEntityData
    public final void setQrisCpmPrefixs(List<String> prefixes) {
        Intrinsics.checkNotNullParameter(prefixes, "");
        this.preferenceFacade.saveData(QRIS_CPM_PREFIX_KEY, (String) prefixes);
    }

    @Override // id.dana.domain.featureconfig.ScannerConfigEntityData
    public final List<String> getQrisCpmPrefixs() {
        List<String> emptyList;
        String string = this.preferenceFacade.getString(QRIS_CPM_PREFIX_KEY);
        if (string != null) {
            try {
                Object fromJson = this.gson.fromJson(string, (Class<Object>) List.class);
                emptyList = fromJson instanceof List ? (List) fromJson : null;
            } catch (Exception unused) {
                emptyList = CollectionsKt.emptyList();
            }
            if (emptyList != null) {
                return emptyList;
            }
        }
        return CollectionsKt.emptyList();
    }
}
