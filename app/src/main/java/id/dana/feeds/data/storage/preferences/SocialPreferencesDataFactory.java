package id.dana.feeds.data.storage.preferences;

import id.dana.data.AbstractEntityDataFactory;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/feeds/data/storage/preferences/SocialPreferencesDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/feeds/data/storage/preferences/SocialPreferencesData;", "Lid/dana/feeds/data/storage/preferences/SocialPreferences;", "MyBillsEntityDataFactory", "Lid/dana/feeds/data/storage/preferences/SocialPreferences;", "PlaceComponentResult", "p0", "<init>", "(Lid/dana/feeds/data/storage/preferences/SocialPreferences;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SocialPreferencesDataFactory extends AbstractEntityDataFactory<SocialPreferencesData> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public SocialPreferences PlaceComponentResult;

    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final /* synthetic */ SocialPreferencesData createData2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new LocalSocialPreferencesData(this.PlaceComponentResult);
    }

    @Inject
    public SocialPreferencesDataFactory(SocialPreferences socialPreferences) {
        Intrinsics.checkNotNullParameter(socialPreferences, "");
        this.PlaceComponentResult = socialPreferences;
    }
}
