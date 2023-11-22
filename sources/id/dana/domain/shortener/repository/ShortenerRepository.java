package id.dana.domain.shortener.repository;

import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface ShortenerRepository {
    Observable<String> restore(String str);

    Observable<String> shorten(String str, String str2);
}
