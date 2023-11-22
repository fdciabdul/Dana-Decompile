package com.twilio.verify.api;

import android.content.Context;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.models.ChallengeListOrder;
import com.twilio.verify.models.Factor;
import com.twilio.verify.networking.Authentication;
import com.twilio.verify.networking.BasicAuthorization;
import com.twilio.verify.networking.HttpMethod;
import com.twilio.verify.networking.NetworkException;
import com.twilio.verify.networking.NetworkProvider;
import com.twilio.verify.networking.Request;
import com.twilio.verify.networking.RequestHelper;
import com.twilio.verify.networking.Response;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KDeclarationContainer;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "retries", "", BridgeDSL.INVOKE, "(I)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class ChallengeAPIClient$getAll$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ Function1 $$error;
    final /* synthetic */ Factor $$factor;
    final /* synthetic */ ChallengeListOrder $$order;
    final /* synthetic */ int $$pageSize;
    final /* synthetic */ String $$pageToken;
    final /* synthetic */ String $$status;
    final /* synthetic */ Function1 $$success;
    final /* synthetic */ ChallengeAPIClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChallengeAPIClient$getAll$1(ChallengeAPIClient challengeAPIClient, Factor factor, int i, ChallengeListOrder challengeListOrder, String str, String str2, Function1 function1, Function1 function12) {
        super(1);
        this.this$0 = challengeAPIClient;
        this.$$factor = factor;
        this.$$pageSize = i;
        this.$$order = challengeListOrder;
        this.$$status = str;
        this.$$pageToken = str2;
        this.$$success = function1;
        this.$$error = function12;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void invoke$default(ChallengeAPIClient$getAll$1 challengeAPIClient$getAll$1, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        challengeAPIClient$getAll$1.invoke(i);
    }

    public final void invoke(final int i) {
        Authentication authentication;
        Context context;
        NetworkProvider networkProvider;
        try {
            authentication = this.this$0.MyBillsEntityDataFactory;
            String MyBillsEntityDataFactory = authentication.MyBillsEntityDataFactory(this.$$factor);
            context = this.this$0.BuiltInFictitiousFunctionClassFactory;
            RequestHelper requestHelper = new RequestHelper(context, new BasicAuthorization("token", MyBillsEntityDataFactory));
            Pair[] pairArr = new Pair[3];
            pairArr[0] = TuplesKt.to("PageSize", Integer.valueOf(this.$$pageSize));
            pairArr[1] = TuplesKt.to("FactorSid", this.$$factor.getLookAheadTest());
            String name = this.$$order.name();
            if (name != null) {
                String lowerCase = name.toLowerCase();
                Intrinsics.checkExpressionValueIsNotNull(lowerCase, "");
                pairArr[2] = TuplesKt.to("Order", lowerCase);
                Map<String, ? extends Object> mutableMapOf = MapsKt.mutableMapOf(pairArr);
                String str = this.$$status;
                if (str != null) {
                    mutableMapOf.put("Status", str);
                }
                String str2 = this.$$pageToken;
                if (str2 != null) {
                    mutableMapOf.put("PageToken", str2);
                }
                Request.Builder builder = new Request.Builder(requestHelper, ChallengeAPIClient.getAuthRequestContext(this.this$0, this.$$factor), null, null, null, null, null, 124, null);
                HttpMethod httpMethod = HttpMethod.Get;
                Intrinsics.checkParameterIsNotNull(httpMethod, "");
                Request.Builder builder2 = builder;
                builder.getAuthRequestContext = httpMethod;
                Intrinsics.checkParameterIsNotNull(mutableMapOf, "");
                Request.Builder builder3 = builder;
                builder.BuiltInFictitiousFunctionClassFactory = mutableMapOf;
                Request KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2();
                networkProvider = this.this$0.getAuthRequestContext;
                networkProvider.BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2, new Function1<Response, Unit>() { // from class: com.twilio.verify.api.ChallengeAPIClient$getAll$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        ChallengeAPIClient$getAll$1.this = this;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(Response response) {
                        invoke2(response);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke */
                    public final void invoke2(Response response) {
                        Intrinsics.checkParameterIsNotNull(response, "");
                        ChallengeAPIClient$getAll$1.this.$$success.invoke(new JSONObject(response.KClassImpl$Data$declaredNonStaticMembers$2));
                    }
                }, new Function1<NetworkException, Unit>() { // from class: com.twilio.verify.api.ChallengeAPIClient$getAll$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        ChallengeAPIClient$getAll$1.this = this;
                    }

                    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "retries", BridgeDSL.INVOKE}, k = 3, mv = {1, 1, 16})
                    /* renamed from: com.twilio.verify.api.ChallengeAPIClient$getAll$1$4$1 */
                    /* loaded from: classes3.dex */
                    public static final /* synthetic */ class AnonymousClass1 extends FunctionReference implements Function1<Integer, Unit> {
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1() {
                            super(1);
                            AnonymousClass4.this = r1;
                        }

                        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
                        public final String getName() {
                            return "getAllChallenges";
                        }

                        @Override // kotlin.jvm.internal.CallableReference
                        public final KDeclarationContainer getOwner() {
                            return null;
                        }

                        @Override // kotlin.jvm.internal.CallableReference
                        public final String getSignature() {
                            return "invoke(I)V";
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* synthetic */ Unit invoke(Integer num) {
                            invoke(num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i) {
                            ChallengeAPIClient$getAll$1.this.invoke(i);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(NetworkException networkException) {
                        invoke2(networkException);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke */
                    public final void invoke2(NetworkException networkException) {
                        Intrinsics.checkParameterIsNotNull(networkException, "");
                        ChallengeAPIClient$getAll$1.this.this$0.MyBillsEntityDataFactory(networkException, new AnonymousClass1(), i, ChallengeAPIClient$getAll$1.this.$$error);
                    }
                });
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        } catch (TwilioVerifyException e) {
            this.$$error.invoke(e);
        } catch (Exception e2) {
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Error;
            String obj = e2.toString();
            Exception exc = e2;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(level, obj, exc);
            this.$$error.invoke(new TwilioVerifyException(new NetworkException(exc), TwilioVerifyException.ErrorCode.NetworkError));
        }
    }
}
