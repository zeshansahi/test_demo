package dev.zeshan.demoapp.base

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import java.util.*

abstract class GenericRecyclerAdapter<T, L : BaseRecyclerListener?, VH : BaseViewHolder<T, L>?>(
    context: Context?
) :
    RecyclerView.Adapter<VH>() {
    private val items: MutableList<T>?
    var listener: L? = null
        private set
    private val layoutInflater: LayoutInflater
    var position = 0
        private set

    /**
     * To be implemented in as specific adapter
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the itemView to reflect the item at the given
     * position.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items!![position]
        holder?.onBind(item, listener)
        this.position = position
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    /**
     * Sets items to the adapter and notifies that data set has been changed.
     *
     * @param items items to set to the adapter
     * @throws IllegalArgumentException in case of setting `null` items
     */
    fun setItems(items: List<T>?) {
        var items = items
        if (items == null) {
//            throw new IllegalArgumentException("Cannot set `null` item to the Recycler adapter");
            items = ArrayList()
        }
        this.items!!.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    /**
     * Returns all items from the data set held by the adapter.
     *
     * @return All of items in this adapter.
     */
    fun getItems(): List<T>? {
        return items
    }

    /**
     * Returns an items from the data set at a certain position.
     *
     * @return All of items in this adapter.
     */
    fun getItem(position: Int): T {
        return items!![position]
    }

    /**
     * Adds item to the end of the data set.
     * Notifies that item has been inserted.
     *
     * @param item item which has to be added to the adapter.
     */
    fun add(item: T?) {
        requireNotNull(item) { "Cannot add null item to the Recycler adapter" }
        items!!.add(item)
        notifyItemInserted(items.size - 1)
    }

    /**
     * Adds list of items to the end of the adapter's data set.
     * Notifies that item has been inserted.
     *
     * @param items items which has to be added to the adapter.
     */
    fun addAll(items: List<T>?) {
        requireNotNull(items) { "Cannot add `null` items to the Recycler adapter" }
        this.items!!.addAll(items)
        notifyItemRangeInserted(this.items.size - items.size, items.size)
    }

    /**
     * Clears all the items in the adapter.
     */
    fun clear() {
        items!!.clear()
        notifyDataSetChanged()
    }

    /**
     * Removes an item from the adapter.
     * Notifies that item has been removed.
     *
     * @param item to be removed
     */
    fun remove(item: T) {
        val position = items!!.indexOf(item)
        if (position > -1) {
            items.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    /**
     * Returns whether adapter is empty or not.
     *
     * @return `true` if adapter is empty or `false` otherwise
     */
    val isEmpty: Boolean
        get() = itemCount == 0

    /**
     * Indicates whether each item in the data set can be represented with a unique identifier
     * of type [Long].
     *
     * @param hasStableIds Whether items in data set have unique identifiers or not.
     * @see .hasStableIds
     * @see .getItemId
     */
    override fun setHasStableIds(hasStableIds: Boolean) {
        super.setHasStableIds(hasStableIds)
    }

    /**
     * Set click listener, which must extend [BaseRecyclerListener]
     *
     * @param listener click listener
     */
    fun setListener(listener: L) {
        this.listener = listener
    }
    /**
     * Inflates a view.
     *
     * @param layout       layout to me inflater
     * @param parent       container where to inflate
     * @param attachToRoot whether to attach to root or not
     * @return inflated View
     */
    /**
     * Inflates a view.
     *
     * @param layout layout to me inflater
     * @param parent container where to inflate
     * @return inflated View
     */
    protected fun inflate(
        @LayoutRes layout: Int,
        parent: ViewGroup?,
        attachToRoot: Boolean = false
    ): View {
        return layoutInflater.inflate(layout, parent, attachToRoot)
    }

    /**
     * Base constructor.
     * Allocate adapter-related objects here if needed.
     *
     * @param context Context needed to retrieve LayoutInflater
     */
    init {
        layoutInflater = LayoutInflater.from(context)
        items = ArrayList()
    }
}