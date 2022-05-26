package ng.groove.mediaplayer.adapters

import android.widget.ImageView
import androidx.recyclerview.widget.AsyncListDiffer
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import ng.groove.mediaplayer.R


class SwipeSongAdapter: BaseSongAdapter(R.layout.mini_player) {


    override val differ = AsyncListDiffer(this, diffCallback)


    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = songs[position]
        holder.itemView.apply {
            val text = "${song.title} - ${song.subtitle}"
            holder.textViewTitle.text = text
            holder.textViewArtist.text = song.subtitle
            val image: ImageView = holder.imageViewTrackCover
            Glide.with(context).load(song.imageUrl).into(image)

            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(song)
                }
            }
        }
    }

}
