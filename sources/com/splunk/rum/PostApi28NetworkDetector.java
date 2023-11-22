package com.splunk.rum;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.telephony.TelephonyManager;
import androidx.core.app.ActivityCompat;
import com.alipay.iap.android.aplog.util.NetUtil;
import com.alipay.multigateway.sdk.decision.condition.Condition;
import com.splunk.rum.Carrier;
import com.splunk.rum.CurrentNetwork;

/* loaded from: classes3.dex */
class PostApi28NetworkDetector implements NetworkDetector {
    private final TelephonyManager BuiltInFictitiousFunctionClassFactory;
    private final CarrierFinder KClassImpl$Data$declaredNonStaticMembers$2;
    private final ConnectivityManager PlaceComponentResult;
    private final Context getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PostApi28NetworkDetector(ConnectivityManager connectivityManager, TelephonyManager telephonyManager, CarrierFinder carrierFinder, Context context) {
        this.PlaceComponentResult = connectivityManager;
        this.BuiltInFictitiousFunctionClassFactory = telephonyManager;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = carrierFinder;
        this.getAuthRequestContext = context;
    }

    @Override // com.splunk.rum.NetworkDetector
    public final CurrentNetwork BuiltInFictitiousFunctionClassFactory() {
        String str;
        ConnectivityManager connectivityManager = this.PlaceComponentResult;
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        if (networkCapabilities == null) {
            return ConnectionUtil.getAuthRequestContext;
        }
        String str2 = null;
        CarrierFinder carrierFinder = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Carrier.Builder MyBillsEntityDataFactory = Carrier.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.MyBillsEntityDataFactory = carrierFinder.getAuthRequestContext.getSimCarrierId();
        CharSequence simCarrierIdName = carrierFinder.getAuthRequestContext.getSimCarrierIdName();
        if (CarrierFinder.MyBillsEntityDataFactory(simCarrierIdName)) {
            MyBillsEntityDataFactory.PlaceComponentResult = simCarrierIdName.toString();
        }
        String simOperator = carrierFinder.getAuthRequestContext.getSimOperator();
        byte b = 0;
        if (CarrierFinder.MyBillsEntityDataFactory(simOperator) && simOperator.length() >= 5) {
            String substring = simOperator.substring(0, 3);
            String substring2 = simOperator.substring(3);
            MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = substring;
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory = substring2;
        }
        String simCountryIso = carrierFinder.getAuthRequestContext.getSimCountryIso();
        if (CarrierFinder.MyBillsEntityDataFactory(simCountryIso)) {
            MyBillsEntityDataFactory.getAuthRequestContext = simCountryIso;
        }
        Carrier carrier = new Carrier(MyBillsEntityDataFactory);
        if (networkCapabilities.hasTransport(0)) {
            if (KClassImpl$Data$declaredNonStaticMembers$2("android.permission.READ_PHONE_STATE")) {
                switch (this.BuiltInFictitiousFunctionClassFactory.getDataNetworkType()) {
                    case 1:
                        str = "GPRS";
                        break;
                    case 2:
                        str = "EDGE";
                        break;
                    case 3:
                        str = "UMTS";
                        break;
                    case 4:
                        str = "CDMA";
                        break;
                    case 5:
                        str = "EVDO_0";
                        break;
                    case 6:
                        str = "EVDO_A";
                        break;
                    case 7:
                        str = "1xRTT";
                        break;
                    case 8:
                        str = "HSDPA";
                        break;
                    case 9:
                        str = "HSUPA";
                        break;
                    case 10:
                        str = "HSPA";
                        break;
                    case 11:
                        str = "IDEN";
                        break;
                    case 12:
                        str = "EVDO_B";
                        break;
                    case 13:
                        str = Condition.MATCH_TYPE_LESS_THAN_EQUALS;
                        break;
                    case 14:
                        str = "EHRPD";
                        break;
                    case 15:
                        str = "HSPAP";
                        break;
                    case 16:
                        str = NetUtil.TYPE_GSM;
                        break;
                    case 17:
                        str = "SCDMA";
                        break;
                    case 18:
                        str = "IWLAN";
                        break;
                    case 19:
                    default:
                        str = "UNKNOWN";
                        break;
                    case 20:
                        str = "NR";
                        break;
                }
                str2 = str;
            }
            CurrentNetwork.Builder authRequestContext = CurrentNetwork.getAuthRequestContext(NetworkState.TRANSPORT_CELLULAR);
            authRequestContext.BuiltInFictitiousFunctionClassFactory = carrier;
            authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
            return new CurrentNetwork(authRequestContext, b);
        } else if (networkCapabilities.hasTransport(1)) {
            CurrentNetwork.Builder authRequestContext2 = CurrentNetwork.getAuthRequestContext(NetworkState.TRANSPORT_WIFI);
            authRequestContext2.BuiltInFictitiousFunctionClassFactory = carrier;
            return new CurrentNetwork(authRequestContext2, b);
        } else if (networkCapabilities.hasTransport(4)) {
            CurrentNetwork.Builder authRequestContext3 = CurrentNetwork.getAuthRequestContext(NetworkState.TRANSPORT_VPN);
            authRequestContext3.BuiltInFictitiousFunctionClassFactory = carrier;
            return new CurrentNetwork(authRequestContext3, b);
        } else {
            return ConnectionUtil.PlaceComponentResult;
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        return ActivityCompat.KClassImpl$Data$declaredNonStaticMembers$2(this.getAuthRequestContext, str) == 0;
    }
}
