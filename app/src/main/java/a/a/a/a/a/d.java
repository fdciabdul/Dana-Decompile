package a.a.a.a.a;

import id.co.bri.brizzi.Utility;
import id.co.bri.brizzi.exception.BrizziException;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes6.dex */
public class d implements Callback<ResponseBody> {
    public final /* synthetic */ a.a.a.a.a.e.c MyBillsEntityDataFactory;
    public final /* synthetic */ b getAuthRequestContext;

    public d(b bVar, a.a.a.a.a.e.c cVar) {
        this.getAuthRequestContext = bVar;
        this.MyBillsEntityDataFactory = cVar;
    }

    @Override // retrofit2.Callback
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Call<ResponseBody> call, Throwable th) {
        this.MyBillsEntityDataFactory.onFailure(new BrizziException("98"));
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
            if (!response.MyBillsEntityDataFactory()) {
                this.MyBillsEntityDataFactory.onFailure(new BrizziException("98"));
                return;
            }
            this.MyBillsEntityDataFactory.onReceive(response.KClassImpl$Data$declaredNonStaticMembers$2.string());
        } catch (IOException unused) {
            this.MyBillsEntityDataFactory.onFailure(new BrizziException("98"));
        }
    }
}
