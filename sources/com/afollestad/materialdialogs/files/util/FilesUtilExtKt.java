package com.afollestad.materialdialogs.files.util;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.afollestad.materialdialogs.MaterialDialog;
import com.ap.zoloz.hummer.biz.HummerConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u001aA\u0010\b\u001a\u0004\u0018\u00010\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\u000b\u001a\u0006*\u00020\n0\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a?\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001b\u0010\u0010\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0013\u0010\u0013\u001a\u00020\u0003*\u00020\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0013\u0010\u0015\u001a\u00020\u0003*\u00020\u0012H\u0000¢\u0006\u0004\b\u0015\u0010\u0014\u001a\u001b\u0010\u0016\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0013\u0010\u0018\u001a\u00020\u0003*\u00020\u0000H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001b\u0010\u001a\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u001a\u0010\u001b"}, d2 = {"Ljava/io/File;", "Landroid/content/Context;", HummerConstants.CONTEXT, "", "writeable", "Lkotlin/Function1;", "Lcom/afollestad/materialdialogs/files/FileFilter;", "filter", "betterParent", "(Ljava/io/File;Landroid/content/Context;ZLkotlin/jvm/functions/Function1;)Ljava/io/File;", "", "friendlyName", "(Ljava/io/File;Landroid/content/Context;)Ljava/lang/String;", "hasParent", "(Ljava/io/File;Landroid/content/Context;ZLkotlin/jvm/functions/Function1;)Z", "permission", "hasPermission", "(Landroid/content/Context;Ljava/lang/String;)Z", "Lcom/afollestad/materialdialogs/MaterialDialog;", "hasReadStoragePermission", "(Lcom/afollestad/materialdialogs/MaterialDialog;)Z", "hasWriteStoragePermission", "isExternalStorage", "(Ljava/io/File;Landroid/content/Context;)Z", "isRoot", "(Ljava/io/File;)Z", "jumpOverEmulated", "(Ljava/io/File;Landroid/content/Context;)Ljava/io/File;"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class FilesUtilExtKt {
    public static final boolean hasParent(File file, Context context, boolean z, Function1<? super File, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(file, "");
        Intrinsics.checkParameterIsNotNull(context, "");
        return betterParent(file, context, z, function1) != null;
    }

    public static final boolean isExternalStorage(File file, Context context) {
        Intrinsics.checkParameterIsNotNull(file, "");
        Intrinsics.checkParameterIsNotNull(context, "");
        String absolutePath = file.getAbsolutePath();
        File externalFilesDir = ContextExtKt.getExternalFilesDir(context);
        return Intrinsics.areEqual(absolutePath, externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null);
    }

    public static final boolean isRoot(File file) {
        Intrinsics.checkParameterIsNotNull(file, "");
        return Intrinsics.areEqual(file.getAbsolutePath(), "/");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.io.File betterParent(java.io.File r6, android.content.Context r7, boolean r8, kotlin.jvm.functions.Function1<? super java.io.File, java.lang.Boolean> r9) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r6, r0)
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r7, r0)
            boolean r1 = isExternalStorage(r6, r7)
            r2 = 0
            if (r1 == 0) goto L1d
            java.io.File r6 = com.afollestad.materialdialogs.files.util.ContextExtKt.getExternalFilesDir(r7)
            if (r6 == 0) goto L1b
            java.io.File r6 = r6.getParentFile()
            if (r6 != 0) goto L1d
        L1b:
            r6 = r2
            goto L21
        L1d:
            java.io.File r6 = r6.getParentFile()
        L21:
            if (r6 == 0) goto L6f
            if (r8 == 0) goto L2b
            boolean r7 = r6.canWrite()
            if (r7 == 0) goto L31
        L2b:
            boolean r7 = r6.canRead()
            if (r7 != 0) goto L32
        L31:
            return r2
        L32:
            java.io.File[] r7 = r6.listFiles()
            if (r7 == 0) goto L63
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            int r1 = r7.length
            r3 = 0
        L41:
            if (r3 >= r1) goto L60
            r4 = r7[r3]
            if (r9 == 0) goto L57
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r0)
            java.lang.Object r5 = r9.invoke(r4)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            if (r5 == 0) goto L57
            boolean r5 = r5.booleanValue()
            goto L58
        L57:
            r5 = 1
        L58:
            if (r5 == 0) goto L5d
            r8.add(r4)
        L5d:
            int r3 = r3 + 1
            goto L41
        L60:
            java.util.List r8 = (java.util.List) r8
            goto L67
        L63:
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
        L67:
            boolean r7 = r8.isEmpty()
            if (r7 == 0) goto L6e
            return r2
        L6e:
            return r6
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.files.util.FilesUtilExtKt.betterParent(java.io.File, android.content.Context, boolean, kotlin.jvm.functions.Function1):java.io.File");
    }

    public static final File jumpOverEmulated(File file, Context context) {
        File parentFile;
        Intrinsics.checkParameterIsNotNull(file, "");
        Intrinsics.checkParameterIsNotNull(context, "");
        File externalFilesDir = ContextExtKt.getExternalFilesDir(context);
        return (externalFilesDir == null || (parentFile = externalFilesDir.getParentFile()) == null || !Intrinsics.areEqual(file.getAbsolutePath(), parentFile.getAbsolutePath())) ? file : externalFilesDir;
    }

    public static final String friendlyName(File file, Context context) {
        Intrinsics.checkParameterIsNotNull(file, "");
        Intrinsics.checkParameterIsNotNull(context, "");
        return isExternalStorage(file, context) ? "External Storage" : isRoot(file) ? "Root" : file.getName();
    }

    public static final boolean hasPermission(Context context, String str) {
        Intrinsics.checkParameterIsNotNull(context, "");
        Intrinsics.checkParameterIsNotNull(str, "");
        return ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(context, str) == 0;
    }

    public static final boolean hasReadStoragePermission(MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        return hasPermission(materialDialog.getWindowContext(), "android.permission.READ_EXTERNAL_STORAGE");
    }

    public static final boolean hasWriteStoragePermission(MaterialDialog materialDialog) {
        Intrinsics.checkParameterIsNotNull(materialDialog, "");
        return hasPermission(materialDialog.getWindowContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }
}
