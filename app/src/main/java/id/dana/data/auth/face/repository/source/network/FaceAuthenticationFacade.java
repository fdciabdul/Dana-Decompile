package id.dana.data.auth.face.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.auth.face.repository.source.request.FaceAuthenticationEntityRequest;
import id.dana.network.response.authface.FaceAuthenticationEntityResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/auth/face/repository/source/network/FaceAuthenticationFacade;", "", "Lid/dana/data/auth/face/repository/source/request/FaceAuthenticationEntityRequest;", "faceAuthenticationRequest", "Lid/dana/network/response/authface/FaceAuthenticationEntityResult;", "switch", "(Lid/dana/data/auth/face/repository/source/request/FaceAuthenticationEntityRequest;)Lid/dana/network/response/authface/FaceAuthenticationEntityResult;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface FaceAuthenticationFacade {
    @OperationType("alipayplus.mobilewallet.user.face.authentication.switch")
    @SignCheck
    /* renamed from: switch  reason: not valid java name */
    FaceAuthenticationEntityResult m793switch(FaceAuthenticationEntityRequest faceAuthenticationRequest);
}
