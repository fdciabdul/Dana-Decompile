package com.alibaba.griver.core.utils;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.SystemClock;
import android.widget.ExpandableListView;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.InputStream;
import java.lang.reflect.Method;
import kotlin.text.Typography;
import o.NetworkUserEntityData$$ExternalSyntheticLambda7;

/* loaded from: classes6.dex */
public class GIOUtils {
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 1;

    public static InputStream readAssetForInputStream(Resources resources, String str) {
        int i = MyBillsEntityDataFactory + 69;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        InputStream inputStream = null;
        try {
            try {
                Object[] objArr = {resources.getAssets(), str};
                Object obj = NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
                if (obj == null) {
                    obj = ((Class) NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (58132 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), Color.alpha(0), 50 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)))).getMethod("getAuthRequestContext", AssetManager.class, String.class);
                    NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, obj);
                }
                InputStream inputStream2 = (InputStream) ((Method) obj).invoke(null, objArr);
                try {
                    int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
                    MyBillsEntityDataFactory = i3 % 128;
                    int i4 = i3 % 2;
                    inputStream = inputStream2;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (Throwable unused) {
            RVLogger.e("not found resource");
        }
        int i5 = MyBillsEntityDataFactory + 67;
        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
        if ((i5 % 2 != 0 ? Typography.quote : ',') != ',') {
            int i6 = 86 / 0;
            return inputStream;
        }
        return inputStream;
    }
}
