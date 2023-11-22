package com.twilio.verify.domain.factor;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.domain.factor.models.UpdateFactorPayload;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lorg/json/JSONObject;", "response", "", BridgeDSL.INVOKE, "(Lorg/json/JSONObject;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
final class FactorRepository$update$1 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ Function1 $$error;
    final /* synthetic */ Function1 $$success;
    final /* synthetic */ UpdateFactorPayload $$updateFactorPayload;
    final /* synthetic */ FactorRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FactorRepository$update$1(FactorRepository factorRepository, Function1 function1, UpdateFactorPayload updateFactorPayload, Function1 function12) {
        super(1);
        this.this$0 = factorRepository;
        this.$$success = function1;
        this.$$updateFactorPayload = updateFactorPayload;
        this.$$error = function12;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(JSONObject jSONObject) {
        invoke2(jSONObject);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject jSONObject) {
        FactorMapper unused;
        Intrinsics.checkParameterIsNotNull(jSONObject, "");
        try {
            Function1 function1 = this.$$success;
            unused = this.this$0.PlaceComponentResult;
            function1.invoke(FactorMapper.MyBillsEntityDataFactory(jSONObject, this.$$updateFactorPayload));
        } catch (TwilioVerifyException e) {
            this.$$error.invoke(e);
        }
    }
}
