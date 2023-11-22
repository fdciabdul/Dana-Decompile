package a.a.a.a.a;

import com.fullstory.instrumentation.InstrumentInjector;
import id.co.bri.brizzi.Utility;
import id.co.bri.brizzi.exception.BrizziException;
import id.co.bri.brizzi.exception.ExceptionList;
import id.co.bri.brizzi.hostService.APIData;
import id.co.bri.brizzi.hostService.HostUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* loaded from: classes6.dex */
public class b {
    public Utility KClassImpl$Data$declaredNonStaticMembers$2;
    public a.a.a.a.a.a MyBillsEntityDataFactory;
    public HostUtil PlaceComponentResult;

    public final void getAuthRequestContext(APIData aPIData, String str, a.a.a.a.a.e.a aVar) {
        try {
            this.KClassImpl$Data$declaredNonStaticMembers$2.writeAdvanceDebuggingLog(aPIData.getBody());
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append("Bearer ");
            sb.append(aPIData.ldUfdlAlicDjlJVa());
            hashMap.put("Authorization", sb.toString());
            hashMap.put("Content-Type", "text/plain; charset=UTF-8");
            hashMap.put("BRI-Signature", aPIData.getSignature());
            hashMap.put("BRI-Timestamp", aPIData.getTimestamp());
            hashMap.put("BRI-External-Id", str);
            this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(aPIData.getBody(), hashMap).MyBillsEntityDataFactory(new a(aVar));
        } catch (Exception e) {
            InstrumentInjector.log_e("Exception", e.getMessage());
        }
    }

    public b() {
        HostUtil hostUtil = new HostUtil();
        this.PlaceComponentResult = hostUtil;
        String str = hostUtil.f8019a;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        InstrumentInjector.okhttp_addInterceptors(builder);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient build = builder.connectTimeout(55L, timeUnit).writeTimeout(55L, timeUnit).readTimeout(55L, timeUnit).retryOnConnectionFailure(false).build();
        Retrofit.Builder builder2 = new Retrofit.Builder();
        builder2.MyBillsEntityDataFactory = (Call.Factory) Objects.requireNonNull((Call.Factory) Objects.requireNonNull(build, "client == null"), "factory == null");
        Objects.requireNonNull(str, "baseUrl == null");
        Retrofit.Builder BuiltInFictitiousFunctionClassFactory = builder2.BuiltInFictitiousFunctionClassFactory(HttpUrl.get(str));
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.add((Converter.Factory) Objects.requireNonNull(ScalarsConverterFactory.getAuthRequestContext(), "factory == null"));
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.add((Converter.Factory) Objects.requireNonNull(GsonConverterFactory.BuiltInFictitiousFunctionClassFactory(), "factory == null"));
        this.MyBillsEntityDataFactory = (a.a.a.a.a.a) BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(a.a.a.a.a.a.class);
        new ExceptionList();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new Utility();
    }

    /* loaded from: classes6.dex */
    public class a implements Callback<ResponseBody> {
        public final /* synthetic */ a.a.a.a.a.e.a PlaceComponentResult;

        public a(a.a.a.a.a.e.a aVar) {
            this.PlaceComponentResult = aVar;
        }

        @Override // retrofit2.Callback
        public final void KClassImpl$Data$declaredNonStaticMembers$2(retrofit2.Call<ResponseBody> call, Throwable th) {
            this.PlaceComponentResult.onFailure(new BrizziException("98"));
        }

        @Override // retrofit2.Callback
        public final void PlaceComponentResult(retrofit2.Call<ResponseBody> call, Response<ResponseBody> response) {
            try {
                Utility utility = b.this.KClassImpl$Data$declaredNonStaticMembers$2;
                StringBuilder sb = new StringBuilder();
                sb.append("HTTP Code API : ");
                sb.append(response.getAuthRequestContext.code());
                sb.append(", Message : ");
                sb.append(response.getAuthRequestContext.message());
                utility.writeAdvanceDebuggingLog(String.valueOf(sb.toString()));
                if (response.MyBillsEntityDataFactory()) {
                    String string = response.KClassImpl$Data$declaredNonStaticMembers$2.string();
                    b.this.KClassImpl$Data$declaredNonStaticMembers$2.writeAdvanceDebuggingLog(string);
                    this.PlaceComponentResult.onReceive(string);
                } else if (response.getAuthRequestContext.code() == 504) {
                    this.PlaceComponentResult.onFailure(new BrizziException("91"));
                } else {
                    this.PlaceComponentResult.onFailure(new BrizziException("98"));
                }
            } catch (IOException unused) {
                this.PlaceComponentResult.onFailure(new BrizziException("98"));
            }
        }
    }
}
