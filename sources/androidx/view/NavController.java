package androidx.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.os.BundleKt;
import androidx.view.Lifecycle;
import androidx.view.LifecycleEventObserver;
import androidx.view.LifecycleObserver;
import androidx.view.LifecycleOwner;
import androidx.view.NavBackStackEntry;
import androidx.view.NavControllerViewModel;
import androidx.view.NavDeepLinkBuilder;
import androidx.view.NavDestination;
import androidx.view.NavGraph;
import androidx.view.Navigator;
import androidx.view.NavigatorProvider;
import androidx.view.OnBackPressedCallback;
import androidx.view.OnBackPressedDispatcher;
import androidx.view.ViewModelStore;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000Æ\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 Å\u00012\u00020\u0001:\u0006Å\u0001Æ\u0001Ç\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J2\u0010p\u001a\u00020\u00162\u0006\u0010q\u001a\u0002022\b\u0010r\u001a\u0004\u0018\u00010\\2\u0006\u0010\u0015\u001a\u00020\u00072\u000e\b\u0002\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0002J\u0010\u0010t\u001a\u00020\u00162\u0006\u0010u\u001a\u00020cH\u0016J\u0012\u0010v\u001a\u0002062\b\b\u0001\u0010w\u001a\u00020\u001fH\u0007J\u0010\u0010v\u001a\u0002062\u0006\u0010x\u001a\u00020 H\u0007J\u0012\u0010y\u001a\u0002062\b\b\u0001\u0010w\u001a\u00020\u001fH\u0003J\b\u0010z\u001a\u00020{H\u0016J\b\u0010|\u001a\u000206H\u0002J\u0010\u0010}\u001a\u00020\u00162\u0006\u0010~\u001a\u000206H\u0017J\u0014\u0010\u007f\u001a\u0004\u0018\u0001022\b\b\u0001\u0010w\u001a\u00020\u001fH\u0007J\u0013\u0010\u007f\u001a\u0004\u0018\u0001022\u0007\u0010\u0080\u0001\u001a\u00020 H\u0007J\u0015\u0010\u0081\u0001\u001a\u0004\u0018\u00010 2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0002J\u0013\u0010\u0084\u0001\u001a\u00020\u00072\b\b\u0001\u0010w\u001a\u00020\u001fH\u0016J\u000f\u0010\u0084\u0001\u001a\u00020\u00072\u0006\u0010x\u001a\u00020 J\u0015\u0010\u0085\u0001\u001a\u00030\u0086\u00012\t\b\u0001\u0010\u0087\u0001\u001a\u00020\u001fH\u0016J\u0015\u0010\u0088\u0001\u001a\u0002062\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001H\u0017J \u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u000f\u0010\u008c\u0001\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0018H\u0002J\u001b\u0010\u008d\u0001\u001a\u00020\u00162\u0007\u0010\u008e\u0001\u001a\u00020\u00072\u0007\u0010\u008f\u0001\u001a\u00020\u0007H\u0002J\u0013\u0010\u0090\u0001\u001a\u00020\u00162\b\u0010\u0082\u0001\u001a\u00030\u0091\u0001H\u0017J\u001f\u0010\u0090\u0001\u001a\u00020\u00162\b\u0010\u0082\u0001\u001a\u00030\u0091\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0017J+\u0010\u0090\u0001\u001a\u00020\u00162\b\u0010\u0082\u0001\u001a\u00030\u0091\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0017J\u0013\u0010\u0090\u0001\u001a\u00020\u00162\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0017J\u001f\u0010\u0090\u0001\u001a\u00020\u00162\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0017J+\u0010\u0090\u0001\u001a\u00020\u00162\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0017J4\u0010\u0090\u0001\u001a\u00020\u00162\u0006\u0010q\u001a\u0002022\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\\2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0003J\u0013\u0010\u0090\u0001\u001a\u00020\u00162\b\u0010\u0099\u0001\u001a\u00030\u009a\u0001H\u0017J\u001f\u0010\u0090\u0001\u001a\u00020\u00162\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0017J\u001d\u0010\u0090\u0001\u001a\u00020\u00162\b\u0010\u0099\u0001\u001a\u00030\u009a\u00012\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0017J\u0014\u0010\u0090\u0001\u001a\u00020\u00162\t\b\u0001\u0010\u009b\u0001\u001a\u00020\u001fH\u0017J\u001f\u0010\u0090\u0001\u001a\u00020\u00162\t\b\u0001\u0010\u009b\u0001\u001a\u00020\u001f2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\\H\u0017J+\u0010\u0090\u0001\u001a\u00020\u00162\t\b\u0001\u0010\u009b\u0001\u001a\u00020\u001f2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\\2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0017J7\u0010\u0090\u0001\u001a\u00020\u00162\t\b\u0001\u0010\u009b\u0001\u001a\u00020\u001f2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\\2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0017J-\u0010\u0090\u0001\u001a\u00020\u00162\u0006\u0010x\u001a\u00020 2\f\b\u0002\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\f\b\u0002\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0007J+\u0010\u0090\u0001\u001a\u00020\u00162\u0006\u0010x\u001a\u00020 2\u001a\u0010\u009c\u0001\u001a\u0015\u0012\u0005\u0012\u00030\u009d\u0001\u0012\u0004\u0012\u00020\u00160\u0012¢\u0006\u0003\b\u009e\u0001J\t\u0010\u009f\u0001\u001a\u000206H\u0017J\u0014\u0010 \u0001\u001a\u00020\u00162\t\u0010¡\u0001\u001a\u0004\u0018\u00010\\H\u0003J\t\u0010¢\u0001\u001a\u000206H\u0017J\u001c\u0010¢\u0001\u001a\u0002062\b\b\u0001\u0010w\u001a\u00020\u001f2\u0007\u0010£\u0001\u001a\u000206H\u0017J%\u0010¢\u0001\u001a\u0002062\b\b\u0001\u0010w\u001a\u00020\u001f2\u0007\u0010£\u0001\u001a\u0002062\u0007\u0010¤\u0001\u001a\u000206H\u0017J%\u0010¢\u0001\u001a\u0002062\u0006\u0010x\u001a\u00020 2\u0007\u0010£\u0001\u001a\u0002062\t\b\u0002\u0010¤\u0001\u001a\u000206H\u0007J'\u0010¥\u0001\u001a\u00020\u00162\u0006\u0010g\u001a\u00020\u00072\u000e\u0010¦\u0001\u001a\t\u0012\u0004\u0012\u00020\u00160§\u0001H\u0000¢\u0006\u0003\b¨\u0001J'\u0010©\u0001\u001a\u0002062\b\b\u0001\u0010w\u001a\u00020\u001f2\u0007\u0010£\u0001\u001a\u0002062\t\b\u0002\u0010¤\u0001\u001a\u000206H\u0003J-\u0010ª\u0001\u001a\u00020\u00162\u0006\u0010g\u001a\u00020\u00072\t\b\u0002\u0010¤\u0001\u001a\u0002062\u000f\b\u0002\u0010«\u0001\u001a\b\u0012\u0004\u0012\u00020\"0\u0018H\u0002J\u0015\u0010¬\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0000¢\u0006\u0003\b\u00ad\u0001J\u0011\u0010®\u0001\u001a\u00020\u00162\u0006\u0010u\u001a\u00020cH\u0016J\u0014\u0010¯\u0001\u001a\u00020\u00162\t\u0010°\u0001\u001a\u0004\u0018\u00010\\H\u0017J5\u0010±\u0001\u001a\u0002062\u0007\u0010²\u0001\u001a\u00020\u001f2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\\2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001H\u0002J\u000b\u0010¤\u0001\u001a\u0004\u0018\u00010\\H\u0017J\u001b\u0010@\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\t2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\\H\u0017J\u0013\u0010@\u001a\u00020\u00162\t\b\u0001\u0010³\u0001\u001a\u00020\u001fH\u0017J\u001e\u0010@\u001a\u00020\u00162\t\b\u0001\u0010³\u0001\u001a\u00020\u001f2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\\H\u0017J\u0012\u0010´\u0001\u001a\u00020\u00162\u0007\u0010µ\u0001\u001a\u00020MH\u0017J\u0012\u0010¶\u0001\u001a\u00020\u00162\u0007\u0010·\u0001\u001a\u00020`H\u0017J\u0013\u0010¸\u0001\u001a\u00020\u00162\b\u0010¹\u0001\u001a\u00030º\u0001H\u0017J\t\u0010»\u0001\u001a\u000206H\u0002J\t\u0010¼\u0001\u001a\u000206H\u0002J\u001a\u0010½\u0001\u001a\u0004\u0018\u00010\u00072\u0007\u0010\u008e\u0001\u001a\u00020\u0007H\u0000¢\u0006\u0003\b¾\u0001J\u000f\u0010¿\u0001\u001a\u00020\u0016H\u0000¢\u0006\u0003\bÀ\u0001J\t\u0010Á\u0001\u001a\u00020\u0016H\u0002J\u0018\u0010\u007f\u001a\u0004\u0018\u000102*\u0002022\b\b\u0001\u0010w\u001a\u00020\u001fH\u0002Jb\u0010Â\u0001\u001a\u00020\u0016*\n\u0012\u0006\b\u0001\u0012\u0002020Y2\r\u0010Ã\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u00012\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u00012$\b\u0002\u0010Ä\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0012H\u0002JL\u0010©\u0001\u001a\u00020\u0016*\n\u0012\u0006\b\u0001\u0012\u0002020Y2\u0006\u0010g\u001a\u00020\u00072\u0007\u0010¤\u0001\u001a\u0002062$\b\u0002\u0010Ä\u0001\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(g\u0012\u0004\u0012\u00020\u00160\u0012H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00188WX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010 0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010!\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00180\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0016\u0010*\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0016\u00101\u001a\u0004\u0018\u0001028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u000e\u0010:\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002060\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010=\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t8W@WX\u0096\u000e¢\u0006\f\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010B\u001a\u00020C8@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010N\u001a\u00020I8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bO\u0010PR$\u0010S\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u000b8V@WX\u0096\u000e¢\u0006\f\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR&\u0010X\u001a\u001a\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u0002020Y\u0012\b\u0012\u00060ZR\u00020\u00000\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020^X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010`X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010a\u001a\b\u0012\u0004\u0012\u00020c0bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010d\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020e0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010f\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(g\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010h\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bi\u0010,R\u0010\u0010j\u001a\u0004\u0018\u00010kX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010l\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0m¢\u0006\b\n\u0000\u001a\u0004\bn\u0010o¨\u0006È\u0001"}, d2 = {"Landroidx/navigation/NavController;", "", HummerConstants.CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "_currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Landroidx/navigation/NavBackStackEntry;", "_graph", "Landroidx/navigation/NavGraph;", "_navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "_visibleEntries", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", AkuEventParamsKey.KEY_ACTIVITY, "Landroid/app/Activity;", "addToBackStackHandler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "backStackEntry", "", "backQueue", "Lkotlin/collections/ArrayDeque;", "getBackQueue", "()Lkotlin/collections/ArrayDeque;", "backStackEntriesToDispatch", "", "backStackMap", "", "", "", "backStackStates", "Landroidx/navigation/NavBackStackEntryState;", "backStackToRestore", "", "Landroid/os/Parcelable;", "[Landroid/os/Parcelable;", "childToParentEntries", "getContext", "()Landroid/content/Context;", "currentBackStackEntry", "getCurrentBackStackEntry", "()Landroidx/navigation/NavBackStackEntry;", "currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/Flow;", "getCurrentBackStackEntryFlow", "()Lkotlinx/coroutines/flow/Flow;", "currentDestination", "Landroidx/navigation/NavDestination;", "getCurrentDestination", "()Landroidx/navigation/NavDestination;", "deepLinkHandled", "", "destinationCountOnBackStack", "getDestinationCountOnBackStack", "()I", "dispatchReentrantCount", "enableOnBackPressedCallback", "entrySavedState", "graph", "getGraph", "()Landroidx/navigation/NavGraph;", "setGraph", "(Landroidx/navigation/NavGraph;)V", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "getHostLifecycleState$navigation_runtime_release", "()Landroidx/lifecycle/Lifecycle$State;", "setHostLifecycleState$navigation_runtime_release", "(Landroidx/lifecycle/Lifecycle$State;)V", "inflater", "Landroidx/navigation/NavInflater;", "lifecycleObserver", "Landroidx/lifecycle/LifecycleObserver;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "navInflater", "getNavInflater", "()Landroidx/navigation/NavInflater;", "navInflater$delegate", "Lkotlin/Lazy;", "navigatorProvider", "getNavigatorProvider", "()Landroidx/navigation/NavigatorProvider;", "setNavigatorProvider", "(Landroidx/navigation/NavigatorProvider;)V", "navigatorState", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavController$NavControllerNavigatorState;", "navigatorStateToRestore", "Landroid/os/Bundle;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "onDestinationChangedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "parentToChildCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "popFromBackStackHandler", "popUpTo", "previousBackStackEntry", "getPreviousBackStackEntry", "viewModel", "Landroidx/navigation/NavControllerViewModel;", "visibleEntries", "Lkotlinx/coroutines/flow/StateFlow;", "getVisibleEntries", "()Lkotlinx/coroutines/flow/StateFlow;", "addEntryToBackStack", "node", "finalArgs", "restoredEntries", "addOnDestinationChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "clearBackStack", "destinationId", "route", "clearBackStackInternal", "createDeepLink", "Landroidx/navigation/NavDeepLinkBuilder;", "dispatchOnDestinationChanged", "enableOnBackPressed", "enabled", "findDestination", "destinationRoute", "findInvalidDestinationDisplayNameInDeepLink", "deepLink", "", "getBackStackEntry", "getViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "navGraphId", "handleDeepLink", "intent", "Landroid/content/Intent;", "instantiateBackStack", "backStackState", "linkChildToParent", "child", "parent", "navigate", "Landroid/net/Uri;", "navOptions", "Landroidx/navigation/NavOptions;", "navigatorExtras", "Landroidx/navigation/Navigator$Extras;", "request", "Landroidx/navigation/NavDeepLinkRequest;", "args", "directions", "Landroidx/navigation/NavDirections;", "resId", "builder", "Landroidx/navigation/NavOptionsBuilder;", "Lkotlin/ExtensionFunctionType;", "navigateUp", "onGraphCreated", "startDestinationArgs", "popBackStack", "inclusive", "saveState", "popBackStackFromNavigator", "onComplete", "Lkotlin/Function0;", "popBackStackFromNavigator$navigation_runtime_release", "popBackStackInternal", "popEntryFromBackStack", "savedState", "populateVisibleEntries", "populateVisibleEntries$navigation_runtime_release", "removeOnDestinationChangedListener", "restoreState", "navState", "restoreStateInternal", "id", "graphResId", "setLifecycleOwner", "owner", "setOnBackPressedDispatcher", "dispatcher", "setViewModelStore", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "tryRelaunchUpToExplicitStack", "tryRelaunchUpToGeneratedStack", "unlinkChildFromParent", "unlinkChildFromParent$navigation_runtime_release", "updateBackStackLifecycle", "updateBackStackLifecycle$navigation_runtime_release", "updateOnBackPressedCallbackEnabled", "navigateInternal", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "handler", "Companion", "NavControllerNavigatorState", "OnDestinationChangedListener", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class NavController {
    public static final Companion BuiltInFictitiousFunctionClassFactory = new Companion(null);
    private static boolean isLayoutRequested = true;
    private NavControllerViewModel B;
    private Function1<? super NavBackStackEntry, Unit> BottomSheetCardBindingView$watcherCardNumberView$1;
    private final Map<NavBackStackEntry, AtomicInteger> C;
    LifecycleOwner DatabaseTableConfigUtil;
    private final Map<NavBackStackEntry, NavBackStackEntry> FragmentBottomSheetPaymentSettingBinding;
    Lifecycle.State GetContactSyncConfig;
    public NavigatorProvider KClassImpl$Data$declaredNonStaticMembers$2;
    public final Map<Integer, String> MyBillsEntityDataFactory;
    public final Flow<NavBackStackEntry> NetworkUserEntityData$$ExternalSyntheticLambda0;
    public Bundle NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final Lazy NetworkUserEntityData$$ExternalSyntheticLambda2;
    private final MutableStateFlow<List<NavBackStackEntry>> NetworkUserEntityData$$ExternalSyntheticLambda3;
    private Activity NetworkUserEntityData$$ExternalSyntheticLambda4;
    private final List<NavBackStackEntry> NetworkUserEntityData$$ExternalSyntheticLambda5;
    private Function1<? super NavBackStackEntry, Unit> NetworkUserEntityData$$ExternalSyntheticLambda6;
    private NavGraph NetworkUserEntityData$$ExternalSyntheticLambda7;
    public final StateFlow<List<NavBackStackEntry>> NetworkUserEntityData$$ExternalSyntheticLambda8;
    public final ArrayDeque<NavBackStackEntry> PlaceComponentResult;
    private final MutableSharedFlow<NavBackStackEntry> PrepareContext;
    private final Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> SubSequence;
    private OnBackPressedDispatcher VerifyPinStateManager$executeRiskChallenge$2$1;
    public final Map<String, ArrayDeque<NavBackStackEntryState>> getAuthRequestContext;
    private final Map<NavBackStackEntry, Boolean> getCallingPid;
    public final Context getErrorConfigVersion;
    private NavInflater getSupportButtonTintMode;
    final OnBackPressedCallback initRecordTimeStamp;
    public boolean lookAheadTest;
    boolean moveToNextValue;
    public final CopyOnWriteArrayList<OnDestinationChangedListener> newProxyInstance;
    private int readMicros;
    public Parcelable[] scheduleImpl;
    private final LifecycleObserver whenAvailable;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Landroidx/navigation/NavController$OnDestinationChangedListener;", "", "Landroidx/navigation/NavController;", "p0", "Landroidx/navigation/NavDestination;", "p1", "Landroid/os/Bundle;", "p2", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/navigation/NavController;Landroidx/navigation/NavDestination;Landroid/os/Bundle;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface OnDestinationChangedListener {
        void KClassImpl$Data$declaredNonStaticMembers$2(NavController p0, NavDestination p1, Bundle p2);
    }

    public NavController(Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "");
        this.getErrorConfigVersion = context;
        Iterator it = SequencesKt.generateSequence(context, new Function1<Context, Context>() { // from class: androidx.navigation.NavController$activity$1
            @Override // kotlin.jvm.functions.Function1
            public final Context invoke(Context context2) {
                Intrinsics.checkNotNullParameter(context2, "");
                if (context2 instanceof ContextWrapper) {
                    return ((ContextWrapper) context2).getBaseContext();
                }
                return null;
            }
        }).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (obj instanceof Activity) {
                break;
            }
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = (Activity) obj;
        this.PlaceComponentResult = new ArrayDeque<>();
        MutableStateFlow<List<NavBackStackEntry>> MutableStateFlow = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = MutableStateFlow;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = FlowKt.asStateFlow(MutableStateFlow);
        this.FragmentBottomSheetPaymentSettingBinding = new LinkedHashMap();
        this.C = new LinkedHashMap();
        this.MyBillsEntityDataFactory = new LinkedHashMap();
        this.getAuthRequestContext = new LinkedHashMap();
        this.newProxyInstance = new CopyOnWriteArrayList<>();
        this.GetContactSyncConfig = Lifecycle.State.INITIALIZED;
        this.whenAvailable = new LifecycleEventObserver() { // from class: androidx.navigation.NavController$$ExternalSyntheticLambda0
            @Override // androidx.view.LifecycleEventObserver
            public final void BuiltInFictitiousFunctionClassFactory(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                NavController.KClassImpl$Data$declaredNonStaticMembers$2(NavController.this, lifecycleOwner, event);
            }
        };
        this.initRecordTimeStamp = new OnBackPressedCallback() { // from class: androidx.navigation.NavController$onBackPressedCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(false);
            }

            @Override // androidx.view.OnBackPressedCallback
            public final void handleOnBackPressed() {
                NavController.this.moveToNextValue();
            }
        };
        this.moveToNextValue = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new NavigatorProvider();
        this.SubSequence = new LinkedHashMap();
        this.getCallingPid = new LinkedHashMap();
        NavigatorProvider navigatorProvider = this.KClassImpl$Data$declaredNonStaticMembers$2;
        NavGraphNavigator navGraphNavigator = new NavGraphNavigator(this.KClassImpl$Data$declaredNonStaticMembers$2);
        Intrinsics.checkNotNullParameter(navGraphNavigator, "");
        NavigatorProvider.Companion companion = NavigatorProvider.INSTANCE;
        navigatorProvider.getAuthRequestContext(NavigatorProvider.Companion.PlaceComponentResult((Class<? extends Navigator<?>>) navGraphNavigator.getClass()), navGraphNavigator);
        NavigatorProvider navigatorProvider2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        ActivityNavigator activityNavigator = new ActivityNavigator(this.getErrorConfigVersion);
        Intrinsics.checkNotNullParameter(activityNavigator, "");
        NavigatorProvider.Companion companion2 = NavigatorProvider.INSTANCE;
        navigatorProvider2.getAuthRequestContext(NavigatorProvider.Companion.PlaceComponentResult((Class<? extends Navigator<?>>) activityNavigator.getClass()), activityNavigator);
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = new ArrayList();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = LazyKt.lazy(new Function0<NavInflater>() { // from class: androidx.navigation.NavController$navInflater$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final NavInflater invoke() {
                NavInflater navInflater;
                navInflater = NavController.this.getSupportButtonTintMode;
                return navInflater == null ? new NavInflater(NavController.this.getErrorConfigVersion, NavController.this.KClassImpl$Data$declaredNonStaticMembers$2) : navInflater;
            }
        });
        MutableSharedFlow<NavBackStackEntry> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        this.PrepareContext = MutableSharedFlow$default;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = FlowKt.asSharedFlow(MutableSharedFlow$default);
    }

    @JvmName(name = "getGraph")
    public final NavGraph getAuthRequestContext() {
        NavGraph navGraph = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (navGraph != null) {
            if (navGraph != null) {
                return navGraph;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavGraph");
        }
        throw new IllegalStateException("You must call setGraph() before calling getGraph()".toString());
    }

    private final void BuiltInFictitiousFunctionClassFactory(NavBackStackEntry navBackStackEntry, NavBackStackEntry navBackStackEntry2) {
        this.FragmentBottomSheetPaymentSettingBinding.put(navBackStackEntry, navBackStackEntry2);
        if (this.C.get(navBackStackEntry2) == null) {
            this.C.put(navBackStackEntry2, new AtomicInteger(0));
        }
        AtomicInteger atomicInteger = this.C.get(navBackStackEntry2);
        Intrinsics.checkNotNull(atomicInteger);
        atomicInteger.incrementAndGet();
    }

    public final NavBackStackEntry MyBillsEntityDataFactory(NavBackStackEntry navBackStackEntry) {
        Intrinsics.checkNotNullParameter(navBackStackEntry, "");
        NavBackStackEntry remove = this.FragmentBottomSheetPaymentSettingBinding.remove(navBackStackEntry);
        if (remove == null) {
            return null;
        }
        AtomicInteger atomicInteger = this.C.get(remove);
        Integer valueOf = atomicInteger != null ? Integer.valueOf(atomicInteger.decrementAndGet()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            NavControllerNavigatorState navControllerNavigatorState = this.SubSequence.get(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(remove.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest));
            if (navControllerNavigatorState != null) {
                navControllerNavigatorState.BuiltInFictitiousFunctionClassFactory(remove);
            }
            this.C.remove(remove);
        }
        return remove;
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0006R\u0019\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0011X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u0012"}, d2 = {"Landroidx/navigation/NavController$NavControllerNavigatorState;", "Landroidx/navigation/NavigatorState;", "Landroidx/navigation/NavBackStackEntry;", "p0", "", "MyBillsEntityDataFactory", "(Landroidx/navigation/NavBackStackEntry;)V", "Landroidx/navigation/NavDestination;", "Landroid/os/Bundle;", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;)Landroidx/navigation/NavBackStackEntry;", "BuiltInFictitiousFunctionClassFactory", "", "PlaceComponentResult", "(Landroidx/navigation/NavBackStackEntry;Z)V", "getAuthRequestContext", "Landroidx/navigation/Navigator;", "Landroidx/navigation/Navigator;", "<init>", "(Landroidx/navigation/NavController;Landroidx/navigation/Navigator;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class NavControllerNavigatorState extends NavigatorState {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final Navigator<? extends NavDestination> KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ NavController KClassImpl$Data$declaredNonStaticMembers$2;

        public NavControllerNavigatorState(NavController navController, Navigator<? extends NavDestination> navigator) {
            Intrinsics.checkNotNullParameter(navigator, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = navController;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = navigator;
        }

        @Override // androidx.view.NavigatorState
        public final void getAuthRequestContext(NavBackStackEntry p0) {
            NavControllerNavigatorState navControllerNavigatorState = this;
            while (true) {
                Intrinsics.checkNotNullParameter(p0, "");
                Navigator PlaceComponentResult = navControllerNavigatorState.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(p0.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest);
                if (Intrinsics.areEqual(PlaceComponentResult, navControllerNavigatorState.KClassImpl$Data$declaredNonStaticMembers$2)) {
                    Function1 function1 = navControllerNavigatorState.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda6;
                    if (function1 != null) {
                        function1.invoke(p0);
                        Intrinsics.checkNotNullParameter(p0, "");
                        super.getAuthRequestContext(p0);
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Ignoring add of destination ");
                    sb.append(p0.KClassImpl$Data$declaredNonStaticMembers$2);
                    sb.append(" outside of the call to navigate(). ");
                    InstrumentInjector.log_i("NavController", sb.toString());
                    return;
                }
                Object obj = navControllerNavigatorState.KClassImpl$Data$declaredNonStaticMembers$2.SubSequence.get(PlaceComponentResult);
                if (obj == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("NavigatorBackStack for ");
                    sb2.append(p0.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest);
                    sb2.append(" should already be created");
                    throw new IllegalStateException(sb2.toString().toString());
                }
                navControllerNavigatorState = (NavControllerNavigatorState) obj;
            }
        }

        public final void MyBillsEntityDataFactory(NavBackStackEntry p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            super.getAuthRequestContext(p0);
        }

        @Override // androidx.view.NavigatorState
        public final NavBackStackEntry KClassImpl$Data$declaredNonStaticMembers$2(NavDestination p0, Bundle p1) {
            Lifecycle.State state;
            Intrinsics.checkNotNullParameter(p0, "");
            NavBackStackEntry.Companion companion = NavBackStackEntry.INSTANCE;
            Context context = this.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion;
            NavController navController = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (navController.DatabaseTableConfigUtil == null) {
                state = Lifecycle.State.CREATED;
            } else {
                state = navController.GetContactSyncConfig;
            }
            return NavBackStackEntry.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, p0, p1, state, this.KClassImpl$Data$declaredNonStaticMembers$2.B);
        }

        @Override // androidx.view.NavigatorState
        public final void PlaceComponentResult(final NavBackStackEntry p0, final boolean p1) {
            final NavControllerNavigatorState navControllerNavigatorState = this;
            while (true) {
                Intrinsics.checkNotNullParameter(p0, "");
                Navigator PlaceComponentResult = navControllerNavigatorState.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(p0.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest);
                if (Intrinsics.areEqual(PlaceComponentResult, navControllerNavigatorState.KClassImpl$Data$declaredNonStaticMembers$2)) {
                    break;
                }
                Object obj = navControllerNavigatorState.KClassImpl$Data$declaredNonStaticMembers$2.SubSequence.get(PlaceComponentResult);
                Intrinsics.checkNotNull(obj);
                navControllerNavigatorState = (NavControllerNavigatorState) obj;
            }
            Function1 function1 = navControllerNavigatorState.KClassImpl$Data$declaredNonStaticMembers$2.BottomSheetCardBindingView$watcherCardNumberView$1;
            if (function1 != null) {
                function1.invoke(p0);
                super.PlaceComponentResult(p0, p1);
                return;
            }
            NavController navController = navControllerNavigatorState.KClassImpl$Data$declaredNonStaticMembers$2;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.navigation.NavController$NavControllerNavigatorState$pop$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    super/*androidx.navigation.NavigatorState*/.PlaceComponentResult(p0, p1);
                }
            };
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(function0, "");
            int indexOf = navController.PlaceComponentResult.indexOf(p0);
            if (indexOf < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Ignoring pop of ");
                sb.append(p0);
                sb.append(" as it was not found on the current back stack");
                InstrumentInjector.log_i("NavController", sb.toString());
                return;
            }
            int i = indexOf + 1;
            if (i != navController.PlaceComponentResult.size()) {
                navController.MyBillsEntityDataFactory(navController.PlaceComponentResult.get(i).KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion, true, false);
            }
            NavController.PlaceComponentResult(navController, p0);
            function0.invoke();
            navController.initRecordTimeStamp.setEnabled(navController.moveToNextValue && navController.MyBillsEntityDataFactory() > 1);
            navController.BuiltInFictitiousFunctionClassFactory();
        }

        @Override // androidx.view.NavigatorState
        public final void BuiltInFictitiousFunctionClassFactory(NavBackStackEntry p0) {
            NavControllerViewModel navControllerViewModel;
            Intrinsics.checkNotNullParameter(p0, "");
            boolean areEqual = Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2.getCallingPid.get(p0), Boolean.TRUE);
            super.BuiltInFictitiousFunctionClassFactory(p0);
            this.KClassImpl$Data$declaredNonStaticMembers$2.getCallingPid.remove(p0);
            if (!this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult.contains(p0)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(p0);
                if (p0.getLifecycle().PlaceComponentResult().isAtLeast(Lifecycle.State.CREATED)) {
                    Lifecycle.State state = Lifecycle.State.DESTROYED;
                    Intrinsics.checkNotNullParameter(state, "");
                    p0.moveToNextValue = state;
                    p0.BuiltInFictitiousFunctionClassFactory();
                }
                ArrayDeque<NavBackStackEntry> arrayDeque = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
                boolean z = true;
                if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
                    Iterator<NavBackStackEntry> it = arrayDeque.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (Intrinsics.areEqual(it.next().getErrorConfigVersion, p0.getErrorConfigVersion)) {
                            z = false;
                            break;
                        }
                    }
                }
                if (z && !areEqual && (navControllerViewModel = this.KClassImpl$Data$declaredNonStaticMembers$2.B) != null) {
                    String str = p0.getErrorConfigVersion;
                    Intrinsics.checkNotNullParameter(str, "");
                    ViewModelStore remove = navControllerViewModel.MyBillsEntityDataFactory.remove(str);
                    if (remove != null) {
                        remove.PlaceComponentResult();
                    }
                }
                this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0();
                this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda3.tryEmit(this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest());
            } else if (getGetAuthRequestContext()) {
            } else {
                this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0();
                this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda3.tryEmit(this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest());
            }
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, boolean z) {
        return BuiltInFictitiousFunctionClassFactory(i, z);
    }

    private boolean BuiltInFictitiousFunctionClassFactory(int i, boolean z) {
        return MyBillsEntityDataFactory(i, z, false) && BuiltInFictitiousFunctionClassFactory();
    }

    static /* synthetic */ void PlaceComponentResult(NavController navController, NavBackStackEntry navBackStackEntry) {
        navController.BuiltInFictitiousFunctionClassFactory(navBackStackEntry, false, new ArrayDeque<>());
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(int i) {
        Iterator<T> it = this.SubSequence.values().iterator();
        while (it.hasNext()) {
            ((NavControllerNavigatorState) it.next()).getAuthRequestContext = true;
        }
        boolean BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(i, null, null, null);
        Iterator<T> it2 = this.SubSequence.values().iterator();
        while (it2.hasNext()) {
            ((NavControllerNavigatorState) it2.next()).getAuthRequestContext = false;
        }
        return BuiltInFictitiousFunctionClassFactory2 && MyBillsEntityDataFactory(i, true, false);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        Intent intent;
        if (MyBillsEntityDataFactory() == 1) {
            Activity activity = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            Bundle extras = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras();
            if ((extras != null ? extras.getIntArray("android-support-nav:controller:deepLinkIds") : null) != null) {
                return getErrorConfigVersion();
            }
            return scheduleImpl();
        }
        return moveToNextValue();
    }

    private final boolean getErrorConfigVersion() {
        int i = 0;
        if (this.lookAheadTest) {
            Activity activity = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
            Intrinsics.checkNotNull(activity);
            Intent intent = activity.getIntent();
            Bundle extras = intent.getExtras();
            Intrinsics.checkNotNull(extras);
            int[] intArray = extras.getIntArray("android-support-nav:controller:deepLinkIds");
            Intrinsics.checkNotNull(intArray);
            List<Integer> mutableList = ArraysKt.toMutableList(intArray);
            ArrayList parcelableArrayList = extras.getParcelableArrayList("android-support-nav:controller:deepLinkArgs");
            int intValue = ((Number) CollectionsKt.removeLast(mutableList)).intValue();
            if (parcelableArrayList != null) {
                Bundle bundle = (Bundle) CollectionsKt.removeLast(parcelableArrayList);
            }
            if (mutableList.isEmpty()) {
                return false;
            }
            NavDestination KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(getAuthRequestContext(), intValue);
            if (KClassImpl$Data$declaredNonStaticMembers$2 instanceof NavGraph) {
                NavGraph.Companion companion = NavGraph.INSTANCE;
                intValue = NavGraph.Companion.MyBillsEntityDataFactory((NavGraph) KClassImpl$Data$declaredNonStaticMembers$2).getErrorConfigVersion;
            }
            NavBackStackEntry lastOrNull = this.PlaceComponentResult.lastOrNull();
            NavDestination navDestination = lastOrNull != null ? lastOrNull.KClassImpl$Data$declaredNonStaticMembers$2 : null;
            if (navDestination != null && intValue == navDestination.getErrorConfigVersion) {
                NavDeepLinkBuilder navDeepLinkBuilder = new NavDeepLinkBuilder(this);
                Bundle PlaceComponentResult = BundleKt.PlaceComponentResult(TuplesKt.to("android-support-nav:controller:deepLinkIntent", intent));
                Bundle bundle2 = extras.getBundle("android-support-nav:controller:deepLinkExtras");
                if (bundle2 != null) {
                    PlaceComponentResult.putAll(bundle2);
                }
                navDeepLinkBuilder.BuiltInFictitiousFunctionClassFactory = PlaceComponentResult;
                navDeepLinkBuilder.KClassImpl$Data$declaredNonStaticMembers$2.putExtra("android-support-nav:controller:deepLinkExtras", PlaceComponentResult);
                for (Object obj : mutableList) {
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    navDeepLinkBuilder.getAuthRequestContext.add(new NavDeepLinkBuilder.DeepLinkDestination(((Number) obj).intValue(), parcelableArrayList != null ? (Bundle) parcelableArrayList.get(i) : null));
                    if (navDeepLinkBuilder.PlaceComponentResult != null) {
                        navDeepLinkBuilder.BuiltInFictitiousFunctionClassFactory();
                    }
                    i++;
                }
                navDeepLinkBuilder.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory();
                Activity activity2 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
                if (activity2 != null) {
                    activity2.finish();
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public final List<NavBackStackEntry> lookAheadTest() {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = this.SubSequence.values().iterator();
        while (it.hasNext()) {
            ArrayList arrayList2 = arrayList;
            Set<NavBackStackEntry> value = ((NavControllerNavigatorState) it.next()).getErrorConfigVersion.getValue();
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : value) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                if ((arrayList.contains(navBackStackEntry) || navBackStackEntry.moveToNextValue.isAtLeast(Lifecycle.State.STARTED)) ? false : true) {
                    arrayList3.add(obj);
                }
            }
            CollectionsKt.addAll(arrayList2, arrayList3);
        }
        ArrayList arrayList4 = arrayList;
        ArrayDeque<NavBackStackEntry> arrayDeque = this.PlaceComponentResult;
        ArrayList arrayList5 = new ArrayList();
        for (NavBackStackEntry navBackStackEntry2 : arrayDeque) {
            NavBackStackEntry navBackStackEntry3 = navBackStackEntry2;
            if (!arrayList.contains(navBackStackEntry3) && navBackStackEntry3.moveToNextValue.isAtLeast(Lifecycle.State.STARTED)) {
                arrayList5.add(navBackStackEntry2);
            }
        }
        CollectionsKt.addAll(arrayList4, arrayList5);
        ArrayList arrayList6 = new ArrayList();
        for (Object obj2 : arrayList) {
            if ((!(((NavBackStackEntry) obj2).KClassImpl$Data$declaredNonStaticMembers$2 instanceof NavGraph)) != false) {
                arrayList6.add(obj2);
            }
        }
        return arrayList6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:199:0x0192, code lost:
    
        if (KClassImpl$Data$declaredNonStaticMembers$2(r11.getIntent()) != false) goto L202;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void BuiltInFictitiousFunctionClassFactory(androidx.view.NavGraph r11, android.os.Bundle r12) {
        /*
            Method dump skipped, instructions count: 530
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.view.NavController.BuiltInFictitiousFunctionClassFactory(androidx.navigation.NavGraph, android.os.Bundle):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:161:0x003a, code lost:
    
        if ((r3.length == 0) != false) goto L162;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2(android.content.Intent r12) {
        /*
            Method dump skipped, instructions count: 541
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.view.NavController.KClassImpl$Data$declaredNonStaticMembers$2(android.content.Intent):boolean");
    }

    private NavDestination PlaceComponentResult(int i) {
        NavGraph navGraph;
        NavGraph navGraph2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        if (navGraph2 == null) {
            return null;
        }
        Intrinsics.checkNotNull(navGraph2);
        if (navGraph2.getErrorConfigVersion == i) {
            return this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        }
        NavBackStackEntry lastOrNull = this.PlaceComponentResult.lastOrNull();
        if (lastOrNull == null || (navGraph = lastOrNull.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
            NavGraph navGraph3 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            Intrinsics.checkNotNull(navGraph3);
            navGraph = navGraph3;
        }
        return KClassImpl$Data$declaredNonStaticMembers$2(navGraph, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0104 A[LOOP:1: B:121:0x00fe->B:123:0x0104, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void KClassImpl$Data$declaredNonStaticMembers$2(final androidx.view.NavDestination r10, android.os.Bundle r11, androidx.view.NavOptions r12) {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.view.NavController.KClassImpl$Data$declaredNonStaticMembers$2(androidx.navigation.NavDestination, android.os.Bundle, androidx.navigation.NavOptions):void");
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(int i, final Bundle bundle, NavOptions navOptions, Navigator.Extras extras) {
        NavGraph authRequestContext;
        NavBackStackEntry navBackStackEntry;
        NavDestination navDestination;
        Lifecycle.State state;
        if (this.MyBillsEntityDataFactory.containsKey(Integer.valueOf(i))) {
            final String str = this.MyBillsEntityDataFactory.get(Integer.valueOf(i));
            CollectionsKt.removeAll(this.MyBillsEntityDataFactory.values(), new Function1<String, Boolean>() { // from class: androidx.navigation.NavController$restoreStateInternal$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(String str2) {
                    return Boolean.valueOf(Intrinsics.areEqual(str2, str));
                }
            });
            ArrayDeque<NavBackStackEntryState> arrayDeque = (ArrayDeque) TypeIntrinsics.asMutableMap(this.getAuthRequestContext).remove(str);
            final ArrayList arrayList = new ArrayList();
            NavBackStackEntry lastOrNull = this.PlaceComponentResult.lastOrNull();
            if (lastOrNull == null || (authRequestContext = lastOrNull.KClassImpl$Data$declaredNonStaticMembers$2) == null) {
                authRequestContext = getAuthRequestContext();
            }
            if (arrayDeque != null) {
                for (NavBackStackEntryState navBackStackEntryState : arrayDeque) {
                    NavDestination KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext, navBackStackEntryState.BuiltInFictitiousFunctionClassFactory);
                    if (KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                        NavDestination.Companion companion = NavDestination.getAuthRequestContext;
                        String BuiltInFictitiousFunctionClassFactory2 = NavDestination.Companion.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion, navBackStackEntryState.BuiltInFictitiousFunctionClassFactory);
                        StringBuilder sb = new StringBuilder();
                        sb.append("Restore State failed: destination ");
                        sb.append(BuiltInFictitiousFunctionClassFactory2);
                        sb.append(" cannot be found from the current destination ");
                        sb.append(authRequestContext);
                        throw new IllegalStateException(sb.toString().toString());
                    }
                    ArrayList arrayList2 = arrayList;
                    Context context = this.getErrorConfigVersion;
                    if (this.DatabaseTableConfigUtil == null) {
                        state = Lifecycle.State.CREATED;
                    } else {
                        state = this.GetContactSyncConfig;
                    }
                    arrayList2.add(navBackStackEntryState.PlaceComponentResult(context, KClassImpl$Data$declaredNonStaticMembers$2, state, this.B));
                    authRequestContext = KClassImpl$Data$declaredNonStaticMembers$2;
                }
            }
            ArrayList<List<NavBackStackEntry>> arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (Object obj : arrayList) {
                if (!(((NavBackStackEntry) obj).KClassImpl$Data$declaredNonStaticMembers$2 instanceof NavGraph)) {
                    arrayList4.add(obj);
                }
            }
            Iterator it = arrayList4.iterator();
            while (true) {
                String str2 = null;
                if (!it.hasNext()) {
                    break;
                }
                NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) it.next();
                List list = (List) CollectionsKt.lastOrNull((List) arrayList3);
                if (list != null && (navBackStackEntry = (NavBackStackEntry) CollectionsKt.last(list)) != null && (navDestination = navBackStackEntry.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
                    str2 = navDestination.lookAheadTest;
                }
                if (Intrinsics.areEqual(str2, navBackStackEntry2.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest)) {
                    list.add(navBackStackEntry2);
                } else {
                    arrayList3.add(CollectionsKt.mutableListOf(navBackStackEntry2));
                }
            }
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            for (List<NavBackStackEntry> list2 : arrayList3) {
                Navigator PlaceComponentResult = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(((NavBackStackEntry) CollectionsKt.first((List) list2)).KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest);
                final Ref.IntRef intRef = new Ref.IntRef();
                this.NetworkUserEntityData$$ExternalSyntheticLambda6 = new Function1<NavBackStackEntry, Unit>() { // from class: androidx.navigation.NavController$restoreStateInternal$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(NavBackStackEntry navBackStackEntry3) {
                        invoke2(navBackStackEntry3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(NavBackStackEntry navBackStackEntry3) {
                        List<NavBackStackEntry> emptyList;
                        Intrinsics.checkNotNullParameter(navBackStackEntry3, "");
                        Ref.BooleanRef.this.element = true;
                        int indexOf = arrayList.indexOf(navBackStackEntry3);
                        if (indexOf != -1) {
                            int i2 = indexOf + 1;
                            emptyList = arrayList.subList(intRef.element, i2);
                            intRef.element = i2;
                        } else {
                            emptyList = CollectionsKt.emptyList();
                        }
                        this.KClassImpl$Data$declaredNonStaticMembers$2(navBackStackEntry3.KClassImpl$Data$declaredNonStaticMembers$2, bundle, navBackStackEntry3, emptyList);
                    }
                };
                PlaceComponentResult.MyBillsEntityDataFactory(list2, navOptions, null);
                this.NetworkUserEntityData$$ExternalSyntheticLambda6 = null;
            }
            return booleanRef.element;
        }
        return false;
    }

    public void getAuthRequestContext(LifecycleOwner lifecycleOwner) {
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "");
        if (Intrinsics.areEqual(lifecycleOwner, this.DatabaseTableConfigUtil)) {
            return;
        }
        LifecycleOwner lifecycleOwner2 = this.DatabaseTableConfigUtil;
        if (lifecycleOwner2 != null && (lifecycle = lifecycleOwner2.getLifecycle()) != null) {
            lifecycle.KClassImpl$Data$declaredNonStaticMembers$2(this.whenAvailable);
        }
        this.DatabaseTableConfigUtil = lifecycleOwner;
        lifecycleOwner.getLifecycle().BuiltInFictitiousFunctionClassFactory(this.whenAvailable);
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(OnBackPressedDispatcher onBackPressedDispatcher) {
        Intrinsics.checkNotNullParameter(onBackPressedDispatcher, "");
        if (Intrinsics.areEqual(onBackPressedDispatcher, this.VerifyPinStateManager$executeRiskChallenge$2$1)) {
            return;
        }
        LifecycleOwner lifecycleOwner = this.DatabaseTableConfigUtil;
        if (lifecycleOwner == null) {
            throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()".toString());
        }
        this.initRecordTimeStamp.remove();
        this.VerifyPinStateManager$executeRiskChallenge$2$1 = onBackPressedDispatcher;
        onBackPressedDispatcher.PlaceComponentResult(lifecycleOwner, this.initRecordTimeStamp);
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        lifecycle.KClassImpl$Data$declaredNonStaticMembers$2(this.whenAvailable);
        lifecycle.BuiltInFictitiousFunctionClassFactory(this.whenAvailable);
    }

    public void BuiltInFictitiousFunctionClassFactory(boolean z) {
        this.moveToNextValue = z;
        this.initRecordTimeStamp.setEnabled(z && MyBillsEntityDataFactory() > 1);
    }

    public void KClassImpl$Data$declaredNonStaticMembers$2(ViewModelStore viewModelStore) {
        Intrinsics.checkNotNullParameter(viewModelStore, "");
        NavControllerViewModel navControllerViewModel = this.B;
        NavControllerViewModel.Companion companion = NavControllerViewModel.INSTANCE;
        if (Intrinsics.areEqual(navControllerViewModel, NavControllerViewModel.Companion.MyBillsEntityDataFactory(viewModelStore))) {
            return;
        }
        if (!this.PlaceComponentResult.isEmpty()) {
            throw new IllegalStateException("ViewModelStore should be set before setGraph call".toString());
        }
        NavControllerViewModel.Companion companion2 = NavControllerViewModel.INSTANCE;
        this.B = NavControllerViewModel.Companion.MyBillsEntityDataFactory(viewModelStore);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/navigation/NavController$Companion;", "", "", "isLayoutRequested", "Z", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(NavController navController, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(navController, "");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "");
        Intrinsics.checkNotNullParameter(event, "");
        Lifecycle.State targetState = event.getTargetState();
        Intrinsics.checkNotNullExpressionValue(targetState, "");
        navController.GetContactSyncConfig = targetState;
        if (navController.NetworkUserEntityData$$ExternalSyntheticLambda7 != null) {
            Iterator<NavBackStackEntry> it = navController.PlaceComponentResult.iterator();
            while (it.hasNext()) {
                NavBackStackEntry next = it.next();
                Intrinsics.checkNotNullParameter(event, "");
                Lifecycle.State targetState2 = event.getTargetState();
                Intrinsics.checkNotNullExpressionValue(targetState2, "");
                next.BuiltInFictitiousFunctionClassFactory = targetState2;
                next.BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:144:0x0004, code lost:
    
        if ((r0 instanceof androidx.view.FloatingWindow) == false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x000c, code lost:
    
        if (r10.PlaceComponentResult.isEmpty() != false) goto L252;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x001a, code lost:
    
        if ((r10.PlaceComponentResult.last().KClassImpl$Data$declaredNonStaticMembers$2 instanceof androidx.view.FloatingWindow) == false) goto L250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x002c, code lost:
    
        if (MyBillsEntityDataFactory(r10.PlaceComponentResult.last().KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion, true, false) != false) goto L253;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x002e, code lost:
    
        r1 = new kotlin.collections.ArrayDeque();
        r4 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0037, code lost:
    
        if ((r11 instanceof androidx.view.NavGraph) == false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0039, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x003a, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
        r2 = r2.moveToNextValue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x003f, code lost:
    
        if (r2 == null) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0041, code lost:
    
        r5 = r14.listIterator(r14.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x004d, code lost:
    
        if (r5.hasPrevious() == false) goto L258;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x004f, code lost:
    
        r6 = r5.previous();
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x005c, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r6.KClassImpl$Data$declaredNonStaticMembers$2, r2) == false) goto L259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x005f, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0060, code lost:
    
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0062, code lost:
    
        if (r6 != null) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0064, code lost:
    
        r5 = androidx.view.NavBackStackEntry.INSTANCE;
        r5 = r10.getErrorConfigVersion;
        r6 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x006d, code lost:
    
        if (r10.DatabaseTableConfigUtil != null) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x006f, code lost:
    
        r7 = androidx.lifecycle.Lifecycle.State.CREATED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0072, code lost:
    
        r7 = r10.GetContactSyncConfig;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0074, code lost:
    
        r6 = androidx.view.NavBackStackEntry.Companion.KClassImpl$Data$declaredNonStaticMembers$2(r5, r6, r12, r7, r10.B);
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x007c, code lost:
    
        r1.addFirst(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0089, code lost:
    
        if ((!r10.PlaceComponentResult.isEmpty()) == false) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0095, code lost:
    
        if (r10.PlaceComponentResult.last().KClassImpl$Data$declaredNonStaticMembers$2 != r2) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0097, code lost:
    
        BuiltInFictitiousFunctionClassFactory(r10.PlaceComponentResult.last(), false, new kotlin.collections.ArrayDeque<>());
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x00a7, code lost:
    
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x00a9, code lost:
    
        if (r2 == null) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x00ab, code lost:
    
        if (r2 != r11) goto L256;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x00b1, code lost:
    
        if (r1.isEmpty() == false) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x00b3, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x00b5, code lost:
    
        r2 = ((androidx.view.NavBackStackEntry) r1.first()).KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x00bd, code lost:
    
        if (r2 == null) goto L261;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x00c5, code lost:
    
        if (PlaceComponentResult(r2.getErrorConfigVersion) != null) goto L260;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x00c7, code lost:
    
        r2 = r2.moveToNextValue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x00c9, code lost:
    
        if (r2 == null) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x00cb, code lost:
    
        r5 = r14.listIterator(r14.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x00d7, code lost:
    
        if (r5.hasPrevious() == false) goto L266;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x00d9, code lost:
    
        r6 = r5.previous();
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x00e6, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r6.KClassImpl$Data$declaredNonStaticMembers$2, r2) == false) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x00e9, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x00ea, code lost:
    
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x00ec, code lost:
    
        if (r6 != null) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x00ee, code lost:
    
        r5 = androidx.view.NavBackStackEntry.INSTANCE;
        r5 = r10.getErrorConfigVersion;
        r6 = r2;
        r7 = r2.MyBillsEntityDataFactory(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x00fb, code lost:
    
        if (r10.DatabaseTableConfigUtil != null) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x00fd, code lost:
    
        r8 = androidx.lifecycle.Lifecycle.State.CREATED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0100, code lost:
    
        r8 = r10.GetContactSyncConfig;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0102, code lost:
    
        r6 = androidx.view.NavBackStackEntry.Companion.KClassImpl$Data$declaredNonStaticMembers$2(r5, r6, r7, r8, r10.B);
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x010a, code lost:
    
        r1.addFirst(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x010d, code lost:
    
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x0114, code lost:
    
        if (r1.isEmpty() != false) goto L271;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x0116, code lost:
    
        r0 = ((androidx.view.NavBackStackEntry) r1.first()).KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x0124, code lost:
    
        if (r10.PlaceComponentResult.isEmpty() != false) goto L269;
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x0132, code lost:
    
        if ((r10.PlaceComponentResult.last().KClassImpl$Data$declaredNonStaticMembers$2 instanceof androidx.view.NavGraph) == false) goto L268;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x0146, code lost:
    
        if (((androidx.view.NavGraph) r10.PlaceComponentResult.last().KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory(r0.getErrorConfigVersion, false) != null) goto L270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0148, code lost:
    
        BuiltInFictitiousFunctionClassFactory(r10.PlaceComponentResult.last(), false, new kotlin.collections.ArrayDeque<>());
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x0159, code lost:
    
        r0 = r10.PlaceComponentResult.firstOrNull();
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0161, code lost:
    
        if (r0 != null) goto L216;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0163, code lost:
    
        r0 = (androidx.view.NavBackStackEntry) r1.firstOrNull();
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0169, code lost:
    
        if (r0 == null) goto L218;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x016b, code lost:
    
        r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x016e, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x0175, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0, r10.NetworkUserEntityData$$ExternalSyntheticLambda7) != false) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0177, code lost:
    
        r14 = r14.listIterator(r14.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0183, code lost:
    
        if (r14.hasPrevious() == false) goto L272;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0185, code lost:
    
        r0 = r14.previous();
        r2 = r0.KClassImpl$Data$declaredNonStaticMembers$2;
        r3 = r10.NetworkUserEntityData$$ExternalSyntheticLambda7;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0197, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L274;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x0199, code lost:
    
        r4 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x019a, code lost:
    
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x019c, code lost:
    
        if (r4 != null) goto L234;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x019e, code lost:
    
        r14 = androidx.view.NavBackStackEntry.INSTANCE;
        r14 = r10.getErrorConfigVersion;
        r0 = r10.NetworkUserEntityData$$ExternalSyntheticLambda7;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
        r0 = r0;
        r2 = r10.NetworkUserEntityData$$ExternalSyntheticLambda7;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r2);
        r12 = r2.MyBillsEntityDataFactory(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x01b4, code lost:
    
        if (r10.DatabaseTableConfigUtil != null) goto L232;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x01b6, code lost:
    
        r2 = androidx.lifecycle.Lifecycle.State.CREATED;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x01b9, code lost:
    
        r2 = r10.GetContactSyncConfig;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x01bb, code lost:
    
        r4 = androidx.view.NavBackStackEntry.Companion.KClassImpl$Data$declaredNonStaticMembers$2(r14, r0, r12, r2, r10.B);
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x01c3, code lost:
    
        r1.addFirst(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x01c6, code lost:
    
        r12 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x01d1, code lost:
    
        if (r12.hasNext() == false) goto L275;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x01d3, code lost:
    
        r14 = (androidx.view.NavBackStackEntry) r12.next();
        r0 = r10.SubSequence.get(r10.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(r14.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest));
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x01e9, code lost:
    
        if (r0 == null) goto L276;
     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x01eb, code lost:
    
        r0.MyBillsEntityDataFactory(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x01f1, code lost:
    
        r12 = new java.lang.StringBuilder();
        r12.append("NavigatorBackStack for ");
        r12.append(r11.lookAheadTest);
        r12.append(" should already be created");
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0212, code lost:
    
        throw new java.lang.IllegalStateException(r12.toString().toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0213, code lost:
    
        r1 = r1;
        r10.PlaceComponentResult.addAll(r1);
        r10.PlaceComponentResult.add(r13);
        r11 = kotlin.collections.CollectionsKt.plus((java.util.Collection<? extends androidx.view.NavBackStackEntry>) r1, r13).iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x022d, code lost:
    
        if (r11.hasNext() == false) goto L278;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x022f, code lost:
    
        r12 = (androidx.view.NavBackStackEntry) r11.next();
        r13 = r12.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:247:0x0239, code lost:
    
        if (r13 == null) goto L280;
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x023b, code lost:
    
        BuiltInFictitiousFunctionClassFactory(r12, MyBillsEntityDataFactory(r13.getErrorConfigVersion));
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x0245, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(androidx.view.NavDestination r11, android.os.Bundle r12, androidx.view.NavBackStackEntry r13, java.util.List<androidx.view.NavBackStackEntry> r14) {
        /*
            Method dump skipped, instructions count: 582
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.view.NavController.KClassImpl$Data$declaredNonStaticMembers$2(androidx.navigation.NavDestination, android.os.Bundle, androidx.navigation.NavBackStackEntry, java.util.List):void");
    }

    final boolean BuiltInFictitiousFunctionClassFactory() {
        while (!this.PlaceComponentResult.isEmpty() && (this.PlaceComponentResult.last().KClassImpl$Data$declaredNonStaticMembers$2 instanceof NavGraph)) {
            BuiltInFictitiousFunctionClassFactory(this.PlaceComponentResult.last(), false, new ArrayDeque<>());
        }
        NavBackStackEntry lastOrNull = this.PlaceComponentResult.lastOrNull();
        if (lastOrNull != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda5.add(lastOrNull);
        }
        this.readMicros++;
        NetworkUserEntityData$$ExternalSyntheticLambda0();
        int i = this.readMicros - 1;
        this.readMicros = i;
        if (i == 0) {
            List<NavBackStackEntry> mutableList = CollectionsKt.toMutableList((Collection) this.NetworkUserEntityData$$ExternalSyntheticLambda5);
            this.NetworkUserEntityData$$ExternalSyntheticLambda5.clear();
            for (NavBackStackEntry navBackStackEntry : mutableList) {
                Iterator<OnDestinationChangedListener> it = this.newProxyInstance.iterator();
                while (it.hasNext()) {
                    it.next().KClassImpl$Data$declaredNonStaticMembers$2(this, navBackStackEntry.KClassImpl$Data$declaredNonStaticMembers$2, navBackStackEntry.getAuthRequestContext);
                }
                this.PrepareContext.tryEmit(navBackStackEntry);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda3.tryEmit(lookAheadTest());
        }
        return lastOrNull != null;
    }

    private static NavDestination KClassImpl$Data$declaredNonStaticMembers$2(NavDestination navDestination, int i) {
        NavGraph navGraph;
        if (navDestination.getErrorConfigVersion == i) {
            return navDestination;
        }
        if (navDestination instanceof NavGraph) {
            navGraph = (NavGraph) navDestination;
        } else {
            navGraph = navDestination.moveToNextValue;
            Intrinsics.checkNotNull(navGraph);
        }
        return navGraph.MyBillsEntityDataFactory(i, true);
    }

    @JvmName(name = "getDestinationCountOnBackStack")
    final int MyBillsEntityDataFactory() {
        ArrayDeque<NavBackStackEntry> arrayDeque = this.PlaceComponentResult;
        int i = 0;
        if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
            Iterator<NavBackStackEntry> it = arrayDeque.iterator();
            while (it.hasNext()) {
                if ((!(it.next().KClassImpl$Data$declaredNonStaticMembers$2 instanceof NavGraph)) != false && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i;
    }

    public final boolean MyBillsEntityDataFactory(int i, boolean z, final boolean z2) {
        NavDestination navDestination;
        if (this.PlaceComponentResult.isEmpty()) {
            return false;
        }
        ArrayList<Navigator> arrayList = new ArrayList();
        Iterator it = CollectionsKt.reversed(this.PlaceComponentResult).iterator();
        while (true) {
            if (!it.hasNext()) {
                navDestination = null;
                break;
            }
            NavDestination navDestination2 = ((NavBackStackEntry) it.next()).KClassImpl$Data$declaredNonStaticMembers$2;
            Navigator PlaceComponentResult = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(navDestination2.lookAheadTest);
            if (z || navDestination2.getErrorConfigVersion != i) {
                arrayList.add(PlaceComponentResult);
            }
            if (navDestination2.getErrorConfigVersion == i) {
                navDestination = navDestination2;
                break;
            }
        }
        if (navDestination == null) {
            NavDestination.Companion companion = NavDestination.getAuthRequestContext;
            String BuiltInFictitiousFunctionClassFactory2 = NavDestination.Companion.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion, i);
            StringBuilder sb = new StringBuilder();
            sb.append("Ignoring popBackStack to destination ");
            sb.append(BuiltInFictitiousFunctionClassFactory2);
            sb.append(" as it was not found on the current back stack");
            InstrumentInjector.log_i("NavController", sb.toString());
            return false;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final ArrayDeque<NavBackStackEntryState> arrayDeque = new ArrayDeque<>();
        for (Navigator navigator : arrayList) {
            final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
            NavBackStackEntry last = this.PlaceComponentResult.last();
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = new Function1<NavBackStackEntry, Unit>() { // from class: androidx.navigation.NavController$popBackStackInternal$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(NavBackStackEntry navBackStackEntry) {
                    invoke2(navBackStackEntry);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(NavBackStackEntry navBackStackEntry) {
                    Intrinsics.checkNotNullParameter(navBackStackEntry, "");
                    Ref.BooleanRef.this.element = true;
                    booleanRef.element = true;
                    this.BuiltInFictitiousFunctionClassFactory(navBackStackEntry, z2, arrayDeque);
                }
            };
            navigator.getAuthRequestContext(last, z2);
            this.BottomSheetCardBindingView$watcherCardNumberView$1 = null;
            if (!booleanRef2.element) {
                break;
            }
        }
        if (z2) {
            if (!z) {
                for (NavDestination navDestination3 : SequencesKt.takeWhile(SequencesKt.generateSequence(navDestination, new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavController$popBackStackInternal$3
                    @Override // kotlin.jvm.functions.Function1
                    public final NavDestination invoke(NavDestination navDestination4) {
                        Intrinsics.checkNotNullParameter(navDestination4, "");
                        NavGraph navGraph = navDestination4.moveToNextValue;
                        boolean z3 = false;
                        if (navGraph != null && navGraph.PlaceComponentResult == navDestination4.getErrorConfigVersion) {
                            z3 = true;
                        }
                        if (z3) {
                            return navDestination4.moveToNextValue;
                        }
                        return null;
                    }
                }), new Function1<NavDestination, Boolean>() { // from class: androidx.navigation.NavController$popBackStackInternal$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(NavDestination navDestination4) {
                        Map map;
                        Intrinsics.checkNotNullParameter(navDestination4, "");
                        map = NavController.this.MyBillsEntityDataFactory;
                        return Boolean.valueOf(!map.containsKey(Integer.valueOf(navDestination4.getErrorConfigVersion)));
                    }
                })) {
                    Map<Integer, String> map = this.MyBillsEntityDataFactory;
                    int i2 = navDestination3.getErrorConfigVersion;
                    NavBackStackEntryState firstOrNull = arrayDeque.firstOrNull();
                    map.put(Integer.valueOf(i2), firstOrNull != null ? firstOrNull.PlaceComponentResult : null);
                }
            }
            if ((!arrayDeque.isEmpty()) != false) {
                NavBackStackEntryState first = arrayDeque.first();
                Iterator it2 = SequencesKt.takeWhile(SequencesKt.generateSequence(PlaceComponentResult(first.BuiltInFictitiousFunctionClassFactory), new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavController$popBackStackInternal$6
                    @Override // kotlin.jvm.functions.Function1
                    public final NavDestination invoke(NavDestination navDestination4) {
                        Intrinsics.checkNotNullParameter(navDestination4, "");
                        NavGraph navGraph = navDestination4.moveToNextValue;
                        boolean z3 = false;
                        if (navGraph != null && navGraph.PlaceComponentResult == navDestination4.getErrorConfigVersion) {
                            z3 = true;
                        }
                        if (z3) {
                            return navDestination4.moveToNextValue;
                        }
                        return null;
                    }
                }), new Function1<NavDestination, Boolean>() { // from class: androidx.navigation.NavController$popBackStackInternal$7
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(NavDestination navDestination4) {
                        Map map2;
                        Intrinsics.checkNotNullParameter(navDestination4, "");
                        map2 = NavController.this.MyBillsEntityDataFactory;
                        return Boolean.valueOf(!map2.containsKey(Integer.valueOf(navDestination4.getErrorConfigVersion)));
                    }
                }).iterator();
                while (it2.hasNext()) {
                    this.MyBillsEntityDataFactory.put(Integer.valueOf(((NavDestination) it2.next()).getErrorConfigVersion), first.PlaceComponentResult);
                }
                this.getAuthRequestContext.put(first.PlaceComponentResult, arrayDeque);
            }
        }
        this.initRecordTimeStamp.setEnabled(this.moveToNextValue && MyBillsEntityDataFactory() > 1);
        return booleanRef.element;
    }

    public final void BuiltInFictitiousFunctionClassFactory(NavBackStackEntry navBackStackEntry, boolean z, ArrayDeque<NavBackStackEntryState> arrayDeque) {
        NavControllerViewModel navControllerViewModel;
        StateFlow<Set<NavBackStackEntry>> stateFlow;
        Set<NavBackStackEntry> value;
        NavBackStackEntry last = this.PlaceComponentResult.last();
        if (!Intrinsics.areEqual(last, navBackStackEntry)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Attempted to pop ");
            sb.append(navBackStackEntry.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", which is not the top of the back stack (");
            sb.append(last.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(')');
            throw new IllegalStateException(sb.toString().toString());
        }
        this.PlaceComponentResult.removeLast();
        NavControllerNavigatorState navControllerNavigatorState = this.SubSequence.get(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(last.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest));
        boolean z2 = (navControllerNavigatorState != null && (stateFlow = navControllerNavigatorState.getErrorConfigVersion) != null && (value = stateFlow.getValue()) != null && value.contains(last)) || this.C.containsKey(last);
        if (last.getLifecycle().PlaceComponentResult().isAtLeast(Lifecycle.State.CREATED)) {
            if (z) {
                Lifecycle.State state = Lifecycle.State.CREATED;
                Intrinsics.checkNotNullParameter(state, "");
                last.moveToNextValue = state;
                last.BuiltInFictitiousFunctionClassFactory();
                arrayDeque.addFirst(new NavBackStackEntryState(last));
            }
            if (!z2) {
                Lifecycle.State state2 = Lifecycle.State.DESTROYED;
                Intrinsics.checkNotNullParameter(state2, "");
                last.moveToNextValue = state2;
                last.BuiltInFictitiousFunctionClassFactory();
                MyBillsEntityDataFactory(last);
            } else {
                Lifecycle.State state3 = Lifecycle.State.CREATED;
                Intrinsics.checkNotNullParameter(state3, "");
                last.moveToNextValue = state3;
                last.BuiltInFictitiousFunctionClassFactory();
            }
        }
        if (z || z2 || (navControllerViewModel = this.B) == null) {
            return;
        }
        String str = last.getErrorConfigVersion;
        Intrinsics.checkNotNullParameter(str, "");
        ViewModelStore remove = navControllerViewModel.MyBillsEntityDataFactory.remove(str);
        if (remove != null) {
            remove.PlaceComponentResult();
        }
    }

    private final boolean scheduleImpl() {
        NavBackStackEntry lastOrNull = this.PlaceComponentResult.lastOrNull();
        NavDestination navDestination = lastOrNull != null ? lastOrNull.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        Intrinsics.checkNotNull(navDestination);
        int i = navDestination.getErrorConfigVersion;
        for (NavGraph navGraph = navDestination.moveToNextValue; navGraph != null; navGraph = navGraph.moveToNextValue) {
            if (navGraph.PlaceComponentResult != i) {
                Bundle bundle = new Bundle();
                Activity activity = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
                if (activity != null) {
                    Intrinsics.checkNotNull(activity);
                    if (activity.getIntent() != null) {
                        Activity activity2 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
                        Intrinsics.checkNotNull(activity2);
                        if (activity2.getIntent().getData() != null) {
                            Activity activity3 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
                            Intrinsics.checkNotNull(activity3);
                            bundle.putParcelable("android-support-nav:controller:deepLinkIntent", activity3.getIntent());
                            NavGraph navGraph2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
                            Intrinsics.checkNotNull(navGraph2);
                            Activity activity4 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
                            Intrinsics.checkNotNull(activity4);
                            Intent intent = activity4.getIntent();
                            Intrinsics.checkNotNullExpressionValue(intent, "");
                            NavDestination.DeepLinkMatch KClassImpl$Data$declaredNonStaticMembers$2 = navGraph2.KClassImpl$Data$declaredNonStaticMembers$2(new NavDeepLinkRequest(intent));
                            if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                                bundle.putAll(KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext));
                            }
                        }
                    }
                }
                NavDeepLinkBuilder BuiltInFictitiousFunctionClassFactory2 = NavDeepLinkBuilder.BuiltInFictitiousFunctionClassFactory(new NavDeepLinkBuilder(this), navGraph.getErrorConfigVersion);
                BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory = bundle;
                BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.putExtra("android-support-nav:controller:deepLinkExtras", bundle);
                BuiltInFictitiousFunctionClassFactory2.MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory();
                Activity activity5 = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
                if (activity5 != null) {
                    activity5.finish();
                    return true;
                }
                return true;
            }
            i = navGraph.getErrorConfigVersion;
        }
        return false;
    }

    public final NavBackStackEntry MyBillsEntityDataFactory(int i) {
        NavBackStackEntry navBackStackEntry;
        ArrayDeque<NavBackStackEntry> arrayDeque = this.PlaceComponentResult;
        ListIterator<NavBackStackEntry> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            if (navBackStackEntry.KClassImpl$Data$declaredNonStaticMembers$2.getErrorConfigVersion == i) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
        if (navBackStackEntry2 != null) {
            return navBackStackEntry2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No destination with ID ");
        sb.append(i);
        sb.append(" is on the NavController's back stack. The current destination is ");
        NavBackStackEntry lastOrNull = this.PlaceComponentResult.lastOrNull();
        sb.append(lastOrNull != null ? lastOrNull.KClassImpl$Data$declaredNonStaticMembers$2 : null);
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public final NavBackStackEntry BuiltInFictitiousFunctionClassFactory(String str) {
        NavBackStackEntry navBackStackEntry;
        Intrinsics.checkNotNullParameter(str, "");
        ArrayDeque<NavBackStackEntry> arrayDeque = this.PlaceComponentResult;
        ListIterator<NavBackStackEntry> listIterator = arrayDeque.listIterator(arrayDeque.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                navBackStackEntry = null;
                break;
            }
            navBackStackEntry = listIterator.previous();
            if (Intrinsics.areEqual(navBackStackEntry.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl, str)) {
                break;
            }
        }
        NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
        if (navBackStackEntry2 != null) {
            return navBackStackEntry2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No destination with route ");
        sb.append(str);
        sb.append(" is on the NavController's back stack. The current destination is ");
        NavBackStackEntry lastOrNull = this.PlaceComponentResult.lastOrNull();
        sb.append(lastOrNull != null ? lastOrNull.KClassImpl$Data$declaredNonStaticMembers$2 : null);
        throw new IllegalArgumentException(sb.toString().toString());
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, Bundle bundle, NavOptions navOptions) {
        NavGraph navGraph;
        int i2;
        if (this.PlaceComponentResult.isEmpty()) {
            navGraph = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
        } else {
            navGraph = this.PlaceComponentResult.last().KClassImpl$Data$declaredNonStaticMembers$2;
        }
        if (navGraph == null) {
            throw new IllegalStateException("no current navigation node");
        }
        NavAction KClassImpl$Data$declaredNonStaticMembers$2 = navGraph.KClassImpl$Data$declaredNonStaticMembers$2(i);
        Bundle bundle2 = null;
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            if (navOptions == null) {
                navOptions = KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            i2 = KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
            Bundle bundle3 = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
            if (bundle3 != null) {
                bundle2 = new Bundle();
                bundle2.putAll(bundle3);
            }
        } else {
            i2 = i;
        }
        if (bundle != null) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2.putAll(bundle);
        }
        if (i2 == 0 && navOptions != null && navOptions.BuiltInFictitiousFunctionClassFactory != -1) {
            KClassImpl$Data$declaredNonStaticMembers$2(navOptions.BuiltInFictitiousFunctionClassFactory, navOptions.getMoveToNextValue());
            return;
        }
        if (!(i2 != 0)) {
            throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo".toString());
        }
        NavDestination PlaceComponentResult = PlaceComponentResult(i2);
        if (PlaceComponentResult == null) {
            NavDestination.Companion companion = NavDestination.getAuthRequestContext;
            String BuiltInFictitiousFunctionClassFactory2 = NavDestination.Companion.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion, i2);
            if (!(KClassImpl$Data$declaredNonStaticMembers$2 == null)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Navigation destination ");
                sb.append(BuiltInFictitiousFunctionClassFactory2);
                sb.append(" referenced from action ");
                NavDestination.Companion companion2 = NavDestination.getAuthRequestContext;
                sb.append(NavDestination.Companion.BuiltInFictitiousFunctionClassFactory(this.getErrorConfigVersion, i));
                sb.append(" cannot be found from the current destination ");
                sb.append(navGraph);
                throw new IllegalArgumentException(sb.toString().toString());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Navigation action/destination ");
            sb2.append(BuiltInFictitiousFunctionClassFactory2);
            sb2.append(" cannot be found from the current destination ");
            sb2.append(navGraph);
            throw new IllegalArgumentException(sb2.toString());
        }
        KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult, bundle2, navOptions);
    }

    public final boolean moveToNextValue() {
        if (this.PlaceComponentResult.isEmpty()) {
            return false;
        }
        NavBackStackEntry lastOrNull = this.PlaceComponentResult.lastOrNull();
        NavDestination navDestination = lastOrNull != null ? lastOrNull.KClassImpl$Data$declaredNonStaticMembers$2 : null;
        Intrinsics.checkNotNull(navDestination);
        return KClassImpl$Data$declaredNonStaticMembers$2(navDestination.getErrorConfigVersion, true);
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        NavGraph navGraph;
        StateFlow<Set<NavBackStackEntry>> stateFlow;
        Set<NavBackStackEntry> value;
        List<NavBackStackEntry> mutableList = CollectionsKt.toMutableList((Collection) this.PlaceComponentResult);
        if (mutableList.isEmpty()) {
            return;
        }
        NavGraph navGraph2 = ((NavBackStackEntry) CollectionsKt.last(mutableList)).KClassImpl$Data$declaredNonStaticMembers$2;
        if (navGraph2 instanceof FloatingWindow) {
            Iterator it = CollectionsKt.reversed(mutableList).iterator();
            while (it.hasNext()) {
                navGraph = ((NavBackStackEntry) it.next()).KClassImpl$Data$declaredNonStaticMembers$2;
                if (!(navGraph instanceof NavGraph) && !(navGraph instanceof FloatingWindow)) {
                    break;
                }
            }
        }
        navGraph = null;
        HashMap hashMap = new HashMap();
        for (NavBackStackEntry navBackStackEntry : CollectionsKt.reversed(mutableList)) {
            Lifecycle.State state = navBackStackEntry.moveToNextValue;
            NavDestination navDestination = navBackStackEntry.KClassImpl$Data$declaredNonStaticMembers$2;
            if (navGraph2 != null && navDestination.getErrorConfigVersion == navGraph2.getErrorConfigVersion) {
                if (state != Lifecycle.State.RESUMED) {
                    NavControllerNavigatorState navControllerNavigatorState = this.SubSequence.get(this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(navBackStackEntry.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest));
                    if (!Intrinsics.areEqual((navControllerNavigatorState == null || (stateFlow = navControllerNavigatorState.getErrorConfigVersion) == null || (value = stateFlow.getValue()) == null) ? null : Boolean.valueOf(value.contains(navBackStackEntry)), Boolean.TRUE)) {
                        AtomicInteger atomicInteger = this.C.get(navBackStackEntry);
                        if (!(atomicInteger != null && atomicInteger.get() == 0)) {
                            hashMap.put(navBackStackEntry, Lifecycle.State.RESUMED);
                        }
                    }
                    hashMap.put(navBackStackEntry, Lifecycle.State.STARTED);
                }
                navGraph2 = navGraph2.moveToNextValue;
            } else if (navGraph != null && navDestination.getErrorConfigVersion == navGraph.getErrorConfigVersion) {
                if (state == Lifecycle.State.RESUMED) {
                    Lifecycle.State state2 = Lifecycle.State.STARTED;
                    Intrinsics.checkNotNullParameter(state2, "");
                    navBackStackEntry.moveToNextValue = state2;
                    navBackStackEntry.BuiltInFictitiousFunctionClassFactory();
                } else if (state != Lifecycle.State.STARTED) {
                    hashMap.put(navBackStackEntry, Lifecycle.State.STARTED);
                }
                navGraph = navGraph.moveToNextValue;
            } else {
                Lifecycle.State state3 = Lifecycle.State.CREATED;
                Intrinsics.checkNotNullParameter(state3, "");
                navBackStackEntry.moveToNextValue = state3;
                navBackStackEntry.BuiltInFictitiousFunctionClassFactory();
            }
        }
        for (NavBackStackEntry navBackStackEntry2 : mutableList) {
            Lifecycle.State state4 = (Lifecycle.State) hashMap.get(navBackStackEntry2);
            if (state4 != null) {
                Intrinsics.checkNotNullParameter(state4, "");
                navBackStackEntry2.moveToNextValue = state4;
                navBackStackEntry2.BuiltInFictitiousFunctionClassFactory();
            } else {
                navBackStackEntry2.BuiltInFictitiousFunctionClassFactory();
            }
        }
    }
}
