package id.dana.miniprogram.provider;

import android.content.Context;
import android.content.Intent;
import com.iap.ac.android.gol.AlipayPlusClientAutoDebit;
import com.iap.ac.android.gol.callback.Callback;
import com.iap.ac.android.gol.google.model.TopUpParams;
import com.iap.ac.android.gol.google.model.TopUpResult;
import com.iap.ac.android.gol.google.service.TopUpService;
import id.dana.BuildConfig;
import id.dana.globalnetwork.GnTopUpSaveDataManager;
import id.dana.globalnetwork.model.GnTopUpResultModel;
import id.dana.onboarding.splash.LocalConfigSplashActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/miniprogram/provider/TopUpServiceProvider;", "Lcom/iap/ac/android/gol/google/service/TopUpService;", "Lid/dana/globalnetwork/model/GnTopUpResultModel;", "p0", "", "PlaceComponentResult", "(Lid/dana/globalnetwork/model/GnTopUpResultModel;)V", "Lcom/iap/ac/android/gol/google/model/TopUpParams;", "Lcom/iap/ac/android/gol/callback/Callback;", "Lcom/iap/ac/android/gol/google/model/TopUpResult;", "p1", "topUp", "(Lcom/iap/ac/android/gol/google/model/TopUpParams;Lcom/iap/ac/android/gol/callback/Callback;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/iap/ac/android/gol/callback/Callback;", "getAuthRequestContext", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TopUpServiceProvider implements TopUpService {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Context PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Callback<TopUpResult> getAuthRequestContext;

    @Override // com.iap.ac.android.gol.google.service.TopUpService
    public final void topUp(TopUpParams p0, Callback<TopUpResult> p1) {
        this.getAuthRequestContext = p1;
        GnTopUpSaveDataManager.INSTANCE.PlaceComponentResult().getAuthRequestContext = Boolean.TRUE;
        Context context = PlaceComponentResult;
        if (context != null) {
            Intent intent = new Intent(context, LocalConfigSplashActivity.class);
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
        }
    }

    public final void PlaceComponentResult(GnTopUpResultModel p0) {
        if (p0 != null) {
            if (p0.getBuiltInFictitiousFunctionClassFactory()) {
                Callback<TopUpResult> callback = this.getAuthRequestContext;
                if (callback != null) {
                    callback.onSuccess(new TopUpResult());
                    return;
                }
                return;
            }
            Callback<TopUpResult> callback2 = this.getAuthRequestContext;
            if (callback2 != null) {
                callback2.onFailure(p0.KClassImpl$Data$declaredNonStaticMembers$2, p0.MyBillsEntityDataFactory);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/miniprogram/provider/TopUpServiceProvider$Companion;", "", "Landroid/content/Context;", "p0", "Lid/dana/miniprogram/provider/TopUpServiceProvider;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;)Lid/dana/miniprogram/provider/TopUpServiceProvider;", "PlaceComponentResult", "Landroid/content/Context;", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static TopUpServiceProvider KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
            TopUpServiceProvider.PlaceComponentResult = p0;
            if (((TopUpServiceProvider) AlipayPlusClientAutoDebit.getInstance().getTopUpService()) == null) {
                if (!Intrinsics.areEqual("production", "production")) {
                    AlipayPlusClientAutoDebit.getInstance().setEnvType("DEV");
                }
                AlipayPlusClientAutoDebit.getInstance().setClientId(BuildConfig.CLIENT_ID_FOR_ALIPAY_KEY);
                AlipayPlusClientAutoDebit.getInstance().setTopUpService(new TopUpServiceProvider());
            }
            TopUpService topUpService = AlipayPlusClientAutoDebit.getInstance().getTopUpService();
            if (topUpService != null) {
                return (TopUpServiceProvider) topUpService;
            }
            throw new NullPointerException("null cannot be cast to non-null type id.dana.miniprogram.provider.TopUpServiceProvider");
        }
    }
}
