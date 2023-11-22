package com.twilio.verify.domain.factor;

import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.data.DateParserKt;
import com.twilio.verify.domain.factor.models.Config;
import com.twilio.verify.domain.factor.models.FactorDataPayload;
import com.twilio.verify.domain.factor.models.PushFactor;
import com.twilio.verify.models.Factor;
import com.twilio.verify.models.FactorStatus;
import com.twilio.verify.models.FactorType;
import java.util.Date;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000fJ\u0015\u0010\u0007\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0011J\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u0012J'\u0010\u0007\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0015"}, d2 = {"Lcom/twilio/verify/domain/factor/FactorMapper;", "", "Lorg/json/JSONObject;", "p0", "Lcom/twilio/verify/domain/factor/models/FactorDataPayload;", "p1", "Lcom/twilio/verify/models/Factor;", "MyBillsEntityDataFactory", "(Lorg/json/JSONObject;Lcom/twilio/verify/domain/factor/models/FactorDataPayload;)Lcom/twilio/verify/models/Factor;", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lcom/twilio/verify/models/Factor;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lorg/json/JSONObject;)Ljava/lang/String;", "", "(Ljava/lang/String;)Z", "Lcom/twilio/verify/models/FactorStatus;", "(Lorg/json/JSONObject;)Lcom/twilio/verify/models/FactorStatus;", "(Lcom/twilio/verify/models/Factor;)Ljava/lang/String;", "p2", "Lcom/twilio/verify/domain/factor/models/PushFactor;", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)Lcom/twilio/verify/domain/factor/models/PushFactor;", "<init>", "()V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class FactorMapper {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 8, 0})
    /* loaded from: classes3.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] MyBillsEntityDataFactory;
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[FactorType.values().length];
            getAuthRequestContext = iArr;
            iArr[FactorType.PUSH.ordinal()] = 1;
            int[] iArr2 = new int[FactorType.values().length];
            MyBillsEntityDataFactory = iArr2;
            iArr2[FactorType.PUSH.ordinal()] = 1;
        }
    }

    public static Factor MyBillsEntityDataFactory(JSONObject p0, FactorDataPayload p1) throws TwilioVerifyException {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        String placeComponentResult = p1.getPlaceComponentResult();
        String myBillsEntityDataFactory = p1.getMyBillsEntityDataFactory();
        if (!(placeComponentResult.length() == 0)) {
            if (!(myBillsEntityDataFactory.length() == 0)) {
                if (WhenMappings.getAuthRequestContext[p1.getNetworkUserEntityData$$ExternalSyntheticLambda0().ordinal()] == 1) {
                    return MyBillsEntityDataFactory(placeComponentResult, myBillsEntityDataFactory, p0);
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ServiceSid or Identity is null or empty");
        Logger logger = Logger.PlaceComponentResult;
        Level level = Level.Error;
        String obj = illegalArgumentException.toString();
        IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
        Logger.KClassImpl$Data$declaredNonStaticMembers$2(level, obj, illegalArgumentException2);
        throw new TwilioVerifyException(illegalArgumentException2, TwilioVerifyException.ErrorCode.MapperError);
    }

    public static FactorStatus MyBillsEntityDataFactory(JSONObject p0) throws TwilioVerifyException {
        FactorStatus factorStatus;
        Intrinsics.checkParameterIsNotNull(p0, "");
        try {
            FactorStatus[] values = FactorStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    factorStatus = null;
                    break;
                }
                factorStatus = values[i];
                if (Intrinsics.areEqual(factorStatus.getValue(), p0.getString("status"))) {
                    break;
                }
                i++;
            }
            return factorStatus == null ? FactorStatus.Unverified : factorStatus;
        } catch (JSONException e) {
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Error;
            String obj = e.toString();
            JSONException jSONException = e;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(level, obj, jSONException);
            throw new TwilioVerifyException(jSONException, TwilioVerifyException.ErrorCode.MapperError);
        }
    }

    public static Factor BuiltInFictitiousFunctionClassFactory(String p0) throws TwilioVerifyException {
        Intrinsics.checkParameterIsNotNull(p0, "");
        try {
            JSONObject jSONObject = new JSONObject(p0);
            String optString = jSONObject.optString("service_sid");
            String optString2 = jSONObject.optString("entity_identity");
            String str = optString;
            if (!(str == null || str.length() == 0)) {
                String str2 = optString2;
                if (!(str2 == null || str2.length() == 0)) {
                    if (Intrinsics.areEqual(jSONObject.getString("type"), FactorType.PUSH.getFactorTypeName())) {
                        PushFactor MyBillsEntityDataFactory = MyBillsEntityDataFactory(optString, optString2, jSONObject);
                        MyBillsEntityDataFactory.getErrorConfigVersion = jSONObject.optString("key_pair");
                        return MyBillsEntityDataFactory;
                    }
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid factor type from json");
                    Logger logger = Logger.PlaceComponentResult;
                    Level level = Level.Error;
                    String obj = illegalArgumentException.toString();
                    IllegalArgumentException illegalArgumentException2 = illegalArgumentException;
                    Logger.KClassImpl$Data$declaredNonStaticMembers$2(level, obj, illegalArgumentException2);
                    throw new TwilioVerifyException(illegalArgumentException2, TwilioVerifyException.ErrorCode.MapperError);
                }
            }
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("ServiceSid or Identity is null or empty");
            Logger logger2 = Logger.PlaceComponentResult;
            Level level2 = Level.Error;
            String obj2 = illegalArgumentException3.toString();
            IllegalArgumentException illegalArgumentException4 = illegalArgumentException3;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(level2, obj2, illegalArgumentException4);
            throw new TwilioVerifyException(illegalArgumentException4, TwilioVerifyException.ErrorCode.MapperError);
        } catch (JSONException e) {
            Logger logger3 = Logger.PlaceComponentResult;
            Level level3 = Level.Error;
            String obj3 = e.toString();
            JSONException jSONException = e;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(level3, obj3, jSONException);
            throw new TwilioVerifyException(jSONException, TwilioVerifyException.ErrorCode.MapperError);
        }
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(Factor p0) throws TwilioVerifyException {
        Intrinsics.checkParameterIsNotNull(p0, "");
        if (WhenMappings.MyBillsEntityDataFactory[p0.getScheduleImpl().ordinal()] == 1) {
            PushFactor pushFactor = (PushFactor) p0;
            String jSONObject = new JSONObject().put("sid", p0.getLookAheadTest()).put("friendly_name", p0.getKClassImpl$Data$declaredNonStaticMembers$2()).put("account_sid", p0.getPlaceComponentResult()).put("service_sid", p0.getMoveToNextValue()).put("entity_identity", p0.getBuiltInFictitiousFunctionClassFactory()).put("type", p0.getScheduleImpl().getFactorTypeName()).put("key_pair", pushFactor.getErrorConfigVersion).put("status", p0.getNetworkUserEntityData$$ExternalSyntheticLambda0().getValue()).put("config", new JSONObject().put("credential_sid", pushFactor.getAuthRequestContext.PlaceComponentResult)).put("date_created", DateParserKt.getAuthRequestContext(p0.getMyBillsEntityDataFactory())).toString();
            Intrinsics.checkExpressionValueIsNotNull(jSONObject, "");
            return jSONObject;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static PushFactor MyBillsEntityDataFactory(String p0, String p1, JSONObject p2) throws TwilioVerifyException {
        FactorStatus factorStatus;
        try {
            String string = p2.getString("sid");
            Intrinsics.checkExpressionValueIsNotNull(string, "");
            String string2 = p2.getString("friendly_name");
            Intrinsics.checkExpressionValueIsNotNull(string2, "");
            String string3 = p2.getString("account_sid");
            Intrinsics.checkExpressionValueIsNotNull(string3, "");
            FactorStatus[] values = FactorStatus.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    factorStatus = null;
                    break;
                }
                factorStatus = values[i];
                if (Intrinsics.areEqual(factorStatus.getValue(), p2.getString("status"))) {
                    break;
                }
                i++;
            }
            FactorStatus factorStatus2 = factorStatus == null ? FactorStatus.Unverified : factorStatus;
            String string4 = p2.getString("date_created");
            Intrinsics.checkExpressionValueIsNotNull(string4, "");
            Date KClassImpl$Data$declaredNonStaticMembers$2 = DateParserKt.KClassImpl$Data$declaredNonStaticMembers$2(string4);
            String string5 = p2.getJSONObject("config").getString("credential_sid");
            Intrinsics.checkExpressionValueIsNotNull(string5, "");
            return new PushFactor(string, string2, string3, p0, p1, factorStatus2, KClassImpl$Data$declaredNonStaticMembers$2, new Config(string5));
        } catch (JSONException e) {
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Error;
            String obj = e.toString();
            JSONException jSONException = e;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(level, obj, jSONException);
            throw new TwilioVerifyException(jSONException, TwilioVerifyException.ErrorCode.MapperError);
        }
    }

    public static boolean MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        try {
            JSONObject jSONObject = new JSONObject(p0);
            Iterator it = CollectionsKt.listOf((Object[]) new String[]{"service_sid", "entity_identity", "sid", "account_sid"}).iterator();
            while (it.hasNext()) {
                if (!jSONObject.has((String) it.next())) {
                    return false;
                }
            }
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(JSONObject p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        String string = p0.getString("sid");
        Intrinsics.checkExpressionValueIsNotNull(string, "");
        return string;
    }
}
