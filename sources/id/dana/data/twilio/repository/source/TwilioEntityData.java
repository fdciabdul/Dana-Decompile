package id.dana.data.twilio.repository.source;

import id.dana.data.carrieridentification.model.VerifySecurityProductRequest;
import id.dana.data.carrieridentification.model.VerifySecurityProductResult;
import id.dana.data.twilio.repository.source.network.request.VerifyPushBindEnrollmentRequest;
import id.dana.data.twilio.repository.source.network.request.VerifyPushConsultRequest;
import id.dana.data.twilio.repository.source.network.request.VerifyPushDerollRequest;
import id.dana.data.twilio.repository.source.network.request.VerifyPushEnrollRequest;
import id.dana.data.twilio.repository.source.network.request.VerifyPushRequestChallengeRequest;
import id.dana.data.twilio.repository.source.network.result.VerifyPushBindEnrollmentResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushConsultResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushDerollResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushEnrollResult;
import id.dana.data.twilio.repository.source.network.result.VerifyPushRequestChallengeResult;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u0003\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\u0006\u0010\u0003\u001a\u00020\u0010H&¢\u0006\u0004\b\n\u0010\u0012J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00042\u0006\u0010\u0003\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00042\u0006\u0010\u0003\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001b\u0010\u001cø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/twilio/repository/source/TwilioEntityData;", "", "Lid/dana/data/twilio/repository/source/network/request/VerifyPushBindEnrollmentRequest;", "p0", "Lio/reactivex/Observable;", "Lid/dana/data/twilio/repository/source/network/result/VerifyPushBindEnrollmentResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/data/twilio/repository/source/network/request/VerifyPushBindEnrollmentRequest;)Lio/reactivex/Observable;", "Lid/dana/data/twilio/repository/source/network/request/VerifyPushConsultRequest;", "Lid/dana/data/twilio/repository/source/network/result/VerifyPushConsultResult;", "PlaceComponentResult", "(Lid/dana/data/twilio/repository/source/network/request/VerifyPushConsultRequest;)Lio/reactivex/Observable;", "Lid/dana/data/twilio/repository/source/network/request/VerifyPushRequestChallengeRequest;", "Lid/dana/data/twilio/repository/source/network/result/VerifyPushRequestChallengeResult;", "getAuthRequestContext", "(Lid/dana/data/twilio/repository/source/network/request/VerifyPushRequestChallengeRequest;)Lio/reactivex/Observable;", "Lid/dana/data/twilio/repository/source/network/request/VerifyPushDerollRequest;", "Lid/dana/data/twilio/repository/source/network/result/VerifyPushDerollResult;", "(Lid/dana/data/twilio/repository/source/network/request/VerifyPushDerollRequest;)Lio/reactivex/Observable;", "Lid/dana/data/twilio/repository/source/network/request/VerifyPushEnrollRequest;", "Lid/dana/data/twilio/repository/source/network/result/VerifyPushEnrollResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/data/twilio/repository/source/network/request/VerifyPushEnrollRequest;)Lio/reactivex/Observable;", "Lid/dana/data/carrieridentification/model/VerifySecurityProductRequest;", "", "p1", "Lid/dana/data/carrieridentification/model/VerifySecurityProductResult;", "MyBillsEntityDataFactory", "(Lid/dana/data/carrieridentification/model/VerifySecurityProductRequest;Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface TwilioEntityData {
    Observable<VerifyPushEnrollResult> BuiltInFictitiousFunctionClassFactory(VerifyPushEnrollRequest p0);

    Observable<VerifyPushBindEnrollmentResult> KClassImpl$Data$declaredNonStaticMembers$2(VerifyPushBindEnrollmentRequest p0);

    Observable<VerifySecurityProductResult> MyBillsEntityDataFactory(VerifySecurityProductRequest p0, String p1);

    Observable<VerifyPushConsultResult> PlaceComponentResult(VerifyPushConsultRequest p0);

    Observable<VerifyPushDerollResult> PlaceComponentResult(VerifyPushDerollRequest p0);

    Observable<VerifyPushRequestChallengeResult> getAuthRequestContext(VerifyPushRequestChallengeRequest p0);
}
