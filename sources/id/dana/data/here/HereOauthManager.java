package id.dana.data.here;

import android.media.AudioTrack;
import android.util.Base64;
import android.view.View;
import android.widget.ExpandableListView;
import com.google.gson.Gson;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.BuildConfig;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.here.model.BackoffException;
import id.dana.data.here.model.BlacklistedException;
import id.dana.data.here.model.ErrorHereData;
import id.dana.data.here.model.HereAuthentication;
import id.dana.data.here.model.HereConfigResponse;
import id.dana.data.here.model.HereTokenResponse;
import id.dana.data.here.source.local.HereAuthenticationPreference;
import id.dana.data.here.source.network.HereTokenApi;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.data.tracker.HereApiMixpanelTracker;
import id.dana.domain.tracker.HereMixPanelTrackerData;
import id.dana.utils.extension.JSONExtKt;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import o.whenAvailable;
import org.json.JSONArray;
import retrofit2.HttpException;

@Singleton
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 b2\u00020\u0001:\u0001bB1\b\u0007\u0012\u0006\u0010[\u001a\u00020Z\u0012\u0006\u0010S\u001a\u00020R\u0012\u0006\u0010X\u001a\u00020W\u0012\u0006\u0010N\u001a\u00020M\u0012\u0006\u0010^\u001a\u00020]¢\u0006\u0004\b`\u0010aJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ=\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J;\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0013J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0005J?\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ?\u0010 \u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002¢\u0006\u0004\b \u0010\u001eJ\u0017\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0002¢\u0006\u0004\b%\u0010#J\u0017\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0002¢\u0006\u0004\b'\u0010#J\u0019\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010)\u001a\u00020(H\u0002¢\u0006\u0004\b+\u0010,J\u0019\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010)\u001a\u00020-H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u000201H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\tH\u0002¢\u0006\u0004\b4\u00105J\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b6\u00107JE\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\r2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u00102\u0006\u0010)\u001a\u00020-2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b8\u00109J#\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\r2\u0006\u0010)\u001a\u00020-H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u00062\u0006\u0010)\u001a\u00020-H\u0002¢\u0006\u0004\b?\u0010@J\u0017\u0010A\u001a\u00020\u00062\u0006\u0010)\u001a\u00020-H\u0002¢\u0006\u0004\bA\u0010@J\u000f\u0010B\u001a\u00020<H\u0002¢\u0006\u0004\bB\u0010>J\u000f\u0010C\u001a\u00020<H\u0002¢\u0006\u0004\bC\u0010>J\u0015\u0010E\u001a\u00020<2\u0006\u0010D\u001a\u00020\u0015¢\u0006\u0004\bE\u0010FJ\u0017\u0010I\u001a\u00020\u00032\u0006\u0010H\u001a\u00020GH\u0002¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\u0006H\u0002¢\u0006\u0004\bK\u0010\bJ\u0015\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\bL\u0010\u0005R\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010P\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010S\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010U\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010[\u001a\u00020Z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010^\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_"}, d2 = {"Lid/dana/data/here/HereOauthManager;", "", "Lio/reactivex/Observable;", "Lid/dana/data/here/model/HereAuthentication;", "acquireNewToken", "()Lio/reactivex/Observable;", "", "checkBackoffData", "()Z", "", "source", "checkBlacklistSource", "(Ljava/lang/String;)Z", "T", "Lid/dana/domain/tracker/HereMixPanelTrackerData;", "hereMixPanelTrackerData", "Lkotlin/Function1;", "apiCall", "doExecuteHereApi", "(Lid/dana/domain/tracker/HereMixPanelTrackerData;Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", "executeHereApi", "Lid/dana/data/here/model/HereConfigResponse;", "fetchHereConfig", "consumerKeyEncoded", "hmacSha256Encoded", "timeStampEndcoded", "uniqueIDEncoded", "versionEncoded", BranchLinkConstant.OauthParams.SIGNATURE, "generateAuthorizationValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "grantTypeEncoded", "generateBaseSignature", "signatureBaseString", "generateBaseString", "(Ljava/lang/String;)Ljava/lang/String;", "baseString", "generateSignature", "accessToken", "getBearerToken", "Lretrofit2/HttpException;", "error", "Lid/dana/data/here/model/ErrorHereResponse;", "getErrorHereBody", "(Lretrofit2/HttpException;)Lid/dana/data/here/model/ErrorHereResponse;", "", "Lid/dana/data/here/model/ErrorHereData;", "getErrorHereData", "(Ljava/lang/Throwable;)Lid/dana/data/here/model/ErrorHereData;", "Ljavax/crypto/Mac;", "getSha256Hashing", "()Ljavax/crypto/Mac;", "getTimestampInSeconds", "()Ljava/lang/String;", "getToken", "(Lid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", "handleApiCallError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;Lid/dana/domain/tracker/HereMixPanelTrackerData;)Lio/reactivex/Observable;", "handleGetTokenError", "(Ljava/lang/Throwable;)Lio/reactivex/Observable;", "", "invalidateLastToken", "()V", "isErrorTooManyRequests", "(Ljava/lang/Throwable;)Z", "isErrorUnauthorized", "resetBackoffData", "saveBackoffData", "hereConfigResponse", "setHereConfig", "(Lid/dana/data/here/model/HereConfigResponse;)V", "Lid/dana/data/here/model/HereTokenResponse;", "newToken", "setLastToken", "(Lid/dana/data/here/model/HereTokenResponse;)Lid/dana/data/here/model/HereAuthentication;", "shouldAcquireNewToken", "useExistingToken", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "hereAuthentication", "Lid/dana/data/here/model/HereAuthentication;", "Lid/dana/data/here/source/local/HereAuthenticationPreference;", "hereAuthenticationPreference", "Lid/dana/data/here/source/local/HereAuthenticationPreference;", "hereConfig", "Lid/dana/data/here/model/HereConfigResponse;", "Lid/dana/data/tracker/HereApiMixpanelTracker;", "hereMixPanelTracker", "Lid/dana/data/tracker/HereApiMixpanelTracker;", "Lid/dana/data/here/source/network/HereTokenApi;", "hereTokenApi", "Lid/dana/data/here/source/network/HereTokenApi;", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/here/source/network/HereTokenApi;Lid/dana/data/here/source/local/HereAuthenticationPreference;Lid/dana/data/tracker/HereApiMixpanelTracker;Lcom/google/gson/Gson;Lid/dana/data/toggle/SplitFacade;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HereOauthManager {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final String CLIENT_CREDENTIALS = "client_credentials";
    public static final String CONSUMER_KEY_PARAM = "oauth_consumer_key";
    public static final String CONTENT_TYPE_ENCODED_FORM = "application/x-www-form-urlencoded";
    public static final int DEFAULT_FACTOR = 3;
    public static final int DEFAULT_MAX_BACKOFF = 60;
    public static final String ENC = "utf-8";
    public static final String HASHING_ALGORITHM = "HmacSHA256";
    public static final String HMAC_SHA256 = "HMAC-SHA256";
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 1;
    public static final String NONCE_PARAM = "oauth_nonce";
    public static final String OAUTH = "OAuth";
    private static long PlaceComponentResult = 0;
    public static final String SIGNATURE_METHOD_PARAM = "oauth_signature_method";
    public static final String SIGNATURE_PARAM = "oauth_signature";
    public static final String TIMESTAMP_PARAM = "oauth_timestamp";
    public static final int TOO_MANY_REQUEST_CODE = 429;
    public static final int UNAUTHORIZED_ERROR_CODE = 401;
    public static final String VERSION = "1.0";
    public static final String VERSION_PARAM = "oauth_version";
    private static char[] getAuthRequestContext;
    private final Gson gson;
    private HereAuthentication hereAuthentication;
    private final HereAuthenticationPreference hereAuthenticationPreference;
    private HereConfigResponse hereConfig;
    private final HereApiMixpanelTracker hereMixPanelTracker;
    private final HereTokenApi hereTokenApi;
    private final SplitFacade splitFacade;

    public static /* synthetic */ HereConfigResponse $r8$lambda$1E0gyWT4PWXrdohmADiYiqlRhnQ(BaseTrafficType baseTrafficType) {
        try {
            int i = MyBillsEntityDataFactory + 23;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                boolean z = i % 2 == 0;
                HereConfigResponse m1357fetchHereConfig$lambda9 = m1357fetchHereConfig$lambda9(baseTrafficType);
                if (!z) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 97;
                MyBillsEntityDataFactory = i2 % 128;
                int i3 = i2 % 2;
                return m1357fetchHereConfig$lambda9;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: $r8$lambda$4LU89bZkKt7-RPfcHsEP-837KgA */
    public static /* synthetic */ ObservableSource m1348$r8$lambda$4LU89bZkKt7RPfcHsEP837KgA(Function1 function1, HereOauthManager hereOauthManager, HereMixPanelTrackerData hereMixPanelTrackerData, HereAuthentication hereAuthentication) {
        int i = MyBillsEntityDataFactory + 49;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        char c = i % 2 != 0 ? ',' : '_';
        ObservableSource m1353doExecuteHereApi$lambda5 = m1353doExecuteHereApi$lambda5(function1, hereOauthManager, hereMixPanelTrackerData, hereAuthentication);
        if (c == ',') {
            int i2 = 90 / 0;
        }
        try {
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
            MyBillsEntityDataFactory = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return m1353doExecuteHereApi$lambda5;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return m1353doExecuteHereApi$lambda5;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$E0yrE6_9g8ztAdopWCcz2ARDxjM(HereOauthManager hereOauthManager, Throwable th) {
        int i = MyBillsEntityDataFactory + 59;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        ObservableSource m1352acquireNewToken$lambda20 = m1352acquireNewToken$lambda20(hereOauthManager, th);
        try {
            int i3 = MyBillsEntityDataFactory + 99;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if ((i3 % 2 != 0 ? '@' : '\f') != '\f') {
                    Object obj = null;
                    obj.hashCode();
                    return m1352acquireNewToken$lambda20;
                }
                return m1352acquireNewToken$lambda20;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$Flgt0Eu4mjsavZqyGRn6U7t_DsM(HereOauthManager hereOauthManager, Function1 function1, HereMixPanelTrackerData hereMixPanelTrackerData, Throwable th) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 65;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        ObservableSource m1355doExecuteHereApi$lambda5$lambda4 = m1355doExecuteHereApi$lambda5$lambda4(hereOauthManager, function1, hereMixPanelTrackerData, th);
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 27;
        MyBillsEntityDataFactory = i3 % 128;
        if ((i3 % 2 == 0 ? ':' : (char) 28) != 28) {
            Object[] objArr = null;
            int length = objArr.length;
            return m1355doExecuteHereApi$lambda5$lambda4;
        }
        return m1355doExecuteHereApi$lambda5$lambda4;
    }

    public static /* synthetic */ void $r8$lambda$JFs1uDaGjvHXMvgqN8AcBwJ3cdU(HereMixPanelTrackerData hereMixPanelTrackerData, HereOauthManager hereOauthManager, Object obj) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 97;
            MyBillsEntityDataFactory = i % 128;
            boolean z = i % 2 != 0;
            m1354doExecuteHereApi$lambda5$lambda3(hereMixPanelTrackerData, hereOauthManager, obj);
            if (!z) {
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 59;
            MyBillsEntityDataFactory = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: $r8$lambda$P-PwG644RDkPVCOWB616OfsX66U */
    public static /* synthetic */ void m1349$r8$lambda$PPwG644RDkPVCOWB616OfsX66U(HereOauthManager hereOauthManager, HereMixPanelTrackerData hereMixPanelTrackerData, Throwable th) {
        int i = MyBillsEntityDataFactory + 15;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        boolean z = i % 2 != 0;
        m1359getToken$lambda18(hereOauthManager, hereMixPanelTrackerData, th);
        if (z) {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 3;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
    }

    public static /* synthetic */ void $r8$lambda$_PY8JxiWg0RRjSjB41J2rGUUiuY(HereMixPanelTrackerData hereMixPanelTrackerData, HereOauthManager hereOauthManager, HereAuthentication hereAuthentication) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 103;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        m1358getToken$lambda15(hereMixPanelTrackerData, hereOauthManager, hereAuthentication);
        int i3 = MyBillsEntityDataFactory + 47;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 19 : (char) 11) != 11) {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* renamed from: $r8$lambda$el0aYocvWBTzWouBOv-eXyFK5Fs */
    public static /* synthetic */ HereAuthentication m1350$r8$lambda$el0aYocvWBTzWouBOveXyFK5Fs(HereOauthManager hereOauthManager, HereTokenResponse hereTokenResponse) {
        HereAuthentication m1351acquireNewToken$lambda19;
        int i = MyBillsEntityDataFactory + 103;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        Object[] objArr = null;
        if (!(i % 2 != 0)) {
            m1351acquireNewToken$lambda19 = m1351acquireNewToken$lambda19(hereOauthManager, hereTokenResponse);
        } else {
            try {
                m1351acquireNewToken$lambda19 = m1351acquireNewToken$lambda19(hereOauthManager, hereTokenResponse);
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            int i2 = MyBillsEntityDataFactory + 33;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            if (!(i2 % 2 == 0)) {
                objArr.hashCode();
                return m1351acquireNewToken$lambda19;
            }
            return m1351acquireNewToken$lambda19;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public static /* synthetic */ ObservableSource $r8$lambda$qpwHBh8PkghukWT2RTm3fsnQsiw(HereOauthManager hereOauthManager, HereMixPanelTrackerData hereMixPanelTrackerData, Function1 function1, HereConfigResponse hereConfigResponse) {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            ObservableSource m1356executeHereApi$lambda2$lambda1 = m1356executeHereApi$lambda2$lambda1(hereOauthManager, hereMixPanelTrackerData, function1, hereConfigResponse);
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 73;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return m1356executeHereApi$lambda2$lambda1;
        } catch (Exception e) {
            throw e;
        }
    }

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new Companion(null);
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 99;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        getAuthRequestContext = new char[]{62246, 12420, 29794, 47142, 64941, 8518, 25915, 43753, 61008, 4608, 22527};
        PlaceComponentResult = 2723474296688160993L;
    }

    @Inject
    public HereOauthManager(HereTokenApi hereTokenApi, HereAuthenticationPreference hereAuthenticationPreference, HereApiMixpanelTracker hereApiMixpanelTracker, Gson gson, SplitFacade splitFacade) {
        try {
            Intrinsics.checkNotNullParameter(hereTokenApi, "");
            Intrinsics.checkNotNullParameter(hereAuthenticationPreference, "");
            Intrinsics.checkNotNullParameter(hereApiMixpanelTracker, "");
            Intrinsics.checkNotNullParameter(gson, "");
            Intrinsics.checkNotNullParameter(splitFacade, "");
            this.hereTokenApi = hereTokenApi;
            this.hereAuthenticationPreference = hereAuthenticationPreference;
            this.hereMixPanelTracker = hereApiMixpanelTracker;
            this.gson = gson;
            this.splitFacade = splitFacade;
            this.hereAuthentication = hereAuthenticationPreference.getHereAuthentication();
        } catch (Exception e) {
            throw e;
        }
    }

    public final <T> Observable<T> executeHereApi(final HereMixPanelTrackerData hereMixPanelTrackerData, final Function1<? super String, ? extends Observable<T>> apiCall) {
        boolean z;
        Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
        Intrinsics.checkNotNullParameter(apiCall, "");
        if ((hereMixPanelTrackerData.getSource().length() == 0 ? 'P' : 'Y') != 'Y') {
            try {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                z = true;
            } catch (Exception e) {
                throw e;
            }
        } else {
            z = false;
        }
        if (z) {
            Observable<T> error = Observable.error(new UnsupportedOperationException("Need to pass source to execute HERE API"));
            Intrinsics.checkNotNullExpressionValue(error, "");
            int i3 = MyBillsEntityDataFactory + 71;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            return error;
        }
        if (!(this.hereConfig == null)) {
            Observable<T> doExecuteHereApi = doExecuteHereApi(hereMixPanelTrackerData, apiCall);
            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 43;
            MyBillsEntityDataFactory = i5 % 128;
            if ((i5 % 2 == 0 ? 'X' : (char) 21) != 'X') {
                return doExecuteHereApi;
            }
            Object obj = null;
            obj.hashCode();
            return doExecuteHereApi;
        }
        HereOauthManager hereOauthManager = this;
        Observable<T> observable = (Observable<T>) fetchHereConfig().flatMap(new Function() { // from class: id.dana.data.here.HereOauthManager$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj2) {
                return HereOauthManager.$r8$lambda$qpwHBh8PkghukWT2RTm3fsnQsiw(HereOauthManager.this, hereMixPanelTrackerData, apiCall, (HereConfigResponse) obj2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(observable, "");
        return observable;
    }

    /* renamed from: executeHereApi$lambda-2$lambda-1 */
    private static final ObservableSource m1356executeHereApi$lambda2$lambda1(HereOauthManager hereOauthManager, HereMixPanelTrackerData hereMixPanelTrackerData, Function1 function1, HereConfigResponse hereConfigResponse) {
        Observable doExecuteHereApi;
        int i = MyBillsEntityDataFactory + 35;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 != 0)) {
            Intrinsics.checkNotNullParameter(hereOauthManager, "");
            Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
            Intrinsics.checkNotNullParameter(function1, "");
            Intrinsics.checkNotNullParameter(hereConfigResponse, "");
            hereOauthManager.hereConfig = hereConfigResponse;
            doExecuteHereApi = hereOauthManager.doExecuteHereApi(hereMixPanelTrackerData, function1);
        } else {
            Intrinsics.checkNotNullParameter(hereOauthManager, "");
            Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
            Intrinsics.checkNotNullParameter(function1, "");
            Intrinsics.checkNotNullParameter(hereConfigResponse, "");
            hereOauthManager.hereConfig = hereConfigResponse;
            doExecuteHereApi = hereOauthManager.doExecuteHereApi(hereMixPanelTrackerData, function1);
            int i2 = 99 / 0;
        }
        int i3 = MyBillsEntityDataFactory + 5;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
        return doExecuteHereApi;
    }

    private final <T> Observable<T> doExecuteHereApi(final HereMixPanelTrackerData hereMixPanelTrackerData, final Function1<? super String, ? extends Observable<T>> apiCall) {
        int i = MyBillsEntityDataFactory + 11;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        if (checkBlacklistSource(hereMixPanelTrackerData.getSource())) {
            Observable<T> error = Observable.error(new BlacklistedException());
            Intrinsics.checkNotNullExpressionValue(error, "");
            return error;
        } else if (checkBackoffData()) {
            Observable<T> error2 = Observable.error(new BackoffException());
            Intrinsics.checkNotNullExpressionValue(error2, "");
            return error2;
        } else {
            try {
                Observable<T> observable = (Observable<T>) getToken(hereMixPanelTrackerData).flatMap(new Function() { // from class: id.dana.data.here.HereOauthManager$$ExternalSyntheticLambda0
                    @Override // io.reactivex.functions.Function
                    public final Object apply(Object obj) {
                        return HereOauthManager.m1348$r8$lambda$4LU89bZkKt7RPfcHsEP837KgA(Function1.this, this, hereMixPanelTrackerData, (HereAuthentication) obj);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(observable, "");
                int i3 = MyBillsEntityDataFactory + 39;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                return observable;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    /* renamed from: doExecuteHereApi$lambda-5 */
    private static final ObservableSource m1353doExecuteHereApi$lambda5(final Function1 function1, final HereOauthManager hereOauthManager, final HereMixPanelTrackerData hereMixPanelTrackerData, HereAuthentication hereAuthentication) {
        try {
            Intrinsics.checkNotNullParameter(function1, "");
            Intrinsics.checkNotNullParameter(hereOauthManager, "");
            Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
            Intrinsics.checkNotNullParameter(hereAuthentication, "");
            Observable onErrorResumeNext = ((Observable) function1.invoke(hereOauthManager.getBearerToken(hereAuthentication.getAccessToken()))).doOnNext(new Consumer() { // from class: id.dana.data.here.HereOauthManager$$ExternalSyntheticLambda5
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    HereOauthManager.$r8$lambda$JFs1uDaGjvHXMvgqN8AcBwJ3cdU(HereMixPanelTrackerData.this, hereOauthManager, obj);
                }
            }).onErrorResumeNext(new Function() { // from class: id.dana.data.here.HereOauthManager$$ExternalSyntheticLambda6
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return HereOauthManager.$r8$lambda$Flgt0Eu4mjsavZqyGRn6U7t_DsM(HereOauthManager.this, function1, hereMixPanelTrackerData, (Throwable) obj);
                }
            });
            try {
                int i = MyBillsEntityDataFactory + 119;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                return onErrorResumeNext;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* renamed from: doExecuteHereApi$lambda-5$lambda-3 */
    private static final void m1354doExecuteHereApi$lambda5$lambda3(HereMixPanelTrackerData hereMixPanelTrackerData, HereOauthManager hereOauthManager, Object obj) {
        int i = MyBillsEntityDataFactory + 93;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 == 0)) {
            Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
            Intrinsics.checkNotNullParameter(hereOauthManager, "");
            hereMixPanelTrackerData.setSuccess(false);
        } else {
            Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
            Intrinsics.checkNotNullParameter(hereOauthManager, "");
            hereMixPanelTrackerData.setSuccess(true);
        }
        hereOauthManager.hereMixPanelTracker.track(hereMixPanelTrackerData);
        hereOauthManager.resetBackoffData();
        int i2 = MyBillsEntityDataFactory + 81;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
    }

    /* renamed from: doExecuteHereApi$lambda-5$lambda-4 */
    private static final ObservableSource m1355doExecuteHereApi$lambda5$lambda4(HereOauthManager hereOauthManager, Function1 function1, HereMixPanelTrackerData hereMixPanelTrackerData, Throwable th) {
        int i = MyBillsEntityDataFactory + 109;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(hereOauthManager, "");
            Intrinsics.checkNotNullParameter(function1, "");
            Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
            Intrinsics.checkNotNullParameter(th, "");
            Observable handleApiCallError = hereOauthManager.handleApiCallError(function1, th, hereMixPanelTrackerData);
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 49;
            MyBillsEntityDataFactory = i3 % 128;
            int i4 = i3 % 2;
            return handleApiCallError;
        } catch (Exception e) {
            throw e;
        }
    }

    private final boolean checkBlacklistSource(String source) {
        int i = MyBillsEntityDataFactory + 125;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        try {
            HereConfigResponse hereConfigResponse = this.hereConfig;
            if ((hereConfigResponse != null ? 'c' : '!') == '!') {
                return false;
            }
            int i3 = MyBillsEntityDataFactory + 57;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            List<String> excludeSource = hereConfigResponse.getExcludeSource();
            if (excludeSource == null) {
                return false;
            }
            int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 109;
            MyBillsEntityDataFactory = i5 % 128;
            int i6 = i5 % 2;
            try {
                if ((!excludeSource.isEmpty()) != true) {
                    return false;
                }
                List<String> list = excludeSource;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        String lowerCase = ((String) it.next()).toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                        arrayList.add(lowerCase);
                    } else {
                        String lowerCase2 = source.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "");
                        return arrayList.contains(lowerCase2);
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final Observable<HereConfigResponse> fetchHereConfig() {
        try {
            Observable map = this.splitFacade.PlaceComponentResult().map(new Function() { // from class: id.dana.data.here.HereOauthManager$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return HereOauthManager.$r8$lambda$1E0gyWT4PWXrdohmADiYiqlRhnQ((BaseTrafficType) obj);
                }
            });
            try {
                Intrinsics.checkNotNullExpressionValue(map, "");
                int i = MyBillsEntityDataFactory + 117;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if (!(i % 2 == 0)) {
                    int i2 = 20 / 0;
                    return map;
                }
                return map;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final <T> Observable<T> handleGetTokenError(Throwable error) {
        if ((isErrorTooManyRequests(error) ? (char) 24 : 'L') == 24) {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 83;
            MyBillsEntityDataFactory = i % 128;
            int i2 = i % 2;
            saveBackoffData();
        } else {
            resetBackoffData();
        }
        try {
            Observable<T> error2 = Observable.error(error);
            try {
                Intrinsics.checkNotNullExpressionValue(error2, "");
                int i3 = MyBillsEntityDataFactory + 85;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                return error2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final <T> Observable<T> handleApiCallError(Function1<? super String, ? extends Observable<T>> apiCall, Throwable error, HereMixPanelTrackerData hereMixPanelTrackerData) {
        ErrorHereData errorHereData = getErrorHereData(error);
        if (errorHereData != null) {
            try {
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 123;
                try {
                    MyBillsEntityDataFactory = i % 128;
                    int i2 = i % 2;
                    hereMixPanelTrackerData.setSuccess(false);
                    hereMixPanelTrackerData.setErrorCode(errorHereData.getErrorCode());
                    hereMixPanelTrackerData.setFailReason(errorHereData.getMessage());
                    this.hereMixPanelTracker.track(hereMixPanelTrackerData);
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        if (isErrorTooManyRequests(error)) {
            int i3 = MyBillsEntityDataFactory + 13;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if (i3 % 2 == 0) {
                saveBackoffData();
                Observable<T> error2 = Observable.error(error);
                Intrinsics.checkNotNullExpressionValue(error2, "");
                return error2;
            }
            saveBackoffData();
            Observable<T> error3 = Observable.error(error);
            Intrinsics.checkNotNullExpressionValue(error3, "");
            Object[] objArr = null;
            int length = objArr.length;
            return error3;
        }
        if ((isErrorUnauthorized(error) ? '^' : 'J') != 'J') {
            invalidateLastToken();
            resetBackoffData();
            Observable<T> error4 = Observable.error(error);
            Intrinsics.checkNotNullExpressionValue(error4, "");
            return error4;
        }
        resetBackoffData();
        Observable<T> error5 = Observable.error(error);
        Intrinsics.checkNotNullExpressionValue(error5, "");
        return error5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0073, code lost:
    
        if (r7 == null) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x007c, code lost:
    
        if (r7 == null) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0042, code lost:
    
        if (r1 == null) goto L92;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final id.dana.data.here.model.ErrorHereData getErrorHereData(java.lang.Throwable r7) {
        /*
            r6 = this;
            int r0 = id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory
            int r0 = r0 + 49
            int r1 = r0 % 128
            id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 69
            r2 = 0
            if (r0 == 0) goto L21
            boolean r0 = r7 instanceof retrofit2.HttpException
            int r3 = r2.length     // Catch: java.lang.Throwable -> L1f
            r3 = 78
            if (r0 == 0) goto L19
            r0 = 78
            goto L1b
        L19:
            r0 = 69
        L1b:
            if (r0 == r3) goto L25
            goto Lba
        L1f:
            r7 = move-exception
            throw r7
        L21:
            boolean r0 = r7 instanceof retrofit2.HttpException     // Catch: java.lang.Exception -> Lbb
            if (r0 == 0) goto Lba
        L25:
            retrofit2.HttpException r7 = (retrofit2.HttpException) r7
            id.dana.data.here.model.ErrorHereResponse r0 = r6.getErrorHereBody(r7)
            r3 = 43
            if (r0 == 0) goto L30
            goto L32
        L30:
            r1 = 43
        L32:
            if (r1 == r3) goto L44
            int r1 = id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory
            int r1 = r1 + 39
            int r3 = r1 % 128
            id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r1 = r1 % 2
            java.lang.String r1 = r0.getErrorCode()
            if (r1 != 0) goto L60
        L44:
            if (r0 == 0) goto L55
            int r1 = id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2
            int r1 = r1 + 103
            int r3 = r1 % 128
            id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory = r3
            int r1 = r1 % 2
            java.lang.String r1 = r0.getStatus()     // Catch: java.lang.Exception -> Lbb
            goto L56
        L55:
            r1 = r2
        L56:
            if (r1 != 0) goto L60
            int r7 = r7.code()     // Catch: java.lang.Exception -> Lbb
            java.lang.String r1 = java.lang.String.valueOf(r7)     // Catch: java.lang.Exception -> Lbb
        L60:
            if (r0 == 0) goto L7e
            int r7 = id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2
            int r7 = r7 + 121
            int r3 = r7 % 128
            id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory = r3
            int r7 = r7 % 2
            if (r7 != 0) goto L78
            java.lang.String r7 = r0.getMessage()
            int r3 = r2.length     // Catch: java.lang.Throwable -> L76
            if (r7 != 0) goto Lb5
            goto L7e
        L76:
            r7 = move-exception
            throw r7
        L78:
            java.lang.String r7 = r0.getMessage()
            if (r7 != 0) goto Lb5
        L7e:
            r7 = 0
            r3 = 1
            if (r0 == 0) goto L84
            r4 = 1
            goto L85
        L84:
            r4 = 0
        L85:
            if (r4 == r3) goto L93
            int r4 = id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2
            int r4 = r4 + 71
            int r5 = r4 % 128
            id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory = r5
            int r4 = r4 % 2
            r4 = r2
            goto L97
        L93:
            java.lang.String r4 = r0.getErrorDescription()
        L97:
            if (r4 != 0) goto Lb4
            if (r0 == 0) goto L9c
            goto L9d
        L9c:
            r7 = 1
        L9d:
            if (r7 == r3) goto La3
            java.lang.String r2 = r0.getTitle()     // Catch: java.lang.Exception -> Lbb
        La3:
            if (r2 != 0) goto Lb2
            int r7 = id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory
            int r7 = r7 + 25
            int r0 = r7 % 128
            id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r7 = r7 % 2
            java.lang.String r7 = ""
            goto Lb5
        Lb2:
            r7 = r2
            goto Lb5
        Lb4:
            r7 = r4
        Lb5:
            id.dana.data.here.model.ErrorHereData r2 = new id.dana.data.here.model.ErrorHereData
            r2.<init>(r1, r7)
        Lba:
            return r2
        Lbb:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.here.HereOauthManager.getErrorHereData(java.lang.Throwable):id.dana.data.here.model.ErrorHereData");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0034, code lost:
    
        if ((((retrofit2.HttpException) r3).code() == 429 ? 19 : '/') != 19) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x003f, code lost:
    
        if (((retrofit2.HttpException) r3).code() == 14569) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0041, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean isErrorTooManyRequests(java.lang.Throwable r3) {
        /*
            r2 = this;
            int r0 = id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 73
            int r1 = r0 % 128
            id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            boolean r0 = r3 instanceof retrofit2.HttpException
            if (r0 == 0) goto L47
            int r0 = id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L45
            int r0 = r0 + 95
            int r1 = r0 % 128
            id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L45
            int r0 = r0 % 2
            r1 = 10
            if (r0 == 0) goto L1f
            r0 = 10
            goto L21
        L1f:
            r0 = 80
        L21:
            if (r0 == r1) goto L37
            retrofit2.HttpException r3 = (retrofit2.HttpException) r3
            int r3 = r3.code()
            r0 = 429(0x1ad, float:6.01E-43)
            r1 = 19
            if (r3 != r0) goto L32
            r3 = 19
            goto L34
        L32:
            r3 = 47
        L34:
            if (r3 == r1) goto L41
            goto L47
        L37:
            retrofit2.HttpException r3 = (retrofit2.HttpException) r3     // Catch: java.lang.Exception -> L43
            int r3 = r3.code()     // Catch: java.lang.Exception -> L43
            r0 = 14569(0x38e9, float:2.0416E-41)
            if (r3 != r0) goto L47
        L41:
            r3 = 1
            goto L52
        L43:
            r3 = move-exception
            throw r3
        L45:
            r3 = move-exception
            throw r3
        L47:
            r3 = 0
            int r0 = id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory
            int r0 = r0 + 83
            int r1 = r0 % 128
            id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
        L52:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.here.HereOauthManager.isErrorTooManyRequests(java.lang.Throwable):boolean");
    }

    private final boolean isErrorUnauthorized(Throwable error) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 105;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        boolean z = false;
        if (!(!(error instanceof HttpException))) {
            if ((((HttpException) error).code() == 401 ? (char) 24 : Typography.amp) == 24) {
                z = true;
            }
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 109;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        return z;
    }

    private final String getBearerToken(String accessToken) {
        StringBuilder sb = new StringBuilder();
        sb.append("Bearer ");
        sb.append(accessToken);
        String obj = sb.toString();
        int i = MyBillsEntityDataFactory + 49;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? (char) 27 : (char) 28) != 28) {
            Object[] objArr = null;
            int length = objArr.length;
            return obj;
        }
        return obj;
    }

    private final void invalidateLastToken() {
        this.hereAuthentication = new HereAuthentication(null, 0L, 3, null);
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 101;
            MyBillsEntityDataFactory = i % 128;
            if (!(i % 2 == 0)) {
                return;
            }
            int i2 = 9 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    private final HereAuthentication setLastToken(HereTokenResponse newToken) {
        HereAuthentication hereAuthentication = new HereAuthentication(newToken.getAccess_token(), System.currentTimeMillis() + (newToken.getExpires_in() * 1000));
        this.hereAuthenticationPreference.saveHereAuthentication(hereAuthentication);
        this.hereAuthentication = hereAuthentication;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 93;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        return hereAuthentication;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x001b, code lost:
    
        if (r0 != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0024, code lost:
    
        if (shouldAcquireNewToken() != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x002f, code lost:
    
        r3 = acquireNewToken().doOnNext(new id.dana.data.here.HereOauthManager$$ExternalSyntheticLambda7(r3, r2)).doOnError(new id.dana.data.here.HereOauthManager$$ExternalSyntheticLambda8(r2, r3));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "");
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0042, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0043, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0044, code lost:
    
        r3 = useExistingToken();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final io.reactivex.Observable<id.dana.data.here.model.HereAuthentication> getToken(final id.dana.domain.tracker.HereMixPanelTrackerData r3) {
        /*
            r2 = this;
            int r0 = id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 5
            int r1 = r0 % 128
            id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 65
            if (r0 != 0) goto L11
            r0 = 36
            goto L13
        L11:
            r0 = 65
        L13:
            if (r0 == r1) goto L20
            boolean r0 = r2.shouldAcquireNewToken()
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L1e
            if (r0 == 0) goto L44
            goto L26
        L1e:
            r3 = move-exception
            throw r3
        L20:
            boolean r0 = r2.shouldAcquireNewToken()
            if (r0 == 0) goto L44
        L26:
            io.reactivex.Observable r0 = r2.acquireNewToken()
            id.dana.data.here.HereOauthManager$$ExternalSyntheticLambda7 r1 = new id.dana.data.here.HereOauthManager$$ExternalSyntheticLambda7
            r1.<init>()
            io.reactivex.Observable r0 = r0.doOnNext(r1)     // Catch: java.lang.Exception -> L42
            id.dana.data.here.HereOauthManager$$ExternalSyntheticLambda8 r1 = new id.dana.data.here.HereOauthManager$$ExternalSyntheticLambda8     // Catch: java.lang.Exception -> L42
            r1.<init>()     // Catch: java.lang.Exception -> L42
            io.reactivex.Observable r3 = r0.doOnError(r1)     // Catch: java.lang.Exception -> L42
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)     // Catch: java.lang.Exception -> L42
            goto L48
        L42:
            r3 = move-exception
            throw r3
        L44:
            io.reactivex.Observable r3 = r2.useExistingToken()
        L48:
            int r0 = id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory
            int r0 = r0 + 99
            int r1 = r0 % 128
            id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.here.HereOauthManager.getToken(id.dana.domain.tracker.HereMixPanelTrackerData):io.reactivex.Observable");
    }

    /* renamed from: getToken$lambda-15 */
    private static final void m1358getToken$lambda15(HereMixPanelTrackerData hereMixPanelTrackerData, HereOauthManager hereOauthManager, HereAuthentication hereAuthentication) {
        int i = MyBillsEntityDataFactory + 81;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? '9' : ';') != ';') {
            try {
                Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
                Intrinsics.checkNotNullParameter(hereOauthManager, "");
                hereMixPanelTrackerData.setSuccess(true);
                hereMixPanelTrackerData.setUsage(TrackerDataKey.HEREProperties.UsageProperties.OAUTH_TOKEN);
                hereOauthManager.hereMixPanelTracker.track(hereMixPanelTrackerData);
            } catch (Exception e) {
                throw e;
            }
        } else {
            Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
            Intrinsics.checkNotNullParameter(hereOauthManager, "");
            hereMixPanelTrackerData.setSuccess(true);
            hereMixPanelTrackerData.setUsage(TrackerDataKey.HEREProperties.UsageProperties.OAUTH_TOKEN);
            hereOauthManager.hereMixPanelTracker.track(hereMixPanelTrackerData);
        }
        int i2 = MyBillsEntityDataFactory + 61;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
    }

    /* renamed from: getToken$lambda-18 */
    private static final void m1359getToken$lambda18(HereOauthManager hereOauthManager, HereMixPanelTrackerData hereMixPanelTrackerData, Throwable th) {
        ErrorHereData errorHereData;
        int i = MyBillsEntityDataFactory + 41;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? '6' : '\\') != '6') {
            try {
                Intrinsics.checkNotNullParameter(hereOauthManager, "");
                try {
                    Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
                    Intrinsics.checkNotNullExpressionValue(th, "");
                    errorHereData = hereOauthManager.getErrorHereData(th);
                    if (errorHereData == null) {
                        return;
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            Intrinsics.checkNotNullParameter(hereOauthManager, "");
            Intrinsics.checkNotNullParameter(hereMixPanelTrackerData, "");
            Intrinsics.checkNotNullExpressionValue(th, "");
            errorHereData = hereOauthManager.getErrorHereData(th);
            Object obj = null;
            obj.hashCode();
            if ((errorHereData != null ? ',' : '^') == '^') {
                return;
            }
        }
        int i2 = MyBillsEntityDataFactory + 85;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        int i3 = i2 % 2;
        hereMixPanelTrackerData.setSuccess(false);
        hereMixPanelTrackerData.setErrorCode(errorHereData.getErrorCode());
        hereMixPanelTrackerData.setFailReason(errorHereData.getMessage());
        hereMixPanelTrackerData.setUsage(TrackerDataKey.HEREProperties.UsageProperties.OAUTH_TOKEN);
        hereOauthManager.hereMixPanelTracker.track(hereMixPanelTrackerData);
    }

    private final Observable<HereAuthentication> useExistingToken() {
        int i = MyBillsEntityDataFactory + 11;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Observable<HereAuthentication> just = Observable.just(this.hereAuthentication);
        Intrinsics.checkNotNullExpressionValue(just, "");
        int i3 = MyBillsEntityDataFactory + 57;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        if (i3 % 2 == 0) {
            return just;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return just;
    }

    private final boolean shouldAcquireNewToken() {
        int i = MyBillsEntityDataFactory + 103;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        boolean isExpire = this.hereAuthentication.isExpire();
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
        MyBillsEntityDataFactory = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 14 / 0;
            return isExpire;
        }
        return isExpire;
    }

    private final Observable<HereAuthentication> acquireNewToken() {
        String encode = URLEncoder.encode(HMAC_SHA256, ENC);
        String encode2 = URLEncoder.encode(UUID.randomUUID().toString(), ENC);
        String encode3 = URLEncoder.encode(getTimestampInSeconds(), ENC);
        String encode4 = URLEncoder.encode(BuildConfig.HERE_KEY_ID, ENC);
        String encode5 = URLEncoder.encode(CLIENT_CREDENTIALS, ENC);
        String encode6 = URLEncoder.encode("1.0", ENC);
        Intrinsics.checkNotNullExpressionValue(encode5, "");
        Intrinsics.checkNotNullExpressionValue(encode4, "");
        Intrinsics.checkNotNullExpressionValue(encode2, "");
        Intrinsics.checkNotNullExpressionValue(encode, "");
        Intrinsics.checkNotNullExpressionValue(encode3, "");
        Intrinsics.checkNotNullExpressionValue(encode6, "");
        Observable<HereAuthentication> onErrorResumeNext = this.hereTokenApi.getToken("application/x-www-form-urlencoded", generateAuthorizationValue(encode4, encode, encode3, encode2, encode6, generateSignature(generateBaseString(generateBaseSignature(encode5, encode4, encode2, encode, encode3, encode6)))), CLIENT_CREDENTIALS).map(new Function() { // from class: id.dana.data.here.HereOauthManager$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return HereOauthManager.m1350$r8$lambda$el0aYocvWBTzWouBOveXyFK5Fs(HereOauthManager.this, (HereTokenResponse) obj);
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.data.here.HereOauthManager$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return HereOauthManager.$r8$lambda$E0yrE6_9g8ztAdopWCcz2ARDxjM(HereOauthManager.this, (Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        int i = MyBillsEntityDataFactory + 19;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? Typography.dollar : (char) 19) != '$') {
            Object[] objArr = null;
            int length = objArr.length;
            return onErrorResumeNext;
        }
        return onErrorResumeNext;
    }

    /* renamed from: acquireNewToken$lambda-19 */
    private static final HereAuthentication m1351acquireNewToken$lambda19(HereOauthManager hereOauthManager, HereTokenResponse hereTokenResponse) {
        HereAuthentication lastToken;
        int i = MyBillsEntityDataFactory + 117;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 != 0)) {
            try {
                Intrinsics.checkNotNullParameter(hereOauthManager, "");
                try {
                    Intrinsics.checkNotNullParameter(hereTokenResponse, "");
                    hereOauthManager.resetBackoffData();
                    lastToken = hereOauthManager.setLastToken(hereTokenResponse);
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            Intrinsics.checkNotNullParameter(hereOauthManager, "");
            Intrinsics.checkNotNullParameter(hereTokenResponse, "");
            hereOauthManager.resetBackoffData();
            lastToken = hereOauthManager.setLastToken(hereTokenResponse);
            int i2 = 5 / 0;
        }
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 83;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        return lastToken;
    }

    /* renamed from: acquireNewToken$lambda-20 */
    private static final ObservableSource m1352acquireNewToken$lambda20(HereOauthManager hereOauthManager, Throwable th) {
        int i = MyBillsEntityDataFactory + 57;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 != 0 ? (char) 11 : InputCardNumberView.DIVIDER) != 11) {
            try {
                Intrinsics.checkNotNullParameter(hereOauthManager, "");
                Intrinsics.checkNotNullParameter(th, "");
                return hereOauthManager.handleGetTokenError(th);
            } catch (Exception e) {
                throw e;
            }
        }
        Intrinsics.checkNotNullParameter(hereOauthManager, "");
        Intrinsics.checkNotNullParameter(th, "");
        Observable handleGetTokenError = hereOauthManager.handleGetTokenError(th);
        Object obj = null;
        obj.hashCode();
        return handleGetTokenError;
    }

    private final String generateAuthorizationValue(String consumerKeyEncoded, String hmacSha256Encoded, String timeStampEndcoded, String uniqueIDEncoded, String versionEncoded, String r8) {
        StringBuilder sb = new StringBuilder();
        sb.append("OAuth oauth_consumer_key=\"");
        sb.append(consumerKeyEncoded);
        sb.append("\",oauth_signature_method=\"");
        sb.append(hmacSha256Encoded);
        sb.append("\",oauth_timestamp=\"");
        sb.append(timeStampEndcoded);
        sb.append("\",oauth_nonce=\"");
        sb.append(uniqueIDEncoded);
        sb.append("\",oauth_version=\"");
        sb.append(versionEncoded);
        sb.append("\",oauth_signature=\"");
        sb.append(r8);
        sb.append(Typography.quote);
        String obj = sb.toString();
        try {
            int i = MyBillsEntityDataFactory + 111;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            return obj;
        } catch (Exception e) {
            throw e;
        }
    }

    private final String generateSignature(String baseString) {
        Mac sha256Hashing = getSha256Hashing();
        Charset forName = Charset.forName(ENC);
        Intrinsics.checkNotNullExpressionValue(forName, "");
        byte[] bytes = baseString.getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        byte[] encode = Base64.encode(sha256Hashing.doFinal(bytes), 0);
        Intrinsics.checkNotNullExpressionValue(encode, "");
        String encode2 = URLEncoder.encode(StringsKt.trim((CharSequence) new String(encode, Charsets.UTF_8)).toString(), ENC);
        Intrinsics.checkNotNullExpressionValue(encode2, "");
        try {
            int i = MyBillsEntityDataFactory + 53;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            return encode2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final Mac getSha256Hashing() {
        Mac mac = Mac.getInstance(HMAC_SHA256);
        Intrinsics.checkNotNullExpressionValue(mac, "");
        Charset forName = Charset.forName(ENC);
        Intrinsics.checkNotNullExpressionValue(forName, "");
        byte[] bytes = "EH3tKuueP_pAm2uR4_xXah-hV2f0b0VQkwfD5USMxeHuTk2FU72zvJ3FU02n8-rn91jS0YdIJyHv-912crnApg&".getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        mac.init(new SecretKeySpec(bytes, HASHING_ALGORITHM));
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 7;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 == 0 ? (char) 19 : 'N') != 'N') {
            Object[] objArr = null;
            int length = objArr.length;
            return mac;
        }
        return mac;
    }

    private final String generateBaseString(String signatureBaseString) {
        String encode = URLEncoder.encode("https://account.api.here.com/oauth2/token", ENC);
        StringBuilder sb = new StringBuilder();
        sb.append("POST&");
        sb.append(encode);
        sb.append(Typography.amp);
        sb.append(signatureBaseString);
        String obj = sb.toString();
        int i = MyBillsEntityDataFactory + 77;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (!(i % 2 != 0)) {
            return obj;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return obj;
    }

    private final String generateBaseSignature(String grantTypeEncoded, String consumerKeyEncoded, String uniqueIDEncoded, String hmacSha256Encoded, String timeStampEndcoded, String versionEncoded) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(URLEncoder.encode("grant_type", ENC));
            sb.append('=');
            sb.append(grantTypeEncoded);
            sb.append(Typography.amp);
            sb.append(URLEncoder.encode(CONSUMER_KEY_PARAM, ENC));
            sb.append('=');
            sb.append(consumerKeyEncoded);
            sb.append(Typography.amp);
            sb.append(URLEncoder.encode(NONCE_PARAM, ENC));
            sb.append('=');
            sb.append(uniqueIDEncoded);
            sb.append(Typography.amp);
            sb.append(URLEncoder.encode(SIGNATURE_METHOD_PARAM, ENC));
            sb.append('=');
            sb.append(hmacSha256Encoded);
            sb.append(Typography.amp);
            sb.append(URLEncoder.encode(TIMESTAMP_PARAM, ENC));
            sb.append('=');
            sb.append(timeStampEndcoded);
            sb.append(Typography.amp);
            sb.append(URLEncoder.encode(VERSION_PARAM, ENC));
            sb.append('=');
            sb.append(versionEncoded);
            String encode = URLEncoder.encode(sb.toString(), ENC);
            Intrinsics.checkNotNullExpressionValue(encode, "");
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
            MyBillsEntityDataFactory = i % 128;
            if ((i % 2 == 0 ? 'N' : '\f') != 'N') {
                return encode;
            }
            Object obj = null;
            obj.hashCode();
            return encode;
        } catch (Exception e) {
            throw e;
        }
    }

    private final String getTimestampInSeconds() {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 89;
            try {
                MyBillsEntityDataFactory = i % 128;
                int i2 = i % 2;
                String valueOf = String.valueOf(Calendar.getInstance().getTimeInMillis() / 1000);
                int i3 = MyBillsEntityDataFactory + 77;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if ((i3 % 2 != 0 ? 'X' : (char) 29) != 'X') {
                    return valueOf;
                }
                Object obj = null;
                obj.hashCode();
                return valueOf;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void setHereConfig(HereConfigResponse hereConfigResponse) {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        MyBillsEntityDataFactory = i % 128;
        if ((i % 2 == 0 ? '+' : 'E') != 'E') {
            Intrinsics.checkNotNullParameter(hereConfigResponse, "");
            this.hereConfig = hereConfigResponse;
            resetBackoffData();
            Object obj = null;
            obj.hashCode();
        } else {
            Intrinsics.checkNotNullParameter(hereConfigResponse, "");
            this.hereConfig = hereConfigResponse;
            resetBackoffData();
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 69;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0039, code lost:
    
        if ((r2 == null) != false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0042, code lost:
    
        if (r2 != null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0044, code lost:
    
        r5 = id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory + 101;
        id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2 = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x004e, code lost:
    
        if ((r5 % 2) == 0) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0050, code lost:
    
        r2 = r2.intValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0056, code lost:
    
        r5 = 96 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x005a, code lost:
    
        r2 = r2.intValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x005f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0060, code lost:
    
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void saveBackoffData() {
        /*
            r7 = this;
            int r0 = id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 59
            int r1 = r0 % 128
            id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            id.dana.data.here.source.local.HereAuthenticationPreference r0 = r7.hereAuthenticationPreference
            id.dana.data.here.model.HereBackoffData r0 = r0.getBackoffData()
            int r1 = r0.getBackoffTime()
            id.dana.data.here.model.HereConfigResponse r2 = r7.hereConfig
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L1c
            r5 = 1
            goto L1d
        L1c:
            r5 = 0
        L1d:
            if (r5 == r4) goto L20
            goto L61
        L20:
            int r5 = id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory
            int r5 = r5 + 43
            int r6 = r5 % 128
            id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2 = r6
            int r5 = r5 % 2
            if (r5 == 0) goto L3e
            java.lang.Integer r2 = r2.getFactor()
            r5 = 0
            r5.hashCode()     // Catch: java.lang.Throwable -> L3c
            if (r2 == 0) goto L38
            r5 = 0
            goto L39
        L38:
            r5 = 1
        L39:
            if (r5 == 0) goto L44
            goto L61
        L3c:
            r0 = move-exception
            throw r0
        L3e:
            java.lang.Integer r2 = r2.getFactor()
            if (r2 == 0) goto L61
        L44:
            int r5 = id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory
            int r5 = r5 + 101
            int r6 = r5 % 128
            id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2 = r6
            int r5 = r5 % 2
            if (r5 == 0) goto L5a
            int r2 = r2.intValue()
            r5 = 96
            int r5 = r5 / r3
            goto L62
        L58:
            r0 = move-exception
            throw r0
        L5a:
            int r2 = r2.intValue()     // Catch: java.lang.Exception -> L5f
            goto L62
        L5f:
            r0 = move-exception
            throw r0
        L61:
            r2 = 3
        L62:
            int r1 = r1 + r2
            id.dana.data.here.model.HereConfigResponse r2 = r7.hereConfig     // Catch: java.lang.Exception -> L9d
            r3 = 65
            if (r2 == 0) goto L6c
            r5 = 65
            goto L6e
        L6c:
            r5 = 73
        L6e:
            r6 = 60
            if (r5 == r3) goto L73
            goto L87
        L73:
            java.lang.Integer r2 = r2.getMaxBackoff()
            r3 = 40
            if (r2 == 0) goto L7e
            r5 = 40
            goto L80
        L7e:
            r5 = 60
        L80:
            if (r5 == r3) goto L83
            goto L87
        L83:
            int r6 = r2.intValue()
        L87:
            r0.setStatus(r4)
            long r2 = java.lang.System.currentTimeMillis()
            r0.setLastFetch(r2)
            if (r1 <= r6) goto L94
            r1 = r6
        L94:
            r0.setBackoffTime(r1)
            id.dana.data.here.source.local.HereAuthenticationPreference r1 = r7.hereAuthenticationPreference
            r1.saveBackoffData(r0)
            return
        L9d:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.here.HereOauthManager.saveBackoffData():void");
    }

    private final void resetBackoffData() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 81;
        MyBillsEntityDataFactory = i % 128;
        if (!(i % 2 != 0)) {
            this.hereAuthenticationPreference.resetBackoffData();
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            this.hereAuthenticationPreference.resetBackoffData();
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 65;
        MyBillsEntityDataFactory = i2 % 128;
        if ((i2 % 2 == 0 ? 'G' : ']') != 'G') {
            return;
        }
        int i3 = 89 / 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0020, code lost:
    
        if (r0.getStatus() != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0023, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0038, code lost:
    
        if ((r0.getStatus() ? 'Z' : '`') != 'Z') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0057, code lost:
    
        if (java.lang.System.currentTimeMillis() < (r0.getLastFetch() + (r0.getBackoffTime() * 1000))) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0059, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x005c, code lost:
    
        r2 = id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2 + 55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0060, code lost:
    
        id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory = r2 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0064, code lost:
    
        if ((r2 % 2) != 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0066, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0067, code lost:
    
        if (r3 == true) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0069, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x006a, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x006b, code lost:
    
        r1 = r1.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x006c, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x006f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0070, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean checkBackoffData() {
        /*
            r10 = this;
            int r0 = id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory
            r1 = 1
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r0 = r0 % 2
            r2 = 26
            if (r0 == 0) goto L11
            r0 = 26
            goto L13
        L11:
            r0 = 52
        L13:
            r3 = 0
            if (r0 == r2) goto L25
            id.dana.data.here.source.local.HereAuthenticationPreference r0 = r10.hereAuthenticationPreference
            id.dana.data.here.model.HereBackoffData r0 = r0.getBackoffData()
            boolean r2 = r0.getStatus()
            if (r2 == 0) goto L23
            goto L3b
        L23:
            r0 = 0
            goto L5a
        L25:
            id.dana.data.here.source.local.HereAuthenticationPreference r0 = r10.hereAuthenticationPreference     // Catch: java.lang.Exception -> L71
            id.dana.data.here.model.HereBackoffData r0 = r0.getBackoffData()     // Catch: java.lang.Exception -> L71
            boolean r2 = r0.getStatus()     // Catch: java.lang.Exception -> L71
            r4 = 90
            if (r2 == 0) goto L36
            r2 = 90
            goto L38
        L36:
            r2 = 96
        L38:
            if (r2 == r4) goto L3b
            goto L59
        L3b:
            int r2 = id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2
            int r2 = r2 + 119
            int r4 = r2 % 128
            id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory = r4
            int r2 = r2 % 2
            long r4 = java.lang.System.currentTimeMillis()
            long r6 = r0.getLastFetch()
            int r0 = r0.getBackoffTime()
            int r0 = r0 * 1000
            long r8 = (long) r0
            long r6 = r6 + r8
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 >= 0) goto L23
        L59:
            r0 = 1
        L5a:
            int r2 = id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L6f
            int r2 = r2 + 55
            int r4 = r2 % 128
            id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory = r4     // Catch: java.lang.Exception -> L71
            int r2 = r2 % 2
            if (r2 != 0) goto L67
            r3 = 1
        L67:
            if (r3 == r1) goto L6a
            return r0
        L6a:
            r1 = 0
            int r1 = r1.length     // Catch: java.lang.Throwable -> L6d
            return r0
        L6d:
            r0 = move-exception
            throw r0
        L6f:
            r0 = move-exception
            throw r0
        L71:
            r0 = move-exception
            goto L74
        L73:
            throw r0
        L74:
            goto L73
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.here.HereOauthManager.checkBackoffData():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0018, code lost:
    
        if (r5 != null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x001d, code lost:
    
        if (r5 != null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x001f, code lost:
    
        r5 = r5.BuiltInFictitiousFunctionClassFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0021, code lost:
    
        r0 = id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2 + 31;
        id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x002c, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x002d, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x002e, code lost:
    
        r5 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final id.dana.data.here.model.ErrorHereResponse getErrorHereBody(retrofit2.HttpException r5) {
        /*
            r4 = this;
            int r0 = id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 67
            int r1 = r0 % 128
            id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 1
            if (r0 != 0) goto Lf
            r0 = 0
            goto L10
        Lf:
            r0 = 1
        L10:
            r2 = 0
            retrofit2.Response r5 = r5.response()
            if (r0 == r1) goto L1d
            int r0 = r2.length     // Catch: java.lang.Throwable -> L1b
            if (r5 == 0) goto L2e
            goto L1f
        L1b:
            r5 = move-exception
            throw r5
        L1d:
            if (r5 == 0) goto L2e
        L1f:
            okhttp3.ResponseBody r5 = r5.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L2c
            int r0 = id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 31
            int r3 = r0 % 128
            id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory = r3
            int r0 = r0 % 2
            goto L2f
        L2c:
            r5 = move-exception
            throw r5
        L2e:
            r5 = r2
        L2f:
            com.google.gson.Gson r0 = r4.gson     // Catch: java.lang.Exception -> L53
            r3 = 30
            if (r5 == 0) goto L36
            goto L38
        L36:
            r1 = 30
        L38:
            if (r1 == r3) goto L49
            java.io.Reader r5 = r5.charStream()     // Catch: java.lang.Exception -> L53
            int r1 = id.dana.data.here.HereOauthManager.MyBillsEntityDataFactory
            int r1 = r1 + 87
            int r3 = r1 % 128
            id.dana.data.here.HereOauthManager.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r1 = r1 % 2
            goto L4a
        L49:
            r5 = r2
        L4a:
            java.lang.Class<id.dana.data.here.model.ErrorHereResponse> r1 = id.dana.data.here.model.ErrorHereResponse.class
            java.lang.Object r5 = r0.fromJson(r5, r1)     // Catch: java.lang.Exception -> L53
            id.dana.data.here.model.ErrorHereResponse r5 = (id.dana.data.here.model.ErrorHereResponse) r5     // Catch: java.lang.Exception -> L53
            r2 = r5
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.here.HereOauthManager.getErrorHereBody(retrofit2.HttpException):id.dana.data.here.model.ErrorHereResponse");
    }

    /* renamed from: fetchHereConfig$lambda-9 */
    private static final HereConfigResponse m1357fetchHereConfig$lambda9(BaseTrafficType baseTrafficType) {
        Intrinsics.checkNotNullParameter(baseTrafficType, "");
        Object hereConfigResponse = new HereConfigResponse(null, null, null, 7, null);
        Object[] objArr = new Object[1];
        a(1 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), 10 - ExpandableListView.getPackedPositionChild(0L), (char) View.MeasureSpec.getSize(0), objArr);
        String authRequestContext = baseTrafficType.getAuthRequestContext(((String) objArr[0]).intern(), false);
        if (!(!HereConfigResponse.class.isAssignableFrom(JSONArray.class))) {
            hereConfigResponse = (HereConfigResponse) new JSONArray(authRequestContext != null ? authRequestContext : "");
        } else if (authRequestContext != null) {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 115;
            MyBillsEntityDataFactory = i % 128;
            Object obj = null;
            try {
                if (!(i % 2 == 0)) {
                    obj = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, null), (Class<Object>) HereConfigResponse.class);
                } else {
                    Object fromJson = JSONExtKt.PlaceComponentResult().fromJson(JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, null), (Class<Object>) HereConfigResponse.class);
                    int i2 = 40 / 0;
                    obj = fromJson;
                }
            } catch (Exception unused) {
            }
            if (obj != null) {
                hereConfigResponse = obj;
            } else {
                int i3 = MyBillsEntityDataFactory + 85;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
            }
        }
        return (HereConfigResponse) hereConfigResponse;
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        int i3;
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? ',' : '\\') != ',') {
                break;
            }
            int i4 = $11 + 27;
            $10 = i4 % 128;
            int i5 = i4 % 2;
            try {
                jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (getAuthRequestContext[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ PlaceComponentResult))) ^ c;
                whenavailable.BuiltInFictitiousFunctionClassFactory++;
                int i6 = $11 + 21;
                $10 = i6 % 128;
                int i7 = i6 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? (char) 29 : '.') == '.') {
                String str = new String(cArr);
                int i8 = $10 + 57;
                $11 = i8 % 128;
                int i9 = i8 % 2;
                objArr[0] = str;
                return;
            }
            int i10 = $10 + 89;
            $11 = i10 % 128;
            if (i10 % 2 != 0) {
                cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                i3 = whenavailable.BuiltInFictitiousFunctionClassFactory + 1;
            } else {
                cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                i3 = whenavailable.BuiltInFictitiousFunctionClassFactory >> 1;
            }
            whenavailable.BuiltInFictitiousFunctionClassFactory = i3;
        }
    }
}
