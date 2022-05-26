package ng.groove.mediaplayer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ng.groove.mediaplayer.R
import ng.groove.mediaplayer.data.entities.Song

abstract class BaseSongAdapter(
    private val layoutId: Int
) : RecyclerView.Adapter<BaseSongAdapter.SongViewHolder>() {
//add data binding to module so Baseadapter can be dynamic
    class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var textViewTitle: TextView = itemView.findViewById(R.id.textViewTrackTitle)
   var textViewArtist: TextView = itemView.findViewById(R.id.textViewArtist)
    var imageViewTrackCover: ImageView = itemView.findViewById(R.id.imageViewTrackCover)
    }

    protected val diffCallback = object : DiffUtil.ItemCallback<Song>() {
        override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
            return oldItem.mediaId == newItem.mediaId
        }

        override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    protected abstract val differ: AsyncListDiffer<Song>

    var songs: List<Song>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            layoutId,
            parent,
            false
        )
        view.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        return SongViewHolder(
            view
        )
    }

    protected var onItemClickListener: ((Song) -> Unit)? = null

    fun setItemClickListener(listener: (Song) -> Unit) {
        onItemClickListener = listener
    }

    override fun getItemCount(): Int {
        return songs.size
    }
}
