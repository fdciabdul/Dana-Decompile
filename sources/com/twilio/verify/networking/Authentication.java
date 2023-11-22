package com.twilio.verify.networking;

import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.models.Factor;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/twilio/verify/networking/Authentication;", "", "Lcom/twilio/verify/models/Factor;", "p0", "", "MyBillsEntityDataFactory", "(Lcom/twilio/verify/models/Factor;)Ljava/lang/String;"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public interface Authentication {
    String MyBillsEntityDataFactory(Factor p0) throws TwilioVerifyException;
}
