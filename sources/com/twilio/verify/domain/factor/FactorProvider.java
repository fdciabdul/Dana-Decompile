package com.twilio.verify.domain.factor;

import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.domain.factor.models.CreateFactorPayload;
import com.twilio.verify.domain.factor.models.UpdateFactorPayload;
import com.twilio.verify.models.Factor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J?\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u0007H&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\bH&¢\u0006\u0004\b\u0003\u0010\u000eJ9\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u0012H&¢\u0006\u0004\b\f\u0010\u0013J\u0015\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\bH&¢\u0006\u0004\b\u0017\u0010\u0018J?\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00192\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u0007H&¢\u0006\u0004\b\u0017\u0010\u001aJG\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00122\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u00072\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\u0007H&¢\u0006\u0004\b\u0003\u0010\u001c"}, d2 = {"Lcom/twilio/verify/domain/factor/FactorProvider;", "", "", "MyBillsEntityDataFactory", "()V", "Lcom/twilio/verify/domain/factor/models/CreateFactorPayload;", "p0", "Lkotlin/Function1;", "Lcom/twilio/verify/models/Factor;", "p1", "Lcom/twilio/verify/TwilioVerifyException;", "p2", "PlaceComponentResult", "(Lcom/twilio/verify/domain/factor/models/CreateFactorPayload;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "(Lcom/twilio/verify/models/Factor;)V", "Lkotlin/Function0;", "BuiltInFictitiousFunctionClassFactory", "(Lcom/twilio/verify/models/Factor;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "", "(Ljava/lang/String;)Lcom/twilio/verify/models/Factor;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/List;", "getAuthRequestContext", "(Lcom/twilio/verify/models/Factor;)Lcom/twilio/verify/models/Factor;", "Lcom/twilio/verify/domain/factor/models/UpdateFactorPayload;", "(Lcom/twilio/verify/domain/factor/models/UpdateFactorPayload;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "p3", "(Lcom/twilio/verify/models/Factor;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public interface FactorProvider {
    void BuiltInFictitiousFunctionClassFactory(Factor p0, Function0<Unit> p1, Function1<? super TwilioVerifyException, Unit> p2);

    List<Factor> KClassImpl$Data$declaredNonStaticMembers$2();

    void MyBillsEntityDataFactory();

    void MyBillsEntityDataFactory(Factor p0);

    void MyBillsEntityDataFactory(Factor p0, String p1, Function1<? super Factor, Unit> p2, Function1<? super TwilioVerifyException, Unit> p3);

    Factor PlaceComponentResult(String p0);

    void PlaceComponentResult(CreateFactorPayload p0, Function1<? super Factor, Unit> p1, Function1<? super TwilioVerifyException, Unit> p2);

    Factor getAuthRequestContext(Factor p0);

    void getAuthRequestContext(UpdateFactorPayload p0, Function1<? super Factor, Unit> p1, Function1<? super TwilioVerifyException, Unit> p2);
}
