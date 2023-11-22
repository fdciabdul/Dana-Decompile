package id.dana.domain.featureconfig;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\u0007J\u000f\u0010\u000f\u001a\u00020\u0005H&¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\u0005H&¢\u0006\u0004\b\u0010\u0010\u0007J\u001f\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0016\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0017\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&¢\u0006\u0004\b\u0019\u0010\u001aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/featureconfig/ScannerConfigEntityData;", "", "", "clearAll", "()V", "", "getFeatureCashierDeeplinkKybEnable", "()Z", "getFeatureNativeDecodeEnable", "getFeaturePaymentKeyboardEnable", "", "", "getQrisCpmPrefixs", "()Ljava/util/List;", "isFeatureCashierDeeplinkKybTimeExpired", "isFeatureNativeDecodeTimeExpired", "isFeaturePaymentKeyboardTimeExpired", "enable", "", "createdTime", "setFeatureCashierDeeplinkKybEnable", "(ZJ)V", "setFeatureNativeDecodeEnable", "setFeaturePaymentKeyboardEnable", "prefixes", "setQrisCpmPrefixs", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ScannerConfigEntityData {
    void clearAll();

    boolean getFeatureCashierDeeplinkKybEnable();

    boolean getFeatureNativeDecodeEnable();

    boolean getFeaturePaymentKeyboardEnable();

    List<String> getQrisCpmPrefixs();

    boolean isFeatureCashierDeeplinkKybTimeExpired();

    boolean isFeatureNativeDecodeTimeExpired();

    boolean isFeaturePaymentKeyboardTimeExpired();

    void setFeatureCashierDeeplinkKybEnable(boolean enable, long createdTime);

    void setFeatureNativeDecodeEnable(boolean enable, long createdTime);

    void setFeaturePaymentKeyboardEnable(boolean enable, long createdTime);

    void setQrisCpmPrefixs(List<String> prefixes);
}
