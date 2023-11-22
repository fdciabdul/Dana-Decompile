package id.dana.data.zendesk.repository.source;

import id.dana.data.zendesk.repository.source.network.request.CreateZendeskTicketRequest;
import id.dana.data.zendesk.repository.source.network.response.CreateZendeskTicketResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lid/dana/data/zendesk/repository/source/ZendeskEntityData;", "", "createTicket", "Lio/reactivex/Single;", "Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse;", "base64AuthString", "", "createZendeskTicketRequest", "Lid/dana/data/zendesk/repository/source/network/request/CreateZendeskTicketRequest;", "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ZendeskEntityData {
    Single<CreateZendeskTicketResponse> createTicket(String base64AuthString, CreateZendeskTicketRequest createZendeskTicketRequest);

    /* renamed from: id.dana.data.zendesk.repository.source.ZendeskEntityData$-CC  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC {
        public static Single $default$createTicket(ZendeskEntityData zendeskEntityData, String str, CreateZendeskTicketRequest createZendeskTicketRequest) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(createZendeskTicketRequest, "");
            Single MyBillsEntityDataFactory = Single.MyBillsEntityDataFactory((Object) null);
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
            return MyBillsEntityDataFactory;
        }
    }
}
