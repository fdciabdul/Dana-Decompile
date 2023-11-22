package com.alibaba.griver.ui.ant.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.ui.ant.api.AUPop;
import com.alibaba.griver.ui.ant.api.AUPopSupportPreemption;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.domain.expresspurchase.interaction.SaveLastActionToPreference;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/* loaded from: classes6.dex */
public class PopManager {
    public static final byte[] MyBillsEntityDataFactory = {122, TarHeader.LF_CONTIG, -29, -99, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 4, -13, 35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int PlaceComponentResult = 134;

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, String> f6681a;
    private static final Map<Activity, TreeSet<PopBean>> b;
    private static final Handler c;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.alibaba.griver.ui.ant.dialog.PopManager.MyBillsEntityDataFactory
            int r7 = r7 * 3
            int r7 = r7 + 13
            int r6 = r6 * 12
            int r6 = r6 + 4
            int r8 = 106 - r8
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L35
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L35:
            int r6 = -r6
            int r9 = r9 + r6
            int r6 = r7 + 1
            int r7 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.ui.ant.dialog.PopManager.d(byte, short, byte, java.lang.Object[]):void");
    }

    static {
        HashMap hashMap = new HashMap();
        f6681a = hashMap;
        b = new ConcurrentHashMap();
        c = new Handler(Looper.getMainLooper());
        hashMap.put("101056", ContainerUIProvider.KEY_SHOW);
        hashMap.put("101073", SaveLastActionToPreference.DISMISS_EP);
        hashMap.put("101074", "preshow");
        hashMap.put("101075", "dismissallpopup");
        hashMap.put("101076", SemanticAttributes.MessagingDestinationKindValues.QUEUE);
        hashMap.put("101077", "replaced");
        hashMap.put("100810", "threadCreate");
        hashMap.put("100811", "threadShow");
    }

    public static void show(AUPop aUPop) {
        if (aUPop == null) {
            return;
        }
        PopBean popBean = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("ready start show:");
            sb.append(aUPop);
            GriverLogger.d("PopManager", sb.toString());
            StringBuilder a2 = a(3, 13);
            if (Looper.myLooper() != Looper.getMainLooper()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("show in workder thread, ignore, ");
                sb2.append(aUPop);
                GriverLogger.debug("PopManager", sb2.toString());
                a(aUPop.getPopActivity(), aUPop, "100811", a2.toString());
            } else if ((aUPop instanceof AUBasicDialog) && !((AUBasicDialog) aUPop).isCreateInUIThread()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("create in worker thread, ignore, ");
                sb3.append(aUPop);
                GriverLogger.debug("PopManager", sb3.toString());
                a(aUPop.getPopActivity(), aUPop, "100810", a2.toString());
            } else if (!isOpen()) {
                aUPop.showPop();
            } else {
                Activity popActivity = aUPop.getPopActivity();
                if (popActivity == null) {
                    GriverLogger.e("PopManager", "pop's context is not instance of activity");
                    return;
                }
                if (!popActivity.isFinishing() && !popActivity.isDestroyed()) {
                    PopBean findPop = findPop(aUPop);
                    if (findPop == null) {
                        findPop = new PopBean(aUPop, System.currentTimeMillis(), System.nanoTime());
                    } else {
                        findPop.showMillis = System.currentTimeMillis();
                        findPop.showNano = System.nanoTime();
                    }
                    GriverLogger.d("PopManager", "start show");
                    a(popActivity, findPop, "101074");
                    Map<Activity, TreeSet<PopBean>> map = b;
                    TreeSet<PopBean> treeSet = map.get(popActivity);
                    if (treeSet == null) {
                        treeSet = new TreeSet<>();
                        map.put(popActivity, treeSet);
                    }
                    findPop.isRegister = true;
                    treeSet.add(findPop);
                    PopBean first = treeSet.first();
                    if (first == null) {
                        treeSet.pollFirst();
                        first = treeSet.first();
                    }
                    PopBean popBean2 = first;
                    if (popBean2.isShowing) {
                        a(popActivity, findPop, "101076");
                        findPop.isQueue = true;
                        if (!(popBean2.mAUPop instanceof Dialog) || ((Dialog) popBean2.mAUPop).isShowing()) {
                            return;
                        }
                        a(popBean2);
                        return;
                    }
                    a(popBean2);
                    if (treeSet.size() == 1) {
                        a(popActivity, popBean2, "101056");
                        return;
                    }
                    Iterator<PopBean> it = treeSet.iterator();
                    while (it.hasNext()) {
                        PopBean next = it.next();
                        if (next != popBean2 && (next.mAUPop instanceof AUPopSupportPreemption) && next.isShowing) {
                            next.isShowing = false;
                            next.isPreemption = true;
                            ((AUPopSupportPreemption) next.mAUPop).onPreemption();
                        }
                    }
                    a(popActivity, popBean2, "101077");
                    return;
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("show Activity is finish, name = ");
                sb4.append(popActivity.getClass().getName());
                GriverLogger.d("PopManager", sb4.toString());
                Map<Activity, TreeSet<PopBean>> map2 = b;
                if (map2.containsKey(popActivity)) {
                    map2.remove(popActivity);
                }
            }
        } catch (Throwable th) {
            GriverLogger.e("PopManager", "show dialog exception: ", th);
            if (0 != 0) {
                GriverLogger.e("PopManager", "show dialog exception, force close dialog");
                dismiss(popBean.mAUPop);
            }
        }
    }

