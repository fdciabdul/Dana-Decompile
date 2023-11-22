package com.ipification.mobile.sdk.android.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ipification.mobile.sdk.android.SingletonHolder;
import com.ipification.mobile.sdk.android.model.SIMOperator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\u0007J\b\u0010\r\u001a\u00020\u0007H\u0002J\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/ipification/mobile/sdk/android/utils/DeviceUtils;", "", "c", "Landroid/content/Context;", "(Landroid/content/Context;)V", HummerConstants.CONTEXT, "mActiveSIMOperator", "Lcom/ipification/mobile/sdk/android/model/SIMOperator;", "getMActiveSIMOperator$ipification_auth_release", "()Lcom/ipification/mobile/sdk/android/model/SIMOperator;", "setMActiveSIMOperator$ipification_auth_release", "(Lcom/ipification/mobile/sdk/android/model/SIMOperator;)V", "activeSimOperator", "getActiveDataSimOperator", "getInfoSIM1", "getInfoSIM2", "isDualSim", "", "reset", "", "Companion", "ipification-auth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class DeviceUtils {
    public static final Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion();
    public SIMOperator BuiltInFictitiousFunctionClassFactory;
    public Context PlaceComponentResult;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/ipification/mobile/sdk/android/utils/DeviceUtils$Companion;", "Lcom/ipification/mobile/sdk/android/SingletonHolder;", "Lcom/ipification/mobile/sdk/android/utils/DeviceUtils;", "Landroid/content/Context;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion extends SingletonHolder<DeviceUtils, Context> {

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* renamed from: com.ipification.mobile.sdk.android.utils.DeviceUtils$Companion$1  reason: invalid class name */
        /* loaded from: classes3.dex */
        public final /* synthetic */ class AnonymousClass1 extends FunctionReference implements Function1<Context, DeviceUtils> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
            public final String getName() {
                return "<init>";
            }

            @Override // kotlin.jvm.internal.CallableReference
            public final KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinClass(DeviceUtils.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            public final String getSignature() {
                return "<init>(Landroid/content/Context;)V";
            }

            @Override // kotlin.jvm.functions.Function1
            public final DeviceUtils invoke(Context context) {
                Context context2 = context;
                Intrinsics.checkParameterIsNotNull(context2, "");
                return new DeviceUtils(context2);
            }
        }

        public Companion() {
            super(AnonymousClass1.INSTANCE);
        }
    }

    public DeviceUtils(Context context) {
        this.PlaceComponentResult = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005c A[Catch: Exception -> 0x00f3, TryCatch #0 {Exception -> 0x00f3, blocks: (B:3:0x0002, B:5:0x000d, B:7:0x0015, B:11:0x0027, B:15:0x0030, B:16:0x003a, B:18:0x0040, B:20:0x004a, B:22:0x0050, B:28:0x005c, B:31:0x0063, B:34:0x006a, B:37:0x0071, B:38:0x0079, B:40:0x0083, B:44:0x008c, B:48:0x0095, B:51:0x009c, B:55:0x00aa, B:57:0x00b4, B:63:0x00c0, B:69:0x00cc, B:74:0x00d6, B:75:0x00e2, B:76:0x00eb, B:77:0x00f2), top: B:89:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cc A[Catch: Exception -> 0x00f3, TryCatch #0 {Exception -> 0x00f3, blocks: (B:3:0x0002, B:5:0x000d, B:7:0x0015, B:11:0x0027, B:15:0x0030, B:16:0x003a, B:18:0x0040, B:20:0x004a, B:22:0x0050, B:28:0x005c, B:31:0x0063, B:34:0x006a, B:37:0x0071, B:38:0x0079, B:40:0x0083, B:44:0x008c, B:48:0x0095, B:51:0x009c, B:55:0x00aa, B:57:0x00b4, B:63:0x00c0, B:69:0x00cc, B:74:0x00d6, B:75:0x00e2, B:76:0x00eb, B:77:0x00f2), top: B:89:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.ipification.mobile.sdk.android.model.SIMOperator BuiltInFictitiousFunctionClassFactory() {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipification.mobile.sdk.android.utils.DeviceUtils.BuiltInFictitiousFunctionClassFactory():com.ipification.mobile.sdk.android.model.SIMOperator");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0051 A[Catch: Exception -> 0x00f4, TryCatch #0 {Exception -> 0x00f4, blocks: (B:3:0x0002, B:5:0x000d, B:8:0x0018, B:10:0x0023, B:12:0x0029, B:14:0x0030, B:16:0x0039, B:22:0x0045, B:28:0x0051, B:33:0x005b, B:34:0x0067, B:37:0x0075, B:39:0x007d, B:40:0x0081, B:49:0x009c, B:51:0x00a2, B:57:0x00ae, B:63:0x00ba, B:68:0x00c4, B:69:0x00cf, B:70:0x00d8, B:71:0x00de, B:72:0x00e5, B:73:0x00e6, B:75:0x00ec, B:76:0x00f3), top: B:80:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ba A[Catch: Exception -> 0x00f4, TryCatch #0 {Exception -> 0x00f4, blocks: (B:3:0x0002, B:5:0x000d, B:8:0x0018, B:10:0x0023, B:12:0x0029, B:14:0x0030, B:16:0x0039, B:22:0x0045, B:28:0x0051, B:33:0x005b, B:34:0x0067, B:37:0x0075, B:39:0x007d, B:40:0x0081, B:49:0x009c, B:51:0x00a2, B:57:0x00ae, B:63:0x00ba, B:68:0x00c4, B:69:0x00cf, B:70:0x00d8, B:71:0x00de, B:72:0x00e5, B:73:0x00e6, B:75:0x00ec, B:76:0x00f3), top: B:80:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.ipification.mobile.sdk.android.model.SIMOperator KClassImpl$Data$declaredNonStaticMembers$2() {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipification.mobile.sdk.android.utils.DeviceUtils.KClassImpl$Data$declaredNonStaticMembers$2():com.ipification.mobile.sdk.android.model.SIMOperator");
    }

    public final boolean MyBillsEntityDataFactory() {
        Object systemService = this.PlaceComponentResult.getSystemService("phone");
        if (systemService != null) {
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                if (telephonyManager.getActiveModemCount() > 1) {
                    return true;
                }
            } else if (i >= 23 && telephonyManager.getPhoneCount() > 1) {
                return true;
            }
            return false;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0073 A[Catch: Exception -> 0x00e6, TryCatch #0 {Exception -> 0x00e6, blocks: (B:5:0x000f, B:7:0x0015, B:11:0x0025, B:15:0x002e, B:17:0x0039, B:19:0x003f, B:21:0x004a, B:23:0x0053, B:25:0x005b, B:31:0x0067, B:37:0x0073, B:42:0x007d, B:43:0x0089, B:44:0x009a, B:45:0x00a1, B:48:0x00a6, B:50:0x00b0, B:56:0x00bc, B:62:0x00c8, B:67:0x00d2, B:68:0x00dd), top: B:75:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c8 A[Catch: Exception -> 0x00e6, TryCatch #0 {Exception -> 0x00e6, blocks: (B:5:0x000f, B:7:0x0015, B:11:0x0025, B:15:0x002e, B:17:0x0039, B:19:0x003f, B:21:0x004a, B:23:0x0053, B:25:0x005b, B:31:0x0067, B:37:0x0073, B:42:0x007d, B:43:0x0089, B:44:0x009a, B:45:0x00a1, B:48:0x00a6, B:50:0x00b0, B:56:0x00bc, B:62:0x00c8, B:67:0x00d2, B:68:0x00dd), top: B:75:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.ipification.mobile.sdk.android.model.SIMOperator getAuthRequestContext() {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipification.mobile.sdk.android.utils.DeviceUtils.getAuthRequestContext():com.ipification.mobile.sdk.android.model.SIMOperator");
    }
}
