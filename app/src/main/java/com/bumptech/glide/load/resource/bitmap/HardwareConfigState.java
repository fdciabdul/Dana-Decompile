package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class HardwareConfigState {
    private static final File BuiltInFictitiousFunctionClassFactory;
    private static volatile int KClassImpl$Data$declaredNonStaticMembers$2;
    public static final boolean MyBillsEntityDataFactory;
    public static final boolean PlaceComponentResult;
    private static volatile HardwareConfigState getAuthRequestContext;
    private final int DatabaseTableConfigUtil;
    private final int lookAheadTest;
    private int scheduleImpl;
    private boolean moveToNextValue = true;
    private final AtomicBoolean getErrorConfigVersion = new AtomicBoolean(false);
    private final boolean NetworkUserEntityData$$ExternalSyntheticLambda0 = getAuthRequestContext();

    static {
        MyBillsEntityDataFactory = Build.VERSION.SDK_INT < 29;
        PlaceComponentResult = Build.VERSION.SDK_INT >= 26;
        BuiltInFictitiousFunctionClassFactory = new File("/proc/self/fd");
        KClassImpl$Data$declaredNonStaticMembers$2 = -1;
    }

    public static HardwareConfigState PlaceComponentResult() {
        if (getAuthRequestContext == null) {
            synchronized (HardwareConfigState.class) {
                if (getAuthRequestContext == null) {
                    getAuthRequestContext = new HardwareConfigState();
                }
            }
        }
        return getAuthRequestContext;
    }

    HardwareConfigState() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.DatabaseTableConfigUtil = 20000;
            this.lookAheadTest = 0;
            return;
        }
        this.DatabaseTableConfigUtil = 700;
        this.lookAheadTest = 128;
    }

    public final boolean getAuthRequestContext(int i, int i2, boolean z, boolean z2) {
        if (!z) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                InstrumentInjector.log_v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        } else if (!this.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                InstrumentInjector.log_v("HardwareConfig", "Hardware config disallowed by device model");
            }
            return false;
        } else if (!PlaceComponentResult) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                InstrumentInjector.log_v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        } else if (MyBillsEntityDataFactory()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                InstrumentInjector.log_v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        } else if (z2) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                InstrumentInjector.log_v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        } else {
            int i3 = this.lookAheadTest;
            if (i < i3) {
                if (Log.isLoggable("HardwareConfig", 2)) {
                    InstrumentInjector.log_v("HardwareConfig", "Hardware config disallowed because width is too small");
                }
                return false;
            } else if (i2 < i3) {
                if (Log.isLoggable("HardwareConfig", 2)) {
                    InstrumentInjector.log_v("HardwareConfig", "Hardware config disallowed because height is too small");
                }
                return false;
            } else if (BuiltInFictitiousFunctionClassFactory()) {
                return true;
            } else {
                if (Log.isLoggable("HardwareConfig", 2)) {
                    InstrumentInjector.log_v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
                }
                return false;
            }
        }
    }

    private boolean MyBillsEntityDataFactory() {
        return MyBillsEntityDataFactory && !this.getErrorConfigVersion.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean MyBillsEntityDataFactory(int i, int i2, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean authRequestContext = getAuthRequestContext(i, i2, z, z2);
        if (authRequestContext) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return authRequestContext;
    }

    private static boolean getAuthRequestContext() {
        return (KClassImpl$Data$declaredNonStaticMembers$2() || lookAheadTest()) ? false : true;
    }

    private static boolean lookAheadTest() {
        if (Build.VERSION.SDK_INT != 27) {
            return false;
        }
        return Arrays.asList("LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM").contains(Build.MODEL);
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        if (Build.VERSION.SDK_INT != 26) {
            return false;
        }
        Iterator it = Arrays.asList("SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play").iterator();
        while (it.hasNext()) {
            if (Build.MODEL.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean BuiltInFictitiousFunctionClassFactory() {
        boolean z;
        int i;
        synchronized (this) {
            int i2 = this.scheduleImpl + 1;
            this.scheduleImpl = i2;
            if (i2 >= 50) {
                this.scheduleImpl = 0;
                int length = BuiltInFictitiousFunctionClassFactory.list().length;
                if (KClassImpl$Data$declaredNonStaticMembers$2 != -1) {
                    i = KClassImpl$Data$declaredNonStaticMembers$2;
                } else {
                    i = this.DatabaseTableConfigUtil;
                }
                long j = i;
                boolean z2 = ((long) length) < j;
                this.moveToNextValue = z2;
                if (!z2 && Log.isLoggable("Downsampler", 5)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ");
                    sb.append(length);
                    sb.append(", limit ");
                    sb.append(j);
                    InstrumentInjector.log_w("Downsampler", sb.toString());
                }
            }
            z = this.moveToNextValue;
        }
        return z;
    }
}
