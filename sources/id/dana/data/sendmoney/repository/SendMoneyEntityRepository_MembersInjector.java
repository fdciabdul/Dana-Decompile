package id.dana.data.sendmoney.repository;

import dagger.MembersInjector;
import id.dana.data.content.mapper.ContentMapper;
import id.dana.data.content.mapper.ContentsMapper;
import id.dana.data.content.source.ContentDeliveryEntityDataFactory;
import id.dana.data.sendmoney.mapper.BizTransferInitMapper;
import id.dana.data.sendmoney.mapper.SendMoneyMapper;
import id.dana.data.sendmoney.mapper.SendMoneyScenariosMapper;
import id.dana.data.sendmoney.mapper.TransferInitParamRequestMapper;
import id.dana.data.sendmoney.mapper.TransferOrderCreateMapper;
import id.dana.data.sendmoney.mapper.TransferPrePayMapper;
import id.dana.data.sendmoney.mapper.TransferSubmitParamMapper;
import id.dana.data.sendmoney.mapper.WithdrawNameCheckMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class SendMoneyEntityRepository_MembersInjector implements MembersInjector<SendMoneyEntityRepository> {
    private final Provider<BizTransferInitMapper> bizTransferInitMapperProvider;
    private final Provider<ContentDeliveryEntityDataFactory> contentDeliveryEntityDataFactoryProvider;
    private final Provider<ContentsMapper> contentsMapperProvider;
    private final Provider<ContentMapper> mapperProvider;
    private final Provider<SendMoneyMapper> sendMoneyMapperProvider;
    private final Provider<SendMoneyScenariosMapper> sendMoneyScenariosMapperProvider;
    private final Provider<TransferInitParamRequestMapper> transferInitParamRequestMapperProvider;
    private final Provider<TransferOrderCreateMapper> transferOrderCreateMapperProvider;
    private final Provider<TransferPrePayMapper> transferPrePayMapperProvider;
    private final Provider<TransferSubmitParamMapper> transferSubmitParamMapperProvider;
    private final Provider<WithdrawNameCheckMapper> withdrawNameCheckMapperProvider;

    public SendMoneyEntityRepository_MembersInjector(Provider<SendMoneyMapper> provider, Provider<BizTransferInitMapper> provider2, Provider<WithdrawNameCheckMapper> provider3, Provider<TransferSubmitParamMapper> provider4, Provider<TransferPrePayMapper> provider5, Provider<ContentsMapper> provider6, Provider<TransferInitParamRequestMapper> provider7, Provider<SendMoneyScenariosMapper> provider8, Provider<TransferOrderCreateMapper> provider9, Provider<ContentDeliveryEntityDataFactory> provider10, Provider<ContentMapper> provider11) {
        this.sendMoneyMapperProvider = provider;
        this.bizTransferInitMapperProvider = provider2;
        this.withdrawNameCheckMapperProvider = provider3;
        this.transferSubmitParamMapperProvider = provider4;
        this.transferPrePayMapperProvider = provider5;
        this.contentsMapperProvider = provider6;
        this.transferInitParamRequestMapperProvider = provider7;
        this.sendMoneyScenariosMapperProvider = provider8;
        this.transferOrderCreateMapperProvider = provider9;
        this.contentDeliveryEntityDataFactoryProvider = provider10;
        this.mapperProvider = provider11;
    }

    public static MembersInjector<SendMoneyEntityRepository> create(Provider<SendMoneyMapper> provider, Provider<BizTransferInitMapper> provider2, Provider<WithdrawNameCheckMapper> provider3, Provider<TransferSubmitParamMapper> provider4, Provider<TransferPrePayMapper> provider5, Provider<ContentsMapper> provider6, Provider<TransferInitParamRequestMapper> provider7, Provider<SendMoneyScenariosMapper> provider8, Provider<TransferOrderCreateMapper> provider9, Provider<ContentDeliveryEntityDataFactory> provider10, Provider<ContentMapper> provider11) {
        return new SendMoneyEntityRepository_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }

    public final void injectMembers(SendMoneyEntityRepository sendMoneyEntityRepository) {
        injectInjectMapperDependencies(sendMoneyEntityRepository, this.sendMoneyMapperProvider.get(), this.bizTransferInitMapperProvider.get(), this.withdrawNameCheckMapperProvider.get(), this.transferSubmitParamMapperProvider.get(), this.transferPrePayMapperProvider.get(), this.contentsMapperProvider.get(), this.transferInitParamRequestMapperProvider.get(), this.sendMoneyScenariosMapperProvider.get(), this.transferOrderCreateMapperProvider.get());
        injectInjectCdpDependencies(sendMoneyEntityRepository, this.contentDeliveryEntityDataFactoryProvider.get(), this.mapperProvider.get());
    }

    public static void injectInjectMapperDependencies(SendMoneyEntityRepository sendMoneyEntityRepository, SendMoneyMapper sendMoneyMapper, BizTransferInitMapper bizTransferInitMapper, WithdrawNameCheckMapper withdrawNameCheckMapper, TransferSubmitParamMapper transferSubmitParamMapper, TransferPrePayMapper transferPrePayMapper, ContentsMapper contentsMapper, TransferInitParamRequestMapper transferInitParamRequestMapper, SendMoneyScenariosMapper sendMoneyScenariosMapper, TransferOrderCreateMapper transferOrderCreateMapper) {
        sendMoneyEntityRepository.injectMapperDependencies(sendMoneyMapper, bizTransferInitMapper, withdrawNameCheckMapper, transferSubmitParamMapper, transferPrePayMapper, contentsMapper, transferInitParamRequestMapper, sendMoneyScenariosMapper, transferOrderCreateMapper);
    }

    public static void injectInjectCdpDependencies(SendMoneyEntityRepository sendMoneyEntityRepository, ContentDeliveryEntityDataFactory contentDeliveryEntityDataFactory, ContentMapper contentMapper) {
        sendMoneyEntityRepository.injectCdpDependencies(contentDeliveryEntityDataFactory, contentMapper);
    }
}
