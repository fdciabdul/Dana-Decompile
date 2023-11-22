package id.dana.cashier.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alipay.iap.android.aplog.util.CrashCombineUtils;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bO\b\u0086\b\u0018\u0000 ³\u00012\u00020\u0001:\u0002³\u0001B\u0097\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010L\u0012\n\b\u0002\u0010n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010p\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010q\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010v\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010w\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010x\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010y\u001a\u0004\u0018\u00010=\u0012\n\b\u0002\u0010z\u001a\u0004\u0018\u00010=\u0012\u0010\b\u0002\u0010{\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010L\u0012\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010}\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010~\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010\n\u0012\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0081\u0001\u001a\u0004\u0018\u00010\n\u0012\u000b\b\u0002\u0010\u0082\u0001\u001a\u0004\u0018\u00010\n\u0012\u000b\b\u0002\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0002\u0012\t\b\u0002\u0010\u0085\u0001\u001a\u00020\u0002\u0012\u000b\b\u0002\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u0011\b\u0002\u0010\u0089\u0001\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010L\u0012\u000b\b\u0002\u0010\u008a\u0001\u001a\u0004\u0018\u00010Q\u0012\u000b\b\u0002\u0010\u008b\u0001\u001a\u0004\u0018\u00010Q\u0012\u000b\b\u0002\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0005\u0012\u000b\b\u0002\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0005\u0012\u000b\b\u0002\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0005\u0012\u000b\b\u0002\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0090\u0001\u001a\t\u0018\u00010\b¢\u0006\u0002\bH\u0012\u000b\b\u0002\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u0011\b\u0002\u0010\u0093\u0001\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010L\u0012\u000b\b\u0002\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u0011\b\u0002\u0010\u0097\u0001\u001a\n\u0012\u0004\u0012\u00020S\u0018\u00010L\u0012\u000b\b\u0002\u0010\u0098\u0001\u001a\u0004\u0018\u00010\n\u0012\u000b\b\u0002\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u009a\u0001\u001a\u0004\u0018\u00010\n\u0012\u000b\b\u0002\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u009c\u0001\u001a\u0004\u0018\u00010\n\u0012\u000b\b\u0002\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010\u009e\u0001\u001a\u0004\u0018\u00010\n\u0012\u000b\b\u0002\u0010\u009f\u0001\u001a\u0004\u0018\u00010\n\u0012\u000b\b\u0002\u0010 \u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010¡\u0001\u001a\u0004\u0018\u00010W\u0012\u000b\b\u0002\u0010¢\u0001\u001a\u0004\u0018\u00010A\u0012\u000b\b\u0002\u0010£\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010¤\u0001\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010¥\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010¦\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010§\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010¨\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010©\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010«\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010¬\u0001\u001a\u0004\u0018\u00010=\u0012\u000b\b\u0002\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010®\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010¯\u0001\u001a\u0004\u0018\u00010\u0002\u0012\u000b\b\u0002\u0010°\u0001\u001a\u0004\u0018\u00010=¢\u0006\u0006\b±\u0001\u0010²\u0001J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u0004J\r\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\r\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0007J\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u000f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0013J\u0015\u0010\u0012\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J \u0010\u0019\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u001bR\u0011\u0010\u0003\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u001bR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u001bR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0013\u0010 \u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\b \u0010!R\u0013\u0010#\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\"\u0010\u001bR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b$\u0010\u001bR\u0013\u0010%\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b#\u0010\u001bR\u0013\u0010&\u001a\u0004\u0018\u00010\u0005X\u0006¢\u0006\u0006\n\u0004\b&\u0010'R\u0013\u0010$\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b%\u0010\u001bR\u0013\u0010)\u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\b(\u0010!R\u0013\u0010(\u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\b)\u0010!R\u0013\u0010*\u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\b*\u0010!R\u0013\u0010+\u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\b+\u0010!R\u0013\u0010,\u001a\u0004\u0018\u00010\u0005X\u0006¢\u0006\u0006\n\u0004\b,\u0010'R\u0013\u0010.\u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\b-\u0010!R\u0013\u00100\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b/\u0010\u001bR\u0013\u00101\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b0\u0010\u001bR\u0013\u0010/\u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\b.\u0010!R\u0013\u0010-\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b1\u0010\u001bR\u0013\u00103\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b2\u0010\u001bR\u0013\u00104\u001a\u0004\u0018\u00010\u0005X\u0006¢\u0006\u0006\n\u0004\b4\u0010'R\u0013\u00102\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b5\u0010\u001bR\u0013\u00106\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b3\u0010\u001bR\u0014\u00105\u001a\u0004\u0018\u00010\u0002X\u0086\u0002¢\u0006\u0006\n\u0004\b6\u0010\u001bR\u0013\u00107\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b7\u0010\u001bR\u0013\u00108\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b8\u0010\u001bR\u0013\u00109\u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\b9\u0010!R\u0013\u0010;\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b:\u0010\u001bR\u0013\u0010:\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b;\u0010\u001bR\u0013\u0010<\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b<\u0010\u001bR\u0014\u0010@\u001a\u0004\u0018\u00010=X\u0086\u0002¢\u0006\u0006\n\u0004\b>\u0010?R\u0013\u0010>\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b@\u0010\u001bR\u0013\u0010D\u001a\u0004\u0018\u00010AX\u0006¢\u0006\u0006\n\u0004\bB\u0010CR\u0013\u0010B\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\bD\u0010\u001bR\u0014\u0010E\u001a\u0004\u0018\u00010=X\u0086\u0002¢\u0006\u0006\n\u0004\bE\u0010?R\u0013\u0010G\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\bF\u0010\u001bR\u0018\u0010F\u001a\t\u0018\u00010\b¢\u0006\u0002\bHX\u0006¢\u0006\u0006\n\u0004\bG\u0010IR\u0013\u0010K\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\bJ\u0010\u001bR\u0019\u0010J\u001a\n\u0012\u0004\u0012\u00020M\u0018\u00010LX\u0006¢\u0006\u0006\n\u0004\bK\u0010NR\u0013\u0010P\u001a\u0004\u0018\u00010=X\u0006¢\u0006\u0006\n\u0004\bO\u0010?R\u0013\u0010O\u001a\u0004\u0018\u00010QX\u0006¢\u0006\u0006\n\u0004\bP\u0010RR\u0019\u0010U\u001a\n\u0012\u0004\u0012\u00020S\u0018\u00010LX\u0006¢\u0006\u0006\n\u0004\bT\u0010NR\u0013\u0010V\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\bV\u0010\u001bR\u0013\u0010T\u001a\u0004\u0018\u00010WX\u0006¢\u0006\u0006\n\u0004\bU\u0010XR\u0013\u0010Z\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\bY\u0010\u001bR\u0013\u0010Y\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\bZ\u0010\u001bR\u0013\u0010[\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b[\u0010\u001bR\u0013\u0010]\u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\b\\\u0010!R\u0013\u0010\\\u001a\u0004\u0018\u00010QX\u0006¢\u0006\u0006\n\u0004\b]\u0010RR\u0013\u0010_\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b^\u0010\u001bR\u0019\u0010b\u001a\n\u0012\u0004\u0012\u00020`\u0018\u00010LX\u0006¢\u0006\u0006\n\u0004\ba\u0010NR\u0013\u0010c\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b_\u0010\u001bR\u0019\u0010^\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010LX\u0006¢\u0006\u0006\n\u0004\bb\u0010NR\u001a\u0010a\u001a\n\u0012\u0004\u0012\u00020d\u0018\u00010LX\u0086\u0002¢\u0006\u0006\n\u0004\bc\u0010NR\u0013\u0010f\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\be\u0010\u001bR\u0013\u0010e\u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\bf\u0010!R\u0014\u0010h\u001a\u0004\u0018\u00010=X\u0086\u0002¢\u0006\u0006\n\u0004\bg\u0010?R\u0013\u0010g\u001a\u0004\u0018\u00010=X\u0006¢\u0006\u0006\n\u0004\bi\u0010?R\u0013\u0010i\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\bh\u0010\u001bR\u0013\u0010k\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\bj\u0010\u001bR\u0013\u0010l\u001a\u0004\u0018\u00010=X\u0006¢\u0006\u0006\n\u0004\bk\u0010?R\u0013\u0010j\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\bm\u0010\u001bR\u0013\u0010m\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\bl\u0010\u001b"}, d2 = {"Lid/dana/cashier/model/AttributeCashierPayModel;", "Landroid/os/Parcelable;", "", "getAuthRequestContext", "()Ljava/lang/String;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "hashCode", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Z", "", "(Ljava/lang/String;)V", "toString", "Landroid/os/Parcel;", "p1", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "scheduleImpl", "getErrorConfigVersion", "lookAheadTest", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Ljava/lang/Boolean;", "DatabaseTableConfigUtil", "GetContactSyncConfig", "initRecordTimeStamp", "NetworkUserEntityData$$ExternalSyntheticLambda2", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Ljava/lang/Integer;", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda7", "NetworkUserEntityData$$ExternalSyntheticLambda8", "newProxyInstance", "isLayoutRequested", "NetworkUserEntityData$$ExternalSyntheticLambda5", "NetworkUserEntityData$$ExternalSyntheticLambda3", "NetworkUserEntityData$$ExternalSyntheticLambda4", "FragmentBottomSheetPaymentSettingBinding", "NetworkUserEntityData$$ExternalSyntheticLambda6", "whenAvailable", "getCallingPid", "readMicros", "getSupportButtonTintMode", "SubSequence", DiskFormatter.B, "A", "VerifyPinStateManager$executeRiskChallenge$2$1", "BottomSheetCardBindingView$watcherCardNumberView$1", "C", "E", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "VerifyPinStateManager$executeRiskChallenge$2$2", "Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;", "getValueOfTouchPositionAbsolute", "", SummaryActivity.DAYS, "Ljava/lang/Long;", "getOnBoardingScenario", LogConstants.RESULT_FALSE, "AppCompatEmojiTextHelper", SummaryActivity.HOURS, "Lkotlinx/android/parcel/RawValue;", "Ljava/lang/Object;", "I", DiskFormatter.GB, "", "Lid/dana/cashier/model/CashierPayChannelModel;", "Ljava/util/List;", DiskFormatter.KB, "J", "Lid/dana/cashier/model/RiskVerificationMethodModel;", "Lid/dana/cashier/model/RiskVerificationMethodModel;", "Lid/dana/cashier/model/PayMethodViewDtoModel;", "L", DiskFormatter.MB, "getNameOrBuilderList", "Lid/dana/cashier/model/ProcessingMilestoneModel;", "Lid/dana/cashier/model/ProcessingMilestoneModel;", "SummaryVoucherView$$ExternalSyntheticLambda0", "O", "N", "P", "Q", "SummaryVoucherView$$ExternalSyntheticLambda1", "S", "Lid/dana/cashier/model/Risk3dsAdditionalDataModel;", "isAuth", "R", "SummaryVoucherView$$ExternalSyntheticLambda2", "Lid/dana/cashier/model/CashierOrderGoodModel;", "U", "W", "V", "X", "T", "shouldRecycleViewType", "flip", "Z", "Y", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "p17", "p18", "p19", "p20", "p21", "p22", "p23", "p24", "p25", "p26", "p27", "p28", "p29", "p30", "p31", "p32", "p33", "p34", "p35", "p36", "p37", "p38", "p39", "p40", "p41", "p42", "p43", "p44", "p45", "p46", "p47", "p48", "p49", "p50", "p51", "p52", "p53", "p54", "p55", "p56", "p57", "p58", "p59", "p60", "p61", "p62", "p63", "p64", "p65", "p66", "p67", "p68", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lid/dana/cashier/model/RiskVerificationMethodModel;Lid/dana/cashier/model/RiskVerificationMethodModel;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Lid/dana/cashier/model/ProcessingMilestoneModel;Ljava/lang/Long;Ljava/lang/String;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/nearbyme/merchantdetail/model/MoneyViewModel;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AttributeCashierPayModel implements Parcelable {
    public final String A;

    /* renamed from: AppCompatEmojiTextHelper  reason: from kotlin metadata */
    public final String H;
    public final String B;

    /* renamed from: BottomSheetCardBindingView$watcherCardNumberView$1  reason: from kotlin metadata */
    public final String C;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: C  reason: from kotlin metadata */
    public final String BottomSheetCardBindingView$watcherCardNumberView$1;

    /* renamed from: D  reason: from kotlin metadata */
    public final Long getOnBoardingScenario;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    public final String GetContactSyncConfig;
    public final String E;
    public MoneyViewModel F;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda6;

    /* renamed from: G  reason: from kotlin metadata */
    public final List<CashierPayChannelModel> I;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: H  reason: from kotlin metadata */
    public final Object AppCompatEmojiTextHelper;

    /* renamed from: I  reason: from kotlin metadata */
    public final String G;

    /* renamed from: J  reason: from kotlin metadata */
    public final RiskVerificationMethodModel K;

    /* renamed from: K  reason: from kotlin metadata */
    public final MoneyViewModel J;
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: L  reason: from kotlin metadata */
    public final List<PayMethodViewDtoModel> M;

    /* renamed from: M  reason: from kotlin metadata */
    public final ProcessingMilestoneModel L;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;
    public final String N;
    public final Boolean NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final Integer NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public final String initRecordTimeStamp;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    public final Boolean NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    public final String FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    public final Boolean NetworkUserEntityData$$ExternalSyntheticLambda3;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda5;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    public final Boolean PrepareContext;
    public final Boolean NetworkUserEntityData$$ExternalSyntheticLambda8;

    /* renamed from: O  reason: from kotlin metadata */
    public final String SummaryVoucherView$$ExternalSyntheticLambda0;

    /* renamed from: P  reason: from kotlin metadata */
    public final Boolean Q;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    public final Boolean NetworkUserEntityData$$ExternalSyntheticLambda7;

    /* renamed from: Q  reason: from kotlin metadata */
    public final RiskVerificationMethodModel P;

    /* renamed from: R  reason: from kotlin metadata */
    public final List<RiskVerificationMethodModel> SummaryVoucherView$$ExternalSyntheticLambda1;

    /* renamed from: S  reason: from kotlin metadata */
    public final String SummaryVoucherView$$ExternalSyntheticLambda2;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    public String getSupportButtonTintMode;

    /* renamed from: SummaryVoucherView$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String O;

    /* renamed from: SummaryVoucherView$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    public final String S;

    /* renamed from: SummaryVoucherView$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    public List<CashierOrderGoodModel> isAuth;

    /* renamed from: T  reason: from kotlin metadata */
    public final MoneyViewModel V;

    /* renamed from: U  reason: from kotlin metadata */
    public final String W;

    /* renamed from: V  reason: from kotlin metadata */
    public MoneyViewModel X;
    public final Boolean VerifyPinStateManager$executeRiskChallenge$2$1;

    /* renamed from: VerifyPinStateManager$executeRiskChallenge$2$2  reason: from kotlin metadata */
    public MoneyViewModel getValueOfTouchPositionAbsolute;

    /* renamed from: W  reason: from kotlin metadata */
    public final Boolean U;

    /* renamed from: X  reason: from kotlin metadata */
    public final String T;

    /* renamed from: Y  reason: from kotlin metadata */
    public final String shouldRecycleViewType;

    /* renamed from: Z  reason: from kotlin metadata */
    public final String Y;

    /* renamed from: flip  reason: from kotlin metadata */
    public final MoneyViewModel Z;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: getCallingPid  reason: from kotlin metadata */
    public final String SubSequence;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String scheduleImpl;
    public final String getNameOrBuilderList;

    /* renamed from: getOnBoardingScenario  reason: from kotlin metadata */
    public final String D;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    public final String whenAvailable;

    /* renamed from: getValueOfTouchPositionAbsolute  reason: from kotlin metadata */
    public final String VerifyPinStateManager$executeRiskChallenge$2$2;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    public final String DatabaseTableConfigUtil;

    /* renamed from: isAuth  reason: from kotlin metadata */
    public final List<Risk3dsAdditionalDataModel> R;
    public final Integer isLayoutRequested;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String moveToNextValue;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public final String lookAheadTest;
    public final Boolean newProxyInstance;
    public final Integer readMicros;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: shouldRecycleViewType  reason: from kotlin metadata */
    public final String flip;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    public final String getCallingPid;
    public static final Parcelable.Creator<AttributeCashierPayModel> CREATOR = new Creator();

    public AttributeCashierPayModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 31, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof AttributeCashierPayModel) {
            AttributeCashierPayModel attributeCashierPayModel = (AttributeCashierPayModel) p0;
            return Intrinsics.areEqual(this.scheduleImpl, attributeCashierPayModel.scheduleImpl) && Intrinsics.areEqual(this.I, attributeCashierPayModel.I) && Intrinsics.areEqual(this.BottomSheetCardBindingView$watcherCardNumberView$1, attributeCashierPayModel.BottomSheetCardBindingView$watcherCardNumberView$1) && Intrinsics.areEqual(this.G, attributeCashierPayModel.G) && Intrinsics.areEqual(this.getCallingPid, attributeCashierPayModel.getCallingPid) && Intrinsics.areEqual(this.PlaceComponentResult, attributeCashierPayModel.PlaceComponentResult) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda5, attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda5) && Intrinsics.areEqual(this.H, attributeCashierPayModel.H) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda3, attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda3) && Intrinsics.areEqual(this.SubSequence, attributeCashierPayModel.SubSequence) && Intrinsics.areEqual(this.getSupportButtonTintMode, attributeCashierPayModel.getSupportButtonTintMode) && Intrinsics.areEqual(this.X, attributeCashierPayModel.X) && Intrinsics.areEqual(this.O, attributeCashierPayModel.O) && Intrinsics.areEqual(this.getValueOfTouchPositionAbsolute, attributeCashierPayModel.getValueOfTouchPositionAbsolute) && Intrinsics.areEqual(this.F, attributeCashierPayModel.F) && Intrinsics.areEqual(this.isAuth, attributeCashierPayModel.isAuth) && Intrinsics.areEqual(this.T, attributeCashierPayModel.T) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, attributeCashierPayModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.Q, attributeCashierPayModel.Q) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda8, attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda8) && Intrinsics.areEqual(this.C, attributeCashierPayModel.C) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda7, attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda7) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.D, attributeCashierPayModel.D) && Intrinsics.areEqual(this.Y, attributeCashierPayModel.Y) && Intrinsics.areEqual(this.getAuthRequestContext, attributeCashierPayModel.getAuthRequestContext) && Intrinsics.areEqual(this.VerifyPinStateManager$executeRiskChallenge$2$2, attributeCashierPayModel.VerifyPinStateManager$executeRiskChallenge$2$2) && Intrinsics.areEqual(this.FragmentBottomSheetPaymentSettingBinding, attributeCashierPayModel.FragmentBottomSheetPaymentSettingBinding) && Intrinsics.areEqual(this.N, attributeCashierPayModel.N) && Intrinsics.areEqual(this.SummaryVoucherView$$ExternalSyntheticLambda1, attributeCashierPayModel.SummaryVoucherView$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.K, attributeCashierPayModel.K) && Intrinsics.areEqual(this.P, attributeCashierPayModel.P) && Intrinsics.areEqual(this.readMicros, attributeCashierPayModel.readMicros) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda1) && Intrinsics.areEqual(this.isLayoutRequested, attributeCashierPayModel.isLayoutRequested) && Intrinsics.areEqual(this.S, attributeCashierPayModel.S) && Intrinsics.areEqual(this.AppCompatEmojiTextHelper, attributeCashierPayModel.AppCompatEmojiTextHelper) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.moveToNextValue, attributeCashierPayModel.moveToNextValue) && Intrinsics.areEqual(this.R, attributeCashierPayModel.R) && Intrinsics.areEqual(this.E, attributeCashierPayModel.E) && Intrinsics.areEqual(this.flip, attributeCashierPayModel.flip) && Intrinsics.areEqual(this.DatabaseTableConfigUtil, attributeCashierPayModel.DatabaseTableConfigUtil) && Intrinsics.areEqual(this.M, attributeCashierPayModel.M) && Intrinsics.areEqual(this.U, attributeCashierPayModel.U) && Intrinsics.areEqual(this.shouldRecycleViewType, attributeCashierPayModel.shouldRecycleViewType) && Intrinsics.areEqual(this.PrepareContext, attributeCashierPayModel.PrepareContext) && Intrinsics.areEqual(this.A, attributeCashierPayModel.A) && Intrinsics.areEqual(this.VerifyPinStateManager$executeRiskChallenge$2$1, attributeCashierPayModel.VerifyPinStateManager$executeRiskChallenge$2$1) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda6, attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda6) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda4, attributeCashierPayModel.NetworkUserEntityData$$ExternalSyntheticLambda4) && Intrinsics.areEqual(this.newProxyInstance, attributeCashierPayModel.newProxyInstance) && Intrinsics.areEqual(this.getErrorConfigVersion, attributeCashierPayModel.getErrorConfigVersion) && Intrinsics.areEqual(this.L, attributeCashierPayModel.L) && Intrinsics.areEqual(this.getOnBoardingScenario, attributeCashierPayModel.getOnBoardingScenario) && Intrinsics.areEqual(this.SummaryVoucherView$$ExternalSyntheticLambda0, attributeCashierPayModel.SummaryVoucherView$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.J, attributeCashierPayModel.J) && Intrinsics.areEqual(this.GetContactSyncConfig, attributeCashierPayModel.GetContactSyncConfig) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, attributeCashierPayModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.whenAvailable, attributeCashierPayModel.whenAvailable) && Intrinsics.areEqual(this.B, attributeCashierPayModel.B) && Intrinsics.areEqual(this.getNameOrBuilderList, attributeCashierPayModel.getNameOrBuilderList) && Intrinsics.areEqual(this.lookAheadTest, attributeCashierPayModel.lookAheadTest) && Intrinsics.areEqual(this.SummaryVoucherView$$ExternalSyntheticLambda2, attributeCashierPayModel.SummaryVoucherView$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.V, attributeCashierPayModel.V) && Intrinsics.areEqual(this.initRecordTimeStamp, attributeCashierPayModel.initRecordTimeStamp) && Intrinsics.areEqual(this.W, attributeCashierPayModel.W) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, attributeCashierPayModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.Z, attributeCashierPayModel.Z);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.scheduleImpl;
        int hashCode = str == null ? 0 : str.hashCode();
        List<CashierPayChannelModel> list = this.I;
        int hashCode2 = list == null ? 0 : list.hashCode();
        String str2 = this.BottomSheetCardBindingView$watcherCardNumberView$1;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.G;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.getCallingPid;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.PlaceComponentResult;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        int hashCode7 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.H;
        int hashCode8 = str7 == null ? 0 : str7.hashCode();
        Boolean bool = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        int hashCode9 = bool == null ? 0 : bool.hashCode();
        String str8 = this.SubSequence;
        int hashCode10 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.getSupportButtonTintMode;
        int hashCode11 = str9 == null ? 0 : str9.hashCode();
        MoneyViewModel moneyViewModel = this.X;
        int hashCode12 = moneyViewModel == null ? 0 : moneyViewModel.hashCode();
        String str10 = this.O;
        int hashCode13 = str10 == null ? 0 : str10.hashCode();
        MoneyViewModel moneyViewModel2 = this.getValueOfTouchPositionAbsolute;
        int hashCode14 = moneyViewModel2 == null ? 0 : moneyViewModel2.hashCode();
        MoneyViewModel moneyViewModel3 = this.F;
        int hashCode15 = moneyViewModel3 == null ? 0 : moneyViewModel3.hashCode();
        List<CashierOrderGoodModel> list2 = this.isAuth;
        int hashCode16 = list2 == null ? 0 : list2.hashCode();
        String str11 = this.T;
        int hashCode17 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode18 = str12 == null ? 0 : str12.hashCode();
        Boolean bool2 = this.Q;
        int hashCode19 = bool2 == null ? 0 : bool2.hashCode();
        Boolean bool3 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        int hashCode20 = bool3 == null ? 0 : bool3.hashCode();
        String str13 = this.C;
        int hashCode21 = str13 == null ? 0 : str13.hashCode();
        Boolean bool4 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        int hashCode22 = bool4 == null ? 0 : bool4.hashCode();
        Boolean bool5 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int hashCode23 = bool5 == null ? 0 : bool5.hashCode();
        String str14 = this.D;
        int hashCode24 = str14 == null ? 0 : str14.hashCode();
        String str15 = this.Y;
        int hashCode25 = str15 == null ? 0 : str15.hashCode();
        int hashCode26 = this.getAuthRequestContext.hashCode();
        String str16 = this.VerifyPinStateManager$executeRiskChallenge$2$2;
        int hashCode27 = str16 == null ? 0 : str16.hashCode();
        String str17 = this.FragmentBottomSheetPaymentSettingBinding;
        int hashCode28 = str17 == null ? 0 : str17.hashCode();
        String str18 = this.N;
        int hashCode29 = str18 == null ? 0 : str18.hashCode();
        List<RiskVerificationMethodModel> list3 = this.SummaryVoucherView$$ExternalSyntheticLambda1;
        int hashCode30 = list3 == null ? 0 : list3.hashCode();
        RiskVerificationMethodModel riskVerificationMethodModel = this.K;
        int hashCode31 = riskVerificationMethodModel == null ? 0 : riskVerificationMethodModel.hashCode();
        RiskVerificationMethodModel riskVerificationMethodModel2 = this.P;
        int hashCode32 = riskVerificationMethodModel2 == null ? 0 : riskVerificationMethodModel2.hashCode();
        Integer num = this.readMicros;
        int hashCode33 = num == null ? 0 : num.hashCode();
        Integer num2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int hashCode34 = num2 == null ? 0 : num2.hashCode();
        Integer num3 = this.isLayoutRequested;
        int hashCode35 = num3 == null ? 0 : num3.hashCode();
        String str19 = this.S;
        int hashCode36 = str19 == null ? 0 : str19.hashCode();
        Object obj = this.AppCompatEmojiTextHelper;
        int hashCode37 = obj == null ? 0 : obj.hashCode();
        String str20 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int hashCode38 = str20 == null ? 0 : str20.hashCode();
        String str21 = this.moveToNextValue;
        int hashCode39 = str21 == null ? 0 : str21.hashCode();
        List<Risk3dsAdditionalDataModel> list4 = this.R;
        int hashCode40 = list4 == null ? 0 : list4.hashCode();
        String str22 = this.E;
        int hashCode41 = str22 == null ? 0 : str22.hashCode();
        String str23 = this.flip;
        int hashCode42 = str23 == null ? 0 : str23.hashCode();
        String str24 = this.DatabaseTableConfigUtil;
        int hashCode43 = str24 == null ? 0 : str24.hashCode();
        List<PayMethodViewDtoModel> list5 = this.M;
        int hashCode44 = list5 == null ? 0 : list5.hashCode();
        Boolean bool6 = this.U;
        int hashCode45 = bool6 == null ? 0 : bool6.hashCode();
        String str25 = this.shouldRecycleViewType;
        int hashCode46 = str25 == null ? 0 : str25.hashCode();
        Boolean bool7 = this.PrepareContext;
        int hashCode47 = bool7 == null ? 0 : bool7.hashCode();
        String str26 = this.A;
        int hashCode48 = str26 == null ? 0 : str26.hashCode();
        Boolean bool8 = this.VerifyPinStateManager$executeRiskChallenge$2$1;
        int hashCode49 = bool8 == null ? 0 : bool8.hashCode();
        String str27 = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        int hashCode50 = str27 == null ? 0 : str27.hashCode();
        Boolean bool9 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        int hashCode51 = bool9 == null ? 0 : bool9.hashCode();
        Boolean bool10 = this.newProxyInstance;
        int hashCode52 = bool10 == null ? 0 : bool10.hashCode();
        String str28 = this.getErrorConfigVersion;
        int hashCode53 = str28 == null ? 0 : str28.hashCode();
        ProcessingMilestoneModel processingMilestoneModel = this.L;
        int hashCode54 = processingMilestoneModel == null ? 0 : processingMilestoneModel.hashCode();
        Long l = this.getOnBoardingScenario;
        int hashCode55 = l == null ? 0 : l.hashCode();
        String str29 = this.SummaryVoucherView$$ExternalSyntheticLambda0;
        int hashCode56 = str29 == null ? 0 : str29.hashCode();
        MoneyViewModel moneyViewModel4 = this.J;
        int hashCode57 = moneyViewModel4 == null ? 0 : moneyViewModel4.hashCode();
        String str30 = this.GetContactSyncConfig;
        int hashCode58 = str30 == null ? 0 : str30.hashCode();
        String str31 = this.MyBillsEntityDataFactory;
        int hashCode59 = str31 == null ? 0 : str31.hashCode();
        String str32 = this.whenAvailable;
        int hashCode60 = str32 == null ? 0 : str32.hashCode();
        String str33 = this.B;
        int hashCode61 = str33 == null ? 0 : str33.hashCode();
        String str34 = this.getNameOrBuilderList;
        int hashCode62 = str34 == null ? 0 : str34.hashCode();
        String str35 = this.lookAheadTest;
        int hashCode63 = str35 == null ? 0 : str35.hashCode();
        String str36 = this.SummaryVoucherView$$ExternalSyntheticLambda2;
        int hashCode64 = str36 == null ? 0 : str36.hashCode();
        MoneyViewModel moneyViewModel5 = this.V;
        int hashCode65 = moneyViewModel5 == null ? 0 : moneyViewModel5.hashCode();
        String str37 = this.initRecordTimeStamp;
        int hashCode66 = str37 == null ? 0 : str37.hashCode();
        String str38 = this.W;
        int hashCode67 = str38 == null ? 0 : str38.hashCode();
        String str39 = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode68 = str39 == null ? 0 : str39.hashCode();
        MoneyViewModel moneyViewModel6 = this.Z;
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + hashCode25) * 31) + hashCode26) * 31) + hashCode27) * 31) + hashCode28) * 31) + hashCode29) * 31) + hashCode30) * 31) + hashCode31) * 31) + hashCode32) * 31) + hashCode33) * 31) + hashCode34) * 31) + hashCode35) * 31) + hashCode36) * 31) + hashCode37) * 31) + hashCode38) * 31) + hashCode39) * 31) + hashCode40) * 31) + hashCode41) * 31) + hashCode42) * 31) + hashCode43) * 31) + hashCode44) * 31) + hashCode45) * 31) + hashCode46) * 31) + hashCode47) * 31) + hashCode48) * 31) + hashCode49) * 31) + hashCode50) * 31) + hashCode51) * 31) + hashCode52) * 31) + hashCode53) * 31) + hashCode54) * 31) + hashCode55) * 31) + hashCode56) * 31) + hashCode57) * 31) + hashCode58) * 31) + hashCode59) * 31) + hashCode60) * 31) + hashCode61) * 31) + hashCode62) * 31) + hashCode63) * 31) + hashCode64) * 31) + hashCode65) * 31) + hashCode66) * 31) + hashCode67) * 31) + hashCode68) * 31) + (moneyViewModel6 != null ? moneyViewModel6.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AttributeCashierPayModel(scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", I=");
        sb.append(this.I);
        sb.append(", BottomSheetCardBindingView$watcherCardNumberView$1=");
        sb.append(this.BottomSheetCardBindingView$watcherCardNumberView$1);
        sb.append(", G=");
        sb.append(this.G);
        sb.append(", getCallingPid=");
        sb.append(this.getCallingPid);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda5=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        sb.append(", H=");
        sb.append(this.H);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda3=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda3);
        sb.append(", SubSequence=");
        sb.append(this.SubSequence);
        sb.append(", getSupportButtonTintMode=");
        sb.append(this.getSupportButtonTintMode);
        sb.append(", X=");
        sb.append(this.X);
        sb.append(", O=");
        sb.append(this.O);
        sb.append(", getValueOfTouchPositionAbsolute=");
        sb.append(this.getValueOfTouchPositionAbsolute);
        sb.append(", F=");
        sb.append(this.F);
        sb.append(", isAuth=");
        sb.append(this.isAuth);
        sb.append(", T=");
        sb.append(this.T);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", Q=");
        sb.append(this.Q);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda8=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        sb.append(", C=");
        sb.append(this.C);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda7=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda7);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        sb.append(", D=");
        sb.append(this.D);
        sb.append(", Y=");
        sb.append(this.Y);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", VerifyPinStateManager$executeRiskChallenge$2$2=");
        sb.append(this.VerifyPinStateManager$executeRiskChallenge$2$2);
        sb.append(", FragmentBottomSheetPaymentSettingBinding=");
        sb.append(this.FragmentBottomSheetPaymentSettingBinding);
        sb.append(", N=");
        sb.append(this.N);
        sb.append(", SummaryVoucherView$$ExternalSyntheticLambda1=");
        sb.append(this.SummaryVoucherView$$ExternalSyntheticLambda1);
        sb.append(", K=");
        sb.append(this.K);
        sb.append(", P=");
        sb.append(this.P);
        sb.append(", readMicros=");
        sb.append(this.readMicros);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
        sb.append(", isLayoutRequested=");
        sb.append(this.isLayoutRequested);
        sb.append(", S=");
        sb.append(this.S);
        sb.append(", AppCompatEmojiTextHelper=");
        sb.append(this.AppCompatEmojiTextHelper);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", R=");
        sb.append(this.R);
        sb.append(", E=");
        sb.append(this.E);
        sb.append(", flip=");
        sb.append(this.flip);
        sb.append(", DatabaseTableConfigUtil=");
        sb.append(this.DatabaseTableConfigUtil);
        sb.append(", M=");
        sb.append(this.M);
        sb.append(", U=");
        sb.append(this.U);
        sb.append(", shouldRecycleViewType=");
        sb.append(this.shouldRecycleViewType);
        sb.append(", PrepareContext=");
        sb.append(this.PrepareContext);
        sb.append(", A=");
        sb.append(this.A);
        sb.append(", VerifyPinStateManager$executeRiskChallenge$2$1=");
        sb.append(this.VerifyPinStateManager$executeRiskChallenge$2$1);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda6=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda4=");
        sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda4);
        sb.append(", newProxyInstance=");
        sb.append(this.newProxyInstance);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", L=");
        sb.append(this.L);
        sb.append(", getOnBoardingScenario=");
        sb.append(this.getOnBoardingScenario);
        sb.append(", SummaryVoucherView$$ExternalSyntheticLambda0=");
        sb.append(this.SummaryVoucherView$$ExternalSyntheticLambda0);
        sb.append(", J=");
        sb.append(this.J);
        sb.append(", GetContactSyncConfig=");
        sb.append(this.GetContactSyncConfig);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", whenAvailable=");
        sb.append(this.whenAvailable);
        sb.append(", B=");
        sb.append(this.B);
        sb.append(", getNameOrBuilderList=");
        sb.append(this.getNameOrBuilderList);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", SummaryVoucherView$$ExternalSyntheticLambda2=");
        sb.append(this.SummaryVoucherView$$ExternalSyntheticLambda2);
        sb.append(", V=");
        sb.append(this.V);
        sb.append(", initRecordTimeStamp=");
        sb.append(this.initRecordTimeStamp);
        sb.append(", W=");
        sb.append(this.W);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", Z=");
        sb.append(this.Z);
        sb.append(')');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        p0.writeString(this.scheduleImpl);
        List<CashierPayChannelModel> list = this.I;
        if (list == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(list.size());
            Iterator<CashierPayChannelModel> it = list.iterator();
            while (it.hasNext()) {
                it.next().writeToParcel(p0, p1);
            }
        }
        p0.writeString(this.BottomSheetCardBindingView$watcherCardNumberView$1);
        p0.writeString(this.G);
        p0.writeString(this.getCallingPid);
        p0.writeString(this.PlaceComponentResult);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda5);
        p0.writeString(this.H);
        Boolean bool = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
        if (bool == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.SubSequence);
        p0.writeString(this.getSupportButtonTintMode);
        MoneyViewModel moneyViewModel = this.X;
        if (moneyViewModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel.writeToParcel(p0, p1);
        }
        p0.writeString(this.O);
        MoneyViewModel moneyViewModel2 = this.getValueOfTouchPositionAbsolute;
        if (moneyViewModel2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel2.writeToParcel(p0, p1);
        }
        MoneyViewModel moneyViewModel3 = this.F;
        if (moneyViewModel3 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel3.writeToParcel(p0, p1);
        }
        List<CashierOrderGoodModel> list2 = this.isAuth;
        if (list2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(list2.size());
            Iterator<CashierOrderGoodModel> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().writeToParcel(p0, p1);
            }
        }
        p0.writeString(this.T);
        p0.writeString(this.KClassImpl$Data$declaredNonStaticMembers$2);
        Boolean bool2 = this.Q;
        if (bool2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Boolean bool3 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (bool3 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.C);
        Boolean bool4 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (bool4 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool4.booleanValue() ? 1 : 0);
        }
        Boolean bool5 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (bool5 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool5.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.D);
        p0.writeString(this.Y);
        p0.writeString(this.getAuthRequestContext);
        p0.writeString(this.VerifyPinStateManager$executeRiskChallenge$2$2);
        p0.writeString(this.FragmentBottomSheetPaymentSettingBinding);
        p0.writeString(this.N);
        List<RiskVerificationMethodModel> list3 = this.SummaryVoucherView$$ExternalSyntheticLambda1;
        if (list3 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(list3.size());
            Iterator<RiskVerificationMethodModel> it3 = list3.iterator();
            while (it3.hasNext()) {
                it3.next().writeToParcel(p0, p1);
            }
        }
        RiskVerificationMethodModel riskVerificationMethodModel = this.K;
        if (riskVerificationMethodModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            riskVerificationMethodModel.writeToParcel(p0, p1);
        }
        RiskVerificationMethodModel riskVerificationMethodModel2 = this.P;
        if (riskVerificationMethodModel2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            riskVerificationMethodModel2.writeToParcel(p0, p1);
        }
        Integer num = this.readMicros;
        if (num == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(num.intValue());
        }
        Integer num2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (num2 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(num2.intValue());
        }
        Integer num3 = this.isLayoutRequested;
        if (num3 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(num3.intValue());
        }
        p0.writeString(this.S);
        p0.writeValue(this.AppCompatEmojiTextHelper);
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
        p0.writeString(this.moveToNextValue);
        List<Risk3dsAdditionalDataModel> list4 = this.R;
        if (list4 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(list4.size());
            Iterator<Risk3dsAdditionalDataModel> it4 = list4.iterator();
            while (it4.hasNext()) {
                it4.next().writeToParcel(p0, p1);
            }
        }
        p0.writeString(this.E);
        p0.writeString(this.flip);
        p0.writeString(this.DatabaseTableConfigUtil);
        List<PayMethodViewDtoModel> list5 = this.M;
        if (list5 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(list5.size());
            Iterator<PayMethodViewDtoModel> it5 = list5.iterator();
            while (it5.hasNext()) {
                it5.next().writeToParcel(p0, p1);
            }
        }
        Boolean bool6 = this.U;
        if (bool6 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool6.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.shouldRecycleViewType);
        Boolean bool7 = this.PrepareContext;
        if (bool7 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool7.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.A);
        Boolean bool8 = this.VerifyPinStateManager$executeRiskChallenge$2$1;
        if (bool8 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool8.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.NetworkUserEntityData$$ExternalSyntheticLambda6);
        Boolean bool9 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
        if (bool9 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool9.booleanValue() ? 1 : 0);
        }
        Boolean bool10 = this.newProxyInstance;
        if (bool10 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeInt(bool10.booleanValue() ? 1 : 0);
        }
        p0.writeString(this.getErrorConfigVersion);
        ProcessingMilestoneModel processingMilestoneModel = this.L;
        if (processingMilestoneModel == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            processingMilestoneModel.writeToParcel(p0, p1);
        }
        Long l = this.getOnBoardingScenario;
        if (l == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            p0.writeLong(l.longValue());
        }
        p0.writeString(this.SummaryVoucherView$$ExternalSyntheticLambda0);
        MoneyViewModel moneyViewModel4 = this.J;
        if (moneyViewModel4 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel4.writeToParcel(p0, p1);
        }
        p0.writeString(this.GetContactSyncConfig);
        p0.writeString(this.MyBillsEntityDataFactory);
        p0.writeString(this.whenAvailable);
        p0.writeString(this.B);
        p0.writeString(this.getNameOrBuilderList);
        p0.writeString(this.lookAheadTest);
        p0.writeString(this.SummaryVoucherView$$ExternalSyntheticLambda2);
        MoneyViewModel moneyViewModel5 = this.V;
        if (moneyViewModel5 == null) {
            p0.writeInt(0);
        } else {
            p0.writeInt(1);
            moneyViewModel5.writeToParcel(p0, p1);
        }
        p0.writeString(this.initRecordTimeStamp);
        p0.writeString(this.W);
        p0.writeString(this.BuiltInFictitiousFunctionClassFactory);
        MoneyViewModel moneyViewModel6 = this.Z;
        if (moneyViewModel6 == null) {
            p0.writeInt(0);
            return;
        }
        p0.writeInt(1);
        moneyViewModel6.writeToParcel(p0, p1);
    }

    public AttributeCashierPayModel(String str, List<CashierPayChannelModel> list, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, String str8, String str9, MoneyViewModel moneyViewModel, String str10, MoneyViewModel moneyViewModel2, MoneyViewModel moneyViewModel3, List<CashierOrderGoodModel> list2, String str11, String str12, Boolean bool2, Boolean bool3, String str13, Boolean bool4, Boolean bool5, String str14, String str15, String str16, String str17, String str18, String str19, List<RiskVerificationMethodModel> list3, RiskVerificationMethodModel riskVerificationMethodModel, RiskVerificationMethodModel riskVerificationMethodModel2, Integer num, Integer num2, Integer num3, String str20, Object obj, String str21, String str22, List<Risk3dsAdditionalDataModel> list4, String str23, String str24, String str25, List<PayMethodViewDtoModel> list5, Boolean bool6, String str26, Boolean bool7, String str27, Boolean bool8, String str28, Boolean bool9, Boolean bool10, String str29, ProcessingMilestoneModel processingMilestoneModel, Long l, String str30, MoneyViewModel moneyViewModel4, String str31, String str32, String str33, String str34, String str35, String str36, String str37, MoneyViewModel moneyViewModel5, String str38, String str39, String str40, MoneyViewModel moneyViewModel6) {
        Intrinsics.checkNotNullParameter(str16, "");
        this.scheduleImpl = str;
        this.I = list;
        this.BottomSheetCardBindingView$watcherCardNumberView$1 = str2;
        this.G = str3;
        this.getCallingPid = str4;
        this.PlaceComponentResult = str5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = str6;
        this.H = str7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = bool;
        this.SubSequence = str8;
        this.getSupportButtonTintMode = str9;
        this.X = moneyViewModel;
        this.O = str10;
        this.getValueOfTouchPositionAbsolute = moneyViewModel2;
        this.F = moneyViewModel3;
        this.isAuth = list2;
        this.T = str11;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str12;
        this.Q = bool2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = bool3;
        this.C = str13;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = bool4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = bool5;
        this.D = str14;
        this.Y = str15;
        this.getAuthRequestContext = str16;
        this.VerifyPinStateManager$executeRiskChallenge$2$2 = str17;
        this.FragmentBottomSheetPaymentSettingBinding = str18;
        this.N = str19;
        this.SummaryVoucherView$$ExternalSyntheticLambda1 = list3;
        this.K = riskVerificationMethodModel;
        this.P = riskVerificationMethodModel2;
        this.readMicros = num;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = num2;
        this.isLayoutRequested = num3;
        this.S = str20;
        this.AppCompatEmojiTextHelper = obj;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str21;
        this.moveToNextValue = str22;
        this.R = list4;
        this.E = str23;
        this.flip = str24;
        this.DatabaseTableConfigUtil = str25;
        this.M = list5;
        this.U = bool6;
        this.shouldRecycleViewType = str26;
        this.PrepareContext = bool7;
        this.A = str27;
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = bool8;
        this.NetworkUserEntityData$$ExternalSyntheticLambda6 = str28;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = bool9;
        this.newProxyInstance = bool10;
        this.getErrorConfigVersion = str29;
        this.L = processingMilestoneModel;
        this.getOnBoardingScenario = l;
        this.SummaryVoucherView$$ExternalSyntheticLambda0 = str30;
        this.J = moneyViewModel4;
        this.GetContactSyncConfig = str31;
        this.MyBillsEntityDataFactory = str32;
        this.whenAvailable = str33;
        this.B = str34;
        this.getNameOrBuilderList = str35;
        this.lookAheadTest = str36;
        this.SummaryVoucherView$$ExternalSyntheticLambda2 = str37;
        this.V = moneyViewModel5;
        this.initRecordTimeStamp = str38;
        this.W = str39;
        this.BuiltInFictitiousFunctionClassFactory = str40;
        this.Z = moneyViewModel6;
    }

    public /* synthetic */ AttributeCashierPayModel(String str, List list, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, String str8, String str9, MoneyViewModel moneyViewModel, String str10, MoneyViewModel moneyViewModel2, MoneyViewModel moneyViewModel3, List list2, String str11, String str12, Boolean bool2, Boolean bool3, String str13, Boolean bool4, Boolean bool5, String str14, String str15, String str16, String str17, String str18, String str19, List list3, RiskVerificationMethodModel riskVerificationMethodModel, RiskVerificationMethodModel riskVerificationMethodModel2, Integer num, Integer num2, Integer num3, String str20, Object obj, String str21, String str22, List list4, String str23, String str24, String str25, List list5, Boolean bool6, String str26, Boolean bool7, String str27, Boolean bool8, String str28, Boolean bool9, Boolean bool10, String str29, ProcessingMilestoneModel processingMilestoneModel, Long l, String str30, MoneyViewModel moneyViewModel4, String str31, String str32, String str33, String str34, String str35, String str36, String str37, MoneyViewModel moneyViewModel5, String str38, String str39, String str40, MoneyViewModel moneyViewModel6, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? new MoneyViewModel(null, null, null, 7, null) : moneyViewModel, (i & 4096) != 0 ? null : str10, (i & 8192) != 0 ? new MoneyViewModel(null, null, null, 7, null) : moneyViewModel2, (i & 16384) != 0 ? new MoneyViewModel(null, null, null, 7, null) : moneyViewModel3, (i & 32768) != 0 ? CollectionsKt.emptyList() : list2, (i & 65536) != 0 ? null : str11, (i & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : str12, (i & 262144) != 0 ? null : bool2, (i & 524288) != 0 ? null : bool3, (i & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? null : str13, (i & 2097152) != 0 ? null : bool4, (i & 4194304) != 0 ? null : bool5, (i & 8388608) != 0 ? null : str14, (i & 16777216) != 0 ? null : str15, (i & 33554432) != 0 ? "" : str16, (i & 67108864) != 0 ? null : str17, (i & 134217728) != 0 ? null : str18, (i & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? null : str19, (i & 536870912) != 0 ? CollectionsKt.emptyList() : list3, (i & 1073741824) != 0 ? null : riskVerificationMethodModel, (i & Integer.MIN_VALUE) != 0 ? null : riskVerificationMethodModel2, (i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : num2, (i2 & 4) != 0 ? null : num3, (i2 & 8) != 0 ? null : str20, (i2 & 16) != 0 ? null : obj, (i2 & 32) != 0 ? null : str21, (i2 & 64) != 0 ? null : str22, (i2 & 128) != 0 ? null : list4, (i2 & 256) != 0 ? null : str23, (i2 & 512) != 0 ? null : str24, (i2 & 1024) != 0 ? null : str25, (i2 & 2048) != 0 ? null : list5, (i2 & 4096) != 0 ? null : bool6, (i2 & 8192) != 0 ? null : str26, (i2 & 16384) != 0 ? null : bool7, (i2 & 32768) != 0 ? null : str27, (i2 & 65536) != 0 ? null : bool8, (i2 & AntDetector.SCENE_ID_LOGIN_REGIST) != 0 ? null : str28, (i2 & 262144) != 0 ? null : bool9, (i2 & 524288) != 0 ? null : bool10, (i2 & CrashCombineUtils.DEFAULT_MAX_INFO_LEN) != 0 ? null : str29, (i2 & 2097152) != 0 ? null : processingMilestoneModel, (i2 & 4194304) != 0 ? null : l, (i2 & 8388608) != 0 ? null : str30, (i2 & 16777216) != 0 ? null : moneyViewModel4, (i2 & 33554432) != 0 ? null : str31, (i2 & 67108864) != 0 ? null : str32, (i2 & 134217728) != 0 ? null : str33, (i2 & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? null : str34, (i2 & 536870912) != 0 ? null : str35, (i2 & 1073741824) != 0 ? null : str36, (i2 & Integer.MIN_VALUE) != 0 ? null : str37, (i3 & 1) != 0 ? null : moneyViewModel5, (i3 & 2) != 0 ? null : str38, (i3 & 4) != 0 ? null : str39, (i3 & 8) != 0 ? null : str40, (i3 & 16) != 0 ? null : moneyViewModel6);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        List<RiskVerificationMethodModel> list = this.SummaryVoucherView$$ExternalSyntheticLambda1;
        if ((list == null || list.isEmpty()) && this.K == null && this.P == null) {
            String str = this.S;
            return !(str == null || str.length() == 0);
        }
        return true;
    }

    public final String getAuthRequestContext() {
        String str = this.T;
        String upperCase = TrackerKey.TransactionType.ACQUIRING.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        if (Intrinsics.areEqual(str, upperCase)) {
            String str2 = this.flip;
            if (!(str2 == null || str2.length() == 0)) {
                return this.flip;
            }
        }
        return this.T;
    }

    public final void MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String str = this.getSupportButtonTintMode;
        if (str == null || str.length() == 0) {
            if (p0.length() > 0) {
                this.getSupportButtonTintMode = p0;
            }
        }
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        return Intrinsics.areEqual(this.O, ProcessingStatus.INNER_REDIRECT_STATUS) || Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, p0);
    }

    public final boolean MyBillsEntityDataFactory() {
        return Intrinsics.areEqual(this.SummaryVoucherView$$ExternalSyntheticLambda2, "FORCE_FACE");
    }

    public final String BuiltInFictitiousFunctionClassFactory() {
        if (Intrinsics.areEqual(this.O, ProcessingStatus.INNER_REDIRECT_STATUS)) {
            StringBuilder sb = new StringBuilder();
            sb.append("https://m.dana.id");
            sb.append(this.initRecordTimeStamp);
            Uri parse = Uri.parse(sb.toString());
            Intrinsics.checkNotNullExpressionValue(parse, "");
            Uri.Builder buildUpon = parse.buildUpon();
            Object obj = this.AppCompatEmojiTextHelper;
            Map map = obj instanceof Map ? (Map) obj : null;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    buildUpon.appendQueryParameter(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));
                }
            }
            buildUpon.appendQueryParameter("previousPage", "cashier");
            buildUpon.appendQueryParameter("fromSubApp", "false");
            String obj2 = buildUpon.build().toString();
            Intrinsics.checkNotNullExpressionValue(obj2, "");
            return obj2;
        }
        return "";
    }

    public final String PlaceComponentResult() {
        String str;
        List<RiskVerificationMethodModel> list = this.SummaryVoucherView$$ExternalSyntheticLambda1;
        if (list == null || list.isEmpty()) {
            RiskVerificationMethodModel riskVerificationMethodModel = this.K;
            if (riskVerificationMethodModel == null || (str = riskVerificationMethodModel.scheduleImpl) == null) {
                RiskVerificationMethodModel riskVerificationMethodModel2 = this.P;
                str = riskVerificationMethodModel2 != null ? riskVerificationMethodModel2.scheduleImpl : null;
            }
        } else {
            str = ((RiskVerificationMethodModel) CollectionsKt.first((List) this.SummaryVoucherView$$ExternalSyntheticLambda1)).scheduleImpl;
        }
        return str == null ? "" : str;
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<AttributeCashierPayModel> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AttributeCashierPayModel createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3;
            ArrayList arrayList4;
            ArrayList arrayList5;
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(CashierPayChannelModel.CREATOR.createFromParcel(parcel));
                }
            }
            ArrayList arrayList6 = arrayList;
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            Boolean valueOf = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            MoneyViewModel createFromParcel = parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel);
            String readString10 = parcel.readString();
            MoneyViewModel createFromParcel2 = parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel);
            MoneyViewModel createFromParcel3 = parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                arrayList2 = null;
            } else {
                int readInt2 = parcel.readInt();
                arrayList2 = new ArrayList(readInt2);
                int i2 = 0;
                while (i2 != readInt2) {
                    arrayList2.add(CashierOrderGoodModel.CREATOR.createFromParcel(parcel));
                    i2++;
                    readInt2 = readInt2;
                }
            }
            ArrayList arrayList7 = arrayList2;
            String readString11 = parcel.readString();
            String readString12 = parcel.readString();
            Boolean valueOf2 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            Boolean valueOf3 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            String readString13 = parcel.readString();
            Boolean valueOf4 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            Boolean valueOf5 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            String readString14 = parcel.readString();
            String readString15 = parcel.readString();
            String readString16 = parcel.readString();
            String readString17 = parcel.readString();
            String readString18 = parcel.readString();
            String readString19 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList3 = null;
            } else {
                int readInt3 = parcel.readInt();
                arrayList3 = new ArrayList(readInt3);
                int i3 = 0;
                while (i3 != readInt3) {
                    arrayList3.add(RiskVerificationMethodModel.CREATOR.createFromParcel(parcel));
                    i3++;
                    readInt3 = readInt3;
                }
            }
            ArrayList arrayList8 = arrayList3;
            RiskVerificationMethodModel createFromParcel4 = parcel.readInt() == 0 ? null : RiskVerificationMethodModel.CREATOR.createFromParcel(parcel);
            RiskVerificationMethodModel createFromParcel5 = parcel.readInt() == 0 ? null : RiskVerificationMethodModel.CREATOR.createFromParcel(parcel);
            Integer valueOf6 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf7 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf8 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString20 = parcel.readString();
            Object readValue = parcel.readValue(AttributeCashierPayModel.class.getClassLoader());
            String readString21 = parcel.readString();
            String readString22 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList4 = null;
            } else {
                int readInt4 = parcel.readInt();
                arrayList4 = new ArrayList(readInt4);
                int i4 = 0;
                while (i4 != readInt4) {
                    arrayList4.add(Risk3dsAdditionalDataModel.CREATOR.createFromParcel(parcel));
                    i4++;
                    readInt4 = readInt4;
                }
            }
            ArrayList arrayList9 = arrayList4;
            String readString23 = parcel.readString();
            String readString24 = parcel.readString();
            String readString25 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList5 = null;
            } else {
                int readInt5 = parcel.readInt();
                arrayList5 = new ArrayList(readInt5);
                int i5 = 0;
                while (i5 != readInt5) {
                    arrayList5.add(PayMethodViewDtoModel.CREATOR.createFromParcel(parcel));
                    i5++;
                    readInt5 = readInt5;
                }
            }
            return new AttributeCashierPayModel(readString, arrayList6, readString2, readString3, readString4, readString5, readString6, readString7, valueOf, readString8, readString9, createFromParcel, readString10, createFromParcel2, createFromParcel3, arrayList7, readString11, readString12, valueOf2, valueOf3, readString13, valueOf4, valueOf5, readString14, readString15, readString16, readString17, readString18, readString19, arrayList8, createFromParcel4, createFromParcel5, valueOf6, valueOf7, valueOf8, readString20, readValue, readString21, readString22, arrayList9, readString23, readString24, readString25, arrayList5, parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readString(), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readString(), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readString(), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readString(), parcel.readInt() == 0 ? null : ProcessingMilestoneModel.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : MoneyViewModel.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AttributeCashierPayModel[] newArray(int i) {
            return new AttributeCashierPayModel[i];
        }
    }
}
