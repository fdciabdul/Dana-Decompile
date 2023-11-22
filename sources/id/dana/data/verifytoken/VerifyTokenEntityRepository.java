package id.dana.data.verifytoken;

import android.text.TextUtils;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.util.NumberUtils;
import id.dana.data.verifytoken.repository.model.VerifyToken;
import id.dana.data.verifytoken.repository.source.VerifyTokenEntityData;
import id.dana.data.verifytoken.repository.source.VerifyTokenEntityDataFactory;
import id.dana.data.verifytoken.repository.source.network.result.VerifyTokenResult;
import id.dana.domain.verifytoken.VerifyTokenRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class VerifyTokenEntityRepository implements VerifyTokenRepository {
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final VerifyTokenEntityDataFactory verifyTokenEntityDataFactory;

    @Inject
    public VerifyTokenEntityRepository(VerifyTokenEntityDataFactory verifyTokenEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.verifyTokenEntityDataFactory = verifyTokenEntityDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.verifytoken.VerifyTokenRepository
    public Observable<String> getPinWithVerifiedToken(final String str, String str2, String str3) {
        return getVerifyToken(str3, NumberUtils.getClearPhoneNumber(str2)).onErrorReturnItem(new VerifyTokenResult()).map(new Function() { // from class: id.dana.data.verifytoken.VerifyTokenEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return VerifyTokenEntityRepository.this.m2141x3dcc5791(str, (VerifyTokenResult) obj);
            }
        });
    }

    private Observable<VerifyTokenResult> getVerifyToken(String str, String str2) {
        if ("LOGIN".equals(str)) {
            return createVerifyTokenEntityData().getVerifyToken(str, str2);
        }
        return this.holdLoginV1EntityRepository.authenticatedRequest(createVerifyTokenEntityData().getVerifyToken(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPinWithTOTP  reason: merged with bridge method [inline-methods] */
    public String m2141x3dcc5791(VerifyTokenResult verifyTokenResult, String str) {
        VerifyToken verifyToken = verifyTokenResult.getVerifyToken();
        if (verifyToken == null || !isTokenAndSeparatorExist(verifyToken)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(verifyToken.getToken());
        sb.append(verifyToken.getSeparator());
        sb.append(str);
        sb.append(verifyToken.getSeparator());
        sb.append(verifyToken.getToken());
        return sb.toString();
    }

    private boolean isTokenAndSeparatorExist(VerifyToken verifyToken) {
        return (TextUtils.isEmpty(verifyToken.getSeparator()) || TextUtils.isEmpty(verifyToken.getToken())) ? false : true;
    }

    private VerifyTokenEntityData createVerifyTokenEntityData() {
        return this.verifyTokenEntityDataFactory.createData2("network");
    }
}
