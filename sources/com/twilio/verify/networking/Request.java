package com.twilio.verify.networking;

import android.net.Uri;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0017BM\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0005\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\tR\u0011\u0010\u0007\u001a\u00020\u000bX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0011\u0010\f\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u0010"}, d2 = {"Lcom/twilio/verify/networking/Request;", "", "", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/Map;)Ljava/lang/String;", "getAuthRequestContext", "PlaceComponentResult", "Ljava/util/Map;", "MyBillsEntityDataFactory", "Lcom/twilio/verify/networking/HttpMethod;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/twilio/verify/networking/HttpMethod;", "Ljava/lang/String;", "Ljava/net/URL;", "Ljava/net/URL;", "p1", "p2", "p3", "p4", "<init>", "(Lcom/twilio/verify/networking/HttpMethod;Ljava/net/URL;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;)V", "Builder"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class Request {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final Map<String, String> MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final HttpMethod getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final URL KClassImpl$Data$declaredNonStaticMembers$2;
    public final Map<String, Object> PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    public Request(HttpMethod httpMethod, URL url, Map<String, ? extends Object> map, Map<String, String> map2, String str) {
        Intrinsics.checkParameterIsNotNull(httpMethod, "");
        Intrinsics.checkParameterIsNotNull(url, "");
        Intrinsics.checkParameterIsNotNull(map2, "");
        Intrinsics.checkParameterIsNotNull(str, "");
        this.getAuthRequestContext = httpMethod;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = url;
        this.PlaceComponentResult = map;
        this.MyBillsEntityDataFactory = map2;
        this.BuiltInFictitiousFunctionClassFactory = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getAuthRequestContext(Map<String, ? extends Object> p0) {
        Uri.Builder builder = new Uri.Builder();
        for (Map.Entry<String, ? extends Object> entry : p0.entrySet()) {
            builder.appendQueryParameter(entry.getKey(), String.valueOf(entry.getValue()));
        }
        Uri build = builder.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "");
        return build.getEncodedQuery();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String BuiltInFictitiousFunctionClassFactory(Map<String, ? extends Object> p0) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ? extends Object> entry : p0.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "");
        return jSONObject2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\b\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0013\u0012\u0018\b\u0002\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0010\u0012\u0018\b\u0002\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0010\u0012\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004R&\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R$\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0016\u0010\u0011\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R&\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001a"}, d2 = {"Lcom/twilio/verify/networking/Request$Builder;", "", "", "MyBillsEntityDataFactory", "()Ljava/lang/String;", "Lcom/twilio/verify/networking/Request;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lcom/twilio/verify/networking/Request;", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "", "getAuthRequestContext", "Ljava/util/Map;", "Lcom/twilio/verify/networking/HttpMethod;", "BuiltInFictitiousFunctionClassFactory", "Lcom/twilio/verify/networking/HttpMethod;", "Lcom/twilio/verify/networking/RequestHelper;", "PlaceComponentResult", "Lcom/twilio/verify/networking/RequestHelper;", "getErrorConfigVersion", "Ljava/lang/String;", "scheduleImpl", "lookAheadTest", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Lcom/twilio/verify/networking/RequestHelper;Ljava/lang/String;Lcom/twilio/verify/networking/HttpMethod;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;)V"}, k = 1, mv = {1, 8, 0})
    /* loaded from: classes4.dex */
    public static final /* data */ class Builder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public HttpMethod getAuthRequestContext;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public Map<String, ? extends Object> BuiltInFictitiousFunctionClassFactory;
        private Map<String, String> MyBillsEntityDataFactory;
        private final RequestHelper PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public Map<String, ? extends Object> KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        private String scheduleImpl;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        private final String lookAheadTest;

        public final boolean equals(Object p0) {
            if (this != p0) {
                if (p0 instanceof Builder) {
                    Builder builder = (Builder) p0;
                    return Intrinsics.areEqual(this.PlaceComponentResult, builder.PlaceComponentResult) && Intrinsics.areEqual(this.lookAheadTest, builder.lookAheadTest) && Intrinsics.areEqual(this.getAuthRequestContext, builder.getAuthRequestContext) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, builder.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, builder.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, builder.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.scheduleImpl, builder.scheduleImpl);
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            RequestHelper requestHelper = this.PlaceComponentResult;
            int hashCode = requestHelper != null ? requestHelper.hashCode() : 0;
            String str = this.lookAheadTest;
            int hashCode2 = str != null ? str.hashCode() : 0;
            HttpMethod httpMethod = this.getAuthRequestContext;
            int hashCode3 = httpMethod != null ? httpMethod.hashCode() : 0;
            Map<String, ? extends Object> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int hashCode4 = map != null ? map.hashCode() : 0;
            Map<String, ? extends Object> map2 = this.BuiltInFictitiousFunctionClassFactory;
            int hashCode5 = map2 != null ? map2.hashCode() : 0;
            Map<String, String> map3 = this.MyBillsEntityDataFactory;
            int hashCode6 = map3 != null ? map3.hashCode() : 0;
            String str2 = this.scheduleImpl;
            return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Builder(PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", lookAheadTest=");
            sb.append(this.lookAheadTest);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", scheduleImpl=");
            sb.append(this.scheduleImpl);
            sb.append(")");
            return sb.toString();
        }

        private Builder(RequestHelper requestHelper, String str, HttpMethod httpMethod, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, Map<String, String> map3, String str2) {
            Intrinsics.checkParameterIsNotNull(requestHelper, "");
            Intrinsics.checkParameterIsNotNull(str, "");
            Intrinsics.checkParameterIsNotNull(httpMethod, "");
            this.PlaceComponentResult = requestHelper;
            this.lookAheadTest = str;
            this.getAuthRequestContext = httpMethod;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = map;
            this.BuiltInFictitiousFunctionClassFactory = map2;
            this.MyBillsEntityDataFactory = map3;
            this.scheduleImpl = str2;
        }

        public /* synthetic */ Builder(RequestHelper requestHelper, String str, HttpMethod httpMethod, Map map, Map map2, Map map3, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(requestHelper, str, (i & 4) != 0 ? HttpMethod.Get : httpMethod, (i & 8) != 0 ? null : map, (i & 16) != 0 ? null : map2, (i & 32) != 0 ? null : map3, (i & 64) != 0 ? null : str2);
        }

        public final Request KClassImpl$Data$declaredNonStaticMembers$2() throws MalformedURLException {
            Map<String, String> PlaceComponentResult;
            HttpMethod httpMethod = this.getAuthRequestContext;
            URL url = new URL(MyBillsEntityDataFactory());
            Map<String, ? extends Object> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
            Map<String, String> map2 = this.MyBillsEntityDataFactory;
            if (map2 == null || (PlaceComponentResult = MapsKt.plus(this.PlaceComponentResult.PlaceComponentResult(this.getAuthRequestContext), map2)) == null) {
                PlaceComponentResult = this.PlaceComponentResult.PlaceComponentResult(this.getAuthRequestContext);
            }
            Map<String, String> map3 = PlaceComponentResult;
            String str = this.scheduleImpl;
            if (str == null) {
                str = "";
            }
            return new Request(httpMethod, url, map, map3, str);
        }

        private final String MyBillsEntityDataFactory() {
            Uri.Builder buildUpon = Uri.parse(this.lookAheadTest).buildUpon();
            Map<String, ? extends Object> map = this.BuiltInFictitiousFunctionClassFactory;
            if (map != null) {
                for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                    buildUpon.appendQueryParameter(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
            String obj = buildUpon.build().toString();
            Intrinsics.checkExpressionValueIsNotNull(obj, "");
            return obj;
        }
    }
}
