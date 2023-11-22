package id.dana.data.auth.face.repository.source.local;

import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.danah5.faceverificationenablement.DefaultFaceAuthenticationManager;
import id.dana.data.auth.face.repository.source.FaceAuthenticationEntityData;
import id.dana.data.auth.face.repository.source.network.NetworkFaceAuthenticationEntityData;
import id.dana.data.util.RandomMatchers;
import id.dana.network.response.authface.FaceAuthenticationEntityResult;
import id.dana.network.response.authface.SecurityContextEntity;
import id.dana.network.response.authface.VerificationMethodInfoEntity;
import id.dana.riskChallenges.ui.missedCallOtp.PhoneStateReceiver;
import io.reactivex.Observable;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J1\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\f\u0010\rJ;\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014"}, d2 = {"Lid/dana/data/auth/face/repository/source/local/MockFaceAuthenticationEntityData;", "Lid/dana/data/auth/face/repository/source/FaceAuthenticationEntityData;", "Lid/dana/network/response/authface/FaceAuthenticationEntityResult;", "generateResultForEnroll", "()Lid/dana/network/response/authface/FaceAuthenticationEntityResult;", "generateResultForSwitch", "", "faceAuthNew", "", BioUtilityBridge.SECURITY_ID, NetworkFaceAuthenticationEntityData.PAGE_SOURCE, "Lio/reactivex/Observable;", "switch", "(ZLjava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "pin", RecordError.KEY_PUB_KEY, PhoneStateReceiver.VERIFY, "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "", "actionState", "[Ljava/lang/String;", "riskResultState", "verificationMethodCodeState", "verificationMethodState", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MockFaceAuthenticationEntityData implements FaceAuthenticationEntityData {
    private final String[] riskResultState = {"ACCEPT", "VERIFICATION"};
    private final String[] verificationMethodState = {"PIN", "ACCEPT", "MIC_FACE"};
    private final String[] verificationMethodCodeState = {"pin", "accept", "micface"};
    private final String[] actionState = {DefaultFaceAuthenticationManager.Companion.ActionConstant.TO_RISK, DefaultFaceAuthenticationManager.Companion.ActionConstant.TO_ENROLL, "TO_KYC"};

    @Inject
    public MockFaceAuthenticationEntityData() {
    }

    @Override // id.dana.data.auth.face.repository.source.FaceAuthenticationEntityData
    public final Observable<FaceAuthenticationEntityResult> verify(boolean faceAuthNew, String securityId, String pin, String pubKey) {
        Observable<FaceAuthenticationEntityResult> just = Observable.just(generateResultForEnroll());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    private final FaceAuthenticationEntityResult generateResultForSwitch() {
        VerificationMethodInfoEntity verificationMethodInfoEntity = new VerificationMethodInfoEntity(0, null, null, 7, null);
        verificationMethodInfoEntity.setPriority(RandomMatchers.randomInt());
        verificationMethodInfoEntity.setVerificationMethod(this.verificationMethodState[RandomMatchers.randomInt(this.riskResultState.length)]);
        String str = this.verificationMethodCodeState[RandomMatchers.randomInt(this.riskResultState.length)];
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        verificationMethodInfoEntity.setVerificationMethodCode(lowerCase);
        FaceAuthenticationEntityResult faceAuthenticationEntityResult = new FaceAuthenticationEntityResult();
        faceAuthenticationEntityResult.success = RandomMatchers.randomBoolean();
        if (faceAuthenticationEntityResult.success) {
            String[] strArr = this.riskResultState;
            faceAuthenticationEntityResult.setRiskResult(strArr[RandomMatchers.randomInt(strArr.length)]);
            if (Intrinsics.areEqual(this.riskResultState[1], faceAuthenticationEntityResult.getRiskResult())) {
                faceAuthenticationEntityResult.setSecurityId(RandomMatchers.randomString());
                faceAuthenticationEntityResult.setVerificationMethods(CollectionsKt.mutableListOf(verificationMethodInfoEntity));
                SecurityContextEntity securityContext = faceAuthenticationEntityResult.getSecurityContext();
                if (securityContext != null) {
                    securityContext.setPubKey(RandomMatchers.randomString());
                }
                String[] strArr2 = this.actionState;
                faceAuthenticationEntityResult.setAction(strArr2[RandomMatchers.randomInt(strArr2.length)]);
            }
        }
        return faceAuthenticationEntityResult;
    }

    private final FaceAuthenticationEntityResult generateResultForEnroll() {
        FaceAuthenticationEntityResult faceAuthenticationEntityResult = new FaceAuthenticationEntityResult();
        faceAuthenticationEntityResult.success = RandomMatchers.randomBoolean();
        if (faceAuthenticationEntityResult.success) {
            String[] strArr = this.riskResultState;
            faceAuthenticationEntityResult.setRiskResult(strArr[RandomMatchers.randomInt(strArr.length)]);
            faceAuthenticationEntityResult.setSecurityId(RandomMatchers.randomString());
            faceAuthenticationEntityResult.setAction(this.actionState[1]);
        }
        return faceAuthenticationEntityResult;
    }

    @Override // id.dana.data.auth.face.repository.source.FaceAuthenticationEntityData
    /* renamed from: switch */
    public final Observable<FaceAuthenticationEntityResult> mo786switch(boolean faceAuthNew, String securityId, String pageSource) {
        Observable<FaceAuthenticationEntityResult> just = Observable.just(generateResultForSwitch());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }
}
