package id.dana.data.shortener.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.data.shortener.repository.source.network.request.UrlShortenerRestoreRequest;
import id.dana.data.shortener.repository.source.network.request.UrlShortenerShortenRequest;
import id.dana.data.shortener.repository.source.network.result.UrlShortenerRestoreResult;
import id.dana.data.shortener.repository.source.network.result.UrlShortenerShortenResult;

/* loaded from: classes4.dex */
public interface UrlShortenerFacade {
    @OperationType("alipayplus.mobilewallet.urlshortener.restore")
    @SignCheck
    UrlShortenerRestoreResult restore(UrlShortenerRestoreRequest urlShortenerRestoreRequest);

    @OperationType("alipayplus.mobilewallet.urlshortener.shorten")
    @SignCheck
    UrlShortenerShortenResult shorten(UrlShortenerShortenRequest urlShortenerShortenRequest);
}
