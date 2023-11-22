package id.dana.domain.exploredana.repository;

import id.dana.domain.promotion.Space;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface ExploreDanaRepository {
    Observable<Space> getExploreDana();

    Observable<Boolean> setDismissAll(List<String> list);

    Observable<Boolean> setReadExploreDanaItem(String str);
}
