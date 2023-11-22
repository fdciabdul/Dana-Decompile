package com.huawei.hms.framework.common;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerZCodeConstant;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes7.dex */
public class AssetsUtil {
    private static final ExecutorService KClassImpl$Data$declaredNonStaticMembers$2 = ExecutorsUtils.newSingleThreadExecutor("AssetsUtil_Operate");
    private static int PlaceComponentResult = 1;
    private static int getAuthRequestContext;

    public static String[] list(final Context context, final String str) {
        if (context == null) {
            Logger.w("AssetsUtil", HummerZCodeConstant.CONTEXT_ERROR_MSG);
            return new String[0];
        }
        FutureTask futureTask = new FutureTask(new Callable<String[]>() { // from class: com.huawei.hms.framework.common.AssetsUtil.1
            @Override // java.util.concurrent.Callable
            public final String[] call() throws Exception {
                return context.getAssets().list(str);
            }
        });
        KClassImpl$Data$declaredNonStaticMembers$2.execute(futureTask);
        try {
            return (String[]) futureTask.get(5L, TimeUnit.SECONDS);
        } catch (TimeoutException unused) {
            Logger.w("AssetsUtil", "get local config files from sp task timed out");
            return new String[0];
        } catch (Exception unused2) {
            Logger.w("AssetsUtil", "get local config files from sp task occur unknown Exception");
            return new String[0];
        } catch (InterruptedException e) {
            Logger.w("AssetsUtil", "get local config files from sp task interrupted", e);
            return new String[0];
        } catch (ExecutionException e2) {
            Logger.w("AssetsUtil", "get local config files from sp task failed", e2);
            return new String[0];
        } finally {
            futureTask.cancel(true);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
    
        if ((r9 == null ? 7 : 'R') != 7) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        if ((r9 == null) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0032, code lost:
    
        com.huawei.hms.framework.common.Logger.w("AssetsUtil", com.ap.zoloz.hummer.biz.HummerZCodeConstant.CONTEXT_ERROR_MSG);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0035, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0036, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0038, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003b, code lost:
    
        throw r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0040, code lost:
    
        r0 = new java.lang.Object[]{r9.getAssets(), r10};
        r9 = o.NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.get(-906490705);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0053, code lost:
    
        if (r9 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0056, code lost:
    
        r9 = ((java.lang.Class) o.NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult((char) (58132 - android.text.TextUtils.indexOf((java.lang.CharSequence) "", '0', 0, 0)), android.view.ViewConfiguration.getDoubleTapTimeout() >> 16, (android.view.ViewConfiguration.getKeyRepeatDelay() >> 16) + 49)).getMethod("getAuthRequestContext", android.content.res.AssetManager.class, java.lang.String.class);
        o.NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested.put(-906490705, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0098, code lost:
    
        r5 = (java.io.InputStream) ((java.lang.reflect.Method) r9).invoke(null, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009a, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009b, code lost:
    
        r10 = r9.getCause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009f, code lost:
    
        if (r10 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a1, code lost:
    
        throw r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a2, code lost:
    
        throw r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a3, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a4, code lost:
    
        com.huawei.hms.framework.common.Logger.e("AssetsUtil", "AssetManager has been destroyed", r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a9, code lost:
    
        r9 = com.huawei.hms.framework.common.AssetsUtil.PlaceComponentResult + 73;
        com.huawei.hms.framework.common.AssetsUtil.getAuthRequestContext = r9 % 128;
        r9 = r9 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b2, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b3, code lost:
    
        throw r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.InputStream open(android.content.Context r9, java.lang.String r10) throws java.io.IOException {
        /*
            int r0 = com.huawei.hms.framework.common.AssetsUtil.getAuthRequestContext
            int r0 = r0 + 41
            int r1 = r0 % 128
            com.huawei.hms.framework.common.AssetsUtil.PlaceComponentResult = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 21
            if (r0 != 0) goto L11
            r0 = 96
            goto L13
        L11:
            r0 = 21
        L13:
            java.lang.String r3 = "AssetsUtil"
            r4 = 1
            r5 = 0
            r6 = 0
            if (r0 == r2) goto L29
            r5.hashCode()     // Catch: java.lang.Throwable -> L27
            r0 = 7
            if (r9 != 0) goto L22
            r2 = 7
            goto L24
        L22:
            r2 = 82
        L24:
            if (r2 == r0) goto L30
            goto L3c
        L27:
            r9 = move-exception
            throw r9
        L29:
            if (r9 != 0) goto L2d
            r0 = 1
            goto L2e
        L2d:
            r0 = 0
        L2e:
            if (r0 == 0) goto L3c
        L30:
            java.lang.String r9 = "context is null"
            com.huawei.hms.framework.common.Logger.w(r3, r9)     // Catch: java.lang.Exception -> L36
            return r5
        L36:
            r9 = move-exception
            goto L3b
        L38:
            r9 = move-exception
            goto Lb3
        L3b:
            throw r9
        L3c:
            android.content.res.AssetManager r9 = r9.getAssets()     // Catch: java.lang.Exception -> L38
            java.lang.Object[] r0 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L9a
            r0[r4] = r10     // Catch: java.lang.Throwable -> L9a
            r0[r6] = r9     // Catch: java.lang.Throwable -> L9a
            java.util.Map<java.lang.Integer, java.lang.Object> r9 = o.NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested     // Catch: java.lang.Throwable -> L9a
            r10 = -906490705(0xffffffffc9f80caf, float:-2032021.9)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Throwable -> L9a
            java.lang.Object r9 = r9.get(r2)     // Catch: java.lang.Throwable -> L9a
            if (r9 == 0) goto L56
            goto L90
        L56:
            r9 = 58132(0xe314, float:8.146E-41)
            java.lang.String r2 = ""
            r7 = 48
            int r2 = android.text.TextUtils.indexOf(r2, r7, r6, r6)     // Catch: java.lang.Throwable -> L9a
            int r9 = r9 - r2
            char r9 = (char) r9     // Catch: java.lang.Throwable -> L9a
            int r2 = android.view.ViewConfiguration.getDoubleTapTimeout()     // Catch: java.lang.Throwable -> L9a
            int r2 = r2 >> 16
            int r7 = android.view.ViewConfiguration.getKeyRepeatDelay()     // Catch: java.lang.Throwable -> L9a
            int r7 = r7 >> 16
            int r7 = r7 + 49
            java.lang.Object r9 = o.NetworkUserEntityData$$ExternalSyntheticLambda7.PlaceComponentResult(r9, r2, r7)     // Catch: java.lang.Throwable -> L9a
            java.lang.Class r9 = (java.lang.Class) r9     // Catch: java.lang.Throwable -> L9a
            java.lang.String r2 = "getAuthRequestContext"
            java.lang.Class[] r7 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L9a
            java.lang.Class<android.content.res.AssetManager> r8 = android.content.res.AssetManager.class
            r7[r6] = r8     // Catch: java.lang.Throwable -> L9a
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r7[r4] = r6     // Catch: java.lang.Throwable -> L9a
            java.lang.reflect.Method r9 = r9.getMethod(r2, r7)     // Catch: java.lang.Throwable -> L9a
            java.util.Map<java.lang.Integer, java.lang.Object> r2 = o.NetworkUserEntityData$$ExternalSyntheticLambda7.isLayoutRequested     // Catch: java.lang.Throwable -> L9a
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Throwable -> L9a
            r2.put(r10, r9)     // Catch: java.lang.Throwable -> L9a
        L90:
            java.lang.reflect.Method r9 = (java.lang.reflect.Method) r9     // Catch: java.lang.Throwable -> L9a
            java.lang.Object r9 = r9.invoke(r5, r0)     // Catch: java.lang.Throwable -> L9a
            java.io.InputStream r9 = (java.io.InputStream) r9     // Catch: java.lang.Throwable -> L9a
            r5 = r9
            goto La9
        L9a:
            r9 = move-exception
            java.lang.Throwable r10 = r9.getCause()     // Catch: java.lang.Exception -> L38 java.lang.RuntimeException -> La3
            if (r10 == 0) goto La2
            throw r10     // Catch: java.lang.Exception -> L38 java.lang.RuntimeException -> La3
        La2:
            throw r9     // Catch: java.lang.Exception -> L38 java.lang.RuntimeException -> La3
        La3:
            r9 = move-exception
            java.lang.String r10 = "AssetManager has been destroyed"
            com.huawei.hms.framework.common.Logger.e(r3, r10, r9)
        La9:
            int r9 = com.huawei.hms.framework.common.AssetsUtil.PlaceComponentResult
            int r9 = r9 + 73
            int r10 = r9 % 128
            com.huawei.hms.framework.common.AssetsUtil.getAuthRequestContext = r10
            int r9 = r9 % r1
            return r5
        Lb3:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.AssetsUtil.open(android.content.Context, java.lang.String):java.io.InputStream");
    }
}
