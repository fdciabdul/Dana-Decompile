package id.dana.lib.gcontainer.util;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import com.ap.zoloz.hummer.h5.ZolozEkycH5Handler;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.lib.logger.DANALog;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ=\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0018\u0010\u0011\u001a\u0006*\u00020\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00028CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00028CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R*\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00028G@BX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\f\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0019\u0010\u0013"}, d2 = {"Lid/dana/lib/gcontainer/util/UserAgentFactory;", "", "", "platformName", RemoteConfigConstants.RequestFieldKey.PLATFORM_VERSION, "kitVersion", "apiPackVersion", "identitySource", "", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "DANA_KIT", "Ljava/lang/String;", "DEFAULT_IDENTITY_SOURCE", "KIT_VERSION", "LOCAL_KIT", "SKYWALKER_PLATFORM_NAME", "TAG", "getDefaultUserAgent", "()Ljava/lang/String;", "defaultUserAgent", ZolozEkycH5Handler.HUMMER_FOUNDATION_GET_LANGUAGE, "language", "p0", "userAgent", "getUserAgent", "getUserAgent$annotations", "()V", "<init>"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class UserAgentFactory {
    private static final String DANA_KIT = "DanaKit";
    private static final String DEFAULT_IDENTITY_SOURCE = "EDIK/1.0.0";
    private static final String KIT_VERSION = "1.5.1.3";
    private static final String LOCAL_KIT = "LocalKit";
    private static final String SKYWALKER_PLATFORM_NAME = "Skywalker";
    public static final UserAgentFactory INSTANCE = new UserAgentFactory();
    private static final String TAG = "UserAgentFactory";
    private static String userAgent = "";

    @JvmStatic
    public static final void create(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        create$default(str, str2, null, null, null, 28, null);
    }

    @JvmStatic
    public static final void create(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        create$default(str, str2, str3, null, null, 24, null);
    }

    @JvmStatic
    public static final void create(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        create$default(str, str2, str3, str4, null, 16, null);
    }

    @JvmStatic
    public static /* synthetic */ void getUserAgent$annotations() {
    }

    private UserAgentFactory() {
    }

    public static /* synthetic */ void create$default(String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = KIT_VERSION;
        }
        if ((i & 8) != 0) {
            str4 = "";
        }
        if ((i & 16) != 0) {
            str5 = DEFAULT_IDENTITY_SOURCE;
        }
        create(str, str2, str3, str4, str5);
    }

    @JvmStatic
    public static final void create(String platformName, String platformVersion, String kitVersion, String apiPackVersion, String identitySource) {
        Intrinsics.checkNotNullParameter(platformName, "");
        Intrinsics.checkNotNullParameter(platformVersion, "");
        Intrinsics.checkNotNullParameter(kitVersion, "");
        Intrinsics.checkNotNullParameter(apiPackVersion, "");
        Intrinsics.checkNotNullParameter(identitySource, "");
        UserAgentFactory userAgentFactory = INSTANCE;
        String str = Intrinsics.areEqual(platformName, SKYWALKER_PLATFORM_NAME) ? LOCAL_KIT : DANA_KIT;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('/');
        sb.append(kitVersion);
        String obj = sb.toString();
        String stringPlus = Intrinsics.areEqual(platformName, SKYWALKER_PLATFORM_NAME) ? "" : Intrinsics.stringPlus("DanaApiPack/", apiPackVersion);
        if (!Intrinsics.areEqual(platformName, SKYWALKER_PLATFORM_NAME)) {
            platformName = platformName.toUpperCase();
            Intrinsics.checkNotNullExpressionValue(platformName, "");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(platformName);
        sb2.append('/');
        sb2.append(platformVersion);
        String obj2 = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(obj2);
        sb3.append(InputCardNumberView.DIVIDER);
        sb3.append(identitySource);
        sb3.append(InputCardNumberView.DIVIDER);
        sb3.append((Object) userAgentFactory.getDefaultUserAgent());
        sb3.append(" Ariver/2.52.0");
        String obj3 = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append(obj3);
        sb4.append(InputCardNumberView.DIVIDER);
        sb4.append(obj);
        sb4.append(InputCardNumberView.DIVIDER);
        sb4.append(stringPlus);
        sb4.append(" Lang/");
        sb4.append(userAgentFactory.getLanguage());
        userAgent = sb4.toString();
        DANALog.KClassImpl$Data$declaredNonStaticMembers$2(TAG, Intrinsics.stringPlus("User-Agent=", getUserAgent()));
    }

    @JvmName(name = "getUserAgent")
    public static final String getUserAgent() {
        if (userAgent.length() > 0) {
            return userAgent;
        }
        throw new IllegalStateException("Please init User Agent with UserAgentFactory.create()");
    }

    @JvmName(name = "getDefaultUserAgent")
    private final String getDefaultUserAgent() {
        try {
            return System.getProperty("http.agent");
        } catch (Exception unused) {
            return null;
        }
    }

    @JvmName(name = ZolozEkycH5Handler.HUMMER_FOUNDATION_GET_LANGUAGE)
    private final String getLanguage() {
        String obj = Locale.getDefault().toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return StringsKt.endsWith$default(obj, "ID", false, 2, (Object) null) ? "id-ID" : HereUrlConstant.LANG_US;
    }
}
