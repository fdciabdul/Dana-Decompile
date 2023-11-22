package com.twilio.verify;

import android.content.Context;
import android.content.SharedPreferences;
import com.twilio.verify.data.DateAdapter;
import com.twilio.verify.data.KeyStorage;
import com.twilio.verify.data.KeyStoreAdapter;
import com.twilio.verify.data.jwt.JwtGenerator;
import com.twilio.verify.data.jwt.JwtSigner;
import com.twilio.verify.logger.LoggerService;
import com.twilio.verify.models.Challenge;
import com.twilio.verify.models.ChallengeList;
import com.twilio.verify.models.ChallengeListPayload;
import com.twilio.verify.models.Factor;
import com.twilio.verify.models.FactorPayload;
import com.twilio.verify.models.UpdateChallengePayload;
import com.twilio.verify.models.UpdateFactorPayload;
import com.twilio.verify.models.VerifyFactorPayload;
import com.twilio.verify.networking.AuthenticationProvider;
import com.twilio.verify.networking.NetworkAdapter;
import com.twilio.verify.networking.NetworkProvider;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001 J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J?\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\bH&¢\u0006\u0004\b\r\u0010\u000eJ?\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000f2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\bH&¢\u0006\u0004\b\u0011\u0010\u0012J=\u0010\u0005\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0013\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\bH&¢\u0006\u0004\b\u0005\u0010\u0014JG\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u00152\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\bH&¢\u0006\u0004\b\u0011\u0010\u0018J9\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00192\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\bH&¢\u0006\u0004\b\u001a\u0010\u001bJ?\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u001c2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\bH&¢\u0006\u0004\b\u0005\u0010\u001dJ?\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u001e2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\bH&¢\u0006\u0004\b\u0011\u0010\u001f"}, d2 = {"Lcom/twilio/verify/TwilioVerify;", "", "Lkotlin/Function0;", "", "p0", "getAuthRequestContext", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/twilio/verify/models/FactorPayload;", "Lkotlin/Function1;", "Lcom/twilio/verify/models/Factor;", "p1", "Lcom/twilio/verify/TwilioVerifyException;", "p2", "BuiltInFictitiousFunctionClassFactory", "(Lcom/twilio/verify/models/FactorPayload;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lcom/twilio/verify/models/ChallengeListPayload;", "Lcom/twilio/verify/models/ChallengeList;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lcom/twilio/verify/models/ChallengeListPayload;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "", "Lcom/twilio/verify/models/Challenge;", "p3", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lcom/twilio/verify/models/UpdateChallengePayload;", "MyBillsEntityDataFactory", "(Lcom/twilio/verify/models/UpdateChallengePayload;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "Lcom/twilio/verify/models/UpdateFactorPayload;", "(Lcom/twilio/verify/models/UpdateFactorPayload;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lcom/twilio/verify/models/VerifyFactorPayload;", "(Lcom/twilio/verify/models/VerifyFactorPayload;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Builder"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public interface TwilioVerify {
    void BuiltInFictitiousFunctionClassFactory(FactorPayload p0, Function1<? super Factor, Unit> p1, Function1<? super TwilioVerifyException, Unit> p2);

    void KClassImpl$Data$declaredNonStaticMembers$2(ChallengeListPayload p0, Function1<? super ChallengeList, Unit> p1, Function1<? super TwilioVerifyException, Unit> p2);

    void KClassImpl$Data$declaredNonStaticMembers$2(VerifyFactorPayload p0, Function1<? super Factor, Unit> p1, Function1<? super TwilioVerifyException, Unit> p2);

    void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, Function1<? super Challenge, Unit> p2, Function1<? super TwilioVerifyException, Unit> p3);

    void MyBillsEntityDataFactory(UpdateChallengePayload p0, Function0<Unit> p1, Function1<? super TwilioVerifyException, Unit> p2);

    void getAuthRequestContext(UpdateFactorPayload p0, Function1<? super Factor, Unit> p1, Function1<? super TwilioVerifyException, Unit> p2);

    void getAuthRequestContext(Function0<Unit> p0);

    void getAuthRequestContext(Function1<? super List<? extends Factor>, Unit> p0, Function1<? super TwilioVerifyException, Unit> p1);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\n¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u0007\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0013\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018"}, d2 = {"Lcom/twilio/verify/TwilioVerify$Builder;", "", "Lcom/twilio/verify/networking/AuthenticationProvider;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/twilio/verify/networking/AuthenticationProvider;", "BuiltInFictitiousFunctionClassFactory", "", "getAuthRequestContext", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "Landroid/content/Context;", "Lcom/twilio/verify/data/jwt/JwtGenerator;", "Lcom/twilio/verify/data/jwt/JwtGenerator;", "Lcom/twilio/verify/data/KeyStorage;", "PlaceComponentResult", "Lcom/twilio/verify/data/KeyStorage;", "", "Lcom/twilio/verify/logger/LoggerService;", "scheduleImpl", "Ljava/util/List;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lcom/twilio/verify/networking/NetworkProvider;", "lookAheadTest", "Lcom/twilio/verify/networking/NetworkProvider;", "p0", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 8, 0})
    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public JwtGenerator KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public AuthenticationProvider BuiltInFictitiousFunctionClassFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public Context getAuthRequestContext;
        public KeyStorage PlaceComponentResult;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public String MyBillsEntityDataFactory;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public NetworkProvider scheduleImpl;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        public List<LoggerService> NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, com.twilio.security.crypto.KeyManager] */
        public Builder(Context context) {
            Intrinsics.checkParameterIsNotNull(context, "");
            this.getAuthRequestContext = context;
            ?? r1 = 0;
            this.PlaceComponentResult = new KeyStoreAdapter(r1, 1, r1);
            this.scheduleImpl = new NetworkAdapter();
            this.MyBillsEntityDataFactory = BuildConfig.BASE_URL;
            JwtGenerator jwtGenerator = new JwtGenerator(new JwtSigner(this.PlaceComponentResult));
            this.KClassImpl$Data$declaredNonStaticMembers$2 = jwtGenerator;
            SharedPreferences PlaceComponentResult = TwilioVerifyKt.PlaceComponentResult(this.getAuthRequestContext);
            Intrinsics.checkExpressionValueIsNotNull(PlaceComponentResult, "");
            this.BuiltInFictitiousFunctionClassFactory = new AuthenticationProvider(jwtGenerator, new DateAdapter(PlaceComponentResult));
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new ArrayList();
        }
    }
}
