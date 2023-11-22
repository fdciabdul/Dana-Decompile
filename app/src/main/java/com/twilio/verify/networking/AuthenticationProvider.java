package com.twilio.verify.networking;

import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.data.DateProvider;
import com.twilio.verify.data.KeyStoreAdapterKt;
import com.twilio.verify.data.jwt.JwtGenerator;
import com.twilio.verify.domain.factor.models.PushFactor;
import com.twilio.verify.models.Factor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\f"}, d2 = {"Lcom/twilio/verify/networking/AuthenticationProvider;", "Lcom/twilio/verify/networking/Authentication;", "Lcom/twilio/verify/models/Factor;", "p0", "", "MyBillsEntityDataFactory", "(Lcom/twilio/verify/models/Factor;)Ljava/lang/String;", "Lcom/twilio/verify/data/DateProvider;", "getAuthRequestContext", "Lcom/twilio/verify/data/DateProvider;", "BuiltInFictitiousFunctionClassFactory", "Lcom/twilio/verify/data/jwt/JwtGenerator;", "Lcom/twilio/verify/data/jwt/JwtGenerator;", "p1", "<init>", "(Lcom/twilio/verify/data/jwt/JwtGenerator;Lcom/twilio/verify/data/DateProvider;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class AuthenticationProvider implements Authentication {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final JwtGenerator MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final DateProvider BuiltInFictitiousFunctionClassFactory;

    public AuthenticationProvider(JwtGenerator jwtGenerator, DateProvider dateProvider) {
        Intrinsics.checkParameterIsNotNull(jwtGenerator, "");
        Intrinsics.checkParameterIsNotNull(dateProvider, "");
        this.MyBillsEntityDataFactory = jwtGenerator;
        this.BuiltInFictitiousFunctionClassFactory = dateProvider;
    }

    @Override // com.twilio.verify.networking.Authentication
    public final String MyBillsEntityDataFactory(Factor p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        try {
            if (!(p0 instanceof PushFactor)) {
                throw new IllegalArgumentException("Not supported factor for JWT generation");
            }
            PushFactor pushFactor = (PushFactor) p0;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cty", "twilio-pba;v=1");
            jSONObject.put("kid", pushFactor.getAuthRequestContext.PlaceComponentResult);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("sub", pushFactor.PlaceComponentResult);
            jSONObject2.put("exp", this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext() + TimeUnit.MINUTES.toSeconds(10L));
            jSONObject2.put("nbf", this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext());
            String str = pushFactor.getErrorConfigVersion;
            if (str == null) {
                throw new IllegalStateException("Key pair not set");
            }
            return this.MyBillsEntityDataFactory.PlaceComponentResult(KeyStoreAdapterKt.KClassImpl$Data$declaredNonStaticMembers$2(str, true), jSONObject, jSONObject2);
        } catch (Exception e) {
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Error;
            String obj = e.toString();
            Exception exc = e;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(level, obj, exc);
            throw new TwilioVerifyException(exc, TwilioVerifyException.ErrorCode.AuthenticationTokenError);
        }
    }
}
