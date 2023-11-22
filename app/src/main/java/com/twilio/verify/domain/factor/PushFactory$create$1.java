package com.twilio.verify.domain.factor;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.data.KeyStorage;
import com.twilio.verify.domain.factor.models.PushFactor;
import com.twilio.verify.models.Factor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/twilio/verify/models/Factor;", "factor", "", BridgeDSL.INVOKE, "(Lcom/twilio/verify/models/Factor;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
final class PushFactory$create$1 extends Lambda implements Function1<Factor, Unit> {
    final /* synthetic */ String $$alias;
    final /* synthetic */ Function1 $$error;
    final /* synthetic */ Function1 $$success;
    final /* synthetic */ PushFactory this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushFactory$create$1(PushFactory pushFactory, String str, Function1 function1, Function1 function12) {
        super(1);
        this.this$0 = pushFactory;
        this.$$alias = str;
        this.$$success = function1;
        this.$$error = function12;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Unit invoke(Factor factor) {
        invoke2(factor);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Factor factor) {
        KeyStorage keyStorage;
        FactorProvider factorProvider;
        Intrinsics.checkParameterIsNotNull(factor, "");
        if (!(factor instanceof PushFactor)) {
            factor = null;
        }
        PushFactor pushFactor = (PushFactor) factor;
        if (pushFactor != null) {
            pushFactor.getErrorConfigVersion = this.$$alias;
            if (pushFactor != null) {
                String str = pushFactor.getErrorConfigVersion;
                PushFactor pushFactor2 = str == null || str.length() == 0 ? null : pushFactor;
                if (pushFactor2 != null) {
                    factorProvider = this.this$0.BuiltInFictitiousFunctionClassFactory;
                    factorProvider.getAuthRequestContext(pushFactor);
                    if (pushFactor2 != null) {
                        this.$$success.invoke(pushFactor2);
                        return;
                    }
                }
                PushFactory pushFactory = this.this$0;
                Logger logger = Logger.PlaceComponentResult;
                Level level = Level.Debug;
                StringBuilder sb = new StringBuilder();
                sb.append("Delete key pair ");
                sb.append(this.$$alias);
                Logger.MyBillsEntityDataFactory(level, sb.toString());
                keyStorage = pushFactory.PlaceComponentResult;
                keyStorage.MyBillsEntityDataFactory(this.$$alias);
                Function1 function1 = this.$$error;
                IllegalStateException illegalStateException = new IllegalStateException("Key pair not set");
                Logger logger2 = Logger.PlaceComponentResult;
                Level level2 = Level.Error;
                String obj = illegalStateException.toString();
                IllegalStateException illegalStateException2 = illegalStateException;
                Logger.KClassImpl$Data$declaredNonStaticMembers$2(level2, obj, illegalStateException2);
                function1.invoke(new TwilioVerifyException(illegalStateException2, TwilioVerifyException.ErrorCode.KeyStorageError));
            }
        }
    }
}
