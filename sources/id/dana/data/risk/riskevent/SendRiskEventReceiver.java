package id.dana.data.risk.riskevent;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import id.dana.data.risk.riskevent.repository.SendRiskEventEntityRepository;
import id.dana.data.risk.riskevent.sharetextbroadcast.ShareTextBroadcastReceiver;
import id.dana.data.risk.riskevent.sharetextbroadcast.ShareTextBroadcastReceiverListener;
import id.dana.domain.DefaultObserver;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class SendRiskEventReceiver extends ShareTextBroadcastReceiver {
    private static final String LUCKYMONEY = "LUCKYMONEY";
    private final SendRiskEventEntityRepository sendRiskEventEntityRepository;

    @Override // id.dana.data.risk.riskevent.sharetextbroadcast.ShareTextBroadcastReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    @Inject
    public SendRiskEventReceiver(SendRiskEventEntityRepository sendRiskEventEntityRepository) {
        this.sendRiskEventEntityRepository = sendRiskEventEntityRepository;
    }

    @Override // id.dana.data.risk.riskevent.sharetextbroadcast.ShareTextBroadcastReceiver
    public void doAction(ShareTextBroadcastReceiverListener shareTextBroadcastReceiverListener, ComponentName componentName, String str, String str2) {
        if (LUCKYMONEY.equalsIgnoreCase(str2)) {
            sendRiskLuckyMoney(shareTextBroadcastReceiverListener, componentName, str);
        }
    }

    private void sendRiskLuckyMoney(final ShareTextBroadcastReceiverListener shareTextBroadcastReceiverListener, ComponentName componentName, String str) {
        this.sendRiskEventEntityRepository.sendRiskEvent(componentName.getClassName(), str, "").subscribe(new DefaultObserver<Boolean>() { // from class: id.dana.data.risk.riskevent.SendRiskEventReceiver.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                Boolean bool = (Boolean) obj;
                ShareTextBroadcastReceiverListener shareTextBroadcastReceiverListener2 = shareTextBroadcastReceiverListener;
                if (shareTextBroadcastReceiverListener2 != null) {
                    shareTextBroadcastReceiverListener2.onReceive(true);
                }
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public void onError(Throwable th) {
                super.onError(th);
                shareTextBroadcastReceiverListener.onReceive(false);
            }
        });
    }
}
