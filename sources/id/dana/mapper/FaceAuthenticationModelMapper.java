package id.dana.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.domain.model.rpc.response.CheckRegistrationResponse;
import id.dana.domain.model.rpc.response.LoginAuthenticationOptionResponse;
import id.dana.model.FaceAuthenticationModel;
import id.dana.model.LoginAuthenticationMethod;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\f\u0010\rJ%\u0010\n\u001a\u00020\t2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/mapper/FaceAuthenticationModelMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/domain/model/rpc/response/CheckRegistrationResponse;", "Lid/dana/model/FaceAuthenticationModel;", "", "Lid/dana/domain/model/rpc/response/LoginAuthenticationOptionResponse;", "p0", "", "p1", "Lid/dana/model/LoginAuthenticationMethod;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/List;I)Lid/dana/model/LoginAuthenticationMethod;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FaceAuthenticationModelMapper extends BaseMapper<CheckRegistrationResponse, FaceAuthenticationModel> {
    @Override // id.dana.data.base.BaseMapper
    public final /* synthetic */ FaceAuthenticationModel map(CheckRegistrationResponse checkRegistrationResponse) {
        CheckRegistrationResponse checkRegistrationResponse2 = checkRegistrationResponse;
        if (checkRegistrationResponse2 != null) {
            return new FaceAuthenticationModel(BuiltInFictitiousFunctionClassFactory(checkRegistrationResponse2.getLoginAuthenticationOptionResponses(), checkRegistrationResponse2.getPasswordAuthMethodIndex()), BuiltInFictitiousFunctionClassFactory(checkRegistrationResponse2.getLoginAuthenticationOptionResponses(), checkRegistrationResponse2.getFaceLoginAuthMethodIndex()), checkRegistrationResponse2.getSecurityId());
        }
        return null;
    }

    @Inject
    public FaceAuthenticationModelMapper() {
    }

    private static LoginAuthenticationMethod BuiltInFictitiousFunctionClassFactory(List<? extends LoginAuthenticationOptionResponse> p0, int p1) {
        if (p1 != -1) {
            LoginAuthenticationOptionResponse loginAuthenticationOptionResponse = p0 != null ? p0.get(p1) : null;
            if (loginAuthenticationOptionResponse != null) {
                LoginAuthenticationMethod loginAuthenticationMethod = new LoginAuthenticationMethod();
                loginAuthenticationMethod.KClassImpl$Data$declaredNonStaticMembers$2 = loginAuthenticationOptionResponse.isRiskFlag();
                loginAuthenticationMethod.BuiltInFictitiousFunctionClassFactory = loginAuthenticationOptionResponse.isEnrollFlag();
                loginAuthenticationMethod.PlaceComponentResult = loginAuthenticationOptionResponse.isKycFlag();
                loginAuthenticationMethod.getAuthRequestContext = loginAuthenticationOptionResponse.getAuthenticationMethod();
                return loginAuthenticationMethod;
            }
            return new LoginAuthenticationMethod();
        }
        return new LoginAuthenticationMethod();
    }
}
