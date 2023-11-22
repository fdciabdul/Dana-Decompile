package id.dana.lib.gcontainer.util;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.ut.device.UTDevice;
import id.dana.lib.logger.DANALog;
import id.dana.oauth.OauthConstant;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/lib/gcontainer/util/DeviceUtil;", "", "Landroid/content/Context;", HummerConstants.CONTEXT, "", "getUtdId", "(Landroid/content/Context;)Ljava/lang/String;", "getUtdidAdvertisingId", "", "isEmulator", "(Landroid/content/Context;)Z", "isRooted", "TAG", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class DeviceUtil {
    public static final DeviceUtil INSTANCE = new DeviceUtil();
    public static final String TAG = "DeviceUtil";

    private DeviceUtil() {
    }

    @JvmStatic
    public static final boolean isEmulator(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        return Intrinsics.areEqual(OauthConstant.OauthType.SDK_TYPE, Build.PRODUCT) || Intrinsics.areEqual("google_sdk", Build.PRODUCT) || Settings.Secure.getString(context.getContentResolver(), "android_id") == null;
    }

    @JvmStatic
    public static final boolean isRooted(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        boolean isEmulator = isEmulator(context);
        String str = Build.TAGS;
        return !(isEmulator || str == null || !StringsKt.contains$default((CharSequence) str, (CharSequence) "test-keys", false, 2, (Object) null)) || new File("/system/app/Superuser.apk").exists() || (!isEmulator && new File("/system/xbin/su").exists());
    }

    @JvmStatic
    public static final String getUtdidAdvertisingId(final Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        Single MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory(new SingleOnSubscribe() { // from class: id.dana.lib.gcontainer.util.DeviceUtil$$ExternalSyntheticLambda0
            @Override // io.reactivex.SingleOnSubscribe
            public final void subscribe(SingleEmitter singleEmitter) {
                DeviceUtil.m2657getUtdidAdvertisingId$lambda0(context, singleEmitter);
            }
        });
        Scheduler authRequestContext = Schedulers.getAuthRequestContext();
        ObjectHelper.PlaceComponentResult(authRequestContext, "scheduler is null");
        Single BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleObserveOn(MyBillsEntityDataFactory, authRequestContext));
        Scheduler MyBillsEntityDataFactory2 = Schedulers.MyBillsEntityDataFactory();
        ObjectHelper.PlaceComponentResult(MyBillsEntityDataFactory2, "scheduler is null");
        Object r_ = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleSubscribeOn(BuiltInFictitiousFunctionClassFactory, MyBillsEntityDataFactory2)).r_();
        Intrinsics.checkNotNullExpressionValue(r_, "");
        return (String) r_;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getUtdidAdvertisingId$lambda-0  reason: not valid java name */
    public static final void m2657getUtdidAdvertisingId$lambda0(Context context, SingleEmitter singleEmitter) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(singleEmitter, "");
        try {
            singleEmitter.onSuccess(Intrinsics.stringPlus(INSTANCE.getUtdId(context), AdvertisingIdClient.getAdvertisingIdInfo(context).getId()));
        } catch (Exception e) {
            singleEmitter.onSuccess("");
            DANALog.PlaceComponentResult(TAG, "getAdIdInfo", e);
        }
    }

    private final String getUtdId(Context context) {
        String utdid = UTDevice.getUtdid(context);
        return utdid == null ? "" : utdid;
    }
}
