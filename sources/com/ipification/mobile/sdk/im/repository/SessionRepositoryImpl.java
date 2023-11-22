package com.ipification.mobile.sdk.im.repository;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.ipification.mobile.sdk.android.IPConfiguration;
import com.ipification.mobile.sdk.android.callback.CellularCallback;
import com.ipification.mobile.sdk.android.connection.DefaultConnection;
import com.ipification.mobile.sdk.android.exception.CellularException;
import com.ipification.mobile.sdk.android.model.IMSession;
import com.ipification.mobile.sdk.android.request.API_TYPE;
import com.ipification.mobile.sdk.android.request.AuthRequest;
import com.ipification.mobile.sdk.android.response.AuthResponse;
import com.ipification.mobile.sdk.android.response.CellularResponse;
import com.ipification.mobile.sdk.android.response.RedirectResponse;
import com.ipification.mobile.sdk.im.data.SessionDataSource;
import com.ipification.mobile.sdk.im.data.SessionResponse;
import com.ipification.mobile.sdk.im.listener.RedirectDataCallback;
import com.ipification.mobile.sdk.im.listener.SessionDataCallback;
import com.ipification.mobile.sdk.im.network.RedirectInterceptor;
import com.ipification.mobile.sdk.im.util.SingleLiveEvent;
import java.io.IOException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0003\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0003\u0010\u0011R\u0014\u0010\t\u001a\u0004\u0018\u00010\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015"}, d2 = {"Lcom/ipification/mobile/sdk/im/repository/SessionRepositoryImpl;", "Lcom/ipification/mobile/sdk/im/repository/SessionRepository;", "", "PlaceComponentResult", "()V", "Landroid/content/Context;", "p0", "Lcom/ipification/mobile/sdk/im/util/SingleLiveEvent;", "Lcom/ipification/mobile/sdk/im/data/SessionResponse;", "getAuthRequestContext", "(Landroid/content/Context;)Lcom/ipification/mobile/sdk/im/util/SingleLiveEvent;", "", "p1", "(Landroid/content/Context;Ljava/lang/String;)Lcom/ipification/mobile/sdk/im/util/SingleLiveEvent;", "Lcom/ipification/mobile/sdk/android/model/IMSession;", "MyBillsEntityDataFactory", "()Lcom/ipification/mobile/sdk/android/model/IMSession;", "(Lcom/ipification/mobile/sdk/android/model/IMSession;)V", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/ipification/mobile/sdk/android/model/IMSession;", "Lcom/ipification/mobile/sdk/im/data/SessionDataSource;", "Lcom/ipification/mobile/sdk/im/data/SessionDataSource;", "<init>", "(Lcom/ipification/mobile/sdk/im/data/SessionDataSource;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SessionRepositoryImpl implements SessionRepository {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public IMSession getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final SessionDataSource PlaceComponentResult;

    public SessionRepositoryImpl(SessionDataSource sessionDataSource) {
        Intrinsics.checkParameterIsNotNull(sessionDataSource, "");
        this.PlaceComponentResult = sessionDataSource;
    }

    @Override // com.ipification.mobile.sdk.im.repository.SessionRepository
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final IMSession getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @Override // com.ipification.mobile.sdk.im.repository.SessionRepository
    public final void PlaceComponentResult() {
        this.getAuthRequestContext = null;
    }

    @Override // com.ipification.mobile.sdk.im.repository.SessionRepository
    public final void PlaceComponentResult(IMSession p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        this.getAuthRequestContext = p0;
    }

    @Override // com.ipification.mobile.sdk.im.repository.SessionRepository
    public final SingleLiveEvent<SessionResponse> getAuthRequestContext(final Context p0) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        IMSession iMSession = this.getAuthRequestContext;
        if (iMSession != null) {
            if (iMSession == null) {
                Intrinsics.throwNpe();
            }
            if (iMSession.getAuthRequestContext != null) {
                IMSession iMSession2 = this.getAuthRequestContext;
                if (iMSession2 == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkParameterIsNotNull(p0, "");
                Intrinsics.checkParameterIsNotNull(iMSession2, "");
                final SingleLiveEvent<SessionResponse> singleLiveEvent = new SingleLiveEvent<>();
                final SessionDataCallback sessionDataCallback = new SessionDataCallback() { // from class: com.ipification.mobile.sdk.im.data.SessionDataSource$completeSession$1
                    @Override // com.ipification.mobile.sdk.im.listener.SessionDataCallback
                    public final void KClassImpl$Data$declaredNonStaticMembers$2(AuthResponse p02) {
                        Intrinsics.checkParameterIsNotNull(p02, "");
                        singleLiveEvent.BuiltInFictitiousFunctionClassFactory((SingleLiveEvent<SessionResponse>) (p02.getAuthRequestContext() != null ? new SessionResponse(true, p02, null) : new SessionResponse(false, p02, null)));
                    }

                    @Override // com.ipification.mobile.sdk.im.listener.SessionDataCallback
                    public final void PlaceComponentResult(CellularException p02) {
                        Intrinsics.checkParameterIsNotNull(p02, "");
                        singleLiveEvent.BuiltInFictitiousFunctionClassFactory((SingleLiveEvent<SessionResponse>) new SessionResponse(false, null, p02));
                    }
                };
                StringBuilder sb = new StringBuilder();
                sb.append((Object) iMSession2.BuiltInFictitiousFunctionClassFactory);
                sb.append('/');
                sb.append((Object) iMSession2.getAuthRequestContext);
                String obj = sb.toString();
                if (Build.VERSION.SDK_INT >= 21) {
                    Request build = new Request.Builder().url(obj).build();
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    InstrumentInjector.okhttp_addInterceptors(builder);
                    IPConfiguration.Companion companion = IPConfiguration.INSTANCE;
                    FirebasePerfOkHttpClient.enqueue(builder.addNetworkInterceptor(new RedirectInterceptor(String.valueOf(IPConfiguration.Companion.MyBillsEntityDataFactory().NetworkUserEntityData$$ExternalSyntheticLambda5))).build().newCall(build), new Callback() { // from class: com.ipification.mobile.sdk.im.data.SessionDataSource$callCompleteSession$1
                        @Override // okhttp3.Callback
                        public final void onFailure(Call p02, IOException p1) {
                            Intrinsics.checkParameterIsNotNull(p02, "");
                            Intrinsics.checkParameterIsNotNull(p1, "");
                            CellularException cellularException = new CellularException();
                            cellularException.MyBillsEntityDataFactory = p1;
                            cellularException.PlaceComponentResult = "3000";
                            SessionDataCallback.this.PlaceComponentResult(cellularException);
                        }

                        @Override // okhttp3.Callback
                        public final void onResponse(Call p02, Response p1) {
                            String string;
                            CellularException cellularException;
                            Intrinsics.checkParameterIsNotNull(p02, "");
                            Intrinsics.checkParameterIsNotNull(p1, "");
                            if (p1.isSuccessful()) {
                                ResponseBody body = p1.body();
                                String string2 = body == null ? null : body.string();
                                try {
                                    if (string2 == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    JSONObject jSONObject = new JSONObject(string2);
                                    CellularException cellularException2 = new CellularException();
                                    cellularException2.BuiltInFictitiousFunctionClassFactory = jSONObject.getString("session_status");
                                    cellularException2.PlaceComponentResult = String.valueOf(p1.code());
                                    SessionDataCallback.this.PlaceComponentResult(cellularException2);
                                } catch (Exception unused) {
                                    SessionDataCallback.this.KClassImpl$Data$declaredNonStaticMembers$2(new AuthResponse(p1.code(), string2 != null ? string2 : "", null));
                                }
                                p1.code();
                                Objects.toString(string2);
                                return;
                            }
                            if (p1.code() == 404) {
                                ResponseBody body2 = p1.body();
                                String string3 = body2 == null ? null : body2.string();
                                try {
                                    if (string3 == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    JSONObject jSONObject2 = new JSONObject(string3);
                                    CellularException cellularException3 = new CellularException();
                                    cellularException3.BuiltInFictitiousFunctionClassFactory = jSONObject2.getString("session_status");
                                    cellularException3.PlaceComponentResult = String.valueOf(p1.code());
                                    SessionDataCallback.this.PlaceComponentResult(cellularException3);
                                    return;
                                } catch (Exception unused2) {
                                    ResponseBody body3 = p1.body();
                                    string = body3 != null ? body3.string() : null;
                                    Intrinsics.stringPlus("error body ", string);
                                    cellularException = new CellularException();
                                }
                            } else {
                                ResponseBody body4 = p1.body();
                                string = body4 != null ? body4.string() : null;
                                Intrinsics.stringPlus("error body ", string);
                                cellularException = new CellularException();
                            }
                            cellularException.BuiltInFictitiousFunctionClassFactory = string;
                            cellularException.PlaceComponentResult = String.valueOf(p1.code());
                            SessionDataCallback.this.PlaceComponentResult(cellularException);
                        }
                    });
                } else {
                    AuthRequest.Builder builder2 = new AuthRequest.Builder(Uri.parse(obj));
                    builder2.KClassImpl$Data$declaredNonStaticMembers$2 = API_TYPE.OTHER;
                    DefaultConnection defaultConnection = new DefaultConnection(false, p0, builder2.KClassImpl$Data$declaredNonStaticMembers$2(), new CellularCallback<CellularResponse>() { // from class: com.ipification.mobile.sdk.im.data.SessionDataSource$callCompleteSession$defaultConnection$1
                        @Override // com.ipification.mobile.sdk.android.callback.CellularCallback
                        public final void BuiltInFictitiousFunctionClassFactory(CellularException p02) {
                            Intrinsics.checkParameterIsNotNull(p02, "");
                            CellularException cellularException = new CellularException();
                            cellularException.MyBillsEntityDataFactory = new Exception(p02.PlaceComponentResult());
                            cellularException.PlaceComponentResult = "3000";
                            sessionDataCallback.PlaceComponentResult(cellularException);
                        }

                        @Override // com.ipification.mobile.sdk.android.callback.CellularCallback
                        public final /* synthetic */ void PlaceComponentResult(CellularResponse cellularResponse) {
                            String str;
                            CellularException cellularException;
                            CellularResponse cellularResponse2 = cellularResponse;
                            Intrinsics.checkParameterIsNotNull(cellularResponse2, "");
                            if (cellularResponse2 instanceof RedirectResponse) {
                                RedirectResponse redirectResponse = (RedirectResponse) cellularResponse2;
                                String str2 = redirectResponse.getAuthRequestContext;
                                Intrinsics.stringPlus("onRedirect ", str2);
                                AuthRequest.Builder builder3 = new AuthRequest.Builder(Uri.parse(str2));
                                builder3.KClassImpl$Data$declaredNonStaticMembers$2 = redirectResponse.KClassImpl$Data$declaredNonStaticMembers$2;
                                IPConfiguration.Companion companion2 = IPConfiguration.INSTANCE;
                                if (IPConfiguration.Companion.MyBillsEntityDataFactory().NetworkUserEntityData$$ExternalSyntheticLambda5 != null) {
                                    Uri uri = IPConfiguration.Companion.MyBillsEntityDataFactory().NetworkUserEntityData$$ExternalSyntheticLambda5;
                                    if (uri == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    Intrinsics.checkParameterIsNotNull(uri, "");
                                    builder3.NetworkUserEntityData$$ExternalSyntheticLambda0 = uri;
                                }
                                DefaultConnection defaultConnection2 = new DefaultConnection(true, p0, builder3.KClassImpl$Data$declaredNonStaticMembers$2(), this);
                                defaultConnection2.BuiltInFictitiousFunctionClassFactory = true;
                                defaultConnection2.execute(new Unit[0]);
                            } else if (cellularResponse2.MyBillsEntityDataFactory == 200) {
                                String str3 = cellularResponse2.getAuthRequestContext;
                                try {
                                    JSONObject jSONObject = new JSONObject(str3);
                                    CellularException cellularException2 = new CellularException();
                                    cellularException2.BuiltInFictitiousFunctionClassFactory = jSONObject.getString("session_status");
                                    cellularException2.PlaceComponentResult = String.valueOf(cellularResponse2.MyBillsEntityDataFactory);
                                    sessionDataCallback.PlaceComponentResult(cellularException2);
                                } catch (Exception unused) {
                                    sessionDataCallback.KClassImpl$Data$declaredNonStaticMembers$2(new AuthResponse(cellularResponse2.MyBillsEntityDataFactory, str3 != null ? str3 : "", null));
                                }
                                int i = cellularResponse2.MyBillsEntityDataFactory;
                            } else {
                                if (cellularResponse2.MyBillsEntityDataFactory == 404) {
                                    try {
                                        JSONObject jSONObject2 = new JSONObject(cellularResponse2.getAuthRequestContext);
                                        CellularException cellularException3 = new CellularException();
                                        cellularException3.BuiltInFictitiousFunctionClassFactory = jSONObject2.getString("session_status");
                                        cellularException3.PlaceComponentResult = String.valueOf(cellularResponse2.MyBillsEntityDataFactory);
                                        sessionDataCallback.PlaceComponentResult(cellularException3);
                                        return;
                                    } catch (Exception unused2) {
                                        str = cellularResponse2.getAuthRequestContext;
                                        Intrinsics.stringPlus("error body ", str);
                                        cellularException = new CellularException();
                                    }
                                } else {
                                    str = cellularResponse2.getAuthRequestContext;
                                    Intrinsics.stringPlus("error body ", str);
                                    cellularException = new CellularException();
                                }
                                cellularException.BuiltInFictitiousFunctionClassFactory = str;
                                cellularException.PlaceComponentResult = String.valueOf(cellularResponse2.MyBillsEntityDataFactory);
                                sessionDataCallback.PlaceComponentResult(cellularException);
                            }
                        }
                    });
                    defaultConnection.BuiltInFictitiousFunctionClassFactory = true;
                    defaultConnection.execute(new Unit[0]);
                }
                return singleLiveEvent;
            }
            return null;
        }
        return null;
    }

    @Override // com.ipification.mobile.sdk.im.repository.SessionRepository
    public final SingleLiveEvent<String> PlaceComponentResult(Context p0, String p1) {
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        Intrinsics.checkParameterIsNotNull(p0, "");
        Intrinsics.checkParameterIsNotNull(p1, "");
        final SingleLiveEvent<String> singleLiveEvent = new SingleLiveEvent<>();
        final RedirectDataCallback redirectDataCallback = new RedirectDataCallback() { // from class: com.ipification.mobile.sdk.im.data.SessionDataSource$getRedirectLink$1
            @Override // com.ipification.mobile.sdk.im.listener.RedirectDataCallback
            public final void PlaceComponentResult(String p02) {
                Intrinsics.checkParameterIsNotNull(p02, "");
                singleLiveEvent.BuiltInFictitiousFunctionClassFactory((SingleLiveEvent<String>) p02);
            }
        };
        if (Build.VERSION.SDK_INT >= 21) {
            Request build = new Request.Builder().url(p1).build();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            InstrumentInjector.okhttp_addInterceptors(builder);
            builder.followRedirects(false);
            builder.followSslRedirects(false);
            FirebasePerfOkHttpClient.enqueue(builder.build().newCall(build), new Callback() { // from class: com.ipification.mobile.sdk.im.data.SessionDataSource$callRedirectUrl$1
                @Override // okhttp3.Callback
                public final void onFailure(Call p02, IOException p12) {
                    Intrinsics.checkParameterIsNotNull(p02, "");
                    Intrinsics.checkParameterIsNotNull(p12, "");
                    RedirectDataCallback.this.PlaceComponentResult("");
                }

                @Override // okhttp3.Callback
                public final void onResponse(Call p02, Response p12) {
                    String string;
                    RedirectDataCallback redirectDataCallback2;
                    String str = "";
                    Intrinsics.checkParameterIsNotNull(p02, "");
                    Intrinsics.checkParameterIsNotNull(p12, "");
                    if (p12.isSuccessful() || p12.isRedirect()) {
                        ResponseBody body = p12.body();
                        string = body != null ? body.string() : null;
                        String header = p12.header("Location");
                        if (header == null) {
                            header = p12.header("location");
                        }
                        if (header != null || string != null) {
                            RedirectDataCallback redirectDataCallback3 = RedirectDataCallback.this;
                            if (header != null) {
                                string = header;
                            }
                            redirectDataCallback3.PlaceComponentResult(String.valueOf(string));
                            return;
                        }
                        redirectDataCallback2 = RedirectDataCallback.this;
                    } else {
                        ResponseBody body2 = p12.body();
                        string = body2 != null ? body2.string() : null;
                        Intrinsics.stringPlus("error body ", string);
                        redirectDataCallback2 = RedirectDataCallback.this;
                        if (string != null) {
                            str = string;
                        }
                    }
                    redirectDataCallback2.PlaceComponentResult(str);
                }
            });
        } else {
            AuthRequest.Builder builder2 = new AuthRequest.Builder(Uri.parse(p1));
            builder2.KClassImpl$Data$declaredNonStaticMembers$2 = API_TYPE.OTHER;
            new DefaultConnection(false, p0, builder2.KClassImpl$Data$declaredNonStaticMembers$2(), new CellularCallback<CellularResponse>() { // from class: com.ipification.mobile.sdk.im.data.SessionDataSource$callRedirectUrl$defaultConnection$1
                @Override // com.ipification.mobile.sdk.android.callback.CellularCallback
                public final void BuiltInFictitiousFunctionClassFactory(CellularException p02) {
                    Intrinsics.checkParameterIsNotNull(p02, "");
                    RedirectDataCallback.this.PlaceComponentResult("");
                }

                @Override // com.ipification.mobile.sdk.android.callback.CellularCallback
                public final /* synthetic */ void PlaceComponentResult(CellularResponse cellularResponse) {
                    CellularResponse cellularResponse2 = cellularResponse;
                    Intrinsics.checkParameterIsNotNull(cellularResponse2, "");
                    RedirectDataCallback.this.PlaceComponentResult(cellularResponse2.getAuthRequestContext);
                }
            }).execute(new Unit[0]);
        }
        return singleLiveEvent;
    }
}
