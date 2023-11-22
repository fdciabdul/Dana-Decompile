package id.dana.twilio.onboarding.mapper;

import id.dana.domain.twilio.model.TwilioBindEnroll;
import id.dana.domain.twilio.model.TwilioConsult;
import id.dana.domain.twilio.model.TwilioDeroll;
import id.dana.domain.twilio.model.TwilioEnroll;
import id.dana.domain.twilio.model.TwilioVerify;
import id.dana.twilio.onboarding.model.request.TwilioBindEnrollModel;
import id.dana.twilio.onboarding.model.request.TwilioConsultModel;
import id.dana.twilio.onboarding.model.request.TwilioDerollModel;
import id.dana.twilio.onboarding.model.request.TwilioEnrollModel;
import id.dana.twilio.onboarding.model.request.TwilioVerifySecurityProductModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\u0006\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\u0006\u0010\n\u001a\u0011\u0010\r\u001a\u00020\f*\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0011\u0010\u0006\u001a\u00020\u0010*\u00020\u000f¢\u0006\u0004\b\u0006\u0010\u0011"}, d2 = {"Lid/dana/twilio/onboarding/model/request/TwilioBindEnrollModel;", "Lid/dana/domain/twilio/model/TwilioBindEnroll;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/twilio/onboarding/model/request/TwilioBindEnrollModel;)Lid/dana/domain/twilio/model/TwilioBindEnroll;", "Lid/dana/twilio/onboarding/model/request/TwilioConsultModel;", "Lid/dana/domain/twilio/model/TwilioConsult;", "getAuthRequestContext", "(Lid/dana/twilio/onboarding/model/request/TwilioConsultModel;)Lid/dana/domain/twilio/model/TwilioConsult;", "Lid/dana/twilio/onboarding/model/request/TwilioDerollModel;", "Lid/dana/domain/twilio/model/TwilioDeroll;", "(Lid/dana/twilio/onboarding/model/request/TwilioDerollModel;)Lid/dana/domain/twilio/model/TwilioDeroll;", "Lid/dana/twilio/onboarding/model/request/TwilioEnrollModel;", "Lid/dana/domain/twilio/model/TwilioEnroll;", "PlaceComponentResult", "(Lid/dana/twilio/onboarding/model/request/TwilioEnrollModel;)Lid/dana/domain/twilio/model/TwilioEnroll;", "Lid/dana/twilio/onboarding/model/request/TwilioVerifySecurityProductModel;", "Lid/dana/domain/twilio/model/TwilioVerify;", "(Lid/dana/twilio/onboarding/model/request/TwilioVerifySecurityProductModel;)Lid/dana/domain/twilio/model/TwilioVerify;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TwilioModelMapperKt {
    public static final TwilioConsult getAuthRequestContext(TwilioConsultModel twilioConsultModel) {
        Intrinsics.checkNotNullParameter(twilioConsultModel, "");
        return new TwilioConsult(twilioConsultModel.KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public static final TwilioEnroll PlaceComponentResult(TwilioEnrollModel twilioEnrollModel) {
        Intrinsics.checkNotNullParameter(twilioEnrollModel, "");
        return new TwilioEnroll(twilioEnrollModel.MyBillsEntityDataFactory, twilioEnrollModel.BuiltInFictitiousFunctionClassFactory);
    }

    public static final TwilioBindEnroll BuiltInFictitiousFunctionClassFactory(TwilioBindEnrollModel twilioBindEnrollModel) {
        Intrinsics.checkNotNullParameter(twilioBindEnrollModel, "");
        return new TwilioBindEnroll(twilioBindEnrollModel.KClassImpl$Data$declaredNonStaticMembers$2, twilioBindEnrollModel.MyBillsEntityDataFactory);
    }

    public static final TwilioDeroll getAuthRequestContext(TwilioDerollModel twilioDerollModel) {
        Intrinsics.checkNotNullParameter(twilioDerollModel, "");
        return new TwilioDeroll(twilioDerollModel.getAuthRequestContext);
    }

    public static final TwilioVerify getAuthRequestContext(TwilioVerifySecurityProductModel twilioVerifySecurityProductModel) {
        Intrinsics.checkNotNullParameter(twilioVerifySecurityProductModel, "");
        return new TwilioVerify(twilioVerifySecurityProductModel.KClassImpl$Data$declaredNonStaticMembers$2, twilioVerifySecurityProductModel.getAuthRequestContext, twilioVerifySecurityProductModel.PlaceComponentResult, twilioVerifySecurityProductModel.BuiltInFictitiousFunctionClassFactory);
    }
}
