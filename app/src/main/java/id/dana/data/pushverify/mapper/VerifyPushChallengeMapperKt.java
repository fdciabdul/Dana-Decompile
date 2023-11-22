package id.dana.data.pushverify.mapper;

import id.dana.data.pushverify.source.model.VerifyPushChallengeRequest;
import id.dana.data.pushverify.source.model.VerifyPushChallengeResult;
import id.dana.domain.pushverify.model.VerifyPushChallenge;
import id.dana.domain.pushverify.model.VerifyPushChallengeParam;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000*\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0006\u001a\u00020\u0002*\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\b\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\f\u001a\u00020\u000b*\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\u0011\u0010\u000f\u001a\u00020\u000e*\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010"}, d2 = {"", "data", "", "bytesToHexString", "([B)Ljava/lang/String;", "Lid/dana/domain/pushverify/model/VerifyPushChallengeParam;", "createTokenId", "(Lid/dana/domain/pushverify/model/VerifyPushChallengeParam;)Ljava/lang/String;", "sha256", "(Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/data/pushverify/source/model/VerifyPushChallengeResult;", "Lid/dana/domain/pushverify/model/VerifyPushChallenge;", "toVerifyPushChallenge", "(Lid/dana/data/pushverify/source/model/VerifyPushChallengeResult;)Lid/dana/domain/pushverify/model/VerifyPushChallenge;", "Lid/dana/data/pushverify/source/model/VerifyPushChallengeRequest;", "toVerifyPushChallengeRequest", "(Lid/dana/domain/pushverify/model/VerifyPushChallengeParam;)Lid/dana/data/pushverify/source/model/VerifyPushChallengeRequest;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class VerifyPushChallengeMapperKt {
    public static final VerifyPushChallengeRequest toVerifyPushChallengeRequest(VerifyPushChallengeParam verifyPushChallengeParam) {
        Intrinsics.checkNotNullParameter(verifyPushChallengeParam, "");
        return new VerifyPushChallengeRequest(sha256(createTokenId(verifyPushChallengeParam)), verifyPushChallengeParam.getTokenPair(), verifyPushChallengeParam.getApproveVerify(), verifyPushChallengeParam.getTransactionId(), verifyPushChallengeParam.getCacheKey());
    }

    private static final String createTokenId(VerifyPushChallengeParam verifyPushChallengeParam) {
        StringBuilder sb = new StringBuilder();
        sb.append(verifyPushChallengeParam.getTokenPair());
        sb.append('_');
        sb.append(verifyPushChallengeParam.getToken());
        sb.append('_');
        sb.append(verifyPushChallengeParam.getTokenPair());
        sb.append('_');
        sb.append(verifyPushChallengeParam.getToken());
        return sb.toString();
    }

    private static final String sha256(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        byte[] digest = messageDigest.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(digest, "");
        return bytesToHexString(digest);
    }

    private static final String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Integer.valueOf(b & 255)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "");
            sb.append(format);
        }
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public static final VerifyPushChallenge toVerifyPushChallenge(VerifyPushChallengeResult verifyPushChallengeResult) {
        Intrinsics.checkNotNullParameter(verifyPushChallengeResult, "");
        return new VerifyPushChallenge(verifyPushChallengeResult.success, verifyPushChallengeResult.getVerified());
    }
}
