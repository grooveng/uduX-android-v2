package ng.groove.mediaplayer.di
//
//import ng.groove.mediaplayer.MediaPlayerMainViewModel
//import ng.groove.mediaplayer.SongViewModel
//import ng.groove.mediaplayer.adapters.SongAdapter
//import ng.groove.mediaplayer.adapters.SwipeSongAdapter
//import ng.groove.mediaplayer.exoplayer.MusicServiceConnection
//import ng.groove.mediaplayer.exoplayer.MusicSource
//import org.koin.android.ext.koin.androidApplication
//import org.koin.androidx.viewmodel.dsl.viewModel
//import org.koin.dsl.module
//
//val appModule = module {
//    single { MusicServiceConnection(context = androidApplication().applicationContext) }
//    single { SwipeSongAdapter() }
//    single { SongAdapter(get()) }
//    single { MusicSource(get())}
//    viewModel { SongViewModel(get()) }
//    viewModel { MediaPlayerMainViewModel(get()) }
//}