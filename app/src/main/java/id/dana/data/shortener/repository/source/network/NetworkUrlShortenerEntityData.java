package id.dana.data.shortener.repository.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.shortener.repository.source.UrlShortenerEntityData;
import id.dana.data.shortener.repository.source.network.request.UrlShortenerRestoreRequest;
import id.dana.data.shortener.repository.source.network.request.UrlShortenerShortenRequest;
import id.dana.data.shortener.repository.source.network.result.UrlShortenerRestoreResult;
import id.dana.data.shortener.repository.source.network.result.UrlShortenerShortenResult;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class NetworkUrlShortenerEntityData extends SecureBaseNetwork<UrlShortenerFacade> implements UrlShortenerEntityData {
    @Inject
    public NetworkUrlShortenerEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
    }

    @Override // id.dana.network.base.BaseNetwork
    public Class<UrlShortenerFacade> getFacadeClass() {
        return UrlShortenerFacade.class;
    }

    @Override // id.dana.data.shortener.repository.source.UrlShortenerEntityData
    public Observable<String> shorten(String str, String str2) {
        final UrlShortenerShortenRequest urlShortenerShortenRequest = new UrlShortenerShortenRequest();
        urlShortenerShortenRequest.bizType = str;
        urlShortenerShortenRequest.originalUrl = str2;
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.shortener.repository.source.network.NetworkUrlShortenerEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                UrlShortenerShortenResult shorten;
                shorten = ((UrlShortenerFacade) obj).shorten(UrlShortenerShortenRequest.this);
                return shorten;
            }
        }).map(new Function() { // from class: id.dana.data.shortener.repository.source.network.NetworkUrlShortenerEntityData$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String str3;
                str3 = ((UrlShortenerShortenResult) obj).shortUrl;
                return str3;
            }
        });
    }

    @Override // id.dana.data.shortener.repository.source.UrlShortenerEntityData
    public Observable<String> restore(String str) {
        final UrlShortenerRestoreRequest urlShortenerRestoreRequest = new UrlShortenerRestoreRequest();
        urlShortenerRestoreRequest.shortUrl = str;
        return wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.shortener.repository.source.network.NetworkUrlShortenerEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                UrlShortenerRestoreResult restore;
                restore = ((UrlShortenerFacade) obj).restore(UrlShortenerRestoreRequest.this);
                return restore;
            }
        }).map(new Function() { // from class: id.dana.data.shortener.repository.source.network.NetworkUrlShortenerEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String str2;
                str2 = ((UrlShortenerRestoreResult) obj).originalUrl;
                return str2;
            }
        });
    }
}
