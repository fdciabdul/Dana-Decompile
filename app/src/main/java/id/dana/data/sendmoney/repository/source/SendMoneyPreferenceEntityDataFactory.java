package id.dana.data.sendmoney.repository.source;

import id.dana.data.AbstractEntityDataFactory;
import id.dana.data.sendmoney.repository.source.local.PreferenceSendMoneyEntityData;
import id.dana.data.sendmoney.repository.source.local.SendMoneyPreference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/data/sendmoney/repository/source/SendMoneyPreferenceEntityDataFactory;", "Lid/dana/data/AbstractEntityDataFactory;", "Lid/dana/data/sendmoney/repository/source/local/PreferenceSendMoneyEntityData;", "", "source", "createData", "(Ljava/lang/String;)Lid/dana/data/sendmoney/repository/source/local/PreferenceSendMoneyEntityData;", "Lid/dana/data/sendmoney/repository/source/local/SendMoneyPreference;", "sendMoneyPreference", "Lid/dana/data/sendmoney/repository/source/local/SendMoneyPreference;", "<init>", "(Lid/dana/data/sendmoney/repository/source/local/SendMoneyPreference;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SendMoneyPreferenceEntityDataFactory extends AbstractEntityDataFactory<PreferenceSendMoneyEntityData> {
    private final SendMoneyPreference sendMoneyPreference;

    @Inject
    public SendMoneyPreferenceEntityDataFactory(SendMoneyPreference sendMoneyPreference) {
        Intrinsics.checkNotNullParameter(sendMoneyPreference, "");
        this.sendMoneyPreference = sendMoneyPreference;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // id.dana.data.AbstractEntityDataFactory
    /* renamed from: createData */
    public final PreferenceSendMoneyEntityData createData2(String source) {
        return new PreferenceSendMoneyEntityData(this.sendMoneyPreference);
    }
}
