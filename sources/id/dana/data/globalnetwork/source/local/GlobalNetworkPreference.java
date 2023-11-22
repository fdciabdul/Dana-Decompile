package id.dana.data.globalnetwork.source.local;

import android.content.Context;
import com.alibaba.fastjson.JSONObject;
import id.dana.data.globalnetwork.GnPaymentUtil;
import id.dana.data.globalnetwork.model.PaymentResult;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.domain.globalnetwork.model.Forex;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class GlobalNetworkPreference {
    private final String GLOBAL_NETWORK_PREFERENCE;
    private final PreferenceFacade preferenceFacade;

    public String getCountryCode() {
        return "ID";
    }

    @Inject
    public GlobalNetworkPreference(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("production");
        String obj = sb.toString();
        this.GLOBAL_NETWORK_PREFERENCE = obj;
        this.preferenceFacade = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(obj)).createData("local");
    }

    public String getCurrentCountryCode() {
        String string = this.preferenceFacade.getString("gn_current_country_code");
        return string == null ? "" : string;
    }

    public boolean saveCurrentCountryCode(String str) {
        this.preferenceFacade.saveData("gn_current_country_code", str);
        return true;
    }

    public Forex getForexCache(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gn_forex_");
        sb.append(str);
        return (Forex) this.preferenceFacade.getObject(sb.toString(), Forex.class);
    }

    public boolean saveForex(Forex forex) {
        StringBuilder sb = new StringBuilder();
        sb.append("gn_forex_");
        sb.append(forex.getCurrency());
        this.preferenceFacade.saveData(sb.toString(), (String) forex);
        return true;
    }

    public boolean getAlipayConnectServiceFirstTime() {
        return this.preferenceFacade.getBoolean("alipay_service_first", true).booleanValue();
    }

    public boolean saveAlipayConnectServiceFirstTime(boolean z) {
        this.preferenceFacade.saveData("alipay_service_first", Boolean.valueOf(z));
        return true;
    }

    public List<PaymentResult> getPaymentCodes() {
        return new ArrayList(getPaymentCodeSet());
    }

    public boolean savePaymentCode(String str) {
        Set<PaymentResult> paymentCodeSet = getPaymentCodeSet();
        PaymentResult paymentResult = new PaymentResult(str, new Date(), false);
        paymentCodeSet.remove(paymentResult);
        paymentCodeSet.add(paymentResult);
        savePaymentCodes(paymentCodeSet);
        return true;
    }

    public boolean savePaymentCodes(Set<PaymentResult> set) {
        this.preferenceFacade.saveData("gn_payment_results", (String) set);
        return true;
    }

    public Set<PaymentResult> getPaymentCodeSet() {
        Set<JSONObject> set = (Set) this.preferenceFacade.getObject("gn_payment_results", HashSet.class);
        if (set == null) {
            set = new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (JSONObject jSONObject : set) {
            PaymentResult paymentResult = new PaymentResult(jSONObject.get("code").toString(), getDateFromStrTimestamp(jSONObject.get("generateDate").toString()), ((Boolean) jSONObject.get("expired")).booleanValue());
            if (!GnPaymentUtil.isPaymentExpired(paymentResult)) {
                hashSet.add(paymentResult);
            }
        }
        savePaymentCodes(hashSet);
        return hashSet;
    }

    public boolean saveLastTimeGetLocation(long j) {
        this.preferenceFacade.saveData("last_time_get_location", Long.valueOf(j));
        return true;
    }

    public long getLastTimeGetLocation() {
        return this.preferenceFacade.getLong("last_time_get_location").longValue();
    }

    private Date getDateFromStrTimestamp(String str) {
        return new Date(new Timestamp(Long.parseLong(str)).getTime());
    }

    public void clearAll() {
        this.preferenceFacade.clearAllData();
    }

    /* loaded from: classes8.dex */
    static class Key {
        private Key() {
        }
    }
}
