package id.dana.lib.gcontainer.app.bridge.sendevent.sendmoney;

import com.alibaba.fastjson.JSONObject;
import id.dana.lib.logger.DANALog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0006*\u00020\n0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/sendevent/sendmoney/CheckoutFinishEventManager;", "", "Lcom/alibaba/fastjson/JSONObject;", "info", "Lid/dana/lib/gcontainer/app/bridge/sendevent/sendmoney/CheckoutFinishEntity;", "parseCheckoutFinishResult", "(Lcom/alibaba/fastjson/JSONObject;)Lid/dana/lib/gcontainer/app/bridge/sendevent/sendmoney/CheckoutFinishEntity;", "", "processEvent", "(Lcom/alibaba/fastjson/JSONObject;)V", "", "TAG", "Ljava/lang/String;", "Lid/dana/lib/gcontainer/app/bridge/sendevent/sendmoney/CheckoutFinishCallback;", "checkoutFinishCallback", "Lid/dana/lib/gcontainer/app/bridge/sendevent/sendmoney/CheckoutFinishCallback;", "getCheckoutFinishCallback", "()Lid/dana/lib/gcontainer/app/bridge/sendevent/sendmoney/CheckoutFinishCallback;", "setCheckoutFinishCallback", "(Lid/dana/lib/gcontainer/app/bridge/sendevent/sendmoney/CheckoutFinishCallback;)V", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckoutFinishEventManager {
    public static final CheckoutFinishEventManager INSTANCE = new CheckoutFinishEventManager();
    private static final String TAG = "CheckoutFinishEventManager";
    private static CheckoutFinishCallback checkoutFinishCallback;

    private CheckoutFinishEventManager() {
    }

    @JvmName(name = "getCheckoutFinishCallback")
    public final CheckoutFinishCallback getCheckoutFinishCallback() {
        return checkoutFinishCallback;
    }

    @JvmName(name = "setCheckoutFinishCallback")
    public final void setCheckoutFinishCallback(CheckoutFinishCallback checkoutFinishCallback2) {
        checkoutFinishCallback = checkoutFinishCallback2;
    }

    public final void processEvent(JSONObject info) {
        Intrinsics.checkNotNullParameter(info, "");
        CheckoutFinishEntity parseCheckoutFinishResult = parseCheckoutFinishResult(info);
        String str = TAG;
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(parseCheckoutFinishResult != null);
        String format = String.format("Checkout finish entity exists: %s", Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "");
        DANALog.KClassImpl$Data$declaredNonStaticMembers$2(str, format);
        CheckoutFinishCallback checkoutFinishCallback2 = checkoutFinishCallback;
        if (checkoutFinishCallback2 != null) {
            checkoutFinishCallback2.onCheckoutFinished(parseCheckoutFinishResult);
        }
        checkoutFinishCallback = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0017 A[Catch: Exception -> 0x0032, TRY_LEAVE, TryCatch #0 {Exception -> 0x0032, blocks: (B:3:0x0001, B:5:0x000b, B:11:0x0017), top: B:15:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final id.dana.lib.gcontainer.app.bridge.sendevent.sendmoney.CheckoutFinishEntity parseCheckoutFinishResult(com.alibaba.fastjson.JSONObject r5) {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r5 = r5.toJSONString()     // Catch: java.lang.Exception -> L32
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch: java.lang.Exception -> L32
            r2 = 0
            if (r1 == 0) goto L14
            int r1 = r1.length()     // Catch: java.lang.Exception -> L32
            if (r1 != 0) goto L12
            goto L14
        L12:
            r1 = 0
            goto L15
        L14:
            r1 = 1
        L15:
            if (r1 != 0) goto L32
            java.lang.String r1 = id.dana.lib.gcontainer.app.bridge.sendevent.sendmoney.CheckoutFinishEventManager.TAG     // Catch: java.lang.Exception -> L32
            java.lang.String r3 = "Checkout finish : "
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r3, r5)     // Catch: java.lang.Exception -> L32
            id.dana.lib.logger.DANALog.KClassImpl$Data$declaredNonStaticMembers$2(r1, r3)     // Catch: java.lang.Exception -> L32
            id.dana.lib.gcontainer.app.bridge.sendevent.sendmoney.CheckoutFinishEventManager$parseCheckoutFinishResult$1 r1 = new id.dana.lib.gcontainer.app.bridge.sendevent.sendmoney.CheckoutFinishEventManager$parseCheckoutFinishResult$1     // Catch: java.lang.Exception -> L32
            r1.<init>()     // Catch: java.lang.Exception -> L32
            com.alibaba.fastjson.TypeReference r1 = (com.alibaba.fastjson.TypeReference) r1     // Catch: java.lang.Exception -> L32
            com.alibaba.fastjson.parser.Feature[] r2 = new com.alibaba.fastjson.parser.Feature[r2]     // Catch: java.lang.Exception -> L32
            java.lang.Object r5 = com.alibaba.fastjson.JSON.parseObject(r5, r1, r2)     // Catch: java.lang.Exception -> L32
            id.dana.lib.gcontainer.app.bridge.sendevent.sendmoney.CheckoutFinishEntity r5 = (id.dana.lib.gcontainer.app.bridge.sendevent.sendmoney.CheckoutFinishEntity) r5     // Catch: java.lang.Exception -> L32
            r0 = r5
        L32:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.lib.gcontainer.app.bridge.sendevent.sendmoney.CheckoutFinishEventManager.parseCheckoutFinishResult(com.alibaba.fastjson.JSONObject):id.dana.lib.gcontainer.app.bridge.sendevent.sendmoney.CheckoutFinishEntity");
    }
}
