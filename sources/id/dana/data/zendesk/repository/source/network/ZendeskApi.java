package id.dana.data.zendesk.repository.source.network;

import id.dana.data.zendesk.repository.source.network.request.CreateZendeskTicketRequest;
import id.dana.data.zendesk.repository.source.network.response.CreateZendeskTicketResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J)\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u0004H'¢\u0006\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/zendesk/repository/source/network/ZendeskApi;", "", "", "base64AuthString", "Lid/dana/data/zendesk/repository/source/network/request/CreateZendeskTicketRequest;", "createZendeskTicketRequest", "Lio/reactivex/Single;", "Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse;", "createTicket", "(Ljava/lang/String;Lid/dana/data/zendesk/repository/source/network/request/CreateZendeskTicketRequest;)Lio/reactivex/Single;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ZendeskApi {
    @POST("/api/v2/tickets")
    Single<CreateZendeskTicketResponse> createTicket(@Header("Authorization") String base64AuthString, @Body CreateZendeskTicketRequest createZendeskTicketRequest);
}
