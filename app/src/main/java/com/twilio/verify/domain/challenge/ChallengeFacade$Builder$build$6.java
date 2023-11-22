package com.twilio.verify.domain.challenge;

import com.twilio.verify.domain.challenge.ChallengeFacade;
import com.twilio.verify.networking.Authentication;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 8, 0})
/* loaded from: classes8.dex */
final /* synthetic */ class ChallengeFacade$Builder$build$6 extends MutablePropertyReference0 {
    ChallengeFacade$Builder$build$6(ChallengeFacade.Builder builder) {
        super(builder);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "PlaceComponentResult";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ChallengeFacade.Builder.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "getMyBillsEntityDataFactory()Lcom/twilio/verify/networking/Authentication;";
    }

    @Override // kotlin.reflect.KProperty0
    public final Object get() {
        return ChallengeFacade.Builder.MyBillsEntityDataFactory((ChallengeFacade.Builder) this.receiver);
    }

    @Override // kotlin.reflect.KMutableProperty0
    public final void set(Object obj) {
        ((ChallengeFacade.Builder) this.receiver).PlaceComponentResult = (Authentication) obj;
    }
}
