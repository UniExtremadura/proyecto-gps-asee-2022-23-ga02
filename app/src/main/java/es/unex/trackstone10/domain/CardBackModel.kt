package es.unex.trackstone10.domain

import es.unex.trackstone10.API.CardBackResponse
import es.unex.trackstone10.roomdb.Entity.CardBackEntity
import java.io.Serializable

data class CardBackModel(
    var id: Int? = null,
    var name: String? = null,
    var image: String? = null,
    var slug: String? = null,
) : Serializable

fun CardBackResponse.toCardBackModel() = CardBackModel(id, name, image, slug)
fun CardBackModel.toCardBackResponse() = CardBackResponse(id, 0, "", name, image, slug)
fun CardBackEntity.toCardBackModel() = CardBackModel(id, name, url, "")
fun CardBackModel.toCardBackEntity(userId: Int) = CardBackEntity(name, image, userId)