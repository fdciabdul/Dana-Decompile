package id.dana.data.exploredana.repository.source.local;

import id.dana.domain.promotion.CdpContent;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes8.dex */
public interface ExploreDanaEntityData {
    Observable<List<CdpContent>> checkExploreDanaPreferences(List<CdpContent> list);

    Observable<Boolean> setDismissAll(List<String> list);

    Observable<Boolean> setReadDanaPreferences(String str);
}
