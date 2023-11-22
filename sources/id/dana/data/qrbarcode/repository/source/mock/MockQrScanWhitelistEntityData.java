package id.dana.data.qrbarcode.repository.source.mock;

import id.dana.data.qrbarcode.repository.source.QrScanWhitelistEntityData;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class MockQrScanWhitelistEntityData implements QrScanWhitelistEntityData {
    @Inject
    public MockQrScanWhitelistEntityData() {
    }

    @Override // id.dana.data.qrbarcode.repository.source.QrScanWhitelistEntityData
    public Observable<List<String>> getWhitelistedQrH5Container() {
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.qrbarcode.repository.source.mock.MockQrScanWhitelistEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List mockedWhitelistedQrH5Container;
                mockedWhitelistedQrH5Container = MockQrScanWhitelistEntityData.this.getMockedWhitelistedQrH5Container();
                return mockedWhitelistedQrH5Container;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> getMockedWhitelistedQrH5Container() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("\"^(http|https):\\/\\/(qr.dana.id)");
        arrayList.add("\"^(http|https):\\/\\/(link.dana.id)\"");
        arrayList.add("(m.dana.id)(\\/)");
        return arrayList;
    }
}
