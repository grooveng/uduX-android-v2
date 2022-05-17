package ng.groove.mediaplayer.di
//
//import android.content.Context
//import com.bumptech.glide.Glide
//import com.bumptech.glide.load.engine.DiskCacheStrategy
//import com.bumptech.glide.request.RequestOptions
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ApplicationComponent
//import dagger.hilt.android.qualifiers.ApplicationContext
//import ng.groove.mediaplayer.R
//import ng.groove.mediaplayer.adapters.SwipeSongAdapter
//import ng.groove.mediaplayer.exoplayer.MusicServiceConnection
//import javax.inject.Singleton
//
//@Module
//@InstallIn(ApplicationComponent::class)
//object AppModuleHilt {
//
//    @Singleton
//    @Provides
//    fun provideMusicServiceConnection(
//        @ApplicationContext context: Context
//    ) = MusicServiceConnection(context)
//
////    Singleton instance to be used for later feature of swiping songs to switch songs
//    @Singleton
//    @Provides
//    fun provideSwipeSongAdapter() = SwipeSongAdapter()
//
//    @Singleton
//    @Provides
//    fun provideGlideInstance(
//        @ApplicationContext context: Context
//    ) = Glide.with(context).setDefaultRequestOptions(
//        RequestOptions()
//            .placeholder(R.drawable.icon_loading_temp)
//            .error(R.drawable.icon_error_temp)
//            .diskCacheStrategy(DiskCacheStrategy.DATA)
//    )
//}