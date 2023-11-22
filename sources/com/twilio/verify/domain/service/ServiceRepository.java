package com.twilio.verify.domain.service;

import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.api.ServiceAPIClient;
import com.twilio.verify.api.ServiceAPIClient$get$1;
import com.twilio.verify.models.Factor;
import com.twilio.verify.models.Service;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016JG\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0006H\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u000f\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lcom/twilio/verify/domain/service/ServiceRepository;", "Lcom/twilio/verify/domain/service/ServiceProvider;", "", "p0", "Lcom/twilio/verify/models/Factor;", "p1", "Lkotlin/Function1;", "Lcom/twilio/verify/models/Service;", "", "p2", "Lcom/twilio/verify/TwilioVerifyException;", "p3", "MyBillsEntityDataFactory", "(Ljava/lang/String;Lcom/twilio/verify/models/Factor;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lcom/twilio/verify/api/ServiceAPIClient;", "getAuthRequestContext", "Lcom/twilio/verify/api/ServiceAPIClient;", "PlaceComponentResult", "Lcom/twilio/verify/domain/service/ServiceMapper;", "BuiltInFictitiousFunctionClassFactory", "Lcom/twilio/verify/domain/service/ServiceMapper;", "<init>", "(Lcom/twilio/verify/api/ServiceAPIClient;Lcom/twilio/verify/domain/service/ServiceMapper;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class ServiceRepository implements ServiceProvider {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final ServiceMapper getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ServiceAPIClient PlaceComponentResult;

    private ServiceRepository(ServiceAPIClient serviceAPIClient, ServiceMapper serviceMapper) {
        Intrinsics.checkParameterIsNotNull(serviceAPIClient, "");
        Intrinsics.checkParameterIsNotNull(serviceMapper, "");
        this.PlaceComponentResult = serviceAPIClient;
        this.getAuthRequestContext = serviceMapper;
    }

    public /* synthetic */ ServiceRepository(ServiceAPIClient serviceAPIClient, ServiceMapper serviceMapper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(serviceAPIClient, (i & 2) != 0 ? new ServiceMapper() : serviceMapper);
    }

    @Override // com.twilio.verify.domain.service.ServiceProvider
    public final void MyBillsEntityDataFactory(String p0, Factor p1, Function1<? super Service, Unit> p2, Function1<? super TwilioVerifyException, Unit> p3) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p2, "");
        Intrinsics.checkParameterIsNotNull(p3, "");
        ServiceRepository$get$1 serviceRepository$get$1 = new ServiceRepository$get$1(this, p2, p3);
        ServiceAPIClient serviceAPIClient = this.PlaceComponentResult;
        ServiceRepository$get$2 serviceRepository$get$2 = new ServiceRepository$get$2(serviceRepository$get$1);
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(serviceRepository$get$2, "");
        Intrinsics.checkParameterIsNotNull(p3, "");
        ServiceAPIClient$get$1.invoke$default(new ServiceAPIClient$get$1(serviceAPIClient, p1, p0, serviceRepository$get$2, p3), 0, 1, null);
    }
}
