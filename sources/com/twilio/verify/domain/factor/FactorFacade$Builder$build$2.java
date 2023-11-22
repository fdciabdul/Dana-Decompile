package com.twilio.verify.domain.factor;

import com.twilio.verify.domain.factor.FactorFacade;
import com.twilio.verify.networking.NetworkProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 8, 0})
/* loaded from: classes8.dex */
final /* synthetic */ class FactorFacade$Builder$build$2 extends MutablePropertyReference0 {
    FactorFacade$Builder$build$2(FactorFacade.Builder builder) {
        super(builder);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "MyBillsEntityDataFactory";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(FactorFacade.Builder.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "getPlaceComponentResult()Lcom/twilio/verify/networking/NetworkProvider;";
    }

    @Override // kotlin.reflect.KProperty0
    public final Object get() {
        return FactorFacade.Builder.BuiltInFictitiousFunctionClassFactory((FactorFacade.Builder) this.receiver);
    }

    @Override // kotlin.reflect.KMutableProperty0
    public final void set(Object obj) {
        ((FactorFacade.Builder) this.receiver).MyBillsEntityDataFactory = (NetworkProvider) obj;
    }
}
