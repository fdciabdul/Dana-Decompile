package id.dana.data.shortener.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.shortener.repository.source.network.NetworkUrlShortenerEntityData;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class UrlShortenerEntityDataFactory extends AbstractEntityDataFactory<UrlShortenerEntityData> {
    private final NetworkUrlShortenerEntityData networkUrlShortensEntityData;

    @Inject
    public UrlShortenerEntityDataFactory(NetworkUrlShortenerEntityData networkUrlShortenerEntityData) {
        this.networkUrlShortensEntityData = networkUrlShortenerEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public UrlShortenerEntityData createData2(String str) {
        return this.networkUrlShortensEntityData;
    }
}
