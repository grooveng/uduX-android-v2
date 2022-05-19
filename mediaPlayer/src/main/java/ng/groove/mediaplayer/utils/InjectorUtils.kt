/*
 * Copyright 2018 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ng.groove.mediaplayer.utils

import android.app.Application
import android.content.ComponentName
import android.content.Context
import ng.groove.mediaplayer.MediaPlayerMainViewModel
import ng.groove.mediaplayer.SongViewModel
import ng.groove.mediaplayer.exoplayer.MusicService
import ng.groove.mediaplayer.exoplayer.MusicServiceConnection

/**
 * Static methods used to inject classes needed for various Activities and Fragments.
 */
object InjectorUtils {

    lateinit var applicationContextField: Context
    private fun provideMusicServiceConnection(context: Context): MusicServiceConnection {
        return MusicServiceConnection.getInstance(
            context,
            ComponentName(context, MusicService::class.java)
        )
    }

    fun provideMainActivityViewModel(context: Context): MediaPlayerMainViewModel.Factory {
        applicationContextField = context.applicationContext
        val applicationContext = context.applicationContext
        val musicServiceConnection = provideMusicServiceConnection(applicationContext)
        return MediaPlayerMainViewModel.Factory(musicServiceConnection)
    }

    fun provideSongViewModel(context: Context, )
            : SongViewModel.Factory {
        applicationContextField = context.applicationContext
        val applicationContext = context.applicationContext
        val musicServiceConnection = provideMusicServiceConnection(applicationContext)
        return SongViewModel.Factory( musicServiceConnection)
    }
    fun provideContext():Context{
        return applicationContextField
    }


}