    private static StringBuilder a(int i, int i2) {
        try {
            Object[] objArr = new Object[1];
            d(MyBillsEntityDataFactory[6], (byte) (-MyBillsEntityDataFactory[15]), MyBillsEntityDataFactory[21], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = MyBillsEntityDataFactory[21];
            Object[] objArr2 = new Object[1];
            d(b2, b2, (byte) (-MyBillsEntityDataFactory[8]), objArr2);
            Object invoke = cls.getMethod((String) objArr2[0], null).invoke(null, null);
            try {
                Object[] objArr3 = new Object[1];
                d(MyBillsEntityDataFactory[6], (byte) (-MyBillsEntityDataFactory[15]), MyBillsEntityDataFactory[21], objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b3 = (byte) (-MyBillsEntityDataFactory[15]);
                byte b4 = MyBillsEntityDataFactory[21];
                Object[] objArr4 = new Object[1];
                d(b3, b4, (byte) (b4 + 3), objArr4);
                StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) cls2.getMethod((String) objArr4[0], null).invoke(invoke, null);
                StringBuilder sb = new StringBuilder();
                if (stackTraceElementArr != null) {
                    while (i < stackTraceElementArr.length) {
                        GriverLogger.d("PopManager", stackTraceElementArr[i].toString());
                        sb.append(stackTraceElementArr[i]);
                        sb.append("#");
                        if (i > i2) {
                            break;
                        }
                        i++;
                    }
                }
                return sb;
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (Throwable th2) {
            Throwable cause2 = th2.getCause();
            if (cause2 != null) {
                throw cause2;
            }
            throw th2;
        }
    }

    public static void dismiss(AUPop aUPop) {
        if (aUPop == null) {
            return;
        }
        try {
            if (!isOpen()) {
                aUPop.dismissPop();
                return;
            }
            Activity popActivity = aUPop.getPopActivity();
            if (popActivity == null) {
                GriverLogger.e("PopManager", "pop's context is not instance of activity");
                return;
            }
            a(popActivity);
            if (!popActivity.isFinishing() && !popActivity.isDestroyed()) {
                PopBean findPop = findPop(aUPop);
                if (findPop == null) {
                    aUPop.dismissPop();
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("start dismiss:");
                sb.append(aUPop);
                GriverLogger.d("PopManager", sb.toString());
                a(3, 20);
                Map<Activity, TreeSet<PopBean>> map = b;
                TreeSet<PopBean> treeSet = map.get(popActivity);
                if (treeSet != null && !treeSet.isEmpty()) {
                    if (treeSet.contains(findPop)) {
                        if (!findPop.isPreemption) {
                            treeSet.remove(findPop);
                            findPop.isRegister = false;
                        }
                        findPop.mAUPop.dismissPop();
                        a(popActivity, findPop, "101073");
                    }
                    if (treeSet.isEmpty()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("2.empty list, remove activity : ");
                        sb2.append(popActivity);
                        GriverLogger.d("PopManager", sb2.toString());
                        if (map.containsKey(popActivity)) {
                            map.remove(popActivity);
                            return;
                        }
                        return;
                    }
                    PopBean first = treeSet.first();
                    if (first == null) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("first is null activity : ");
                        sb3.append(popActivity);
                        GriverLogger.d("PopManager", sb3.toString());
                        return;
                    } else if (first.isShowing) {
                        return;
                    } else {
                        a(first);
                        a(popActivity, first, "101056");
                        return;
                    }
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("1.empty list, remove activity : ");
                sb4.append(popActivity);
                GriverLogger.d("PopManager", sb4.toString());
                if (map.containsKey(popActivity)) {
                    map.remove(popActivity);
                    return;
                }
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("dismiss Activity is finish, name = ");
            sb5.append(popActivity.getClass().getName());
            GriverLogger.d("PopManager", sb5.toString());
            Map<Activity, TreeSet<PopBean>> map2 = b;
            if (map2.containsKey(popActivity)) {
                map2.remove(popActivity);
            }
        } catch (Throwable th) {
            GriverLogger.e("PopManager", th.toString());
        }
    }

    private static void a(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            Iterator<Map.Entry<Activity, TreeSet<PopBean>>> it = b.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Activity, TreeSet<PopBean>> next = it.next();
                Activity key = next.getKey();
                TreeSet<PopBean> value = next.getValue();
                if (activity != key && (key.isFinishing() || key.isDestroyed() || value == null || value.isEmpty())) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("remove activity without dialog : ");
                    sb.append(key);
                    GriverLogger.d("PopManager", sb.toString());
                    it.remove();
                }
            }
        } catch (Throwable th) {
            GriverLogger.e("PopManager", "gcActivity exception: ", th);
        }
    }

    private static void a(final PopBean popBean) {
        popBean.isQueue = false;
        popBean.isPreemption = false;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            popBean.mAUPop.showPop();
        } else {
            c.post(new Runnable() { // from class: com.alibaba.griver.ui.ant.dialog.PopManager.1
                @Override // java.lang.Runnable
                public final void run() {
                    PopBean.this.mAUPop.showPop();
                }
            });
        }
        popBean.isShowing = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static PopBean findPop(AUPop aUPop) {
        TreeSet<PopBean> treeSet = b.get(aUPop.getPopActivity());
        if (treeSet == null) {
            return null;
        }
        Iterator<PopBean> it = treeSet.iterator();
        while (it.hasNext()) {
            PopBean next = it.next();
            if (next.mAUPop == aUPop) {
                return next;
            }
        }
        return null;
    }

    public static void dismissAll(Activity activity) {
        if (isOpen() && activity != null) {
            try {
                TreeSet<PopBean> treeSet = b.get(activity);
                if (treeSet == null || treeSet.isEmpty()) {
                    return;
                }
                Iterator<PopBean> it = treeSet.iterator();
                while (it.hasNext()) {
                    PopBean next = it.next();
                    if (next != null) {
                        next.mAUPop.dismissPop();
                    }
                }
                b.remove(activity);
                HashMap hashMap = new HashMap();
                hashMap.put("action", f6681a.get("101075"));
                hashMap.put("referer_url", activity.getClass().getName());
            } catch (Throwable th) {
                GriverLogger.e("PopManager", th.toString());
            }
        }
    }

    private static void a(Activity activity, PopBean popBean, String str) {
        a(activity, popBean.mAUPop, str, null);
    }

    private static void a(Activity activity, AUPop aUPop, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = f6681a;
        sb.append(map.get(str));
        sb.append(": ");
        sb.append(aUPop);
        GriverLogger.d("PopManager", sb.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("action", map.get(str));
        hashMap.put(FirebaseAnalytics.Param.CONTENT_TYPE, aUPop.getClass().getName());
        hashMap.put("referer_url", activity != null ? activity.getClass().getName() : "null");
        hashMap.put("category", a(aUPop));
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        hashMap.put("fromStackTrace", str2);
    }

    private static String a(AUPop aUPop) {
        Class<?> cls = aUPop.getClass();
        String str = "";
        for (int i = 0; i < 5; i++) {
            if (cls == null) {
                return str;
            }
            str = cls.getSimpleName();
            if (str.startsWith("AP") || str.startsWith("AU") || str.startsWith("Bee")) {
                break;
            }
            cls = cls.getSuperclass();
        }
        return str;
    }

    public static boolean isOpen() {
        return GriverConfig.getConfigBoolean("AUDialogWindow_AUPopManager_disable_v2", true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class PopBean implements Comparable<PopBean> {
        public boolean isPreemption;
        boolean isQueue;
        boolean isRegister;
        boolean isShowing;
        AUPop mAUPop;
        long showMillis;
        long showNano;

        public PopBean(AUPop aUPop, long j, long j2) {
            this.mAUPop = aUPop;
            this.showMillis = j;
            this.showNano = j2;
        }

        @Override // java.lang.Comparable
        public int compareTo(PopBean popBean) {
            int priority = popBean.mAUPop.getPriority() - this.mAUPop.getPriority();
            if (priority != 0) {
                return priority;
            }
            int i = (int) (this.showMillis - popBean.showMillis);
            return i != 0 ? i : (int) (this.showNano - popBean.showNano);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PopBean { priority: ");
            sb.append(this.mAUPop.getPriority());
            sb.append(", showMillis: ");
            sb.append(this.showMillis);
            sb.append(" }");
            return sb.toString();
        }
    }
}
