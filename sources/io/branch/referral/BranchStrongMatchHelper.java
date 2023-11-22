package io.branch.referral;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsService;
import com.huawei.hms.framework.common.ContainerUtils;
import io.branch.referral.Defines;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class BranchStrongMatchHelper {
    private static BranchStrongMatchHelper KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static int MyBillsEntityDataFactory = 750;
    private Class<?> BuiltInFictitiousFunctionClassFactory;
    private Class<?> PlaceComponentResult;
    private Class<?> getAuthRequestContext;
    private final Handler lookAheadTest;
    private boolean moveToNextValue;
    private Class<?> scheduleImpl;
    private Object NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    private boolean getErrorConfigVersion = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface StrongMatchCheckEvents {
        void BuiltInFictitiousFunctionClassFactory();
    }

    static /* synthetic */ boolean getAuthRequestContext(BranchStrongMatchHelper branchStrongMatchHelper) {
        branchStrongMatchHelper.getErrorConfigVersion = true;
        return true;
    }

    private BranchStrongMatchHelper() {
        this.moveToNextValue = true;
        try {
            this.PlaceComponentResult = Class.forName("android.support.customtabs.CustomTabsClient");
            this.getAuthRequestContext = Class.forName("android.support.customtabs.CustomTabsCallback");
            this.BuiltInFictitiousFunctionClassFactory = Class.forName("android.support.customtabs.CustomTabsSession");
            this.scheduleImpl = Class.forName("android.support.customtabs.ICustomTabsService");
        } catch (Throwable unused) {
            this.moveToNextValue = false;
        }
        this.lookAheadTest = new Handler();
    }

    public static BranchStrongMatchHelper getAuthRequestContext() {
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            KClassImpl$Data$declaredNonStaticMembers$2 = new BranchStrongMatchHelper();
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(Context context, String str, DeviceInfo deviceInfo, final PrefHelper prefHelper, final StrongMatchCheckEvents strongMatchCheckEvents) {
        long j;
        this.getErrorConfigVersion = false;
        long currentTimeMillis = System.currentTimeMillis();
        j = PrefHelper.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2.getLong("bnc_branch_strong_match_time", 0L);
        if (currentTimeMillis - j < 2592000000L) {
            KClassImpl$Data$declaredNonStaticMembers$2(strongMatchCheckEvents, this.getErrorConfigVersion);
        } else if (!this.moveToNextValue) {
            KClassImpl$Data$declaredNonStaticMembers$2(strongMatchCheckEvents, this.getErrorConfigVersion);
        } else {
            try {
                SystemObserver systemObserver = deviceInfo.KClassImpl$Data$declaredNonStaticMembers$2;
                SystemObserver.getAuthRequestContext(deviceInfo.PlaceComponentResult, DeviceInfo.BuiltInFictitiousFunctionClassFactory());
                final Uri KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(str, deviceInfo, context);
                if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                    this.lookAheadTest.postDelayed(new Runnable() { // from class: io.branch.referral.BranchStrongMatchHelper.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BranchStrongMatchHelper branchStrongMatchHelper = BranchStrongMatchHelper.this;
                            branchStrongMatchHelper.KClassImpl$Data$declaredNonStaticMembers$2(strongMatchCheckEvents, branchStrongMatchHelper.getErrorConfigVersion);
                        }
                    }, 500L);
                    final Method method = this.PlaceComponentResult.getMethod("warmup", Long.TYPE);
                    final Method method2 = this.PlaceComponentResult.getMethod("newSession", this.getAuthRequestContext);
                    final Method method3 = this.BuiltInFictitiousFunctionClassFactory.getMethod("mayLaunchUrl", Uri.class, Bundle.class, List.class);
                    Intent intent = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION);
                    intent.setPackage("com.android.chrome");
                    context.bindService(intent, new MockCustomTabServiceConnection() { // from class: io.branch.referral.BranchStrongMatchHelper.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super();
                        }

                        @Override // io.branch.referral.BranchStrongMatchHelper.MockCustomTabServiceConnection
                        public final void BuiltInFictitiousFunctionClassFactory(Object obj) {
                            BranchStrongMatchHelper branchStrongMatchHelper = BranchStrongMatchHelper.this;
                            branchStrongMatchHelper.NetworkUserEntityData$$ExternalSyntheticLambda0 = branchStrongMatchHelper.PlaceComponentResult.cast(obj);
                            if (BranchStrongMatchHelper.this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
                                try {
                                    method.invoke(BranchStrongMatchHelper.this.NetworkUserEntityData$$ExternalSyntheticLambda0, 0);
                                    Object invoke = method2.invoke(BranchStrongMatchHelper.this.NetworkUserEntityData$$ExternalSyntheticLambda0, null);
                                    if (invoke != null) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("Strong match request ");
                                        sb.append(KClassImpl$Data$declaredNonStaticMembers$22);
                                        PrefHelper.MyBillsEntityDataFactory(sb.toString());
                                        method3.invoke(invoke, KClassImpl$Data$declaredNonStaticMembers$22, null, null);
                                        PrefHelper.BuiltInFictitiousFunctionClassFactory("bnc_branch_strong_match_time", System.currentTimeMillis());
                                        BranchStrongMatchHelper.getAuthRequestContext(BranchStrongMatchHelper.this);
                                    }
                                } catch (Throwable unused) {
                                    BranchStrongMatchHelper.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
                                    BranchStrongMatchHelper branchStrongMatchHelper2 = BranchStrongMatchHelper.this;
                                    branchStrongMatchHelper2.KClassImpl$Data$declaredNonStaticMembers$2(strongMatchCheckEvents, branchStrongMatchHelper2.getErrorConfigVersion);
                                }
                            }
                        }

                        @Override // android.content.ServiceConnection
                        public void onServiceDisconnected(ComponentName componentName) {
                            BranchStrongMatchHelper.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
                            BranchStrongMatchHelper branchStrongMatchHelper = BranchStrongMatchHelper.this;
                            branchStrongMatchHelper.KClassImpl$Data$declaredNonStaticMembers$2(strongMatchCheckEvents, branchStrongMatchHelper.getErrorConfigVersion);
                        }
                    }, 33);
                    return;
                }
                KClassImpl$Data$declaredNonStaticMembers$2(strongMatchCheckEvents, this.getErrorConfigVersion);
            } catch (Throwable unused) {
                KClassImpl$Data$declaredNonStaticMembers$2(strongMatchCheckEvents, this.getErrorConfigVersion);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KClassImpl$Data$declaredNonStaticMembers$2(final StrongMatchCheckEvents strongMatchCheckEvents, boolean z) {
        if (strongMatchCheckEvents != null) {
            if (z) {
                new Handler().postDelayed(new Runnable() { // from class: io.branch.referral.BranchStrongMatchHelper.3
                    @Override // java.lang.Runnable
                    public void run() {
                        strongMatchCheckEvents.BuiltInFictitiousFunctionClassFactory();
                    }
                }, MyBillsEntityDataFactory);
            } else {
                strongMatchCheckEvents.BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    private static Uri KClassImpl$Data$declaredNonStaticMembers$2(String str, DeviceInfo deviceInfo, Context context) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("https://");
        sb.append(str);
        sb.append("/_strong_match?os=");
        sb.append(DeviceInfo.MyBillsEntityDataFactory());
        String obj = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(obj);
        sb2.append(ContainerUtils.FIELD_DELIMITER);
        sb2.append(Defines.Jsonkey.HardwareID.getKey());
        sb2.append("=");
        SystemObserver systemObserver = deviceInfo.KClassImpl$Data$declaredNonStaticMembers$2;
        sb2.append(SystemObserver.getAuthRequestContext(deviceInfo.PlaceComponentResult, DeviceInfo.BuiltInFictitiousFunctionClassFactory()));
        String obj2 = sb2.toString();
        SystemObserver systemObserver2 = deviceInfo.KClassImpl$Data$declaredNonStaticMembers$2;
        String key = (SystemObserver.getAuthRequestContext(deviceInfo.PlaceComponentResult, DeviceInfo.BuiltInFictitiousFunctionClassFactory()).getAuthRequestContext() ? Defines.Jsonkey.HardwareIDTypeVendor : Defines.Jsonkey.HardwareIDTypeRandom).getKey();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj2);
        sb3.append(ContainerUtils.FIELD_DELIMITER);
        sb3.append(Defines.Jsonkey.HardwareIDType.getKey());
        sb3.append("=");
        sb3.append(key);
        String obj3 = sb3.toString();
        String str2 = deviceInfo.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
        if (str2 != null && !BranchUtil.getAuthRequestContext(context)) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(obj3);
            sb4.append(ContainerUtils.FIELD_DELIMITER);
            sb4.append(Defines.Jsonkey.GoogleAdvertisingID.getKey());
            sb4.append("=");
            sb4.append(str2);
            obj3 = sb4.toString();
        }
        if (!PrefHelper.lookAheadTest("bnc_device_fingerprint_id").equals("bnc_no_value")) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(obj3);
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append(Defines.Jsonkey.DeviceFingerprintID.getKey());
            sb5.append("=");
            sb5.append(PrefHelper.lookAheadTest("bnc_device_fingerprint_id"));
            obj3 = sb5.toString();
        }
        if (!SystemObserver.MyBillsEntityDataFactory(deviceInfo.PlaceComponentResult).equals("bnc_no_value")) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(obj3);
            sb6.append(ContainerUtils.FIELD_DELIMITER);
            sb6.append(Defines.Jsonkey.AppVersion.getKey());
            sb6.append("=");
            sb6.append(SystemObserver.MyBillsEntityDataFactory(deviceInfo.PlaceComponentResult));
            obj3 = sb6.toString();
        }
        if (PrefHelper.getAuthRequestContext == null) {
            PrefHelper.getAuthRequestContext = PrefHelper.lookAheadTest("bnc_branch_key");
        }
        if (!PrefHelper.getAuthRequestContext.equals("bnc_no_value")) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(obj3);
            sb7.append(ContainerUtils.FIELD_DELIMITER);
            sb7.append(Defines.Jsonkey.BranchKey.getKey());
            sb7.append("=");
            if (PrefHelper.getAuthRequestContext == null) {
                PrefHelper.getAuthRequestContext = PrefHelper.lookAheadTest("bnc_branch_key");
            }
            sb7.append(PrefHelper.getAuthRequestContext);
            obj3 = sb7.toString();
        }
        StringBuilder sb8 = new StringBuilder();
        sb8.append(obj3);
        sb8.append("&sdk=android4.1.0");
        return Uri.parse(sb8.toString());
    }

    /* loaded from: classes6.dex */
    abstract class MockCustomTabServiceConnection implements ServiceConnection {
        public abstract void BuiltInFictitiousFunctionClassFactory(Object obj);

        MockCustomTabServiceConnection() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Constructor declaredConstructor = BranchStrongMatchHelper.this.PlaceComponentResult.getDeclaredConstructor(BranchStrongMatchHelper.this.scheduleImpl, ComponentName.class);
                declaredConstructor.setAccessible(true);
                BuiltInFictitiousFunctionClassFactory(declaredConstructor.newInstance(Class.forName("android.support.customtabs.ICustomTabsService$Stub").getMethod("asInterface", IBinder.class).invoke(null, iBinder), componentName));
            } catch (Throwable unused) {
                BuiltInFictitiousFunctionClassFactory(null);
            }
        }
    }
}
