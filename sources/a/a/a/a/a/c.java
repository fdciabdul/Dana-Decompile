package a.a.a.a.a;

import id.co.bri.brizzi.Utility;
import id.co.bri.brizzi.exception.BrizziException;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes6.dex */
public class c implements Callback<ResponseBody> {
    public final /* synthetic */ a.a.a.a.a.e.b KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ b getAuthRequestContext;

    public c(b bVar, a.a.a.a.a.e.b bVar2) {
        this.getAuthRequestContext = bVar;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bVar2;
    }

    @Override // retrofit2.Callback
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Call<ResponseBody> call, Throwable th) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.onReceive("44");
    }

    @Override // retrofit2.Callback
    public final void PlaceComponentResult(Call<ResponseBody> call, Response<ResponseBody> response) {
        try {
            Utility utility = this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
            StringBuilder sb = new StringBuilder();
            sb.append("HTTP Code API : ");
            sb.append(response.getAuthRequestContext.code());
            sb.append(", Message : ");
            sb.append(response.getAuthRequestContext.message());
            utility.writeAdvanceDebuggingLog(String.valueOf(sb.toString()));
            if (response.MyBillsEntityDataFactory()) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.onReceive(response.KClassImpl$Data$declaredNonStaticMembers$2.string());
            } else if (response.getAuthRequestContext.code() == 504) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.onReceive("44");
            } else {
                this.KClassImpl$Data$declaredNonStaticMembers$2.onFailure(new BrizziException("98"));
            }
        } catch (IOException unused) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.onFailure(new BrizziException("98"));
        }
    }
}
