package id.dana.data.config.source.split;

import id.dana.data.config.model.StartupConfigEntity;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/data/config/source/split/DefaultStartupConfigGenerator;", "", "Lid/dana/data/config/model/StartupConfigEntity;", "generate", "()Lid/dana/data/config/model/StartupConfigEntity;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DefaultStartupConfigGenerator {
    public static final DefaultStartupConfigGenerator INSTANCE = new DefaultStartupConfigGenerator();

    private DefaultStartupConfigGenerator() {
    }

    public final StartupConfigEntity generate() {
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = Boolean.FALSE;
        return new StartupConfigEntity(bool, bool, bool2, 1, CollectionsKt.listOf((Object[]) new String[]{"https://a.m.dana.id/app/common/sec/mgs-gw.m.dana.id-fullchain-exp_11_jul_2024.cer", "https://a.m.dana.id/app/common/sec/star_m_dana_id_akamai_2022-2023.cer", "https://a.m.dana.id/app/common/sec/star_m_dana_id_abc_2022-2023.cer", "https://a.m.dana.id/app/common/sec/mgs-gw_m_dana_id_bin_ak_2022-2023.cer", "https://a.m.dana.id/app/common/sec/star_m_dana_id_bundle_2023-2024.cer"}), CollectionsKt.listOf((Object[]) new String[]{"mgs-gw.m.dana.id", "m.dana.id", "sec.m.dana.id"}), bool2, bool2, bool2);
    }
}
