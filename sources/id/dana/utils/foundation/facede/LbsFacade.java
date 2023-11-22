package id.dana.utils.foundation.facede;

import android.content.Context;
import android.graphics.ImageFormat;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.ViewConfiguration;
import com.alipay.iap.android.lbs.LBSLocation;
import com.alipay.iap.android.lbs.LBSLocationManagerProxy;
import com.alipay.iap.android.lbs.LBSLocationRequest;
import com.iap.ac.config.lite.ConfigCenter;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class LbsFacade {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static final long KClassImpl$Data$declaredNonStaticMembers$2;
    private static int MyBillsEntityDataFactory = 0;
    private static short[] NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    private static byte[] PlaceComponentResult = null;
    private static int getAuthRequestContext = 0;
    private static int getErrorConfigVersion = 1;
    private static int scheduleImpl;

    static void PlaceComponentResult() {
        getAuthRequestContext = 1257195733;
        MyBillsEntityDataFactory = -1100207246;
        PlaceComponentResult = new byte[]{89, -97, -114, -99, -121, -97, -125, -102, -105, -113, -110, -106, -112, 104, -125, -98};
        BuiltInFictitiousFunctionClassFactory = -510928719;
    }

    static {
        PlaceComponentResult();
        KClassImpl$Data$declaredNonStaticMembers$2 = TimeUnit.MINUTES.toMillis(15L);
        try {
            int i = getErrorConfigVersion + 17;
            try {
                scheduleImpl = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private LbsFacade() {
    }

    public static LBSLocation getAuthRequestContext(Context context) {
        ConfigCenter configCenter = ConfigCenter.getInstance();
        long j = KClassImpl$Data$declaredNonStaticMembers$2;
        Object[] objArr = new Object[1];
        a(TextUtils.lastIndexOf("", '0', 0) + 1419472851, (ViewConfiguration.getLongPressTimeout() >> 16) - 75, (short) ((ViewConfiguration.getKeyRepeatDelay() >> 16) - 11), 192715902 - ImageFormat.getBitsPerPixel(0), (byte) Gravity.getAbsoluteGravity(0, 0), objArr);
        long longConfig = configCenter.getLongConfig(((String) objArr[0]).intern(), j);
        LBSLocationRequest lBSLocationRequest = new LBSLocationRequest();
        lBSLocationRequest.cacheValidTime = longConfig;
        LBSLocation KClassImpl$Data$declaredNonStaticMembers$22 = KClassImpl$Data$declaredNonStaticMembers$2(context, lBSLocationRequest);
        int i = scheduleImpl + 71;
        getErrorConfigVersion = i % 128;
        int i2 = i % 2;
        return KClassImpl$Data$declaredNonStaticMembers$22;
    }

    private static LBSLocation KClassImpl$Data$declaredNonStaticMembers$2(Context context, LBSLocationRequest lBSLocationRequest) {
        StringBuilder sb = new StringBuilder();
        sb.append("getLatestLocation  request:  [cacheValidTime: ");
        sb.append(lBSLocationRequest.cacheValidTime);
        sb.append("\t isHighAccuracy: ");
        sb.append(lBSLocationRequest.isHighAccuracy);
        sb.append("\t timeOut: ");
        sb.append(lBSLocationRequest.timeOut);
        sb.append(" \t updateInterval:");
        sb.append(lBSLocationRequest.updateInterval);
        sb.append("\t minDistance:");
        sb.append(lBSLocationRequest.minDistance);
        sb.append("]");
        DanaLog.MyBillsEntityDataFactory("LbsFacade", sb.toString());
        LBSLocation lastKnownLocation = LBSLocationManagerProxy.getInstance().getLastKnownLocation(context, lBSLocationRequest);
        int i = getErrorConfigVersion + 1;
        scheduleImpl = i % 128;
        if ((i % 2 != 0 ? 'R' : '^') != 'R') {
            return lastKnownLocation;
        }
        Object obj = null;
        obj.hashCode();
        return lastKnownLocation;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r13, int r14, short r15, int r16, byte r17, java.lang.Object[] r18) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.utils.foundation.facede.LbsFacade.a(int, int, short, int, byte, java.lang.Object[]):void");
    }
}
