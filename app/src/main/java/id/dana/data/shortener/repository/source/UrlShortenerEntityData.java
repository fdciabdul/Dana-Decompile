package id.dana.data.shortener.repository.source;

import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface UrlShortenerEntityData {
    Observable<String> restore(String str);

    Observable<String> shorten(String str, String str2);
}
