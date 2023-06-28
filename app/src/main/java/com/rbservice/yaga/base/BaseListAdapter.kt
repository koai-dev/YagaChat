package com.rbservice.yaga.base

import android.annotation.SuppressLint
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class TComparator<T : Any> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean = oldItem == newItem

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean = oldItem == newItem

}

abstract class BaseListAdapter<T : Any> : ListAdapter<T, BaseListAdapter.VH>(TComparator<T>()) {
    private var mLastClickTime: Long = 0

    class VH(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)

    var listener: BaseAction<T>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                getLayoutId(viewType),
                parent,
                false
            )
        )
    }

    abstract fun getLayoutId(viewType: Int): Int

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.binding.root.setOnClickListener {
            kotlin.run {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return@setOnClickListener
                }
                mLastClickTime = SystemClock.elapsedRealtime()
                listener?.click(position, getItem(position))
            }
        }
    }

    interface BaseAction<T> {
        fun click(position: Int, data: T, code: Int = 1)
    }
}