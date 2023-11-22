package id.dana.network.base;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alipay.imobile.network.quake.exception.ServerException;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import id.dana.analytics.mixpanel.MixPanelDataTracker;
import id.dana.analytics.tracker.TrackerDataKey;
import id.dana.data.login.source.network.result.NetworkUrlRpcResult;
import id.dana.network.exception.BotProtectionException;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b*\u0004\b\u0000\u0010\u00012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0002:\u0001\u001bB\u001b\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ=\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015"}, d2 = {"Lid/dana/network/base/BotProtectionExceptionParser;", "T", "Lio/reactivex/functions/Function;", "", "Lio/reactivex/ObservableSource;", SecurityConstants.KEY_TEXT, "apply", "(Ljava/lang/Throwable;)Lio/reactivex/ObservableSource;", "Lcom/alipay/imobile/network/quake/exception/ServerException;", "", "", "readServerExceptionResponse", "(Lcom/alipay/imobile/network/quake/exception/ServerException;)Ljava/util/Map;", "botScore", SemanticAttributes.FaasTriggerValues.HTTP, "operationType", NetworkUrlRpcResult.ParamsName.REFERENCE_ID, "", "trackAkamaiResponse", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "akamaiChallengeContext", "Ljava/lang/String;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BotProtectionExceptionParser<T> implements Function<Throwable, ObservableSource<T>> {
    private static final String AKAMAI_DEFAULT_PROPERTY_VALUE = "(not set)";
    private static final String CCA_ACTION = "CCA";
    private static final int CCA_ERROR_CODE = 428;
    private static final int DENY_ERROR_CODE = 403;
    private static final String DENY_ERROR_MESSAGE_EN = "Check your connection and try again";
    private static final String DENY_ERROR_MESSAGE_ID = "Ada kendala nih di jaringanmu. Coba lagi ya";
    private String akamaiChallengeContext;
    private final Context context;
    private final String operationType;

    public BotProtectionExceptionParser(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "");
        this.context = context;
        this.operationType = str;
        this.akamaiChallengeContext = "";
    }

    public /* synthetic */ BotProtectionExceptionParser(Context context, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? "" : str);
    }

    @Override // io.reactivex.functions.Function
    public final ObservableSource<T> apply(Throwable r15) {
        Observable observable;
        String str;
        Intrinsics.checkNotNullParameter(r15, "");
        if (r15 instanceof ServerException) {
            ServerException serverException = (ServerException) r15;
            Map<String, String> readServerExceptionResponse = readServerExceptionResponse(serverException);
            Map map = (Map) JSONObject.parseObject(readServerExceptionResponse != null ? readServerExceptionResponse.get("headers") : null, new TypeReference<Map<String, ? extends String>>() { // from class: id.dana.network.base.BotProtectionExceptionParser$apply$headers$1
            }, new Feature[0]);
            Map<String, String> readServerExceptionResponse2 = readServerExceptionResponse(serverException);
            Integer num = (Integer) JSONObject.parseObject(readServerExceptionResponse2 != null ? readServerExceptionResponse2.get(HiAnalyticsConstant.HaKey.BI_KEY_RESULT) : null, new TypeReference<Integer>() { // from class: id.dana.network.base.BotProtectionExceptionParser$apply$errorCode$1
            }, new Feature[0]);
            if (num != null && num.intValue() == CCA_ERROR_CODE) {
                if (map == null || (str = (String) map.get("Akamai-BM-Challenge-Context")) == null) {
                    str = "";
                }
                this.akamaiChallengeContext = str;
                if (str.length() > 0) {
                    trackAkamaiResponse$default(this, null, null, this.operationType, null, 11, null);
                    r15 = new BotProtectionException(Integer.valueOf((int) CCA_ERROR_CODE), r15, this.akamaiChallengeContext, true);
                } else {
                    observable = Observable.error(r15);
                    Intrinsics.checkNotNullExpressionValue(observable, "");
                    return observable;
                }
            } else if (num != null && num.intValue() == 403) {
                r15 = new BotProtectionException(403, new Throwable(StringsKt.equals(Locale.getDefault().getCountry(), "id", true) ? DENY_ERROR_MESSAGE_ID : DENY_ERROR_MESSAGE_EN), "", false);
            }
            observable = Observable.error(r15);
            Intrinsics.checkNotNullExpressionValue(observable, "");
            return observable;
        }
        Observable error = Observable.error(r15);
        Intrinsics.checkNotNullExpressionValue(error, "");
        return error;
    }

    private final Map<String, String> readServerExceptionResponse(ServerException r3) {
        return (Map) JSONObject.parseObject(r3.getExtInfo(), new TypeReference<Map<String, ? extends String>>() { // from class: id.dana.network.base.BotProtectionExceptionParser$readServerExceptionResponse$extInfo$1
        }, new Feature[0]);
    }

    static /* synthetic */ void trackAkamaiResponse$default(BotProtectionExceptionParser botProtectionExceptionParser, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = AKAMAI_DEFAULT_PROPERTY_VALUE;
        }
        if ((i & 2) != 0) {
            str2 = AKAMAI_DEFAULT_PROPERTY_VALUE;
        }
        if ((i & 8) != 0) {
            str4 = AKAMAI_DEFAULT_PROPERTY_VALUE;
        }
        botProtectionExceptionParser.trackAkamaiResponse(str, str2, str3, str4);
    }

    private final void trackAkamaiResponse(String botScore, String r5, String operationType, String r7) {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(TrackerDataKey.Property.ACTION_TAKEN, CCA_ACTION);
            jSONObject.put(TrackerDataKey.Property.BOT_SCORE, botScore);
            jSONObject.put(TrackerDataKey.Property.HTTP, r5);
            jSONObject.put("Operation Type", operationType);
            jSONObject.put(TrackerDataKey.Property.REFERENCE_ID, r7);
            MixPanelDataTracker.PlaceComponentResult(this.context, TrackerDataKey.Event.BOT_DETECTION, jSONObject);
        } catch (JSONException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.MIXPANEL, "Unable to add properties to JSONObject", e);
        }
    }
}
