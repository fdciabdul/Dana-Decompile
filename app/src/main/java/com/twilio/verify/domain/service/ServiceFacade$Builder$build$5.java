package com.twilio.verify.domain.service;

import com.twilio.verify.domain.service.ServiceFacade;
import com.twilio.verify.networking.Authentication;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 8, 0})
/* loaded from: classes8.dex */
final /* synthetic */ class ServiceFacade$Builder$build$5 extends MutablePropertyReference0 {
    ServiceFacade$Builder$build$5(ServiceFacade.Builder builder) {
        super(builder);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "KClassImpl$Data$declaredNonStaticMembers$2";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ServiceFacade.Builder.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "getKClassImpl$Data$declaredNonStaticMembers$2()Lcom/twilio/verify/networking/Authentication;";
    }

    @Override // kotlin.reflect.KProperty0
    public final Object get() {
        return ServiceFacade.Builder.KClassImpl$Data$declaredNonStaticMembers$2((ServiceFacade.Builder) this.receiver);
    }

    @Override // kotlin.reflect.KMutableProperty0
    public final void set(Object obj) {
        ((ServiceFacade.Builder) this.receiver).KClassImpl$Data$declaredNonStaticMembers$2 = (Authentication) obj;
    }
}
