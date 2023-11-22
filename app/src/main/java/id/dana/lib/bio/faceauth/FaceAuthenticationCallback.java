package id.dana.lib.bio.faceauth;

import id.dana.lib.bio.faceauth.exception.DanaBioException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/lib/bio/faceauth/FaceAuthenticationCallback;", "", "", "onCancel", "()V", "Lid/dana/lib/bio/faceauth/exception/DanaBioException$FaceAuthenticationException;", "exception", "onFailed", "(Lid/dana/lib/bio/faceauth/exception/DanaBioException$FaceAuthenticationException;)V", "", "verifyId", "onSuccess", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface FaceAuthenticationCallback {
    void onCancel();

    void onFailed(DanaBioException.FaceAuthenticationException exception);

    void onSuccess(String verifyId);
}
