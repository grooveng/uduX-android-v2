package ng.groove.mediaplayer.data.remote

import ng.groove.mediaplayer.data.entities.Song
import ng.groove.mediaplayer.Constants.SONG_COLLECTION

class MusicDatabase {

    //Replace this with source of music data
//    private val firestore
//    private val songCollection = firestore.collection(SONG_COLLECTION)
//    fun populateList(){
//
//    }

    suspend fun getAllSongs(): List<Song> {
        val playlist: MutableList<Song> = mutableListOf(
            Song(mediaId = "xEA1mOVbVHd2CpBEfNrW",
                title= "Mi Historia Entre Tus Dedos",
                subtitle = "Christian Jean",
                songUrl = "https://umedia.udux.com/hls/182uyhhjfkedkdki2u192w993/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MDk5NDU4OTcsImlwIjoiMTI5LjE4LjE3OC4zOCIsInJvbGUiOiIzV1lKYUlzUjRxaWg5eXd3MlB5UiIsInRyYWNrX2lkIjoieEVBMW1PVmJWSGQyQ3BCRWZOclciLCJkZXZpY2UiOiJpb3MiLCJjb3VudHJ5IjoiTkciLCJpYXQiOjE2MDk5NDIyOTd9.EvT1rwat-Uopk28xM_zl2PgaT7kzCbeUz1-AuwB7XwM/xEA1mOVbVHd2CpBEfNrW_trd_preview.mp4/index.m3u8?ut=st=1609942178~exp=1609945778~acl=/hls/182uyhhjfkedkdki2u192w993/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MDk5NDU4OTcsImlwIjoiMTI5LjE4LjE3OC4zOCIsInJvbGUiOiIzV1lKYUlzUjRxaWg5eXd3MlB5UiIsInRyYWNrX2lkIjoieEVBMW1PVmJWSGQyQ3BCRWZOclciLCJkZXZpY2UiOiJpb3MiLCJjb3VudHJ5IjoiTkciLCJpYXQiOjE2MDk5NDIyOTd9.EvT1rwat-Uopk28xM_zl2PgaT7kzCbeUz1-AuwB7XwM/xEA1mOVbVHd2CpBEfNrW_trd_preview.mp4/*~hmac=f54c023c761923caa683217f7e02196406c3577de6c4a0c3747d378bccfaf202",
                imageUrl = "https://static.udux.com/c4ea9f94e44555f8ec7a01a0de554d43612f0a95f12e39f19bf82cedfdb8dc7f.jpg"),
        )
//        return try {
//            songCollection.get().await().toObjects(Song::class.java)
//        } catch(e: Exception) {
//            emptyList()
//        }
        return playlist
    }
}