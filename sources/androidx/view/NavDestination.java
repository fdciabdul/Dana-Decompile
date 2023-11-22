package androidx.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import androidx.view.NavDeepLink;
import androidx.view.NavigatorProvider;
import androidx.view.common.R;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.messaging.Constants;
import id.dana.domain.social.ExtendInfoUtilKt;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 X2\u00020\u0001:\u0003WXYB\u0017\b\u0016\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00062\u0006\u00103\u001a\u00020\nJ\u000e\u00104\u001a\u0002012\u0006\u00105\u001a\u00020\u0014J\u000e\u00104\u001a\u0002012\u0006\u00106\u001a\u00020\u0006J\u0014\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u000108H\u0007J\u0014\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0000H\u0007J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0012\u0010@\u001a\u0004\u0018\u00010\r2\b\b\u0001\u0010\u0018\u001a\u00020\u0019J\u0010\u0010A\u001a\u00020>2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010A\u001a\u00020>2\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020\u0019H\u0016J\u0012\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020EH\u0017J\u0018\u0010J\u001a\u0002012\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0017J\u0018\u0010O\u001a\u0002012\b\b\u0001\u0010P\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020\rJ\u001a\u0010O\u001a\u0002012\b\b\u0001\u0010P\u001a\u00020\u00192\b\b\u0001\u0010R\u001a\u00020\u0019J\u0010\u0010S\u001a\u0002012\b\b\u0001\u0010P\u001a\u00020\u0019J\u000e\u0010T\u001a\u0002012\u0006\u00102\u001a\u00020\u0006J\b\u0010U\u001a\u00020>H\u0017J\b\u0010V\u001a\u00020\u0006H\u0016R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00068WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u0018\u001a\u00020\u00198G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R(\u0010(\u001a\u0004\u0018\u00010'2\b\u0010&\u001a\u0004\u0018\u00010'@GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R(\u0010-\u001a\u0004\u0018\u00010\u00062\b\u0010-\u001a\u0004\u0018\u00010\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0007¨\u0006Z"}, d2 = {"Landroidx/navigation/NavDestination;", "", "navigator", "Landroidx/navigation/Navigator;", "(Landroidx/navigation/Navigator;)V", "navigatorName", "", "(Ljava/lang/String;)V", "_arguments", "", "Landroidx/navigation/NavArgument;", "actions", "Landroidx/collection/SparseArrayCompat;", "Landroidx/navigation/NavAction;", "arguments", "", "getArguments", "()Ljava/util/Map;", "deepLinks", "", "Landroidx/navigation/NavDeepLink;", ExtendInfoUtilKt.DISPLAY_NAME_KEY, "getDisplayName", "()Ljava/lang/String;", "id", "", "getId", "()I", "setId", "(I)V", "idName", Constants.ScionAnalytics.PARAM_LABEL, "", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "getNavigatorName", "<set-?>", "Landroidx/navigation/NavGraph;", "parent", "getParent", "()Landroidx/navigation/NavGraph;", "setParent", "(Landroidx/navigation/NavGraph;)V", "route", "getRoute", "setRoute", "addArgument", "", "argumentName", HummerConstants.ARGUMENT, "addDeepLink", "navDeepLink", "uriPattern", "addInDefaultArgs", "Landroid/os/Bundle;", "args", "buildDeepLinkIds", "", "previousDestination", "equals", "", "other", "getAction", "hasDeepLink", "deepLink", "Landroid/net/Uri;", "deepLinkRequest", "Landroidx/navigation/NavDeepLinkRequest;", "hashCode", "matchDeepLink", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "navDeepLinkRequest", "onInflate", HummerConstants.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "putAction", "actionId", "action", "destId", "removeAction", "removeArgument", "supportsActions", "toString", "ClassType", "Companion", "DeepLinkMatch", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public class NavDestination {
    private final List<NavDeepLink> KClassImpl$Data$declaredNonStaticMembers$2;
    final SparseArrayCompat<NavAction> MyBillsEntityDataFactory;
    public CharSequence NetworkUserEntityData$$ExternalSyntheticLambda0;
    Map<String, NavArgument> PlaceComponentResult;
    public int getErrorConfigVersion;
    private String initRecordTimeStamp;
    final String lookAheadTest;
    public NavGraph moveToNextValue;
    String scheduleImpl;
    public static final Companion getAuthRequestContext = new Companion(null);
    private static final Map<String, Class<?>> BuiltInFictitiousFunctionClassFactory = new LinkedHashMap();

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\f\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002R\u0015\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0007¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/navigation/NavDestination$ClassType;", "", "Lkotlin/reflect/KClass;", "value", "()Ljava/lang/Class;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    @Retention(RetentionPolicy.CLASS)
    @kotlin.annotation.Retention(AnnotationRetention.BINARY)
    /* loaded from: classes2.dex */
    public @interface ClassType {
        @JvmName(name = "value")
        Class<?> value();
    }

    public boolean MyBillsEntityDataFactory() {
        return true;
    }

    public NavDestination(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.lookAheadTest = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
        this.MyBillsEntityDataFactory = new SparseArrayCompat<>();
        this.PlaceComponentResult = new LinkedHashMap();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\t\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\rX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Landroidx/navigation/NavDestination$DeepLinkMatch;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/navigation/NavDestination$DeepLinkMatch;)I", "Landroidx/navigation/NavDestination;", "getAuthRequestContext", "Landroidx/navigation/NavDestination;", "BuiltInFictitiousFunctionClassFactory", "", "Z", "PlaceComponentResult", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "MyBillsEntityDataFactory", "I", "p1", "p2", "p3", "p4", "<init>", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;ZZI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DeepLinkMatch implements Comparable<DeepLinkMatch> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final boolean PlaceComponentResult;
        private final boolean KClassImpl$Data$declaredNonStaticMembers$2;
        private final int MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        final Bundle getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        final NavDestination BuiltInFictitiousFunctionClassFactory;

        public DeepLinkMatch(NavDestination navDestination, Bundle bundle, boolean z, boolean z2, int i) {
            Intrinsics.checkNotNullParameter(navDestination, "");
            this.BuiltInFictitiousFunctionClassFactory = navDestination;
            this.getAuthRequestContext = bundle;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
            this.PlaceComponentResult = z2;
            this.MyBillsEntityDataFactory = i;
        }

        @Override // java.lang.Comparable
        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: merged with bridge method [inline-methods] */
        public final int compareTo(DeepLinkMatch p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            boolean z = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (!z || p0.KClassImpl$Data$declaredNonStaticMembers$2) {
                if (z || !p0.KClassImpl$Data$declaredNonStaticMembers$2) {
                    Bundle bundle = this.getAuthRequestContext;
                    if (bundle == null || p0.getAuthRequestContext != null) {
                        if (bundle != null || p0.getAuthRequestContext == null) {
                            if (bundle != null) {
                                int size = bundle.size();
                                Bundle bundle2 = p0.getAuthRequestContext;
                                Intrinsics.checkNotNull(bundle2);
                                int size2 = size - bundle2.size();
                                if (size2 > 0) {
                                    return 1;
                                }
                                if (size2 < 0) {
                                    return -1;
                                }
                            }
                            boolean z2 = this.PlaceComponentResult;
                            if (!z2 || p0.PlaceComponentResult) {
                                if (z2 || !p0.PlaceComponentResult) {
                                    return this.MyBillsEntityDataFactory - p0.MyBillsEntityDataFactory;
                                }
                                return -1;
                            }
                            return 1;
                        }
                        return -1;
                    }
                    return 1;
                }
                return -1;
            }
            return 1;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NavDestination(Navigator<? extends NavDestination> navigator) {
        this(NavigatorProvider.Companion.PlaceComponentResult((Class<? extends Navigator<?>>) navigator.getClass()));
        Intrinsics.checkNotNullParameter(navigator, "");
        NavigatorProvider.Companion companion = NavigatorProvider.INSTANCE;
    }

    public void BuiltInFictitiousFunctionClassFactory(Context context, AttributeSet attributeSet) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.NetworkUserEntityData$$ExternalSyntheticLambda6);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "");
        String string = obtainAttributes.getString(R.styleable.readMicros);
        if (string != null) {
            if ((!StringsKt.isBlank(string)) == false) {
                throw new IllegalArgumentException("Cannot have an empty route".toString());
            }
            String MyBillsEntityDataFactory = Companion.MyBillsEntityDataFactory(string);
            this.getErrorConfigVersion = MyBillsEntityDataFactory.hashCode();
            this.initRecordTimeStamp = null;
            Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
            NavDeepLink.Builder builder = new NavDeepLink.Builder();
            Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory, "");
            builder.PlaceComponentResult = MyBillsEntityDataFactory;
            KClassImpl$Data$declaredNonStaticMembers$2(new NavDeepLink(builder.PlaceComponentResult, builder.MyBillsEntityDataFactory, builder.getAuthRequestContext));
        } else {
            this.getErrorConfigVersion = 0;
            this.initRecordTimeStamp = null;
        }
        List<NavDeepLink> list = this.KClassImpl$Data$declaredNonStaticMembers$2;
        List<NavDeepLink> list2 = list;
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((NavDeepLink) obj).NetworkUserEntityData$$ExternalSyntheticLambda2, Companion.MyBillsEntityDataFactory(this.scheduleImpl))) {
                break;
            }
        }
        TypeIntrinsics.asMutableCollection(list2).remove(obj);
        this.scheduleImpl = string;
        if (obtainAttributes.hasValue(R.styleable.FragmentBottomSheetPaymentSettingBinding)) {
            int resourceId = obtainAttributes.getResourceId(R.styleable.FragmentBottomSheetPaymentSettingBinding, 0);
            this.getErrorConfigVersion = resourceId;
            this.initRecordTimeStamp = null;
            this.initRecordTimeStamp = Companion.BuiltInFictitiousFunctionClassFactory(context, resourceId);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = obtainAttributes.getText(R.styleable.getCallingPid);
        Unit unit = Unit.INSTANCE;
        obtainAttributes.recycle();
    }

    @JvmName(name = "getDisplayName")
    public String getAuthRequestContext() {
        String str = this.initRecordTimeStamp;
        return str == null ? String.valueOf(this.getErrorConfigVersion) : str;
    }

    public DeepLinkMatch KClassImpl$Data$declaredNonStaticMembers$2(NavDeepLinkRequest navDeepLinkRequest) {
        int i;
        DeepLinkMatch deepLinkMatch;
        Intrinsics.checkNotNullParameter(navDeepLinkRequest, "");
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
            return null;
        }
        DeepLinkMatch deepLinkMatch2 = null;
        for (NavDeepLink navDeepLink : this.KClassImpl$Data$declaredNonStaticMembers$2) {
            Uri uri = navDeepLinkRequest.PlaceComponentResult;
            Bundle BuiltInFictitiousFunctionClassFactory2 = uri != null ? navDeepLink.BuiltInFictitiousFunctionClassFactory(uri, MapsKt.toMap(this.PlaceComponentResult)) : null;
            String str = navDeepLinkRequest.MyBillsEntityDataFactory;
            boolean z = str != null && Intrinsics.areEqual(str, navDeepLink.PlaceComponentResult);
            String str2 = navDeepLinkRequest.getAuthRequestContext;
            if (str2 != null) {
                Intrinsics.checkNotNullParameter(str2, "");
                if (navDeepLink.scheduleImpl != null) {
                    Pattern pattern = (Pattern) navDeepLink.getErrorConfigVersion.getValue();
                    Intrinsics.checkNotNull(pattern);
                    if (pattern.matcher(str2).matches()) {
                        i = new NavDeepLink.MimeType(navDeepLink.scheduleImpl).compareTo(new NavDeepLink.MimeType(str2));
                        if (BuiltInFictitiousFunctionClassFactory2 == null || z || i >= 0) {
                            deepLinkMatch = new DeepLinkMatch(this, BuiltInFictitiousFunctionClassFactory2, navDeepLink.getKClassImpl$Data$declaredNonStaticMembers$2(), z, i);
                            if (deepLinkMatch2 != null || deepLinkMatch.compareTo(deepLinkMatch2) > 0) {
                                deepLinkMatch2 = deepLinkMatch;
                            }
                        }
                    }
                }
            }
            i = -1;
            if (BuiltInFictitiousFunctionClassFactory2 == null) {
            }
            deepLinkMatch = new DeepLinkMatch(this, BuiltInFictitiousFunctionClassFactory2, navDeepLink.getKClassImpl$Data$declaredNonStaticMembers$2(), z, i);
            if (deepLinkMatch2 != null) {
            }
            deepLinkMatch2 = deepLinkMatch;
        }
        return deepLinkMatch2;
    }

    public final int[] BuiltInFictitiousFunctionClassFactory(NavDestination navDestination) {
        ArrayDeque arrayDeque = new ArrayDeque();
        NavGraph navGraph = this;
        while (true) {
            Intrinsics.checkNotNull(navGraph);
            NavGraph navGraph2 = navGraph.moveToNextValue;
            if ((navDestination != null ? navDestination.moveToNextValue : null) != null) {
                NavGraph navGraph3 = navDestination.moveToNextValue;
                Intrinsics.checkNotNull(navGraph3);
                if (navGraph3.MyBillsEntityDataFactory(navGraph.getErrorConfigVersion, true) == navGraph) {
                    arrayDeque.addFirst(navGraph);
                    break;
                }
            }
            if (navGraph2 == null || navGraph2.PlaceComponentResult != navGraph.getErrorConfigVersion) {
                arrayDeque.addFirst(navGraph);
            }
            if (Intrinsics.areEqual(navGraph2, navDestination) || (navGraph = navGraph2) == null) {
                break;
            }
        }
        List list = CollectionsKt.toList(arrayDeque);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((NavDestination) it.next()).getErrorConfigVersion));
        }
        return CollectionsKt.toIntArray(arrayList);
    }

    public final NavAction KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        NavAction BuiltInFictitiousFunctionClassFactory2 = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory() ? null : this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(i);
        if (BuiltInFictitiousFunctionClassFactory2 == null) {
            NavGraph navGraph = this.moveToNextValue;
            if (navGraph != null) {
                return navGraph.KClassImpl$Data$declaredNonStaticMembers$2(i);
            }
            return null;
        }
        return BuiltInFictitiousFunctionClassFactory2;
    }

    public final Bundle MyBillsEntityDataFactory(Bundle bundle) {
        if (bundle == null) {
            Map<String, NavArgument> map = this.PlaceComponentResult;
            if (map == null || map.isEmpty()) {
                return null;
            }
        }
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, NavArgument> entry : this.PlaceComponentResult.entrySet()) {
            entry.getValue().KClassImpl$Data$declaredNonStaticMembers$2(entry.getKey(), bundle2);
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            for (Map.Entry<String, NavArgument> entry2 : this.PlaceComponentResult.entrySet()) {
                String key = entry2.getKey();
                NavArgument value = entry2.getValue();
                if (!value.getAuthRequestContext(key, bundle2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Wrong argument type for '");
                    sb.append(key);
                    sb.append("' in argument bundle. ");
                    sb.append(value.BuiltInFictitiousFunctionClassFactory.getMyBillsEntityDataFactory());
                    sb.append(" expected.");
                    throw new IllegalArgumentException(sb.toString().toString());
                }
            }
        }
        return bundle2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        String str = this.initRecordTimeStamp;
        if (str == null) {
            sb.append("0x");
            sb.append(Integer.toHexString(this.getErrorConfigVersion));
        } else {
            sb.append(str);
        }
        sb.append(")");
        String str2 = this.scheduleImpl;
        if (!(str2 == null || StringsKt.isBlank(str2))) {
            sb.append(" route=");
            sb.append(this.scheduleImpl);
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            sb.append(" label=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
        }
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x013d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.view.NavDestination.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Set<String> keySet;
        int i = this.getErrorConfigVersion;
        String str = this.scheduleImpl;
        int hashCode = (i * 31) + (str != null ? str.hashCode() : 0);
        for (NavDeepLink navDeepLink : this.KClassImpl$Data$declaredNonStaticMembers$2) {
            String str2 = navDeepLink.NetworkUserEntityData$$ExternalSyntheticLambda2;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            String str3 = navDeepLink.PlaceComponentResult;
            int hashCode3 = str3 != null ? str3.hashCode() : 0;
            String str4 = navDeepLink.scheduleImpl;
            hashCode = (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str4 != null ? str4.hashCode() : 0);
        }
        Iterator MyBillsEntityDataFactory = SparseArrayKt.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory);
        while (MyBillsEntityDataFactory.hasNext()) {
            NavAction navAction = (NavAction) MyBillsEntityDataFactory.next();
            int i2 = navAction.getAuthRequestContext;
            NavOptions navOptions = navAction.KClassImpl$Data$declaredNonStaticMembers$2;
            hashCode = (((hashCode * 31) + i2) * 31) + (navOptions != null ? navOptions.hashCode() : 0);
            Bundle bundle = navAction.BuiltInFictitiousFunctionClassFactory;
            if (bundle != null && (keySet = bundle.keySet()) != null) {
                Intrinsics.checkNotNullExpressionValue(keySet, "");
                for (String str5 : keySet) {
                    Bundle bundle2 = navAction.BuiltInFictitiousFunctionClassFactory;
                    Intrinsics.checkNotNull(bundle2);
                    Object obj = bundle2.get(str5);
                    hashCode = (hashCode * 31) + (obj != null ? obj.hashCode() : 0);
                }
            }
        }
        for (String str6 : MapsKt.toMap(this.PlaceComponentResult).keySet()) {
            int hashCode4 = str6.hashCode();
            Object obj2 = MapsKt.toMap(this.PlaceComponentResult).get(str6);
            hashCode = (((hashCode * 31) + hashCode4) * 31) + (obj2 != null ? obj2.hashCode() : 0);
        }
        return hashCode;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rR\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0010*\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0011"}, d2 = {"Landroidx/navigation/NavDestination$Companion;", "", "", "p0", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Ljava/lang/String;", "Landroid/content/Context;", "", "p1", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;I)Ljava/lang/String;", "", "Ljava/lang/Class;", "Ljava/util/Map;", "getAuthRequestContext", "Landroidx/navigation/NavDestination;", "Lkotlin/sequences/Sequence;", "(Landroidx/navigation/NavDestination;)Lkotlin/sequences/Sequence;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static String BuiltInFictitiousFunctionClassFactory(Context p0, int p1) {
            String valueOf;
            Intrinsics.checkNotNullParameter(p0, "");
            if (p1 <= 16777215) {
                return String.valueOf(p1);
            }
            try {
                valueOf = p0.getResources().getResourceName(p1);
            } catch (Resources.NotFoundException unused) {
                valueOf = String.valueOf(p1);
            }
            Intrinsics.checkNotNullExpressionValue(valueOf, "");
            return valueOf;
        }

        public static String MyBillsEntityDataFactory(String p0) {
            if (p0 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("android-app://androidx.navigation/");
                sb.append(p0);
                return sb.toString();
            }
            return "";
        }

        @JvmName(name = "getAuthRequestContext")
        public static Sequence<NavDestination> getAuthRequestContext(NavDestination navDestination) {
            Intrinsics.checkNotNullParameter(navDestination, "");
            return SequencesKt.generateSequence(navDestination, new Function1<NavDestination, NavDestination>() { // from class: androidx.navigation.NavDestination$Companion$hierarchy$1
                @Override // kotlin.jvm.functions.Function1
                public final NavDestination invoke(NavDestination navDestination2) {
                    Intrinsics.checkNotNullParameter(navDestination2, "");
                    return navDestination2.moveToNextValue;
                }
            });
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(NavDeepLink navDeepLink) {
        Intrinsics.checkNotNullParameter(navDeepLink, "");
        Map map = MapsKt.toMap(this.PlaceComponentResult);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            NavArgument navArgument = (NavArgument) entry.getValue();
            if ((navArgument.getGetAuthRequestContext() || navArgument.getKClassImpl$Data$declaredNonStaticMembers$2()) ? false : true) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Set keySet = linkedHashMap.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : keySet) {
            String str = (String) obj;
            List<String> list = navDeepLink.MyBillsEntityDataFactory;
            Collection<NavDeepLink.ParamQuery> values = navDeepLink.lookAheadTest.values();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it2 = values.iterator();
            while (it2.hasNext()) {
                CollectionsKt.addAll(arrayList2, ((NavDeepLink.ParamQuery) it2.next()).PlaceComponentResult);
            }
            if ((!CollectionsKt.plus((Collection) list, (Iterable) arrayList2).contains(str)) != false) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList;
        if (!arrayList3.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Deep link ");
            sb.append(navDeepLink.NetworkUserEntityData$$ExternalSyntheticLambda2);
            sb.append(" can't be used to open destination ");
            sb.append(this);
            sb.append(".\nFollowing required arguments are missing: ");
            sb.append(arrayList3);
            throw new IllegalArgumentException(sb.toString().toString());
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2.add(navDeepLink);
    }
}
