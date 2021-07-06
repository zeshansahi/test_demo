package dev.zeshan.demoapp.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T, L : BaseRecyclerListener?> : RecyclerView.ViewHolder {
    private var listener: L? = null

    constructor(itemView: View?) : super(itemView!!) {}
    constructor(itemView: View, listener: L) : super(itemView) {
        this.listener = listener
    }

    /**
     * Bind data to the item and set listener if needed.
     *
     * @param item     object, associated with the item.
     * @param listener listener a listener [BaseRecyclerListener] which has to b set at the item (if not `null`).
     */
    abstract fun onBind(item: T, listener: L?)
}
