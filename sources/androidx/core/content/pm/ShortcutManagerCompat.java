package androidx.core.content.pm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.pm.ShortcutInfoCompatSaver;
import androidx.core.graphics.drawable.IconCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public class ShortcutManagerCompat {
    private static volatile ShortcutInfoCompatSaver<?> BuiltInFictitiousFunctionClassFactory;
    private static volatile List<ShortcutInfoChangeListener> PlaceComponentResult;
    public static final byte[] getAuthRequestContext = {TarHeader.LF_DIR, 18, -76, 65, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 56;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ShortcutMatchFlags {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0029). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.Object[] r10) {
        /*
            byte[] r0 = androidx.core.content.pm.ShortcutManagerCompat.getAuthRequestContext
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 3
            r4 = 0
            if (r0 != 0) goto Lf
            r5 = 3
            r6 = 23
            r7 = 0
            goto L29
        Lf:
            r5 = 97
            r6 = 0
        L12:
            int r7 = r6 + 1
            byte r8 = (byte) r5
            r2[r6] = r8
            int r3 = r3 + 1
            if (r7 != r1) goto L23
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2, r4)
            r10[r4] = r0
            return
        L23:
            r6 = r0[r3]
            r9 = r5
            r5 = r3
            r3 = r6
            r6 = r9
        L29:
            int r6 = r6 + r3
            int r3 = r6 + (-8)
            r6 = r7
            r9 = r5
            r5 = r3
            r3 = r9
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.pm.ShortcutManagerCompat.a(java.lang.Object[]):void");
    }

    private ShortcutManagerCompat() {
    }

    /* renamed from: androidx.core.content.pm.ShortcutManagerCompat$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ IntentSender PlaceComponentResult;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                this.PlaceComponentResult.sendIntent(context, 0, null, null, null);
            } catch (IntentSender.SendIntentException unused) {
            }
        }
    }

    public static boolean getAuthRequestContext(Context context, List<ShortcutInfoCompat> list) {
        List<ShortcutInfoCompat> authRequestContext = getAuthRequestContext(list, 1);
        if (Build.VERSION.SDK_INT <= 29) {
            KClassImpl$Data$declaredNonStaticMembers$2(context, authRequestContext);
        }
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList arrayList = new ArrayList();
            Iterator<ShortcutInfoCompat> it = authRequestContext.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().PlaceComponentResult());
            }
            if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).addDynamicShortcuts(arrayList)) {
                return false;
            }
        }
        MyBillsEntityDataFactory(context).MyBillsEntityDataFactory(authRequestContext);
        for (ShortcutInfoChangeListener shortcutInfoChangeListener : getAuthRequestContext(context)) {
        }
        return true;
    }

    static boolean BuiltInFictitiousFunctionClassFactory(Context context, ShortcutInfoCompat shortcutInfoCompat) {
        Bitmap decodeStream;
        IconCompat KClassImpl$Data$declaredNonStaticMembers$22;
        if (shortcutInfoCompat.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            return false;
        }
        int i = shortcutInfoCompat.NetworkUserEntityData$$ExternalSyntheticLambda0.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (i == 6 || i == 4) {
            InputStream MyBillsEntityDataFactory = shortcutInfoCompat.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory(context);
            if (MyBillsEntityDataFactory == null || (decodeStream = BitmapFactory.decodeStream(MyBillsEntityDataFactory)) == null) {
                return false;
            }
            if (i == 6) {
                KClassImpl$Data$declaredNonStaticMembers$22 = IconCompat.PlaceComponentResult(decodeStream);
            } else {
                KClassImpl$Data$declaredNonStaticMembers$22 = IconCompat.KClassImpl$Data$declaredNonStaticMembers$2(decodeStream);
            }
            shortcutInfoCompat.NetworkUserEntityData$$ExternalSyntheticLambda0 = KClassImpl$Data$declaredNonStaticMembers$22;
            return true;
        }
        return true;
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2(Context context, List<ShortcutInfoCompat> list) {
        for (ShortcutInfoCompat shortcutInfoCompat : new ArrayList(list)) {
            if (!BuiltInFictitiousFunctionClassFactory(context, shortcutInfoCompat)) {
                list.remove(shortcutInfoCompat);
            }
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts();
        }
        MyBillsEntityDataFactory(context).getAuthRequestContext();
        for (ShortcutInfoChangeListener shortcutInfoChangeListener : getAuthRequestContext(context)) {
        }
    }

    private static ShortcutInfoCompatSaver<?> MyBillsEntityDataFactory(Context context) {
        if (BuiltInFictitiousFunctionClassFactory == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    Class<?> cls = Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader());
                    Object[] objArr = new Object[1];
                    a(objArr);
                    BuiltInFictitiousFunctionClassFactory = (ShortcutInfoCompatSaver) cls.getMethod("getInstance", Class.forName((String) objArr[0])).invoke(null, context);
                } catch (Exception unused) {
                }
            }
            if (BuiltInFictitiousFunctionClassFactory == null) {
                BuiltInFictitiousFunctionClassFactory = new ShortcutInfoCompatSaver.NoopImpl();
            }
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    private static List<ShortcutInfoChangeListener> getAuthRequestContext(Context context) {
        Bundle bundle;
        String string;
        if (PlaceComponentResult == null) {
            ArrayList arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 21) {
                PackageManager packageManager = context.getPackageManager();
                Intent intent = new Intent("androidx.core.content.pm.SHORTCUT_LISTENER");
                intent.setPackage(context.getPackageName());
                Iterator<ResolveInfo> it = packageManager.queryIntentActivities(intent, 128).iterator();
                while (it.hasNext()) {
                    ActivityInfo activityInfo = it.next().activityInfo;
                    if (activityInfo != null && (bundle = activityInfo.metaData) != null && (string = bundle.getString("androidx.core.content.pm.shortcut_listener_impl")) != null) {
                        try {
                            Class<?> cls = Class.forName(string, false, ShortcutManagerCompat.class.getClassLoader());
                            Object[] objArr = new Object[1];
                            a(objArr);
                            arrayList.add((ShortcutInfoChangeListener) cls.getMethod("getInstance", Class.forName((String) objArr[0])).invoke(null, context));
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            if (PlaceComponentResult == null) {
                PlaceComponentResult = arrayList;
            }
        }
        return PlaceComponentResult;
    }

    private static List<ShortcutInfoCompat> getAuthRequestContext(List<ShortcutInfoCompat> list, int i) {
        Objects.requireNonNull(list);
        if (Build.VERSION.SDK_INT > 31) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list);
        for (ShortcutInfoCompat shortcutInfoCompat : list) {
            if (shortcutInfoCompat.PlaceComponentResult(i)) {
                arrayList.remove(shortcutInfoCompat);
            }
        }
        return arrayList;
    }

    /* loaded from: classes6.dex */
    static class Api25Impl {
        private Api25Impl() {
        }
    }
}
