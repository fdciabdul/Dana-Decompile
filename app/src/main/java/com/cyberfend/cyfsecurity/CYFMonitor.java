package com.cyberfend.cyfsecurity;

import android.app.Activity;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import com.akamai.botman.ah;
import com.akamai.botman.d;
import com.akamai.botman.e;
import com.akamai.botman.f;
import com.akamai.botman.h;
import com.akamai.botman.p;
import com.akamai.botman.q;
import com.akamai.botman.s;
import com.akamai.botman.t;
import com.akamai.botman.u;
import com.akamai.botman.v;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.ArrayList;

@Deprecated
/* loaded from: classes.dex */
public class CYFMonitor {
    private static h BuiltInFictitiousFunctionClassFactory;
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private static boolean MyBillsEntityDataFactory;
    private static boolean PlaceComponentResult;
    private static boolean getAuthRequestContext;

    static {
        InstrumentInjector.log_i("CYFMonitor", "Initializing Akamai BMP SDK Version 3.3.0");
        final SensorDataBuilder MyBillsEntityDataFactory2 = SensorDataBuilder.MyBillsEntityDataFactory();
        new Thread(new Runnable() { // from class: com.cyberfend.cyfsecurity.SensorDataBuilder.1
            @Override // java.lang.Runnable
            public final void run() {
                MyBillsEntityDataFactory2.initializeKeyN();
            }
        }).start();
        BuiltInFictitiousFunctionClassFactory = new h();
        KClassImpl$Data$declaredNonStaticMembers$2 = false;
        getAuthRequestContext = false;
        MyBillsEntityDataFactory = false;
        PlaceComponentResult = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:280:0x0336 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void KClassImpl$Data$declaredNonStaticMembers$2(android.app.Application r37, java.lang.String r38) {
        /*
            Method dump skipped, instructions count: 975
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberfend.cyfsecurity.CYFMonitor.KClassImpl$Data$declaredNonStaticMembers$2(android.app.Application, java.lang.String):void");
    }

    public static String PlaceComponentResult() {
        String PlaceComponentResult2;
        synchronized (CYFMonitor.class) {
            PlaceComponentResult2 = BuiltInFictitiousFunctionClassFactory.PlaceComponentResult();
        }
        return PlaceComponentResult2;
    }

    public static void PlaceComponentResult(boolean z) {
        PlaceComponentResult = z;
    }

    public static boolean BuiltInFictitiousFunctionClassFactory() {
        return PlaceComponentResult;
    }

    public static void getAuthRequestContext(Activity activity) {
        try {
            ah.PlaceComponentResult("CYFMonitor", "Start collecting sensor data", new Throwable[0]);
            if (d.PlaceComponentResult == 0) {
                d.PlaceComponentResult = SystemClock.uptimeMillis();
            }
            if (d.KClassImpl$Data$declaredNonStaticMembers$2 == 0) {
                d.KClassImpl$Data$declaredNonStaticMembers$2 = System.currentTimeMillis();
            }
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory();
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
            if (h.KClassImpl$Data$declaredNonStaticMembers$2(activity.getWindow())) {
                return;
            }
            h hVar = BuiltInFictitiousFunctionClassFactory;
            Window window = activity.getWindow();
            try {
                if (hVar.PlaceComponentResult == null) {
                    hVar.PlaceComponentResult = new v();
                }
                v vVar = hVar.PlaceComponentResult;
                ah.PlaceComponentResult("TouchManager", "Listening on window", new Throwable[0]);
                vVar.KClassImpl$Data$declaredNonStaticMembers$2 = SystemClock.uptimeMillis();
                vVar.MyBillsEntityDataFactory = 0;
                vVar.PlaceComponentResult = 0;
                u uVar = new u(window.getCallback());
                window.setCallback(uVar);
                InstrumentInjector.trackWindow(window);
                uVar.addObserver(vVar);
            } catch (Exception e) {
                ah.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(6, "Exception in creating touch manager", e);
                f.KClassImpl$Data$declaredNonStaticMembers$2(e);
            }
            h hVar2 = BuiltInFictitiousFunctionClassFactory;
            try {
                ArrayList<View> PlaceComponentResult2 = p.PlaceComponentResult((ViewGroup) activity.findViewById(16908290));
                for (int i = 0; i < PlaceComponentResult2.size(); i++) {
                    View view = PlaceComponentResult2.get(i);
                    if (view instanceof EditText) {
                        if (!hVar2.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                            hVar2.BuiltInFictitiousFunctionClassFactory = new t();
                            hVar2.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                        }
                        t tVar = hVar2.BuiltInFictitiousFunctionClassFactory;
                        EditText editText = (EditText) view;
                        StringBuilder sb = new StringBuilder("Listening on edit text: ");
                        sb.append(editText.getId());
                        ah.PlaceComponentResult("TextChangeManager", sb.toString(), new Throwable[0]);
                        int BuiltInFictitiousFunctionClassFactory2 = q.BuiltInFictitiousFunctionClassFactory(String.valueOf(editText.getId()));
                        if (!e.PlaceComponentResult.toLowerCase().contains(Integer.toString(BuiltInFictitiousFunctionClassFactory2).toLowerCase())) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(e.PlaceComponentResult);
                            sb2.append(BuiltInFictitiousFunctionClassFactory2);
                            sb2.append(";");
                            e.PlaceComponentResult = sb2.toString();
                        }
                        if ((editText.getInputType() & 129) != 129 && (editText.getInputType() & 18) != 18 && (editText.getInputType() & 145) != 145 && (editText.getInputType() & 225) != 225) {
                            s sVar = new s(BuiltInFictitiousFunctionClassFactory2, false);
                            editText.addTextChangedListener(sVar);
                            sVar.addObserver(tVar.BuiltInFictitiousFunctionClassFactory);
                        }
                        s sVar2 = new s(BuiltInFictitiousFunctionClassFactory2, true);
                        editText.addTextChangedListener(sVar2);
                        sVar2.addObserver(tVar.BuiltInFictitiousFunctionClassFactory);
                    }
                }
            } catch (Exception e2) {
                ah.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(6, "Exception in creating text listener", e2);
                f.KClassImpl$Data$declaredNonStaticMembers$2(e2);
            }
        } catch (Exception e3) {
            new Throwable[1][0] = e3;
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            ah.PlaceComponentResult("CYFMonitor", "Stop collecting sensor data", new Throwable[0]);
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        } catch (Exception e) {
            new Throwable[1][0] = e;
        }
    }
}
