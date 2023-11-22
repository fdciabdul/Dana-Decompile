package com.huawei.hms.api;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes7.dex */
public abstract class HuaweiApiClient implements AidlApiClient {

    /* loaded from: classes7.dex */
    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i);
    }

    /* loaded from: classes7.dex */
    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public abstract void checkUpdate(Activity activity, CheckUpdatelistener checkUpdatelistener);

    public void connect(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void connect(Activity activity);

    public abstract void connectForeground();

    public abstract void disableLifeCycleManagement(Activity activity);

    public abstract PendingResult<Status> discardAndReconnect();

    public abstract void disconnect();

    public abstract Map<Api<?>, Api.ApiOptions> getApiMap();

    public abstract ConnectionResult getConnectionResult(Api<?> api);

    public abstract List<PermissionInfo> getPermissionInfos();

    public abstract List<Scope> getScopes();

    public abstract Activity getTopActivity();

    public abstract boolean hasConnectedApi(Api<?> api);

    public abstract boolean hasConnectionFailureListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract boolean hasConnectionSuccessListener(ConnectionCallbacks connectionCallbacks);

    public abstract ConnectionResult holdUpConnect();

    public abstract ConnectionResult holdUpConnect(long j, TimeUnit timeUnit);

    @Override // com.huawei.hms.support.api.client.ApiClient
    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract void onPause(Activity activity);

    public abstract void onResume(Activity activity);

    public abstract void print(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void reconnect();

    public abstract void removeConnectionFailureListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract void removeConnectionSuccessListener(ConnectionCallbacks connectionCallbacks);

    public abstract void setConnectionCallbacks(ConnectionCallbacks connectionCallbacks);

    public abstract void setConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener);

    public abstract boolean setSubAppInfo(SubAppInfo subAppInfo);

    /* loaded from: classes7.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final Context f7457a;
        private final List<Scope> b = new ArrayList();
        private final List<PermissionInfo> c = new ArrayList();
        private final Map<Api<?>, Api.ApiOptions> d = new HashMap();
        private OnConnectionFailedListener e;
        private ConnectionCallbacks f;
        private int g;
        private Activity h;

        public Builder(Context context) throws NullPointerException {
            Checker.checkNonNull(context, "context must not be null.");
            Context applicationContext = context.getApplicationContext();
            this.f7457a = applicationContext;
            this.g = -1;
            ResourceLoaderUtil.setmContext(applicationContext);
            a(context);
        }

        private void a(Context context) {
            HMSBIInitializer.getInstance(context).initBI();
        }

        public final Builder addApi(Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            this.d.put(api, null);
            if (HuaweiApiAvailability.HMS_API_NAME_GAME.equals(api.getApiName())) {
                HiAnalyticsUtil hiAnalyticsUtil = HiAnalyticsUtil.getInstance();
                Context applicationContext = this.f7457a.getApplicationContext();
                StringBuilder sb = new StringBuilder();
                sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                sb.append(System.currentTimeMillis());
                hiAnalyticsUtil.onEvent(applicationContext, HiAnalyticsConstant.KeyAndValue.GAME_INIT_KEY, sb.toString());
            }
            return this;
        }

        public final Builder addApiWithScope(Api<? extends Api.ApiOptions.NotRequiredOptions> api, Scope... scopeArr) {
            Checker.checkNonNull(api, "Api must not be null");
            Checker.checkNonNull(scopeArr, "Scopes must not be null");
            this.d.put(api, null);
            this.b.addAll(new ArrayList(Arrays.asList(scopeArr)));
            return this;
        }

        public final Builder addConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
            Checker.checkNonNull(connectionCallbacks, "listener must not be null.");
            this.f = connectionCallbacks;
            return this;
        }

        public final Builder addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
            Checker.checkNonNull(onConnectionFailedListener, "listener must not be null.");
            this.e = onConnectionFailedListener;
            return this;
        }

        public final Builder addScope(Scope scope) {
            Checker.checkNonNull(scope, "scope must not be null.");
            this.b.add(scope);
            return this;
        }

        public final Builder allowLifeCycleManagement(Activity activity, int i, OnConnectionFailedListener onConnectionFailedListener) {
            if (i >= 0) {
                this.g = i;
                this.h = (Activity) Preconditions.checkNotNull(activity, "activity must not be Null.");
                return this;
            }
            throw new IllegalArgumentException("allowLifeCycleManagement id should be positive");
        }

        public final Builder applyDefaultAccount() {
            return this;
        }

        public final HuaweiApiClient build() {
            addApi(new Api<>("Core.API"));
            HuaweiApiClientImpl huaweiApiClientImpl = new HuaweiApiClientImpl(this.f7457a);
            huaweiApiClientImpl.setScopes(this.b);
            huaweiApiClientImpl.setPermissionInfos(this.c);
            huaweiApiClientImpl.setApiMap(this.d);
            huaweiApiClientImpl.setConnectionCallbacks(this.f);
            huaweiApiClientImpl.setConnectionFailedListener(this.e);
            huaweiApiClientImpl.setAutoLifecycleClientId(this.g);
            if (this.g >= 0) {
                a(huaweiApiClientImpl);
            }
            return huaweiApiClientImpl;
        }

        public final Builder setAccountName(String str) {
            return this;
        }

        public final Builder setHandler(Handler handler) {
            return this;
        }

        public final Builder setPopupsGravity(int i) {
            return this;
        }

        public final Builder setViewForPopups(View view) {
            return this;
        }

        private void a(HuaweiApiClient huaweiApiClient) {
            AutoLifecycleFragment.getInstance(this.h).startAutoMange(this.g, huaweiApiClient);
        }

        public final Builder allowLifeCycleManagement(Activity activity, OnConnectionFailedListener onConnectionFailedListener) {
            return allowLifeCycleManagement(activity, 0, onConnectionFailedListener);
        }

        public final <O extends Api.ApiOptions.HasOptions> Builder addApiWithScope(Api<O> api, O o2, Scope... scopeArr) {
            Checker.checkNonNull(api, "Api must not be null");
            Checker.checkNonNull(o2, "Null options are not permitted for this Api");
            Checker.checkNonNull(scopeArr, "Scopes must not be null");
            this.d.put(api, o2);
            if (api.getOptions() != null) {
                this.b.addAll(api.getOptions().getScopeList(o2));
                this.c.addAll(api.getOptions().getPermissionInfoList(o2));
            }
            this.b.addAll(new ArrayList(Arrays.asList(scopeArr)));
            return this;
        }

        public final <O extends Api.ApiOptions.HasOptions> Builder addApi(Api<O> api, O o2) {
            Checker.checkNonNull(api, "Api must not be null");
            Checker.checkNonNull(o2, "Null options are not permitted for this Api");
            this.d.put(api, o2);
            if (api.getOptions() != null) {
                this.b.addAll(api.getOptions().getScopeList(o2));
                this.c.addAll(api.getOptions().getPermissionInfoList(o2));
            }
            return this;
        }
    }
}
