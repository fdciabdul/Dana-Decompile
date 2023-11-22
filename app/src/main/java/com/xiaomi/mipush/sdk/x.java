package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class x {
    private static volatile x KClassImpl$Data$declaredNonStaticMembers$2;
    private List<r> BuiltInFictitiousFunctionClassFactory = new ArrayList();
    private Context getAuthRequestContext;

    private x(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.getAuthRequestContext = applicationContext;
        if (applicationContext == null) {
            this.getAuthRequestContext = context;
        }
    }

    public static x BuiltInFictitiousFunctionClassFactory(Context context) {
        if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            synchronized (x.class) {
                if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    KClassImpl$Data$declaredNonStaticMembers$2 = new x(context);
                }
            }
        }
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final void BuiltInFictitiousFunctionClassFactory(String str) {
        synchronized (this.BuiltInFictitiousFunctionClassFactory) {
            r rVar = new r();
            rVar.MyBillsEntityDataFactory = str;
            if (this.BuiltInFictitiousFunctionClassFactory.contains(rVar)) {
                this.BuiltInFictitiousFunctionClassFactory.remove(rVar);
            }
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        synchronized (this.BuiltInFictitiousFunctionClassFactory) {
            r rVar = new r();
            rVar.MyBillsEntityDataFactory = str;
            if (this.BuiltInFictitiousFunctionClassFactory.contains(rVar)) {
                Iterator<r> it = this.BuiltInFictitiousFunctionClassFactory.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    r next = it.next();
                    if (rVar.equals(next)) {
                        rVar = next;
                        break;
                    }
                }
            }
            rVar.getAuthRequestContext++;
            this.BuiltInFictitiousFunctionClassFactory.remove(rVar);
            this.BuiltInFictitiousFunctionClassFactory.add(rVar);
        }
    }

    public final int MyBillsEntityDataFactory(String str) {
        synchronized (this.BuiltInFictitiousFunctionClassFactory) {
            r rVar = new r();
            rVar.MyBillsEntityDataFactory = str;
            if (this.BuiltInFictitiousFunctionClassFactory.contains(rVar)) {
                for (r rVar2 : this.BuiltInFictitiousFunctionClassFactory) {
                    if (rVar2.equals(rVar)) {
                        return rVar2.getAuthRequestContext;
                    }
                }
            }
            return 0;
        }
    }

    public final String MyBillsEntityDataFactory(am amVar) {
        String string;
        synchronized (this) {
            string = this.getAuthRequestContext.getSharedPreferences("mipush_extra", 0).getString(amVar.name(), "");
        }
        return string;
    }

    public final void PlaceComponentResult(String str) {
        synchronized (this.BuiltInFictitiousFunctionClassFactory) {
            r rVar = new r();
            rVar.getAuthRequestContext = 0;
            rVar.MyBillsEntityDataFactory = str;
            if (this.BuiltInFictitiousFunctionClassFactory.contains(rVar)) {
                this.BuiltInFictitiousFunctionClassFactory.remove(rVar);
            }
            this.BuiltInFictitiousFunctionClassFactory.add(rVar);
        }
    }

    public final void getAuthRequestContext(am amVar, String str) {
        synchronized (this) {
            SharedPreferences sharedPreferences = this.getAuthRequestContext.getSharedPreferences("mipush_extra", 0);
            sharedPreferences.edit().putString(amVar.name(), str).commit();
        }
    }

    public final boolean getAuthRequestContext(String str) {
        synchronized (this.BuiltInFictitiousFunctionClassFactory) {
            r rVar = new r();
            rVar.MyBillsEntityDataFactory = str;
            return this.BuiltInFictitiousFunctionClassFactory.contains(rVar);
        }
    }
}
