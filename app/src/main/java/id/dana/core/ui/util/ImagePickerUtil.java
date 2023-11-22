package id.dana.core.ui.util;

import android.content.Intent;
import android.provider.MediaStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/core/ui/util/ImagePickerUtil;", "", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "()Landroid/content/Intent;", "Landroid/content/Context;", "p0", "Landroid/net/Uri;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;)Landroid/net/Uri;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ImagePickerUtil {
    public static final ImagePickerUtil INSTANCE = new ImagePickerUtil();

    private ImagePickerUtil() {
    }

    public static Intent MyBillsEntityDataFactory() {
        Intent type = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI).setType("image/*");
        Intrinsics.checkNotNullExpressionValue(type, "");
        return type;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0066 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri KClassImpl$Data$declaredNonStaticMembers$2(android.content.Context r6) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r1 = 0
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch: java.io.IOException -> L49
            java.lang.String r3 = "yyyyMMdd_HHmmss"
            r2.<init>(r3)     // Catch: java.io.IOException -> L49
            java.util.Date r3 = new java.util.Date     // Catch: java.io.IOException -> L49
            r3.<init>()     // Catch: java.io.IOException -> L49
            java.lang.String r2 = r2.format(r3)     // Catch: java.io.IOException -> L49
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L49
            r3.<init>()     // Catch: java.io.IOException -> L49
            java.lang.String r4 = "JPEG_"
            r3.append(r4)     // Catch: java.io.IOException -> L49
            r3.append(r2)     // Catch: java.io.IOException -> L49
            r2 = 95
            r3.append(r2)     // Catch: java.io.IOException -> L49
            java.lang.String r2 = r3.toString()     // Catch: java.io.IOException -> L49
            java.lang.String r3 = android.os.Environment.DIRECTORY_PICTURES     // Catch: java.io.IOException -> L49
            java.io.File[] r3 = androidx.core.content.ContextCompat.getAuthRequestContext(r6, r3)     // Catch: java.io.IOException -> L49
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)     // Catch: java.io.IOException -> L49
            int r0 = r3.length     // Catch: java.io.IOException -> L49
            r4 = 1
            r5 = 0
            if (r0 != 0) goto L3c
            r0 = 1
            goto L3d
        L3c:
            r0 = 0
        L3d:
            r0 = r0 ^ r4
            if (r0 == 0) goto L49
            r0 = r3[r5]     // Catch: java.io.IOException -> L49
            java.lang.String r3 = ".jpg"
            java.io.File r0 = java.io.File.createTempFile(r2, r3, r0)     // Catch: java.io.IOException -> L49
            goto L4a
        L49:
            r0 = r1
        L4a:
            if (r0 == 0) goto L66
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r6.getPackageName()
            r1.append(r2)
            java.lang.String r2 = ".provider"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.net.Uri r6 = androidx.core.content.FileProvider.getUriForFile(r6, r1, r0)
            return r6
        L66:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.core.ui.util.ImagePickerUtil.KClassImpl$Data$declaredNonStaticMembers$2(android.content.Context):android.net.Uri");
    }
}
