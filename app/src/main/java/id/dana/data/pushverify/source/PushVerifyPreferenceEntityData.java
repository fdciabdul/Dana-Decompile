package id.dana.data.pushverify.source;

import io.reactivex.Completable;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H&¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/pushverify/source/PushVerifyPreferenceEntityData;", "", "", "phoneNumber", "Lio/reactivex/Observable;", "", "isNotificationPromptDisabled", "(Ljava/lang/String;)Lio/reactivex/Observable;", "enabled", "Lio/reactivex/Completable;", "saveNotificationPromptPreference", "(Ljava/lang/String;Z)Lio/reactivex/Completable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface PushVerifyPreferenceEntityData {
    Observable<Boolean> isNotificationPromptDisabled(String phoneNumber);

    Completable saveNotificationPromptPreference(String phoneNumber, boolean enabled);
}
