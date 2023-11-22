package com.twilio.verify.domain.service;

import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.data.DateParserKt;
import com.twilio.verify.domain.service.models.FactorService;
import com.twilio.verify.models.Service;
import java.text.ParseException;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/twilio/verify/domain/service/ServiceMapper;", "", "Lorg/json/JSONObject;", "p0", "Lcom/twilio/verify/models/Service;", "getAuthRequestContext", "(Lorg/json/JSONObject;)Lcom/twilio/verify/models/Service;", "<init>", "()V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class ServiceMapper {
    public static Service getAuthRequestContext(JSONObject p0) throws TwilioVerifyException {
        Intrinsics.checkParameterIsNotNull(p0, "");
        try {
            String string = p0.getString("sid");
            String string2 = p0.getString("account_sid");
            String string3 = p0.getString("friendly_name");
            String string4 = p0.getString("date_created");
            String string5 = p0.getString("date_updated");
            Intrinsics.checkExpressionValueIsNotNull(string, "");
            Intrinsics.checkExpressionValueIsNotNull(string4, "");
            Date KClassImpl$Data$declaredNonStaticMembers$2 = DateParserKt.KClassImpl$Data$declaredNonStaticMembers$2(string4);
            Intrinsics.checkExpressionValueIsNotNull(string5, "");
            Date KClassImpl$Data$declaredNonStaticMembers$22 = DateParserKt.KClassImpl$Data$declaredNonStaticMembers$2(string5);
            Intrinsics.checkExpressionValueIsNotNull(string3, "");
            Intrinsics.checkExpressionValueIsNotNull(string2, "");
            return new FactorService(string, KClassImpl$Data$declaredNonStaticMembers$2, KClassImpl$Data$declaredNonStaticMembers$22, string3, string2);
        } catch (ParseException e) {
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Error;
            String obj = e.toString();
            ParseException parseException = e;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(level, obj, parseException);
            throw new TwilioVerifyException(parseException, TwilioVerifyException.ErrorCode.MapperError);
        } catch (JSONException e2) {
            Logger logger2 = Logger.PlaceComponentResult;
            Level level2 = Level.Error;
            String obj2 = e2.toString();
            JSONException jSONException = e2;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(level2, obj2, jSONException);
            throw new TwilioVerifyException(jSONException, TwilioVerifyException.ErrorCode.MapperError);
        }
    }
}
