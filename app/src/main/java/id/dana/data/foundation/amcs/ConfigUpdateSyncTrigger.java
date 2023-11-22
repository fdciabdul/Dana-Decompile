package id.dana.data.foundation.amcs;

import com.alipay.iap.android.common.syncintegration.api.IAPSyncMessage;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncProvider;
import com.alipay.iap.android.common.syncintegration.impl.IAPSyncMessageParsedCallback;
import com.alipay.iap.android.common.syncintegration.impl.SyncProvider;
import com.alipay.plus.android.config.sdk.delegate.ConfigMonitor;
import com.iap.ac.android.common.json.JsonUtils;
import com.iap.ac.android.loglite.utils.LoggerWrapper;
import com.iap.ac.config.lite.ConfigCenter;
import com.iap.ac.config.lite.ConfigCenterContext;
import com.iap.ac.config.lite.utils.ConfigUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\b\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\f"}, d2 = {"Lid/dana/data/foundation/amcs/ConfigUpdateSyncTrigger;", "", "Lcom/iap/ac/config/lite/ConfigCenterContext;", "p0", "", "PlaceComponentResult", "(Lcom/iap/ac/config/lite/ConfigCenterContext;)V", "", "getAuthRequestContext", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Lcom/alipay/iap/android/common/syncintegration/api/IAPSyncProvider;", "Lcom/alipay/iap/android/common/syncintegration/api/IAPSyncProvider;", "p1", "<init>", "(Lcom/alipay/iap/android/common/syncintegration/api/IAPSyncProvider;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConfigUpdateSyncTrigger {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final IAPSyncProvider getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final String MyBillsEntityDataFactory;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, com.alipay.iap.android.common.syncintegration.api.IAPSyncProvider, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ConfigUpdateSyncTrigger() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.foundation.amcs.ConfigUpdateSyncTrigger.<init>():void");
    }

    private ConfigUpdateSyncTrigger(IAPSyncProvider iAPSyncProvider, String str) {
        Intrinsics.checkNotNullParameter(iAPSyncProvider, "");
        Intrinsics.checkNotNullParameter(str, "");
        this.getAuthRequestContext = iAPSyncProvider;
        this.MyBillsEntityDataFactory = str;
    }

    public /* synthetic */ ConfigUpdateSyncTrigger(SyncProvider syncProvider, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new SyncProvider() : syncProvider, (i & 2) != 0 ? "" : str);
    }

    public final void PlaceComponentResult(final ConfigCenterContext p0) {
        IAPSyncMessageParsedCallback iAPSyncMessageParsedCallback = new IAPSyncMessageParsedCallback() { // from class: id.dana.data.foundation.amcs.ConfigUpdateSyncTrigger$registerSyncReceiver$syncCallback$1
            @Override // com.alipay.iap.android.common.syncintegration.impl.IAPSyncMessageParsedCallback
            public final void onReceiveParsedSyncMessage(IAPSyncMessage p02, String p1, List<String> p2) {
                Intrinsics.checkNotNullParameter(p02, "");
                Intrinsics.checkNotNullParameter(p1, "");
                Intrinsics.checkNotNullParameter(p2, "");
                if (Intrinsics.areEqual(p1, "APLUS-CONFIG") || Intrinsics.areEqual(p1, "APLUS-CONFIG-USER")) {
                    ConfigUpdateSyncTrigger.BuiltInFictitiousFunctionClassFactory(ConfigUpdateSyncTrigger.this, p2);
                    p0.getConfigMonitor().behavior(ConfigMonitor.Events.CONFIG_SYNC_GETDATA, null);
                }
            }
        };
        this.getAuthRequestContext.registerReceiveCallback("APLUS-CONFIG", iAPSyncMessageParsedCallback);
        this.getAuthRequestContext.registerReceiveCallback("APLUS-CONFIG-USER", iAPSyncMessageParsedCallback);
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ConfigUpdateSyncTrigger configUpdateSyncTrigger, List list) {
        long parseLong;
        long lastUpdateVersion = ConfigCenter.getInstance(configUpdateSyncTrigger.MyBillsEntityDataFactory).getLastUpdateVersion();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                parseLong = ConfigUtils.parseLong(((JSONObject) JsonUtils.fromJson(str, JSONObject.class)).getString("update"), 0L);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot parse config sync mess age to JSONObject! ");
                sb.append(th.getMessage());
                LoggerWrapper.w("ConfigUpdateSyncTrigger", sb.toString());
            }
            if (parseLong > lastUpdateVersion) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("Receive sync message: %s! will refresh config now!", Arrays.copyOf(new Object[]{str}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "");
                LoggerWrapper.d("ConfigUpdateSyncTrigger", format);
                ConfigCenter.getInstance(configUpdateSyncTrigger.MyBillsEntityDataFactory).refreshConfig();
                return;
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Receive sync message! But not refresh config!");
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String format2 = String.format("lastUpdateTimestamp = %d, configUpdateTimestamp = %d", Arrays.copyOf(new Object[]{Long.valueOf(lastUpdateVersion), Long.valueOf(parseLong)}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "");
            sb2.append(format2);
            String format3 = String.format(sb2.toString(), Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "");
            LoggerWrapper.d("ConfigUpdateSyncTrigger", format3);
        }
    }
}
