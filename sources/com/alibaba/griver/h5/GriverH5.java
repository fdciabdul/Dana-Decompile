package com.alibaba.griver.h5;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import androidx.fragment.app.Fragment;
import com.alibaba.ariver.integration.RVMain;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigProxy;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.core.GriverCreateFragmentCallBack;
import com.alibaba.griver.core.ui.fragment.GriverBaseFragment;
import com.alibaba.griver.h5.app.GriverH5AppInstallManager;
import com.alibaba.griver.h5.app.GriverH5AppOpenManager;
import o.D;

/* loaded from: classes3.dex */
public class GriverH5 {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static long KClassImpl$Data$declaredNonStaticMembers$2 = 2753226336834177682L;
    private static int getAuthRequestContext = 1;

    public static void openUrl(Context context, String str, Bundle bundle) {
        int i = BuiltInFictitiousFunctionClassFactory + 49;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        GriverH5AppOpenManager.openUrl(context, str, bundle);
        int i3 = getAuthRequestContext + 117;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 3 : ']') != ']') {
            int i4 = 7 / 0;
        }
    }

    public static void createFragment(Context context, String str, Bundle bundle, final GriverCreateFragmentCallBack griverCreateFragmentCallBack) {
        GriverH5AppOpenManager.createFragment(context, str, bundle, new RVMain.Callback() { // from class: com.alibaba.griver.h5.GriverH5.1
            @Override // com.alibaba.ariver.integration.RVMain.Callback
            public final void onFragmentCreate(Fragment fragment) {
                GriverCreateFragmentCallBack griverCreateFragmentCallBack2 = GriverCreateFragmentCallBack.this;
                if (griverCreateFragmentCallBack2 != null) {
                    griverCreateFragmentCallBack2.onFragmentCreate((GriverBaseFragment) fragment);
                }
            }
        });
        try {
            int i = getAuthRequestContext + 83;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static void preInstallH5Auto() {
        int i = BuiltInFictitiousFunctionClassFactory + 61;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        if ((!ProcessUtils.isMainProcess() ? 'a' : '\r') != '\r') {
            GriverLogger.w("GriverH5", "do not save cloud configuration in non-main process");
            return;
        }
        Object[] objArr = new Object[1];
        a(Color.red(0), new char[]{23055, 23164, 20081, 18787, 24138, 6787, 18306, 20703, 27511, 31827, 14504, 3231, 25020, 3408, 6778, 24262, 978, 12080}, objArr);
        GriverH5AppInstallManager.installCommons(GriverConfig.getConfig(((String) objArr[0]).intern(), "[]", new GriverConfigProxy.OnConfigChangeListener() { // from class: com.alibaba.griver.h5.GriverH5.2
            @Override // com.alibaba.griver.api.common.config.GriverConfigProxy.OnConfigChangeListener
            public final void onChange(String str) {
                GriverH5AppInstallManager.installCommons(str);
            }
        }));
        Object[] objArr2 = new Object[1];
        a((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), new char[]{23337, 23368, 35847, 35597, 40298, 32303, 37870, 26674}, objArr2);
        GriverH5AppInstallManager.install(GriverConfig.getSectionConfigWithListener(((String) objArr2[0]).intern(), new GriverConfigProxy.OnSectionConfigChangeListener() { // from class: com.alibaba.griver.h5.GriverH5.3
            @Override // com.alibaba.griver.api.common.config.GriverConfigProxy.OnSectionConfigChangeListener
            public final void onChange(JSONObject jSONObject) {
                GriverH5AppInstallManager.install(jSONObject);
            }
        }));
        int i3 = BuiltInFictitiousFunctionClassFactory + 121;
        getAuthRequestContext = i3 % 128;
        if (i3 % 2 == 0) {
            Object[] objArr3 = null;
            int length = objArr3.length;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$22 = D.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2 ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (true) {
            if (d.MyBillsEntityDataFactory < KClassImpl$Data$declaredNonStaticMembers$22.length) {
                try {
                    int i2 = $11 + 5;
                    $10 = i2 % 128;
                    int i3 = i2 % 2;
                    d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                    KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$22[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3919452569568103912L)));
                    d.MyBillsEntityDataFactory++;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                String str = new String(KClassImpl$Data$declaredNonStaticMembers$22, 4, KClassImpl$Data$declaredNonStaticMembers$22.length - 4);
                int i4 = $11 + 19;
                $10 = i4 % 128;
                int i5 = i4 % 2;
                objArr[0] = str;
                return;
            }
        }
    }
}
