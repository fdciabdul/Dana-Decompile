package id.dana.data.config.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.config.source.amcs.result.DonationCampaignConfigResult;
import id.dana.domain.featureconfig.model.DonationCampaignConfig;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/config/mapper/DonationCampaignConfigMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/data/config/source/amcs/result/DonationCampaignConfigResult;", "Lid/dana/domain/featureconfig/model/DonationCampaignConfig;", "oldItem", "map", "(Lid/dana/data/config/source/amcs/result/DonationCampaignConfigResult;)Lid/dana/domain/featureconfig/model/DonationCampaignConfig;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DonationCampaignConfigMapper extends BaseMapper<DonationCampaignConfigResult, DonationCampaignConfig> {
    @Inject
    public DonationCampaignConfigMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public final DonationCampaignConfig map(DonationCampaignConfigResult oldItem) {
        Intrinsics.checkNotNullParameter(oldItem, "");
        return new DonationCampaignConfig(oldItem.getEnable(), oldItem.getTitle(), oldItem.getDescription(), oldItem.getButtonTitle(), oldItem.getRedirectUrl(), oldItem.getAction());
    }
}
