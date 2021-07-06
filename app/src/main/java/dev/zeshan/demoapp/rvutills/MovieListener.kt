package dev.zeshan.demoapp.rvutills

import dev.zeshan.demoapp.base.BaseRecyclerListener
import dev.zeshan.demoapp.models.DTOMovie

interface MovieListener <T> : BaseRecyclerListener {
    fun onClickToBook(objects: DTOMovie?)
}