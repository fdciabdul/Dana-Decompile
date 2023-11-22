package id.dana.data.miniprogram.provider;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alipay.iap.android.wallet.acl.base.APIContext;
import com.alipay.iap.android.wallet.acl.base.BaseResult;
import com.alipay.iap.android.wallet.acl.base.Callback;
import com.alipay.iap.android.wallet.acl.base.ResultError;
import com.alipay.iap.android.wallet.foundation.deeplink.DeeplinkService;
import id.dana.data.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;
import org.greenrobot.eventbus.EventBus;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJC\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\t2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u0007\u0010\u0010J)\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J9\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/data/miniprogram/provider/DeeplinkServiceProvider;", "Lcom/alipay/iap/android/wallet/foundation/deeplink/DeeplinkService;", "Landroid/net/Uri;", "p0", "Lcom/alipay/iap/android/wallet/acl/base/APIContext;", "p1", "", "open", "(Landroid/net/Uri;Lcom/alipay/iap/android/wallet/acl/base/APIContext;)Z", "", "", "p2", "Lcom/alipay/iap/android/wallet/acl/base/Callback;", "Lcom/alipay/iap/android/wallet/acl/base/BaseResult;", "p3", "", "(Ljava/lang/String;Ljava/util/Map;Lcom/alipay/iap/android/wallet/acl/base/APIContext;Lcom/alipay/iap/android/wallet/acl/base/Callback;)V", "PlaceComponentResult", "(Ljava/lang/String;Lcom/alipay/iap/android/wallet/acl/base/Callback;)Z", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;Lcom/alipay/iap/android/wallet/acl/base/Callback;Ljava/lang/String;)V", "<init>", "()V", "MessageEvent", "OpenDeeplinkMessageEvent"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DeeplinkServiceProvider implements DeeplinkService {
    @Override // com.alipay.iap.android.wallet.foundation.deeplink.DeeplinkService
    public final boolean open(Uri p0, APIContext p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (Intrinsics.areEqual(p0.getHost(), BuildConfig.DEEPLINK_URL)) {
            EventBus.getDefault().post(new MessageEvent(DeeplinkService.Scene.WEB_PAGE, p0.toString(), p1 != null ? p1.getSource() : null));
            return true;
        }
        return PlaceComponentResult(p0.toString(), null);
    }

    @Override // com.alipay.iap.android.wallet.foundation.deeplink.DeeplinkService
    public final void open(String p0, Map<String, String> p1, APIContext p2, Callback<BaseResult> p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p3, "");
        switch (p0.hashCode()) {
            case -1854658139:
                if (p0.equals(DeeplinkService.Scene.SCHEME)) {
                    PlaceComponentResult(p1.get("scheme"), p3);
                    return;
                }
                break;
            case -1814683163:
                if (p0.equals(DeeplinkService.Scene.TOP_UP)) {
                    MyBillsEntityDataFactory(p0, "https://m.dana.id/m/portal/topup", p3, null);
                    return;
                }
                break;
            case 93594810:
                if (p0.equals(DeeplinkService.Scene.WEB_PAGE)) {
                    MyBillsEntityDataFactory(p0, p1.get("url"), p3, p2 != null ? p2.getSource() : null);
                    return;
                }
                break;
            case 1885613522:
                if (p0.equals(DeeplinkService.Scene.BIND_CARD)) {
                    MyBillsEntityDataFactory(p0, "https://m.dana.id/m/portal/bankcardadd?isClosable=true", p3, null);
                    return;
                }
                break;
        }
        EventBus.getDefault().post(new MessageEvent(p0, null, null, 6, null));
        p3.result(new BaseResult());
    }

    private static boolean PlaceComponentResult(String p0, Callback<BaseResult> p1) {
        Application applicationContext = GriverEnv.getApplicationContext();
        try {
            Uri parse = Uri.parse(p0);
            if (Intrinsics.areEqual(parse.getAuthority(), BuildConfig.DEEPLINK_URL)) {
                EventBus eventBus = EventBus.getDefault();
                Intrinsics.checkNotNull(p0);
                eventBus.post(new OpenDeeplinkMessageEvent(p0));
            } else {
                Intent addFlags = new Intent("android.intent.action.VIEW", parse).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                Intrinsics.checkNotNullExpressionValue(addFlags, "");
                applicationContext.startActivity(addFlags);
            }
            if (p1 != null) {
                p1.result(new BaseResult());
            }
            return true;
        } catch (Exception unused) {
            if (p1 != null) {
                BaseResult baseResult = new BaseResult();
                baseResult.setResultError(new ResultError(1000, "Missing Intent handler"));
                p1.result(baseResult);
            }
            return false;
        }
    }

    private static void MyBillsEntityDataFactory(String p0, String p1, Callback<BaseResult> p2, String p3) {
        if (p1 != null) {
            EventBus.getDefault().post(new MessageEvent(p0, p1, p3));
            p2.result(new BaseResult());
            return;
        }
        BaseResult baseResult = new BaseResult();
        baseResult.setResultError(new ResultError(1000, "Missing URL"));
        p2.result(baseResult);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/miniprogram/provider/DeeplinkServiceProvider$OpenDeeplinkMessageEvent;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "p0", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class OpenDeeplinkMessageEvent {
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        public OpenDeeplinkMessageEvent(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0011\u0010\b\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004"}, d2 = {"Lid/dana/data/miniprogram/provider/DeeplinkServiceProvider$MessageEvent;", "", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "p0", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class MessageEvent {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final String MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final String PlaceComponentResult;

        public MessageEvent(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            this.getAuthRequestContext = str;
            this.MyBillsEntityDataFactory = str2;
            this.PlaceComponentResult = str3;
        }

        public /* synthetic */ MessageEvent(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }
    }
}
