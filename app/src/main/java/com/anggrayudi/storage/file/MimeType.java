package com.anggrayudi.storage.file;

import android.webkit.MimeTypeMap;
import com.alipay.mobile.zebra.ZebraLoader;
import com.anggrayudi.storage.extension.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005J\u0019\u0010\u0007\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0005J!\u0010\t\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\nJ\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0005J\u0019\u0010\u000b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u000b\u0010\u0005J\u0019\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\r\u0010\u000e"}, d2 = {"Lcom/anggrayudi/storage/file/MimeType;", "", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Ljava/lang/String;", "MyBillsEntityDataFactory", "PlaceComponentResult", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "getAuthRequestContext", "", "scheduleImpl", "(Ljava/lang/String;)Z", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class MimeType {
    public static final MimeType INSTANCE = new MimeType();

    private MimeType() {
    }

    @JvmStatic
    public static final String MyBillsEntityDataFactory(String p0, String p1) {
        String str = "";
        Intrinsics.checkNotNullParameter(p0, "");
        String authRequestContext = TextUtils.getAuthRequestContext(p0);
        if (Intrinsics.areEqual(p1, ZebraLoader.MIME_TYPE_STREAM) || Intrinsics.areEqual(p1, "*/*")) {
            if (scheduleImpl(authRequestContext)) {
                str = StringsKt.substringAfterLast(authRequestContext == null ? "" : authRequestContext, '.', "");
            }
            if (str.length() > 0) {
                return authRequestContext;
            }
        }
        String PlaceComponentResult = PlaceComponentResult(p1);
        if ((PlaceComponentResult.length() == 0) || StringsKt.endsWith$default(authRequestContext, Intrinsics.stringPlus(".", PlaceComponentResult), false, 2, (Object) null)) {
            return authRequestContext;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(authRequestContext);
        sb.append('.');
        sb.append(PlaceComponentResult);
        return StringsKt.trimEnd(sb.toString(), '.');
    }

    @JvmStatic
    private static String PlaceComponentResult(String p0) {
        String extensionFromMimeType;
        if (p0 == null) {
            extensionFromMimeType = null;
        } else {
            extensionFromMimeType = Intrinsics.areEqual(p0, ZebraLoader.MIME_TYPE_STREAM) ? "bin" : MimeTypeMap.getSingleton().getExtensionFromMimeType(p0);
        }
        return extensionFromMimeType == null ? "" : extensionFromMimeType;
    }

    @JvmStatic
    public static final String BuiltInFictitiousFunctionClassFactory(String p0) {
        if (!scheduleImpl(p0)) {
            return p0 == null ? "" : p0;
        }
        if (p0 == null) {
            p0 = "";
        }
        return StringsKt.substringBeforeLast$default(p0, '.', (String) null, 2, (Object) null);
    }

    @JvmStatic
    public static final String MyBillsEntityDataFactory(String p0) {
        if (scheduleImpl(p0)) {
            if (p0 == null) {
                p0 = "";
            }
            return StringsKt.substringAfterLast(p0, '.', "");
        }
        return "";
    }

    @JvmStatic
    private static boolean scheduleImpl(String p0) {
        if (p0 != null) {
            if (new Regex("(.*?)\\.[a-zA-Z0-9]+").matches(p0)) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final String KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1) {
        String str = "";
        Intrinsics.checkNotNullParameter(p1, "");
        if (p0 == null || Intrinsics.areEqual(p0, "*/*")) {
            if (scheduleImpl(p1)) {
                if (p1 == null) {
                    p1 = "";
                }
                str = StringsKt.substringAfterLast(p1, '.', "");
            }
            return str;
        }
        return PlaceComponentResult(p0);
    }

    @JvmStatic
    public static final String KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (Intrinsics.areEqual(p0, "bin")) {
            return ZebraLoader.MIME_TYPE_STREAM;
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(p0);
        return mimeTypeFromExtension == null ? "*/*" : mimeTypeFromExtension;
    }

    @JvmStatic
    public static final String getAuthRequestContext(String p0) {
        String str = "";
        if (scheduleImpl(p0)) {
            if (p0 == null) {
                p0 = "";
            }
            str = StringsKt.substringAfterLast(p0, '.', "");
        }
        return KClassImpl$Data$declaredNonStaticMembers$2(str);
    }
}
