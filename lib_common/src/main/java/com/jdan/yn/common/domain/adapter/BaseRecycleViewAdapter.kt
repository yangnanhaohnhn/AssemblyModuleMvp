package com.jdan.yn.common.domain.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.jdan.yn.common.listener.OnItemClickListener
import com.jdan.yn.common.listener.OnLongClickListener

/**
 * Created by Cxx on 2018/3/26.
 */
abstract class BaseRecycleViewAdapter<D, H : RecyclerView.ViewHolder>(private val mContext: Context, private var mLists: ArrayList<D>) : RecyclerView.Adapter<H>(), View.OnClickListener, View.OnLongClickListener {
    private val inflater: LayoutInflater
    private var mOnItemClickListener: OnItemClickListener? = null
    private var mOnLongClickListener: OnLongClickListener? = null

    init {
        inflater = LayoutInflater.from(mContext)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.mOnItemClickListener = listener
    }

    fun setOnLongClickListener(listener: OnLongClickListener) {
        this.mOnLongClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): H {
        val convertView = inflater.inflate(getLayoutId(viewType), parent, false)
        convertView.setOnClickListener(this)
        convertView.setOnLongClickListener(this)
        return convert(convertView, viewType)
    }

    override fun getItemCount(): Int {
        return mLists.size
    }

    override fun onBindViewHolder(holder: H, position: Int) {
        //将position保存在itemView的tag中
        holder.itemView.tag = position
        bindView(holder, mLists, position)
    }

    protected abstract fun bindView(holder: H, mLists: java.util.ArrayList<D>, position: Int)

    protected abstract fun convert(convertView: View, viewType: Int): H

    protected abstract fun getLayoutId(viewType: Int): Int


    override fun onClick(v: View) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener!!.onItemClick(v,v.tag as Int)
        }
    }

    override fun onLongClick(v: View): Boolean {
        if (mOnLongClickListener != null) {
            mOnLongClickListener!!.onItemLongClick(v, v.tag as Int)
        }
        return true
    }

    fun setText(view: View, textStr: String) {
        if (view is TextView) {
            view.text = textStr
        } else if (view is Button) {
            view.text = textStr
        } else if (view is EditText) {
            view.setText(textStr)
        }
    }

    fun setText(view:View,textId:Int){
        setText(view,mContext.getString(textId))
    }

    val activityContext : Context
        get() = mContext

    /**
     * 是否隐藏,显示
     *
     * @param view
     * @param hide
     */
    fun isHide(view: View, hide: Boolean) {
        if (hide)
            view.visibility = View.GONE
        else
            view.visibility = View.VISIBLE
    }

    fun clear() {
        mLists.clear()
        notifyDataSetChanged()
    }

    val data : ArrayList<D>
        get() = mLists
}