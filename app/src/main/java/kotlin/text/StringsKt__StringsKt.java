package kotlin.text;

import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.here.model.HereUrlConstant;
import id.dana.sendmoney.summary.SummaryActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0019\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b@\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a#\u0010\n\u001a\u00020\t*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\f\u001a\u00020\t*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u000b\u001a&\u0010\u000f\u001a\u00020\u0007*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a&\u0010\u000f\u001a\u00020\u0007*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u000f\u0010\u0011\u001a\u001c\u0010\u000f\u001a\u00020\u0007*\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0086\n¢\u0006\u0004\b\u000f\u0010\u0014\u001a\u001f\u0010\u0015\u001a\u00020\u0007*\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001f\u0010\u0017\u001a\u00020\u0007*\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u0017\u0010\u0016\u001a#\u0010\u0018\u001a\u00020\u0007*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0010\u001a#\u0010\u0018\u001a\u00020\u0007*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0011\u001aA\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d*\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001aG\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d*\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u001a2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b!\u0010\"\u001aA\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t\u0018\u00010\u001d*\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b#\u0010\u001f\u001a\u0019\u0010%\u001a\u00020\u0007*\u00020\u00052\u0006\u0010$\u001a\u00020\u0000¢\u0006\u0004\b%\u0010&\u001a9\u0010+\u001a\u00028\u0001\"\f\b\u0000\u0010'*\u00020\u0005*\u00028\u0001\"\u0004\b\u0001\u0010(*\u00028\u00002\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00010)H\u0086\bø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a9\u0010-\u001a\u00028\u0001\"\f\b\u0000\u0010'*\u00020\u0005*\u00028\u0001\"\u0004\b\u0001\u0010(*\u00028\u00002\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00010)H\u0086\bø\u0001\u0000¢\u0006\u0004\b-\u0010,\u001a-\u0010.\u001a\u00020\u0000*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b.\u0010/\u001a=\u00101\u001a\u00020\u0000*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b1\u00102\u001a-\u0010.\u001a\u00020\u0000*\u00020\u00052\u0006\u00103\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b.\u00104\u001a-\u00107\u001a\u00020\u0000*\u00020\u00052\u0006\u00106\u001a\u0002052\b\b\u0002\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b7\u00108\u001a3\u00107\u001a\u00020\u0000*\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b7\u00109\u001a\u0014\u0010:\u001a\u00020\u0007*\u00020\u0005H\u0086\b¢\u0006\u0004\b:\u0010;\u001a\u0014\u0010<\u001a\u00020\u0007*\u00020\u0005H\u0086\b¢\u0006\u0004\b<\u0010;\u001a\u0014\u0010=\u001a\u00020\u0007*\u00020\u0005H\u0086\b¢\u0006\u0004\b=\u0010;\u001a2\u0010>\u001a\u00020\u0007*\u0004\u0018\u00010\u0005H\u0086\b\u0082\u0002\u0019\n\u0017\b\u0000\u0012\r\u0010ÿÿÿÿÿÿÿÿÿ\u0001\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0004\b>\u0010;\u001a2\u0010?\u001a\u00020\u0007*\u0004\u0018\u00010\u0005H\u0086\b\u0082\u0002\u0019\n\u0017\b\u0000\u0012\r\u0010ÿÿÿÿÿÿÿÿÿ\u0001\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0004\b?\u0010;\u001a\u0014\u0010A\u001a\u00020@*\u00020\u0005H\u0086\u0002¢\u0006\u0004\bA\u0010B\u001a-\u0010C\u001a\u00020\u0000*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bC\u0010/\u001a-\u0010C\u001a\u00020\u0000*\u00020\u00052\u0006\u00103\u001a\u00020\t2\b\b\u0002\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bC\u00104\u001a-\u0010D\u001a\u00020\u0000*\u00020\u00052\u0006\u00106\u001a\u0002052\b\b\u0002\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bD\u00108\u001a3\u0010D\u001a\u00020\u0000*\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\bD\u00109\u001a\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020\t0E*\u00020\u0005¢\u0006\u0004\bF\u0010G\u001a\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020\t0H*\u00020\u0005¢\u0006\u0004\bI\u0010J\u001a\u001c\u0010K\u001a\u00020\u0007*\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0086\f¢\u0006\u0004\bK\u0010\u0014\u001a\u0016\u0010L\u001a\u00020\t*\u0004\u0018\u00010\tH\u0086\b¢\u0006\u0004\bL\u0010M\u001a#\u0010P\u001a\u00020\u0005*\u00020\u00052\u0006\u0010N\u001a\u00020\u00002\b\b\u0002\u0010O\u001a\u00020\r¢\u0006\u0004\bP\u0010Q\u001a#\u0010P\u001a\u00020\t*\u00020\t2\u0006\u0010N\u001a\u00020\u00002\b\b\u0002\u0010O\u001a\u00020\r¢\u0006\u0004\bP\u0010R\u001a#\u0010S\u001a\u00020\u0005*\u00020\u00052\u0006\u0010N\u001a\u00020\u00002\b\b\u0002\u0010O\u001a\u00020\r¢\u0006\u0004\bS\u0010Q\u001a#\u0010S\u001a\u00020\t*\u00020\t2\u0006\u0010N\u001a\u00020\u00002\b\b\u0002\u0010O\u001a\u00020\r¢\u0006\u0004\bS\u0010R\u001aG\u0010W\u001a\b\u0012\u0004\u0012\u00020V0E*\u00020\u00052\u000e\u0010U\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0T2\b\b\u0002\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\bW\u0010X\u001a?\u0010W\u001a\b\u0012\u0004\u0012\u00020V0E*\u00020\u00052\u0006\u0010U\u001a\u0002052\b\b\u0002\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\bW\u0010Y\u001a;\u0010\\\u001a\u00020\u0007*\u00020\u00052\u0006\u0010Z\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\\\u0010]\u001a\u0019\u0010_\u001a\u00020\u0005*\u00020\u00052\u0006\u0010^\u001a\u00020\u0005¢\u0006\u0004\b_\u0010`\u001a\u0019\u0010_\u001a\u00020\t*\u00020\t2\u0006\u0010^\u001a\u00020\u0005¢\u0006\u0004\b_\u0010a\u001a!\u0010b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0000¢\u0006\u0004\bb\u0010c\u001a\u0019\u0010b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010d\u001a\u00020V¢\u0006\u0004\bb\u0010e\u001a$\u0010b\u001a\u00020\t*\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\bb\u0010f\u001a\u001c\u0010b\u001a\u00020\t*\u00020\t2\u0006\u0010d\u001a\u00020VH\u0086\b¢\u0006\u0004\bb\u0010g\u001a\u0019\u0010h\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\bh\u0010`\u001a\u0019\u0010h\u001a\u00020\t*\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\bh\u0010a\u001a\u0019\u0010j\u001a\u00020\u0005*\u00020\u00052\u0006\u0010i\u001a\u00020\u0005¢\u0006\u0004\bj\u0010`\u001a!\u0010j\u001a\u00020\u0005*\u00020\u00052\u0006\u0010^\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\bj\u0010k\u001a\u0019\u0010j\u001a\u00020\t*\u00020\t2\u0006\u0010i\u001a\u00020\u0005¢\u0006\u0004\bj\u0010a\u001a!\u0010j\u001a\u00020\t*\u00020\t2\u0006\u0010^\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\bj\u0010l\u001a5\u0010p\u001a\u00020\t*\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0014\b\b\u0010o\u001a\u000e\u0012\u0004\u0012\u00020n\u0012\u0004\u0012\u00020\u00050mH\u0086\bø\u0001\u0000¢\u0006\u0004\bp\u0010q\u001a$\u0010p\u001a\u00020\t*\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010r\u001a\u00020\tH\u0086\b¢\u0006\u0004\bp\u0010s\u001a+\u0010u\u001a\u00020\t*\u00020\t2\u0006\u0010i\u001a\u00020\r2\u0006\u0010r\u001a\u00020\t2\b\b\u0002\u0010t\u001a\u00020\t¢\u0006\u0004\bu\u0010v\u001a+\u0010u\u001a\u00020\t*\u00020\t2\u0006\u0010i\u001a\u00020\t2\u0006\u0010r\u001a\u00020\t2\b\b\u0002\u0010t\u001a\u00020\t¢\u0006\u0004\bu\u0010w\u001a+\u0010x\u001a\u00020\t*\u00020\t2\u0006\u0010i\u001a\u00020\r2\u0006\u0010r\u001a\u00020\t2\b\b\u0002\u0010t\u001a\u00020\t¢\u0006\u0004\bx\u0010v\u001a+\u0010x\u001a\u00020\t*\u00020\t2\u0006\u0010i\u001a\u00020\t2\u0006\u0010r\u001a\u00020\t2\b\b\u0002\u0010t\u001a\u00020\t¢\u0006\u0004\bx\u0010w\u001a+\u0010y\u001a\u00020\t*\u00020\t2\u0006\u0010i\u001a\u00020\r2\u0006\u0010r\u001a\u00020\t2\b\b\u0002\u0010t\u001a\u00020\t¢\u0006\u0004\by\u0010v\u001a+\u0010y\u001a\u00020\t*\u00020\t2\u0006\u0010i\u001a\u00020\t2\u0006\u0010r\u001a\u00020\t2\b\b\u0002\u0010t\u001a\u00020\t¢\u0006\u0004\by\u0010w\u001a+\u0010z\u001a\u00020\t*\u00020\t2\u0006\u0010i\u001a\u00020\r2\u0006\u0010r\u001a\u00020\t2\b\b\u0002\u0010t\u001a\u00020\t¢\u0006\u0004\bz\u0010v\u001a+\u0010z\u001a\u00020\t*\u00020\t2\u0006\u0010i\u001a\u00020\t2\u0006\u0010r\u001a\u00020\t2\b\b\u0002\u0010t\u001a\u00020\t¢\u0006\u0004\bz\u0010w\u001a$\u0010{\u001a\u00020\t*\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010r\u001a\u00020\tH\u0086\b¢\u0006\u0004\b{\u0010s\u001a+\u0010|\u001a\u00020\t*\u00020\t2\u0012\u0010o\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0mH\u0086\bø\u0001\u0000¢\u0006\u0004\b|\u0010}\u001a+\u0010~\u001a\u00020\t*\u00020\t2\u0012\u0010o\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050mH\u0086\bø\u0001\u0000¢\u0006\u0004\b~\u0010}\u001a*\u0010\u007f\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00002\u0006\u0010r\u001a\u00020\u0005¢\u0006\u0005\b\u007f\u0010\u0080\u0001\u001a\"\u0010\u007f\u001a\u00020\u0005*\u00020\u00052\u0006\u0010d\u001a\u00020V2\u0006\u0010r\u001a\u00020\u0005¢\u0006\u0005\b\u007f\u0010\u0081\u0001\u001a-\u0010\u007f\u001a\u00020\t*\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00002\u0006\u0010r\u001a\u00020\u0005H\u0086\b¢\u0006\u0005\b\u007f\u0010\u0082\u0001\u001a%\u0010\u007f\u001a\u00020\t*\u00020\t2\u0006\u0010d\u001a\u00020V2\u0006\u0010r\u001a\u00020\u0005H\u0086\b¢\u0006\u0005\b\u007f\u0010\u0083\u0001\u001aB\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\t0H*\u00020\u00052\u0012\u0010U\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0T\"\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a:\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\t0H*\u00020\u00052\n\u0010U\u001a\u000205\"\u00020\r2\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0006\b\u0084\u0001\u0010\u0086\u0001\u001a4\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020\t0H*\u00020\u00052\u0006\u0010i\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a/\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\t0H*\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0006\b\u0084\u0001\u0010\u0089\u0001\u001aB\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\t0E*\u00020\u00052\u0012\u0010U\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0T\"\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a:\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\t0E*\u00020\u00052\n\u0010U\u001a\u000205\"\u00020\r2\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0006\b\u008a\u0001\u0010\u008c\u0001\u001a/\u0010\u008a\u0001\u001a\b\u0012\u0004\u0012\u00020\t0E*\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0006\b\u008a\u0001\u0010\u008d\u0001\u001a%\u0010\u008e\u0001\u001a\u00020\u0007*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0005\b\u008e\u0001\u0010\u0010\u001a%\u0010\u008e\u0001\u001a\u00020\u0007*\u00020\u00052\u0006\u0010^\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0005\b\u008e\u0001\u0010\u0011\u001a.\u0010\u008e\u0001\u001a\u00020\u0007*\u00020\u00052\u0006\u0010^\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u001b\u0010\u0090\u0001\u001a\u00020\u0005*\u00020\u00052\u0006\u0010d\u001a\u00020V¢\u0006\u0005\b\u0090\u0001\u0010e\u001a)\u0010\u0090\u0001\u001a\u00020\u0005*\u00020\t2\u0007\u0010\u0091\u0001\u001a\u00020\u00002\u0007\u0010\u0092\u0001\u001a\u00020\u0000H\u0087\b¢\u0006\u0006\b\u0090\u0001\u0010\u0093\u0001\u001a)\u0010\u0094\u0001\u001a\u00020\t*\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u00100\u001a\u00020\u0000H\u0086\b¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u001c\u0010\u0094\u0001\u001a\u00020\t*\u00020\u00052\u0006\u0010d\u001a\u00020V¢\u0006\u0006\b\u0094\u0001\u0010\u0096\u0001\u001a\u001b\u0010\u0094\u0001\u001a\u00020\t*\u00020\t2\u0006\u0010d\u001a\u00020V¢\u0006\u0005\b\u0094\u0001\u0010g\u001a&\u0010\u0097\u0001\u001a\u00020\t*\u00020\t2\u0006\u0010i\u001a\u00020\r2\b\b\u0002\u0010t\u001a\u00020\t¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001\u001a&\u0010\u0097\u0001\u001a\u00020\t*\u00020\t2\u0006\u0010i\u001a\u00020\t2\b\b\u0002\u0010t\u001a\u00020\t¢\u0006\u0006\b\u0097\u0001\u0010\u0099\u0001\u001a&\u0010\u009a\u0001\u001a\u00020\t*\u00020\t2\u0006\u0010i\u001a\u00020\r2\b\b\u0002\u0010t\u001a\u00020\t¢\u0006\u0006\b\u009a\u0001\u0010\u0098\u0001\u001a&\u0010\u009a\u0001\u001a\u00020\t*\u00020\t2\u0006\u0010i\u001a\u00020\t2\b\b\u0002\u0010t\u001a\u00020\t¢\u0006\u0006\b\u009a\u0001\u0010\u0099\u0001\u001a&\u0010\u009b\u0001\u001a\u00020\t*\u00020\t2\u0006\u0010i\u001a\u00020\r2\b\b\u0002\u0010t\u001a\u00020\t¢\u0006\u0006\b\u009b\u0001\u0010\u0098\u0001\u001a&\u0010\u009b\u0001\u001a\u00020\t*\u00020\t2\u0006\u0010i\u001a\u00020\t2\b\b\u0002\u0010t\u001a\u00020\t¢\u0006\u0006\b\u009b\u0001\u0010\u0099\u0001\u001a&\u0010\u009c\u0001\u001a\u00020\t*\u00020\t2\u0006\u0010i\u001a\u00020\r2\b\b\u0002\u0010t\u001a\u00020\t¢\u0006\u0006\b\u009c\u0001\u0010\u0098\u0001\u001a&\u0010\u009c\u0001\u001a\u00020\t*\u00020\t2\u0006\u0010i\u001a\u00020\t2\b\b\u0002\u0010t\u001a\u00020\t¢\u0006\u0006\b\u009c\u0001\u0010\u0099\u0001\u001a\u0014\u0010\u009d\u0001\u001a\u00020\u0007*\u00020\t¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001\u001a\u0016\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0007*\u00020\t¢\u0006\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0014\u0010¡\u0001\u001a\u00020\u0005*\u00020\u0005¢\u0006\u0006\b¡\u0001\u0010¢\u0001\u001a/\u0010¡\u0001\u001a\u00020\u0005*\u00020\u00052\u0013\u0010£\u0001\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070mH\u0086\bø\u0001\u0000¢\u0006\u0006\b¡\u0001\u0010¤\u0001\u001a \u0010¡\u0001\u001a\u00020\u0005*\u00020\u00052\n\u00106\u001a\u000205\"\u00020\r¢\u0006\u0006\b¡\u0001\u0010¥\u0001\u001a\u0016\u0010¡\u0001\u001a\u00020\t*\u00020\tH\u0086\b¢\u0006\u0005\b¡\u0001\u0010M\u001a.\u0010¡\u0001\u001a\u00020\t*\u00020\t2\u0013\u0010£\u0001\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070mH\u0086\bø\u0001\u0000¢\u0006\u0005\b¡\u0001\u0010}\u001a \u0010¡\u0001\u001a\u00020\t*\u00020\t2\n\u00106\u001a\u000205\"\u00020\r¢\u0006\u0006\b¡\u0001\u0010¦\u0001\u001a\u0014\u0010§\u0001\u001a\u00020\u0005*\u00020\u0005¢\u0006\u0006\b§\u0001\u0010¢\u0001\u001a/\u0010§\u0001\u001a\u00020\u0005*\u00020\u00052\u0013\u0010£\u0001\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070mH\u0086\bø\u0001\u0000¢\u0006\u0006\b§\u0001\u0010¤\u0001\u001a \u0010§\u0001\u001a\u00020\u0005*\u00020\u00052\n\u00106\u001a\u000205\"\u00020\r¢\u0006\u0006\b§\u0001\u0010¥\u0001\u001a\u0016\u0010§\u0001\u001a\u00020\t*\u00020\tH\u0086\b¢\u0006\u0005\b§\u0001\u0010M\u001a.\u0010§\u0001\u001a\u00020\t*\u00020\t2\u0013\u0010£\u0001\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070mH\u0086\bø\u0001\u0000¢\u0006\u0005\b§\u0001\u0010}\u001a \u0010§\u0001\u001a\u00020\t*\u00020\t2\n\u00106\u001a\u000205\"\u00020\r¢\u0006\u0006\b§\u0001\u0010¦\u0001\u001a\u0014\u0010¨\u0001\u001a\u00020\u0005*\u00020\u0005¢\u0006\u0006\b¨\u0001\u0010¢\u0001\u001a/\u0010¨\u0001\u001a\u00020\u0005*\u00020\u00052\u0013\u0010£\u0001\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070mH\u0086\bø\u0001\u0000¢\u0006\u0006\b¨\u0001\u0010¤\u0001\u001a \u0010¨\u0001\u001a\u00020\u0005*\u00020\u00052\n\u00106\u001a\u000205\"\u00020\r¢\u0006\u0006\b¨\u0001\u0010¥\u0001\u001a\u0016\u0010¨\u0001\u001a\u00020\t*\u00020\tH\u0086\b¢\u0006\u0005\b¨\u0001\u0010M\u001a.\u0010¨\u0001\u001a\u00020\t*\u00020\t2\u0013\u0010£\u0001\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00070mH\u0086\bø\u0001\u0000¢\u0006\u0005\b¨\u0001\u0010}\u001a \u0010¨\u0001\u001a\u00020\t*\u00020\t2\n\u00106\u001a\u000205\"\u00020\r¢\u0006\u0006\b¨\u0001\u0010¦\u0001\"\u0018\u0010«\u0001\u001a\u00020V*\u00020\u00058G¢\u0006\b\u001a\u0006\b©\u0001\u0010ª\u0001\"\u0018\u0010®\u0001\u001a\u00020\u0000*\u00020\u00058G¢\u0006\b\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"", HereUrlConstant.LIMIT, "", "requireNonNegativeLimit", "(I)V", "", "other", "", "ignoreCase", "", "commonPrefixWith", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Ljava/lang/String;", "commonSuffixWith", "", "char", "contains", "(Ljava/lang/CharSequence;CZ)Z", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Z", "Lkotlin/text/Regex;", "regex", "(Ljava/lang/CharSequence;Lkotlin/text/Regex;)Z", "contentEqualsIgnoreCaseImpl", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z", "contentEqualsImpl", "endsWith", "suffix", "", "strings", "startIndex", "Lkotlin/Pair;", "findAnyOf", "(Ljava/lang/CharSequence;Ljava/util/Collection;IZ)Lkotlin/Pair;", "last", "findAnyOf$StringsKt__StringsKt", "(Ljava/lang/CharSequence;Ljava/util/Collection;IZZ)Lkotlin/Pair;", "findLastAnyOf", "index", "hasSurrogatePairAt", "(Ljava/lang/CharSequence;I)Z", "C", "R", "Lkotlin/Function0;", "defaultValue", "ifBlank", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "(Ljava/lang/CharSequence;CIZ)I", "endIndex", "indexOf$StringsKt__StringsKt", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIZZ)I", "string", "(Ljava/lang/CharSequence;Ljava/lang/String;IZ)I", "", "chars", "indexOfAny", "(Ljava/lang/CharSequence;[CIZ)I", "(Ljava/lang/CharSequence;Ljava/util/Collection;IZ)I", "isEmpty", "(Ljava/lang/CharSequence;)Z", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "Lkotlin/collections/CharIterator;", "iterator", "(Ljava/lang/CharSequence;)Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "Lkotlin/sequences/Sequence;", "lineSequence", "(Ljava/lang/CharSequence;)Lkotlin/sequences/Sequence;", "", "lines", "(Ljava/lang/CharSequence;)Ljava/util/List;", "matches", "orEmpty", "(Ljava/lang/String;)Ljava/lang/String;", "length", "padChar", "padEnd", "(Ljava/lang/CharSequence;IC)Ljava/lang/CharSequence;", "(Ljava/lang/String;IC)Ljava/lang/String;", "padStart", "", "delimiters", "Lkotlin/ranges/IntRange;", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "(Ljava/lang/CharSequence;[CIZI)Lkotlin/sequences/Sequence;", "thisOffset", "otherOffset", "regionMatchesImpl", "(Ljava/lang/CharSequence;ILjava/lang/CharSequence;IIZ)Z", "prefix", "removePrefix", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "(Ljava/lang/String;Ljava/lang/CharSequence;)Ljava/lang/String;", "removeRange", "(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;", "range", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;)Ljava/lang/CharSequence;", "(Ljava/lang/String;II)Ljava/lang/String;", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)Ljava/lang/String;", "removeSuffix", "delimiter", "removeSurrounding", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "(Ljava/lang/String;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "transform", "replace", "(Ljava/lang/CharSequence;Lkotlin/text/Regex;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "replacement", "(Ljava/lang/CharSequence;Lkotlin/text/Regex;Ljava/lang/String;)Ljava/lang/String;", "missingDelimiterValue", "replaceAfter", "(Ljava/lang/String;CLjava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceFirstCharWithChar", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "replaceFirstCharWithCharSequence", "replaceRange", "(Ljava/lang/CharSequence;IILjava/lang/CharSequence;)Ljava/lang/CharSequence;", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "(Ljava/lang/String;IILjava/lang/CharSequence;)Ljava/lang/String;", "(Ljava/lang/String;Lkotlin/ranges/IntRange;Ljava/lang/CharSequence;)Ljava/lang/String;", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "(Ljava/lang/CharSequence;[CZI)Ljava/util/List;", "split$StringsKt__StringsKt", "(Ljava/lang/CharSequence;Ljava/lang/String;ZI)Ljava/util/List;", "(Ljava/lang/CharSequence;Lkotlin/text/Regex;I)Ljava/util/List;", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "(Ljava/lang/CharSequence;[CZI)Lkotlin/sequences/Sequence;", "(Ljava/lang/CharSequence;Lkotlin/text/Regex;I)Lkotlin/sequences/Sequence;", "startsWith", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;IZ)Z", "subSequence", "start", "end", "(Ljava/lang/String;II)Ljava/lang/CharSequence;", "substring", "(Ljava/lang/CharSequence;II)Ljava/lang/String;", "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;)Ljava/lang/String;", "substringAfter", "(Ljava/lang/String;CLjava/lang/String;)Ljava/lang/String;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "substringAfterLast", "substringBefore", "substringBeforeLast", "toBooleanStrict", "(Ljava/lang/String;)Z", "toBooleanStrictOrNull", "(Ljava/lang/String;)Ljava/lang/Boolean;", "trim", "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "predicate", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/CharSequence;", "(Ljava/lang/CharSequence;[C)Ljava/lang/CharSequence;", "(Ljava/lang/String;[C)Ljava/lang/String;", "trimEnd", "trimStart", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "indices", "getLastIndex", "(Ljava/lang/CharSequence;)I", "lastIndex"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
public class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    private static final String orEmpty(String str) {
        return str == null ? "" : str;
    }

    public static final CharSequence trim(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(function1, "");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean booleanValue = function1.invoke(Character.valueOf(charSequence.charAt(!z ? i : length))).booleanValue();
            if (z) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final String trim(String str, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function1, "");
        String str2 = str;
        int length = str2.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean booleanValue = function1.invoke(Character.valueOf(str2.charAt(!z ? i : length))).booleanValue();
            if (z) {
                if (!booleanValue) {
                    break;
                }
                length--;
            } else if (booleanValue) {
                i++;
            } else {
                z = true;
            }
        }
        return str2.subSequence(i, length + 1).toString();
    }

    public static final CharSequence trimStart(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(function1, "");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!function1.invoke(Character.valueOf(charSequence.charAt(i))).booleanValue()) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    public static final String trimStart(String str, Function1<? super Character, Boolean> function1) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function1, "");
        String str3 = str;
        int length = str3.length();
        int i = 0;
        while (true) {
            if (i < length) {
                if (!function1.invoke(Character.valueOf(str3.charAt(i))).booleanValue()) {
                    str2 = str3.subSequence(i, str3.length());
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return str2.toString();
    }

    public static final CharSequence trimEnd(CharSequence charSequence, Function1<? super Character, Boolean> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(function1, "");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!function1.invoke(Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return "";
    }

    public static final String trimEnd(String str, Function1<? super Character, Boolean> function1) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function1, "");
        String str3 = str;
        int length = str3.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!function1.invoke(Character.valueOf(str3.charAt(length))).booleanValue()) {
                    str2 = str3.subSequence(0, length + 1);
                    break;
                } else if (i < 0) {
                    break;
                } else {
                    length = i;
                }
            }
            return str2.toString();
        }
        return str2.toString();
    }

    private static final String trim(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return StringsKt.trim((CharSequence) str).toString();
    }

    private static final String trimStart(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return StringsKt.trimStart((CharSequence) str).toString();
    }

    private static final String trimEnd(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return StringsKt.trimEnd((CharSequence) str).toString();
    }

    public static /* synthetic */ CharSequence padStart$default(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = InputCardNumberView.DIVIDER;
        }
        return StringsKt.padStart(charSequence, i, c);
    }

    public static final CharSequence padStart(CharSequence charSequence, int i, char c) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Desired length ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString());
        } else if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb2 = new StringBuilder(i);
            int length = i - charSequence.length();
            if (length > 0) {
                int i2 = 1;
                while (true) {
                    sb2.append(c);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sb2.append(charSequence);
            return sb2;
        }
    }

    public static /* synthetic */ String padStart$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = InputCardNumberView.DIVIDER;
        }
        return StringsKt.padStart(str, i, c);
    }

    public static final String padStart(String str, int i, char c) {
        Intrinsics.checkNotNullParameter(str, "");
        return StringsKt.padStart((CharSequence) str, i, c).toString();
    }

    public static /* synthetic */ CharSequence padEnd$default(CharSequence charSequence, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = InputCardNumberView.DIVIDER;
        }
        return StringsKt.padEnd(charSequence, i, c);
    }

    public static final CharSequence padEnd(CharSequence charSequence, int i, char c) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        if (i < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Desired length ");
            sb.append(i);
            sb.append(" is less than zero.");
            throw new IllegalArgumentException(sb.toString());
        } else if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb2 = new StringBuilder(i);
            sb2.append(charSequence);
            int length = i - charSequence.length();
            if (length > 0) {
                int i2 = 1;
                while (true) {
                    sb2.append(c);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            return sb2;
        }
    }

    public static /* synthetic */ String padEnd$default(String str, int i, char c, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            c = InputCardNumberView.DIVIDER;
        }
        return StringsKt.padEnd(str, i, c);
    }

    public static final String padEnd(String str, int i, char c) {
        Intrinsics.checkNotNullParameter(str, "");
        return StringsKt.padEnd((CharSequence) str, i, c).toString();
    }

    private static final boolean isNullOrEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    private static final boolean isEmpty(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        return charSequence.length() == 0;
    }

    private static final boolean isNotEmpty(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        return charSequence.length() > 0;
    }

    private static final boolean isNotBlank(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        return !StringsKt.isBlank(charSequence);
    }

    private static final boolean isNullOrBlank(CharSequence charSequence) {
        return charSequence == null || StringsKt.isBlank(charSequence);
    }

    public static final CharIterator iterator(final CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        return new CharIterator() { // from class: kotlin.text.StringsKt__StringsKt$iterator$1
            private int index;

            @Override // kotlin.collections.CharIterator
            public final char nextChar() {
                CharSequence charSequence2 = charSequence;
                int i = this.index;
                this.index = i + 1;
                return charSequence2.charAt(i);
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.index < charSequence.length();
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <C extends CharSequence & R, R> R ifEmpty(C c, Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        return c.length() == 0 ? function0.invoke() : c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <C extends CharSequence & R, R> R ifBlank(C c, Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        return StringsKt.isBlank(c) ? function0.invoke() : c;
    }

    @JvmName(name = "getIndices")
    public static final IntRange getIndices(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        return new IntRange(0, charSequence.length() - 1);
    }

    @JvmName(name = "getLastIndex")
    public static final int getLastIndex(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        return charSequence.length() - 1;
    }

    public static final boolean hasSurrogatePairAt(CharSequence charSequence, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        return (i >= 0 && i <= charSequence.length() + (-2)) && Character.isHighSurrogate(charSequence.charAt(i)) && Character.isLowSurrogate(charSequence.charAt(i + 1));
    }

    public static final String substring(String str, IntRange intRange) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(intRange, "");
        String substring = str.substring(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        return substring;
    }

    public static final CharSequence subSequence(CharSequence charSequence, IntRange intRange) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(intRange, "");
        return charSequence.subSequence(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    @Deprecated(message = "Use parameters named startIndex and endIndex.", replaceWith = @ReplaceWith(expression = "subSequence(startIndex = start, endIndex = end)", imports = {}))
    private static final CharSequence subSequence(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "");
        return str.subSequence(i, i2);
    }

    private static final String substring(CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        return charSequence.subSequence(i, i2).toString();
    }

    static /* synthetic */ String substring$default(CharSequence charSequence, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = charSequence.length();
        }
        Intrinsics.checkNotNullParameter(charSequence, "");
        return charSequence.subSequence(i, i2).toString();
    }

    public static final String substring(CharSequence charSequence, IntRange intRange) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(intRange, "");
        return charSequence.subSequence(intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1).toString();
    }

    public static /* synthetic */ String substringBefore$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringBefore(str, c, str2);
    }

    public static final String substringBefore(String str, char c, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            String substring = str.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            return substring;
        }
        return str2;
    }

    public static /* synthetic */ String substringBefore$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringBefore(str, str2, str3);
    }

    public static final String substringBefore(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            String substring = str.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            return substring;
        }
        return str3;
    }

    public static /* synthetic */ String substringAfter$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringAfter(str, c, str2);
    }

    public static final String substringAfter(String str, char c, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            String substring = str.substring(indexOf$default + 1, str.length());
            Intrinsics.checkNotNullExpressionValue(substring, "");
            return substring;
        }
        return str2;
    }

    public static /* synthetic */ String substringAfter$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringAfter(str, str2, str3);
    }

    public static final String substringAfter(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (indexOf$default != -1) {
            String substring = str.substring(indexOf$default + str2.length(), str.length());
            Intrinsics.checkNotNullExpressionValue(substring, "");
            return substring;
        }
        return str3;
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringBeforeLast(str, c, str2);
    }

    public static final String substringBeforeLast(String str, char c, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (lastIndexOf$default != -1) {
            String substring = str.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            return substring;
        }
        return str2;
    }

    public static /* synthetic */ String substringBeforeLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringBeforeLast(str, str2, str3);
    }

    public static final String substringBeforeLast(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (lastIndexOf$default != -1) {
            String substring = str.substring(0, lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            return substring;
        }
        return str3;
    }

    public static /* synthetic */ String substringAfterLast$default(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.substringAfterLast(str, c, str2);
    }

    public static final String substringAfterLast(String str, char c, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, c, 0, false, 6, (Object) null);
        if (lastIndexOf$default != -1) {
            String substring = str.substring(lastIndexOf$default + 1, str.length());
            Intrinsics.checkNotNullExpressionValue(substring, "");
            return substring;
        }
        return str2;
    }

    public static /* synthetic */ String substringAfterLast$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.substringAfterLast(str, str2, str3);
    }

    public static final String substringAfterLast(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (lastIndexOf$default != -1) {
            String substring = str.substring(lastIndexOf$default + str2.length(), str.length());
            Intrinsics.checkNotNullExpressionValue(substring, "");
            return substring;
        }
        return str3;
    }

    public static final CharSequence replaceRange(CharSequence charSequence, int i, int i2, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(charSequence2, "");
        if (i2 < i) {
            StringBuilder sb = new StringBuilder();
            sb.append("End index (");
            sb.append(i2);
            sb.append(") is less than start index (");
            sb.append(i);
            sb.append(").");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(charSequence, 0, i);
        Intrinsics.checkNotNullExpressionValue(sb2, "");
        sb2.append(charSequence2);
        sb2.append(charSequence, i2, charSequence.length());
        Intrinsics.checkNotNullExpressionValue(sb2, "");
        return sb2;
    }

    private static final String replaceRange(String str, int i, int i2, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        return StringsKt.replaceRange((CharSequence) str, i, i2, charSequence).toString();
    }

    public static final CharSequence replaceRange(CharSequence charSequence, IntRange intRange, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(intRange, "");
        Intrinsics.checkNotNullParameter(charSequence2, "");
        return StringsKt.replaceRange(charSequence, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1, charSequence2);
    }

    private static final String replaceRange(String str, IntRange intRange, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(intRange, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        return StringsKt.replaceRange((CharSequence) str, intRange, charSequence).toString();
    }

    public static final CharSequence removeRange(CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        if (i2 < i) {
            StringBuilder sb = new StringBuilder();
            sb.append("End index (");
            sb.append(i2);
            sb.append(") is less than start index (");
            sb.append(i);
            sb.append(").");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 == i) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb2 = new StringBuilder(charSequence.length() - (i2 - i));
            sb2.append(charSequence, 0, i);
            Intrinsics.checkNotNullExpressionValue(sb2, "");
            sb2.append(charSequence, i2, charSequence.length());
            Intrinsics.checkNotNullExpressionValue(sb2, "");
            return sb2;
        }
    }

    private static final String removeRange(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "");
        return StringsKt.removeRange((CharSequence) str, i, i2).toString();
    }

    public static final CharSequence removeRange(CharSequence charSequence, IntRange intRange) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(intRange, "");
        return StringsKt.removeRange(charSequence, intRange.getStart().intValue(), intRange.getEndInclusive().intValue() + 1);
    }

    private static final String removeRange(String str, IntRange intRange) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(intRange, "");
        return StringsKt.removeRange((CharSequence) str, intRange).toString();
    }

    public static final CharSequence removePrefix(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(charSequence2, "");
        if (StringsKt.startsWith$default(charSequence, charSequence2, false, 2, (Object) null)) {
            return charSequence.subSequence(charSequence2.length(), charSequence.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static final String removePrefix(String str, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        if (StringsKt.startsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            String substring = str.substring(charSequence.length());
            Intrinsics.checkNotNullExpressionValue(substring, "");
            return substring;
        }
        return str;
    }

    public static final CharSequence removeSuffix(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(charSequence2, "");
        if (StringsKt.endsWith$default(charSequence, charSequence2, false, 2, (Object) null)) {
            return charSequence.subSequence(0, charSequence.length() - charSequence2.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static final String removeSuffix(String str, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        if (StringsKt.endsWith$default((CharSequence) str, charSequence, false, 2, (Object) null)) {
            String substring = str.substring(0, str.length() - charSequence.length());
            Intrinsics.checkNotNullExpressionValue(substring, "");
            return substring;
        }
        return str;
    }

    public static final CharSequence removeSurrounding(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(charSequence2, "");
        Intrinsics.checkNotNullParameter(charSequence3, "");
        if (charSequence.length() >= charSequence2.length() + charSequence3.length() && StringsKt.startsWith$default(charSequence, charSequence2, false, 2, (Object) null) && StringsKt.endsWith$default(charSequence, charSequence3, false, 2, (Object) null)) {
            return charSequence.subSequence(charSequence2.length(), charSequence.length() - charSequence3.length());
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    public static final String removeSurrounding(String str, CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(charSequence2, "");
        if (str.length() >= charSequence.length() + charSequence2.length()) {
            String str2 = str;
            if (StringsKt.startsWith$default((CharSequence) str2, charSequence, false, 2, (Object) null) && StringsKt.endsWith$default((CharSequence) str2, charSequence2, false, 2, (Object) null)) {
                String substring = str.substring(charSequence.length(), str.length() - charSequence2.length());
                Intrinsics.checkNotNullExpressionValue(substring, "");
                return substring;
            }
            return str;
        }
        return str;
    }

    public static final CharSequence removeSurrounding(CharSequence charSequence, CharSequence charSequence2) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(charSequence2, "");
        return StringsKt.removeSurrounding(charSequence, charSequence2, charSequence2);
    }

    public static final String removeSurrounding(String str, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        return StringsKt.removeSurrounding(str, charSequence, charSequence);
    }

    public static /* synthetic */ String replaceBefore$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return StringsKt.replaceBefore(str, c, str2, str3);
    }

    public static final String replaceBefore(String str, char c, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        String str4 = str;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str4, c, 0, false, 6, (Object) null);
        return indexOf$default != -1 ? StringsKt.replaceRange((CharSequence) str4, 0, indexOf$default, (CharSequence) str2).toString() : str3;
    }

    public static /* synthetic */ String replaceBefore$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return StringsKt.replaceBefore(str, str2, str3, str4);
    }

    public static final String replaceBefore(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        String str5 = str;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str5, str2, 0, false, 6, (Object) null);
        return indexOf$default != -1 ? StringsKt.replaceRange((CharSequence) str5, 0, indexOf$default, (CharSequence) str3).toString() : str4;
    }

    public static /* synthetic */ String replaceAfter$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return StringsKt.replaceAfter(str, c, str2, str3);
    }

    public static final String replaceAfter(String str, char c, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        String str4 = str;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str4, c, 0, false, 6, (Object) null);
        return indexOf$default != -1 ? StringsKt.replaceRange((CharSequence) str4, indexOf$default + 1, str.length(), (CharSequence) str2).toString() : str3;
    }

    public static /* synthetic */ String replaceAfter$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return StringsKt.replaceAfter(str, str2, str3, str4);
    }

    public static final String replaceAfter(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        String str5 = str;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str5, str2, 0, false, 6, (Object) null);
        return indexOf$default != -1 ? StringsKt.replaceRange((CharSequence) str5, indexOf$default + str2.length(), str.length(), (CharSequence) str3).toString() : str4;
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return StringsKt.replaceAfterLast(str, str2, str3, str4);
    }

    public static final String replaceAfterLast(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        String str5 = str;
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str5, str2, 0, false, 6, (Object) null);
        return lastIndexOf$default != -1 ? StringsKt.replaceRange((CharSequence) str5, lastIndexOf$default + str2.length(), str.length(), (CharSequence) str3).toString() : str4;
    }

    public static /* synthetic */ String replaceAfterLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return StringsKt.replaceAfterLast(str, c, str2, str3);
    }

    public static final String replaceAfterLast(String str, char c, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        String str4 = str;
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str4, c, 0, false, 6, (Object) null);
        return lastIndexOf$default != -1 ? StringsKt.replaceRange((CharSequence) str4, lastIndexOf$default + 1, str.length(), (CharSequence) str2).toString() : str3;
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, char c, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = str;
        }
        return StringsKt.replaceBeforeLast(str, c, str2, str3);
    }

    public static final String replaceBeforeLast(String str, char c, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        String str4 = str;
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str4, c, 0, false, 6, (Object) null);
        return lastIndexOf$default != -1 ? StringsKt.replaceRange((CharSequence) str4, 0, lastIndexOf$default, (CharSequence) str2).toString() : str3;
    }

    public static /* synthetic */ String replaceBeforeLast$default(String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str4 = str;
        }
        return StringsKt.replaceBeforeLast(str, str2, str3, str4);
    }

    public static final String replaceBeforeLast(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        String str5 = str;
        int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) str5, str2, 0, false, 6, (Object) null);
        return lastIndexOf$default != -1 ? StringsKt.replaceRange((CharSequence) str5, 0, lastIndexOf$default, (CharSequence) str3).toString() : str4;
    }

    private static final String replace(CharSequence charSequence, Regex regex, String str) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(regex, "");
        Intrinsics.checkNotNullParameter(str, "");
        return regex.replace(charSequence, str);
    }

    private static final String replace(CharSequence charSequence, Regex regex, Function1<? super MatchResult, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(regex, "");
        Intrinsics.checkNotNullParameter(function1, "");
        return regex.replace(charSequence, function1);
    }

    private static final String replaceFirst(CharSequence charSequence, Regex regex, String str) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(regex, "");
        Intrinsics.checkNotNullParameter(str, "");
        return regex.replaceFirst(charSequence, str);
    }

    private static final String replaceFirstCharWithChar(String str, Function1<? super Character, Character> function1) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function1, "");
        if (str.length() > 0) {
            char charValue = function1.invoke(Character.valueOf(str.charAt(0))).charValue();
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            StringBuilder sb = new StringBuilder();
            sb.append(charValue);
            sb.append(substring);
            return sb.toString();
        }
        return str;
    }

    private static final String replaceFirstCharWithCharSequence(String str, Function1<? super Character, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(function1, "");
        if (str.length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append((Object) function1.invoke(Character.valueOf(str.charAt(0))));
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            sb.append(substring);
            return sb.toString();
        }
        return str;
    }

    private static final boolean matches(CharSequence charSequence, Regex regex) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(regex, "");
        return regex.matches(charSequence);
    }

    public static final boolean regionMatchesImpl(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(charSequence2, "");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!CharsKt.equals(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.startsWith(charSequence, c, z);
    }

    public static final boolean startsWith(CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        return charSequence.length() > 0 && CharsKt.equals(charSequence.charAt(0), c, z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.endsWith(charSequence, c, z);
    }

    public static final boolean endsWith(CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        return charSequence.length() > 0 && CharsKt.equals(charSequence.charAt(StringsKt.getLastIndex(charSequence)), c, z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.startsWith(charSequence, charSequence2, z);
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(charSequence2, "");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt.startsWith$default((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return StringsKt.regionMatchesImpl(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean startsWith$default(CharSequence charSequence, CharSequence charSequence2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.startsWith(charSequence, charSequence2, i, z);
    }

    public static final boolean startsWith(CharSequence charSequence, CharSequence charSequence2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(charSequence2, "");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt.startsWith$default((String) charSequence, (String) charSequence2, i, false, 4, (Object) null);
        }
        return StringsKt.regionMatchesImpl(charSequence, i, charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ boolean endsWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.endsWith(charSequence, charSequence2, z);
    }

    public static final boolean endsWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(charSequence2, "");
        if (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt.endsWith$default((String) charSequence, (String) charSequence2, false, 2, (Object) null);
        }
        return StringsKt.regionMatchesImpl(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    public static /* synthetic */ String commonPrefixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.commonPrefixWith(charSequence, charSequence2, z);
    }

    public static final String commonPrefixWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(charSequence2, "");
        int min = Math.min(charSequence.length(), charSequence2.length());
        int i = 0;
        while (i < min && CharsKt.equals(charSequence.charAt(i), charSequence2.charAt(i), z)) {
            i++;
        }
        int i2 = i - 1;
        if (StringsKt.hasSurrogatePairAt(charSequence, i2) || StringsKt.hasSurrogatePairAt(charSequence2, i2)) {
            i = i2;
        }
        return charSequence.subSequence(0, i).toString();
    }

    public static /* synthetic */ String commonSuffixWith$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.commonSuffixWith(charSequence, charSequence2, z);
    }

    public static final String commonSuffixWith(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(charSequence2, "");
        int length = charSequence.length();
        int min = Math.min(length, charSequence2.length());
        int i = 0;
        while (i < min && CharsKt.equals(charSequence.charAt((length - i) - 1), charSequence2.charAt((r1 - i) - 1), z)) {
            i++;
        }
        if (StringsKt.hasSurrogatePairAt(charSequence, (length - i) - 1) || StringsKt.hasSurrogatePairAt(charSequence2, (r1 - i) - 1)) {
            i--;
        }
        return charSequence.subSequence(length - i, length).toString();
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.indexOfAny(charSequence, cArr, i, z);
    }

    public static final int indexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(cArr, "");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(ArraysKt.single(cArr), i);
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(i, 0);
        int lastIndex = StringsKt.getLastIndex(charSequence);
        if (coerceAtLeast > lastIndex) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(coerceAtLeast);
            int length = cArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                } else if (CharsKt.equals(cArr[i2], charAt, z)) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2) {
                return coerceAtLeast;
            }
            if (coerceAtLeast == lastIndex) {
                return -1;
            }
            coerceAtLeast++;
        }
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.lastIndexOfAny(charSequence, cArr, i, z);
    }

    public static final int lastIndexOfAny(CharSequence charSequence, char[] cArr, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(cArr, "");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(ArraysKt.single(cArr), i);
        }
        for (int coerceAtMost = RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence)); coerceAtMost >= 0; coerceAtMost--) {
            char charAt = charSequence.charAt(coerceAtMost);
            int length = cArr.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (CharsKt.equals(cArr[i2], charAt, z)) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2) {
                return coerceAtMost;
            }
        }
        return -1;
    }

    static /* synthetic */ int indexOf$StringsKt__StringsKt$default(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return indexOf$StringsKt__StringsKt(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    private static final int indexOf$StringsKt__StringsKt(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        IntRange downTo;
        if (!z2) {
            downTo = new IntRange(RangesKt.coerceAtLeast(i, 0), RangesKt.coerceAtMost(i2, charSequence.length()));
        } else {
            downTo = RangesKt.downTo(RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence)), RangesKt.coerceAtLeast(i2, 0));
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int first = downTo.getFirst();
            int last = downTo.getLast();
            int step = downTo.getStep();
            if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                return -1;
            }
            while (!StringsKt.regionMatches((String) charSequence2, 0, (String) charSequence, first, charSequence2.length(), z)) {
                if (first == last) {
                    return -1;
                }
                first += step;
            }
            return first;
        }
        int first2 = downTo.getFirst();
        int last2 = downTo.getLast();
        int step2 = downTo.getStep();
        if ((step2 <= 0 || first2 > last2) && (step2 >= 0 || last2 > first2)) {
            return -1;
        }
        while (!StringsKt.regionMatchesImpl(charSequence2, 0, charSequence, first2, charSequence2.length(), z)) {
            if (first2 == last2) {
                return -1;
            }
            first2 += step2;
        }
        return first2;
    }

    public static final Pair<Integer, String> findAnyOf$StringsKt__StringsKt(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        Object obj;
        Object obj2;
        if (!z && collection.size() == 1) {
            String str = (String) CollectionsKt.single(collection);
            int indexOf$default = !z2 ? StringsKt.indexOf$default(charSequence, str, i, false, 4, (Object) null) : StringsKt.lastIndexOf$default(charSequence, str, i, false, 4, (Object) null);
            if (indexOf$default < 0) {
                return null;
            }
            return TuplesKt.to(Integer.valueOf(indexOf$default), str);
        }
        IntRange intRange = !z2 ? new IntRange(RangesKt.coerceAtLeast(i, 0), charSequence.length()) : RangesKt.downTo(RangesKt.coerceAtMost(i, StringsKt.getLastIndex(charSequence)), 0);
        if (charSequence instanceof String) {
            int first = intRange.getFirst();
            int last = intRange.getLast();
            int step = intRange.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str2 = (String) obj2;
                        if (StringsKt.regionMatches(str2, 0, (String) charSequence, first, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (first == last) {
                            break;
                        }
                        first += step;
                    } else {
                        return TuplesKt.to(Integer.valueOf(first), str3);
                    }
                }
            }
        } else {
            int first2 = intRange.getFirst();
            int last2 = intRange.getLast();
            int step2 = intRange.getStep();
            if ((step2 > 0 && first2 <= last2) || (step2 < 0 && last2 <= first2)) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str4 = (String) obj;
                        if (StringsKt.regionMatchesImpl(str4, 0, charSequence, first2, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (first2 == last2) {
                            break;
                        }
                        first2 += step2;
                    } else {
                        return TuplesKt.to(Integer.valueOf(first2), str5);
                    }
                }
            }
        }
        return null;
    }

    public static /* synthetic */ Pair findAnyOf$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.findAnyOf(charSequence, collection, i, z);
    }

    public static final Pair<Integer, String> findAnyOf(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(collection, "");
        return findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, false);
    }

    public static /* synthetic */ Pair findLastAnyOf$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.findLastAnyOf(charSequence, collection, i, z);
    }

    public static final Pair<Integer, String> findLastAnyOf(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(collection, "");
        return findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, true);
    }

    public static /* synthetic */ int indexOfAny$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.indexOfAny(charSequence, collection, i, z);
    }

    public static final int indexOfAny(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(collection, "");
        Pair<Integer, String> findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, false);
        if (findAnyOf$StringsKt__StringsKt != null) {
            return findAnyOf$StringsKt__StringsKt.getFirst().intValue();
        }
        return -1;
    }

    public static /* synthetic */ int lastIndexOfAny$default(CharSequence charSequence, Collection collection, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.lastIndexOfAny(charSequence, collection, i, z);
    }

    public static final int lastIndexOfAny(CharSequence charSequence, Collection<String> collection, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(collection, "");
        Pair<Integer, String> findAnyOf$StringsKt__StringsKt = findAnyOf$StringsKt__StringsKt(charSequence, collection, i, z, true);
        if (findAnyOf$StringsKt__StringsKt != null) {
            return findAnyOf$StringsKt__StringsKt.getFirst().intValue();
        }
        return -1;
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.indexOf(charSequence, c, i, z);
    }

    public static final int indexOf(CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        if (z || !(charSequence instanceof String)) {
            return StringsKt.indexOfAny(charSequence, new char[]{c}, i, z);
        }
        return ((String) charSequence).indexOf(c, i);
    }

    public static /* synthetic */ int indexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.indexOf(charSequence, str, i, z);
    }

    public static final int indexOf(CharSequence charSequence, String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (z || !(charSequence instanceof String)) {
            return indexOf$StringsKt__StringsKt$default(charSequence, str, i, charSequence.length(), z, false, 16, null);
        }
        return ((String) charSequence).indexOf(str, i);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.lastIndexOf(charSequence, c, i, z);
    }

    public static final int lastIndexOf(CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        if (z || !(charSequence instanceof String)) {
            return StringsKt.lastIndexOfAny(charSequence, new char[]{c}, i, z);
        }
        return ((String) charSequence).lastIndexOf(c, i);
    }

    public static /* synthetic */ int lastIndexOf$default(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.getLastIndex(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.lastIndexOf(charSequence, str, i, z);
    }

    public static final int lastIndexOf(CharSequence charSequence, String str, int i, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (z || !(charSequence instanceof String)) {
            return indexOf$StringsKt__StringsKt(charSequence, str, i, 0, z, true);
        }
        return ((String) charSequence).lastIndexOf(str, i);
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.contains(charSequence, charSequence2, z);
    }

    public static final boolean contains(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(charSequence2, "");
        if (charSequence2 instanceof String) {
            if (StringsKt.indexOf$default(charSequence, (String) charSequence2, 0, z, 2, (Object) null) >= 0) {
                return true;
            }
        } else if (indexOf$StringsKt__StringsKt$default(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean contains$default(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.contains(charSequence, c, z);
    }

    public static final boolean contains(CharSequence charSequence, char c, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        return StringsKt.indexOf$default(charSequence, c, 0, z, 2, (Object) null) >= 0;
    }

    private static final boolean contains(CharSequence charSequence, Regex regex) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(regex, "");
        return regex.containsMatchIn(charSequence);
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, cArr, i, z, i2);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, final char[] cArr, int i, final boolean z, int i2) {
        StringsKt.requireNonNegativeLimit(i2);
        return new DelimitedRangesSequence(charSequence, i, i2, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return invoke(charSequence2, num.intValue());
            }

            public final Pair<Integer, Integer> invoke(CharSequence charSequence2, int i3) {
                Intrinsics.checkNotNullParameter(charSequence2, "");
                int indexOfAny = StringsKt.indexOfAny(charSequence2, cArr, i3, z);
                if (indexOfAny < 0) {
                    return null;
                }
                return TuplesKt.to(Integer.valueOf(indexOfAny), 1);
            }
        });
    }

    static /* synthetic */ Sequence rangesDelimitedBy$StringsKt__StringsKt$default(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return rangesDelimitedBy$StringsKt__StringsKt(charSequence, strArr, i, z, i2);
    }

    private static final Sequence<IntRange> rangesDelimitedBy$StringsKt__StringsKt(CharSequence charSequence, String[] strArr, int i, final boolean z, int i2) {
        StringsKt.requireNonNegativeLimit(i2);
        final List asList = ArraysKt.asList(strArr);
        return new DelimitedRangesSequence(charSequence, i, i2, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return invoke(charSequence2, num.intValue());
            }

            public final Pair<Integer, Integer> invoke(CharSequence charSequence2, int i3) {
                Pair findAnyOf$StringsKt__StringsKt;
                Intrinsics.checkNotNullParameter(charSequence2, "");
                findAnyOf$StringsKt__StringsKt = StringsKt__StringsKt.findAnyOf$StringsKt__StringsKt(charSequence2, asList, i3, z, false);
                if (findAnyOf$StringsKt__StringsKt != null) {
                    return TuplesKt.to(findAnyOf$StringsKt__StringsKt.getFirst(), Integer.valueOf(((String) findAnyOf$StringsKt__StringsKt.getSecond()).length()));
                }
                return null;
            }
        });
    }

    public static final void requireNonNegativeLimit(int i) {
        if (i >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Limit must be non-negative, but was ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.splitToSequence(charSequence, strArr, z, i);
    }

    public static final Sequence<String> splitToSequence(final CharSequence charSequence, String[] strArr, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(strArr, "");
        return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, strArr, 0, z, i, 2, (Object) null), new Function1<IntRange, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(IntRange intRange) {
                Intrinsics.checkNotNullParameter(intRange, "");
                return StringsKt.substring(charSequence, intRange);
            }
        });
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.split(charSequence, strArr, z, i);
    }

    public static final List<String> split(CharSequence charSequence, String[] strArr, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(strArr, "");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return split$StringsKt__StringsKt(charSequence, str, z, i);
            }
        }
        Iterable asIterable = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, strArr, 0, z, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(asIterable, 10));
        Iterator it = asIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.substring(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    public static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.splitToSequence(charSequence, cArr, z, i);
    }

    public static final Sequence<String> splitToSequence(final CharSequence charSequence, char[] cArr, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(cArr, "");
        return SequencesKt.map(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, cArr, 0, z, i, 2, (Object) null), new Function1<IntRange, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(IntRange intRange) {
                Intrinsics.checkNotNullParameter(intRange, "");
                return StringsKt.substring(charSequence, intRange);
            }
        });
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.split(charSequence, cArr, z, i);
    }

    public static final List<String> split(CharSequence charSequence, char[] cArr, boolean z, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(cArr, "");
        if (cArr.length == 1) {
            return split$StringsKt__StringsKt(charSequence, String.valueOf(cArr[0]), z, i);
        }
        Iterable asIterable = SequencesKt.asIterable(rangesDelimitedBy$StringsKt__StringsKt$default(charSequence, cArr, 0, z, i, 2, (Object) null));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(asIterable, 10));
        Iterator it = asIterable.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.substring(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    private static final List<String> split$StringsKt__StringsKt(CharSequence charSequence, String str, boolean z, int i) {
        StringsKt.requireNonNegativeLimit(i);
        int i2 = 0;
        int indexOf = StringsKt.indexOf(charSequence, str, 0, z);
        if (indexOf == -1 || i == 1) {
            return CollectionsKt.listOf(charSequence.toString());
        }
        boolean z2 = i > 0;
        ArrayList arrayList = new ArrayList(z2 ? RangesKt.coerceAtMost(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(i2, indexOf).toString());
            i2 = str.length() + indexOf;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            indexOf = StringsKt.indexOf(charSequence, str, i2, z);
        } while (indexOf != -1);
        arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
        return arrayList;
    }

    private static final List<String> split(CharSequence charSequence, Regex regex, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(regex, "");
        return regex.split(charSequence, i);
    }

    static /* synthetic */ List split$default(CharSequence charSequence, Regex regex, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(regex, "");
        return regex.split(charSequence, i);
    }

    private static final Sequence<String> splitToSequence(CharSequence charSequence, Regex regex, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(regex, "");
        return regex.splitToSequence(charSequence, i);
    }

    static /* synthetic */ Sequence splitToSequence$default(CharSequence charSequence, Regex regex, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(regex, "");
        return regex.splitToSequence(charSequence, i);
    }

    public static final Sequence<String> lineSequence(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        return StringsKt.splitToSequence$default(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, (Object) null);
    }

    public static final List<String> lines(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        return SequencesKt.toList(StringsKt.lineSequence(charSequence));
    }

    public static final boolean contentEqualsIgnoreCaseImpl(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt.equals((String) charSequence, (String) charSequence2, true);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!CharsKt.equals(charSequence.charAt(i), charSequence2.charAt(i), true)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean contentEqualsImpl(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return Intrinsics.areEqual(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean toBooleanStrict(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        if (Intrinsics.areEqual(str, SummaryActivity.CHECKED)) {
            return true;
        }
        if (Intrinsics.areEqual(str, "false")) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The string doesn't represent a boolean value: ");
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    public static final Boolean toBooleanStrictOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        if (Intrinsics.areEqual(str, SummaryActivity.CHECKED)) {
            return Boolean.TRUE;
        }
        if (Intrinsics.areEqual(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static final CharSequence trim(CharSequence charSequence, char... cArr) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(cArr, "");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean contains = ArraysKt.contains(cArr, charSequence.charAt(!z ? i : length));
            if (z) {
                if (!contains) {
                    break;
                }
                length--;
            } else if (contains) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final String trim(String str, char... cArr) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(cArr, "");
        String str2 = str;
        int length = str2.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean contains = ArraysKt.contains(cArr, str2.charAt(!z ? i : length));
            if (z) {
                if (!contains) {
                    break;
                }
                length--;
            } else if (contains) {
                i++;
            } else {
                z = true;
            }
        }
        return str2.subSequence(i, length + 1).toString();
    }

    public static final CharSequence trimStart(CharSequence charSequence, char... cArr) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(cArr, "");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!ArraysKt.contains(cArr, charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    public static final String trimStart(String str, char... cArr) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(cArr, "");
        String str3 = str;
        int length = str3.length();
        int i = 0;
        while (true) {
            if (i < length) {
                if (!ArraysKt.contains(cArr, str3.charAt(i))) {
                    str2 = str3.subSequence(i, str3.length());
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return str2.toString();
    }

    public static final CharSequence trimEnd(CharSequence charSequence, char... cArr) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(cArr, "");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!ArraysKt.contains(cArr, charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return "";
    }

    public static final String trimEnd(String str, char... cArr) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(cArr, "");
        String str3 = str;
        int length = str3.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!ArraysKt.contains(cArr, str3.charAt(length))) {
                    str2 = str3.subSequence(0, length + 1);
                    break;
                } else if (i < 0) {
                    break;
                } else {
                    length = i;
                }
            }
            return str2.toString();
        }
        return str2.toString();
    }

    public static final CharSequence trim(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean isWhitespace = CharsKt.isWhitespace(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!isWhitespace) {
                    break;
                }
                length--;
            } else if (isWhitespace) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final CharSequence trimStart(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!CharsKt.isWhitespace(charSequence.charAt(i))) {
                return charSequence.subSequence(i, charSequence.length());
            }
        }
        return "";
    }

    public static final CharSequence trimEnd(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i = length - 1;
                if (!CharsKt.isWhitespace(charSequence.charAt(length))) {
                    return charSequence.subSequence(0, length + 1);
                }
                if (i < 0) {
                    break;
                }
                length = i;
            }
        }
        return "";
    }
}
