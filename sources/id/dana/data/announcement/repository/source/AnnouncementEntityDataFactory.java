package id.dana.data.announcement.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.announcement.AnnouncementEntityData;
import id.dana.data.announcement.repository.source.local.LocalAnnouncementEntityData;
import id.dana.data.announcement.repository.source.mock.MockAnnouncementEntityData;
import id.dana.data.announcement.repository.source.network.NetworkAnnouncementEntityData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/data/announcement/repository/source/AnnouncementEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/announcement/AnnouncementEntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/announcement/AnnouncementEntityData;", "Lid/dana/data/announcement/repository/source/local/LocalAnnouncementEntityData;", "localAnnouncementEntityData", "Lid/dana/data/announcement/repository/source/local/LocalAnnouncementEntityData;", "Lid/dana/data/announcement/repository/source/mock/MockAnnouncementEntityData;", "mockAnnouncementEntityData", "Lid/dana/data/announcement/repository/source/mock/MockAnnouncementEntityData;", "Lid/dana/data/announcement/repository/source/network/NetworkAnnouncementEntityData;", "networkAnnouncementEntityData", "Lid/dana/data/announcement/repository/source/network/NetworkAnnouncementEntityData;", "<init>", "(Lid/dana/data/announcement/repository/source/network/NetworkAnnouncementEntityData;Lid/dana/data/announcement/repository/source/mock/MockAnnouncementEntityData;Lid/dana/data/announcement/repository/source/local/LocalAnnouncementEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AnnouncementEntityDataFactory extends AbstractEntityDataFactory<AnnouncementEntityData> {
    private final LocalAnnouncementEntityData localAnnouncementEntityData;
    private final MockAnnouncementEntityData mockAnnouncementEntityData;
    private final NetworkAnnouncementEntityData networkAnnouncementEntityData;

    @Inject
    public AnnouncementEntityDataFactory(NetworkAnnouncementEntityData networkAnnouncementEntityData, MockAnnouncementEntityData mockAnnouncementEntityData, LocalAnnouncementEntityData localAnnouncementEntityData) {
        Intrinsics.checkNotNullParameter(networkAnnouncementEntityData, "");
        Intrinsics.checkNotNullParameter(mockAnnouncementEntityData, "");
        Intrinsics.checkNotNullParameter(localAnnouncementEntityData, "");
        this.networkAnnouncementEntityData = networkAnnouncementEntityData;
        this.mockAnnouncementEntityData = mockAnnouncementEntityData;
        this.localAnnouncementEntityData = localAnnouncementEntityData;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final AnnouncementEntityData createData2(String source) {
        return Intrinsics.areEqual(source, "mock") ? this.mockAnnouncementEntityData : Intrinsics.areEqual(source, "local") ? this.localAnnouncementEntityData : this.networkAnnouncementEntityData;
    }
}
