package id.dana.data.account.avatar.repository.source;

import id.dana.data.account.avatar.repository.source.network.result.AvatarEntityResult;
import io.reactivex.Observable;
import java.io.File;

/* loaded from: classes.dex */
public interface AvatarEntityData {
    Observable<AvatarEntityResult> uploadAvatar(File file, String str);
}
