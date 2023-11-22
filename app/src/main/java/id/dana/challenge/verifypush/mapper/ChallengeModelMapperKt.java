package id.dana.challenge.verifypush.mapper;

import id.dana.challenge.verifypush.model.request.TwilioChallengeModel;
import id.dana.domain.twilio.model.TwilioChallenge;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/challenge/verifypush/model/request/TwilioChallengeModel;", "Lid/dana/domain/twilio/model/TwilioChallenge;", "MyBillsEntityDataFactory", "(Lid/dana/challenge/verifypush/model/request/TwilioChallengeModel;)Lid/dana/domain/twilio/model/TwilioChallenge;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ChallengeModelMapperKt {
    public static final TwilioChallenge MyBillsEntityDataFactory(TwilioChallengeModel twilioChallengeModel) {
        Intrinsics.checkNotNullParameter(twilioChallengeModel, "");
        return new TwilioChallenge(twilioChallengeModel.PlaceComponentResult, twilioChallengeModel.BuiltInFictitiousFunctionClassFactory, twilioChallengeModel.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
