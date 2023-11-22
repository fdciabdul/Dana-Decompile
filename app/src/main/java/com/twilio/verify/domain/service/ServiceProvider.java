package com.twilio.verify.domain.service;

import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.models.Factor;
import com.twilio.verify.models.Service;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001JG\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0006H&¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/twilio/verify/domain/service/ServiceProvider;", "", "", "p0", "Lcom/twilio/verify/models/Factor;", "p1", "Lkotlin/Function1;", "Lcom/twilio/verify/models/Service;", "", "p2", "Lcom/twilio/verify/TwilioVerifyException;", "p3", "MyBillsEntityDataFactory", "(Ljava/lang/String;Lcom/twilio/verify/models/Factor;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public interface ServiceProvider {
    void MyBillsEntityDataFactory(String p0, Factor p1, Function1<? super Service, Unit> p2, Function1<? super TwilioVerifyException, Unit> p3);
}
