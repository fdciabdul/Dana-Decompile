package id.dana.data.auth.face.repository.source;

import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000e\u001a\u00020\u0003H&¢\u0006\u0004\b\u000f\u0010\bR\u0014\u0010\u0012\u001a\u00020\t8'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/auth/face/repository/source/FaceAuthSuggestionRepository;", "", "Lio/reactivex/Observable;", "", "clearFaceAuthSuggestionState", "()Lio/reactivex/Observable;", "hasShown", "saveFaceAuthSuggestionState", "(Z)Lio/reactivex/Observable;", "", "currentDateTimeStamp", "", "saveFaceAuthSuggestionStateSavingTime", "(J)V", "shouldNeverShow", "saveNeverShowFaceAuthSuggestionState", "getFaceAuthSuggestionStateSavingTime", "()J", "faceAuthSuggestionStateSavingTime", "getShouldNeverShowFaceAuthSuggestion", "shouldNeverShowFaceAuthSuggestion", "getShouldSuggestFaceAuth", "shouldSuggestFaceAuth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface FaceAuthSuggestionRepository {
    Observable<Boolean> clearFaceAuthSuggestionState();

    @JvmName(name = "getFaceAuthSuggestionStateSavingTime")
    long getFaceAuthSuggestionStateSavingTime();

    @JvmName(name = "getShouldNeverShowFaceAuthSuggestion")
    Observable<Boolean> getShouldNeverShowFaceAuthSuggestion();

    @JvmName(name = "getShouldSuggestFaceAuth")
    Observable<Boolean> getShouldSuggestFaceAuth();

    Observable<Boolean> saveFaceAuthSuggestionState(boolean hasShown);

    void saveFaceAuthSuggestionStateSavingTime(long currentDateTimeStamp);

    Observable<Boolean> saveNeverShowFaceAuthSuggestionState(boolean shouldNeverShow);
}
