package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0007\u0010\f"}, d2 = {"Landroidx/window/embedding/MatcherUtils;", "", "Landroid/app/Activity;", "p0", "Landroid/content/ComponentName;", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/app/Activity;Landroid/content/ComponentName;)Z", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/ComponentName;Landroid/content/ComponentName;)Z", "", "(Ljava/lang/String;Ljava/lang/String;)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MatcherUtils {
    public static final MatcherUtils INSTANCE = new MatcherUtils();

    private MatcherUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0082 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean BuiltInFictitiousFunctionClassFactory(android.content.ComponentName r7, android.content.ComponentName r8) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r1 = "*"
            r2 = 0
            r3 = 1
            if (r7 != 0) goto L22
            java.lang.String r7 = r8.getPackageName()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r1)
            if (r7 == 0) goto L21
            java.lang.String r7 = r8.getClassName()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r1)
            if (r7 != 0) goto L20
            goto L21
        L20:
            r2 = 1
        L21:
            return r2
        L22:
            java.lang.String r4 = r7.toString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r5 = 2
            r6 = 0
            boolean r1 = kotlin.text.StringsKt.contains$default(r4, r1, r2, r5, r6)
            r1 = r1 ^ r3
            if (r1 == 0) goto L86
            java.lang.String r1 = r7.getPackageName()
            java.lang.String r4 = r8.getPackageName()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r4)
            if (r1 != 0) goto L5a
            java.lang.String r1 = r7.getPackageName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            java.lang.String r4 = r8.getPackageName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            boolean r1 = KClassImpl$Data$declaredNonStaticMembers$2(r1, r4)
            if (r1 != 0) goto L5a
            r1 = 0
            goto L5b
        L5a:
            r1 = 1
        L5b:
            java.lang.String r4 = r7.getClassName()
            java.lang.String r5 = r8.getClassName()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r4 != 0) goto L7f
            java.lang.String r7 = r7.getClassName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            java.lang.String r8 = r8.getClassName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            boolean r7 = KClassImpl$Data$declaredNonStaticMembers$2(r7, r8)
            if (r7 != 0) goto L7f
            r7 = 0
            goto L80
        L7f:
            r7 = 1
        L80:
            if (r1 == 0) goto L85
            if (r7 == 0) goto L85
            r2 = 1
        L85:
            return r2
        L86:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Wildcard can only be part of the rule."
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.MatcherUtils.BuiltInFictitiousFunctionClassFactory(android.content.ComponentName, android.content.ComponentName):boolean");
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(Activity p0, ComponentName p1) {
        ComponentName component;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (BuiltInFictitiousFunctionClassFactory(p0.getComponentName(), p1)) {
            return true;
        }
        Intent intent = p0.getIntent();
        if (intent == null || (component = intent.getComponent()) == null) {
            return false;
        }
        return BuiltInFictitiousFunctionClassFactory(component, p1);
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
        String str = p1;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "*", false, 2, (Object) null)) {
            if (Intrinsics.areEqual(p1, "*")) {
                return true;
            }
            if (!(StringsKt.indexOf$default((CharSequence) str, "*", 0, false, 6, (Object) null) == StringsKt.lastIndexOf$default((CharSequence) str, "*", 0, false, 6, (Object) null) && StringsKt.endsWith$default(p1, "*", false, 2, (Object) null))) {
                throw new IllegalArgumentException("Name pattern with a wildcard must only contain a single wildcard in the end".toString());
            }
            String substring = p1.substring(0, p1.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            return StringsKt.startsWith$default(p0, substring, false, 2, (Object) null);
        }
        return false;
    }
}
