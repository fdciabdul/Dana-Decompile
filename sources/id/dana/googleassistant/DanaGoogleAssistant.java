package id.dana.googleassistant;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import id.dana.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0005\u001a\u00020\n*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u000f¢\u0006\u0004\b\u0005\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u0007*\u0004\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u0007*\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\b\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\b\u0010\u0015J\u0013\u0010\u0005\u001a\u00020\u0007*\u00020\u000eH\u0002¢\u0006\u0004\b\u0005\u0010\u0014J\u001b\u0010\u0013\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0015J\u0013\u0010\u0011\u001a\u00020\u0007*\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0014J\u0013\u0010\b\u001a\u00020\u0007*\u00020\u000eH\u0002¢\u0006\u0004\b\b\u0010\u0014J\u001b\u0010\u0005\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0005\u0010\u0015J\u0013\u0010\u000b\u001a\u00020\u0007*\u00020\u000eH\u0002¢\u0006\u0004\b\u000b\u0010\u0014J\u001b\u0010\u0011\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0016"}, d2 = {"Lid/dana/googleassistant/DanaGoogleAssistant;", "", "", "p0", "p1", "MyBillsEntityDataFactory", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "PlaceComponentResult", "()Z", "", "getAuthRequestContext", "(Z)V", "Landroid/content/Intent;", "Landroid/net/Uri;", "Landroid/content/Context;", "(Landroid/content/Intent;Landroid/net/Uri;Landroid/content/Context;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Intent;)Z", "BuiltInFictitiousFunctionClassFactory", "(Landroid/net/Uri;)Z", "(Ljava/lang/String;Landroid/content/Context;)Z", "Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DanaGoogleAssistant {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private static boolean PlaceComponentResult;
    public static final DanaGoogleAssistant INSTANCE = new DanaGoogleAssistant();

    private DanaGoogleAssistant() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0065, code lost:
    
        if (r8.equals("scan_qr") == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x006c, code lost:
    
        if (r8.equals("request_money") != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0073, code lost:
    
        if (r8.equals("send_money") != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0075, code lost:
    
        r8 = "source=VoiceAssistant";
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String MyBillsEntityDataFactory(java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "https://link.dana.id/"
            r1.append(r2)
            int r2 = r8.hashCode()
            java.lang.String r3 = "scan_qr"
            java.lang.String r4 = "request_money"
            java.lang.String r5 = "send_money"
            java.lang.String r6 = "search"
            java.lang.String r7 = "top_up"
            switch(r2) {
                case -906336856: goto L48;
                case -868043323: goto L3f;
                case 821988681: goto L36;
                case 1740443408: goto L2d;
                case 1910947619: goto L24;
                default: goto L23;
            }
        L23:
            goto L51
        L24:
            boolean r2 = r8.equals(r3)
            if (r2 == 0) goto L51
            java.lang.String r2 = "payqr"
            goto L52
        L2d:
            boolean r2 = r8.equals(r4)
            if (r2 == 0) goto L51
            java.lang.String r2 = "request-money"
            goto L52
        L36:
            boolean r2 = r8.equals(r5)
            if (r2 == 0) goto L51
            java.lang.String r2 = "sendmoney"
            goto L52
        L3f:
            boolean r2 = r8.equals(r7)
            if (r2 != 0) goto L46
            goto L51
        L46:
            r2 = r7
            goto L52
        L48:
            boolean r2 = r8.equals(r6)
            if (r2 == 0) goto L51
            java.lang.String r2 = "globalsearch"
            goto L52
        L51:
            r2 = r0
        L52:
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            int r2 = r8.hashCode()
            switch(r2) {
                case -906336856: goto L81;
                case -868043323: goto L78;
                case 821988681: goto L6f;
                case 1740443408: goto L68;
                case 1910947619: goto L61;
                default: goto L60;
            }
        L60:
            goto L9e
        L61:
            boolean r8 = r8.equals(r3)
            if (r8 != 0) goto L75
            goto L9e
        L68:
            boolean r8 = r8.equals(r4)
            if (r8 == 0) goto L9e
            goto L75
        L6f:
            boolean r8 = r8.equals(r5)
            if (r8 == 0) goto L9e
        L75:
            java.lang.String r8 = "source=VoiceAssistant"
            goto L9f
        L78:
            boolean r8 = r8.equals(r7)
            if (r8 == 0) goto L9e
            java.lang.String r8 = "params=[source=VoiceAssistant]"
            goto L9f
        L81:
            boolean r8 = r8.equals(r6)
            if (r8 == 0) goto L9e
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r2 = "params=[source=VoiceAssistant,keyword="
            r8.append(r2)
            r8.append(r9)
            r9 = 93
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            goto L9f
        L9e:
            r8 = r0
        L9f:
            java.lang.String r8 = id.dana.utils.UrlUtil.PlaceComponentResult(r1, r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.googleassistant.DanaGoogleAssistant.MyBillsEntityDataFactory(java.lang.String, java.lang.String):java.lang.String");
    }

    public static void getAuthRequestContext(boolean p0) {
        PlaceComponentResult = p0;
    }

    public static boolean PlaceComponentResult() {
        return PlaceComponentResult;
    }

    public static boolean KClassImpl$Data$declaredNonStaticMembers$2(Intent intent) {
        if (intent == null) {
            return false;
        }
        String dataString = intent.getDataString();
        if (dataString == null) {
            dataString = "";
        }
        return StringsKt.contains$default((CharSequence) dataString, (CharSequence) "dana://google.assistant/", false, 2, (Object) null);
    }

    private static boolean PlaceComponentResult(Uri uri) {
        return Intrinsics.areEqual(uri.getQueryParameter("transferMode"), "http://schema.googleapis.com/SendMoney") || Intrinsics.areEqual(uri.getQueryParameter("featureName"), "send_money");
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Uri uri) {
        return Intrinsics.areEqual(uri.getQueryParameter("transferMode"), "http://schema.googleapis.com/ReceiveMoney") || Intrinsics.areEqual(uri.getQueryParameter("featureName"), "request_money");
    }

    private static boolean MyBillsEntityDataFactory(Uri uri) {
        return Intrinsics.areEqual(uri.getQueryParameter("featureName"), "scan_qr") || Intrinsics.areEqual(uri.getPath(), "/scan_qr");
    }

    private static boolean getAuthRequestContext(Uri uri) {
        return Intrinsics.areEqual(uri.getQueryParameter("featureName"), "top_up");
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Uri uri) {
        String queryParameter = uri.getQueryParameter("searchQuery");
        return !(queryParameter == null || queryParameter.length() == 0);
    }

    private static boolean MyBillsEntityDataFactory(String str, Context context) {
        String[] stringArray = context.getResources().getStringArray(R.array.google_app_action_send_money);
        Intrinsics.checkNotNullExpressionValue(stringArray, "");
        for (String str2 : stringArray) {
            Intrinsics.checkNotNullExpressionValue(str2, "");
            if (StringsKt.contains((CharSequence) str, (CharSequence) str2, true)) {
                return true;
            }
        }
        return false;
    }

    private static boolean PlaceComponentResult(String str, Context context) {
        String[] stringArray = context.getResources().getStringArray(R.array.google_app_action_request_money);
        Intrinsics.checkNotNullExpressionValue(stringArray, "");
        for (String str2 : stringArray) {
            Intrinsics.checkNotNullExpressionValue(str2, "");
            if (StringsKt.contains((CharSequence) str, (CharSequence) str2, true)) {
                return true;
            }
        }
        return false;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(String str, Context context) {
        String[] stringArray = context.getResources().getStringArray(R.array.google_app_action_scan_qr);
        Intrinsics.checkNotNullExpressionValue(stringArray, "");
        for (String str2 : stringArray) {
            Intrinsics.checkNotNullExpressionValue(str2, "");
            if (StringsKt.contains((CharSequence) str, (CharSequence) str2, true)) {
                return true;
            }
        }
        return false;
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String str, Context context) {
        String[] stringArray = context.getResources().getStringArray(R.array.google_app_action_top_up);
        Intrinsics.checkNotNullExpressionValue(stringArray, "");
        for (String str2 : stringArray) {
            Intrinsics.checkNotNullExpressionValue(str2, "");
            if (StringsKt.contains((CharSequence) str, (CharSequence) str2, true)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void MyBillsEntityDataFactory(android.content.Intent r8, android.net.Uri r9, android.content.Context r10) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r1 = "search"
            java.lang.String r2 = "top_up"
            java.lang.String r3 = "scan_qr"
            java.lang.String r4 = "request_money"
            java.lang.String r5 = "send_money"
            if (r9 != 0) goto L19
        L17:
            r6 = r0
            goto L40
        L19:
            boolean r6 = PlaceComponentResult(r9)
            if (r6 == 0) goto L21
            r6 = r5
            goto L40
        L21:
            boolean r6 = BuiltInFictitiousFunctionClassFactory(r9)
            if (r6 == 0) goto L29
            r6 = r4
            goto L40
        L29:
            boolean r6 = MyBillsEntityDataFactory(r9)
            if (r6 == 0) goto L31
            r6 = r3
            goto L40
        L31:
            boolean r6 = getAuthRequestContext(r9)
            if (r6 == 0) goto L39
            r6 = r2
            goto L40
        L39:
            boolean r6 = KClassImpl$Data$declaredNonStaticMembers$2(r9)
            if (r6 == 0) goto L17
            r6 = r1
        L40:
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            if (r7 <= 0) goto L4b
            r7 = 1
            goto L4c
        L4b:
            r7 = 0
        L4c:
            if (r7 == 0) goto L8e
            java.lang.String r7 = "google_assistant_app_action"
            r8.putExtra(r7, r6)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r1)
            if (r1 == 0) goto L8e
            java.lang.String r1 = "searchQuery"
            java.lang.String r9 = r9.getQueryParameter(r1)
            if (r9 != 0) goto L62
            goto L63
        L62:
            r0 = r9
        L63:
            boolean r9 = MyBillsEntityDataFactory(r0, r10)
            if (r9 == 0) goto L6d
            r8.putExtra(r7, r5)
            return
        L6d:
            boolean r9 = PlaceComponentResult(r0, r10)
            if (r9 == 0) goto L77
            r8.putExtra(r7, r4)
            return
        L77:
            boolean r9 = BuiltInFictitiousFunctionClassFactory(r0, r10)
            if (r9 == 0) goto L81
            r8.putExtra(r7, r3)
            return
        L81:
            boolean r9 = KClassImpl$Data$declaredNonStaticMembers$2(r0, r10)
            if (r9 == 0) goto L8b
            r8.putExtra(r7, r2)
            return
        L8b:
            r8.putExtra(r1, r0)
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.googleassistant.DanaGoogleAssistant.MyBillsEntityDataFactory(android.content.Intent, android.net.Uri, android.content.Context):void");
    }
}
