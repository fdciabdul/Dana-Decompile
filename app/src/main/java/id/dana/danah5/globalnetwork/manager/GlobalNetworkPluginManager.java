package id.dana.danah5.globalnetwork.manager;

import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import id.dana.danah5.globalnetwork.GetForexBalanceResultFactory;
import id.dana.danah5.globalnetwork.InquiryResultFactory;
import id.dana.danah5.globalnetwork.model.request.InquiryForexRateEntity;
import id.dana.danah5.globalnetwork.model.result.forexbalance.ForexBalanceEntityResult;
import id.dana.danah5.globalnetwork.model.result.forexbalance.ResponseForex;
import id.dana.danah5.globalnetwork.model.result.inquiry.Rate;
import id.dana.danah5.globalnetwork.model.result.inquiry.ResponseInquiry;
import id.dana.data.globalnetwork.constants.GlobalNetworkConstants;
import id.dana.domain.DefaultObserver;
import id.dana.domain.globalnetwork.interactor.GetForex;
import id.dana.domain.globalnetwork.interactor.GetRealTimeForex;
import id.dana.domain.globalnetwork.interactor.GetSelectedCountryCode;
import id.dana.domain.globalnetwork.model.Forex;
import id.dana.utils.ForeignCurrencySymbolUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class GlobalNetworkPluginManager {
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final GetForex getForex;
    private final GetRealTimeForex getRealTimeForex;
    private final GetSelectedCountryCode getSelectedCountryCode;

    @Inject
    public GlobalNetworkPluginManager(GetSelectedCountryCode getSelectedCountryCode, GetForex getForex, GetRealTimeForex getRealTimeForex) {
        this.getSelectedCountryCode = getSelectedCountryCode;
        this.getForex = getForex;
        this.getRealTimeForex = getRealTimeForex;
    }

    public boolean inquiryForexRate(BridgeCallback bridgeCallback, InquiryForexRateEntity inquiryForexRateEntity) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (InquiryForexRateEntity.Query query : inquiryForexRateEntity.getQueries()) {
            arrayList.add(query.getFrom());
            arrayList2.add(query.getTo());
        }
        getRealTimeForex(bridgeCallback, arrayList, arrayList2);
        return true;
    }

    private void getRealTimeForex(final BridgeCallback bridgeCallback, List<String> list, List<String> list2) {
        this.getRealTimeForex.execute(new DefaultObserver<List<Forex>>() { // from class: id.dana.danah5.globalnetwork.manager.GlobalNetworkPluginManager.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onNext(List<Forex> list3) {
                List rateList = GlobalNetworkPluginManager.this.getRateList(list3);
                ResponseInquiry responseInquiry = new ResponseInquiry();
                responseInquiry.setLastUpdated(String.valueOf(Calendar.getInstance().getTimeInMillis()));
                GlobalNetworkPluginManager.this.sendResultInquirySuccess(bridgeCallback, true, rateList, responseInquiry.getLastUpdated());
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GLOBAL_NETWORK, th.getMessage());
            }
        }, GetRealTimeForex.Params.getRealtimeForex(list, list2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Rate> getRateList(List<Forex> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Forex forex : list) {
            Rate rate = new Rate();
            rate.setFrom(GlobalNetworkConstants.IDR_CURRENCY);
            rate.setTo(forex.getCurrency());
            rate.setRate(String.valueOf(forex.getRate()));
            rate.setSymbol(ForeignCurrencySymbolUtil.BuiltInFictitiousFunctionClassFactory(forex.getCurrency()));
            arrayList.add(rate);
        }
        return arrayList;
    }

    public boolean getForexBalance(final BridgeCallback bridgeCallback) {
        this.compositeDisposable.getAuthRequestContext(this.getSelectedCountryCode.execute(null).subscribe(new Consumer() { // from class: id.dana.danah5.globalnetwork.manager.GlobalNetworkPluginManager$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GlobalNetworkPluginManager.this.m654x366808b7(bridgeCallback, (String) obj);
            }
        }));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getForexBalance  reason: merged with bridge method [inline-methods] */
    public void m654x366808b7(final BridgeCallback bridgeCallback, final String str) {
        this.compositeDisposable.getAuthRequestContext(this.getForex.execute(null).subscribe(new Consumer() { // from class: id.dana.danah5.globalnetwork.manager.GlobalNetworkPluginManager$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                GlobalNetworkPluginManager.this.m655x842780b8(bridgeCallback, str, (Forex) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sendResultForexBalance  reason: merged with bridge method [inline-methods] */
    public void m655x842780b8(BridgeCallback bridgeCallback, String str, Forex forex) {
        ForexBalanceEntityResult forexBalanceEntityResult = new ForexBalanceEntityResult();
        forexBalanceEntityResult.setSymbol(ForeignCurrencySymbolUtil.MyBillsEntityDataFactory(str));
        forexBalanceEntityResult.setCountry(str);
        forexBalanceEntityResult.setAmount(forex.getForexAmount());
        ResponseForex responseForex = new ResponseForex();
        responseForex.setData(forexBalanceEntityResult);
        sendResultForexBalanceSuccess(bridgeCallback, true, responseForex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendResultInquirySuccess(BridgeCallback bridgeCallback, boolean z, List<Rate> list, String str) {
        bridgeCallback.sendJSONResponse(InquiryResultFactory.getResult(z ? "SUCCESS" : "UNKNOWN_ERROR", list, str));
    }

    private void sendResultForexBalanceSuccess(BridgeCallback bridgeCallback, boolean z, ResponseForex responseForex) {
        bridgeCallback.sendJSONResponse(GetForexBalanceResultFactory.getResult(z ? "SUCCESS" : "UNKNOWN_ERROR", responseForex));
    }
}
