package id.dana.data.zendesk.repository.source.network;

import id.dana.data.zendesk.repository.source.ZendeskEntityData;
import id.dana.data.zendesk.repository.source.network.request.CreateZendeskTicketRequest;
import id.dana.data.zendesk.repository.source.network.response.CreateZendeskTicketResponse;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/zendesk/repository/source/network/NetworkZendeskEntityData;", "Lid/dana/data/zendesk/repository/source/ZendeskEntityData;", "", "base64AuthString", "Lid/dana/data/zendesk/repository/source/network/request/CreateZendeskTicketRequest;", "createZendeskTicketRequest", "Lio/reactivex/Single;", "Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse;", "createTicket", "(Ljava/lang/String;Lid/dana/data/zendesk/repository/source/network/request/CreateZendeskTicketRequest;)Lio/reactivex/Single;", "Lid/dana/data/zendesk/repository/source/network/ZendeskApi;", "zendeskApi", "Lid/dana/data/zendesk/repository/source/network/ZendeskApi;", "<init>", "(Lid/dana/data/zendesk/repository/source/network/ZendeskApi;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkZendeskEntityData implements ZendeskEntityData {
    private final ZendeskApi zendeskApi;

    @Inject
    public NetworkZendeskEntityData(ZendeskApi zendeskApi) {
        Intrinsics.checkNotNullParameter(zendeskApi, "");
        this.zendeskApi = zendeskApi;
    }

    @Override // id.dana.data.zendesk.repository.source.ZendeskEntityData
    public final Single<CreateZendeskTicketResponse> createTicket(String base64AuthString, CreateZendeskTicketRequest createZendeskTicketRequest) {
        Intrinsics.checkNotNullParameter(base64AuthString, "");
        Intrinsics.checkNotNullParameter(createZendeskTicketRequest, "");
        return this.zendeskApi.createTicket(base64AuthString, createZendeskTicketRequest);
    }
}
