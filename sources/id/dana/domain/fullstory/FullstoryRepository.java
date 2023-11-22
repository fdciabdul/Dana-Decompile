package id.dana.domain.fullstory;

import id.dana.domain.fullstory.model.FullstoryConfig;
import id.dana.domain.fullstory.model.FullstoryPreferenceConfig;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/fullstory/FullstoryRepository;", "", "Lio/reactivex/Observable;", "Lid/dana/domain/fullstory/model/FullstoryConfig;", "getFullstoryConfig", "()Lio/reactivex/Observable;", "Lid/dana/domain/fullstory/model/FullstoryPreferenceConfig;", "getSessionCounterFromPreference", "()Lid/dana/domain/fullstory/model/FullstoryPreferenceConfig;", "fullstoryPreferenceConfig", "", "setSessionCounterToPreference", "(Lid/dana/domain/fullstory/model/FullstoryPreferenceConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface FullstoryRepository {
    Observable<FullstoryConfig> getFullstoryConfig();

    FullstoryPreferenceConfig getSessionCounterFromPreference();

    void setSessionCounterToPreference(FullstoryPreferenceConfig fullstoryPreferenceConfig);
}
