package id.dana.danapoly.ui.sound;

import android.content.Context;
import android.media.MediaPlayer;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/danapoly/ui/sound/DanapolyAudioPlayer;", "Lid/dana/danapoly/ui/sound/AudioPlayer;", "Landroid/content/Context;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;)V", "()V", "PlaceComponentResult", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Landroid/media/MediaPlayer;", "getAuthRequestContext", "Landroid/media/MediaPlayer;", "Lid/dana/danapoly/ui/sound/DanapolyAudioModel;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/danapoly/ui/sound/DanapolyAudioModel;", "<init>", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyAudioPlayer implements AudioPlayer {
    DanapolyAudioModel BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Context MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public MediaPlayer KClassImpl$Data$declaredNonStaticMembers$2;

    public DanapolyAudioPlayer(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.MyBillsEntityDataFactory = context;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
        DanapolyAudioModel danapolyAudioModel = this.BuiltInFictitiousFunctionClassFactory;
        DanapolyAudioModel danapolyAudioModel2 = null;
        if (danapolyAudioModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danapolyAudioModel = null;
        }
        MediaPlayer create = MediaPlayer.create(p0, danapolyAudioModel.getAuthRequestContext);
        DanapolyAudioModel danapolyAudioModel3 = this.BuiltInFictitiousFunctionClassFactory;
        if (danapolyAudioModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danapolyAudioModel3 = null;
        }
        float f = danapolyAudioModel3.KClassImpl$Data$declaredNonStaticMembers$2;
        DanapolyAudioModel danapolyAudioModel4 = this.BuiltInFictitiousFunctionClassFactory;
        if (danapolyAudioModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danapolyAudioModel4 = null;
        }
        create.setVolume(f, danapolyAudioModel4.KClassImpl$Data$declaredNonStaticMembers$2);
        DanapolyAudioModel danapolyAudioModel5 = this.BuiltInFictitiousFunctionClassFactory;
        if (danapolyAudioModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            danapolyAudioModel2 = danapolyAudioModel5;
        }
        create.setLooping(danapolyAudioModel2.getPlaceComponentResult());
        this.KClassImpl$Data$declaredNonStaticMembers$2 = create;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory);
        }
        MediaPlayer mediaPlayer = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        MediaPlayer mediaPlayer2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (mediaPlayer2 != null) {
            mediaPlayer2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: id.dana.danapoly.ui.sound.DanapolyAudioPlayer$$ExternalSyntheticLambda0
                @Override // android.media.MediaPlayer.OnCompletionListener
                public final void onCompletion(MediaPlayer mediaPlayer3) {
                    DanapolyAudioPlayer.MyBillsEntityDataFactory(DanapolyAudioPlayer.this, mediaPlayer3);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u001c\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b@BX\u0086\n¢\u0006\u0006\n\u0004\b\u0007\u0010\nR4\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f@BX\u0086\n¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R4\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f@BX\u0086\n¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0013\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\u0015@BX\u0086\n¢\u0006\u0006\n\u0004\b\u000b\u0010\u0016"}, d2 = {"Lid/dana/danapoly/ui/sound/DanapolyAudioPlayer$Builder;", "", "Lid/dana/danapoly/ui/sound/DanapolyAudioPlayer;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lid/dana/danapoly/ui/sound/DanapolyAudioPlayer;", "Landroid/content/Context;", "Landroid/content/Context;", "PlaceComponentResult", "", "p0", "Z", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Function1;", "Landroid/media/MediaPlayer;", "", "getAuthRequestContext", "Lkotlin/jvm/functions/Function1;", "MyBillsEntityDataFactory", "", "lookAheadTest", "I", "", LogConstants.RESULT_FALSE, "p1", "<init>", "(Landroid/content/Context;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public float lookAheadTest;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        private final Context PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public Function1<? super MediaPlayer, Unit> getAuthRequestContext;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public boolean BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public Function1<? super MediaPlayer, Unit> MyBillsEntityDataFactory;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        private final int KClassImpl$Data$declaredNonStaticMembers$2;

        public Builder(Context context, int i) {
            Intrinsics.checkNotNullParameter(context, "");
            this.PlaceComponentResult = context;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i;
            this.lookAheadTest = 1.0f;
            this.getAuthRequestContext = new Function1<MediaPlayer, Unit>() { // from class: id.dana.danapoly.ui.sound.DanapolyAudioPlayer$Builder$onPreparedListener$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(MediaPlayer mediaPlayer) {
                    Intrinsics.checkNotNullParameter(mediaPlayer, "");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(MediaPlayer mediaPlayer) {
                    invoke2(mediaPlayer);
                    return Unit.INSTANCE;
                }
            };
            this.MyBillsEntityDataFactory = new Function1<MediaPlayer, Unit>() { // from class: id.dana.danapoly.ui.sound.DanapolyAudioPlayer$Builder$onPlaybackCompleteListener$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(MediaPlayer mediaPlayer) {
                    Intrinsics.checkNotNullParameter(mediaPlayer, "");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(MediaPlayer mediaPlayer) {
                    invoke2(mediaPlayer);
                    return Unit.INSTANCE;
                }
            };
        }

        public final DanapolyAudioPlayer KClassImpl$Data$declaredNonStaticMembers$2() {
            DanapolyAudioPlayer danapolyAudioPlayer = new DanapolyAudioPlayer(this.PlaceComponentResult);
            DanapolyAudioModel danapolyAudioModel = new DanapolyAudioModel(this.KClassImpl$Data$declaredNonStaticMembers$2, this.lookAheadTest, this.BuiltInFictitiousFunctionClassFactory, this.getAuthRequestContext, this.MyBillsEntityDataFactory);
            Intrinsics.checkNotNullParameter(danapolyAudioModel, "");
            danapolyAudioPlayer.BuiltInFictitiousFunctionClassFactory = danapolyAudioModel;
            return danapolyAudioPlayer;
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(DanapolyAudioPlayer danapolyAudioPlayer, MediaPlayer mediaPlayer) {
        Intrinsics.checkNotNullParameter(danapolyAudioPlayer, "");
        DanapolyAudioModel danapolyAudioModel = danapolyAudioPlayer.BuiltInFictitiousFunctionClassFactory;
        if (danapolyAudioModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            danapolyAudioModel = null;
        }
        Function1<? super MediaPlayer, Unit> function1 = danapolyAudioModel.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(mediaPlayer, "");
        function1.invoke(mediaPlayer);
    }
}
