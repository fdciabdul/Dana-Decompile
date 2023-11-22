package id.dana.mapper;

import dagger.internal.Factory;
import id.dana.base.BaseResponseMapper;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class PocketNumUpdatedMapper_Factory implements Factory<PocketNumUpdatedMapper> {
    private final Provider<BaseResponseMapper> MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new PocketNumUpdatedMapper(this.MyBillsEntityDataFactory.get());
    }
}
