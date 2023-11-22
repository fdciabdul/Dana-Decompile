package id.dana.contract.deeplink.util;

import android.net.Uri;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.utils.TextUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0011\u0012\u0013B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\n\u001a\u00020\u00022\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\n\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\n\u0010\rJ\u0017\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\r"}, d2 = {"Lid/dana/contract/deeplink/util/SourceParamUtil;", "", "", "p0", "p1", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "PlaceComponentResult", "(Ljava/lang/String;)Ljava/lang/String;", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/Map;)Ljava/lang/String;", "", "(Ljava/lang/String;)Z", "MyBillsEntityDataFactory", "<init>", "()V", "DanaKagetClaimSource", "Param", TrackerKey.DeeplinkProperty.PATH}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SourceParamUtil {
    public static final SourceParamUtil INSTANCE = new SourceParamUtil();

    private SourceParamUtil() {
    }

    @JvmStatic
    public static final String BuiltInFictitiousFunctionClassFactory(Map<String, String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String str = p0.get("source");
        String str2 = str != null ? str : "";
        String str3 = str2;
        return (!StringsKt.contains$default((CharSequence) str3, (CharSequence) "_", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) str3, (CharSequence) " ", false, 2, (Object) null)) ? str2 : CollectionsKt.joinToString$default(new Regex("_").split(str3, 0), " ", null, null, 0, null, new Function1<String, CharSequence>() { // from class: id.dana.contract.deeplink.util.SourceParamUtil$getSplitBillSourceParam$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(String str4) {
                Intrinsics.checkNotNullParameter(str4, "");
                String KClassImpl$Data$declaredNonStaticMembers$2 = TextUtil.KClassImpl$Data$declaredNonStaticMembers$2(str4);
                Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
                return KClassImpl$Data$declaredNonStaticMembers$2;
            }
        }, 30, null);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/contract/deeplink/util/SourceParamUtil$DanaKagetClaimSource;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class DanaKagetClaimSource {
        public static final DanaKagetClaimSource INSTANCE = new DanaKagetClaimSource();

        private DanaKagetClaimSource() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/contract/deeplink/util/SourceParamUtil$Path;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Path {
        public static final Path INSTANCE = new Path();

        private Path() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/contract/deeplink/util/SourceParamUtil$Param;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Param {
        public static final Param INSTANCE = new Param();

        private Param() {
        }
    }

    @JvmStatic
    public static final boolean MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Uri parse = Uri.parse(p0);
        Intrinsics.checkNotNullExpressionValue(parse, "");
        return Intrinsics.areEqual(parse.getPath(), "/m/luckymoney/claim") || Intrinsics.areEqual(parse.getPath(), "/n/dana-transfer/luckymoney/create") || Intrinsics.areEqual(parse.getPath(), "/kaget") || Intrinsics.areEqual(parse.getPath(), "/m/luckymoney");
    }

    @JvmStatic
    public static final boolean BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Uri parse = Uri.parse(p0);
        Intrinsics.checkNotNullExpressionValue(parse, "");
        return Intrinsics.areEqual(parse.getPath(), "/kaget");
    }

    @JvmStatic
    public static final String PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Uri parse = Uri.parse(p0);
        Intrinsics.checkNotNullExpressionValue(parse, "");
        if (Intrinsics.areEqual(parse.getPath(), "/kaget")) {
            return parse.getQueryParameter("refer");
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x003e, code lost:
    
        if (r6.equals("QR Code") == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0047, code lost:
    
        if (r6.equals("Friends Feed") == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x004e, code lost:
    
        if (r6.equals("Feed") == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0057, code lost:
    
        if (r6.equals(id.dana.feeds.ui.tracker.FeedsSourceType.FRIENDSHIP_FRIENDS_FEED) == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0060, code lost:
    
        if (r6.equals("Scan QR") == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0063, code lost:
    
        r3 = "QR Code";
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x006b, code lost:
    
        if (r6.equals(id.dana.feeds.ui.tracker.FeedsSourceType.FRIENDSHIP_MY_FEED) != false) goto L71;
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String getAuthRequestContext(java.lang.String r5, java.lang.String r6) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            android.net.Uri r1 = android.net.Uri.parse(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            boolean r2 = MyBillsEntityDataFactory(r5)
            if (r2 == 0) goto L7c
            java.lang.String r2 = "refer"
            java.lang.String r3 = r1.getQueryParameter(r2)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L27
            int r3 = r3.length()
            if (r3 == 0) goto L27
            r3 = 0
            goto L28
        L27:
            r3 = 1
        L28:
            if (r3 == 0) goto L7c
            android.net.Uri$Builder r5 = r1.buildUpon()
            int r1 = r6.hashCode()
            java.lang.String r3 = "Feed"
            java.lang.String r4 = "QR Code"
            switch(r1) {
                case -1812806804: goto L65;
                case -719427964: goto L5a;
                case -15294278: goto L51;
                case 2185662: goto L4a;
                case 744229257: goto L41;
                case 1252603052: goto L3a;
                default: goto L39;
            }
        L39:
            goto L6e
        L3a:
            boolean r6 = r6.equals(r4)
            if (r6 != 0) goto L63
            goto L6e
        L41:
            java.lang.String r1 = "Friends Feed"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L70
            goto L6e
        L4a:
            boolean r6 = r6.equals(r3)
            if (r6 != 0) goto L70
            goto L6e
        L51:
            java.lang.String r1 = "Friendship Friend Feed"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L70
            goto L6e
        L5a:
            java.lang.String r1 = "Scan QR"
            boolean r6 = r6.equals(r1)
            if (r6 != 0) goto L63
            goto L6e
        L63:
            r3 = r4
            goto L70
        L65:
            java.lang.String r1 = "Friendship My Feed"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L6e
            goto L70
        L6e:
            java.lang.String r3 = "Link"
        L70:
            android.net.Uri$Builder r5 = r5.appendQueryParameter(r2, r3)
            android.net.Uri r5 = r5.build()
            java.lang.String r5 = r5.toString()
        L7c:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.deeplink.util.SourceParamUtil.getAuthRequestContext(java.lang.String, java.lang.String):java.lang.String");
    }
}
