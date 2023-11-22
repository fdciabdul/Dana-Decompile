package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.xiaomi.push.dc;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class at {
    private static volatile at getAuthRequestContext;
    public HashSet<a> BuiltInFictitiousFunctionClassFactory = new HashSet<>();
    protected SharedPreferences MyBillsEntityDataFactory;
    protected SharedPreferences PlaceComponentResult;

    /* loaded from: classes8.dex */
    public static abstract class a implements Runnable {
        private int getAuthRequestContext;

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.getAuthRequestContext == ((a) obj).getAuthRequestContext;
        }

        protected abstract void getAuthRequestContext();

        public int hashCode() {
            return this.getAuthRequestContext;
        }

        @Override // java.lang.Runnable
        public final void run() {
            getAuthRequestContext();
        }
    }

    private at(Context context) {
        this.PlaceComponentResult = context.getSharedPreferences("mipush_oc_normal", 0);
        this.MyBillsEntityDataFactory = context.getSharedPreferences("mipush_oc_custom", 0);
    }

    public static at MyBillsEntityDataFactory(Context context) {
        if (getAuthRequestContext == null) {
            synchronized (at.class) {
                if (getAuthRequestContext == null) {
                    getAuthRequestContext = new at(context);
                }
            }
        }
        return getAuthRequestContext;
    }

    private static void MyBillsEntityDataFactory(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        if (pair.second instanceof Integer) {
            editor.putInt(str, ((Integer) pair.second).intValue());
        } else if (pair.second instanceof Long) {
            editor.putLong(str, ((Long) pair.second).longValue());
        } else if (pair.second instanceof String) {
            editor.putString(str, (String) pair.second);
        } else if (pair.second instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) pair.second).booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory() {
        com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory("OC_Callback : receive new oc data");
        HashSet hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.BuiltInFictitiousFunctionClassFactory);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.run();
            }
        }
        hashSet.clear();
    }

    public final int getAuthRequestContext(int i, int i2) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("oc_");
            sb.append(i);
            String obj = sb.toString();
            return this.MyBillsEntityDataFactory.contains(obj) ? this.MyBillsEntityDataFactory.getInt(obj, 0) : this.PlaceComponentResult.contains(obj) ? this.PlaceComponentResult.getInt(obj, 0) : i2;
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            sb2.append(" oc int error ");
            sb2.append(e);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
            return i2;
        }
    }

    public final int BuiltInFictitiousFunctionClassFactory(dc dcVar, int i) {
        try {
            SharedPreferences sharedPreferences = this.PlaceComponentResult;
            StringBuilder sb = new StringBuilder();
            sb.append("oc_version_");
            sb.append(dcVar.a());
            return sharedPreferences.getInt(sb.toString(), i);
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(dcVar);
            sb2.append(" version error ");
            sb2.append(e);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
            return i;
        }
    }

    public final void MyBillsEntityDataFactory(List<Pair<Integer, Object>> list) {
        if (com.xiaomi.push.k.getAuthRequestContext(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.MyBillsEntityDataFactory.edit();
        for (Pair<Integer, Object> pair : list) {
            if (pair.first != null) {
                int intValue = ((Integer) pair.first).intValue();
                StringBuilder sb = new StringBuilder();
                sb.append("oc_");
                sb.append(intValue);
                String obj = sb.toString();
                if (pair.second == null) {
                    edit.remove(obj);
                } else {
                    MyBillsEntityDataFactory(edit, pair, obj);
                }
            }
        }
        edit.apply();
    }

    public final void BuiltInFictitiousFunctionClassFactory(List<Pair<dc, Integer>> list, List<Pair<Integer, Object>> list2) {
        if (com.xiaomi.push.k.getAuthRequestContext(list) || com.xiaomi.push.k.getAuthRequestContext(list2)) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("not update oc, because versions or configs are empty");
            return;
        }
        SharedPreferences.Editor edit = this.PlaceComponentResult.edit();
        edit.clear();
        for (Pair<dc, Integer> pair : list) {
            if (pair.first != null && pair.second != null) {
                dc dcVar = (dc) pair.first;
                StringBuilder sb = new StringBuilder();
                sb.append("oc_version_");
                sb.append(dcVar.a());
                edit.putInt(sb.toString(), ((Integer) pair.second).intValue());
            }
        }
        for (Pair<Integer, Object> pair2 : list2) {
            if (pair2.first != null && pair2.second != null) {
                int intValue = ((Integer) pair2.first).intValue();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("oc_");
                sb2.append(intValue);
                MyBillsEntityDataFactory(edit, pair2, sb2.toString());
            }
        }
        edit.apply();
    }

    public final boolean MyBillsEntityDataFactory(int i) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("oc_");
            sb.append(i);
            String obj = sb.toString();
            if (this.MyBillsEntityDataFactory.contains(obj)) {
                return this.MyBillsEntityDataFactory.getBoolean(obj, false);
            }
            if (this.PlaceComponentResult.contains(obj)) {
                return this.PlaceComponentResult.getBoolean(obj, false);
            }
            return true;
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            sb2.append(" oc boolean error ");
            sb2.append(e);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb2.toString());
            return true;
        }
    }
}
