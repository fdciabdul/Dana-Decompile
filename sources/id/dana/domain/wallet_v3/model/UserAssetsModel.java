package id.dana.domain.wallet_v3.model;

import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.danah5.constant.BaseKey;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.domain.investment.model.InvestmentUnitInfo;
import id.dana.domain.investment.model.MultiCurrencyMoneyView;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\bK\n\u0002\u0010\b\n\u0002\bQ\b\u0086\b\u0018\u00002\u00020\u0001BÕ\u0006\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010W\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010X\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010%\u0012\u0010\b\u0002\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010O\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010p\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001e\u0012\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010w\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010x\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010y\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010z\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010{\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010}\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010~\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u000102\u0012\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010/\u0012\u000b\b\u0002\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0082\u0001\u001a\u0004\u0018\u00010/\u0012\u000b\b\u0002\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0084\u0001\u001a\u0004\u0018\u000109\u0012\u000b\b\u0002\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0088\u0001\u001a\u0004\u0018\u00010%\u0012\u000b\b\u0002\u0010\u0089\u0001\u001a\u0004\u0018\u00010%\u0012\u000b\b\u0002\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u008c\u0001\u001a\u0004\u0018\u000109\u0012\u000b\b\u0002\u0010\u008d\u0001\u001a\u0004\u0018\u000109\u0012\u000b\b\u0002\u0010\u008e\u0001\u001a\u0004\u0018\u000109\u0012\u0017\b\u0002\u0010\u008f\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001e\u0012\u000b\b\u0002\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0094\u0001\u001a\u0004\u0018\u000109\u0012\u000b\b\u0002\u0010\u0095\u0001\u001a\u0004\u0018\u000109¢\u0006\u0006\bë\u0001\u0010ì\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0004J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u001e\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b!\u0010\u0019J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u0004J\u0012\u0010#\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b#\u0010\u0019J\u0012\u0010$\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b$\u0010\u0019J\u0012\u0010&\u001a\u0004\u0018\u00010%HÆ\u0003¢\u0006\u0004\b&\u0010'J\u0012\u0010(\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b(\u0010\u0004J\u0012\u0010)\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b)\u0010\u0004J\u0012\u0010*\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b*\u0010\u0004J\u0012\u0010+\u001a\u0004\u0018\u00010%HÆ\u0003¢\u0006\u0004\b+\u0010'J\u0012\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b,\u0010\u0004J\u0012\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b-\u0010\u0004J\u0012\u0010.\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b.\u0010\u0004J\u0012\u00100\u001a\u0004\u0018\u00010/HÆ\u0003¢\u0006\u0004\b0\u00101J\u0012\u00103\u001a\u0004\u0018\u000102HÆ\u0003¢\u0006\u0004\b3\u00104J\u0012\u00105\u001a\u0004\u0018\u00010/HÆ\u0003¢\u0006\u0004\b5\u00101J\u0012\u00106\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b6\u0010\u0004J\u0012\u00107\u001a\u0004\u0018\u00010/HÆ\u0003¢\u0006\u0004\b7\u00101J\u0012\u00108\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b8\u0010\u0004J\u0012\u0010:\u001a\u0004\u0018\u000109HÆ\u0003¢\u0006\u0004\b:\u0010;J\u0012\u0010<\u001a\u0004\u0018\u00010%HÆ\u0003¢\u0006\u0004\b<\u0010'J\u0012\u0010=\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b=\u0010\u0004J\u0012\u0010>\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b>\u0010\u0004J\u0012\u0010?\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b?\u0010\u0004J\u0012\u0010@\u001a\u0004\u0018\u00010%HÆ\u0003¢\u0006\u0004\b@\u0010'J\u0012\u0010A\u001a\u0004\u0018\u00010%HÆ\u0003¢\u0006\u0004\bA\u0010'J\u0012\u0010B\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bB\u0010\u0004J\u0012\u0010C\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bC\u0010\u0004J\u0012\u0010D\u001a\u0004\u0018\u000109HÆ\u0003¢\u0006\u0004\bD\u0010;J\u0012\u0010E\u001a\u0004\u0018\u000109HÆ\u0003¢\u0006\u0004\bE\u0010;J\u0012\u0010F\u001a\u0004\u0018\u000109HÆ\u0003¢\u0006\u0004\bF\u0010;J\u0012\u0010G\u001a\u0004\u0018\u00010%HÆ\u0003¢\u0006\u0004\bG\u0010'J\u001e\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\bH\u0010 J\u0012\u0010I\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bI\u0010\u0004J\u0012\u0010J\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bJ\u0010\u0004J\u0012\u0010K\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bK\u0010\u0004J\u0012\u0010L\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bL\u0010\u0004J\u0012\u0010M\u001a\u0004\u0018\u000109HÆ\u0003¢\u0006\u0004\bM\u0010;J\u0012\u0010N\u001a\u0004\u0018\u000109HÆ\u0003¢\u0006\u0004\bN\u0010;J\u0018\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010OHÆ\u0003¢\u0006\u0004\bP\u0010QJ\u0012\u0010R\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\bR\u0010\u0019J\u0012\u0010S\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bS\u0010\u0004Jß\u0006\u0010\u0096\u0001\u001a\u00020\u00002\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010W\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010%2\u0010\b\u0002\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010O2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010i\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010j\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010k\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010l\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010m\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010p\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001e2\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010w\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010x\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010y\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010z\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010{\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010}\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010~\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u0001022\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010/2\u000b\b\u0002\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u0082\u0001\u001a\u0004\u0018\u00010/2\u000b\b\u0002\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u0084\u0001\u001a\u0004\u0018\u0001092\u000b\b\u0002\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u0088\u0001\u001a\u0004\u0018\u00010%2\u000b\b\u0002\u0010\u0089\u0001\u001a\u0004\u0018\u00010%2\u000b\b\u0002\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u008c\u0001\u001a\u0004\u0018\u0001092\u000b\b\u0002\u0010\u008d\u0001\u001a\u0004\u0018\u0001092\u000b\b\u0002\u0010\u008e\u0001\u001a\u0004\u0018\u0001092\u0017\b\u0002\u0010\u008f\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001e2\u000b\b\u0002\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00022\u000b\b\u0002\u0010\u0094\u0001\u001a\u0004\u0018\u0001092\u000b\b\u0002\u0010\u0095\u0001\u001a\u0004\u0018\u000109HÆ\u0001¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J\u001e\u0010\u0099\u0001\u001a\u00020\u00172\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J\u0014\u0010\u009c\u0001\u001a\u00030\u009b\u0001HÖ\u0001¢\u0006\u0006\b\u009c\u0001\u0010\u009d\u0001J\u0012\u0010\u009e\u0001\u001a\u00020\u0002HÖ\u0001¢\u0006\u0005\b\u009e\u0001\u0010\u0004R\u001b\u0010\\\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\u000e\n\u0005\b\\\u0010\u009f\u0001\u001a\u0005\b \u0001\u0010\u0004R\u001e\u0010p\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bp\u0010\u009f\u0001\u001a\u0005\b¡\u0001\u0010\u0004R\u001e\u0010}\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b}\u0010\u009f\u0001\u001a\u0005\b¢\u0001\u0010\u0004R \u0010\u008d\u0001\u001a\u0004\u0018\u0001098\u0007X\u0087\u0004¢\u0006\u000f\n\u0006\b\u008d\u0001\u0010£\u0001\u001a\u0005\b¤\u0001\u0010;R\u001e\u0010{\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b{\u0010\u009f\u0001\u001a\u0005\b¥\u0001\u0010\u0004R\u001e\u0010U\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bU\u0010\u009f\u0001\u001a\u0005\b¦\u0001\u0010\u0004R\u001e\u0010_\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b_\u0010\u009f\u0001\u001a\u0005\b§\u0001\u0010\u0004R\u001e\u0010d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bd\u0010\u009f\u0001\u001a\u0005\b¨\u0001\u0010\u0004R\u001e\u0010~\u001a\u0004\u0018\u00010/8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b~\u0010©\u0001\u001a\u0005\bª\u0001\u00101R\u001e\u0010X\u001a\u0004\u0018\u00010%8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bX\u0010«\u0001\u001a\u0005\b¬\u0001\u0010'R\u001e\u0010\u007f\u001a\u0004\u0018\u0001028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b\u007f\u0010\u00ad\u0001\u001a\u0005\b®\u0001\u00104R\u001e\u0010t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bt\u0010\u009f\u0001\u001a\u0005\b¯\u0001\u0010\u0004R\u001e\u0010o\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bo\u0010\u009f\u0001\u001a\u0005\b°\u0001\u0010\u0004R*\u0010\u0095\u0001\u001a\u0004\u0018\u0001098\u0007@\u0007X\u0087\u000e¢\u0006\u0017\n\u0006\b\u0095\u0001\u0010£\u0001\u001a\u0005\b±\u0001\u0010;\"\u0006\b²\u0001\u0010³\u0001R \u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000f\n\u0006\b\u0090\u0001\u0010\u009f\u0001\u001a\u0005\b´\u0001\u0010\u0004R\u001e\u0010a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\ba\u0010\u009f\u0001\u001a\u0005\bµ\u0001\u0010\u0004R\u001e\u0010b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bb\u0010\u009f\u0001\u001a\u0005\b¶\u0001\u0010\u0004R\u001e\u0010e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\be\u0010\u009f\u0001\u001a\u0005\b·\u0001\u0010\u0004R\u001e\u0010`\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b`\u0010\u009f\u0001\u001a\u0005\b¸\u0001\u0010\u0004R \u0010\u0087\u0001\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000f\n\u0006\b\u0087\u0001\u0010\u009f\u0001\u001a\u0005\b¹\u0001\u0010\u0004R \u0010\u008e\u0001\u001a\u0004\u0018\u0001098\u0007X\u0087\u0004¢\u0006\u000f\n\u0006\b\u008e\u0001\u0010£\u0001\u001a\u0005\bº\u0001\u0010;R\u001e\u0010y\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\by\u0010\u009f\u0001\u001a\u0005\b»\u0001\u0010\u0004R \u0010\u008c\u0001\u001a\u0004\u0018\u0001098\u0007X\u0087\u0004¢\u0006\u000f\n\u0006\b\u008c\u0001\u0010£\u0001\u001a\u0005\b¼\u0001\u0010;R\u001e\u0010V\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bV\u0010\u009f\u0001\u001a\u0005\b½\u0001\u0010\u0004R \u0010\u0088\u0001\u001a\u0004\u0018\u00010%8\u0007X\u0087\u0004¢\u0006\u000f\n\u0006\b\u0088\u0001\u0010«\u0001\u001a\u0005\b¾\u0001\u0010'R \u0010\u0082\u0001\u001a\u0004\u0018\u00010/8\u0007X\u0087\u0004¢\u0006\u000f\n\u0006\b\u0082\u0001\u0010©\u0001\u001a\u0005\b¿\u0001\u00101R \u0010\u0083\u0001\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000f\n\u0006\b\u0083\u0001\u0010\u009f\u0001\u001a\u0005\bÀ\u0001\u0010\u0004R\u001e\u0010q\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bq\u0010\u009f\u0001\u001a\u0005\bÁ\u0001\u0010\u0004R\u001e\u0010u\u001a\u0004\u0018\u00010\u00178\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bu\u0010Â\u0001\u001a\u0005\bÃ\u0001\u0010\u0019R\u001e\u0010s\u001a\u0004\u0018\u00010\u00178\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bs\u0010Â\u0001\u001a\u0005\bÄ\u0001\u0010\u0019R\u001e\u0010m\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bm\u0010\u009f\u0001\u001a\u0005\bÅ\u0001\u0010\u0004R\u001e\u0010l\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bl\u0010\u009f\u0001\u001a\u0005\bÆ\u0001\u0010\u0004R*\u0010r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001e8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\br\u0010Ç\u0001\u001a\u0005\bÈ\u0001\u0010 R,\u0010\u008f\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001e8\u0007X\u0087\u0004¢\u0006\u000f\n\u0006\b\u008f\u0001\u0010Ç\u0001\u001a\u0005\bÉ\u0001\u0010 R\u001e\u0010]\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b]\u0010\u009f\u0001\u001a\u0005\bÊ\u0001\u0010\u0004R\u001e\u0010^\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b^\u0010\u009f\u0001\u001a\u0005\bË\u0001\u0010\u0004R\u001e\u0010z\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bz\u0010\u009f\u0001\u001a\u0005\bÌ\u0001\u0010\u0004R\u001e\u0010f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bf\u0010\u009f\u0001\u001a\u0005\bÍ\u0001\u0010\u0004R\u001e\u0010j\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bj\u0010\u009f\u0001\u001a\u0005\bÎ\u0001\u0010\u0004R\u001e\u0010k\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bk\u0010\u009f\u0001\u001a\u0005\bÏ\u0001\u0010\u0004R\u001e\u0010h\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bh\u0010\u009f\u0001\u001a\u0005\bÐ\u0001\u0010\u0004R\u001e\u0010g\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bg\u0010\u009f\u0001\u001a\u0005\bÑ\u0001\u0010\u0004R\u001e\u0010i\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bi\u0010\u009f\u0001\u001a\u0005\bÒ\u0001\u0010\u0004R\u001d\u0010v\u001a\u0004\u0018\u00010\u00178\u0007X\u0087\u0004¢\u0006\r\n\u0005\bv\u0010Â\u0001\u001a\u0004\bv\u0010\u0019R \u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000f\n\u0006\b\u0092\u0001\u0010\u009f\u0001\u001a\u0005\bÓ\u0001\u0010\u0004R \u0010\u0084\u0001\u001a\u0004\u0018\u0001098\u0007X\u0087\u0004¢\u0006\u000f\n\u0006\b\u0084\u0001\u0010£\u0001\u001a\u0005\bÔ\u0001\u0010;R\u001e\u0010W\u001a\u0004\u0018\u00010%8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bW\u0010«\u0001\u001a\u0005\bÕ\u0001\u0010'R\u001e\u0010c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bc\u0010\u009f\u0001\u001a\u0005\bÖ\u0001\u0010\u0004R \u0010\u0093\u0001\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000f\n\u0006\b\u0093\u0001\u0010\u009f\u0001\u001a\u0005\b×\u0001\u0010\u0004R \u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000f\n\u0006\b\u008a\u0001\u0010\u009f\u0001\u001a\u0005\bØ\u0001\u0010\u0004R \u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000f\n\u0006\b\u008b\u0001\u0010\u009f\u0001\u001a\u0005\bÙ\u0001\u0010\u0004R\u001e\u0010[\u001a\u0004\u0018\u00010\u00178\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b[\u0010Â\u0001\u001a\u0005\bÚ\u0001\u0010\u0019R$\u0010Z\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010O8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bZ\u0010Û\u0001\u001a\u0005\bÜ\u0001\u0010QR\u001e\u0010w\u001a\u0004\u0018\u00010%8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bw\u0010«\u0001\u001a\u0005\bÝ\u0001\u0010'R \u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000f\n\u0006\b\u0091\u0001\u0010\u009f\u0001\u001a\u0005\bÞ\u0001\u0010\u0004R \u0010\u0085\u0001\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000f\n\u0006\b\u0085\u0001\u0010\u009f\u0001\u001a\u0005\bß\u0001\u0010\u0004R \u0010\u0089\u0001\u001a\u0004\u0018\u00010%8\u0007X\u0087\u0004¢\u0006\u000f\n\u0006\b\u0089\u0001\u0010«\u0001\u001a\u0005\bà\u0001\u0010'R \u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000f\n\u0006\b\u0086\u0001\u0010\u009f\u0001\u001a\u0005\bá\u0001\u0010\u0004R \u0010\u0080\u0001\u001a\u0004\u0018\u00010/8\u0007X\u0087\u0004¢\u0006\u000f\n\u0006\b\u0080\u0001\u0010©\u0001\u001a\u0005\bâ\u0001\u00101R \u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000f\n\u0006\b\u0081\u0001\u0010\u009f\u0001\u001a\u0005\bã\u0001\u0010\u0004R\u001e\u0010T\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bT\u0010\u009f\u0001\u001a\u0005\bä\u0001\u0010\u0004R\u001e\u0010Y\u001a\u0004\u0018\u00010%8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bY\u0010«\u0001\u001a\u0005\bå\u0001\u0010'R*\u0010\u0094\u0001\u001a\u0004\u0018\u0001098\u0007@\u0007X\u0087\u000e¢\u0006\u0017\n\u0006\b\u0094\u0001\u0010£\u0001\u001a\u0005\bæ\u0001\u0010;\"\u0006\bç\u0001\u0010³\u0001R\u001e\u0010|\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b|\u0010\u009f\u0001\u001a\u0005\bè\u0001\u0010\u0004R\u001e\u0010x\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bx\u0010\u009f\u0001\u001a\u0005\bé\u0001\u0010\u0004R\u001e\u0010n\u001a\u0004\u0018\u00010\u00178\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bn\u0010Â\u0001\u001a\u0005\bê\u0001\u0010\u0019"}, d2 = {"Lid/dana/domain/wallet_v3/model/UserAssetsModel;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "", "component27", "()Ljava/lang/Boolean;", "component28", "component29", "component3", "component30", "", "component31", "()Ljava/util/Map;", "component32", "component33", "component34", "component35", "Lid/dana/domain/nearbyme/model/MoneyView;", "component36", "()Lid/dana/domain/nearbyme/model/MoneyView;", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "Lid/dana/domain/investment/model/MultiCurrencyMoneyView;", "component43", "()Lid/dana/domain/investment/model/MultiCurrencyMoneyView;", "Lid/dana/domain/investment/model/InvestmentUnitInfo;", "component44", "()Lid/dana/domain/investment/model/InvestmentUnitInfo;", "component45", "component46", "component47", "component48", "", "component49", "()Ljava/lang/Long;", "component5", "component50", "component51", "component52", "component53", "component54", "component55", "component56", "component57", "component58", "component59", "component6", "component60", "component61", "component62", "component63", "component64", "component65", "component66", "", "component7", "()Ljava/util/List;", "component8", "component9", "uniqueId", "amount", FirebaseAnalytics.Param.CURRENCY, HereUrlConstant.LIMIT, "balance", "unpaidAmount", "overdueTips", "overdueStatus", "accountId", "gmtCreate", "gmtModified", "assetBiztype", "cardTitle", WalletConstant.CARD_INDEX_NO, "cardNoLength", "maskedCardNo", "assetType", "cardScheme", "holderName", "instLogoUrl", "instId", "instOfficialName", "instBranchId", "instBranchOfficialName", "expiryYear", "expiryMonth", "verified", "bindingId", "accountNo", "defaultAsset", "extInfo", "enableStatus", "bankMobileNo", "directDebit", "isDirectDebit", "personalDailyLimit", "userPhoneNo", "contactBizType", "goodsId", "aggregator", "userId", "accountStatus", "availableBalance", "balanceUnit", "totalGainLossAmount", "totalGainLossPercentage", "dailyGainLossAmount", "dailyGainLossPercentage", BaseKey.LAST_UPDATED, "savingId", "title", "categoryCode", "currentAmount", "targetAmount", "orderStatus", "orderSubStatus", "createdTime", "achievedTime", "completedTime", "extendInfo", "cardBackground", "phoneNumber", WalletConstant.KYC_LEVEL, "nickname", "urlTimestamp", "cacheTimestamp", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;Lid/dana/domain/investment/model/InvestmentUnitInfo;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;Ljava/lang/String;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lid/dana/domain/wallet_v3/model/UserAssetsModel;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAccountId", "getAccountNo", "getAccountStatus", "Ljava/lang/Long;", "getAchievedTime", "getAggregator", "getAmount", "getAssetBiztype", "getAssetType", "Lid/dana/domain/investment/model/MultiCurrencyMoneyView;", "getAvailableBalance", "Lid/dana/domain/nearbyme/model/MoneyView;", "getBalance", "Lid/dana/domain/investment/model/InvestmentUnitInfo;", "getBalanceUnit", "getBankMobileNo", "getBindingId", "getCacheTimestamp", "setCacheTimestamp", "(Ljava/lang/Long;)V", "getCardBackground", "getCardIndexNo", "getCardNoLength", "getCardScheme", "getCardTitle", "getCategoryCode", "getCompletedTime", "getContactBizType", "getCreatedTime", "getCurrency", "getCurrentAmount", "getDailyGainLossAmount", "getDailyGainLossPercentage", "getDefaultAsset", "Ljava/lang/Boolean;", "getDirectDebit", "getEnableStatus", "getExpiryMonth", "getExpiryYear", "Ljava/util/Map;", "getExtInfo", "getExtendInfo", "getGmtCreate", "getGmtModified", "getGoodsId", "getHolderName", "getInstBranchId", "getInstBranchOfficialName", "getInstId", "getInstLogoUrl", "getInstOfficialName", "getKycLevel", "getLastUpdated", "getLimit", "getMaskedCardNo", "getNickname", "getOrderStatus", "getOrderSubStatus", "getOverdueStatus", "Ljava/util/List;", "getOverdueTips", "getPersonalDailyLimit", "getPhoneNumber", "getSavingId", "getTargetAmount", "getTitle", "getTotalGainLossAmount", "getTotalGainLossPercentage", "getUniqueId", "getUnpaidAmount", "getUrlTimestamp", "setUrlTimestamp", "getUserId", "getUserPhoneNo", "getVerified", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;Lid/dana/domain/investment/model/InvestmentUnitInfo;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;Ljava/lang/String;Lid/dana/domain/investment/model/MultiCurrencyMoneyView;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UserAssetsModel {
    private final String accountId;
    private final String accountNo;
    private final String accountStatus;
    private final Long achievedTime;
    private final String aggregator;
    private final String amount;
    private final String assetBiztype;
    private final String assetType;
    private final MultiCurrencyMoneyView availableBalance;
    private final MoneyView balance;
    private final InvestmentUnitInfo balanceUnit;
    private final String bankMobileNo;
    private final String bindingId;
    private Long cacheTimestamp;
    private final String cardBackground;
    private final String cardIndexNo;
    private final String cardNoLength;
    private final String cardScheme;
    private final String cardTitle;
    private final String categoryCode;
    private final Long completedTime;
    private final String contactBizType;
    private final Long createdTime;
    private final String currency;
    private final MoneyView currentAmount;
    private final MultiCurrencyMoneyView dailyGainLossAmount;
    private final String dailyGainLossPercentage;
    private final String defaultAsset;
    private final Boolean directDebit;
    private final Boolean enableStatus;
    private final String expiryMonth;
    private final String expiryYear;
    private final Map<String, String> extInfo;
    private final Map<String, String> extendInfo;
    private final String gmtCreate;
    private final String gmtModified;
    private final String goodsId;
    private final String holderName;
    private final String instBranchId;
    private final String instBranchOfficialName;
    private final String instId;
    private final String instLogoUrl;
    private final String instOfficialName;
    private final Boolean isDirectDebit;
    private final String kycLevel;
    private final Long lastUpdated;
    private final MoneyView limit;
    private final String maskedCardNo;
    private final String nickname;
    private final String orderStatus;
    private final String orderSubStatus;
    private final Boolean overdueStatus;
    private final List<String> overdueTips;
    private final MoneyView personalDailyLimit;
    private final String phoneNumber;
    private final String savingId;
    private final MoneyView targetAmount;
    private final String title;
    private final MultiCurrencyMoneyView totalGainLossAmount;
    private final String totalGainLossPercentage;
    private final String uniqueId;
    private final MoneyView unpaidAmount;
    private Long urlTimestamp;
    private final String userId;
    private final String userPhoneNo;
    private final Boolean verified;

    public UserAssetsModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 3, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getUniqueId() {
        return this.uniqueId;
    }

    /* renamed from: component10  reason: from getter */
    public final String getGmtCreate() {
        return this.gmtCreate;
    }

    /* renamed from: component11  reason: from getter */
    public final String getGmtModified() {
        return this.gmtModified;
    }

    /* renamed from: component12  reason: from getter */
    public final String getAssetBiztype() {
        return this.assetBiztype;
    }

    /* renamed from: component13  reason: from getter */
    public final String getCardTitle() {
        return this.cardTitle;
    }

    /* renamed from: component14  reason: from getter */
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    /* renamed from: component15  reason: from getter */
    public final String getCardNoLength() {
        return this.cardNoLength;
    }

    /* renamed from: component16  reason: from getter */
    public final String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    /* renamed from: component17  reason: from getter */
    public final String getAssetType() {
        return this.assetType;
    }

    /* renamed from: component18  reason: from getter */
    public final String getCardScheme() {
        return this.cardScheme;
    }

    /* renamed from: component19  reason: from getter */
    public final String getHolderName() {
        return this.holderName;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component20  reason: from getter */
    public final String getInstLogoUrl() {
        return this.instLogoUrl;
    }

    /* renamed from: component21  reason: from getter */
    public final String getInstId() {
        return this.instId;
    }

    /* renamed from: component22  reason: from getter */
    public final String getInstOfficialName() {
        return this.instOfficialName;
    }

    /* renamed from: component23  reason: from getter */
    public final String getInstBranchId() {
        return this.instBranchId;
    }

    /* renamed from: component24  reason: from getter */
    public final String getInstBranchOfficialName() {
        return this.instBranchOfficialName;
    }

    /* renamed from: component25  reason: from getter */
    public final String getExpiryYear() {
        return this.expiryYear;
    }

    /* renamed from: component26  reason: from getter */
    public final String getExpiryMonth() {
        return this.expiryMonth;
    }

    /* renamed from: component27  reason: from getter */
    public final Boolean getVerified() {
        return this.verified;
    }

    /* renamed from: component28  reason: from getter */
    public final String getBindingId() {
        return this.bindingId;
    }

    /* renamed from: component29  reason: from getter */
    public final String getAccountNo() {
        return this.accountNo;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCurrency() {
        return this.currency;
    }

    /* renamed from: component30  reason: from getter */
    public final String getDefaultAsset() {
        return this.defaultAsset;
    }

    public final Map<String, String> component31() {
        return this.extInfo;
    }

    /* renamed from: component32  reason: from getter */
    public final Boolean getEnableStatus() {
        return this.enableStatus;
    }

    /* renamed from: component33  reason: from getter */
    public final String getBankMobileNo() {
        return this.bankMobileNo;
    }

    /* renamed from: component34  reason: from getter */
    public final Boolean getDirectDebit() {
        return this.directDebit;
    }

    /* renamed from: component35  reason: from getter */
    public final Boolean getIsDirectDebit() {
        return this.isDirectDebit;
    }

    /* renamed from: component36  reason: from getter */
    public final MoneyView getPersonalDailyLimit() {
        return this.personalDailyLimit;
    }

    /* renamed from: component37  reason: from getter */
    public final String getUserPhoneNo() {
        return this.userPhoneNo;
    }

    /* renamed from: component38  reason: from getter */
    public final String getContactBizType() {
        return this.contactBizType;
    }

    /* renamed from: component39  reason: from getter */
    public final String getGoodsId() {
        return this.goodsId;
    }

    /* renamed from: component4  reason: from getter */
    public final MoneyView getLimit() {
        return this.limit;
    }

    /* renamed from: component40  reason: from getter */
    public final String getAggregator() {
        return this.aggregator;
    }

    /* renamed from: component41  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component42  reason: from getter */
    public final String getAccountStatus() {
        return this.accountStatus;
    }

    /* renamed from: component43  reason: from getter */
    public final MultiCurrencyMoneyView getAvailableBalance() {
        return this.availableBalance;
    }

    /* renamed from: component44  reason: from getter */
    public final InvestmentUnitInfo getBalanceUnit() {
        return this.balanceUnit;
    }

    /* renamed from: component45  reason: from getter */
    public final MultiCurrencyMoneyView getTotalGainLossAmount() {
        return this.totalGainLossAmount;
    }

    /* renamed from: component46  reason: from getter */
    public final String getTotalGainLossPercentage() {
        return this.totalGainLossPercentage;
    }

    /* renamed from: component47  reason: from getter */
    public final MultiCurrencyMoneyView getDailyGainLossAmount() {
        return this.dailyGainLossAmount;
    }

    /* renamed from: component48  reason: from getter */
    public final String getDailyGainLossPercentage() {
        return this.dailyGainLossPercentage;
    }

    /* renamed from: component49  reason: from getter */
    public final Long getLastUpdated() {
        return this.lastUpdated;
    }

    /* renamed from: component5  reason: from getter */
    public final MoneyView getBalance() {
        return this.balance;
    }

    /* renamed from: component50  reason: from getter */
    public final String getSavingId() {
        return this.savingId;
    }

    /* renamed from: component51  reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component52  reason: from getter */
    public final String getCategoryCode() {
        return this.categoryCode;
    }

    /* renamed from: component53  reason: from getter */
    public final MoneyView getCurrentAmount() {
        return this.currentAmount;
    }

    /* renamed from: component54  reason: from getter */
    public final MoneyView getTargetAmount() {
        return this.targetAmount;
    }

    /* renamed from: component55  reason: from getter */
    public final String getOrderStatus() {
        return this.orderStatus;
    }

    /* renamed from: component56  reason: from getter */
    public final String getOrderSubStatus() {
        return this.orderSubStatus;
    }

    /* renamed from: component57  reason: from getter */
    public final Long getCreatedTime() {
        return this.createdTime;
    }

    /* renamed from: component58  reason: from getter */
    public final Long getAchievedTime() {
        return this.achievedTime;
    }

    /* renamed from: component59  reason: from getter */
    public final Long getCompletedTime() {
        return this.completedTime;
    }

    /* renamed from: component6  reason: from getter */
    public final MoneyView getUnpaidAmount() {
        return this.unpaidAmount;
    }

    public final Map<String, String> component60() {
        return this.extendInfo;
    }

    /* renamed from: component61  reason: from getter */
    public final String getCardBackground() {
        return this.cardBackground;
    }

    /* renamed from: component62  reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component63  reason: from getter */
    public final String getKycLevel() {
        return this.kycLevel;
    }

    /* renamed from: component64  reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component65  reason: from getter */
    public final Long getUrlTimestamp() {
        return this.urlTimestamp;
    }

    /* renamed from: component66  reason: from getter */
    public final Long getCacheTimestamp() {
        return this.cacheTimestamp;
    }

    public final List<String> component7() {
        return this.overdueTips;
    }

    /* renamed from: component8  reason: from getter */
    public final Boolean getOverdueStatus() {
        return this.overdueStatus;
    }

    /* renamed from: component9  reason: from getter */
    public final String getAccountId() {
        return this.accountId;
    }

    public final UserAssetsModel copy(String uniqueId, String amount, String currency, MoneyView limit, MoneyView balance, MoneyView unpaidAmount, List<String> overdueTips, Boolean overdueStatus, String accountId, String gmtCreate, String gmtModified, String assetBiztype, String cardTitle, String cardIndexNo, String cardNoLength, String maskedCardNo, String assetType, String cardScheme, String holderName, String instLogoUrl, String instId, String instOfficialName, String instBranchId, String instBranchOfficialName, String expiryYear, String expiryMonth, Boolean verified, String bindingId, String accountNo, String defaultAsset, Map<String, String> extInfo, Boolean enableStatus, String bankMobileNo, Boolean directDebit, Boolean isDirectDebit, MoneyView personalDailyLimit, String userPhoneNo, String contactBizType, String goodsId, String aggregator, String userId, String accountStatus, MultiCurrencyMoneyView availableBalance, InvestmentUnitInfo balanceUnit, MultiCurrencyMoneyView totalGainLossAmount, String totalGainLossPercentage, MultiCurrencyMoneyView dailyGainLossAmount, String dailyGainLossPercentage, Long lastUpdated, String savingId, String title, String categoryCode, MoneyView currentAmount, MoneyView targetAmount, String orderStatus, String orderSubStatus, Long createdTime, Long achievedTime, Long completedTime, Map<String, String> extendInfo, String cardBackground, String phoneNumber, String kycLevel, String nickname, Long urlTimestamp, Long cacheTimestamp) {
        return new UserAssetsModel(uniqueId, amount, currency, limit, balance, unpaidAmount, overdueTips, overdueStatus, accountId, gmtCreate, gmtModified, assetBiztype, cardTitle, cardIndexNo, cardNoLength, maskedCardNo, assetType, cardScheme, holderName, instLogoUrl, instId, instOfficialName, instBranchId, instBranchOfficialName, expiryYear, expiryMonth, verified, bindingId, accountNo, defaultAsset, extInfo, enableStatus, bankMobileNo, directDebit, isDirectDebit, personalDailyLimit, userPhoneNo, contactBizType, goodsId, aggregator, userId, accountStatus, availableBalance, balanceUnit, totalGainLossAmount, totalGainLossPercentage, dailyGainLossAmount, dailyGainLossPercentage, lastUpdated, savingId, title, categoryCode, currentAmount, targetAmount, orderStatus, orderSubStatus, createdTime, achievedTime, completedTime, extendInfo, cardBackground, phoneNumber, kycLevel, nickname, urlTimestamp, cacheTimestamp);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UserAssetsModel) {
            UserAssetsModel userAssetsModel = (UserAssetsModel) other;
            return Intrinsics.areEqual(this.uniqueId, userAssetsModel.uniqueId) && Intrinsics.areEqual(this.amount, userAssetsModel.amount) && Intrinsics.areEqual(this.currency, userAssetsModel.currency) && Intrinsics.areEqual(this.limit, userAssetsModel.limit) && Intrinsics.areEqual(this.balance, userAssetsModel.balance) && Intrinsics.areEqual(this.unpaidAmount, userAssetsModel.unpaidAmount) && Intrinsics.areEqual(this.overdueTips, userAssetsModel.overdueTips) && Intrinsics.areEqual(this.overdueStatus, userAssetsModel.overdueStatus) && Intrinsics.areEqual(this.accountId, userAssetsModel.accountId) && Intrinsics.areEqual(this.gmtCreate, userAssetsModel.gmtCreate) && Intrinsics.areEqual(this.gmtModified, userAssetsModel.gmtModified) && Intrinsics.areEqual(this.assetBiztype, userAssetsModel.assetBiztype) && Intrinsics.areEqual(this.cardTitle, userAssetsModel.cardTitle) && Intrinsics.areEqual(this.cardIndexNo, userAssetsModel.cardIndexNo) && Intrinsics.areEqual(this.cardNoLength, userAssetsModel.cardNoLength) && Intrinsics.areEqual(this.maskedCardNo, userAssetsModel.maskedCardNo) && Intrinsics.areEqual(this.assetType, userAssetsModel.assetType) && Intrinsics.areEqual(this.cardScheme, userAssetsModel.cardScheme) && Intrinsics.areEqual(this.holderName, userAssetsModel.holderName) && Intrinsics.areEqual(this.instLogoUrl, userAssetsModel.instLogoUrl) && Intrinsics.areEqual(this.instId, userAssetsModel.instId) && Intrinsics.areEqual(this.instOfficialName, userAssetsModel.instOfficialName) && Intrinsics.areEqual(this.instBranchId, userAssetsModel.instBranchId) && Intrinsics.areEqual(this.instBranchOfficialName, userAssetsModel.instBranchOfficialName) && Intrinsics.areEqual(this.expiryYear, userAssetsModel.expiryYear) && Intrinsics.areEqual(this.expiryMonth, userAssetsModel.expiryMonth) && Intrinsics.areEqual(this.verified, userAssetsModel.verified) && Intrinsics.areEqual(this.bindingId, userAssetsModel.bindingId) && Intrinsics.areEqual(this.accountNo, userAssetsModel.accountNo) && Intrinsics.areEqual(this.defaultAsset, userAssetsModel.defaultAsset) && Intrinsics.areEqual(this.extInfo, userAssetsModel.extInfo) && Intrinsics.areEqual(this.enableStatus, userAssetsModel.enableStatus) && Intrinsics.areEqual(this.bankMobileNo, userAssetsModel.bankMobileNo) && Intrinsics.areEqual(this.directDebit, userAssetsModel.directDebit) && Intrinsics.areEqual(this.isDirectDebit, userAssetsModel.isDirectDebit) && Intrinsics.areEqual(this.personalDailyLimit, userAssetsModel.personalDailyLimit) && Intrinsics.areEqual(this.userPhoneNo, userAssetsModel.userPhoneNo) && Intrinsics.areEqual(this.contactBizType, userAssetsModel.contactBizType) && Intrinsics.areEqual(this.goodsId, userAssetsModel.goodsId) && Intrinsics.areEqual(this.aggregator, userAssetsModel.aggregator) && Intrinsics.areEqual(this.userId, userAssetsModel.userId) && Intrinsics.areEqual(this.accountStatus, userAssetsModel.accountStatus) && Intrinsics.areEqual(this.availableBalance, userAssetsModel.availableBalance) && Intrinsics.areEqual(this.balanceUnit, userAssetsModel.balanceUnit) && Intrinsics.areEqual(this.totalGainLossAmount, userAssetsModel.totalGainLossAmount) && Intrinsics.areEqual(this.totalGainLossPercentage, userAssetsModel.totalGainLossPercentage) && Intrinsics.areEqual(this.dailyGainLossAmount, userAssetsModel.dailyGainLossAmount) && Intrinsics.areEqual(this.dailyGainLossPercentage, userAssetsModel.dailyGainLossPercentage) && Intrinsics.areEqual(this.lastUpdated, userAssetsModel.lastUpdated) && Intrinsics.areEqual(this.savingId, userAssetsModel.savingId) && Intrinsics.areEqual(this.title, userAssetsModel.title) && Intrinsics.areEqual(this.categoryCode, userAssetsModel.categoryCode) && Intrinsics.areEqual(this.currentAmount, userAssetsModel.currentAmount) && Intrinsics.areEqual(this.targetAmount, userAssetsModel.targetAmount) && Intrinsics.areEqual(this.orderStatus, userAssetsModel.orderStatus) && Intrinsics.areEqual(this.orderSubStatus, userAssetsModel.orderSubStatus) && Intrinsics.areEqual(this.createdTime, userAssetsModel.createdTime) && Intrinsics.areEqual(this.achievedTime, userAssetsModel.achievedTime) && Intrinsics.areEqual(this.completedTime, userAssetsModel.completedTime) && Intrinsics.areEqual(this.extendInfo, userAssetsModel.extendInfo) && Intrinsics.areEqual(this.cardBackground, userAssetsModel.cardBackground) && Intrinsics.areEqual(this.phoneNumber, userAssetsModel.phoneNumber) && Intrinsics.areEqual(this.kycLevel, userAssetsModel.kycLevel) && Intrinsics.areEqual(this.nickname, userAssetsModel.nickname) && Intrinsics.areEqual(this.urlTimestamp, userAssetsModel.urlTimestamp) && Intrinsics.areEqual(this.cacheTimestamp, userAssetsModel.cacheTimestamp);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.uniqueId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.amount;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.currency;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        MoneyView moneyView = this.limit;
        int hashCode4 = moneyView == null ? 0 : moneyView.hashCode();
        MoneyView moneyView2 = this.balance;
        int hashCode5 = moneyView2 == null ? 0 : moneyView2.hashCode();
        MoneyView moneyView3 = this.unpaidAmount;
        int hashCode6 = moneyView3 == null ? 0 : moneyView3.hashCode();
        List<String> list = this.overdueTips;
        int hashCode7 = list == null ? 0 : list.hashCode();
        Boolean bool = this.overdueStatus;
        int hashCode8 = bool == null ? 0 : bool.hashCode();
        String str4 = this.accountId;
        int hashCode9 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.gmtCreate;
        int hashCode10 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.gmtModified;
        int hashCode11 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.assetBiztype;
        int hashCode12 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.cardTitle;
        int hashCode13 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.cardIndexNo;
        int hashCode14 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.cardNoLength;
        int hashCode15 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.maskedCardNo;
        int hashCode16 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.assetType;
        int hashCode17 = str12 == null ? 0 : str12.hashCode();
        String str13 = this.cardScheme;
        int hashCode18 = str13 == null ? 0 : str13.hashCode();
        String str14 = this.holderName;
        int hashCode19 = str14 == null ? 0 : str14.hashCode();
        String str15 = this.instLogoUrl;
        int hashCode20 = str15 == null ? 0 : str15.hashCode();
        String str16 = this.instId;
        int hashCode21 = str16 == null ? 0 : str16.hashCode();
        String str17 = this.instOfficialName;
        int hashCode22 = str17 == null ? 0 : str17.hashCode();
        String str18 = this.instBranchId;
        int hashCode23 = str18 == null ? 0 : str18.hashCode();
        String str19 = this.instBranchOfficialName;
        int hashCode24 = str19 == null ? 0 : str19.hashCode();
        String str20 = this.expiryYear;
        int hashCode25 = str20 == null ? 0 : str20.hashCode();
        String str21 = this.expiryMonth;
        int hashCode26 = str21 == null ? 0 : str21.hashCode();
        Boolean bool2 = this.verified;
        int hashCode27 = bool2 == null ? 0 : bool2.hashCode();
        String str22 = this.bindingId;
        int hashCode28 = str22 == null ? 0 : str22.hashCode();
        String str23 = this.accountNo;
        int hashCode29 = str23 == null ? 0 : str23.hashCode();
        String str24 = this.defaultAsset;
        int hashCode30 = str24 == null ? 0 : str24.hashCode();
        Map<String, String> map = this.extInfo;
        int hashCode31 = map == null ? 0 : map.hashCode();
        Boolean bool3 = this.enableStatus;
        int hashCode32 = bool3 == null ? 0 : bool3.hashCode();
        String str25 = this.bankMobileNo;
        int hashCode33 = str25 == null ? 0 : str25.hashCode();
        Boolean bool4 = this.directDebit;
        int hashCode34 = bool4 == null ? 0 : bool4.hashCode();
        Boolean bool5 = this.isDirectDebit;
        int hashCode35 = bool5 == null ? 0 : bool5.hashCode();
        MoneyView moneyView4 = this.personalDailyLimit;
        int hashCode36 = moneyView4 == null ? 0 : moneyView4.hashCode();
        String str26 = this.userPhoneNo;
        int hashCode37 = str26 == null ? 0 : str26.hashCode();
        String str27 = this.contactBizType;
        int hashCode38 = str27 == null ? 0 : str27.hashCode();
        String str28 = this.goodsId;
        int hashCode39 = str28 == null ? 0 : str28.hashCode();
        String str29 = this.aggregator;
        int hashCode40 = str29 == null ? 0 : str29.hashCode();
        String str30 = this.userId;
        int hashCode41 = str30 == null ? 0 : str30.hashCode();
        String str31 = this.accountStatus;
        int hashCode42 = str31 == null ? 0 : str31.hashCode();
        MultiCurrencyMoneyView multiCurrencyMoneyView = this.availableBalance;
        int hashCode43 = multiCurrencyMoneyView == null ? 0 : multiCurrencyMoneyView.hashCode();
        InvestmentUnitInfo investmentUnitInfo = this.balanceUnit;
        int hashCode44 = investmentUnitInfo == null ? 0 : investmentUnitInfo.hashCode();
        MultiCurrencyMoneyView multiCurrencyMoneyView2 = this.totalGainLossAmount;
        int hashCode45 = multiCurrencyMoneyView2 == null ? 0 : multiCurrencyMoneyView2.hashCode();
        String str32 = this.totalGainLossPercentage;
        int hashCode46 = str32 == null ? 0 : str32.hashCode();
        MultiCurrencyMoneyView multiCurrencyMoneyView3 = this.dailyGainLossAmount;
        int hashCode47 = multiCurrencyMoneyView3 == null ? 0 : multiCurrencyMoneyView3.hashCode();
        String str33 = this.dailyGainLossPercentage;
        int hashCode48 = str33 == null ? 0 : str33.hashCode();
        Long l = this.lastUpdated;
        int hashCode49 = l == null ? 0 : l.hashCode();
        String str34 = this.savingId;
        int hashCode50 = str34 == null ? 0 : str34.hashCode();
        String str35 = this.title;
        int hashCode51 = str35 == null ? 0 : str35.hashCode();
        String str36 = this.categoryCode;
        int hashCode52 = str36 == null ? 0 : str36.hashCode();
        MoneyView moneyView5 = this.currentAmount;
        int hashCode53 = moneyView5 == null ? 0 : moneyView5.hashCode();
        MoneyView moneyView6 = this.targetAmount;
        int hashCode54 = moneyView6 == null ? 0 : moneyView6.hashCode();
        String str37 = this.orderStatus;
        int hashCode55 = str37 == null ? 0 : str37.hashCode();
        String str38 = this.orderSubStatus;
        int hashCode56 = str38 == null ? 0 : str38.hashCode();
        Long l2 = this.createdTime;
        int hashCode57 = l2 == null ? 0 : l2.hashCode();
        Long l3 = this.achievedTime;
        int hashCode58 = l3 == null ? 0 : l3.hashCode();
        Long l4 = this.completedTime;
        int hashCode59 = l4 == null ? 0 : l4.hashCode();
        Map<String, String> map2 = this.extendInfo;
        int hashCode60 = map2 == null ? 0 : map2.hashCode();
        String str39 = this.cardBackground;
        int hashCode61 = str39 == null ? 0 : str39.hashCode();
        String str40 = this.phoneNumber;
        int hashCode62 = str40 == null ? 0 : str40.hashCode();
        String str41 = this.kycLevel;
        int hashCode63 = str41 == null ? 0 : str41.hashCode();
        String str42 = this.nickname;
        int hashCode64 = str42 == null ? 0 : str42.hashCode();
        Long l5 = this.urlTimestamp;
        int hashCode65 = l5 == null ? 0 : l5.hashCode();
        Long l6 = this.cacheTimestamp;
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + hashCode25) * 31) + hashCode26) * 31) + hashCode27) * 31) + hashCode28) * 31) + hashCode29) * 31) + hashCode30) * 31) + hashCode31) * 31) + hashCode32) * 31) + hashCode33) * 31) + hashCode34) * 31) + hashCode35) * 31) + hashCode36) * 31) + hashCode37) * 31) + hashCode38) * 31) + hashCode39) * 31) + hashCode40) * 31) + hashCode41) * 31) + hashCode42) * 31) + hashCode43) * 31) + hashCode44) * 31) + hashCode45) * 31) + hashCode46) * 31) + hashCode47) * 31) + hashCode48) * 31) + hashCode49) * 31) + hashCode50) * 31) + hashCode51) * 31) + hashCode52) * 31) + hashCode53) * 31) + hashCode54) * 31) + hashCode55) * 31) + hashCode56) * 31) + hashCode57) * 31) + hashCode58) * 31) + hashCode59) * 31) + hashCode60) * 31) + hashCode61) * 31) + hashCode62) * 31) + hashCode63) * 31) + hashCode64) * 31) + hashCode65) * 31) + (l6 != null ? l6.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UserAssetsModel(uniqueId=");
        sb.append(this.uniqueId);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", currency=");
        sb.append(this.currency);
        sb.append(", limit=");
        sb.append(this.limit);
        sb.append(", balance=");
        sb.append(this.balance);
        sb.append(", unpaidAmount=");
        sb.append(this.unpaidAmount);
        sb.append(", overdueTips=");
        sb.append(this.overdueTips);
        sb.append(", overdueStatus=");
        sb.append(this.overdueStatus);
        sb.append(", accountId=");
        sb.append(this.accountId);
        sb.append(", gmtCreate=");
        sb.append(this.gmtCreate);
        sb.append(", gmtModified=");
        sb.append(this.gmtModified);
        sb.append(", assetBiztype=");
        sb.append(this.assetBiztype);
        sb.append(", cardTitle=");
        sb.append(this.cardTitle);
        sb.append(", cardIndexNo=");
        sb.append(this.cardIndexNo);
        sb.append(", cardNoLength=");
        sb.append(this.cardNoLength);
        sb.append(", maskedCardNo=");
        sb.append(this.maskedCardNo);
        sb.append(", assetType=");
        sb.append(this.assetType);
        sb.append(", cardScheme=");
        sb.append(this.cardScheme);
        sb.append(", holderName=");
        sb.append(this.holderName);
        sb.append(", instLogoUrl=");
        sb.append(this.instLogoUrl);
        sb.append(", instId=");
        sb.append(this.instId);
        sb.append(", instOfficialName=");
        sb.append(this.instOfficialName);
        sb.append(", instBranchId=");
        sb.append(this.instBranchId);
        sb.append(", instBranchOfficialName=");
        sb.append(this.instBranchOfficialName);
        sb.append(", expiryYear=");
        sb.append(this.expiryYear);
        sb.append(", expiryMonth=");
        sb.append(this.expiryMonth);
        sb.append(", verified=");
        sb.append(this.verified);
        sb.append(", bindingId=");
        sb.append(this.bindingId);
        sb.append(", accountNo=");
        sb.append(this.accountNo);
        sb.append(", defaultAsset=");
        sb.append(this.defaultAsset);
        sb.append(", extInfo=");
        sb.append(this.extInfo);
        sb.append(", enableStatus=");
        sb.append(this.enableStatus);
        sb.append(", bankMobileNo=");
        sb.append(this.bankMobileNo);
        sb.append(", directDebit=");
        sb.append(this.directDebit);
        sb.append(", isDirectDebit=");
        sb.append(this.isDirectDebit);
        sb.append(", personalDailyLimit=");
        sb.append(this.personalDailyLimit);
        sb.append(", userPhoneNo=");
        sb.append(this.userPhoneNo);
        sb.append(", contactBizType=");
        sb.append(this.contactBizType);
        sb.append(", goodsId=");
        sb.append(this.goodsId);
        sb.append(", aggregator=");
        sb.append(this.aggregator);
        sb.append(", userId=");
        sb.append(this.userId);
        sb.append(", accountStatus=");
        sb.append(this.accountStatus);
        sb.append(", availableBalance=");
        sb.append(this.availableBalance);
        sb.append(", balanceUnit=");
        sb.append(this.balanceUnit);
        sb.append(", totalGainLossAmount=");
        sb.append(this.totalGainLossAmount);
        sb.append(", totalGainLossPercentage=");
        sb.append(this.totalGainLossPercentage);
        sb.append(", dailyGainLossAmount=");
        sb.append(this.dailyGainLossAmount);
        sb.append(", dailyGainLossPercentage=");
        sb.append(this.dailyGainLossPercentage);
        sb.append(", lastUpdated=");
        sb.append(this.lastUpdated);
        sb.append(", savingId=");
        sb.append(this.savingId);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", categoryCode=");
        sb.append(this.categoryCode);
        sb.append(", currentAmount=");
        sb.append(this.currentAmount);
        sb.append(", targetAmount=");
        sb.append(this.targetAmount);
        sb.append(", orderStatus=");
        sb.append(this.orderStatus);
        sb.append(", orderSubStatus=");
        sb.append(this.orderSubStatus);
        sb.append(", createdTime=");
        sb.append(this.createdTime);
        sb.append(", achievedTime=");
        sb.append(this.achievedTime);
        sb.append(", completedTime=");
        sb.append(this.completedTime);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", cardBackground=");
        sb.append(this.cardBackground);
        sb.append(", phoneNumber=");
        sb.append(this.phoneNumber);
        sb.append(", kycLevel=");
        sb.append(this.kycLevel);
        sb.append(", nickname=");
        sb.append(this.nickname);
        sb.append(", urlTimestamp=");
        sb.append(this.urlTimestamp);
        sb.append(", cacheTimestamp=");
        sb.append(this.cacheTimestamp);
        sb.append(')');
        return sb.toString();
    }

    public UserAssetsModel(String str, String str2, String str3, MoneyView moneyView, MoneyView moneyView2, MoneyView moneyView3, List<String> list, Boolean bool, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, Boolean bool2, String str22, String str23, String str24, Map<String, String> map, Boolean bool3, String str25, Boolean bool4, Boolean bool5, MoneyView moneyView4, String str26, String str27, String str28, String str29, String str30, String str31, MultiCurrencyMoneyView multiCurrencyMoneyView, InvestmentUnitInfo investmentUnitInfo, MultiCurrencyMoneyView multiCurrencyMoneyView2, String str32, MultiCurrencyMoneyView multiCurrencyMoneyView3, String str33, Long l, String str34, String str35, String str36, MoneyView moneyView5, MoneyView moneyView6, String str37, String str38, Long l2, Long l3, Long l4, Map<String, String> map2, String str39, String str40, String str41, String str42, Long l5, Long l6) {
        this.uniqueId = str;
        this.amount = str2;
        this.currency = str3;
        this.limit = moneyView;
        this.balance = moneyView2;
        this.unpaidAmount = moneyView3;
        this.overdueTips = list;
        this.overdueStatus = bool;
        this.accountId = str4;
        this.gmtCreate = str5;
        this.gmtModified = str6;
        this.assetBiztype = str7;
        this.cardTitle = str8;
        this.cardIndexNo = str9;
        this.cardNoLength = str10;
        this.maskedCardNo = str11;
        this.assetType = str12;
        this.cardScheme = str13;
        this.holderName = str14;
        this.instLogoUrl = str15;
        this.instId = str16;
        this.instOfficialName = str17;
        this.instBranchId = str18;
        this.instBranchOfficialName = str19;
        this.expiryYear = str20;
        this.expiryMonth = str21;
        this.verified = bool2;
        this.bindingId = str22;
        this.accountNo = str23;
        this.defaultAsset = str24;
        this.extInfo = map;
        this.enableStatus = bool3;
        this.bankMobileNo = str25;
        this.directDebit = bool4;
        this.isDirectDebit = bool5;
        this.personalDailyLimit = moneyView4;
        this.userPhoneNo = str26;
        this.contactBizType = str27;
        this.goodsId = str28;
        this.aggregator = str29;
        this.userId = str30;
        this.accountStatus = str31;
        this.availableBalance = multiCurrencyMoneyView;
        this.balanceUnit = investmentUnitInfo;
        this.totalGainLossAmount = multiCurrencyMoneyView2;
        this.totalGainLossPercentage = str32;
        this.dailyGainLossAmount = multiCurrencyMoneyView3;
        this.dailyGainLossPercentage = str33;
        this.lastUpdated = l;
        this.savingId = str34;
        this.title = str35;
        this.categoryCode = str36;
        this.currentAmount = moneyView5;
        this.targetAmount = moneyView6;
        this.orderStatus = str37;
        this.orderSubStatus = str38;
        this.createdTime = l2;
        this.achievedTime = l3;
        this.completedTime = l4;
        this.extendInfo = map2;
        this.cardBackground = str39;
        this.phoneNumber = str40;
        this.kycLevel = str41;
        this.nickname = str42;
        this.urlTimestamp = l5;
        this.cacheTimestamp = l6;
    }

    public /* synthetic */ UserAssetsModel(String str, String str2, String str3, MoneyView moneyView, MoneyView moneyView2, MoneyView moneyView3, List list, Boolean bool, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, Boolean bool2, String str22, String str23, String str24, Map map, Boolean bool3, String str25, Boolean bool4, Boolean bool5, MoneyView moneyView4, String str26, String str27, String str28, String str29, String str30, String str31, MultiCurrencyMoneyView multiCurrencyMoneyView, InvestmentUnitInfo investmentUnitInfo, MultiCurrencyMoneyView multiCurrencyMoneyView2, String str32, MultiCurrencyMoneyView multiCurrencyMoneyView3, String str33, Long l, String str34, String str35, String str36, MoneyView moneyView5, MoneyView moneyView6, String str37, String str38, Long l2, Long l3, Long l4, Map map2, String str39, String str40, String str41, String str42, Long l5, Long l6, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : moneyView, (i & 16) != 0 ? null : moneyView2, (i & 32) != 0 ? null : moneyView3, (i & 64) != 0 ? null : list, (i & 128) != 0 ? null : bool, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : str5, (i & 1024) != 0 ? null : str6, (i & 2048) != 0 ? null : str7, (i & 4096) != 0 ? null : str8, (i & 8192) != 0 ? null : str9, (i & 16384) != 0 ? null : str10, (i & 32768) != 0 ? null : str11, (i & 65536) != 0 ? null : str12, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : str13, (i & 262144) != 0 ? null : str14, (i & 524288) != 0 ? null : str15, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? null : str16, (i & 2097152) != 0 ? null : str17, (i & 4194304) != 0 ? null : str18, (i & 8388608) != 0 ? null : str19, (i & 16777216) != 0 ? null : str20, (i & 33554432) != 0 ? null : str21, (i & 67108864) != 0 ? null : bool2, (i & 134217728) != 0 ? null : str22, (i & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? null : str23, (i & 536870912) != 0 ? null : str24, (i & 1073741824) != 0 ? null : map, (i & Integer.MIN_VALUE) != 0 ? null : bool3, (i2 & 1) != 0 ? null : str25, (i2 & 2) != 0 ? null : bool4, (i2 & 4) != 0 ? null : bool5, (i2 & 8) != 0 ? null : moneyView4, (i2 & 16) != 0 ? null : str26, (i2 & 32) != 0 ? null : str27, (i2 & 64) != 0 ? null : str28, (i2 & 128) != 0 ? null : str29, (i2 & 256) != 0 ? null : str30, (i2 & 512) != 0 ? null : str31, (i2 & 1024) != 0 ? null : multiCurrencyMoneyView, (i2 & 2048) != 0 ? null : investmentUnitInfo, (i2 & 4096) != 0 ? null : multiCurrencyMoneyView2, (i2 & 8192) != 0 ? null : str32, (i2 & 16384) != 0 ? null : multiCurrencyMoneyView3, (i2 & 32768) != 0 ? null : str33, (i2 & 65536) != 0 ? null : l, (i2 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : str34, (i2 & 262144) != 0 ? null : str35, (i2 & 524288) != 0 ? null : str36, (i2 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? null : moneyView5, (i2 & 2097152) != 0 ? null : moneyView6, (i2 & 4194304) != 0 ? null : str37, (i2 & 8388608) != 0 ? null : str38, (i2 & 16777216) != 0 ? null : l2, (i2 & 33554432) != 0 ? null : l3, (i2 & 67108864) != 0 ? null : l4, (i2 & 134217728) != 0 ? null : map2, (i2 & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? null : str39, (i2 & 536870912) != 0 ? null : str40, (i2 & 1073741824) != 0 ? null : str41, (i2 & Integer.MIN_VALUE) != 0 ? null : str42, (i3 & 1) != 0 ? null : l5, (i3 & 2) != 0 ? null : l6);
    }

    @JvmName(name = "getUniqueId")
    public final String getUniqueId() {
        return this.uniqueId;
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "getCurrency")
    public final String getCurrency() {
        return this.currency;
    }

    @JvmName(name = "getLimit")
    public final MoneyView getLimit() {
        return this.limit;
    }

    @JvmName(name = "getBalance")
    public final MoneyView getBalance() {
        return this.balance;
    }

    @JvmName(name = "getUnpaidAmount")
    public final MoneyView getUnpaidAmount() {
        return this.unpaidAmount;
    }

    @JvmName(name = "getOverdueTips")
    public final List<String> getOverdueTips() {
        return this.overdueTips;
    }

    @JvmName(name = "getOverdueStatus")
    public final Boolean getOverdueStatus() {
        return this.overdueStatus;
    }

    @JvmName(name = "getAccountId")
    public final String getAccountId() {
        return this.accountId;
    }

    @JvmName(name = "getGmtCreate")
    public final String getGmtCreate() {
        return this.gmtCreate;
    }

    @JvmName(name = "getGmtModified")
    public final String getGmtModified() {
        return this.gmtModified;
    }

    @JvmName(name = "getAssetBiztype")
    public final String getAssetBiztype() {
        return this.assetBiztype;
    }

    @JvmName(name = "getCardTitle")
    public final String getCardTitle() {
        return this.cardTitle;
    }

    @JvmName(name = "getCardIndexNo")
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    @JvmName(name = "getCardNoLength")
    public final String getCardNoLength() {
        return this.cardNoLength;
    }

    @JvmName(name = "getMaskedCardNo")
    public final String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    @JvmName(name = "getAssetType")
    public final String getAssetType() {
        return this.assetType;
    }

    @JvmName(name = "getCardScheme")
    public final String getCardScheme() {
        return this.cardScheme;
    }

    @JvmName(name = "getHolderName")
    public final String getHolderName() {
        return this.holderName;
    }

    @JvmName(name = "getInstLogoUrl")
    public final String getInstLogoUrl() {
        return this.instLogoUrl;
    }

    @JvmName(name = "getInstId")
    public final String getInstId() {
        return this.instId;
    }

    @JvmName(name = "getInstOfficialName")
    public final String getInstOfficialName() {
        return this.instOfficialName;
    }

    @JvmName(name = "getInstBranchId")
    public final String getInstBranchId() {
        return this.instBranchId;
    }

    @JvmName(name = "getInstBranchOfficialName")
    public final String getInstBranchOfficialName() {
        return this.instBranchOfficialName;
    }

    @JvmName(name = "getExpiryYear")
    public final String getExpiryYear() {
        return this.expiryYear;
    }

    @JvmName(name = "getExpiryMonth")
    public final String getExpiryMonth() {
        return this.expiryMonth;
    }

    @JvmName(name = "getVerified")
    public final Boolean getVerified() {
        return this.verified;
    }

    @JvmName(name = "getBindingId")
    public final String getBindingId() {
        return this.bindingId;
    }

    @JvmName(name = "getAccountNo")
    public final String getAccountNo() {
        return this.accountNo;
    }

    @JvmName(name = "getDefaultAsset")
    public final String getDefaultAsset() {
        return this.defaultAsset;
    }

    @JvmName(name = "getExtInfo")
    public final Map<String, String> getExtInfo() {
        return this.extInfo;
    }

    @JvmName(name = "getEnableStatus")
    public final Boolean getEnableStatus() {
        return this.enableStatus;
    }

    @JvmName(name = "getBankMobileNo")
    public final String getBankMobileNo() {
        return this.bankMobileNo;
    }

    @JvmName(name = "getDirectDebit")
    public final Boolean getDirectDebit() {
        return this.directDebit;
    }

    @JvmName(name = "isDirectDebit")
    public final Boolean isDirectDebit() {
        return this.isDirectDebit;
    }

    @JvmName(name = "getPersonalDailyLimit")
    public final MoneyView getPersonalDailyLimit() {
        return this.personalDailyLimit;
    }

    @JvmName(name = "getUserPhoneNo")
    public final String getUserPhoneNo() {
        return this.userPhoneNo;
    }

    @JvmName(name = "getContactBizType")
    public final String getContactBizType() {
        return this.contactBizType;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getAggregator")
    public final String getAggregator() {
        return this.aggregator;
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "getAccountStatus")
    public final String getAccountStatus() {
        return this.accountStatus;
    }

    @JvmName(name = "getAvailableBalance")
    public final MultiCurrencyMoneyView getAvailableBalance() {
        return this.availableBalance;
    }

    @JvmName(name = "getBalanceUnit")
    public final InvestmentUnitInfo getBalanceUnit() {
        return this.balanceUnit;
    }

    @JvmName(name = "getTotalGainLossAmount")
    public final MultiCurrencyMoneyView getTotalGainLossAmount() {
        return this.totalGainLossAmount;
    }

    @JvmName(name = "getTotalGainLossPercentage")
    public final String getTotalGainLossPercentage() {
        return this.totalGainLossPercentage;
    }

    @JvmName(name = "getDailyGainLossAmount")
    public final MultiCurrencyMoneyView getDailyGainLossAmount() {
        return this.dailyGainLossAmount;
    }

    @JvmName(name = "getDailyGainLossPercentage")
    public final String getDailyGainLossPercentage() {
        return this.dailyGainLossPercentage;
    }

    @JvmName(name = "getLastUpdated")
    public final Long getLastUpdated() {
        return this.lastUpdated;
    }

    @JvmName(name = "getSavingId")
    public final String getSavingId() {
        return this.savingId;
    }

    @JvmName(name = "getTitle")
    public final String getTitle() {
        return this.title;
    }

    @JvmName(name = "getCategoryCode")
    public final String getCategoryCode() {
        return this.categoryCode;
    }

    @JvmName(name = "getCurrentAmount")
    public final MoneyView getCurrentAmount() {
        return this.currentAmount;
    }

    @JvmName(name = "getTargetAmount")
    public final MoneyView getTargetAmount() {
        return this.targetAmount;
    }

    @JvmName(name = "getOrderStatus")
    public final String getOrderStatus() {
        return this.orderStatus;
    }

    @JvmName(name = "getOrderSubStatus")
    public final String getOrderSubStatus() {
        return this.orderSubStatus;
    }

    @JvmName(name = "getCreatedTime")
    public final Long getCreatedTime() {
        return this.createdTime;
    }

    @JvmName(name = "getAchievedTime")
    public final Long getAchievedTime() {
        return this.achievedTime;
    }

    @JvmName(name = "getCompletedTime")
    public final Long getCompletedTime() {
        return this.completedTime;
    }

    @JvmName(name = "getExtendInfo")
    public final Map<String, String> getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getCardBackground")
    public final String getCardBackground() {
        return this.cardBackground;
    }

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @JvmName(name = "getKycLevel")
    public final String getKycLevel() {
        return this.kycLevel;
    }

    @JvmName(name = "getNickname")
    public final String getNickname() {
        return this.nickname;
    }

    @JvmName(name = "getUrlTimestamp")
    public final Long getUrlTimestamp() {
        return this.urlTimestamp;
    }

    @JvmName(name = "setUrlTimestamp")
    public final void setUrlTimestamp(Long l) {
        this.urlTimestamp = l;
    }

    @JvmName(name = "getCacheTimestamp")
    public final Long getCacheTimestamp() {
        return this.cacheTimestamp;
    }

    @JvmName(name = "setCacheTimestamp")
    public final void setCacheTimestamp(Long l) {
        this.cacheTimestamp = l;
    }
}
