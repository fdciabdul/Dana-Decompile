package id.dana.data.shortener.repository;

import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.shortener.repository.source.UrlShortenerEntityData;
import id.dana.data.shortener.repository.source.UrlShortenerEntityDataFactory;
import id.dana.domain.shortener.repository.ShortenerRepository;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class ShortenerEntityRepository implements ShortenerRepository {
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final UrlShortenerEntityDataFactory urlShortenerEntityDataFactory;

    @Inject
    public ShortenerEntityRepository(UrlShortenerEntityDataFactory urlShortenerEntityDataFactory, HoldLoginV1EntityRepository holdLoginV1EntityRepository) {
        this.urlShortenerEntityDataFactory = urlShortenerEntityDataFactory;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
    }

    @Override // id.dana.domain.shortener.repository.ShortenerRepository
    public Observable<String> shorten(String str, String str2) {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createUrlShortenerData().shorten(str, str2));
    }

    private UrlShortenerEntityData createUrlShortenerData() {
        return this.urlShortenerEntityDataFactory.createData2("network");
    }

    @Override // id.dana.domain.shortener.repository.ShortenerRepository
    public Observable<String> restore(String str) {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createUrlShortenerData().restore(str));
    }
}
