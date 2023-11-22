package id.dana.feeds.data.relationship.mapper;

import id.dana.data.social.repository.source.persistence.entity.PaginatorEntity;
import id.dana.feeds.data.relationship.source.network.response.PaginatorResponse;
import id.dana.feeds.domain.relationship.model.Paginator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/social/repository/source/persistence/entity/PaginatorEntity;", "Lid/dana/feeds/domain/relationship/model/Paginator;", "getAuthRequestContext", "(Lid/dana/data/social/repository/source/persistence/entity/PaginatorEntity;)Lid/dana/feeds/domain/relationship/model/Paginator;", "Lid/dana/feeds/data/relationship/source/network/response/PaginatorResponse;", "MyBillsEntityDataFactory", "(Lid/dana/feeds/data/relationship/source/network/response/PaginatorResponse;)Lid/dana/feeds/domain/relationship/model/Paginator;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PaginatorMapperKt {
    public static final Paginator getAuthRequestContext(PaginatorEntity paginatorEntity) {
        Intrinsics.checkNotNullParameter(paginatorEntity, "");
        return new Paginator(paginatorEntity.getBeginIndex(), paginatorEntity.getEndIndex(), paginatorEntity.getFirstPage(), paginatorEntity.getItems(), paginatorEntity.getItemsPerPage(), paginatorEntity.getLastPage(), paginatorEntity.getLength(), paginatorEntity.getNextPage(), paginatorEntity.getOffset(), paginatorEntity.getPage(), paginatorEntity.getPages(), paginatorEntity.getPreviousPage(), null, 4096, null);
    }

    public static final Paginator MyBillsEntityDataFactory(PaginatorResponse paginatorResponse) {
        Intrinsics.checkNotNullParameter(paginatorResponse, "");
        return new Paginator(paginatorResponse.getBeginIndex(), paginatorResponse.getEndIndex(), paginatorResponse.getFirstPage(), paginatorResponse.getItems(), paginatorResponse.getItemsPerPage(), paginatorResponse.getLastPage(), paginatorResponse.getLength(), paginatorResponse.getNextPage(), paginatorResponse.getOffset(), paginatorResponse.getPage(), paginatorResponse.getPages(), paginatorResponse.getPreviousPage(), null, 4096, null);
    }
}
