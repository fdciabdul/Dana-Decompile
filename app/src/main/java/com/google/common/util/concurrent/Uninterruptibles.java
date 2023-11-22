package com.google.common.util.concurrent;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import com.google.common.base.Verify;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;

@ElementTypesAreNonnullByDefault
/* loaded from: classes3.dex */
public final class Uninterruptibles {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {116, 58, -28, -63, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int PlaceComponentResult = 74;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 12
            int r7 = 16 - r7
            int r8 = r8 * 7
            int r8 = 106 - r8
            byte[] r0 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 * 3
            int r6 = 16 - r6
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1d
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L38
        L1d:
            r3 = 0
        L1e:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L38:
            int r6 = -r6
            int r9 = r9 + r6
            int r6 = r8 + 1
            int r8 = r9 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Uninterruptibles.a(short, byte, byte, java.lang.Object[]):void");
    }

    public static void awaitUninterruptibly(CountDownLatch countDownLatch) {
        boolean z = false;
        while (true) {
            try {
                countDownLatch.await();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    try {
                        byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
                        byte b2 = b;
                        Object[] objArr = new Object[1];
                        a(b, b2, b2, objArr);
                        Class<?> cls = Class.forName((String) objArr[0]);
                        byte b3 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                        byte b4 = b3;
                        Object[] objArr2 = new Object[1];
                        a(b3, b4, b4, objArr2);
                        ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                    } catch (Throwable th2) {
                        Throwable cause = th2.getCause();
                        if (cause == null) {
                            throw th2;
                        }
                        throw cause;
                    }
                }
                throw th;
            }
        }
        if (z) {
            try {
                byte b5 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
                byte b6 = b5;
                Object[] objArr3 = new Object[1];
                a(b5, b6, b6, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b7 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                byte b8 = b7;
                Object[] objArr4 = new Object[1];
                a(b7, b8, b8, objArr4);
                ((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).interrupt();
            } catch (Throwable th3) {
                Throwable cause2 = th3.getCause();
                if (cause2 == null) {
                    throw th3;
                }
                throw cause2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean awaitUninterruptibly(java.util.concurrent.CountDownLatch r10, long r11, java.util.concurrent.TimeUnit r13) {
        /*
            r0 = 15
            r1 = 0
            r2 = 0
            r3 = 1
            long r11 = r13.toNanos(r11)     // Catch: java.lang.Throwable -> L64
            long r4 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L64
            r6 = r11
            r13 = 0
        Lf:
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.Throwable -> L55 java.lang.InterruptedException -> L57
            boolean r10 = r10.await(r6, r8)     // Catch: java.lang.Throwable -> L55 java.lang.InterruptedException -> L57
            if (r13 == 0) goto L54
            byte[] r11 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L4b
            r11 = r11[r0]     // Catch: java.lang.Throwable -> L4b
            int r11 = r11 + r3
            byte r11 = (byte) r11     // Catch: java.lang.Throwable -> L4b
            byte r12 = (byte) r11     // Catch: java.lang.Throwable -> L4b
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L4b
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L4b
            a(r11, r12, r13, r4)     // Catch: java.lang.Throwable -> L4b
            r11 = r4[r2]     // Catch: java.lang.Throwable -> L4b
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L4b
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch: java.lang.Throwable -> L4b
            byte[] r12 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L4b
            r12 = r12[r0]     // Catch: java.lang.Throwable -> L4b
            int r12 = -r12
            byte r12 = (byte) r12     // Catch: java.lang.Throwable -> L4b
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L4b
            byte r0 = (byte) r13     // Catch: java.lang.Throwable -> L4b
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L4b
            a(r12, r13, r0, r3)     // Catch: java.lang.Throwable -> L4b
            r12 = r3[r2]     // Catch: java.lang.Throwable -> L4b
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L4b
            java.lang.reflect.Method r11 = r11.getMethod(r12, r1)     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r11 = r11.invoke(r1, r1)     // Catch: java.lang.Throwable -> L4b
            java.lang.Thread r11 = (java.lang.Thread) r11     // Catch: java.lang.Throwable -> L4b
            r11.interrupt()
            goto L54
        L4b:
            r10 = move-exception
            java.lang.Throwable r11 = r10.getCause()
            if (r11 == 0) goto L53
            throw r11
        L53:
            throw r10
        L54:
            return r10
        L55:
            r10 = move-exception
            goto L66
        L57:
            long r6 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L61
            long r8 = r4 + r11
            long r6 = r8 - r6
            r13 = 1
            goto Lf
        L61:
            r10 = move-exception
            r13 = 1
            goto L66
        L64:
            r10 = move-exception
            r13 = 0
        L66:
            if (r13 == 0) goto La5
            byte[] r11 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L9c
            r11 = r11[r0]     // Catch: java.lang.Throwable -> L9c
            int r11 = r11 + r3
            byte r11 = (byte) r11     // Catch: java.lang.Throwable -> L9c
            byte r12 = (byte) r11     // Catch: java.lang.Throwable -> L9c
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L9c
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9c
            a(r11, r12, r13, r4)     // Catch: java.lang.Throwable -> L9c
            r11 = r4[r2]     // Catch: java.lang.Throwable -> L9c
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L9c
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch: java.lang.Throwable -> L9c
            byte[] r12 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L9c
            r12 = r12[r0]     // Catch: java.lang.Throwable -> L9c
            int r12 = -r12
            byte r12 = (byte) r12     // Catch: java.lang.Throwable -> L9c
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L9c
            byte r0 = (byte) r13     // Catch: java.lang.Throwable -> L9c
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9c
            a(r12, r13, r0, r3)     // Catch: java.lang.Throwable -> L9c
            r12 = r3[r2]     // Catch: java.lang.Throwable -> L9c
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L9c
            java.lang.reflect.Method r11 = r11.getMethod(r12, r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r11 = r11.invoke(r1, r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.Thread r11 = (java.lang.Thread) r11     // Catch: java.lang.Throwable -> L9c
            r11.interrupt()
            goto La5
        L9c:
            r10 = move-exception
            java.lang.Throwable r11 = r10.getCause()
            if (r11 == 0) goto La4
            throw r11
        La4:
            throw r10
        La5:
            goto La7
        La6:
            throw r10
        La7:
            goto La6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Uninterruptibles.awaitUninterruptibly(java.util.concurrent.CountDownLatch, long, java.util.concurrent.TimeUnit):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean awaitUninterruptibly(java.util.concurrent.locks.Condition r10, long r11, java.util.concurrent.TimeUnit r13) {
        /*
            r0 = 15
            r1 = 0
            r2 = 0
            r3 = 1
            long r11 = r13.toNanos(r11)     // Catch: java.lang.Throwable -> L64
            long r4 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L64
            r6 = r11
            r13 = 0
        Lf:
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.Throwable -> L55 java.lang.InterruptedException -> L57
            boolean r10 = r10.await(r6, r8)     // Catch: java.lang.Throwable -> L55 java.lang.InterruptedException -> L57
            if (r13 == 0) goto L54
            byte[] r11 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L4b
            r11 = r11[r0]     // Catch: java.lang.Throwable -> L4b
            int r11 = r11 + r3
            byte r11 = (byte) r11     // Catch: java.lang.Throwable -> L4b
            byte r12 = (byte) r11     // Catch: java.lang.Throwable -> L4b
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L4b
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L4b
            a(r11, r12, r13, r4)     // Catch: java.lang.Throwable -> L4b
            r11 = r4[r2]     // Catch: java.lang.Throwable -> L4b
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L4b
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch: java.lang.Throwable -> L4b
            byte[] r12 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L4b
            r12 = r12[r0]     // Catch: java.lang.Throwable -> L4b
            int r12 = -r12
            byte r12 = (byte) r12     // Catch: java.lang.Throwable -> L4b
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L4b
            byte r0 = (byte) r13     // Catch: java.lang.Throwable -> L4b
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L4b
            a(r12, r13, r0, r3)     // Catch: java.lang.Throwable -> L4b
            r12 = r3[r2]     // Catch: java.lang.Throwable -> L4b
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L4b
            java.lang.reflect.Method r11 = r11.getMethod(r12, r1)     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r11 = r11.invoke(r1, r1)     // Catch: java.lang.Throwable -> L4b
            java.lang.Thread r11 = (java.lang.Thread) r11     // Catch: java.lang.Throwable -> L4b
            r11.interrupt()
            goto L54
        L4b:
            r10 = move-exception
            java.lang.Throwable r11 = r10.getCause()
            if (r11 == 0) goto L53
            throw r11
        L53:
            throw r10
        L54:
            return r10
        L55:
            r10 = move-exception
            goto L66
        L57:
            long r6 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L61
            long r8 = r4 + r11
            long r6 = r8 - r6
            r13 = 1
            goto Lf
        L61:
            r10 = move-exception
            r13 = 1
            goto L66
        L64:
            r10 = move-exception
            r13 = 0
        L66:
            if (r13 == 0) goto La5
            byte[] r11 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L9c
            r11 = r11[r0]     // Catch: java.lang.Throwable -> L9c
            int r11 = r11 + r3
            byte r11 = (byte) r11     // Catch: java.lang.Throwable -> L9c
            byte r12 = (byte) r11     // Catch: java.lang.Throwable -> L9c
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L9c
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9c
            a(r11, r12, r13, r4)     // Catch: java.lang.Throwable -> L9c
            r11 = r4[r2]     // Catch: java.lang.Throwable -> L9c
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L9c
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch: java.lang.Throwable -> L9c
            byte[] r12 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L9c
            r12 = r12[r0]     // Catch: java.lang.Throwable -> L9c
            int r12 = -r12
            byte r12 = (byte) r12     // Catch: java.lang.Throwable -> L9c
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L9c
            byte r0 = (byte) r13     // Catch: java.lang.Throwable -> L9c
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9c
            a(r12, r13, r0, r3)     // Catch: java.lang.Throwable -> L9c
            r12 = r3[r2]     // Catch: java.lang.Throwable -> L9c
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L9c
            java.lang.reflect.Method r11 = r11.getMethod(r12, r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r11 = r11.invoke(r1, r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.Thread r11 = (java.lang.Thread) r11     // Catch: java.lang.Throwable -> L9c
            r11.interrupt()
            goto La5
        L9c:
            r10 = move-exception
            java.lang.Throwable r11 = r10.getCause()
            if (r11 == 0) goto La4
            throw r11
        La4:
            throw r10
        La5:
            goto La7
        La6:
            throw r10
        La7:
            goto La6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Uninterruptibles.awaitUninterruptibly(java.util.concurrent.locks.Condition, long, java.util.concurrent.TimeUnit):boolean");
    }

    public static void joinUninterruptibly(Thread thread) {
        boolean z = false;
        while (true) {
            try {
                thread.join();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    try {
                        byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
                        byte b2 = b;
                        Object[] objArr = new Object[1];
                        a(b, b2, b2, objArr);
                        Class<?> cls = Class.forName((String) objArr[0]);
                        byte b3 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                        byte b4 = b3;
                        Object[] objArr2 = new Object[1];
                        a(b3, b4, b4, objArr2);
                        ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                    } catch (Throwable th2) {
                        Throwable cause = th2.getCause();
                        if (cause == null) {
                            throw th2;
                        }
                        throw cause;
                    }
                }
                throw th;
            }
        }
        if (z) {
            try {
                byte b5 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
                byte b6 = b5;
                Object[] objArr3 = new Object[1];
                a(b5, b6, b6, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b7 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                byte b8 = b7;
                Object[] objArr4 = new Object[1];
                a(b7, b8, b8, objArr4);
                ((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).interrupt();
            } catch (Throwable th3) {
                Throwable cause2 = th3.getCause();
                if (cause2 == null) {
                    throw th3;
                }
                throw cause2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void joinUninterruptibly(java.lang.Thread r10, long r11, java.util.concurrent.TimeUnit r13) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r10)
            r0 = 15
            r1 = 0
            r2 = 0
            r3 = 1
            long r11 = r13.toNanos(r11)     // Catch: java.lang.Throwable -> L66
            long r4 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L66
            r6 = r11
            r13 = 0
        L12:
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.Throwable -> L57 java.lang.InterruptedException -> L59
            r8.timedJoin(r10, r6)     // Catch: java.lang.Throwable -> L57 java.lang.InterruptedException -> L59
            if (r13 == 0) goto L56
            byte[] r10 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L4d
            r10 = r10[r0]     // Catch: java.lang.Throwable -> L4d
            int r10 = r10 + r3
            byte r10 = (byte) r10     // Catch: java.lang.Throwable -> L4d
            byte r11 = (byte) r10     // Catch: java.lang.Throwable -> L4d
            byte r12 = (byte) r11     // Catch: java.lang.Throwable -> L4d
            java.lang.Object[] r13 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L4d
            a(r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L4d
            r10 = r13[r2]     // Catch: java.lang.Throwable -> L4d
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L4d
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch: java.lang.Throwable -> L4d
            byte[] r11 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L4d
            r11 = r11[r0]     // Catch: java.lang.Throwable -> L4d
            int r11 = -r11
            byte r11 = (byte) r11     // Catch: java.lang.Throwable -> L4d
            byte r12 = (byte) r11     // Catch: java.lang.Throwable -> L4d
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L4d
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L4d
            a(r11, r12, r13, r0)     // Catch: java.lang.Throwable -> L4d
            r11 = r0[r2]     // Catch: java.lang.Throwable -> L4d
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L4d
            java.lang.reflect.Method r10 = r10.getMethod(r11, r1)     // Catch: java.lang.Throwable -> L4d
            java.lang.Object r10 = r10.invoke(r1, r1)     // Catch: java.lang.Throwable -> L4d
            java.lang.Thread r10 = (java.lang.Thread) r10     // Catch: java.lang.Throwable -> L4d
            r10.interrupt()
            goto L56
        L4d:
            r10 = move-exception
            java.lang.Throwable r11 = r10.getCause()
            if (r11 == 0) goto L55
            throw r11
        L55:
            throw r10
        L56:
            return
        L57:
            r10 = move-exception
            goto L68
        L59:
            long r6 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L63
            long r8 = r4 + r11
            long r6 = r8 - r6
            r13 = 1
            goto L12
        L63:
            r10 = move-exception
            r13 = 1
            goto L68
        L66:
            r10 = move-exception
            r13 = 0
        L68:
            if (r13 == 0) goto La7
            byte[] r11 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L9e
            r11 = r11[r0]     // Catch: java.lang.Throwable -> L9e
            int r11 = r11 + r3
            byte r11 = (byte) r11     // Catch: java.lang.Throwable -> L9e
            byte r12 = (byte) r11     // Catch: java.lang.Throwable -> L9e
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L9e
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9e
            a(r11, r12, r13, r4)     // Catch: java.lang.Throwable -> L9e
            r11 = r4[r2]     // Catch: java.lang.Throwable -> L9e
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L9e
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch: java.lang.Throwable -> L9e
            byte[] r12 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L9e
            r12 = r12[r0]     // Catch: java.lang.Throwable -> L9e
            int r12 = -r12
            byte r12 = (byte) r12     // Catch: java.lang.Throwable -> L9e
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L9e
            byte r0 = (byte) r13     // Catch: java.lang.Throwable -> L9e
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9e
            a(r12, r13, r0, r3)     // Catch: java.lang.Throwable -> L9e
            r12 = r3[r2]     // Catch: java.lang.Throwable -> L9e
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L9e
            java.lang.reflect.Method r11 = r11.getMethod(r12, r1)     // Catch: java.lang.Throwable -> L9e
            java.lang.Object r11 = r11.invoke(r1, r1)     // Catch: java.lang.Throwable -> L9e
            java.lang.Thread r11 = (java.lang.Thread) r11     // Catch: java.lang.Throwable -> L9e
            r11.interrupt()
            goto La7
        L9e:
            r10 = move-exception
            java.lang.Throwable r11 = r10.getCause()
            if (r11 == 0) goto La6
            throw r11
        La6:
            throw r10
        La7:
            goto La9
        La8:
            throw r10
        La9:
            goto La8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Uninterruptibles.joinUninterruptibly(java.lang.Thread, long, java.util.concurrent.TimeUnit):void");
    }

    @ParametricNullness
    public static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    try {
                        byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
                        byte b2 = b;
                        Object[] objArr = new Object[1];
                        a(b, b2, b2, objArr);
                        Class<?> cls = Class.forName((String) objArr[0]);
                        byte b3 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                        byte b4 = b3;
                        Object[] objArr2 = new Object[1];
                        a(b3, b4, b4, objArr2);
                        ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                    } catch (Throwable th2) {
                        Throwable cause = th2.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th2;
                    }
                }
                throw th;
            }
        }
        if (z) {
            try {
                byte b5 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
                byte b6 = b5;
                Object[] objArr3 = new Object[1];
                a(b5, b6, b6, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b7 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                byte b8 = b7;
                Object[] objArr4 = new Object[1];
                a(b7, b8, b8, objArr4);
                ((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).interrupt();
            } catch (Throwable th3) {
                Throwable cause2 = th3.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th3;
            }
        }
        return v;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @com.google.common.util.concurrent.ParametricNullness
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <V> V getUninterruptibly(java.util.concurrent.Future<V> r10, long r11, java.util.concurrent.TimeUnit r13) throws java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        /*
            r0 = 15
            r1 = 0
            r2 = 0
            r3 = 1
            long r11 = r13.toNanos(r11)     // Catch: java.lang.Throwable -> L64
            long r4 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L64
            r6 = r11
            r13 = 0
        Lf:
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.Throwable -> L55 java.lang.InterruptedException -> L57
            java.lang.Object r10 = r10.get(r6, r8)     // Catch: java.lang.Throwable -> L55 java.lang.InterruptedException -> L57
            if (r13 == 0) goto L54
            byte[] r11 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L4b
            r11 = r11[r0]     // Catch: java.lang.Throwable -> L4b
            int r11 = r11 + r3
            byte r11 = (byte) r11     // Catch: java.lang.Throwable -> L4b
            byte r12 = (byte) r11     // Catch: java.lang.Throwable -> L4b
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L4b
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L4b
            a(r11, r12, r13, r4)     // Catch: java.lang.Throwable -> L4b
            r11 = r4[r2]     // Catch: java.lang.Throwable -> L4b
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L4b
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch: java.lang.Throwable -> L4b
            byte[] r12 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L4b
            r12 = r12[r0]     // Catch: java.lang.Throwable -> L4b
            int r12 = -r12
            byte r12 = (byte) r12     // Catch: java.lang.Throwable -> L4b
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L4b
            byte r0 = (byte) r13     // Catch: java.lang.Throwable -> L4b
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L4b
            a(r12, r13, r0, r3)     // Catch: java.lang.Throwable -> L4b
            r12 = r3[r2]     // Catch: java.lang.Throwable -> L4b
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L4b
            java.lang.reflect.Method r11 = r11.getMethod(r12, r1)     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r11 = r11.invoke(r1, r1)     // Catch: java.lang.Throwable -> L4b
            java.lang.Thread r11 = (java.lang.Thread) r11     // Catch: java.lang.Throwable -> L4b
            r11.interrupt()
            goto L54
        L4b:
            r10 = move-exception
            java.lang.Throwable r11 = r10.getCause()
            if (r11 == 0) goto L53
            throw r11
        L53:
            throw r10
        L54:
            return r10
        L55:
            r10 = move-exception
            goto L66
        L57:
            long r6 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L61
            long r8 = r4 + r11
            long r6 = r8 - r6
            r13 = 1
            goto Lf
        L61:
            r10 = move-exception
            r13 = 1
            goto L66
        L64:
            r10 = move-exception
            r13 = 0
        L66:
            if (r13 == 0) goto La5
            byte[] r11 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L9c
            r11 = r11[r0]     // Catch: java.lang.Throwable -> L9c
            int r11 = r11 + r3
            byte r11 = (byte) r11     // Catch: java.lang.Throwable -> L9c
            byte r12 = (byte) r11     // Catch: java.lang.Throwable -> L9c
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L9c
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9c
            a(r11, r12, r13, r4)     // Catch: java.lang.Throwable -> L9c
            r11 = r4[r2]     // Catch: java.lang.Throwable -> L9c
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L9c
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch: java.lang.Throwable -> L9c
            byte[] r12 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L9c
            r12 = r12[r0]     // Catch: java.lang.Throwable -> L9c
            int r12 = -r12
            byte r12 = (byte) r12     // Catch: java.lang.Throwable -> L9c
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L9c
            byte r0 = (byte) r13     // Catch: java.lang.Throwable -> L9c
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9c
            a(r12, r13, r0, r3)     // Catch: java.lang.Throwable -> L9c
            r12 = r3[r2]     // Catch: java.lang.Throwable -> L9c
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L9c
            java.lang.reflect.Method r11 = r11.getMethod(r12, r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r11 = r11.invoke(r1, r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.Thread r11 = (java.lang.Thread) r11     // Catch: java.lang.Throwable -> L9c
            r11.interrupt()
            goto La5
        L9c:
            r10 = move-exception
            java.lang.Throwable r11 = r10.getCause()
            if (r11 == 0) goto La4
            throw r11
        La4:
            throw r10
        La5:
            goto La7
        La6:
            throw r10
        La7:
            goto La6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Uninterruptibles.getUninterruptibly(java.util.concurrent.Future, long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    public static <E> E takeUninterruptibly(BlockingQueue<E> blockingQueue) {
        E take;
        boolean z = false;
        while (true) {
            try {
                take = blockingQueue.take();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    try {
                        byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
                        byte b2 = b;
                        Object[] objArr = new Object[1];
                        a(b, b2, b2, objArr);
                        Class<?> cls = Class.forName((String) objArr[0]);
                        byte b3 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                        byte b4 = b3;
                        Object[] objArr2 = new Object[1];
                        a(b3, b4, b4, objArr2);
                        ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                    } catch (Throwable th2) {
                        Throwable cause = th2.getCause();
                        if (cause != null) {
                            throw cause;
                        }
                        throw th2;
                    }
                }
                throw th;
            }
        }
        if (z) {
            try {
                byte b5 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
                byte b6 = b5;
                Object[] objArr3 = new Object[1];
                a(b5, b6, b6, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b7 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                byte b8 = b7;
                Object[] objArr4 = new Object[1];
                a(b7, b8, b8, objArr4);
                ((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).interrupt();
            } catch (Throwable th3) {
                Throwable cause2 = th3.getCause();
                if (cause2 != null) {
                    throw cause2;
                }
                throw th3;
            }
        }
        return take;
    }

    public static <E> void putUninterruptibly(BlockingQueue<E> blockingQueue, E e) {
        boolean z = false;
        while (true) {
            try {
                blockingQueue.put(e);
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    try {
                        byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
                        byte b2 = b;
                        Object[] objArr = new Object[1];
                        a(b, b2, b2, objArr);
                        Class<?> cls = Class.forName((String) objArr[0]);
                        byte b3 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                        byte b4 = b3;
                        Object[] objArr2 = new Object[1];
                        a(b3, b4, b4, objArr2);
                        ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
                    } catch (Throwable th2) {
                        Throwable cause = th2.getCause();
                        if (cause == null) {
                            throw th2;
                        }
                        throw cause;
                    }
                }
                throw th;
            }
        }
        if (z) {
            try {
                byte b5 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
                byte b6 = b5;
                Object[] objArr3 = new Object[1];
                a(b5, b6, b6, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                byte b7 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                byte b8 = b7;
                Object[] objArr4 = new Object[1];
                a(b7, b8, b8, objArr4);
                ((Thread) cls2.getMethod((String) objArr4[0], null).invoke(null, null)).interrupt();
            } catch (Throwable th3) {
                Throwable cause2 = th3.getCause();
                if (cause2 == null) {
                    throw th3;
                }
                throw cause2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void sleepUninterruptibly(long r10, java.util.concurrent.TimeUnit r12) {
        /*
            r0 = 15
            r1 = 0
            r2 = 0
            r3 = 1
            long r10 = r12.toNanos(r10)     // Catch: java.lang.Throwable -> L63
            long r4 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L63
            r6 = r10
            r12 = 0
        Lf:
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.Throwable -> L54 java.lang.InterruptedException -> L56
            r8.sleep(r6)     // Catch: java.lang.Throwable -> L54 java.lang.InterruptedException -> L56
            if (r12 == 0) goto L53
            byte[] r10 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L4a
            r10 = r10[r0]     // Catch: java.lang.Throwable -> L4a
            int r10 = r10 + r3
            byte r10 = (byte) r10     // Catch: java.lang.Throwable -> L4a
            byte r11 = (byte) r10     // Catch: java.lang.Throwable -> L4a
            byte r12 = (byte) r11     // Catch: java.lang.Throwable -> L4a
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L4a
            a(r10, r11, r12, r4)     // Catch: java.lang.Throwable -> L4a
            r10 = r4[r2]     // Catch: java.lang.Throwable -> L4a
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Throwable -> L4a
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch: java.lang.Throwable -> L4a
            byte[] r11 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L4a
            r11 = r11[r0]     // Catch: java.lang.Throwable -> L4a
            int r11 = -r11
            byte r11 = (byte) r11     // Catch: java.lang.Throwable -> L4a
            byte r12 = (byte) r11     // Catch: java.lang.Throwable -> L4a
            byte r0 = (byte) r12     // Catch: java.lang.Throwable -> L4a
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L4a
            a(r11, r12, r0, r3)     // Catch: java.lang.Throwable -> L4a
            r11 = r3[r2]     // Catch: java.lang.Throwable -> L4a
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L4a
            java.lang.reflect.Method r10 = r10.getMethod(r11, r1)     // Catch: java.lang.Throwable -> L4a
            java.lang.Object r10 = r10.invoke(r1, r1)     // Catch: java.lang.Throwable -> L4a
            java.lang.Thread r10 = (java.lang.Thread) r10     // Catch: java.lang.Throwable -> L4a
            r10.interrupt()
            goto L53
        L4a:
            r10 = move-exception
            java.lang.Throwable r11 = r10.getCause()
            if (r11 == 0) goto L52
            throw r11
        L52:
            throw r10
        L53:
            return
        L54:
            r10 = move-exception
            goto L65
        L56:
            long r6 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L60
            long r8 = r4 + r10
            long r6 = r8 - r6
            r12 = 1
            goto Lf
        L60:
            r10 = move-exception
            r12 = 1
            goto L65
        L63:
            r10 = move-exception
            r12 = 0
        L65:
            if (r12 == 0) goto La4
            byte[] r11 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L9b
            r11 = r11[r0]     // Catch: java.lang.Throwable -> L9b
            int r11 = r11 + r3
            byte r11 = (byte) r11     // Catch: java.lang.Throwable -> L9b
            byte r12 = (byte) r11     // Catch: java.lang.Throwable -> L9b
            byte r4 = (byte) r12     // Catch: java.lang.Throwable -> L9b
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9b
            a(r11, r12, r4, r5)     // Catch: java.lang.Throwable -> L9b
            r11 = r5[r2]     // Catch: java.lang.Throwable -> L9b
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L9b
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch: java.lang.Throwable -> L9b
            byte[] r12 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L9b
            r12 = r12[r0]     // Catch: java.lang.Throwable -> L9b
            int r12 = -r12
            byte r12 = (byte) r12     // Catch: java.lang.Throwable -> L9b
            byte r0 = (byte) r12     // Catch: java.lang.Throwable -> L9b
            byte r4 = (byte) r0     // Catch: java.lang.Throwable -> L9b
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9b
            a(r12, r0, r4, r3)     // Catch: java.lang.Throwable -> L9b
            r12 = r3[r2]     // Catch: java.lang.Throwable -> L9b
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L9b
            java.lang.reflect.Method r11 = r11.getMethod(r12, r1)     // Catch: java.lang.Throwable -> L9b
            java.lang.Object r11 = r11.invoke(r1, r1)     // Catch: java.lang.Throwable -> L9b
            java.lang.Thread r11 = (java.lang.Thread) r11     // Catch: java.lang.Throwable -> L9b
            r11.interrupt()
            goto La4
        L9b:
            r10 = move-exception
            java.lang.Throwable r11 = r10.getCause()
            if (r11 == 0) goto La3
            throw r11
        La3:
            throw r10
        La4:
            goto La6
        La5:
            throw r10
        La6:
            goto La5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Uninterruptibles.sleepUninterruptibly(long, java.util.concurrent.TimeUnit):void");
    }

    public static boolean tryAcquireUninterruptibly(Semaphore semaphore, long j, TimeUnit timeUnit) {
        return tryAcquireUninterruptibly(semaphore, 1, j, timeUnit);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean tryAcquireUninterruptibly(java.util.concurrent.Semaphore r10, int r11, long r12, java.util.concurrent.TimeUnit r14) {
        /*
            r0 = 15
            r1 = 0
            r2 = 0
            r3 = 1
            long r12 = r14.toNanos(r12)     // Catch: java.lang.Throwable -> L64
            long r4 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L64
            r6 = r12
            r14 = 0
        Lf:
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.Throwable -> L55 java.lang.InterruptedException -> L57
            boolean r10 = r10.tryAcquire(r11, r6, r8)     // Catch: java.lang.Throwable -> L55 java.lang.InterruptedException -> L57
            if (r14 == 0) goto L54
            byte[] r11 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L4b
            r11 = r11[r0]     // Catch: java.lang.Throwable -> L4b
            int r11 = r11 + r3
            byte r11 = (byte) r11     // Catch: java.lang.Throwable -> L4b
            byte r12 = (byte) r11     // Catch: java.lang.Throwable -> L4b
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L4b
            java.lang.Object[] r14 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L4b
            a(r11, r12, r13, r14)     // Catch: java.lang.Throwable -> L4b
            r11 = r14[r2]     // Catch: java.lang.Throwable -> L4b
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L4b
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch: java.lang.Throwable -> L4b
            byte[] r12 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L4b
            r12 = r12[r0]     // Catch: java.lang.Throwable -> L4b
            int r12 = -r12
            byte r12 = (byte) r12     // Catch: java.lang.Throwable -> L4b
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L4b
            byte r14 = (byte) r13     // Catch: java.lang.Throwable -> L4b
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L4b
            a(r12, r13, r14, r0)     // Catch: java.lang.Throwable -> L4b
            r12 = r0[r2]     // Catch: java.lang.Throwable -> L4b
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L4b
            java.lang.reflect.Method r11 = r11.getMethod(r12, r1)     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r11 = r11.invoke(r1, r1)     // Catch: java.lang.Throwable -> L4b
            java.lang.Thread r11 = (java.lang.Thread) r11     // Catch: java.lang.Throwable -> L4b
            r11.interrupt()
            goto L54
        L4b:
            r10 = move-exception
            java.lang.Throwable r11 = r10.getCause()
            if (r11 == 0) goto L53
            throw r11
        L53:
            throw r10
        L54:
            return r10
        L55:
            r10 = move-exception
            goto L66
        L57:
            long r6 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L61
            long r8 = r4 + r12
            long r6 = r8 - r6
            r14 = 1
            goto Lf
        L61:
            r10 = move-exception
            r14 = 1
            goto L66
        L64:
            r10 = move-exception
            r14 = 0
        L66:
            if (r14 == 0) goto La5
            byte[] r11 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L9c
            r11 = r11[r0]     // Catch: java.lang.Throwable -> L9c
            int r11 = r11 + r3
            byte r11 = (byte) r11     // Catch: java.lang.Throwable -> L9c
            byte r12 = (byte) r11     // Catch: java.lang.Throwable -> L9c
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L9c
            java.lang.Object[] r14 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9c
            a(r11, r12, r13, r14)     // Catch: java.lang.Throwable -> L9c
            r11 = r14[r2]     // Catch: java.lang.Throwable -> L9c
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L9c
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch: java.lang.Throwable -> L9c
            byte[] r12 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L9c
            r12 = r12[r0]     // Catch: java.lang.Throwable -> L9c
            int r12 = -r12
            byte r12 = (byte) r12     // Catch: java.lang.Throwable -> L9c
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L9c
            byte r14 = (byte) r13     // Catch: java.lang.Throwable -> L9c
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9c
            a(r12, r13, r14, r0)     // Catch: java.lang.Throwable -> L9c
            r12 = r0[r2]     // Catch: java.lang.Throwable -> L9c
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L9c
            java.lang.reflect.Method r11 = r11.getMethod(r12, r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r11 = r11.invoke(r1, r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.Thread r11 = (java.lang.Thread) r11     // Catch: java.lang.Throwable -> L9c
            r11.interrupt()
            goto La5
        L9c:
            r10 = move-exception
            java.lang.Throwable r11 = r10.getCause()
            if (r11 == 0) goto La4
            throw r11
        La4:
            throw r10
        La5:
            goto La7
        La6:
            throw r10
        La7:
            goto La6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Uninterruptibles.tryAcquireUninterruptibly(java.util.concurrent.Semaphore, int, long, java.util.concurrent.TimeUnit):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean tryLockUninterruptibly(java.util.concurrent.locks.Lock r10, long r11, java.util.concurrent.TimeUnit r13) {
        /*
            r0 = 15
            r1 = 0
            r2 = 0
            r3 = 1
            long r11 = r13.toNanos(r11)     // Catch: java.lang.Throwable -> L64
            long r4 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L64
            r6 = r11
            r13 = 0
        Lf:
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.Throwable -> L55 java.lang.InterruptedException -> L57
            boolean r10 = r10.tryLock(r6, r8)     // Catch: java.lang.Throwable -> L55 java.lang.InterruptedException -> L57
            if (r13 == 0) goto L54
            byte[] r11 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L4b
            r11 = r11[r0]     // Catch: java.lang.Throwable -> L4b
            int r11 = r11 + r3
            byte r11 = (byte) r11     // Catch: java.lang.Throwable -> L4b
            byte r12 = (byte) r11     // Catch: java.lang.Throwable -> L4b
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L4b
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L4b
            a(r11, r12, r13, r4)     // Catch: java.lang.Throwable -> L4b
            r11 = r4[r2]     // Catch: java.lang.Throwable -> L4b
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L4b
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch: java.lang.Throwable -> L4b
            byte[] r12 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L4b
            r12 = r12[r0]     // Catch: java.lang.Throwable -> L4b
            int r12 = -r12
            byte r12 = (byte) r12     // Catch: java.lang.Throwable -> L4b
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L4b
            byte r0 = (byte) r13     // Catch: java.lang.Throwable -> L4b
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L4b
            a(r12, r13, r0, r3)     // Catch: java.lang.Throwable -> L4b
            r12 = r3[r2]     // Catch: java.lang.Throwable -> L4b
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L4b
            java.lang.reflect.Method r11 = r11.getMethod(r12, r1)     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r11 = r11.invoke(r1, r1)     // Catch: java.lang.Throwable -> L4b
            java.lang.Thread r11 = (java.lang.Thread) r11     // Catch: java.lang.Throwable -> L4b
            r11.interrupt()
            goto L54
        L4b:
            r10 = move-exception
            java.lang.Throwable r11 = r10.getCause()
            if (r11 == 0) goto L53
            throw r11
        L53:
            throw r10
        L54:
            return r10
        L55:
            r10 = move-exception
            goto L66
        L57:
            long r6 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L61
            long r8 = r4 + r11
            long r6 = r8 - r6
            r13 = 1
            goto Lf
        L61:
            r10 = move-exception
            r13 = 1
            goto L66
        L64:
            r10 = move-exception
            r13 = 0
        L66:
            if (r13 == 0) goto La5
            byte[] r11 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L9c
            r11 = r11[r0]     // Catch: java.lang.Throwable -> L9c
            int r11 = r11 + r3
            byte r11 = (byte) r11     // Catch: java.lang.Throwable -> L9c
            byte r12 = (byte) r11     // Catch: java.lang.Throwable -> L9c
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L9c
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9c
            a(r11, r12, r13, r4)     // Catch: java.lang.Throwable -> L9c
            r11 = r4[r2]     // Catch: java.lang.Throwable -> L9c
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L9c
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch: java.lang.Throwable -> L9c
            byte[] r12 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L9c
            r12 = r12[r0]     // Catch: java.lang.Throwable -> L9c
            int r12 = -r12
            byte r12 = (byte) r12     // Catch: java.lang.Throwable -> L9c
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L9c
            byte r0 = (byte) r13     // Catch: java.lang.Throwable -> L9c
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9c
            a(r12, r13, r0, r3)     // Catch: java.lang.Throwable -> L9c
            r12 = r3[r2]     // Catch: java.lang.Throwable -> L9c
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L9c
            java.lang.reflect.Method r11 = r11.getMethod(r12, r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r11 = r11.invoke(r1, r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.Thread r11 = (java.lang.Thread) r11     // Catch: java.lang.Throwable -> L9c
            r11.interrupt()
            goto La5
        L9c:
            r10 = move-exception
            java.lang.Throwable r11 = r10.getCause()
            if (r11 == 0) goto La4
            throw r11
        La4:
            throw r10
        La5:
            goto La7
        La6:
            throw r10
        La7:
            goto La6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Uninterruptibles.tryLockUninterruptibly(java.util.concurrent.locks.Lock, long, java.util.concurrent.TimeUnit):boolean");
    }

    public static void awaitTerminationUninterruptibly(ExecutorService executorService) {
        Verify.verify(awaitTerminationUninterruptibly(executorService, LongCompanionObject.MAX_VALUE, TimeUnit.NANOSECONDS));
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean awaitTerminationUninterruptibly(java.util.concurrent.ExecutorService r10, long r11, java.util.concurrent.TimeUnit r13) {
        /*
            r0 = 15
            r1 = 0
            r2 = 0
            r3 = 1
            long r11 = r13.toNanos(r11)     // Catch: java.lang.Throwable -> L64
            long r4 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L64
            r6 = r11
            r13 = 0
        Lf:
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.Throwable -> L55 java.lang.InterruptedException -> L57
            boolean r10 = r10.awaitTermination(r6, r8)     // Catch: java.lang.Throwable -> L55 java.lang.InterruptedException -> L57
            if (r13 == 0) goto L54
            byte[] r11 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L4b
            r11 = r11[r0]     // Catch: java.lang.Throwable -> L4b
            int r11 = r11 + r3
            byte r11 = (byte) r11     // Catch: java.lang.Throwable -> L4b
            byte r12 = (byte) r11     // Catch: java.lang.Throwable -> L4b
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L4b
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L4b
            a(r11, r12, r13, r4)     // Catch: java.lang.Throwable -> L4b
            r11 = r4[r2]     // Catch: java.lang.Throwable -> L4b
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L4b
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch: java.lang.Throwable -> L4b
            byte[] r12 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L4b
            r12 = r12[r0]     // Catch: java.lang.Throwable -> L4b
            int r12 = -r12
            byte r12 = (byte) r12     // Catch: java.lang.Throwable -> L4b
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L4b
            byte r0 = (byte) r13     // Catch: java.lang.Throwable -> L4b
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L4b
            a(r12, r13, r0, r3)     // Catch: java.lang.Throwable -> L4b
            r12 = r3[r2]     // Catch: java.lang.Throwable -> L4b
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L4b
            java.lang.reflect.Method r11 = r11.getMethod(r12, r1)     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r11 = r11.invoke(r1, r1)     // Catch: java.lang.Throwable -> L4b
            java.lang.Thread r11 = (java.lang.Thread) r11     // Catch: java.lang.Throwable -> L4b
            r11.interrupt()
            goto L54
        L4b:
            r10 = move-exception
            java.lang.Throwable r11 = r10.getCause()
            if (r11 == 0) goto L53
            throw r11
        L53:
            throw r10
        L54:
            return r10
        L55:
            r10 = move-exception
            goto L66
        L57:
            long r6 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L61
            long r8 = r4 + r11
            long r6 = r8 - r6
            r13 = 1
            goto Lf
        L61:
            r10 = move-exception
            r13 = 1
            goto L66
        L64:
            r10 = move-exception
            r13 = 0
        L66:
            if (r13 == 0) goto La5
            byte[] r11 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L9c
            r11 = r11[r0]     // Catch: java.lang.Throwable -> L9c
            int r11 = r11 + r3
            byte r11 = (byte) r11     // Catch: java.lang.Throwable -> L9c
            byte r12 = (byte) r11     // Catch: java.lang.Throwable -> L9c
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L9c
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9c
            a(r11, r12, r13, r4)     // Catch: java.lang.Throwable -> L9c
            r11 = r4[r2]     // Catch: java.lang.Throwable -> L9c
            java.lang.String r11 = (java.lang.String) r11     // Catch: java.lang.Throwable -> L9c
            java.lang.Class r11 = java.lang.Class.forName(r11)     // Catch: java.lang.Throwable -> L9c
            byte[] r12 = com.google.common.util.concurrent.Uninterruptibles.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Throwable -> L9c
            r12 = r12[r0]     // Catch: java.lang.Throwable -> L9c
            int r12 = -r12
            byte r12 = (byte) r12     // Catch: java.lang.Throwable -> L9c
            byte r13 = (byte) r12     // Catch: java.lang.Throwable -> L9c
            byte r0 = (byte) r13     // Catch: java.lang.Throwable -> L9c
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L9c
            a(r12, r13, r0, r3)     // Catch: java.lang.Throwable -> L9c
            r12 = r3[r2]     // Catch: java.lang.Throwable -> L9c
            java.lang.String r12 = (java.lang.String) r12     // Catch: java.lang.Throwable -> L9c
            java.lang.reflect.Method r11 = r11.getMethod(r12, r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.Object r11 = r11.invoke(r1, r1)     // Catch: java.lang.Throwable -> L9c
            java.lang.Thread r11 = (java.lang.Thread) r11     // Catch: java.lang.Throwable -> L9c
            r11.interrupt()
            goto La5
        L9c:
            r10 = move-exception
            java.lang.Throwable r11 = r10.getCause()
            if (r11 == 0) goto La4
            throw r11
        La4:
            throw r10
        La5:
            goto La7
        La6:
            throw r10
        La7:
            goto La6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.Uninterruptibles.awaitTerminationUninterruptibly(java.util.concurrent.ExecutorService, long, java.util.concurrent.TimeUnit):boolean");
    }

    private Uninterruptibles() {
    }
}
