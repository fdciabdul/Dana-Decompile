package id.dana.data.network.interceptor;

import android.content.Context;
import id.dana.data.network.exception.NoNetworkException;
import id.dana.data.util.NetworkUtils;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
/* loaded from: classes2.dex */
public class NetworkAvailabilityInterceptor implements Interceptor {
    private Context getAuthRequestContext;

    @Inject
    public NetworkAvailabilityInterceptor(Context context) {
        this.getAuthRequestContext = context;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (!NetworkUtils.isNetworkAvailable(this.getAuthRequestContext)) {
            throw new NoNetworkException(this.getAuthRequestContext);
        }
        return chain.proceed(request);
    }
}
