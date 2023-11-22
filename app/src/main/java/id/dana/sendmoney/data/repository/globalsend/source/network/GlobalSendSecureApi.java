package id.dana.sendmoney.data.repository.globalsend.source.network;

import id.dana.network.base.ResultResponse;
import id.dana.sendmoney.data.api.globalsend.country.model.CountryEntity;
import id.dana.sendmoney.data.api.globalsend.province.model.ProvinceEntity;
import id.dana.sendmoney.data.api.globalsend.validate.model.request.TransferValidateEntityRequest;
import id.dana.sendmoney.data.api.globalsend.validate.model.response.TransferValidateEntityResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eJ#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0007J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0001\u0010\u0003\u001a\u00020\nH§@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\rø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/data/repository/globalsend/source/network/GlobalSendSecureApi;", "", "", "p0", "", "Lid/dana/sendmoney/data/api/globalsend/country/model/CountryEntity;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/sendmoney/data/api/globalsend/province/model/ProvinceEntity;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/data/api/globalsend/validate/model/request/TransferValidateEntityRequest;", "Lid/dana/network/base/ResultResponse;", "Lid/dana/sendmoney/data/api/globalsend/validate/model/response/TransferValidateEntityResult;", "(Lid/dana/sendmoney/data/api/globalsend/validate/model/request/TransferValidateEntityRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface GlobalSendSecureApi {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.MyBillsEntityDataFactory;

    @POST("/wallet/api/id.dana.transferprod.transfer.validate.json")
    Object BuiltInFictitiousFunctionClassFactory(@Body TransferValidateEntityRequest transferValidateEntityRequest, Continuation<? super ResultResponse<TransferValidateEntityResult>> continuation);

    @GET
    Object BuiltInFictitiousFunctionClassFactory(@Url String str, Continuation<? super List<CountryEntity>> continuation);

    @GET
    Object KClassImpl$Data$declaredNonStaticMembers$2(@Url String str, Continuation<? super List<ProvinceEntity>> continuation);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/sendmoney/data/repository/globalsend/source/network/GlobalSendSecureApi$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion MyBillsEntityDataFactory = new Companion();

        private Companion() {
        }
    }
}
