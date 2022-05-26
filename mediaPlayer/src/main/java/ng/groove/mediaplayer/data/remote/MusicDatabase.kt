package ng.groove.mediaplayer.data.remote

import ng.groove.mediaplayer.data.entities.Song

class MusicDatabase {

    //Replace this with source of music data
// dummy data manually populated
    fun getAllSongs(): List<Song> {
        return mutableListOf(
            Song(
                mediaId = "xEA1mOVbVHd2CpBEfNrW",
                title = "Mi Historia Entre Tus Dedos",
                subtitle = "Christian Jean",
                songUrl = "https://umedia.udux.com/hls/182uyhhjfkedkdki2u192w993/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MDk5NDU4OTcsImlwIjoiMTI5LjE4LjE3OC4zOCIsInJvbGUiOiIzV1lKYUlzUjRxaWg5eXd3MlB5UiIsInRyYWNrX2lkIjoieEVBMW1PVmJWSGQyQ3BCRWZOclciLCJkZXZpY2UiOiJpb3MiLCJjb3VudHJ5IjoiTkciLCJpYXQiOjE2MDk5NDIyOTd9.EvT1rwat-Uopk28xM_zl2PgaT7kzCbeUz1-AuwB7XwM/xEA1mOVbVHd2CpBEfNrW_trd_preview.mp4/index.m3u8?ut=st=1609942178~exp=1609945778~acl=/hls/182uyhhjfkedkdki2u192w993/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2MDk5NDU4OTcsImlwIjoiMTI5LjE4LjE3OC4zOCIsInJvbGUiOiIzV1lKYUlzUjRxaWg5eXd3MlB5UiIsInRyYWNrX2lkIjoieEVBMW1PVmJWSGQyQ3BCRWZOclciLCJkZXZpY2UiOiJpb3MiLCJjb3VudHJ5IjoiTkciLCJpYXQiOjE2MDk5NDIyOTd9.EvT1rwat-Uopk28xM_zl2PgaT7kzCbeUz1-AuwB7XwM/xEA1mOVbVHd2CpBEfNrW_trd_preview.mp4/*~hmac=f54c023c761923caa683217f7e02196406c3577de6c4a0c3747d378bccfaf202",
                imageUrl = "https://static.udux.com/c4ea9f94e44555f8ec7a01a0de554d43612f0a95f12e39f19bf82cedfdb8dc7f.jpg"
            ),
            Song(
                mediaId = "0koZTWTtNAcpl4Li2LyL",
                title = "United In Grief",
                subtitle = "Kendrick Lamar",
                songUrl = "https://umedia.udux.com/hls/182uyhhjfkedkdki2u192w993/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTM1NTE2MTksImlwIjoiMTAyLjg5LjMuMTQxIiwicm9sZSI6IjNXWUphSXNSNHFpaDl5d3cyUHlSIiwidHJhY2tfaWQiOiIwa29aVFdUdE5BY3BsNExpMkx5TCIsImRldmljZSI6ImlvcyIsImNvdW50cnkiOiJORyIsImlhdCI6MTY1MzU0ODAxOX0.QuQBUyCzd2kmTr2vdKcXeSjxMb9B-fc9aBCCOHieQR0/0koZTWTtNAcpl4Li2LyL_trd_preview.mp4/index.m3u8?ut=st=1653547900~exp=1653551500~acl=/hls/182uyhhjfkedkdki2u192w993/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTM1NTE2MTksImlwIjoiMTAyLjg5LjMuMTQxIiwicm9sZSI6IjNXWUphSXNSNHFpaDl5d3cyUHlSIiwidHJhY2tfaWQiOiIwa29aVFdUdE5BY3BsNExpMkx5TCIsImRldmljZSI6ImlvcyIsImNvdW50cnkiOiJORyIsImlhdCI6MTY1MzU0ODAxOX0.QuQBUyCzd2kmTr2vdKcXeSjxMb9B-fc9aBCCOHieQR0/0koZTWTtNAcpl4Li2LyL_trd_preview.mp4/*~hmac=57cd6dcc43905159ac2b8af27266b66658fd2204a3b3b47bb5314ab22244a46a",
                imageUrl = "https://static.udux.com/90f13b3cd6a055e0ada8c22579a1be57bdb6ad54bf89e31d8dbe10092594fd11.jpg"
            ),
            Song(
                mediaId = "KN4HhPqtyvnEw8IKyI2c",
                title = "N95",
                subtitle = "Kendrick Lamar",
                songUrl = "https://umedia.udux.com/hls/182uyhhjfkedkdki2u192w993/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTM1NTE2MTksImlwIjoiMTAyLjg5LjMuMTQxIiwicm9sZSI6IjNXWUphSXNSNHFpaDl5d3cyUHlSIiwidHJhY2tfaWQiOiJLTjRIaFBxdHl2bkV3OElLeUkyYyIsImRldmljZSI6ImlvcyIsImNvdW50cnkiOiJORyIsImlhdCI6MTY1MzU0ODAxOX0.gRokq5Cxh1gQly-DDjyTiGtsDpHomEPHrm_wh93dyn8/KN4HhPqtyvnEw8IKyI2c_trd_preview.mp4/index.m3u8?ut=st=1653547900~exp=1653551500~acl=/hls/182uyhhjfkedkdki2u192w993/eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NTM1NTE2MTksImlwIjoiMTAyLjg5LjMuMTQxIiwicm9sZSI6IjNXWUphSXNSNHFpaDl5d3cyUHlSIiwidHJhY2tfaWQiOiJLTjRIaFBxdHl2bkV3OElLeUkyYyIsImRldmljZSI6ImlvcyIsImNvdW50cnkiOiJORyIsImlhdCI6MTY1MzU0ODAxOX0.gRokq5Cxh1gQly-DDjyTiGtsDpHomEPHrm_wh93dyn8/KN4HhPqtyvnEw8IKyI2c_trd_preview.mp4/*~hmac=6cda5a82d99cf9b03c8ccbb552f0e7688c4e5ee54a6bb049784e65dcbee43386",
                imageUrl = "https://static.udux.com/90f13b3cd6a055e0ada8c22579a1be57bdb6ad54bf89e31d8dbe10092594fd11.jpg"
            ),
        )
    }
}