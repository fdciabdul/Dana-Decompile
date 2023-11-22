package id.dana.data.payasset.mapper;

import id.dana.data.BaseMapper;
import id.dana.data.payasset.source.network.result.AmountRangeResult;
import id.dana.data.payasset.source.network.result.ChangePayMethodResult;
import id.dana.data.payasset.source.network.result.PayCardOptionViewDTO;
import id.dana.data.payasset.source.network.result.PayChannelOptionViewDTO;
import id.dana.data.payasset.source.network.result.PayMethodViewDTO;
import id.dana.data.payasset.source.network.result.QueryPayMethodResult;
import id.dana.data.sendmoney.mapper.CurrencyAmountResultMapper;
import id.dana.domain.payasset.model.AmountRange;
import id.dana.domain.payasset.model.ChangePayMethodResponse;
import id.dana.domain.payasset.model.PayCardOptionView;
import id.dana.domain.payasset.model.PayChannelOptionView;
import id.dana.domain.payasset.model.PayMethodView;
import id.dana.domain.payasset.model.QueryPayMethodResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class PayAssetMapper {
    private final CurrencyAmountResultMapper currencyAmountResultMapper;

    @Inject
    public PayAssetMapper(CurrencyAmountResultMapper currencyAmountResultMapper) {
        this.currencyAmountResultMapper = currencyAmountResultMapper;
    }

    public ChangePayMethodResponse transform(ChangePayMethodResult changePayMethodResult) {
        if (changePayMethodResult != null) {
            ChangePayMethodResponse changePayMethodResponse = new ChangePayMethodResponse();
            BaseMapper.transform(changePayMethodResponse, changePayMethodResult);
            return changePayMethodResponse;
        }
        return null;
    }

    public QueryPayMethodResponse transform(QueryPayMethodResult queryPayMethodResult) {
        if (queryPayMethodResult != null) {
            QueryPayMethodResponse queryPayMethodResponse = new QueryPayMethodResponse();
            BaseMapper.transform(queryPayMethodResponse, queryPayMethodResult);
            queryPayMethodResponse.setDefaultOption(queryPayMethodResult.defaultOption);
            queryPayMethodResponse.setPayMethodViews(transformPayMethods(queryPayMethodResult.payMethodViewDTOS));
            queryPayMethodResponse.setStandardCardOptionViews(transformCardOptions(queryPayMethodResult.standardCardOptionViews));
            queryPayMethodResponse.setCountryCode(queryPayMethodResult.countryCode);
            return queryPayMethodResponse;
        }
        return null;
    }

    public List<PayMethodView> transformPayMethods(List<PayMethodViewDTO> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<PayMethodViewDTO> it = list.iterator();
        while (it.hasNext()) {
            PayMethodView transform = transform(it.next());
            if (transform != null) {
                arrayList.add(transform);
            }
        }
        return arrayList;
    }

    public PayMethodView transform(PayMethodViewDTO payMethodViewDTO) {
        if (payMethodViewDTO != null) {
            PayMethodView payMethodView = new PayMethodView();
            payMethodView.setPayMethod(payMethodViewDTO.payMethod);
            payMethodView.setPayCardOptionViews(transformCardOptions(payMethodViewDTO.payCardOptionViewDTOs));
            payMethodView.setPayChannelOptionViews(transformChannelOptions(payMethodViewDTO.payChannelOptionViewDTOS));
            return payMethodView;
        }
        return null;
    }

    public List<PayCardOptionView> transformCardOptions(List<PayCardOptionViewDTO> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<PayCardOptionViewDTO> it = list.iterator();
        while (it.hasNext()) {
            PayCardOptionView transform = transform(it.next());
            if (transform != null) {
                arrayList.add(transform);
            }
        }
        return arrayList;
    }

    public PayCardOptionView transform(PayCardOptionViewDTO payCardOptionViewDTO) {
        if (payCardOptionViewDTO != null) {
            PayCardOptionView payCardOptionView = new PayCardOptionView();
            payCardOptionView.setAssetType(payCardOptionViewDTO.assetType);
            payCardOptionView.setBindingId(payCardOptionViewDTO.bindingId);
            payCardOptionView.setCardBin(payCardOptionViewDTO.cardBin);
            payCardOptionView.setCardIndexNo(payCardOptionViewDTO.cardIndexNo);
            payCardOptionView.setCardNoLength(payCardOptionViewDTO.cardNoLength);
            payCardOptionView.setCardScheme(payCardOptionViewDTO.cardScheme);
            payCardOptionView.setDefaultCard(payCardOptionViewDTO.defaultCard);
            payCardOptionView.setEnableStatus(payCardOptionViewDTO.enableStatus);
            payCardOptionView.setExpiryMonth(payCardOptionViewDTO.expiryMonth);
            payCardOptionView.setExpiryYear(payCardOptionViewDTO.expiryYear);
            payCardOptionView.setExtendInfo(payCardOptionViewDTO.extendInfo);
            payCardOptionView.setHolderName(payCardOptionViewDTO.holderName);
            payCardOptionView.setInstId(payCardOptionViewDTO.instId);
            payCardOptionView.setInstName(payCardOptionViewDTO.instName);
            payCardOptionView.setMaskedCardNo(payCardOptionViewDTO.maskedCardNo);
            payCardOptionView.setPayMethod(payCardOptionViewDTO.payMethod);
            payCardOptionView.setPayOption(payCardOptionViewDTO.payOption);
            payCardOptionView.setPayWithoutCVV(payCardOptionViewDTO.payWithoutCVV);
            payCardOptionView.setPayVerifyElements(payCardOptionViewDTO.payVerifyElements);
            payCardOptionView.setOfflinePayIndex(payCardOptionViewDTO.offlinePayIndex);
            return payCardOptionView;
        }
        return null;
    }

    public List<PayChannelOptionView> transformChannelOptions(List<PayChannelOptionViewDTO> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<PayChannelOptionViewDTO> it = list.iterator();
        while (it.hasNext()) {
            PayChannelOptionView transform = transform(it.next());
            if (transform != null) {
                arrayList.add(transform);
            }
        }
        return arrayList;
    }

    public PayChannelOptionView transform(PayChannelOptionViewDTO payChannelOptionViewDTO) {
        if (payChannelOptionViewDTO != null) {
            PayChannelOptionView payChannelOptionView = new PayChannelOptionView();
            payChannelOptionView.setAmountRange(transform(payChannelOptionViewDTO.amountRange));
            payChannelOptionView.setBankCode(payChannelOptionViewDTO.bankCode);
            payChannelOptionView.setDisableReason(payChannelOptionViewDTO.disableReason);
            payChannelOptionView.setEnableStatus(payChannelOptionViewDTO.enableStatus);
            payChannelOptionView.setExtendInfo(payChannelOptionViewDTO.extendInfo);
            payChannelOptionView.setInstId(payChannelOptionViewDTO.instId);
            payChannelOptionView.setInstName(payChannelOptionViewDTO.instName);
            payChannelOptionView.setInstLocalName(payChannelOptionViewDTO.instLocalName);
            payChannelOptionView.setInterBank(payChannelOptionViewDTO.interBank);
            payChannelOptionView.setPayAccountNo(payChannelOptionViewDTO.payAccountNo);
            payChannelOptionView.setPayMethod(payChannelOptionViewDTO.payMethod);
            payChannelOptionView.setPayOption(payChannelOptionViewDTO.payOption);
            payChannelOptionView.setOfflinePayIndex(payChannelOptionViewDTO.offlinePayIndex);
            return payChannelOptionView;
        }
        return null;
    }

    public AmountRange transform(AmountRangeResult amountRangeResult) {
        if (amountRangeResult != null) {
            AmountRange amountRange = new AmountRange();
            amountRange.setMaxAmount(this.currencyAmountResultMapper.apply(amountRangeResult.maxAmount));
            amountRange.setMinAmount(this.currencyAmountResultMapper.apply(amountRangeResult.minAmount));
            return amountRange;
        }
        return null;
    }
}
