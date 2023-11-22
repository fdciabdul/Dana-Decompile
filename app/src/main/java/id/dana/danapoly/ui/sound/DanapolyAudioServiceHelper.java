package id.dana.danapoly.ui.sound;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.os.IBinder;
import com.alibaba.griver.base.common.utils.H5ResourceHandlerUtil;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danapoly.ui.sound.DanapolyAudioService;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR(\u0010\u0005\u001a\b\u0018\u00010\u000eR\u00020\u000f8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0005\u0010\u0013R\u0014\u0010\b\u001a\u00020\u00148\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016"}, d2 = {"Lid/dana/danapoly/ui/sound/DanapolyAudioServiceHelper;", "", "Landroid/content/Context;", "p0", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;)F", "", "getAuthRequestContext", "(Landroid/content/Context;)Z", "Landroid/content/Intent;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Intent;", "PlaceComponentResult", "Lid/dana/danapoly/ui/sound/DanapolyAudioService$DanapolyAudioServiceBinder;", "Lid/dana/danapoly/ui/sound/DanapolyAudioService;", "Lid/dana/danapoly/ui/sound/DanapolyAudioService$DanapolyAudioServiceBinder;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/danapoly/ui/sound/DanapolyAudioService$DanapolyAudioServiceBinder;", "(Lid/dana/danapoly/ui/sound/DanapolyAudioService$DanapolyAudioServiceBinder;)V", "Lid/dana/danapoly/ui/sound/DanapolyAudioServiceHelper$connection$1;", "Lid/dana/danapoly/ui/sound/DanapolyAudioServiceHelper$connection$1;", "Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyAudioServiceHelper {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public static Intent PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public static boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private static DanapolyAudioService.DanapolyAudioServiceBinder MyBillsEntityDataFactory;
    public static final DanapolyAudioServiceHelper INSTANCE = new DanapolyAudioServiceHelper();

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public static final DanapolyAudioServiceHelper$connection$1 getAuthRequestContext = new ServiceConnection() { // from class: id.dana.danapoly.ui.sound.DanapolyAudioServiceHelper$connection$1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName p0, IBinder p1) {
            DanapolyAudioServiceHelper danapolyAudioServiceHelper = DanapolyAudioServiceHelper.INSTANCE;
            if (p1 == null) {
                throw new NullPointerException("null cannot be cast to non-null type id.dana.danapoly.ui.sound.DanapolyAudioService.DanapolyAudioServiceBinder");
            }
            DanapolyAudioServiceHelper.MyBillsEntityDataFactory((DanapolyAudioService.DanapolyAudioServiceBinder) p1);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName p0) {
            DanapolyAudioServiceHelper danapolyAudioServiceHelper = DanapolyAudioServiceHelper.INSTANCE;
            DanapolyAudioServiceHelper.MyBillsEntityDataFactory((DanapolyAudioService.DanapolyAudioServiceBinder) null);
        }
    };

    private DanapolyAudioServiceHelper() {
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public static DanapolyAudioService.DanapolyAudioServiceBinder BuiltInFictitiousFunctionClassFactory() {
        return MyBillsEntityDataFactory;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public static void MyBillsEntityDataFactory(DanapolyAudioService.DanapolyAudioServiceBinder danapolyAudioServiceBinder) {
        MyBillsEntityDataFactory = danapolyAudioServiceBinder;
    }

    public static boolean getAuthRequestContext(Context p0) {
        try {
            Object systemService = p0.getSystemService(AkuEventParamsKey.KEY_ACTIVITY);
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
            }
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) systemService).getRunningServices(Integer.MAX_VALUE);
            Intrinsics.checkNotNullExpressionValue(runningServices, "");
            List<ActivityManager.RunningServiceInfo> list = runningServices;
            if ((list instanceof Collection) && list.isEmpty()) {
                return false;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((ActivityManager.RunningServiceInfo) it.next()).service.getClassName(), DanapolyAudioService.class.getName())) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static float MyBillsEntityDataFactory(Context p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Object systemService = p0.getSystemService(H5ResourceHandlerUtil.AUDIO);
        if (systemService != null) {
            return ((AudioManager) systemService).getRingerMode() == 2 ? 1.0f : 0.0f;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
    }
}
