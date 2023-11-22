package id.dana.data.util;

import id.dana.data.config.source.amcs.result.SplitBillConfigResult;
import id.dana.data.sendmoney.x2l.model.SocialLinkEntity;
import id.dana.domain.notificationcenter.interactor.ConnectionType;
import id.dana.tracker.mixpanel.ChallengeEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\tJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\t"}, d2 = {"Lid/dana/data/util/SendMoneyDefaultConfigGenerator;", "", "", "", "createSendMoneyHomeCategory", "()Ljava/util/List;", "createSendMoneyPayMethodSection", "Lid/dana/data/sendmoney/x2l/model/SocialLinkEntity;", "createSendMoneySocialInstagram", "()Lid/dana/data/sendmoney/x2l/model/SocialLinkEntity;", "createSendMoneySocialLine", "createSendMoneySocialMedia", "createSendMoneySocialMesseger", "createSendMoneySocialTelegram", "createSendMoneySocialWhatsApp", "Lid/dana/data/config/source/amcs/result/SplitBillConfigResult;", "createSplitBillConfig", "()Lid/dana/data/config/source/amcs/result/SplitBillConfigResult;", "cretaeSendMoneySocialOthers", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SendMoneyDefaultConfigGenerator {
    public static final SendMoneyDefaultConfigGenerator INSTANCE = new SendMoneyDefaultConfigGenerator();

    private SendMoneyDefaultConfigGenerator() {
    }

    public final List<String> createSendMoneyPayMethodSection() {
        return CollectionsKt.listOf("sm_add_pm_debit_card");
    }

    public final List<String> createSendMoneyHomeCategory() {
        return CollectionsKt.listOf((Object[]) new String[]{"send_money_phone", "send_money_bank", "send_money_external", "send_money_chat", "send_money_scan_qr"});
    }

    public final SplitBillConfigResult createSplitBillConfig() {
        SplitBillConfigResult splitBillConfigResult = new SplitBillConfigResult();
        splitBillConfigResult.setFeatureEnable(false);
        splitBillConfigResult.setMaxRecipient(20);
        return splitBillConfigResult;
    }

    public final List<SocialLinkEntity> createSendMoneySocialMedia() {
        return CollectionsKt.listOf((Object[]) new SocialLinkEntity[]{createSendMoneySocialWhatsApp(), createSendMoneySocialTelegram(), createSendMoneySocialLine(), createSendMoneySocialMesseger(), createSendMoneySocialInstagram(), cretaeSendMoneySocialOthers()});
    }

    private final SocialLinkEntity createSendMoneySocialWhatsApp() {
        return new SocialLinkEntity("send_money_to", ChallengeEvent.Channel.WHATSAPP, ChallengeEvent.Channel.WHATSAPP, "");
    }

    private final SocialLinkEntity createSendMoneySocialTelegram() {
        return new SocialLinkEntity("send_money_to", "Telegram", "Telegram", "");
    }

    private final SocialLinkEntity createSendMoneySocialLine() {
        return new SocialLinkEntity("send_money_to", "Line", "Line", "");
    }

    private final SocialLinkEntity createSendMoneySocialMesseger() {
        return new SocialLinkEntity("send_money_to", "Messenger", "Messenger", "");
    }

    private final SocialLinkEntity createSendMoneySocialInstagram() {
        return new SocialLinkEntity("send_money_to", "Instagram", "Instagram", "");
    }

    private final SocialLinkEntity cretaeSendMoneySocialOthers() {
        return new SocialLinkEntity("", ConnectionType.OTHERS, ConnectionType.OTHERS, "");
    }
}
