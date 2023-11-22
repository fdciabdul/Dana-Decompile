package id.dana.data.auth.face.repository.source.local;

import id.dana.data.auth.face.repository.source.FaceAuthSuggestionRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\t8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0005R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0005"}, d2 = {"Lid/dana/data/auth/face/repository/source/local/PreferenceFaceAuthSuggestionEntityData;", "Lid/dana/data/auth/face/repository/source/FaceAuthSuggestionRepository;", "Lio/reactivex/Observable;", "", "clearFaceAuthSuggestionState", "()Lio/reactivex/Observable;", "hasShown", "saveFaceAuthSuggestionState", "(Z)Lio/reactivex/Observable;", "", "currentDateTimeStamp", "", "saveFaceAuthSuggestionStateSavingTime", "(J)V", "shouldNeverShow", "saveNeverShowFaceAuthSuggestionState", "Lid/dana/data/auth/face/repository/source/local/FaceAuthSuggestionPreference;", "faceAuthSuggestionPreference", "Lid/dana/data/auth/face/repository/source/local/FaceAuthSuggestionPreference;", "getFaceAuthSuggestionStateSavingTime", "()J", "faceAuthSuggestionStateSavingTime", "getShouldNeverShowFaceAuthSuggestion", "shouldNeverShowFaceAuthSuggestion", "getShouldSuggestFaceAuth", "shouldSuggestFaceAuth", "<init>", "(Lid/dana/data/auth/face/repository/source/local/FaceAuthSuggestionPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PreferenceFaceAuthSuggestionEntityData implements FaceAuthSuggestionRepository {
    private final FaceAuthSuggestionPreference faceAuthSuggestionPreference;

    @Inject
    public PreferenceFaceAuthSuggestionEntityData(FaceAuthSuggestionPreference faceAuthSuggestionPreference) {
        Intrinsics.checkNotNullParameter(faceAuthSuggestionPreference, "");
        this.faceAuthSuggestionPreference = faceAuthSuggestionPreference;
    }

    @Override // id.dana.data.auth.face.repository.source.FaceAuthSuggestionRepository
    @JvmName(name = "getShouldSuggestFaceAuth")
    public final Observable<Boolean> getShouldSuggestFaceAuth() {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.faceAuthSuggestionPreference.getShouldSuggestFaceAuth()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.auth.face.repository.source.FaceAuthSuggestionRepository
    @JvmName(name = "getShouldNeverShowFaceAuthSuggestion")
    public final Observable<Boolean> getShouldNeverShowFaceAuthSuggestion() {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.faceAuthSuggestionPreference.getShouldNeverShowFaceAuthSuggestion()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.auth.face.repository.source.FaceAuthSuggestionRepository
    public final Observable<Boolean> saveFaceAuthSuggestionState(boolean hasShown) {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.faceAuthSuggestionPreference.saveFaceAuthSuggestionState(hasShown)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.auth.face.repository.source.FaceAuthSuggestionRepository
    public final Observable<Boolean> saveNeverShowFaceAuthSuggestionState(boolean shouldNeverShow) {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.faceAuthSuggestionPreference.saveNeverShowFaceAuthSuggestionState(shouldNeverShow)));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.auth.face.repository.source.FaceAuthSuggestionRepository
    public final Observable<Boolean> clearFaceAuthSuggestionState() {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.faceAuthSuggestionPreference.clearFaceAuthSuggestionState()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.auth.face.repository.source.FaceAuthSuggestionRepository
    public final void saveFaceAuthSuggestionStateSavingTime(long currentDateTimeStamp) {
        this.faceAuthSuggestionPreference.saveFaceAuthSuggestionStateSavingTime(currentDateTimeStamp);
    }

    @Override // id.dana.data.auth.face.repository.source.FaceAuthSuggestionRepository
    @JvmName(name = "getFaceAuthSuggestionStateSavingTime")
    public final long getFaceAuthSuggestionStateSavingTime() {
        return this.faceAuthSuggestionPreference.getFaceAuthSuggestionStateSavingTime();
    }
}
