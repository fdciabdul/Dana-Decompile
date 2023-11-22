package com.twilio.verify.domain.challenge;

import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.models.Challenge;
import com.twilio.verify.models.ChallengeList;
import com.twilio.verify.models.ChallengeListOrder;
import com.twilio.verify.models.ChallengeStatus;
import com.twilio.verify.models.Factor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001JG\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0006H&¢\u0006\u0004\b\f\u0010\rJc\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0006H&¢\u0006\u0004\b\u0015\u0010\u0016JG\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\b0\u0006H&¢\u0006\u0004\b\f\u0010\u0017"}, d2 = {"Lcom/twilio/verify/domain/challenge/ChallengeProvider;", "", "", "p0", "Lcom/twilio/verify/models/Factor;", "p1", "Lkotlin/Function1;", "Lcom/twilio/verify/models/Challenge;", "", "p2", "Lcom/twilio/verify/TwilioVerifyException;", "p3", "PlaceComponentResult", "(Ljava/lang/String;Lcom/twilio/verify/models/Factor;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "Lcom/twilio/verify/models/ChallengeStatus;", "", "Lcom/twilio/verify/models/ChallengeListOrder;", "p4", "Lcom/twilio/verify/models/ChallengeList;", "p5", "p6", "MyBillsEntityDataFactory", "(Lcom/twilio/verify/models/Factor;Lcom/twilio/verify/models/ChallengeStatus;ILcom/twilio/verify/models/ChallengeListOrder;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "(Lcom/twilio/verify/models/Challenge;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes.dex */
public interface ChallengeProvider {
    void MyBillsEntityDataFactory(Factor p0, ChallengeStatus p1, int p2, ChallengeListOrder p3, String p4, Function1<? super ChallengeList, Unit> p5, Function1<? super TwilioVerifyException, Unit> p6);

    void PlaceComponentResult(Challenge p0, String p1, Function1<? super Challenge, Unit> p2, Function1<? super TwilioVerifyException, Unit> p3);

    void PlaceComponentResult(String p0, Factor p1, Function1<? super Challenge, Unit> p2, Function1<? super TwilioVerifyException, Unit> p3);
}
