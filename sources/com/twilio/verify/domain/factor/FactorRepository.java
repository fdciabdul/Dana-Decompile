package com.twilio.verify.domain.factor;

import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.api.FactorAPIClient;
import com.twilio.verify.api.FactorAPIClient$delete$1;
import com.twilio.verify.api.FactorAPIClient$update$1;
import com.twilio.verify.api.FactorAPIClient$verify$1;
import com.twilio.verify.data.StorageException;
import com.twilio.verify.data.StorageProvider;
import com.twilio.verify.domain.factor.models.CreateFactorPayload;
import com.twilio.verify.domain.factor.models.UpdateFactorPayload;
import com.twilio.verify.models.Factor;
import com.twilio.verify.networking.BasicAuthorization;
import com.twilio.verify.networking.HttpMethod;
import com.twilio.verify.networking.NetworkException;
import com.twilio.verify.networking.Request;
import com.twilio.verify.networking.RequestHelper;
import com.twilio.verify.networking.Response;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0006\u001a\u00020\u001d\u0012\u0006\u0010\t\u001a\u00020!\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u001f¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J?\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0003\u0010\u000eJ9\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\f\u0010\u0013J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J?\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00192\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u001aJG\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00122\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u00072\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\u0003\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u001eR\u0014\u0010\f\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010 R\u0014\u0010\u0010\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\""}, d2 = {"Lcom/twilio/verify/domain/factor/FactorRepository;", "Lcom/twilio/verify/domain/factor/FactorProvider;", "", "MyBillsEntityDataFactory", "()V", "Lcom/twilio/verify/domain/factor/models/CreateFactorPayload;", "p0", "Lkotlin/Function1;", "Lcom/twilio/verify/models/Factor;", "p1", "Lcom/twilio/verify/TwilioVerifyException;", "p2", "PlaceComponentResult", "(Lcom/twilio/verify/domain/factor/models/CreateFactorPayload;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "(Lcom/twilio/verify/models/Factor;)V", "Lkotlin/Function0;", "BuiltInFictitiousFunctionClassFactory", "(Lcom/twilio/verify/models/Factor;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "", "(Ljava/lang/String;)Lcom/twilio/verify/models/Factor;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/List;", "getAuthRequestContext", "(Lcom/twilio/verify/models/Factor;)Lcom/twilio/verify/models/Factor;", "Lcom/twilio/verify/domain/factor/models/UpdateFactorPayload;", "(Lcom/twilio/verify/domain/factor/models/UpdateFactorPayload;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "p3", "(Lcom/twilio/verify/models/Factor;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lcom/twilio/verify/api/FactorAPIClient;", "Lcom/twilio/verify/api/FactorAPIClient;", "Lcom/twilio/verify/domain/factor/FactorMapper;", "Lcom/twilio/verify/domain/factor/FactorMapper;", "Lcom/twilio/verify/data/StorageProvider;", "Lcom/twilio/verify/data/StorageProvider;", "<init>", "(Lcom/twilio/verify/api/FactorAPIClient;Lcom/twilio/verify/data/StorageProvider;Lcom/twilio/verify/domain/factor/FactorMapper;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class FactorRepository implements FactorProvider {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final StorageProvider BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FactorAPIClient MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final FactorMapper PlaceComponentResult;

    private FactorRepository(FactorAPIClient factorAPIClient, StorageProvider storageProvider, FactorMapper factorMapper) {
        Intrinsics.checkParameterIsNotNull(factorAPIClient, "");
        Intrinsics.checkParameterIsNotNull(storageProvider, "");
        Intrinsics.checkParameterIsNotNull(factorMapper, "");
        this.MyBillsEntityDataFactory = factorAPIClient;
        this.BuiltInFictitiousFunctionClassFactory = storageProvider;
        this.PlaceComponentResult = factorMapper;
    }

    public /* synthetic */ FactorRepository(FactorAPIClient factorAPIClient, StorageProvider storageProvider, FactorMapper factorMapper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(factorAPIClient, storageProvider, (i & 4) != 0 ? new FactorMapper() : factorMapper);
    }

    @Override // com.twilio.verify.domain.factor.FactorProvider
    public final void PlaceComponentResult(CreateFactorPayload p0, Function1<? super Factor, Unit> p1, final Function1<? super TwilioVerifyException, Unit> p2) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        FactorRepository$create$1 factorRepository$create$1 = new FactorRepository$create$1(this, p0, p1, p2);
        FactorAPIClient factorAPIClient = this.MyBillsEntityDataFactory;
        final FactorRepository$create$2 factorRepository$create$2 = new FactorRepository$create$2(factorRepository$create$1);
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(factorRepository$create$2, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        try {
            RequestHelper requestHelper = new RequestHelper(factorAPIClient.getAuthRequestContext, new BasicAuthorization("token", p0.BuiltInFictitiousFunctionClassFactory));
            StringBuilder sb = new StringBuilder();
            sb.append(factorAPIClient.MyBillsEntityDataFactory);
            sb.append("Services/{ServiceSid}/Entities/{Identity}/Factors");
            Request.Builder builder = new Request.Builder(requestHelper, StringsKt.replace$default(StringsKt.replace(sb.toString(), "{ServiceSid}", p0.moveToNextValue, true), "{Identity}", p0.KClassImpl$Data$declaredNonStaticMembers$2, false, 4, (Object) null), null, null, null, null, null, 124, null);
            HttpMethod httpMethod = HttpMethod.Post;
            Intrinsics.checkParameterIsNotNull(httpMethod, "");
            Request.Builder builder2 = builder;
            builder.getAuthRequestContext = httpMethod;
            Map<String, ? extends Object> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("FriendlyName", p0.PlaceComponentResult), TuplesKt.to("FactorType", p0.scheduleImpl.getFactorTypeName()));
            Map<String, String> map = p0.getAuthRequestContext;
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Binding.");
                sb2.append(entry.getKey());
                arrayList.add(TuplesKt.to(sb2.toString(), entry.getValue()));
            }
            MapsKt.putAll(mutableMapOf, arrayList);
            Map<String, String> map2 = p0.MyBillsEntityDataFactory;
            ArrayList arrayList2 = new ArrayList(map2.size());
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Config.");
                sb3.append(entry2.getKey());
                arrayList2.add(TuplesKt.to(sb3.toString(), entry2.getValue()));
            }
            MapsKt.putAll(mutableMapOf, arrayList2);
            Intrinsics.checkParameterIsNotNull(mutableMapOf, "");
            Request.Builder builder3 = builder;
            builder.KClassImpl$Data$declaredNonStaticMembers$2 = mutableMapOf;
            factorAPIClient.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(builder.KClassImpl$Data$declaredNonStaticMembers$2(), new Function1<Response, Unit>() { // from class: com.twilio.verify.api.FactorAPIClient$create$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Response response) {
                    invoke2(response);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Response response) {
                    Intrinsics.checkParameterIsNotNull(response, "");
                    Function1.this.invoke(new JSONObject(response.KClassImpl$Data$declaredNonStaticMembers$2));
                }
            }, new Function1<NetworkException, Unit>() { // from class: com.twilio.verify.api.FactorAPIClient$create$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(NetworkException networkException) {
                    invoke2(networkException);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(NetworkException networkException) {
                    Intrinsics.checkParameterIsNotNull(networkException, "");
                    Function1.this.invoke(new TwilioVerifyException(networkException, TwilioVerifyException.ErrorCode.NetworkError));
                }
            });
        } catch (TwilioVerifyException e) {
            p2.invoke(e);
        } catch (Exception e2) {
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Error;
            String obj = e2.toString();
            Exception exc = e2;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(level, obj, exc);
            p2.invoke(new TwilioVerifyException(new NetworkException(exc), TwilioVerifyException.ErrorCode.NetworkError));
        }
    }

    @Override // com.twilio.verify.domain.factor.FactorProvider
    public final void MyBillsEntityDataFactory(Factor p0, String p1, Function1<? super Factor, Unit> p2, Function1<? super TwilioVerifyException, Unit> p3) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        Intrinsics.checkParameterIsNotNull(p3, "");
        FactorRepository$verify$1 factorRepository$verify$1 = new FactorRepository$verify$1(this, p0, p2, p3);
        FactorAPIClient factorAPIClient = this.MyBillsEntityDataFactory;
        FactorRepository$verify$2 factorRepository$verify$2 = new FactorRepository$verify$2(factorRepository$verify$1);
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(factorRepository$verify$2, "");
        Intrinsics.checkParameterIsNotNull(p3, "");
        FactorAPIClient$verify$1.invoke$default(new FactorAPIClient$verify$1(factorAPIClient, p0, p1, factorRepository$verify$2, p3), 0, 1, null);
    }

    @Override // com.twilio.verify.domain.factor.FactorProvider
    public final void getAuthRequestContext(UpdateFactorPayload p0, Function1<? super Factor, Unit> p1, Function1<? super TwilioVerifyException, Unit> p2) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        FactorRepository$update$1 factorRepository$update$1 = new FactorRepository$update$1(this, p1, p0, p2);
        Factor PlaceComponentResult = PlaceComponentResult(p0.KClassImpl$Data$declaredNonStaticMembers$2);
        if (PlaceComponentResult == null) {
            throw new TwilioVerifyException(new StorageException("Factor not found"), TwilioVerifyException.ErrorCode.StorageError);
        }
        FactorAPIClient factorAPIClient = this.MyBillsEntityDataFactory;
        FactorRepository$update$2 factorRepository$update$2 = new FactorRepository$update$2(factorRepository$update$1);
        Intrinsics.checkParameterIsNotNull(PlaceComponentResult, "");
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(factorRepository$update$2, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        FactorAPIClient$update$1.invoke$default(new FactorAPIClient$update$1(factorAPIClient, PlaceComponentResult, p0, factorRepository$update$2, p2), 0, 1, null);
    }

    @Override // com.twilio.verify.domain.factor.FactorProvider
    public final void BuiltInFictitiousFunctionClassFactory(Factor p0, Function0<Unit> p1, Function1<? super TwilioVerifyException, Unit> p2) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        FactorRepository$delete$1 factorRepository$delete$1 = new FactorRepository$delete$1(this, p0, p1);
        FactorAPIClient factorAPIClient = this.MyBillsEntityDataFactory;
        FactorRepository$delete$2 factorRepository$delete$2 = new FactorRepository$delete$2(factorRepository$delete$1);
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(factorRepository$delete$2, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        FactorAPIClient$delete$1.invoke$default(new FactorAPIClient$delete$1(factorAPIClient, p0, factorRepository$delete$2, p2), 0, 1, null);
    }

    @Override // com.twilio.verify.domain.factor.FactorProvider
    public final void MyBillsEntityDataFactory(Factor p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0.getLookAheadTest());
    }

    @Override // com.twilio.verify.domain.factor.FactorProvider
    public final Factor PlaceComponentResult(String p0) throws TwilioVerifyException {
        Intrinsics.checkParameterIsNotNull(p0, "");
        String authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(p0);
        if (authRequestContext != null) {
            return FactorMapper.BuiltInFictitiousFunctionClassFactory(authRequestContext);
        }
        return null;
    }

    @Override // com.twilio.verify.domain.factor.FactorProvider
    public final Factor getAuthRequestContext(Factor p0) throws TwilioVerifyException {
        Intrinsics.checkParameterIsNotNull(p0, "");
        this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(p0.getLookAheadTest(), FactorMapper.KClassImpl$Data$declaredNonStaticMembers$2(p0));
        Factor PlaceComponentResult = PlaceComponentResult(p0.getLookAheadTest());
        if (PlaceComponentResult != null) {
            return PlaceComponentResult;
        }
        StorageException storageException = new StorageException("Factor not found");
        Logger logger = Logger.PlaceComponentResult;
        Level level = Level.Error;
        String obj = storageException.toString();
        StorageException storageException2 = storageException;
        Logger.KClassImpl$Data$declaredNonStaticMembers$2(level, obj, storageException2);
        throw new TwilioVerifyException(storageException2, TwilioVerifyException.ErrorCode.StorageError);
    }

    @Override // com.twilio.verify.domain.factor.FactorProvider
    public final void MyBillsEntityDataFactory() {
        this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // com.twilio.verify.domain.factor.FactorProvider
    public final List<Factor> KClassImpl$Data$declaredNonStaticMembers$2() throws TwilioVerifyException {
        List<String> authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = authRequestContext.iterator();
        while (it.hasNext()) {
            Factor BuiltInFictitiousFunctionClassFactory = FactorMapper.BuiltInFictitiousFunctionClassFactory((String) it.next());
            if (BuiltInFictitiousFunctionClassFactory != null) {
                arrayList.add(BuiltInFictitiousFunctionClassFactory);
            }
        }
        return arrayList;
    }
}
