package timber.log;

import android.os.Build;
import com.google.common.base.Ascii;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class Timber {
    public static volatile Tree[] MyBillsEntityDataFactory;
    private static final Tree[] PlaceComponentResult;
    public static final List<Tree> getAuthRequestContext = new ArrayList();
    public static final Tree BuiltInFictitiousFunctionClassFactory = new Tree() { // from class: timber.log.Timber.1
        @Override // timber.log.Timber.Tree
        public final void KClassImpl$Data$declaredNonStaticMembers$2(String str, Object... objArr) {
            for (Tree tree : Timber.MyBillsEntityDataFactory) {
                tree.KClassImpl$Data$declaredNonStaticMembers$2(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void getAuthRequestContext(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.MyBillsEntityDataFactory) {
                tree.getAuthRequestContext(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void BuiltInFictitiousFunctionClassFactory(String str, Object... objArr) {
            for (Tree tree : Timber.MyBillsEntityDataFactory) {
                tree.BuiltInFictitiousFunctionClassFactory(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void PlaceComponentResult(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.MyBillsEntityDataFactory) {
                tree.PlaceComponentResult(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void PlaceComponentResult(String str, Object... objArr) {
            for (Tree tree : Timber.MyBillsEntityDataFactory) {
                tree.PlaceComponentResult(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void getAuthRequestContext(String str, Object... objArr) {
            for (Tree tree : Timber.MyBillsEntityDataFactory) {
                tree.getAuthRequestContext(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void BuiltInFictitiousFunctionClassFactory(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.MyBillsEntityDataFactory) {
                tree.BuiltInFictitiousFunctionClassFactory(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void getAuthRequestContext(Throwable th) {
            for (Tree tree : Timber.MyBillsEntityDataFactory) {
                tree.getAuthRequestContext(th);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void MyBillsEntityDataFactory(String str, Object... objArr) {
            for (Tree tree : Timber.MyBillsEntityDataFactory) {
                tree.MyBillsEntityDataFactory(str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th, String str, Object... objArr) {
            for (Tree tree : Timber.MyBillsEntityDataFactory) {
                tree.KClassImpl$Data$declaredNonStaticMembers$2(th, str, objArr);
            }
        }

        @Override // timber.log.Timber.Tree
        public final void MyBillsEntityDataFactory(Throwable th) {
            for (Tree tree : Timber.MyBillsEntityDataFactory) {
                tree.MyBillsEntityDataFactory(th);
            }
        }

        @Override // timber.log.Timber.Tree
        protected final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
            throw new AssertionError("Missing override for log method.");
        }
    };

    public static Tree getAuthRequestContext(String str) {
        for (Tree tree : MyBillsEntityDataFactory) {
            tree.PlaceComponentResult.set(str);
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    public static int BuiltInFictitiousFunctionClassFactory() {
        int size;
        List<Tree> list = getAuthRequestContext;
        synchronized (list) {
            size = list.size();
        }
        return size;
    }

    static {
        Tree[] treeArr = new Tree[0];
        PlaceComponentResult = treeArr;
        MyBillsEntityDataFactory = treeArr;
    }

    private Timber() {
        throw new AssertionError("No instances.");
    }

    /* loaded from: classes.dex */
    public static abstract class Tree {
        final ThreadLocal<String> PlaceComponentResult = new ThreadLocal<>();

        protected abstract void KClassImpl$Data$declaredNonStaticMembers$2(String str);

        String KClassImpl$Data$declaredNonStaticMembers$2() {
            String str = this.PlaceComponentResult.get();
            if (str != null) {
                this.PlaceComponentResult.remove();
            }
            return str;
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(String str, Object... objArr) {
            MyBillsEntityDataFactory(null, str, objArr);
        }

        public void getAuthRequestContext(Throwable th, String str, Object... objArr) {
            MyBillsEntityDataFactory(th, str, objArr);
        }

        public void BuiltInFictitiousFunctionClassFactory(String str, Object... objArr) {
            MyBillsEntityDataFactory(null, str, objArr);
        }

        public void PlaceComponentResult(Throwable th, String str, Object... objArr) {
            MyBillsEntityDataFactory(th, str, objArr);
        }

        public void PlaceComponentResult(String str, Object... objArr) {
            MyBillsEntityDataFactory(null, str, objArr);
        }

        public void getAuthRequestContext(String str, Object... objArr) {
            MyBillsEntityDataFactory(null, str, objArr);
        }

        public void BuiltInFictitiousFunctionClassFactory(Throwable th, String str, Object... objArr) {
            MyBillsEntityDataFactory(th, str, objArr);
        }

        public void getAuthRequestContext(Throwable th) {
            MyBillsEntityDataFactory(th, null, new Object[0]);
        }

        public void MyBillsEntityDataFactory(String str, Object... objArr) {
            MyBillsEntityDataFactory(null, str, objArr);
        }

        public void KClassImpl$Data$declaredNonStaticMembers$2(Throwable th, String str, Object... objArr) {
            MyBillsEntityDataFactory(th, str, objArr);
        }

        public void MyBillsEntityDataFactory(Throwable th) {
            MyBillsEntityDataFactory(th, null, new Object[0]);
        }

        private void MyBillsEntityDataFactory(Throwable th, String str, Object... objArr) {
            String str2;
            KClassImpl$Data$declaredNonStaticMembers$2();
            if (str != null && str.length() == 0) {
                str = null;
            }
            if (str != null) {
                if (objArr != null && objArr.length > 0) {
                    str = String.format(str, objArr);
                }
                if (th != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append("\n");
                    sb.append(PlaceComponentResult(th));
                    str2 = sb.toString();
                } else {
                    str2 = str;
                }
            } else if (th == null) {
                return;
            } else {
                str2 = PlaceComponentResult(th);
            }
            KClassImpl$Data$declaredNonStaticMembers$2(str2);
        }

        private static String PlaceComponentResult(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }
    }

    /* loaded from: classes2.dex */
    public static class DebugTree extends Tree {
        public static final byte[] MyBillsEntityDataFactory = {37, 81, 122, 15, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, Ascii.US, -21, 0, 6, -25, Ascii.FS, -19, 0, 0, -34, 37, -9, 6, -10, 7, 4, -4, 13, -51, 39, -13, 16, -2, -39, 17, 10, -10};
        public static final int BuiltInFictitiousFunctionClassFactory = 56;
        private static final Pattern getAuthRequestContext = Pattern.compile("(\\$\\d+)+$");

        /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0035). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(byte r7, byte r8, byte r9, java.lang.Object[] r10) {
            /*
                int r7 = r7 * 15
                int r7 = 27 - r7
                byte[] r0 = timber.log.Timber.DebugTree.MyBillsEntityDataFactory
                int r9 = r9 * 26
                int r9 = r9 + 4
                int r8 = r8 * 3
                int r8 = r8 + 103
                byte[] r1 = new byte[r7]
                r2 = 0
                if (r0 != 0) goto L1b
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r8
                r8 = r7
                goto L35
            L1b:
                r3 = 0
            L1c:
                int r4 = r3 + 1
                byte r5 = (byte) r8
                r1[r3] = r5
                if (r4 != r7) goto L2b
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L2b:
                r3 = r0[r9]
                r6 = r8
                r8 = r7
                r7 = r3
                r3 = r1
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r6
            L35:
                int r10 = r10 + 1
                int r9 = r9 + r7
                int r7 = r9 + 2
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r6 = r8
                r8 = r7
                r7 = r6
                goto L1c
            */
            throw new UnsupportedOperationException("Method not decompiled: timber.log.Timber.DebugTree.a(byte, byte, byte, java.lang.Object[]):void");
        }

        private static String KClassImpl$Data$declaredNonStaticMembers$2(StackTraceElement stackTraceElement) {
            try {
                byte b = MyBillsEntityDataFactory[16];
                Object[] objArr = new Object[1];
                a(b, (byte) (b + 1), MyBillsEntityDataFactory[16], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b2 = (byte) (MyBillsEntityDataFactory[16] + 1);
                byte b3 = MyBillsEntityDataFactory[16];
                Object[] objArr2 = new Object[1];
                a(b2, b3, (byte) (b3 + 1), objArr2);
                String str = (String) cls.getMethod((String) objArr2[0], null).invoke(stackTraceElement, null);
                Matcher matcher = getAuthRequestContext.matcher(str);
                if (matcher.find()) {
                    str = matcher.replaceAll("");
                }
                String substring = str.substring(str.lastIndexOf(46) + 1);
                return (substring.length() <= 23 || Build.VERSION.SDK_INT >= 24) ? substring : substring.substring(0, 23);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }

        @Override // timber.log.Timber.Tree
        final String KClassImpl$Data$declaredNonStaticMembers$2() {
            String KClassImpl$Data$declaredNonStaticMembers$2 = super.KClassImpl$Data$declaredNonStaticMembers$2();
            if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                return KClassImpl$Data$declaredNonStaticMembers$2;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length <= 5) {
                throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
            }
            return KClassImpl$Data$declaredNonStaticMembers$2(stackTrace[5]);
        }

        @Override // timber.log.Timber.Tree
        protected final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
            if (str.length() < 4000) {
            }
        }
    }
}
