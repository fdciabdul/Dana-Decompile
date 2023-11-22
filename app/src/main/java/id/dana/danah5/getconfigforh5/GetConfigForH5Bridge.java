package id.dana.danah5.getconfigforh5;

import android.view.View;
import android.view.ViewConfiguration;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import id.dana.danah5.constant.BridgeName;
import id.dana.data.util.FeatureSwitch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.A;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/danah5/getconfigforh5/GetConfigForH5Bridge;", "Lcom/alibaba/ariver/kernel/api/extension/bridge/SimpleBridgeExtension;", "Lcom/alibaba/fastjson/JSONObject;", "assembleConfig", "()Lcom/alibaba/fastjson/JSONObject;", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "", BridgeName.GET_CONFIG_FOR_H5, "(Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GetConfigForH5Bridge extends SimpleBridgeExtension {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int MyBillsEntityDataFactory = 269894834;
    private static int PlaceComponentResult = 1;

    @ThreadType(ExecutorType.UI)
    @ActionFilter(canOverride = false)
    public final void getConfigForH5(@BindingCallback BridgeCallback bridgeCallback) {
        int i = PlaceComponentResult + 39;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        try {
            if (!(i % 2 != 0)) {
                Intrinsics.checkNotNullParameter(bridgeCallback, "");
                bridgeCallback.sendJSONResponse(assembleConfig());
                return;
            }
            try {
                Intrinsics.checkNotNullParameter(bridgeCallback, "");
                bridgeCallback.sendJSONResponse(assembleConfig());
                int i2 = 64 / 0;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception unused) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = jSONObject;
            jSONObject2.put((JSONObject) "success", (String) Boolean.FALSE);
            jSONObject2.put((JSONObject) "error", "001");
            bridgeCallback.sendJSONResponse(jSONObject);
        }
    }

    private final JSONObject assembleConfig() {
        Object obj;
        int i = BuiltInFictitiousFunctionClassFactory + 93;
        PlaceComponentResult = i % 128;
        if (i % 2 == 0) {
            Object[] objArr = new Object[1];
            a(new char[]{65534, 65530, 65488, 3, 65530, 0, '\r', 16, 15, 65532, 0, 1, 2, 4, 1, '\t', '\n'}, 26674 / (ViewConfiguration.getScrollDefaultDelay() << 93), View.resolveSizeAndState(0, 0, 1) + 117, false, 126 / (ViewConfiguration.getTouchSlop() * 44), objArr);
            obj = objArr[0];
        } else {
            Object[] objArr2 = new Object[1];
            a(new char[]{65534, 65530, 65488, 3, 65530, 0, '\r', 16, 15, 65532, 0, 1, 2, 4, 1, '\t', '\n'}, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 252, View.resolveSizeAndState(0, 0, 0) + 17, true, (ViewConfiguration.getTouchSlop() >> 8) + 12, objArr2);
            obj = objArr2[0];
        }
        return FeatureSwitch.getFeatureSwitchJSONObject(((String) obj).intern());
    }

    private static void a(char[] cArr, int i, int i2, boolean z, int i3, Object[] objArr) {
        A a2 = new A();
        char[] cArr2 = new char[i2];
        a2.MyBillsEntityDataFactory = 0;
        try {
            int i4 = $10 + 23;
            try {
                $11 = i4 % 128;
                while (true) {
                    int i5 = i4 % 2;
                    if ((a2.MyBillsEntityDataFactory < i2 ? '0' : (char) 31) == 31) {
                        break;
                    }
                    a2.KClassImpl$Data$declaredNonStaticMembers$2 = cArr[a2.MyBillsEntityDataFactory];
                    cArr2[a2.MyBillsEntityDataFactory] = (char) (a2.KClassImpl$Data$declaredNonStaticMembers$2 + i);
                    int i6 = a2.MyBillsEntityDataFactory;
                    cArr2[i6] = (char) (cArr2[i6] - ((int) (MyBillsEntityDataFactory ^ (-5694784870793460699L))));
                    a2.MyBillsEntityDataFactory++;
                    i4 = $11 + 115;
                    $10 = i4 % 128;
                }
                if (!(i3 <= 0)) {
                    a2.BuiltInFictitiousFunctionClassFactory = i3;
                    char[] cArr3 = new char[i2];
                    System.arraycopy(cArr2, 0, cArr3, 0, i2);
                    System.arraycopy(cArr3, 0, cArr2, i2 - a2.BuiltInFictitiousFunctionClassFactory, a2.BuiltInFictitiousFunctionClassFactory);
                    System.arraycopy(cArr3, a2.BuiltInFictitiousFunctionClassFactory, cArr2, 0, i2 - a2.BuiltInFictitiousFunctionClassFactory);
                }
                if (!(!z)) {
                    char[] cArr4 = new char[i2];
                    a2.MyBillsEntityDataFactory = 0;
                    while (true) {
                        if (a2.MyBillsEntityDataFactory >= i2) {
                            break;
                        }
                        cArr4[a2.MyBillsEntityDataFactory] = cArr2[(i2 - a2.MyBillsEntityDataFactory) - 1];
                        a2.MyBillsEntityDataFactory++;
                    }
                    cArr2 = cArr4;
                }
                objArr[0] = new String(cArr2);
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
