package kotlin.collections;

import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0002\b\n\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b \u001ag\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0003\u001a\u00020\u00022%\u0010\b\u001a!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\n\u0010\u000b\u001a_\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012%\u0010\b\u001a!\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\b\u0007H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\n\u0010\f\u001a%\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a8\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000fj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0010\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0086\b¢\u0006\u0004\b\u0011\u0010\u0012\u001aa\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000fj\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0010\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0015\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140\u0013\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014¢\u0006\u0004\b\u0011\u0010\u0016\u001a8\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0017j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0018\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0086\b¢\u0006\u0004\b\u0019\u0010\u001a\u001aa\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0017j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0018\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0015\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140\u0013\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014¢\u0006\u0004\b\u0019\u0010\u001b\u001a(\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0086\b¢\u0006\u0004\b\u001c\u0010\u000e\u001aQ\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0015\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140\u0013\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014¢\u0006\u0004\b\u001c\u0010\u001d\u001a(\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0086\b¢\u0006\u0004\b\u001e\u0010\u000e\u001aQ\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012*\u0010\u0015\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140\u0013\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014¢\u0006\u0004\b\u001e\u0010\u001d\u001a,\u0010 \u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001fH\u0086\n¢\u0006\u0004\b \u0010!\u001a,\u0010\"\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001fH\u0086\n¢\u0006\u0004\b\"\u0010!\u001a=\u0010&\u001a\u00020%\"\u000b\b\u0000\u0010\u0000\u0018\u0001¢\u0006\u0002\b#\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010$\u001a\u00028\u0000H\u0086\n¢\u0006\u0004\b&\u0010'\u001a5\u0010(\u001a\u00020%\"\u000b\b\u0000\u0010\u0000\u0018\u0001¢\u0006\u0002\b#*\u000e\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0002\b\u00030\t2\u0006\u0010$\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b(\u0010'\u001a;\u0010*\u001a\u00020%\"\u0004\b\u0000\u0010\u0000\"\u000b\b\u0001\u0010\u0001\u0018\u0001¢\u0006\u0002\b#*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010)\u001a\u00028\u0001H\u0086\b¢\u0006\u0004\b*\u0010'\u001a]\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u001e\u0010+\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f\u0012\u0004\u0012\u00020%0\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001aQ\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020%0\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b.\u0010-\u001a]\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u001e\u0010+\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f\u0012\u0004\u0012\u00020%0\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b/\u0010-\u001as\u00102\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u00100*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u00101\u001a\u00028\u00022\u001e\u0010+\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f\u0012\u0004\u0012\u00020%0\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b2\u00103\u001as\u00104\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u00100*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u00101\u001a\u00028\u00022\u001e\u0010+\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f\u0012\u0004\u0012\u00020%0\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b4\u00103\u001aQ\u00105\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020%0\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b5\u0010-\u001a?\u00106\u001a\u0004\u0018\u00018\u0001\"\u000b\b\u0000\u0010\u0000\u0018\u0001¢\u0006\u0002\b#\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010$\u001a\u00028\u0000H\u0086\n¢\u0006\u0004\b6\u00107\u001aE\u0010:\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010$\u001a\u00028\u00002\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u000108H\u0086\bø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001aE\u0010<\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010$\u001a\u00028\u00002\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u000108H\u0080\bø\u0001\u0000¢\u0006\u0004\b<\u0010;\u001aE\u0010=\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010$\u001a\u00028\u00002\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u000108H\u0086\bø\u0001\u0000¢\u0006\u0004\b=\u0010;\u001a1\u0010>\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010$\u001a\u00028\u0000¢\u0006\u0004\b>\u00107\u001aA\u0010@\u001a\u00028\u0001\"\u0014\b\u0000\u00100*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\t*\u00028\u0001\"\u0004\b\u0001\u0010?*\u00028\u00002\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u000108H\u0086\bø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a.\u0010B\u001a\u00020%\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH\u0086\b¢\u0006\u0004\bB\u0010C\u001aL\u0010D\u001a\u00020%\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\tH\u0086\b\u0082\u0002\u0019\n\u0017\b\u0000\u0012\r\u0010ÿÿÿÿÿÿÿÿÿ\u0001\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0004\bD\u0010C\u001a@\u0010F\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f0E\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH\u0086\n¢\u0006\u0004\bF\u0010G\u001a>\u0010J\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010I0H\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0086\n¢\u0006\u0004\bJ\u0010G\u001ac\u0010L\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010?*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u001e\u0010K\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f\u0012\u0004\u0012\u00028\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\bL\u0010-\u001ay\u0010M\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010?\"\u0018\b\u0003\u00100*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0002\u0012\u0006\b\u0000\u0012\u00028\u00010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u00101\u001a\u00028\u00032\u001e\u0010K\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f\u0012\u0004\u0012\u00028\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\bM\u00103\u001ac\u0010N\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010?*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u001e\u0010K\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f\u0012\u0004\u0012\u00028\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\bN\u0010-\u001ay\u0010O\u001a\u00028\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010?\"\u0018\b\u0003\u00100*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00020\u0005*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u00101\u001a\u00028\u00032\u001e\u0010K\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f\u0012\u0004\u0012\u00028\u00020\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\bO\u00103\u001aB\u0010P\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010$\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\bP\u0010Q\u001aJ\u0010P\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u000e\u0010R\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0013H\u0086\u0002¢\u0006\u0004\bP\u0010S\u001aH\u0010P\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\f\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000TH\u0086\u0002¢\u0006\u0004\bP\u0010U\u001aH\u0010P\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\f\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000VH\u0086\u0002¢\u0006\u0004\bP\u0010W\u001a4\u0010X\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010$\u001a\u00028\u0000H\u0086\n¢\u0006\u0004\bX\u0010Y\u001a<\u0010X\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u000e\u0010R\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0013H\u0086\n¢\u0006\u0004\bX\u0010Z\u001a:\u0010X\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000TH\u0086\n¢\u0006\u0004\bX\u0010[\u001a:\u0010X\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\f\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000VH\u0086\n¢\u0006\u0004\bX\u0010\\\u001a7\u0010]\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH\u0000¢\u0006\u0004\b]\u0010^\u001a:\u0010_\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\tH\u0086\b¢\u0006\u0004\b_\u0010^\u001aV\u0010`\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u001a\u0010\u0015\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140\u0013H\u0086\u0002¢\u0006\u0004\b`\u0010a\u001aN\u0010`\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014H\u0086\u0002¢\u0006\u0004\b`\u0010c\u001aT\u0010`\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0018\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140TH\u0086\u0002¢\u0006\u0004\b`\u0010U\u001aP\u0010`\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0014\u0010d\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH\u0086\u0002¢\u0006\u0004\b`\u0010e\u001aT\u0010`\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0018\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140VH\u0086\u0002¢\u0006\u0004\b`\u0010W\u001aL\u0010f\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u00052\u001a\u0010\u0015\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140\u0013H\u0086\n¢\u0006\u0004\bf\u0010g\u001aD\u0010f\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u00052\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014H\u0086\n¢\u0006\u0004\bf\u0010h\u001aJ\u0010f\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u00052\u0018\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140TH\u0086\n¢\u0006\u0004\bf\u0010[\u001aD\u0010f\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u00052\u0012\u0010d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH\u0086\n¢\u0006\u0004\bf\u0010i\u001aJ\u0010f\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u00052\u0018\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140VH\u0086\n¢\u0006\u0004\bf\u0010\\\u001aI\u0010j\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u00052\u001a\u0010\u0015\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140\u0013¢\u0006\u0004\bj\u0010g\u001aG\u0010j\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u00052\u0018\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140T¢\u0006\u0004\bj\u0010[\u001aG\u0010j\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u00052\u0018\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140V¢\u0006\u0004\bj\u0010\\\u001a?\u0010k\u001a\u0004\u0018\u00018\u0001\"\u000b\b\u0000\u0010\u0000\u0018\u0001¢\u0006\u0002\b#\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010$\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\bk\u00107\u001a<\u0010l\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010$\u001a\u00028\u00002\u0006\u0010)\u001a\u00028\u0001H\u0086\n¢\u0006\u0004\bl\u0010m\u001a=\u0010n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140\u0013¢\u0006\u0004\bn\u0010\u001d\u001aS\u0010n\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u00100*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u0005*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140\u00132\u0006\u00101\u001a\u00028\u0002¢\u0006\u0004\bn\u0010o\u001a;\u0010n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140T¢\u0006\u0004\bn\u0010p\u001aQ\u0010n\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u00100*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u0005*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140T2\u0006\u00101\u001a\u00028\u0002¢\u0006\u0004\bn\u0010q\u001a7\u0010n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\bn\u0010^\u001aM\u0010n\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u00100*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u0005*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u00101\u001a\u00028\u0002¢\u0006\u0004\bn\u0010e\u001a;\u0010n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140V¢\u0006\u0004\bn\u0010r\u001aQ\u0010n\u001a\u00028\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0018\b\u0002\u00100*\u0012\u0012\u0006\b\u0000\u0012\u00028\u0000\u0012\u0006\b\u0000\u0012\u00028\u00010\u0005*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00140V2\u0006\u00101\u001a\u00028\u0002¢\u0006\u0004\bn\u0010s\u001a7\u0010t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\bt\u0010^\u001a8\u0010u\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001fH\u0086\b¢\u0006\u0004\bu\u0010v\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {DiskFormatter.KB, "V", "", "capacity", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "", "buildMap", "(ILkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "emptyMap", "()Ljava/util/Map;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "hashMapOf", "()Ljava/util/HashMap;", "", "Lkotlin/Pair;", "pairs", "([Lkotlin/Pair;)Ljava/util/HashMap;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "linkedMapOf", "()Ljava/util/LinkedHashMap;", "([Lkotlin/Pair;)Ljava/util/LinkedHashMap;", "mapOf", "([Lkotlin/Pair;)Ljava/util/Map;", "mutableMapOf", "", "component1", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "Lkotlin/internal/OnlyInputTypes;", "key", "", "contains", "(Ljava/util/Map;Ljava/lang/Object;)Z", "containsKey", "value", "containsValue", "predicate", "filter", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "filterKeys", "filterNot", DiskFormatter.MB, FirebaseAnalytics.Param.DESTINATION, "filterNotTo", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "filterTo", "filterValues", "get", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "defaultValue", "getOrElse", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseNullable", "getOrPut", "getValue", "R", "ifEmpty", "(Ljava/util/Map;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "(Ljava/util/Map;)Z", "isNullOrEmpty", "", "iterator", "(Ljava/util/Map;)Ljava/util/Iterator;", "", "", "mutableIterator", "transform", "mapKeys", "mapKeysTo", "mapValues", "mapValuesTo", "minus", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", UserMetadata.KEYDATA_FILENAME, "(Ljava/util/Map;[Ljava/lang/Object;)Ljava/util/Map;", "", "(Ljava/util/Map;Ljava/lang/Iterable;)Ljava/util/Map;", "Lkotlin/sequences/Sequence;", "(Ljava/util/Map;Lkotlin/sequences/Sequence;)Ljava/util/Map;", "minusAssign", "(Ljava/util/Map;Ljava/lang/Object;)V", "(Ljava/util/Map;[Ljava/lang/Object;)V", "(Ljava/util/Map;Ljava/lang/Iterable;)V", "(Ljava/util/Map;Lkotlin/sequences/Sequence;)V", "optimizeReadOnlyMap", "(Ljava/util/Map;)Ljava/util/Map;", "orEmpty", "plus", "(Ljava/util/Map;[Lkotlin/Pair;)Ljava/util/Map;", "pair", "(Ljava/util/Map;Lkotlin/Pair;)Ljava/util/Map;", "map", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "plusAssign", "(Ljava/util/Map;[Lkotlin/Pair;)V", "(Ljava/util/Map;Lkotlin/Pair;)V", "(Ljava/util/Map;Ljava/util/Map;)V", "putAll", "remove", "set", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "toMap", "([Lkotlin/Pair;Ljava/util/Map;)Ljava/util/Map;", "(Ljava/lang/Iterable;)Ljava/util/Map;", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;Ljava/util/Map;)Ljava/util/Map;", "toMutableMap", "toPair", "(Ljava/util/Map$Entry;)Lkotlin/Pair;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/collections/MapsKt")
/* loaded from: classes.dex */
public class MapsKt__MapsKt extends MapsKt__MapsJVMKt {
    public static final <K, V> Map<K, V> emptyMap() {
        return EmptyMap.INSTANCE;
    }

    public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "");
        return pairArr.length > 0 ? MapsKt.toMap(pairArr, new LinkedHashMap(MapsKt.mapCapacity(pairArr.length))) : MapsKt.emptyMap();
    }

    private static final <K, V> Map<K, V> mapOf() {
        return MapsKt.emptyMap();
    }

    private static final <K, V> Map<K, V> mutableMapOf() {
        return new LinkedHashMap();
    }

    public static final <K, V> Map<K, V> mutableMapOf(Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(pairArr.length));
        MapsKt.putAll(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    private static final <K, V> HashMap<K, V> hashMapOf() {
        return new HashMap<>();
    }

    public static final <K, V> HashMap<K, V> hashMapOf(Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "");
        HashMap<K, V> hashMap = new HashMap<>(MapsKt.mapCapacity(pairArr.length));
        MapsKt.putAll(hashMap, pairArr);
        return hashMap;
    }

    private static final <K, V> LinkedHashMap<K, V> linkedMapOf() {
        return new LinkedHashMap<>();
    }

    public static final <K, V> LinkedHashMap<K, V> linkedMapOf(Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "");
        return (LinkedHashMap) MapsKt.toMap(pairArr, new LinkedHashMap(MapsKt.mapCapacity(pairArr.length)));
    }

    private static final <K, V> Map<K, V> buildMap(Function1<? super Map<K, V>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        Map createMapBuilder = MapsKt.createMapBuilder();
        function1.invoke(createMapBuilder);
        return MapsKt.build(createMapBuilder);
    }

    private static final <K, V> Map<K, V> buildMap(int i, Function1<? super Map<K, V>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        Map createMapBuilder = MapsKt.createMapBuilder(i);
        function1.invoke(createMapBuilder);
        return MapsKt.build(createMapBuilder);
    }

    private static final <K, V> boolean isNotEmpty(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "");
        return !map.isEmpty();
    }

    private static final <K, V> boolean isNullOrEmpty(Map<? extends K, ? extends V> map) {
        return map == null || map.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <K, V> Map<K, V> orEmpty(Map<K, ? extends V> map) {
        return map == 0 ? MapsKt.emptyMap() : map;
    }

    /* JADX WARN: Incorrect types in method signature: <M::Ljava/util/Map<**>;:TR;R:Ljava/lang/Object;>(TM;Lkotlin/jvm/functions/Function0<+TR;>;)TR; */
    private static final Object ifEmpty(Map map, Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        return map.isEmpty() ? function0.invoke() : map;
    }

    private static final <K, V> boolean contains(Map<? extends K, ? extends V> map, K k) {
        Intrinsics.checkNotNullParameter(map, "");
        return map.containsKey(k);
    }

    private static final <K, V> V get(Map<? extends K, ? extends V> map, K k) {
        Intrinsics.checkNotNullParameter(map, "");
        return map.get(k);
    }

    private static final <K, V> void set(Map<K, V> map, K k, V v) {
        Intrinsics.checkNotNullParameter(map, "");
        map.put(k, v);
    }

    private static final <K> boolean containsKey(Map<? extends K, ?> map, K k) {
        Intrinsics.checkNotNullParameter(map, "");
        return map.containsKey(k);
    }

    private static final <K, V> boolean containsValue(Map<K, ? extends V> map, V v) {
        Intrinsics.checkNotNullParameter(map, "");
        return map.containsValue(v);
    }

    private static final <K, V> V remove(Map<? extends K, V> map, K k) {
        Intrinsics.checkNotNullParameter(map, "");
        return (V) TypeIntrinsics.asMutableMap(map).remove(k);
    }

    private static final <K, V> K component1(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "");
        return entry.getKey();
    }

    private static final <K, V> V component2(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "");
        return entry.getValue();
    }

    private static final <K, V> Pair<K, V> toPair(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, "");
        return new Pair<>(entry.getKey(), entry.getValue());
    }

    private static final <K, V> V getOrElse(Map<K, ? extends V> map, K k, Function0<? extends V> function0) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(function0, "");
        V v = map.get(k);
        return v == null ? function0.invoke() : v;
    }

    public static final <K, V> V getOrElseNullable(Map<K, ? extends V> map, K k, Function0<? extends V> function0) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(function0, "");
        V v = map.get(k);
        return (v != null || map.containsKey(k)) ? v : function0.invoke();
    }

    public static final <K, V> V getValue(Map<K, ? extends V> map, K k) {
        Intrinsics.checkNotNullParameter(map, "");
        return (V) MapsKt.getOrImplicitDefaultNullable(map, k);
    }

    public static final <K, V> V getOrPut(Map<K, V> map, K k, Function0<? extends V> function0) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(function0, "");
        V v = map.get(k);
        if (v == null) {
            V invoke = function0.invoke();
            map.put(k, invoke);
            return invoke;
        }
        return v;
    }

    private static final <K, V> Iterator<Map.Entry<K, V>> iterator(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "");
        return (Iterator<Map.Entry<? extends K, ? extends V>>) map.entrySet().iterator();
    }

    private static final <K, V> Iterator<Map.Entry<K, V>> mutableIterator(Map<K, V> map) {
        Intrinsics.checkNotNullParameter(map, "");
        return map.entrySet().iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R, M extends Map<? super K, ? super R>> M mapValuesTo(Map<? extends K, ? extends V> map, M m, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(m, "");
        Intrinsics.checkNotNullParameter(function1, "");
        for (Object obj : map.entrySet()) {
            m.put(((Map.Entry) obj).getKey(), function1.invoke(obj));
        }
        return m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R, M extends Map<? super R, ? super V>> M mapKeysTo(Map<? extends K, ? extends V> map, M m, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(m, "");
        Intrinsics.checkNotNullParameter(function1, "");
        for (Object obj : map.entrySet()) {
            m.put(function1.invoke(obj), ((Map.Entry) obj).getValue());
        }
        return m;
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairArr) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(pairArr, "");
        for (Pair<? extends K, ? extends V> pair : pairArr) {
            map.put((K) pair.component1(), (V) pair.component2());
        }
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(iterable, "");
        for (Pair<? extends K, ? extends V> pair : iterable) {
            map.put((K) pair.component1(), (V) pair.component2());
        }
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> map, Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(sequence, "");
        for (Pair<? extends K, ? extends V> pair : sequence) {
            map.put((K) pair.component1(), (V) pair.component2());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R> Map<K, R> mapValues(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(function1, "");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Object obj : map.entrySet()) {
            linkedHashMap.put(((Map.Entry) obj).getKey(), function1.invoke(obj));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R> Map<R, V> mapKeys(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(function1, "");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Object obj : map.entrySet()) {
            linkedHashMap.put(function1.invoke(obj), ((Map.Entry) obj).getValue());
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> filterKeys(Map<? extends K, ? extends V> map, Function1<? super K, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(function1, "");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (function1.invoke((K) entry.getKey()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> filterValues(Map<? extends K, ? extends V> map, Function1<? super V, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(function1, "");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (function1.invoke((V) entry.getValue()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M filterTo(Map<? extends K, ? extends V> map, M m, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(m, "");
        Intrinsics.checkNotNullParameter(function1, "");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (function1.invoke(entry).booleanValue()) {
                m.put(entry.getKey(), entry.getValue());
            }
        }
        return m;
    }

    public static final <K, V> Map<K, V> filter(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(function1, "");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (function1.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M filterNotTo(Map<? extends K, ? extends V> map, M m, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(m, "");
        Intrinsics.checkNotNullParameter(function1, "");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!function1.invoke(entry).booleanValue()) {
                m.put(entry.getKey(), entry.getValue());
            }
        }
        return m;
    }

    public static final <K, V> Map<K, V> filterNot(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(function1, "");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!function1.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> toMap(Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    return MapsKt.toMap(iterable, new LinkedHashMap(MapsKt.mapCapacity(collection.size())));
                }
                return MapsKt.mapOf(iterable instanceof List ? (Pair<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
            }
            return MapsKt.emptyMap();
        }
        return MapsKt.optimizeReadOnlyMap(MapsKt.toMap(iterable, new LinkedHashMap()));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Iterable<? extends Pair<? extends K, ? extends V>> iterable, M m) {
        Intrinsics.checkNotNullParameter(iterable, "");
        Intrinsics.checkNotNullParameter(m, "");
        MapsKt.putAll(m, iterable);
        return m;
    }

    public static final <K, V> Map<K, V> toMap(Pair<? extends K, ? extends V>[] pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "");
        int length = pairArr.length;
        if (length != 0) {
            if (length == 1) {
                return MapsKt.mapOf(pairArr[0]);
            }
            return MapsKt.toMap(pairArr, new LinkedHashMap(MapsKt.mapCapacity(pairArr.length)));
        }
        return MapsKt.emptyMap();
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Pair<? extends K, ? extends V>[] pairArr, M m) {
        Intrinsics.checkNotNullParameter(pairArr, "");
        Intrinsics.checkNotNullParameter(m, "");
        MapsKt.putAll(m, pairArr);
        return m;
    }

    public static final <K, V> Map<K, V> toMap(Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "");
        return MapsKt.optimizeReadOnlyMap(MapsKt.toMap(sequence, new LinkedHashMap()));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Sequence<? extends Pair<? extends K, ? extends V>> sequence, M m) {
        Intrinsics.checkNotNullParameter(sequence, "");
        Intrinsics.checkNotNullParameter(m, "");
        MapsKt.putAll(m, sequence);
        return m;
    }

    public static final <K, V> Map<K, V> toMap(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "");
        int size = map.size();
        if (size != 0) {
            if (size == 1) {
                return MapsKt.toSingletonMap(map);
            }
            return MapsKt.toMutableMap(map);
        }
        return MapsKt.emptyMap();
    }

    public static final <K, V> Map<K, V> toMutableMap(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "");
        return new LinkedHashMap(map);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Map<? extends K, ? extends V> map, M m) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(m, "");
        m.putAll(map);
        return m;
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(pair, "");
        if (map.isEmpty()) {
            return MapsKt.mapOf(pair);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(pair.getFirst(), pair.getSecond());
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(iterable, "");
        if (map.isEmpty()) {
            return MapsKt.toMap(iterable);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        MapsKt.putAll(linkedHashMap, iterable);
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Pair<? extends K, ? extends V>[] pairArr) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(pairArr, "");
        if (map.isEmpty()) {
            return MapsKt.toMap(pairArr);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        MapsKt.putAll(linkedHashMap, pairArr);
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(sequence, "");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        MapsKt.putAll(linkedHashMap, sequence);
        return MapsKt.optimizeReadOnlyMap(linkedHashMap);
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(map2, "");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    private static final <K, V> void plusAssign(Map<? super K, ? super V> map, Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(pair, "");
        map.put((K) pair.getFirst(), (V) pair.getSecond());
    }

    private static final <K, V> void plusAssign(Map<? super K, ? super V> map, Iterable<? extends Pair<? extends K, ? extends V>> iterable) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(iterable, "");
        MapsKt.putAll(map, iterable);
    }

    private static final <K, V> void plusAssign(Map<? super K, ? super V> map, Pair<? extends K, ? extends V>[] pairArr) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(pairArr, "");
        MapsKt.putAll(map, pairArr);
    }

    private static final <K, V> void plusAssign(Map<? super K, ? super V> map, Sequence<? extends Pair<? extends K, ? extends V>> sequence) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(sequence, "");
        MapsKt.putAll(map, sequence);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <K, V> void plusAssign(Map<? super K, ? super V> map, Map<K, ? extends V> map2) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(map2, "");
        map.putAll(map2);
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, K k) {
        Intrinsics.checkNotNullParameter(map, "");
        Map mutableMap = MapsKt.toMutableMap(map);
        mutableMap.remove(k);
        return MapsKt.optimizeReadOnlyMap(mutableMap);
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, Iterable<? extends K> iterable) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(iterable, "");
        Map mutableMap = MapsKt.toMutableMap(map);
        CollectionsKt.removeAll(mutableMap.keySet(), iterable);
        return MapsKt.optimizeReadOnlyMap(mutableMap);
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, K[] kArr) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(kArr, "");
        Map mutableMap = MapsKt.toMutableMap(map);
        CollectionsKt.removeAll(mutableMap.keySet(), kArr);
        return MapsKt.optimizeReadOnlyMap(mutableMap);
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, Sequence<? extends K> sequence) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(sequence, "");
        Map mutableMap = MapsKt.toMutableMap(map);
        CollectionsKt.removeAll(mutableMap.keySet(), sequence);
        return MapsKt.optimizeReadOnlyMap(mutableMap);
    }

    private static final <K, V> void minusAssign(Map<K, V> map, K k) {
        Intrinsics.checkNotNullParameter(map, "");
        map.remove(k);
    }

    private static final <K, V> void minusAssign(Map<K, V> map, Iterable<? extends K> iterable) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(iterable, "");
        CollectionsKt.removeAll(map.keySet(), iterable);
    }

    private static final <K, V> void minusAssign(Map<K, V> map, K[] kArr) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(kArr, "");
        CollectionsKt.removeAll(map.keySet(), kArr);
    }

    private static final <K, V> void minusAssign(Map<K, V> map, Sequence<? extends K> sequence) {
        Intrinsics.checkNotNullParameter(map, "");
        Intrinsics.checkNotNullParameter(sequence, "");
        CollectionsKt.removeAll(map.keySet(), sequence);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> optimizeReadOnlyMap(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "");
        int size = map.size();
        if (size != 0) {
            return size == 1 ? MapsKt.toSingletonMap(map) : map;
        }
        return MapsKt.emptyMap();
    }
}
