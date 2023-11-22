package id.dana.data.zendesk.mapper;

import id.dana.data.zendesk.repository.source.network.request.CreateZendeskTicketRequest;
import id.dana.domain.zendesk.model.ZendeskBasicTicket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/domain/zendesk/model/ZendeskBasicTicket;", "Lid/dana/data/zendesk/repository/source/network/request/CreateZendeskTicketRequest;", "toCreateZendeskTicketRequest", "(Lid/dana/domain/zendesk/model/ZendeskBasicTicket;)Lid/dana/data/zendesk/repository/source/network/request/CreateZendeskTicketRequest;", "Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse;", "Lid/dana/domain/zendesk/model/ZendeskBasicTicketResult;", "toZendeskBasicTicketResult", "(Lid/dana/data/zendesk/repository/source/network/response/CreateZendeskTicketResponse;)Lid/dana/domain/zendesk/model/ZendeskBasicTicketResult;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ZendeskEntityRepositoryMapperExtKt {
    public static final CreateZendeskTicketRequest toCreateZendeskTicketRequest(ZendeskBasicTicket zendeskBasicTicket) {
        Intrinsics.checkNotNullParameter(zendeskBasicTicket, "");
        return new CreateZendeskTicketRequest(new CreateZendeskTicketRequest.Ticket(new CreateZendeskTicketRequest.Comment(zendeskBasicTicket.getBody()), zendeskBasicTicket.getPriority(), zendeskBasicTicket.getSubject()));
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final id.dana.domain.zendesk.model.ZendeskBasicTicketResult toZendeskBasicTicketResult(id.dana.data.zendesk.repository.source.network.response.CreateZendeskTicketResponse r36) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.zendesk.mapper.ZendeskEntityRepositoryMapperExtKt.toZendeskBasicTicketResult(id.dana.data.zendesk.repository.source.network.response.CreateZendeskTicketResponse):id.dana.domain.zendesk.model.ZendeskBasicTicketResult");
    }
}
