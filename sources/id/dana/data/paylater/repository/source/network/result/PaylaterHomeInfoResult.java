package id.dana.data.paylater.repository.source.network.result;

import com.alipay.mobile.security.bio.api.BioDetector;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0015B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/data/paylater/repository/source/network/result/PaylaterHomeInfoResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "action", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "actionLimit", "getActionLimit", "Lid/dana/data/paylater/repository/source/network/result/PaylaterHomeInfoResult$BillInfo;", "billInfo", "Lid/dana/data/paylater/repository/source/network/result/PaylaterHomeInfoResult$BillInfo;", "getBillInfo", "()Lid/dana/data/paylater/repository/source/network/result/PaylaterHomeInfoResult$BillInfo;", "", BioDetector.EXT_KEY_PARTNER_ID, "I", "getPartnerId", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/data/paylater/repository/source/network/result/PaylaterHomeInfoResult$BillInfo;I)V", "BillInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterHomeInfoResult extends BaseRpcResult {
    private final String action;
    private final String actionLimit;
    private final BillInfo billInfo;
    private final int partnerId;

    @JvmName(name = "getAction")
    public final String getAction() {
        return this.action;
    }

    @JvmName(name = "getActionLimit")
    public final String getActionLimit() {
        return this.actionLimit;
    }

    @JvmName(name = "getBillInfo")
    public final BillInfo getBillInfo() {
        return this.billInfo;
    }

    @JvmName(name = "getPartnerId")
    public final int getPartnerId() {
        return this.partnerId;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001Bg\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006"}, d2 = {"Lid/dana/data/paylater/repository/source/network/result/PaylaterHomeInfoResult$BillInfo;", "", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "balance", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getBalance", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "", "hasMore", "Ljava/lang/Boolean;", "getHasMore", "()Ljava/lang/Boolean;", HereUrlConstant.LIMIT, "getLimit", "maxUnpaidAmount", "getMaxUnpaidAmount", "minUnpaidAmount", "getMinUnpaidAmount", "overdueStatus", "getOverdueStatus", "", "", "overdueTips", "Ljava/util/List;", "getOverdueTips", "()Ljava/util/List;", "success", "getSuccess", "unpaidAmount", "getUnpaidAmount", "<init>", "(Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/Boolean;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Lid/dana/network/response/expresspurchase/MoneyViewEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class BillInfo {
        private final MoneyViewEntity balance;
        private final Boolean hasMore;
        private final MoneyViewEntity limit;
        private final MoneyViewEntity maxUnpaidAmount;
        private final MoneyViewEntity minUnpaidAmount;
        private final Boolean overdueStatus;
        private final List<String> overdueTips;
        private final Boolean success;
        private final MoneyViewEntity unpaidAmount;

        public BillInfo(MoneyViewEntity moneyViewEntity, Boolean bool, MoneyViewEntity moneyViewEntity2, MoneyViewEntity moneyViewEntity3, MoneyViewEntity moneyViewEntity4, Boolean bool2, List<String> list, Boolean bool3, MoneyViewEntity moneyViewEntity5) {
            this.balance = moneyViewEntity;
            this.hasMore = bool;
            this.limit = moneyViewEntity2;
            this.maxUnpaidAmount = moneyViewEntity3;
            this.minUnpaidAmount = moneyViewEntity4;
            this.overdueStatus = bool2;
            this.overdueTips = list;
            this.success = bool3;
            this.unpaidAmount = moneyViewEntity5;
        }

        @JvmName(name = "getBalance")
        public final MoneyViewEntity getBalance() {
            return this.balance;
        }

        @JvmName(name = "getHasMore")
        public final Boolean getHasMore() {
            return this.hasMore;
        }

        @JvmName(name = "getLimit")
        public final MoneyViewEntity getLimit() {
            return this.limit;
        }

        @JvmName(name = "getMaxUnpaidAmount")
        public final MoneyViewEntity getMaxUnpaidAmount() {
            return this.maxUnpaidAmount;
        }

        @JvmName(name = "getMinUnpaidAmount")
        public final MoneyViewEntity getMinUnpaidAmount() {
            return this.minUnpaidAmount;
        }

        @JvmName(name = "getOverdueStatus")
        public final Boolean getOverdueStatus() {
            return this.overdueStatus;
        }

        @JvmName(name = "getOverdueTips")
        public final List<String> getOverdueTips() {
            return this.overdueTips;
        }

        @JvmName(name = "getSuccess")
        public final Boolean getSuccess() {
            return this.success;
        }

        @JvmName(name = "getUnpaidAmount")
        public final MoneyViewEntity getUnpaidAmount() {
            return this.unpaidAmount;
        }
    }

    public PaylaterHomeInfoResult(String str, String str2, BillInfo billInfo, int i) {
        this.action = str;
        this.actionLimit = str2;
        this.billInfo = billInfo;
        this.partnerId = i;
    }
}
