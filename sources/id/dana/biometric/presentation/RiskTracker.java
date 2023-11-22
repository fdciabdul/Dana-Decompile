package id.dana.biometric.presentation;

import id.dana.biometric.domain.model.BiometricDataSize;
import id.dana.biometric.domain.model.RiskEventMapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H&JD\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007H&J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Lid/dana/biometric/presentation/RiskTracker;", "", "getMaxLimitTrackTime", "", "onPageEndAndZip", "", "onTrackPassiveBiometricDataSize", "Lkotlin/Function1;", "Lid/dana/biometric/domain/model/BiometricDataSize;", "onPageStart", "scheme", "", "onStartTrackPassiveBiometricReady", "Lkotlin/Function0;", "onStopTrackPassiveBiometricReady", "onTrackPassiveBiometricConfig", "", "track", "eventMapper", "Lid/dana/biometric/domain/model/RiskEventMapper;", "component-biometric_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface RiskTracker {
    int BuiltInFictitiousFunctionClassFactory();

    void MyBillsEntityDataFactory(RiskEventMapper riskEventMapper);

    void MyBillsEntityDataFactory(Function1<? super BiometricDataSize, Unit> function1);

    void getAuthRequestContext(String str, Function0<Unit> function0, Function0<Unit> function02, Function1<? super Boolean, Unit> function1);
}
