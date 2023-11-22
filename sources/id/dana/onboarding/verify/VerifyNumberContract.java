package id.dana.onboarding.verify;

import id.dana.base.AbstractContractKt;
import id.dana.domain.featureconfig.model.EmergencyNotificationConfig;
import id.dana.domain.featureconfig.model.OnboardingWarningTextConfig;
import id.dana.domain.model.rpc.response.CheckRegistrationResponse;
import id.dana.domain.model.rpc.response.LoginAuthenticationOptionResponse;
import id.dana.domain.registration.model.CheckRegistrationRequest;
import id.dana.model.FaceAuthenticationModel;
import id.dana.model.Trust2RiskLoginModel;
import id.dana.network.exception.NetworkException;
import id.dana.onboarding.track.LocationPermissionTracker;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/onboarding/verify/VerifyNumberContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface VerifyNumberContract {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\u000fJ7\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH&¢\u0006\u0004\b\t\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\nH&¢\u0006\u0004\b\u0014\u0010\fJ\u000f\u0010\u0015\u001a\u00020\u0005H&¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\bJ\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0015\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\u0005H&¢\u0006\u0004\b\u0014\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0014\u0010\u0007J\u000f\u0010\u0016\u001a\u00020\u0005H&¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0005H&¢\u0006\u0004\b\u0017\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u000b\u0010\u0007J\u001d\u0010\t\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H&¢\u0006\u0004\b\t\u0010\u001aø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/onboarding/verify/VerifyNumberContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "Lid/dana/onboarding/track/LocationPermissionTracker;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "()V", "getAuthRequestContext", "", "PlaceComponentResult", "(Z)V", "Lid/dana/domain/registration/model/CheckRegistrationRequest;", "p1", "(Lid/dana/domain/registration/model/CheckRegistrationRequest;Z)V", "p2", "p3", "p4", "(Ljava/lang/String;ZZZZ)V", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "", "Lid/dana/domain/model/rpc/response/LoginAuthenticationOptionResponse;", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter, LocationPermissionTracker {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(String p0);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(String p0);

        void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(String p0);

        void NetworkUserEntityData$$ExternalSyntheticLambda0();

        void PlaceComponentResult();

        void PlaceComponentResult(CheckRegistrationRequest p0, boolean p1);

        void PlaceComponentResult(String p0);

        void PlaceComponentResult(boolean p0);

        void getAuthRequestContext();

        void getAuthRequestContext(String p0, boolean p1, boolean p2, boolean p3, boolean p4);

        void getAuthRequestContext(List<? extends LoginAuthenticationOptionResponse> p0);

        void lookAheadTest();
    }

    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&¢\u0006\u0004\b\n\u0010\u0011J\u001f\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0005H&¢\u0006\u0004\b\u0003\u0010\u0013J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0012H&¢\u0006\u0004\b\n\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0012H&¢\u0006\u0004\b\u0015\u0010\u0014J1\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0005H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0015\u001a\u00020\u0002H&¢\u0006\u0004\b\u0015\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0018H&¢\u0006\u0004\b\u0003\u0010\u0019J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0012H&¢\u0006\u0004\b\u0007\u0010\u0014J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0012H&¢\u0006\u0004\b\u0003\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J9\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH&¢\u0006\u0004\b\u0015\u0010\u001dJ-\u0010\u0016\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0016\u0010\u001eJ=\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001fH&¢\u0006\u0004\b\u0016\u0010 J=\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020!H&¢\u0006\u0004\b\u0007\u0010\"J)\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u0012H&¢\u0006\u0004\b\u0007\u0010#J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0012H&¢\u0006\u0004\b\u0016\u0010\u0014J\u000f\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0004J\u0019\u0010\u0015\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0015\u0010\bJ\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\tH&¢\u0006\u0004\b\u0016\u0010\u000bJ\u000f\u0010$\u001a\u00020\u0002H&¢\u0006\u0004\b$\u0010\u0004J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\tH&¢\u0006\u0004\b\u0015\u0010\u000bJ\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\tH&¢\u0006\u0004\b\u0003\u0010\u000bJ\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\tH&¢\u0006\u0004\b\u0007\u0010\u000bJ\u000f\u0010%\u001a\u00020\u0002H&¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\u0002H&¢\u0006\u0004\b&\u0010\u0004J\u000f\u0010'\u001a\u00020\u0002H&¢\u0006\u0004\b'\u0010\u0004J)\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020(H&¢\u0006\u0004\b\u0015\u0010)J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020(H&¢\u0006\u0004\b\u0016\u0010*J\u000f\u0010+\u001a\u00020\u0002H&¢\u0006\u0004\b+\u0010\u0004J\u000f\u0010,\u001a\u00020\u0002H&¢\u0006\u0004\b,\u0010\u0004J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020(H&¢\u0006\u0004\b\n\u0010-J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020.H&¢\u0006\u0004\b\n\u0010/J\u000f\u00100\u001a\u00020\u0002H&¢\u0006\u0004\b0\u0010\u0004J\u000f\u00101\u001a\u00020\u0002H&¢\u0006\u0004\b1\u0010\u0004J\u0019\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0003\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/onboarding/verify/VerifyNumberContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "", "p0", "PlaceComponentResult", "(Ljava/lang/String;)V", "Lid/dana/network/exception/NetworkException;", "getAuthRequestContext", "(Lid/dana/network/exception/NetworkException;)V", "p1", "p2", "", "Lid/dana/domain/model/rpc/response/LoginAuthenticationOptionResponse;", "p3", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "", "(ZLjava/lang/String;)V", "(Z)V", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "Lid/dana/domain/featureconfig/model/EmergencyNotificationConfig;", "(Lid/dana/domain/featureconfig/model/EmergencyNotificationConfig;)V", "Lid/dana/domain/model/rpc/response/CheckRegistrationResponse;", "", "p4", "(Lid/dana/domain/model/rpc/response/CheckRegistrationResponse;ZLjava/lang/String;II)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lid/dana/model/FaceAuthenticationModel;", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/model/FaceAuthenticationModel;)V", "Lid/dana/model/Trust2RiskLoginModel;", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/model/Trust2RiskLoginModel;)V", "(ZLjava/lang/String;Z)V", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "moveToNextValue", "", "(Ljava/lang/String;Lid/dana/network/exception/NetworkException;J)V", "(J)V", "getErrorConfigVersion", "NetworkUserEntityData$$ExternalSyntheticLambda1", "(Ljava/lang/String;J)V", "Lid/dana/domain/featureconfig/model/OnboardingWarningTextConfig;", "(Lid/dana/domain/featureconfig/model/OnboardingWarningTextConfig;)V", "NetworkUserEntityData$$ExternalSyntheticLambda2", "DatabaseTableConfigUtil"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(EmergencyNotificationConfig p0);

        void BuiltInFictitiousFunctionClassFactory(NetworkException p0);

        void BuiltInFictitiousFunctionClassFactory(String p0);

        void BuiltInFictitiousFunctionClassFactory(boolean p0);

        void BuiltInFictitiousFunctionClassFactory(boolean p0, String p1);

        void DatabaseTableConfigUtil();

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(long p0);

        void KClassImpl$Data$declaredNonStaticMembers$2(NetworkException p0);

        void KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2);

        void KClassImpl$Data$declaredNonStaticMembers$2(String p0, boolean p1, String p2, String p3);

        void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0);

        void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0, String p1, String p2, String p3, FaceAuthenticationModel p4);

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(CheckRegistrationResponse p0, boolean p1, String p2, int p3, int p4);

        void MyBillsEntityDataFactory(NetworkException p0);

        void MyBillsEntityDataFactory(String p0);

        void MyBillsEntityDataFactory(String p0, NetworkException p1, long p2);

        void MyBillsEntityDataFactory(boolean p0);

        void NetworkUserEntityData$$ExternalSyntheticLambda0();

        void NetworkUserEntityData$$ExternalSyntheticLambda1();

        void NetworkUserEntityData$$ExternalSyntheticLambda2();

        void PlaceComponentResult();

        void PlaceComponentResult(NetworkException p0);

        void PlaceComponentResult(String p0);

        void PlaceComponentResult(boolean p0);

        void PlaceComponentResult(boolean p0, String p1, String p2, String p3, Trust2RiskLoginModel p4);

        void PlaceComponentResult(boolean p0, String p1, boolean p2);

        void getAuthRequestContext();

        void getAuthRequestContext(OnboardingWarningTextConfig p0);

        void getAuthRequestContext(NetworkException p0);

        void getAuthRequestContext(String p0, long p1);

        void getAuthRequestContext(String p0, String p1, String p2, List<? extends LoginAuthenticationOptionResponse> p3);

        void getAuthRequestContext(boolean p0);

        void getErrorConfigVersion();

        void lookAheadTest();

        void moveToNextValue();

        void scheduleImpl();
    }
}
